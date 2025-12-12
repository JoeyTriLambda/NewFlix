package org.jsoup.parser;

import dh.f;
import java.io.Reader;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

/* compiled from: TreeBuilder.java */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public gh.a f17311a;

    /* renamed from: b, reason: collision with root package name */
    public b f17312b;

    /* renamed from: c, reason: collision with root package name */
    public Document f17313c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<Element> f17314d;

    /* renamed from: e, reason: collision with root package name */
    public String f17315e;

    /* renamed from: f, reason: collision with root package name */
    public Token f17316f;

    /* renamed from: g, reason: collision with root package name */
    public ParseErrorList f17317g;

    /* renamed from: h, reason: collision with root package name */
    public gh.c f17318h;

    /* renamed from: i, reason: collision with root package name */
    public final Token.g f17319i = new Token.g();

    /* renamed from: j, reason: collision with root package name */
    public final Token.f f17320j = new Token.f();

    public abstract gh.c a();

    public Element currentElement() {
        int size = this.f17314d.size();
        if (size > 0) {
            return this.f17314d.get(size - 1);
        }
        return null;
    }

    public void initialiseParse(Reader reader, String str, ParseErrorList parseErrorList, gh.c cVar) {
        f.notNull(reader, "String input must not be null");
        f.notNull(str, "BaseURI must not be null");
        this.f17313c = new Document(str);
        this.f17318h = cVar;
        this.f17311a = new gh.a(reader);
        this.f17317g = parseErrorList;
        this.f17316f = null;
        this.f17312b = new b(this.f17311a, parseErrorList);
        this.f17314d = new ArrayList<>(32);
        this.f17315e = str;
    }

    public abstract boolean process(Token token);

    public boolean processEndTag(String str) {
        Token token = this.f17316f;
        Token.f fVar = this.f17320j;
        if (token == fVar) {
            Token.f fVar2 = new Token.f();
            fVar2.n(str);
            return process(fVar2);
        }
        fVar.f();
        fVar.n(str);
        return process(fVar);
    }

    public boolean processStartTag(String str) {
        Token token = this.f17316f;
        Token.g gVar = this.f17319i;
        if (token == gVar) {
            Token.g gVar2 = new Token.g();
            gVar2.n(str);
            return process(gVar2);
        }
        gVar.f();
        gVar.n(str);
        return process(gVar);
    }

    public void runParser() {
        Token token;
        do {
            b bVar = this.f17312b;
            while (!bVar.f17298e) {
                bVar.f17296c.d(bVar, bVar.f17294a);
            }
            StringBuilder sb2 = bVar.f17300g;
            int length = sb2.length();
            Token.b bVar2 = bVar.f17305l;
            if (length > 0) {
                String string = sb2.toString();
                sb2.delete(0, sb2.length());
                bVar.f17299f = null;
                bVar2.f17218b = string;
                token = bVar2;
            } else {
                String str = bVar.f17299f;
                if (str != null) {
                    bVar2.f17218b = str;
                    bVar.f17299f = null;
                    token = bVar2;
                } else {
                    bVar.f17298e = false;
                    token = bVar.f17297d;
                }
            }
            process(token);
            token.f();
        } while (token.f17210a != Token.TokenType.EOF);
    }

    public boolean processStartTag(String str, org.jsoup.nodes.b bVar) {
        Token token = this.f17316f;
        Token.g gVar = this.f17319i;
        if (token == gVar) {
            Token.g gVar2 = new Token.g();
            gVar2.f17226b = str;
            gVar2.f17234j = bVar;
            gVar2.f17227c = eh.b.lowerCase(str);
            return process(gVar2);
        }
        gVar.f();
        gVar.f17226b = str;
        gVar.f17234j = bVar;
        gVar.f17227c = eh.b.lowerCase(str);
        return process(gVar);
    }
}
