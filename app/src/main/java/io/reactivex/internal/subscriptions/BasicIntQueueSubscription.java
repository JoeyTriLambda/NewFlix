package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import ve.c;

/* loaded from: classes2.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements c, zh.c {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // ve.f
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
