package cz.msebera.android.httpclient.util;

/* loaded from: classes2.dex */
public final class TextUtils {
    public static boolean containsBlanks(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (Character.isWhitespace(charSequence.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!Character.isWhitespace(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
