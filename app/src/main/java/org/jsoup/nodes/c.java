package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;

/* compiled from: CDataNode.java */
/* loaded from: classes2.dex */
public final class c extends i {
    public c(String str) {
        super(str);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.g
    public final void a(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<![CDATA[").append(getWholeText());
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.g
    public final void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        try {
            appendable.append("]]>");
        } catch (IOException e10) {
            throw new UncheckedIOException(e10);
        }
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.g
    public String nodeName() {
        return "#cdata";
    }
}
