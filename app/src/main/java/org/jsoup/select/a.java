package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;
import org.jsoup.select.NodeFilter;

/* compiled from: Collector.java */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: Collector.java */
    public static class b implements NodeFilter {

        /* renamed from: a, reason: collision with root package name */
        public final Element f17329a;

        /* renamed from: b, reason: collision with root package name */
        public Element f17330b = null;

        /* renamed from: c, reason: collision with root package name */
        public final c f17331c;

        public b(c cVar, Element element) {
            this.f17329a = element;
            this.f17331c = cVar;
        }

        public NodeFilter.FilterResult head(g gVar, int i10) {
            if (gVar instanceof Element) {
                Element element = (Element) gVar;
                if (this.f17331c.matches(this.f17329a, element)) {
                    this.f17330b = element;
                    return NodeFilter.FilterResult.STOP;
                }
            }
            return NodeFilter.FilterResult.CONTINUE;
        }

        public NodeFilter.FilterResult tail(g gVar, int i10) {
            return NodeFilter.FilterResult.CONTINUE;
        }
    }

    public static Elements collect(c cVar, Element element) {
        Elements elements = new Elements();
        d.traverse(new C0214a(element, elements, cVar), element);
        return elements;
    }

    public static Element findFirst(c cVar, Element element) {
        b bVar = new b(cVar, element);
        d.filter(bVar, element);
        return bVar.f17330b;
    }

    /* compiled from: Collector.java */
    /* renamed from: org.jsoup.select.a$a, reason: collision with other inner class name */
    public static class C0214a implements hh.a {

        /* renamed from: a, reason: collision with root package name */
        public final Element f17326a;

        /* renamed from: b, reason: collision with root package name */
        public final Elements f17327b;

        /* renamed from: c, reason: collision with root package name */
        public final c f17328c;

        public C0214a(Element element, Elements elements, c cVar) {
            this.f17326a = element;
            this.f17327b = elements;
            this.f17328c = cVar;
        }

        @Override // hh.a
        public void head(g gVar, int i10) {
            if (gVar instanceof Element) {
                Element element = (Element) gVar;
                if (this.f17328c.matches(this.f17326a, element)) {
                    this.f17327b.add(element);
                }
            }
        }

        @Override // hh.a
        public void tail(g gVar, int i10) {
        }
    }
}
