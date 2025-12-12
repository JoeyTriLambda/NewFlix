package z9;

import ac.c;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;
import v9.t;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public final Reader f22628b;

    /* renamed from: t, reason: collision with root package name */
    public long f22636t;

    /* renamed from: u, reason: collision with root package name */
    public int f22637u;

    /* renamed from: v, reason: collision with root package name */
    public String f22638v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f22639w;

    /* renamed from: y, reason: collision with root package name */
    public String[] f22641y;

    /* renamed from: z, reason: collision with root package name */
    public int[] f22642z;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22629m = false;

    /* renamed from: n, reason: collision with root package name */
    public final char[] f22630n = new char[1024];

    /* renamed from: o, reason: collision with root package name */
    public int f22631o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f22632p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f22633q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f22634r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f22635s = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f22640x = 0 + 1;

    /* compiled from: JsonReader.java */
    /* renamed from: z9.a$a, reason: collision with other inner class name */
    public class C0333a extends t {
        public void promoteNameToValue(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.bind.b) {
                ((com.google.gson.internal.bind.b) aVar).promoteNameToValue();
                return;
            }
            int iB = aVar.f22635s;
            if (iB == 0) {
                iB = aVar.b();
            }
            if (iB == 13) {
                aVar.f22635s = 9;
                return;
            }
            if (iB == 12) {
                aVar.f22635s = 8;
            } else {
                if (iB == 14) {
                    aVar.f22635s = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + aVar.peek() + aVar.f());
            }
        }
    }

    static {
        t.f20642a = new C0333a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f22639w = iArr;
        iArr[0] = 6;
        this.f22641y = new String[32];
        this.f22642z = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f22628b = reader;
    }

    public final void a() throws IOException {
        if (this.f22629m) {
            return;
        }
        n("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0209, code lost:
    
        if (e(r1) != false) goto L204;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x026f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.a.b():int");
    }

    public void beginArray() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 3) {
            j(1);
            this.f22642z[this.f22640x - 1] = 0;
            this.f22635s = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + f());
        }
    }

    public void beginObject() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 1) {
            j(3);
            this.f22635s = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + f());
        }
    }

    public final boolean c(int i10) throws IOException {
        int i11;
        int i12;
        int i13 = this.f22634r;
        int i14 = this.f22631o;
        this.f22634r = i13 - i14;
        int i15 = this.f22632p;
        char[] cArr = this.f22630n;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f22632p = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f22632p = 0;
        }
        this.f22631o = 0;
        do {
            int i17 = this.f22632p;
            int i18 = this.f22628b.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f22632p + i18;
            this.f22632p = i11;
            if (this.f22633q == 0 && (i12 = this.f22634r) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f22631o++;
                this.f22634r = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22635s = 0;
        this.f22639w[0] = 8;
        this.f22640x = 1;
        this.f22628b.close();
    }

    public final String d(boolean z10) {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.f22640x;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.f22639w[i10];
            if (i12 == 1 || i12 == 2) {
                int i13 = this.f22642z[i10];
                if (z10 && i13 > 0 && i10 == i11 - 1) {
                    i13--;
                }
                sb2.append('[');
                sb2.append(i13);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.f22641y[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    public final boolean e(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        a();
        return false;
    }

    public void endArray() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + f());
        }
        int i10 = this.f22640x - 1;
        this.f22640x = i10;
        int[] iArr = this.f22642z;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f22635s = 0;
    }

    public void endObject() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + f());
        }
        int i10 = this.f22640x - 1;
        this.f22640x = i10;
        this.f22641y[i10] = null;
        int[] iArr = this.f22642z;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f22635s = 0;
    }

    public final String f() {
        StringBuilder sbT = c.t(" at line ", this.f22633q + 1, " column ", (this.f22631o - this.f22634r) + 1, " path ");
        sbT.append(getPath());
        return sbT.toString();
    }

    public final int g(boolean z10) throws IOException {
        int i10 = this.f22631o;
        int i11 = this.f22632p;
        while (true) {
            boolean z11 = true;
            if (i10 == i11) {
                this.f22631o = i10;
                if (!c(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + f());
                }
                i10 = this.f22631o;
                i11 = this.f22632p;
            }
            int i12 = i10 + 1;
            char[] cArr = this.f22630n;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.f22633q++;
                this.f22634r = i12;
            } else if (c10 != ' ' && c10 != '\r' && c10 != '\t') {
                if (c10 == '/') {
                    this.f22631o = i12;
                    if (i12 == i11) {
                        this.f22631o = i12 - 1;
                        boolean zC = c(2);
                        this.f22631o++;
                        if (!zC) {
                            return c10;
                        }
                    }
                    a();
                    int i13 = this.f22631o;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f22631o = i13 + 1;
                        while (true) {
                            if (this.f22631o + 2 > this.f22632p && !c(2)) {
                                z11 = false;
                                break;
                            }
                            int i14 = this.f22631o;
                            if (cArr[i14] != '\n') {
                                for (int i15 = 0; i15 < 2; i15++) {
                                    if (cArr[this.f22631o + i15] != "*/".charAt(i15)) {
                                        break;
                                    }
                                }
                                break;
                            }
                            this.f22633q++;
                            this.f22634r = i14 + 1;
                            this.f22631o++;
                        }
                        if (!z11) {
                            n("Unterminated comment");
                            throw null;
                        }
                        i10 = this.f22631o + 2;
                        i11 = this.f22632p;
                    } else {
                        if (c11 != '/') {
                            return c10;
                        }
                        this.f22631o = i13 + 1;
                        m();
                        i10 = this.f22631o;
                        i11 = this.f22632p;
                    }
                } else {
                    if (c10 != '#') {
                        this.f22631o = i12;
                        return c10;
                    }
                    this.f22631o = i12;
                    a();
                    m();
                    i10 = this.f22631o;
                    i11 = this.f22632p;
                }
            }
            i10 = i12;
        }
    }

    public String getPath() {
        return d(false);
    }

    public String getPreviousPath() {
        return d(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        r10.f22631o = r8;
        r8 = (r8 - r2) - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r8 + 1) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r4 - r2) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r1.append(r7, r2, r4 - r2);
        r10.f22631o = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String h(char r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.f22631o
            int r3 = r10.f22632p
        L6:
            r4 = r2
        L7:
            r5 = 1
            r6 = 16
            char[] r7 = r10.f22630n
            if (r4 >= r3) goto L5c
            int r8 = r4 + 1
            char r4 = r7[r4]
            if (r4 != r11) goto L28
            r10.f22631o = r8
            int r8 = r8 - r2
            int r8 = r8 - r5
            if (r1 != 0) goto L20
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r2, r8)
            return r11
        L20:
            r1.append(r7, r2, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L28:
            r9 = 92
            if (r4 != r9) goto L4f
            r10.f22631o = r8
            int r8 = r8 - r2
            int r8 = r8 - r5
            if (r1 != 0) goto L40
            int r1 = r8 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r6)
            r3.<init>(r1)
            r1 = r3
        L40:
            r1.append(r7, r2, r8)
            char r2 = r10.k()
            r1.append(r2)
            int r2 = r10.f22631o
            int r3 = r10.f22632p
            goto L6
        L4f:
            r6 = 10
            if (r4 != r6) goto L5a
            int r4 = r10.f22633q
            int r4 = r4 + r5
            r10.f22633q = r4
            r10.f22634r = r8
        L5a:
            r4 = r8
            goto L7
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r4 - r2
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r6)
            r3.<init>(r1)
            r1 = r3
        L6c:
            int r3 = r4 - r2
            r1.append(r7, r2, r3)
            r10.f22631o = r4
            boolean r2 = r10.c(r5)
            if (r2 == 0) goto L7a
            goto L2
        L7a:
            java.lang.String r11 = "Unterminated string"
            r10.n(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.a.h(char):java.lang.String");
    }

    public boolean hasNext() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        return (iB == 2 || iB == 4 || iB == 17) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        a();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String i() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r7.f22631o
            int r4 = r3 + r2
            int r5 = r7.f22632p
            char[] r6 = r7.f22630n
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.a()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.c(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f22631o
            r0.append(r6, r3, r2)
            int r3 = r7.f22631o
            int r3 = r3 + r2
            r7.f22631o = r3
            r2 = 1
            boolean r2 = r7.c(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f22631o
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f22631o
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f22631o
            int r2 = r2 + r1
            r7.f22631o = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.a.i():java.lang.String");
    }

    public final boolean isLenient() {
        return this.f22629m;
    }

    public final void j(int i10) {
        int i11 = this.f22640x;
        int[] iArr = this.f22639w;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f22639w = Arrays.copyOf(iArr, i12);
            this.f22642z = Arrays.copyOf(this.f22642z, i12);
            this.f22641y = (String[]) Arrays.copyOf(this.f22641y, i12);
        }
        int[] iArr2 = this.f22639w;
        int i13 = this.f22640x;
        this.f22640x = i13 + 1;
        iArr2[i13] = i10;
    }

    public final char k() throws IOException {
        int i10;
        int i11;
        if (this.f22631o == this.f22632p && !c(1)) {
            n("Unterminated escape sequence");
            throw null;
        }
        int i12 = this.f22631o;
        int i13 = i12 + 1;
        this.f22631o = i13;
        char[] cArr = this.f22630n;
        char c10 = cArr[i12];
        if (c10 == '\n') {
            this.f22633q++;
            this.f22634r = i13;
        } else if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
            if (c10 == 'b') {
                return '\b';
            }
            if (c10 == 'f') {
                return '\f';
            }
            if (c10 == 'n') {
                return '\n';
            }
            if (c10 == 'r') {
                return '\r';
            }
            if (c10 == 't') {
                return '\t';
            }
            if (c10 != 'u') {
                n("Invalid escape sequence");
                throw null;
            }
            if (i13 + 4 > this.f22632p && !c(4)) {
                n("Unterminated escape sequence");
                throw null;
            }
            int i14 = this.f22631o;
            int i15 = i14 + 4;
            char c11 = 0;
            while (i14 < i15) {
                char c12 = cArr[i14];
                char c13 = (char) (c11 << 4);
                if (c12 < '0' || c12 > '9') {
                    if (c12 >= 'a' && c12 <= 'f') {
                        i10 = c12 - 'a';
                    } else {
                        if (c12 < 'A' || c12 > 'F') {
                            throw new NumberFormatException("\\u".concat(new String(cArr, this.f22631o, 4)));
                        }
                        i10 = c12 - 'A';
                    }
                    i11 = i10 + 10;
                } else {
                    i11 = c12 - '0';
                }
                c11 = (char) (i11 + c13);
                i14++;
            }
            this.f22631o += 4;
            return c11;
        }
        return c10;
    }

    public final void l(char c10) throws IOException {
        do {
            int i10 = this.f22631o;
            int i11 = this.f22632p;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = this.f22630n[i10];
                if (c11 == c10) {
                    this.f22631o = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f22631o = i12;
                    k();
                    i10 = this.f22631o;
                    i11 = this.f22632p;
                } else {
                    if (c11 == '\n') {
                        this.f22633q++;
                        this.f22634r = i12;
                    }
                    i10 = i12;
                }
            }
            this.f22631o = i10;
        } while (c(1));
        n("Unterminated string");
        throw null;
    }

    public final void m() throws IOException {
        char c10;
        do {
            if (this.f22631o >= this.f22632p && !c(1)) {
                return;
            }
            int i10 = this.f22631o;
            int i11 = i10 + 1;
            this.f22631o = i11;
            c10 = this.f22630n[i10];
            if (c10 == '\n') {
                this.f22633q++;
                this.f22634r = i11;
                return;
            }
        } while (c10 != '\r');
    }

    public final void n(String str) throws IOException {
        StringBuilder sbR = c.r(str);
        sbR.append(f());
        throw new MalformedJsonException(sbR.toString());
    }

    public boolean nextBoolean() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 5) {
            this.f22635s = 0;
            int[] iArr = this.f22642z;
            int i10 = this.f22640x - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iB != 6) {
            throw new IllegalStateException("Expected a boolean but was " + peek() + f());
        }
        this.f22635s = 0;
        int[] iArr2 = this.f22642z;
        int i11 = this.f22640x - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return false;
    }

    public double nextDouble() throws IOException, NumberFormatException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 15) {
            this.f22635s = 0;
            int[] iArr = this.f22642z;
            int i10 = this.f22640x - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f22636t;
        }
        if (iB == 16) {
            this.f22638v = new String(this.f22630n, this.f22631o, this.f22637u);
            this.f22631o += this.f22637u;
        } else if (iB == 8 || iB == 9) {
            this.f22638v = h(iB == 8 ? '\'' : '\"');
        } else if (iB == 10) {
            this.f22638v = i();
        } else if (iB != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + f());
        }
        this.f22635s = 11;
        double d10 = Double.parseDouble(this.f22638v);
        if (!this.f22629m && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d10 + f());
        }
        this.f22638v = null;
        this.f22635s = 0;
        int[] iArr2 = this.f22642z;
        int i11 = this.f22640x - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d10;
    }

    public int nextInt() throws IOException, NumberFormatException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 15) {
            long j10 = this.f22636t;
            int i10 = (int) j10;
            if (j10 != i10) {
                throw new NumberFormatException("Expected an int but was " + this.f22636t + f());
            }
            this.f22635s = 0;
            int[] iArr = this.f22642z;
            int i11 = this.f22640x - 1;
            iArr[i11] = iArr[i11] + 1;
            return i10;
        }
        if (iB == 16) {
            this.f22638v = new String(this.f22630n, this.f22631o, this.f22637u);
            this.f22631o += this.f22637u;
        } else {
            if (iB != 8 && iB != 9 && iB != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + f());
            }
            if (iB == 10) {
                this.f22638v = i();
            } else {
                this.f22638v = h(iB == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.f22638v);
                this.f22635s = 0;
                int[] iArr2 = this.f22642z;
                int i13 = this.f22640x - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f22635s = 11;
        double d10 = Double.parseDouble(this.f22638v);
        int i14 = (int) d10;
        if (i14 != d10) {
            throw new NumberFormatException("Expected an int but was " + this.f22638v + f());
        }
        this.f22638v = null;
        this.f22635s = 0;
        int[] iArr3 = this.f22642z;
        int i15 = this.f22640x - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public long nextLong() throws IOException, NumberFormatException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 15) {
            this.f22635s = 0;
            int[] iArr = this.f22642z;
            int i10 = this.f22640x - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f22636t;
        }
        if (iB == 16) {
            this.f22638v = new String(this.f22630n, this.f22631o, this.f22637u);
            this.f22631o += this.f22637u;
        } else {
            if (iB != 8 && iB != 9 && iB != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + f());
            }
            if (iB == 10) {
                this.f22638v = i();
            } else {
                this.f22638v = h(iB == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f22638v);
                this.f22635s = 0;
                int[] iArr2 = this.f22642z;
                int i11 = this.f22640x - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f22635s = 11;
        double d10 = Double.parseDouble(this.f22638v);
        long j11 = (long) d10;
        if (j11 != d10) {
            throw new NumberFormatException("Expected a long but was " + this.f22638v + f());
        }
        this.f22638v = null;
        this.f22635s = 0;
        int[] iArr3 = this.f22642z;
        int i12 = this.f22640x - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public String nextName() throws IOException {
        String strH;
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 14) {
            strH = i();
        } else if (iB == 12) {
            strH = h('\'');
        } else {
            if (iB != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + f());
            }
            strH = h('\"');
        }
        this.f22635s = 0;
        this.f22641y[this.f22640x - 1] = strH;
        return strH;
    }

    public void nextNull() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB != 7) {
            throw new IllegalStateException("Expected null but was " + peek() + f());
        }
        this.f22635s = 0;
        int[] iArr = this.f22642z;
        int i10 = this.f22640x - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    public String nextString() throws IOException {
        String str;
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        if (iB == 10) {
            str = i();
        } else if (iB == 8) {
            str = h('\'');
        } else if (iB == 9) {
            str = h('\"');
        } else if (iB == 11) {
            str = this.f22638v;
            this.f22638v = null;
        } else if (iB == 15) {
            str = Long.toString(this.f22636t);
        } else {
            if (iB != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + f());
            }
            str = new String(this.f22630n, this.f22631o, this.f22637u);
            this.f22631o += this.f22637u;
        }
        this.f22635s = 0;
        int[] iArr = this.f22642z;
        int i10 = this.f22640x - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int iB = this.f22635s;
        if (iB == 0) {
            iB = b();
        }
        switch (iB) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z10) {
        this.f22629m = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a1, code lost:
    
        a();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009b. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void skipValue() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.a.skipValue():void");
    }

    public String toString() {
        return getClass().getSimpleName() + f();
    }
}
