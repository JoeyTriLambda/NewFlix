package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import qe.b;

/* loaded from: classes2.dex */
public final class SequentialDisposable extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    @Override // qe.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean replace(b bVar) {
        return DisposableHelper.replace(this, bVar);
    }

    public boolean update(b bVar) {
        return DisposableHelper.set(this, bVar);
    }

    public SequentialDisposable(b bVar) {
        lazySet(bVar);
    }
}
