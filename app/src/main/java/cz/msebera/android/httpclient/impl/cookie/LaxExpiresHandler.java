package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.message.ParserCursor;
import java.util.BitSet;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class LaxExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final BitSet DELIMS;
    private static final Map<String, Integer> MONTHS;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final Pattern YEAR_PATTERN;

    static {
        BitSet bitSet = new BitSet();
        bitSet.set(9);
        for (int i10 = 32; i10 <= 47; i10++) {
            bitSet.set(i10);
        }
        for (int i11 = 59; i11 <= 64; i11++) {
            bitSet.set(i11);
        }
        for (int i12 = 91; i12 <= 96; i12++) {
            bitSet.set(i12);
        }
        for (int i13 = 123; i13 <= 126; i13++) {
            bitSet.set(i13);
        }
        DELIMS = bitSet;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(12);
        concurrentHashMap.put("jan", 0);
        concurrentHashMap.put("feb", 1);
        concurrentHashMap.put("mar", 2);
        concurrentHashMap.put("apr", 3);
        concurrentHashMap.put("may", 4);
        concurrentHashMap.put("jun", 5);
        concurrentHashMap.put("jul", 6);
        concurrentHashMap.put("aug", 7);
        concurrentHashMap.put("sep", 8);
        concurrentHashMap.put("oct", 9);
        concurrentHashMap.put("nov", 10);
        concurrentHashMap.put("dec", 11);
        MONTHS = concurrentHashMap;
        TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
        DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
        MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
        YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
    }

    private void copyContent(CharSequence charSequence, ParserCursor parserCursor, StringBuilder sb2) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charSequence.charAt(pos2);
            if (DELIMS.get(cCharAt)) {
                break;
            }
            pos++;
            sb2.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    private void skipDelims(CharSequence charSequence, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            if (!DELIMS.get(charSequence.charAt(pos2))) {
                break;
            }
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return "expires";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parse(cz.msebera.android.httpclient.cookie.SetCookie r21, java.lang.String r22) throws cz.msebera.android.httpclient.cookie.MalformedCookieException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.cookie.LaxExpiresHandler.parse(cz.msebera.android.httpclient.cookie.SetCookie, java.lang.String):void");
    }
}
