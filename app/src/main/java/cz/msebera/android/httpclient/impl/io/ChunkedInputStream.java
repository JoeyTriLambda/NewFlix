package cz.msebera.android.httpclient.impl.io;

import ac.c;
import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.MalformedChunkCodingException;
import cz.msebera.android.httpclient.TruncatedChunkException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_INVALID = Integer.MAX_VALUE;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private long chunkSize;
    private boolean closed;
    private final MessageConstraints constraints;
    private boolean eof;
    private Header[] footers;
    private final SessionInputBuffer in;
    private long pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.pos = 0L;
        this.buffer = new CharArrayBuffer(16);
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.state = 1;
    }

    private long getChunkSize() throws IOException {
        int i10 = this.state;
        if (i10 != 1) {
            if (i10 != 3) {
                throw new IllegalStateException("Inconsistent codec state");
            }
            this.buffer.clear();
            if (this.in.readLine(this.buffer) == -1) {
                throw new MalformedChunkCodingException("CRLF expected at end of chunk");
            }
            if (!this.buffer.isEmpty()) {
                throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
            }
            this.state = 1;
        }
        this.buffer.clear();
        if (this.in.readLine(this.buffer) == -1) {
            throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
        }
        int iIndexOf = this.buffer.indexOf(59);
        if (iIndexOf < 0) {
            iIndexOf = this.buffer.length();
        }
        String strSubstringTrimmed = this.buffer.substringTrimmed(0, iIndexOf);
        try {
            return Long.parseLong(strSubstringTrimmed, 16);
        } catch (NumberFormatException unused) {
            throw new MalformedChunkCodingException(c.j("Bad chunk header: ", strSubstringTrimmed));
        }
    }

    private void nextChunk() throws IOException {
        if (this.state == CHUNK_INVALID) {
            throw new MalformedChunkCodingException("Corrupt data stream");
        }
        try {
            long chunkSize = getChunkSize();
            this.chunkSize = chunkSize;
            if (chunkSize < 0) {
                throw new MalformedChunkCodingException("Negative chunk size");
            }
            this.state = 2;
            this.pos = 0L;
            if (chunkSize == 0) {
                this.eof = true;
                parseTrailerHeaders();
            }
        } catch (MalformedChunkCodingException e10) {
            this.state = CHUNK_INVALID;
            throw e10;
        }
    }

    private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);
        } catch (HttpException e10) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + e10.getMessage());
            malformedChunkCodingException.initCause(e10);
            throw malformedChunkCodingException;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in instanceof BufferInfo) {
            return (int) Math.min(((BufferInfo) r0).length(), this.chunkSize - this.pos);
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            if (!this.eof && this.state != CHUNK_INVALID) {
                do {
                } while (read(new byte[BUFFER_SIZE]) >= 0);
            }
        } finally {
            this.eof = true;
            this.closed = true;
        }
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.eof) {
            return -1;
        }
        if (this.state != 2) {
            nextChunk();
            if (this.eof) {
                return -1;
            }
        }
        int i10 = this.in.read();
        if (i10 != -1) {
            long j10 = this.pos + 1;
            this.pos = j10;
            if (j10 >= this.chunkSize) {
                this.state = 3;
            }
        }
        return i10;
    }

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, null);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int i12 = this.in.read(bArr, i10, (int) Math.min(i11, this.chunkSize - this.pos));
            if (i12 != -1) {
                long j10 = this.pos + i12;
                this.pos = j10;
                if (j10 >= this.chunkSize) {
                    this.state = 3;
                }
                return i12;
            }
            this.eof = true;
            throw new TruncatedChunkException("Truncated chunk (expected size: %,d; actual size: %,d)", Long.valueOf(this.chunkSize), Long.valueOf(this.pos));
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
