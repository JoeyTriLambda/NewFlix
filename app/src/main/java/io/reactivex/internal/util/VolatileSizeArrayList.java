package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<T> f14551b = new ArrayList<>();

    @Override // java.util.List, java.util.Collection
    public boolean add(T t10) {
        ArrayList<T> arrayList = this.f14551b;
        boolean zAdd = arrayList.add(t10);
        lazySet(arrayList.size());
        return zAdd;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        ArrayList<T> arrayList = this.f14551b;
        boolean zAddAll = arrayList.addAll(collection);
        lazySet(arrayList.size());
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f14551b.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f14551b.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f14551b.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        boolean z10 = obj instanceof VolatileSizeArrayList;
        ArrayList<T> arrayList = this.f14551b;
        return z10 ? arrayList.equals(((VolatileSizeArrayList) obj).f14551b) : arrayList.equals(obj);
    }

    @Override // java.util.List
    public T get(int i10) {
        return this.f14551b.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f14551b.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f14551b.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f14551b.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f14551b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.f14551b.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        ArrayList<T> arrayList = this.f14551b;
        boolean zRemove = arrayList.remove(obj);
        lazySet(arrayList.size());
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        ArrayList<T> arrayList = this.f14551b;
        boolean zRemoveAll = arrayList.removeAll(collection);
        lazySet(arrayList.size());
        return zRemoveAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        ArrayList<T> arrayList = this.f14551b;
        boolean zRetainAll = arrayList.retainAll(collection);
        lazySet(arrayList.size());
        return zRetainAll;
    }

    @Override // java.util.List
    public T set(int i10, T t10) {
        return this.f14551b.set(i10, t10);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i10, int i11) {
        return this.f14551b.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f14551b.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f14551b.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i10) {
        return this.f14551b.listIterator(i10);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.f14551b.toArray(eArr);
    }

    @Override // java.util.List
    public void add(int i10, T t10) {
        ArrayList<T> arrayList = this.f14551b;
        arrayList.add(i10, t10);
        lazySet(arrayList.size());
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends T> collection) {
        ArrayList<T> arrayList = this.f14551b;
        boolean zAddAll = arrayList.addAll(i10, collection);
        lazySet(arrayList.size());
        return zAddAll;
    }

    @Override // java.util.List
    public T remove(int i10) {
        ArrayList<T> arrayList = this.f14551b;
        T tRemove = arrayList.remove(i10);
        lazySet(arrayList.size());
        return tRemove;
    }
}
