package b8;

import java.util.Arrays;

/* compiled from: Objects.java */
/* loaded from: classes.dex */
public final class d {
    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
