package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import ne.k;
import ne.q;
import ne.t;
import ne.u;
import qe.b;

/* loaded from: classes2.dex */
public final class SingleToObservable<T> extends k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final u<? extends T> f14498b;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements t<T> {
        private static final long serialVersionUID = 3786543492451018833L;

        /* renamed from: n, reason: collision with root package name */
        public b f14499n;

        public SingleToObservableObserver(q<? super T> qVar) {
            super(qVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, qe.b
        public void dispose() {
            super.dispose();
            this.f14499n.dispose();
        }

        @Override // ne.t
        public void onError(Throwable th2) {
            error(th2);
        }

        @Override // ne.t
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14499n, bVar)) {
                this.f14499n = bVar;
                this.f13572b.onSubscribe(this);
            }
        }

        @Override // ne.t
        public void onSuccess(T t10) {
            complete(t10);
        }
    }

    public SingleToObservable(u<? extends T> uVar) {
        this.f14498b = uVar;
    }

    public static <T> t<T> create(q<? super T> qVar) {
        return new SingleToObservableObserver(qVar);
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f14498b.subscribe(create(qVar));
    }
}
