package com.airbnb.lottie.parser.moshi;

import ac.c;
import ah.e;
import ah.p;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f5529p = new String[128];

    /* renamed from: b, reason: collision with root package name */
    public int f5530b;

    /* renamed from: m, reason: collision with root package name */
    public int[] f5531m = new int[32];

    /* renamed from: n, reason: collision with root package name */
    public String[] f5532n = new String[32];

    /* renamed from: o, reason: collision with root package name */
    public int[] f5533o = new int[32];

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f5545a;

        /* renamed from: b, reason: collision with root package name */
        public final p f5546b;

        public a(String[] strArr, p pVar) {
            this.f5545a = strArr;
            this.f5546b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IOException -> 0x0069, TryCatch #0 {IOException -> 0x0069, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x0059), top: B:30:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.airbnb.lottie.parser.moshi.JsonReader.a of(java.lang.String... r12) {
            /*
                int r0 = r12.length     // Catch: java.io.IOException -> L69
                okio.ByteString[] r0 = new okio.ByteString[r0]     // Catch: java.io.IOException -> L69
                ah.c r1 = new ah.c     // Catch: java.io.IOException -> L69
                r1.<init>()     // Catch: java.io.IOException -> L69
                r2 = 0
                r3 = 0
            La:
                int r4 = r12.length     // Catch: java.io.IOException -> L69
                if (r3 >= r4) goto L59
                r4 = r12[r3]     // Catch: java.io.IOException -> L69
                java.lang.String[] r5 = com.airbnb.lottie.parser.moshi.JsonReader.f5529p     // Catch: java.io.IOException -> L69
                r6 = 34
                r1.writeByte(r6)     // Catch: java.io.IOException -> L69
                int r7 = r4.length()     // Catch: java.io.IOException -> L69
                r8 = 0
                r9 = 0
            L1c:
                if (r8 >= r7) goto L45
                char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L69
                r11 = 128(0x80, float:1.8E-43)
                if (r10 >= r11) goto L2b
                r10 = r5[r10]     // Catch: java.io.IOException -> L69
                if (r10 != 0) goto L38
                goto L42
            L2b:
                r11 = 8232(0x2028, float:1.1535E-41)
                if (r10 != r11) goto L32
                java.lang.String r10 = "\\u2028"
                goto L38
            L32:
                r11 = 8233(0x2029, float:1.1537E-41)
                if (r10 != r11) goto L42
                java.lang.String r10 = "\\u2029"
            L38:
                if (r9 >= r8) goto L3d
                r1.writeUtf8(r4, r9, r8)     // Catch: java.io.IOException -> L69
            L3d:
                r1.writeUtf8(r10)     // Catch: java.io.IOException -> L69
                int r9 = r8 + 1
            L42:
                int r8 = r8 + 1
                goto L1c
            L45:
                if (r9 >= r7) goto L4a
                r1.writeUtf8(r4, r9, r7)     // Catch: java.io.IOException -> L69
            L4a:
                r1.writeByte(r6)     // Catch: java.io.IOException -> L69
                r1.readByte()     // Catch: java.io.IOException -> L69
                okio.ByteString r4 = r1.readByteString()     // Catch: java.io.IOException -> L69
                r0[r3] = r4     // Catch: java.io.IOException -> L69
                int r3 = r3 + 1
                goto La
            L59:
                com.airbnb.lottie.parser.moshi.JsonReader$a r1 = new com.airbnb.lottie.parser.moshi.JsonReader$a     // Catch: java.io.IOException -> L69
                java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L69
                java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L69
                ah.p r0 = ah.p.of(r0)     // Catch: java.io.IOException -> L69
                r1.<init>(r12, r0)     // Catch: java.io.IOException -> L69
                return r1
            L69:
                r12 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.a.of(java.lang.String[]):com.airbnb.lottie.parser.moshi.JsonReader$a");
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f5529p[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f5529p;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader of(e eVar) {
        return new com.airbnb.lottie.parser.moshi.a(eVar);
    }

    public final void a(int i10) {
        int i11 = this.f5530b;
        int[] iArr = this.f5531m;
        if (i11 == iArr.length) {
            if (i11 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.f5531m = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f5532n;
            this.f5532n = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f5533o;
            this.f5533o = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f5531m;
        int i12 = this.f5530b;
        this.f5530b = i12 + 1;
        iArr3[i12] = i10;
    }

    public final void b(String str) throws JsonEncodingException {
        StringBuilder sbU = c.u(str, " at path ");
        sbU.append(getPath());
        throw new JsonEncodingException(sbU.toString());
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        int i10 = this.f5530b;
        int[] iArr = this.f5531m;
        String[] strArr = this.f5532n;
        int[] iArr2 = this.f5533o;
        StringBuilder sb2 = new StringBuilder("$");
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i11]);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = strArr[i11];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract int selectName(a aVar) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;
}
