package of;

import java.util.Comparator;
import zf.i;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class c implements Comparator<Comparable<? super Object>> {

    /* renamed from: b, reason: collision with root package name */
    public static final c f17086b = new c();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return b.f17085b;
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Comparable<Object> comparable, Comparable<Object> comparable2) {
        i.checkNotNullParameter(comparable, "a");
        i.checkNotNullParameter(comparable2, "b");
        return comparable2.compareTo(comparable);
    }
}
