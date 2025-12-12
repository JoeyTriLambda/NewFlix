package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
class ResourceReference extends PhantomReference<HttpCacheEntry> {
    private final Resource resource;

    public ResourceReference(HttpCacheEntry httpCacheEntry, ReferenceQueue<HttpCacheEntry> referenceQueue) {
        super(httpCacheEntry, referenceQueue);
        Args.notNull(httpCacheEntry.getResource(), "Resource");
        this.resource = httpCacheEntry.getResource();
    }

    public boolean equals(Object obj) {
        return this.resource.equals(obj);
    }

    public Resource getResource() {
        return this.resource;
    }

    public int hashCode() {
        return this.resource.hashCode();
    }
}
