package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

/* compiled from: DataNode.java */
/* loaded from: classes2.dex */
public final class e extends fh.c {
    public e(String str) {
        this.f11563n = str;
    }

    @Override // org.jsoup.nodes.g
    public final void a(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(getWholeData());
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    public String getWholeData() {
        return c();
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.g
    public String nodeName() {
        return "#data";
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.g
    public final void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) {
    }
}
