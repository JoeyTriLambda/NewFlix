package com.unity3d.services.core.network.model;

import ac.c;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.List;
import java.util.Map;
import kotlin.collections.a;
import zf.f;
import zf.i;

/* compiled from: HttpRequest.kt */
/* loaded from: classes2.dex */
public final class HttpRequest {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final Object body;
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map<String, List<String>> headers;
    private final RequestType method;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    /* compiled from: HttpRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str) {
        this(str, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 8190, null);
        i.checkNotNullParameter(str, "baseURL");
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.connectTimeout;
    }

    public final int component11() {
        return this.readTimeout;
    }

    public final int component12() {
        return this.writeTimeout;
    }

    public final int component13() {
        return this.callTimeout;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final Object component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final BodyType component7() {
        return this.bodyType;
    }

    public final String component8() {
        return this.scheme;
    }

    public final Integer component9() {
        return this.port;
    }

    public final HttpRequest copy(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3, Integer num, int i10, int i11, int i12, int i13) {
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
        return new HttpRequest(str, str2, requestType, obj, map, map2, bodyType, str3, num, i10, i11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return i.areEqual(this.baseURL, httpRequest.baseURL) && i.areEqual(this.path, httpRequest.path) && this.method == httpRequest.method && i.areEqual(this.body, httpRequest.body) && i.areEqual(this.headers, httpRequest.headers) && i.areEqual(this.parameters, httpRequest.parameters) && this.bodyType == httpRequest.bodyType && i.areEqual(this.scheme, httpRequest.scheme) && i.areEqual(this.port, httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final Object getBody() {
        return this.body;
    }

    public final BodyType getBodyType() {
        return this.bodyType;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final RequestType getMethod() {
        return this.method;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        int iHashCode = (this.method.hashCode() + c.b(this.path, this.baseURL.hashCode() * 31, 31)) * 31;
        Object obj = this.body;
        int iB = c.b(this.scheme, (this.bodyType.hashCode() + ((this.parameters.hashCode() + ((this.headers.hashCode() + ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31)) * 31)) * 31)) * 31, 31);
        Integer num = this.port;
        return ((((((((iB + (num != null ? num.hashCode() : 0)) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("HttpRequest(baseURL=");
        sb2.append(this.baseURL);
        sb2.append(", path=");
        sb2.append(this.path);
        sb2.append(", method=");
        sb2.append(this.method);
        sb2.append(", body=");
        sb2.append(this.body);
        sb2.append(", headers=");
        sb2.append(this.headers);
        sb2.append(", parameters=");
        sb2.append(this.parameters);
        sb2.append(", bodyType=");
        sb2.append(this.bodyType);
        sb2.append(", scheme=");
        sb2.append(this.scheme);
        sb2.append(", port=");
        sb2.append(this.port);
        sb2.append(", connectTimeout=");
        sb2.append(this.connectTimeout);
        sb2.append(", readTimeout=");
        sb2.append(this.readTimeout);
        sb2.append(", writeTimeout=");
        sb2.append(this.writeTimeout);
        sb2.append(", callTimeout=");
        return c.l(sb2, this.callTimeout, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2) {
        this(str, str2, null, null, null, null, null, null, null, 0, 0, 0, 0, 8188, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType) {
        this(str, str2, requestType, null, null, null, null, null, null, 0, 0, 0, 0, 8184, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj) {
        this(str, str2, requestType, obj, null, null, null, null, null, 0, 0, 0, 0, 8176, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map) {
        this(str, str2, requestType, obj, map, null, null, null, null, 0, 0, 0, 0, 8160, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2) {
        this(str, str2, requestType, obj, map, map2, null, null, null, 0, 0, 0, 0, 8128, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType) {
        this(str, str2, requestType, obj, map, map2, bodyType, null, null, 0, 0, 0, 0, 8064, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3) {
        this(str, str2, requestType, obj, map, map2, bodyType, str3, null, 0, 0, 0, 0, 7936, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3, Integer num) {
        this(str, str2, requestType, obj, map, map2, bodyType, str3, num, 0, 0, 0, 0, 7680, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3, Integer num, int i10) {
        this(str, str2, requestType, obj, map, map2, bodyType, str3, num, i10, 0, 0, 0, 7168, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3, Integer num, int i10, int i11) {
        this(str, str2, requestType, obj, map, map2, bodyType, str3, num, i10, i11, 0, 0, 6144, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3, Integer num, int i10, int i11, int i12) {
        this(str, str2, requestType, obj, map, map2, bodyType, str3, num, i10, i11, i12, 0, 4096, null);
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType, String str3, Integer num, int i10, int i11, int i12, int i13) {
        i.checkNotNullParameter(str, "baseURL");
        i.checkNotNullParameter(str2, ClientCookie.PATH_ATTR);
        i.checkNotNullParameter(requestType, "method");
        i.checkNotNullParameter(map, "headers");
        i.checkNotNullParameter(map2, "parameters");
        i.checkNotNullParameter(bodyType, "bodyType");
        i.checkNotNullParameter(str3, "scheme");
        this.baseURL = str;
        this.path = str2;
        this.method = requestType;
        this.body = obj;
        this.headers = map;
        this.parameters = map2;
        this.bodyType = bodyType;
        this.scheme = str3;
        this.port = num;
        this.connectTimeout = i10;
        this.readTimeout = i11;
        this.writeTimeout = i12;
        this.callTimeout = i13;
    }

    public /* synthetic */ HttpRequest(String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType, String str3, Integer num, int i10, int i11, int i12, int i13, int i14, f fVar) {
        this(str, (i14 & 2) != 0 ? "" : str2, (i14 & 4) != 0 ? RequestType.GET : requestType, (i14 & 8) != 0 ? null : obj, (i14 & 16) != 0 ? a.emptyMap() : map, (i14 & 32) != 0 ? a.emptyMap() : map2, (i14 & 64) != 0 ? BodyType.UNKNOWN : bodyType, (i14 & 128) != 0 ? DEFAULT_SCHEME : str3, (i14 & 256) == 0 ? num : null, (i14 & 512) != 0 ? DEFAULT_TIMEOUT : i10, (i14 & 1024) != 0 ? DEFAULT_TIMEOUT : i11, (i14 & 2048) != 0 ? DEFAULT_TIMEOUT : i12, (i14 & 4096) == 0 ? i13 : DEFAULT_TIMEOUT);
    }
}
