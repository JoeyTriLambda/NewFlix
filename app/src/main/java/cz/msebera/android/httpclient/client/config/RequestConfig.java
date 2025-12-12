package cz.msebera.android.httpclient.client.config;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.net.InetAddress;
import java.util.Collection;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class RequestConfig implements Cloneable {
    public static final RequestConfig DEFAULT = new Builder().build();
    private final boolean authenticationEnabled;
    private final boolean circularRedirectsAllowed;
    private final int connectTimeout;
    private final int connectionRequestTimeout;
    private final boolean contentCompressionEnabled;
    private final String cookieSpec;
    private final boolean expectContinueEnabled;
    private final InetAddress localAddress;
    private final int maxRedirects;
    private final boolean normalizeUri;
    private final HttpHost proxy;
    private final Collection<String> proxyPreferredAuthSchemes;
    private final boolean redirectsEnabled;
    private final boolean relativeRedirectsAllowed;
    private final int socketTimeout;
    private final boolean staleConnectionCheckEnabled;
    private final Collection<String> targetPreferredAuthSchemes;

    public static class Builder {
        private boolean circularRedirectsAllowed;
        private String cookieSpec;
        private boolean expectContinueEnabled;
        private InetAddress localAddress;
        private HttpHost proxy;
        private Collection<String> proxyPreferredAuthSchemes;
        private Collection<String> targetPreferredAuthSchemes;
        private boolean staleConnectionCheckEnabled = false;
        private boolean redirectsEnabled = true;
        private int maxRedirects = 50;
        private boolean relativeRedirectsAllowed = true;
        private boolean authenticationEnabled = true;
        private int connectionRequestTimeout = -1;
        private int connectTimeout = -1;
        private int socketTimeout = -1;
        private boolean contentCompressionEnabled = true;
        private boolean normalizeUri = true;

        public RequestConfig build() {
            return new RequestConfig(this.expectContinueEnabled, this.proxy, this.localAddress, this.staleConnectionCheckEnabled, this.cookieSpec, this.redirectsEnabled, this.relativeRedirectsAllowed, this.circularRedirectsAllowed, this.maxRedirects, this.authenticationEnabled, this.targetPreferredAuthSchemes, this.proxyPreferredAuthSchemes, this.connectionRequestTimeout, this.connectTimeout, this.socketTimeout, this.contentCompressionEnabled, this.normalizeUri);
        }

        public Builder setAuthenticationEnabled(boolean z10) {
            this.authenticationEnabled = z10;
            return this;
        }

        public Builder setCircularRedirectsAllowed(boolean z10) {
            this.circularRedirectsAllowed = z10;
            return this;
        }

        public Builder setConnectTimeout(int i10) {
            this.connectTimeout = i10;
            return this;
        }

        public Builder setConnectionRequestTimeout(int i10) {
            this.connectionRequestTimeout = i10;
            return this;
        }

        public Builder setContentCompressionEnabled(boolean z10) {
            this.contentCompressionEnabled = z10;
            return this;
        }

        public Builder setCookieSpec(String str) {
            this.cookieSpec = str;
            return this;
        }

        @Deprecated
        public Builder setDecompressionEnabled(boolean z10) {
            this.contentCompressionEnabled = z10;
            return this;
        }

        public Builder setExpectContinueEnabled(boolean z10) {
            this.expectContinueEnabled = z10;
            return this;
        }

        public Builder setLocalAddress(InetAddress inetAddress) {
            this.localAddress = inetAddress;
            return this;
        }

        public Builder setMaxRedirects(int i10) {
            this.maxRedirects = i10;
            return this;
        }

        public Builder setNormalizeUri(boolean z10) {
            this.normalizeUri = z10;
            return this;
        }

        public Builder setProxy(HttpHost httpHost) {
            this.proxy = httpHost;
            return this;
        }

        public Builder setProxyPreferredAuthSchemes(Collection<String> collection) {
            this.proxyPreferredAuthSchemes = collection;
            return this;
        }

        public Builder setRedirectsEnabled(boolean z10) {
            this.redirectsEnabled = z10;
            return this;
        }

        public Builder setRelativeRedirectsAllowed(boolean z10) {
            this.relativeRedirectsAllowed = z10;
            return this;
        }

        public Builder setSocketTimeout(int i10) {
            this.socketTimeout = i10;
            return this;
        }

        @Deprecated
        public Builder setStaleConnectionCheckEnabled(boolean z10) {
            this.staleConnectionCheckEnabled = z10;
            return this;
        }

        public Builder setTargetPreferredAuthSchemes(Collection<String> collection) {
            this.targetPreferredAuthSchemes = collection;
            return this;
        }
    }

    public RequestConfig() {
        this(false, null, null, false, null, false, false, false, 0, false, null, null, 0, 0, 0, true, true);
    }

    public static Builder copy(RequestConfig requestConfig) {
        return new Builder().setExpectContinueEnabled(requestConfig.isExpectContinueEnabled()).setProxy(requestConfig.getProxy()).setLocalAddress(requestConfig.getLocalAddress()).setStaleConnectionCheckEnabled(requestConfig.isStaleConnectionCheckEnabled()).setCookieSpec(requestConfig.getCookieSpec()).setRedirectsEnabled(requestConfig.isRedirectsEnabled()).setRelativeRedirectsAllowed(requestConfig.isRelativeRedirectsAllowed()).setCircularRedirectsAllowed(requestConfig.isCircularRedirectsAllowed()).setMaxRedirects(requestConfig.getMaxRedirects()).setAuthenticationEnabled(requestConfig.isAuthenticationEnabled()).setTargetPreferredAuthSchemes(requestConfig.getTargetPreferredAuthSchemes()).setProxyPreferredAuthSchemes(requestConfig.getProxyPreferredAuthSchemes()).setConnectionRequestTimeout(requestConfig.getConnectionRequestTimeout()).setConnectTimeout(requestConfig.getConnectTimeout()).setSocketTimeout(requestConfig.getSocketTimeout()).setDecompressionEnabled(requestConfig.isDecompressionEnabled()).setContentCompressionEnabled(requestConfig.isContentCompressionEnabled());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getConnectionRequestTimeout() {
        return this.connectionRequestTimeout;
    }

    public String getCookieSpec() {
        return this.cookieSpec;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public HttpHost getProxy() {
        return this.proxy;
    }

    public Collection<String> getProxyPreferredAuthSchemes() {
        return this.proxyPreferredAuthSchemes;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public Collection<String> getTargetPreferredAuthSchemes() {
        return this.targetPreferredAuthSchemes;
    }

    public boolean isAuthenticationEnabled() {
        return this.authenticationEnabled;
    }

    public boolean isCircularRedirectsAllowed() {
        return this.circularRedirectsAllowed;
    }

    public boolean isContentCompressionEnabled() {
        return this.contentCompressionEnabled;
    }

    @Deprecated
    public boolean isDecompressionEnabled() {
        return this.contentCompressionEnabled;
    }

    public boolean isExpectContinueEnabled() {
        return this.expectContinueEnabled;
    }

    public boolean isNormalizeUri() {
        return this.normalizeUri;
    }

    public boolean isRedirectsEnabled() {
        return this.redirectsEnabled;
    }

    public boolean isRelativeRedirectsAllowed() {
        return this.relativeRedirectsAllowed;
    }

    @Deprecated
    public boolean isStaleConnectionCheckEnabled() {
        return this.staleConnectionCheckEnabled;
    }

    public String toString() {
        return "[expectContinueEnabled=" + this.expectContinueEnabled + ", proxy=" + this.proxy + ", localAddress=" + this.localAddress + ", cookieSpec=" + this.cookieSpec + ", redirectsEnabled=" + this.redirectsEnabled + ", relativeRedirectsAllowed=" + this.relativeRedirectsAllowed + ", maxRedirects=" + this.maxRedirects + ", circularRedirectsAllowed=" + this.circularRedirectsAllowed + ", authenticationEnabled=" + this.authenticationEnabled + ", targetPreferredAuthSchemes=" + this.targetPreferredAuthSchemes + ", proxyPreferredAuthSchemes=" + this.proxyPreferredAuthSchemes + ", connectionRequestTimeout=" + this.connectionRequestTimeout + ", connectTimeout=" + this.connectTimeout + ", socketTimeout=" + this.socketTimeout + ", contentCompressionEnabled=" + this.contentCompressionEnabled + ", normalizeUri=" + this.normalizeUri + "]";
    }

    public RequestConfig(boolean z10, HttpHost httpHost, InetAddress inetAddress, boolean z11, String str, boolean z12, boolean z13, boolean z14, int i10, boolean z15, Collection<String> collection, Collection<String> collection2, int i11, int i12, int i13, boolean z16, boolean z17) {
        this.expectContinueEnabled = z10;
        this.proxy = httpHost;
        this.localAddress = inetAddress;
        this.staleConnectionCheckEnabled = z11;
        this.cookieSpec = str;
        this.redirectsEnabled = z12;
        this.relativeRedirectsAllowed = z13;
        this.circularRedirectsAllowed = z14;
        this.maxRedirects = i10;
        this.authenticationEnabled = z15;
        this.targetPreferredAuthSchemes = collection;
        this.proxyPreferredAuthSchemes = collection2;
        this.connectionRequestTimeout = i11;
        this.connectTimeout = i12;
        this.socketTimeout = i13;
        this.contentCompressionEnabled = z16;
        this.normalizeUri = z17;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RequestConfig m25clone() throws CloneNotSupportedException {
        return (RequestConfig) super.clone();
    }
}
