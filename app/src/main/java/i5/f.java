package i5;

import java.io.IOException;

/* compiled from: VarintReader.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f13208d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f13209a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f13210b;

    /* renamed from: c, reason: collision with root package name */
    public int f13211c;

    public static long assembleVarint(byte[] bArr, int i10, boolean z10) {
        long j10 = bArr[0] & 255;
        if (z10) {
            j10 &= ~f13208d[i10 - 1];
        }
        for (int i11 = 1; i11 < i10; i11++) {
            j10 = (j10 << 8) | (bArr[i11] & 255);
        }
        return j10;
    }

    public static int parseUnsignedVarintLength(int i10) {
        for (int i11 = 0; i11 < 8; i11++) {
            if ((f13208d[i11] & i10) != 0) {
                return i11 + 1;
            }
        }
        return -1;
    }

    public int getLastLength() {
        return this.f13211c;
    }

    public long readUnsignedVarint(g5.f fVar, boolean z10, boolean z11, int i10) throws InterruptedException, IOException {
        int i11 = this.f13210b;
        byte[] bArr = this.f13209a;
        if (i11 == 0) {
            if (!((g5.b) fVar).readFully(bArr, 0, 1, z10)) {
                return -1L;
            }
            int unsignedVarintLength = parseUnsignedVarintLength(bArr[0] & 255);
            this.f13211c = unsignedVarintLength;
            if (unsignedVarintLength == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f13210b = 1;
        }
        int i12 = this.f13211c;
        if (i12 > i10) {
            this.f13210b = 0;
            return -2L;
        }
        if (i12 != 1) {
            ((g5.b) fVar).readFully(bArr, 1, i12 - 1);
        }
        this.f13210b = 0;
        return assembleVarint(bArr, this.f13211c, z11);
    }

    public void reset() {
        this.f13210b = 0;
        this.f13211c = 0;
    }
}
