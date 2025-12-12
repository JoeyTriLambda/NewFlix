package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* compiled from: Node.java */
/* loaded from: classes2.dex */
public abstract class g implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public g f17171b;

    /* renamed from: m, reason: collision with root package name */
    public int f17172m;

    /* compiled from: Node.java */
    public static class b implements hh.a {

        /* renamed from: a, reason: collision with root package name */
        public final Appendable f17174a;

        /* renamed from: b, reason: collision with root package name */
        public final Document.OutputSettings f17175b;

        public b(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f17174a = appendable;
            this.f17175b = outputSettings;
            outputSettings.a();
        }

        @Override // hh.a
        public void head(g gVar, int i10) {
            try {
                gVar.a(this.f17174a, i10, this.f17175b);
            } catch (IOException e10) {
                throw new SerializationException(e10);
            }
        }

        @Override // hh.a
        public void tail(g gVar, int i10) {
            if (gVar.nodeName().equals("#text")) {
                return;
            }
            try {
                gVar.b(this.f17174a, i10, this.f17175b);
            } catch (IOException e10) {
                throw new SerializationException(e10);
            }
        }
    }

    public abstract void a(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException;

    public String absUrl(String str) {
        dh.f.notEmpty(str);
        return !hasAttr(str) ? "" : dh.e.resolve(baseUri(), attr(str));
    }

    public void addChildren(int i10, g... gVarArr) {
        dh.f.noNullElements(gVarArr);
        List<g> listEnsureChildNodes = ensureChildNodes();
        for (g gVar : gVarArr) {
            reparentChild(gVar);
        }
        listEnsureChildNodes.addAll(i10, Arrays.asList(gVarArr));
        List<g> listEnsureChildNodes2 = ensureChildNodes();
        while (i10 < listEnsureChildNodes2.size()) {
            listEnsureChildNodes2.get(i10).setSiblingIndex(i10);
            i10++;
        }
    }

    public String attr(String str) {
        dh.f.notNull(str);
        if (!hasAttributes()) {
            return "";
        }
        String ignoreCase = attributes().getIgnoreCase(str);
        return ignoreCase.length() > 0 ? ignoreCase : str.startsWith("abs:") ? absUrl(str.substring(4)) : "";
    }

    public abstract org.jsoup.nodes.b attributes();

    public abstract void b(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException;

    public abstract String baseUri();

    public g before(g gVar) {
        dh.f.notNull(gVar);
        dh.f.notNull(this.f17171b);
        this.f17171b.addChildren(this.f17172m, gVar);
        return this;
    }

    public g childNode(int i10) {
        return ensureChildNodes().get(i10);
    }

    public abstract int childNodeSize();

    public List<g> childNodes() {
        return Collections.unmodifiableList(ensureChildNodes());
    }

    public g doClone(g gVar) {
        try {
            g gVar2 = (g) super.clone();
            gVar2.f17171b = gVar;
            gVar2.f17172m = gVar == null ? 0 : this.f17172m;
            return gVar2;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public abstract void doSetBaseUri(String str);

    public abstract List<g> ensureChildNodes();

    public boolean equals(Object obj) {
        return this == obj;
    }

    public boolean hasAttr(String str) {
        dh.f.notNull(str);
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring(4);
            if (attributes().hasKeyIgnoreCase(strSubstring) && !absUrl(strSubstring).equals("")) {
                return true;
            }
        }
        return attributes().hasKeyIgnoreCase(str);
    }

    public abstract boolean hasAttributes();

    public boolean hasParent() {
        return this.f17171b != null;
    }

    public void indent(Appendable appendable, int i10, Document.OutputSettings outputSettings) throws IOException {
        appendable.append('\n').append(dh.e.padding(outputSettings.indentAmount() * i10));
    }

    public g nextSibling() {
        g gVar = this.f17171b;
        if (gVar == null) {
            return null;
        }
        List<g> listEnsureChildNodes = gVar.ensureChildNodes();
        int i10 = this.f17172m + 1;
        if (listEnsureChildNodes.size() > i10) {
            return listEnsureChildNodes.get(i10);
        }
        return null;
    }

    public abstract String nodeName();

    public String outerHtml() {
        StringBuilder sb2 = new StringBuilder(128);
        outerHtml(sb2);
        return sb2.toString();
    }

    public Document ownerDocument() {
        g gVarRoot = root();
        if (gVarRoot instanceof Document) {
            return (Document) gVarRoot;
        }
        return null;
    }

    public g parent() {
        return this.f17171b;
    }

    public final g parentNode() {
        return this.f17171b;
    }

    public void remove() {
        dh.f.notNull(this.f17171b);
        this.f17171b.removeChild(this);
    }

    public void removeChild(g gVar) {
        dh.f.isTrue(gVar.f17171b == this);
        int i10 = gVar.f17172m;
        ensureChildNodes().remove(i10);
        List<g> listEnsureChildNodes = ensureChildNodes();
        while (i10 < listEnsureChildNodes.size()) {
            listEnsureChildNodes.get(i10).setSiblingIndex(i10);
            i10++;
        }
        gVar.f17171b = null;
    }

    public void reparentChild(g gVar) {
        gVar.setParentNode(this);
    }

    public void replaceChild(g gVar, g gVar2) {
        dh.f.isTrue(gVar.f17171b == this);
        dh.f.notNull(gVar2);
        g gVar3 = gVar2.f17171b;
        if (gVar3 != null) {
            gVar3.removeChild(gVar2);
        }
        int i10 = gVar.f17172m;
        ensureChildNodes().set(i10, gVar2);
        gVar2.f17171b = this;
        gVar2.setSiblingIndex(i10);
        gVar.f17171b = null;
    }

    public void replaceWith(g gVar) {
        dh.f.notNull(gVar);
        dh.f.notNull(this.f17171b);
        this.f17171b.replaceChild(this, gVar);
    }

    public g root() {
        g gVar = this;
        while (true) {
            g gVar2 = gVar.f17171b;
            if (gVar2 == null) {
                return gVar;
            }
            gVar = gVar2;
        }
    }

    public void setBaseUri(String str) {
        dh.f.notNull(str);
        traverse(new a(str));
    }

    public void setParentNode(g gVar) {
        dh.f.notNull(gVar);
        g gVar2 = this.f17171b;
        if (gVar2 != null) {
            gVar2.removeChild(this);
        }
        this.f17171b = gVar;
    }

    public void setSiblingIndex(int i10) {
        this.f17172m = i10;
    }

    public int siblingIndex() {
        return this.f17172m;
    }

    public List<g> siblingNodes() {
        g gVar = this.f17171b;
        if (gVar == null) {
            return Collections.emptyList();
        }
        List<g> listEnsureChildNodes = gVar.ensureChildNodes();
        ArrayList arrayList = new ArrayList(listEnsureChildNodes.size() - 1);
        for (g gVar2 : listEnsureChildNodes) {
            if (gVar2 != this) {
                arrayList.add(gVar2);
            }
        }
        return arrayList;
    }

    public String toString() {
        return outerHtml();
    }

    public g traverse(hh.a aVar) {
        dh.f.notNull(aVar);
        org.jsoup.select.d.traverse(aVar, this);
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public g mo226clone() {
        g gVarDoClone = doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(gVarDoClone);
        while (!linkedList.isEmpty()) {
            g gVar = (g) linkedList.remove();
            int iChildNodeSize = gVar.childNodeSize();
            for (int i10 = 0; i10 < iChildNodeSize; i10++) {
                List<g> listEnsureChildNodes = gVar.ensureChildNodes();
                g gVarDoClone2 = listEnsureChildNodes.get(i10).doClone(gVar);
                listEnsureChildNodes.set(i10, gVarDoClone2);
                linkedList.add(gVarDoClone2);
            }
        }
        return gVarDoClone;
    }

    public void outerHtml(Appendable appendable) {
        Document documentOwnerDocument = ownerDocument();
        if (documentOwnerDocument == null) {
            documentOwnerDocument = new Document("");
        }
        org.jsoup.select.d.traverse(new b(appendable, documentOwnerDocument.outputSettings()), this);
    }

    public g attr(String str, String str2) {
        org.jsoup.nodes.b bVarAttributes = attributes();
        int iD = bVarAttributes.d(str);
        if (iD != -1) {
            bVarAttributes.f17168n[iD] = str2;
            if (!bVarAttributes.f17167m[iD].equals(str)) {
                bVarAttributes.f17167m[iD] = str;
            }
        } else {
            bVarAttributes.a(bVarAttributes.f17166b + 1);
            String[] strArr = bVarAttributes.f17167m;
            int i10 = bVarAttributes.f17166b;
            strArr[i10] = str;
            bVarAttributes.f17168n[i10] = str2;
            bVarAttributes.f17166b = i10 + 1;
        }
        return this;
    }

    /* compiled from: Node.java */
    public class a implements hh.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17173a;

        public a(String str) {
            this.f17173a = str;
        }

        @Override // hh.a
        public void head(g gVar, int i10) {
            gVar.doSetBaseUri(this.f17173a);
        }

        @Override // hh.a
        public void tail(g gVar, int i10) {
        }
    }
}
