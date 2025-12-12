package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import ne.h;
import ne.k;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class MaybeToObservable<T> extends k<T> {

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements h<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: n, reason: collision with root package name */
        public b f13615n;

        public MaybeToObservableObserver(q<? super T> qVar) {
            super(qVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, qe.b
        public void dispose() {
            super.dispose();
            this.f13615n.dispose();
        }

        @Override // ne.h
        public void onComplete() {
            complete();
        }

        @Override // ne.h
        public void onError(Throwable th2) {
            error(th2);
        }

        @Override // ne.h
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13615n, bVar)) {
                this.f13615n = bVar;
                this.f13572b.onSubscribe(this);
            }
        }

        @Override // ne.h
        public void onSuccess(T t10) {
            complete(t10);
        }
    }

    public static <T> h<T> create(q<? super T> qVar) {
        return new MaybeToObservableObserver(qVar);
    }
}
