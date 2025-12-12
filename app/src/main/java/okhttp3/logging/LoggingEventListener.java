package okhttp3.logging;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import zf.f;
import zf.i;

/* compiled from: LoggingEventListener.kt */
/* loaded from: classes2.dex */
public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    /* compiled from: LoggingEventListener.kt */
    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            i.checkNotNullParameter(call, "call");
            return new LoggingEventListener(this.logger, null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger) {
            i.checkNotNullParameter(logger, "logger");
            this.logger = logger;
        }

        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i10, f fVar) {
            this((i10 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, f fVar) {
        this(logger);
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        this.logger.log("[" + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "cachedResponse");
        logWithTime(i.stringPlus("cacheConditionalHit: ", response));
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "response");
        logWithTime(i.stringPlus("cacheHit: ", response));
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("cacheMiss");
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(iOException, "ioe");
        logWithTime(i.stringPlus("callFailed: ", iOException));
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        i.checkNotNullParameter(call, "call");
        this.startNs = System.nanoTime();
        logWithTime(i.stringPlus("callStart: ", call.request()));
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("canceled");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        i.checkNotNullParameter(proxy, "proxy");
        logWithTime(i.stringPlus("connectEnd: ", protocol));
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        i.checkNotNullParameter(proxy, "proxy");
        i.checkNotNullParameter(iOException, "ioe");
        logWithTime("connectFailed: " + protocol + TokenParser.SP + iOException);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        i.checkNotNullParameter(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + TokenParser.SP + proxy);
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(connection, "connection");
        logWithTime(i.stringPlus("connectionAcquired: ", connection));
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(connection, "connection");
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(str, "domainName");
        i.checkNotNullParameter(list, "inetAddressList");
        logWithTime(i.stringPlus("dnsEnd: ", list));
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(str, "domainName");
        logWithTime(i.stringPlus("dnsStart: ", str));
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(httpUrl, "url");
        i.checkNotNullParameter(list, "proxies");
        logWithTime(i.stringPlus("proxySelectEnd: ", list));
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(httpUrl, "url");
        logWithTime(i.stringPlus("proxySelectStart: ", httpUrl));
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j10) {
        i.checkNotNullParameter(call, "call");
        logWithTime(i.stringPlus("requestBodyEnd: byteCount=", Long.valueOf(j10)));
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(iOException, "ioe");
        logWithTime(i.stringPlus("requestFailed: ", iOException));
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(request, "request");
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j10) {
        i.checkNotNullParameter(call, "call");
        logWithTime(i.stringPlus("responseBodyEnd: byteCount=", Long.valueOf(j10)));
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(iOException, "ioe");
        logWithTime(i.stringPlus("responseFailed: ", iOException));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "response");
        logWithTime(i.stringPlus("responseHeadersEnd: ", response));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "response");
        logWithTime(i.stringPlus("satisfactionFailure: ", response));
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        i.checkNotNullParameter(call, "call");
        logWithTime(i.stringPlus("secureConnectEnd: ", handshake));
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        i.checkNotNullParameter(call, "call");
        logWithTime("secureConnectStart");
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }
}
