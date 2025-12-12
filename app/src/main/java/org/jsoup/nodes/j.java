package org.jsoup.nodes;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.nodes.Document;

/* compiled from: XmlDeclaration.java */
/* loaded from: classes2.dex */
public final class j extends fh.c {

    /* renamed from: p, reason: collision with root package name */
    public final boolean f17176p;

    public j(String str, boolean z10) {
        dh.f.notNull(str);
        this.f11563n = str;
        this.f17176p = z10;
    }

    @Override // org.jsoup.nodes.g
    public final void a(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        Appendable appendableAppend = appendable.append("<");
        boolean z10 = this.f17176p;
        appendableAppend.append(z10 ? "!" : "?").append(c());
        Iterator<a> it = attributes().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.getKey().equals(nodeName())) {
                appendable.append(TokenParser.SP);
                next.html(appendable, outputSettings);
            }
        }
        appendable.append(z10 ? "!" : "?").append(">");
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

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public String name() {
        return c();
    }

    @Override // org.jsoup.nodes.g
    public String nodeName() {
        return "#declaration";
    }

    @Override // org.jsoup.nodes.g
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.g
    public final void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) {
    }
}
