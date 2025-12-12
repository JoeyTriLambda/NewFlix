package okhttp3;

import ah.e;
import ig.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import lf.h;
import okhttp3.internal.Util;
import okio.ByteString;
import wf.a;
import yf.l;
import zf.f;
import zf.i;

/* compiled from: ResponseBody.kt */
/* loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    /* compiled from: ResponseBody.kt */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final e source;

        public BomAwareReader(e eVar, Charset charset) {
            i.checkNotNullParameter(eVar, "source");
            i.checkNotNullParameter(charset, "charset");
            this.source = eVar;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            h hVar;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader == null) {
                hVar = null;
            } else {
                reader.close();
                hVar = h.f16056a;
            }
            if (hVar == null) {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            i.checkNotNullParameter(cArr, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i10, i11);
        }
    }

    /* compiled from: ResponseBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            i.checkNotNullParameter(str, "<this>");
            Charset charset = c.f13440b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            ah.c cVarWriteString = new ah.c().writeString(str, charset);
            return create(cVarWriteString, mediaType, cVarWriteString.size());
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, e eVar, MediaType mediaType, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            if ((i10 & 2) != 0) {
                j10 = -1;
            }
            return companion.create(eVar, mediaType, j10);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            i.checkNotNullParameter(bArr, "<this>");
            return create(new ah.c().write(bArr), mediaType, bArr.length);
        }

        public final ResponseBody create(ByteString byteString, MediaType mediaType) {
            i.checkNotNullParameter(byteString, "<this>");
            return create(new ah.c().write(byteString), mediaType, byteString.size());
        }

        public final ResponseBody create(final e eVar, final MediaType mediaType, final long j10) {
            i.checkNotNullParameter(eVar, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j10;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public e source() {
                    return eVar;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String str) {
            i.checkNotNullParameter(str, "content");
            return create(str, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] bArr) {
            i.checkNotNullParameter(bArr, "content");
            return create(bArr, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, ByteString byteString) {
            i.checkNotNullParameter(byteString, "content");
            return create(byteString, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j10, e eVar) {
            i.checkNotNullParameter(eVar, "content");
            return create(eVar, mediaType, j10);
        }
    }

    private final Charset charset() {
        MediaType mediaTypeContentType = contentType();
        Charset charset = mediaTypeContentType == null ? null : mediaTypeContentType.charset(c.f13440b);
        return charset == null ? c.f13440b : charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(l<? super e, ? extends T> lVar, l<? super T, Integer> lVar2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(i.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        e eVarSource = source();
        try {
            T tInvoke = lVar.invoke(eVarSource);
            zf.h.finallyStart(1);
            a.closeFinally(eVarSource, null);
            zf.h.finallyEnd(1);
            int iIntValue = lVar2.invoke(tInvoke).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tInvoke;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } finally {
        }
    }

    public static final ResponseBody create(e eVar, MediaType mediaType, long j10) {
        return Companion.create(eVar, mediaType, j10);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final ByteString byteString() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(i.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        e eVarSource = source();
        try {
            ByteString byteString = eVarSource.readByteString();
            a.closeFinally(eVarSource, null);
            int size = byteString.size();
            if (jContentLength == -1 || jContentLength == size) {
                return byteString;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + size + ") disagree");
        } finally {
        }
    }

    public final byte[] bytes() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(i.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(jContentLength)));
        }
        e eVarSource = source();
        try {
            byte[] byteArray = eVarSource.readByteArray();
            a.closeFinally(eVarSource, null);
            int length = byteArray.length;
            if (jContentLength == -1 || jContentLength == length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract e source();

    public final String string() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        e eVarSource = source();
        try {
            String string = eVarSource.readString(Util.readBomAsCharset(eVarSource, charset()));
            a.closeFinally(eVarSource, null);
            return string;
        } finally {
        }
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final ResponseBody create(MediaType mediaType, long j10, e eVar) {
        return Companion.create(mediaType, j10, eVar);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
