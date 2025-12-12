package cz.msebera.android.httpclient.conn.ssl;

import ac.c;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractVerifier implements X509HostnameVerifier {
    static final String[] BAD_COUNTRY_2LDS;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        BAD_COUNTRY_2LDS = strArr;
        Arrays.sort(strArr);
    }

    public static boolean acceptableCountryWildcard(String str) {
        return validCountryWildcard(str.split("\\."));
    }

    public static int countDots(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) == '.') {
                i10++;
            }
        }
        return i10;
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        String strFindMostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
        if (strFindMostSpecific != null) {
            return new String[]{strFindMostSpecific};
        }
        return null;
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) throws CertificateParsingException {
        List<SubjectName> subjectAltNames = DefaultHostnameVerifier.getSubjectAltNames(x509Certificate);
        if (subjectAltNames == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SubjectName subjectName : subjectAltNames) {
            if (subjectName.getType() == 2) {
                arrayList.add(subjectName.getValue());
            }
        }
        if (arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    private static boolean matchIdentity(String str, String str2, boolean z10) {
        boolean zEndsWith;
        if (str == null) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        String lowerCase2 = str2.toLowerCase(locale);
        String[] strArrSplit = lowerCase2.split("\\.");
        if (!(strArrSplit.length >= 3 && strArrSplit[0].endsWith("*") && (!z10 || validCountryWildcard(strArrSplit)))) {
            return lowerCase.equals(lowerCase2);
        }
        String str3 = strArrSplit[0];
        if (str3.length() > 1) {
            String strSubstring = str3.substring(0, str3.length() - 1);
            zEndsWith = lowerCase.startsWith(strSubstring) && lowerCase.substring(strSubstring.length()).endsWith(lowerCase2.substring(str3.length()));
        } else {
            zEndsWith = lowerCase.endsWith(lowerCase2.substring(1));
        }
        if (zEndsWith) {
            return !z10 || countDots(lowerCase) == countDots(lowerCase2);
        }
        return false;
    }

    private static boolean validCountryWildcard(String[] strArr) {
        return (strArr.length == 3 && strArr[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, strArr[1]) >= 0) ? false : true;
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String str, SSLSocket sSLSocket) throws CertificateParsingException, IOException {
        Args.notNull(str, "Host");
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            sSLSocket.getInputStream().available();
            session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.startHandshake();
                session = sSLSocket.getSession();
            }
        }
        verify(str, (X509Certificate) session.getPeerCertificates()[0]);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) throws CertificateParsingException {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e10) {
            if (this.log.isDebugEnabled()) {
                this.log.debug(e10.getMessage(), e10);
            }
            return false;
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String str, X509Certificate x509Certificate) throws SSLException, CertificateParsingException {
        List<SubjectName> subjectAltNames = DefaultHostnameVerifier.getSubjectAltNames(x509Certificate);
        ArrayList arrayList = new ArrayList();
        if (!InetAddressUtils.isIPv4Address(str) && !InetAddressUtils.isIPv6Address(str)) {
            for (SubjectName subjectName : subjectAltNames) {
                if (subjectName.getType() == 2) {
                    arrayList.add(subjectName.getValue());
                }
            }
        } else {
            for (SubjectName subjectName2 : subjectAltNames) {
                if (subjectName2.getType() == 7) {
                    arrayList.add(subjectName2.getValue());
                }
            }
        }
        String strFindMostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
        verify(str, strFindMostSpecific != null ? new String[]{strFindMostSpecific} : null, arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final void verify(String str, String[] strArr, String[] strArr2, boolean z10) throws SSLException {
        List<String> listAsList = null;
        String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        if (strArr2 != null && strArr2.length > 0) {
            listAsList = Arrays.asList(strArr2);
        }
        String strNormaliseAddress = InetAddressUtils.isIPv6Address(str) ? DefaultHostnameVerifier.normaliseAddress(str.toLowerCase(Locale.ROOT)) : str;
        if (listAsList == null) {
            if (str2 != null) {
                if (matchIdentity(strNormaliseAddress, InetAddressUtils.isIPv6Address(str2) ? DefaultHostnameVerifier.normaliseAddress(str2) : str2, z10)) {
                    return;
                }
                throw new SSLException("Certificate for <" + str + "> doesn't match common name of the certificate subject: " + str2);
            }
            throw new SSLException(c.k("Certificate subject for <", str, "> doesn't contain a common name and does not have alternative names"));
        }
        for (String strNormaliseAddress2 : listAsList) {
            if (InetAddressUtils.isIPv6Address(strNormaliseAddress2)) {
                strNormaliseAddress2 = DefaultHostnameVerifier.normaliseAddress(strNormaliseAddress2);
            }
            if (matchIdentity(strNormaliseAddress, strNormaliseAddress2, z10)) {
                return;
            }
        }
        throw new SSLException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + listAsList);
    }
}
