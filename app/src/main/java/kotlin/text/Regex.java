package kotlin.text;

import ig.g;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zf.f;
import zf.i;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class Regex implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final Pattern f15270b;

    /* compiled from: Regex.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
    }

    public Regex(Pattern pattern) {
        i.checkNotNullParameter(pattern, "nativePattern");
        this.f15270b = pattern;
    }

    public final ig.f find(CharSequence charSequence, int i10) {
        i.checkNotNullParameter(charSequence, "input");
        Matcher matcher = this.f15270b.matcher(charSequence);
        i.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return g.access$findNext(matcher, i10, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "input");
        return this.f15270b.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, String str) {
        i.checkNotNullParameter(charSequence, "input");
        i.checkNotNullParameter(str, "replacement");
        String strReplaceAll = this.f15270b.matcher(charSequence).replaceAll(str);
        i.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f15270b.toString();
        i.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        i.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        i.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
        this(patternCompile);
    }
}
