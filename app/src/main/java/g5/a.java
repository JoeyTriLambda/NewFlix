package g5;

import l6.u;

/* compiled from: ChunkIndex.java */
/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final int f12693a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f12694b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f12695c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f12696d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f12697e;

    /* renamed from: f, reason: collision with root package name */
    public final long f12698f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f12694b = iArr;
        this.f12695c = jArr;
        this.f12696d = jArr2;
        this.f12697e = jArr3;
        int length = iArr.length;
        this.f12693a = length;
        if (length > 0) {
            this.f12698f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f12698f = 0L;
        }
    }

    public int getChunkIndex(long j10) {
        return u.binarySearchFloor(this.f12697e, j10, true, true);
    }

    @Override // g5.l
    public long getDurationUs() {
        return this.f12698f;
    }

    @Override // g5.l
    public long getPosition(long j10) {
        return this.f12695c[getChunkIndex(j10)];
    }

    @Override // g5.l
    public boolean isSeekable() {
        return true;
    }
}
