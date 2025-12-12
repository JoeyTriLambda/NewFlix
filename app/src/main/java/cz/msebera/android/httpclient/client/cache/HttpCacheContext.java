package cz.msebera.android.httpclient.client.cache;

import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes2.dex */
public class HttpCacheContext extends HttpClientContext {
    public static final String CACHE_RESPONSE_STATUS = "http.cache.response.status";

    public HttpCacheContext(HttpContext httpContext) {
        super(httpContext);
    }

    public static HttpCacheContext adapt(HttpContext httpContext) {
        return httpContext instanceof HttpCacheContext ? (HttpCacheContext) httpContext : new HttpCacheContext(httpContext);
    }

    public static HttpCacheContext create() {
        return new HttpCacheContext(new BasicHttpContext());
    }

    public CacheResponseStatus getCacheResponseStatus() {
        return (CacheResponseStatus) getAttribute(CACHE_RESPONSE_STATUS, CacheResponseStatus.class);
    }

    public HttpCacheContext() {
    }
}
