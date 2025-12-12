package okio;

import ah.d0;
import ah.u;
import bh.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import mf.h;
import zf.i;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes2.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: q, reason: collision with root package name */
    public final transient byte[][] f17106q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int[] f17107r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.f17102p.getData$okio());
        i.checkNotNullParameter(bArr, "segments");
        i.checkNotNullParameter(iArr, "directory");
        this.f17106q = bArr;
        this.f17107r = iArr;
    }

    @Override // okio.ByteString
    public String base64() {
        return new ByteString(toByteArray()).base64();
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        i.checkNotNullParameter(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory$okio()[length + i10];
            int i13 = getDirectory$okio()[i10];
            messageDigest.update(getSegments$okio()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] bArrDigest = messageDigest.digest();
        i.checkNotNullExpressionValue(bArrDigest, "digestBytes");
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.f17107r;
    }

    public final byte[][] getSegments$okio() {
        return this.f17106q;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory$okio()[length + i10];
            int i14 = getDirectory$okio()[i10];
            byte[] bArr = getSegments$okio()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        setHashCode$okio(i11);
        return i11;
    }

    @Override // okio.ByteString
    public String hex() {
        return new ByteString(toByteArray()).hex();
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i10) {
        d0.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i10, 1L);
        int iSegment = c.segment(this, i10);
        return getSegments$okio()[iSegment][(i10 - (iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1])) + getDirectory$okio()[getSegments$okio().length + iSegment]];
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        i.checkNotNullParameter(byteString, "other");
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iSegment = c.segment(this, i10);
        while (i10 < i13) {
            int i14 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i15 = getDirectory$okio()[iSegment] - i14;
            int i16 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!byteString.rangeEquals(i11, getSegments$okio()[iSegment], (i10 - i14) + i16, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return new ByteString(toByteArray()).toAsciiLowercase();
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory$okio()[length + i10];
            int i14 = getDirectory$okio()[i10];
            int i15 = i14 - i11;
            h.copyInto(getSegments$okio()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return new ByteString(toByteArray()).toString();
    }

    @Override // okio.ByteString
    public void write$okio(ah.c cVar, int i10, int i11) {
        i.checkNotNullParameter(cVar, "buffer");
        int i12 = i10 + i11;
        int iSegment = c.segment(this, i10);
        while (i10 < i12) {
            int i13 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i14 = getDirectory$okio()[iSegment] - i13;
            int i15 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = (i10 - i13) + i15;
            u uVar = new u(getSegments$okio()[iSegment], i16, i16 + iMin, true, false);
            u uVar2 = cVar.f676b;
            if (uVar2 == null) {
                uVar.f729g = uVar;
                uVar.f728f = uVar;
                cVar.f676b = uVar;
            } else {
                i.checkNotNull(uVar2);
                u uVar3 = uVar2.f729g;
                i.checkNotNull(uVar3);
                uVar3.push(uVar);
            }
            i10 += iMin;
            iSegment++;
        }
        cVar.setSize$okio(cVar.size() + i11);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        i.checkNotNullParameter(bArr, "other");
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iSegment = c.segment(this, i10);
        while (i10 < i13) {
            int i14 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i15 = getDirectory$okio()[iSegment] - i14;
            int i16 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!d0.arrayRangeEquals(getSegments$okio()[iSegment], (i10 - i14) + i16, bArr, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iSegment++;
        }
        return true;
    }
}
