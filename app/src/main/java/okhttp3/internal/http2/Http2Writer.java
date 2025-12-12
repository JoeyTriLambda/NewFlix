package okhttp3.internal.http2;

import ah.c;
import ah.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import zf.f;
import zf.i;

/* compiled from: Http2Writer.kt */
/* loaded from: classes2.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final c hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final d sink;

    /* compiled from: Http2Writer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public Http2Writer(d dVar, boolean z10) {
        i.checkNotNullParameter(dVar, "sink");
        this.sink = dVar;
        this.client = z10;
        c cVar = new c();
        this.hpackBuffer = cVar;
        this.maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        this.hpackWriter = new Hpack.Writer(0, false, cVar, 3, null);
    }

    private final void writeContinuationFrames(int i10, long j10) throws IOException {
        while (j10 > 0) {
            long jMin = Math.min(this.maxFrameSize, j10);
            j10 -= jMin;
            frameHeader(i10, (int) jMin, 9, j10 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        i.checkNotNullParameter(settings, "peerSettings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, 4, 1);
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (this.client) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(i.stringPlus(">> CONNECTION ", Http2.CONNECTION_PREFACE.hex()), new Object[0]));
            }
            this.sink.write(Http2.CONNECTION_PREFACE);
            this.sink.flush();
        }
    }

    public final synchronized void data(boolean z10, int i10, c cVar, int i11) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i10, z10 ? 1 : 0, cVar, i11);
    }

    public final void dataFrame(int i10, int i11, c cVar, int i12) throws IOException {
        frameHeader(i10, i12, 0, i11);
        if (i12 > 0) {
            d dVar = this.sink;
            i.checkNotNull(cVar);
            dVar.write(cVar, i12);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i10, int i11, int i12, int i13) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i10, i11, i12, i13));
        }
        if (!(i11 <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i11).toString());
        }
        if (!((Integer.MIN_VALUE & i10) == 0)) {
            throw new IllegalArgumentException(i.stringPlus("reserved bit set: ", Integer.valueOf(i10)).toString());
        }
        Util.writeMedium(this.sink, i11);
        this.sink.writeByte(i12 & 255);
        this.sink.writeByte(i13 & 255);
        this.sink.writeInt(i10 & Integer.MAX_VALUE);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i10, ErrorCode errorCode, byte[] bArr) throws IOException {
        i.checkNotNullParameter(errorCode, "errorCode");
        i.checkNotNullParameter(bArr, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        frameHeader(0, bArr.length + 8, 7, 0);
        this.sink.writeInt(i10);
        this.sink.writeInt(errorCode.getHttpCode());
        if (!(bArr.length == 0)) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z10, int i10, List<Header> list) throws IOException {
        i.checkNotNullParameter(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        long jMin = Math.min(this.maxFrameSize, size);
        int i11 = size == jMin ? 4 : 0;
        if (z10) {
            i11 |= 1;
        }
        frameHeader(i10, (int) jMin, 1, i11);
        this.sink.write(this.hpackBuffer, jMin);
        if (size > jMin) {
            writeContinuationFrames(i10, size - jMin);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z10, int i10, int i11) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z10 ? 1 : 0);
        this.sink.writeInt(i10);
        this.sink.writeInt(i11);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i10, int i11, List<Header> list) throws IOException {
        i.checkNotNullParameter(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) Math.min(this.maxFrameSize - 4, size);
        long j10 = iMin;
        frameHeader(i10, iMin + 4, 5, size == j10 ? 4 : 0);
        this.sink.writeInt(i11 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j10);
        if (size > j10) {
            writeContinuationFrames(i10, size - j10);
        }
    }

    public final synchronized void rstStream(int i10, ErrorCode errorCode) throws IOException {
        i.checkNotNullParameter(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        frameHeader(i10, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) throws IOException {
        i.checkNotNullParameter(settings, "settings");
        if (this.closed) {
            throw new IOException("closed");
        }
        int i10 = 0;
        frameHeader(0, settings.size() * 6, 4, 0);
        while (i10 < 10) {
            int i11 = i10 + 1;
            if (settings.isSet(i10)) {
                this.sink.writeShort(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                this.sink.writeInt(settings.get(i10));
            }
            i10 = i11;
        }
        this.sink.flush();
    }

    public final synchronized void windowUpdate(int i10, long j10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(j10 != 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(i.stringPlus("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j10)).toString());
        }
        frameHeader(i10, 4, 8, 0);
        this.sink.writeInt((int) j10);
        this.sink.flush();
    }
}
