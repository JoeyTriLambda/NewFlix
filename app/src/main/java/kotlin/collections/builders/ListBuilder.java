package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import mf.c;
import mf.f;
import mf.h;
import nf.b;
import zf.i;

/* compiled from: ListBuilder.kt */
/* loaded from: classes2.dex */
public final class ListBuilder<E> extends c<E> implements RandomAccess, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public E[] f15207b;

    /* renamed from: m, reason: collision with root package name */
    public final int f15208m;

    /* renamed from: n, reason: collision with root package name */
    public int f15209n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15210o;

    /* renamed from: p, reason: collision with root package name */
    public final ListBuilder<E> f15211p;

    /* renamed from: q, reason: collision with root package name */
    public final ListBuilder<E> f15212q;

    /* compiled from: ListBuilder.kt */
    public static final class a<E> implements ListIterator<E>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public final ListBuilder<E> f15213b;

        /* renamed from: m, reason: collision with root package name */
        public int f15214m;

        /* renamed from: n, reason: collision with root package name */
        public int f15215n;

        public a(ListBuilder<E> listBuilder, int i10) {
            i.checkNotNullParameter(listBuilder, "list");
            this.f15213b = listBuilder;
            this.f15214m = i10;
            this.f15215n = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            int i10 = this.f15214m;
            this.f15214m = i10 + 1;
            this.f15213b.add(i10, e10);
            this.f15215n = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f15214m < this.f15213b.f15209n;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f15214m > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            int i10 = this.f15214m;
            ListBuilder<E> listBuilder = this.f15213b;
            if (i10 >= listBuilder.f15209n) {
                throw new NoSuchElementException();
            }
            int i11 = this.f15214m;
            this.f15214m = i11 + 1;
            this.f15215n = i11;
            return (E) listBuilder.f15207b[listBuilder.f15208m + this.f15215n];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f15214m;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i10 = this.f15214m;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f15214m = i11;
            this.f15215n = i11;
            ListBuilder<E> listBuilder = this.f15213b;
            return (E) listBuilder.f15207b[listBuilder.f15208m + this.f15215n];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f15214m - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i10 = this.f15215n;
            if (!(i10 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f15213b.remove(i10);
            this.f15214m = this.f15215n;
            this.f15215n = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            int i10 = this.f15215n;
            if (!(i10 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f15213b.set(i10, e10);
        }
    }

    public ListBuilder(E[] eArr, int i10, int i11, boolean z10, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f15207b = eArr;
        this.f15208m = i10;
        this.f15209n = i11;
        this.f15210o = z10;
        this.f15211p = listBuilder;
        this.f15212q = listBuilder2;
    }

    public final void a(int i10, Collection<? extends E> collection, int i11) {
        ListBuilder<E> listBuilder = this.f15211p;
        if (listBuilder != null) {
            listBuilder.a(i10, collection, i11);
            this.f15207b = listBuilder.f15207b;
            this.f15209n += i11;
        } else {
            d(i10, i11);
            Iterator<? extends E> it = collection.iterator();
            for (int i12 = 0; i12 < i11; i12++) {
                this.f15207b[i10 + i12] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        c();
        b(this.f15208m + this.f15209n, e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        i.checkNotNullParameter(collection, "elements");
        c();
        int size = collection.size();
        a(this.f15208m + this.f15209n, collection, size);
        return size > 0;
    }

    public final void b(int i10, E e10) {
        ListBuilder<E> listBuilder = this.f15211p;
        if (listBuilder == null) {
            d(i10, 1);
            this.f15207b[i10] = e10;
        } else {
            listBuilder.b(i10, e10);
            this.f15207b = listBuilder.f15207b;
            this.f15209n++;
        }
    }

    public final List<E> build() {
        if (this.f15211p != null) {
            throw new IllegalStateException();
        }
        c();
        this.f15210o = true;
        return this;
    }

    public final void c() {
        ListBuilder<E> listBuilder;
        if (this.f15210o || ((listBuilder = this.f15212q) != null && listBuilder.f15210o)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        f(this.f15208m, this.f15209n);
    }

    public final void d(int i10, int i11) {
        int i12 = this.f15209n + i11;
        if (this.f15211p != null) {
            throw new IllegalStateException();
        }
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f15207b;
        if (i12 > eArr.length) {
            this.f15207b = (E[]) b.copyOfUninitializedElements(this.f15207b, f.f16303o.newCapacity$kotlin_stdlib(eArr.length, i12));
        }
        E[] eArr2 = this.f15207b;
        h.copyInto(eArr2, eArr2, i10 + i11, i10, this.f15208m + this.f15209n);
        this.f15209n += i11;
    }

    public final E e(int i10) {
        ListBuilder<E> listBuilder = this.f15211p;
        if (listBuilder != null) {
            this.f15209n--;
            return listBuilder.e(i10);
        }
        E[] eArr = this.f15207b;
        E e10 = eArr[i10];
        h.copyInto(eArr, eArr, i10, i10 + 1, this.f15209n + this.f15208m);
        b.resetAt(this.f15207b, (r4 + this.f15209n) - 1);
        this.f15209n--;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                if (b.access$subarrayContentEquals(this.f15207b, this.f15208m, this.f15209n, (List) obj)) {
                }
            }
            return false;
        }
        return true;
    }

    public final void f(int i10, int i11) {
        ListBuilder<E> listBuilder = this.f15211p;
        if (listBuilder != null) {
            listBuilder.f(i10, i11);
        } else {
            E[] eArr = this.f15207b;
            h.copyInto(eArr, eArr, i10, i10 + i11, this.f15209n);
            E[] eArr2 = this.f15207b;
            int i12 = this.f15209n;
            b.resetRange(eArr2, i12 - i11, i12);
        }
        this.f15209n -= i11;
    }

    public final int g(int i10, int i11, Collection<? extends E> collection, boolean z10) {
        ListBuilder<E> listBuilder = this.f15211p;
        if (listBuilder != null) {
            int iG = listBuilder.g(i10, i11, collection, z10);
            this.f15209n -= iG;
            return iG;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.f15207b[i14]) == z10) {
                E[] eArr = this.f15207b;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.f15207b;
        h.copyInto(eArr2, eArr2, i10 + i13, i11 + i10, this.f15209n);
        E[] eArr3 = this.f15207b;
        int i16 = this.f15209n;
        b.resetRange(eArr3, i16 - i15, i16);
        this.f15209n -= i15;
        return i15;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        mf.a.f16294b.checkElementIndex$kotlin_stdlib(i10, this.f15209n);
        return this.f15207b[this.f15208m + i10];
    }

    @Override // mf.c
    public int getSize() {
        return this.f15209n;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return b.access$subarrayContentHashCode(this.f15207b, this.f15208m, this.f15209n);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f15209n; i10++) {
            if (i.areEqual(this.f15207b[this.f15208m + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f15209n == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i10 = this.f15209n - 1; i10 >= 0; i10--) {
            if (i.areEqual(this.f15207b[this.f15208m + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        c();
        return g(this.f15208m, this.f15209n, collection, false) > 0;
    }

    @Override // mf.c
    public E removeAt(int i10) {
        c();
        mf.a.f16294b.checkElementIndex$kotlin_stdlib(i10, this.f15209n);
        return e(this.f15208m + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        c();
        return g(this.f15208m, this.f15209n, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        c();
        mf.a.f16294b.checkElementIndex$kotlin_stdlib(i10, this.f15209n);
        E[] eArr = this.f15207b;
        int i11 = this.f15208m;
        E e11 = eArr[i11 + i10];
        eArr[i11 + i10] = e10;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i10, int i11) {
        mf.a.f16294b.checkRangeIndexes$kotlin_stdlib(i10, i11, this.f15209n);
        E[] eArr = this.f15207b;
        int i12 = this.f15208m + i10;
        int i13 = i11 - i10;
        boolean z10 = this.f15210o;
        ListBuilder<E> listBuilder = this.f15212q;
        return new ListBuilder(eArr, i12, i13, z10, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        i.checkNotNullParameter(tArr, "destination");
        int length = tArr.length;
        int i10 = this.f15209n;
        int i11 = this.f15208m;
        if (length < i10) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(this.f15207b, i11, i10 + i11, tArr.getClass());
            i.checkNotNullExpressionValue(tArr2, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr2;
        }
        h.copyInto(this.f15207b, tArr, 0, i11, i10 + i11);
        int length2 = tArr.length;
        int i12 = this.f15209n;
        if (length2 > i12) {
            tArr[i12] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return b.access$subarrayContentToString(this.f15207b, this.f15208m, this.f15209n);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i10) {
        mf.a.f16294b.checkPositionIndex$kotlin_stdlib(i10, this.f15209n);
        return new a(this, i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        c();
        mf.a.f16294b.checkPositionIndex$kotlin_stdlib(i10, this.f15209n);
        b(this.f15208m + i10, e10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        i.checkNotNullParameter(collection, "elements");
        c();
        mf.a.f16294b.checkPositionIndex$kotlin_stdlib(i10, this.f15209n);
        int size = collection.size();
        a(this.f15208m + i10, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        E[] eArr = this.f15207b;
        int i10 = this.f15209n;
        int i11 = this.f15208m;
        return h.copyOfRange(eArr, i11, i10 + i11);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i10) {
        this(b.arrayOfUninitializedElements(i10), 0, 0, false, null, null);
    }
}
