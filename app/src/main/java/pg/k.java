package pg;

import java.util.ArrayList;

/* compiled from: InlineList.kt */
/* loaded from: classes2.dex */
public final class k<E> {
    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Object m231constructorimpl$default(Object obj, int i10, zf.f fVar) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return m230constructorimpl(obj);
    }

    /* renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m232plusFjFbRPM(Object obj, E e10) {
        if (obj == null) {
            return m230constructorimpl(e10);
        }
        if (obj instanceof ArrayList) {
            zf.i.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e10);
            return m230constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e10);
        return m230constructorimpl(arrayList);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <E> Object m230constructorimpl(Object obj) {
        return obj;
    }
}
