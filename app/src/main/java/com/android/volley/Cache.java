package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface Cache {

    public static class Entry {
        public List<Header> allResponseHeaders;
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, String> responseHeaders = Collections.emptyMap();
        public long serverDate;
        public long softTtl;
        public long ttl;

        public boolean isExpired() {
            return isExpired(System.currentTimeMillis());
        }

        public boolean refreshNeeded() {
            return refreshNeeded(System.currentTimeMillis());
        }

        public boolean isExpired(long j10) {
            return this.ttl < j10;
        }

        public boolean refreshNeeded(long j10) {
            return this.softTtl < j10;
        }
    }

    void clear();

    Entry get(String str);

    void initialize();

    void invalidate(String str, boolean z10);

    void put(String str, Entry entry);

    void remove(String str);
}
