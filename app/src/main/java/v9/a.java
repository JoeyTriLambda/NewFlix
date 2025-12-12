package v9;

/* compiled from: $Gson$Preconditions.java */
/* loaded from: classes.dex */
public final class a {
    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }
}
