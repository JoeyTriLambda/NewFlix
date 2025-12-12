package eh;

import dh.f;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* compiled from: ConstrainableInputStream.java */
/* loaded from: classes2.dex */
public final class a extends BufferedInputStream {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11325b;

    /* renamed from: m, reason: collision with root package name */
    public final int f11326m;

    /* renamed from: n, reason: collision with root package name */
    public long f11327n;

    /* renamed from: o, reason: collision with root package name */
    public long f11328o;

    /* renamed from: p, reason: collision with root package name */
    public int f11329p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11330q;

    public a(InputStream inputStream, int i10, int i11) {
        super(inputStream, i10);
        this.f11328o = 0L;
        f.isTrue(i11 >= 0);
        this.f11326m = i11;
        this.f11329p = i11;
        this.f11325b = i11 != 0;
        this.f11327n = System.nanoTime();
    }

    public static a wrap(InputStream inputStream, int i10, int i11) {
        return inputStream instanceof a ? (a) inputStream : new a(inputStream, i10, i11);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        boolean z10;
        int i12;
        if (this.f11330q || ((z10 = this.f11325b) && this.f11329p <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f11330q = true;
            return -1;
        }
        if (this.f11328o != 0 && System.nanoTime() - this.f11327n > this.f11328o) {
            throw new SocketTimeoutException("Read timeout");
        }
        if (z10 && i11 > (i12 = this.f11329p)) {
            i11 = i12;
        }
        try {
            int i13 = super.read(bArr, i10, i11);
            this.f11329p -= i13;
            return i13;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    public ByteBuffer readToByteBuffer(int i10) throws IOException {
        f.isTrue(i10 >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z10 = i10 > 0;
        int i11 = 32768;
        if (z10 && i10 < 32768) {
            i11 = i10;
        }
        byte[] bArr = new byte[i11];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11);
        while (true) {
            int i12 = read(bArr);
            if (i12 == -1) {
                break;
            }
            if (z10) {
                if (i12 >= i10) {
                    byteArrayOutputStream.write(bArr, 0, i10);
                    break;
                }
                i10 -= i12;
            }
            byteArrayOutputStream.write(bArr, 0, i12);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f11329p = this.f11326m - ((BufferedInputStream) this).markpos;
    }

    public a timeout(long j10, long j11) {
        this.f11327n = j10;
        this.f11328o = j11 * 1000000;
        return this;
    }
}
