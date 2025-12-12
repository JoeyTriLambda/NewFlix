package l6;

/* compiled from: ParsableBitArray.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f15877a;

    /* renamed from: b, reason: collision with root package name */
    public int f15878b;

    /* renamed from: c, reason: collision with root package name */
    public int f15879c;

    /* renamed from: d, reason: collision with root package name */
    public int f15880d;

    public k() {
    }

    public k(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public final void a() {
        int i10;
        int i11 = this.f15878b;
        a.checkState(i11 >= 0 && (i11 < (i10 = this.f15880d) || (i11 == i10 && this.f15879c == 0)));
    }

    public int bitsLeft() {
        return ((this.f15880d - this.f15878b) * 8) - this.f15879c;
    }

    public void byteAlign() {
        if (this.f15879c == 0) {
            return;
        }
        this.f15879c = 0;
        this.f15878b++;
        a();
    }

    public int getBytePosition() {
        a.checkState(this.f15879c == 0);
        return this.f15878b;
    }

    public int getPosition() {
        return (this.f15878b * 8) + this.f15879c;
    }

    public boolean readBit() {
        boolean z10 = (this.f15877a[this.f15878b] & (128 >> this.f15879c)) != 0;
        skipBit();
        return z10;
    }

    public int readBits(int i10) {
        int i11;
        if (i10 == 0) {
            return 0;
        }
        this.f15879c += i10;
        int i12 = 0;
        while (true) {
            i11 = this.f15879c;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.f15879c = i13;
            byte[] bArr = this.f15877a;
            int i14 = this.f15878b;
            this.f15878b = i14 + 1;
            i12 |= (bArr[i14] & 255) << i13;
        }
        byte[] bArr2 = this.f15877a;
        int i15 = this.f15878b;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.f15879c = 0;
            this.f15878b = i15 + 1;
        }
        a();
        return i16;
    }

    public void readBytes(byte[] bArr, int i10, int i11) {
        a.checkState(this.f15879c == 0);
        System.arraycopy(this.f15877a, this.f15878b, bArr, i10, i11);
        this.f15878b += i11;
        a();
    }

    public void reset(byte[] bArr, int i10) {
        this.f15877a = bArr;
        this.f15878b = 0;
        this.f15879c = 0;
        this.f15880d = i10;
    }

    public void setPosition(int i10) {
        int i11 = i10 / 8;
        this.f15878b = i11;
        this.f15879c = i10 - (i11 * 8);
        a();
    }

    public void skipBit() {
        int i10 = this.f15879c + 1;
        this.f15879c = i10;
        if (i10 == 8) {
            this.f15879c = 0;
            this.f15878b++;
        }
        a();
    }

    public void skipBits(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f15878b + i11;
        this.f15878b = i12;
        int i13 = (i10 - (i11 * 8)) + this.f15879c;
        this.f15879c = i13;
        if (i13 > 7) {
            this.f15878b = i12 + 1;
            this.f15879c = i13 - 8;
        }
        a();
    }

    public void skipBytes(int i10) {
        a.checkState(this.f15879c == 0);
        this.f15878b += i10;
        a();
    }

    public k(byte[] bArr, int i10) {
        this.f15877a = bArr;
        this.f15880d = i10;
    }
}
