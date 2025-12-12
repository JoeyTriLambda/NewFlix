package com.google.common.collect;

import c8.i;
import c8.j;

/* loaded from: classes.dex */
final class RegularImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: s, reason: collision with root package name */
    public static final Object[] f9717s;

    /* renamed from: t, reason: collision with root package name */
    public static final RegularImmutableSet<Object> f9718t;

    /* renamed from: n, reason: collision with root package name */
    public final transient Object[] f9719n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f9720o;

    /* renamed from: p, reason: collision with root package name */
    public final transient Object[] f9721p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f9722q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f9723r;

    static {
        Object[] objArr = new Object[0];
        f9717s = objArr;
        f9718t = new RegularImmutableSet<>(objArr, 0, objArr, 0, 0);
    }

    public RegularImmutableSet(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f9719n = objArr;
        this.f9720o = i10;
        this.f9721p = objArr2;
        this.f9722q = i11;
        this.f9723r = i12;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f9719n;
        int i10 = this.f9723r;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return 0 + i10;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] b() {
        return this.f9719n;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int c() {
        return this.f9723r;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f9721p;
            if (objArr.length != 0) {
                int iK = i.k(obj);
                while (true) {
                    int i10 = iK & this.f9722q;
                    Object obj2 = objArr[i10];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iK = i10 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public final ImmutableList<E> g() {
        return ImmutableList.e(this.f9723r, this.f9719n);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f9720o;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f9723r;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public j<E> iterator() {
        return asList().iterator();
    }
}
