package mf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: _Arrays.kt */
/* loaded from: classes2.dex */
public class i extends h {
    public static final <T> boolean contains(T[] tArr, T t10) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        return indexOf(tArr, t10) >= 0;
    }

    public static final <T> List<T> filterNotNull(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C c10) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        zf.i.checkNotNullParameter(c10, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    public static final <T> int getLastIndex(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final <T> int indexOf(T[] tArr, T t10) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (zf.i.areEqual(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, yf.l<? super T, ? extends CharSequence> lVar) throws IOException {
        zf.i.checkNotNullParameter(tArr, "<this>");
        zf.i.checkNotNullParameter(a10, "buffer");
        zf.i.checkNotNullParameter(charSequence, "separator");
        zf.i.checkNotNullParameter(charSequence2, "prefix");
        zf.i.checkNotNullParameter(charSequence3, "postfix");
        zf.i.checkNotNullParameter(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ig.h.appendElement(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T> String joinToString(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, yf.l<? super T, ? extends CharSequence> lVar) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        zf.i.checkNotNullParameter(charSequence, "separator");
        zf.i.checkNotNullParameter(charSequence2, "prefix");
        zf.i.checkNotNullParameter(charSequence3, "postfix");
        zf.i.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        zf.i.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, yf.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return joinToString(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final char single(char[] cArr) {
        zf.i.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T singleOrNull(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c10) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        zf.i.checkNotNullParameter(c10, "destination");
        for (T t10 : tArr) {
            c10.add(t10);
        }
        return c10;
    }

    public static final <T> List<T> toList(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? toMutableList(tArr) : j.listOf(tArr[0]) : k.emptyList();
    }

    public static final <T> List<T> toMutableList(T[] tArr) {
        zf.i.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(k.asCollection(tArr));
    }

    public static final boolean contains(char[] cArr, char c10) {
        zf.i.checkNotNullParameter(cArr, "<this>");
        return indexOf(cArr, c10) >= 0;
    }

    public static final int indexOf(char[] cArr, char c10) {
        zf.i.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }
}
