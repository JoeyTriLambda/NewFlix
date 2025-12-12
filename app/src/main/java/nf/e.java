package nf;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import zf.i;

/* compiled from: MapBuilder.kt */
/* loaded from: classes2.dex */
public final class e<V> extends mf.b<V> {

    /* renamed from: b, reason: collision with root package name */
    public final MapBuilder<?, V> f16826b;

    public e(MapBuilder<?, V> mapBuilder) {
        i.checkNotNullParameter(mapBuilder, "backing");
        this.f16826b = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        i.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f16826b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f16826b.containsValue(obj);
    }

    @Override // mf.b
    public int getSize() {
        return this.f16826b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f16826b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.f16826b.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f16826b.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f16826b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f16826b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
