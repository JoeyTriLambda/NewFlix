package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.NetworkType;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.d;
import f3.m;
import f3.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import w2.g;
import x2.e;
import x2.v;
import x2.w;

/* compiled from: CommandHandler.java */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: p, reason: collision with root package name */
    public static final String f4539p = g.tagWithPrefix("CommandHandler");

    /* renamed from: b, reason: collision with root package name */
    public final Context f4540b;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f4541m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public final Object f4542n = new Object();

    /* renamed from: o, reason: collision with root package name */
    public final w f4543o;

    public a(Context context, w wVar) {
        this.f4540b = context;
        this.f4543o = wVar;
    }

    public static m c(Intent intent) {
        return new m(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void d(Intent intent, m mVar) {
        intent.putExtra("KEY_WORKSPEC_ID", mVar.getWorkSpecId());
        intent.putExtra("KEY_WORKSPEC_GENERATION", mVar.getGeneration());
    }

    public final boolean a() {
        boolean z10;
        synchronized (this.f4542n) {
            z10 = !this.f4541m.isEmpty();
        }
        return z10;
    }

    public final void b(int i10, Intent intent, d dVar) {
        List<v> listRemove;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            g.get().debug(f4539p, "Handling constraints changed " + intent);
            b bVar = new b(this.f4540b, i10, dVar);
            List<t> scheduledWork = dVar.f4566p.getWorkDatabase().workSpecDao().getScheduledWork();
            String str = ConstraintProxy.f4530a;
            Iterator<t> it = scheduledWork.iterator();
            boolean zRequiresBatteryNotLow = false;
            boolean zRequiresCharging = false;
            boolean zRequiresStorageNotLow = false;
            boolean z10 = false;
            while (it.hasNext()) {
                w2.b bVar2 = it.next().f11435j;
                zRequiresBatteryNotLow |= bVar2.requiresBatteryNotLow();
                zRequiresCharging |= bVar2.requiresCharging();
                zRequiresStorageNotLow |= bVar2.requiresStorageNotLow();
                z10 |= bVar2.getRequiredNetworkType() != NetworkType.NOT_REQUIRED;
                if (zRequiresBatteryNotLow && zRequiresCharging && zRequiresStorageNotLow && z10) {
                    break;
                }
            }
            Context context = bVar.f4545a;
            context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, zRequiresBatteryNotLow, zRequiresCharging, zRequiresStorageNotLow, z10));
            b3.e eVar = bVar.f4547c;
            eVar.replace(scheduledWork);
            ArrayList arrayList = new ArrayList(scheduledWork.size());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (t tVar : scheduledWork) {
                String str2 = tVar.f11426a;
                if (jCurrentTimeMillis >= tVar.calculateNextRunTime() && (!tVar.hasConstraints() || eVar.areAllConstraintsMet(str2))) {
                    arrayList.add(tVar);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                t tVar2 = (t) it2.next();
                String str3 = tVar2.f11426a;
                m mVarGenerationalId = f3.w.generationalId(tVar2);
                Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent2.setAction("ACTION_DELAY_MET");
                d(intent2, mVarGenerationalId);
                g.get().debug(b.f4544d, ac.c.k("Creating a delay_met command for workSpec with id (", str3, ")"));
                ((i3.d) dVar.f4563m).getMainThreadExecutor().execute(new d.b(bVar.f4546b, intent2, dVar));
            }
            eVar.reset();
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            g.get().debug(f4539p, "Handling reschedule " + intent + ", " + i10);
            dVar.f4566p.rescheduleEligibleWork();
            return;
        }
        Bundle extras = intent.getExtras();
        if (!((extras == null || extras.isEmpty() || extras.get(new String[]{"KEY_WORKSPEC_ID"}[0]) == null) ? false : true)) {
            g.get().error(f4539p, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            m mVarC = c(intent);
            String str4 = f4539p;
            g.get().debug(str4, "Handling schedule work for " + mVarC);
            WorkDatabase workDatabase = dVar.f4566p.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                t workSpec = workDatabase.workSpecDao().getWorkSpec(mVarC.getWorkSpecId());
                if (workSpec == null) {
                    g.get().warning(str4, "Skipping scheduling " + mVarC + " because it's no longer in the DB");
                } else if (workSpec.f11427b.isFinished()) {
                    g.get().warning(str4, "Skipping scheduling " + mVarC + "because it is finished.");
                } else {
                    long jCalculateNextRunTime = workSpec.calculateNextRunTime();
                    boolean zHasConstraints = workSpec.hasConstraints();
                    Context context2 = this.f4540b;
                    if (zHasConstraints) {
                        g.get().debug(str4, "Opportunistically setting an alarm for " + mVarC + "at " + jCalculateNextRunTime);
                        z2.a.setAlarm(context2, workDatabase, mVarC, jCalculateNextRunTime);
                        Intent intent3 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                        intent3.setAction("ACTION_CONSTRAINTS_CHANGED");
                        ((i3.d) dVar.f4563m).getMainThreadExecutor().execute(new d.b(i10, intent3, dVar));
                    } else {
                        g.get().debug(str4, "Setting up Alarms for " + mVarC + "at " + jCalculateNextRunTime);
                        z2.a.setAlarm(context2, workDatabase, mVarC, jCalculateNextRunTime);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                return;
            } finally {
                workDatabase.endTransaction();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f4542n) {
                m mVarC2 = c(intent);
                g gVar = g.get();
                String str5 = f4539p;
                gVar.debug(str5, "Handing delay met for " + mVarC2);
                if (this.f4541m.containsKey(mVarC2)) {
                    g.get().debug(str5, "WorkSpec " + mVarC2 + " is is already being handled for ACTION_DELAY_MET");
                } else {
                    c cVar = new c(this.f4540b, i10, dVar, this.f4543o.tokenFor(mVarC2));
                    this.f4541m.put(mVarC2, cVar);
                    cVar.c();
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                g.get().warning(f4539p, "Ignoring intent " + intent);
                return;
            }
            m mVarC3 = c(intent);
            boolean z11 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            g.get().debug(f4539p, "Handling onExecutionCompleted " + intent + ", " + i10);
            onExecuted(mVarC3, z11);
            return;
        }
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        boolean zContainsKey = extras2.containsKey("KEY_WORKSPEC_GENERATION");
        w wVar = this.f4543o;
        if (zContainsKey) {
            int i11 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            v vVarRemove = wVar.remove(new m(string, i11));
            listRemove = arrayList2;
            if (vVarRemove != null) {
                arrayList2.add(vVarRemove);
                listRemove = arrayList2;
            }
        } else {
            listRemove = wVar.remove(string);
        }
        for (v vVar : listRemove) {
            g.get().debug(f4539p, ac.c.j("Handing stopWork work for ", string));
            dVar.f4566p.stopWork(vVar);
            z2.a.cancelAlarm(this.f4540b, dVar.f4566p.getWorkDatabase(), vVar.getId());
            dVar.onExecuted(vVar.getId(), false);
        }
    }

    @Override // x2.e
    public void onExecuted(m mVar, boolean z10) {
        synchronized (this.f4542n) {
            c cVar = (c) this.f4541m.remove(mVar);
            this.f4543o.remove(mVar);
            if (cVar != null) {
                cVar.d(z10);
            }
        }
    }
}
