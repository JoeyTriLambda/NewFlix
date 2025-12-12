package org.jsoup.nodes;

import com.unity3d.ads.metadata.MediationMetaData;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

/* compiled from: DocumentType.java */
/* loaded from: classes2.dex */
public final class f extends fh.c {
    public f(String str, String str2, String str3) {
        dh.f.notNull(str);
        dh.f.notNull(str2);
        dh.f.notNull(str3);
        attr(MediationMetaData.KEY_NAME, str);
        attr("publicId", str2);
        if (e("publicId")) {
            attr("pubSysKey", "PUBLIC");
        }
        attr("systemId", str3);
    }

    @Override // org.jsoup.nodes.g
    public final void a(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.syntax() != Document.OutputSettings.Syntax.html || e("publicId") || e("systemId")) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (e(MediationMetaData.KEY_NAME)) {
            appendable.append(StringUtils.SPACE).append(attr(MediationMetaData.KEY_NAME));
        }
        if (e("pubSysKey")) {
            appendable.append(StringUtils.SPACE).append(attr("pubSysKey"));
        }
        if (e("publicId")) {
            appendable.append(" \"").append(attr("publicId")).append('\"');
        }
        if (e("systemId")) {
            appendable.append(" \"").append(attr("systemId")).append('\"');
        }
        appendable.append('>');
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

    public final boolean e(String str) {
        return !dh.e.isBlank(attr(str));
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.g
    public String nodeName() {
        return "#doctype";
    }

    public void setPubSysKey(String str) {
        if (str != null) {
            attr("pubSysKey", str);
        }
    }

    @Override // fh.c, org.jsoup.nodes.g
    public /* bridge */ /* synthetic */ g attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // org.jsoup.nodes.g
    public final void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) {
    }
}
