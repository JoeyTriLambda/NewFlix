package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: StructuralEvaluator.java */
/* loaded from: classes2.dex */
public abstract class f extends org.jsoup.select.c {

    /* renamed from: a, reason: collision with root package name */
    public org.jsoup.select.c f17359a;

    /* compiled from: StructuralEvaluator.java */
    public static class a extends f {
        public a(org.jsoup.select.c cVar) {
            this.f17359a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Iterator<Element> it = element2.getAllElements().iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next != element2 && this.f17359a.matches(element, next)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.f17359a);
        }
    }

    /* compiled from: StructuralEvaluator.java */
    public static class b extends f {
        public b(org.jsoup.select.c cVar) {
            this.f17359a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementParent;
            return (element == element2 || (elementParent = element2.parent()) == null || !this.f17359a.matches(element, elementParent)) ? false : true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.f17359a);
        }
    }

    /* compiled from: StructuralEvaluator.java */
    public static class c extends f {
        public c(org.jsoup.select.c cVar) {
            this.f17359a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementPreviousElementSibling;
            return (element == element2 || (elementPreviousElementSibling = element2.previousElementSibling()) == null || !this.f17359a.matches(element, elementPreviousElementSibling)) ? false : true;
        }

        public String toString() {
            return String.format(":prev%s", this.f17359a);
        }
    }

    /* compiled from: StructuralEvaluator.java */
    public static class d extends f {
        public d(org.jsoup.select.c cVar) {
            this.f17359a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return !this.f17359a.matches(element, element2);
        }

        public String toString() {
            return String.format(":not%s", this.f17359a);
        }
    }

    /* compiled from: StructuralEvaluator.java */
    public static class e extends f {
        public e(org.jsoup.select.c cVar) {
            this.f17359a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element elementParent = element2.parent(); !this.f17359a.matches(element, elementParent); elementParent = elementParent.parent()) {
                if (elementParent == element) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", this.f17359a);
        }
    }

    /* compiled from: StructuralEvaluator.java */
    /* renamed from: org.jsoup.select.f$f, reason: collision with other inner class name */
    public static class C0217f extends f {
        public C0217f(org.jsoup.select.c cVar) {
            this.f17359a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element elementPreviousElementSibling = element2.previousElementSibling(); elementPreviousElementSibling != null; elementPreviousElementSibling = elementPreviousElementSibling.previousElementSibling()) {
                if (this.f17359a.matches(element, elementPreviousElementSibling)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", this.f17359a);
        }
    }

    /* compiled from: StructuralEvaluator.java */
    public static class g extends org.jsoup.select.c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element == element2;
        }
    }
}
