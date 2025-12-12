package v0;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import v0.f;

/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final f.e f20390d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f20391e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f20392f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f20393g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f20394h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20395a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20396b;

    /* renamed from: c, reason: collision with root package name */
    public final e f20397c;

    /* compiled from: BidiFormatter.java */
    /* renamed from: v0.a$a, reason: collision with other inner class name */
    public static final class C0290a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20398a;

        /* renamed from: b, reason: collision with root package name */
        public int f20399b;

        /* renamed from: c, reason: collision with root package name */
        public f.e f20400c;

        public C0290a() {
            this.f20398a = g.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
            this.f20400c = a.f20390d;
            this.f20399b = 2;
        }

        public a build() {
            return (this.f20399b == 2 && this.f20400c == a.f20390d) ? this.f20398a ? a.f20394h : a.f20393g : new a(this.f20398a, this.f20399b, this.f20400c);
        }
    }

    /* compiled from: BidiFormatter.java */
    public static class b {

        /* renamed from: e, reason: collision with root package name */
        public static final byte[] f20401e = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f20402a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20403b;

        /* renamed from: c, reason: collision with root package name */
        public int f20404c;

        /* renamed from: d, reason: collision with root package name */
        public char f20405d;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f20401e[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence) {
            this.f20402a = charSequence;
            this.f20403b = charSequence.length();
        }

        public final byte a() {
            int i10 = this.f20404c - 1;
            CharSequence charSequence = this.f20402a;
            char cCharAt = charSequence.charAt(i10);
            this.f20405d = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(charSequence, this.f20404c);
                this.f20404c -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f20404c--;
            char c10 = this.f20405d;
            return c10 < 1792 ? f20401e[c10] : Character.getDirectionality(c10);
        }
    }

    static {
        f.e eVar = f.f20417c;
        f20390d = eVar;
        f20391e = Character.toString((char) 8206);
        f20392f = Character.toString((char) 8207);
        f20393g = new a(false, 2, eVar);
        f20394h = new a(true, 2, eVar);
    }

    public a(boolean z10, int i10, f.e eVar) {
        this.f20395a = z10;
        this.f20396b = i10;
        this.f20397c = eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        if (r1 != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        if (r2 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        if (r0.f20404c <= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
    
        switch(r0.a()) {
            case 14: goto L66;
            case 15: goto L66;
            case 16: goto L65;
            case 17: goto L65;
            case 18: goto L64;
            default: goto L70;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
    
        if (r1 != r3) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0086, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0088, code lost:
    
        if (r1 != r3) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008c, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.CharSequence r9) {
        /*
            v0.a$b r0 = new v0.a$b
            r0.<init>(r9)
            r9 = 0
            r0.f20404c = r9
            r1 = 0
            r2 = 0
            r3 = 0
        Lb:
            int r4 = r0.f20404c
            int r5 = r0.f20403b
            r6 = -1
            r7 = 1
            if (r4 >= r5) goto L6e
            if (r1 != 0) goto L6e
            java.lang.CharSequence r5 = r0.f20402a
            char r4 = r5.charAt(r4)
            r0.f20405d = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L37
            int r4 = r0.f20404c
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.f20404c
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.f20404c = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L4b
        L37:
            int r4 = r0.f20404c
            int r4 = r4 + r7
            r0.f20404c = r4
            char r4 = r0.f20405d
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L47
            byte[] r5 = v0.a.b.f20401e
            r4 = r5[r4]
            goto L4b
        L47:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L4b:
            if (r4 == 0) goto L69
            if (r4 == r7) goto L66
            r5 = 2
            if (r4 == r5) goto L66
            r5 = 9
            if (r4 == r5) goto Lb
            switch(r4) {
                case 14: goto L62;
                case 15: goto L62;
                case 16: goto L5e;
                case 17: goto L5e;
                case 18: goto L5a;
                default: goto L59;
            }
        L59:
            goto L6c
        L5a:
            int r3 = r3 + (-1)
            r2 = 0
            goto Lb
        L5e:
            int r3 = r3 + 1
            r2 = 1
            goto Lb
        L62:
            int r3 = r3 + 1
            r2 = -1
            goto Lb
        L66:
            if (r3 != 0) goto L6c
            goto L86
        L69:
            if (r3 != 0) goto L6c
            goto L8a
        L6c:
            r1 = r3
            goto Lb
        L6e:
            if (r1 != 0) goto L71
            goto L8f
        L71:
            if (r2 == 0) goto L75
            r9 = r2
            goto L8f
        L75:
            int r2 = r0.f20404c
            if (r2 <= 0) goto L8f
            byte r2 = r0.a()
            switch(r2) {
                case 14: goto L88;
                case 15: goto L88;
                case 16: goto L84;
                case 17: goto L84;
                case 18: goto L81;
                default: goto L80;
            }
        L80:
            goto L75
        L81:
            int r3 = r3 + 1
            goto L75
        L84:
            if (r1 != r3) goto L8c
        L86:
            r9 = 1
            goto L8f
        L88:
            if (r1 != r3) goto L8c
        L8a:
            r9 = -1
            goto L8f
        L8c:
            int r3 = r3 + (-1)
            goto L75
        L8f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.a.a(java.lang.CharSequence):int");
    }

    public static int b(CharSequence charSequence) {
        b bVar = new b(charSequence);
        bVar.f20404c = bVar.f20403b;
        int i10 = 0;
        int i11 = 0;
        while (bVar.f20404c > 0) {
            byte bA = bVar.a();
            if (bA != 0) {
                if (bA == 1 || bA == 2) {
                    if (i10 == 0) {
                        return 1;
                    }
                    if (i11 == 0) {
                        i11 = i10;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i11 == i10) {
                                return -1;
                            }
                            i10--;
                            break;
                        case 16:
                        case 17:
                            if (i11 == i10) {
                                return 1;
                            }
                            i10--;
                            break;
                        case 18:
                            i10++;
                            break;
                        default:
                            if (i11 != 0) {
                                break;
                            } else {
                                i11 = i10;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else {
                if (i10 == 0) {
                    return -1;
                }
                if (i11 == 0) {
                    i11 = i10;
                }
            }
        }
        return 0;
    }

    public static a getInstance() {
        return new C0290a().build();
    }

    public boolean getStereoReset() {
        return (this.f20396b & 2) != 0;
    }

    public String unicodeWrap(String str, e eVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, eVar, z10).toString();
    }

    public CharSequence unicodeWrap(CharSequence charSequence, e eVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = ((f.d) eVar).isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean stereoReset = getStereoReset();
        String str = f20392f;
        String str2 = f20391e;
        boolean z11 = this.f20395a;
        if (stereoReset && z10) {
            boolean zIsRtl2 = (zIsRtl ? f.f20416b : f.f20415a).isRtl(charSequence, 0, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((z11 || !(zIsRtl2 || a(charSequence) == 1)) ? (!z11 || (zIsRtl2 && a(charSequence) != -1)) ? "" : str : str2));
        }
        if (zIsRtl != z11) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            boolean zIsRtl3 = (zIsRtl ? f.f20416b : f.f20415a).isRtl(charSequence, 0, charSequence.length());
            if (!z11 && (zIsRtl3 || b(charSequence) == 1)) {
                str = str2;
            } else if (!z11 || (zIsRtl3 && b(charSequence) != -1)) {
                str = "";
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.f20397c, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.f20397c, true);
    }
}
