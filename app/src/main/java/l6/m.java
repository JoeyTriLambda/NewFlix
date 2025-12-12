package l6;

/* compiled from: ParsableNalUnitBitArray.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f15884a;

    /* renamed from: b, reason: collision with root package name */
    public int f15885b;

    /* renamed from: c, reason: collision with root package name */
    public int f15886c;

    /* renamed from: d, reason: collision with root package name */
    public int f15887d;

    public m(byte[] bArr, int i10, int i11) {
        reset(bArr, i10, i11);
    }

    public final void a() {
        int i10;
        int i11 = this.f15886c;
        a.checkState(i11 >= 0 && (i11 < (i10 = this.f15885b) || (i11 == i10 && this.f15887d == 0)));
    }

    public final boolean b(int i10) {
        if (2 <= i10 && i10 < this.f15885b) {
            byte[] bArr = this.f15884a;
            if (bArr[i10] == 3 && bArr[i10 - 2] == 0 && bArr[i10 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canReadBits(int i10) {
        int i11 = this.f15886c;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        int i14 = (this.f15887d + i10) - (i12 * 8);
        if (i14 > 7) {
            i13++;
            i14 -= 8;
        }
        while (true) {
            i11++;
            if (i11 > i13 || i13 >= this.f15885b) {
                break;
            }
            if (b(i11)) {
                i13++;
                i11 += 2;
            }
        }
        int i15 = this.f15885b;
        if (i13 >= i15) {
            return i13 == i15 && i14 == 0;
        }
        return true;
    }

    public boolean canReadExpGolombCodedNum() {
        int i10 = this.f15886c;
        int i11 = this.f15887d;
        int i12 = 0;
        while (this.f15886c < this.f15885b && !readBit()) {
            i12++;
        }
        boolean z10 = this.f15886c == this.f15885b;
        this.f15886c = i10;
        this.f15887d = i11;
        return !z10 && canReadBits((i12 * 2) + 1);
    }

    public boolean readBit() {
        boolean z10 = (this.f15884a[this.f15886c] & (128 >> this.f15887d)) != 0;
        skipBit();
        return z10;
    }

    public int readBits(int i10) {
        int i11;
        this.f15887d += i10;
        int i12 = 0;
        while (true) {
            i11 = this.f15887d;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.f15887d = i13;
            byte[] bArr = this.f15884a;
            int i14 = this.f15886c;
            i12 |= (bArr[i14] & 255) << i13;
            if (!b(i14 + 1)) {
                i = 1;
            }
            this.f15886c = i14 + i;
        }
        byte[] bArr2 = this.f15884a;
        int i15 = this.f15886c;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.f15887d = 0;
            this.f15886c = i15 + (b(i15 + 1) ? 2 : 1);
        }
        a();
        return i16;
    }

    public int readSignedExpGolombCodedInt() {
        int i10 = 0;
        while (!readBit()) {
            i10++;
        }
        int bits = ((1 << i10) - 1) + (i10 > 0 ? readBits(i10) : 0);
        return ((bits + 1) / 2) * (bits % 2 == 0 ? -1 : 1);
    }

    public int readUnsignedExpGolombCodedInt() {
        int i10 = 0;
        while (!readBit()) {
            i10++;
        }
        return ((1 << i10) - 1) + (i10 > 0 ? readBits(i10) : 0);
    }

    public void reset(byte[] bArr, int i10, int i11) {
        this.f15884a = bArr;
        this.f15886c = i10;
        this.f15885b = i11;
        this.f15887d = 0;
        a();
    }

    public void skipBit() {
        int i10 = this.f15887d + 1;
        this.f15887d = i10;
        if (i10 == 8) {
            this.f15887d = 0;
            int i11 = this.f15886c;
            this.f15886c = i11 + (b(i11 + 1) ? 2 : 1);
        }
        a();
    }

    public void skipBits(int i10) {
        int i11 = this.f15886c;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        this.f15886c = i13;
        int i14 = (i10 - (i12 * 8)) + this.f15887d;
        this.f15887d = i14;
        if (i14 > 7) {
            this.f15886c = i13 + 1;
            this.f15887d = i14 - 8;
        }
        while (true) {
            i11++;
            if (i11 > this.f15886c) {
                a();
                return;
            } else if (b(i11)) {
                this.f15886c++;
                i11 += 2;
            }
        }
    }
}
