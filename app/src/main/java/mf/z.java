package mf;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptySet;

/* compiled from: Sets.kt */
/* loaded from: classes2.dex */
public class z extends y {
    public static final <T> Set<T> emptySet() {
        return EmptySet.f15206b;
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        zf.i.checkNotNullParameter(tArr, "elements");
        return (Set) i.toCollection(tArr, new LinkedHashSet(x.mapCapacity(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        zf.i.checkNotNullParameter(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : y.setOf(set.iterator().next()) : emptySet();
    }
}
