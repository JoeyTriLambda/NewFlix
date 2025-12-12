package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.jsoup.nodes.Entities;

/* loaded from: classes2.dex */
public final class Document extends Element {

    /* renamed from: t, reason: collision with root package name */
    public OutputSettings f17124t;

    /* renamed from: u, reason: collision with root package name */
    public QuirksMode f17125u;

    public static class OutputSettings implements Cloneable {

        /* renamed from: m, reason: collision with root package name */
        public Charset f17127m;

        /* renamed from: o, reason: collision with root package name */
        public Entities.CoreCharset f17129o;

        /* renamed from: b, reason: collision with root package name */
        public Entities.EscapeMode f17126b = Entities.EscapeMode.base;

        /* renamed from: n, reason: collision with root package name */
        public final ThreadLocal<CharsetEncoder> f17128n = new ThreadLocal<>();

        /* renamed from: p, reason: collision with root package name */
        public final boolean f17130p = true;

        /* renamed from: q, reason: collision with root package name */
        public final int f17131q = 1;

        /* renamed from: r, reason: collision with root package name */
        public Syntax f17132r = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            charset(Charset.forName("UTF8"));
        }

        public final CharsetEncoder a() {
            CharsetEncoder charsetEncoderNewEncoder = this.f17127m.newEncoder();
            this.f17128n.set(charsetEncoderNewEncoder);
            String strName = charsetEncoderNewEncoder.charset().name();
            this.f17129o = strName.equals("US-ASCII") ? Entities.CoreCharset.ascii : strName.startsWith("UTF-") ? Entities.CoreCharset.utf : Entities.CoreCharset.fallback;
            return charsetEncoderNewEncoder;
        }

        public Charset charset() {
            return this.f17127m;
        }

        public Entities.EscapeMode escapeMode() {
            return this.f17126b;
        }

        public int indentAmount() {
            return this.f17131q;
        }

        public boolean outline() {
            return false;
        }

        public boolean prettyPrint() {
            return this.f17130p;
        }

        public Syntax syntax() {
            return this.f17132r;
        }

        public OutputSettings charset(Charset charset) {
            this.f17127m = charset;
            return this;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.f17127m.name());
                outputSettings.f17126b = Entities.EscapeMode.valueOf(this.f17126b.name());
                return outputSettings;
            } catch (CloneNotSupportedException e10) {
                throw new RuntimeException(e10);
            }
        }

        public OutputSettings syntax(Syntax syntax) {
            this.f17132r = syntax;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        /* JADX INFO: Fake field, exist only in values array */
        limitedQuirks
    }

    public Document(String str) {
        super(gh.e.valueOf("#root", gh.c.f12843c), str);
        this.f17124t = new OutputSettings();
        this.f17125u = QuirksMode.noQuirks;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.g
    public String nodeName() {
        return "#document";
    }

    @Override // org.jsoup.nodes.g
    public String outerHtml() {
        return super.html();
    }

    public OutputSettings outputSettings() {
        return this.f17124t;
    }

    public QuirksMode quirksMode() {
        return this.f17125u;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.f17125u = quirksMode;
        return this;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.g
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Document mo226clone() {
        Document document = (Document) super.mo226clone();
        document.f17124t = this.f17124t.clone();
        return document;
    }
}
