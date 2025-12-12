package pg;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f17692a = new b0("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [pg.e] */
    public static final <N extends e<N>> N close(N n6) {
        while (true) {
            Object objAccess$getNextOrClosed = e.access$getNextOrClosed(n6);
            if (objAccess$getNextOrClosed == f17692a) {
                return n6;
            }
            ?? r02 = (e) objAccess$getNextOrClosed;
            if (r02 != 0) {
                n6 = r02;
            } else if (n6.markAsClosed()) {
                return n6;
            }
        }
    }

    public static final <S extends y<S>> Object findSegmentInternal(S s10, long j10, yf.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.f17734n >= j10 && !s10.isRemoved()) {
                return z.m233constructorimpl(s10);
            }
            Object objAccess$getNextOrClosed = e.access$getNextOrClosed(s10);
            if (objAccess$getNextOrClosed == f17692a) {
                return z.m233constructorimpl(f17692a);
            }
            S sInvoke = (S) ((e) objAccess$getNextOrClosed);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s10.f17734n + 1), s10);
                if (s10.trySetNext(sInvoke)) {
                    if (s10.isRemoved()) {
                        s10.remove();
                    }
                }
            }
            s10 = sInvoke;
        }
    }
}
