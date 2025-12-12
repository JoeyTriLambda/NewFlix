package io.reactivex.internal.operators.observable;

import cf.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableTakeUntil<T, U> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final o<? extends U> f14319m;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 1418547743690811973L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14320b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<b> f14321m = new AtomicReference<>();

        /* renamed from: n, reason: collision with root package name */
        public final TakeUntilMainObserver<T, U>.OtherObserver f14322n = new OtherObserver();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f14323o = new AtomicThrowable();

        public final class OtherObserver extends AtomicReference<b> implements q<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            @Override // ne.q
            public void onComplete() {
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.f14321m);
                f.onComplete(takeUntilMainObserver.f14320b, takeUntilMainObserver, takeUntilMainObserver.f14323o);
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.f14321m);
                f.onError(takeUntilMainObserver.f14320b, th2, takeUntilMainObserver, takeUntilMainObserver.f14323o);
            }

            @Override // ne.q
            public void onNext(U u10) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.f14321m);
                f.onComplete(takeUntilMainObserver.f14320b, takeUntilMainObserver, takeUntilMainObserver.f14323o);
            }

            @Override // ne.q
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public TakeUntilMainObserver(q<? super T> qVar) {
            this.f14320b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14321m);
            DisposableHelper.dispose(this.f14322n);
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.dispose(this.f14322n);
            f.onComplete(this.f14320b, this, this.f14323o);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14322n);
            f.onError(this.f14320b, th2, this, this.f14323o);
        }

        @Override // ne.q
        public void onNext(T t10) {
            f.onNext(this.f14320b, t10, this, this.f14323o);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14321m, bVar);
        }
    }

    public ObservableTakeUntil(o<T> oVar, o<? extends U> oVar2) {
        super(oVar);
        this.f14319m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(qVar);
        qVar.onSubscribe(takeUntilMainObserver);
        this.f14319m.subscribe(takeUntilMainObserver.f14322n);
        this.f22058b.subscribe(takeUntilMainObserver);
    }
}
