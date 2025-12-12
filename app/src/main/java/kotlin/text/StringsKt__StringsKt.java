package kotlin.text;

import fg.c;
import fg.h;
import hg.f;
import ig.b;
import ig.d;
import ig.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import lf.g;
import mf.j;
import mf.q;
import org.apache.commons.lang3.StringUtils;
import yf.p;
import zf.i;

/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public class StringsKt__StringsKt extends l {
    public static final int a(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        fg.a cVar = !z11 ? new c(h.coerceAtLeast(i10, 0), h.coerceAtMost(i11, charSequence.length())) : h.downTo(h.coerceAtMost(i10, getLastIndex(charSequence)), h.coerceAtLeast(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = cVar.getFirst();
            int last = cVar.getLast();
            int step = cVar.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (!l.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z10)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = cVar.getFirst();
        int last2 = cVar.getLast();
        int step2 = cVar.getStep();
        if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z10)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    public static final Pair access$findAnyOf(CharSequence charSequence, Collection collection, int i10, boolean z10, boolean z11) {
        Object next;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) q.single(collection);
            int iIndexOf$default = !z11 ? indexOf$default(charSequence, str, i10, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i10, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return g.to(Integer.valueOf(iIndexOf$default), str);
        }
        fg.a cVar = !z11 ? new c(h.coerceAtLeast(i10, 0), charSequence.length()) : h.downTo(h.coerceAtMost(i10, getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = cVar.getFirst();
            int last = cVar.getLast();
            int step = cVar.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return null;
            }
            while (true) {
                Iterator it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    String str2 = (String) next2;
                    if (l.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z10)) {
                        break;
                    }
                }
                String str3 = (String) next2;
                if (str3 != null) {
                    return g.to(Integer.valueOf(first), str3);
                }
                if (first == last) {
                    return null;
                }
                first += step;
            }
        } else {
            int first2 = cVar.getFirst();
            int last2 = cVar.getLast();
            int step2 = cVar.getStep();
            if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
                return null;
            }
            while (true) {
                Iterator it2 = collection.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    String str4 = (String) next;
                    if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z10)) {
                        break;
                    }
                }
                String str5 = (String) next;
                if (str5 != null) {
                    return g.to(Integer.valueOf(first2), str5);
                }
                if (first2 == last2) {
                    return null;
                }
                first2 += step2;
            }
        }
    }

    public static d b(CharSequence charSequence, String[] strArr, final boolean z10, int i10) {
        requireNonNegativeLimit(i10);
        final List listAsList = mf.h.asList(strArr);
        return new d(charSequence, 0, i10, new p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // yf.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i11) {
                i.checkNotNullParameter(charSequence2, "$this$$receiver");
                Pair pairAccess$findAnyOf = StringsKt__StringsKt.access$findAnyOf(charSequence2, listAsList, i11, z10, false);
                if (pairAccess$findAnyOf != null) {
                    return g.to(pairAccess$findAnyOf.getFirst(), Integer.valueOf(((String) pairAccess$findAnyOf.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static final List c(CharSequence charSequence, String str, int i10, boolean z10) {
        requireNonNegativeLimit(i10);
        int length = 0;
        int iIndexOf = indexOf(charSequence, str, 0, z10);
        if (iIndexOf == -1 || i10 == 1) {
            return j.listOf(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? h.coerceAtMost(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, z10);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(charSequence2, "other");
        return !(charSequence2 instanceof String) ? a(charSequence, charSequence2, 0, charSequence.length(), z10, false) < 0 : indexOf$default(charSequence, (String) charSequence2, 0, z10, 2, (Object) null) < 0;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return contains(charSequence, charSequence2, z10);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(charSequence2, "suffix");
        return (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? l.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z10);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return endsWith(charSequence, charSequence2, z10);
    }

    public static final c getIndices(CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "<this>");
        return new c(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, char c10, int i10, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return indexOf(charSequence, c10, i10, z10);
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.Iterator, mf.t] */
    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        boolean z11;
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(mf.i.single(cArr), i10);
        }
        ?? it = new c(h.coerceAtLeast(i10, 0), getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            int length = cArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (b.equals(cArr[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iNextInt;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(CharSequence charSequence, char c10, int i10, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = getLastIndex(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return lastIndexOf(charSequence, c10, i10, z10);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i10, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(cArr, "chars");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(mf.i.single(cArr), i10);
        }
        for (int iCoerceAtMost = h.coerceAtMost(i10, getLastIndex(charSequence)); -1 < iCoerceAtMost; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            int length = cArr.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (b.equals(cArr[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iCoerceAtMost;
            }
        }
        return -1;
    }

    public static final hg.d<String> lineSequence(CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "<this>");
        return splitToSequence$default(charSequence, new String[]{"\r\n", StringUtils.LF, StringUtils.CR}, false, 0, 6, null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "<this>");
        return f.toList(lineSequence(charSequence));
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.Iterator, mf.t] */
    public static final CharSequence padStart(CharSequence charSequence, int i10, char c10) {
        i.checkNotNullParameter(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(o1.a.d("Desired length ", i10, " is less than zero."));
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        ?? it = new c(1, i10 - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.nextInt();
            sb2.append(c10);
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(charSequence2, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.equals(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(charSequence, "prefix");
        if (!startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(charSequence, "suffix");
        if (!endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(charSequence, "prefix");
        i.checkNotNullParameter(charSequence2, "suffix");
        if (str.length() < charSequence2.length() + charSequence.length() || !startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) || !endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final void requireNonNegativeLimit(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(ac.c.f("Limit must be non-negative, but was ", i10).toString());
        }
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return c(charSequence, str, i10, z10);
            }
        }
        Iterable iterableAsIterable = f.asIterable(b(charSequence, strArr, z10, i10));
        ArrayList arrayList = new ArrayList(mf.l.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (c) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return split(charSequence, strArr, z10, i10);
    }

    public static final hg.d<String> splitToSequence(final CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(strArr, "delimiters");
        return f.map(b(charSequence, strArr, z10, i10), new yf.l<c, String>() { // from class: kotlin.text.StringsKt__StringsKt.splitToSequence.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // yf.l
            public final String invoke(c cVar) {
                i.checkNotNullParameter(cVar, "it");
                return StringsKt__StringsKt.substring(charSequence, cVar);
            }
        });
    }

    public static /* synthetic */ hg.d splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return splitToSequence(charSequence, strArr, z10, i10);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(charSequence2, "prefix");
        return (!z10 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? l.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z10);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return startsWith(charSequence, charSequence2, z10);
    }

    public static final String substring(CharSequence charSequence, c cVar) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(cVar, "range");
        return charSequence.subSequence(cVar.getStart().intValue(), cVar.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String str, char c10, String str2) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(str2, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, c10, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iIndexOf$default + 1, str.length());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c10, str2);
    }

    public static final String substringAfterLast(String str, char c10, String str2) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(str2, "missingDelimiterValue");
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c10, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str2;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1, str.length());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c10, str2);
    }

    public static final String trim(String str, char... cArr) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(cArr, "chars");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zContains = mf.i.contains(cArr, str.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return contains(charSequence, c10, z10);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return indexOf(charSequence, str, i10, z10);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = getLastIndex(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return lastIndexOf(charSequence, str, i10, z10);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return split(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(charSequence, "delimiter");
        return removeSurrounding(str, charSequence, charSequence);
    }

    public static final String substringAfter(String str, String str2, String str3) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(str2, "delimiter");
        i.checkNotNullParameter(str3, "missingDelimiterValue");
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iIndexOf$default, str.length());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i10, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(str, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i10);
        }
        return a(charSequence, str, i10, charSequence.length(), z10, false);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i10, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(str, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i10);
        }
        return a(charSequence, str, i10, 0, z10, true);
    }

    public static final boolean contains(CharSequence charSequence, char c10, boolean z10) {
        i.checkNotNullParameter(charSequence, "<this>");
        return indexOf$default(charSequence, c10, 0, z10, 2, (Object) null) >= 0;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zIsWhitespace = ig.a.isWhitespace(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final List<String> split(CharSequence charSequence, final char[] cArr, final boolean z10, int i10) {
        i.checkNotNullParameter(charSequence, "<this>");
        i.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return c(charSequence, String.valueOf(cArr[0]), i10, z10);
        }
        requireNonNegativeLimit(i10);
        Iterable iterableAsIterable = f.asIterable(new d(charSequence, 0, i10, new p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // yf.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i11) {
                i.checkNotNullParameter(charSequence2, "$this$$receiver");
                int iIndexOfAny = StringsKt__StringsKt.indexOfAny(charSequence2, cArr, i11, z10);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return g.to(Integer.valueOf(iIndexOfAny), 1);
            }
        }));
        ArrayList arrayList = new ArrayList(mf.l.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (c) it.next()));
        }
        return arrayList;
    }

    public static final String padStart(String str, int i10, char c10) {
        i.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i10, c10).toString();
    }
}
