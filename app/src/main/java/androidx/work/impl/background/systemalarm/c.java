package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.d;
import b3.e;
import d3.n;
import f3.m;
import f3.w;
import g3.p;
import g3.t;
import g3.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import w2.g;
import x2.v;

/* compiled from: DelayMetCommandHandler.java */
/* loaded from: classes.dex */
public final class c implements b3.c, y.a {

    /* renamed from: x, reason: collision with root package name */
    public static final String f4548x = g.tagWithPrefix("DelayMetCommandHandler");

    /* renamed from: b, reason: collision with root package name */
    public final Context f4549b;

    /* renamed from: m, reason: collision with root package name */
    public final int f4550m;

    /* renamed from: n, reason: collision with root package name */
    public final m f4551n;

    /* renamed from: o, reason: collision with root package name */
    public final d f4552o;

    /* renamed from: p, reason: collision with root package name */
    public final e f4553p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f4554q;

    /* renamed from: r, reason: collision with root package name */
    public int f4555r;

    /* renamed from: s, reason: collision with root package name */
    public final i3.a f4556s;

    /* renamed from: t, reason: collision with root package name */
    public final Executor f4557t;

    /* renamed from: u, reason: collision with root package name */
    public PowerManager.WakeLock f4558u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4559v;

    /* renamed from: w, reason: collision with root package name */
    public final v f4560w;

    public c(Context context, int i10, d dVar, v vVar) {
        this.f4549b = context;
        this.f4550m = i10;
        this.f4552o = dVar;
        this.f4551n = vVar.getId();
        this.f4560w = vVar;
        n trackers = dVar.f4566p.getTrackers();
        i3.d dVar2 = (i3.d) dVar.f4563m;
        this.f4556s = dVar2.m31getSerialTaskExecutor();
        this.f4557t = dVar2.getMainThreadExecutor();
        this.f4553p = new e(trackers, this);
        this.f4559v = false;
        this.f4555r = 0;
        this.f4554q = new Object();
    }

    public static void a(c cVar) {
        m mVar = cVar.f4551n;
        String workSpecId = mVar.getWorkSpecId();
        int i10 = cVar.f4555r;
        String str = f4548x;
        if (i10 >= 2) {
            g.get().debug(str, "Already stopped work for " + workSpecId);
            return;
        }
        cVar.f4555r = 2;
        g.get().debug(str, "Stopping work for WorkSpec " + workSpecId);
        String str2 = a.f4539p;
        Context context = cVar.f4549b;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        a.d(intent, mVar);
        int i11 = cVar.f4550m;
        d dVar = cVar.f4552o;
        d.b bVar = new d.b(i11, intent, dVar);
        Executor executor = cVar.f4557t;
        executor.execute(bVar);
        if (!dVar.f4565o.isEnqueued(mVar.getWorkSpecId())) {
            g.get().debug(str, "Processor does not have WorkSpec " + workSpecId + ". No need to reschedule");
            return;
        }
        g.get().debug(str, "WorkSpec " + workSpecId + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        a.d(intent2, mVar);
        executor.execute(new d.b(i11, intent2, dVar));
    }

    public final void b() {
        synchronized (this.f4554q) {
            this.f4553p.reset();
            this.f4552o.f4564n.stopTimer(this.f4551n);
            PowerManager.WakeLock wakeLock = this.f4558u;
            if (wakeLock != null && wakeLock.isHeld()) {
                g.get().debug(f4548x, "Releasing wakelock " + this.f4558u + "for WorkSpec " + this.f4551n);
                this.f4558u.release();
            }
        }
    }

    public final void c() {
        String workSpecId = this.f4551n.getWorkSpecId();
        this.f4558u = t.newWakeLock(this.f4549b, ac.c.m(ac.c.u(workSpecId, " ("), this.f4550m, ")"));
        g gVar = g.get();
        String str = "Acquiring wakelock " + this.f4558u + "for WorkSpec " + workSpecId;
        String str2 = f4548x;
        gVar.debug(str2, str);
        this.f4558u.acquire();
        f3.t workSpec = this.f4552o.f4566p.getWorkDatabase().workSpecDao().getWorkSpec(workSpecId);
        if (workSpec == null) {
            ((p) this.f4556s).execute(new z2.b(this, 2));
            return;
        }
        boolean zHasConstraints = workSpec.hasConstraints();
        this.f4559v = zHasConstraints;
        if (zHasConstraints) {
            this.f4553p.replace(Collections.singletonList(workSpec));
            return;
        }
        g.get().debug(str2, "No constraints for " + workSpecId);
        onAllConstraintsMet(Collections.singletonList(workSpec));
    }

    public final void d(boolean z10) {
        g gVar = g.get();
        StringBuilder sb2 = new StringBuilder("onExecuted ");
        m mVar = this.f4551n;
        sb2.append(mVar);
        sb2.append(", ");
        sb2.append(z10);
        gVar.debug(f4548x, sb2.toString());
        b();
        int i10 = this.f4550m;
        d dVar = this.f4552o;
        Executor executor = this.f4557t;
        Context context = this.f4549b;
        if (z10) {
            String str = a.f4539p;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            a.d(intent, mVar);
            executor.execute(new d.b(i10, intent, dVar));
        }
        if (this.f4559v) {
            String str2 = a.f4539p;
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            executor.execute(new d.b(i10, intent2, dVar));
        }
    }

    @Override // b3.c
    public void onAllConstraintsMet(List<f3.t> list) {
        Iterator<f3.t> it = list.iterator();
        while (it.hasNext()) {
            if (w.generationalId(it.next()).equals(this.f4551n)) {
                ((p) this.f4556s).execute(new z2.b(this, 3));
                return;
            }
        }
    }

    @Override // b3.c
    public void onAllConstraintsNotMet(List<f3.t> list) {
        ((p) this.f4556s).execute(new z2.b(this, 1));
    }

    @Override // g3.y.a
    public void onTimeLimitExceeded(m mVar) {
        g.get().debug(f4548x, "Exceeded time limits on execution for " + mVar);
        ((p) this.f4556s).execute(new z2.b(this, 0));
    }
}
