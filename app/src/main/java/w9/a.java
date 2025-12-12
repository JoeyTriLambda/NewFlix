package w9;

import java.util.TimeZone;

/* compiled from: ISO8601Utils.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f21043a = TimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i10, char c10) {
        return i10 < str.length() && str.charAt(i10) == c10;
    }

    public static int b(String str, int i10, int i11) throws NumberFormatException {
        int i12;
        int i13;
        if (i10 < 0 || i11 > str.length() || i10 > i11) {
            throw new NumberFormatException(str);
        }
        if (i10 < i11) {
            i13 = i10 + 1;
            int iDigit = Character.digit(str.charAt(i10), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
            i12 = -iDigit;
        } else {
            i12 = 0;
            i13 = i10;
        }
        while (i13 < i11) {
            int i14 = i13 + 1;
            int iDigit2 = Character.digit(str.charAt(i13), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
            i12 = (i12 * 10) - iDigit2;
            i13 = i14;
        }
        return -i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef A[Catch: IllegalArgumentException -> 0x00b8, NumberFormatException -> 0x00bb, IndexOutOfBoundsException -> 0x00be, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x00b8, IndexOutOfBoundsException -> 0x00be, NumberFormatException -> 0x00bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:37:0x00a0, B:39:0x00a6, B:44:0x00b3, B:52:0x00c6, B:63:0x00e9, B:65:0x00ef, B:93:0x01a7, B:74:0x0104, B:75:0x011f, B:76:0x0120, B:80:0x013c, B:82:0x0149, B:85:0x0152, B:87:0x0171, B:90:0x0180, B:91:0x01a2, B:79:0x012b, B:95:0x01d8, B:96:0x01df, B:56:0x00d6, B:57:0x00d9, B:51:0x00c1), top: B:107:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d8 A[Catch: IllegalArgumentException -> 0x00b8, NumberFormatException -> 0x00bb, IndexOutOfBoundsException -> 0x00be, TryCatch #2 {IllegalArgumentException -> 0x00b8, IndexOutOfBoundsException -> 0x00be, NumberFormatException -> 0x00bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:37:0x00a0, B:39:0x00a6, B:44:0x00b3, B:52:0x00c6, B:63:0x00e9, B:65:0x00ef, B:93:0x01a7, B:74:0x0104, B:75:0x011f, B:76:0x0120, B:80:0x013c, B:82:0x0149, B:85:0x0152, B:87:0x0171, B:90:0x0180, B:91:0x01a2, B:79:0x012b, B:95:0x01d8, B:96:0x01df, B:56:0x00d6, B:57:0x00d9, B:51:0x00c1), top: B:107:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w9.a.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }
}
