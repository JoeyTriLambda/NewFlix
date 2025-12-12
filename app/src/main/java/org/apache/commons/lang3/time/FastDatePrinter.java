package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* loaded from: classes2.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    public static class CharacterLiteral implements Rule {
        private final char mValue;

        public CharacterLiteral(char c10) {
            this.mValue = c10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    public static class Iso8601_Rule implements Rule {
        final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        public Iso8601_Rule(int i10) {
            this.length = i10;
        }

        public static Iso8601_Rule getRule(int i10) {
            if (i10 == 1) {
                return ISO8601_HOURS;
            }
            if (i10 == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i10 == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(16) + calendar.get(15);
            if (i10 == 0) {
                appendable.append("Z");
                return;
            }
            if (i10 < 0) {
                appendable.append('-');
                i10 = -i10;
            } else {
                appendable.append('+');
            }
            int i11 = i10 / 3600000;
            FastDatePrinter.appendDigits(appendable, i11);
            int i12 = this.length;
            if (i12 < 5) {
                return;
            }
            if (i12 == 6) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i10 / 60000) - (i11 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i10) throws IOException;
    }

    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public PaddedNumberField(int i10, int i11) {
            if (i11 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = i10;
            this.mSize = i11;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i10, this.mSize);
        }
    }

    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        private final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        public TextField(int i10, String[] strArr) {
            this.mField = i10;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i10 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i10;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i10) {
                    i10 = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z10, int i10, Locale locale) {
            this.mTimeZone = timeZone;
            if (z10) {
                this.mStyle = Integer.MIN_VALUE | i10;
            } else {
                this.mStyle = i10;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            return this.mTimeZone.hashCode() + ((this.mLocale.hashCode() + (this.mStyle * 31)) * 31);
        }
    }

    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i10) {
            this.mLocale = locale;
            this.mStyle = i10;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i10, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i10, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        public TimeZoneNumberRule(boolean z10) {
            this.mColon = z10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(16) + calendar.get(15);
            if (i10 < 0) {
                appendable.append('-');
                i10 = -i10;
            } else {
                appendable.append('+');
            }
            int i11 = i10 / 3600000;
            FastDatePrinter.appendDigits(appendable, i11);
            if (this.mColon) {
                appendable.append(':');
            }
            FastDatePrinter.appendDigits(appendable, (i10 / 60000) - (i11 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            FastDatePrinter.appendDigits(appendable, i10);
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public TwoDigitNumberField(int i10) {
            this.mField = i10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            if (i10 < 100) {
                FastDatePrinter.appendDigits(appendable, i10);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i10, 2);
            }
        }
    }

    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            FastDatePrinter.appendDigits(appendable, i10);
        }
    }

    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            if (i10 < 10) {
                appendable.append((char) (i10 + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, i10);
            }
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public UnpaddedNumberField(int i10) {
            this.mField = i10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            if (i10 < 10) {
                appendable.append((char) (i10 + 48));
            } else if (i10 < 100) {
                FastDatePrinter.appendDigits(appendable, i10);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i10, 1);
            }
        }
    }

    public static class WeekYear implements NumberRule {
        private final NumberRule mRule;

        public WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            this.mRule.appendTo(appendable, calendar.getWeekYear());
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i10) throws IOException {
        appendable.append((char) ((i10 / 10) + 48));
        appendable.append((char) ((i10 % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i10, int i11) throws IOException {
        if (i10 < 10000) {
            int i12 = i10 < 1000 ? i10 < 100 ? i10 < 10 ? 1 : 2 : 3 : 4;
            for (int i13 = i11 - i12; i13 > 0; i13--) {
                appendable.append('0');
            }
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 != 4) {
                            return;
                        }
                        appendable.append((char) ((i10 / 1000) + 48));
                        i10 %= 1000;
                    }
                    if (i10 >= 100) {
                        appendable.append((char) ((i10 / 100) + 48));
                        i10 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i10 >= 10) {
                    appendable.append((char) ((i10 / 10) + 48));
                    i10 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i10 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i14 = 0;
        while (i10 != 0) {
            cArr[i14] = (char) ((i10 % 10) + 48);
            i10 /= 10;
            i14++;
        }
        while (i14 < i11) {
            appendable.append('0');
            i11--;
        }
        while (true) {
            i14--;
            if (i14 < 0) {
                return;
            } else {
                appendable.append(cArr[i14]);
            }
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z10, int i10, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z10, i10, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z10, i10, locale);
        String strPutIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return strPutIfAbsent != null ? strPutIfAbsent : displayName;
    }

    private void init() {
        List<Rule> pattern = parsePattern();
        Rule[] ruleArr = (Rule[]) pattern.toArray(new Rule[pattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.mMaxLengthEstimate = iEstimateLength;
                return;
            }
            iEstimateLength += this.mRules[length].estimateLength();
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        throw new IllegalArgumentException("Unknown class: ".concat(obj == null ? "<null>" : obj.getClass().getName()));
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return (((this.mLocale.hashCode() * 13) + this.mTimeZone.hashCode()) * 13) + this.mPattern.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Type inference failed for: r12v17, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12, types: [org.apache.commons.lang3.time.FastDatePrinter$StringLiteral] */
    /* JADX WARN: Type inference failed for: r9v13, types: [org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral] */
    /* JADX WARN: Type inference failed for: r9v15, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v17, types: [org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField] */
    /* JADX WARN: Type inference failed for: r9v18, types: [org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField] */
    /* JADX WARN: Type inference failed for: r9v19, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v20, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v22, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v23, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v25, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v26, types: [org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField] */
    /* JADX WARN: Type inference failed for: r9v27, types: [org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField] */
    /* JADX WARN: Type inference failed for: r9v29, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v31, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v32, types: [org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField] */
    /* JADX WARN: Type inference failed for: r9v34, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v36, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v41, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v42, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v45, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v46, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v47, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v50, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v51, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v52, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v7, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /* JADX WARN: Type inference failed for: r9v8, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<org.apache.commons.lang3.time.FastDatePrinter.Rule> parsePattern() {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDatePrinter.parsePattern():java.util.List");
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i10);
        if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
            sb2.append('\'');
            boolean z10 = false;
            while (i10 < length) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt2 != '\'') {
                    if (!z10 && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i10--;
                        break;
                    }
                    sb2.append(cCharAt2);
                } else {
                    int i11 = i10 + 1;
                    if (i11 >= length || str.charAt(i11) != '\'') {
                        z10 = !z10;
                    } else {
                        sb2.append(cCharAt2);
                        i10 = i11;
                    }
                }
                i10++;
            }
        } else {
            sb2.append(cCharAt);
            while (true) {
                int i12 = i10 + 1;
                if (i12 >= length || str.charAt(i12) != cCharAt) {
                    break;
                }
                sb2.append(cCharAt);
                i10 = i12;
            }
        }
        iArr[0] = i10;
        return sb2.toString();
    }

    public NumberRule selectNumberRule(int i10, int i11) {
        return i11 != 1 ? i11 != 2 ? new PaddedNumberField(i10, i11) : new TwoDigitNumberField(i10) : new UnpaddedNumberField(i10);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        public DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(7);
            this.mRule.appendTo(appendable, i10 != 1 ? i10 - 1 : 7);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b10) {
        try {
            for (Rule rule : this.mRules) {
                rule.appendTo(b10, calendar);
            }
        } catch (IOException e10) {
            ExceptionUtils.rethrow(e10);
        }
        return b10;
    }

    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, leastMaximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, maximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        throw new IllegalArgumentException("Unknown class: ".concat(obj == null ? "<null>" : obj.getClass().getName()));
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j10) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j10);
        return applyRulesToString(calendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return applyRulesToString(calendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j10, StringBuffer stringBuffer) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j10);
        return (StringBuffer) applyRules(calendarNewCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return (StringBuffer) applyRules(calendarNewCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j10, B b10) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTimeInMillis(j10);
        return (B) applyRules(calendarNewCalendar, (Calendar) b10);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b10) {
        Calendar calendarNewCalendar = newCalendar();
        calendarNewCalendar.setTime(date);
        return (B) applyRules(calendarNewCalendar, (Calendar) b10);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b10) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar, (Calendar) b10);
    }
}
