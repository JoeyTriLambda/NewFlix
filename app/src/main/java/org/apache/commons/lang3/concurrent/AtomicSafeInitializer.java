package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public final T get() throws ConcurrentException {
        boolean z10;
        while (true) {
            T t10 = this.reference.get();
            if (t10 != null) {
                return t10;
            }
            AtomicReference<AtomicSafeInitializer<T>> atomicReference = this.factory;
            while (true) {
                if (atomicReference.compareAndSet(null, this)) {
                    z10 = true;
                    break;
                }
                if (atomicReference.get() != null) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                this.reference.set(initialize());
            }
        }
    }

    public abstract T initialize() throws ConcurrentException;
}
