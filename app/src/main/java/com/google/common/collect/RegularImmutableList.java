package com.google.common.collect;

import b8.e;
import java.util.Objects;

/* loaded from: classes.dex */
class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: p, reason: collision with root package name */
    public static final ImmutableList<Object> f9700p = new RegularImmutableList(new Object[0], 0);

    /* renamed from: n, reason: collision with root package name */
    public final transient Object[] f9701n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f9702o;

    public RegularImmutableList(Object[] objArr, int i10) {
        this.f9701n = objArr;
        this.f9702o = i10;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f9701n;
        int i10 = this.f9702o;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return 0 + i10;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] b() {
        return this.f9701n;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int c() {
        return this.f9702o;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d() {
        return 0;
    }

    @Override // java.util.List
    public E get(int i10) {
        e.checkElementIndex(i10, this.f9702o);
        E e10 = (E) this.f9701n[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9702o;
    }
}
