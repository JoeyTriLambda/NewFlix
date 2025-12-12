package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import mf.d;
import zf.i;

/* compiled from: SetBuilder.kt */
/* loaded from: classes2.dex */
public final class SetBuilder<E> extends d<E> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final MapBuilder<E, ?> f15234b;

    public SetBuilder(MapBuilder<E, ?> mapBuilder) {
        i.checkNotNullParameter(mapBuilder, "backing");
        this.f15234b = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        return this.f15234b.addKey$kotlin_stdlib(e10) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f15234b.checkIsMutable$kotlin_stdlib();
        return super.addAll(collection);
    }

    public final Set<E> build() {
        this.f15234b.build();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f15234b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f15234b.containsKey(obj);
    }

    @Override // mf.d
    public int getSize() {
        return this.f15234b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f15234b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f15234b.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f15234b.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f15234b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f15234b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    public SetBuilder() {
        this(new MapBuilder());
    }
}
