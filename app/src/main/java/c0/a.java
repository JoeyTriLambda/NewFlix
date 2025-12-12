package c0;

import androidx.concurrent.futures.AbstractResolvableFuture;

/* compiled from: ResolvableFuture.java */
/* loaded from: classes.dex */
public final class a<V> extends AbstractResolvableFuture<V> {
    public static <V> a<V> create() {
        return new a<>();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(V v10) {
        return super.set(v10);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }
}
