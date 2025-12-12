package mf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractCollection;

/* compiled from: AbstractList.kt */
/* loaded from: classes2.dex */
public abstract class a<E> extends AbstractCollection<E> implements List<E> {

    /* renamed from: b, reason: collision with root package name */
    public static final C0202a f16294b = new C0202a(null);

    /* compiled from: AbstractList.kt */
    /* renamed from: mf.a$a, reason: collision with other inner class name */
    public static final class C0202a {
        public C0202a(zf.f fVar) {
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                StringBuilder sbT = ac.c.t("startIndex: ", i10, ", endIndex: ", i11, ", size: ");
                sbT.append(i12);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(ac.c.g("startIndex: ", i10, " > endIndex: ", i11));
            }
        }

        public final void checkElementIndex$kotlin_stdlib(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException(ac.c.g("index: ", i10, ", size: ", i11));
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException(ac.c.g("index: ", i10, ", size: ", i11));
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                StringBuilder sbT = ac.c.t("fromIndex: ", i10, ", toIndex: ", i11, ", size: ");
                sbT.append(i12);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(ac.c.g("fromIndex: ", i10, " > toIndex: ", i11));
            }
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
            zf.i.checkNotNullParameter(collection, "c");
            zf.i.checkNotNullParameter(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!zf.i.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
            zf.i.checkNotNullParameter(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* compiled from: AbstractList.kt */
    public class b implements Iterator<E>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public int f16295b;

        public b() {
        }

        public final int getIndex() {
            return this.f16295b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16295b < a.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f16295b;
            this.f16295b = i10 + 1;
            return a.this.get(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.f16295b = i10;
        }
    }

    /* compiled from: AbstractList.kt */
    public class c extends a<E>.b implements ListIterator<E> {
        public c(int i10) {
            super();
            a.f16294b.checkPositionIndex$kotlin_stdlib(i10, a.this.size());
            setIndex(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return getIndex() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return getIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            setIndex(getIndex() - 1);
            return a.this.get(getIndex());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return getIndex() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    public static final class d<E> extends a<E> implements RandomAccess {

        /* renamed from: m, reason: collision with root package name */
        public final a<E> f16298m;

        /* renamed from: n, reason: collision with root package name */
        public final int f16299n;

        /* renamed from: o, reason: collision with root package name */
        public final int f16300o;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a<? extends E> aVar, int i10, int i11) {
            zf.i.checkNotNullParameter(aVar, "list");
            this.f16298m = aVar;
            this.f16299n = i10;
            a.f16294b.checkRangeIndexes$kotlin_stdlib(i10, i11, aVar.size());
            this.f16300o = i11 - i10;
        }

        @Override // mf.a, java.util.List
        public E get(int i10) {
            a.f16294b.checkElementIndex$kotlin_stdlib(i10, this.f16300o);
            return this.f16298m.get(this.f16299n + i10);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f16300o;
        }
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f16294b.orderedEquals$kotlin_stdlib(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f16294b.orderedHashCode$kotlin_stdlib(this);
    }

    public int indexOf(E e10) {
        Iterator<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (zf.i.areEqual(it.next(), e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zf.i.areEqual(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
