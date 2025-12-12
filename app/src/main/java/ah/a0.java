package ah;

/* compiled from: Utf8.kt */
/* loaded from: classes2.dex */
public final class a0 {
    public static final long size(String str, int i10, int i11) {
        int i12;
        zf.i.checkNotNullParameter(str, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(ac.c.g("endIndex < beginIndex: ", i11, " < ", i10).toString());
        }
        if (!(i11 <= str.length())) {
            StringBuilder sbS = ac.c.s("endIndex > string.length: ", i11, " > ");
            sbS.append(str.length());
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        long j10 = 0;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                j10++;
            } else {
                if (cCharAt < 2048) {
                    i12 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i12 = 3;
                } else {
                    int i13 = i10 + 1;
                    char cCharAt2 = i13 < i11 ? str.charAt(i13) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j10++;
                        i10 = i13;
                    } else {
                        j10 += 4;
                        i10 += 2;
                    }
                }
                j10 += i12;
            }
            i10++;
        }
        return j10;
    }

    public static /* synthetic */ long size$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return size(str, i10, i11);
    }
}
