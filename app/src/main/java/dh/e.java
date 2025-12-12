package dh;

import cz.msebera.android.httpclient.message.TokenParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: StringUtil.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11066a = {"", StringUtils.SPACE, "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};

    /* renamed from: b, reason: collision with root package name */
    public static final a f11067b = new a();

    /* compiled from: StringUtil.java */
    public class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder(8192);
        }
    }

    public static void appendNormalisedWhitespace(StringBuilder sb2, String str, boolean z10) {
        int length = str.length();
        int iCharCount = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (isActuallyWhitespace(iCodePointAt)) {
                if ((!z10 || z11) && !z12) {
                    sb2.append(TokenParser.SP);
                    z12 = true;
                }
            } else if (!isInvisibleChar(iCodePointAt)) {
                sb2.appendCodePoint(iCodePointAt);
                z11 = true;
                z12 = false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    public static boolean in(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean inSorted(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean isActuallyWhitespace(int i10) {
        return i10 == 32 || i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 160;
    }

    public static boolean isBlank(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!isWhitespace(str.codePointAt(i10))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isInvisibleChar(int i10) {
        return Character.getType(i10) == 16 && (i10 == 8203 || i10 == 8204 || i10 == 8205 || i10 == 173);
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isDigit(str.codePointAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(int i10) {
        return i10 == 32 || i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13;
    }

    public static String join(Collection collection, String str) {
        return join(collection.iterator(), str);
    }

    public static String padding(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (i10 < 21) {
            return f11066a[i10];
        }
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            cArr[i11] = TokenParser.SP;
        }
        return String.valueOf(cArr);
    }

    public static URL resolve(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            url = new URL(url.getProtocol(), url.getHost(), url.getPort(), "/" + url.getFile());
        }
        return new URL(url, str);
    }

    public static StringBuilder stringBuilder() {
        a aVar = f11067b;
        StringBuilder sb2 = aVar.get();
        if (sb2.length() <= 8192) {
            sb2.delete(0, sb2.length());
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder(8192);
        aVar.set(sb3);
        return sb3;
    }

    public static String join(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String string = it.next().toString();
        if (!it.hasNext()) {
            return string;
        }
        StringBuilder sbQ = ac.c.q(64, string);
        while (it.hasNext()) {
            sbQ.append(str);
            sbQ.append(it.next());
        }
        return sbQ.toString();
    }

    public static String resolve(String str, String str2) {
        try {
            try {
                return resolve(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return new URL(str2).toExternalForm();
            }
        } catch (MalformedURLException unused2) {
            return "";
        }
    }
}
