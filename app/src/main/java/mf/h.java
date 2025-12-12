package mf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes2.dex */
public class h extends g {
    public static final <T> List<T> asList(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        List<T> listAsList = Arrays.asList(tArr);
        zf.i.checkNotNullExpressionValue(listAsList, "asList(this)");
        return listAsList;
    }

    public static final <T> T[] copyInto(T[] tArr, T[] tArr2, int i10, int i11, int i12) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        zf.i.checkNotNullParameter(tArr2, "destination");
        System.arraycopy(tArr, i11, tArr2, i10, i12 - i11);
        return tArr2;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return copyInto(objArr, objArr2, i10, i11, i12);
    }

    public static final <T> T[] copyOfRange(T[] tArr, int i10, int i11) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        g.copyOfRangeToIndexCheck(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        zf.i.checkNotNullExpressionValue(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> void fill(T[] tArr, T t10, int i10, int i11) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        fill(objArr, obj, i10, i11);
    }

    public static final byte[] plus(byte[] bArr, byte b10) {
        zf.i.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b10;
        zf.i.checkNotNullExpressionValue(bArrCopyOf, "result");
        return bArrCopyOf;
    }

    public static final <T> void sort(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        zf.i.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final byte[] copyInto(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        zf.i.checkNotNullParameter(bArr, "<this>");
        zf.i.checkNotNullParameter(bArr2, "destination");
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
        return bArr2;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return copyInto(bArr, bArr2, i10, i11, i12);
    }

    public static final void fill(int[] iArr, int i10, int i11, int i12) {
        zf.i.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        fill(iArr, i10, i11, i12);
    }

    public static final byte[] copyOfRange(byte[] bArr, int i10, int i11) {
        zf.i.checkNotNullParameter(bArr, "<this>");
        g.copyOfRangeToIndexCheck(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        zf.i.checkNotNullExpressionValue(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    public static final byte[] plus(byte[] bArr, byte[] bArr2) {
        zf.i.checkNotNullParameter(bArr, "<this>");
        zf.i.checkNotNullParameter(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        zf.i.checkNotNullExpressionValue(bArrCopyOf, "result");
        return bArrCopyOf;
    }
}
