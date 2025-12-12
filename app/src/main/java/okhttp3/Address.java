package okhttp3;

import ac.c;
import cz.msebera.android.httpclient.HttpHost;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import zf.i;

/* compiled from: Address.kt */
/* loaded from: classes2.dex */
public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String str, int i10, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        i.checkNotNullParameter(str, "uriHost");
        i.checkNotNullParameter(dns, "dns");
        i.checkNotNullParameter(socketFactory, "socketFactory");
        i.checkNotNullParameter(authenticator, "proxyAuthenticator");
        i.checkNotNullParameter(list, "protocols");
        i.checkNotNullParameter(list2, "connectionSpecs");
        i.checkNotNullParameter(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).host(str).port(i10).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    /* renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m89deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m90deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m91deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m92deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m93deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m94deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m95deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m96deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m97deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m98deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m99deprecated_url() {
        return this.url;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (i.areEqual(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        i.checkNotNullParameter(address, "that");
        return i.areEqual(this.dns, address.dns) && i.areEqual(this.proxyAuthenticator, address.proxyAuthenticator) && i.areEqual(this.protocols, address.protocols) && i.areEqual(this.connectionSpecs, address.connectionSpecs) && i.areEqual(this.proxySelector, address.proxySelector) && i.areEqual(this.proxy, address.proxy) && i.areEqual(this.sslSocketFactory, address.sslSocketFactory) && i.areEqual(this.hostnameVerifier, address.hostnameVerifier) && i.areEqual(this.certificatePinner, address.certificatePinner) && this.url.port() == address.url.port();
    }

    public int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((Objects.hashCode(this.proxy) + ((this.proxySelector.hashCode() + ((this.connectionSpecs.hashCode() + ((this.protocols.hashCode() + ((this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + ((this.url.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        Proxy proxy = this.proxy;
        return c.n(sb2, proxy != null ? i.stringPlus("proxy=", proxy) : i.stringPlus("proxySelector=", this.proxySelector), '}');
    }

    public final HttpUrl url() {
        return this.url;
    }
}
