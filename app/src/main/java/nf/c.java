package nf;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import zf.i;

/* compiled from: MapBuilder.kt */
/* loaded from: classes2.dex */
public final class c<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* renamed from: b, reason: collision with root package name */
    public final MapBuilder<K, V> f16824b;

    public c(MapBuilder<K, V> mapBuilder) {
        i.checkNotNullParameter(mapBuilder, "backing");
        this.f16824b = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        i.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f16824b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        return this.f16824b.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // nf.a
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> entry) {
        i.checkNotNullParameter(entry, "element");
        return this.f16824b.containsEntry$kotlin_stdlib(entry);
    }

    @Override // mf.d
    public int getSize() {
        return this.f16824b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f16824b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f16824b.entriesIterator$kotlin_stdlib();
    }

    @Override // nf.a
    public boolean remove(Map.Entry entry) {
        i.checkNotNullParameter(entry, "element");
        return this.f16824b.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f16824b.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        i.checkNotNullParameter(collection, "elements");
        this.f16824b.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry<K, V> entry) {
        i.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }
}
