package okhttp3.internal.http;

import ac.c;
import ah.d;
import ah.m;
import cz.msebera.android.httpclient.protocol.HTTP;
import ig.l;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import zf.i;

/* compiled from: CallServerInterceptor.kt */
/* loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z10) {
        this.forWebSocket = z10;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z10;
        Response.Builder responseHeaders;
        i.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        i.checkNotNull(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody requestBodyBody = request$okhttp.body();
        long jCurrentTimeMillis = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(request$okhttp);
        if (!HttpMethod.permitsRequestBody(request$okhttp.method()) || requestBodyBody == null) {
            exchange$okhttp.noRequestBody();
            z10 = true;
            responseHeaders = null;
        } else {
            if (l.equals(HTTP.EXPECT_CONTINUE, request$okhttp.header("Expect"), true)) {
                exchange$okhttp.flushRequest();
                responseHeaders = exchange$okhttp.readResponseHeaders(true);
                exchange$okhttp.responseHeadersStart();
                z10 = false;
            } else {
                z10 = true;
                responseHeaders = null;
            }
            if (responseHeaders != null) {
                exchange$okhttp.noRequestBody();
                if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                    exchange$okhttp.noNewExchangesOnConnection();
                }
            } else if (requestBodyBody.isDuplex()) {
                exchange$okhttp.flushRequest();
                requestBodyBody.writeTo(m.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
            } else {
                d dVarBuffer = m.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                requestBodyBody.writeTo(dVarBuffer);
                dVarBuffer.close();
            }
        }
        if (requestBodyBody == null || !requestBodyBody.isDuplex()) {
            exchange$okhttp.finishRequest();
        }
        if (responseHeaders == null) {
            responseHeaders = exchange$okhttp.readResponseHeaders(false);
            i.checkNotNull(responseHeaders);
            if (z10) {
                exchange$okhttp.responseHeadersStart();
                z10 = false;
            }
        }
        Response responseBuild = responseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild.code();
        if (iCode == 100) {
            Response.Builder responseHeaders2 = exchange$okhttp.readResponseHeaders(false);
            i.checkNotNull(responseHeaders2);
            if (z10) {
                exchange$okhttp.responseHeadersStart();
            }
            responseBuild = responseHeaders2.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            iCode = responseBuild.code();
        }
        exchange$okhttp.responseHeadersEnd(responseBuild);
        Response responseBuild2 = (this.forWebSocket && iCode == 101) ? responseBuild.newBuilder().body(Util.EMPTY_RESPONSE).build() : responseBuild.newBuilder().body(exchange$okhttp.openResponseBody(responseBuild)).build();
        if (l.equals("close", responseBuild2.request().header("Connection"), true) || l.equals("close", Response.header$default(responseBuild2, "Connection", null, 2, null), true)) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if (iCode == 204 || iCode == 205) {
            ResponseBody responseBodyBody = responseBuild2.body();
            if ((responseBodyBody == null ? -1L : responseBodyBody.contentLength()) > 0) {
                StringBuilder sbS = c.s("HTTP ", iCode, " had non-zero Content-Length: ");
                ResponseBody responseBodyBody2 = responseBuild2.body();
                sbS.append(responseBodyBody2 != null ? Long.valueOf(responseBodyBody2.contentLength()) : null);
                throw new ProtocolException(sbS.toString());
            }
        }
        return responseBuild2;
    }
}
