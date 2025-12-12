package d4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: PoolingByteArrayOutputStream.java */
/* loaded from: classes.dex */
public final class l extends ByteArrayOutputStream {

    /* renamed from: b, reason: collision with root package name */
    public final c f10845b;

    public l(c cVar, int i10) {
        this.f10845b = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.getBuf(Math.max(i10, 256));
    }

    public final void a(int i10) {
        int i11 = ((ByteArrayOutputStream) this).count;
        if (i11 + i10 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        int i12 = (i11 + i10) * 2;
        c cVar = this.f10845b;
        byte[] buf = cVar.getBuf(i12);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, buf, 0, ((ByteArrayOutputStream) this).count);
        cVar.returnBuf(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = buf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10845b.returnBuf(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f10845b.returnBuf(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i10, int i11) {
        a(i11);
        super.write(bArr, i10, i11);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i10) {
        a(1);
        super.write(i10);
    }
}
