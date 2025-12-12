package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
import qe.b;

/* compiled from: Disposables.java */
/* loaded from: classes2.dex */
public final class a {
    public static b disposed() {
        return EmptyDisposable.INSTANCE;
    }

    public static b fromRunnable(Runnable runnable) {
        ue.a.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
