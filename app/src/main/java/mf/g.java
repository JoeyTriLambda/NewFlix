package mf;

import java.lang.reflect.Array;

/* compiled from: ArraysJVM.kt */
/* loaded from: classes2.dex */
public class g {
    public static final <T> T[] arrayOfNulls(T[] tArr, int i10) throws NegativeArraySizeException {
        zf.i.checkNotNullParameter(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i10);
        zf.i.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void copyOfRangeToIndexCheck(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }
}
