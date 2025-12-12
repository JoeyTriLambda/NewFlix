package org.jsoup.parser;

import com.fasterxml.jackson.core.JsonPointer;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.util.Locale;
import org.jsoup.parser.Token;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
abstract class TokeniserState {
    public static final AnonymousClass16 A;
    public static final char[] A0;
    public static final AnonymousClass17 B;
    public static final char[] B0;
    public static final AnonymousClass18 C;
    public static final char[] C0;
    public static final AnonymousClass19 D;
    public static final char[] D0;
    public static final AnonymousClass20 E;
    public static final String E0;
    public static final AnonymousClass21 F;
    public static final /* synthetic */ TokeniserState[] F0;
    public static final AnonymousClass22 G;
    public static final AnonymousClass23 H;
    public static final AnonymousClass24 I;
    public static final AnonymousClass25 J;
    public static final AnonymousClass26 K;
    public static final AnonymousClass27 L;
    public static final AnonymousClass28 M;
    public static final AnonymousClass29 N;
    public static final AnonymousClass30 O;
    public static final AnonymousClass31 P;
    public static final AnonymousClass32 Q;
    public static final AnonymousClass33 R;
    public static final AnonymousClass34 S;
    public static final AnonymousClass35 T;
    public static final AnonymousClass36 U;
    public static final AnonymousClass37 V;
    public static final AnonymousClass38 W;
    public static final AnonymousClass39 X;
    public static final AnonymousClass40 Y;
    public static final AnonymousClass41 Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final AnonymousClass42 f17235a0;

    /* renamed from: b, reason: collision with root package name */
    public static final AnonymousClass1 f17236b;

    /* renamed from: b0, reason: collision with root package name */
    public static final AnonymousClass43 f17237b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final AnonymousClass44 f17238c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final AnonymousClass45 f17239d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final AnonymousClass46 f17240e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final AnonymousClass47 f17241f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final AnonymousClass48 f17242g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final AnonymousClass49 f17243h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final AnonymousClass50 f17244i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final AnonymousClass51 f17245j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final AnonymousClass52 f17246k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final AnonymousClass53 f17247l0;

    /* renamed from: m, reason: collision with root package name */
    public static final AnonymousClass2 f17248m;

    /* renamed from: m0, reason: collision with root package name */
    public static final AnonymousClass54 f17249m0;

    /* renamed from: n, reason: collision with root package name */
    public static final AnonymousClass3 f17250n;

    /* renamed from: n0, reason: collision with root package name */
    public static final AnonymousClass55 f17251n0;

    /* renamed from: o, reason: collision with root package name */
    public static final AnonymousClass4 f17252o;

    /* renamed from: o0, reason: collision with root package name */
    public static final AnonymousClass56 f17253o0;

    /* renamed from: p, reason: collision with root package name */
    public static final AnonymousClass5 f17254p;

    /* renamed from: p0, reason: collision with root package name */
    public static final AnonymousClass57 f17255p0;

    /* renamed from: q, reason: collision with root package name */
    public static final AnonymousClass6 f17256q;

    /* renamed from: q0, reason: collision with root package name */
    public static final AnonymousClass58 f17257q0;

    /* renamed from: r, reason: collision with root package name */
    public static final AnonymousClass7 f17258r;

    /* renamed from: r0, reason: collision with root package name */
    public static final AnonymousClass59 f17259r0;

    /* renamed from: s, reason: collision with root package name */
    public static final AnonymousClass8 f17260s;

    /* renamed from: s0, reason: collision with root package name */
    public static final AnonymousClass60 f17261s0;

    /* renamed from: t, reason: collision with root package name */
    public static final AnonymousClass9 f17262t;

    /* renamed from: t0, reason: collision with root package name */
    public static final AnonymousClass61 f17263t0;

    /* renamed from: u, reason: collision with root package name */
    public static final AnonymousClass10 f17264u;

    /* renamed from: u0, reason: collision with root package name */
    public static final AnonymousClass62 f17265u0;

    /* renamed from: v, reason: collision with root package name */
    public static final AnonymousClass11 f17266v;

    /* renamed from: v0, reason: collision with root package name */
    public static final AnonymousClass63 f17267v0;

    /* renamed from: w, reason: collision with root package name */
    public static final AnonymousClass12 f17268w;

    /* renamed from: w0, reason: collision with root package name */
    public static final AnonymousClass64 f17269w0;

    /* renamed from: x, reason: collision with root package name */
    public static final AnonymousClass13 f17270x;

    /* renamed from: x0, reason: collision with root package name */
    public static final AnonymousClass65 f17271x0;

    /* renamed from: y, reason: collision with root package name */
    public static final AnonymousClass14 f17272y;

    /* renamed from: y0, reason: collision with root package name */
    public static final AnonymousClass66 f17273y0;

    /* renamed from: z, reason: collision with root package name */
    public static final AnonymousClass15 f17274z;

    /* renamed from: z0, reason: collision with root package name */
    public static final AnonymousClass67 f17275z0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [org.jsoup.parser.TokeniserState$1] */
    /* JADX WARN: Type inference failed for: r10v0, types: [org.jsoup.parser.TokeniserState$11] */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.jsoup.parser.TokeniserState$12] */
    /* JADX WARN: Type inference failed for: r12v0, types: [org.jsoup.parser.TokeniserState$13] */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.jsoup.parser.TokeniserState$14] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.jsoup.parser.TokeniserState$15] */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.jsoup.parser.TokeniserState$16] */
    /* JADX WARN: Type inference failed for: r16v0, types: [org.jsoup.parser.TokeniserState$17] */
    /* JADX WARN: Type inference failed for: r17v0, types: [org.jsoup.parser.TokeniserState$18] */
    /* JADX WARN: Type inference failed for: r18v0, types: [org.jsoup.parser.TokeniserState$19] */
    /* JADX WARN: Type inference failed for: r19v0, types: [org.jsoup.parser.TokeniserState$20] */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.jsoup.parser.TokeniserState$2] */
    /* JADX WARN: Type inference failed for: r20v0, types: [org.jsoup.parser.TokeniserState$21] */
    /* JADX WARN: Type inference failed for: r21v0, types: [org.jsoup.parser.TokeniserState$22] */
    /* JADX WARN: Type inference failed for: r22v0, types: [org.jsoup.parser.TokeniserState$23] */
    /* JADX WARN: Type inference failed for: r23v0, types: [org.jsoup.parser.TokeniserState$24] */
    /* JADX WARN: Type inference failed for: r24v0, types: [org.jsoup.parser.TokeniserState$25] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.jsoup.parser.TokeniserState$26] */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.jsoup.parser.TokeniserState$27] */
    /* JADX WARN: Type inference failed for: r27v0, types: [org.jsoup.parser.TokeniserState$28] */
    /* JADX WARN: Type inference failed for: r28v0, types: [org.jsoup.parser.TokeniserState$29] */
    /* JADX WARN: Type inference failed for: r29v0, types: [org.jsoup.parser.TokeniserState$30] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.jsoup.parser.TokeniserState$3] */
    /* JADX WARN: Type inference failed for: r30v0, types: [org.jsoup.parser.TokeniserState$31] */
    /* JADX WARN: Type inference failed for: r31v0, types: [org.jsoup.parser.TokeniserState$32] */
    /* JADX WARN: Type inference failed for: r32v0, types: [org.jsoup.parser.TokeniserState$33] */
    /* JADX WARN: Type inference failed for: r33v0, types: [org.jsoup.parser.TokeniserState$34] */
    /* JADX WARN: Type inference failed for: r34v0, types: [org.jsoup.parser.TokeniserState$35] */
    /* JADX WARN: Type inference failed for: r35v0, types: [org.jsoup.parser.TokeniserState$36] */
    /* JADX WARN: Type inference failed for: r36v0, types: [org.jsoup.parser.TokeniserState$37] */
    /* JADX WARN: Type inference failed for: r37v0, types: [org.jsoup.parser.TokeniserState$38] */
    /* JADX WARN: Type inference failed for: r38v0, types: [org.jsoup.parser.TokeniserState$39] */
    /* JADX WARN: Type inference failed for: r39v0, types: [org.jsoup.parser.TokeniserState$40] */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.jsoup.parser.TokeniserState$4] */
    /* JADX WARN: Type inference failed for: r40v0, types: [org.jsoup.parser.TokeniserState$41] */
    /* JADX WARN: Type inference failed for: r41v0, types: [org.jsoup.parser.TokeniserState$42] */
    /* JADX WARN: Type inference failed for: r42v0, types: [org.jsoup.parser.TokeniserState$43] */
    /* JADX WARN: Type inference failed for: r43v0, types: [org.jsoup.parser.TokeniserState$44] */
    /* JADX WARN: Type inference failed for: r44v0, types: [org.jsoup.parser.TokeniserState$45] */
    /* JADX WARN: Type inference failed for: r45v0, types: [org.jsoup.parser.TokeniserState$46] */
    /* JADX WARN: Type inference failed for: r46v0, types: [org.jsoup.parser.TokeniserState$47] */
    /* JADX WARN: Type inference failed for: r47v0, types: [org.jsoup.parser.TokeniserState$48] */
    /* JADX WARN: Type inference failed for: r48v0, types: [org.jsoup.parser.TokeniserState$49] */
    /* JADX WARN: Type inference failed for: r49v0, types: [org.jsoup.parser.TokeniserState$50] */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.jsoup.parser.TokeniserState$5] */
    /* JADX WARN: Type inference failed for: r50v0, types: [org.jsoup.parser.TokeniserState$51] */
    /* JADX WARN: Type inference failed for: r51v0, types: [org.jsoup.parser.TokeniserState$52] */
    /* JADX WARN: Type inference failed for: r52v0, types: [org.jsoup.parser.TokeniserState$53] */
    /* JADX WARN: Type inference failed for: r53v0, types: [org.jsoup.parser.TokeniserState$54] */
    /* JADX WARN: Type inference failed for: r54v0, types: [org.jsoup.parser.TokeniserState$55] */
    /* JADX WARN: Type inference failed for: r55v0, types: [org.jsoup.parser.TokeniserState$56] */
    /* JADX WARN: Type inference failed for: r56v0, types: [org.jsoup.parser.TokeniserState$57] */
    /* JADX WARN: Type inference failed for: r57v0, types: [org.jsoup.parser.TokeniserState$58] */
    /* JADX WARN: Type inference failed for: r58v0, types: [org.jsoup.parser.TokeniserState$59] */
    /* JADX WARN: Type inference failed for: r59v0, types: [org.jsoup.parser.TokeniserState$60] */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.jsoup.parser.TokeniserState$6] */
    /* JADX WARN: Type inference failed for: r60v0, types: [org.jsoup.parser.TokeniserState$61] */
    /* JADX WARN: Type inference failed for: r61v0, types: [org.jsoup.parser.TokeniserState$62] */
    /* JADX WARN: Type inference failed for: r62v0, types: [org.jsoup.parser.TokeniserState$63] */
    /* JADX WARN: Type inference failed for: r63v0, types: [org.jsoup.parser.TokeniserState$64] */
    /* JADX WARN: Type inference failed for: r64v0, types: [org.jsoup.parser.TokeniserState$65] */
    /* JADX WARN: Type inference failed for: r65v0, types: [org.jsoup.parser.TokeniserState$66] */
    /* JADX WARN: Type inference failed for: r66v0, types: [org.jsoup.parser.TokeniserState$67] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.jsoup.parser.TokeniserState$7] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.jsoup.parser.TokeniserState$8] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.jsoup.parser.TokeniserState$9] */
    /* JADX WARN: Type inference failed for: r9v0, types: [org.jsoup.parser.TokeniserState$10] */
    static {
        ?? r02 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.1
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                int i10;
                char[] cArr;
                char c10;
                char cCurrent = aVar.current();
                if (cCurrent == 0) {
                    bVar.m(this);
                    bVar.f(aVar.c());
                    return;
                }
                if (cCurrent == '&') {
                    bVar.a(TokeniserState.f17248m);
                    return;
                }
                if (cCurrent == '<') {
                    bVar.a(TokeniserState.f17260s);
                    return;
                }
                if (cCurrent == 65535) {
                    bVar.h(new Token.e());
                    return;
                }
                aVar.a();
                int i11 = aVar.f12837e;
                int i12 = aVar.f12835c;
                while (true) {
                    i10 = aVar.f12837e;
                    cArr = aVar.f12833a;
                    if (i10 >= i12 || (c10 = cArr[i10]) == '&' || c10 == '<' || c10 == 0) {
                        break;
                    } else {
                        aVar.f12837e = i10 + 1;
                    }
                }
                bVar.g(i10 > i11 ? gh.a.b(cArr, aVar.f12840h, i11, i10 - i11) : "");
            }
        };
        f17236b = r02;
        ?? r12 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.2
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                int[] iArrC = bVar.c(null, false);
                if (iArrC == null) {
                    bVar.f('&');
                } else {
                    bVar.g(new String(iArrC, 0, iArrC.length));
                }
                bVar.f17296c = anonymousClass1;
            }
        };
        f17248m = r12;
        ?? r22 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.3
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char cCurrent = aVar.current();
                if (cCurrent == 0) {
                    bVar.m(this);
                    aVar.advance();
                    bVar.f((char) 65533);
                } else {
                    if (cCurrent == '&') {
                        bVar.a(TokeniserState.f17252o);
                        return;
                    }
                    if (cCurrent == '<') {
                        bVar.a(TokeniserState.f17266v);
                    } else if (cCurrent != 65535) {
                        bVar.g(aVar.consumeToAny('&', '<', 0));
                    } else {
                        bVar.h(new Token.e());
                    }
                }
            }
        };
        f17250n = r22;
        ?? r32 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.4
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                AnonymousClass3 anonymousClass3 = TokeniserState.f17250n;
                int[] iArrC = bVar.c(null, false);
                if (iArrC == null) {
                    bVar.f('&');
                } else {
                    bVar.g(new String(iArrC, 0, iArrC.length));
                }
                bVar.f17296c = anonymousClass3;
            }
        };
        f17252o = r32;
        ?? r42 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.5
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.a(bVar, aVar, this, TokeniserState.f17272y);
            }
        };
        f17254p = r42;
        ?? r52 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.6
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.a(bVar, aVar, this, TokeniserState.B);
            }
        };
        f17256q = r52;
        ?? r62 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.7
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char cCurrent = aVar.current();
                if (cCurrent == 0) {
                    bVar.m(this);
                    aVar.advance();
                    bVar.f((char) 65533);
                } else if (cCurrent != 65535) {
                    bVar.g(aVar.consumeTo((char) 0));
                } else {
                    bVar.h(new Token.e());
                }
            }
        };
        f17258r = r62;
        ?? r72 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.8
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char cCurrent = aVar.current();
                if (cCurrent == '!') {
                    bVar.a(TokeniserState.f17238c0);
                    return;
                }
                if (cCurrent == '/') {
                    bVar.a(TokeniserState.f17262t);
                    return;
                }
                if (cCurrent == '?') {
                    bVar.a(TokeniserState.f17237b0);
                    return;
                }
                if (aVar.j()) {
                    bVar.d(true);
                    bVar.f17296c = TokeniserState.f17264u;
                } else {
                    bVar.m(this);
                    bVar.f('<');
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        f17260s = r72;
        ?? r82 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.9
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                boolean zIsEmpty = aVar.isEmpty();
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (zIsEmpty) {
                    bVar.l(this);
                    bVar.g("</");
                    bVar.f17296c = anonymousClass1;
                } else if (aVar.j()) {
                    bVar.d(false);
                    bVar.f17296c = TokeniserState.f17264u;
                } else if (aVar.h('>')) {
                    bVar.m(this);
                    bVar.a(anonymousClass1);
                } else {
                    bVar.m(this);
                    bVar.a(TokeniserState.f17237b0);
                }
            }
        };
        f17262t = r82;
        ?? r92 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.10
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                int i10;
                char[] cArr;
                char c10;
                aVar.a();
                int i11 = aVar.f12837e;
                int i12 = aVar.f12835c;
                while (true) {
                    i10 = aVar.f12837e;
                    cArr = aVar.f12833a;
                    if (i10 >= i12 || (c10 = cArr[i10]) == '\t' || c10 == '\n' || c10 == '\r' || c10 == '\f' || c10 == ' ' || c10 == '/' || c10 == '>' || c10 == 0) {
                        break;
                    } else {
                        aVar.f12837e = i10 + 1;
                    }
                }
                bVar.f17302i.l(i10 > i11 ? gh.a.b(cArr, aVar.f12840h, i11, i10 - i11) : "");
                char c11 = aVar.c();
                if (c11 == 0) {
                    bVar.f17302i.l(TokeniserState.E0);
                    return;
                }
                if (c11 != ' ') {
                    if (c11 == '/') {
                        bVar.f17296c = TokeniserState.f17235a0;
                        return;
                    }
                    AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                    if (c11 == '>') {
                        bVar.k();
                        bVar.f17296c = anonymousClass1;
                        return;
                    }
                    if (c11 == 65535) {
                        bVar.l(this);
                        bVar.f17296c = anonymousClass1;
                        return;
                    } else if (c11 != '\t' && c11 != '\n' && c11 != '\f' && c11 != '\r') {
                        Token.h hVar = bVar.f17302i;
                        hVar.getClass();
                        hVar.l(String.valueOf(c11));
                        return;
                    }
                }
                bVar.f17296c = TokeniserState.S;
            }
        };
        f17264u = r92;
        ?? r10 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.11
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (aVar.h(JsonPointer.SEPARATOR)) {
                    bVar.e();
                    bVar.a(TokeniserState.f17268w);
                    return;
                }
                if (aVar.j() && bVar.f17308o != null) {
                    String str = "</" + bVar.f17308o;
                    Locale locale = Locale.ENGLISH;
                    if (!(aVar.k(str.toLowerCase(locale)) > -1 || aVar.k(str.toUpperCase(locale)) > -1)) {
                        Token.h hVarD = bVar.d(false);
                        hVarD.n(bVar.f17308o);
                        bVar.f17302i = hVarD;
                        bVar.k();
                        aVar.l();
                        bVar.f17296c = TokeniserState.f17236b;
                        return;
                    }
                }
                bVar.g("<");
                bVar.f17296c = TokeniserState.f17250n;
            }
        };
        f17266v = r10;
        ?? r11 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.12
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                if (!aVar.j()) {
                    bVar.g("</");
                    bVar.f17296c = TokeniserState.f17250n;
                    return;
                }
                bVar.d(false);
                Token.h hVar = bVar.f17302i;
                char cCurrent = aVar.current();
                hVar.getClass();
                hVar.l(String.valueOf(cCurrent));
                bVar.f17301h.append(aVar.current());
                bVar.a(TokeniserState.f17270x);
            }
        };
        f17268w = r11;
        ?? r122 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.13
            public static void e(b bVar, gh.a aVar) {
                bVar.g("</" + bVar.f17301h.toString());
                aVar.l();
                bVar.f17296c = TokeniserState.f17250n;
            }

            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                if (aVar.j()) {
                    String strD = aVar.d();
                    bVar.f17302i.l(strD);
                    bVar.f17301h.append(strD);
                    return;
                }
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    if (bVar.n()) {
                        bVar.f17296c = TokeniserState.S;
                        return;
                    } else {
                        e(bVar, aVar);
                        return;
                    }
                }
                if (c10 == '/') {
                    if (bVar.n()) {
                        bVar.f17296c = TokeniserState.f17235a0;
                        return;
                    } else {
                        e(bVar, aVar);
                        return;
                    }
                }
                if (c10 != '>') {
                    e(bVar, aVar);
                } else if (!bVar.n()) {
                    e(bVar, aVar);
                } else {
                    bVar.k();
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        f17270x = r122;
        ?? r13 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.14
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (aVar.h(JsonPointer.SEPARATOR)) {
                    bVar.e();
                    bVar.a(TokeniserState.f17274z);
                } else {
                    bVar.f('<');
                    bVar.f17296c = TokeniserState.f17254p;
                }
            }
        };
        f17272y = r13;
        ?? r14 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.15
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                AnonymousClass16 anonymousClass16 = TokeniserState.A;
                AnonymousClass5 anonymousClass5 = TokeniserState.f17254p;
                if (aVar.j()) {
                    bVar.d(false);
                    bVar.f17296c = anonymousClass16;
                } else {
                    bVar.g("</");
                    bVar.f17296c = anonymousClass5;
                }
            }
        };
        f17274z = r14;
        ?? r15 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.16
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.b(bVar, aVar, TokeniserState.f17254p);
            }
        };
        A = r15;
        ?? r16 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.17
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '!') {
                    bVar.g("<!");
                    bVar.f17296c = TokeniserState.E;
                } else if (c10 == '/') {
                    bVar.e();
                    bVar.f17296c = TokeniserState.C;
                } else {
                    bVar.g("<");
                    aVar.l();
                    bVar.f17296c = TokeniserState.f17256q;
                }
            }
        };
        B = r16;
        ?? r17 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.18
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                AnonymousClass19 anonymousClass19 = TokeniserState.D;
                AnonymousClass6 anonymousClass6 = TokeniserState.f17256q;
                if (aVar.j()) {
                    bVar.d(false);
                    bVar.f17296c = anonymousClass19;
                } else {
                    bVar.g("</");
                    bVar.f17296c = anonymousClass6;
                }
            }
        };
        C = r17;
        ?? r18 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.19
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.b(bVar, aVar, TokeniserState.f17256q);
            }
        };
        D = r18;
        ?? r19 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.20
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (!aVar.h('-')) {
                    bVar.f17296c = TokeniserState.f17256q;
                } else {
                    bVar.f('-');
                    bVar.a(TokeniserState.F);
                }
            }
        };
        E = r19;
        ?? r20 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.21
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (!aVar.h('-')) {
                    bVar.f17296c = TokeniserState.f17256q;
                } else {
                    bVar.f('-');
                    bVar.a(TokeniserState.I);
                }
            }
        };
        F = r20;
        ?? r21 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.22
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                if (aVar.isEmpty()) {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                    return;
                }
                char cCurrent = aVar.current();
                if (cCurrent == 0) {
                    bVar.m(this);
                    aVar.advance();
                    bVar.f((char) 65533);
                } else if (cCurrent == '-') {
                    bVar.f('-');
                    bVar.a(TokeniserState.H);
                } else if (cCurrent != '<') {
                    bVar.g(aVar.consumeToAny('-', '<', 0));
                } else {
                    bVar.a(TokeniserState.J);
                }
            }
        };
        G = r21;
        ?? r222 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.23
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                if (aVar.isEmpty()) {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                    return;
                }
                char c10 = aVar.c();
                AnonymousClass22 anonymousClass22 = TokeniserState.G;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f((char) 65533);
                    bVar.f17296c = anonymousClass22;
                } else if (c10 == '-') {
                    bVar.f(c10);
                    bVar.f17296c = TokeniserState.I;
                } else if (c10 == '<') {
                    bVar.f17296c = TokeniserState.J;
                } else {
                    bVar.f(c10);
                    bVar.f17296c = anonymousClass22;
                }
            }
        };
        H = r222;
        ?? r23 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.24
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                if (aVar.isEmpty()) {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                    return;
                }
                char c10 = aVar.c();
                AnonymousClass22 anonymousClass22 = TokeniserState.G;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f((char) 65533);
                    bVar.f17296c = anonymousClass22;
                } else {
                    if (c10 == '-') {
                        bVar.f(c10);
                        return;
                    }
                    if (c10 == '<') {
                        bVar.f17296c = TokeniserState.J;
                    } else if (c10 != '>') {
                        bVar.f(c10);
                        bVar.f17296c = anonymousClass22;
                    } else {
                        bVar.f(c10);
                        bVar.f17296c = TokeniserState.f17256q;
                    }
                }
            }
        };
        I = r23;
        ?? r24 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.25
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (aVar.j()) {
                    bVar.e();
                    bVar.f17301h.append(aVar.current());
                    bVar.g("<" + aVar.current());
                    bVar.a(TokeniserState.M);
                    return;
                }
                if (aVar.h(JsonPointer.SEPARATOR)) {
                    bVar.e();
                    bVar.a(TokeniserState.K);
                } else {
                    bVar.f('<');
                    bVar.f17296c = TokeniserState.G;
                }
            }
        };
        J = r24;
        ?? r25 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.26
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                if (!aVar.j()) {
                    bVar.g("</");
                    bVar.f17296c = TokeniserState.G;
                    return;
                }
                bVar.d(false);
                Token.h hVar = bVar.f17302i;
                char cCurrent = aVar.current();
                hVar.getClass();
                hVar.l(String.valueOf(cCurrent));
                bVar.f17301h.append(aVar.current());
                bVar.a(TokeniserState.L);
            }
        };
        K = r25;
        ?? r26 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.27
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.b(bVar, aVar, TokeniserState.G);
            }
        };
        L = r26;
        ?? r27 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.28
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.c(bVar, aVar, TokeniserState.N, TokeniserState.G);
            }
        };
        M = r27;
        ?? r28 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.29
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char cCurrent = aVar.current();
                if (cCurrent == 0) {
                    bVar.m(this);
                    aVar.advance();
                    bVar.f((char) 65533);
                } else if (cCurrent == '-') {
                    bVar.f(cCurrent);
                    bVar.a(TokeniserState.O);
                } else if (cCurrent == '<') {
                    bVar.f(cCurrent);
                    bVar.a(TokeniserState.Q);
                } else if (cCurrent != 65535) {
                    bVar.g(aVar.consumeToAny('-', '<', 0));
                } else {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        N = r28;
        ?? r29 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.30
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass29 anonymousClass29 = TokeniserState.N;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f((char) 65533);
                    bVar.f17296c = anonymousClass29;
                } else if (c10 == '-') {
                    bVar.f(c10);
                    bVar.f17296c = TokeniserState.P;
                } else if (c10 == '<') {
                    bVar.f(c10);
                    bVar.f17296c = TokeniserState.Q;
                } else if (c10 != 65535) {
                    bVar.f(c10);
                    bVar.f17296c = anonymousClass29;
                } else {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        O = r29;
        ?? r30 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.31
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass29 anonymousClass29 = TokeniserState.N;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f((char) 65533);
                    bVar.f17296c = anonymousClass29;
                    return;
                }
                if (c10 == '-') {
                    bVar.f(c10);
                    return;
                }
                if (c10 == '<') {
                    bVar.f(c10);
                    bVar.f17296c = TokeniserState.Q;
                } else if (c10 == '>') {
                    bVar.f(c10);
                    bVar.f17296c = TokeniserState.f17256q;
                } else if (c10 != 65535) {
                    bVar.f(c10);
                    bVar.f17296c = anonymousClass29;
                } else {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        P = r30;
        ?? r31 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.32
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (!aVar.h(JsonPointer.SEPARATOR)) {
                    bVar.f17296c = TokeniserState.N;
                    return;
                }
                bVar.f(JsonPointer.SEPARATOR);
                bVar.e();
                bVar.a(TokeniserState.R);
            }
        };
        Q = r31;
        ?? r322 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.33
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                TokeniserState.c(bVar, aVar, TokeniserState.G, TokeniserState.N);
            }
        };
        R = r322;
        ?? r33 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.34
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass35 anonymousClass35 = TokeniserState.T;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.o();
                    aVar.l();
                    bVar.f17296c = anonymousClass35;
                    return;
                }
                if (c10 != ' ') {
                    if (c10 != '\"' && c10 != '\'') {
                        if (c10 == '/') {
                            bVar.f17296c = TokeniserState.f17235a0;
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                        if (c10 == 65535) {
                            bVar.l(this);
                            bVar.f17296c = anonymousClass1;
                            return;
                        }
                        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r') {
                            return;
                        }
                        switch (c10) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                bVar.k();
                                bVar.f17296c = anonymousClass1;
                                break;
                            default:
                                bVar.f17302i.o();
                                aVar.l();
                                bVar.f17296c = anonymousClass35;
                                break;
                        }
                        return;
                    }
                    bVar.m(this);
                    bVar.f17302i.o();
                    bVar.f17302i.h(c10);
                    bVar.f17296c = anonymousClass35;
                }
            }
        };
        S = r33;
        ?? r34 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.35
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                String strE = aVar.e(TokeniserState.C0);
                Token.h hVar = bVar.f17302i;
                String str = hVar.f17228d;
                if (str != null) {
                    strE = str.concat(strE);
                }
                hVar.f17228d = strE;
                char c10 = aVar.c();
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.h((char) 65533);
                    return;
                }
                if (c10 != ' ') {
                    if (c10 != '\"' && c10 != '\'') {
                        if (c10 == '/') {
                            bVar.f17296c = TokeniserState.f17235a0;
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                        if (c10 == 65535) {
                            bVar.l(this);
                            bVar.f17296c = anonymousClass1;
                            return;
                        }
                        if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r') {
                            switch (c10) {
                                case '<':
                                    break;
                                case '=':
                                    bVar.f17296c = TokeniserState.V;
                                    break;
                                case '>':
                                    bVar.k();
                                    bVar.f17296c = anonymousClass1;
                                    break;
                                default:
                                    bVar.f17302i.h(c10);
                                    break;
                            }
                            return;
                        }
                    }
                    bVar.m(this);
                    bVar.f17302i.h(c10);
                    return;
                }
                bVar.f17296c = TokeniserState.U;
            }
        };
        T = r34;
        ?? r35 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.36
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass35 anonymousClass35 = TokeniserState.T;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.h((char) 65533);
                    bVar.f17296c = anonymousClass35;
                    return;
                }
                if (c10 != ' ') {
                    if (c10 != '\"' && c10 != '\'') {
                        if (c10 == '/') {
                            bVar.f17296c = TokeniserState.f17235a0;
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                        if (c10 == 65535) {
                            bVar.l(this);
                            bVar.f17296c = anonymousClass1;
                            return;
                        }
                        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r') {
                            return;
                        }
                        switch (c10) {
                            case '<':
                                break;
                            case '=':
                                bVar.f17296c = TokeniserState.V;
                                break;
                            case '>':
                                bVar.k();
                                bVar.f17296c = anonymousClass1;
                                break;
                            default:
                                bVar.f17302i.o();
                                aVar.l();
                                bVar.f17296c = anonymousClass35;
                                break;
                        }
                        return;
                    }
                    bVar.m(this);
                    bVar.f17302i.o();
                    bVar.f17302i.h(c10);
                    bVar.f17296c = anonymousClass35;
                }
            }
        };
        U = r35;
        ?? r36 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.37
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass40 anonymousClass40 = TokeniserState.Y;
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.i((char) 65533);
                    bVar.f17296c = anonymousClass40;
                    return;
                }
                if (c10 != ' ') {
                    if (c10 == '\"') {
                        bVar.f17296c = TokeniserState.W;
                        return;
                    }
                    if (c10 != '`') {
                        AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                        if (c10 == 65535) {
                            bVar.l(this);
                            bVar.k();
                            bVar.f17296c = anonymousClass1;
                            return;
                        }
                        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r') {
                            return;
                        }
                        if (c10 == '&') {
                            aVar.l();
                            bVar.f17296c = anonymousClass40;
                            return;
                        }
                        if (c10 == '\'') {
                            bVar.f17296c = TokeniserState.X;
                            return;
                        }
                        switch (c10) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                bVar.m(this);
                                bVar.k();
                                bVar.f17296c = anonymousClass1;
                                break;
                            default:
                                aVar.l();
                                bVar.f17296c = anonymousClass40;
                                break;
                        }
                        return;
                    }
                    bVar.m(this);
                    bVar.f17302i.i(c10);
                    bVar.f17296c = anonymousClass40;
                }
            }
        };
        V = r36;
        ?? r37 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.38
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                String strConsumeToAny = aVar.consumeToAny(TokeniserState.B0);
                if (strConsumeToAny.length() > 0) {
                    bVar.f17302i.j(strConsumeToAny);
                } else {
                    bVar.f17302i.f17231g = true;
                }
                char c10 = aVar.c();
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.i((char) 65533);
                    return;
                }
                if (c10 == '\"') {
                    bVar.f17296c = TokeniserState.Z;
                    return;
                }
                if (c10 != '&') {
                    if (c10 != 65535) {
                        bVar.f17302i.i(c10);
                        return;
                    } else {
                        bVar.l(this);
                        bVar.f17296c = TokeniserState.f17236b;
                        return;
                    }
                }
                int[] iArrC = bVar.c('\"', true);
                if (iArrC != null) {
                    bVar.f17302i.k(iArrC);
                } else {
                    bVar.f17302i.i('&');
                }
            }
        };
        W = r37;
        ?? r38 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.39
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                String strConsumeToAny = aVar.consumeToAny(TokeniserState.A0);
                if (strConsumeToAny.length() > 0) {
                    bVar.f17302i.j(strConsumeToAny);
                } else {
                    bVar.f17302i.f17231g = true;
                }
                char c10 = aVar.c();
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.i((char) 65533);
                    return;
                }
                if (c10 == 65535) {
                    bVar.l(this);
                    bVar.f17296c = TokeniserState.f17236b;
                    return;
                }
                if (c10 != '&') {
                    if (c10 != '\'') {
                        bVar.f17302i.i(c10);
                        return;
                    } else {
                        bVar.f17296c = TokeniserState.Z;
                        return;
                    }
                }
                int[] iArrC = bVar.c('\'', true);
                if (iArrC != null) {
                    bVar.f17302i.k(iArrC);
                } else {
                    bVar.f17302i.i('&');
                }
            }
        };
        X = r38;
        ?? r39 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.40
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                String strE = aVar.e(TokeniserState.D0);
                if (strE.length() > 0) {
                    bVar.f17302i.j(strE);
                }
                char c10 = aVar.c();
                if (c10 == 0) {
                    bVar.m(this);
                    bVar.f17302i.i((char) 65533);
                    return;
                }
                if (c10 != ' ') {
                    if (c10 != '\"' && c10 != '`') {
                        AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                        if (c10 == 65535) {
                            bVar.l(this);
                            bVar.f17296c = anonymousClass1;
                            return;
                        }
                        if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r') {
                            if (c10 == '&') {
                                int[] iArrC = bVar.c('>', true);
                                if (iArrC != null) {
                                    bVar.f17302i.k(iArrC);
                                    return;
                                } else {
                                    bVar.f17302i.i('&');
                                    return;
                                }
                            }
                            if (c10 != '\'') {
                                switch (c10) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        bVar.k();
                                        bVar.f17296c = anonymousClass1;
                                        break;
                                    default:
                                        bVar.f17302i.i(c10);
                                        break;
                                }
                                return;
                            }
                        }
                    }
                    bVar.m(this);
                    bVar.f17302i.i(c10);
                    return;
                }
                bVar.f17296c = TokeniserState.S;
            }
        };
        Y = r39;
        ?? r40 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.41
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass34 anonymousClass34 = TokeniserState.S;
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    bVar.f17296c = anonymousClass34;
                    return;
                }
                if (c10 == '/') {
                    bVar.f17296c = TokeniserState.f17235a0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.k();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 == 65535) {
                    bVar.l(this);
                    bVar.f17296c = anonymousClass1;
                } else {
                    bVar.m(this);
                    aVar.l();
                    bVar.f17296c = anonymousClass34;
                }
            }
        };
        Z = r40;
        ?? r41 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.42
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.f17302i.f17233i = true;
                    bVar.k();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 == 65535) {
                    bVar.l(this);
                    bVar.f17296c = anonymousClass1;
                } else {
                    bVar.m(this);
                    aVar.l();
                    bVar.f17296c = TokeniserState.S;
                }
            }
        };
        f17235a0 = r41;
        ?? r422 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.43
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                aVar.l();
                Token.c cVar = new Token.c();
                cVar.f17220c = true;
                cVar.f17219b.append(aVar.consumeTo('>'));
                bVar.h(cVar);
                bVar.a(TokeniserState.f17236b);
            }
        };
        f17237b0 = r422;
        ?? r43 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.44
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) {
                if (aVar.f("--")) {
                    bVar.f17307n.f();
                    bVar.f17296c = TokeniserState.f17239d0;
                } else if (aVar.g("DOCTYPE")) {
                    bVar.f17296c = TokeniserState.f17245j0;
                } else if (aVar.f("[CDATA[")) {
                    bVar.e();
                    bVar.f17296c = TokeniserState.f17275z0;
                } else {
                    bVar.m(this);
                    bVar.a(TokeniserState.f17237b0);
                }
            }
        };
        f17238c0 = r43;
        ?? r44 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.45
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass47 anonymousClass47 = TokeniserState.f17241f0;
                Token.c cVar = bVar.f17307n;
                if (c10 == 0) {
                    bVar.m(this);
                    cVar.f17219b.append((char) 65533);
                    bVar.f17296c = anonymousClass47;
                    return;
                }
                if (c10 == '-') {
                    bVar.f17296c = TokeniserState.f17240e0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.m(this);
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 != 65535) {
                    cVar.f17219b.append(c10);
                    bVar.f17296c = anonymousClass47;
                } else {
                    bVar.l(this);
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17239d0 = r44;
        ?? r45 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.46
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass47 anonymousClass47 = TokeniserState.f17241f0;
                Token.c cVar = bVar.f17307n;
                if (c10 == 0) {
                    bVar.m(this);
                    cVar.f17219b.append((char) 65533);
                    bVar.f17296c = anonymousClass47;
                    return;
                }
                if (c10 == '-') {
                    bVar.f17296c = TokeniserState.f17240e0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.m(this);
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 != 65535) {
                    cVar.f17219b.append(c10);
                    bVar.f17296c = anonymousClass47;
                } else {
                    bVar.l(this);
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17240e0 = r45;
        ?? r46 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.47
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char cCurrent = aVar.current();
                Token.c cVar = bVar.f17307n;
                if (cCurrent == 0) {
                    bVar.m(this);
                    aVar.advance();
                    cVar.f17219b.append((char) 65533);
                } else if (cCurrent == '-') {
                    bVar.a(TokeniserState.f17242g0);
                } else {
                    if (cCurrent != 65535) {
                        cVar.f17219b.append(aVar.consumeToAny('-', 0));
                        return;
                    }
                    bVar.l(this);
                    bVar.i();
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        f17241f0 = r46;
        ?? r47 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.48
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass47 anonymousClass47 = TokeniserState.f17241f0;
                Token.c cVar = bVar.f17307n;
                if (c10 == 0) {
                    bVar.m(this);
                    StringBuilder sb2 = cVar.f17219b;
                    sb2.append('-');
                    sb2.append((char) 65533);
                    bVar.f17296c = anonymousClass47;
                    return;
                }
                if (c10 == '-') {
                    bVar.f17296c = TokeniserState.f17243h0;
                    return;
                }
                if (c10 == 65535) {
                    bVar.l(this);
                    bVar.i();
                    bVar.f17296c = TokeniserState.f17236b;
                } else {
                    StringBuilder sb3 = cVar.f17219b;
                    sb3.append('-');
                    sb3.append(c10);
                    bVar.f17296c = anonymousClass47;
                }
            }
        };
        f17242g0 = r47;
        ?? r48 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.49
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass47 anonymousClass47 = TokeniserState.f17241f0;
                Token.c cVar = bVar.f17307n;
                if (c10 == 0) {
                    bVar.m(this);
                    StringBuilder sb2 = cVar.f17219b;
                    sb2.append("--");
                    sb2.append((char) 65533);
                    bVar.f17296c = anonymousClass47;
                    return;
                }
                if (c10 == '!') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17244i0;
                    return;
                }
                if (c10 == '-') {
                    bVar.m(this);
                    cVar.f17219b.append('-');
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 == 65535) {
                    bVar.l(this);
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                } else {
                    bVar.m(this);
                    StringBuilder sb3 = cVar.f17219b;
                    sb3.append("--");
                    sb3.append(c10);
                    bVar.f17296c = anonymousClass47;
                }
            }
        };
        f17243h0 = r48;
        ?? r49 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.50
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass47 anonymousClass47 = TokeniserState.f17241f0;
                Token.c cVar = bVar.f17307n;
                if (c10 == 0) {
                    bVar.m(this);
                    StringBuilder sb2 = cVar.f17219b;
                    sb2.append("--!");
                    sb2.append((char) 65533);
                    bVar.f17296c = anonymousClass47;
                    return;
                }
                if (c10 == '-') {
                    cVar.f17219b.append("--!");
                    bVar.f17296c = TokeniserState.f17242g0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 == 65535) {
                    bVar.l(this);
                    bVar.i();
                    bVar.f17296c = anonymousClass1;
                } else {
                    StringBuilder sb3 = cVar.f17219b;
                    sb3.append("--!");
                    sb3.append(c10);
                    bVar.f17296c = anonymousClass47;
                }
            }
        };
        f17244i0 = r49;
        ?? r50 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.51
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass52 anonymousClass52 = TokeniserState.f17246k0;
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    bVar.f17296c = anonymousClass52;
                    return;
                }
                if (c10 != '>') {
                    if (c10 != 65535) {
                        bVar.m(this);
                        bVar.f17296c = anonymousClass52;
                        return;
                    }
                    bVar.l(this);
                }
                bVar.m(this);
                Token.d dVar = bVar.f17306m;
                dVar.f();
                dVar.f17225f = true;
                bVar.j();
                bVar.f17296c = TokeniserState.f17236b;
            }
        };
        f17245j0 = r50;
        ?? r51 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.52
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                boolean zJ = aVar.j();
                AnonymousClass53 anonymousClass53 = TokeniserState.f17247l0;
                Token.d dVar = bVar.f17306m;
                if (zJ) {
                    dVar.f();
                    bVar.f17296c = anonymousClass53;
                    return;
                }
                char c10 = aVar.c();
                if (c10 == 0) {
                    bVar.m(this);
                    dVar.f();
                    dVar.f17221b.append((char) 65533);
                    bVar.f17296c = anonymousClass53;
                    return;
                }
                if (c10 != ' ') {
                    if (c10 == 65535) {
                        bVar.l(this);
                        dVar.f();
                        dVar.f17225f = true;
                        bVar.j();
                        bVar.f17296c = TokeniserState.f17236b;
                        return;
                    }
                    if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r') {
                        return;
                    }
                    dVar.f();
                    dVar.f17221b.append(c10);
                    bVar.f17296c = anonymousClass53;
                }
            }
        };
        f17246k0 = r51;
        ?? r522 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.53
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                boolean zJ = aVar.j();
                Token.d dVar = bVar.f17306m;
                if (zJ) {
                    dVar.f17221b.append(aVar.d());
                    return;
                }
                char c10 = aVar.c();
                if (c10 == 0) {
                    bVar.m(this);
                    dVar.f17221b.append((char) 65533);
                    return;
                }
                if (c10 != ' ') {
                    AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                    if (c10 == '>') {
                        bVar.j();
                        bVar.f17296c = anonymousClass1;
                        return;
                    }
                    if (c10 == 65535) {
                        bVar.l(this);
                        dVar.f17225f = true;
                        bVar.j();
                        bVar.f17296c = anonymousClass1;
                        return;
                    }
                    if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r') {
                        dVar.f17221b.append(c10);
                        return;
                    }
                }
                bVar.f17296c = TokeniserState.f17249m0;
            }
        };
        f17247l0 = r522;
        ?? r53 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.54
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                boolean zIsEmpty = aVar.isEmpty();
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                Token.d dVar = bVar.f17306m;
                if (zIsEmpty) {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (aVar.i('\t', '\n', '\r', '\f', TokenParser.SP)) {
                    aVar.advance();
                    return;
                }
                if (aVar.h('>')) {
                    bVar.j();
                    bVar.a(anonymousClass1);
                    return;
                }
                if (aVar.g("PUBLIC")) {
                    dVar.f17222c = "PUBLIC";
                    bVar.f17296c = TokeniserState.f17251n0;
                } else if (aVar.g("SYSTEM")) {
                    dVar.f17222c = "SYSTEM";
                    bVar.f17296c = TokeniserState.f17263t0;
                } else {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.a(TokeniserState.f17273y0);
                }
            }
        };
        f17249m0 = r53;
        ?? r54 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.55
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    bVar.f17296c = TokeniserState.f17253o0;
                    return;
                }
                if (c10 == '\"') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17255p0;
                    return;
                }
                if (c10 == '\'') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17257q0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                Token.d dVar = bVar.f17306m;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.f17296c = TokeniserState.f17273y0;
                } else {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17251n0 = r54;
        ?? r55 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.56
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    return;
                }
                if (c10 == '\"') {
                    bVar.f17296c = TokeniserState.f17255p0;
                    return;
                }
                if (c10 == '\'') {
                    bVar.f17296c = TokeniserState.f17257q0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                Token.d dVar = bVar.f17306m;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.f17296c = TokeniserState.f17273y0;
                } else {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17253o0 = r55;
        ?? r56 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.57
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                Token.d dVar = bVar.f17306m;
                if (c10 == 0) {
                    bVar.m(this);
                    dVar.f17223d.append((char) 65533);
                    return;
                }
                if (c10 == '\"') {
                    bVar.f17296c = TokeniserState.f17259r0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    dVar.f17223d.append(c10);
                    return;
                }
                bVar.l(this);
                dVar.f17225f = true;
                bVar.j();
                bVar.f17296c = anonymousClass1;
            }
        };
        f17255p0 = r56;
        ?? r57 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.58
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                Token.d dVar = bVar.f17306m;
                if (c10 == 0) {
                    bVar.m(this);
                    dVar.f17223d.append((char) 65533);
                    return;
                }
                if (c10 == '\'') {
                    bVar.f17296c = TokeniserState.f17259r0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    dVar.f17223d.append(c10);
                    return;
                }
                bVar.l(this);
                dVar.f17225f = true;
                bVar.j();
                bVar.f17296c = anonymousClass1;
            }
        };
        f17257q0 = r57;
        ?? r58 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.59
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    bVar.f17296c = TokeniserState.f17261s0;
                    return;
                }
                if (c10 == '\"') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17267v0;
                    return;
                }
                if (c10 == '\'') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17269w0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                Token.d dVar = bVar.f17306m;
                if (c10 != 65535) {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.f17296c = TokeniserState.f17273y0;
                } else {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17259r0 = r58;
        ?? r59 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.60
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    return;
                }
                if (c10 == '\"') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17267v0;
                    return;
                }
                if (c10 == '\'') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17269w0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                Token.d dVar = bVar.f17306m;
                if (c10 != 65535) {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.f17296c = TokeniserState.f17273y0;
                } else {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17261s0 = r59;
        ?? r60 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.61
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    bVar.f17296c = TokeniserState.f17265u0;
                    return;
                }
                if (c10 == '\"') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17267v0;
                    return;
                }
                if (c10 == '\'') {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17269w0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                Token.d dVar = bVar.f17306m;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                } else {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17263t0 = r60;
        ?? r61 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.62
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    return;
                }
                if (c10 == '\"') {
                    bVar.f17296c = TokeniserState.f17267v0;
                    return;
                }
                if (c10 == '\'') {
                    bVar.f17296c = TokeniserState.f17269w0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                Token.d dVar = bVar.f17306m;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.f17296c = TokeniserState.f17273y0;
                } else {
                    bVar.l(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17265u0 = r61;
        ?? r622 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.63
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                Token.d dVar = bVar.f17306m;
                if (c10 == 0) {
                    bVar.m(this);
                    dVar.f17224e.append((char) 65533);
                    return;
                }
                if (c10 == '\"') {
                    bVar.f17296c = TokeniserState.f17271x0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    dVar.f17224e.append(c10);
                    return;
                }
                bVar.l(this);
                dVar.f17225f = true;
                bVar.j();
                bVar.f17296c = anonymousClass1;
            }
        };
        f17267v0 = r622;
        ?? r63 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.64
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                Token.d dVar = bVar.f17306m;
                if (c10 == 0) {
                    bVar.m(this);
                    dVar.f17224e.append((char) 65533);
                    return;
                }
                if (c10 == '\'') {
                    bVar.f17296c = TokeniserState.f17271x0;
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.m(this);
                    dVar.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                    return;
                }
                if (c10 != 65535) {
                    dVar.f17224e.append(c10);
                    return;
                }
                bVar.l(this);
                dVar.f17225f = true;
                bVar.j();
                bVar.f17296c = anonymousClass1;
            }
        };
        f17269w0 = r63;
        ?? r64 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.65
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                    return;
                }
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                } else if (c10 != 65535) {
                    bVar.m(this);
                    bVar.f17296c = TokeniserState.f17273y0;
                } else {
                    bVar.l(this);
                    bVar.f17306m.f17225f = true;
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17271x0 = r64;
        ?? r65 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.66
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                char c10 = aVar.c();
                AnonymousClass1 anonymousClass1 = TokeniserState.f17236b;
                if (c10 == '>') {
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                } else {
                    if (c10 != 65535) {
                        return;
                    }
                    bVar.j();
                    bVar.f17296c = anonymousClass1;
                }
            }
        };
        f17273y0 = r65;
        ?? r66 = new TokeniserState() { // from class: org.jsoup.parser.TokeniserState.67
            @Override // org.jsoup.parser.TokeniserState
            public final void d(b bVar, gh.a aVar) throws IOException {
                String strB;
                int iK = aVar.k("]]>");
                String[] strArr = aVar.f12840h;
                char[] cArr = aVar.f12833a;
                if (iK != -1) {
                    strB = gh.a.b(cArr, strArr, aVar.f12837e, iK);
                    aVar.f12837e += iK;
                } else {
                    aVar.a();
                    int i10 = aVar.f12837e;
                    strB = gh.a.b(cArr, strArr, i10, aVar.f12835c - i10);
                    aVar.f12837e = aVar.f12835c;
                }
                StringBuilder sb2 = bVar.f17301h;
                sb2.append(strB);
                if (aVar.f("]]>") || aVar.isEmpty()) {
                    bVar.h(new Token.a(sb2.toString()));
                    bVar.f17296c = TokeniserState.f17236b;
                }
            }
        };
        f17275z0 = r66;
        F0 = new TokeniserState[]{r02, r12, r22, r32, r42, r52, r62, r72, r82, r92, r10, r11, r122, r13, r14, r15, r16, r17, r18, r19, r20, r21, r222, r23, r24, r25, r26, r27, r28, r29, r30, r31, r322, r33, r34, r35, r36, r37, r38, r39, r40, r41, r422, r43, r44, r45, r46, r47, r48, r49, r50, r51, r522, r53, r54, r55, r56, r57, r58, r59, r60, r61, r622, r63, r64, r65, r66};
        A0 = new char[]{0, '&', '\''};
        B0 = new char[]{0, '\"', '&'};
        C0 = new char[]{0, '\t', '\n', '\f', '\r', TokenParser.SP, '\"', '\'', JsonPointer.SEPARATOR, '<', '=', '>'};
        D0 = new char[]{0, '\t', '\n', '\f', '\r', TokenParser.SP, '\"', '&', '\'', '<', '=', '>', '`'};
        E0 = String.valueOf((char) 65533);
    }

    public TokeniserState() {
        throw null;
    }

    public TokeniserState(String str, int i10) {
    }

    public static void a(b bVar, gh.a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) throws IOException {
        char cCurrent = aVar.current();
        if (cCurrent == 0) {
            bVar.m(tokeniserState);
            aVar.advance();
            bVar.f((char) 65533);
        } else if (cCurrent == '<') {
            bVar.a(tokeniserState2);
        } else if (cCurrent != 65535) {
            bVar.g(aVar.consumeToAny('<', 0));
        } else {
            bVar.h(new Token.e());
        }
    }

    public static void b(b bVar, gh.a aVar, TokeniserState tokeniserState) throws IOException {
        boolean z10;
        boolean zJ = aVar.j();
        StringBuilder sb2 = bVar.f17301h;
        if (zJ) {
            String strD = aVar.d();
            bVar.f17302i.l(strD);
            sb2.append(strD);
            return;
        }
        if (!bVar.n() || aVar.isEmpty()) {
            z10 = true;
        } else {
            char c10 = aVar.c();
            if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
                bVar.f17296c = S;
            } else if (c10 == '/') {
                bVar.f17296c = f17235a0;
            } else if (c10 != '>') {
                sb2.append(c10);
                z10 = true;
            } else {
                bVar.k();
                bVar.f17296c = f17236b;
            }
            z10 = false;
        }
        if (z10) {
            bVar.g("</" + sb2.toString());
            bVar.f17296c = tokeniserState;
        }
    }

    public static void c(b bVar, gh.a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) throws IOException {
        boolean zJ = aVar.j();
        StringBuilder sb2 = bVar.f17301h;
        if (zJ) {
            String strD = aVar.d();
            sb2.append(strD);
            bVar.g(strD);
            return;
        }
        char c10 = aVar.c();
        if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ' && c10 != '/' && c10 != '>') {
            aVar.l();
            bVar.f17296c = tokeniserState2;
        } else {
            if (sb2.toString().equals("script")) {
                bVar.f17296c = tokeniserState;
            } else {
                bVar.f17296c = tokeniserState2;
            }
            bVar.f(c10);
        }
    }

    public static TokeniserState valueOf(String str) {
        return (TokeniserState) Enum.valueOf(TokeniserState.class, str);
    }

    public static TokeniserState[] values() {
        return (TokeniserState[]) F0.clone();
    }

    public abstract void d(b bVar, gh.a aVar);
}
