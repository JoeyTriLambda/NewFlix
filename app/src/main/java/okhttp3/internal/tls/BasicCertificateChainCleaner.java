package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import zf.f;
import zf.i;

/* compiled from: BasicCertificateChainCleaner.kt */
/* loaded from: classes2.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    /* compiled from: BasicCertificateChainCleaner.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        i.checkNotNullParameter(trustRootIndex, "trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    private final boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (!i.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        i.checkNotNullParameter(list, "chain");
        i.checkNotNullParameter(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        i.checkNotNullExpressionValue(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < 9) {
            i10++;
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateFindByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (x509CertificateFindByIssuerAndSignature == null) {
                Iterator it = arrayDeque.iterator();
                i.checkNotNullExpressionValue(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (verifySignature(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException(i.stringPlus("Failed to find a trusted cert that signed ", x509Certificate));
            }
            if (arrayList.size() > 1 || !i.areEqual(x509Certificate, x509CertificateFindByIssuerAndSignature)) {
                arrayList.add(x509CertificateFindByIssuerAndSignature);
            }
            if (verifySignature(x509CertificateFindByIssuerAndSignature, x509CertificateFindByIssuerAndSignature)) {
                return arrayList;
            }
            z10 = true;
        }
        throw new SSLPeerUnverifiedException(i.stringPlus("Certificate chain too long: ", arrayList));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && i.areEqual(((BasicCertificateChainCleaner) obj).trustRootIndex, this.trustRootIndex);
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
