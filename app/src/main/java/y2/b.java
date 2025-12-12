package y2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo$State;
import b3.c;
import d3.n;
import f3.m;
import g3.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import w2.g;
import x2.e;
import x2.e0;
import x2.t;
import x2.v;
import x2.w;

/* compiled from: GreedyScheduler.java */
/* loaded from: classes.dex */
public final class b implements t, c, e {

    /* renamed from: u, reason: collision with root package name */
    public static final String f21848u = g.tagWithPrefix("GreedyScheduler");

    /* renamed from: b, reason: collision with root package name */
    public final Context f21849b;

    /* renamed from: m, reason: collision with root package name */
    public final e0 f21850m;

    /* renamed from: n, reason: collision with root package name */
    public final b3.e f21851n;

    /* renamed from: p, reason: collision with root package name */
    public final a f21853p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21854q;

    /* renamed from: t, reason: collision with root package name */
    public Boolean f21857t;

    /* renamed from: o, reason: collision with root package name */
    public final HashSet f21852o = new HashSet();

    /* renamed from: s, reason: collision with root package name */
    public final w f21856s = new w();

    /* renamed from: r, reason: collision with root package name */
    public final Object f21855r = new Object();

    public b(Context context, androidx.work.a aVar, n nVar, e0 e0Var) {
        this.f21849b = context;
        this.f21850m = e0Var;
        this.f21851n = new b3.e(nVar, this);
        this.f21853p = new a(this, aVar.getRunnableScheduler());
    }

    @Override // x2.t
    public void cancel(String str) {
        Boolean bool = this.f21857t;
        e0 e0Var = this.f21850m;
        if (bool == null) {
            this.f21857t = Boolean.valueOf(o.isDefaultProcess(this.f21849b, e0Var.getConfiguration()));
        }
        boolean zBooleanValue = this.f21857t.booleanValue();
        String str2 = f21848u;
        if (!zBooleanValue) {
            g.get().info(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f21854q) {
            e0Var.getProcessor().addExecutionListener(this);
            this.f21854q = true;
        }
        g.get().debug(str2, "Cancelling work ID " + str);
        a aVar = this.f21853p;
        if (aVar != null) {
            aVar.unschedule(str);
        }
        Iterator<v> it = this.f21856s.remove(str).iterator();
        while (it.hasNext()) {
            e0Var.stopWork(it.next());
        }
    }

    @Override // x2.t
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // b3.c
    public void onAllConstraintsMet(List<f3.t> list) {
        Iterator<f3.t> it = list.iterator();
        while (it.hasNext()) {
            m mVarGenerationalId = f3.w.generationalId(it.next());
            w wVar = this.f21856s;
            if (!wVar.contains(mVarGenerationalId)) {
                g.get().debug(f21848u, "Constraints met: Scheduling work ID " + mVarGenerationalId);
                this.f21850m.startWork(wVar.tokenFor(mVarGenerationalId));
            }
        }
    }

    @Override // b3.c
    public void onAllConstraintsNotMet(List<f3.t> list) {
        Iterator<f3.t> it = list.iterator();
        while (it.hasNext()) {
            m mVarGenerationalId = f3.w.generationalId(it.next());
            g.get().debug(f21848u, "Constraints not met: Cancelling work ID " + mVarGenerationalId);
            v vVarRemove = this.f21856s.remove(mVarGenerationalId);
            if (vVarRemove != null) {
                this.f21850m.stopWork(vVarRemove);
            }
        }
    }

    @Override // x2.e
    public void onExecuted(m mVar, boolean z10) {
        this.f21856s.remove(mVar);
        synchronized (this.f21855r) {
            Iterator it = this.f21852o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f3.t tVar = (f3.t) it.next();
                if (f3.w.generationalId(tVar).equals(mVar)) {
                    g.get().debug(f21848u, "Stopping tracking for " + mVar);
                    this.f21852o.remove(tVar);
                    this.f21851n.replace(this.f21852o);
                    break;
                }
            }
        }
    }

    @Override // x2.t
    public void schedule(f3.t... tVarArr) {
        if (this.f21857t == null) {
            this.f21857t = Boolean.valueOf(o.isDefaultProcess(this.f21849b, this.f21850m.getConfiguration()));
        }
        if (!this.f21857t.booleanValue()) {
            g.get().info(f21848u, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f21854q) {
            this.f21850m.getProcessor().addExecutionListener(this);
            this.f21854q = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (f3.t tVar : tVarArr) {
            if (!this.f21856s.contains(f3.w.generationalId(tVar))) {
                long jCalculateNextRunTime = tVar.calculateNextRunTime();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (tVar.f11427b == WorkInfo$State.ENQUEUED) {
                    if (jCurrentTimeMillis < jCalculateNextRunTime) {
                        a aVar = this.f21853p;
                        if (aVar != null) {
                            aVar.schedule(tVar);
                        }
                    } else if (tVar.hasConstraints()) {
                        int i10 = Build.VERSION.SDK_INT;
                        if (i10 >= 23 && tVar.f11435j.requiresDeviceIdle()) {
                            g.get().debug(f21848u, "Ignoring " + tVar + ". Requires device idle.");
                        } else if (i10 < 24 || !tVar.f11435j.hasContentUriTriggers()) {
                            hashSet.add(tVar);
                            hashSet2.add(tVar.f11426a);
                        } else {
                            g.get().debug(f21848u, "Ignoring " + tVar + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f21856s.contains(f3.w.generationalId(tVar))) {
                        g.get().debug(f21848u, "Starting work for " + tVar.f11426a);
                        this.f21850m.startWork(this.f21856s.tokenFor(tVar));
                    }
                }
            }
        }
        synchronized (this.f21855r) {
            if (!hashSet.isEmpty()) {
                g.get().debug(f21848u, "Starting tracking for " + TextUtils.join(",", hashSet2));
                this.f21852o.addAll(hashSet);
                this.f21851n.replace(this.f21852o);
            }
        }
    }
}
