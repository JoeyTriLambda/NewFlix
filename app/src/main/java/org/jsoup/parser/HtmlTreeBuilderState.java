package org.jsoup.parser;

import com.unity3d.ads.metadata.MediationMetaData;
import dh.e;
import dh.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;
import org.jsoup.parser.Token;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
abstract class HtmlTreeBuilderState {
    public static final AnonymousClass16 A;
    public static final AnonymousClass17 B;
    public static final AnonymousClass18 C;
    public static final AnonymousClass19 D;
    public static final AnonymousClass20 E;
    public static final AnonymousClass21 F;
    public static final AnonymousClass22 G;
    public static final String H;
    public static final /* synthetic */ HtmlTreeBuilderState[] I;

    /* renamed from: b, reason: collision with root package name */
    public static final AnonymousClass1 f17177b;

    /* renamed from: m, reason: collision with root package name */
    public static final AnonymousClass2 f17178m;

    /* renamed from: n, reason: collision with root package name */
    public static final AnonymousClass3 f17179n;

    /* renamed from: o, reason: collision with root package name */
    public static final AnonymousClass4 f17180o;

    /* renamed from: p, reason: collision with root package name */
    public static final AnonymousClass5 f17181p;

    /* renamed from: q, reason: collision with root package name */
    public static final AnonymousClass6 f17182q;

    /* renamed from: r, reason: collision with root package name */
    public static final AnonymousClass7 f17183r;

    /* renamed from: s, reason: collision with root package name */
    public static final AnonymousClass8 f17184s;

    /* renamed from: t, reason: collision with root package name */
    public static final AnonymousClass9 f17185t;

    /* renamed from: u, reason: collision with root package name */
    public static final AnonymousClass10 f17186u;

    /* renamed from: v, reason: collision with root package name */
    public static final AnonymousClass11 f17187v;

    /* renamed from: w, reason: collision with root package name */
    public static final AnonymousClass12 f17188w;

    /* renamed from: x, reason: collision with root package name */
    public static final AnonymousClass13 f17189x;

    /* renamed from: y, reason: collision with root package name */
    public static final AnonymousClass14 f17190y;

    /* renamed from: z, reason: collision with root package name */
    public static final AnonymousClass15 f17191z;

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$7, reason: invalid class name */
    public enum AnonymousClass7 extends HtmlTreeBuilderState {
        public AnonymousClass7() {
            super("InBody", 6);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public final boolean c(Token token, org.jsoup.parser.a aVar) throws IOException {
            Element element;
            boolean z10;
            Element element2;
            boolean z11;
            boolean z12;
            int iOrdinal = token.f17210a.ordinal();
            if (iOrdinal == 0) {
                aVar.e(this);
                return false;
            }
            String[] strArr = a.f17199h;
            String[] strArr2 = a.f17194c;
            String[] strArr3 = a.f17197f;
            String[] strArr4 = org.jsoup.parser.a.B;
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        aVar.p((Token.c) token);
                        return true;
                    }
                    if (iOrdinal != 4) {
                        return true;
                    }
                    Token.b bVar = (Token.b) token;
                    if (bVar.f17218b.equals(HtmlTreeBuilderState.H)) {
                        aVar.e(this);
                        return false;
                    }
                    if (aVar.f17289s && HtmlTreeBuilderState.a(bVar)) {
                        aVar.y();
                        aVar.o(bVar);
                        return true;
                    }
                    aVar.y();
                    aVar.o(bVar);
                    aVar.f17289s = false;
                    return true;
                }
                Token.f fVar = (Token.f) token;
                String str = fVar.f17227c;
                if (!e.inSorted(str, a.f17207p)) {
                    if (e.inSorted(str, a.f17206o)) {
                        if (!aVar.j(str, null)) {
                            aVar.e(this);
                            return false;
                        }
                        if (!ac.c.z(aVar, str)) {
                            aVar.e(this);
                        }
                        aVar.v(str);
                        return true;
                    }
                    if (str.equals("span")) {
                        return d(token, aVar);
                    }
                    if (str.equals("li")) {
                        if (!aVar.j(str, org.jsoup.parser.a.f17277w)) {
                            aVar.e(this);
                            return false;
                        }
                        aVar.f(str);
                        if (!aVar.currentElement().nodeName().equals(str)) {
                            aVar.e(this);
                        }
                        aVar.v(str);
                        return true;
                    }
                    if (str.equals("body")) {
                        if (aVar.j("body", null)) {
                            aVar.f17281k = HtmlTreeBuilderState.C;
                            return true;
                        }
                        aVar.e(this);
                        return false;
                    }
                    if (str.equals("html")) {
                        if (aVar.processEndTag("body")) {
                            return aVar.process(fVar);
                        }
                        return true;
                    }
                    if (str.equals("form")) {
                        Element element3 = aVar.f17285o;
                        aVar.f17285o = null;
                        if (element3 == null || !aVar.j(str, null)) {
                            aVar.e(this);
                            return false;
                        }
                        if (!ac.c.z(aVar, str)) {
                            aVar.e(this);
                        }
                        aVar.A(element3);
                        return true;
                    }
                    if (str.equals("p")) {
                        if (!aVar.i(str)) {
                            aVar.e(this);
                            aVar.processStartTag(str);
                            return aVar.process(fVar);
                        }
                        aVar.f(str);
                        if (!aVar.currentElement().nodeName().equals(str)) {
                            aVar.e(this);
                        }
                        aVar.v(str);
                        return true;
                    }
                    if (e.inSorted(str, strArr3)) {
                        if (!aVar.j(str, null)) {
                            aVar.e(this);
                            return false;
                        }
                        aVar.f(str);
                        if (!aVar.currentElement().nodeName().equals(str)) {
                            aVar.e(this);
                        }
                        aVar.v(str);
                        return true;
                    }
                    if (e.inSorted(str, strArr2)) {
                        if (!aVar.l(strArr2, org.jsoup.parser.a.f17276v, null)) {
                            aVar.e(this);
                            return false;
                        }
                        aVar.f(str);
                        if (!aVar.currentElement().nodeName().equals(str)) {
                            aVar.e(this);
                        }
                        int size = aVar.f17314d.size();
                        do {
                            size--;
                            if (size < 0) {
                                return true;
                            }
                            element = aVar.f17314d.get(size);
                            aVar.f17314d.remove(size);
                        } while (!e.inSorted(element.nodeName(), strArr2));
                        return true;
                    }
                    if (str.equals("sarcasm")) {
                        return d(token, aVar);
                    }
                    if (!e.inSorted(str, strArr)) {
                        if (!str.equals("br")) {
                            return d(token, aVar);
                        }
                        aVar.e(this);
                        aVar.processStartTag("br");
                        return false;
                    }
                    if (aVar.j(MediationMetaData.KEY_NAME, null)) {
                        return true;
                    }
                    if (!aVar.j(str, null)) {
                        aVar.e(this);
                        return false;
                    }
                    if (!ac.c.z(aVar, str)) {
                        aVar.e(this);
                    }
                    aVar.v(str);
                    aVar.c();
                    return true;
                }
                for (int i10 = 0; i10 < 8; i10++) {
                    Element elementG = aVar.g(str);
                    if (elementG == null) {
                        return d(token, aVar);
                    }
                    ArrayList<Element> arrayList = aVar.f17314d;
                    int size2 = arrayList.size() - 1;
                    while (true) {
                        if (size2 < 0) {
                            z10 = false;
                            break;
                        }
                        if (arrayList.get(size2) == elementG) {
                            z10 = true;
                            break;
                        }
                        size2--;
                    }
                    if (!z10) {
                        aVar.e(this);
                        aVar.z(elementG);
                        return true;
                    }
                    if (!aVar.j(elementG.nodeName(), null)) {
                        aVar.e(this);
                        return false;
                    }
                    if (aVar.currentElement() != elementG) {
                        aVar.e(this);
                    }
                    ArrayList<Element> arrayList2 = aVar.f17314d;
                    int size3 = arrayList2.size();
                    Element element4 = null;
                    boolean z13 = false;
                    for (int i11 = 0; i11 < size3 && i11 < 64; i11++) {
                        element2 = arrayList2.get(i11);
                        if (element2 != elementG) {
                            if (z13 && e.inSorted(element2.nodeName(), strArr4)) {
                                break;
                            }
                        } else {
                            element4 = arrayList2.get(i11 - 1);
                            z13 = true;
                        }
                    }
                    element2 = null;
                    if (element2 == null) {
                        aVar.v(elementG.nodeName());
                        aVar.z(elementG);
                        return true;
                    }
                    int i12 = 1;
                    int i13 = 0;
                    Element elementB = element2;
                    Element element5 = elementB;
                    while (i13 < 3) {
                        ArrayList<Element> arrayList3 = aVar.f17314d;
                        int size4 = arrayList3.size() - i12;
                        while (true) {
                            if (size4 < 0) {
                                z11 = false;
                                break;
                            }
                            if (arrayList3.get(size4) == elementB) {
                                z11 = true;
                                break;
                            }
                            size4--;
                        }
                        if (z11) {
                            elementB = aVar.b(elementB);
                        }
                        ArrayList<Element> arrayList4 = aVar.f17286p;
                        int size5 = arrayList4.size() - 1;
                        while (true) {
                            if (size5 < 0) {
                                z12 = false;
                                break;
                            }
                            if (arrayList4.get(size5) == elementB) {
                                z12 = true;
                                break;
                            }
                            size5--;
                        }
                        if (!z12) {
                            aVar.A(elementB);
                        } else {
                            if (elementB == elementG) {
                                break;
                            }
                            Element element6 = new Element(gh.e.valueOf(elementB.nodeName(), gh.c.f12844d), aVar.f17315e);
                            ArrayList<Element> arrayList5 = aVar.f17286p;
                            int iLastIndexOf = arrayList5.lastIndexOf(elementB);
                            f.isTrue(iLastIndexOf != -1);
                            arrayList5.set(iLastIndexOf, element6);
                            ArrayList<Element> arrayList6 = aVar.f17314d;
                            int iLastIndexOf2 = arrayList6.lastIndexOf(elementB);
                            f.isTrue(iLastIndexOf2 != -1);
                            arrayList6.set(iLastIndexOf2, element6);
                            if (element5.parent() != null) {
                                element5.remove();
                            }
                            element6.appendChild(element5);
                            elementB = element6;
                            element5 = elementB;
                        }
                        i13++;
                        i12 = 1;
                    }
                    if (e.inSorted(element4.nodeName(), a.f17208q)) {
                        if (element5.parent() != null) {
                            element5.remove();
                        }
                        aVar.s(element5);
                    } else {
                        if (element5.parent() != null) {
                            element5.remove();
                        }
                        element4.appendChild(element5);
                    }
                    Element element7 = new Element(elementG.tag(), aVar.f17315e);
                    element7.attributes().addAll(elementG.attributes());
                    for (g gVar : (g[]) element2.childNodes().toArray(new g[element2.childNodeSize()])) {
                        element7.appendChild(gVar);
                    }
                    element2.appendChild(element7);
                    aVar.z(elementG);
                    aVar.A(elementG);
                    int iLastIndexOf3 = aVar.f17314d.lastIndexOf(element2);
                    f.isTrue(iLastIndexOf3 != -1);
                    aVar.f17314d.add(iLastIndexOf3 + 1, element7);
                }
                return true;
            }
            Token.g gVar2 = (Token.g) token;
            String str2 = gVar2.f17227c;
            if (str2.equals("a")) {
                if (aVar.g("a") != null) {
                    aVar.e(this);
                    aVar.processEndTag("a");
                    Element elementH = aVar.h("a");
                    if (elementH != null) {
                        aVar.z(elementH);
                        aVar.A(elementH);
                    }
                }
                aVar.y();
                aVar.x(aVar.n(gVar2));
                return true;
            }
            if (e.inSorted(str2, a.f17200i)) {
                aVar.y();
                aVar.q(gVar2);
                aVar.f17289s = false;
                return true;
            }
            if (e.inSorted(str2, a.f17193b)) {
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.n(gVar2);
                return true;
            }
            if (str2.equals("span")) {
                aVar.y();
                aVar.n(gVar2);
                return true;
            }
            boolean zEquals = str2.equals("li");
            String[] strArr5 = a.f17196e;
            if (zEquals) {
                aVar.f17289s = false;
                ArrayList<Element> arrayList7 = aVar.f17314d;
                int size6 = arrayList7.size() - 1;
                while (true) {
                    if (size6 <= 0) {
                        break;
                    }
                    Element element8 = arrayList7.get(size6);
                    if (element8.nodeName().equals("li")) {
                        aVar.processEndTag("li");
                        break;
                    }
                    if (e.inSorted(element8.nodeName(), strArr4) && !e.inSorted(element8.nodeName(), strArr5)) {
                        break;
                    }
                    size6--;
                }
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.n(gVar2);
                return true;
            }
            if (str2.equals("html")) {
                aVar.e(this);
                Element element9 = aVar.f17314d.get(0);
                Iterator<org.jsoup.nodes.a> it = gVar2.f17234j.iterator();
                while (it.hasNext()) {
                    org.jsoup.nodes.a next = it.next();
                    if (!element9.hasAttr(next.getKey())) {
                        element9.attributes().put(next);
                    }
                }
                return true;
            }
            if (e.inSorted(str2, a.f17192a)) {
                return aVar.w(token, HtmlTreeBuilderState.f17180o);
            }
            if (str2.equals("body")) {
                aVar.e(this);
                ArrayList<Element> arrayList8 = aVar.f17314d;
                if (arrayList8.size() == 1) {
                    return false;
                }
                if (arrayList8.size() > 2 && !arrayList8.get(1).nodeName().equals("body")) {
                    return false;
                }
                aVar.f17289s = false;
                Element element10 = arrayList8.get(1);
                Iterator<org.jsoup.nodes.a> it2 = gVar2.f17234j.iterator();
                while (it2.hasNext()) {
                    org.jsoup.nodes.a next2 = it2.next();
                    if (!element10.hasAttr(next2.getKey())) {
                        element10.attributes().put(next2);
                    }
                }
                return true;
            }
            if (str2.equals("frameset")) {
                aVar.e(this);
                ArrayList<Element> arrayList9 = aVar.f17314d;
                if (arrayList9.size() == 1) {
                    return false;
                }
                if ((arrayList9.size() > 2 && !arrayList9.get(1).nodeName().equals("body")) || !aVar.f17289s) {
                    return false;
                }
                Element element11 = arrayList9.get(1);
                if (element11.parent() != null) {
                    element11.remove();
                }
                for (int i14 = 1; arrayList9.size() > i14; i14 = 1) {
                    arrayList9.remove(arrayList9.size() - i14);
                }
                aVar.n(gVar2);
                aVar.f17281k = HtmlTreeBuilderState.D;
                return true;
            }
            if (e.inSorted(str2, strArr2)) {
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                if (e.inSorted(aVar.currentElement().nodeName(), strArr2)) {
                    aVar.e(this);
                    aVar.u();
                }
                aVar.n(gVar2);
                return true;
            }
            if (e.inSorted(str2, a.f17195d)) {
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.n(gVar2);
                aVar.f17311a.f(StringUtils.LF);
                aVar.f17289s = false;
                return true;
            }
            if (str2.equals("form")) {
                if (aVar.f17285o != null) {
                    aVar.e(this);
                    return false;
                }
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.r(gVar2, true);
                return true;
            }
            if (e.inSorted(str2, strArr3)) {
                aVar.f17289s = false;
                ArrayList<Element> arrayList10 = aVar.f17314d;
                int size7 = arrayList10.size() - 1;
                while (true) {
                    if (size7 <= 0) {
                        break;
                    }
                    Element element12 = arrayList10.get(size7);
                    if (e.inSorted(element12.nodeName(), strArr3)) {
                        aVar.processEndTag(element12.nodeName());
                        break;
                    }
                    if (e.inSorted(element12.nodeName(), strArr4) && !e.inSorted(element12.nodeName(), strArr5)) {
                        break;
                    }
                    size7--;
                }
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.n(gVar2);
                return true;
            }
            if (str2.equals("plaintext")) {
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.n(gVar2);
                aVar.f17312b.f17296c = TokeniserState.f17258r;
                return true;
            }
            if (str2.equals("button")) {
                if (aVar.i("button")) {
                    aVar.e(this);
                    aVar.processEndTag("button");
                    aVar.process(gVar2);
                    return true;
                }
                aVar.y();
                aVar.n(gVar2);
                aVar.f17289s = false;
                return true;
            }
            if (e.inSorted(str2, a.f17198g)) {
                aVar.y();
                aVar.x(aVar.n(gVar2));
                return true;
            }
            if (str2.equals("nobr")) {
                aVar.y();
                if (aVar.j("nobr", null)) {
                    aVar.e(this);
                    aVar.processEndTag("nobr");
                    aVar.y();
                }
                aVar.x(aVar.n(gVar2));
                return true;
            }
            if (e.inSorted(str2, strArr)) {
                aVar.y();
                aVar.n(gVar2);
                aVar.f17286p.add(null);
                aVar.f17289s = false;
                return true;
            }
            boolean zEquals2 = str2.equals("table");
            AnonymousClass9 anonymousClass9 = HtmlTreeBuilderState.f17185t;
            if (zEquals2) {
                if (aVar.f17313c.quirksMode() != Document.QuirksMode.quirks && aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.n(gVar2);
                aVar.f17289s = false;
                aVar.f17281k = anonymousClass9;
                return true;
            }
            if (str2.equals("input")) {
                aVar.y();
                if (aVar.q(gVar2).attr("type").equalsIgnoreCase("hidden")) {
                    return true;
                }
                aVar.f17289s = false;
                return true;
            }
            if (e.inSorted(str2, a.f17201j)) {
                aVar.q(gVar2);
                return true;
            }
            if (str2.equals("hr")) {
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.q(gVar2);
                aVar.f17289s = false;
                return true;
            }
            if (str2.equals("image")) {
                if (aVar.h("svg") == null) {
                    gVar2.n("img");
                    return aVar.process(gVar2);
                }
                aVar.n(gVar2);
                return true;
            }
            if (str2.equals("isindex")) {
                aVar.e(this);
                if (aVar.f17285o != null) {
                    return false;
                }
                aVar.processStartTag("form");
                if (gVar2.f17234j.hasKey("action")) {
                    aVar.f17285o.attr("action", gVar2.f17234j.get("action"));
                }
                aVar.processStartTag("hr");
                aVar.processStartTag("label");
                String str3 = gVar2.f17234j.hasKey("prompt") ? gVar2.f17234j.get("prompt") : "This is a searchable index. Enter search keywords: ";
                Token.b bVar2 = new Token.b();
                bVar2.f17218b = str3;
                aVar.process(bVar2);
                org.jsoup.nodes.b bVar3 = new org.jsoup.nodes.b();
                Iterator<org.jsoup.nodes.a> it3 = gVar2.f17234j.iterator();
                while (it3.hasNext()) {
                    org.jsoup.nodes.a next3 = it3.next();
                    if (!e.inSorted(next3.getKey(), a.f17202k)) {
                        bVar3.put(next3);
                    }
                }
                bVar3.put(MediationMetaData.KEY_NAME, "isindex");
                aVar.processStartTag("input", bVar3);
                aVar.processEndTag("label");
                aVar.processStartTag("hr");
                aVar.processEndTag("form");
                return true;
            }
            if (str2.equals("textarea")) {
                aVar.n(gVar2);
                aVar.f17312b.f17296c = TokeniserState.f17250n;
                aVar.f17282l = aVar.f17281k;
                aVar.f17289s = false;
                aVar.f17281k = HtmlTreeBuilderState.f17184s;
                return true;
            }
            if (str2.equals("xmp")) {
                if (aVar.i("p")) {
                    aVar.processEndTag("p");
                }
                aVar.y();
                aVar.f17289s = false;
                HtmlTreeBuilderState.b(gVar2, aVar);
                return true;
            }
            if (str2.equals("iframe")) {
                aVar.f17289s = false;
                HtmlTreeBuilderState.b(gVar2, aVar);
                return true;
            }
            if (str2.equals("noembed")) {
                HtmlTreeBuilderState.b(gVar2, aVar);
                return true;
            }
            if (str2.equals("select")) {
                aVar.y();
                aVar.n(gVar2);
                aVar.f17289s = false;
                HtmlTreeBuilderState htmlTreeBuilderState = aVar.f17281k;
                if (htmlTreeBuilderState.equals(anonymousClass9) || htmlTreeBuilderState.equals(HtmlTreeBuilderState.f17187v) || htmlTreeBuilderState.equals(HtmlTreeBuilderState.f17189x) || htmlTreeBuilderState.equals(HtmlTreeBuilderState.f17190y) || htmlTreeBuilderState.equals(HtmlTreeBuilderState.f17191z)) {
                    aVar.f17281k = HtmlTreeBuilderState.B;
                    return true;
                }
                aVar.f17281k = HtmlTreeBuilderState.A;
                return true;
            }
            if (e.inSorted(str2, a.f17203l)) {
                if (ac.c.z(aVar, "option")) {
                    aVar.processEndTag("option");
                }
                aVar.y();
                aVar.n(gVar2);
                return true;
            }
            if (e.inSorted(str2, a.f17204m)) {
                if (!aVar.j("ruby", null)) {
                    return true;
                }
                if (!ac.c.z(aVar, "ruby")) {
                    aVar.e(this);
                    int size8 = aVar.f17314d.size();
                    while (true) {
                        size8--;
                        if (size8 < 0 || aVar.f17314d.get(size8).nodeName().equals("ruby")) {
                            break;
                        }
                        aVar.f17314d.remove(size8);
                    }
                }
                aVar.n(gVar2);
                return true;
            }
            if (str2.equals("math")) {
                aVar.y();
                aVar.n(gVar2);
                return true;
            }
            if (str2.equals("svg")) {
                aVar.y();
                aVar.n(gVar2);
                return true;
            }
            if (e.inSorted(str2, a.f17205n)) {
                aVar.e(this);
                return false;
            }
            aVar.y();
            aVar.n(gVar2);
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean d(org.jsoup.parser.Token r6, org.jsoup.parser.a r7) {
            /*
                r5 = this;
                gh.c r0 = r7.f17318h
                r6.getClass()
                org.jsoup.parser.Token$f r6 = (org.jsoup.parser.Token.f) r6
                java.lang.String r6 = r6.m()
                java.lang.String r6 = r0.a(r6)
                java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.f17314d
                int r1 = r0.size()
                r2 = 1
                int r1 = r1 - r2
            L17:
                if (r1 < 0) goto L55
                java.lang.Object r3 = r0.get(r1)
                org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
                java.lang.String r4 = r3.nodeName()
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L41
                r7.f(r6)
                org.jsoup.nodes.Element r0 = r7.currentElement()
                java.lang.String r0 = r0.nodeName()
                boolean r0 = r6.equals(r0)
                if (r0 != 0) goto L3d
                r7.e(r5)
            L3d:
                r7.v(r6)
                goto L55
            L41:
                java.lang.String r3 = r3.nodeName()
                java.lang.String[] r4 = org.jsoup.parser.a.B
                boolean r3 = dh.e.inSorted(r3, r4)
                if (r3 == 0) goto L52
                r7.e(r5)
                r6 = 0
                return r6
            L52:
                int r1 = r1 + (-1)
                goto L17
            L55:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.d(org.jsoup.parser.Token, org.jsoup.parser.a):boolean");
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f17192a = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f17193b = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f17194c = {"h1", "h2", "h3", "h4", "h5", "h6"};

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f17195d = {"listing", "pre"};

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f17196e = {"address", "div", "p"};

        /* renamed from: f, reason: collision with root package name */
        public static final String[] f17197f = {"dd", "dt"};

        /* renamed from: g, reason: collision with root package name */
        public static final String[] f17198g = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};

        /* renamed from: h, reason: collision with root package name */
        public static final String[] f17199h = {"applet", "marquee", "object"};

        /* renamed from: i, reason: collision with root package name */
        public static final String[] f17200i = {"area", "br", "embed", "img", "keygen", "wbr"};

        /* renamed from: j, reason: collision with root package name */
        public static final String[] f17201j = {"param", "source", "track"};

        /* renamed from: k, reason: collision with root package name */
        public static final String[] f17202k = {"action", MediationMetaData.KEY_NAME, "prompt"};

        /* renamed from: l, reason: collision with root package name */
        public static final String[] f17203l = {"optgroup", "option"};

        /* renamed from: m, reason: collision with root package name */
        public static final String[] f17204m = {"rp", "rt"};

        /* renamed from: n, reason: collision with root package name */
        public static final String[] f17205n = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};

        /* renamed from: o, reason: collision with root package name */
        public static final String[] f17206o = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};

        /* renamed from: p, reason: collision with root package name */
        public static final String[] f17207p = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};

        /* renamed from: q, reason: collision with root package name */
        public static final String[] f17208q = {"table", "tbody", "tfoot", "thead", "tr"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [org.jsoup.parser.HtmlTreeBuilderState$1] */
    /* JADX WARN: Type inference failed for: r10v0, types: [org.jsoup.parser.HtmlTreeBuilderState$11] */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.jsoup.parser.HtmlTreeBuilderState$12] */
    /* JADX WARN: Type inference failed for: r12v0, types: [org.jsoup.parser.HtmlTreeBuilderState$13] */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.jsoup.parser.HtmlTreeBuilderState$14] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.jsoup.parser.HtmlTreeBuilderState$15] */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.jsoup.parser.HtmlTreeBuilderState$16] */
    /* JADX WARN: Type inference failed for: r16v0, types: [org.jsoup.parser.HtmlTreeBuilderState$17] */
    /* JADX WARN: Type inference failed for: r17v0, types: [org.jsoup.parser.HtmlTreeBuilderState$18] */
    /* JADX WARN: Type inference failed for: r18v0, types: [org.jsoup.parser.HtmlTreeBuilderState$19] */
    /* JADX WARN: Type inference failed for: r19v0, types: [org.jsoup.parser.HtmlTreeBuilderState$20] */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.jsoup.parser.HtmlTreeBuilderState$2] */
    /* JADX WARN: Type inference failed for: r20v0, types: [org.jsoup.parser.HtmlTreeBuilderState$21] */
    /* JADX WARN: Type inference failed for: r21v0, types: [org.jsoup.parser.HtmlTreeBuilderState$22] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.jsoup.parser.HtmlTreeBuilderState$3] */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.jsoup.parser.HtmlTreeBuilderState$4] */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.jsoup.parser.HtmlTreeBuilderState$5] */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.jsoup.parser.HtmlTreeBuilderState$6] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.jsoup.parser.HtmlTreeBuilderState$8] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.jsoup.parser.HtmlTreeBuilderState$9] */
    /* JADX WARN: Type inference failed for: r9v0, types: [org.jsoup.parser.HtmlTreeBuilderState$10] */
    static {
        ?? r02 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (HtmlTreeBuilderState.a(token)) {
                    return true;
                }
                if (token.a()) {
                    aVar.p((Token.c) token);
                } else {
                    boolean zB = token.b();
                    AnonymousClass2 anonymousClass2 = HtmlTreeBuilderState.f17178m;
                    if (!zB) {
                        aVar.f17281k = anonymousClass2;
                        return aVar.process(token);
                    }
                    Token.d dVar = (Token.d) token;
                    org.jsoup.nodes.f fVar = new org.jsoup.nodes.f(aVar.f17318h.a(dVar.f17221b.toString()), dVar.f17223d.toString(), dVar.getSystemIdentifier());
                    fVar.setPubSysKey(dVar.f17222c);
                    aVar.f17313c.appendChild(fVar);
                    if (dVar.isForceQuirks()) {
                        aVar.f17313c.quirksMode(Document.QuirksMode.quirks);
                    }
                    aVar.f17281k = anonymousClass2;
                }
                return true;
            }
        };
        f17177b = r02;
        ?? r12 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.b()) {
                    aVar.e(this);
                    return false;
                }
                if (!token.a()) {
                    if (HtmlTreeBuilderState.a(token)) {
                        return true;
                    }
                    boolean zE = token.e();
                    AnonymousClass3 anonymousClass3 = HtmlTreeBuilderState.f17179n;
                    if (zE) {
                        Token.g gVar = (Token.g) token;
                        if (gVar.f17227c.equals("html")) {
                            aVar.n(gVar);
                            aVar.f17281k = anonymousClass3;
                        }
                    }
                    if (token.d() && e.in(((Token.f) token).f17227c, "head", "body", "html", "br")) {
                        aVar.getClass();
                        Element element = new Element(gh.e.valueOf("html", aVar.f17318h), aVar.f17315e);
                        aVar.t(element);
                        aVar.f17314d.add(element);
                        aVar.f17281k = anonymousClass3;
                        return aVar.process(token);
                    }
                    if (token.d()) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.getClass();
                    Element element2 = new Element(gh.e.valueOf("html", aVar.f17318h), aVar.f17315e);
                    aVar.t(element2);
                    aVar.f17314d.add(element2);
                    aVar.f17281k = anonymousClass3;
                    return aVar.process(token);
                }
                aVar.p((Token.c) token);
                return true;
            }
        };
        f17178m = r12;
        ?? r22 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (HtmlTreeBuilderState.a(token)) {
                    return true;
                }
                if (!token.a()) {
                    if (token.b()) {
                        aVar.e(this);
                        return false;
                    }
                    if (token.e() && ((Token.g) token).f17227c.equals("html")) {
                        return HtmlTreeBuilderState.f17183r.c(token, aVar);
                    }
                    if (token.e()) {
                        Token.g gVar = (Token.g) token;
                        if (gVar.f17227c.equals("head")) {
                            aVar.f17284n = aVar.n(gVar);
                            aVar.f17281k = HtmlTreeBuilderState.f17180o;
                        }
                    }
                    if (token.d() && e.in(((Token.f) token).f17227c, "head", "body", "html", "br")) {
                        aVar.processStartTag("head");
                        return aVar.process(token);
                    }
                    if (token.d()) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.processStartTag("head");
                    return aVar.process(token);
                }
                aVar.p((Token.c) token);
                return true;
            }
        };
        f17179n = r22;
        ?? r32 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (HtmlTreeBuilderState.a(token)) {
                    aVar.o((Token.b) token);
                    return true;
                }
                int iOrdinal = token.f17210a.ordinal();
                if (iOrdinal == 0) {
                    aVar.e(this);
                    return false;
                }
                if (iOrdinal == 1) {
                    Token.g gVar = (Token.g) token;
                    String str = gVar.f17227c;
                    if (str.equals("html")) {
                        return HtmlTreeBuilderState.f17183r.c(token, aVar);
                    }
                    if (e.in(str, "base", "basefont", "bgsound", "command", "link")) {
                        Element elementQ = aVar.q(gVar);
                        if (str.equals("base") && elementQ.hasAttr("href") && !aVar.f17283m) {
                            String strAbsUrl = elementQ.absUrl("href");
                            if (strAbsUrl.length() != 0) {
                                aVar.f17315e = strAbsUrl;
                                aVar.f17283m = true;
                                aVar.f17313c.setBaseUri(strAbsUrl);
                            }
                        }
                    } else if (str.equals("meta")) {
                        aVar.q(gVar);
                    } else {
                        boolean zEquals = str.equals("title");
                        AnonymousClass8 anonymousClass8 = HtmlTreeBuilderState.f17184s;
                        if (zEquals) {
                            aVar.f17312b.f17296c = TokeniserState.f17250n;
                            aVar.f17282l = aVar.f17281k;
                            aVar.f17281k = anonymousClass8;
                            aVar.n(gVar);
                        } else if (e.in(str, "noframes", "style")) {
                            HtmlTreeBuilderState.b(gVar, aVar);
                        } else if (str.equals("noscript")) {
                            aVar.n(gVar);
                            aVar.f17281k = HtmlTreeBuilderState.f17181p;
                        } else {
                            if (!str.equals("script")) {
                                if (str.equals("head")) {
                                    aVar.e(this);
                                    return false;
                                }
                                aVar.processEndTag("head");
                                return aVar.process(token);
                            }
                            aVar.f17312b.f17296c = TokeniserState.f17256q;
                            aVar.f17282l = aVar.f17281k;
                            aVar.f17281k = anonymousClass8;
                            aVar.n(gVar);
                        }
                    }
                } else if (iOrdinal == 2) {
                    String str2 = ((Token.f) token).f17227c;
                    if (!str2.equals("head")) {
                        if (e.in(str2, "body", "html", "br")) {
                            aVar.processEndTag("head");
                            return aVar.process(token);
                        }
                        aVar.e(this);
                        return false;
                    }
                    aVar.u();
                    aVar.f17281k = HtmlTreeBuilderState.f17182q;
                } else {
                    if (iOrdinal != 3) {
                        aVar.processEndTag("head");
                        return aVar.process(token);
                    }
                    aVar.p((Token.c) token);
                }
                return true;
            }
        };
        f17180o = r32;
        ?? r42 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.b()) {
                    aVar.e(this);
                } else {
                    if (token.e() && ((Token.g) token).f17227c.equals("html")) {
                        return aVar.w(token, HtmlTreeBuilderState.f17183r);
                    }
                    boolean zD = token.d();
                    AnonymousClass4 anonymousClass4 = HtmlTreeBuilderState.f17180o;
                    if (!zD || !((Token.f) token).f17227c.equals("noscript")) {
                        if (HtmlTreeBuilderState.a(token) || token.a() || (token.e() && e.in(((Token.g) token).f17227c, "basefont", "bgsound", "link", "meta", "noframes", "style"))) {
                            return aVar.w(token, anonymousClass4);
                        }
                        if (token.d() && ((Token.f) token).f17227c.equals("br")) {
                            aVar.e(this);
                            Token.b bVar = new Token.b();
                            bVar.f17218b = token.toString();
                            aVar.o(bVar);
                            return true;
                        }
                        if ((token.e() && e.in(((Token.g) token).f17227c, "head", "noscript")) || token.d()) {
                            aVar.e(this);
                            return false;
                        }
                        aVar.e(this);
                        Token.b bVar2 = new Token.b();
                        bVar2.f17218b = token.toString();
                        aVar.o(bVar2);
                        return true;
                    }
                    aVar.u();
                    aVar.f17281k = anonymousClass4;
                }
                return true;
            }
        };
        f17181p = r42;
        ?? r52 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (HtmlTreeBuilderState.a(token)) {
                    aVar.o((Token.b) token);
                } else if (token.a()) {
                    aVar.p((Token.c) token);
                } else if (token.b()) {
                    aVar.e(this);
                } else if (token.e()) {
                    Token.g gVar = (Token.g) token;
                    String str = gVar.f17227c;
                    boolean zEquals = str.equals("html");
                    AnonymousClass7 anonymousClass7 = HtmlTreeBuilderState.f17183r;
                    if (zEquals) {
                        return aVar.w(token, anonymousClass7);
                    }
                    if (str.equals("body")) {
                        aVar.n(gVar);
                        aVar.f17289s = false;
                        aVar.f17281k = anonymousClass7;
                    } else if (str.equals("frameset")) {
                        aVar.n(gVar);
                        aVar.f17281k = HtmlTreeBuilderState.D;
                    } else if (e.in(str, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                        aVar.e(this);
                        Element element = aVar.f17284n;
                        aVar.f17314d.add(element);
                        aVar.w(token, HtmlTreeBuilderState.f17180o);
                        aVar.A(element);
                    } else {
                        if (str.equals("head")) {
                            aVar.e(this);
                            return false;
                        }
                        aVar.processStartTag("body");
                        aVar.f17289s = true;
                        aVar.process(token);
                    }
                } else {
                    if (token.d() && !e.in(((Token.f) token).f17227c, "body", "html")) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.processStartTag("body");
                    aVar.f17289s = true;
                    aVar.process(token);
                }
                return true;
            }
        };
        f17182q = r52;
        AnonymousClass7 anonymousClass7 = new AnonymousClass7();
        f17183r = anonymousClass7;
        ?? r72 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.f17210a == Token.TokenType.Character) {
                    aVar.o((Token.b) token);
                } else {
                    if (token.c()) {
                        aVar.e(this);
                        aVar.u();
                        aVar.f17281k = aVar.f17282l;
                        return aVar.process(token);
                    }
                    if (token.d()) {
                        aVar.u();
                        aVar.f17281k = aVar.f17282l;
                    }
                }
                return true;
            }
        };
        f17184s = r72;
        ?? r82 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.f17210a == Token.TokenType.Character) {
                    aVar.getClass();
                    aVar.f17287q = new ArrayList();
                    aVar.f17282l = aVar.f17281k;
                    aVar.f17281k = HtmlTreeBuilderState.f17186u;
                    return aVar.process(token);
                }
                if (token.a()) {
                    aVar.p((Token.c) token);
                    return true;
                }
                if (token.b()) {
                    aVar.e(this);
                    return false;
                }
                if (!token.e()) {
                    if (!token.d()) {
                        if (!token.c()) {
                            return d(token, aVar);
                        }
                        if (ac.c.z(aVar, "html")) {
                            aVar.e(this);
                        }
                        return true;
                    }
                    String str = ((Token.f) token).f17227c;
                    if (!str.equals("table")) {
                        if (!e.in(str, "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                            return d(token, aVar);
                        }
                        aVar.e(this);
                        return false;
                    }
                    if (!aVar.m(str)) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.v("table");
                    aVar.B();
                    return true;
                }
                Token.g gVar = (Token.g) token;
                String str2 = gVar.f17227c;
                if (str2.equals("caption")) {
                    aVar.d("table");
                    aVar.f17286p.add(null);
                    aVar.n(gVar);
                    aVar.f17281k = HtmlTreeBuilderState.f17187v;
                } else if (str2.equals("colgroup")) {
                    aVar.d("table");
                    aVar.n(gVar);
                    aVar.f17281k = HtmlTreeBuilderState.f17188w;
                } else {
                    if (str2.equals("col")) {
                        aVar.processStartTag("colgroup");
                        return aVar.process(token);
                    }
                    if (e.in(str2, "tbody", "tfoot", "thead")) {
                        aVar.d("table");
                        aVar.n(gVar);
                        aVar.f17281k = HtmlTreeBuilderState.f17189x;
                    } else {
                        if (e.in(str2, "td", "th", "tr")) {
                            aVar.processStartTag("tbody");
                            return aVar.process(token);
                        }
                        if (str2.equals("table")) {
                            aVar.e(this);
                            if (aVar.processEndTag("table")) {
                                return aVar.process(token);
                            }
                        } else {
                            if (e.in(str2, "style", "script")) {
                                return aVar.w(token, HtmlTreeBuilderState.f17180o);
                            }
                            if (str2.equals("input")) {
                                if (!gVar.f17234j.get("type").equalsIgnoreCase("hidden")) {
                                    return d(token, aVar);
                                }
                                aVar.q(gVar);
                            } else {
                                if (!str2.equals("form")) {
                                    return d(token, aVar);
                                }
                                aVar.e(this);
                                if (aVar.f17285o != null) {
                                    return false;
                                }
                                aVar.r(gVar, false);
                            }
                        }
                    }
                }
                return true;
            }

            public final boolean d(Token token, org.jsoup.parser.a aVar) {
                aVar.e(this);
                boolean zIn = e.in(aVar.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr");
                AnonymousClass7 anonymousClass72 = HtmlTreeBuilderState.f17183r;
                if (!zIn) {
                    return aVar.w(token, anonymousClass72);
                }
                aVar.f17290t = true;
                boolean zW = aVar.w(token, anonymousClass72);
                aVar.f17290t = false;
                return zW;
            }
        };
        f17185t = r82;
        ?? r92 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.f17210a.ordinal() == 4) {
                    Token.b bVar = (Token.b) token;
                    if (bVar.f17218b.equals(HtmlTreeBuilderState.H)) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.f17287q.add(bVar.f17218b);
                    return true;
                }
                if (aVar.f17287q.size() > 0) {
                    Iterator it = aVar.f17287q.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (e.isBlank(str)) {
                            Token.b bVar2 = new Token.b();
                            bVar2.f17218b = str;
                            aVar.o(bVar2);
                        } else {
                            aVar.e(this);
                            boolean zIn = e.in(aVar.currentElement().nodeName(), "table", "tbody", "tfoot", "thead", "tr");
                            HtmlTreeBuilderState htmlTreeBuilderState = HtmlTreeBuilderState.f17183r;
                            if (zIn) {
                                aVar.f17290t = true;
                                Token.b bVar3 = new Token.b();
                                bVar3.f17218b = str;
                                aVar.w(bVar3, htmlTreeBuilderState);
                                aVar.f17290t = false;
                            } else {
                                Token.b bVar4 = new Token.b();
                                bVar4.f17218b = str;
                                aVar.w(bVar4, htmlTreeBuilderState);
                            }
                        }
                    }
                    aVar.f17287q = new ArrayList();
                }
                aVar.f17281k = aVar.f17282l;
                return aVar.process(token);
            }
        };
        f17186u = r92;
        ?? r10 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.d()) {
                    Token.f fVar = (Token.f) token;
                    if (fVar.f17227c.equals("caption")) {
                        if (!aVar.m(fVar.f17227c)) {
                            aVar.e(this);
                            return false;
                        }
                        if (!ac.c.z(aVar, "caption")) {
                            aVar.e(this);
                        }
                        aVar.v("caption");
                        aVar.c();
                        aVar.f17281k = HtmlTreeBuilderState.f17185t;
                        return true;
                    }
                }
                if ((token.e() && e.in(((Token.g) token).f17227c, "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.d() && ((Token.f) token).f17227c.equals("table"))) {
                    aVar.e(this);
                    if (aVar.processEndTag("caption")) {
                        return aVar.process(token);
                    }
                    return true;
                }
                if (!token.d() || !e.in(((Token.f) token).f17227c, "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return aVar.w(token, HtmlTreeBuilderState.f17183r);
                }
                aVar.e(this);
                return false;
            }
        };
        f17187v = r10;
        ?? r11 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (HtmlTreeBuilderState.a(token)) {
                    aVar.o((Token.b) token);
                    return true;
                }
                int iOrdinal = token.f17210a.ordinal();
                if (iOrdinal == 0) {
                    aVar.e(this);
                } else if (iOrdinal == 1) {
                    Token.g gVar = (Token.g) token;
                    String str = gVar.f17227c;
                    str.getClass();
                    if (!str.equals("col")) {
                        return !str.equals("html") ? d(token, aVar) : aVar.w(token, HtmlTreeBuilderState.f17183r);
                    }
                    aVar.q(gVar);
                } else if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal != 5) {
                            return d(token, aVar);
                        }
                        if (ac.c.z(aVar, "html")) {
                            return true;
                        }
                        return d(token, aVar);
                    }
                    aVar.p((Token.c) token);
                } else {
                    if (!((Token.f) token).f17227c.equals("colgroup")) {
                        return d(token, aVar);
                    }
                    if (ac.c.z(aVar, "html")) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.u();
                    aVar.f17281k = HtmlTreeBuilderState.f17185t;
                }
                return true;
            }

            public final boolean d(Token token, c cVar) {
                if (cVar.processEndTag("colgroup")) {
                    return cVar.process(token);
                }
                return true;
            }
        };
        f17188w = r11;
        ?? r122 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                int iOrdinal = token.f17210a.ordinal();
                HtmlTreeBuilderState htmlTreeBuilderState = HtmlTreeBuilderState.f17185t;
                if (iOrdinal == 1) {
                    Token.g gVar = (Token.g) token;
                    String str = gVar.f17227c;
                    if (str.equals("template")) {
                        aVar.n(gVar);
                    } else {
                        if (!str.equals("tr")) {
                            if (!e.in(str, "th", "td")) {
                                return e.in(str, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? d(token, aVar) : aVar.w(token, htmlTreeBuilderState);
                            }
                            aVar.e(this);
                            aVar.processStartTag("tr");
                            return aVar.process(gVar);
                        }
                        aVar.d("tbody", "tfoot", "thead", "template");
                        aVar.n(gVar);
                        aVar.f17281k = HtmlTreeBuilderState.f17190y;
                    }
                } else {
                    if (iOrdinal != 2) {
                        return aVar.w(token, htmlTreeBuilderState);
                    }
                    String str2 = ((Token.f) token).f17227c;
                    if (!e.in(str2, "tbody", "tfoot", "thead")) {
                        if (str2.equals("table")) {
                            return d(token, aVar);
                        }
                        if (!e.in(str2, "body", "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                            return aVar.w(token, htmlTreeBuilderState);
                        }
                        aVar.e(this);
                        return false;
                    }
                    if (!aVar.m(str2)) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.d("tbody", "tfoot", "thead", "template");
                    aVar.u();
                    aVar.f17281k = htmlTreeBuilderState;
                }
                return true;
            }

            public final boolean d(Token token, org.jsoup.parser.a aVar) {
                if (!aVar.m("tbody") && !aVar.m("thead") && !aVar.j("tfoot", null)) {
                    aVar.e(this);
                    return false;
                }
                aVar.d("tbody", "tfoot", "thead", "template");
                aVar.processEndTag(aVar.currentElement().nodeName());
                return aVar.process(token);
            }
        };
        f17189x = r122;
        ?? r13 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                boolean zE = token.e();
                AnonymousClass9 anonymousClass9 = HtmlTreeBuilderState.f17185t;
                if (zE) {
                    Token.g gVar = (Token.g) token;
                    String str = gVar.f17227c;
                    if (str.equals("template")) {
                        aVar.n(gVar);
                        return true;
                    }
                    if (e.in(str, "th", "td")) {
                        aVar.d("tr", "template");
                        aVar.n(gVar);
                        aVar.f17281k = HtmlTreeBuilderState.f17191z;
                        aVar.f17286p.add(null);
                        return true;
                    }
                    if (!e.in(str, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr")) {
                        return aVar.w(token, anonymousClass9);
                    }
                    if (aVar.processEndTag("tr")) {
                        return aVar.process(token);
                    }
                    return false;
                }
                if (!token.d()) {
                    return aVar.w(token, anonymousClass9);
                }
                String str2 = ((Token.f) token).f17227c;
                if (str2.equals("tr")) {
                    if (!aVar.m(str2)) {
                        aVar.e(this);
                        return false;
                    }
                    aVar.d("tr", "template");
                    aVar.u();
                    aVar.f17281k = HtmlTreeBuilderState.f17189x;
                    return true;
                }
                if (str2.equals("table")) {
                    if (aVar.processEndTag("tr")) {
                        return aVar.process(token);
                    }
                    return false;
                }
                if (!e.in(str2, "tbody", "tfoot", "thead")) {
                    if (!e.in(str2, "body", "caption", "col", "colgroup", "html", "td", "th")) {
                        return aVar.w(token, anonymousClass9);
                    }
                    aVar.e(this);
                    return false;
                }
                if (aVar.m(str2)) {
                    aVar.processEndTag("tr");
                    return aVar.process(token);
                }
                aVar.e(this);
                return false;
            }
        };
        f17190y = r13;
        ?? r14 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                boolean zD = token.d();
                AnonymousClass7 anonymousClass72 = HtmlTreeBuilderState.f17183r;
                if (!zD) {
                    if (!token.e() || !e.in(((Token.g) token).f17227c, "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return aVar.w(token, anonymousClass72);
                    }
                    if (!aVar.m("td") && !aVar.m("th")) {
                        aVar.e(this);
                        return false;
                    }
                    if (aVar.m("td")) {
                        aVar.processEndTag("td");
                    } else {
                        aVar.processEndTag("th");
                    }
                    return aVar.process(token);
                }
                String str = ((Token.f) token).f17227c;
                if (e.in(str, "td", "th")) {
                    boolean zM = aVar.m(str);
                    AnonymousClass14 anonymousClass14 = HtmlTreeBuilderState.f17190y;
                    if (!zM) {
                        aVar.e(this);
                        aVar.f17281k = anonymousClass14;
                        return false;
                    }
                    if (!ac.c.z(aVar, str)) {
                        aVar.e(this);
                    }
                    aVar.v(str);
                    aVar.c();
                    aVar.f17281k = anonymousClass14;
                    return true;
                }
                if (e.in(str, "body", "caption", "col", "colgroup", "html")) {
                    aVar.e(this);
                    return false;
                }
                if (!e.in(str, "table", "tbody", "tfoot", "thead", "tr")) {
                    return aVar.w(token, anonymousClass72);
                }
                if (!aVar.m(str)) {
                    aVar.e(this);
                    return false;
                }
                if (aVar.m("td")) {
                    aVar.processEndTag("td");
                } else {
                    aVar.processEndTag("th");
                }
                return aVar.process(token);
            }
        };
        f17191z = r14;
        ?? r15 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
            /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x00cf  */
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean c(org.jsoup.parser.Token r9, org.jsoup.parser.a r10) {
                /*
                    Method dump skipped, instructions count: 358
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass16.c(org.jsoup.parser.Token, org.jsoup.parser.a):boolean");
            }
        };
        A = r15;
        ?? r16 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.e() && e.in(((Token.g) token).f17227c, "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                    aVar.e(this);
                    aVar.processEndTag("select");
                    return aVar.process(token);
                }
                if (token.d()) {
                    Token.f fVar = (Token.f) token;
                    if (e.in(fVar.f17227c, "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                        aVar.e(this);
                        if (!aVar.m(fVar.f17227c)) {
                            return false;
                        }
                        aVar.processEndTag("select");
                        return aVar.process(token);
                    }
                }
                return aVar.w(token, HtmlTreeBuilderState.A);
            }
        };
        B = r16;
        ?? r17 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                boolean zA = HtmlTreeBuilderState.a(token);
                AnonymousClass7 anonymousClass72 = HtmlTreeBuilderState.f17183r;
                if (zA) {
                    return aVar.w(token, anonymousClass72);
                }
                if (token.a()) {
                    aVar.p((Token.c) token);
                    return true;
                }
                if (token.b()) {
                    aVar.e(this);
                    return false;
                }
                if (token.e() && ((Token.g) token).f17227c.equals("html")) {
                    return aVar.w(token, anonymousClass72);
                }
                if (token.d() && ((Token.f) token).f17227c.equals("html")) {
                    aVar.getClass();
                    aVar.f17281k = HtmlTreeBuilderState.F;
                    return true;
                }
                if (token.c()) {
                    return true;
                }
                aVar.e(this);
                aVar.f17281k = anonymousClass72;
                return aVar.process(token);
            }
        };
        C = r17;
        ?? r18 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                Token.g gVar;
                if (HtmlTreeBuilderState.a(token)) {
                    aVar.o((Token.b) token);
                } else if (token.a()) {
                    aVar.p((Token.c) token);
                } else {
                    if (token.b()) {
                        aVar.e(this);
                        return false;
                    }
                    if (token.e()) {
                        gVar = (Token.g) token;
                        String str = gVar.f17227c;
                        str.getClass();
                        str.hashCode();
                        switch (str) {
                            case "frameset":
                                aVar.n(gVar);
                                break;
                            case "html":
                                return aVar.w(gVar, HtmlTreeBuilderState.f17183r);
                            case "frame":
                                aVar.q(gVar);
                                break;
                            case "noframes":
                                return aVar.w(gVar, HtmlTreeBuilderState.f17180o);
                            default:
                                aVar.e(this);
                                return false;
                        }
                    } else if (token.d() && ((Token.f) token).f17227c.equals("frameset")) {
                        if (ac.c.z(aVar, "html")) {
                            aVar.e(this);
                            return false;
                        }
                        aVar.u();
                        if (!aVar.currentElement().nodeName().equals("frameset")) {
                            aVar.f17281k = HtmlTreeBuilderState.E;
                        }
                    } else {
                        if (!token.c()) {
                            aVar.e(this);
                            return false;
                        }
                        if (!ac.c.z(aVar, "html")) {
                            aVar.e(this);
                        }
                    }
                }
                return true;
            }
        };
        D = r18;
        ?? r19 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (HtmlTreeBuilderState.a(token)) {
                    aVar.o((Token.b) token);
                    return true;
                }
                if (token.a()) {
                    aVar.p((Token.c) token);
                    return true;
                }
                if (token.b()) {
                    aVar.e(this);
                    return false;
                }
                if (token.e() && ((Token.g) token).f17227c.equals("html")) {
                    return aVar.w(token, HtmlTreeBuilderState.f17183r);
                }
                if (token.d() && ((Token.f) token).f17227c.equals("html")) {
                    aVar.f17281k = HtmlTreeBuilderState.G;
                    return true;
                }
                if (token.e() && ((Token.g) token).f17227c.equals("noframes")) {
                    return aVar.w(token, HtmlTreeBuilderState.f17180o);
                }
                if (token.c()) {
                    return true;
                }
                aVar.e(this);
                return false;
            }
        };
        E = r19;
        ?? r20 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.a()) {
                    aVar.p((Token.c) token);
                    return true;
                }
                boolean zB = token.b();
                AnonymousClass7 anonymousClass72 = HtmlTreeBuilderState.f17183r;
                if (zB || HtmlTreeBuilderState.a(token) || (token.e() && ((Token.g) token).f17227c.equals("html"))) {
                    return aVar.w(token, anonymousClass72);
                }
                if (token.c()) {
                    return true;
                }
                aVar.e(this);
                aVar.f17281k = anonymousClass72;
                return aVar.process(token);
            }
        };
        F = r20;
        ?? r21 = new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                if (token.a()) {
                    aVar.p((Token.c) token);
                    return true;
                }
                if (token.b() || HtmlTreeBuilderState.a(token) || (token.e() && ((Token.g) token).f17227c.equals("html"))) {
                    return aVar.w(token, HtmlTreeBuilderState.f17183r);
                }
                if (token.c()) {
                    return true;
                }
                if (token.e() && ((Token.g) token).f17227c.equals("noframes")) {
                    return aVar.w(token, HtmlTreeBuilderState.f17180o);
                }
                aVar.e(this);
                return false;
            }
        };
        G = r21;
        I = new HtmlTreeBuilderState[]{r02, r12, r22, r32, r42, r52, anonymousClass7, r72, r82, r92, r10, r11, r122, r13, r14, r15, r16, r17, r18, r19, r20, r21, new HtmlTreeBuilderState() { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
            @Override // org.jsoup.parser.HtmlTreeBuilderState
            public final boolean c(Token token, org.jsoup.parser.a aVar) {
                return true;
            }
        }};
        H = String.valueOf((char) 0);
    }

    public HtmlTreeBuilderState() {
        throw null;
    }

    public HtmlTreeBuilderState(String str, int i10) {
    }

    public static boolean a(Token token) {
        if (token.f17210a == Token.TokenType.Character) {
            return e.isBlank(((Token.b) token).f17218b);
        }
        return false;
    }

    public static void b(Token.g gVar, org.jsoup.parser.a aVar) {
        aVar.f17312b.f17296c = TokeniserState.f17254p;
        aVar.f17282l = aVar.f17281k;
        aVar.f17281k = f17184s;
        aVar.n(gVar);
    }

    public static HtmlTreeBuilderState valueOf(String str) {
        return (HtmlTreeBuilderState) Enum.valueOf(HtmlTreeBuilderState.class, str);
    }

    public static HtmlTreeBuilderState[] values() {
        return (HtmlTreeBuilderState[]) I.clone();
    }

    public abstract boolean c(Token token, org.jsoup.parser.a aVar);
}
