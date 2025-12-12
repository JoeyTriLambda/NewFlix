package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        boolean z10;
        T t10 = this.reference.get();
        if (t10 != null) {
            return t10;
        }
        T tInitialize = initialize();
        AtomicReference<T> atomicReference = this.reference;
        while (true) {
            if (atomicReference.compareAndSet(null, tInitialize)) {
                z10 = true;
                break;
            }
            if (atomicReference.get() != null) {
                z10 = false;
                break;
            }
        }
        return !z10 ? this.reference.get() : tInitialize;
    }

    public abstract T initialize() throws ConcurrentException;
}
