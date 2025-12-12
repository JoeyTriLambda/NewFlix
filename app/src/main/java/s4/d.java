package s4;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class d {
    public static <T> void checkBuilderRequirement(T t10, Class<T> cls) {
        if (t10 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T checkNotNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
