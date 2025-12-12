package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: Evaluator.java */
/* loaded from: classes2.dex */
public abstract class c {

    /* compiled from: Evaluator.java */
    public static final class a extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class a0 extends o {
        public a0(int i10, int i11) {
            super(i10, i11);
        }

        @Override // org.jsoup.select.c.o
        public int calculatePosition(Element element, Element element2) {
            return element2.parent().children().size() - element2.elementSiblingIndex();
        }

        @Override // org.jsoup.select.c.o
        public String getPseudoClass() {
            return "nth-last-child";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17334a;

        public b(String str) {
            this.f17334a = str;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.f17334a);
        }

        public String toString() {
            return String.format("[%s]", this.f17334a);
        }
    }

    /* compiled from: Evaluator.java */
    public static class b0 extends o {
        public b0(int i10, int i11) {
            super(i10, i11);
        }

        @Override // org.jsoup.select.c.o
        public int calculatePosition(Element element, Element element2) {
            Elements elementsChildren = element2.parent().children();
            int i10 = 0;
            for (int iElementSiblingIndex = element2.elementSiblingIndex(); iElementSiblingIndex < elementsChildren.size(); iElementSiblingIndex++) {
                if (elementsChildren.get(iElementSiblingIndex).tag().equals(element2.tag())) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // org.jsoup.select.c.o
        public String getPseudoClass() {
            return "nth-last-of-type";
        }
    }

    /* compiled from: Evaluator.java */
    /* renamed from: org.jsoup.select.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0216c extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17335a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17336b;

        public AbstractC0216c(String str, String str2) {
            dh.f.notEmpty(str);
            dh.f.notEmpty(str2);
            this.f17335a = eh.b.normalize(str);
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.f17336b = eh.b.normalize(str2);
        }
    }

    /* compiled from: Evaluator.java */
    public static class c0 extends o {
        public c0(int i10, int i11) {
            super(i10, i11);
        }

        @Override // org.jsoup.select.c.o
        public int calculatePosition(Element element, Element element2) {
            Iterator<Element> it = element2.parent().children().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.tag().equals(element2.tag())) {
                    i10++;
                }
                if (next == element2) {
                    break;
                }
            }
            return i10;
        }

        @Override // org.jsoup.select.c.o
        public String getPseudoClass() {
            return "nth-of-type";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class d extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17337a;

        public d(String str) {
            dh.f.notEmpty(str);
            this.f17337a = eh.b.lowerCase(str);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Iterator<org.jsoup.nodes.a> it = element2.attributes().asList().iterator();
            while (it.hasNext()) {
                if (eh.b.lowerCase(it.next().getKey()).startsWith(this.f17337a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.f17337a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class d0 extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            return (elementParent == null || (elementParent instanceof Document) || element2.siblingElements().size() != 0) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class e extends AbstractC0216c {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            String str = this.f17335a;
            if (element2.hasAttr(str)) {
                if (this.f17336b.equalsIgnoreCase(element2.attr(str).trim())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[%s=%s]", this.f17335a, this.f17336b);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class e0 extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            if (elementParent == null || (elementParent instanceof Document)) {
                return false;
            }
            Iterator<Element> it = elementParent.children().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next().tag().equals(element2.tag())) {
                    i10++;
                }
            }
            return i10 == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class f extends AbstractC0216c {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            String str = this.f17335a;
            return element2.hasAttr(str) && eh.b.lowerCase(element2.attr(str)).contains(this.f17336b);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.f17335a, this.f17336b);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class f0 extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.child(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class g extends AbstractC0216c {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            String str = this.f17335a;
            return element2.hasAttr(str) && eh.b.lowerCase(element2.attr(str)).endsWith(this.f17336b);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.f17335a, this.f17336b);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class g0 extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            if (element2 instanceof org.jsoup.nodes.h) {
                return true;
            }
            for (org.jsoup.nodes.i iVar : element2.textNodes()) {
                org.jsoup.nodes.h hVar = new org.jsoup.nodes.h(gh.e.valueOf(element2.tagName()), element2.baseUri(), element2.attributes());
                iVar.replaceWith(hVar);
                hVar.appendChild(iVar);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class h extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17338a;

        /* renamed from: b, reason: collision with root package name */
        public final Pattern f17339b;

        public h(String str, Pattern pattern) {
            this.f17338a = eh.b.normalize(str);
            this.f17339b = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            String str = this.f17338a;
            return element2.hasAttr(str) && this.f17339b.matcher(element2.attr(str)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.f17338a, this.f17339b.toString());
        }
    }

    /* compiled from: Evaluator.java */
    public static final class h0 extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Pattern f17340a;

        public h0(Pattern pattern) {
            this.f17340a = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return this.f17340a.matcher(element2.text()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.f17340a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class i extends AbstractC0216c {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return !this.f17336b.equalsIgnoreCase(element2.attr(this.f17335a));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.f17335a, this.f17336b);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class i0 extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Pattern f17341a;

        public i0(Pattern pattern) {
            this.f17341a = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return this.f17341a.matcher(element2.ownText()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.f17341a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class j extends AbstractC0216c {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            String str = this.f17335a;
            return element2.hasAttr(str) && eh.b.lowerCase(element2.attr(str)).startsWith(this.f17336b);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.f17335a, this.f17336b);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class j0 extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17342a;

        public j0(String str) {
            this.f17342a = str;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element2.tagName().equalsIgnoreCase(this.f17342a);
        }

        public String toString() {
            return String.format("%s", this.f17342a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class k extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17343a;

        public k(String str) {
            this.f17343a = str;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element2.hasClass(this.f17343a);
        }

        public String toString() {
            return String.format(".%s", this.f17343a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class k0 extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17344a;

        public k0(String str) {
            this.f17344a = str;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element2.tagName().endsWith(this.f17344a);
        }

        public String toString() {
            return String.format("%s", this.f17344a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class l extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17345a;

        public l(String str) {
            this.f17345a = eh.b.lowerCase(str);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return eh.b.lowerCase(element2.data()).contains(this.f17345a);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.f17345a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class m extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17346a;

        public m(String str) {
            this.f17346a = eh.b.lowerCase(str);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return eh.b.lowerCase(element2.ownText()).contains(this.f17346a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.f17346a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class n extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17347a;

        public n(String str) {
            this.f17347a = eh.b.lowerCase(str);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return eh.b.lowerCase(element2.text()).contains(this.f17347a);
        }

        public String toString() {
            return String.format(":contains(%s)", this.f17347a);
        }
    }

    /* compiled from: Evaluator.java */
    public static abstract class o extends c {

        /* renamed from: a, reason: collision with root package name */
        public final int f17348a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17349b;

        public o(int i10, int i11) {
            this.f17348a = i10;
            this.f17349b = i11;
        }

        public abstract int calculatePosition(Element element, Element element2);

        public abstract String getPseudoClass();

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            if (elementParent == null || (elementParent instanceof Document)) {
                return false;
            }
            int iCalculatePosition = calculatePosition(element, element2);
            int i10 = this.f17349b;
            int i11 = this.f17348a;
            return i11 == 0 ? iCalculatePosition == i10 : (iCalculatePosition - i10) * i11 >= 0 && (iCalculatePosition - i10) % i11 == 0;
        }

        public String toString() {
            int i10 = this.f17349b;
            int i11 = this.f17348a;
            return i11 == 0 ? String.format(":%s(%d)", getPseudoClass(), Integer.valueOf(i10)) : i10 == 0 ? String.format(":%s(%dn)", getPseudoClass(), Integer.valueOf(i11)) : String.format(":%s(%dn%+d)", getPseudoClass(), Integer.valueOf(i11), Integer.valueOf(i10));
        }
    }

    /* compiled from: Evaluator.java */
    public static final class p extends c {

        /* renamed from: a, reason: collision with root package name */
        public final String f17350a;

        public p(String str) {
            this.f17350a = str;
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return this.f17350a.equals(element2.id());
        }

        public String toString() {
            return String.format("#%s", this.f17350a);
        }
    }

    /* compiled from: Evaluator.java */
    public static final class q extends r {
        public q(int i10) {
            super(i10);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() == this.f17351a;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.f17351a));
        }
    }

    /* compiled from: Evaluator.java */
    public static abstract class r extends c {

        /* renamed from: a, reason: collision with root package name */
        public final int f17351a;

        public r(int i10) {
            this.f17351a = i10;
        }
    }

    /* compiled from: Evaluator.java */
    public static final class s extends r {
        public s(int i10) {
            super(i10);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() > this.f17351a;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.f17351a));
        }
    }

    /* compiled from: Evaluator.java */
    public static final class t extends r {
        public t(int i10) {
            super(i10);
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            return element != element2 && element2.elementSiblingIndex() < this.f17351a;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.f17351a));
        }
    }

    /* compiled from: Evaluator.java */
    public static final class u extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            for (org.jsoup.nodes.g gVar : element2.childNodes()) {
                if (!(gVar instanceof org.jsoup.nodes.d) && !(gVar instanceof org.jsoup.nodes.j) && !(gVar instanceof org.jsoup.nodes.f)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class v extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            return (elementParent == null || (elementParent instanceof Document) || element2.elementSiblingIndex() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class w extends c0 {
        public w() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.o
        public String toString() {
            return ":first-of-type";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class x extends c {
        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            return (elementParent == null || (elementParent instanceof Document) || element2.elementSiblingIndex() != elementParent.children().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class y extends b0 {
        public y() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.o
        public String toString() {
            return ":last-of-type";
        }
    }

    /* compiled from: Evaluator.java */
    public static final class z extends o {
        public z(int i10, int i11) {
            super(i10, i11);
        }

        @Override // org.jsoup.select.c.o
        public int calculatePosition(Element element, Element element2) {
            return element2.elementSiblingIndex() + 1;
        }

        @Override // org.jsoup.select.c.o
        public String getPseudoClass() {
            return "nth-child";
        }
    }

    public abstract boolean matches(Element element, Element element2);
}
