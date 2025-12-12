package w0;

import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public final class c {
    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int hash(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static <T> T requireNonNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static String toString(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> T requireNonNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
