package org.apache.commons.lang3.text;

import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

@Deprecated
/* loaded from: classes2.dex */
public class FormattableUtils {
    private static final String SIMPLEST_FORMAT = "%s";

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i10, int i11, int i12) {
        return append(charSequence, formatter, i10, i11, i12, TokenParser.SP, null);
    }

    public static String toString(Formattable formattable) {
        return String.format(SIMPLEST_FORMAT, formattable);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i10, int i11, int i12, char c10) {
        return append(charSequence, formatter, i10, i11, i12, c10, null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i10, int i11, int i12, CharSequence charSequence2) {
        return append(charSequence, formatter, i10, i11, i12, TokenParser.SP, charSequence2);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i10, int i11, int i12, char c10, CharSequence charSequence2) {
        Validate.isTrue(charSequence2 == null || i12 < 0 || charSequence2.length() <= i12, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i12));
        StringBuilder sb2 = new StringBuilder(charSequence);
        if (i12 >= 0 && i12 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.defaultIfNull(charSequence2, "");
            sb2.replace(i12 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        boolean z10 = (i10 & 1) == 1;
        for (int length = sb2.length(); length < i11; length++) {
            sb2.insert(z10 ? length : 0, c10);
        }
        formatter.format(sb2.toString(), new Object[0]);
        return formatter;
    }
}
