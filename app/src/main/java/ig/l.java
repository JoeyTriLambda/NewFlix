package ig;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.text.StringsKt__StringsKt;
import mf.t;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: StringsJVM.kt */
/* loaded from: classes2.dex */
public class l extends k {
    public static final String concatToString(char[] cArr) {
        zf.i.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static final byte[] encodeToByteArray(String str) {
        zf.i.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(c.f13440b);
        zf.i.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final boolean endsWith(String str, String str2, boolean z10) {
        zf.i.checkNotNullParameter(str, "<this>");
        zf.i.checkNotNullParameter(str2, "suffix");
        return !z10 ? str.endsWith(str2) : regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return endsWith(str, str2, z10);
    }

    public static final boolean equals(String str, String str2, boolean z10) {
        return str == null ? str2 == null : !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(zf.m mVar) {
        zf.i.checkNotNullParameter(mVar, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        zf.i.checkNotNullExpressionValue(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z10;
        zf.i.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable indices = StringsKt__StringsKt.getIndices(charSequence);
        if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
            z10 = true;
        } else {
            Iterator it = indices.iterator();
            while (it.hasNext()) {
                if (!a.isWhitespace(charSequence.charAt(((t) it).nextInt()))) {
                    z10 = false;
                    break;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public static final boolean regionMatches(String str, int i10, String str2, int i11, int i12, boolean z10) {
        zf.i.checkNotNullParameter(str, "<this>");
        zf.i.checkNotNullParameter(str2, "other");
        return !z10 ? str.regionMatches(i10, str2, i11, i12) : str.regionMatches(z10, i10, str2, i11, i12);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Iterator, mf.t] */
    public static final String repeat(CharSequence charSequence, int i10) {
        zf.i.checkNotNullParameter(charSequence, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(charSequence.length() * i10);
        ?? Iterator2 = new fg.c(1, i10).iterator();
        while (Iterator2.hasNext()) {
            Iterator2.nextInt();
            sb2.append(charSequence);
        }
        String string = sb2.toString();
        zf.i.checkNotNullExpressionValue(string, "{\n                    va…tring()\n                }");
        return string;
    }

    public static final String replace(String str, char c10, char c11, boolean z10) {
        zf.i.checkNotNullParameter(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            zf.i.checkNotNullExpressionValue(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (b.equals(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb2.append(cCharAt);
        }
        String string = sb2.toString();
        zf.i.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String replace$default(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return replace(str, c10, c11, z10);
    }

    public static final boolean startsWith(String str, String str2, boolean z10) {
        zf.i.checkNotNullParameter(str, "<this>");
        zf.i.checkNotNullParameter(str2, "prefix");
        return !z10 ? str.startsWith(str2) : regionMatches(str, 0, str2, 0, str2.length(), z10);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return startsWith(str, str2, z10);
    }

    public static final String concatToString(char[] cArr, int i10, int i11) {
        zf.i.checkNotNullParameter(cArr, "<this>");
        mf.a.f16294b.checkBoundsIndexes$kotlin_stdlib(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return replace(str, str2, str3, z10);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return startsWith(str, str2, i10, z10);
    }

    public static final boolean startsWith(String str, String str2, int i10, boolean z10) {
        zf.i.checkNotNullParameter(str, "<this>");
        zf.i.checkNotNullParameter(str2, "prefix");
        if (!z10) {
            return str.startsWith(str2, i10);
        }
        return regionMatches(str, i10, str2, 0, str2.length(), z10);
    }

    public static final String replace(String str, String str2, String str3, boolean z10) {
        zf.i.checkNotNullParameter(str, "<this>");
        zf.i.checkNotNullParameter(str2, "oldValue");
        zf.i.checkNotNullParameter(str3, "newValue");
        int i10 = 0;
        int iIndexOf = StringsKt__StringsKt.indexOf(str, str2, 0, z10);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str2.length();
        int iCoerceAtLeast = fg.h.coerceAtLeast(length, 1);
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append((CharSequence) str, i10, iIndexOf);
                sb2.append(str3);
                i10 = iIndexOf + length;
                if (iIndexOf >= str.length()) {
                    break;
                }
                iIndexOf = StringsKt__StringsKt.indexOf(str, str2, iIndexOf + iCoerceAtLeast, z10);
            } while (iIndexOf > 0);
            sb2.append((CharSequence) str, i10, str.length());
            String string = sb2.toString();
            zf.i.checkNotNullExpressionValue(string, "stringBuilder.append(this, i, length).toString()");
            return string;
        }
        throw new OutOfMemoryError();
    }
}
