package z9;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f22643u = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: v, reason: collision with root package name */
    public static final String[] f22644v = new String[128];

    /* renamed from: w, reason: collision with root package name */
    public static final String[] f22645w;

    /* renamed from: b, reason: collision with root package name */
    public final Writer f22646b;

    /* renamed from: m, reason: collision with root package name */
    public int[] f22647m;

    /* renamed from: n, reason: collision with root package name */
    public int f22648n;

    /* renamed from: o, reason: collision with root package name */
    public String f22649o;

    /* renamed from: p, reason: collision with root package name */
    public String f22650p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f22651q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f22652r;

    /* renamed from: s, reason: collision with root package name */
    public String f22653s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f22654t;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f22644v[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f22644v;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f22645w = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f22647m = iArr;
        this.f22648n = 0;
        if (iArr.length == 0) {
            this.f22647m = Arrays.copyOf(iArr, 0 * 2);
        }
        int[] iArr2 = this.f22647m;
        int i10 = this.f22648n;
        this.f22648n = i10 + 1;
        iArr2[i10] = 6;
        this.f22650p = ":";
        this.f22654t = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f22646b = writer;
    }

    public final void a() throws IOException {
        int iD = d();
        if (iD == 1) {
            this.f22647m[this.f22648n - 1] = 2;
            c();
            return;
        }
        Writer writer = this.f22646b;
        if (iD == 2) {
            writer.append(',');
            c();
        } else {
            if (iD == 4) {
                writer.append((CharSequence) this.f22650p);
                this.f22647m[this.f22648n - 1] = 5;
                return;
            }
            if (iD != 6) {
                if (iD != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f22651q) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f22647m[this.f22648n - 1] = 7;
        }
    }

    public final void b(int i10, int i11, char c10) throws IOException {
        int iD = d();
        if (iD != i11 && iD != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f22653s != null) {
            throw new IllegalStateException("Dangling name: " + this.f22653s);
        }
        this.f22648n--;
        if (iD == i11) {
            c();
        }
        this.f22646b.write(c10);
    }

    public b beginArray() throws IOException {
        f();
        a();
        int i10 = this.f22648n;
        int[] iArr = this.f22647m;
        if (i10 == iArr.length) {
            this.f22647m = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.f22647m;
        int i11 = this.f22648n;
        this.f22648n = i11 + 1;
        iArr2[i11] = 1;
        this.f22646b.write(91);
        return this;
    }

    public b beginObject() throws IOException {
        f();
        a();
        int i10 = this.f22648n;
        int[] iArr = this.f22647m;
        if (i10 == iArr.length) {
            this.f22647m = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.f22647m;
        int i11 = this.f22648n;
        this.f22648n = i11 + 1;
        iArr2[i11] = 3;
        this.f22646b.write(123);
        return this;
    }

    public final void c() throws IOException {
        if (this.f22649o == null) {
            return;
        }
        Writer writer = this.f22646b;
        writer.write(10);
        int i10 = this.f22648n;
        for (int i11 = 1; i11 < i10; i11++) {
            writer.write(this.f22649o);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22646b.close();
        int i10 = this.f22648n;
        if (i10 > 1 || (i10 == 1 && this.f22647m[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f22648n = 0;
    }

    public final int d() {
        int i10 = this.f22648n;
        if (i10 != 0) {
            return this.f22647m[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f22652r
            if (r0 == 0) goto L7
            java.lang.String[] r0 = z9.b.f22645w
            goto L9
        L7:
            java.lang.String[] r0 = z9.b.f22644v
        L9:
            java.io.Writer r1 = r8.f22646b
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = 0
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.b.e(java.lang.String):void");
    }

    public b endArray() throws IOException {
        b(1, 2, ']');
        return this;
    }

    public b endObject() throws IOException {
        b(3, 5, '}');
        return this;
    }

    public final void f() throws IOException {
        if (this.f22653s != null) {
            int iD = d();
            if (iD == 5) {
                this.f22646b.write(44);
            } else if (iD != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            c();
            this.f22647m[this.f22648n - 1] = 4;
            e(this.f22653s);
            this.f22653s = null;
        }
    }

    public void flush() throws IOException {
        if (this.f22648n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f22646b.flush();
    }

    public final boolean getSerializeNulls() {
        return this.f22654t;
    }

    public final boolean isHtmlSafe() {
        return this.f22652r;
    }

    public boolean isLenient() {
        return this.f22651q;
    }

    public b name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f22653s != null) {
            throw new IllegalStateException();
        }
        if (this.f22648n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f22653s = str;
        return this;
    }

    public b nullValue() throws IOException {
        if (this.f22653s != null) {
            if (!this.f22654t) {
                this.f22653s = null;
                return this;
            }
            f();
        }
        a();
        this.f22646b.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean z10) {
        this.f22652r = z10;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f22649o = null;
            this.f22650p = ":";
        } else {
            this.f22649o = str;
            this.f22650p = ": ";
        }
    }

    public final void setLenient(boolean z10) {
        this.f22651q = z10;
    }

    public final void setSerializeNulls(boolean z10) {
        this.f22654t = z10;
    }

    public b value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        f();
        a();
        e(str);
        return this;
    }

    public b value(boolean z10) throws IOException {
        f();
        a();
        this.f22646b.write(z10 ? "true" : "false");
        return this;
    }

    public b value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        f();
        a();
        this.f22646b.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b value(long j10) throws IOException {
        f();
        a();
        this.f22646b.write(Long.toString(j10));
        return this;
    }

    public b value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        f();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!(cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class) && !f22643u.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f22651q) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
        }
        a();
        this.f22646b.append((CharSequence) string);
        return this;
    }
}
