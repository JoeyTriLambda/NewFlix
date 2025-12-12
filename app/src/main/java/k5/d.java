package k5;

import l6.u;

/* compiled from: FixedSampleSizeRechunker.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: FixedSampleSizeRechunker.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f14824a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f14825b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14826c;

        /* renamed from: d, reason: collision with root package name */
        public final long[] f14827d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f14828e;

        public a(long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2) {
            this.f14824a = jArr;
            this.f14825b = iArr;
            this.f14826c = i10;
            this.f14827d = jArr2;
            this.f14828e = iArr2;
        }
    }

    public static a rechunk(int i10, long[] jArr, int[] iArr, long j10) {
        int i11 = 8192 / i10;
        int iCeilDivide = 0;
        for (int i12 : iArr) {
            iCeilDivide += u.ceilDivide(i12, i11);
        }
        long[] jArr2 = new long[iCeilDivide];
        int[] iArr2 = new int[iCeilDivide];
        long[] jArr3 = new long[iCeilDivide];
        int[] iArr3 = new int[iCeilDivide];
        int i13 = 0;
        int i14 = 0;
        int iMax = 0;
        for (int i15 = 0; i15 < iArr.length; i15++) {
            int i16 = iArr[i15];
            long j11 = jArr[i15];
            while (i16 > 0) {
                int iMin = Math.min(i11, i16);
                jArr2[i14] = j11;
                int i17 = i10 * iMin;
                iArr2[i14] = i17;
                iMax = Math.max(iMax, i17);
                jArr3[i14] = i13 * j10;
                iArr3[i14] = 1;
                j11 += iArr2[i14];
                i13 += iMin;
                i16 -= iMin;
                i14++;
            }
        }
        return new a(jArr2, iArr2, iMax, jArr3, iArr3);
    }
}
