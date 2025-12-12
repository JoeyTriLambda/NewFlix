package com.fasterxml.jackson.core.io;

import ac.c;
import com.loopj.android.http.AsyncHttpClient;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    private static NumberFormatException _badBD(String str) {
        return new NumberFormatException(c.k("Value \"", str, "\" can not be represented as BigDecimal"));
    }

    public static boolean inLongRange(char[] cArr, int i10, int i11, boolean z10) {
        String str = z10 ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i11 < length) {
            return true;
        }
        if (i11 > length) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            int iCharAt = cArr[i10 + i12] - str.charAt(i12);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static double parseAsDouble(String str, double d10) {
        if (str == null) {
            return d10;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return d10;
        }
        try {
            return parseDouble(strTrim);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    public static int parseAsInt(String str, int i10) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i10;
        }
        int i11 = 0;
        if (length > 0) {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i11 = 1;
            }
        }
        while (i11 < length) {
            char cCharAt2 = strTrim.charAt(i11);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return i10;
                }
            }
            i11++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i10;
        }
    }

    public static long parseAsLong(String str, long j10) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j10;
        }
        int i10 = 0;
        if (length > 0) {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i10 = 1;
            }
        }
        while (i10 < length) {
            char cCharAt2 = strTrim.charAt(i10);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (long) parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return j10;
                }
            }
            i10++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j10;
        }
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw _badBD(str);
        }
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if (NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int parseInt(char[] cArr, int i10, int i11) {
        int iA = cArr[(i10 + i11) - 1] - '0';
        switch (i11) {
            case 2:
                return c.A(cArr[i10], -48, 10, iA);
            case 3:
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            case 4:
                iA = c.A(cArr[i10], -48, 1000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            case 5:
                iA = c.A(cArr[i10], -48, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            case 6:
                iA = c.A(cArr[i10], -48, 100000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            case 7:
                iA = c.A(cArr[i10], -48, 1000000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            case 8:
                iA = c.A(cArr[i10], -48, 10000000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            case 9:
                iA = c.A(cArr[i10], -48, 100000000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 10000000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 1000, iA);
                i10++;
                iA = c.A(cArr[i10], -48, 100, iA);
                i10++;
                return c.A(cArr[i10], -48, 10, iA);
            default:
                return iA;
        }
    }

    public static long parseLong(char[] cArr, int i10, int i11) {
        int i12 = i11 - 9;
        return (parseInt(cArr, i10, i12) * L_BILLION) + parseInt(cArr, i10 + i12, 9);
    }

    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return parseBigDecimal(cArr, 0, cArr.length);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z10) {
        String str2 = z10 ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            int iCharAt = str.charAt(i10) - str2.charAt(i10);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i10, int i11) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i10, i11);
        } catch (NumberFormatException unused) {
            throw _badBD(new String(cArr, i10, i11));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
    
        return java.lang.Integer.parseInt(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int parseInt(java.lang.String r8) {
        /*
            r0 = 0
            char r1 = r8.charAt(r0)
            int r2 = r8.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = 1
        Lf:
            r3 = 10
            if (r0 == 0) goto L23
            if (r2 == r4) goto L1e
            if (r2 <= r3) goto L18
            goto L1e
        L18:
            char r1 = r8.charAt(r4)
            r4 = 2
            goto L2c
        L1e:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L23:
            r5 = 9
            if (r2 <= r5) goto L2c
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L2c:
            r5 = 57
            if (r1 > r5) goto L82
            r6 = 48
            if (r1 >= r6) goto L35
            goto L82
        L35:
            int r1 = r1 - r6
            if (r4 >= r2) goto L7e
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L79
            if (r4 >= r6) goto L43
            goto L79
        L43:
            int r1 = r1 * 10
            int r4 = r4 - r6
            int r1 = r1 + r4
            if (r7 >= r2) goto L7e
            int r4 = r7 + 1
            char r7 = r8.charAt(r7)
            if (r7 > r5) goto L74
            if (r7 >= r6) goto L54
            goto L74
        L54:
            int r1 = r1 * 10
            int r7 = r7 - r6
            int r1 = r1 + r7
            if (r4 >= r2) goto L7e
        L5a:
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L6f
            if (r4 >= r6) goto L65
            goto L6f
        L65:
            int r1 = r1 * 10
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r7 < r2) goto L6d
            goto L7e
        L6d:
            r4 = r7
            goto L5a
        L6f:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L74:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L79:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L7e:
            if (r0 == 0) goto L81
            int r1 = -r1
        L81:
            return r1
        L82:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }
}
