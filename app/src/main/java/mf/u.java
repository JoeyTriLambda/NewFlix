package mf;

import java.util.Iterator;

/* compiled from: PrimitiveIterators.kt */
/* loaded from: classes2.dex */
public abstract class u implements Iterator<Long>, ag.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
