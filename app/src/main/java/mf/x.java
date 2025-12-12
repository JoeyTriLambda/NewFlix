package mf;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

/* compiled from: MapsJVM.kt */
/* loaded from: classes2.dex */
public class x extends w {
    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        zf.i.checkNotNullParameter(map, "builder");
        return ((MapBuilder) map).build();
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder();
    }

    public static final int mapCapacity(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        zf.i.checkNotNullParameter(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        zf.i.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        zf.i.checkNotNullParameter(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        zf.i.checkNotNullExpressionValue(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
