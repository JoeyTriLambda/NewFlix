package com.airbnb.lottie.parser.moshi;

import ah.c;
import ah.e;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import java.io.EOFException;
import java.io.IOException;
import okio.ByteString;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
public final class a extends JsonReader {

    /* renamed from: w, reason: collision with root package name */
    public static final ByteString f5547w = ByteString.encodeUtf8("'\\");

    /* renamed from: x, reason: collision with root package name */
    public static final ByteString f5548x = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);

    /* renamed from: y, reason: collision with root package name */
    public static final ByteString f5549y = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q, reason: collision with root package name */
    public final e f5550q;

    /* renamed from: r, reason: collision with root package name */
    public final c f5551r;

    /* renamed from: s, reason: collision with root package name */
    public int f5552s = 0;

    /* renamed from: t, reason: collision with root package name */
    public long f5553t;

    /* renamed from: u, reason: collision with root package name */
    public int f5554u;

    /* renamed from: v, reason: collision with root package name */
    public String f5555v;

    static {
        ByteString.encodeUtf8("\n\r");
        ByteString.encodeUtf8("*/");
    }

    public a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f5550q = eVar;
        this.f5551r = eVar.getBuffer();
        a(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 3) {
            a(1);
            this.f5533o[this.f5530b - 1] = 0;
            this.f5552s = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 1) {
            a(3);
            this.f5552s = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
        }
    }

    public final void c() throws IOException {
        b("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5552s = 0;
        this.f5531m[0] = 8;
        this.f5530b = 1;
        this.f5551r.clear();
        this.f5550q.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x018e, code lost:
    
        if (f(r14) != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0190, code lost:
    
        if (r6 != 2) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0192, code lost:
    
        if (r7 == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0198, code lost:
    
        if (r9 != Long.MIN_VALUE) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x019a, code lost:
    
        if (r11 == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x019e, code lost:
    
        if (r9 != 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01a0, code lost:
    
        if (r11 != false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01a2, code lost:
    
        if (r11 == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01a5, code lost:
    
        r9 = -r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01a6, code lost:
    
        r18.f5553t = r9;
        r5.skip(r3);
        r13 = 16;
        r18.f5552s = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01b1, code lost:
    
        if (r6 == 2) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01b4, code lost:
    
        if (r6 == 4) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01b7, code lost:
    
        if (r6 != 7) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01b9, code lost:
    
        r18.f5554u = r3;
        r13 = 17;
        r18.f5552s = 17;
     */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0112 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int d() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.a.d():int");
    }

    public final int e(String str, JsonReader.a aVar) {
        int length = aVar.f5545a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f5545a[i10])) {
                this.f5552s = 0;
                this.f5532n[this.f5530b - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endArray() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
        }
        int i10 = this.f5530b - 1;
        this.f5530b = i10;
        int[] iArr = this.f5533o;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f5552s = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endObject() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
        }
        int i10 = this.f5530b - 1;
        this.f5530b = i10;
        this.f5532n[i10] = null;
        int[] iArr = this.f5533o;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f5552s = 0;
    }

    public final boolean f(int i10) throws IOException {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (i10 != 47 && i10 != 61) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        throw null;
    }

    public final int g(boolean z10) throws IOException {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            e eVar = this.f5550q;
            if (!eVar.request(i11)) {
                if (z10) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            long j10 = i10;
            c cVar = this.f5551r;
            byte b10 = cVar.getByte(j10);
            if (b10 != 10 && b10 != 32 && b10 != 13 && b10 != 9) {
                cVar.skip(i11 - 1);
                if (b10 == 47) {
                    if (!eVar.request(2L)) {
                        return b10;
                    }
                    c();
                    throw null;
                }
                if (b10 != 35) {
                    return b10;
                }
                c();
                throw null;
            }
            i10 = i11;
        }
    }

    public final String h(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long jIndexOfElement = this.f5550q.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                b("Unterminated string");
                throw null;
            }
            c cVar = this.f5551r;
            if (cVar.getByte(jIndexOfElement) != 92) {
                if (sb2 == null) {
                    String utf8 = cVar.readUtf8(jIndexOfElement);
                    cVar.readByte();
                    return utf8;
                }
                sb2.append(cVar.readUtf8(jIndexOfElement));
                cVar.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(cVar.readUtf8(jIndexOfElement));
            cVar.readByte();
            sb2.append(j());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        return (iD == 2 || iD == 4 || iD == 18) ? false : true;
    }

    public final String i() throws IOException {
        long jIndexOfElement = this.f5550q.indexOfElement(f5549y);
        c cVar = this.f5551r;
        return jIndexOfElement != -1 ? cVar.readUtf8(jIndexOfElement) : cVar.readUtf8();
    }

    public final char j() throws IOException {
        int i10;
        int i11;
        e eVar = this.f5550q;
        if (!eVar.request(1L)) {
            b("Unterminated escape sequence");
            throw null;
        }
        c cVar = this.f5551r;
        byte b10 = cVar.readByte();
        if (b10 == 10 || b10 == 34 || b10 == 39 || b10 == 47 || b10 == 92) {
            return (char) b10;
        }
        if (b10 == 98) {
            return '\b';
        }
        if (b10 == 102) {
            return '\f';
        }
        if (b10 == 110) {
            return '\n';
        }
        if (b10 == 114) {
            return '\r';
        }
        if (b10 == 116) {
            return '\t';
        }
        if (b10 != 117) {
            b("Invalid escape sequence: \\" + ((char) b10));
            throw null;
        }
        if (!eVar.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c10 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            byte b11 = cVar.getByte(i12);
            char c11 = (char) (c10 << 4);
            if (b11 < 48 || b11 > 57) {
                if (b11 >= 97 && b11 <= 102) {
                    i10 = b11 - 97;
                } else {
                    if (b11 < 65 || b11 > 70) {
                        b("\\u" + cVar.readUtf8(4L));
                        throw null;
                    }
                    i10 = b11 + ByteSourceJsonBootstrapper.UTF8_BOM_3;
                }
                i11 = i10 + 10;
            } else {
                i11 = b11 - 48;
            }
            c10 = (char) (i11 + c11);
        }
        cVar.skip(4L);
        return c10;
    }

    public final void k(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.f5550q.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                b("Unterminated string");
                throw null;
            }
            c cVar = this.f5551r;
            if (cVar.getByte(jIndexOfElement) != 92) {
                cVar.skip(jIndexOfElement + 1);
                return;
            } else {
                cVar.skip(jIndexOfElement + 1);
                j();
            }
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 5) {
            this.f5552s = 0;
            int[] iArr = this.f5533o;
            int i10 = this.f5530b - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iD == 6) {
            this.f5552s = 0;
            int[] iArr2 = this.f5533o;
            int i11 = this.f5530b - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() throws IOException, NumberFormatException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 16) {
            this.f5552s = 0;
            int[] iArr = this.f5533o;
            int i10 = this.f5530b - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f5553t;
        }
        if (iD == 17) {
            this.f5555v = this.f5551r.readUtf8(this.f5554u);
        } else if (iD == 9) {
            this.f5555v = h(f5548x);
        } else if (iD == 8) {
            this.f5555v = h(f5547w);
        } else if (iD == 10) {
            this.f5555v = i();
        } else if (iD != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.f5552s = 11;
        try {
            double d10 = Double.parseDouble(this.f5555v);
            if (Double.isNaN(d10) || Double.isInfinite(d10)) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + d10 + " at path " + getPath());
            }
            this.f5555v = null;
            this.f5552s = 0;
            int[] iArr2 = this.f5533o;
            int i11 = this.f5530b - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return d10;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f5555v + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() throws IOException, NumberFormatException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 16) {
            long j10 = this.f5553t;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.f5552s = 0;
                int[] iArr = this.f5533o;
                int i11 = this.f5530b - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new JsonDataException("Expected an int but was " + this.f5553t + " at path " + getPath());
        }
        if (iD == 17) {
            this.f5555v = this.f5551r.readUtf8(this.f5554u);
        } else if (iD == 9 || iD == 8) {
            String strH = iD == 9 ? h(f5548x) : h(f5547w);
            this.f5555v = strH;
            try {
                int i12 = Integer.parseInt(strH);
                this.f5552s = 0;
                int[] iArr2 = this.f5533o;
                int i13 = this.f5530b - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        } else if (iD != 11) {
            throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.f5552s = 11;
        try {
            double d10 = Double.parseDouble(this.f5555v);
            int i14 = (int) d10;
            if (i14 != d10) {
                throw new JsonDataException("Expected an int but was " + this.f5555v + " at path " + getPath());
            }
            this.f5555v = null;
            this.f5552s = 0;
            int[] iArr3 = this.f5533o;
            int i15 = this.f5530b - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f5555v + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextName() throws IOException {
        String strH;
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 14) {
            strH = i();
        } else if (iD == 13) {
            strH = h(f5548x);
        } else if (iD == 12) {
            strH = h(f5547w);
        } else {
            if (iD != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            strH = this.f5555v;
        }
        this.f5552s = 0;
        this.f5532n[this.f5530b - 1] = strH;
        return strH;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextString() throws IOException {
        String utf8;
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 10) {
            utf8 = i();
        } else if (iD == 9) {
            utf8 = h(f5548x);
        } else if (iD == 8) {
            utf8 = h(f5547w);
        } else if (iD == 11) {
            utf8 = this.f5555v;
            this.f5555v = null;
        } else if (iD == 16) {
            utf8 = Long.toString(this.f5553t);
        } else {
            if (iD != 17) {
                throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
            }
            utf8 = this.f5551r.readUtf8(this.f5554u);
        }
        this.f5552s = 0;
        int[] iArr = this.f5533o;
        int i10 = this.f5530b - 1;
        iArr[i10] = iArr[i10] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        switch (iD) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(JsonReader.a aVar) throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD < 12 || iD > 15) {
            return -1;
        }
        if (iD == 15) {
            return e(this.f5555v, aVar);
        }
        int iSelect = this.f5550q.select(aVar.f5546b);
        if (iSelect != -1) {
            this.f5552s = 0;
            this.f5532n[this.f5530b - 1] = aVar.f5545a[iSelect];
            return iSelect;
        }
        String str = this.f5532n[this.f5530b - 1];
        String strNextName = nextName();
        int iE = e(strNextName, aVar);
        if (iE == -1) {
            this.f5552s = 15;
            this.f5555v = strNextName;
            this.f5532n[this.f5530b - 1] = str;
        }
        return iE;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() throws IOException {
        int iD = this.f5552s;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 14) {
            long jIndexOfElement = this.f5550q.indexOfElement(f5549y);
            c cVar = this.f5551r;
            if (jIndexOfElement == -1) {
                jIndexOfElement = cVar.size();
            }
            cVar.skip(jIndexOfElement);
        } else if (iD == 13) {
            k(f5548x);
        } else if (iD == 12) {
            k(f5547w);
        } else if (iD != 15) {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.f5552s = 0;
        this.f5532n[this.f5530b - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() throws IOException {
        int i10 = 0;
        do {
            int iD = this.f5552s;
            if (iD == 0) {
                iD = d();
            }
            if (iD == 3) {
                a(1);
            } else if (iD == 1) {
                a(3);
            } else {
                if (iD == 4) {
                    i10--;
                    if (i10 < 0) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.f5530b--;
                } else if (iD == 2) {
                    i10--;
                    if (i10 < 0) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.f5530b--;
                } else {
                    c cVar = this.f5551r;
                    if (iD == 14 || iD == 10) {
                        long jIndexOfElement = this.f5550q.indexOfElement(f5549y);
                        if (jIndexOfElement == -1) {
                            jIndexOfElement = cVar.size();
                        }
                        cVar.skip(jIndexOfElement);
                    } else if (iD == 9 || iD == 13) {
                        k(f5548x);
                    } else if (iD == 8 || iD == 12) {
                        k(f5547w);
                    } else if (iD == 17) {
                        cVar.skip(this.f5554u);
                    } else if (iD == 18) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                }
                this.f5552s = 0;
            }
            i10++;
            this.f5552s = 0;
        } while (i10 != 0);
        int[] iArr = this.f5533o;
        int i11 = this.f5530b;
        int i12 = i11 - 1;
        iArr[i12] = iArr[i12] + 1;
        this.f5532n[i11 - 1] = "null";
    }

    public String toString() {
        return "JsonReader(" + this.f5550q + ")";
    }
}
