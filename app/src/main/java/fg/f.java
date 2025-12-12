package fg;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes2.dex */
public final class f extends d {

    /* compiled from: PrimitiveRanges.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
        new f(1L, 0L);
    }

    public f(long j10, long j11) {
        super(j10, j11, 1L);
    }

    public boolean contains(long j10) {
        return getFirst() <= j10 && j10 <= getLast();
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (getFirst() != fVar.getFirst() || getLast() != fVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
