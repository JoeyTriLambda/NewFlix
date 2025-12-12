package mf;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes2.dex */
public class n extends m {
    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        zf.i.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        zf.i.checkNotNullParameter(list, "<this>");
        zf.i.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
