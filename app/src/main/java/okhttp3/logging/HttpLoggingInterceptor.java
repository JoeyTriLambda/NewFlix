package okhttp3.logging;

import ac.c;
import ah.e;
import ah.j;
import com.loopj.android.http.AsyncHttpClient;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.protocol.HTTP;
import ig.l;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import mf.o;
import mf.z;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import org.apache.commons.lang3.StringUtils;
import wf.a;
import zf.f;
import zf.i;
import zf.m;

/* compiled from: HttpLoggingInterceptor.kt */
/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* compiled from: HttpLoggingInterceptor.kt */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        /* compiled from: HttpLoggingInterceptor.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            /* compiled from: HttpLoggingInterceptor.kt */
            public static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String str) {
                    i.checkNotNullParameter(str, "message");
                    Platform.log$default(Platform.Companion.get(), str, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || l.equals(str, HTTP.IDENTITY_CODING, true) || l.equals(str, AsyncHttpClient.ENCODING_GZIP, true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i10) {
        String strValue = this.headersToRedact.contains(headers.name(i10)) ? "██" : headers.value(i10);
        this.logger.log(headers.name(i10) + ": " + strValue);
    }

    /* renamed from: -deprecated_level, reason: not valid java name */
    public final Level m225deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String str;
        Long lValueOf;
        Charset charset;
        i.checkNotNullParameter(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z10 = level == Level.BODY;
        boolean z11 = z10 || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder("--> ");
        sb2.append(request.method());
        sb2.append(TokenParser.SP);
        sb2.append(request.url());
        sb2.append(connection != null ? i.stringPlus(StringUtils.SPACE, connection.protocol()) : "");
        String string = sb2.toString();
        if (!z11 && requestBodyBody != null) {
            StringBuilder sbU = c.u(string, " (");
            sbU.append(requestBodyBody.contentLength());
            sbU.append("-byte body)");
            string = sbU.toString();
        }
        this.logger.log(string);
        if (z11) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null && headers.get("Content-Type") == null) {
                    this.logger.log(i.stringPlus("Content-Type: ", mediaTypeContentType));
                }
                if (requestBodyBody.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log(i.stringPlus("Content-Length: ", Long.valueOf(requestBodyBody.contentLength())));
                }
            }
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                logHeader(headers, i10);
            }
            if (!z10 || requestBodyBody == null) {
                str = "UTF_8";
                this.logger.log(i.stringPlus("--> END ", request.method()));
            } else {
                if (bodyHasUnknownEncoding(request.headers())) {
                    this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                } else if (requestBodyBody.isDuplex()) {
                    this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                } else if (requestBodyBody.isOneShot()) {
                    this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                } else {
                    ah.c cVar = new ah.c();
                    requestBodyBody.writeTo(cVar);
                    MediaType mediaTypeContentType2 = requestBodyBody.contentType();
                    Charset charset2 = mediaTypeContentType2 == null ? null : mediaTypeContentType2.charset(StandardCharsets.UTF_8);
                    if (charset2 == null) {
                        charset2 = StandardCharsets.UTF_8;
                        i.checkNotNullExpressionValue(charset2, "UTF_8");
                    }
                    this.logger.log("");
                    if (Utf8Kt.isProbablyUtf8(cVar)) {
                        this.logger.log(cVar.readString(charset2));
                        this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                        str = "UTF_8";
                    } else {
                        Logger logger = this.logger;
                        StringBuilder sb3 = new StringBuilder("--> END ");
                        sb3.append(request.method());
                        sb3.append(" (binary ");
                        str = "UTF_8";
                        sb3.append(requestBodyBody.contentLength());
                        sb3.append("-byte body omitted)");
                        logger.log(sb3.toString());
                    }
                }
                str = "UTF_8";
            }
        } else {
            str = "UTF_8";
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            i.checkNotNull(responseBodyBody);
            long jContentLength = responseBodyBody.contentLength();
            String str2 = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            Logger logger2 = this.logger;
            StringBuilder sb4 = new StringBuilder("<-- ");
            sb4.append(responseProceed.code());
            sb4.append(responseProceed.message().length() == 0 ? "" : c.j(StringUtils.SPACE, responseProceed.message()));
            sb4.append(TokenParser.SP);
            sb4.append(responseProceed.request().url());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(!z11 ? c.k(", ", str2, " body") : "");
            sb4.append(')');
            logger2.log(sb4.toString());
            if (z11) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    logHeader(headers2, i11);
                }
                if (!z10 || !HttpHeaders.promisesBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(responseProceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    e eVarSource = responseBodyBody.source();
                    eVarSource.request(Long.MAX_VALUE);
                    ah.c buffer = eVarSource.getBuffer();
                    if (l.equals(AsyncHttpClient.ENCODING_GZIP, headers2.get("Content-Encoding"), true)) {
                        lValueOf = Long.valueOf(buffer.size());
                        j jVar = new j(buffer.m0clone());
                        try {
                            buffer = new ah.c();
                            buffer.writeAll(jVar);
                            charset = null;
                            a.closeFinally(jVar, null);
                        } finally {
                        }
                    } else {
                        lValueOf = null;
                        charset = null;
                    }
                    MediaType mediaTypeContentType3 = responseBodyBody.contentType();
                    if (mediaTypeContentType3 != null) {
                        charset = mediaTypeContentType3.charset(StandardCharsets.UTF_8);
                    }
                    if (charset == null) {
                        charset = StandardCharsets.UTF_8;
                        i.checkNotNullExpressionValue(charset, str);
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (jContentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer.m0clone().readString(charset));
                    }
                    if (lValueOf != null) {
                        this.logger.log("<-- END HTTP (" + buffer.size() + "-byte, " + lValueOf + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e10) {
            this.logger.log(i.stringPlus("<-- HTTP FAILED: ", e10));
            throw e10;
        }
    }

    public final void level(Level level) {
        i.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        TreeSet treeSet = new TreeSet(l.getCASE_INSENSITIVE_ORDER(m.f22730a));
        o.addAll(treeSet, this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        i.checkNotNullParameter(level, "level");
        level(level);
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        i.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.headersToRedact = z.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i10, f fVar) {
        this((i10 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
