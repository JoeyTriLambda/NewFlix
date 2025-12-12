package kotlin.text;

import ig.h;
import ig.l;
import ig.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mf.k;
import mf.q;
import org.apache.commons.lang3.StringUtils;
import zf.i;

/* compiled from: Indent.kt */
/* loaded from: classes2.dex */
public class a extends h {
    public static final String replaceIndent(String str, String str2) {
        int length;
        String str3;
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(str2, "newIndent");
        List<String> listLines = StringsKt__StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listLines.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (true ^ l.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(mf.l.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it2.hasNext()) {
                break;
            }
            String str4 = (String) it2.next();
            int length2 = str4.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!ig.a.isWhitespace(str4.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str4.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Integer num = (Integer) q.minOrNull(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int size = (listLines.size() * str2.length()) + str.length();
        yf.l stringsKt__IndentKt$getIndentFunction$2 = str2.length() == 0 ? StringsKt__IndentKt$getIndentFunction$1.f15271b : new StringsKt__IndentKt$getIndentFunction$2(str2);
        int lastIndex = k.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : listLines) {
            int i10 = length + 1;
            if (length < 0) {
                k.throwIndexOverflow();
            }
            String str5 = (String) obj;
            if ((length == 0 || length == lastIndex) && l.isBlank(str5)) {
                str5 = null;
            } else {
                String strDrop = m.drop(str5, iIntValue);
                if (strDrop != null && (str3 = (String) stringsKt__IndentKt$getIndentFunction$2.invoke(strDrop)) != null) {
                    str5 = str3;
                }
            }
            if (str5 != null) {
                arrayList3.add(str5);
            }
            length = i10;
        }
        String string = ((StringBuilder) q.joinTo(arrayList3, new StringBuilder(size), (124 & 2) != 0 ? ", " : StringUtils.LF, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        i.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String replaceIndentByMargin(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.a.replaceIndentByMargin(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static final String trimIndent(String str) {
        i.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String str2) {
        i.checkNotNullParameter(str, "<this>");
        i.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
