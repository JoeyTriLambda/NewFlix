package of;

import java.util.Comparator;
import zf.i;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public class a {
    public static final <T extends Comparable<?>> int compareValues(T t10, T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        b bVar = b.f17085b;
        i.checkNotNull(bVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return bVar;
    }
}
