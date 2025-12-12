package fg;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes2.dex */
public final class c extends fg.a {

    /* renamed from: p, reason: collision with root package name */
    public static final a f11552p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final c f11553q = new c(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final c getEMPTY() {
            return c.f11553q;
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    public boolean contains(int i10) {
        return getFirst() <= i10 && i10 <= getLast();
    }

    @Override // fg.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (getFirst() != cVar.getFirst() || getLast() != cVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }

    @Override // fg.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // fg.a
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // fg.a
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
