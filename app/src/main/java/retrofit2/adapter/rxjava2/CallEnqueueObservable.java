package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import ne.k;
import ne.q;
import qe.b;
import re.a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class CallEnqueueObservable<T> extends k<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallCallback<T> implements b, Callback<T> {
        private final Call<?> call;
        private final q<? super Response<T>> observer;
        boolean terminated = false;

        public CallCallback(Call<?> call, q<? super Response<T>> qVar) {
            this.call = call;
            this.observer = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th2) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th2);
            } catch (Throwable th3) {
                a.throwIfFatal(th3);
                ff.a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onNext(response);
                if (call.isCanceled()) {
                    return;
                }
                this.terminated = true;
                this.observer.onComplete();
            } catch (Throwable th2) {
                if (this.terminated) {
                    ff.a.onError(th2);
                    return;
                }
                if (call.isCanceled()) {
                    return;
                }
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    a.throwIfFatal(th3);
                    ff.a.onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Response<T>> qVar) {
        Call<T> callClone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(callClone, qVar);
        qVar.onSubscribe(callCallback);
        callClone.enqueue(callCallback);
    }
}
