package ye;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableError.java */
/* loaded from: classes2.dex */
public final class f0<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Callable<? extends Throwable> f22144b;

    public f0(Callable<? extends Throwable> callable) {
        this.f22144b = callable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        try {
            th = (Throwable) ue.a.requireNonNull(this.f22144b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            re.a.throwIfFatal(th);
        }
        EmptyDisposable.error(th, qVar);
    }
}
