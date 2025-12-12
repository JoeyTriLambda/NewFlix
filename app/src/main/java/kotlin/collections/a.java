package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import mf.w;
import mf.x;
import zf.i;

/* compiled from: Maps.kt */
/* loaded from: classes2.dex */
public class a extends x {
    public static final <K, V> Map<K, V> emptyMap() {
        EmptyMap emptyMap = EmptyMap.f15205b;
        i.checkNotNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static final <K, V> V getValue(Map<K, ? extends V> map, K k10) {
        i.checkNotNullParameter(map, "<this>");
        return (V) w.getOrImplicitDefaultNullable(map, k10);
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        i.checkNotNullParameter(pairArr, "pairs");
        return pairArr.length > 0 ? toMap(pairArr, new LinkedHashMap(x.mapCapacity(pairArr.length))) : emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        i.checkNotNullParameter(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : x.toSingletonMap(map) : emptyMap();
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        i.checkNotNullParameter(map, "<this>");
        i.checkNotNullParameter(pair, "pair");
        if (map.isEmpty()) {
            return x.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        i.checkNotNullParameter(map, "<this>");
        i.checkNotNullParameter(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        i.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return optimizeReadOnlyMap(toMap(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMap(iterable, new LinkedHashMap(x.mapCapacity(collection.size())));
        }
        return x.mapOf(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        i.checkNotNullParameter(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        i.checkNotNullParameter(map, "<this>");
        i.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        i.checkNotNullParameter(map, "<this>");
        i.checkNotNullParameter(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m10) {
        i.checkNotNullParameter(iterable, "<this>");
        i.checkNotNullParameter(m10, "destination");
        putAll(m10, iterable);
        return m10;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] pairArr, M m10) {
        i.checkNotNullParameter(pairArr, "<this>");
        i.checkNotNullParameter(m10, "destination");
        putAll(m10, pairArr);
        return m10;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        i.checkNotNullParameter(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return x.toSingletonMap(map);
    }
}
