package mf;

import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes2.dex */
public class w {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k10) {
        zf.i.checkNotNullParameter(map, "<this>");
        if (map instanceof v) {
            return (V) ((v) map).getOrImplicitDefault(k10);
        }
        V v10 = map.get(k10);
        if (v10 != null || map.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }
}
