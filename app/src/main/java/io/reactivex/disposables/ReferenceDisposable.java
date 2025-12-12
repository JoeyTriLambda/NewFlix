package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import qe.b;

/* loaded from: classes2.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T t10) {
        super(ue.a.requireNonNull(t10, "value is null"));
    }

    @Override // qe.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(T t10);
}
