package g5;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import l6.u;

/* compiled from: DefaultExtractorInput.java */
/* loaded from: classes.dex */
public final class b implements f {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f12699g = new byte[4096];

    /* renamed from: a, reason: collision with root package name */
    public final k6.d f12700a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12701b;

    /* renamed from: c, reason: collision with root package name */
    public long f12702c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f12703d = new byte[65536];

    /* renamed from: e, reason: collision with root package name */
    public int f12704e;

    /* renamed from: f, reason: collision with root package name */
    public int f12705f;

    public b(k6.d dVar, long j10, long j11) {
        this.f12700a = dVar;
        this.f12702c = j10;
        this.f12701b = j11;
    }

    public final int a(byte[] bArr, int i10, int i11, int i12, boolean z10) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int i13 = this.f12700a.read(bArr, i10 + i12, i11 - i12);
        if (i13 != -1) {
            return i12 + i13;
        }
        if (i12 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void advancePeekPosition(int i10) throws InterruptedException, IOException {
        advancePeekPosition(i10, false);
    }

    public final void b(int i10) {
        int i11 = this.f12705f - i10;
        this.f12705f = i11;
        this.f12704e = 0;
        byte[] bArr = this.f12703d;
        byte[] bArr2 = i11 < bArr.length - 524288 ? new byte[65536 + i11] : bArr;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        this.f12703d = bArr2;
    }

    public long getLength() {
        return this.f12701b;
    }

    public long getPeekPosition() {
        return this.f12702c + this.f12704e;
    }

    @Override // g5.f
    public long getPosition() {
        return this.f12702c;
    }

    public boolean peekFully(byte[] bArr, int i10, int i11, boolean z10) throws InterruptedException, IOException {
        if (!advancePeekPosition(i11, z10)) {
            return false;
        }
        System.arraycopy(this.f12703d, this.f12704e - i11, bArr, i10, i11);
        return true;
    }

    public int read(byte[] bArr, int i10, int i11) throws InterruptedException, IOException {
        int i12 = this.f12705f;
        int iA = 0;
        if (i12 != 0) {
            int iMin = Math.min(i12, i11);
            System.arraycopy(this.f12703d, 0, bArr, i10, iMin);
            b(iMin);
            iA = iMin;
        }
        if (iA == 0) {
            iA = a(bArr, i10, i11, 0, true);
        }
        if (iA != -1) {
            this.f12702c += iA;
        }
        return iA;
    }

    public void readFully(byte[] bArr, int i10, int i11) throws InterruptedException, IOException {
        readFully(bArr, i10, i11, false);
    }

    public void resetPeekPosition() {
        this.f12704e = 0;
    }

    public int skip(int i10) throws InterruptedException, IOException {
        int iMin = Math.min(this.f12705f, i10);
        b(iMin);
        if (iMin == 0) {
            iMin = a(f12699g, 0, Math.min(i10, 4096), 0, true);
        }
        if (iMin != -1) {
            this.f12702c += iMin;
        }
        return iMin;
    }

    @Override // g5.f
    public void skipFully(int i10) throws InterruptedException, IOException {
        skipFully(i10, false);
    }

    public boolean advancePeekPosition(int i10, boolean z10) throws InterruptedException, IOException {
        int i11 = this.f12704e + i10;
        byte[] bArr = this.f12703d;
        if (i11 > bArr.length) {
            this.f12703d = Arrays.copyOf(this.f12703d, u.constrainValue(bArr.length * 2, 65536 + i11, i11 + 524288));
        }
        int iMin = Math.min(this.f12705f - this.f12704e, i10);
        while (iMin < i10) {
            iMin = a(this.f12703d, this.f12704e, i10, iMin, z10);
            if (iMin == -1) {
                return false;
            }
        }
        int i12 = this.f12704e + i10;
        this.f12704e = i12;
        this.f12705f = Math.max(this.f12705f, i12);
        return true;
    }

    public boolean readFully(byte[] bArr, int i10, int i11, boolean z10) throws InterruptedException, IOException {
        int iMin;
        int i12 = this.f12705f;
        if (i12 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i12, i11);
            System.arraycopy(this.f12703d, 0, bArr, i10, iMin);
            b(iMin);
        }
        int iA = iMin;
        while (iA < i11 && iA != -1) {
            iA = a(bArr, i10, i11, iA, z10);
        }
        if (iA != -1) {
            this.f12702c += iA;
        }
        return iA != -1;
    }

    public boolean skipFully(int i10, boolean z10) throws InterruptedException, IOException {
        int iMin = Math.min(this.f12705f, i10);
        b(iMin);
        int iA = iMin;
        while (iA < i10 && iA != -1) {
            iA = a(f12699g, -iA, Math.min(i10, iA + 4096), iA, z10);
        }
        if (iA != -1) {
            this.f12702c += iA;
        }
        return iA != -1;
    }

    public void peekFully(byte[] bArr, int i10, int i11) throws InterruptedException, IOException {
        peekFully(bArr, i10, i11, false);
    }
}
