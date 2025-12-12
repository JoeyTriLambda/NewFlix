package ah;

import ah.c;
import okio.ByteString;

/* compiled from: -Util.kt */
/* loaded from: classes2.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c.a f687a = new c.a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f688b = -1234567890;

    public static final boolean arrayRangeEquals(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        zf.i.checkNotNullParameter(bArr, "a");
        zf.i.checkNotNullParameter(bArr2, "b");
        if (i12 <= 0) {
            return true;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13 + 1;
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
            if (i14 >= i12) {
                return true;
            }
            i13 = i14;
        }
    }

    public static final void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final c.a getDEFAULT__new_UnsafeCursor() {
        return f687a;
    }

    public static final c.a resolveDefaultParameter(c.a aVar) {
        zf.i.checkNotNullParameter(aVar, "unsafeCursor");
        return aVar == f687a ? new c.a() : aVar;
    }

    public static final int reverseBytes(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final String toHexString(byte b10) {
        return ig.l.concatToString(new char[]{bh.b.getHEX_DIGIT_CHARS()[(b10 >> 4) & 15], bh.b.getHEX_DIGIT_CHARS()[b10 & 15]});
    }

    public static final int resolveDefaultParameter(ByteString byteString, int i10) {
        zf.i.checkNotNullParameter(byteString, "<this>");
        return i10 == f688b ? byteString.size() : i10;
    }

    public static final short reverseBytes(short s10) {
        int i10 = s10 & 65535;
        return (short) (((i10 & 255) << 8) | ((65280 & i10) >>> 8));
    }

    public static final String toHexString(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {bh.b.getHEX_DIGIT_CHARS()[(i10 >> 28) & 15], bh.b.getHEX_DIGIT_CHARS()[(i10 >> 24) & 15], bh.b.getHEX_DIGIT_CHARS()[(i10 >> 20) & 15], bh.b.getHEX_DIGIT_CHARS()[(i10 >> 16) & 15], bh.b.getHEX_DIGIT_CHARS()[(i10 >> 12) & 15], bh.b.getHEX_DIGIT_CHARS()[(i10 >> 8) & 15], bh.b.getHEX_DIGIT_CHARS()[(i10 >> 4) & 15], bh.b.getHEX_DIGIT_CHARS()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return ig.l.concatToString(cArr, i11, 8);
    }
}
