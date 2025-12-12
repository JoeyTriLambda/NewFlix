package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* loaded from: classes2.dex */
public class DeflateInputStream extends InputStream {
    private final InputStream sourceStream;

    public static class DeflateStream extends InflaterInputStream {
        private boolean closed;

        public DeflateStream(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
            this.closed = false;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ((InflaterInputStream) this).inf.end();
            super.close();
        }
    }

    public DeflateInputStream(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 2);
        int i10 = pushbackInputStream.read();
        int i11 = pushbackInputStream.read();
        if (i10 == -1 || i11 == -1) {
            throw new ZipException("Unexpected end of stream");
        }
        pushbackInputStream.unread(i11);
        pushbackInputStream.unread(i10);
        int i12 = i10 & 255;
        this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater(((i12 & 15) == 8 && ((i12 >> 4) & 15) <= 7 && ((i12 << 8) | (i11 & 255)) % 31 == 0) ? false : true));
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.sourceStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sourceStream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.sourceStream.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.sourceStream.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        return this.sourceStream.skip(j10);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.sourceStream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.sourceStream.read(bArr, i10, i11);
    }
}
