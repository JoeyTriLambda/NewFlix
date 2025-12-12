package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import ne.k;
import ne.q;
import qe.b;
import re.a;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class ResultObservable<T> extends k<Result<T>> {
    private final k<Response<T>> upstream;

    public static class ResultObserver<R> implements q<Response<R>> {
        private final q<? super Result<R>> observer;

        public ResultObserver(q<? super Result<R>> qVar) {
            this.observer = qVar;
        }

        @Override // ne.q
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            try {
                this.observer.onNext(Result.error(th2));
                this.observer.onComplete();
            } catch (Throwable th3) {
                try {
                    this.observer.onError(th3);
                } catch (Throwable th4) {
                    a.throwIfFatal(th4);
                    ff.a.onError(new CompositeException(th3, th4));
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        @Override // ne.q
        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }
    }

    public ResultObservable(k<Response<T>> kVar) {
        this.upstream = kVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Result<T>> qVar) {
        this.upstream.subscribe(new ResultObserver(qVar));
    }
}
