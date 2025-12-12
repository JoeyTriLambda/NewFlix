package okhttp3;

import ac.c;
import com.fasterxml.jackson.core.JsonPointer;
import ig.l;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.text.StringsKt__StringsKt;
import mf.k;
import mf.q;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.apache.commons.lang3.ClassUtils;
import yf.a;
import zf.f;
import zf.i;
import zf.n;

/* compiled from: CertificatePinner.kt */
/* loaded from: classes2.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* compiled from: CertificatePinner.kt */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            i.checkNotNullParameter(str, "pattern");
            i.checkNotNullParameter(strArr, "pins");
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                String str2 = strArr[i10];
                i10++;
                getPins().add(new Pin(str, str2));
            }
            return this;
        }

        public final CertificatePinner build() {
            return new CertificatePinner(q.toSet(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* compiled from: CertificatePinner.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String pin(Certificate certificate) {
            i.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return i.stringPlus("sha256/", sha256Hash((X509Certificate) certificate).base64());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString sha1Hash(X509Certificate x509Certificate) {
            i.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.a aVar = ByteString.f17101o;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            i.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.a.of$default(aVar, encoded, 0, 0, 3, null).sha1();
        }

        public final ByteString sha256Hash(X509Certificate x509Certificate) {
            i.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.a aVar = ByteString.f17101o;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            i.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.a.of$default(aVar, encoded, 0, 0, 3, null).sha256();
        }
    }

    /* compiled from: CertificatePinner.kt */
    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            i.checkNotNullParameter(str, "pattern");
            i.checkNotNullParameter(str2, "pin");
            if (!((l.startsWith$default(str, "*.", false, 2, null) && StringsKt__StringsKt.indexOf$default((CharSequence) str, "*", 1, false, 4, (Object) null) == -1) || (l.startsWith$default(str, "**.", false, 2, null) && StringsKt__StringsKt.indexOf$default((CharSequence) str, "*", 2, false, 4, (Object) null) == -1) || StringsKt__StringsKt.indexOf$default((CharSequence) str, "*", 0, false, 6, (Object) null) == -1)) {
                throw new IllegalArgumentException(i.stringPlus("Unexpected pattern: ", str).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(i.stringPlus("Invalid pattern: ", str));
            }
            this.pattern = canonicalHost;
            if (l.startsWith$default(str2, "sha1/", false, 2, null)) {
                this.hashAlgorithm = "sha1";
                ByteString.a aVar = ByteString.f17101o;
                String strSubstring = str2.substring(5);
                i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                ByteString byteStringDecodeBase64 = aVar.decodeBase64(strSubstring);
                if (byteStringDecodeBase64 == null) {
                    throw new IllegalArgumentException(i.stringPlus("Invalid pin hash: ", str2));
                }
                this.hash = byteStringDecodeBase64;
                return;
            }
            if (!l.startsWith$default(str2, "sha256/", false, 2, null)) {
                throw new IllegalArgumentException(i.stringPlus("pins must start with 'sha256/' or 'sha1/': ", str2));
            }
            this.hashAlgorithm = "sha256";
            ByteString.a aVar2 = ByteString.f17101o;
            String strSubstring2 = str2.substring(7);
            i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            ByteString byteStringDecodeBase642 = aVar2.decodeBase64(strSubstring2);
            if (byteStringDecodeBase642 == null) {
                throw new IllegalArgumentException(i.stringPlus("Invalid pin hash: ", str2));
            }
            this.hash = byteStringDecodeBase642;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return i.areEqual(this.pattern, pin.pattern) && i.areEqual(this.hashAlgorithm, pin.hashAlgorithm) && i.areEqual(this.hash, pin.hash);
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + c.b(this.hashAlgorithm, this.pattern.hashCode() * 31, 31);
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            i.checkNotNullParameter(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (i.areEqual(str, "sha256")) {
                return i.areEqual(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (i.areEqual(str, "sha1")) {
                return i.areEqual(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        public final boolean matchesHostname(String str) {
            i.checkNotNullParameter(str, "hostname");
            if (l.startsWith$default(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                if (!l.regionMatches(str, str.length() - length, this.pattern, 3, length, (16 & 16) != 0 ? false : false)) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!l.startsWith$default(this.pattern, "*.", false, 2, null)) {
                    return i.areEqual(str, this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                if (!l.regionMatches(str, str.length() - length3, this.pattern, 1, length3, (16 & 16) != 0 ? false : false) || StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ClassUtils.PACKAGE_SEPARATOR_CHAR, length4 - 1, false, 4, (Object) null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + JsonPointer.SEPARATOR + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        i.checkNotNullParameter(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(final String str, final List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        i.checkNotNullParameter(str, "hostname");
        i.checkNotNullParameter(list, "peerCertificates");
        check$okhttp(str, new a<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner.check.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // yf.a
            public final List<? extends X509Certificate> invoke() {
                CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                List<Certificate> listClean = certificateChainCleaner$okhttp == null ? null : certificateChainCleaner$okhttp.clean(list, str);
                if (listClean == null) {
                    listClean = list;
                }
                List<Certificate> list2 = listClean;
                ArrayList arrayList = new ArrayList(mf.l.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add((X509Certificate) ((Certificate) it.next()));
                }
                return arrayList;
            }
        });
    }

    public final void check$okhttp(String str, a<? extends List<? extends X509Certificate>> aVar) throws SSLPeerUnverifiedException {
        i.checkNotNullParameter(str, "hostname");
        i.checkNotNullParameter(aVar, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = aVar.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            ByteString byteStringSha256Hash = null;
            ByteString byteStringSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (i.areEqual(hashAlgorithm, "sha256")) {
                    if (byteStringSha256Hash == null) {
                        byteStringSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (i.areEqual(pin.getHash(), byteStringSha256Hash)) {
                        return;
                    }
                } else {
                    if (!i.areEqual(hashAlgorithm, "sha1")) {
                        throw new AssertionError(i.stringPlus("unsupported hashAlgorithm: ", pin.getHashAlgorithm()));
                    }
                    if (byteStringSha1Hash == null) {
                        byteStringSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (i.areEqual(pin.getHash(), byteStringSha1Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb2.append("\n    ");
            sb2.append(Companion.pin(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb2.append("\n    ");
            sb2.append(pin2);
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (i.areEqual(certificatePinner.pins, this.pins) && i.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String str) {
        i.checkNotNullParameter(str, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> listEmptyList = k.emptyList();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                n.asMutableList(listEmptyList).add(obj);
            }
        }
        return listEmptyList;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        i.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        return i.areEqual(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        i.checkNotNullParameter(str, "hostname");
        i.checkNotNullParameter(certificateArr, "peerCertificates");
        check(str, mf.i.toList(certificateArr));
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i10, f fVar) {
        this(set, (i10 & 2) != 0 ? null : certificateChainCleaner);
    }
}
