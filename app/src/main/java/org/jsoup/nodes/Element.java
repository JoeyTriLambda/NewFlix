package org.jsoup.nodes;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.jsoup.select.c;

/* loaded from: classes2.dex */
public class Element extends g {

    /* renamed from: s, reason: collision with root package name */
    public static final List<g> f17139s = Collections.emptyList();

    /* renamed from: n, reason: collision with root package name */
    public final gh.e f17140n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference<List<Element>> f17141o;

    /* renamed from: p, reason: collision with root package name */
    public List<g> f17142p;

    /* renamed from: q, reason: collision with root package name */
    public b f17143q;

    /* renamed from: r, reason: collision with root package name */
    public String f17144r;

    public static final class NodeList extends ChangeNotifyingArrayList<g> {

        /* renamed from: b, reason: collision with root package name */
        public final Element f17145b;

        public NodeList(Element element, int i10) {
            super(i10);
            this.f17145b = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.f17145b.f17141o = null;
        }
    }

    public class a implements hh.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f17146a;

        public a(StringBuilder sb2) {
            this.f17146a = sb2;
        }

        @Override // hh.a
        public void head(g gVar, int i10) {
            boolean z10 = gVar instanceof i;
            StringBuilder sb2 = this.f17146a;
            if (z10) {
                Element.c(sb2, (i) gVar);
                return;
            }
            if (gVar instanceof Element) {
                Element element = (Element) gVar;
                if (sb2.length() > 0) {
                    if ((element.isBlock() || element.f17140n.getName().equals("br")) && !i.e(sb2)) {
                        sb2.append(TokenParser.SP);
                    }
                }
            }
        }

        @Override // hh.a
        public void tail(g gVar, int i10) {
            if ((gVar instanceof Element) && ((Element) gVar).isBlock() && (gVar.nextSibling() instanceof i)) {
                StringBuilder sb2 = this.f17146a;
                if (i.e(sb2)) {
                    return;
                }
                sb2.append(TokenParser.SP);
            }
        }
    }

    static {
        Pattern.compile("\\s+");
    }

    public Element(gh.e eVar, String str, b bVar) {
        dh.f.notNull(eVar);
        dh.f.notNull(str);
        this.f17142p = f17139s;
        this.f17144r = str;
        this.f17143q = bVar;
        this.f17140n = eVar;
    }

    public static void c(StringBuilder sb2, i iVar) {
        String wholeText = iVar.getWholeText();
        if (f(iVar.f17171b) || (iVar instanceof c)) {
            sb2.append(wholeText);
        } else {
            dh.e.appendNormalisedWhitespace(sb2, wholeText, i.e(sb2));
        }
    }

    public static <E extends Element> int e(Element element, List<E> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10) == element) {
                return i10;
            }
        }
        return 0;
    }

    public static boolean f(g gVar) {
        if (gVar != null && (gVar instanceof Element)) {
            Element elementParent = (Element) gVar;
            int i10 = 0;
            while (!elementParent.f17140n.preserveWhitespace()) {
                elementParent = elementParent.parent();
                i10++;
                if (i10 >= 6 || elementParent == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // org.jsoup.nodes.g
    public void a(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        boolean zPrettyPrint = outputSettings.prettyPrint();
        gh.e eVar = this.f17140n;
        if (zPrettyPrint && ((eVar.formatAsBlock() || ((parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline())) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0))) {
            indent(appendable, i10, outputSettings);
        }
        appendable.append('<').append(tagName());
        b bVar = this.f17143q;
        if (bVar != null) {
            bVar.b(appendable, outputSettings);
        }
        if (!this.f17142p.isEmpty() || !eVar.isSelfClosing()) {
            appendable.append('>');
        } else if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && eVar.isEmpty()) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    public Element appendChild(g gVar) {
        dh.f.notNull(gVar);
        reparentChild(gVar);
        ensureChildNodes();
        this.f17142p.add(gVar);
        gVar.setSiblingIndex(this.f17142p.size() - 1);
        return this;
    }

    @Override // org.jsoup.nodes.g
    public Element attr(String str, String str2) {
        attr(str, str2);
        return this;
    }

    @Override // org.jsoup.nodes.g
    public b attributes() {
        if (!hasAttributes()) {
            this.f17143q = new b();
        }
        return this.f17143q;
    }

    @Override // org.jsoup.nodes.g
    public void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        boolean zIsEmpty = this.f17142p.isEmpty();
        gh.e eVar = this.f17140n;
        if (zIsEmpty && eVar.isSelfClosing()) {
            return;
        }
        if (outputSettings.prettyPrint() && !this.f17142p.isEmpty() && (eVar.formatAsBlock() || (outputSettings.outline() && (this.f17142p.size() > 1 || (this.f17142p.size() == 1 && !(this.f17142p.get(0) instanceof i)))))) {
            indent(appendable, i10, outputSettings);
        }
        appendable.append("</").append(tagName()).append('>');
    }

    @Override // org.jsoup.nodes.g
    public String baseUri() {
        return this.f17144r;
    }

    @Override // org.jsoup.nodes.g
    public Element before(g gVar) {
        return (Element) before(gVar);
    }

    public Element child(int i10) {
        return d().get(i10);
    }

    @Override // org.jsoup.nodes.g
    public int childNodeSize() {
        return this.f17142p.size();
    }

    public Elements children() {
        return new Elements(d());
    }

    public final List<Element> d() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.f17141o;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.f17142p.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f17142p.get(i10);
            if (gVar instanceof Element) {
                arrayList.add((Element) gVar);
            }
        }
        this.f17141o = new WeakReference<>(arrayList);
        return arrayList;
    }

    public String data() {
        StringBuilder sb2 = new StringBuilder();
        for (g gVar : this.f17142p) {
            if (gVar instanceof e) {
                sb2.append(((e) gVar).getWholeData());
            } else if (gVar instanceof d) {
                sb2.append(((d) gVar).getData());
            } else if (gVar instanceof Element) {
                sb2.append(((Element) gVar).data());
            } else if (gVar instanceof c) {
                sb2.append(((c) gVar).getWholeText());
            }
        }
        return sb2.toString();
    }

    @Override // org.jsoup.nodes.g
    public void doSetBaseUri(String str) {
        this.f17144r = str;
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return e(this, parent().d());
    }

    @Override // org.jsoup.nodes.g
    public List<g> ensureChildNodes() {
        if (this.f17142p == f17139s) {
            this.f17142p = new NodeList(this, 4);
        }
        return this.f17142p;
    }

    public Elements getAllElements() {
        return org.jsoup.select.a.collect(new c.a(), this);
    }

    public Element getElementById(String str) {
        dh.f.notEmpty(str);
        Elements elementsCollect = org.jsoup.select.a.collect(new c.p(str), this);
        if (elementsCollect.size() > 0) {
            return elementsCollect.get(0);
        }
        return null;
    }

    public Elements getElementsByClass(String str) {
        dh.f.notEmpty(str);
        return org.jsoup.select.a.collect(new c.k(str), this);
    }

    public Elements getElementsByTag(String str) {
        dh.f.notEmpty(str);
        return org.jsoup.select.a.collect(new c.j0(eh.b.normalize(str)), this);
    }

    @Override // org.jsoup.nodes.g
    public boolean hasAttributes() {
        return this.f17143q != null;
    }

    public boolean hasClass(String str) {
        String ignoreCase = attributes().getIgnoreCase("class");
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            boolean z10 = false;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (Character.isWhitespace(ignoreCase.charAt(i11))) {
                    if (!z10) {
                        continue;
                    } else {
                        if (i11 - i10 == length2 && ignoreCase.regionMatches(true, i10, str, 0, length2)) {
                            return true;
                        }
                        z10 = false;
                    }
                } else if (!z10) {
                    i10 = i11;
                    z10 = true;
                }
            }
            if (z10 && length - i10 == length2) {
                return ignoreCase.regionMatches(true, i10, str, 0, length2);
            }
        }
        return false;
    }

    public String html() {
        StringBuilder sbStringBuilder = dh.e.stringBuilder();
        Iterator<g> it = this.f17142p.iterator();
        while (it.hasNext()) {
            it.next().outerHtml(sbStringBuilder);
        }
        Document documentOwnerDocument = ownerDocument();
        if (documentOwnerDocument == null) {
            documentOwnerDocument = new Document("");
        }
        boolean zPrettyPrint = documentOwnerDocument.outputSettings().prettyPrint();
        String string = sbStringBuilder.toString();
        return zPrettyPrint ? string.trim() : string;
    }

    public String id() {
        return attributes().getIgnoreCase("id");
    }

    public boolean isBlock() {
        return this.f17140n.isBlock();
    }

    public Element nextElementSibling() {
        if (this.f17171b == null) {
            return null;
        }
        List<Element> listD = parent().d();
        Integer numValueOf = Integer.valueOf(e(this, listD));
        dh.f.notNull(numValueOf);
        if (listD.size() > numValueOf.intValue() + 1) {
            return listD.get(numValueOf.intValue() + 1);
        }
        return null;
    }

    @Override // org.jsoup.nodes.g
    public String nodeName() {
        return this.f17140n.getName();
    }

    public String ownText() {
        StringBuilder sb2 = new StringBuilder();
        for (g gVar : this.f17142p) {
            if (gVar instanceof i) {
                c(sb2, (i) gVar);
            } else if ((gVar instanceof Element) && ((Element) gVar).f17140n.getName().equals("br") && !i.e(sb2)) {
                sb2.append(StringUtils.SPACE);
            }
        }
        return sb2.toString().trim();
    }

    @Override // org.jsoup.nodes.g
    public final Element parent() {
        return (Element) this.f17171b;
    }

    public Element previousElementSibling() {
        if (this.f17171b == null) {
            return null;
        }
        List<Element> listD = parent().d();
        Integer numValueOf = Integer.valueOf(e(this, listD));
        dh.f.notNull(numValueOf);
        if (numValueOf.intValue() > 0) {
            return listD.get(numValueOf.intValue() - 1);
        }
        return null;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    public Elements siblingElements() {
        if (this.f17171b == null) {
            return new Elements(0);
        }
        List<Element> listD = parent().d();
        Elements elements = new Elements(listD.size() - 1);
        for (Element element : listD) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public gh.e tag() {
        return this.f17140n;
    }

    public String tagName() {
        return this.f17140n.getName();
    }

    public String text() {
        StringBuilder sb2 = new StringBuilder();
        org.jsoup.select.d.traverse(new a(sb2), this);
        return sb2.toString().trim();
    }

    public List<i> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.f17142p) {
            if (gVar instanceof i) {
                arrayList.add((i) gVar);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.g
    public Element doClone(g gVar) {
        Element element = (Element) super.doClone(gVar);
        b bVar = this.f17143q;
        element.f17143q = bVar != null ? bVar.clone() : null;
        element.f17144r = this.f17144r;
        NodeList nodeList = new NodeList(element, this.f17142p.size());
        element.f17142p = nodeList;
        nodeList.addAll(this.f17142p);
        return element;
    }

    @Override // org.jsoup.nodes.g
    /* renamed from: clone */
    public Element mo226clone() {
        return (Element) super.mo226clone();
    }

    public Element(gh.e eVar, String str) {
        this(eVar, str, null);
    }
}
