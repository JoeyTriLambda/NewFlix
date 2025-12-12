package b8;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class e {
    public static String a(int i10, int i11, String str) {
        if (i10 < 0) {
            return f.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return f.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static void checkArgument(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i10, int i11) {
        return checkElementIndex(i10, i11, "index");
    }

    public static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static int checkPositionIndex(int i10, int i11) {
        return checkPositionIndex(i10, i11, "index");
    }

    public static void checkPositionIndexes(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? a(i10, i12, "start index") : (i11 < 0 || i11 > i12) ? a(i11, i12, "end index") : f.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public static void checkState(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalArgumentException(f.lenientFormat(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static int checkElementIndex(int i10, int i11, String str) {
        String strLenientFormat;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            strLenientFormat = f.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("negative size: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            strLenientFormat = f.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(strLenientFormat);
    }

    public static <T> T checkNotNull(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkPositionIndex(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(a(i10, i11, str));
        }
        return i10;
    }

    public static void checkState(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalStateException(f.lenientFormat(str, obj));
        }
    }
}
