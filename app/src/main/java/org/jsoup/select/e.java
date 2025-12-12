package org.jsoup.select;

import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.select.Selector;
import org.jsoup.select.b;
import org.jsoup.select.c;
import org.jsoup.select.f;

/* compiled from: QueryParser.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f17352d = {",", ">", "+", "~", StringUtils.SPACE};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f17353e = {"=", "!=", "^=", "$=", "*=", "~="};

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f17354f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f17355g = Pattern.compile("([+-])?(\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final gh.f f17356a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17357b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f17358c = new ArrayList();

    public e(String str) {
        this.f17357b = str;
        this.f17356a = new gh.f(str);
    }

    public static c parse(String str) {
        try {
            return new e(str).g();
        } catch (IllegalArgumentException e10) {
            throw new Selector.SelectorParseException(e10.getMessage(), new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(char r11) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.e.a(char):void");
    }

    public final int b() {
        String strTrim = this.f17356a.chompTo(")").trim();
        dh.f.isTrue(dh.e.isNumeric(strTrim), "Index must be numeric");
        return Integer.parseInt(strTrim);
    }

    public final void c(boolean z10) {
        String str = z10 ? ":containsOwn" : ":contains";
        gh.f fVar = this.f17356a;
        fVar.consume(str);
        String strUnescape = gh.f.unescape(fVar.chompBalanced('(', ')'));
        dh.f.notEmpty(strUnescape, ":contains(text) query must not be empty");
        ArrayList arrayList = this.f17358c;
        if (z10) {
            arrayList.add(new c.m(strUnescape));
        } else {
            arrayList.add(new c.n(strUnescape));
        }
    }

    public final void d(boolean z10, boolean z11) throws NumberFormatException {
        String strNormalize = eh.b.normalize(this.f17356a.chompTo(")"));
        Matcher matcher = f17354f.matcher(strNormalize);
        Matcher matcher2 = f17355g.matcher(strNormalize);
        int i10 = 2;
        int i11 = 1;
        if (!"odd".equals(strNormalize)) {
            if ("even".equals(strNormalize)) {
                i11 = 0;
            } else if (matcher.matches()) {
                int i12 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                i11 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i10 = i12;
            } else {
                if (!matcher2.matches()) {
                    throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", strNormalize);
                }
                i11 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i10 = 0;
            }
        }
        ArrayList arrayList = this.f17358c;
        if (z11) {
            if (z10) {
                arrayList.add(new c.b0(i10, i11));
                return;
            } else {
                arrayList.add(new c.c0(i10, i11));
                return;
            }
        }
        if (z10) {
            arrayList.add(new c.a0(i10, i11));
        } else {
            arrayList.add(new c.z(i10, i11));
        }
    }

    public final void e() throws NumberFormatException {
        gh.f fVar = this.f17356a;
        boolean zMatchChomp = fVar.matchChomp("#");
        ArrayList arrayList = this.f17358c;
        if (zMatchChomp) {
            String strConsumeCssIdentifier = fVar.consumeCssIdentifier();
            dh.f.notEmpty(strConsumeCssIdentifier);
            arrayList.add(new c.p(strConsumeCssIdentifier));
            return;
        }
        if (fVar.matchChomp(".")) {
            String strConsumeCssIdentifier2 = fVar.consumeCssIdentifier();
            dh.f.notEmpty(strConsumeCssIdentifier2);
            arrayList.add(new c.k(strConsumeCssIdentifier2.trim()));
            return;
        }
        if (fVar.matchesWord() || fVar.matches("*|")) {
            String strConsumeElementSelector = fVar.consumeElementSelector();
            dh.f.notEmpty(strConsumeElementSelector);
            if (strConsumeElementSelector.startsWith("*|")) {
                arrayList.add(new b.C0215b(new c.j0(eh.b.normalize(strConsumeElementSelector)), new c.k0(eh.b.normalize(strConsumeElementSelector.replace("*|", ":")))));
                return;
            }
            if (strConsumeElementSelector.contains("|")) {
                strConsumeElementSelector = strConsumeElementSelector.replace("|", ":");
            }
            arrayList.add(new c.j0(strConsumeElementSelector.trim()));
            return;
        }
        boolean zMatches = fVar.matches("[");
        String str = this.f17357b;
        if (zMatches) {
            gh.f fVar2 = new gh.f(fVar.chompBalanced('[', ']'));
            String strConsumeToAny = fVar2.consumeToAny(f17353e);
            dh.f.notEmpty(strConsumeToAny);
            fVar2.consumeWhitespace();
            if (fVar2.isEmpty()) {
                if (strConsumeToAny.startsWith("^")) {
                    arrayList.add(new c.d(strConsumeToAny.substring(1)));
                    return;
                } else {
                    arrayList.add(new c.b(strConsumeToAny));
                    return;
                }
            }
            if (fVar2.matchChomp("=")) {
                arrayList.add(new c.e(strConsumeToAny, fVar2.remainder()));
                return;
            }
            if (fVar2.matchChomp("!=")) {
                arrayList.add(new c.i(strConsumeToAny, fVar2.remainder()));
                return;
            }
            if (fVar2.matchChomp("^=")) {
                arrayList.add(new c.j(strConsumeToAny, fVar2.remainder()));
                return;
            }
            if (fVar2.matchChomp("$=")) {
                arrayList.add(new c.g(strConsumeToAny, fVar2.remainder()));
                return;
            } else if (fVar2.matchChomp("*=")) {
                arrayList.add(new c.f(strConsumeToAny, fVar2.remainder()));
                return;
            } else {
                if (!fVar2.matchChomp("~=")) {
                    throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", str, fVar2.remainder());
                }
                arrayList.add(new c.h(strConsumeToAny, Pattern.compile(fVar2.remainder())));
                return;
            }
        }
        if (fVar.matchChomp("*")) {
            arrayList.add(new c.a());
            return;
        }
        if (fVar.matchChomp(":lt(")) {
            arrayList.add(new c.t(b()));
            return;
        }
        if (fVar.matchChomp(":gt(")) {
            arrayList.add(new c.s(b()));
            return;
        }
        if (fVar.matchChomp(":eq(")) {
            arrayList.add(new c.q(b()));
            return;
        }
        if (fVar.matches(":has(")) {
            fVar.consume(":has");
            String strChompBalanced = fVar.chompBalanced('(', ')');
            dh.f.notEmpty(strChompBalanced, ":has(el) subselect must not be empty");
            arrayList.add(new f.a(parse(strChompBalanced)));
            return;
        }
        if (fVar.matches(":contains(")) {
            c(false);
            return;
        }
        if (fVar.matches(":containsOwn(")) {
            c(true);
            return;
        }
        if (fVar.matches(":containsData(")) {
            fVar.consume(":containsData");
            String strUnescape = gh.f.unescape(fVar.chompBalanced('(', ')'));
            dh.f.notEmpty(strUnescape, ":containsData(text) query must not be empty");
            arrayList.add(new c.l(strUnescape));
            return;
        }
        if (fVar.matches(":matches(")) {
            f(false);
            return;
        }
        if (fVar.matches(":matchesOwn(")) {
            f(true);
            return;
        }
        if (fVar.matches(":not(")) {
            fVar.consume(":not");
            String strChompBalanced2 = fVar.chompBalanced('(', ')');
            dh.f.notEmpty(strChompBalanced2, ":not(selector) subselect must not be empty");
            arrayList.add(new f.d(parse(strChompBalanced2)));
            return;
        }
        if (fVar.matchChomp(":nth-child(")) {
            d(false, false);
            return;
        }
        if (fVar.matchChomp(":nth-last-child(")) {
            d(true, false);
            return;
        }
        if (fVar.matchChomp(":nth-of-type(")) {
            d(false, true);
            return;
        }
        if (fVar.matchChomp(":nth-last-of-type(")) {
            d(true, true);
            return;
        }
        if (fVar.matchChomp(":first-child")) {
            arrayList.add(new c.v());
            return;
        }
        if (fVar.matchChomp(":last-child")) {
            arrayList.add(new c.x());
            return;
        }
        if (fVar.matchChomp(":first-of-type")) {
            arrayList.add(new c.w());
            return;
        }
        if (fVar.matchChomp(":last-of-type")) {
            arrayList.add(new c.y());
            return;
        }
        if (fVar.matchChomp(":only-child")) {
            arrayList.add(new c.d0());
            return;
        }
        if (fVar.matchChomp(":only-of-type")) {
            arrayList.add(new c.e0());
            return;
        }
        if (fVar.matchChomp(":empty")) {
            arrayList.add(new c.u());
        } else if (fVar.matchChomp(":root")) {
            arrayList.add(new c.f0());
        } else {
            if (!fVar.matchChomp(":matchText")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", str, fVar.remainder());
            }
            arrayList.add(new c.g0());
        }
    }

    public final void f(boolean z10) {
        String str = z10 ? ":matchesOwn" : ":matches";
        gh.f fVar = this.f17356a;
        fVar.consume(str);
        String strChompBalanced = fVar.chompBalanced('(', ')');
        dh.f.notEmpty(strChompBalanced, ":matches(regex) query must not be empty");
        ArrayList arrayList = this.f17358c;
        if (z10) {
            arrayList.add(new c.i0(Pattern.compile(strChompBalanced)));
        } else {
            arrayList.add(new c.h0(Pattern.compile(strChompBalanced)));
        }
    }

    public final c g() throws NumberFormatException {
        gh.f fVar = this.f17356a;
        fVar.consumeWhitespace();
        String[] strArr = f17352d;
        boolean zMatchesAny = fVar.matchesAny(strArr);
        ArrayList arrayList = this.f17358c;
        if (zMatchesAny) {
            arrayList.add(new f.g());
            a(fVar.consume());
        } else {
            e();
        }
        while (!fVar.isEmpty()) {
            boolean zConsumeWhitespace = fVar.consumeWhitespace();
            if (fVar.matchesAny(strArr)) {
                a(fVar.consume());
            } else if (zConsumeWhitespace) {
                a(TokenParser.SP);
            } else {
                e();
            }
        }
        return arrayList.size() == 1 ? (c) arrayList.get(0) : new b.a(arrayList);
    }
}
