package okhttp3.internal.http;

import ah.j;
import ah.m;
import com.loopj.android.http.AsyncHttpClient;
import cz.msebera.android.httpclient.protocol.HTTP;
import ig.l;
import java.io.IOException;
import java.util.List;
import mf.k;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import zf.i;

/* compiled from: BridgeInterceptor.kt */
/* loaded from: classes2.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        i.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                k.throwIndexOverflow();
            }
            Cookie cookie = (Cookie) obj;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(cookie.name());
            sb2.append('=');
            sb2.append(cookie.value());
            i10 = i11;
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody responseBodyBody;
        i.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header("Content-Length", String.valueOf(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", HTTP.CHUNK_CODING);
                builderNewBuilder.removeHeader("Content-Length");
            }
        }
        boolean z10 = false;
        if (request.header("Host") == null) {
            builderNewBuilder.header("Host", Util.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header("Connection") == null) {
            builderNewBuilder.header("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            builderNewBuilder.header("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            z10 = true;
        }
        List<Cookie> listLoadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!listLoadForRequest.isEmpty()) {
            builderNewBuilder.header("Cookie", cookieHeader(listLoadForRequest));
        }
        if (request.header("User-Agent") == null) {
            builderNewBuilder.header("User-Agent", Util.userAgent);
        }
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), responseProceed.headers());
        Response.Builder builderRequest = responseProceed.newBuilder().request(request);
        if (z10 && l.equals(AsyncHttpClient.ENCODING_GZIP, Response.header$default(responseProceed, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(responseProceed) && (responseBodyBody = responseProceed.body()) != null) {
            j jVar = new j(responseBodyBody.source());
            builderRequest.headers(responseProceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            builderRequest.body(new RealResponseBody(Response.header$default(responseProceed, "Content-Type", null, 2, null), -1L, m.buffer(jVar)));
        }
        return builderRequest.build();
    }
}
