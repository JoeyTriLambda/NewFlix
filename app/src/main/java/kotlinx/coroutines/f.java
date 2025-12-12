package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.a1;
import kg.i2;
import kg.l;
import kg.o;
import kg.u0;
import kg.y1;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e;
import pg.b0;
import pg.g0;
import pg.h0;
import pg.p;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public abstract class f extends g implements e {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15365p = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_queue");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15366q = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_delayed");

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15367r = AtomicIntegerFieldUpdater.newUpdater(f.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* compiled from: EventLoop.common.kt */
    public final class a extends c {

        /* renamed from: n, reason: collision with root package name */
        public final l<lf.h> f15368n;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, l<? super lf.h> lVar) {
            super(j10);
            this.f15368n = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15368n.resumeUndispatched(f.this, lf.h.f16056a);
        }

        @Override // kotlinx.coroutines.f.c
        public String toString() {
            return super.toString() + this.f15368n;
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static final class b extends c {

        /* renamed from: n, reason: collision with root package name */
        public final Runnable f15370n;

        public b(long j10, Runnable runnable) {
            super(j10);
            this.f15370n = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15370n.run();
        }

        @Override // kotlinx.coroutines.f.c
        public String toString() {
            return super.toString() + this.f15370n;
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static abstract class c implements Runnable, Comparable<c>, u0, h0 {
        private volatile Object _heap;

        /* renamed from: b, reason: collision with root package name */
        public long f15371b;

        /* renamed from: m, reason: collision with root package name */
        public int f15372m = -1;

        public c(long j10) {
            this.f15371b = j10;
        }

        @Override // kg.u0
        public final void dispose() {
            synchronized (this) {
                Object obj = this._heap;
                if (obj == a1.f15095a) {
                    return;
                }
                d dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null) {
                    dVar.remove(this);
                }
                this._heap = a1.f15095a;
                lf.h hVar = lf.h.f16056a;
            }
        }

        @Override // pg.h0
        public g0<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof g0) {
                return (g0) obj;
            }
            return null;
        }

        @Override // pg.h0
        public int getIndex() {
            return this.f15372m;
        }

        public final int scheduleTask(long j10, d dVar, f fVar) {
            synchronized (this) {
                if (this._heap == a1.f15095a) {
                    return 2;
                }
                synchronized (dVar) {
                    c cVarFirstImpl = dVar.firstImpl();
                    if (f.access$isCompleted(fVar)) {
                        return 1;
                    }
                    if (cVarFirstImpl == null) {
                        dVar.f15373c = j10;
                    } else {
                        long j11 = cVarFirstImpl.f15371b;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - dVar.f15373c > 0) {
                            dVar.f15373c = j10;
                        }
                    }
                    long j12 = this.f15371b;
                    long j13 = dVar.f15373c;
                    if (j12 - j13 < 0) {
                        this.f15371b = j13;
                    }
                    dVar.addImpl(this);
                    return 0;
                }
            }
        }

        @Override // pg.h0
        public void setHeap(g0<?> g0Var) {
            if (!(this._heap != a1.f15095a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = g0Var;
        }

        @Override // pg.h0
        public void setIndex(int i10) {
            this.f15372m = i10;
        }

        public final boolean timeToExecute(long j10) {
            return j10 - this.f15371b >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f15371b + ']';
        }

        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            long j10 = this.f15371b - cVar.f15371b;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static final class d extends g0<c> {

        /* renamed from: c, reason: collision with root package name */
        public long f15373c;

        public d(long j10) {
            this.f15373c = j10;
        }
    }

    public static final boolean access$isCompleted(f fVar) {
        fVar.getClass();
        return f15367r.get(fVar) != 0;
    }

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15365p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z10 = false;
            if (f15367r.get(this) != 0) {
                return false;
            }
            if (obj == null) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                if (z10) {
                    return true;
                }
            } else if (obj instanceof p) {
                zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                p pVar = (p) obj;
                int iAddLast = pVar.addLast(runnable);
                if (iAddLast == 0) {
                    return true;
                }
                if (iAddLast == 1) {
                    p next = pVar.next();
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                    }
                } else if (iAddLast == 2) {
                    return false;
                }
            } else {
                if (obj == a1.f15096b) {
                    return false;
                }
                p pVar2 = new p(8, true);
                zf.i.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                pVar2.addLast((Runnable) obj);
                pVar2.addLast(runnable);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar2)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (z10) {
                    return true;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.b
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        if (a(runnable)) {
            unpark();
        } else {
            kotlinx.coroutines.d.f15363s.enqueue(runnable);
        }
    }

    @Override // kg.y0
    public long getNextTime() {
        c cVarPeek;
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = f15365p.get(this);
        if (obj != null) {
            if (!(obj instanceof p)) {
                return obj == a1.f15096b ? Long.MAX_VALUE : 0L;
            }
            if (!((p) obj).isEmpty()) {
                return 0L;
            }
        }
        d dVar = (d) f15366q.get(this);
        if (dVar == null || (cVarPeek = dVar.peek()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVarPeek.f15371b;
        kg.c.getTimeSource();
        return fg.h.coerceAtLeast(j10 - System.nanoTime(), 0L);
    }

    public u0 invokeOnTimeout(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return e.a.invokeOnTimeout(this, j10, runnable, coroutineContext);
    }

    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        d dVar = (d) f15366q.get(this);
        if (dVar != null && !dVar.isEmpty()) {
            return false;
        }
        Object obj = f15365p.get(this);
        if (obj != null) {
            if (obj instanceof p) {
                return ((p) obj).isEmpty();
            }
            if (obj != a1.f15096b) {
                return false;
            }
        }
        return true;
    }

    @Override // kg.y0
    public long processNextEvent() {
        boolean z10;
        c cVarRemoveAtImpl;
        if (processUnconfinedEvent()) {
            return 0L;
        }
        d dVar = (d) f15366q.get(this);
        Runnable runnable = null;
        if (dVar != null && !dVar.isEmpty()) {
            kg.c.getTimeSource();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    c cVarFirstImpl = dVar.firstImpl();
                    if (cVarFirstImpl == null) {
                        cVarRemoveAtImpl = null;
                    } else {
                        c cVar = cVarFirstImpl;
                        cVarRemoveAtImpl = cVar.timeToExecute(jNanoTime) ? a(cVar) : false ? dVar.removeAtImpl(0) : null;
                    }
                }
            } while (cVarRemoveAtImpl != null);
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15365p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                break;
            }
            if (obj instanceof p) {
                zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                p pVar = (p) obj;
                Object objRemoveFirstOrNull = pVar.removeFirstOrNull();
                if (objRemoveFirstOrNull != p.f17724h) {
                    runnable = (Runnable) objRemoveFirstOrNull;
                    break;
                }
                p next = pVar.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, next) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            } else {
                if (obj == a1.f15096b) {
                    break;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    zf.i.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    runnable = (Runnable) obj;
                    break;
                }
            }
        }
        if (runnable == null) {
            return getNextTime();
        }
        runnable.run();
        return 0L;
    }

    public final void resetAll() {
        f15365p.set(this, null);
        f15366q.set(this, null);
    }

    public final void schedule(long j10, c cVar) {
        int iScheduleTask;
        boolean z10 = f15367r.get(this) != 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15366q;
        if (z10) {
            iScheduleTask = 1;
        } else {
            d dVar = (d) atomicReferenceFieldUpdater.get(this);
            if (dVar == null) {
                d dVar2 = new d(j10);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, dVar2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                zf.i.checkNotNull(obj);
                dVar = (d) obj;
            }
            iScheduleTask = cVar.scheduleTask(j10, dVar, this);
        }
        if (iScheduleTask == 0) {
            d dVar3 = (d) atomicReferenceFieldUpdater.get(this);
            if ((dVar3 != null ? dVar3.peek() : null) == cVar) {
                unpark();
                return;
            }
            return;
        }
        if (iScheduleTask == 1) {
            reschedule(j10, cVar);
        } else if (iScheduleTask != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final u0 scheduleInvokeOnTimeout(long j10, Runnable runnable) {
        long jDelayToNanos = a1.delayToNanos(j10);
        if (jDelayToNanos >= 4611686018427387903L) {
            return y1.f15173b;
        }
        kg.c.getTimeSource();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jDelayToNanos + jNanoTime, runnable);
        schedule(jNanoTime, bVar);
        return bVar;
    }

    @Override // kotlinx.coroutines.e
    public void scheduleResumeAfterDelay(long j10, l<? super lf.h> lVar) {
        long jDelayToNanos = a1.delayToNanos(j10);
        if (jDelayToNanos < 4611686018427387903L) {
            kg.c.getTimeSource();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jDelayToNanos + jNanoTime, lVar);
            schedule(jNanoTime, aVar);
            o.disposeOnCancellation(lVar, aVar);
        }
    }

    @Override // kg.y0
    public void shutdown() {
        c cVarRemoveFirstOrNull;
        i2.f15113a.resetEventLoop$kotlinx_coroutines_core();
        f15367r.set(this, 1);
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15365p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z10 = false;
            if (obj == null) {
                b0 b0Var = a1.f15096b;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, b0Var)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                if (z10) {
                    break;
                }
            } else {
                if (obj instanceof p) {
                    ((p) obj).close();
                    break;
                }
                if (obj == a1.f15096b) {
                    break;
                }
                p pVar = new p(8, true);
                zf.i.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                pVar.addLast((Runnable) obj);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (z10) {
                    break;
                }
            }
        }
        while (processNextEvent() <= 0) {
        }
        kg.c.getTimeSource();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f15366q.get(this);
            if (dVar == null || (cVarRemoveFirstOrNull = dVar.removeFirstOrNull()) == null) {
                return;
            } else {
                reschedule(jNanoTime, cVarRemoveFirstOrNull);
            }
        }
    }
}
