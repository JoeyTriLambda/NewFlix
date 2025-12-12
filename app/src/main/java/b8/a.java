package b8;

import cz.msebera.android.httpclient.message.TokenParser;

/* compiled from: Ascii.java */
/* loaded from: classes.dex */
public final class a {
    public static boolean isUpperCase(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (isUpperCase(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (isUpperCase(c10)) {
                        charArray[i10] = (char) (c10 ^ TokenParser.SP);
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }
}
