package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;

/* loaded from: classes2.dex */
public final class RouteTracker implements RouteInfo, Cloneable {
    private boolean connected;
    private RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private HttpHost[] proxyChain;
    private boolean secure;
    private final HttpHost targetHost;
    private RouteInfo.TunnelType tunnelled;

    public RouteTracker(HttpHost httpHost, InetAddress inetAddress) {
        Args.notNull(httpHost, "Target host");
        this.targetHost = httpHost;
        this.localAddress = inetAddress;
        this.tunnelled = RouteInfo.TunnelType.PLAIN;
        this.layered = RouteInfo.LayerType.PLAIN;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final void connectProxy(HttpHost httpHost, boolean z10) {
        Args.notNull(httpHost, "Proxy host");
        Asserts.check(!this.connected, "Already connected");
        this.connected = true;
        this.proxyChain = new HttpHost[]{httpHost};
        this.secure = z10;
    }

    public final void connectTarget(boolean z10) {
        Asserts.check(!this.connected, "Already connected");
        this.connected = true;
        this.secure = z10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteTracker)) {
            return false;
        }
        RouteTracker routeTracker = (RouteTracker) obj;
        return this.connected == routeTracker.connected && this.secure == routeTracker.secure && this.tunnelled == routeTracker.tunnelled && this.layered == routeTracker.layered && LangUtils.equals(this.targetHost, routeTracker.targetHost) && LangUtils.equals(this.localAddress, routeTracker.localAddress) && LangUtils.equals((Object[]) this.proxyChain, (Object[]) routeTracker.proxyChain);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final int getHopCount() {
        if (!this.connected) {
            return 0;
        }
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr == null) {
            return 1;
        }
        return 1 + httpHostArr.length;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getHopTarget(int i10) {
        Args.notNegative(i10, "Hop index");
        int hopCount = getHopCount();
        Args.check(i10 < hopCount, "Hop index exceeds tracked route length");
        return i10 < hopCount - 1 ? this.proxyChain[i10] : this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final RouteInfo.LayerType getLayerType() {
        return this.layered;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr == null) {
            return null;
        }
        return httpHostArr[0];
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final RouteInfo.TunnelType getTunnelType() {
        return this.tunnelled;
    }

    public final int hashCode() {
        int iHashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr != null) {
            for (HttpHost httpHost : httpHostArr) {
                iHashCode = LangUtils.hashCode(iHashCode, httpHost);
            }
        }
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(iHashCode, this.connected), this.secure), this.tunnelled), this.layered);
    }

    public final boolean isConnected() {
        return this.connected;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isLayered() {
        return this.layered == RouteInfo.LayerType.LAYERED;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isSecure() {
        return this.secure;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isTunnelled() {
        return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
    }

    public final void layerProtocol(boolean z10) {
        Asserts.check(this.connected, "No layered protocol unless connected");
        this.layered = RouteInfo.LayerType.LAYERED;
        this.secure = z10;
    }

    public void reset() {
        this.connected = false;
        this.proxyChain = null;
        this.tunnelled = RouteInfo.TunnelType.PLAIN;
        this.layered = RouteInfo.LayerType.PLAIN;
        this.secure = false;
    }

    public final HttpRoute toRoute() {
        if (this.connected) {
            return new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((getHopCount() * 30) + 50);
        sb2.append("RouteTracker[");
        InetAddress inetAddress = this.localAddress;
        if (inetAddress != null) {
            sb2.append(inetAddress);
            sb2.append("->");
        }
        sb2.append('{');
        if (this.connected) {
            sb2.append('c');
        }
        if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
            sb2.append('t');
        }
        if (this.layered == RouteInfo.LayerType.LAYERED) {
            sb2.append('l');
        }
        if (this.secure) {
            sb2.append('s');
        }
        sb2.append("}->");
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr != null) {
            for (HttpHost httpHost : httpHostArr) {
                sb2.append(httpHost);
                sb2.append("->");
            }
        }
        sb2.append(this.targetHost);
        sb2.append(']');
        return sb2.toString();
    }

    public final void tunnelProxy(HttpHost httpHost, boolean z10) {
        Args.notNull(httpHost, "Proxy host");
        Asserts.check(this.connected, "No tunnel unless connected");
        Asserts.notNull(this.proxyChain, "No tunnel without proxy");
        HttpHost[] httpHostArr = this.proxyChain;
        int length = httpHostArr.length + 1;
        HttpHost[] httpHostArr2 = new HttpHost[length];
        System.arraycopy(httpHostArr, 0, httpHostArr2, 0, httpHostArr.length);
        httpHostArr2[length - 1] = httpHost;
        this.proxyChain = httpHostArr2;
        this.secure = z10;
    }

    public final void tunnelTarget(boolean z10) {
        Asserts.check(this.connected, "No tunnel unless connected");
        Asserts.notNull(this.proxyChain, "No tunnel without proxy");
        this.tunnelled = RouteInfo.TunnelType.TUNNELLED;
        this.secure = z10;
    }

    public RouteTracker(HttpRoute httpRoute) {
        this(httpRoute.getTargetHost(), httpRoute.getLocalAddress());
    }
}
