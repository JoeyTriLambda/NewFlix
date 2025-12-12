package org.apache.commons.lang3.time;

import ac.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes2.dex */
public class FastDateParser implements DateParser, Serializable {
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final Comparator<String> LONGER_FIRST_LOWERCASE = new Comparator<String>() { // from class: org.apache.commons.lang3.time.FastDateParser.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    };
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: org.apache.commons.lang3.time.FastDateParser.2
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i10) {
            return i10 < 100 ? fastDateParser.adjustYear(i10) : i10;
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: org.apache.commons.lang3.time.FastDateParser.3
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i10) {
            return i10 - 1;
        }
    };
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) { // from class: org.apache.commons.lang3.time.FastDateParser.4
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i10) {
            if (i10 == 7) {
                return 1;
            }
            return 1 + i10;
        }
    };
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: org.apache.commons.lang3.time.FastDateParser.5
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i10) {
            if (i10 == 24) {
                return 0;
            }
            return i10;
        }
    };
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) { // from class: org.apache.commons.lang3.time.FastDateParser.6
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i10) {
            if (i10 == 12) {
                return 0;
            }
            return i10;
        }
    };
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    public static class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        final Locale locale;

        public CaseInsensitiveTextStrategy(int i10, Calendar calendar, Locale locale) {
            super();
            this.field = i10;
            this.locale = locale;
            StringBuilder sbR = c.r("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale, i10, sbR);
            sbR.setLength(sbR.length() - 1);
            sbR.append(")");
            createPattern(sbR);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.locale);
            Integer num = this.lKeyValues.get(lowerCase);
            if (num == null) {
                num = this.lKeyValues.get(lowerCase + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            calendar.set(this.field, num.intValue());
        }
    }

    public static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        public CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i10) {
            for (int i11 = 0; i11 < this.formatField.length(); i11++) {
                int index = parsePosition.getIndex() + i11;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                if (this.formatField.charAt(i11) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(parsePosition.getIndex() + this.formatField.length());
            return true;
        }
    }

    public static class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        public ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        public static Strategy getStrategy(int i10) {
            if (i10 == 1) {
                return ISO_8601_1_STRATEGY;
            }
            if (i10 == 2) {
                return ISO_8601_2_STRATEGY;
            }
            if (i10 == 3) {
                return ISO_8601_3_STRATEGY;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(str));
        }
    }

    public static abstract class PatternStrategy extends Strategy {
        private Pattern pattern;

        private PatternStrategy() {
            super();
        }

        public void createPattern(StringBuilder sb2) {
            createPattern(sb2.toString());
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i10) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(matcher.end(1) + parsePosition.getIndex());
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        public abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        public void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }
    }

    public static abstract class Strategy {
        private Strategy() {
        }

        public boolean isNumber() {
            return false;
        }

        public abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i10);
    }

    public static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        public StrategyAndWidth(Strategy strategy, int i10) {
            this.strategy = strategy;
            this.width = i10;
        }

        public int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy = listIterator.next().strategy;
            listIterator.previous();
            if (strategy.isNumber()) {
                return this.width;
            }
            return 0;
        }
    }

    public class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;

        public StrategyParser(Calendar calendar) {
            this.definingCalendar = calendar;
        }

        private StrategyAndWidth letterPattern(char c10) {
            int i10 = this.currentIdx;
            do {
                int i11 = this.currentIdx + 1;
                this.currentIdx = i11;
                if (i11 >= FastDateParser.this.pattern.length()) {
                    break;
                }
            } while (FastDateParser.this.pattern.charAt(this.currentIdx) == c10);
            int i12 = this.currentIdx - i10;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c10, i12, this.definingCalendar), i12);
        }

        private StrategyAndWidth literal() {
            StringBuilder sb2 = new StringBuilder();
            boolean z10 = false;
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char cCharAt = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!z10 && FastDateParser.isFormatLetter(cCharAt)) {
                    break;
                }
                if (cCharAt == '\'') {
                    int i10 = this.currentIdx + 1;
                    this.currentIdx = i10;
                    if (i10 == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'') {
                        z10 = !z10;
                    }
                }
                this.currentIdx++;
                sb2.append(cCharAt);
            }
            if (z10) {
                throw new IllegalArgumentException("Unterminated quote");
            }
            String string = sb2.toString();
            return new StrategyAndWidth(new CopyQuotedStrategy(string), string.length());
        }

        public StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char cCharAt = FastDateParser.this.pattern.charAt(this.currentIdx);
            return FastDateParser.isFormatLetter(cCharAt) ? letterPattern(cCharAt) : literal();
        }
    }

    public static class TimeZoneStrategy extends PatternStrategy {
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
        private static final int ID = 0;
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames;

        public static class TzInfo {
            int dstOffset;
            TimeZone zone;

            public TzInfo(TimeZone timeZone, boolean z10) {
                this.zone = timeZone;
                this.dstOffset = z10 ? timeZone.getDSTSavings() : 0;
            }
        }

        public TimeZoneStrategy(Locale locale) {
            super();
            this.tzNames = new HashMap();
            this.locale = locale;
            StringBuilder sbR = c.r("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase(TimeZones.GMT_ID)) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i10 = 1; i10 < strArr.length; i10++) {
                        if (i10 == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i10 == 5) {
                            tzInfo2 = tzInfo;
                        }
                        String str2 = strArr[i10];
                        if (str2 != null) {
                            String lowerCase = str2.toLowerCase(locale);
                            if (treeSet.add(lowerCase)) {
                                this.tzNames.put(lowerCase, tzInfo2);
                            }
                        }
                    }
                }
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                sbR.append('|');
                FastDateParser.simpleQuote(sbR, str3);
            }
            sbR.append(")");
            createPattern(sbR);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone(str);
            if (gmtTimeZone != null) {
                calendar.setTimeZone(gmtTimeZone);
                return;
            }
            String lowerCase = str.toLowerCase(this.locale);
            TzInfo tzInfo = this.tzNames.get(lowerCase);
            if (tzInfo == null) {
                tzInfo = this.tzNames.get(lowerCase + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            calendar.set(16, tzInfo.dstOffset);
            calendar.set(15, tzInfo.zone.getRawOffset());
        }
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(int i10) {
        int i11 = this.century + i10;
        return i10 >= this.startYear ? i11 : i11 + 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int i10, StringBuilder sb2) {
        HashMap map = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i10, 0, locale);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale);
            if (treeSet.add(lowerCase)) {
                map.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb2, (String) it.next()).append('|');
        }
        return map;
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i10) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[i10] == null) {
                concurrentMapArr[i10] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[i10];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i10, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i10);
        Strategy timeZoneStrategy = cache.get(this.locale);
        if (timeZoneStrategy == null) {
            timeZoneStrategy = i10 == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i10, calendar, this.locale);
            Strategy strategyPutIfAbsent = cache.putIfAbsent(this.locale, timeZoneStrategy);
            if (strategyPutIfAbsent != null) {
                return strategyPutIfAbsent;
            }
        }
        return timeZoneStrategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Strategy getStrategy(char c10, int i10, Calendar calendar) {
        if (c10 != 'y') {
            if (c10 != 'z') {
                switch (c10) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c10) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'M':
                                return i10 >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                            case 'S':
                                return MILLISECOND_STRATEGY;
                            case 'a':
                                return getLocaleSpecificStrategy(9, calendar);
                            case 'd':
                                return DAY_OF_MONTH_STRATEGY;
                            case 'h':
                                return HOUR12_STRATEGY;
                            case 'k':
                                return HOUR24_OF_DAY_STRATEGY;
                            case 'm':
                                return MINUTE_STRATEGY;
                            case 's':
                                return SECOND_STRATEGY;
                            case 'u':
                                return DAY_OF_WEEK_STRATEGY;
                            case 'w':
                                return WEEK_OF_YEAR_STRATEGY;
                            default:
                                switch (c10) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return ISO8601TimeZoneStrategy.getStrategy(i10);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i10 == 2) {
                                            return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c10 + "' not supported");
                                }
                        }
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        return i10 > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy == null) {
                return;
            } else {
                this.patterns.add(nextStrategy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFormatLetter(char c10) {
        return (c10 >= 'A' && c10 <= 'Z') || (c10 >= 'a' && c10 <= 'z');
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.StringBuilder simpleQuote(java.lang.StringBuilder r6, java.lang.String r7) {
        /*
            r0 = 0
        L1:
            int r1 = r7.length()
            r2 = 63
            r3 = 46
            if (r0 >= r1) goto L38
            char r1 = r7.charAt(r0)
            r4 = 36
            r5 = 92
            if (r1 == r4) goto L2f
            if (r1 == r3) goto L2f
            if (r1 == r2) goto L2f
            r2 = 94
            if (r1 == r2) goto L2f
            r2 = 91
            if (r1 == r2) goto L2f
            if (r1 == r5) goto L2f
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L2f
            r2 = 124(0x7c, float:1.74E-43)
            if (r1 == r2) goto L2f
            switch(r1) {
                case 40: goto L2f;
                case 41: goto L2f;
                case 42: goto L2f;
                case 43: goto L2f;
                default: goto L2e;
            }
        L2e:
            goto L32
        L2f:
            r6.append(r5)
        L32:
            r6.append(r1)
            int r0 = r0 + 1
            goto L1
        L38:
            int r7 = r6.length()
            int r7 = r7 + (-1)
            char r7 = r6.charAt(r7)
            if (r7 != r3) goto L47
            r6.append(r2)
        L47:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDateParser.simpleQuote(java.lang.StringBuilder, java.lang.String):java.lang.StringBuilder");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return (((this.locale.hashCode() * 13) + this.timeZone.hashCode()) * 13) + this.pattern.hashCode();
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = parse(str, parsePosition);
        if (date != null) {
            return date;
        }
        if (!this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException(c.j("Unparseable date: ", str), parsePosition.getErrorIndex());
        }
        throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i10;
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i10 = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i10 = 0;
        } else {
            calendar.setTime(new Date());
            i10 = calendar.get(1) - 80;
        }
        int i11 = (i10 / 100) * 100;
        this.century = i11;
        this.startYear = i10 - i11;
        init(calendar);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        if (parse(str, parsePosition, calendar)) {
            return calendar.getTime();
        }
        return null;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                return false;
            }
        }
        return true;
    }

    public static class NumberStrategy extends Strategy {
        private final int field;

        public NumberStrategy(int i10) {
            super();
            this.field = i10;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i10) throws NumberFormatException {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i10 == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i11 = i10 + index;
                if (length > i11) {
                    length = i11;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int i12 = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, i12));
            return true;
        }

        public int modify(FastDateParser fastDateParser, int i10) {
            return i10;
        }
    }
}
