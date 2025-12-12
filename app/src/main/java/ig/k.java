package ig;

/* compiled from: StringNumberConversions.kt */
/* loaded from: classes2.dex */
public class k extends j {
    public static final Integer toIntOrNull(String str) {
        zf.i.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    public static final Long toLongOrNull(String str) {
        zf.i.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    public static final Integer toIntOrNull(String str, int i10) {
        boolean z10;
        int i11;
        int i12;
        zf.i.checkNotNullParameter(str, "<this>");
        a.checkRadix(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char cCharAt = str.charAt(0);
        int i14 = -2147483647;
        if (zf.i.compare((int) cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i14 = Integer.MIN_VALUE;
                z10 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z10 = false;
            }
        } else {
            z10 = false;
            i11 = 0;
        }
        int i15 = -59652323;
        while (i11 < length) {
            int iDigitOf = a.digitOf(str.charAt(i11), i10);
            if (iDigitOf < 0) {
                return null;
            }
            if ((i13 < i15 && (i15 != -59652323 || i13 < (i15 = i14 / i10))) || (i12 = i13 * i10) < i14 + iDigitOf) {
                return null;
            }
            i13 = i12 - iDigitOf;
            i11++;
        }
        return z10 ? Integer.valueOf(i13) : Integer.valueOf(-i13);
    }

    public static final Long toLongOrNull(String str, int i10) {
        boolean z10;
        zf.i.checkNotNullParameter(str, "<this>");
        a.checkRadix(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (zf.i.compare((int) cCharAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j10 = Long.MIN_VALUE;
                i11 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i11 = 1;
                z10 = false;
            }
        } else {
            z10 = false;
        }
        long j11 = -256204778801521550L;
        long j12 = 0;
        long j13 = -256204778801521550L;
        while (i11 < length) {
            int iDigitOf = a.digitOf(str.charAt(i11), i10);
            if (iDigitOf < 0) {
                return null;
            }
            if (j12 < j13) {
                if (j13 == j11) {
                    j13 = j10 / i10;
                    if (j12 < j13) {
                    }
                }
                return null;
            }
            long j14 = j12 * i10;
            long j15 = iDigitOf;
            if (j14 < j10 + j15) {
                return null;
            }
            j12 = j14 - j15;
            i11++;
            j11 = -256204778801521550L;
        }
        return z10 ? Long.valueOf(j12) : Long.valueOf(-j12);
    }
}
