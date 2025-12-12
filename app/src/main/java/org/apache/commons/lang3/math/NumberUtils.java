package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static int compare(byte b10, byte b11) {
        return b10 - b11;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (str.trim().startsWith("--")) {
            throw new NumberFormatException(str.concat(" is not a valid number."));
        }
        return new BigDecimal(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.math.BigInteger createBigInteger(java.lang.String r4) {
        /*
            if (r4 != 0) goto L4
            r4 = 0
            return r4
        L4:
            java.lang.String r0 = "-"
            boolean r0 = r4.startsWith(r0)
            java.lang.String r1 = "0x"
            boolean r1 = r4.startsWith(r1, r0)
            r2 = 16
            if (r1 != 0) goto L42
            java.lang.String r1 = "0X"
            boolean r1 = r4.startsWith(r1, r0)
            if (r1 == 0) goto L1d
            goto L42
        L1d:
            java.lang.String r1 = "#"
            boolean r1 = r4.startsWith(r1, r0)
            if (r1 == 0) goto L28
            int r1 = r0 + 1
            goto L44
        L28:
            java.lang.String r1 = "0"
            boolean r1 = r4.startsWith(r1, r0)
            if (r1 == 0) goto L3e
            int r1 = r4.length()
            int r2 = r0 + 1
            if (r1 <= r2) goto L3e
            r1 = 8
            r1 = r2
            r2 = 8
            goto L44
        L3e:
            r2 = 10
            r1 = r0
            goto L44
        L42:
            int r1 = r0 + 2
        L44:
            java.math.BigInteger r3 = new java.math.BigInteger
            java.lang.String r4 = r4.substring(r1)
            r3.<init>(r4, r2)
            if (r0 == 0) goto L53
            java.math.BigInteger r3 = r3.negate()
        L53:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createBigInteger(java.lang.String):java.math.BigInteger");
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0120, code lost:
    
        if (r1 == 'l') goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0162 A[Catch: NumberFormatException -> 0x016d, TRY_LEAVE, TryCatch #4 {NumberFormatException -> 0x016d, blocks: (B:99:0x0158, B:101:0x0162), top: B:165:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0177 A[Catch: NumberFormatException -> 0x0183, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x0183, blocks: (B:106:0x016d, B:108:0x0177), top: B:161:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Number createNumber(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return !str.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ea, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0090, code lost:
    
        if (r3 >= r0.length) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0092, code lost:
    
        r0 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0094, code lost:
    
        if (r0 < '0') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0096, code lost:
    
        if (r0 > '9') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0098, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0099, code lost:
    
        if (r0 == 'e') goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x009b, code lost:
    
        if (r0 != 'E') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x009e, code lost:
    
        if (r0 != '.') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a0, code lost:
    
        if (r15 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a2, code lost:
    
        if (r14 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00a5, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00a6, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00a7, code lost:
    
        if (r7 != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ab, code lost:
    
        if (r0 == 'd') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00af, code lost:
    
        if (r0 == 'D') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b1, code lost:
    
        if (r0 == 'f') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00b5, code lost:
    
        if (r0 != 'F') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b7, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00ba, code lost:
    
        if (r0 == 'l') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00be, code lost:
    
        if (r0 != 'L') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00c1, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c2, code lost:
    
        if (r13 == false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00c4, code lost:
    
        if (r14 != false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00c6, code lost:
    
        if (r15 != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00c8, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00ca, code lost:
    
        if (r7 != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00cc, code lost:
    
        if (r13 == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00ce, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCreatable(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.isCreatable(java.lang.String):boolean");
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) != '-') {
            return withDecimalsParsing(str, 0);
        }
        if (str.length() == 1) {
            return false;
        }
        return withDecimalsParsing(str, 1);
    }

    public static byte max(byte b10, byte b11, byte b12) {
        if (b11 > b10) {
            b10 = b11;
        }
        return b12 > b10 ? b12 : b10;
    }

    public static byte min(byte b10, byte b11, byte b12) {
        if (b11 < b10) {
            b10 = b11;
        }
        return b12 < b10 ? b12 : b10;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    private static void validateArray(Object obj) {
        Validate.isTrue(obj != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    private static boolean withDecimalsParsing(String str, int i10) {
        int i11 = 0;
        while (i10 < str.length()) {
            boolean z10 = str.charAt(i10) == '.';
            if (z10) {
                i11++;
            }
            if (i11 > 1) {
                return false;
            }
            if (!z10 && !Character.isDigit(str.charAt(i10))) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public static int compare(int i10, int i11) {
        if (i10 == i11) {
            return 0;
        }
        return i10 < i11 ? -1 : 1;
    }

    private static String getMantissa(String str, int i10) {
        char cCharAt = str.charAt(0);
        return cCharAt == '-' || cCharAt == '+' ? str.substring(1, i10) : str.substring(0, i10);
    }

    public static int max(int i10, int i11, int i12) {
        if (i11 > i10) {
            i10 = i11;
        }
        return i12 > i10 ? i12 : i10;
    }

    public static int min(int i10, int i11, int i12) {
        if (i11 < i10) {
            i10 = i11;
        }
        return i12 < i10 ? i12 : i10;
    }

    public static byte toByte(String str, byte b10) {
        if (str == null) {
            return b10;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b10;
        }
    }

    public static double toDouble(String str, double d10) {
        if (str == null) {
            return d10;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    public static float toFloat(String str, float f10) {
        if (str == null) {
            return f10;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    public static int toInt(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static long toLong(String str, long j10) {
        if (str == null) {
            return j10;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i10, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i10, roundingMode);
    }

    public static short toShort(String str, short s10) {
        if (str == null) {
            return s10;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s10;
        }
    }

    public static int compare(long j10, long j11) {
        if (j10 == j11) {
            return 0;
        }
        return j10 < j11 ? -1 : 1;
    }

    public static long max(long j10, long j11, long j12) {
        if (j11 > j10) {
            j10 = j11;
        }
        return j12 > j10 ? j12 : j10;
    }

    public static long min(long j10, long j11, long j12) {
        if (j11 < j10) {
            j10 = j11;
        }
        return j12 < j10 ? j12 : j10;
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, 0.0d);
    }

    public static int compare(short s10, short s11) {
        if (s10 == s11) {
            return 0;
        }
        return s10 < s11 ? -1 : 1;
    }

    public static short max(short s10, short s11, short s12) {
        if (s11 > s10) {
            s10 = s11;
        }
        return s12 > s10 ? s12 : s10;
    }

    public static short min(short s10, short s11, short s12) {
        if (s11 < s10) {
            s10 = s11;
        }
        return s12 < s10 ? s12 : s10;
    }

    public static double toDouble(BigDecimal bigDecimal, double d10) {
        return bigDecimal == null ? d10 : bigDecimal.doubleValue();
    }

    public static BigDecimal toScaledBigDecimal(Float f10) {
        return toScaledBigDecimal(f10, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long j11 = jArr[i10];
            if (j11 > j10) {
                j10 = j11;
            }
        }
        return j10;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long j11 = jArr[i10];
            if (j11 < j10) {
                j10 = j11;
            }
        }
        return j10;
    }

    public static BigDecimal toScaledBigDecimal(Float f10, int i10, RoundingMode roundingMode) {
        if (f10 == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(f10.floatValue()), i10, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d10) {
        return toScaledBigDecimal(d10, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i10 = iArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            int i12 = iArr[i11];
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i10 = iArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            int i12 = iArr[i11];
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    public static BigDecimal toScaledBigDecimal(Double d10, int i10, RoundingMode roundingMode) {
        if (d10 == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d10.doubleValue()), i10, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s10 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            short s11 = sArr[i10];
            if (s11 > s10) {
                s10 = s11;
            }
        }
        return s10;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s10 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            short s11 = sArr[i10];
            if (s11 < s10) {
                s10 = s11;
            }
        }
        return s10;
    }

    public static BigDecimal toScaledBigDecimal(String str, int i10, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i10, roundingMode);
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b10 = bArr[0];
        for (int i10 = 1; i10 < bArr.length; i10++) {
            byte b11 = bArr[i10];
            if (b11 > b10) {
                b10 = b11;
            }
        }
        return b10;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b10 = bArr[0];
        for (int i10 = 1; i10 < bArr.length; i10++) {
            byte b11 = bArr[i10];
            if (b11 < b10) {
                b10 = b11;
            }
        }
        return b10;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            if (Double.isNaN(dArr[i10])) {
                return Double.NaN;
            }
            double d11 = dArr[i10];
            if (d11 > d10) {
                d10 = d11;
            }
        }
        return d10;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            if (Double.isNaN(dArr[i10])) {
                return Double.NaN;
            }
            double d11 = dArr[i10];
            if (d11 < d10) {
                d10 = d11;
            }
        }
        return d10;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f10 = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (Float.isNaN(fArr[i10])) {
                return Float.NaN;
            }
            float f11 = fArr[i10];
            if (f11 > f10) {
                f10 = f11;
            }
        }
        return f10;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f10 = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (Float.isNaN(fArr[i10])) {
                return Float.NaN;
            }
            float f11 = fArr[i10];
            if (f11 < f10) {
                f10 = f11;
            }
        }
        return f10;
    }

    public static double max(double d10, double d11, double d12) {
        return Math.max(Math.max(d10, d11), d12);
    }

    public static double min(double d10, double d11, double d12) {
        return Math.min(Math.min(d10, d11), d12);
    }

    public static float max(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    public static float min(float f10, float f11, float f12) {
        return Math.min(Math.min(f10, f11), f12);
    }
}
