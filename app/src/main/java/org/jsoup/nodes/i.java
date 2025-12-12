package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* compiled from: TextNode.java */
/* loaded from: classes2.dex */
public class i extends fh.c {
    public i(String str) {
        this.f11563n = str;
    }

    public static boolean e(StringBuilder sb2) {
        return sb2.length() != 0 && sb2.charAt(sb2.length() - 1) == ' ';
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    @Override // org.jsoup.nodes.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Appendable r3, int r4, org.jsoup.nodes.Document.OutputSettings r5) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r5.prettyPrint()
            if (r0 == 0) goto L3d
            int r0 = r2.siblingIndex()
            if (r0 != 0) goto L24
            org.jsoup.nodes.g r0 = r2.f17171b
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L24
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            gh.e r0 = r0.tag()
            boolean r0 = r0.formatAsBlock()
            if (r0 == 0) goto L24
            boolean r0 = r2.isBlank()
            if (r0 == 0) goto L3a
        L24:
            boolean r0 = r5.outline()
            if (r0 == 0) goto L3d
            java.util.List r0 = r2.siblingNodes()
            int r0 = r0.size()
            if (r0 <= 0) goto L3d
            boolean r0 = r2.isBlank()
            if (r0 != 0) goto L3d
        L3a:
            r2.indent(r3, r4, r5)
        L3d:
            boolean r4 = r5.prettyPrint()
            r0 = 0
            if (r4 == 0) goto L58
            org.jsoup.nodes.g r4 = r2.parent()
            boolean r4 = r4 instanceof org.jsoup.nodes.Element
            if (r4 == 0) goto L58
            org.jsoup.nodes.g r4 = r2.parent()
            boolean r4 = org.jsoup.nodes.Element.f(r4)
            if (r4 != 0) goto L58
            r4 = 1
            goto L59
        L58:
            r4 = 0
        L59:
            java.lang.String r1 = r2.c()
            org.jsoup.nodes.Entities.b(r3, r1, r5, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.i.a(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
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

    public String getWholeText() {
        return c();
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isBlank() {
        return dh.e.isBlank(c());
    }

    @Override // org.jsoup.nodes.g
    public String nodeName() {
        return "#text";
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.g
    public void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) {
    }
}
