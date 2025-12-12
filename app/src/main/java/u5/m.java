package u5;

import c5.r;

/* compiled from: SinglePeriodTimeline.java */
/* loaded from: classes.dex */
public final class m extends r {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f20098j = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final long f20099b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20100c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20101d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20102e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20103f;

    /* renamed from: g, reason: collision with root package name */
    public final long f20104g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f20105h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f20106i;

    public m(long j10, boolean z10) {
        this(j10, j10, 0L, 0L, z10, false);
    }

    @Override // c5.r
    public int getIndexOfPeriod(Object obj) {
        return f20098j.equals(obj) ? 0 : -1;
    }

    @Override // c5.r
    public r.b getPeriod(int i10, r.b bVar, boolean z10) {
        l6.a.checkIndex(i10, 0, 1);
        Object obj = z10 ? f20098j : null;
        return bVar.set(obj, obj, 0, this.f20101d, -this.f20103f);
    }

    @Override // c5.r
    public int getPeriodCount() {
        return 1;
    }

    @Override // c5.r
    public r.c getWindow(int i10, r.c cVar, boolean z10, long j10) {
        l6.a.checkIndex(i10, 0, 1);
        Object obj = z10 ? f20098j : null;
        boolean z11 = this.f20106i;
        long j11 = this.f20104g;
        if (z11) {
            j11 += j10;
            if (j11 > this.f20102e) {
                j11 = -9223372036854775807L;
            }
        }
        return cVar.set(obj, this.f20099b, this.f20100c, this.f20105h, z11, j11, this.f20102e, 0, 0, this.f20103f);
    }

    @Override // c5.r
    public int getWindowCount() {
        return 1;
    }

    public m(long j10, long j11, long j12, long j13, boolean z10, boolean z11) {
        this(-9223372036854775807L, -9223372036854775807L, j10, j11, j12, j13, z10, z11);
    }

    public m(long j10, long j11, long j12, long j13, long j14, long j15, boolean z10, boolean z11) {
        this.f20099b = j10;
        this.f20100c = j11;
        this.f20101d = j12;
        this.f20102e = j13;
        this.f20103f = j14;
        this.f20104g = j15;
        this.f20105h = z10;
        this.f20106i = z11;
    }
}
