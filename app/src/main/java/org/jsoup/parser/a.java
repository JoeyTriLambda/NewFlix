package org.jsoup.parser;

import dh.e;
import dh.f;
import java.io.Reader;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;
import org.jsoup.nodes.i;
import org.jsoup.parser.Token;

/* compiled from: HtmlTreeBuilder.java */
/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: k, reason: collision with root package name */
    public HtmlTreeBuilderState f17281k;

    /* renamed from: l, reason: collision with root package name */
    public HtmlTreeBuilderState f17282l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17283m;

    /* renamed from: n, reason: collision with root package name */
    public Element f17284n;

    /* renamed from: o, reason: collision with root package name */
    public fh.b f17285o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<Element> f17286p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f17287q;

    /* renamed from: r, reason: collision with root package name */
    public Token.f f17288r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f17289s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f17290t;

    /* renamed from: u, reason: collision with root package name */
    public final String[] f17291u = {null};

    /* renamed from: v, reason: collision with root package name */
    public static final String[] f17276v = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};

    /* renamed from: w, reason: collision with root package name */
    public static final String[] f17277w = {"ol", "ul"};

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f17278x = {"button"};

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f17279y = {"html", "table"};

    /* renamed from: z, reason: collision with root package name */
    public static final String[] f17280z = {"optgroup", "option"};
    public static final String[] A = {"dd", "dt", "li", "optgroup", "option", "p", "rp", "rt"};
    public static final String[] B = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};

    public final void A(Element element) {
        for (int size = this.f17314d.size() - 1; size >= 0; size--) {
            if (this.f17314d.get(size) == element) {
                this.f17314d.remove(size);
                return;
            }
        }
    }

    public final void B() {
        boolean z10 = false;
        for (int size = this.f17314d.size() - 1; size >= 0; size--) {
            Element element = this.f17314d.get(size);
            if (size == 0) {
                element = null;
                z10 = true;
            }
            String strNodeName = element.nodeName();
            if ("select".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.A;
                return;
            }
            if ("td".equals(strNodeName) || ("th".equals(strNodeName) && !z10)) {
                this.f17281k = HtmlTreeBuilderState.f17191z;
                return;
            }
            if ("tr".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17190y;
                return;
            }
            if ("tbody".equals(strNodeName) || "thead".equals(strNodeName) || "tfoot".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17189x;
                return;
            }
            if ("caption".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17187v;
                return;
            }
            if ("colgroup".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17188w;
                return;
            }
            if ("table".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17185t;
                return;
            }
            if ("head".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17183r;
                return;
            }
            if ("body".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17183r;
                return;
            }
            if ("frameset".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.D;
                return;
            } else if ("html".equals(strNodeName)) {
                this.f17281k = HtmlTreeBuilderState.f17179n;
                return;
            } else {
                if (z10) {
                    this.f17281k = HtmlTreeBuilderState.f17183r;
                    return;
                }
            }
        }
    }

    @Override // org.jsoup.parser.c
    public final gh.c a() {
        return gh.c.f12843c;
    }

    public final Element b(Element element) {
        for (int size = this.f17314d.size() - 1; size >= 0; size--) {
            if (this.f17314d.get(size) == element) {
                return this.f17314d.get(size - 1);
            }
        }
        return null;
    }

    public final void c() {
        while (!this.f17286p.isEmpty()) {
            int size = this.f17286p.size();
            if ((size > 0 ? this.f17286p.remove(size - 1) : null) == null) {
                return;
            }
        }
    }

    public final void d(String... strArr) {
        int size = this.f17314d.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Element element = this.f17314d.get(size);
            if (e.in(element.nodeName(), strArr) || element.nodeName().equals("html")) {
                return;
            } else {
                this.f17314d.remove(size);
            }
        }
    }

    public final void e(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.f17317g.a()) {
            this.f17317g.add(new gh.b(this.f17311a.pos(), "Unexpected token [%s] when in state [%s]", this.f17316f.getClass().getSimpleName(), htmlTreeBuilderState));
        }
    }

    public final void f(String str) {
        while (str != null && !ac.c.z(this, str) && e.inSorted(currentElement().nodeName(), A)) {
            u();
        }
    }

    public final Element g(String str) {
        for (int size = this.f17286p.size() - 1; size >= 0; size--) {
            Element element = this.f17286p.get(size);
            if (element == null) {
                return null;
            }
            if (element.nodeName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public final Element h(String str) {
        Element element;
        int size = this.f17314d.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            element = this.f17314d.get(size);
        } while (!element.nodeName().equals(str));
        return element;
    }

    public final boolean i(String str) {
        return j(str, f17278x);
    }

    @Override // org.jsoup.parser.c
    public void initialiseParse(Reader reader, String str, ParseErrorList parseErrorList, gh.c cVar) {
        super.initialiseParse(reader, str, parseErrorList, cVar);
        this.f17281k = HtmlTreeBuilderState.f17177b;
        this.f17282l = null;
        this.f17283m = false;
        this.f17284n = null;
        this.f17285o = null;
        this.f17286p = new ArrayList<>();
        this.f17287q = new ArrayList();
        this.f17288r = new Token.f();
        this.f17289s = true;
        this.f17290t = false;
    }

    public final boolean j(String str, String[] strArr) {
        String[] strArr2 = f17276v;
        String[] strArr3 = this.f17291u;
        strArr3[0] = str;
        return l(strArr3, strArr2, strArr);
    }

    public final boolean k(String str) {
        for (int size = this.f17314d.size() - 1; size >= 0; size--) {
            String strNodeName = this.f17314d.get(size).nodeName();
            if (strNodeName.equals(str)) {
                return true;
            }
            if (!e.inSorted(strNodeName, f17280z)) {
                return false;
            }
        }
        f.fail("Should not be reachable");
        return false;
    }

    public final boolean l(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.f17314d.size() - 1;
        int i10 = size > 100 ? size - 100 : 0;
        while (size >= i10) {
            String strNodeName = this.f17314d.get(size).nodeName();
            if (e.inSorted(strNodeName, strArr)) {
                return true;
            }
            if (e.inSorted(strNodeName, strArr2)) {
                return false;
            }
            if (strArr3 != null && e.inSorted(strNodeName, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    public final boolean m(String str) {
        String[] strArr = f17279y;
        String[] strArr2 = this.f17291u;
        strArr2[0] = str;
        return l(strArr2, strArr, null);
    }

    public final Element n(Token.g gVar) {
        if (gVar.f17233i) {
            Element elementQ = q(gVar);
            this.f17314d.add(elementQ);
            b bVar = this.f17312b;
            bVar.f17296c = TokeniserState.f17236b;
            Token.f fVar = this.f17288r;
            fVar.f();
            fVar.n(elementQ.tagName());
            bVar.h(fVar);
            return elementQ;
        }
        gh.e eVarValueOf = gh.e.valueOf(gVar.m(), this.f17318h);
        String str = this.f17315e;
        gh.c cVar = this.f17318h;
        org.jsoup.nodes.b bVar2 = gVar.f17234j;
        if (!cVar.f12846b) {
            bVar2.normalize();
        }
        Element element = new Element(eVarValueOf, str, bVar2);
        t(element);
        this.f17314d.add(element);
        return element;
    }

    public final void o(Token.b bVar) {
        String strTagName = currentElement().tagName();
        String str = bVar.f17218b;
        currentElement().appendChild(bVar instanceof Token.a ? new org.jsoup.nodes.c(str) : (strTagName.equals("script") || strTagName.equals("style")) ? new org.jsoup.nodes.e(str) : new i(str));
    }

    public final void p(Token.c cVar) {
        t(new org.jsoup.nodes.d(cVar.f17219b.toString()));
    }

    @Override // org.jsoup.parser.c
    public boolean process(Token token) {
        this.f17316f = token;
        return this.f17281k.c(token, this);
    }

    @Override // org.jsoup.parser.c
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, org.jsoup.nodes.b bVar) {
        return super.processStartTag(str, bVar);
    }

    public final Element q(Token.g gVar) {
        gh.e eVarValueOf = gh.e.valueOf(gVar.m(), this.f17318h);
        Element element = new Element(eVarValueOf, this.f17315e, gVar.f17234j);
        t(element);
        if (gVar.f17233i) {
            if (!eVarValueOf.isKnownTag()) {
                eVarValueOf.f12862f = true;
            } else if (!eVarValueOf.isEmpty()) {
                b bVar = this.f17312b;
                ParseErrorList parseErrorList = bVar.f17295b;
                if (parseErrorList.a()) {
                    parseErrorList.add(new gh.b(bVar.f17294a.pos(), "Tag cannot be self closing; not a void tag"));
                }
            }
        }
        return element;
    }

    public final void r(Token.g gVar, boolean z10) {
        fh.b bVar = new fh.b(gh.e.valueOf(gVar.m(), this.f17318h), this.f17315e, gVar.f17234j);
        this.f17285o = bVar;
        t(bVar);
        if (z10) {
            this.f17314d.add(bVar);
        }
    }

    public final void s(g gVar) {
        Element elementB;
        Element elementH = h("table");
        boolean z10 = false;
        if (elementH == null) {
            elementB = this.f17314d.get(0);
        } else if (elementH.parent() != null) {
            elementB = elementH.parent();
            z10 = true;
        } else {
            elementB = b(elementH);
        }
        if (!z10) {
            elementB.appendChild(gVar);
        } else {
            f.notNull(elementH);
            elementH.before(gVar);
        }
    }

    public final void t(g gVar) {
        fh.b bVar;
        if (this.f17314d.size() == 0) {
            this.f17313c.appendChild(gVar);
        } else if (this.f17290t) {
            s(gVar);
        } else {
            currentElement().appendChild(gVar);
        }
        if (gVar instanceof Element) {
            Element element = (Element) gVar;
            if (!element.tag().isFormListed() || (bVar = this.f17285o) == null) {
                return;
            }
            bVar.addElement(element);
        }
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f17316f + ", state=" + this.f17281k + ", currentElement=" + currentElement() + '}';
    }

    public final void u() {
        this.f17314d.remove(this.f17314d.size() - 1);
    }

    public final void v(String str) {
        for (int size = this.f17314d.size() - 1; size >= 0; size--) {
            Element element = this.f17314d.get(size);
            this.f17314d.remove(size);
            if (element.nodeName().equals(str)) {
                return;
            }
        }
    }

    public final boolean w(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f17316f = token;
        return htmlTreeBuilderState.c(token, this);
    }

    public final void x(Element element) {
        int size = this.f17286p.size() - 1;
        int i10 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.f17286p.get(size);
                if (element2 == null) {
                    break;
                }
                if (element.nodeName().equals(element2.nodeName()) && element.attributes().equals(element2.attributes())) {
                    i10++;
                }
                if (i10 == 3) {
                    this.f17286p.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.f17286p.add(element);
    }

    public final void y() {
        Element element;
        boolean z10;
        a aVar;
        boolean z11;
        if (this.f17286p.size() > 0) {
            element = this.f17286p.get(r0.size() - 1);
        } else {
            element = null;
        }
        if (element == null) {
            return;
        }
        ArrayList<Element> arrayList = this.f17314d;
        boolean z12 = true;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                z10 = false;
                break;
            } else {
                if (arrayList.get(size) == element) {
                    z10 = true;
                    break;
                }
                size--;
            }
        }
        if (z10) {
            return;
        }
        int size2 = this.f17286p.size() - 1;
        int i10 = size2;
        while (i10 != 0) {
            i10--;
            element = this.f17286p.get(i10);
            if (element != null) {
                ArrayList<Element> arrayList2 = this.f17314d;
                int size3 = arrayList2.size() - 1;
                while (true) {
                    if (size3 < 0) {
                        z11 = false;
                        break;
                    } else {
                        if (arrayList2.get(size3) == element) {
                            z11 = true;
                            break;
                        }
                        size3--;
                    }
                }
                if (z11) {
                }
            }
            aVar = this;
            z12 = false;
            break;
        }
        aVar = this;
        while (true) {
            if (!z12) {
                i10++;
                element = aVar.f17286p.get(i10);
            }
            f.notNull(element);
            Element element2 = new Element(gh.e.valueOf(element.nodeName(), aVar.f17318h), aVar.f17315e);
            aVar.t(element2);
            aVar.f17314d.add(element2);
            element2.attributes().addAll(element.attributes());
            aVar.f17286p.set(i10, element2);
            if (i10 == size2) {
                return;
            }
            aVar = aVar;
            z12 = false;
        }
    }

    public final void z(Element element) {
        int size = this.f17286p.size();
        do {
            size--;
            if (size < 0) {
                return;
            }
        } while (this.f17286p.get(size) != element);
        this.f17286p.remove(size);
    }
}
