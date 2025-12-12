package fh;

import dh.f;
import java.util.Collections;
import java.util.List;
import org.jsoup.nodes.g;

/* compiled from: LeafNode.java */
/* loaded from: classes2.dex */
public abstract class c extends g {

    /* renamed from: o, reason: collision with root package name */
    public static final List<g> f11562o = Collections.emptyList();

    /* renamed from: n, reason: collision with root package name */
    public Object f11563n;

    @Override // org.jsoup.nodes.g
    public String absUrl(String str) {
        d();
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.g
    public String attr(String str) {
        f.notNull(str);
        return !hasAttributes() ? str.equals(nodeName()) ? (String) this.f11563n : "" : super.attr(str);
    }

    @Override // org.jsoup.nodes.g
    public final org.jsoup.nodes.b attributes() {
        d();
        return (org.jsoup.nodes.b) this.f11563n;
    }

    @Override // org.jsoup.nodes.g
    public String baseUri() {
        return hasParent() ? parent().baseUri() : "";
    }

    public final String c() {
        return attr(nodeName());
    }

    @Override // org.jsoup.nodes.g
    public int childNodeSize() {
        return 0;
    }

    public final void d() {
        if (hasAttributes()) {
            return;
        }
        Object obj = this.f11563n;
        org.jsoup.nodes.b bVar = new org.jsoup.nodes.b();
        this.f11563n = bVar;
        if (obj != null) {
            bVar.put(nodeName(), (String) obj);
        }
    }

    @Override // org.jsoup.nodes.g
    public List<g> ensureChildNodes() {
        return f11562o;
    }

    @Override // org.jsoup.nodes.g
    public boolean hasAttr(String str) {
        d();
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.g
    public final boolean hasAttributes() {
        return this.f11563n instanceof org.jsoup.nodes.b;
    }

    @Override // org.jsoup.nodes.g
    public g attr(String str, String str2) {
        if (!hasAttributes() && str.equals(nodeName())) {
            this.f11563n = str2;
        } else {
            d();
            super.attr(str, str2);
        }
        return this;
    }

    @Override // org.jsoup.nodes.g
    public void doSetBaseUri(String str) {
    }
}
