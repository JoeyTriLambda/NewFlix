package ig;

import java.util.NoSuchElementException;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: _Strings.kt */
/* loaded from: classes2.dex */
public class m extends StringsKt__StringsKt {
    public static final String drop(String str, int i10) {
        zf.i.checkNotNullParameter(str, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(o1.a.d("Requested character count ", i10, " is less than zero.").toString());
        }
        String strSubstring = str.substring(fg.h.coerceAtMost(i10, str.length()));
        zf.i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final char last(CharSequence charSequence) {
        zf.i.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(StringsKt__StringsKt.getLastIndex(charSequence));
    }

    public static final String take(String str, int i10) {
        zf.i.checkNotNullParameter(str, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(o1.a.d("Requested character count ", i10, " is less than zero.").toString());
        }
        String strSubstring = str.substring(0, fg.h.coerceAtMost(i10, str.length()));
        zf.i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
