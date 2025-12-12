package ye;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableFromFuture.java */
/* loaded from: classes2.dex */
public final class k0<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Future<? extends T> f22207b;

    /* renamed from: m, reason: collision with root package name */
    public final long f22208m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f22209n;

    public k0(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        this.f22207b = future;
        this.f22208m = j10;
        this.f22209n = timeUnit;
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
            TimeUnit timeUnit = this.f22209n;
            Future<? extends T> future = this.f22207b;
            deferredScalarDisposable.complete(ue.a.requireNonNull(timeUnit != null ? future.get(this.f22208m, timeUnit) : future.get(), "Future returned null"));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            qVar.onError(th2);
        }
    }
}
