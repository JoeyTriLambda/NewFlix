package gh;

import com.unity3d.services.core.device.MimeTypes;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.HashMap;

/* compiled from: Tag.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f12850j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f12851k;

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f12852l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f12853m;

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f12854n;

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f12855o;

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f12856p;

    /* renamed from: a, reason: collision with root package name */
    public final String f12857a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12858b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12859c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12860d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12861e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12862f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12863g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12864h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12865i = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", MimeTypes.BASE_TYPE_VIDEO, MimeTypes.BASE_TYPE_AUDIO, "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math"};
        f12851k = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", JsonStorageKeyNames.DATA_KEY, "bdi", "s"};
        f12852l = new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        f12853m = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        f12854n = new String[]{"pre", "plaintext", "title", "textarea"};
        f12855o = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        f12856p = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (int i10 = 0; i10 < 63; i10++) {
            String str = strArr[i10];
            f12850j.put(str, new e(str));
        }
        for (String str2 : f12851k) {
            e eVar = new e(str2);
            eVar.f12858b = false;
            eVar.f12859c = false;
            f12850j.put(str2, eVar);
        }
        for (String str3 : f12852l) {
            e eVar2 = (e) f12850j.get(str3);
            dh.f.notNull(eVar2);
            eVar2.f12860d = false;
            eVar2.f12861e = true;
        }
        for (String str4 : f12853m) {
            e eVar3 = (e) f12850j.get(str4);
            dh.f.notNull(eVar3);
            eVar3.f12859c = false;
        }
        for (String str5 : f12854n) {
            e eVar4 = (e) f12850j.get(str5);
            dh.f.notNull(eVar4);
            eVar4.f12863g = true;
        }
        for (String str6 : f12855o) {
            e eVar5 = (e) f12850j.get(str6);
            dh.f.notNull(eVar5);
            eVar5.f12864h = true;
        }
        for (String str7 : f12856p) {
            e eVar6 = (e) f12850j.get(str7);
            dh.f.notNull(eVar6);
            eVar6.f12865i = true;
        }
    }

    public e(String str) {
        this.f12857a = str;
    }

    public static e valueOf(String str, c cVar) {
        dh.f.notNull(str);
        HashMap map = f12850j;
        e eVar = (e) map.get(str);
        if (eVar != null) {
            return eVar;
        }
        String strA = cVar.a(str);
        dh.f.notEmpty(strA);
        e eVar2 = (e) map.get(strA);
        if (eVar2 != null) {
            return eVar2;
        }
        e eVar3 = new e(strA);
        eVar3.f12858b = false;
        return eVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f12857a.equals(eVar.f12857a) && this.f12860d == eVar.f12860d && this.f12861e == eVar.f12861e && this.f12859c == eVar.f12859c && this.f12858b == eVar.f12858b && this.f12863g == eVar.f12863g && this.f12862f == eVar.f12862f && this.f12864h == eVar.f12864h && this.f12865i == eVar.f12865i;
    }

    public boolean formatAsBlock() {
        return this.f12859c;
    }

    public String getName() {
        return this.f12857a;
    }

    public int hashCode() {
        return (((((((((((((((this.f12857a.hashCode() * 31) + (this.f12858b ? 1 : 0)) * 31) + (this.f12859c ? 1 : 0)) * 31) + (this.f12860d ? 1 : 0)) * 31) + (this.f12861e ? 1 : 0)) * 31) + (this.f12862f ? 1 : 0)) * 31) + (this.f12863g ? 1 : 0)) * 31) + (this.f12864h ? 1 : 0)) * 31) + (this.f12865i ? 1 : 0);
    }

    public boolean isBlock() {
        return this.f12858b;
    }

    public boolean isEmpty() {
        return this.f12861e;
    }

    public boolean isFormListed() {
        return this.f12864h;
    }

    public boolean isKnownTag() {
        return f12850j.containsKey(this.f12857a);
    }

    public boolean isSelfClosing() {
        return this.f12861e || this.f12862f;
    }

    public boolean preserveWhitespace() {
        return this.f12863g;
    }

    public String toString() {
        return this.f12857a;
    }

    public static e valueOf(String str) {
        return valueOf(str, c.f12844d);
    }
}
