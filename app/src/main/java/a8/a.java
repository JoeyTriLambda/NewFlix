package a8;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class a {
    public static <T> T a(T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("null reference");
    }

    public static <T> T a(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void a(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }
}
