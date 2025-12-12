package com.google.common.collect;

import b8.e;
import c8.i;
import c8.j;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* renamed from: m, reason: collision with root package name */
    public transient ImmutableList<E> f9647m;

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return f(array.length, array);
    }

    public static int e(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            e.checkArgument(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static <E> ImmutableSet<E> f(int i10, Object... objArr) {
        if (i10 == 0) {
            return of();
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int iE = e(i10);
        Object[] objArr2 = new Object[iE];
        int i11 = iE - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object obj2 = objArr[i14];
            if (obj2 == null) {
                StringBuilder sb2 = new StringBuilder(20);
                sb2.append("at index ");
                sb2.append(i14);
                throw new NullPointerException(sb2.toString());
            }
            int iHashCode = obj2.hashCode();
            int iJ = i.j(iHashCode);
            while (true) {
                int i15 = iJ & i11;
                Object obj3 = objArr2[i15];
                if (obj3 == null) {
                    objArr[i13] = obj2;
                    objArr2[i15] = obj2;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iJ++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new SingletonImmutableSet(obj4);
        }
        if (e(i13) < iE / 2) {
            return f(i13, objArr);
        }
        int length = objArr.length;
        if (i13 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new RegularImmutableSet(objArr, i12, objArr2, i11, i13);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.f9718t;
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f9647m;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListG = g();
        this.f9647m = immutableListG;
        return immutableListG;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && (this instanceof RegularImmutableSet)) {
            ImmutableSet immutableSet = (ImmutableSet) obj;
            immutableSet.getClass();
            if ((immutableSet instanceof RegularImmutableSet) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public ImmutableList<E> g() {
        Object[] array = toArray();
        ImmutableList.b bVar = ImmutableList.f9631m;
        return ImmutableList.e(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return i.c(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract j<E> iterator();

    public static <E> ImmutableSet<E> of(E e10) {
        return new SingletonImmutableSet(e10);
    }

    public static <E> ImmutableSet<E> of(E e10, E e11, E e12) {
        return f(3, e10, e11, e12);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        e.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return f(length, objArr);
    }
}
