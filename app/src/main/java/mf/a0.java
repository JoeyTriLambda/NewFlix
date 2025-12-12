package mf;

import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: _Sets.kt */
/* loaded from: classes2.dex */
public class a0 extends z {
    public static final <T> Set<T> plus(Set<? extends T> set, T t10) {
        zf.i.checkNotNullParameter(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(x.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }
}
