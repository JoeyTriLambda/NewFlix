package ye;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableFromCallable.java */
/* loaded from: classes2.dex */
public final class j0<T> extends ne.k<T> implements Callable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Callable<? extends T> f22193b;

    public j0(Callable<? extends T> callable) {
        this.f22193b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) ue.a.requireNonNull(this.f22193b.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(qVar);
        qVar.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ue.a.requireNonNull(this.f22193b.call(), "Callable returned null"));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            if (deferredScalarDisposable.isDisposed()) {
                ff.a.onError(th2);
            } else {
                qVar.onError(th2);
            }
        }
    }
}
