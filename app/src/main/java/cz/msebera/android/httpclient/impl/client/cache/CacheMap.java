package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class CacheMap extends LinkedHashMap<String, HttpCacheEntry> {
    private static final long serialVersionUID = -7750025207539768511L;
    private final int maxEntries;

    public CacheMap(int i10) {
        super(20, 0.75f, true);
        this.maxEntries = i10;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, HttpCacheEntry> entry) {
        return size() > this.maxEntries;
    }
}
