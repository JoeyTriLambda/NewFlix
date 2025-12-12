package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;
import zf.f;
import zf.i;

/* compiled from: CertificateChainCleaner.kt */
/* loaded from: classes2.dex */
public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);

    /* compiled from: CertificateChainCleaner.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final CertificateChainCleaner get(X509TrustManager x509TrustManager) {
            i.checkNotNullParameter(x509TrustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(x509TrustManager);
        }

        public final CertificateChainCleaner get(X509Certificate... x509CertificateArr) {
            i.checkNotNullParameter(x509CertificateArr, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(x509CertificateArr, x509CertificateArr.length)));
        }
    }

    public abstract List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
