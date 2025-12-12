package ye;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: ObservableEmpty.java */
/* loaded from: classes2.dex */
public final class e0 extends ne.k<Object> implements ve.d<Object> {

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f22130b = new e0();

    @Override // ve.d, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super Object> qVar) {
        EmptyDisposable.complete(qVar);
    }
}
