package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/* loaded from: classes2.dex */
public class SessionOutputBufferImpl implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = {13, 10};
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outStream;

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i10, int i11, CharsetEncoder charsetEncoder) {
        Args.positive(i10, "Buffer size");
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new ByteArrayBuffer(i10);
        this.fragementSizeHint = i11 < 0 ? 0 : i11;
        this.encoder = charsetEncoder;
    }

    private void flushBuffer() throws IOException {
        int length = this.buffer.length();
        if (length > 0) {
            streamWrite(this.buffer.buffer(), 0, length);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(length);
        }
    }

    private void flushStream() throws IOException {
        OutputStream outputStream = this.outStream;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    private void handleEncodingResult(CoderResult coderResult) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.bbuf.flip();
        while (this.bbuf.hasRemaining()) {
            write(this.bbuf.get());
        }
        this.bbuf.compact();
    }

    private void streamWrite(byte[] bArr, int i10, int i11) throws IOException {
        Asserts.notNull(this.outStream, "Output stream");
        this.outStream.write(bArr, i10, i11);
    }

    private void writeEncoded(CharBuffer charBuffer) throws IOException {
        if (charBuffer.hasRemaining()) {
            if (this.bbuf == null) {
                this.bbuf = ByteBuffer.allocate(1024);
            }
            this.encoder.reset();
            while (charBuffer.hasRemaining()) {
                handleEncodingResult(this.encoder.encode(charBuffer, this.bbuf, true));
            }
            handleEncodingResult(this.encoder.flush(this.bbuf));
            this.bbuf.clear();
        }
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(OutputStream outputStream) {
        this.outStream = outputStream;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        flushStream();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean isBound() {
        return this.outStream != null;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int length() {
        return this.buffer.length();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (bArr == null) {
            return;
        }
        if (i11 > this.fragementSizeHint || i11 > this.buffer.capacity()) {
            flushBuffer();
            streamWrite(bArr, i10, i11);
            this.metrics.incrementBytesTransferred(i11);
        } else {
            if (i11 > this.buffer.capacity() - this.buffer.length()) {
                flushBuffer();
            }
            this.buffer.append(bArr, i10, i11);
        }
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(String str) throws IOException {
        if (str == null) {
            return;
        }
        if (str.length() > 0) {
            if (this.encoder == null) {
                for (int i10 = 0; i10 < str.length(); i10++) {
                    write(str.charAt(i10));
                }
            } else {
                writeEncoded(CharBuffer.wrap(str));
            }
        }
        write(CRLF);
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i10) {
        this(httpTransportMetricsImpl, i10, i10, null);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] bArr) throws IOException {
        if (bArr == null) {
            return;
        }
        write(bArr, 0, bArr.length);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        if (charArrayBuffer == null) {
            return;
        }
        int i10 = 0;
        if (this.encoder == null) {
            int length = charArrayBuffer.length();
            while (length > 0) {
                int iMin = Math.min(this.buffer.capacity() - this.buffer.length(), length);
                if (iMin > 0) {
                    this.buffer.append(charArrayBuffer, i10, iMin);
                }
                if (this.buffer.isFull()) {
                    flushBuffer();
                }
                i10 += iMin;
                length -= iMin;
            }
        } else {
            writeEncoded(CharBuffer.wrap(charArrayBuffer.buffer(), 0, charArrayBuffer.length()));
        }
        write(CRLF);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(int i10) throws IOException {
        if (this.fragementSizeHint > 0) {
            if (this.buffer.isFull()) {
                flushBuffer();
            }
            this.buffer.append(i10);
        } else {
            flushBuffer();
            this.outStream.write(i10);
        }
    }
}
