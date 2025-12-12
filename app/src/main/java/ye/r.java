package ye;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableDefer.java */
/* loaded from: classes2.dex */
public final class r<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Callable<? extends ne.o<? extends T>> f22341b;

    public r(Callable<? extends ne.o<? extends T>> callable) {
        this.f22341b = callable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        try {
            ((ne.o) ue.a.requireNonNull(this.f22341b.call(), "null ObservableSource supplied")).subscribe(qVar);
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
