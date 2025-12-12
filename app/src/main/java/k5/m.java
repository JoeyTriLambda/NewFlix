package k5;

import l6.u;

/* compiled from: TrackSampleTable.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final int f14945a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f14946b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f14947c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14948d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f14949e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f14950f;

    public m(long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2) {
        l6.a.checkArgument(iArr.length == jArr2.length);
        l6.a.checkArgument(jArr.length == jArr2.length);
        l6.a.checkArgument(iArr2.length == jArr2.length);
        this.f14946b = jArr;
        this.f14947c = iArr;
        this.f14948d = i10;
        this.f14949e = jArr2;
        this.f14950f = iArr2;
        this.f14945a = jArr.length;
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long j10) {
        for (int iBinarySearchFloor = u.binarySearchFloor(this.f14949e, j10, true, false); iBinarySearchFloor >= 0; iBinarySearchFloor--) {
            if ((this.f14950f[iBinarySearchFloor] & 1) != 0) {
                return iBinarySearchFloor;
            }
        }
        return -1;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long j10) {
        long[] jArr = this.f14949e;
        for (int iBinarySearchCeil = u.binarySearchCeil(jArr, j10, true, false); iBinarySearchCeil < jArr.length; iBinarySearchCeil++) {
            if ((this.f14950f[iBinarySearchCeil] & 1) != 0) {
                return iBinarySearchCeil;
            }
        }
        return -1;
    }
}
