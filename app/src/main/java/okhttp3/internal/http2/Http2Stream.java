package okhttp3.internal.http2;

import ah.a;
import ah.c;
import ah.e;
import ah.w;
import ah.y;
import ah.z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import lf.h;
import okhttp3.Headers;
import okhttp3.internal.Util;
import zf.f;
import zf.i;

/* compiled from: Http2Stream.kt */
/* loaded from: classes2.dex */
public final class Http2Stream {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;

    /* renamed from: id, reason: collision with root package name */
    private final int f17100id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    /* compiled from: Http2Stream.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: Http2Stream.kt */
    public final class FramingSource implements y {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final c readBuffer;
        private final c receiveBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSource(Http2Stream http2Stream, long j10, boolean z10) {
            i.checkNotNullParameter(http2Stream, "this$0");
            this.this$0 = http2Stream;
            this.maxByteCount = j10;
            this.finished = z10;
            this.receiveBuffer = new c();
            this.readBuffer = new c();
        }

        private final void updateConnectionFlowControl(long j10) {
            Http2Stream http2Stream = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.this$0.getConnection().updateConnectionFlowControl$okhttp(j10);
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = this.this$0;
            synchronized (http2Stream) {
                setClosed$okhttp(true);
                size = getReadBuffer().size();
                getReadBuffer().clear();
                http2Stream.notifyAll();
                h hVar = h.f16056a;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            this.this$0.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final c getReadBuffer() {
            return this.readBuffer;
        }

        public final c getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // ah.y
        public long read(c cVar, long j10) throws IOException {
            IOException errorException$okhttp;
            long j11;
            boolean z10;
            i.checkNotNullParameter(cVar, "sink");
            long j12 = 0;
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            while (true) {
                Http2Stream http2Stream = this.this$0;
                synchronized (http2Stream) {
                    http2Stream.getReadTimeout$okhttp().enter();
                    try {
                        if (http2Stream.getErrorCode$okhttp() != null) {
                            errorException$okhttp = http2Stream.getErrorException$okhttp();
                            if (errorException$okhttp == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                i.checkNotNull(errorCode$okhttp);
                                errorException$okhttp = new StreamResetException(errorCode$okhttp);
                            }
                        } else {
                            errorException$okhttp = null;
                        }
                        if (getClosed$okhttp()) {
                            throw new IOException("stream closed");
                        }
                        if (getReadBuffer().size() > j12) {
                            j11 = getReadBuffer().read(cVar, Math.min(j10, getReadBuffer().size()));
                            http2Stream.setReadBytesTotal$okhttp(http2Stream.getReadBytesTotal() + j11);
                            long readBytesTotal = http2Stream.getReadBytesTotal() - http2Stream.getReadBytesAcknowledged();
                            if (errorException$okhttp == null && readBytesTotal >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), readBytesTotal);
                                http2Stream.setReadBytesAcknowledged$okhttp(http2Stream.getReadBytesTotal());
                            }
                        } else if (getFinished$okhttp() || errorException$okhttp != null) {
                            j11 = -1;
                        } else {
                            http2Stream.waitForIo$okhttp();
                            j11 = -1;
                            z10 = true;
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                            h hVar = h.f16056a;
                        }
                        z10 = false;
                        http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                        h hVar2 = h.f16056a;
                    } finally {
                    }
                }
                if (!z10) {
                    if (j11 != -1) {
                        updateConnectionFlowControl(j11);
                        return j11;
                    }
                    if (errorException$okhttp == null) {
                        return -1L;
                    }
                    throw errorException$okhttp;
                }
                j12 = 0;
            }
        }

        public final void receive$okhttp(e eVar, long j10) throws IOException {
            boolean finished$okhttp;
            boolean z10;
            boolean z11;
            long size;
            i.checkNotNullParameter(eVar, "source");
            Http2Stream http2Stream = this.this$0;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            while (j10 > 0) {
                synchronized (this.this$0) {
                    finished$okhttp = getFinished$okhttp();
                    z10 = true;
                    z11 = getReadBuffer().size() + j10 > this.maxByteCount;
                    h hVar = h.f16056a;
                }
                if (z11) {
                    eVar.skip(j10);
                    this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (finished$okhttp) {
                    eVar.skip(j10);
                    return;
                }
                long j11 = eVar.read(this.receiveBuffer, j10);
                if (j11 == -1) {
                    throw new EOFException();
                }
                j10 -= j11;
                Http2Stream http2Stream2 = this.this$0;
                synchronized (http2Stream2) {
                    if (getClosed$okhttp()) {
                        size = getReceiveBuffer().size();
                        getReceiveBuffer().clear();
                    } else {
                        if (getReadBuffer().size() != 0) {
                            z10 = false;
                        }
                        getReadBuffer().writeAll(getReceiveBuffer());
                        if (z10) {
                            http2Stream2.notifyAll();
                        }
                        size = 0;
                    }
                }
                if (size > 0) {
                    updateConnectionFlowControl(size);
                }
            }
        }

        public final void setClosed$okhttp(boolean z10) {
            this.closed = z10;
        }

        public final void setFinished$okhttp(boolean z10) {
            this.finished = z10;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // ah.y
        public z timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }
    }

    /* compiled from: Http2Stream.kt */
    public final class StreamTimeout extends a {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream http2Stream) {
            i.checkNotNullParameter(http2Stream, "this$0");
            this.this$0 = http2Stream;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // ah.a
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // ah.a
        public void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i10, Http2Connection http2Connection, boolean z10, boolean z11, Headers headers) {
        i.checkNotNullParameter(http2Connection, "connection");
        this.f17100id = i10;
        this.connection = http2Connection;
        this.writeBytesMaximum = http2Connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(this, http2Connection.getOkHttpSettings().getInitialWindowSize(), z11);
        this.sink = new FramingSink(this, z10);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!isLocallyInitiated())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            if (getSource$okhttp().getFinished$okhttp() && getSink$okhttp().getFinished()) {
                return false;
            }
            setErrorCode$okhttp(errorCode);
            setErrorException$okhttp(iOException);
            notifyAll();
            h hVar = h.f16056a;
            this.connection.removeStream$okhttp(this.f17100id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long j10) {
        this.writeBytesMaximum += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z10;
        boolean zIsOpen;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z10 = !getSource$okhttp().getFinished$okhttp() && getSource$okhttp().getClosed$okhttp() && (getSink$okhttp().getFinished() || getSink$okhttp().getClosed());
            zIsOpen = isOpen();
            h hVar = h.f16056a;
        }
        if (z10) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.f17100id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            i.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void close(ErrorCode errorCode, IOException iOException) throws IOException {
        i.checkNotNullParameter(errorCode, "rstStatusCode");
        if (closeInternal(errorCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.f17100id, errorCode);
        }
    }

    public final void closeLater(ErrorCode errorCode) {
        i.checkNotNullParameter(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.f17100id, errorCode);
        }
    }

    public final void enqueueTrailers(Headers headers) {
        i.checkNotNullParameter(headers, "trailers");
        synchronized (this) {
            boolean z10 = true;
            if (!(!getSink$okhttp().getFinished())) {
                throw new IllegalStateException("already finished".toString());
            }
            if (headers.size() == 0) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            getSink$okhttp().setTrailers(headers);
            h hVar = h.f16056a;
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.f17100id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final w getSink() {
        synchronized (this) {
            if (!(this.hasResponseHeaders || isLocallyInitiated())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            h hVar = h.f16056a;
        }
        return this.sink;
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final y getSource() {
        return this.source;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.f17100id & 1) == 1);
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.getFinished$okhttp() || this.source.getClosed$okhttp()) && (this.sink.getFinished() || this.sink.getClosed())) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public final z readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(e eVar, int i10) throws IOException {
        i.checkNotNullParameter(eVar, "source");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            this.source.receive$okhttp(eVar, i10);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void receiveHeaders(Headers headers, boolean z10) {
        boolean zIsOpen;
        i.checkNotNullParameter(headers, "headers");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.hasResponseHeaders && z10) {
                getSource$okhttp().setTrailers(headers);
            } else {
                this.hasResponseHeaders = true;
                this.headersQueue.add(headers);
            }
            if (z10) {
                getSource$okhttp().setFinished$okhttp(true);
            }
            zIsOpen = isOpen();
            notifyAll();
            h hVar = h.f16056a;
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.f17100id);
    }

    public final synchronized void receiveRstStream(ErrorCode errorCode) {
        i.checkNotNullParameter(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j10) {
        this.readBytesAcknowledged = j10;
    }

    public final void setReadBytesTotal$okhttp(long j10) {
        this.readBytesTotal = j10;
    }

    public final void setWriteBytesMaximum$okhttp(long j10) {
        this.writeBytesMaximum = j10;
    }

    public final void setWriteBytesTotal$okhttp(long j10) {
        this.writeBytesTotal = j10;
    }

    public final synchronized Headers takeHeaders() throws IOException {
        Headers headersRemoveFirst;
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo$okhttp();
            } catch (Throwable th2) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th2;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!(!this.headersQueue.isEmpty())) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            i.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
        headersRemoveFirst = this.headersQueue.removeFirst();
        i.checkNotNullExpressionValue(headersRemoveFirst, "headersQueue.removeFirst()");
        return headersRemoveFirst;
    }

    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (!this.source.getFinished$okhttp() || !this.source.getReceiveBuffer().exhausted() || !this.source.getReadBuffer().exhausted()) {
            if (this.errorCode == null) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            i.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
        trailers = this.source.getTrailers();
        if (trailers == null) {
            trailers = Util.EMPTY_HEADERS;
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> list, boolean z10, boolean z11) throws IOException {
        boolean z12;
        i.checkNotNullParameter(list, "responseHeaders");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z10) {
                getSink$okhttp().setFinished(true);
            }
            h hVar = h.f16056a;
        }
        if (!z11) {
            synchronized (this.connection) {
                z12 = getConnection().getWriteBytesTotal() >= getConnection().getWriteBytesMaximum();
            }
            z11 = z12;
        }
        this.connection.writeHeaders$okhttp(this.f17100id, z10, list);
        if (z11) {
            this.connection.flush();
        }
    }

    public final z writeTimeout() {
        return this.writeTimeout;
    }

    /* compiled from: Http2Stream.kt */
    public final class FramingSink implements w {
        private boolean closed;
        private boolean finished;
        private final c sendBuffer;
        private Headers trailers;

        public FramingSink(Http2Stream http2Stream, boolean z10) {
            i.checkNotNullParameter(http2Stream, "this$0");
            Http2Stream.this = http2Stream;
            this.finished = z10;
            this.sendBuffer = new c();
        }

        private final void emitFrame(boolean z10) throws IOException {
            long jMin;
            boolean z11;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !getFinished() && !getClosed() && http2Stream.getErrorCode$okhttp() == null) {
                    try {
                        http2Stream.waitForIo$okhttp();
                    } finally {
                        http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                    }
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                jMin = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + jMin);
                z11 = z10 && jMin == this.sendBuffer.size();
                h hVar = h.f16056a;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z11, this.sendBuffer, jMin);
            } finally {
                http2Stream = Http2Stream.this;
            }
        }

        @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (getClosed()) {
                    return;
                }
                boolean z10 = http2Stream2.getErrorCode$okhttp() == null;
                h hVar = h.f16056a;
                if (!Http2Stream.this.getSink$okhttp().finished) {
                    boolean z11 = this.sendBuffer.size() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id2 = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        i.checkNotNull(headers);
                        connection.writeHeaders$okhttp(id2, z10, Util.toHeaderList(headers));
                    } else if (z11) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else if (z10) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    setClosed(true);
                    h hVar2 = h.f16056a;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // ah.w, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
                h hVar = h.f16056a;
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z10) {
            this.closed = z10;
        }

        public final void setFinished(boolean z10) {
            this.finished = z10;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // ah.w
        public z timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // ah.w
        public void write(c cVar, long j10) throws IOException {
            i.checkNotNullParameter(cVar, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(cVar, j10);
                while (this.sendBuffer.size() >= 16384) {
                    emitFrame(false);
                }
            } else {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
        }

        public /* synthetic */ FramingSink(boolean z10, int i10, f fVar) {
            this(Http2Stream.this, (i10 & 1) != 0 ? false : z10);
        }
    }
}
