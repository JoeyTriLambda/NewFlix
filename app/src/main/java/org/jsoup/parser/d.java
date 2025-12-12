package org.jsoup.parser;

import gh.e;
import java.io.Reader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.f;
import org.jsoup.nodes.i;
import org.jsoup.nodes.j;
import org.jsoup.parser.Token;

/* compiled from: XmlTreeBuilder.java */
/* loaded from: classes2.dex */
public final class d extends c {
    @Override // org.jsoup.parser.c
    public final gh.c a() {
        return gh.c.f12844d;
    }

    @Override // org.jsoup.parser.c
    public void initialiseParse(Reader reader, String str, ParseErrorList parseErrorList, gh.c cVar) {
        super.initialiseParse(reader, str, parseErrorList, cVar);
        this.f17314d.add(this.f17313c);
        this.f17313c.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [fh.c, org.jsoup.nodes.j] */
    @Override // org.jsoup.parser.c
    public boolean process(Token token) {
        Element element;
        Element element2;
        int iOrdinal = token.f17210a.ordinal();
        if (iOrdinal == 0) {
            Token.d dVar = (Token.d) token;
            f fVar = new f(this.f17318h.a(dVar.f17221b.toString()), dVar.f17223d.toString(), dVar.getSystemIdentifier());
            fVar.setPubSysKey(dVar.f17222c);
            currentElement().appendChild(fVar);
        } else if (iOrdinal == 1) {
            Token.g gVar = (Token.g) token;
            e eVarValueOf = e.valueOf(gVar.m(), this.f17318h);
            String str = this.f17315e;
            gh.c cVar = this.f17318h;
            org.jsoup.nodes.b bVar = gVar.f17234j;
            if (!cVar.f12846b) {
                bVar.normalize();
            }
            Element element3 = new Element(eVarValueOf, str, bVar);
            currentElement().appendChild(element3);
            if (!gVar.f17233i) {
                this.f17314d.add(element3);
            } else if (!eVarValueOf.isKnownTag()) {
                eVarValueOf.f12862f = true;
            }
        } else if (iOrdinal == 2) {
            String strA = this.f17318h.a(((Token.f) token).f17226b);
            int size = this.f17314d.size();
            while (true) {
                size--;
                if (size < 0) {
                    element = null;
                    break;
                }
                element = this.f17314d.get(size);
                if (element.nodeName().equals(strA)) {
                    break;
                }
            }
            if (element != null) {
                int size2 = this.f17314d.size();
                do {
                    size2--;
                    if (size2 < 0) {
                        break;
                    }
                    element2 = this.f17314d.get(size2);
                    this.f17314d.remove(size2);
                } while (element2 != element);
            }
        } else if (iOrdinal == 3) {
            Token.c cVar2 = (Token.c) token;
            org.jsoup.nodes.d dVar2 = new org.jsoup.nodes.d(cVar2.f17219b.toString());
            if (cVar2.f17220c) {
                String data = dVar2.getData();
                if (data.length() > 1 && (data.startsWith("!") || data.startsWith("?"))) {
                    Document document = ch.a.parse("<" + data.substring(1, data.length() - 1) + ">", this.f17315e, gh.d.xmlParser());
                    if (document.childNodeSize() > 0) {
                        Element elementChild = document.child(0);
                        ?? jVar = new j(this.f17318h.a(elementChild.tagName()), data.startsWith("!"));
                        jVar.attributes().addAll(elementChild.attributes());
                        dVar2 = jVar;
                    }
                }
            }
            currentElement().appendChild(dVar2);
        } else if (iOrdinal == 4) {
            Token.b bVar2 = (Token.b) token;
            String str2 = bVar2.f17218b;
            currentElement().appendChild(bVar2 instanceof Token.a ? new org.jsoup.nodes.c(str2) : new i(str2));
        } else if (iOrdinal != 5) {
            dh.f.fail("Unexpected token type: " + token.f17210a);
        }
        return true;
    }
}
