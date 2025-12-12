package okhttp3.internal;

import com.unity3d.ads.metadata.MediationMetaData;
import javax.net.ssl.SSLSocket;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import zf.i;

/* compiled from: internal.kt */
/* loaded from: classes2.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        i.checkNotNullParameter(builder, "builder");
        i.checkNotNullParameter(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10) {
        i.checkNotNullParameter(connectionSpec, "connectionSpec");
        i.checkNotNullParameter(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z10);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        i.checkNotNullParameter(cache, "cache");
        i.checkNotNullParameter(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z10) {
        i.checkNotNullParameter(cookie, "cookie");
        return cookie.toString$okhttp(z10);
    }

    public static final Cookie parseCookie(long j10, HttpUrl httpUrl, String str) {
        i.checkNotNullParameter(httpUrl, "url");
        i.checkNotNullParameter(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j10, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        i.checkNotNullParameter(builder, "builder");
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }
}
