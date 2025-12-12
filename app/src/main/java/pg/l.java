package pg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kg.j0;
import kg.u0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes2.dex */
public final class l extends kotlinx.coroutines.b implements kotlinx.coroutines.e {

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f17711r = AtomicIntegerFieldUpdater.newUpdater(l.class, "runningWorkers");

    /* renamed from: m, reason: collision with root package name */
    public final kotlinx.coroutines.b f17712m;

    /* renamed from: n, reason: collision with root package name */
    public final int f17713n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.e f17714o;

    /* renamed from: p, reason: collision with root package name */
    public final o<Runnable> f17715p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f17716q;
    private volatile int runningWorkers;

    /* compiled from: LimitedDispatcher.kt */
    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public Runnable f17717b;

        public a(Runnable runnable) {
            this.f17717b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f17717b.run();
                } catch (Throwable th2) {
                    kg.f0.handleCoroutineException(EmptyCoroutineContext.f15239b, th2);
                }
                l lVar = l.this;
                Runnable runnableA = lVar.a();
                if (runnableA == null) {
                    return;
                }
                this.f17717b = runnableA;
                i10++;
                if (i10 >= 16 && lVar.f17712m.isDispatchNeeded(lVar)) {
                    lVar.f17712m.dispatch(lVar, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(kotlinx.coroutines.b bVar, int i10) {
        this.f17712m = bVar;
        this.f17713n = i10;
        kotlinx.coroutines.e eVar = bVar instanceof kotlinx.coroutines.e ? (kotlinx.coroutines.e) bVar : null;
        this.f17714o = eVar == null ? j0.getDefaultDelay() : eVar;
        this.f17715p = new o<>(false);
        this.f17716q = new Object();
    }

    public final Runnable a() {
        while (true) {
            Runnable runnableRemoveFirstOrNull = this.f17715p.removeFirstOrNull();
            if (runnableRemoveFirstOrNull != null) {
                return runnableRemoveFirstOrNull;
            }
            synchronized (this.f17716q) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17711r;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f17715p.getSize() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        boolean z10;
        Runnable runnableA;
        this.f17715p.addLast(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17711r;
        if (atomicIntegerFieldUpdater.get(this) < this.f17713n) {
            synchronized (this.f17716q) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f17713n) {
                    z10 = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z10 = true;
                }
            }
            if (!z10 || (runnableA = a()) == null) {
                return;
            }
            this.f17712m.dispatch(this, new a(runnableA));
        }
    }

    @Override // kotlinx.coroutines.b
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        boolean z10;
        Runnable runnableA;
        this.f17715p.addLast(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17711r;
        if (atomicIntegerFieldUpdater.get(this) < this.f17713n) {
            synchronized (this.f17716q) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f17713n) {
                    z10 = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z10 = true;
                }
            }
            if (!z10 || (runnableA = a()) == null) {
                return;
            }
            this.f17712m.dispatchYield(this, new a(runnableA));
        }
    }

    @Override // kotlinx.coroutines.e
    public u0 invokeOnTimeout(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f17714o.invokeOnTimeout(j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.b
    public kotlinx.coroutines.b limitedParallelism(int i10) {
        m.checkParallelism(i10);
        return i10 >= this.f17713n ? this : super.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.e
    public void scheduleResumeAfterDelay(long j10, kg.l<? super lf.h> lVar) {
        this.f17714o.scheduleResumeAfterDelay(j10, lVar);
    }
}
