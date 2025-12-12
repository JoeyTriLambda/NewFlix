package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes2.dex */
public class SystemDefaultRoutePlanner extends DefaultRoutePlanner {
    private final ProxySelector proxySelector;

    /* renamed from: cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$net$Proxy$Type;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $SwitchMap$java$net$Proxy$Type = iArr;
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$net$Proxy$Type[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$net$Proxy$Type[Proxy.Type.SOCKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public SystemDefaultRoutePlanner(SchemePortResolver schemePortResolver, ProxySelector proxySelector) {
        super(schemePortResolver);
        this.proxySelector = proxySelector;
    }

    private Proxy chooseProxy(List<Proxy> list) {
        Proxy proxy = null;
        for (int i10 = 0; proxy == null && i10 < list.size(); i10++) {
            Proxy proxy2 = list.get(i10);
            int i11 = AnonymousClass1.$SwitchMap$java$net$Proxy$Type[proxy2.type().ordinal()];
            if (i11 == 1 || i11 == 2) {
                proxy = proxy2;
            }
        }
        return proxy == null ? Proxy.NO_PROXY : proxy;
    }

    private String getHost(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostName() : inetSocketAddress.getAddress().getHostAddress();
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner
    public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        try {
            URI uri = new URI(httpHost.toURI());
            ProxySelector proxySelector = this.proxySelector;
            if (proxySelector == null) {
                proxySelector = ProxySelector.getDefault();
            }
            if (proxySelector == null) {
                return null;
            }
            Proxy proxyChooseProxy = chooseProxy(proxySelector.select(uri));
            if (proxyChooseProxy.type() != Proxy.Type.HTTP) {
                return null;
            }
            if (proxyChooseProxy.address() instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyChooseProxy.address();
                return new HttpHost(getHost(inetSocketAddress), inetSocketAddress.getPort());
            }
            throw new HttpException("Unable to handle non-Inet proxy address: " + proxyChooseProxy.address());
        } catch (URISyntaxException e10) {
            throw new HttpException("Cannot convert host to URI: " + httpHost, e10);
        }
    }

    public SystemDefaultRoutePlanner(ProxySelector proxySelector) {
        this(null, proxySelector);
    }
}
