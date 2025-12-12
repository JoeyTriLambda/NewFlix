package okhttp3.internal.http1;

import ah.c;
import ah.d;
import ah.e;
import ah.i;
import ah.w;
import ah.y;
import ah.z;
import cz.msebera.android.httpclient.protocol.HTTP;
import ig.l;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import zf.f;

/* compiled from: Http1ExchangeCodec.kt */
/* loaded from: classes2.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = new Companion(null);
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final d sink;
    private final e source;
    private int state;
    private Headers trailers;

    /* compiled from: Http1ExchangeCodec.kt */
    public abstract class AbstractSource implements y {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final i timeout;

        public AbstractSource(Http1ExchangeCodec http1ExchangeCodec) {
            zf.i.checkNotNullParameter(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.timeout = new i(http1ExchangeCodec.source.timeout());
        }

        @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close() throws IOException;

        public final boolean getClosed() {
            return this.closed;
        }

        public final i getTimeout() {
            return this.timeout;
        }

        @Override // ah.y
        public long read(c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "sink");
            try {
                return this.this$0.source.read(cVar, j10);
            } catch (IOException e10) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
                throw e10;
            }
        }

        public final void responseBodyComplete() {
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(this.this$0.state)));
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 6;
        }

        public final void setClosed(boolean z10) {
            this.closed = z10;
        }

        @Override // ah.y
        public z timeout() {
            return this.timeout;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class ChunkedSink implements w {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final i timeout;

        public ChunkedSink(Http1ExchangeCodec http1ExchangeCodec) {
            zf.i.checkNotNullParameter(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.timeout = new i(http1ExchangeCodec.sink.timeout());
        }

        @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.sink.writeUtf8("0\r\n\r\n");
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override // ah.w, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // ah.w
        public z timeout() {
            return this.timeout;
        }

        @Override // ah.w
        public void write(c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j10 == 0) {
                return;
            }
            this.this$0.sink.writeHexadecimalUnsignedLong(j10);
            this.this$0.sink.writeUtf8("\r\n");
            this.this$0.sink.write(cVar, j10);
            this.this$0.sink.writeUtf8("\r\n");
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super(http1ExchangeCodec);
            zf.i.checkNotNullParameter(http1ExchangeCodec, "this$0");
            zf.i.checkNotNullParameter(httpUrl, "url");
            this.this$0 = http1ExchangeCodec;
            this.url = httpUrl;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();
                String string = StringsKt__StringsKt.trim(this.this$0.source.readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (!(string.length() > 0) || l.startsWith$default(string, ";", false, 2, null)) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            Http1ExchangeCodec http1ExchangeCodec = this.this$0;
                            http1ExchangeCodec.trailers = http1ExchangeCodec.headersReader.readHeaders();
                            OkHttpClient okHttpClient = this.this$0.client;
                            zf.i.checkNotNull(okHttpClient);
                            CookieJar cookieJar = okHttpClient.cookieJar();
                            HttpUrl httpUrl = this.url;
                            Headers headers = this.this$0.trailers;
                            zf.i.checkNotNull(headers);
                            HttpHeaders.receiveHeaders(cookieJar, httpUrl, headers);
                            responseBodyComplete();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + '\"');
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, ah.y
        public long read(c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(true ^ getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j11 = this.bytesRemainingInChunk;
            if (j11 == 0 || j11 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j12 = super.read(cVar, Math.min(j10, this.bytesRemainingInChunk));
            if (j12 != -1) {
                this.bytesRemainingInChunk -= j12;
                return j12;
            }
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec http1ExchangeCodec, long j10) {
            super(http1ExchangeCodec);
            zf.i.checkNotNullParameter(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.bytesRemaining = j10;
            if (j10 == 0) {
                responseBodyComplete();
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, ah.y
        public long read(c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(true ^ getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            long j11 = this.bytesRemaining;
            if (j11 == 0) {
                return -1L;
            }
            long j12 = super.read(cVar, Math.min(j11, j10));
            if (j12 == -1) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            long j13 = this.bytesRemaining - j12;
            this.bytesRemaining = j13;
            if (j13 == 0) {
                responseBodyComplete();
            }
            return j12;
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class KnownLengthSink implements w {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final i timeout;

        public KnownLengthSink(Http1ExchangeCodec http1ExchangeCodec) {
            zf.i.checkNotNullParameter(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
            this.timeout = new i(http1ExchangeCodec.sink.timeout());
        }

        @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override // ah.w, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // ah.w
        public z timeout() {
            return this.timeout;
        }

        @Override // ah.w
        public void write(c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Util.checkOffsetAndCount(cVar.size(), 0L, j10);
            this.this$0.sink.write(cVar, j10);
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec http1ExchangeCodec) {
            super(http1ExchangeCodec);
            zf.i.checkNotNullParameter(http1ExchangeCodec, "this$0");
            this.this$0 = http1ExchangeCodec;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, ah.y
        public long read(c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j11 = super.read(cVar, j10);
            if (j11 != -1) {
                return j11;
            }
            this.inputExhausted = true;
            responseBodyComplete();
            return -1L;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, e eVar, d dVar) {
        zf.i.checkNotNullParameter(realConnection, "connection");
        zf.i.checkNotNullParameter(eVar, "source");
        zf.i.checkNotNullParameter(dVar, "sink");
        this.client = okHttpClient;
        this.connection = realConnection;
        this.source = eVar;
        this.sink = dVar;
        this.headersReader = new HeadersReader(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(i iVar) {
        z zVarDelegate = iVar.delegate();
        iVar.setDelegate(z.NONE);
        zVarDelegate.clearDeadline();
        zVarDelegate.clearTimeout();
    }

    private final boolean isChunked(Response response) {
        return l.equals(HTTP.CHUNK_CODING, Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
    }

    private final w newChunkedSink() {
        int i10 = this.state;
        if (!(i10 == 1)) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        this.state = 2;
        return new ChunkedSink(this);
    }

    private final y newChunkedSource(HttpUrl httpUrl) {
        int i10 = this.state;
        if (!(i10 == 4)) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        this.state = 5;
        return new ChunkedSource(this, httpUrl);
    }

    private final y newFixedLengthSource(long j10) {
        int i10 = this.state;
        if (!(i10 == 4)) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        this.state = 5;
        return new FixedLengthSource(this, j10);
    }

    private final w newKnownLengthSink() {
        int i10 = this.state;
        if (!(i10 == 1)) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        this.state = 2;
        return new KnownLengthSink(this);
    }

    private final y newUnknownLengthSource() {
        int i10 = this.state;
        if (!(i10 == 4)) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        this.state = 5;
        getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public w createRequestBody(Request request, long j10) throws ProtocolException {
        zf.i.checkNotNullParameter(request, "request");
        if (request.body() != null && request.body().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (j10 != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public y openResponseBodySource(Response response) {
        zf.i.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0L);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long jHeadersContentLength = Util.headersContentLength(response);
        return jHeadersContentLength != -1 ? newFixedLengthSource(jHeadersContentLength) : newUnknownLengthSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z10) {
        int i10 = this.state;
        boolean z11 = true;
        if (i10 != 1 && i10 != 3) {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        try {
            StatusLine statusLine = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder builderHeaders = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.headersReader.readHeaders());
            if (z10 && statusLine.code == 100) {
                return null;
            }
            if (statusLine.code == 100) {
                this.state = 3;
                return builderHeaders;
            }
            this.state = 4;
            return builderHeaders;
        } catch (EOFException e10) {
            throw new IOException(zf.i.stringPlus("unexpected end of stream on ", getConnection().route().address().url().redact()), e10);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        zf.i.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (isChunked(response)) {
            return -1L;
        }
        return Util.headersContentLength(response);
    }

    public final void skipConnectBody(Response response) {
        zf.i.checkNotNullParameter(response, "response");
        long jHeadersContentLength = Util.headersContentLength(response);
        if (jHeadersContentLength == -1) {
            return;
        }
        y yVarNewFixedLengthSource = newFixedLengthSource(jHeadersContentLength);
        Util.skipAll(yVarNewFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        yVarNewFixedLengthSource.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        if (!(this.state == 6)) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        Headers headers = this.trailers;
        return headers == null ? Util.EMPTY_HEADERS : headers;
    }

    public final void writeRequest(Headers headers, String str) {
        zf.i.checkNotNullParameter(headers, "headers");
        zf.i.checkNotNullParameter(str, "requestLine");
        int i10 = this.state;
        if (!(i10 == 0)) {
            throw new IllegalStateException(zf.i.stringPlus("state: ", Integer.valueOf(i10)).toString());
        }
        this.sink.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.sink.writeUtf8(headers.name(i11)).writeUtf8(": ").writeUtf8(headers.value(i11)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        zf.i.checkNotNullParameter(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getConnection().route().proxy().type();
        zf.i.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    private final boolean isChunked(Request request) {
        return l.equals(HTTP.CHUNK_CODING, request.header("Transfer-Encoding"), true);
    }
}
