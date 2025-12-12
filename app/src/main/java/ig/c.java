package ig;

import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: Charsets.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f13439a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f13440b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Charset f13441c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile Charset f13442d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        zf.i.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
        f13440b = charsetForName;
        zf.i.checkNotNullExpressionValue(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        zf.i.checkNotNullExpressionValue(Charset.forName(CharEncoding.UTF_16BE), "forName(\"UTF-16BE\")");
        zf.i.checkNotNullExpressionValue(Charset.forName(CharEncoding.UTF_16LE), "forName(\"UTF-16LE\")");
        zf.i.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        zf.i.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }

    public final Charset UTF32_BE() {
        Charset charset = f13442d;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        zf.i.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-32BE\")");
        f13442d = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = f13441c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        zf.i.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-32LE\")");
        f13441c = charsetForName;
        return charsetForName;
    }
}
