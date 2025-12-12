package mf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;

/* compiled from: CollectionsJVM.kt */
/* loaded from: classes2.dex */
public class j {
    public static final <E> List<E> build(List<E> list) {
        zf.i.checkNotNullParameter(list, "builder");
        return ((ListBuilder) list).build();
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z10) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        if (z10 && zf.i.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        zf.i.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <E> List<E> createListBuilder() {
        return new ListBuilder();
    }

    public static final <T> List<T> listOf(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        zf.i.checkNotNullExpressionValue(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
