package okhttp3;

import ah.d;
import ah.m;
import ah.y;
import ig.c;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.ByteString;
import wf.a;
import zf.f;
import zf.i;

/* compiled from: RequestBody.kt */
/* loaded from: classes2.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    /* compiled from: RequestBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            i.checkNotNullParameter(bArr, "content");
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i10) {
            i.checkNotNullParameter(bArr, "content");
            return create$default(this, mediaType, bArr, i10, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                mediaType = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return companion.create(bArr, mediaType, i10, i11);
        }

        public final RequestBody create(byte[] bArr) {
            i.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            i.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i10) {
            i.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, mediaType, i10, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return companion.create(mediaType, bArr, i10, i11);
        }

        public final RequestBody create(String str, MediaType mediaType) {
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
            byte[] bytes = str.getBytes(charset);
            i.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(final ByteString byteString, final MediaType mediaType) {
            i.checkNotNullParameter(byteString, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return byteString.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(d dVar) throws IOException {
                    i.checkNotNullParameter(dVar, "sink");
                    dVar.write(byteString);
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i10, final int i11) {
            i.checkNotNullParameter(bArr, "<this>");
            Util.checkOffsetAndCount(bArr.length, i10, i11);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i11;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(d dVar) throws IOException {
                    i.checkNotNullParameter(dVar, "sink");
                    dVar.write(bArr, i10, i11);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            i.checkNotNullParameter(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(d dVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                    i.checkNotNullParameter(dVar, "sink");
                    y yVarSource = m.source(file);
                    try {
                        dVar.writeAll(yVarSource);
                        a.closeFinally(yVarSource, null);
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String str) {
            i.checkNotNullParameter(str, "content");
            return create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, ByteString byteString) {
            i.checkNotNullParameter(byteString, "content");
            return create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i10, int i11) {
            i.checkNotNullParameter(bArr, "content");
            return create(bArr, mediaType, i10, i11);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            i.checkNotNullParameter(file, "file");
            return create(file, mediaType);
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(d dVar) throws IOException;

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i10) {
        return Companion.create(mediaType, bArr, i10);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i10, int i11) {
        return Companion.create(mediaType, bArr, i10, i11);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i10) {
        return Companion.create(bArr, mediaType, i10);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i10, int i11) {
        return Companion.create(bArr, mediaType, i10, i11);
    }
}
