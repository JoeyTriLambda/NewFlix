package com.google.common.collect;

import b8.e;
import c8.h;
import c8.i;
import c8.j;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final Object[] f9627b = new Object[0];

    public static abstract class a<E> extends b<E> {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f9628a;

        /* renamed from: b, reason: collision with root package name */
        public int f9629b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9630c;

        public a() {
            i.a(4, "initialCapacity");
            this.f9628a = new Object[4];
            this.f9629b = 0;
        }

        public b<E> add(E... eArr) {
            int length = eArr.length;
            h.a(length, eArr);
            int i10 = this.f9629b + length;
            Object[] objArr = this.f9628a;
            if (objArr.length < i10) {
                this.f9628a = Arrays.copyOf(objArr, b.a(objArr.length, i10));
                this.f9630c = false;
            } else if (this.f9630c) {
                this.f9628a = (Object[]) objArr.clone();
                this.f9630c = false;
            }
            System.arraycopy(eArr, 0, this.f9628a, this.f9629b, length);
            this.f9629b += length;
            return this;
        }
    }

    public static abstract class b<E> {
        public static int a(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i10 + (i10 >> 1) + 1;
            if (iHighestOneBit < i11) {
                iHighestOneBit = Integer.highestOneBit(i11 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }
    }

    public int a(Object[] objArr) {
        j<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public Object[] b() {
        return null;
    }

    public int c() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    public int d() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract j<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f9627b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        e.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrB = b();
            if (objArrB != null) {
                return (T[]) Arrays.copyOfRange(objArrB, d(), c(), tArr.getClass());
            }
            tArr = (T[]) h.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr);
        return tArr;
    }
}
