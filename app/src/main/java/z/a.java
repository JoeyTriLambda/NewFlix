package z;

import java.util.HashMap;
import java.util.Map;
import z.b;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public final class a<K, V> extends b<K, V> {

    /* renamed from: p, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f22544p = new HashMap<>();

    public Map.Entry<K, V> ceil(K k10) {
        if (contains(k10)) {
            return this.f22544p.get(k10).f22552o;
        }
        return null;
    }

    public boolean contains(K k10) {
        return this.f22544p.containsKey(k10);
    }

    @Override // z.b
    public b.c<K, V> get(K k10) {
        return this.f22544p.get(k10);
    }

    @Override // z.b
    public V putIfAbsent(K k10, V v10) {
        b.c<K, V> cVar = get(k10);
        if (cVar != null) {
            return cVar.f22550m;
        }
        HashMap<K, b.c<K, V>> map = this.f22544p;
        b.c<K, V> cVar2 = new b.c<>(k10, v10);
        this.f22548o++;
        b.c<K, V> cVar3 = this.f22546m;
        if (cVar3 == null) {
            this.f22545b = cVar2;
            this.f22546m = cVar2;
        } else {
            cVar3.f22551n = cVar2;
            cVar2.f22552o = cVar3;
            this.f22546m = cVar2;
        }
        map.put(k10, cVar2);
        return null;
    }

    @Override // z.b
    public V remove(K k10) {
        V v10 = (V) super.remove(k10);
        this.f22544p.remove(k10);
        return v10;
    }
}
