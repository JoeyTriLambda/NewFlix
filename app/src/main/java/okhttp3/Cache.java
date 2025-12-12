package okhttp3;

import ag.a;
import ah.c;
import ah.d;
import ah.e;
import ah.g;
import ah.h;
import ah.m;
import ah.w;
import ah.y;
import ig.l;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.StringsKt__StringsKt;
import mf.k;
import mf.z;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import zf.f;
import zf.i;

/* compiled from: Cache.kt */
/* loaded from: classes2.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* compiled from: Cache.kt */
    public static final class CacheResponseBody extends ResponseBody {
        private final e bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            i.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = m.buffer(new h(this) { // from class: okhttp3.Cache.CacheResponseBody.1
                final /* synthetic */ CacheResponseBody this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this.$source);
                    this.this$0 = this;
                }

                @Override // ah.h, ah.y, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.this$0.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str == null) {
                return -1L;
            }
            return Util.toLongOrDefault(str, -1L);
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str == null) {
                return null;
            }
            return MediaType.Companion.parse(str);
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public e source() {
            return this.bodySource;
        }
    }

    /* compiled from: Cache.kt */
    public final class RealCacheRequest implements CacheRequest {
        private final w body;
        private final w cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            i.checkNotNullParameter(cache, "this$0");
            i.checkNotNullParameter(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            w wVarNewSink = editor.newSink(1);
            this.cacheOut = wVarNewSink;
            this.body = new g(wVarNewSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // ah.g, ah.w, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() throws IOException {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (getDone()) {
                    return;
                }
                setDone(true);
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public w body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z10) {
            this.done = z10;
        }
    }

    /* compiled from: Cache.kt */
    /* renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<String>, a {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;

        public AnonymousClass1() {
            this.delegate = Cache.this.getCache$okhttp().snapshots();
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                try {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        continue;
                        this.nextUrl = m.buffer(next.getSource(0)).readUtf8LineStrict();
                        wf.a.closeFinally(next, null);
                        return true;
                    } finally {
                        try {
                            continue;
                        } catch (Throwable th2) {
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            this.delegate.remove();
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            i.checkNotNull(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
    }

    public Cache(File file, long j10, FileSystem fileSystem) {
        i.checkNotNullParameter(file, "directory");
        i.checkNotNullParameter(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j10, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.abort();
        } catch (IOException unused) {
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m100deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) throws IOException {
        i.checkNotNullParameter(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    Util.closeQuietly(responseBodyBody);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DiskLruCache.Editor editorEdit$default;
        i.checkNotNullParameter(response, "response");
        String strMethod = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!i.areEqual(strMethod, "GET")) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editorEdit$default = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editorEdit$default == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit$default);
                return new RealCacheRequest(this, editorEdit$default);
            } catch (IOException unused2) {
                abortQuietly(editorEdit$default);
                return null;
            }
        } catch (IOException unused3) {
            editorEdit$default = null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        i.checkNotNullParameter(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i10) {
        this.writeAbortCount = i10;
    }

    public final void setWriteSuccessCount$okhttp(int i10) {
        this.writeSuccessCount = i10;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        i.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(Response response, Response response2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DiskLruCache.Editor editorEdit;
        i.checkNotNullParameter(response, "cached");
        i.checkNotNullParameter(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        try {
            editorEdit = ((CacheResponseBody) responseBodyBody).getSnapshot().edit();
            if (editorEdit == null) {
                return;
            }
            try {
                entry.writeTo(editorEdit);
                editorEdit.commit();
            } catch (IOException unused) {
                abortQuietly(editorEdit);
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new AnonymousClass1();
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* compiled from: Cache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (l.equals("Vary", headers.name(i10), true)) {
                    String strValue = headers.value(i10);
                    if (treeSet == null) {
                        treeSet = new TreeSet(l.getCASE_INSENSITIVE_ORDER(zf.m.f22730a));
                    }
                    Iterator it = StringsKt__StringsKt.split$default((CharSequence) strValue, new char[]{','}, false, 0, 6, (Object) null).iterator();
                    while (it.hasNext()) {
                        treeSet.add(StringsKt__StringsKt.trim((String) it.next()).toString());
                    }
                }
                i10 = i11;
            }
            return treeSet == null ? z.emptySet() : treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            i.checkNotNullParameter(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            i.checkNotNullParameter(httpUrl, "url");
            return ByteString.f17101o.encodeUtf8(httpUrl.toString()).md5().hex();
        }

        public final int readInt$okhttp(e eVar) throws IOException {
            i.checkNotNullParameter(eVar, "source");
            try {
                long decimalLong = eVar.readDecimalLong();
                String utf8LineStrict = eVar.readUtf8LineStrict();
                if (decimalLong >= 0 && decimalLong <= 2147483647L) {
                    if (!(utf8LineStrict.length() > 0)) {
                        return (int) decimalLong;
                    }
                }
                throw new IOException("expected an int but was \"" + decimalLong + utf8LineStrict + '\"');
            } catch (NumberFormatException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            i.checkNotNullParameter(response, "<this>");
            Response responseNetworkResponse = response.networkResponse();
            i.checkNotNull(responseNetworkResponse);
            return varyHeaders(responseNetworkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            i.checkNotNullParameter(response, "cachedResponse");
            i.checkNotNullParameter(headers, "cachedRequest");
            i.checkNotNullParameter(request, "newRequest");
            Set<String> setVaryFields = varyFields(response.headers());
            if ((setVaryFields instanceof Collection) && setVaryFields.isEmpty()) {
                return true;
            }
            for (String str : setVaryFields) {
                if (!i.areEqual(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> setVaryFields = varyFields(headers2);
            if (setVaryFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                String strName = headers.name(i10);
                if (setVaryFields.contains(strName)) {
                    builder.add(strName, headers.value(i10));
                }
                i10 = i11;
            }
            return builder.build();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File file, long j10) {
        this(file, j10, FileSystem.SYSTEM);
        i.checkNotNullParameter(file, "directory");
    }

    /* compiled from: Cache.kt */
    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        /* compiled from: Cache.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        static {
            Platform.Companion companion = Platform.Companion;
            SENT_MILLIS = i.stringPlus(companion.get().getPrefix(), "-Sent-Millis");
            RECEIVED_MILLIS = i.stringPlus(companion.get().getPrefix(), "-Received-Millis");
        }

        public Entry(y yVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            i.checkNotNullParameter(yVar, "rawSource");
            try {
                e eVarBuffer = m.buffer(yVar);
                String utf8LineStrict = eVarBuffer.readUtf8LineStrict();
                HttpUrl httpUrl = HttpUrl.Companion.parse(utf8LineStrict);
                if (httpUrl == null) {
                    IOException iOException = new IOException(i.stringPlus("Cache corruption for ", utf8LineStrict));
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = httpUrl;
                this.requestMethod = eVarBuffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int int$okhttp = Cache.Companion.readInt$okhttp(eVarBuffer);
                int i10 = 0;
                while (i10 < int$okhttp) {
                    i10++;
                    builder.addLenient$okhttp(eVarBuffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.Companion.parse(eVarBuffer.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                int int$okhttp2 = Cache.Companion.readInt$okhttp(eVarBuffer);
                int i11 = 0;
                while (i11 < int$okhttp2) {
                    i11++;
                    builder2.addLenient$okhttp(eVarBuffer.readUtf8LineStrict());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j10 = 0;
                this.sentRequestMillis = str2 == null ? 0L : Long.parseLong(str2);
                if (str4 != null) {
                    j10 = Long.parseLong(str4);
                }
                this.receivedResponseMillis = j10;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String utf8LineStrict2 = eVarBuffer.readUtf8LineStrict();
                    if (utf8LineStrict2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + utf8LineStrict2 + '\"');
                    }
                    this.handshake = Handshake.Companion.get(!eVarBuffer.exhausted() ? TlsVersion.Companion.forJavaName(eVarBuffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(eVarBuffer.readUtf8LineStrict()), readCertificateList(eVarBuffer), readCertificateList(eVarBuffer));
                } else {
                    this.handshake = null;
                }
                lf.h hVar = lf.h.f16056a;
                wf.a.closeFinally(yVar, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    wf.a.closeFinally(yVar, th2);
                    throw th3;
                }
            }
        }

        private final boolean isHttps() {
            return i.areEqual(this.url.scheme(), "https");
        }

        private final List<Certificate> readCertificateList(e eVar) throws IOException, CertificateException {
            int int$okhttp = Cache.Companion.readInt$okhttp(eVar);
            if (int$okhttp == -1) {
                return k.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(int$okhttp);
                int i10 = 0;
                while (i10 < int$okhttp) {
                    i10++;
                    String utf8LineStrict = eVar.readUtf8LineStrict();
                    c cVar = new c();
                    ByteString byteStringDecodeBase64 = ByteString.f17101o.decodeBase64(utf8LineStrict);
                    i.checkNotNull(byteStringDecodeBase64);
                    cVar.write(byteStringDecodeBase64);
                    arrayList.add(certificateFactory.generateCertificate(cVar.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        private final void writeCertList(d dVar, List<? extends Certificate> list) throws IOException, CertificateEncodingException {
            try {
                dVar.writeDecimalLong(list.size()).writeByte(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = it.next().getEncoded();
                    ByteString.a aVar = ByteString.f17101o;
                    i.checkNotNullExpressionValue(encoded, "bytes");
                    dVar.writeUtf8(ByteString.a.of$default(aVar, encoded, 0, 0, 3, null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            i.checkNotNullParameter(request, "request");
            i.checkNotNullParameter(response, "response");
            return i.areEqual(this.url, request.url()) && i.areEqual(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            i.checkNotNullParameter(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            i.checkNotNullParameter(editor, "editor");
            d dVarBuffer = m.buffer(editor.newSink(0));
            try {
                dVarBuffer.writeUtf8(this.url.toString()).writeByte(10);
                dVarBuffer.writeUtf8(this.requestMethod).writeByte(10);
                dVarBuffer.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                int i10 = 0;
                while (i10 < size) {
                    int i11 = i10 + 1;
                    dVarBuffer.writeUtf8(this.varyHeaders.name(i10)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i10)).writeByte(10);
                    i10 = i11;
                }
                dVarBuffer.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                dVarBuffer.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    dVarBuffer.writeUtf8(this.responseHeaders.name(i12)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i12)).writeByte(10);
                }
                dVarBuffer.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
                dVarBuffer.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
                if (isHttps()) {
                    dVarBuffer.writeByte(10);
                    Handshake handshake = this.handshake;
                    i.checkNotNull(handshake);
                    dVarBuffer.writeUtf8(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(dVarBuffer, this.handshake.peerCertificates());
                    writeCertList(dVarBuffer, this.handshake.localCertificates());
                    dVarBuffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                lf.h hVar = lf.h.f16056a;
                wf.a.closeFinally(dVarBuffer, null);
            } finally {
            }
        }

        public Entry(Response response) {
            i.checkNotNullParameter(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
