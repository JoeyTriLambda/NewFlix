package okhttp3;

import ac.c;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.client.methods.HttpPatch;
import ig.l;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.a;
import mf.k;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import zf.i;

/* compiled from: Request.kt */
/* loaded from: classes2.dex */
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    /* compiled from: Request.kt */
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i10 & 1) != 0) {
                requestBody = Util.EMPTY_REQUEST;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            getHeaders$okhttp().add(str, str2);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder cacheControl(CacheControl cacheControl) {
            i.checkNotNullParameter(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            getHeaders$okhttp().set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            i.checkNotNullParameter(headers, "headers");
            setHeaders$okhttp(headers.newBuilder());
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            i.checkNotNullParameter(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                if (!(!HttpMethod.requiresRequestBody(str))) {
                    throw new IllegalArgumentException(c.k("method ", str, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException(c.k("method ", str, " must not have a request body.").toString());
            }
            setMethod$okhttp(str);
            setBody$okhttp(requestBody);
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            i.checkNotNullParameter(requestBody, "body");
            return method(HttpPatch.METHOD_NAME, requestBody);
        }

        public Builder post(RequestBody requestBody) {
            i.checkNotNullParameter(requestBody, "body");
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            i.checkNotNullParameter(requestBody, "body");
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            getHeaders$okhttp().removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            i.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            i.checkNotNullParameter(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            i.checkNotNullParameter(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            i.checkNotNullParameter(httpUrl, "url");
            setUrl$okhttp(httpUrl);
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public <T> Builder tag(Class<? super T> cls, T t10) {
            i.checkNotNullParameter(cls, "type");
            if (t10 == null) {
                getTags$okhttp().remove(cls);
            } else {
                if (getTags$okhttp().isEmpty()) {
                    setTags$okhttp(new LinkedHashMap());
                }
                Map<Class<?>, Object> tags$okhttp = getTags$okhttp();
                T tCast = cls.cast(t10);
                i.checkNotNull(tCast);
                tags$okhttp.put(cls, tCast);
            }
            return this;
        }

        public Builder url(String str) {
            i.checkNotNullParameter(str, "url");
            if (l.startsWith(str, "ws:", true)) {
                String strSubstring = str.substring(3);
                i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                str = i.stringPlus("http:", strSubstring);
            } else if (l.startsWith(str, "wss:", true)) {
                String strSubstring2 = str.substring(4);
                i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                str = i.stringPlus("https:", strSubstring2);
            }
            return url(HttpUrl.Companion.get(str));
        }

        public Builder(Request request) {
            Map<Class<?>, Object> mutableMap;
            i.checkNotNullParameter(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = a.toMutableMap(request.getTags$okhttp());
            }
            this.tags = mutableMap;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url) {
            i.checkNotNullParameter(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            i.checkNotNullExpressionValue(string, "url.toString()");
            return url(companion.get(string));
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        i.checkNotNullParameter(httpUrl, "url");
        i.checkNotNullParameter(str, "method");
        i.checkNotNullParameter(headers, "headers");
        i.checkNotNullParameter(map, "tags");
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    /* renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m201deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m202deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m203deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method, reason: not valid java name */
    public final String m204deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m205deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        return this.headers.get(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Request{method=");
        sb2.append(method());
        sb2.append(", url=");
        sb2.append(url());
        if (headers().size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Pair<? extends String, ? extends String> pair : headers()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    k.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strComponent1 = pair2.component1();
                String strComponent2 = pair2.component2();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(strComponent1);
                sb2.append(':');
                sb2.append(strComponent2);
                i10 = i11;
            }
            sb2.append(']');
        }
        if (!getTags$okhttp().isEmpty()) {
            sb2.append(", tags=");
            sb2.append(getTags$okhttp());
        }
        sb2.append('}');
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        return this.headers.values(str);
    }

    public final <T> T tag(Class<? extends T> cls) {
        i.checkNotNullParameter(cls, "type");
        return cls.cast(this.tags.get(cls));
    }
}
