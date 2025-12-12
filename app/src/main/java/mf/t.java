package mf;

import java.util.Iterator;

/* compiled from: PrimitiveIterators.kt */
/* loaded from: classes2.dex */
public abstract class t implements Iterator<Integer>, ag.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
