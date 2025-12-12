package okhttp3.internal.http2;

import ac.c;
import ah.e;
import ah.y;
import ah.z;
import fg.h;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import o1.a;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.ByteString;
import zf.f;
import zf.i;

/* compiled from: Http2Reader.kt */
/* loaded from: classes2.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final e source;

    /* compiled from: Http2Reader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i10, int i11, int i12) throws IOException {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException(c.g("PROTOCOL_ERROR padding ", i12, " > remaining length ", i10));
        }
    }

    /* compiled from: Http2Reader.kt */
    public interface Handler {
        void ackSettings();

        void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10);

        void data(boolean z10, int i10, e eVar, int i11) throws IOException;

        void goAway(int i10, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z10, int i10, int i11, List<Header> list);

        void ping(boolean z10, int i10, int i11);

        void priority(int i10, int i11, int i12, boolean z10);

        void pushPromise(int i10, int i11, List<Header> list) throws IOException;

        void rstStream(int i10, ErrorCode errorCode);

        void settings(boolean z10, Settings settings);

        void windowUpdate(int i10, long j10);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        i.checkNotNullExpressionValue(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(e eVar, boolean z10) {
        i.checkNotNullParameter(eVar, "source");
        this.source = eVar;
        this.client = z10;
        ContinuationSource continuationSource = new ContinuationSource(eVar);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        if ((i11 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iAnd = (i11 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.data(z10, i12, this.source, Companion.lengthWithoutPadding(i10, i11, iAnd));
        this.source.skip(iAnd);
    }

    private final void readGoAway(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i10 < 8) {
            throw new IOException(i.stringPlus("TYPE_GOAWAY length < 8: ", Integer.valueOf(i10)));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i13 = this.source.readInt();
        int i14 = this.source.readInt();
        int i15 = i10 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i14);
        if (errorCodeFromHttp2 == null) {
            throw new IOException(i.stringPlus("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(i14)));
        }
        ByteString byteString = ByteString.f17102p;
        if (i15 > 0) {
            byteString = this.source.readByteString(i15);
        }
        handler.goAway(i13, errorCodeFromHttp2, byteString);
    }

    private final List<Header> readHeaderBlock(int i10, int i11, int i12, int i13) throws IOException {
        this.continuation.setLeft(i10);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i11);
        this.continuation.setFlags(i12);
        this.continuation.setStreamId(i13);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        int iAnd = (i11 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        if ((i11 & 32) != 0) {
            readPriority(handler, i12);
            i10 -= 5;
        }
        handler.headers(z10, i12, -1, readHeaderBlock(Companion.lengthWithoutPadding(i10, i11, iAnd), iAnd, i11, i12));
    }

    private final void readPing(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i10 != 8) {
            throw new IOException(i.stringPlus("TYPE_PING length != 8: ", Integer.valueOf(i10)));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i11 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i10 != 5) {
            throw new IOException(a.d("TYPE_PRIORITY length: ", i10, " != 5"));
        }
        if (i12 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        readPriority(handler, i12);
    }

    private final void readPushPromise(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iAnd = (i11 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i12, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i10 - 4, i11, iAnd), iAnd, i11, i12));
    }

    private final void readRstStream(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException(a.d("TYPE_RST_STREAM length: ", i10, " != 4"));
        }
        if (i12 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i13 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i13);
        if (errorCodeFromHttp2 == null) {
            throw new IOException(i.stringPlus("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(i13)));
        }
        handler.rstStream(i12, errorCodeFromHttp2);
    }

    private final void readSettings(Handler handler, int i10, int i11, int i12) throws IOException {
        int i13;
        if (i12 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i11 & 1) != 0) {
            if (i10 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (i10 % 6 != 0) {
            throw new IOException(i.stringPlus("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i10)));
        }
        Settings settings = new Settings();
        fg.a aVarStep = h.step(h.until(0, i10), 6);
        int first = aVarStep.getFirst();
        int last = aVarStep.getLast();
        int step = aVarStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int i14 = first + step;
                int iAnd = Util.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                i13 = this.source.readInt();
                if (iAnd != 2) {
                    if (iAnd == 3) {
                        iAnd = 4;
                    } else if (iAnd != 4) {
                        if (iAnd == 5 && (i13 < 16384 || i13 > 16777215)) {
                            break;
                        }
                    } else {
                        if (i13 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iAnd = 7;
                    }
                } else if (i13 != 0 && i13 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.set(iAnd, i13);
                if (first == last) {
                    break;
                } else {
                    first = i14;
                }
            }
            throw new IOException(i.stringPlus("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(i13)));
        }
        handler.settings(false, settings);
    }

    private final void readWindowUpdate(Handler handler, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException(i.stringPlus("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i10)));
        }
        long jAnd = Util.and(this.source.readInt(), 2147483647L);
        if (jAnd == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(i12, jAnd);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z10, Handler handler) throws IOException {
        i.checkNotNullParameter(handler, "handler");
        try {
            this.source.require(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException(i.stringPlus("FRAME_SIZE_ERROR: ", Integer.valueOf(medium)));
            }
            int iAnd = Util.and(this.source.readByte(), 255);
            int iAnd2 = Util.and(this.source.readByte(), 255);
            int i10 = this.source.readInt() & Integer.MAX_VALUE;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.INSTANCE.frameLog(true, i10, medium, iAnd, iAnd2));
            }
            if (z10 && iAnd != 4) {
                throw new IOException(i.stringPlus("Expected a SETTINGS frame but was ", Http2.INSTANCE.formattedType$okhttp(iAnd)));
            }
            switch (iAnd) {
                case 0:
                    readData(handler, medium, iAnd2, i10);
                    return true;
                case 1:
                    readHeaders(handler, medium, iAnd2, i10);
                    return true;
                case 2:
                    readPriority(handler, medium, iAnd2, i10);
                    return true;
                case 3:
                    readRstStream(handler, medium, iAnd2, i10);
                    return true;
                case 4:
                    readSettings(handler, medium, iAnd2, i10);
                    return true;
                case 5:
                    readPushPromise(handler, medium, iAnd2, i10);
                    return true;
                case 6:
                    readPing(handler, medium, iAnd2, i10);
                    return true;
                case 7:
                    readGoAway(handler, medium, iAnd2, i10);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, iAnd2, i10);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        i.checkNotNullParameter(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        e eVar = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString byteString2 = eVar.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format(i.stringPlus("<< CONNECTION ", byteString2.hex()), new Object[0]));
        }
        if (!i.areEqual(byteString, byteString2)) {
            throw new IOException(i.stringPlus("Expected a connection header but was ", byteString2.utf8()));
        }
    }

    private final void readPriority(Handler handler, int i10) throws IOException {
        int i11 = this.source.readInt();
        handler.priority(i10, i11 & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    /* compiled from: Http2Reader.kt */
    public static final class ContinuationSource implements y {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final e source;
        private int streamId;

        public ContinuationSource(e eVar) {
            i.checkNotNullParameter(eVar, "source");
            this.source = eVar;
        }

        private final void readContinuationHeader() throws IOException {
            int i10 = this.streamId;
            int medium = Util.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            int iAnd = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, iAnd, this.flags));
            }
            int i11 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i11;
            if (iAnd == 9) {
                if (i11 != i10) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iAnd + " != TYPE_CONTINUATION");
            }
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // ah.y
        public long read(ah.c cVar, long j10) throws IOException {
            i.checkNotNullParameter(cVar, "sink");
            while (true) {
                int i10 = this.left;
                if (i10 != 0) {
                    long j11 = this.source.read(cVar, Math.min(j10, i10));
                    if (j11 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j11;
                    return j11;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i10) {
            this.flags = i10;
        }

        public final void setLeft(int i10) {
            this.left = i10;
        }

        public final void setLength(int i10) {
            this.length = i10;
        }

        public final void setPadding(int i10) {
            this.padding = i10;
        }

        public final void setStreamId(int i10) {
            this.streamId = i10;
        }

        @Override // ah.y
        public z timeout() {
            return this.source.timeout();
        }

        @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
