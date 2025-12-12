package okhttp3;

import ah.c;
import ah.e;
import ah.m;
import ah.p;
import ah.y;
import ah.z;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http1.HeadersReader;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;
import zf.f;
import zf.i;

/* compiled from: MultipartReader.kt */
/* loaded from: classes2.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final p afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final e source;

    /* compiled from: MultipartReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final p getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }
    }

    /* compiled from: MultipartReader.kt */
    public static final class Part implements Closeable {
        private final e body;
        private final Headers headers;

        public Part(Headers headers, e eVar) {
            i.checkNotNullParameter(headers, "headers");
            i.checkNotNullParameter(eVar, "body");
            this.headers = headers;
            this.body = eVar;
        }

        public final e body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    /* compiled from: MultipartReader.kt */
    public final class PartSource implements y {
        final /* synthetic */ MultipartReader this$0;
        private final z timeout;

        public PartSource(MultipartReader multipartReader) {
            i.checkNotNullParameter(multipartReader, "this$0");
            this.this$0 = multipartReader;
            this.timeout = new z();
        }

        @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (i.areEqual(this.this$0.currentPart, this)) {
                this.this$0.currentPart = null;
            }
        }

        @Override // ah.y
        public long read(c cVar, long j10) {
            i.checkNotNullParameter(cVar, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!i.areEqual(this.this$0.currentPart, this)) {
                throw new IllegalStateException("closed".toString());
            }
            z zVarTimeout = this.this$0.source.timeout();
            z zVar = this.timeout;
            MultipartReader multipartReader = this.this$0;
            long jTimeoutNanos = zVarTimeout.timeoutNanos();
            long jMinTimeout = z.Companion.minTimeout(zVar.timeoutNanos(), zVarTimeout.timeoutNanos());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            zVarTimeout.timeout(jMinTimeout, timeUnit);
            if (!zVarTimeout.hasDeadline()) {
                if (zVar.hasDeadline()) {
                    zVarTimeout.deadlineNanoTime(zVar.deadlineNanoTime());
                }
                try {
                    long jCurrentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j10);
                    long j11 = jCurrentPartBytesRemaining == 0 ? -1L : multipartReader.source.read(cVar, jCurrentPartBytesRemaining);
                    zVarTimeout.timeout(jTimeoutNanos, timeUnit);
                    if (zVar.hasDeadline()) {
                        zVarTimeout.clearDeadline();
                    }
                    return j11;
                } catch (Throwable th2) {
                    zVarTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (zVar.hasDeadline()) {
                        zVarTimeout.clearDeadline();
                    }
                    throw th2;
                }
            }
            long jDeadlineNanoTime = zVarTimeout.deadlineNanoTime();
            if (zVar.hasDeadline()) {
                zVarTimeout.deadlineNanoTime(Math.min(zVarTimeout.deadlineNanoTime(), zVar.deadlineNanoTime()));
            }
            try {
                long jCurrentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j10);
                long j12 = jCurrentPartBytesRemaining2 == 0 ? -1L : multipartReader.source.read(cVar, jCurrentPartBytesRemaining2);
                zVarTimeout.timeout(jTimeoutNanos, timeUnit);
                if (zVar.hasDeadline()) {
                    zVarTimeout.deadlineNanoTime(jDeadlineNanoTime);
                }
                return j12;
            } catch (Throwable th3) {
                zVarTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (zVar.hasDeadline()) {
                    zVarTimeout.deadlineNanoTime(jDeadlineNanoTime);
                }
                throw th3;
            }
        }

        @Override // ah.y
        public z timeout() {
            return this.timeout;
        }
    }

    static {
        p.a aVar = p.f705o;
        ByteString.a aVar2 = ByteString.f17101o;
        afterBoundaryOptions = aVar.of(aVar2.encodeUtf8("\r\n"), aVar2.encodeUtf8("--"), aVar2.encodeUtf8(StringUtils.SPACE), aVar2.encodeUtf8("\t"));
    }

    public MultipartReader(e eVar, String str) throws IOException {
        i.checkNotNullParameter(eVar, "source");
        i.checkNotNullParameter(str, "boundary");
        this.source = eVar;
        this.boundary = str;
        this.dashDashBoundary = new c().writeUtf8("--").writeUtf8(str).readByteString();
        this.crlfDashDashBoundary = new c().writeUtf8("\r\n--").writeUtf8(str).readByteString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j10) throws IOException {
        this.source.require(this.crlfDashDashBoundary.size());
        long jIndexOf = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        return jIndexOf == -1 ? Math.min(j10, (this.source.getBuffer().size() - this.crlfDashDashBoundary.size()) + 1) : Math.min(j10, jIndexOf);
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.size());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(jCurrentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.size());
        }
        boolean z10 = false;
        while (true) {
            int iSelect = this.source.select(afterBoundaryOptions);
            if (iSelect == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iSelect == 0) {
                this.partCount++;
                Headers headers = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource(this);
                this.currentPart = partSource;
                return new Part(headers, m.buffer(partSource));
            }
            if (iSelect == 1) {
                if (z10) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (iSelect == 2 || iSelect == 3) {
                z10 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(ResponseBody responseBody) throws IOException {
        i.checkNotNullParameter(responseBody, "response");
        e eVarSource = responseBody.source();
        MediaType mediaTypeContentType = responseBody.contentType();
        String strParameter = mediaTypeContentType == null ? null : mediaTypeContentType.parameter("boundary");
        if (strParameter != null) {
            this(eVarSource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
