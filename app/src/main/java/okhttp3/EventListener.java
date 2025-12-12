package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import zf.f;
import zf.i;

/* compiled from: EventListener.kt */
/* loaded from: classes2.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: EventListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: EventListener.kt */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "response");
    }

    public void cacheMiss(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void callEnd(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(iOException, "ioe");
    }

    public void callStart(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void canceled(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        i.checkNotNullParameter(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        i.checkNotNullParameter(proxy, "proxy");
        i.checkNotNullParameter(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        i.checkNotNullParameter(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(str, "domainName");
        i.checkNotNullParameter(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(httpUrl, "url");
        i.checkNotNullParameter(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(httpUrl, "url");
    }

    public void requestBodyEnd(Call call, long j10) {
        i.checkNotNullParameter(call, "call");
    }

    public void requestBodyStart(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void requestFailed(Call call, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(request, "request");
    }

    public void requestHeadersStart(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void responseBodyEnd(Call call, long j10) {
        i.checkNotNullParameter(call, "call");
    }

    public void responseBodyStart(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void responseFailed(Call call, IOException iOException) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "response");
    }

    public void responseHeadersStart(Call call) {
        i.checkNotNullParameter(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        i.checkNotNullParameter(call, "call");
        i.checkNotNullParameter(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        i.checkNotNullParameter(call, "call");
    }

    public void secureConnectStart(Call call) {
        i.checkNotNullParameter(call, "call");
    }
}
