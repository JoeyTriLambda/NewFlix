package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ContentLengthOutputStream extends OutputStream {
    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer sessionOutputBuffer, long j10) {
        this.out = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.contentLength = Args.notNegative(j10, "Content length");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        long j10 = this.total;
        long j11 = this.contentLength;
        if (j10 < j11) {
            long j12 = j11 - j10;
            if (i11 > j12) {
                i11 = (int) j12;
            }
            this.out.write(bArr, i10, i11);
            this.total += i11;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.total < this.contentLength) {
            this.out.write(i10);
            this.total++;
        }
    }
}
