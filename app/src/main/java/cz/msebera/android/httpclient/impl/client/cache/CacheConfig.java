package cz.msebera.android.httpclient.impl.client.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import cz.msebera.android.httpclient.util.Args;

/* loaded from: classes2.dex */
public class CacheConfig implements Cloneable {
    public static final CacheConfig DEFAULT = new Builder().build();
    public static final boolean DEFAULT_303_CACHING_ENABLED = false;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_CORE = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_MAX = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKER_IDLE_LIFETIME_SECS = 60;
    public static final boolean DEFAULT_HEURISTIC_CACHING_ENABLED = false;
    public static final float DEFAULT_HEURISTIC_COEFFICIENT = 0.1f;
    public static final long DEFAULT_HEURISTIC_LIFETIME = 0;
    public static final int DEFAULT_MAX_CACHE_ENTRIES = 1000;
    public static final int DEFAULT_MAX_OBJECT_SIZE_BYTES = 8192;
    public static final int DEFAULT_MAX_UPDATE_RETRIES = 1;
    public static final int DEFAULT_REVALIDATION_QUEUE_SIZE = 100;
    public static final boolean DEFAULT_WEAK_ETAG_ON_PUTDELETE_ALLOWED = false;
    private final boolean allow303Caching;
    private int asynchronousWorkerIdleLifetimeSecs;
    private int asynchronousWorkersCore;
    private int asynchronousWorkersMax;
    private boolean heuristicCachingEnabled;
    private float heuristicCoefficient;
    private long heuristicDefaultLifetime;
    private boolean isSharedCache;
    private int maxCacheEntries;
    private long maxObjectSize;
    private int maxUpdateRetries;
    private boolean neverCacheHTTP10ResponsesWithQuery;
    private int revalidationQueueSize;
    private final boolean weakETagOnPutDeleteAllowed;

    public static class Builder {
        private boolean neverCacheHTTP10ResponsesWithQuery;
        private long maxObjectSize = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        private int maxCacheEntries = 1000;
        private int maxUpdateRetries = 1;
        private boolean allow303Caching = false;
        private boolean weakETagOnPutDeleteAllowed = false;
        private boolean heuristicCachingEnabled = false;
        private float heuristicCoefficient = 0.1f;
        private long heuristicDefaultLifetime = 0;
        private boolean isSharedCache = true;
        private int asynchronousWorkersMax = 1;
        private int asynchronousWorkersCore = 1;
        private int asynchronousWorkerIdleLifetimeSecs = 60;
        private int revalidationQueueSize = 100;

        public CacheConfig build() {
            return new CacheConfig(this.maxObjectSize, this.maxCacheEntries, this.maxUpdateRetries, this.allow303Caching, this.weakETagOnPutDeleteAllowed, this.heuristicCachingEnabled, this.heuristicCoefficient, this.heuristicDefaultLifetime, this.isSharedCache, this.asynchronousWorkersMax, this.asynchronousWorkersCore, this.asynchronousWorkerIdleLifetimeSecs, this.revalidationQueueSize, this.neverCacheHTTP10ResponsesWithQuery);
        }

        public Builder setAllow303Caching(boolean z10) {
            this.allow303Caching = z10;
            return this;
        }

        public Builder setAsynchronousWorkerIdleLifetimeSecs(int i10) {
            this.asynchronousWorkerIdleLifetimeSecs = i10;
            return this;
        }

        public Builder setAsynchronousWorkersCore(int i10) {
            this.asynchronousWorkersCore = i10;
            return this;
        }

        public Builder setAsynchronousWorkersMax(int i10) {
            this.asynchronousWorkersMax = i10;
            return this;
        }

        public Builder setHeuristicCachingEnabled(boolean z10) {
            this.heuristicCachingEnabled = z10;
            return this;
        }

        public Builder setHeuristicCoefficient(float f10) {
            this.heuristicCoefficient = f10;
            return this;
        }

        public Builder setHeuristicDefaultLifetime(long j10) {
            this.heuristicDefaultLifetime = j10;
            return this;
        }

        public Builder setMaxCacheEntries(int i10) {
            this.maxCacheEntries = i10;
            return this;
        }

        public Builder setMaxObjectSize(long j10) {
            this.maxObjectSize = j10;
            return this;
        }

        public Builder setMaxUpdateRetries(int i10) {
            this.maxUpdateRetries = i10;
            return this;
        }

        public Builder setNeverCacheHTTP10ResponsesWithQueryString(boolean z10) {
            this.neverCacheHTTP10ResponsesWithQuery = z10;
            return this;
        }

        public Builder setRevalidationQueueSize(int i10) {
            this.revalidationQueueSize = i10;
            return this;
        }

        public Builder setSharedCache(boolean z10) {
            this.isSharedCache = z10;
            return this;
        }

        public Builder setWeakETagOnPutDeleteAllowed(boolean z10) {
            this.weakETagOnPutDeleteAllowed = z10;
            return this;
        }
    }

    @Deprecated
    public CacheConfig() {
        this.maxObjectSize = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxCacheEntries = 1000;
        this.maxUpdateRetries = 1;
        this.allow303Caching = false;
        this.weakETagOnPutDeleteAllowed = false;
        this.heuristicCachingEnabled = false;
        this.heuristicCoefficient = 0.1f;
        this.heuristicDefaultLifetime = 0L;
        this.isSharedCache = true;
        this.asynchronousWorkersMax = 1;
        this.asynchronousWorkersCore = 1;
        this.asynchronousWorkerIdleLifetimeSecs = 60;
        this.revalidationQueueSize = 100;
    }

    public static Builder copy(CacheConfig cacheConfig) {
        Args.notNull(cacheConfig, "Cache config");
        return new Builder().setMaxObjectSize(cacheConfig.getMaxObjectSize()).setMaxCacheEntries(cacheConfig.getMaxCacheEntries()).setMaxUpdateRetries(cacheConfig.getMaxUpdateRetries()).setHeuristicCachingEnabled(cacheConfig.isHeuristicCachingEnabled()).setHeuristicCoefficient(cacheConfig.getHeuristicCoefficient()).setHeuristicDefaultLifetime(cacheConfig.getHeuristicDefaultLifetime()).setSharedCache(cacheConfig.isSharedCache()).setAsynchronousWorkersMax(cacheConfig.getAsynchronousWorkersMax()).setAsynchronousWorkersCore(cacheConfig.getAsynchronousWorkersCore()).setAsynchronousWorkerIdleLifetimeSecs(cacheConfig.getAsynchronousWorkerIdleLifetimeSecs()).setRevalidationQueueSize(cacheConfig.getRevalidationQueueSize()).setNeverCacheHTTP10ResponsesWithQueryString(cacheConfig.isNeverCacheHTTP10ResponsesWithQuery());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getAsynchronousWorkerIdleLifetimeSecs() {
        return this.asynchronousWorkerIdleLifetimeSecs;
    }

    public int getAsynchronousWorkersCore() {
        return this.asynchronousWorkersCore;
    }

    public int getAsynchronousWorkersMax() {
        return this.asynchronousWorkersMax;
    }

    public float getHeuristicCoefficient() {
        return this.heuristicCoefficient;
    }

    public long getHeuristicDefaultLifetime() {
        return this.heuristicDefaultLifetime;
    }

    public int getMaxCacheEntries() {
        return this.maxCacheEntries;
    }

    public long getMaxObjectSize() {
        return this.maxObjectSize;
    }

    @Deprecated
    public int getMaxObjectSizeBytes() {
        long j10 = this.maxObjectSize;
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    public int getMaxUpdateRetries() {
        return this.maxUpdateRetries;
    }

    public int getRevalidationQueueSize() {
        return this.revalidationQueueSize;
    }

    public boolean is303CachingEnabled() {
        return this.allow303Caching;
    }

    public boolean isHeuristicCachingEnabled() {
        return this.heuristicCachingEnabled;
    }

    public boolean isNeverCacheHTTP10ResponsesWithQuery() {
        return this.neverCacheHTTP10ResponsesWithQuery;
    }

    public boolean isSharedCache() {
        return this.isSharedCache;
    }

    public boolean isWeakETagOnPutDeleteAllowed() {
        return this.weakETagOnPutDeleteAllowed;
    }

    @Deprecated
    public void setAsynchronousWorkerIdleLifetimeSecs(int i10) {
        this.asynchronousWorkerIdleLifetimeSecs = i10;
    }

    @Deprecated
    public void setAsynchronousWorkersCore(int i10) {
        this.asynchronousWorkersCore = i10;
    }

    @Deprecated
    public void setAsynchronousWorkersMax(int i10) {
        this.asynchronousWorkersMax = i10;
    }

    @Deprecated
    public void setHeuristicCachingEnabled(boolean z10) {
        this.heuristicCachingEnabled = z10;
    }

    @Deprecated
    public void setHeuristicCoefficient(float f10) {
        this.heuristicCoefficient = f10;
    }

    @Deprecated
    public void setHeuristicDefaultLifetime(long j10) {
        this.heuristicDefaultLifetime = j10;
    }

    @Deprecated
    public void setMaxCacheEntries(int i10) {
        this.maxCacheEntries = i10;
    }

    @Deprecated
    public void setMaxObjectSize(long j10) {
        this.maxObjectSize = j10;
    }

    @Deprecated
    public void setMaxObjectSizeBytes(int i10) {
        if (i10 > Integer.MAX_VALUE) {
            this.maxObjectSize = 2147483647L;
        } else {
            this.maxObjectSize = i10;
        }
    }

    @Deprecated
    public void setMaxUpdateRetries(int i10) {
        this.maxUpdateRetries = i10;
    }

    @Deprecated
    public void setRevalidationQueueSize(int i10) {
        this.revalidationQueueSize = i10;
    }

    @Deprecated
    public void setSharedCache(boolean z10) {
        this.isSharedCache = z10;
    }

    public String toString() {
        return "[maxObjectSize=" + this.maxObjectSize + ", maxCacheEntries=" + this.maxCacheEntries + ", maxUpdateRetries=" + this.maxUpdateRetries + ", 303CachingEnabled=" + this.allow303Caching + ", weakETagOnPutDeleteAllowed=" + this.weakETagOnPutDeleteAllowed + ", heuristicCachingEnabled=" + this.heuristicCachingEnabled + ", heuristicCoefficient=" + this.heuristicCoefficient + ", heuristicDefaultLifetime=" + this.heuristicDefaultLifetime + ", isSharedCache=" + this.isSharedCache + ", asynchronousWorkersMax=" + this.asynchronousWorkersMax + ", asynchronousWorkersCore=" + this.asynchronousWorkersCore + ", asynchronousWorkerIdleLifetimeSecs=" + this.asynchronousWorkerIdleLifetimeSecs + ", revalidationQueueSize=" + this.revalidationQueueSize + ", neverCacheHTTP10ResponsesWithQuery=" + this.neverCacheHTTP10ResponsesWithQuery + "]";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CacheConfig m29clone() throws CloneNotSupportedException {
        return (CacheConfig) super.clone();
    }

    public CacheConfig(long j10, int i10, int i11, boolean z10, boolean z11, boolean z12, float f10, long j11, boolean z13, int i12, int i13, int i14, int i15, boolean z14) {
        this.maxObjectSize = j10;
        this.maxCacheEntries = i10;
        this.maxUpdateRetries = i11;
        this.allow303Caching = z10;
        this.weakETagOnPutDeleteAllowed = z11;
        this.heuristicCachingEnabled = z12;
        this.heuristicCoefficient = f10;
        this.heuristicDefaultLifetime = j11;
        this.isSharedCache = z13;
        this.asynchronousWorkersMax = i12;
        this.asynchronousWorkersCore = i13;
        this.asynchronousWorkerIdleLifetimeSecs = i14;
        this.revalidationQueueSize = i15;
    }
}
