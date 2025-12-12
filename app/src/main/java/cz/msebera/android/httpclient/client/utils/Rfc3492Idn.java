package cz.msebera.android.httpclient.client.utils;

import ac.c;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ClassUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public class Rfc3492Idn implements Idn {
    private static final String ACE_PREFIX = "xn--";
    private static final int base = 36;
    private static final int damp = 700;
    private static final char delimiter = '-';
    private static final int initial_bias = 72;
    private static final int initial_n = 128;
    private static final int skew = 38;
    private static final int tmax = 26;
    private static final int tmin = 1;

    private int adapt(int i10, int i11, boolean z10) {
        int i12 = z10 ? i10 / damp : i10 / 2;
        int i13 = (i12 / i11) + i12;
        int i14 = 0;
        while (i13 > 455) {
            i13 /= 35;
            i14 += 36;
        }
        return ((i13 * 36) / (i13 + 38)) + i14;
    }

    private int digit(char c10) {
        if (c10 >= 'A' && c10 <= 'Z') {
            return c10 - 'A';
        }
        if (c10 >= 'a' && c10 <= 'z') {
            return c10 - 'a';
        }
        if (c10 < '0' || c10 > '9') {
            throw new IllegalArgumentException(c.e("illegal digit: ", c10));
        }
        return (c10 - '0') + 26;
    }

    public String decode(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        int iLastIndexOf = str.lastIndexOf(45);
        int length = 128;
        int iAdapt = 72;
        if (iLastIndexOf != -1) {
            sb2.append(str.subSequence(0, iLastIndexOf));
            str = str.substring(iLastIndexOf + 1);
        }
        int i10 = 0;
        while (!str.isEmpty()) {
            int i11 = 36;
            int i12 = i10;
            int i13 = 1;
            while (!str.isEmpty()) {
                char cCharAt = str.charAt(0);
                str = str.substring(1);
                int iDigit = digit(cCharAt);
                i12 += iDigit * i13;
                int i14 = i11 <= iAdapt + 1 ? 1 : i11 >= iAdapt + 26 ? 26 : i11 - iAdapt;
                if (iDigit < i14) {
                    break;
                }
                i13 *= 36 - i14;
                i11 += 36;
            }
            iAdapt = adapt(i12 - i10, sb2.length() + 1, i10 == 0);
            length += i12 / (sb2.length() + 1);
            int length2 = i12 % (sb2.length() + 1);
            sb2.insert(length2, (char) length);
            i10 = length2 + 1;
        }
        return sb2.toString();
    }

    @Override // cz.msebera.android.httpclient.client.utils.Idn
    public String toUnicode(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (sb2.length() > 0) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            if (strNextToken.startsWith(ACE_PREFIX)) {
                strNextToken = decode(strNextToken.substring(4));
            }
            sb2.append(strNextToken);
        }
        return sb2.toString();
    }
}
