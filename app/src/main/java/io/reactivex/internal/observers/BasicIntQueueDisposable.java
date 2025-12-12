package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;
import ve.b;

/* loaded from: classes2.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // ve.f
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
