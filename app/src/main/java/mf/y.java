package mf;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;

/* compiled from: SetsJVM.kt */
/* loaded from: classes2.dex */
public class y {
    public static final <E> Set<E> build(Set<E> set) {
        zf.i.checkNotNullParameter(set, "builder");
        return ((SetBuilder) set).build();
    }

    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static final <T> Set<T> setOf(T t10) {
        Set<T> setSingleton = Collections.singleton(t10);
        zf.i.checkNotNullExpressionValue(setSingleton, "singleton(element)");
        return setSingleton;
    }
}
