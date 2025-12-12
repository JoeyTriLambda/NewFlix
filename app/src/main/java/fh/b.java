package fh;

import gh.e;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;
import org.jsoup.select.Elements;

/* compiled from: FormElement.java */
/* loaded from: classes2.dex */
public final class b extends Element {

    /* renamed from: t, reason: collision with root package name */
    public final Elements f11561t;

    public b(e eVar, String str, org.jsoup.nodes.b bVar) {
        super(eVar, str, bVar);
        this.f11561t = new Elements();
    }

    public b addElement(Element element) {
        this.f11561t.add(element);
        return this;
    }

    @Override // org.jsoup.nodes.g
    public void removeChild(g gVar) {
        super.removeChild(gVar);
        this.f11561t.remove(gVar);
    }
}
