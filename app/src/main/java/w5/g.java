package w5;

/* compiled from: DashWrappingSegmentIndex.java */
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final g5.a f21003a;

    public g(g5.a aVar) {
        this.f21003a = aVar;
    }

    @Override // w5.f
    public long getDurationUs(int i10, long j10) {
        return this.f21003a.f12696d[i10];
    }

    @Override // w5.f
    public int getFirstSegmentNum() {
        return 0;
    }

    @Override // w5.f
    public int getSegmentCount(long j10) {
        return this.f21003a.f12693a;
    }

    @Override // w5.f
    public int getSegmentNum(long j10, long j11) {
        return this.f21003a.getChunkIndex(j10);
    }

    @Override // w5.f
    public x5.f getSegmentUrl(int i10) {
        return new x5.f(null, this.f21003a.f12695c[i10], r0.f12694b[i10]);
    }

    @Override // w5.f
    public long getTimeUs(int i10) {
        return this.f21003a.f12697e[i10];
    }

    @Override // w5.f
    public boolean isExplicit() {
        return true;
    }
}
