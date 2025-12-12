package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kg.i0;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.random.Random;
import pg.b0;
import pg.w;
import rg.c;
import rg.g;
import rg.h;
import rg.j;
import rg.k;
import rg.m;
import zf.f;
import zf.i;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes2.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: s, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15576s;

    /* renamed from: t, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15577t;

    /* renamed from: u, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15578u;

    /* renamed from: v, reason: collision with root package name */
    public static final b0 f15579v;
    private volatile int _isTerminated;

    /* renamed from: b, reason: collision with root package name */
    public final int f15580b;
    private volatile long controlState;

    /* renamed from: m, reason: collision with root package name */
    public final int f15581m;

    /* renamed from: n, reason: collision with root package name */
    public final long f15582n;

    /* renamed from: o, reason: collision with root package name */
    public final String f15583o;

    /* renamed from: p, reason: collision with root package name */
    public final c f15584p;
    private volatile long parkedWorkersStack;

    /* renamed from: q, reason: collision with root package name */
    public final c f15585q;

    /* renamed from: r, reason: collision with root package name */
    public final w<b> f15586r;

    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    public final class b extends Thread {

        /* renamed from: t, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f15593t = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");

        /* renamed from: b, reason: collision with root package name */
        public final m f15594b;
        private volatile int indexInArray;

        /* renamed from: m, reason: collision with root package name */
        public final Ref$ObjectRef<g> f15595m;

        /* renamed from: n, reason: collision with root package name */
        public WorkerState f15596n;
        private volatile Object nextParkedWorker;

        /* renamed from: o, reason: collision with root package name */
        public long f15597o;

        /* renamed from: p, reason: collision with root package name */
        public long f15598p;

        /* renamed from: q, reason: collision with root package name */
        public int f15599q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f15600r;
        private volatile int workerCtl;

        public b() {
            throw null;
        }

        public b(int i10) {
            setDaemon(true);
            this.f15594b = new m();
            this.f15595m = new Ref$ObjectRef<>();
            this.f15596n = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f15579v;
            this.f15599q = Random.f15263b.nextInt();
            setIndexInArray(i10);
        }

        public final g a() {
            int iNextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (iNextInt == 0) {
                g gVarRemoveFirstOrNull = coroutineScheduler.f15584p.removeFirstOrNull();
                return gVarRemoveFirstOrNull != null ? gVarRemoveFirstOrNull : coroutineScheduler.f15585q.removeFirstOrNull();
            }
            g gVarRemoveFirstOrNull2 = coroutineScheduler.f15585q.removeFirstOrNull();
            return gVarRemoveFirstOrNull2 != null ? gVarRemoveFirstOrNull2 : coroutineScheduler.f15584p.removeFirstOrNull();
        }

        public final g b(int i10) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f15577t;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i11 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int iNextInt = nextInt(i11);
            long jMin = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                iNextInt++;
                if (iNextInt > i11) {
                    iNextInt = 1;
                }
                b bVar = coroutineScheduler.f15586r.get(iNextInt);
                if (bVar != null && bVar != this) {
                    m mVar = bVar.f15594b;
                    Ref$ObjectRef<g> ref$ObjectRef = this.f15595m;
                    long jTrySteal = mVar.trySteal(i10, ref$ObjectRef);
                    if (jTrySteal == -1) {
                        g gVar = ref$ObjectRef.f15262b;
                        ref$ObjectRef.f15262b = null;
                        return gVar;
                    }
                    if (jTrySteal > 0) {
                        jMin = Math.min(jMin, jTrySteal);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f15598p = jMin;
            return null;
        }

        public final g findTask(boolean z10) {
            boolean z11;
            g gVarA;
            g gVarA2;
            boolean z12;
            WorkerState workerState = this.f15596n;
            WorkerState workerState2 = WorkerState.CPU_ACQUIRED;
            if (workerState == workerState2) {
                z11 = true;
            } else {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f15577t;
                while (true) {
                    long j10 = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                        z12 = false;
                        break;
                    }
                    if (CoroutineScheduler.f15577t.compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L)) {
                        z12 = true;
                        break;
                    }
                }
                if (z12) {
                    this.f15596n = workerState2;
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
            m mVar = this.f15594b;
            if (!z11) {
                g gVarPollBlocking = mVar.pollBlocking();
                if (gVarPollBlocking != null) {
                    return gVarPollBlocking;
                }
                g gVarRemoveFirstOrNull = coroutineScheduler2.f15585q.removeFirstOrNull();
                return gVarRemoveFirstOrNull == null ? b(1) : gVarRemoveFirstOrNull;
            }
            if (z10) {
                boolean z13 = nextInt(coroutineScheduler2.f15580b * 2) == 0;
                if (z13 && (gVarA2 = a()) != null) {
                    return gVarA2;
                }
                g gVarPoll = mVar.poll();
                if (gVarPoll != null) {
                    return gVarPoll;
                }
                if (!z13 && (gVarA = a()) != null) {
                    return gVarA;
                }
            } else {
                g gVarA3 = a();
                if (gVarA3 != null) {
                    return gVarA3;
                }
            }
            return b(3);
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int i10) {
            int i11 = this.f15599q;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f15599q = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:96:0x0002, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0002, code lost:
        
            continue;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 322
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.b.run():void");
        }

        public final void setIndexInArray(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f15583o);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            WorkerState workerState2 = this.f15596n;
            boolean z10 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z10) {
                CoroutineScheduler.f15577t.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f15596n = workerState;
            }
            return z10;
        }
    }

    static {
        new a(null);
        f15576s = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        f15577t = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        f15578u = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
        f15579v = new b0("NOT_IN_STACK");
    }

    public CoroutineScheduler(int i10, int i11, long j10, String str) {
        this.f15580b = i10;
        this.f15581m = i11;
        this.f15582n = j10;
        this.f15583o = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(o1.a.d("Core pool size ", i10, " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(ac.c.g("Max pool size ", i11, " should be greater than or equals to core pool size ", i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(o1.a.d("Max pool size ", i11, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f15584p = new c();
        this.f15585q = new c();
        this.f15586r = new w<>((i10 + 1) * 2);
        this.controlState = i10 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar = k.f18967g;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        coroutineScheduler.dispatch(runnable, hVar, z10);
    }

    public final int a() {
        synchronized (this.f15586r) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f15577t;
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 & 2097151);
            int iCoerceAtLeast = fg.h.coerceAtLeast(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.f15580b) {
                return 0;
            }
            if (i10 >= this.f15581m) {
                return 0;
            }
            int i11 = ((int) (f15577t.get(this) & 2097151)) + 1;
            if (!(i11 > 0 && this.f15586r.get(i11) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            b bVar = new b(i11);
            this.f15586r.setSynchronized(i11, bVar);
            if (!(i11 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int i12 = iCoerceAtLeast + 1;
            bVar.start();
            return i12;
        }
    }

    public final boolean b(long j10) {
        int iCoerceAtLeast = fg.h.coerceAtLeast(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0);
        int i10 = this.f15580b;
        if (iCoerceAtLeast < i10) {
            int iA = a();
            if (iA == 1 && i10 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        b0 b0Var;
        int indexInArray;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f15576s;
            long j10 = atomicLongFieldUpdater.get(this);
            b bVar = this.f15586r.get((int) (2097151 & j10));
            if (bVar == null) {
                bVar = null;
            } else {
                long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
                Object nextParkedWorker = bVar.getNextParkedWorker();
                while (true) {
                    b0Var = f15579v;
                    if (nextParkedWorker == b0Var) {
                        indexInArray = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        indexInArray = 0;
                        break;
                    }
                    b bVar2 = (b) nextParkedWorker;
                    indexInArray = bVar2.getIndexInArray();
                    if (indexInArray != 0) {
                        break;
                    }
                    nextParkedWorker = bVar2.getNextParkedWorker();
                }
                if (indexInArray >= 0 && atomicLongFieldUpdater.compareAndSet(this, j10, j11 | indexInArray)) {
                    bVar.setNextParkedWorker(b0Var);
                }
            }
            if (bVar == null) {
                return false;
            }
            if (b.f15593t.compareAndSet(bVar, -1, 0)) {
                LockSupport.unpark(bVar);
                return true;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        shutdown(10000L);
    }

    public final g createTask(Runnable runnable, h hVar) {
        long jNanoTime = k.f18966f.nanoTime();
        if (!(runnable instanceof g)) {
            return new j(runnable, jNanoTime, hVar);
        }
        g gVar = (g) runnable;
        gVar.f18957b = jNanoTime;
        gVar.f18958m = hVar;
        return gVar;
    }

    public final void dispatch(Runnable runnable, h hVar, boolean z10) {
        kg.c.getTimeSource();
        g gVarCreateTask = createTask(runnable, hVar);
        boolean z11 = false;
        boolean z12 = gVarCreateTask.f18958m.getTaskMode() == 1;
        long jAddAndGet = z12 ? f15577t.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        b bVar = null;
        b bVar2 = threadCurrentThread instanceof b ? (b) threadCurrentThread : null;
        if (bVar2 != null && i.areEqual(CoroutineScheduler.this, this)) {
            bVar = bVar2;
        }
        if (bVar != null && bVar.f15596n != WorkerState.TERMINATED && (gVarCreateTask.f18958m.getTaskMode() != 0 || bVar.f15596n != WorkerState.BLOCKING)) {
            bVar.f15600r = true;
            gVarCreateTask = bVar.f15594b.add(gVarCreateTask, z10);
        }
        if (gVarCreateTask != null) {
            if (!(gVarCreateTask.f18958m.getTaskMode() == 1 ? this.f15585q.addLast(gVarCreateTask) : this.f15584p.addLast(gVarCreateTask))) {
                throw new RejectedExecutionException(ac.c.o(new StringBuilder(), this.f15583o, " was terminated"));
            }
        }
        if (z10 && bVar != null) {
            z11 = true;
        }
        if (!z12) {
            if (z11) {
                return;
            }
            signalCpuWork();
        } else {
            if (z11 || c() || b(jAddAndGet)) {
                return;
            }
            c();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch$default(this, runnable, null, false, 6, null);
    }

    public final boolean isTerminated() {
        return f15578u.get(this) != 0;
    }

    public final boolean parkedWorkersStackPush(b bVar) {
        long j10;
        long j11;
        int indexInArray;
        if (bVar.getNextParkedWorker() != f15579v) {
            return false;
        }
        do {
            j10 = f15576s.get(this);
            j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            indexInArray = bVar.getIndexInArray();
            bVar.setNextParkedWorker(this.f15586r.get((int) (2097151 & j10)));
        } while (!f15576s.compareAndSet(this, j10, j11 | indexInArray));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(b bVar, int i10, int i11) {
        while (true) {
            long j10 = f15576s.get(this);
            int indexInArray = (int) (2097151 & j10);
            long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            if (indexInArray == i10) {
                if (i11 == 0) {
                    Object nextParkedWorker = bVar.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == f15579v) {
                            indexInArray = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            indexInArray = 0;
                            break;
                        }
                        b bVar2 = (b) nextParkedWorker;
                        indexInArray = bVar2.getIndexInArray();
                        if (indexInArray != 0) {
                            break;
                        } else {
                            nextParkedWorker = bVar2.getNextParkedWorker();
                        }
                    }
                } else {
                    indexInArray = i11;
                }
            }
            if (indexInArray >= 0 && f15576s.compareAndSet(this, j10, j11 | indexInArray)) {
                return;
            }
        }
    }

    public final void runSafely(g gVar) {
        try {
            gVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void shutdown(long r9) throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f15578u
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.b
            r3 = 0
            if (r1 == 0) goto L17
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L25
            kotlinx.coroutines.scheduling.CoroutineScheduler r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.b.access$getThis$0$p(r0)
            boolean r1 = zf.i.areEqual(r1, r8)
            if (r1 == 0) goto L25
            r3 = r0
        L25:
            pg.w<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r0 = r8.f15586r
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = access$getControlState$FU$p()     // Catch: java.lang.Throwable -> L9d
            long r4 = r1.get(r8)     // Catch: java.lang.Throwable -> L9d
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r1 = (int) r4
            monitor-exit(r0)
            if (r2 > r1) goto L5f
            r0 = 1
        L39:
            pg.w<kotlinx.coroutines.scheduling.CoroutineScheduler$b> r4 = r8.f15586r
            java.lang.Object r4 = r4.get(r0)
            zf.i.checkNotNull(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r4
            if (r4 == r3) goto L5a
        L46:
            boolean r5 = r4.isAlive()
            if (r5 == 0) goto L53
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L46
        L53:
            rg.m r4 = r4.f15594b
            rg.c r5 = r8.f15585q
            r4.offloadAllWorkTo(r5)
        L5a:
            if (r0 == r1) goto L5f
            int r0 = r0 + 1
            goto L39
        L5f:
            rg.c r9 = r8.f15585q
            r9.close()
            rg.c r9 = r8.f15584p
            r9.close()
        L69:
            if (r3 == 0) goto L71
            rg.g r9 = r3.findTask(r2)
            if (r9 != 0) goto L99
        L71:
            rg.c r9 = r8.f15584p
            java.lang.Object r9 = r9.removeFirstOrNull()
            rg.g r9 = (rg.g) r9
            if (r9 != 0) goto L99
            rg.c r9 = r8.f15585q
            java.lang.Object r9 = r9.removeFirstOrNull()
            rg.g r9 = (rg.g) r9
            if (r9 != 0) goto L99
            if (r3 == 0) goto L8c
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r3.tryReleaseCpu(r9)
        L8c:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.f15576s
            r0 = 0
            r9.set(r8, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.f15577t
            r9.set(r8, r0)
            return
        L99:
            r8.runSafely(r9)
            goto L69
        L9d:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public final void signalCpuWork() {
        if (c() || b(f15577t.get(this))) {
            return;
        }
        c();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        w<b> wVar = this.f15586r;
        int iCurrentLength = wVar.currentLength();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iCurrentLength; i15++) {
            b bVar = wVar.get(i15);
            if (bVar != null) {
                int size$kotlinx_coroutines_core = bVar.f15594b.getSize$kotlinx_coroutines_core();
                int iOrdinal = bVar.f15596n.ordinal();
                if (iOrdinal == 0) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(size$kotlinx_coroutines_core);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 1) {
                    i11++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(size$kotlinx_coroutines_core);
                    sb3.append('b');
                    arrayList.add(sb3.toString());
                } else if (iOrdinal == 2) {
                    i12++;
                } else if (iOrdinal == 3) {
                    i13++;
                    if (size$kotlinx_coroutines_core > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(size$kotlinx_coroutines_core);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (iOrdinal == 4) {
                    i14++;
                }
            }
        }
        long j10 = f15577t.get(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f15583o);
        sb5.append('@');
        sb5.append(i0.getHexAddress(this));
        sb5.append("[Pool Size {core = ");
        int i16 = this.f15580b;
        sb5.append(i16);
        sb5.append(", max = ");
        sb5.append(this.f15581m);
        sb5.append("}, Worker States {CPU = ");
        sb5.append(i10);
        sb5.append(", blocking = ");
        sb5.append(i11);
        sb5.append(", parked = ");
        sb5.append(i12);
        sb5.append(", dormant = ");
        sb5.append(i13);
        sb5.append(", terminated = ");
        sb5.append(i14);
        sb5.append("}, running workers queues = ");
        sb5.append(arrayList);
        sb5.append(", global CPU queue size = ");
        sb5.append(this.f15584p.getSize());
        sb5.append(", global blocking queue size = ");
        sb5.append(this.f15585q.getSize());
        sb5.append(", Control State {created workers= ");
        sb5.append((int) (2097151 & j10));
        sb5.append(", blocking tasks = ");
        sb5.append((int) ((4398044413952L & j10) >> 21));
        sb5.append(", CPUs acquired = ");
        sb5.append(i16 - ((int) ((j10 & 9223367638808264704L) >> 42)));
        sb5.append("}]");
        return sb5.toString();
    }
}
