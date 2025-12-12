package org.jsoup.parser;

import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.message.TokenParser;
import dh.f;
import java.util.Arrays;
import org.jsoup.parser.Token;

/* compiled from: Tokeniser.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: r, reason: collision with root package name */
    public static final char[] f17292r;

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f17293s;

    /* renamed from: a, reason: collision with root package name */
    public final gh.a f17294a;

    /* renamed from: b, reason: collision with root package name */
    public final ParseErrorList f17295b;

    /* renamed from: d, reason: collision with root package name */
    public Token f17297d;

    /* renamed from: i, reason: collision with root package name */
    public Token.h f17302i;

    /* renamed from: o, reason: collision with root package name */
    public String f17308o;

    /* renamed from: c, reason: collision with root package name */
    public TokeniserState f17296c = TokeniserState.f17236b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17298e = false;

    /* renamed from: f, reason: collision with root package name */
    public String f17299f = null;

    /* renamed from: g, reason: collision with root package name */
    public final StringBuilder f17300g = new StringBuilder(1024);

    /* renamed from: h, reason: collision with root package name */
    public final StringBuilder f17301h = new StringBuilder(1024);

    /* renamed from: j, reason: collision with root package name */
    public final Token.g f17303j = new Token.g();

    /* renamed from: k, reason: collision with root package name */
    public final Token.f f17304k = new Token.f();

    /* renamed from: l, reason: collision with root package name */
    public final Token.b f17305l = new Token.b();

    /* renamed from: m, reason: collision with root package name */
    public final Token.d f17306m = new Token.d();

    /* renamed from: n, reason: collision with root package name */
    public final Token.c f17307n = new Token.c();

    /* renamed from: p, reason: collision with root package name */
    public final int[] f17309p = new int[1];

    /* renamed from: q, reason: collision with root package name */
    public final int[] f17310q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', TokenParser.SP, '<', '&'};
        f17292r = cArr;
        f17293s = new int[]{8364, 129, 8218, HttpStatus.SC_PAYMENT_REQUIRED, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArr);
    }

    public b(gh.a aVar, ParseErrorList parseErrorList) {
        this.f17294a = aVar;
        this.f17295b = parseErrorList;
    }

    public final void a(TokeniserState tokeniserState) {
        this.f17294a.advance();
        this.f17296c = tokeniserState;
    }

    public final void b(String str) {
        ParseErrorList parseErrorList = this.f17295b;
        if (parseErrorList.a()) {
            parseErrorList.add(new gh.b(this.f17294a.pos(), "Invalid character reference: %s", str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0198, code lost:
    
        if (r1.i('=', '-', '_') == false) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] c(java.lang.Character r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.b.c(java.lang.Character, boolean):int[]");
    }

    public final Token.h d(boolean z10) {
        Token.h hVar;
        if (z10) {
            hVar = this.f17303j;
            hVar.f();
        } else {
            hVar = this.f17304k;
            hVar.f();
        }
        this.f17302i = hVar;
        return hVar;
    }

    public final void e() {
        Token.g(this.f17301h);
    }

    public final void f(char c10) {
        g(String.valueOf(c10));
    }

    public final void g(String str) {
        if (this.f17299f == null) {
            this.f17299f = str;
            return;
        }
        StringBuilder sb2 = this.f17300g;
        if (sb2.length() == 0) {
            sb2.append(this.f17299f);
        }
        sb2.append(str);
    }

    public final void h(Token token) {
        f.isFalse(this.f17298e, "There is an unread token pending!");
        this.f17297d = token;
        this.f17298e = true;
        Token.TokenType tokenType = token.f17210a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f17308o = ((Token.g) token).f17226b;
            return;
        }
        if (tokenType != Token.TokenType.EndTag || ((Token.f) token).f17234j == null) {
            return;
        }
        ParseErrorList parseErrorList = this.f17295b;
        if (parseErrorList.a()) {
            parseErrorList.add(new gh.b(this.f17294a.pos(), "Attributes incorrectly present on end tag"));
        }
    }

    public final void i() {
        h(this.f17307n);
    }

    public final void j() {
        h(this.f17306m);
    }

    public final void k() {
        Token.h hVar = this.f17302i;
        if (hVar.f17228d != null) {
            hVar.o();
        }
        h(this.f17302i);
    }

    public final void l(TokeniserState tokeniserState) {
        ParseErrorList parseErrorList = this.f17295b;
        if (parseErrorList.a()) {
            parseErrorList.add(new gh.b(this.f17294a.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public final void m(TokeniserState tokeniserState) {
        ParseErrorList parseErrorList = this.f17295b;
        if (parseErrorList.a()) {
            gh.a aVar = this.f17294a;
            parseErrorList.add(new gh.b(aVar.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(aVar.current()), tokeniserState));
        }
    }

    public final boolean n() {
        return this.f17308o != null && this.f17302i.m().equalsIgnoreCase(this.f17308o);
    }
}
