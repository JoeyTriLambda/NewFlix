package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> {
    private static final long serialVersionUID = 0;

    public static final class a<K, V> extends ImmutableMultimap.a<K, V> {
        public ImmutableSetMultimap<K, V> build() {
            Set<Map.Entry<K, Collection<V>>> setEntrySet = this.f9646a.entrySet();
            if (setEntrySet.isEmpty()) {
                return ImmutableSetMultimap.of();
            }
            ImmutableMap.a aVar = new ImmutableMap.a(setEntrySet.size());
            int size = 0;
            for (Map.Entry<K, Collection<V>> entry : setEntrySet) {
                K key = entry.getKey();
                ImmutableSet immutableSetCopyOf = ImmutableSet.copyOf((Collection) entry.getValue());
                if (!immutableSetCopyOf.isEmpty()) {
                    aVar.put(key, immutableSetCopyOf);
                    size += immutableSetCopyOf.size();
                }
            }
            return new ImmutableSetMultimap<>(aVar.buildOrThrow(), size);
        }
    }

    public ImmutableSetMultimap(ImmutableMap immutableMap, int i10) {
        super(immutableMap);
        ImmutableSet.of();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.f9626m;
    }
}
