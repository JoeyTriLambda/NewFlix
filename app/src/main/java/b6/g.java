package b6;

/* compiled from: SubtitleInputBuffer.java */
/* loaded from: classes.dex */
public final class g extends e5.e implements Comparable<g> {

    /* renamed from: q, reason: collision with root package name */
    public long f4782q;

    public g() {
        super(1);
    }

    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        if (isEndOfStream() != gVar.isEndOfStream()) {
            return isEndOfStream() ? 1 : -1;
        }
        long j10 = this.f11143o - gVar.f11143o;
        if (j10 == 0) {
            return 0;
        }
        return j10 > 0 ? 1 : -1;
    }
}
