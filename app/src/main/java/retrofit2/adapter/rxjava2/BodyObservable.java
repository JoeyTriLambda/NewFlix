package retrofit2.adapter.rxjava2;

import ff.a;
import io.reactivex.exceptions.CompositeException;
import ne.k;
import ne.q;
import qe.b;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class BodyObservable<T> extends k<T> {
    private final k<Response<T>> upstream;

    public static class BodyObserver<R> implements q<Response<R>> {
        private final q<? super R> observer;
        private boolean terminated;

        public BodyObserver(q<? super R> qVar) {
            this.observer = qVar;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.terminated) {
                return;
            }
            this.observer.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.terminated) {
                this.observer.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            a.onError(assertionError);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        @Override // ne.q
        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                a.onError(new CompositeException(httpException, th2));
            }
        }
    }

    public BodyObservable(k<Response<T>> kVar) {
        this.upstream = kVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.upstream.subscribe(new BodyObserver(qVar));
    }
}
