package nf;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import zf.i;

/* compiled from: MapBuilder.kt */
/* loaded from: classes2.dex */
public final class d<E> extends mf.d<E> {

    /* renamed from: b, reason: collision with root package name */
    public final MapBuilder<E, ?> f16825b;

    public d(MapBuilder<E, ?> mapBuilder) {
        i.checkNotNullParameter(mapBuilder, "backing");
        this.f16825b = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        i.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f16825b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f16825b.containsKey(obj);
    }

    @Override // mf.d
    public int getSize() {
        return this.f16825b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f16825b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f16825b.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f16825b.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f16825b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f16825b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
