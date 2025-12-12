package io.reactivex.internal.operators.observable;

import ef.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableSampleTimed<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14195m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f14196n;

    /* renamed from: o, reason: collision with root package name */
    public final r f14197o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f14198p;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* renamed from: r, reason: collision with root package name */
        public final AtomicInteger f14199r;

        public SampleTimedEmitLast(e eVar, long j10, TimeUnit timeUnit, r rVar) {
            super(eVar, j10, timeUnit, rVar);
            this.f14199r = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public final void a() {
            T andSet = getAndSet(null);
            q<? super T> qVar = this.f14200b;
            if (andSet != null) {
                qVar.onNext(andSet);
            }
            if (this.f14199r.decrementAndGet() == 0) {
                qVar.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicInteger atomicInteger = this.f14199r;
            if (atomicInteger.incrementAndGet() == 2) {
                T andSet = getAndSet(null);
                q<? super T> qVar = this.f14200b;
                if (andSet != null) {
                    qVar.onNext(andSet);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    qVar.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(e eVar, long j10, TimeUnit timeUnit, r rVar) {
            super(eVar, j10, timeUnit, rVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public final void a() {
            this.f14200b.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f14200b.onNext(andSet);
            }
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements q<T>, b, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14200b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14201m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f14202n;

        /* renamed from: o, reason: collision with root package name */
        public final r f14203o;

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<b> f14204p = new AtomicReference<>();

        /* renamed from: q, reason: collision with root package name */
        public b f14205q;

        public SampleTimedObserver(e eVar, long j10, TimeUnit timeUnit, r rVar) {
            this.f14200b = eVar;
            this.f14201m = j10;
            this.f14202n = timeUnit;
            this.f14203o = rVar;
        }

        public abstract void a();

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14204p);
            this.f14205q.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.dispose(this.f14204p);
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14204p);
            this.f14200b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14205q, bVar)) {
                this.f14205q = bVar;
                this.f14200b.onSubscribe(this);
                r rVar = this.f14203o;
                long j10 = this.f14201m;
                DisposableHelper.replace(this.f14204p, rVar.schedulePeriodicallyDirect(this, j10, j10, this.f14202n));
            }
        }
    }

    public ObservableSampleTimed(o<T> oVar, long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        super(oVar);
        this.f14195m = j10;
        this.f14196n = timeUnit;
        this.f14197o = rVar;
        this.f14198p = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        e eVar = new e(qVar);
        boolean z10 = this.f14198p;
        o<T> oVar = this.f22058b;
        if (z10) {
            oVar.subscribe(new SampleTimedEmitLast(eVar, this.f14195m, this.f14196n, this.f14197o));
        } else {
            oVar.subscribe(new SampleTimedNoLast(eVar, this.f14195m, this.f14196n, this.f14197o));
        }
    }
}
