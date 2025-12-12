package h3;

import androidx.work.impl.utils.futures.AbstractFuture;
import e8.c;

/* compiled from: SettableFuture.java */
/* loaded from: classes.dex */
public final class a<V> extends AbstractFuture<V> {
    public static <V> a<V> create() {
        return new a<>();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean set(V v10) {
        return super.set(v10);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setFuture(c<? extends V> cVar) {
        return super.setFuture(cVar);
    }
}
