package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import ne.k;
import ne.q;
import qe.b;
import re.a;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes2.dex */
final class CallExecuteObservable<T> extends k<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallDisposable implements b {
        private final Call<?> call;

        public CallDisposable(Call<?> call) {
            this.call = call;
        }

        @Override // qe.b
        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }

    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Response<T>> qVar) {
        boolean z10;
        Call<T> callClone = this.originalCall.clone();
        qVar.onSubscribe(new CallDisposable(callClone));
        try {
            Response<T> responseExecute = callClone.execute();
            if (!callClone.isCanceled()) {
                qVar.onNext(responseExecute);
            }
            if (callClone.isCanceled()) {
                return;
            }
            try {
                qVar.onComplete();
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                a.throwIfFatal(th);
                if (z10) {
                    ff.a.onError(th);
                    return;
                }
                if (callClone.isCanceled()) {
                    return;
                }
                try {
                    qVar.onError(th);
                } catch (Throwable th3) {
                    a.throwIfFatal(th3);
                    ff.a.onError(new CompositeException(th, th3));
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z10 = false;
        }
    }
}
