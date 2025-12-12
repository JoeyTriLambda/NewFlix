package okhttp3;

import ah.c;
import ah.d;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.ByteString;
import zf.f;
import zf.i;

/* compiled from: MultipartBody.kt */
/* loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    /* compiled from: MultipartBody.kt */
    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        public final Builder addPart(RequestBody requestBody) {
            i.checkNotNullParameter(requestBody, "body");
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final Builder setType(MediaType mediaType) {
            i.checkNotNullParameter(mediaType, "type");
            if (!i.areEqual(mediaType.type(), "multipart")) {
                throw new IllegalArgumentException(i.stringPlus("multipart != ", mediaType).toString());
            }
            this.type = mediaType;
            return this;
        }

        public Builder(String str) {
            i.checkNotNullParameter(str, "boundary");
            this.boundary = ByteString.f17101o.encodeUtf8(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(requestBody, "body");
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            i.checkNotNullParameter(requestBody, "body");
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        public final Builder addPart(Part part) {
            i.checkNotNullParameter(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i10, f fVar) {
            if ((i10 & 1) != 0) {
                str = UUID.randomUUID().toString();
                i.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    /* compiled from: MultipartBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder sb2, String str) {
            i.checkNotNullParameter(sb2, "<this>");
            i.checkNotNullParameter(str, "key");
            sb2.append('\"');
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                char cCharAt = str.charAt(i10);
                if (cCharAt == '\n') {
                    sb2.append("%0A");
                } else if (cCharAt == '\r') {
                    sb2.append("%0D");
                } else if (cCharAt == '\"') {
                    sb2.append("%22");
                } else {
                    sb2.append(cCharAt);
                }
                i10 = i11;
            }
            sb2.append('\"');
        }
    }

    /* compiled from: MultipartBody.kt */
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        /* compiled from: MultipartBody.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final Part create(RequestBody requestBody) {
                i.checkNotNullParameter(requestBody, "body");
                return create(null, requestBody);
            }

            public final Part createFormData(String str, String str2) {
                i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
                i.checkNotNullParameter(str2, "value");
                return createFormData(str, null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            public final Part create(Headers headers, RequestBody requestBody) {
                i.checkNotNullParameter(requestBody, "body");
                f fVar = null;
                if (!((headers == null ? null : headers.get("Content-Type")) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers == null ? null : headers.get("Content-Length")) == null) {
                    return new Part(headers, requestBody, fVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            public final Part createFormData(String str, String str2, RequestBody requestBody) {
                i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
                i.checkNotNullParameter(requestBody, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb2, str);
                if (str2 != null) {
                    sb2.append("; filename=");
                    companion.appendQuotedString$okhttp(sb2, str2);
                }
                String string = sb2.toString();
                i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", string).build(), requestBody);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, f fVar) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        /* renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m171deprecated_body() {
            return this.body;
        }

        /* renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m172deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        i.checkNotNullParameter(byteString, "boundaryByteString");
        i.checkNotNullParameter(mediaType, "type");
        i.checkNotNullParameter(list, "parts");
        this.boundaryByteString = byteString;
        this.type = mediaType;
        this.parts = list;
        this.contentType = MediaType.Companion.get(mediaType + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(d dVar, boolean z10) throws IOException {
        c cVar;
        if (z10) {
            dVar = new c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.parts.size();
        long j10 = 0;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            Part part = this.parts.get(i10);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            i.checkNotNull(dVar);
            dVar.write(DASHDASH);
            dVar.write(this.boundaryByteString);
            dVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    dVar.writeUtf8(headers.name(i12)).write(COLONSPACE).writeUtf8(headers.value(i12)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                dVar.writeUtf8("Content-Type: ").writeUtf8(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                dVar.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(CRLF);
            } else if (z10) {
                i.checkNotNull(cVar);
                cVar.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            dVar.write(bArr);
            if (z10) {
                j10 += jContentLength;
            } else {
                requestBodyBody.writeTo(dVar);
            }
            dVar.write(bArr);
            i10 = i11;
        }
        i.checkNotNull(dVar);
        byte[] bArr2 = DASHDASH;
        dVar.write(bArr2);
        dVar.write(this.boundaryByteString);
        dVar.write(bArr2);
        dVar.write(CRLF);
        if (!z10) {
            return j10;
        }
        i.checkNotNull(cVar);
        long size3 = j10 + cVar.size();
        cVar.clear();
        return size3;
    }

    /* renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m167deprecated_boundary() {
        return boundary();
    }

    /* renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m168deprecated_parts() {
        return this.parts;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m169deprecated_size() {
        return size();
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m170deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j10 = this.contentLength;
        if (j10 != -1) {
            return j10;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i10) {
        return this.parts.get(i10);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(d dVar) throws IOException {
        i.checkNotNullParameter(dVar, "sink");
        writeOrCountBytes(dVar, false);
    }
}
