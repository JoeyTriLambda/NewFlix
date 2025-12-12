package l6;

import java.nio.charset.Charset;

/* compiled from: ParsableByteArray.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f15881a;

    /* renamed from: b, reason: collision with root package name */
    public int f15882b;

    /* renamed from: c, reason: collision with root package name */
    public int f15883c;

    public l() {
    }

    public l(int i10) {
        this.f15881a = new byte[i10];
        this.f15883c = i10;
    }

    public int bytesLeft() {
        return this.f15883c - this.f15882b;
    }

    public int capacity() {
        byte[] bArr = this.f15881a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public int getPosition() {
        return this.f15882b;
    }

    public int limit() {
        return this.f15883c;
    }

    public char peekChar() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        return (char) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public void readBytes(k kVar, int i10) {
        readBytes(kVar.f15877a, 0, i10);
        kVar.setPosition(0);
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public int readInt() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << 16);
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.f15882b = i14 + 1;
        return (bArr[i14] & 255) | i15;
    }

    public String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i10 = this.f15882b;
        while (i10 < this.f15883c && !u.isLinebreak(this.f15881a[i10])) {
            i10++;
        }
        int i11 = this.f15882b;
        if (i10 - i11 >= 3) {
            byte[] bArr = this.f15881a;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.f15882b = i11 + 3;
            }
        }
        byte[] bArr2 = this.f15881a;
        int i12 = this.f15882b;
        String str = new String(bArr2, i12, i10 - i12);
        this.f15882b = i10;
        int i13 = this.f15883c;
        if (i10 == i13) {
            return str;
        }
        byte[] bArr3 = this.f15881a;
        if (bArr3[i10] == 13) {
            int i14 = i10 + 1;
            this.f15882b = i14;
            if (i14 == i13) {
                return str;
            }
        }
        int i15 = this.f15882b;
        if (bArr3[i15] == 10) {
            this.f15882b = i15 + 1;
        }
        return str;
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.f15882b = i14 + 1;
        return ((bArr[i14] & 255) << 24) | i15;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.f15881a;
        long j10 = bArr[r1] & 255;
        int i10 = this.f15882b + 1 + 1 + 1;
        long j11 = j10 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        long j12 = j11 | ((bArr[i10] & 255) << 24);
        long j13 = j12 | ((bArr[r3] & 255) << 32);
        long j14 = j13 | ((bArr[r4] & 255) << 40);
        long j15 = j14 | ((bArr[r3] & 255) << 48);
        this.f15882b = i10 + 1 + 1 + 1 + 1 + 1;
        return j15 | ((bArr[r4] & 255) << 56);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.f15881a;
        long j10 = bArr[r1] & 255;
        int i10 = this.f15882b + 1 + 1 + 1;
        long j11 = j10 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        this.f15882b = i10 + 1;
        return j11 | ((bArr[i10] & 255) << 24);
    }

    public int readLittleEndianUnsignedIntToInt() {
        int littleEndianInt = readLittleEndianInt();
        if (littleEndianInt >= 0) {
            return littleEndianInt;
        }
        throw new IllegalStateException(ac.c.f("Top bit not zero: ", littleEndianInt));
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.f15882b = i11 + 1;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public long readLong() {
        byte[] bArr = this.f15881a;
        long j10 = (bArr[r1] & 255) << 56;
        int i10 = this.f15882b + 1 + 1 + 1;
        long j11 = j10 | ((bArr[r2] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j12 = j11 | ((bArr[i10] & 255) << 32);
        long j13 = j12 | ((bArr[r3] & 255) << 24);
        long j14 = j13 | ((bArr[r4] & 255) << 16);
        long j15 = j14 | ((bArr[r3] & 255) << 8);
        this.f15882b = i10 + 1 + 1 + 1 + 1 + 1;
        return j15 | (bArr[r4] & 255);
    }

    public String readNullTerminatedString(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.f15882b;
        int i12 = (i11 + i10) - 1;
        String str = new String(this.f15881a, i11, (i12 >= this.f15883c || this.f15881a[i12] != 0) ? i10 : i10 - 1);
        this.f15882b += i10;
        return str;
    }

    public short readShort() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = (bArr[i10] & 255) << 8;
        this.f15882b = i11 + 1;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public String readString(int i10) {
        return readString(i10, Charset.forName("UTF-8"));
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        this.f15882b = i10 + 1;
        return bArr[i10] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = (bArr[i11] & 255) | ((bArr[i10] & 255) << 8);
        this.f15882b = i11 + 1 + 2;
        return i12;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.f15881a;
        long j10 = (bArr[r1] & 255) << 24;
        int i10 = this.f15882b + 1 + 1 + 1;
        long j11 = j10 | ((bArr[r2] & 255) << 16) | ((bArr[r1] & 255) << 8);
        this.f15882b = i10 + 1;
        return j11 | (bArr[i10] & 255);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = ((bArr[i10] & 255) << 16) | ((bArr[i11] & 255) << 8);
        this.f15882b = i12 + 1;
        return (bArr[i12] & 255) | i13;
    }

    public int readUnsignedIntToInt() {
        int i10 = readInt();
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalStateException(ac.c.f("Top bit not zero: ", i10));
    }

    public long readUnsignedLongToLong() {
        long j10 = readLong();
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalStateException(ac.c.h("Top bit not zero: ", j10));
    }

    public int readUnsignedShort() {
        byte[] bArr = this.f15881a;
        int i10 = this.f15882b;
        int i11 = i10 + 1;
        int i12 = (bArr[i10] & 255) << 8;
        this.f15882b = i11 + 1;
        return (bArr[i11] & 255) | i12;
    }

    public long readUtf8EncodedLong() {
        int i10;
        int i11;
        long j10 = this.f15881a[this.f15882b];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if (((1 << i12) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= r6 - 1;
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 == 0) {
            throw new NumberFormatException(ac.c.h("Invalid UTF-8 sequence first byte: ", j10));
        }
        for (i10 = 1; i10 < i11; i10++) {
            if ((this.f15881a[this.f15882b + i10] & 192) != 128) {
                throw new NumberFormatException(ac.c.h("Invalid UTF-8 sequence continuation byte: ", j10));
            }
            j10 = (j10 << 6) | (r3 & 63);
        }
        this.f15882b += i11;
        return j10;
    }

    public void reset(int i10) {
        reset(capacity() < i10 ? new byte[i10] : this.f15881a, i10);
    }

    public void setLimit(int i10) {
        a.checkArgument(i10 >= 0 && i10 <= this.f15881a.length);
        this.f15883c = i10;
    }

    public void setPosition(int i10) {
        a.checkArgument(i10 >= 0 && i10 <= this.f15883c);
        this.f15882b = i10;
    }

    public void skipBytes(int i10) {
        setPosition(this.f15882b + i10);
    }

    public String readString(int i10, Charset charset) {
        String str = new String(this.f15881a, this.f15882b, i10, charset);
        this.f15882b += i10;
        return str;
    }

    public void reset(byte[] bArr, int i10) {
        this.f15881a = bArr;
        this.f15883c = i10;
        this.f15882b = 0;
    }

    public void readBytes(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.f15881a, this.f15882b, bArr, i10, i11);
        this.f15882b += i11;
    }

    public l(byte[] bArr) {
        this.f15881a = bArr;
        this.f15883c = bArr.length;
    }

    public String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i10 = this.f15882b;
        while (i10 < this.f15883c && this.f15881a[i10] != 0) {
            i10++;
        }
        byte[] bArr = this.f15881a;
        int i11 = this.f15882b;
        String str = new String(bArr, i11, i10 - i11);
        this.f15882b = i10;
        if (i10 < this.f15883c) {
            this.f15882b = i10 + 1;
        }
        return str;
    }

    public void reset() {
        this.f15882b = 0;
        this.f15883c = 0;
    }

    public l(byte[] bArr, int i10) {
        this.f15881a = bArr;
        this.f15883c = i10;
    }
}
