package okhttp3.internal.tls;

import ah.a0;
import ig.l;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.text.StringsKt__StringsKt;
import mf.k;
import mf.q;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import org.apache.commons.lang3.ClassUtils;
import zf.i;

/* compiled from: OkHostnameVerifier.kt */
/* loaded from: classes2.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        i.checkNotNullExpressionValue(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i10) throws CertificateParsingException {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return k.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && i.areEqual(list.get(0), Integer.valueOf(i10)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return k.emptyList();
        }
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) a0.size$default(str, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strAsciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(strAsciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (i.areEqual(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) throws CertificateParsingException {
        i.checkNotNullParameter(x509Certificate, "certificate");
        return q.plus((Collection) getSubjectAltNames(x509Certificate, 7), (Iterable) getSubjectAltNames(x509Certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        i.checkNotNullParameter(str, "host");
        i.checkNotNullParameter(sSLSession, "session");
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(str, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        i.checkNotNullParameter(str, "host");
        i.checkNotNullParameter(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate) : verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (!(str == null || str.length() == 0) && !l.startsWith$default(str, ".", false, 2, null) && !l.endsWith$default(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !l.startsWith$default(str2, ".", false, 2, null) && !l.endsWith$default(str2, "..", false, 2, null)) {
                if (!l.endsWith$default(str, ".", false, 2, null)) {
                    str = i.stringPlus(str, ".");
                }
                String str3 = str;
                if (!l.endsWith$default(str2, ".", false, 2, null)) {
                    str2 = i.stringPlus(str2, ".");
                }
                String strAsciiToLowercase = asciiToLowercase(str2);
                if (!StringsKt__StringsKt.contains$default((CharSequence) strAsciiToLowercase, (CharSequence) "*", false, 2, (Object) null)) {
                    return i.areEqual(str3, strAsciiToLowercase);
                }
                if (!l.startsWith$default(strAsciiToLowercase, "*.", false, 2, null) || StringsKt__StringsKt.indexOf$default((CharSequence) strAsciiToLowercase, '*', 1, false, 4, (Object) null) != -1 || str3.length() < strAsciiToLowercase.length() || i.areEqual("*.", strAsciiToLowercase)) {
                    return false;
                }
                String strSubstring = strAsciiToLowercase.substring(1);
                i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (!l.endsWith$default(str3, strSubstring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - strSubstring.length();
                return length <= 0 || StringsKt__StringsKt.lastIndexOf$default((CharSequence) str3, ClassUtils.PACKAGE_SEPARATOR_CHAR, length + (-1), false, 4, (Object) null) == -1;
            }
        }
        return false;
    }
}
