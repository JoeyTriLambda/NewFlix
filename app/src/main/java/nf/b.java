package nf;

import java.util.Arrays;
import java.util.List;
import zf.i;

/* compiled from: ListBuilder.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final boolean access$subarrayContentEquals(Object[] objArr, int i10, int i11, List list) {
        if (i11 != list.size()) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!i.areEqual(objArr[i10 + i12], list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    public static final int access$subarrayContentHashCode(Object[] objArr, int i10, int i11) {
        int iHashCode = 1;
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = objArr[i10 + i12];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final String access$subarrayContentToString(Object[] objArr, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(objArr[i10 + i12]);
        }
        sb2.append("]");
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final <E> E[] arrayOfUninitializedElements(int i10) {
        if (i10 >= 0) {
            return (E[]) new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i10) {
        i.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        i.checkNotNullExpressionValue(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int i10) {
        i.checkNotNullParameter(eArr, "<this>");
        eArr[i10] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i10, int i11) {
        i.checkNotNullParameter(eArr, "<this>");
        while (i10 < i11) {
            resetAt(eArr, i10);
            i10++;
        }
    }
}
