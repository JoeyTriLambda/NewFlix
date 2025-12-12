package x2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.R;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.utils.ForceStopRunnable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import w2.g;

/* compiled from: WorkManagerImpl.java */
/* loaded from: classes.dex */
public final class e0 extends w2.n {

    /* renamed from: k, reason: collision with root package name */
    public static e0 f21393k;

    /* renamed from: l, reason: collision with root package name */
    public static e0 f21394l;

    /* renamed from: m, reason: collision with root package name */
    public static final Object f21395m;

    /* renamed from: a, reason: collision with root package name */
    public Context f21396a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.work.a f21397b;

    /* renamed from: c, reason: collision with root package name */
    public WorkDatabase f21398c;

    /* renamed from: d, reason: collision with root package name */
    public i3.c f21399d;

    /* renamed from: e, reason: collision with root package name */
    public List<t> f21400e;

    /* renamed from: f, reason: collision with root package name */
    public r f21401f;

    /* renamed from: g, reason: collision with root package name */
    public g3.n f21402g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21403h;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f21404i;

    /* renamed from: j, reason: collision with root package name */
    public final d3.n f21405j;

    /* compiled from: WorkManagerImpl.java */
    public static class a {
        public static boolean a(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static {
        w2.g.tagWithPrefix("WorkManagerImpl");
        f21393k = null;
        f21394l = null;
        f21395m = new Object();
    }

    public e0(Context context, androidx.work.a aVar, i3.c cVar) {
        this(context, aVar, cVar, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    @Deprecated
    public static e0 getInstance() {
        synchronized (f21395m) {
            e0 e0Var = f21393k;
            if (e0Var != null) {
                return e0Var;
            }
            return f21394l;
        }
    }

    public static void initialize(Context context, androidx.work.a aVar) {
        synchronized (f21395m) {
            e0 e0Var = f21393k;
            if (e0Var != null && f21394l != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
            if (e0Var == null) {
                Context applicationContext = context.getApplicationContext();
                if (f21394l == null) {
                    f21394l = new e0(applicationContext, aVar, new i3.d(aVar.getTaskExecutor()));
                }
                f21393k = f21394l;
            }
        }
    }

    public w2.i cancelWorkById(UUID uuid) {
        g3.b bVarForId = g3.b.forId(uuid, this);
        i3.d dVar = (i3.d) this.f21399d;
        dVar.getClass();
        i3.b.a(dVar, bVarForId);
        return bVarForId.getOperation();
    }

    public List<t> createSchedulers(Context context, androidx.work.a aVar, d3.n nVar) {
        t cVar;
        t[] tVarArr = new t[2];
        int i10 = Build.VERSION.SDK_INT;
        String str = u.f21482a;
        if (i10 >= 23) {
            cVar = new a3.d(context, this);
            g3.m.setComponentEnabled(context, SystemJobService.class, true);
            w2.g.get().debug(str, "Created SystemJobScheduler and enabled SystemJobService");
        } else {
            try {
                cVar = (t) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
                w2.g.get().debug(str, "Created androidx.work.impl.background.gcm.GcmScheduler");
            } catch (Throwable th2) {
                w2.g.get().debug(str, "Unable to create GCM Scheduler", th2);
                cVar = null;
            }
            if (cVar == null) {
                cVar = new z2.c(context);
                g3.m.setComponentEnabled(context, SystemAlarmService.class, true);
                w2.g.get().debug(str, "Created SystemAlarmScheduler");
            }
        }
        tVarArr[0] = cVar;
        tVarArr[1] = new y2.b(context, aVar, nVar, this);
        return Arrays.asList(tVarArr);
    }

    public x createWorkContinuationForUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, w2.j jVar) {
        return new x(this, str, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(jVar));
    }

    @Override // w2.n
    public w2.i enqueue(List<? extends w2.o> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new x(this, list).enqueue();
    }

    @Override // w2.n
    public w2.i enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, w2.j jVar) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? WorkerUpdater.enqueueUniquelyNamedPeriodic(this, str, jVar) : createWorkContinuationForUniquePeriodicWork(str, existingPeriodicWorkPolicy, jVar).enqueue();
    }

    public Context getApplicationContext() {
        return this.f21396a;
    }

    public androidx.work.a getConfiguration() {
        return this.f21397b;
    }

    public g3.n getPreferenceUtils() {
        return this.f21402g;
    }

    public r getProcessor() {
        return this.f21401f;
    }

    public List<t> getSchedulers() {
        return this.f21400e;
    }

    public d3.n getTrackers() {
        return this.f21405j;
    }

    public WorkDatabase getWorkDatabase() {
        return this.f21398c;
    }

    public i3.c getWorkTaskExecutor() {
        return this.f21399d;
    }

    public void onForceStopRunnableCompleted() {
        synchronized (f21395m) {
            this.f21403h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f21404i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f21404i = null;
            }
        }
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT >= 23) {
            a3.d.cancelAll(getApplicationContext());
        }
        getWorkDatabase().workSpecDao().resetScheduledState();
        u.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    public void setReschedulePendingResult(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f21395m) {
            this.f21404i = pendingResult;
            if (this.f21403h) {
                pendingResult.finish();
                this.f21404i = null;
            }
        }
    }

    public void startWork(v vVar) {
        startWork(vVar, null);
    }

    public void stopForegroundWork(f3.m mVar) {
        i3.c cVar = this.f21399d;
        g3.r rVar = new g3.r(this, new v(mVar), true);
        i3.d dVar = (i3.d) cVar;
        dVar.getClass();
        i3.b.a(dVar, rVar);
    }

    public void stopWork(v vVar) {
        i3.c cVar = this.f21399d;
        g3.r rVar = new g3.r(this, vVar, false);
        i3.d dVar = (i3.d) cVar;
        dVar.getClass();
        i3.b.a(dVar, rVar);
    }

    public void startWork(v vVar, WorkerParameters.a aVar) {
        i3.c cVar = this.f21399d;
        g3.q qVar = new g3.q(this, vVar, aVar);
        i3.d dVar = (i3.d) cVar;
        dVar.getClass();
        i3.b.a(dVar, qVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e0(Context context, androidx.work.a aVar, i3.c cVar, boolean z10) {
        i3.d dVar = (i3.d) cVar;
        this(context, aVar, dVar, WorkDatabase.create(context.getApplicationContext(), dVar.m31getSerialTaskExecutor(), z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e0 getInstance(Context context) {
        e0 e0Var;
        synchronized (f21395m) {
            e0Var = getInstance();
            if (e0Var == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof a.b) {
                    initialize(applicationContext, ((a.b) applicationContext).getWorkManagerConfiguration());
                    e0Var = getInstance(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return e0Var;
    }

    public e0(Context context, androidx.work.a aVar, i3.c cVar, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        w2.g.setLogger(new g.a(aVar.getMinimumLoggingLevel()));
        d3.n nVar = new d3.n(applicationContext, cVar);
        this.f21405j = nVar;
        List<t> listCreateSchedulers = createSchedulers(applicationContext, aVar, nVar);
        r rVar = new r(context, aVar, cVar, workDatabase, listCreateSchedulers);
        Context applicationContext2 = context.getApplicationContext();
        this.f21396a = applicationContext2;
        this.f21397b = aVar;
        this.f21399d = cVar;
        this.f21398c = workDatabase;
        this.f21400e = listCreateSchedulers;
        this.f21401f = rVar;
        this.f21402g = new g3.n(workDatabase);
        this.f21403h = false;
        if (Build.VERSION.SDK_INT >= 24 && a.a(applicationContext2)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        i3.c cVar2 = this.f21399d;
        ForceStopRunnable forceStopRunnable = new ForceStopRunnable(applicationContext2, this);
        i3.d dVar = (i3.d) cVar2;
        dVar.getClass();
        i3.b.a(dVar, forceStopRunnable);
    }
}
