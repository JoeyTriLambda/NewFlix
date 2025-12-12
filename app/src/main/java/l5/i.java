package l5;

/* compiled from: VorbisBitArray.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f15825a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15826b;

    /* renamed from: c, reason: collision with root package name */
    public int f15827c;

    /* renamed from: d, reason: collision with root package name */
    public int f15828d;

    public i(byte[] bArr) {
        this.f15825a = bArr;
        this.f15826b = bArr.length;
    }

    public int getPosition() {
        return (this.f15827c * 8) + this.f15828d;
    }

    public boolean readBit() {
        boolean z10 = (((this.f15825a[this.f15827c] & 255) >> this.f15828d) & 1) == 1;
        skipBits(1);
        return z10;
    }

    public int readBits(int i10) {
        int i11 = this.f15827c;
        int iMin = Math.min(i10, 8 - this.f15828d);
        int i12 = i11 + 1;
        byte[] bArr = this.f15825a;
        int i13 = ((bArr[i11] & 255) >> this.f15828d) & (255 >> (8 - iMin));
        while (iMin < i10) {
            i13 |= (bArr[i12] & 255) << iMin;
            iMin += 8;
            i12++;
        }
        int i14 = i13 & ((-1) >>> (32 - i10));
        skipBits(i10);
        return i14;
    }

    public void skipBits(int i10) {
        int i11;
        int i12 = i10 / 8;
        int i13 = this.f15827c + i12;
        this.f15827c = i13;
        int i14 = (i10 - (i12 * 8)) + this.f15828d;
        this.f15828d = i14;
        boolean z10 = true;
        if (i14 > 7) {
            this.f15827c = i13 + 1;
            this.f15828d = i14 - 8;
        }
        int i15 = this.f15827c;
        if (i15 < 0 || (i15 >= (i11 = this.f15826b) && (i15 != i11 || this.f15828d != 0))) {
            z10 = false;
        }
        l6.a.checkState(z10);
    }
}
