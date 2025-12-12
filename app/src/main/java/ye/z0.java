package ye;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: ObservableNever.java */
/* loaded from: classes2.dex */
public final class z0 extends ne.k<Object> {

    /* renamed from: b, reason: collision with root package name */
    public static final z0 f22536b = new z0();

    @Override // ne.k
    public void subscribeActual(ne.q<? super Object> qVar) {
        qVar.onSubscribe(EmptyDisposable.NEVER);
    }
}
