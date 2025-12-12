package dh;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpConnection.java */
/* loaded from: classes2.dex */
public final class d implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }
}
