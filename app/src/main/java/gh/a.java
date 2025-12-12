package gh;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import org.jsoup.UncheckedIOException;

/* compiled from: CharacterReader.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final char[] f12833a;

    /* renamed from: b, reason: collision with root package name */
    public final Reader f12834b;

    /* renamed from: c, reason: collision with root package name */
    public int f12835c;

    /* renamed from: d, reason: collision with root package name */
    public int f12836d;

    /* renamed from: e, reason: collision with root package name */
    public int f12837e;

    /* renamed from: f, reason: collision with root package name */
    public int f12838f;

    /* renamed from: g, reason: collision with root package name */
    public int f12839g;

    /* renamed from: h, reason: collision with root package name */
    public final String[] f12840h;

    public a(Reader reader, int i10) throws IOException {
        this.f12840h = new String[512];
        dh.f.notNull(reader);
        dh.f.isTrue(reader.markSupported());
        this.f12834b = reader;
        this.f12833a = new char[i10 > 32768 ? 32768 : i10];
        a();
    }

    public static String b(char[] cArr, String[] strArr, int i10, int i11) {
        if (i11 > 12) {
            return new String(cArr, i10, i11);
        }
        boolean z10 = true;
        if (i11 < 1) {
            return "";
        }
        int i12 = i10;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            i14 = (i14 * 31) + cArr[i12];
            i13++;
            i12++;
        }
        int length = (strArr.length - 1) & i14;
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i10, i11);
            strArr[length] = str2;
            return str2;
        }
        if (i11 == str.length()) {
            int i15 = i10;
            int i16 = i11;
            int i17 = 0;
            while (true) {
                int i18 = i16 - 1;
                if (i16 == 0) {
                    break;
                }
                int i19 = i15 + 1;
                int i20 = i17 + 1;
                if (cArr[i15] != str.charAt(i17)) {
                    break;
                }
                i15 = i19;
                i16 = i18;
                i17 = i20;
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (z10) {
            return str;
        }
        String str3 = new String(cArr, i10, i11);
        strArr[length] = str3;
        return str3;
    }

    public final void a() throws IOException {
        Reader reader = this.f12834b;
        int i10 = this.f12837e;
        if (i10 < this.f12836d) {
            return;
        }
        try {
            reader.skip(i10);
            reader.mark(32768);
            int i11 = reader.read(this.f12833a);
            reader.reset();
            if (i11 != -1) {
                this.f12835c = i11;
                this.f12838f += this.f12837e;
                this.f12837e = 0;
                this.f12839g = 0;
                if (i11 > 24576) {
                    i11 = 24576;
                }
                this.f12836d = i11;
            }
        } catch (IOException e10) {
            throw new UncheckedIOException(e10);
        }
    }

    public void advance() {
        this.f12837e++;
    }

    public final char c() throws IOException {
        a();
        int i10 = this.f12837e;
        char c10 = i10 >= this.f12835c ? (char) 65535 : this.f12833a[i10];
        this.f12837e = i10 + 1;
        return c10;
    }

    public String consumeTo(char c10) throws IOException {
        char[] cArr;
        int i10;
        a();
        int i11 = this.f12837e;
        while (true) {
            int i12 = this.f12835c;
            cArr = this.f12833a;
            if (i11 >= i12) {
                i10 = -1;
                break;
            }
            if (c10 == cArr[i11]) {
                i10 = i11 - this.f12837e;
                break;
            }
            i11++;
        }
        String[] strArr = this.f12840h;
        if (i10 != -1) {
            String strB = b(cArr, strArr, this.f12837e, i10);
            this.f12837e += i10;
            return strB;
        }
        a();
        int i13 = this.f12837e;
        String strB2 = b(cArr, strArr, i13, this.f12835c - i13);
        this.f12837e = this.f12835c;
        return strB2;
    }

    public String consumeToAny(char... cArr) throws IOException {
        char[] cArr2;
        a();
        int i10 = this.f12837e;
        int i11 = this.f12835c;
        loop0: while (true) {
            int i12 = this.f12837e;
            cArr2 = this.f12833a;
            if (i12 >= i11) {
                break;
            }
            for (char c10 : cArr) {
                if (cArr2[this.f12837e] == c10) {
                    break loop0;
                }
            }
            this.f12837e++;
        }
        int i13 = this.f12837e;
        return i13 > i10 ? b(cArr2, this.f12840h, i10, i13 - i10) : "";
    }

    public char current() throws IOException {
        a();
        int i10 = this.f12837e;
        if (i10 >= this.f12835c) {
            return (char) 65535;
        }
        return this.f12833a[i10];
    }

    public final String d() throws IOException {
        char[] cArr;
        char c10;
        a();
        int i10 = this.f12837e;
        while (true) {
            int i11 = this.f12837e;
            int i12 = this.f12835c;
            cArr = this.f12833a;
            if (i11 >= i12 || (((c10 = cArr[i11]) < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !Character.isLetter(c10)))) {
                break;
            }
            this.f12837e++;
        }
        return b(cArr, this.f12840h, i10, this.f12837e - i10);
    }

    public final String e(char... cArr) throws IOException {
        char[] cArr2;
        a();
        int i10 = this.f12837e;
        int i11 = this.f12835c;
        while (true) {
            int i12 = this.f12837e;
            cArr2 = this.f12833a;
            if (i12 >= i11 || Arrays.binarySearch(cArr, cArr2[i12]) >= 0) {
                break;
            }
            this.f12837e++;
        }
        int i13 = this.f12837e;
        return i13 > i10 ? b(cArr2, this.f12840h, i10, i13 - i10) : "";
    }

    public final boolean f(String str) throws IOException {
        boolean z10;
        a();
        a();
        int length = str.length();
        if (length > this.f12835c - this.f12837e) {
            z10 = false;
            break;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) != this.f12833a[this.f12837e + i10]) {
                z10 = false;
                break;
            }
        }
        z10 = true;
        if (!z10) {
            return false;
        }
        this.f12837e = str.length() + this.f12837e;
        return true;
    }

    public final boolean g(String str) throws IOException {
        boolean z10;
        a();
        int length = str.length();
        if (length > this.f12835c - this.f12837e) {
            z10 = false;
            break;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (Character.toUpperCase(str.charAt(i10)) != Character.toUpperCase(this.f12833a[this.f12837e + i10])) {
                z10 = false;
                break;
            }
        }
        z10 = true;
        if (!z10) {
            return false;
        }
        this.f12837e = str.length() + this.f12837e;
        return true;
    }

    public final boolean h(char c10) {
        return !isEmpty() && this.f12833a[this.f12837e] == c10;
    }

    public final boolean i(char... cArr) throws IOException {
        if (isEmpty()) {
            return false;
        }
        a();
        char c10 = this.f12833a[this.f12837e];
        for (char c11 : cArr) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() throws IOException {
        a();
        return this.f12837e >= this.f12835c;
    }

    public final boolean j() {
        if (isEmpty()) {
            return false;
        }
        char c10 = this.f12833a[this.f12837e];
        return (c10 >= 'A' && c10 <= 'Z') || (c10 >= 'a' && c10 <= 'z') || Character.isLetter(c10);
    }

    public final int k(String str) throws IOException {
        a();
        char cCharAt = str.charAt(0);
        int i10 = this.f12837e;
        while (i10 < this.f12835c) {
            char[] cArr = this.f12833a;
            if (cCharAt != cArr[i10]) {
                do {
                    i10++;
                    if (i10 >= this.f12835c) {
                        break;
                    }
                } while (cCharAt != cArr[i10]);
            }
            int i11 = i10 + 1;
            int length = (str.length() + i11) - 1;
            int i12 = this.f12835c;
            if (i10 < i12 && length <= i12) {
                int i13 = i11;
                for (int i14 = 1; i13 < length && str.charAt(i14) == cArr[i13]; i14++) {
                    i13++;
                }
                if (i13 == length) {
                    return i10 - this.f12837e;
                }
            }
            i10 = i11;
        }
        return -1;
    }

    public final void l() {
        this.f12837e--;
    }

    public int pos() {
        return this.f12838f + this.f12837e;
    }

    public String toString() {
        int i10 = this.f12837e;
        return new String(this.f12833a, i10, this.f12835c - i10);
    }

    public a(Reader reader) {
        this(reader, 32768);
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }
}
