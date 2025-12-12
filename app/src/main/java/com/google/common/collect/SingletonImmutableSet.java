package com.google.common.collect;

import b8.e;
import c8.j;

/* loaded from: classes.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: n, reason: collision with root package name */
    public final transient E f9724n;

    public SingletonImmutableSet(E e10) {
        this.f9724n = (E) e.checkNotNull(e10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int a(Object[] objArr) {
        objArr[0] = this.f9724n;
        return 1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f9724n.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f9724n.hashCode();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String string = this.f9724n.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 2);
        sb2.append('[');
        sb2.append(string);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public j<E> iterator() {
        return c8.e.singletonIterator(this.f9724n);
    }
}
