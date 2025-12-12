package okhttp3.internal.cache;

import ah.c;
import ah.d;
import ah.e;
import ah.m;
import ah.w;
import ah.y;
import ah.z;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.protocol.HTTP;
import ig.l;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import zf.f;
import zf.i;

/* compiled from: CacheInterceptor.kt */
/* loaded from: classes2.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    /* compiled from: CacheInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                String strName = headers.name(i11);
                String strValue = headers.value(i11);
                if ((!l.equals("Warning", strName, true) || !l.startsWith$default(strValue, "1", false, 2, null)) && (isContentSpecificHeader(strName) || !isEndToEnd(strName) || headers2.get(strName) == null)) {
                    builder.addLenient$okhttp(strName, strValue);
                }
                i11 = i12;
            }
            int size2 = headers2.size();
            while (i10 < size2) {
                int i13 = i10 + 1;
                String strName2 = headers2.name(i10);
                if (!isContentSpecificHeader(strName2) && isEndToEnd(strName2)) {
                    builder.addLenient$okhttp(strName2, headers2.value(i10));
                }
                i10 = i13;
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            return l.equals("Content-Length", str, true) || l.equals("Content-Encoding", str, true) || l.equals("Content-Type", str, true);
        }

        private final boolean isEndToEnd(String str) {
            return (l.equals("Connection", str, true) || l.equals(HTTP.CONN_KEEP_ALIVE, str, true) || l.equals("Proxy-Authenticate", str, true) || l.equals("Proxy-Authorization", str, true) || l.equals(HttpHeaders.TE, str, true) || l.equals("Trailers", str, true) || l.equals("Transfer-Encoding", str, true) || l.equals(HttpHeaders.UPGRADE, str, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response == null ? null : response.body()) != null ? response.newBuilder().body(null).build() : response;
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        w wVarBody = cacheRequest.body();
        ResponseBody responseBodyBody = response.body();
        i.checkNotNull(responseBodyBody);
        final e eVarSource = responseBodyBody.source();
        final d dVarBuffer = m.buffer(wVarBody);
        y yVar = new y() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                eVarSource.close();
            }

            @Override // ah.y
            public long read(c cVar, long j10) throws IOException {
                i.checkNotNullParameter(cVar, "sink");
                try {
                    long j11 = eVarSource.read(cVar, j10);
                    if (j11 != -1) {
                        cVar.copyTo(dVarBuffer.getBuffer(), cVar.size() - j11, j11);
                        dVarBuffer.emitCompleteSegments();
                        return j11;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        dVarBuffer.close();
                    }
                    return -1L;
                } catch (IOException e10) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e10;
                }
            }

            @Override // ah.y
            public z timeout() {
                return eVarSource.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), m.buffer(yVar))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ResponseBody responseBodyBody;
        ResponseBody responseBodyBody2;
        i.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        Response response = cache == null ? null : cache.get$okhttp(chain.request());
        CacheStrategy cacheStrategyCompute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = cacheStrategyCompute.getNetworkRequest();
        Response cacheResponse = cacheStrategyCompute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(cacheStrategyCompute);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        EventListener eventListener$okhttp = realCall != null ? realCall.getEventListener$okhttp() : null;
        if (eventListener$okhttp == null) {
            eventListener$okhttp = EventListener.NONE;
        }
        if (response != null && cacheResponse == null && (responseBodyBody2 = response.body()) != null) {
            Util.closeQuietly(responseBodyBody2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response responseBuild = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(HttpStatus.SC_GATEWAY_TIMEOUT).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener$okhttp.satisfactionFailure(call, responseBuild);
            return responseBuild;
        }
        if (networkRequest == null) {
            i.checkNotNull(cacheResponse);
            Response responseBuild2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener$okhttp.cacheHit(call, responseBuild2);
            return responseBuild2;
        }
        if (cacheResponse != null) {
            eventListener$okhttp.cacheConditionalHit(call, cacheResponse);
        } else if (this.cache != null) {
            eventListener$okhttp.cacheMiss(call);
        }
        try {
            Response responseProceed = chain.proceed(networkRequest);
            if (responseProceed == null && response != null && responseBodyBody != null) {
            }
            if (cacheResponse != null) {
                boolean z10 = false;
                if (responseProceed != null && responseProceed.code() == 304) {
                    z10 = true;
                }
                if (z10) {
                    Response.Builder builderNewBuilder = cacheResponse.newBuilder();
                    Companion companion = Companion;
                    Response responseBuild3 = builderNewBuilder.headers(companion.combine(cacheResponse.headers(), responseProceed.headers())).sentRequestAtMillis(responseProceed.sentRequestAtMillis()).receivedResponseAtMillis(responseProceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(responseProceed)).build();
                    ResponseBody responseBodyBody3 = responseProceed.body();
                    i.checkNotNull(responseBodyBody3);
                    responseBodyBody3.close();
                    Cache cache3 = this.cache;
                    i.checkNotNull(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, responseBuild3);
                    eventListener$okhttp.cacheHit(call, responseBuild3);
                    return responseBuild3;
                }
                ResponseBody responseBodyBody4 = cacheResponse.body();
                if (responseBodyBody4 != null) {
                    Util.closeQuietly(responseBodyBody4);
                }
            }
            i.checkNotNull(responseProceed);
            Response.Builder builderNewBuilder2 = responseProceed.newBuilder();
            Companion companion2 = Companion;
            Response responseBuild4 = builderNewBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(responseProceed)).build();
            if (this.cache != null) {
                if (okhttp3.internal.http.HttpHeaders.promisesBody(responseBuild4) && CacheStrategy.Companion.isCacheable(responseBuild4, networkRequest)) {
                    Response responseCacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(responseBuild4), responseBuild4);
                    if (cacheResponse != null) {
                        eventListener$okhttp.cacheMiss(call);
                    }
                    return responseCacheWritingResponse;
                }
                if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return responseBuild4;
        } finally {
            if (response != null && (responseBodyBody = response.body()) != null) {
                Util.closeQuietly(responseBodyBody);
            }
        }
    }
}
