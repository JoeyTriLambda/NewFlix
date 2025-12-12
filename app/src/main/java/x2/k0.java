package x2;

import android.content.Context;
import androidx.work.WorkInfo$State;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

/* compiled from: WorkerWrapper.java */
/* loaded from: classes.dex */
public final class k0 implements Runnable {
    public static final String D = w2.g.tagWithPrefix("WorkerWrapper");
    public volatile boolean C;

    /* renamed from: b, reason: collision with root package name */
    public final Context f21429b;

    /* renamed from: m, reason: collision with root package name */
    public final String f21430m;

    /* renamed from: n, reason: collision with root package name */
    public final List<t> f21431n;

    /* renamed from: o, reason: collision with root package name */
    public final WorkerParameters.a f21432o;

    /* renamed from: p, reason: collision with root package name */
    public final f3.t f21433p;

    /* renamed from: q, reason: collision with root package name */
    public androidx.work.c f21434q;

    /* renamed from: r, reason: collision with root package name */
    public final i3.c f21435r;

    /* renamed from: t, reason: collision with root package name */
    public final androidx.work.a f21437t;

    /* renamed from: u, reason: collision with root package name */
    public final e3.a f21438u;

    /* renamed from: v, reason: collision with root package name */
    public final WorkDatabase f21439v;

    /* renamed from: w, reason: collision with root package name */
    public final f3.u f21440w;

    /* renamed from: x, reason: collision with root package name */
    public final f3.b f21441x;

    /* renamed from: y, reason: collision with root package name */
    public final List<String> f21442y;

    /* renamed from: z, reason: collision with root package name */
    public String f21443z;

    /* renamed from: s, reason: collision with root package name */
    public c.a f21436s = c.a.failure();
    public final h3.a<Boolean> A = h3.a.create();
    public final h3.a<c.a> B = h3.a.create();

    /* compiled from: WorkerWrapper.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f21444a;

        /* renamed from: b, reason: collision with root package name */
        public final e3.a f21445b;

        /* renamed from: c, reason: collision with root package name */
        public final i3.c f21446c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.work.a f21447d;

        /* renamed from: e, reason: collision with root package name */
        public final WorkDatabase f21448e;

        /* renamed from: f, reason: collision with root package name */
        public final f3.t f21449f;

        /* renamed from: g, reason: collision with root package name */
        public List<t> f21450g;

        /* renamed from: h, reason: collision with root package name */
        public final List<String> f21451h;

        /* renamed from: i, reason: collision with root package name */
        public WorkerParameters.a f21452i = new WorkerParameters.a();

        public a(Context context, androidx.work.a aVar, i3.c cVar, e3.a aVar2, WorkDatabase workDatabase, f3.t tVar, List<String> list) {
            this.f21444a = context.getApplicationContext();
            this.f21446c = cVar;
            this.f21445b = aVar2;
            this.f21447d = aVar;
            this.f21448e = workDatabase;
            this.f21449f = tVar;
            this.f21451h = list;
        }

        public k0 build() {
            return new k0(this);
        }

        public a withRuntimeExtras(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f21452i = aVar;
            }
            return this;
        }

        public a withSchedulers(List<t> list) {
            this.f21450g = list;
            return this;
        }
    }

    public k0(a aVar) {
        this.f21429b = aVar.f21444a;
        this.f21435r = aVar.f21446c;
        this.f21438u = aVar.f21445b;
        f3.t tVar = aVar.f21449f;
        this.f21433p = tVar;
        this.f21430m = tVar.f11426a;
        this.f21431n = aVar.f21450g;
        this.f21432o = aVar.f21452i;
        this.f21434q = null;
        this.f21437t = aVar.f21447d;
        WorkDatabase workDatabase = aVar.f21448e;
        this.f21439v = workDatabase;
        this.f21440w = workDatabase.workSpecDao();
        this.f21441x = workDatabase.dependencyDao();
        this.f21442y = aVar.f21451h;
    }

    public final void a(c.a aVar) {
        boolean z10 = aVar instanceof c.a.C0049c;
        f3.t tVar = this.f21433p;
        String str = D;
        if (!z10) {
            if (aVar instanceof c.a.b) {
                w2.g.get().info(str, "Worker result RETRY for " + this.f21443z);
                c();
                return;
            }
            w2.g.get().info(str, "Worker result FAILURE for " + this.f21443z);
            if (tVar.isPeriodic()) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        w2.g.get().info(str, "Worker result SUCCESS for " + this.f21443z);
        if (tVar.isPeriodic()) {
            d();
            return;
        }
        f3.b bVar = this.f21441x;
        String str2 = this.f21430m;
        f3.u uVar = this.f21440w;
        WorkDatabase workDatabase = this.f21439v;
        workDatabase.beginTransaction();
        try {
            uVar.setState(WorkInfo$State.SUCCEEDED, str2);
            uVar.setOutput(str2, ((c.a.C0049c) this.f21436s).getOutputData());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str3 : bVar.getDependentWorkIds(str2)) {
                if (uVar.getState(str3) == WorkInfo$State.BLOCKED && bVar.hasCompletedAllPrerequisites(str3)) {
                    w2.g.get().info(str, "Setting status to enqueued for " + str3);
                    uVar.setState(WorkInfo$State.ENQUEUED, str3);
                    uVar.setLastEnqueuedTime(str3, jCurrentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            e(false);
        }
    }

    public final void b() {
        boolean zH = h();
        String str = this.f21430m;
        WorkDatabase workDatabase = this.f21439v;
        if (!zH) {
            workDatabase.beginTransaction();
            try {
                WorkInfo$State state = this.f21440w.getState(str);
                workDatabase.workProgressDao().delete(str);
                if (state == null) {
                    e(false);
                } else if (state == WorkInfo$State.RUNNING) {
                    a(this.f21436s);
                } else if (!state.isFinished()) {
                    c();
                }
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        List<t> list = this.f21431n;
        if (list != null) {
            Iterator<t> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(str);
            }
            u.schedule(this.f21437t, workDatabase, list);
        }
    }

    public final void c() {
        String str = this.f21430m;
        f3.u uVar = this.f21440w;
        WorkDatabase workDatabase = this.f21439v;
        workDatabase.beginTransaction();
        try {
            uVar.setState(WorkInfo$State.ENQUEUED, str);
            uVar.setLastEnqueuedTime(str, System.currentTimeMillis());
            uVar.markWorkSpecScheduled(str, -1L);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            e(true);
        }
    }

    public final void d() {
        String str = this.f21430m;
        f3.u uVar = this.f21440w;
        WorkDatabase workDatabase = this.f21439v;
        workDatabase.beginTransaction();
        try {
            uVar.setLastEnqueuedTime(str, System.currentTimeMillis());
            uVar.setState(WorkInfo$State.ENQUEUED, str);
            uVar.resetWorkSpecRunAttemptCount(str);
            uVar.incrementPeriodCount(str);
            uVar.markWorkSpecScheduled(str, -1L);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
            e(false);
        }
    }

    public final void e(boolean z10) {
        e3.a aVar = this.f21438u;
        f3.u uVar = this.f21440w;
        WorkDatabase workDatabase = this.f21439v;
        workDatabase.beginTransaction();
        try {
            if (!workDatabase.workSpecDao().hasUnfinishedWork()) {
                g3.m.setComponentEnabled(this.f21429b, RescheduleReceiver.class, false);
            }
            String str = this.f21430m;
            if (z10) {
                uVar.setState(WorkInfo$State.ENQUEUED, str);
                uVar.markWorkSpecScheduled(str, -1L);
            }
            if (this.f21433p != null && this.f21434q != null && ((r) aVar).isEnqueuedInForeground(str)) {
                ((r) aVar).stopForeground(str);
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            this.A.set(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            workDatabase.endTransaction();
            throw th2;
        }
    }

    public final void f() {
        f3.u uVar = this.f21440w;
        String str = this.f21430m;
        WorkInfo$State state = uVar.getState(str);
        WorkInfo$State workInfo$State = WorkInfo$State.RUNNING;
        String str2 = D;
        if (state == workInfo$State) {
            w2.g.get().debug(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            e(true);
            return;
        }
        w2.g.get().debug(str2, "Status for " + str + " is " + state + " ; not doing any work");
        e(false);
    }

    public final void g() {
        String str = this.f21430m;
        WorkDatabase workDatabase = this.f21439v;
        workDatabase.beginTransaction();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                f3.u uVar = this.f21440w;
                if (zIsEmpty) {
                    uVar.setOutput(str, ((c.a.C0048a) this.f21436s).getOutputData());
                    workDatabase.setTransactionSuccessful();
                    return;
                } else {
                    String str2 = (String) linkedList.remove();
                    if (uVar.getState(str2) != WorkInfo$State.CANCELLED) {
                        uVar.setState(WorkInfo$State.FAILED, str2);
                    }
                    linkedList.addAll(this.f21441x.getDependentWorkIds(str2));
                }
            }
        } finally {
            workDatabase.endTransaction();
            e(false);
        }
    }

    public e8.c<Boolean> getFuture() {
        return this.A;
    }

    public f3.m getWorkGenerationalId() {
        return f3.w.generationalId(this.f21433p);
    }

    public f3.t getWorkSpec() {
        return this.f21433p;
    }

    public final boolean h() {
        if (!this.C) {
            return false;
        }
        w2.g.get().debug(D, "Work interrupted for " + this.f21443z);
        if (this.f21440w.getState(this.f21430m) == null) {
            e(false);
        } else {
            e(!r0.isFinished());
        }
        return true;
    }

    public void interrupt() {
        this.C = true;
        h();
        this.B.cancel(true);
        if (this.f21434q != null && this.B.isCancelled()) {
            this.f21434q.stop();
            return;
        }
        w2.g.get().debug(D, "WorkSpec " + this.f21433p + " is already done. Not interrupting.");
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx.work.b bVarMerge;
        boolean z10;
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        String str = this.f21430m;
        sb2.append(str);
        sb2.append(", tags={ ");
        boolean z11 = true;
        for (String str2 : this.f21442y) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(str2);
        }
        sb2.append(" } ]");
        this.f21443z = sb2.toString();
        f3.t tVar = this.f21433p;
        if (h()) {
            return;
        }
        WorkDatabase workDatabase = this.f21439v;
        workDatabase.beginTransaction();
        try {
            WorkInfo$State workInfo$State = tVar.f11427b;
            WorkInfo$State workInfo$State2 = WorkInfo$State.ENQUEUED;
            String str3 = tVar.f11428c;
            String str4 = D;
            if (workInfo$State != workInfo$State2) {
                f();
                workDatabase.setTransactionSuccessful();
                w2.g.get().debug(str4, str3 + " is not in ENQUEUED state. Nothing more to do");
            } else {
                if ((!tVar.isPeriodic() && !tVar.isBackedOff()) || System.currentTimeMillis() >= tVar.calculateNextRunTime()) {
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    boolean zIsPeriodic = tVar.isPeriodic();
                    f3.u uVar = this.f21440w;
                    androidx.work.a aVar = this.f21437t;
                    if (zIsPeriodic) {
                        bVarMerge = tVar.f11430e;
                    } else {
                        w2.e eVarCreateInputMergerWithDefaultFallback = aVar.getInputMergerFactory().createInputMergerWithDefaultFallback(tVar.f11429d);
                        if (eVarCreateInputMergerWithDefaultFallback == null) {
                            w2.g.get().error(str4, "Could not create Input Merger " + tVar.f11429d);
                            g();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(tVar.f11430e);
                        arrayList.addAll(uVar.getInputsFromPrerequisites(str));
                        bVarMerge = eVarCreateInputMergerWithDefaultFallback.merge(arrayList);
                    }
                    androidx.work.b bVar = bVarMerge;
                    UUID uuidFromString = UUID.fromString(str);
                    List<String> list = this.f21442y;
                    WorkerParameters.a aVar2 = this.f21432o;
                    int i10 = tVar.f11436k;
                    int generation = tVar.getGeneration();
                    Executor executor = aVar.getExecutor();
                    i3.c cVar = this.f21435r;
                    w2.p workerFactory = aVar.getWorkerFactory();
                    i3.c cVar2 = this.f21435r;
                    WorkerParameters workerParameters = new WorkerParameters(uuidFromString, bVar, list, aVar2, i10, generation, executor, cVar, workerFactory, new g3.x(workDatabase, cVar2), new g3.w(workDatabase, this.f21438u, cVar2));
                    if (this.f21434q == null) {
                        this.f21434q = aVar.getWorkerFactory().createWorkerWithDefaultFallback(this.f21429b, str3, workerParameters);
                    }
                    androidx.work.c cVar3 = this.f21434q;
                    if (cVar3 == null) {
                        w2.g.get().error(str4, "Could not create Worker " + str3);
                        g();
                        return;
                    }
                    if (cVar3.isUsed()) {
                        w2.g.get().error(str4, "Received an already-used Worker " + str3 + "; Worker Factory should return new instances");
                        g();
                        return;
                    }
                    this.f21434q.setUsed();
                    workDatabase.beginTransaction();
                    try {
                        if (uVar.getState(str) == workInfo$State2) {
                            uVar.setState(WorkInfo$State.RUNNING, str);
                            uVar.incrementWorkSpecRunAttemptCount(str);
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        workDatabase.setTransactionSuccessful();
                        if (!z10) {
                            f();
                            return;
                        }
                        if (h()) {
                            return;
                        }
                        g3.v vVar = new g3.v(this.f21429b, this.f21433p, this.f21434q, workerParameters.getForegroundUpdater(), this.f21435r);
                        i3.d dVar = (i3.d) cVar2;
                        dVar.getMainThreadExecutor().execute(vVar);
                        e8.c<Void> future = vVar.getFuture();
                        r.x xVar = new r.x(7, this, future);
                        g3.s sVar = new g3.s();
                        h3.a<c.a> aVar3 = this.B;
                        aVar3.addListener(xVar, sVar);
                        future.addListener(new i0(this, future), dVar.getMainThreadExecutor());
                        aVar3.addListener(new j0(this, this.f21443z), dVar.m31getSerialTaskExecutor());
                        return;
                    } finally {
                    }
                }
                w2.g.get().debug(str4, String.format("Delaying execution for %s because it is being executed before schedule.", str3));
                e(true);
                workDatabase.setTransactionSuccessful();
            }
        } finally {
        }
    }
}
