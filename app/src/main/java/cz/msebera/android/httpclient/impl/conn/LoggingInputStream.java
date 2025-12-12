package cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
class LoggingInputStream extends InputStream {
    private final InputStream in;
    private final Wire wire;

    public LoggingInputStream(InputStream inputStream, Wire wire) {
        this.in = inputStream;
        this.wire = wire;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.in.available();
        } catch (IOException e10) {
            this.wire.input("[available] I/O error : " + e10.getMessage());
            throw e10;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e10) {
            this.wire.input("[close] I/O error: " + e10.getMessage());
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        super.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int i10 = this.in.read();
            if (i10 == -1) {
                this.wire.input("end of stream");
            } else {
                this.wire.input(i10);
            }
            return i10;
        } catch (IOException e10) {
            this.wire.input("[read] I/O error: " + e10.getMessage());
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        super.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return super.skip(j10);
        } catch (IOException e10) {
            this.wire.input("[skip] I/O error: " + e10.getMessage());
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int i10 = this.in.read(bArr);
            if (i10 == -1) {
                this.wire.input("end of stream");
            } else if (i10 > 0) {
                this.wire.input(bArr, 0, i10);
            }
            return i10;
        } catch (IOException e10) {
            this.wire.input("[read] I/O error: " + e10.getMessage());
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            int i12 = this.in.read(bArr, i10, i11);
            if (i12 == -1) {
                this.wire.input("end of stream");
            } else if (i12 > 0) {
                this.wire.input(bArr, i10, i12);
            }
            return i12;
        } catch (IOException e10) {
            this.wire.input("[read] I/O error: " + e10.getMessage());
            throw e10;
        }
    }
}
