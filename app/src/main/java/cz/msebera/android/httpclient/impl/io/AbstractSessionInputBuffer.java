package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.CoreProtocolPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer, BufferInfo {
    private boolean ascii;
    private byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private Charset charset;
    private CharsetDecoder decoder;
    private InputStream inStream;
    private ByteArrayBuffer lineBuffer;
    private int maxLineLen;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int iHandleDecodingResult = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.decoder == null) {
            CharsetDecoder charsetDecoderNewDecoder = this.charset.newDecoder();
            this.decoder = charsetDecoderNewDecoder;
            charsetDecoderNewDecoder.onMalformedInput(this.onMalformedCharAction);
            this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
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
        if (this.ascii) {
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
        if (!this.ascii) {
            return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i11, i12));
        }
        charArrayBuffer.append(this.buffer, i11, i12);
        return i12;
    }

    private int locateLF() {
        for (int i10 = this.bufferPos; i10 < this.bufferLen; i10++) {
            if (this.buffer[i10] == 10) {
                return i10;
            }
        }
        return -1;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
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
        int i13 = this.inStream.read(bArr2, i12, bArr2.length - i12);
        if (i13 == -1) {
            return -1;
        }
        this.bufferLen = i12 + i13;
        this.metrics.incrementBytesTransferred(i13);
        return i13;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        return this.bufferPos < this.bufferLen;
    }

    public void init(InputStream inputStream, int i10, HttpParams httpParams) {
        Args.notNull(inputStream, "Input stream");
        Args.notNegative(i10, "Buffer size");
        Args.notNull(httpParams, "HTTP parameters");
        this.inStream = inputStream;
        this.buffer = new byte[i10];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.lineBuffer = new ByteArrayBuffer(i10);
        String str = (String) httpParams.getParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        Charset charsetForName = str != null ? Charset.forName(str) : Consts.ASCII;
        this.charset = charsetForName;
        this.ascii = charsetForName.equals(Consts.ASCII);
        this.decoder = null;
        this.maxLineLen = httpParams.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.minChunkLimit = httpParams.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
        this.metrics = createTransportMetrics();
        CodingErrorAction codingErrorAction = (CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.onMalformedCharAction = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) httpParams.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.onUnmappableCharAction = codingErrorAction2;
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
        boolean z10 = true;
        int iFillBuffer = 0;
        while (z10) {
            int iLocateLF = locateLF();
            if (iLocateLF == -1) {
                if (hasBufferedData()) {
                    int i10 = this.bufferLen;
                    int i11 = this.bufferPos;
                    this.lineBuffer.append(this.buffer, i11, i10 - i11);
                    this.bufferPos = this.bufferLen;
                }
                iFillBuffer = fillBuffer();
                if (iFillBuffer == -1) {
                }
                if (this.maxLineLen <= 0 && this.lineBuffer.length() >= this.maxLineLen) {
                    throw new IOException("Maximum line length limit exceeded");
                }
            } else {
                if (this.lineBuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, iLocateLF);
                }
                int i12 = iLocateLF + 1;
                int i13 = this.bufferPos;
                this.lineBuffer.append(this.buffer, i13, i12 - i13);
                this.bufferPos = i12;
            }
            z10 = false;
            if (this.maxLineLen <= 0) {
            }
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
            int i12 = this.inStream.read(bArr, i10, i11);
            if (i12 > 0) {
                this.metrics.incrementBytesTransferred(i12);
            }
            return i12;
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
