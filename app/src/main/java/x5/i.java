package x5;

/* compiled from: SingleSegmentIndex.java */
/* loaded from: classes.dex */
public final class i implements w5.f {

    /* renamed from: a, reason: collision with root package name */
    public final f f21613a;

    public i(f fVar) {
        this.f21613a = fVar;
    }

    @Override // w5.f
    public int getFirstSegmentNum() {
        return 0;
    }

    @Override // w5.f
    public int getSegmentCount(long j10) {
        return 1;
    }

    @Override // w5.f
    public int getSegmentNum(long j10, long j11) {
        return 0;
    }

    @Override // w5.f
    public f getSegmentUrl(int i10) {
        return this.f21613a;
    }

    @Override // w5.f
    public long getTimeUs(int i10) {
        return 0L;
    }

    @Override // w5.f
    public boolean isExplicit() {
        return true;
    }

    @Override // w5.f
    public long getDurationUs(int i10, long j10) {
        return j10;
    }
}
