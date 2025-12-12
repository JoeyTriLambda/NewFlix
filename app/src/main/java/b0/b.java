package b0;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public final class b<K, V> extends k<K, V> implements Map<K, V> {

    /* renamed from: s, reason: collision with root package name */
    public a f4647s;

    public b() {
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f4647s == null) {
            this.f4647s = new a(this);
        }
        return (Set<Map.Entry<K, V>>) this.f4647s.getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (this.f4647s == null) {
            this.f4647s = new a(this);
        }
        return (Set<K>) this.f4647s.getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size() + this.f4695n);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean retainAll(Collection<?> collection) {
        return j.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        if (this.f4647s == null) {
            this.f4647s = new a(this);
        }
        return (Collection<V>) this.f4647s.getValues();
    }

    public b(int i10) {
        super(i10);
    }

    public b(k kVar) {
        super(kVar);
    }
}
