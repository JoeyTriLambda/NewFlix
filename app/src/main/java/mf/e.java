package mf;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public final class e<T> implements Collection<T>, ag.a {

    /* renamed from: b, reason: collision with root package name */
    public final T[] f16301b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f16302m;

    public e(T[] tArr, boolean z10) {
        zf.i.checkNotNullParameter(tArr, "values");
        this.f16301b = tArr;
        this.f16302m = z10;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return i.contains(this.f16301b, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        zf.i.checkNotNullParameter(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.f16301b.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f16301b.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return zf.b.iterator(this.f16301b);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "array");
        return (T[]) zf.e.toArray(this, tArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return j.copyToArrayOfAny(this.f16301b, this.f16302m);
    }
}
