package zf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes2.dex */
public final class a<T> implements Iterator<T>, ag.a {

    /* renamed from: b, reason: collision with root package name */
    public final T[] f22720b;

    /* renamed from: m, reason: collision with root package name */
    public int f22721m;

    public a(T[] tArr) {
        i.checkNotNullParameter(tArr, "array");
        this.f22720b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22721m < this.f22720b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f22720b;
            int i10 = this.f22721m;
            this.f22721m = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f22721m--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
