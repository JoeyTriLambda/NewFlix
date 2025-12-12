package org.adblockplus.libadblockplus.android;

import bi.a;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
public class ConnectionInputStream extends InputStream {
    private static final int CACHE_SIZE = 4096;
    private final BufferedInputStream bufferedInputStream;
    private boolean closed = false;
    private final HttpURLConnection httpURLConnection;

    public ConnectionInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) throws IOException {
        this.httpURLConnection = httpURLConnection;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, CACHE_SIZE);
        this.bufferedInputStream = bufferedInputStream;
        try {
            bufferedInputStream.mark(4097);
            bufferedInputStream.read(new byte[CACHE_SIZE], 0, CACHE_SIZE);
            bufferedInputStream.reset();
        } catch (IOException e10) {
            a.d("Error while reading cached buffer for url %s and error %s", httpURLConnection.getURL(), e10.getMessage());
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.bufferedInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            a.d("close()", new Object[0]);
            this.bufferedInputStream.close();
            this.closed = true;
        } finally {
            this.httpURLConnection.disconnect();
        }
    }

    public void finalize() throws Throwable {
        try {
            if (!this.closed) {
                a.d("close() from finalize", new Object[0]);
                this.httpURLConnection.disconnect();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
                super.finalize();
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i10) {
        this.bufferedInputStream.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.bufferedInputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.bufferedInputStream.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.bufferedInputStream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        return this.bufferedInputStream.skip(j10);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.bufferedInputStream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.bufferedInputStream.read(bArr, i10, i11);
    }
}
