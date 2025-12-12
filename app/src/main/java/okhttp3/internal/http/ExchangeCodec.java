package okhttp3.internal.http;

import ah.w;
import ah.y;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;

/* compiled from: ExchangeCodec.kt */
/* loaded from: classes2.dex */
public interface ExchangeCodec {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    /* compiled from: ExchangeCodec.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }

    void cancel();

    w createRequestBody(Request request, long j10) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    RealConnection getConnection();

    y openResponseBodySource(Response response) throws IOException;

    Response.Builder readResponseHeaders(boolean z10) throws IOException;

    long reportedContentLength(Response response) throws IOException;

    Headers trailers() throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
