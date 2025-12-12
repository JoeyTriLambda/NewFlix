package gh;

/* compiled from: TokenQueue.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f12866a;

    /* renamed from: b, reason: collision with root package name */
    public int f12867b = 0;

    public f(String str) {
        dh.f.notNull(str);
        this.f12866a = str;
    }

    public static String unescape(String str) {
        StringBuilder sbStringBuilder = dh.e.stringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i10 = 0;
        char c10 = 0;
        while (i10 < length) {
            char c11 = charArray[i10];
            if (c11 != '\\') {
                sbStringBuilder.append(c11);
            } else if (c10 != 0 && c10 == '\\') {
                sbStringBuilder.append(c11);
            }
            i10++;
            c10 = c11;
        }
        return sbStringBuilder.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0078 A[EDGE_INSN: B:45:0x0078->B:38:0x0078 BREAK  A[LOOP:0: B:3:0x0007->B:49:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[LOOP:0: B:3:0x0007->B:49:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String chompBalanced(char r10, char r11) {
        /*
            r9 = this;
            r0 = -1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L7:
            boolean r7 = r9.isEmpty()
            if (r7 == 0) goto Lf
            goto L78
        Lf:
            char r7 = r9.consume()
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            if (r1 == 0) goto L1d
            r8 = 92
            if (r1 == r8) goto L6c
        L1d:
            r8 = 39
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L34
            char r8 = r7.charValue()
            if (r8 == r10) goto L34
            if (r2 != 0) goto L34
            r3 = r3 ^ 1
            goto L4a
        L34:
            r8 = 34
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L4a
            char r8 = r7.charValue()
            if (r8 == r10) goto L4a
            if (r3 != 0) goto L4a
            r2 = r2 ^ 1
        L4a:
            if (r3 != 0) goto L76
            if (r2 == 0) goto L4f
            goto L76
        L4f:
            java.lang.Character r8 = java.lang.Character.valueOf(r10)
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L60
            int r4 = r4 + 1
            if (r5 != r0) goto L6c
            int r5 = r9.f12867b
            goto L6c
        L60:
            java.lang.Character r8 = java.lang.Character.valueOf(r11)
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L6c
            int r4 = r4 + (-1)
        L6c:
            if (r4 <= 0) goto L72
            if (r1 == 0) goto L72
            int r6 = r9.f12867b
        L72:
            char r1 = r7.charValue()
        L76:
            if (r4 > 0) goto L7
        L78:
            if (r6 < 0) goto L81
            java.lang.String r10 = r9.f12866a
            java.lang.String r10 = r10.substring(r5, r6)
            goto L83
        L81:
            java.lang.String r10 = ""
        L83:
            if (r4 <= 0) goto L9b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Did not find balanced marker at '"
            r11.<init>(r0)
            r11.append(r10)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            dh.f.fail(r11)
        L9b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: gh.f.chompBalanced(char, char):java.lang.String");
    }

    public String chompTo(String str) {
        String strConsumeTo = consumeTo(str);
        matchChomp(str);
        return strConsumeTo;
    }

    public char consume() {
        int i10 = this.f12867b;
        this.f12867b = i10 + 1;
        return this.f12866a.charAt(i10);
    }

    public String consumeCssIdentifier() {
        int i10 = this.f12867b;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_'))) {
            this.f12867b++;
        }
        return this.f12866a.substring(i10, this.f12867b);
    }

    public String consumeElementSelector() {
        int i10 = this.f12867b;
        while (!isEmpty() && (matchesWord() || matchesAny("*|", "|", "_", "-"))) {
            this.f12867b++;
        }
        return this.f12866a.substring(i10, this.f12867b);
    }

    public String consumeTo(String str) {
        int i10 = this.f12867b;
        String str2 = this.f12866a;
        int iIndexOf = str2.indexOf(str, i10);
        if (iIndexOf == -1) {
            return remainder();
        }
        String strSubstring = str2.substring(this.f12867b, iIndexOf);
        this.f12867b = strSubstring.length() + this.f12867b;
        return strSubstring;
    }

    public String consumeToAny(String... strArr) {
        int i10 = this.f12867b;
        while (!isEmpty() && !matchesAny(strArr)) {
            this.f12867b++;
        }
        return this.f12866a.substring(i10, this.f12867b);
    }

    public boolean consumeWhitespace() {
        boolean z10 = false;
        while (matchesWhitespace()) {
            this.f12867b++;
            z10 = true;
        }
        return z10;
    }

    public boolean isEmpty() {
        return this.f12866a.length() - this.f12867b == 0;
    }

    public boolean matchChomp(String str) {
        if (!matches(str)) {
            return false;
        }
        this.f12867b = str.length() + this.f12867b;
        return true;
    }

    public boolean matches(String str) {
        return this.f12866a.regionMatches(true, this.f12867b, str, 0, str.length());
    }

    public boolean matchesAny(String... strArr) {
        for (String str : strArr) {
            if (matches(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesWhitespace() {
        return !isEmpty() && dh.e.isWhitespace(this.f12866a.charAt(this.f12867b));
    }

    public boolean matchesWord() {
        return !isEmpty() && Character.isLetterOrDigit(this.f12866a.charAt(this.f12867b));
    }

    public String remainder() {
        int i10 = this.f12867b;
        String str = this.f12866a;
        String strSubstring = str.substring(i10, str.length());
        this.f12867b = str.length();
        return strSubstring;
    }

    public String toString() {
        return this.f12866a.substring(this.f12867b);
    }

    public void consume(String str) {
        if (!matches(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        int length2 = this.f12866a.length();
        int i10 = this.f12867b;
        if (length > length2 - i10) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.f12867b = i10 + length;
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        for (char c10 : cArr) {
            if (this.f12866a.charAt(this.f12867b) == c10) {
                return true;
            }
        }
        return false;
    }
}
