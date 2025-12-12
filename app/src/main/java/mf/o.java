package mf;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: MutableCollections.kt */
/* loaded from: classes2.dex */
public class o extends n {
    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        zf.i.checkNotNullParameter(collection, "<this>");
        zf.i.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        zf.i.checkNotNullParameter(collection, "<this>");
        zf.i.checkNotNullParameter(tArr, "elements");
        return collection.addAll(h.asList(tArr));
    }
}
