package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.MessageConstraintException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* loaded from: classes2.dex */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream inStream;
    private final ByteArrayBuffer lineBuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i10, int i11, MessageConstraints messageConstraints, CharsetDecoder charsetDecoder) {
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        Args.positive(i10, "Buffer size");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new byte[i10];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.minChunkLimit = i11 < 0 ? 512 : i11;
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.lineBuffer = new ByteArrayBuffer(i10);
        this.decoder = charsetDecoder;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int iHandleDecodingResult = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
        }
        this.decoder.reset();
        while (byteBuffer.hasRemaining()) {
            iHandleDecodingResult += handleDecodingResult(this.decoder.decode(byteBuffer, this.cbuf, true), charArrayBuffer, byteBuffer);
        }
        int iHandleDecodingResult2 = iHandleDecodingResult + handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer, byteBuffer);
        this.cbuf.clear();
        return iHandleDecodingResult2;
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int iRemaining = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return iRemaining;
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.lineBuffer.length();
        if (length > 0) {
            if (this.lineBuffer.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.lineBuffer.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.decoder == null) {
            charArrayBuffer.append(this.lineBuffer, 0, length);
        } else {
            length = appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.lineBuffer.buffer(), 0, length));
        }
        this.lineBuffer.clear();
        return length;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i10) throws IOException {
        int i11 = this.bufferPos;
        this.bufferPos = i10 + 1;
        if (i10 > i11 && this.buffer[i10 - 1] == 13) {
            i10--;
        }
        int i12 = i10 - i11;
        if (this.decoder != null) {
            return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i11, i12));
        }
        charArrayBuffer.append(this.buffer, i11, i12);
        return i12;
    }

    private int streamRead(byte[] bArr, int i10, int i11) throws IOException {
        Asserts.notNull(this.inStream, "Input stream");
        return this.inStream.read(bArr, i10, i11);
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(InputStream inputStream) {
        this.inStream = inputStream;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.bufferPos = 0;
        this.bufferLen = 0;
    }

    public int fillBuffer() throws IOException {
        int i10 = this.bufferPos;
        if (i10 > 0) {
            int i11 = this.bufferLen - i10;
            if (i11 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i10, bArr, 0, i11);
            }
            this.bufferPos = 0;
            this.bufferLen = i11;
        }
        int i12 = this.bufferLen;
        byte[] bArr2 = this.buffer;
        int iStreamRead = streamRead(bArr2, i12, bArr2.length - i12);
        if (iStreamRead == -1) {
            return -1;
        }
        this.bufferLen = i12 + iStreamRead;
        this.metrics.incrementBytesTransferred(iStreamRead);
        return iStreamRead;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        return this.bufferPos < this.bufferLen;
    }

    public boolean isBound() {
        return this.inStream != null;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int i10) throws IOException {
        return hasBufferedData();
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int length() {
        return this.bufferLen - this.bufferPos;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i10 = this.bufferPos;
        this.bufferPos = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int maxLineLength = this.constraints.getMaxLineLength();
        boolean z10 = true;
        int iFillBuffer = 0;
        while (z10) {
            int i10 = this.bufferPos;
            while (true) {
                if (i10 >= this.bufferLen) {
                    i10 = -1;
                    break;
                }
                if (this.buffer[i10] == 10) {
                    break;
                }
                i10++;
            }
            if (maxLineLength > 0) {
                if ((this.lineBuffer.length() + (i10 >= 0 ? i10 : this.bufferLen)) - this.bufferPos >= maxLineLength) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
            }
            if (i10 == -1) {
                if (hasBufferedData()) {
                    int i11 = this.bufferLen;
                    int i12 = this.bufferPos;
                    this.lineBuffer.append(this.buffer, i12, i11 - i12);
                    this.bufferPos = this.bufferLen;
                }
                iFillBuffer = fillBuffer();
                if (iFillBuffer == -1) {
                }
            } else {
                if (this.lineBuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, i10);
                }
                int i13 = i10 + 1;
                int i14 = this.bufferPos;
                this.lineBuffer.append(this.buffer, i14, i13 - i14);
                this.bufferPos = i13;
            }
            z10 = false;
        }
        if (iFillBuffer == -1 && this.lineBuffer.isEmpty()) {
            return -1;
        }
        return lineFromLineBuffer(charArrayBuffer);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (bArr == null) {
            return 0;
        }
        if (hasBufferedData()) {
            int iMin = Math.min(i11, this.bufferLen - this.bufferPos);
            System.arraycopy(this.buffer, this.bufferPos, bArr, i10, iMin);
            this.bufferPos += iMin;
            return iMin;
        }
        if (i11 > this.minChunkLimit) {
            int iStreamRead = streamRead(bArr, i10, i11);
            if (iStreamRead > 0) {
                this.metrics.incrementBytesTransferred(iStreamRead);
            }
            return iStreamRead;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        int iMin2 = Math.min(i11, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, bArr, i10, iMin2);
        this.bufferPos += iMin2;
        return iMin2;
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i10) {
        this(httpTransportMetricsImpl, i10, i10, null, null);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }
}
