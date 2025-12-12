package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: m, reason: collision with root package name */
    public static final MapFieldLite f2371m;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2372b;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        f2371m = mapFieldLite;
        mapFieldLite.makeImmutable();
    }

    private MapFieldLite() {
        this.f2372b = true;
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return f2371m;
    }

    public final void a() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        a();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        boolean z10;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this != map) {
            if (size() == map.size()) {
                for (Map.Entry<K, V> entry : entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        V value = entry.getValue();
                        Object obj2 = map.get(entry.getKey());
                        if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                        }
                    }
                }
                z10 = true;
            }
            z10 = false;
            break;
        }
        z10 = true;
        return z10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iHashCode;
        int iHashCode2;
        int i10 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            K key = entry.getKey();
            if (key instanceof byte[]) {
                iHashCode = w.hashCode((byte[]) key);
            } else {
                if (key instanceof w.c) {
                    throw new UnsupportedOperationException();
                }
                iHashCode = key.hashCode();
            }
            V value = entry.getValue();
            if (value instanceof byte[]) {
                iHashCode2 = w.hashCode((byte[]) value);
            } else {
                if (value instanceof w.c) {
                    throw new UnsupportedOperationException();
                }
                iHashCode2 = value.hashCode();
            }
            i10 += iHashCode2 ^ iHashCode;
        }
        return i10;
    }

    public boolean isMutable() {
        return this.f2372b;
    }

    public void makeImmutable() {
        this.f2372b = false;
    }

    public void mergeFrom(MapFieldLite<K, V> mapFieldLite) {
        a();
        if (mapFieldLite.isEmpty()) {
            return;
        }
        putAll(mapFieldLite);
    }

    public MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        a();
        Charset charset = w.f2545a;
        k10.getClass();
        v10.getClass();
        return (V) super.put(k10, v10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a();
        for (K k10 : map.keySet()) {
            Charset charset = w.f2545a;
            k10.getClass();
            map.get(k10).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        a();
        return (V) super.remove(obj);
    }

    public MapFieldLite(Map<K, V> map) {
        super(map);
        this.f2372b = true;
    }
}
