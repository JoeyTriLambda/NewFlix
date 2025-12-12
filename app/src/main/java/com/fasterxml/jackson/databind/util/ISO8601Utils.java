package com.fasterxml.jackson.databind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

@Deprecated
/* loaded from: classes.dex */
public class ISO8601Utils {
    protected static final int DEF_8601_LEN = 29;
    private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("UTC");

    private static boolean checkOffset(String str, int i10, char c10) {
        return i10 < str.length() && str.charAt(i10) == c10;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_Z);
    }

    private static int indexOfNonDigit(String str, int i10) {
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < '0' || cCharAt > '9') {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4 A[Catch: Exception -> 0x0196, TryCatch #0 {Exception -> 0x0196, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:74:0x015c, B:58:0x00e8, B:59:0x00fe, B:60:0x00ff, B:62:0x0110, B:65:0x0119, B:67:0x012b, B:70:0x013a, B:71:0x0157, B:73:0x015a, B:76:0x018e, B:77:0x0195, B:41:0x00b6, B:42:0x00b9), top: B:89:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018e A[Catch: Exception -> 0x0196, TryCatch #0 {Exception -> 0x0196, blocks: (B:3:0x000a, B:5:0x001c, B:6:0x001e, B:8:0x002a, B:9:0x002c, B:11:0x003b, B:13:0x0041, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0075, B:25:0x007b, B:29:0x0085, B:34:0x0095, B:36:0x009d, B:48:0x00ce, B:50:0x00d4, B:52:0x00da, B:74:0x015c, B:58:0x00e8, B:59:0x00fe, B:60:0x00ff, B:62:0x0110, B:65:0x0119, B:67:0x012b, B:70:0x013a, B:71:0x0157, B:73:0x015a, B:76:0x018e, B:77:0x0195, B:41:0x00b6, B:42:0x00b9), top: B:89:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i10, int i11) throws NumberFormatException {
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

    public static String format(Date date, boolean z10) {
        return format(date, z10, TIMEZONE_Z);
    }

    @Deprecated
    public static String format(Date date, boolean z10, TimeZone timeZone) {
        return format(date, z10, timeZone, Locale.US);
    }

    public static String format(Date date, boolean z10, TimeZone timeZone, Locale locale) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, locale);
        gregorianCalendar.setTime(date);
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(String.format("%04d-%02d-%02dT%02d:%02d:%02d", Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13))));
        if (z10) {
            sb2.append(String.format(".%03d", Integer.valueOf(gregorianCalendar.get(14))));
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i10 = offset / 60000;
            int iAbs = Math.abs(i10 / 60);
            int iAbs2 = Math.abs(i10 % 60);
            Object[] objArr = new Object[3];
            objArr[0] = Character.valueOf(offset < 0 ? '-' : '+');
            objArr[1] = Integer.valueOf(iAbs);
            objArr[2] = Integer.valueOf(iAbs2);
            sb2.append(String.format("%c%02d:%02d", objArr));
        } else {
            sb2.append('Z');
        }
        return sb2.toString();
    }
}
