package mf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public class k extends j {
    public static final <T> Collection<T> asCollection(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        return new e(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t10, int i10, int i11) {
        zf.i.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (i10 > i11) {
            throw new IllegalArgumentException("fromIndex (" + i10 + ") is greater than toIndex (" + i11 + ").");
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException(o1.a.d("fromIndex (", i10, ") is less than zero."));
        }
        if (i11 > size) {
            throw new IndexOutOfBoundsException("toIndex (" + i11 + ") is greater than size (" + size + ").");
        }
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iCompareValues = of.a.compareValues(list.get(i13), t10);
            if (iCompareValues < 0) {
                i10 = i13 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return binarySearch(list, comparable, i10, i11);
    }

    public static final <T> List<T> emptyList() {
        return EmptyList.f15204b;
    }

    public static final fg.c getIndices(Collection<?> collection) {
        zf.i.checkNotNullParameter(collection, "<this>");
        return new fg.c(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static final <T> List<T> listOf(T... tArr) {
        zf.i.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? h.asList(tArr) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        zf.i.checkNotNullParameter(tArr, "elements");
        return i.filterNotNull(tArr);
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        zf.i.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new e(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : j.listOf(list.get(0)) : emptyList();
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
