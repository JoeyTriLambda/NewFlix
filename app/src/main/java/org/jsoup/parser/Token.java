package org.jsoup.parser;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public abstract class Token {

    /* renamed from: a, reason: collision with root package name */
    public TokenType f17210a;

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public static final class a extends b {
        public a(String str) {
            this.f17218b = str;
        }

        @Override // org.jsoup.parser.Token.b
        public String toString() {
            return ac.c.o(new StringBuilder("<![CDATA["), this.f17218b, "]]>");
        }
    }

    public static class b extends Token {

        /* renamed from: b, reason: collision with root package name */
        public String f17218b;

        public b() {
            this.f17210a = TokenType.Character;
        }

        @Override // org.jsoup.parser.Token
        public final Token f() {
            this.f17218b = null;
            return this;
        }

        public String toString() {
            return this.f17218b;
        }
    }

    public static final class c extends Token {

        /* renamed from: b, reason: collision with root package name */
        public final StringBuilder f17219b = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        public boolean f17220c = false;

        public c() {
            this.f17210a = TokenType.Comment;
        }

        @Override // org.jsoup.parser.Token
        public final Token f() {
            Token.g(this.f17219b);
            this.f17220c = false;
            return this;
        }

        public String toString() {
            return "<!--" + this.f17219b.toString() + "-->";
        }
    }

    public static final class d extends Token {

        /* renamed from: b, reason: collision with root package name */
        public final StringBuilder f17221b = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        public String f17222c = null;

        /* renamed from: d, reason: collision with root package name */
        public final StringBuilder f17223d = new StringBuilder();

        /* renamed from: e, reason: collision with root package name */
        public final StringBuilder f17224e = new StringBuilder();

        /* renamed from: f, reason: collision with root package name */
        public boolean f17225f = false;

        public d() {
            this.f17210a = TokenType.Doctype;
        }

        @Override // org.jsoup.parser.Token
        public final Token f() {
            Token.g(this.f17221b);
            this.f17222c = null;
            Token.g(this.f17223d);
            Token.g(this.f17224e);
            this.f17225f = false;
            return this;
        }

        public String getSystemIdentifier() {
            return this.f17224e.toString();
        }

        public boolean isForceQuirks() {
            return this.f17225f;
        }
    }

    public static final class f extends h {
        public f() {
            this.f17210a = TokenType.EndTag;
        }

        public String toString() {
            return "</" + m() + ">";
        }
    }

    public static final class g extends h {
        public g() {
            this.f17234j = new org.jsoup.nodes.b();
            this.f17210a = TokenType.StartTag;
        }

        @Override // org.jsoup.parser.Token.h, org.jsoup.parser.Token
        public final /* bridge */ /* synthetic */ Token f() {
            f();
            return this;
        }

        @Override // org.jsoup.parser.Token.h
        /* renamed from: p */
        public final h f() {
            super.f();
            this.f17234j = new org.jsoup.nodes.b();
            return this;
        }

        public String toString() {
            org.jsoup.nodes.b bVar = this.f17234j;
            if (bVar == null || bVar.size() <= 0) {
                return "<" + m() + ">";
            }
            return "<" + m() + StringUtils.SPACE + this.f17234j.toString() + ">";
        }
    }

    public static abstract class h extends Token {

        /* renamed from: b, reason: collision with root package name */
        public String f17226b;

        /* renamed from: c, reason: collision with root package name */
        public String f17227c;

        /* renamed from: d, reason: collision with root package name */
        public String f17228d;

        /* renamed from: f, reason: collision with root package name */
        public String f17230f;

        /* renamed from: j, reason: collision with root package name */
        public org.jsoup.nodes.b f17234j;

        /* renamed from: e, reason: collision with root package name */
        public final StringBuilder f17229e = new StringBuilder();

        /* renamed from: g, reason: collision with root package name */
        public boolean f17231g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f17232h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f17233i = false;

        public final void h(char c10) {
            String strValueOf = String.valueOf(c10);
            String str = this.f17228d;
            if (str != null) {
                strValueOf = str.concat(strValueOf);
            }
            this.f17228d = strValueOf;
        }

        public final void i(char c10) {
            this.f17232h = true;
            String str = this.f17230f;
            StringBuilder sb2 = this.f17229e;
            if (str != null) {
                sb2.append(str);
                this.f17230f = null;
            }
            sb2.append(c10);
        }

        public final void j(String str) {
            this.f17232h = true;
            String str2 = this.f17230f;
            StringBuilder sb2 = this.f17229e;
            if (str2 != null) {
                sb2.append(str2);
                this.f17230f = null;
            }
            if (sb2.length() == 0) {
                this.f17230f = str;
            } else {
                sb2.append(str);
            }
        }

        public final void k(int[] iArr) {
            this.f17232h = true;
            String str = this.f17230f;
            StringBuilder sb2 = this.f17229e;
            if (str != null) {
                sb2.append(str);
                this.f17230f = null;
            }
            for (int i10 : iArr) {
                sb2.appendCodePoint(i10);
            }
        }

        public final void l(String str) {
            String str2 = this.f17226b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f17226b = str;
            this.f17227c = eh.b.lowerCase(str);
        }

        public final String m() {
            String str = this.f17226b;
            dh.f.isFalse(str == null || str.length() == 0);
            return this.f17226b;
        }

        public final void n(String str) {
            this.f17226b = str;
            this.f17227c = eh.b.lowerCase(str);
        }

        public final void o() {
            if (this.f17234j == null) {
                this.f17234j = new org.jsoup.nodes.b();
            }
            String str = this.f17228d;
            StringBuilder sb2 = this.f17229e;
            if (str != null) {
                String strTrim = str.trim();
                this.f17228d = strTrim;
                if (strTrim.length() > 0) {
                    this.f17234j.put(this.f17228d, this.f17232h ? sb2.length() > 0 ? sb2.toString() : this.f17230f : this.f17231g ? "" : null);
                }
            }
            this.f17228d = null;
            this.f17231g = false;
            this.f17232h = false;
            Token.g(sb2);
            this.f17230f = null;
        }

        @Override // org.jsoup.parser.Token
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public h f() {
            this.f17226b = null;
            this.f17227c = null;
            this.f17228d = null;
            Token.g(this.f17229e);
            this.f17230f = null;
            this.f17231g = false;
            this.f17232h = false;
            this.f17233i = false;
            this.f17234j = null;
            return this;
        }
    }

    public static void g(StringBuilder sb2) {
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
    }

    public final boolean a() {
        return this.f17210a == TokenType.Comment;
    }

    public final boolean b() {
        return this.f17210a == TokenType.Doctype;
    }

    public final boolean c() {
        return this.f17210a == TokenType.EOF;
    }

    public final boolean d() {
        return this.f17210a == TokenType.EndTag;
    }

    public final boolean e() {
        return this.f17210a == TokenType.StartTag;
    }

    public abstract Token f();

    public static final class e extends Token {
        public e() {
            this.f17210a = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        public final Token f() {
            return this;
        }
    }
}
