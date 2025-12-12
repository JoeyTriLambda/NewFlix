package com.google.common.collect;

import b8.e;
import c8.h;
import c8.j;
import c8.k;
import com.google.common.collect.ImmutableCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: m, reason: collision with root package name */
    public static final b f9631m = new b(RegularImmutableList.f9700p, 0);

    public class SubList extends ImmutableList<E> {

        /* renamed from: n, reason: collision with root package name */
        public final transient int f9632n;

        /* renamed from: o, reason: collision with root package name */
        public final transient int f9633o;

        public SubList(int i10, int i11) {
            this.f9632n = i10;
            this.f9633o = i11;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final Object[] b() {
            return ImmutableList.this.b();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int c() {
            return ImmutableList.this.d() + this.f9632n + this.f9633o;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int d() {
            return ImmutableList.this.d() + this.f9632n;
        }

        @Override // java.util.List
        public E get(int i10) {
            e.checkElementIndex(i10, this.f9633o);
            return ImmutableList.this.get(i10 + this.f9632n);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f9633o;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i10, int i11) {
            e.checkPositionIndexes(i10, i11, this.f9633o);
            int i12 = this.f9632n;
            return ImmutableList.this.subList(i10 + i12, i11 + i12);
        }
    }

    public static final class a<E> extends ImmutableCollection.a<E> {
        @Override // com.google.common.collect.ImmutableCollection.a
        public a<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        public ImmutableList<E> build() {
            this.f9630c = true;
            return ImmutableList.e(this.f9629b, this.f9628a);
        }
    }

    public static class b<E> extends c8.a<E> {

        /* renamed from: n, reason: collision with root package name */
        public final ImmutableList<E> f9635n;

        public b(ImmutableList<E> immutableList, int i10) {
            super(immutableList.size(), i10);
            this.f9635n = immutableList;
        }

        @Override // c8.a
        public E get(int i10) {
            return this.f9635n.get(i10);
        }
    }

    public static ImmutableList e(int i10, Object[] objArr) {
        return i10 == 0 ? of() : new RegularImmutableList(objArr, i10);
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.f9700p;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[0 + i10] = get(i10);
        }
        return 0 + size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == e.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(list instanceof RandomAccess)) {
                    return c8.e.elementsEqual(iterator(), list.iterator());
                }
                for (int i10 = 0; i10 < size; i10++) {
                    if (b8.d.equal(get(i10), list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~(get(i11).hashCode() + (i10 * 31)));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableList<E> of(E e10, E e11) {
        Object[] objArr = {e10, e11};
        h.a(2, objArr);
        return e(2, objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public j<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i10, int i11) {
        e.checkPositionIndexes(i10, i11, size());
        int i12 = i11 - i10;
        return i12 == size() ? this : i12 == 0 ? of() : new SubList(i10, i12);
    }

    @Override // java.util.List
    public k<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12) {
        Object[] objArr = {e10, e11, e12};
        h.a(3, objArr);
        return e(3, objArr);
    }

    @Override // java.util.List
    public k<E> listIterator(int i10) {
        e.checkPositionIndex(i10, size());
        if (isEmpty()) {
            return f9631m;
        }
        return new b(this, i10);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        Object[] objArr = {e10, e11, e12, e13, e14, e15, e16};
        h.a(7, objArr);
        return e(7, objArr);
    }
}
