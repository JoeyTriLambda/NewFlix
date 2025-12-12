package pg;

import pg.y;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes2.dex */
public final class z<S extends y<S>> {
    /* renamed from: getSegment-impl, reason: not valid java name */
    public static final S m234getSegmentimpl(Object obj) {
        if (obj == d.f17692a) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        zf.i.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m235isClosedimpl(Object obj) {
        return obj == d.f17692a;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <S extends y<S>> Object m233constructorimpl(Object obj) {
        return obj;
    }
}
