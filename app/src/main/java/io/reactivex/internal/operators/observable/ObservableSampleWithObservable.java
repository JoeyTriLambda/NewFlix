package io.reactivex.internal.operators.observable;

import ef.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableSampleWithObservable<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final o<?> f14206m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f14207n;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* renamed from: p, reason: collision with root package name */
        public final AtomicInteger f14208p;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f14209q;

        public SampleMainEmitLast(o oVar, e eVar) {
            super(oVar, eVar);
            this.f14208p = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public final void a() {
            this.f14209q = true;
            if (this.f14208p.getAndIncrement() == 0) {
                T andSet = getAndSet(null);
                if (andSet != null) {
                    this.f14210b.onNext(andSet);
                }
                this.f14210b.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public final void b() {
            if (this.f14208p.getAndIncrement() == 0) {
                do {
                    boolean z10 = this.f14209q;
                    T andSet = getAndSet(null);
                    if (andSet != null) {
                        this.f14210b.onNext(andSet);
                    }
                    if (z10) {
                        this.f14210b.onComplete();
                        return;
                    }
                } while (this.f14208p.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(o oVar, e eVar) {
            super(oVar, eVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public final void a() {
            this.f14210b.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public final void b() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f14210b.onNext(andSet);
            }
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements q<T>, b {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14210b;

        /* renamed from: m, reason: collision with root package name */
        public final o<?> f14211m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicReference<b> f14212n = new AtomicReference<>();

        /* renamed from: o, reason: collision with root package name */
        public b f14213o;

        public SampleMainObserver(o oVar, e eVar) {
            this.f14210b = eVar;
            this.f14211m = oVar;
        }

        public abstract void a();

        public abstract void b();

        public void complete() {
            this.f14213o.dispose();
            a();
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14212n);
            this.f14213o.dispose();
        }

        public void error(Throwable th2) {
            this.f14213o.dispose();
            this.f14210b.onError(th2);
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.dispose(this.f14212n);
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14212n);
            this.f14210b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14213o, bVar)) {
                this.f14213o = bVar;
                this.f14210b.onSubscribe(this);
                if (this.f14212n.get() == null) {
                    this.f14211m.subscribe(new a(this));
                }
            }
        }
    }

    public static final class a<T> implements q<Object> {

        /* renamed from: b, reason: collision with root package name */
        public final SampleMainObserver<T> f14214b;

        public a(SampleMainObserver<T> sampleMainObserver) {
            this.f14214b = sampleMainObserver;
        }

        @Override // ne.q
        public void onComplete() {
            this.f14214b.complete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14214b.error(th2);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            this.f14214b.b();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14214b.f14212n, bVar);
        }
    }

    public ObservableSampleWithObservable(o<T> oVar, o<?> oVar2, boolean z10) {
        super(oVar);
        this.f14206m = oVar2;
        this.f14207n = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        e eVar = new e(qVar);
        boolean z10 = this.f14207n;
        o<?> oVar = this.f14206m;
        o<T> oVar2 = this.f22058b;
        if (z10) {
            oVar2.subscribe(new SampleMainEmitLast(oVar, eVar));
        } else {
            oVar2.subscribe(new SampleMainNoLast(oVar, eVar));
        }
    }
}
