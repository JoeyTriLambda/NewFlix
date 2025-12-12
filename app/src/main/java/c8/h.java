package c8;

import java.lang.reflect.Array;

/* compiled from: ObjectArrays.java */
/* loaded from: classes.dex */
public final class h {
    public static void a(int i10, Object[] objArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (objArr[i11] == null) {
                StringBuilder sb2 = new StringBuilder(20);
                sb2.append("at index ");
                sb2.append(i11);
                throw new NullPointerException(sb2.toString());
            }
        }
    }

    public static <T> T[] newArray(T[] tArr, int i10) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
    }
}
