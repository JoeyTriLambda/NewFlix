package of;

import java.util.Comparator;
import zf.i;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class b implements Comparator<Comparable<? super Object>> {

    /* renamed from: b, reason: collision with root package name */
    public static final b f17085b = new b();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return c.f17086b;
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Comparable<Object> comparable, Comparable<Object> comparable2) {
        i.checkNotNullParameter(comparable, "a");
        i.checkNotNullParameter(comparable2, "b");
        return comparable.compareTo(comparable2);
    }
}
