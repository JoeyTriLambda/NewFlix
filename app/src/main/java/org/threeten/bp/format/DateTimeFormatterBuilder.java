package org.threeten.bp.format;

import ac.c;
import com.loopj.android.http.AsyncHttpClient;
import cz.msebera.android.httpclient.message.TokenParser;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import o1.a;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.TimeZones;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.SimpleDateTimeTextProvider;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

/* loaded from: classes2.dex */
public final class DateTimeFormatterBuilder {
    private static final Map<Character, TemporalField> FIELD_MAP;
    static final Comparator<String> LENGTH_SORT;
    private static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List<DateTimePrinterParser> printerParsers;
    private int valueParserIndex;

    /* renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$format$SignStyle;

        static {
            int[] iArr = new int[SignStyle.values().length];
            $SwitchMap$org$threeten$bp$format$SignStyle = iArr;
            try {
                iArr[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        public CharLiteralPrinterParser(char c10) {
            this.literal = c10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            if (i10 == charSequence.length()) {
                return ~i10;
            }
            return !dateTimeParseContext.charEquals(this.literal, charSequence.charAt(i10)) ? ~i10 : i10 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            sb2.append(this.literal);
            return true;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            return "'" + this.literal + "'";
        }
    }

    public static final class ChronoPrinterParser implements DateTimePrinterParser {
        private final TextStyle textStyle;

        public ChronoPrinterParser(TextStyle textStyle) {
            this.textStyle = textStyle;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            if (i10 < 0 || i10 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            Chronology chronology = null;
            int i11 = -1;
            for (Chronology chronology2 : Chronology.getAvailableChronologies()) {
                String id2 = chronology2.getId();
                int length = id2.length();
                if (length > i11 && dateTimeParseContext.subSequenceEquals(charSequence, i10, id2, 0, length)) {
                    chronology = chronology2;
                    i11 = length;
                }
            }
            if (chronology == null) {
                return ~i10;
            }
            dateTimeParseContext.setParsed(chronology);
            return i10 + i11;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Chronology chronology = (Chronology) dateTimePrintContext.getValue(TemporalQueries.chronology());
            if (chronology == null) {
                return false;
            }
            if (this.textStyle == null) {
                sb2.append(chronology.getId());
                return true;
            }
            try {
                sb2.append(ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", dateTimePrintContext.getLocale(), DateTimeFormatterBuilder.class.getClassLoader()).getString(chronology.getId()));
                return true;
            } catch (MissingResourceException unused) {
                sb2.append(chronology.getId());
                return true;
            }
        }
    }

    public static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        public CompositePrinterParser(List<DateTimePrinterParser> list, boolean z10) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            if (!this.optional) {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    i10 = dateTimePrinterParser.parse(dateTimeParseContext, charSequence, i10);
                    if (i10 < 0) {
                        break;
                    }
                }
                return i10;
            }
            dateTimeParseContext.startOptional();
            int i11 = i10;
            for (DateTimePrinterParser dateTimePrinterParser2 : this.printerParsers) {
                i11 = dateTimePrinterParser2.parse(dateTimeParseContext, charSequence, i11);
                if (i11 < 0) {
                    dateTimeParseContext.endOptional(false);
                    return i10;
                }
            }
            dateTimeParseContext.endOptional(true);
            return i11;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            int length = sb2.length();
            if (this.optional) {
                dateTimePrintContext.startOptional();
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    if (!dateTimePrinterParser.print(dateTimePrintContext, sb2)) {
                        sb2.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.printerParsers != null) {
                sb2.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    sb2.append(dateTimePrinterParser);
                }
                sb2.append(this.optional ? "]" : ")");
            }
            return sb2.toString();
        }

        public CompositePrinterParser withOptional(boolean z10) {
            return z10 == this.optional ? this : new CompositePrinterParser(this.printerParsers, z10);
        }

        public CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z10) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z10;
        }
    }

    public interface DateTimePrinterParser {
        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10);

        boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2);
    }

    public static class DefaultingParser implements DateTimePrinterParser {
        private final TemporalField field;
        private final long value;

        public DefaultingParser(TemporalField temporalField, long j10) {
            this.field = temporalField;
            this.value = j10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            if (dateTimeParseContext.getParsed(this.field) == null) {
                dateTimeParseContext.setParsedField(this.field, this.value, i10, i10);
            }
            return i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return true;
        }
    }

    public static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        public FractionPrinterParser(TemporalField temporalField, int i10, int i11, boolean z10) {
            Jdk8Methods.requireNonNull(temporalField, "field");
            if (!temporalField.range().isFixed()) {
                throw new IllegalArgumentException(a.e("Field must have a fixed set of values: ", temporalField));
            }
            if (i10 < 0 || i10 > 9) {
                throw new IllegalArgumentException(c.f("Minimum width must be from 0 to 9 inclusive but was ", i10));
            }
            if (i11 < 1 || i11 > 9) {
                throw new IllegalArgumentException(c.f("Maximum width must be from 1 to 9 inclusive but was ", i11));
            }
            if (i11 < i10) {
                throw new IllegalArgumentException(c.g("Maximum width must exceed or equal the minimum width but ", i11, " < ", i10));
            }
            this.field = temporalField;
            this.minWidth = i10;
            this.maxWidth = i11;
            this.decimalPoint = z10;
        }

        private long convertFromFraction(BigDecimal bigDecimal) {
            ValueRange valueRangeRange = this.field.range();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(valueRangeRange.getMinimum());
            return bigDecimal.multiply(BigDecimal.valueOf(valueRangeRange.getMaximum()).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact();
        }

        private BigDecimal convertToFraction(long j10) {
            ValueRange valueRangeRange = this.field.range();
            valueRangeRange.checkValidValue(j10, this.field);
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(valueRangeRange.getMinimum());
            BigDecimal bigDecimalDivide = BigDecimal.valueOf(j10).subtract(bigDecimalValueOf).divide(BigDecimal.valueOf(valueRangeRange.getMaximum()).subtract(bigDecimalValueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            return bigDecimalDivide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : bigDecimalDivide.stripTrailingZeros();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            int i11;
            int i12 = 0;
            int i13 = dateTimeParseContext.isStrict() ? this.minWidth : 0;
            int i14 = dateTimeParseContext.isStrict() ? this.maxWidth : 9;
            int length = charSequence.length();
            if (i10 == length) {
                return i13 > 0 ? ~i10 : i10;
            }
            if (this.decimalPoint) {
                if (charSequence.charAt(i10) != dateTimeParseContext.getSymbols().getDecimalSeparator()) {
                    return i13 > 0 ? ~i10 : i10;
                }
                i10++;
            }
            int i15 = i10;
            int i16 = i13 + i15;
            if (i16 > length) {
                return ~i15;
            }
            int iMin = Math.min(i14 + i15, length);
            int i17 = i15;
            while (true) {
                if (i17 >= iMin) {
                    i11 = i17;
                    break;
                }
                int i18 = i17 + 1;
                int iConvertToDigit = dateTimeParseContext.getSymbols().convertToDigit(charSequence.charAt(i17));
                if (iConvertToDigit >= 0) {
                    i12 = (i12 * 10) + iConvertToDigit;
                    i17 = i18;
                } else {
                    if (i18 < i16) {
                        return ~i15;
                    }
                    i11 = i18 - 1;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, convertFromFraction(new BigDecimal(i12).movePointLeft(i11 - i15)), i15, i11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle symbols = dateTimePrintContext.getSymbols();
            BigDecimal bigDecimalConvertToFraction = convertToFraction(value.longValue());
            if (bigDecimalConvertToFraction.scale() != 0) {
                String strConvertNumberToI18N = symbols.convertNumberToI18N(bigDecimalConvertToFraction.setScale(Math.min(Math.max(bigDecimalConvertToFraction.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb2.append(symbols.getDecimalSeparator());
                }
                sb2.append(strConvertNumberToI18N);
                return true;
            }
            if (this.minWidth <= 0) {
                return true;
            }
            if (this.decimalPoint) {
                sb2.append(symbols.getDecimalSeparator());
            }
            for (int i10 = 0; i10 < this.minWidth; i10++) {
                sb2.append(symbols.getZeroDigit());
            }
            return true;
        }

        public String toString() {
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + (this.decimalPoint ? ",DecimalPoint" : "") + ")";
        }
    }

    public static final class InstantPrinterParser implements DateTimePrinterParser {
        private static final long SECONDS_0000_TO_1970 = 62167219200L;
        private static final long SECONDS_PER_10000_YEARS = 315569520000L;
        private final int fractionalDigits;

        public InstantPrinterParser(int i10) {
            this.fractionalDigits = i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            int i11;
            int i12;
            DateTimeParseContext dateTimeParseContextCopy = dateTimeParseContext.copy();
            int i13 = this.fractionalDigits;
            int i14 = 0;
            int i15 = i13 < 0 ? 0 : i13;
            if (i13 < 0) {
                i13 = 9;
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral2 = dateTimeFormatterBuilderAppendLiteral.appendValue(chronoField, 2).appendLiteral(':');
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral3 = dateTimeFormatterBuilderAppendLiteral2.appendValue(chronoField2, 2).appendLiteral(':');
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendValue = dateTimeFormatterBuilderAppendLiteral3.appendValue(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            int i16 = dateTimeFormatterBuilderAppendValue.appendFraction(chronoField4, i15, i13, true).appendLiteral('Z').toFormatter().toPrinterParser(false).parse(dateTimeParseContextCopy, charSequence, i10);
            if (i16 < 0) {
                return i16;
            }
            long jLongValue = dateTimeParseContextCopy.getParsed(ChronoField.YEAR).longValue();
            int iIntValue = dateTimeParseContextCopy.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int iIntValue2 = dateTimeParseContextCopy.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int iIntValue3 = dateTimeParseContextCopy.getParsed(chronoField).intValue();
            int iIntValue4 = dateTimeParseContextCopy.getParsed(chronoField2).intValue();
            Long parsed = dateTimeParseContextCopy.getParsed(chronoField3);
            Long parsed2 = dateTimeParseContextCopy.getParsed(chronoField4);
            int iIntValue5 = parsed != null ? parsed.intValue() : 0;
            int iIntValue6 = parsed2 != null ? parsed2.intValue() : 0;
            int i17 = ((int) jLongValue) % AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT;
            if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
                i12 = iIntValue5;
                i14 = 1;
                i11 = 0;
            } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
                dateTimeParseContext.setParsedLeapSecond();
                i11 = iIntValue3;
                i12 = 59;
            } else {
                i11 = iIntValue3;
                i12 = iIntValue5;
            }
            try {
                return dateTimeParseContext.setParsedField(chronoField4, iIntValue6, i10, dateTimeParseContext.setParsedField(ChronoField.INSTANT_SECONDS, Jdk8Methods.safeMultiply(jLongValue / 10000, SECONDS_PER_10000_YEARS) + LocalDateTime.of(i17, iIntValue, iIntValue2, i11, iIntValue4, i12, 0).plusDays(i14).toEpochSecond(ZoneOffset.UTC), i10, i16));
            } catch (RuntimeException unused) {
                return ~i10;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long value = dateTimePrintContext.getValue(ChronoField.INSTANT_SECONDS);
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long lValueOf = temporal.isSupported(chronoField) ? Long.valueOf(dateTimePrintContext.getTemporal().getLong(chronoField)) : 0L;
            int i10 = 0;
            if (value == null) {
                return false;
            }
            long jLongValue = value.longValue();
            int iCheckValidIntValue = chronoField.checkValidIntValue(lValueOf.longValue());
            if (jLongValue >= -62167219200L) {
                long j10 = (jLongValue - SECONDS_PER_10000_YEARS) + SECONDS_0000_TO_1970;
                long jFloorDiv = Jdk8Methods.floorDiv(j10, SECONDS_PER_10000_YEARS) + 1;
                LocalDateTime localDateTimeOfEpochSecond = LocalDateTime.ofEpochSecond(Jdk8Methods.floorMod(j10, SECONDS_PER_10000_YEARS) - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                if (jFloorDiv > 0) {
                    sb2.append('+');
                    sb2.append(jFloorDiv);
                }
                sb2.append(localDateTimeOfEpochSecond);
                if (localDateTimeOfEpochSecond.getSecond() == 0) {
                    sb2.append(":00");
                }
            } else {
                long j11 = jLongValue + SECONDS_0000_TO_1970;
                long j12 = j11 / SECONDS_PER_10000_YEARS;
                long j13 = j11 % SECONDS_PER_10000_YEARS;
                LocalDateTime localDateTimeOfEpochSecond2 = LocalDateTime.ofEpochSecond(j13 - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                int length = sb2.length();
                sb2.append(localDateTimeOfEpochSecond2);
                if (localDateTimeOfEpochSecond2.getSecond() == 0) {
                    sb2.append(":00");
                }
                if (j12 < 0) {
                    if (localDateTimeOfEpochSecond2.getYear() == -10000) {
                        sb2.replace(length, length + 2, Long.toString(j12 - 1));
                    } else if (j13 == 0) {
                        sb2.insert(length, j12);
                    } else {
                        sb2.insert(length + 1, Math.abs(j12));
                    }
                }
            }
            int i11 = this.fractionalDigits;
            if (i11 == -2) {
                if (iCheckValidIntValue != 0) {
                    sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    if (iCheckValidIntValue % 1000000 == 0) {
                        sb2.append(Integer.toString((iCheckValidIntValue / 1000000) + 1000).substring(1));
                    } else if (iCheckValidIntValue % 1000 == 0) {
                        sb2.append(Integer.toString((iCheckValidIntValue / 1000) + 1000000).substring(1));
                    } else {
                        sb2.append(Integer.toString(iCheckValidIntValue + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
                    }
                }
            } else if (i11 > 0 || (i11 == -1 && iCheckValidIntValue > 0)) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                int i12 = 100000000;
                while (true) {
                    int i13 = this.fractionalDigits;
                    if ((i13 != -1 || iCheckValidIntValue <= 0) && i10 >= i13) {
                        break;
                    }
                    int i14 = iCheckValidIntValue / i12;
                    sb2.append((char) (i14 + 48));
                    iCheckValidIntValue -= i14 * i12;
                    i12 /= 10;
                    i10++;
                }
            }
            sb2.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        public LocalizedOffsetPrinterParser(TextStyle textStyle) {
            this.style = textStyle;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            char cCharAt;
            if (!dateTimeParseContext.subSequenceEquals(charSequence, i10, TimeZones.GMT_ID, 0, 3)) {
                return ~i10;
            }
            int i11 = i10 + 3;
            if (this.style == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").parse(dateTimeParseContext, charSequence, i11);
            }
            int length = charSequence.length();
            if (i11 == length) {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i11, i11);
            }
            char cCharAt2 = charSequence.charAt(i11);
            if (cCharAt2 != '+' && cCharAt2 != '-') {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, 0L, i11, i11);
            }
            int i12 = cCharAt2 == '-' ? -1 : 1;
            if (i11 == length) {
                return ~i11;
            }
            int i13 = i11 + 1;
            char cCharAt3 = charSequence.charAt(i13);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                return ~i13;
            }
            int i14 = i13 + 1;
            int i15 = cCharAt3 - '0';
            if (i14 != length && (cCharAt = charSequence.charAt(i14)) >= '0' && cCharAt <= '9') {
                i15 = (i15 * 10) + (cCharAt - '0');
                if (i15 > 23) {
                    return ~i14;
                }
                i14++;
            }
            int i16 = i14;
            if (i16 == length || charSequence.charAt(i16) != ':') {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, i12 * 3600 * i15, i16, i16);
            }
            int i17 = i16 + 1;
            int i18 = length - 2;
            if (i17 > i18) {
                return ~i17;
            }
            char cCharAt4 = charSequence.charAt(i17);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                return ~i17;
            }
            int i19 = i17 + 1;
            int i20 = cCharAt4 - '0';
            char cCharAt5 = charSequence.charAt(i19);
            if (cCharAt5 < '0' || cCharAt5 > '9') {
                return ~i19;
            }
            int i21 = i19 + 1;
            if ((cCharAt5 - '0') + (i20 * 10) > 59) {
                return ~i21;
            }
            if (i21 == length || charSequence.charAt(i21) != ':') {
                return dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, ((r12 * 60) + (i15 * 3600)) * i12, i21, i21);
            }
            int i22 = i21 + 1;
            if (i22 > i18) {
                return ~i22;
            }
            char cCharAt6 = charSequence.charAt(i22);
            if (cCharAt6 < '0' || cCharAt6 > '9') {
                return ~i22;
            }
            int i23 = i22 + 1;
            int i24 = cCharAt6 - '0';
            char cCharAt7 = charSequence.charAt(i23);
            if (cCharAt7 < '0' || cCharAt7 > '9') {
                return ~i23;
            }
            int i25 = i23 + 1;
            return (cCharAt7 - '0') + (i24 * 10) > 59 ? ~i25 : dateTimeParseContext.setParsedField(ChronoField.OFFSET_SECONDS, ((r12 * 60) + (i15 * 3600) + r1) * i12, i25, i25);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            sb2.append(TimeZones.GMT_ID);
            if (this.style == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").print(dateTimePrintContext, sb2);
            }
            int iSafeToInt = Jdk8Methods.safeToInt(value.longValue());
            if (iSafeToInt == 0) {
                return true;
            }
            int iAbs = Math.abs((iSafeToInt / 3600) % 100);
            int iAbs2 = Math.abs((iSafeToInt / 60) % 60);
            int iAbs3 = Math.abs(iSafeToInt % 60);
            sb2.append(iSafeToInt < 0 ? "-" : "+");
            sb2.append(iAbs);
            if (iAbs2 <= 0 && iAbs3 <= 0) {
                return true;
            }
            sb2.append(":");
            sb2.append((char) ((iAbs2 / 10) + 48));
            sb2.append((char) ((iAbs2 % 10) + 48));
            if (iAbs3 <= 0) {
                return true;
            }
            sb2.append(":");
            sb2.append((char) ((iAbs3 / 10) + 48));
            sb2.append((char) ((iAbs3 % 10) + 48));
            return true;
        }
    }

    public static final class LocalizedPrinterParser implements DateTimePrinterParser {
        private final FormatStyle dateStyle;
        private final FormatStyle timeStyle;

        public LocalizedPrinterParser(FormatStyle formatStyle, FormatStyle formatStyle2) {
            this.dateStyle = formatStyle;
            this.timeStyle = formatStyle2;
        }

        private DateTimeFormatter formatter(Locale locale, Chronology chronology) {
            return DateTimeFormatStyleProvider.getInstance().getFormatter(this.dateStyle, this.timeStyle, chronology, locale);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            return formatter(dateTimeParseContext.getLocale(), dateTimeParseContext.getEffectiveChronology()).toPrinterParser(false).parse(dateTimeParseContext, charSequence, i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return formatter(dateTimePrintContext.getLocale(), Chronology.from(dateTimePrintContext.getTemporal())).toPrinterParser(false).print(dateTimePrintContext, sb2);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Localized(");
            Object obj = this.dateStyle;
            if (obj == null) {
                obj = "";
            }
            sb2.append(obj);
            sb2.append(",");
            FormatStyle formatStyle = this.timeStyle;
            sb2.append(formatStyle != null ? formatStyle : "");
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class NumberPrinterParser implements DateTimePrinterParser {
        static final int[] EXCEED_POINTS = {0, 10, 100, 1000, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        final SignStyle signStyle;
        final int subsequentWidth;

        public boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            int i10 = this.subsequentWidth;
            return i10 == -1 || (i10 > 0 && this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x014a, code lost:
        
            if (r2 == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x014e, code lost:
        
            if (r0 > r19.minWidth) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0153, code lost:
        
            return ~(r7 - 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0156, code lost:
        
            if (r0 <= r19.minWidth) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x0159, code lost:
        
            return ~r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x015a, code lost:
        
            r2 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x015b, code lost:
        
            if (r13 == null) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0163, code lost:
        
            if (r13.bitLength() <= 63) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0165, code lost:
        
            r13 = r13.divide(java.math.BigInteger.TEN);
            r5 = r5 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x017a, code lost:
        
            return setValue(r20, r13.longValue(), r7, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0184, code lost:
        
            return setValue(r20, r2, r7, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0109, code lost:
        
            r5 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x010e, code lost:
        
            if (r0 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0110, code lost:
        
            if (r13 == null) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0118, code lost:
        
            if (r13.equals(java.math.BigInteger.ZERO) == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x011e, code lost:
        
            if (r20.isStrict() == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0123, code lost:
        
            return ~(r7 - 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0124, code lost:
        
            r13 = r13.negate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x012e, code lost:
        
            if (r14 != 0) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0134, code lost:
        
            if (r20.isStrict() == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0138, code lost:
        
            return ~(r7 - 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0139, code lost:
        
            r2 = -r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0140, code lost:
        
            if (r19.signStyle != org.threeten.bp.format.SignStyle.EXCEEDS_PAD) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0146, code lost:
        
            if (r20.isStrict() == false) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0148, code lost:
        
            r0 = r5 - r7;
         */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(org.threeten.bp.format.DateTimeParseContext r20, java.lang.CharSequence r21, int r22) {
            /*
                Method dump skipped, instructions count: 389
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.parse(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            long value2 = getValue(dateTimePrintContext, value.longValue());
            DecimalStyle symbols = dateTimePrintContext.getSymbols();
            String string = value2 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(value2));
            if (string.length() > this.maxWidth) {
                throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + value2 + " exceeds the maximum print width of " + this.maxWidth);
            }
            String strConvertNumberToI18N = symbols.convertNumberToI18N(string);
            if (value2 >= 0) {
                int i10 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
                if (i10 == 1) {
                    if (this.minWidth < 19 && value2 >= EXCEED_POINTS[r4]) {
                        sb2.append(symbols.getPositiveSign());
                    }
                } else if (i10 == 2) {
                    sb2.append(symbols.getPositiveSign());
                }
            } else {
                int i11 = AnonymousClass4.$SwitchMap$org$threeten$bp$format$SignStyle[this.signStyle.ordinal()];
                if (i11 == 1 || i11 == 2 || i11 == 3) {
                    sb2.append(symbols.getNegativeSign());
                } else if (i11 == 4) {
                    throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + value2 + " cannot be negative according to the SignStyle");
                }
            }
            for (int i12 = 0; i12 < this.minWidth - strConvertNumberToI18N.length(); i12++) {
                sb2.append(symbols.getZeroDigit());
            }
            sb2.append(strConvertNumberToI18N);
            return true;
        }

        public int setValue(DateTimeParseContext dateTimeParseContext, long j10, int i10, int i11) {
            return dateTimeParseContext.setParsedField(this.field, j10, i10, i11);
        }

        public String toString() {
            int i10 = this.minWidth;
            if (i10 == 1 && this.maxWidth == 19 && this.signStyle == SignStyle.NORMAL) {
                return "Value(" + this.field + ")";
            }
            if (i10 == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                StringBuilder sb2 = new StringBuilder("Value(");
                sb2.append(this.field);
                sb2.append(",");
                return c.m(sb2, this.minWidth, ")");
            }
            return "Value(" + this.field + "," + this.minWidth + "," + this.maxWidth + "," + this.signStyle + ")";
        }

        public NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        public NumberPrinterParser withSubsequentWidth(int i10) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + i10);
        }

        public NumberPrinterParser(TemporalField temporalField, int i10, int i11, SignStyle signStyle) {
            this.field = temporalField;
            this.minWidth = i10;
            this.maxWidth = i11;
            this.signStyle = signStyle;
            this.subsequentWidth = 0;
        }

        private NumberPrinterParser(TemporalField temporalField, int i10, int i11, SignStyle signStyle, int i12) {
            this.field = temporalField;
            this.minWidth = i10;
            this.maxWidth = i11;
            this.signStyle = signStyle;
            this.subsequentWidth = i12;
        }

        public long getValue(DateTimePrintContext dateTimePrintContext, long j10) {
            return j10;
        }
    }

    public static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        private final String noOffsetText;
        private final int type;
        static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser INSTANCE_ID = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        static final OffsetIdPrinterParser INSTANCE_ID_ZERO = new OffsetIdPrinterParser("0", "+HH:MM:ss");

        public OffsetIdPrinterParser(String str, String str2) {
            Jdk8Methods.requireNonNull(str, "noOffsetText");
            Jdk8Methods.requireNonNull(str2, "pattern");
            this.noOffsetText = str;
            this.type = checkPattern(str2);
        }

        private int checkPattern(String str) {
            int i10 = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (i10 >= strArr.length) {
                    throw new IllegalArgumentException(c.j("Invalid zone offset pattern: ", str));
                }
                if (strArr[i10].equals(str)) {
                    return i10;
                }
                i10++;
            }
        }

        private boolean parseNumber(int[] iArr, int i10, CharSequence charSequence, boolean z10) {
            int i11 = this.type;
            if ((i11 + 3) / 2 < i10) {
                return false;
            }
            int i12 = iArr[0];
            if (i11 % 2 == 0 && i10 > 1) {
                int i13 = i12 + 1;
                if (i13 > charSequence.length() || charSequence.charAt(i12) != ':') {
                    return z10;
                }
                i12 = i13;
            }
            if (i12 + 2 > charSequence.length()) {
                return z10;
            }
            int i14 = i12 + 1;
            char cCharAt = charSequence.charAt(i12);
            int i15 = i14 + 1;
            char cCharAt2 = charSequence.charAt(i14);
            if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
                int i16 = (cCharAt2 - '0') + ((cCharAt - '0') * 10);
                if (i16 >= 0 && i16 <= 59) {
                    iArr[i10] = i16;
                    iArr[0] = i15;
                    return false;
                }
            }
            return z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(org.threeten.bp.format.DateTimeParseContext r16, java.lang.CharSequence r17, int r18) {
            /*
                r15 = this;
                r0 = r15
                r7 = r17
                r8 = r18
                int r1 = r17.length()
                java.lang.String r2 = r0.noOffsetText
                int r9 = r2.length()
                if (r9 != 0) goto L22
                if (r8 != r1) goto L45
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                r1 = r16
                r5 = r18
                r6 = r18
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            L22:
                if (r8 != r1) goto L26
                int r1 = ~r8
                return r1
            L26:
                java.lang.String r4 = r0.noOffsetText
                r5 = 0
                r1 = r16
                r2 = r17
                r3 = r18
                r6 = r9
                boolean r1 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L45
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                int r6 = r8 + r9
                r1 = r16
                r5 = r18
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            L45:
                char r1 = r17.charAt(r18)
                r2 = 43
                r3 = 45
                if (r1 == r2) goto L51
                if (r1 != r3) goto La5
            L51:
                r2 = 1
                if (r1 != r3) goto L56
                r1 = -1
                goto L57
            L56:
                r1 = 1
            L57:
                r3 = 4
                int[] r3 = new int[r3]
                int r4 = r8 + 1
                r5 = 0
                r3[r5] = r4
                boolean r4 = r15.parseNumber(r3, r2, r7, r2)
                r6 = 2
                r10 = 3
                if (r4 != 0) goto L7d
                int r4 = r0.type
                if (r4 < r10) goto L6d
                r4 = 1
                goto L6e
            L6d:
                r4 = 0
            L6e:
                boolean r4 = r15.parseNumber(r3, r6, r7, r4)
                if (r4 != 0) goto L7d
                boolean r4 = r15.parseNumber(r3, r10, r7, r5)
                if (r4 == 0) goto L7b
                goto L7d
            L7b:
                r4 = 0
                goto L7e
            L7d:
                r4 = 1
            L7e:
                if (r4 != 0) goto La5
                long r11 = (long) r1
                r1 = r3[r2]
                long r1 = (long) r1
                r13 = 3600(0xe10, double:1.7786E-320)
                long r1 = r1 * r13
                r4 = r3[r6]
                long r6 = (long) r4
                r13 = 60
                long r6 = r6 * r13
                long r6 = r6 + r1
                r1 = r3[r10]
                long r1 = (long) r1
                long r6 = r6 + r1
                long r6 = r6 * r11
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r9 = r3[r5]
                r1 = r16
                r3 = r6
                r5 = r18
                r6 = r9
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            La5:
                if (r9 != 0) goto Lb6
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                int r6 = r8 + r9
                r1 = r16
                r5 = r18
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            Lb6:
                int r1 = ~r8
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.parse(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            int iSafeToInt = Jdk8Methods.safeToInt(value.longValue());
            if (iSafeToInt == 0) {
                sb2.append(this.noOffsetText);
            } else {
                int iAbs = Math.abs((iSafeToInt / 3600) % 100);
                int iAbs2 = Math.abs((iSafeToInt / 60) % 60);
                int iAbs3 = Math.abs(iSafeToInt % 60);
                int length = sb2.length();
                sb2.append(iSafeToInt < 0 ? "-" : "+");
                sb2.append((char) ((iAbs / 10) + 48));
                sb2.append((char) ((iAbs % 10) + 48));
                int i10 = this.type;
                if (i10 >= 3 || (i10 >= 1 && iAbs2 > 0)) {
                    sb2.append(i10 % 2 == 0 ? ":" : "");
                    sb2.append((char) ((iAbs2 / 10) + 48));
                    sb2.append((char) ((iAbs2 % 10) + 48));
                    iAbs += iAbs2;
                    int i11 = this.type;
                    if (i11 >= 7 || (i11 >= 5 && iAbs3 > 0)) {
                        sb2.append(i11 % 2 != 0 ? "" : ":");
                        sb2.append((char) ((iAbs3 / 10) + 48));
                        sb2.append((char) ((iAbs3 % 10) + 48));
                        iAbs += iAbs3;
                    }
                }
                if (iAbs == 0) {
                    sb2.setLength(length);
                    sb2.append(this.noOffsetText);
                }
            }
            return true;
        }

        public String toString() {
            return "Offset(" + PATTERNS[this.type] + ",'" + this.noOffsetText.replace("'", "''") + "')";
        }
    }

    public static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        public PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i10, char c10) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = i10;
            this.padChar = c10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            boolean zIsStrict = dateTimeParseContext.isStrict();
            boolean zIsCaseSensitive = dateTimeParseContext.isCaseSensitive();
            if (i10 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (i10 == charSequence.length()) {
                return ~i10;
            }
            int length = this.padWidth + i10;
            if (length > charSequence.length()) {
                if (zIsStrict) {
                    return ~i10;
                }
                length = charSequence.length();
            }
            int i11 = i10;
            while (i11 < length) {
                if (!zIsCaseSensitive) {
                    if (!dateTimeParseContext.charEquals(charSequence.charAt(i11), this.padChar)) {
                        break;
                    }
                    i11++;
                } else {
                    if (charSequence.charAt(i11) != this.padChar) {
                        break;
                    }
                    i11++;
                }
            }
            int i12 = this.printerParser.parse(dateTimeParseContext, charSequence.subSequence(0, length), i11);
            return (i12 == length || !zIsStrict) ? i12 : ~(i10 + i11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            int length = sb2.length();
            if (!this.printerParser.print(dateTimePrintContext, sb2)) {
                return false;
            }
            int length2 = sb2.length() - length;
            if (length2 > this.padWidth) {
                StringBuilder sbS = c.s("Cannot print as output of ", length2, " characters exceeds pad width of ");
                sbS.append(this.padWidth);
                throw new DateTimeException(sbS.toString());
            }
            for (int i10 = 0; i10 < this.padWidth - length2; i10++) {
                sb2.insert(length, this.padChar);
            }
            return true;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder("Pad(");
            sb2.append(this.printerParser);
            sb2.append(",");
            sb2.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                str = ",'" + this.padChar + "')";
            }
            sb2.append(str);
            return sb2.toString();
        }
    }

    public static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        public ReducedPrinterParser(TemporalField temporalField, int i10, int i11, int i12, ChronoLocalDate chronoLocalDate) {
            super(temporalField, i10, i11, SignStyle.NOT_NEGATIVE);
            if (i10 < 1 || i10 > 10) {
                throw new IllegalArgumentException(c.f("The width must be from 1 to 10 inclusive but was ", i10));
            }
            if (i11 < 1 || i11 > 10) {
                throw new IllegalArgumentException(c.f("The maxWidth must be from 1 to 10 inclusive but was ", i11));
            }
            if (i11 < i10) {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
            if (chronoLocalDate == null) {
                long j10 = i12;
                if (!temporalField.range().isValidValue(j10)) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                }
                if (j10 + NumberPrinterParser.EXCEED_POINTS[i10] > 2147483647L) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
            this.baseValue = i12;
            this.baseDate = chronoLocalDate;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public long getValue(DateTimePrintContext dateTimePrintContext, long j10) {
            long jAbs = Math.abs(j10);
            int i10 = this.baseValue;
            if (this.baseDate != null) {
                i10 = Chronology.from(dateTimePrintContext.getTemporal()).date(this.baseDate).get(this.field);
            }
            if (j10 >= i10) {
                int i11 = NumberPrinterParser.EXCEED_POINTS[this.minWidth];
                if (j10 < i10 + i11) {
                    return jAbs % i11;
                }
            }
            return jAbs % NumberPrinterParser.EXCEED_POINTS[this.maxWidth];
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            if (dateTimeParseContext.isStrict()) {
                return super.isFixedWidth(dateTimeParseContext);
            }
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public int setValue(DateTimeParseContext dateTimeParseContext, long j10, int i10, int i11) {
            int i12 = this.baseValue;
            if (this.baseDate != null) {
                i12 = dateTimeParseContext.getEffectiveChronology().date(this.baseDate).get(this.field);
                dateTimeParseContext.addChronologyChangedParser(this, j10, i10, i11);
            }
            int i13 = i11 - i10;
            int i14 = this.minWidth;
            if (i13 == i14 && j10 >= 0) {
                long j11 = NumberPrinterParser.EXCEED_POINTS[i14];
                long j12 = i12;
                long j13 = j12 - (j12 % j11);
                j10 = i12 > 0 ? j13 + j10 : j13 - j10;
                if (j10 < j12) {
                    j10 += j11;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, j10, i10, i11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder sb2 = new StringBuilder("ReducedValue(");
            sb2.append(this.field);
            sb2.append(",");
            sb2.append(this.minWidth);
            sb2.append(",");
            sb2.append(this.maxWidth);
            sb2.append(",");
            Object objValueOf = this.baseDate;
            if (objValueOf == null) {
                objValueOf = Integer.valueOf(this.baseValue);
            }
            sb2.append(objValueOf);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withSubsequentWidth(int i10) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + i10);
        }

        private ReducedPrinterParser(TemporalField temporalField, int i10, int i11, int i12, ChronoLocalDate chronoLocalDate, int i13) {
            super(temporalField, i10, i11, SignStyle.NOT_NEGATIVE, i13);
            this.baseValue = i12;
            this.baseDate = chronoLocalDate;
        }
    }

    public enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                dateTimeParseContext.setCaseSensitive(true);
            } else if (iOrdinal == 1) {
                dateTimeParseContext.setCaseSensitive(false);
            } else if (iOrdinal == 2) {
                dateTimeParseContext.setStrict(true);
            } else if (iOrdinal == 3) {
                dateTimeParseContext.setStrict(false);
            }
            return i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (iOrdinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (iOrdinal == 2) {
                return "ParseStrict(true)";
            }
            if (iOrdinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    public static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        public StringLiteralPrinterParser(String str) {
            this.literal = str;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            if (i10 > charSequence.length() || i10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.literal;
            return !dateTimeParseContext.subSequenceEquals(charSequence, i10, str, 0, str.length()) ? ~i10 : this.literal.length() + i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            sb2.append(this.literal);
            return true;
        }

        public String toString() {
            return c.k("'", this.literal.replace("'", "''"), "'");
        }
    }

    public static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        public TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle;
            this.provider = dateTimeTextProvider;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            int length = charSequence.length();
            if (i10 < 0 || i10 > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> textIterator = this.provider.getTextIterator(this.field, dateTimeParseContext.isStrict() ? this.textStyle : null, dateTimeParseContext.getLocale());
            if (textIterator != null) {
                while (textIterator.hasNext()) {
                    Map.Entry<String, Long> next = textIterator.next();
                    String key = next.getKey();
                    if (dateTimeParseContext.subSequenceEquals(key, 0, charSequence, i10, key.length())) {
                        return dateTimeParseContext.setParsedField(this.field, next.getValue().longValue(), i10, key.length() + i10);
                    }
                }
                if (dateTimeParseContext.isStrict()) {
                    return ~i10;
                }
            }
            return numberPrinterParser().parse(dateTimeParseContext, charSequence, i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            String text = this.provider.getText(this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale());
            if (text == null) {
                return numberPrinterParser().print(dateTimePrintContext, sb2);
            }
            sb2.append(text);
            return true;
        }

        public String toString() {
            if (this.textStyle == TextStyle.FULL) {
                return "Text(" + this.field + ")";
            }
            return "Text(" + this.field + "," + this.textStyle + ")";
        }
    }

    public static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final int count;
        private final char letter;

        public WeekFieldsPrinterParser(char c10, int i10) {
            this.letter = c10;
            this.count = i10;
        }

        private DateTimePrinterParser evaluate(WeekFields weekFields) {
            char c10 = this.letter;
            if (c10 == 'W') {
                return new NumberPrinterParser(weekFields.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c10 == 'Y') {
                if (this.count == 2) {
                    return new ReducedPrinterParser(weekFields.weekBasedYear(), 2, 2, 0, ReducedPrinterParser.BASE_DATE);
                }
                TemporalField temporalFieldWeekBasedYear = weekFields.weekBasedYear();
                int i10 = this.count;
                return new NumberPrinterParser(temporalFieldWeekBasedYear, i10, 19, i10 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
            }
            if (c10 == 'c') {
                return new NumberPrinterParser(weekFields.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c10 == 'e') {
                return new NumberPrinterParser(weekFields.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c10 != 'w') {
                return null;
            }
            return new NumberPrinterParser(weekFields.weekOfWeekBasedYear(), this.count, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            return evaluate(WeekFields.of(dateTimeParseContext.getLocale())).parse(dateTimeParseContext, charSequence, i10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return evaluate(WeekFields.of(dateTimePrintContext.getLocale())).print(dateTimePrintContext, sb2);
        }

        public String toString() {
            StringBuilder sbQ = c.q(30, "Localized(");
            char c10 = this.letter;
            if (c10 == 'Y') {
                int i10 = this.count;
                if (i10 == 1) {
                    sbQ.append("WeekBasedYear");
                } else if (i10 == 2) {
                    sbQ.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
                } else {
                    sbQ.append("WeekBasedYear,");
                    sbQ.append(this.count);
                    sbQ.append(",19,");
                    sbQ.append(this.count < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
            } else {
                if (c10 == 'c' || c10 == 'e') {
                    sbQ.append("DayOfWeek");
                } else if (c10 == 'w') {
                    sbQ.append("WeekOfWeekBasedYear");
                } else if (c10 == 'W') {
                    sbQ.append("WeekOfMonth");
                }
                sbQ.append(",");
                sbQ.append(this.count);
            }
            sbQ.append(")");
            return sbQ.toString();
        }
    }

    public static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, SubstringTree> cachedSubstringTree;
        private final String description;
        private final TemporalQuery<ZoneId> query;

        public static final class SubstringTree {
            final int length;
            private final Map<CharSequence, SubstringTree> substringMap;
            private final Map<String, SubstringTree> substringMapCI;

            /* JADX INFO: Access modifiers changed from: private */
            public void add(String str) {
                int length = str.length();
                int i10 = this.length;
                if (length == i10) {
                    this.substringMap.put(str, null);
                    this.substringMapCI.put(str.toLowerCase(Locale.ENGLISH), null);
                } else if (length > i10) {
                    String strSubstring = str.substring(0, i10);
                    SubstringTree substringTree = this.substringMap.get(strSubstring);
                    if (substringTree == null) {
                        substringTree = new SubstringTree(length);
                        this.substringMap.put(strSubstring, substringTree);
                        this.substringMapCI.put(strSubstring.toLowerCase(Locale.ENGLISH), substringTree);
                    }
                    substringTree.add(str);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public SubstringTree get(CharSequence charSequence, boolean z10) {
                return z10 ? this.substringMap.get(charSequence) : this.substringMapCI.get(charSequence.toString().toLowerCase(Locale.ENGLISH));
            }

            private SubstringTree(int i10) {
                this.substringMap = new HashMap();
                this.substringMapCI = new HashMap();
                this.length = i10;
            }
        }

        public ZoneIdPrinterParser(TemporalQuery<ZoneId> temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        private ZoneId convertToZone(Set<String> set, String str, boolean z10) {
            if (str == null) {
                return null;
            }
            if (z10) {
                if (set.contains(str)) {
                    return ZoneId.of(str);
                }
                return null;
            }
            for (String str2 : set) {
                if (str2.equalsIgnoreCase(str)) {
                    return ZoneId.of(str2);
                }
            }
            return null;
        }

        private int parsePrefixedOffset(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10, int i11) {
            String upperCase = charSequence.subSequence(i10, i11).toString().toUpperCase();
            DateTimeParseContext dateTimeParseContextCopy = dateTimeParseContext.copy();
            if (i11 < charSequence.length() && dateTimeParseContext.charEquals(charSequence.charAt(i11), 'Z')) {
                dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                return i11;
            }
            int i12 = OffsetIdPrinterParser.INSTANCE_ID.parse(dateTimeParseContextCopy, charSequence, i11);
            if (i12 < 0) {
                dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                return i11;
            }
            dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) dateTimeParseContextCopy.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
            return i12;
        }

        private static SubstringTree prepareParser(Set<String> set) {
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList, DateTimeFormatterBuilder.LENGTH_SORT);
            SubstringTree substringTree = new SubstringTree(((String) arrayList.get(0)).length());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                substringTree.add((String) it.next());
            }
            return substringTree;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            int i11;
            int length = charSequence.length();
            if (i10 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i10 == length) {
                return ~i10;
            }
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == '+' || cCharAt == '-') {
                DateTimeParseContext dateTimeParseContextCopy = dateTimeParseContext.copy();
                int i12 = OffsetIdPrinterParser.INSTANCE_ID.parse(dateTimeParseContextCopy, charSequence, i10);
                if (i12 < 0) {
                    return i12;
                }
                dateTimeParseContext.setParsed(ZoneOffset.ofTotalSeconds((int) dateTimeParseContextCopy.getParsed(ChronoField.OFFSET_SECONDS).longValue()));
                return i12;
            }
            int i13 = i10 + 2;
            if (length >= i13) {
                char cCharAt2 = charSequence.charAt(i10 + 1);
                if (dateTimeParseContext.charEquals(cCharAt, 'U') && dateTimeParseContext.charEquals(cCharAt2, 'T')) {
                    int i14 = i10 + 3;
                    return (length < i14 || !dateTimeParseContext.charEquals(charSequence.charAt(i13), 'C')) ? parsePrefixedOffset(dateTimeParseContext, charSequence, i10, i13) : parsePrefixedOffset(dateTimeParseContext, charSequence, i10, i14);
                }
                if (dateTimeParseContext.charEquals(cCharAt, 'G') && length >= (i11 = i10 + 3) && dateTimeParseContext.charEquals(cCharAt2, 'M') && dateTimeParseContext.charEquals(charSequence.charAt(i13), 'T')) {
                    return parsePrefixedOffset(dateTimeParseContext, charSequence, i10, i11);
                }
            }
            Set<String> availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = availableZoneIds.size();
            Map.Entry<Integer, SubstringTree> simpleImmutableEntry = cachedSubstringTree;
            if (simpleImmutableEntry == null || simpleImmutableEntry.getKey().intValue() != size) {
                synchronized (this) {
                    simpleImmutableEntry = cachedSubstringTree;
                    if (simpleImmutableEntry == null || simpleImmutableEntry.getKey().intValue() != size) {
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry<>(Integer.valueOf(size), prepareParser(availableZoneIds));
                        cachedSubstringTree = simpleImmutableEntry;
                    }
                }
            }
            SubstringTree value = simpleImmutableEntry.getValue();
            String str = null;
            String str2 = null;
            while (value != null) {
                int i15 = value.length + i10;
                if (i15 > length) {
                    break;
                }
                String string = charSequence.subSequence(i10, i15).toString();
                value = value.get(string, dateTimeParseContext.isCaseSensitive());
                str2 = str;
                str = string;
            }
            ZoneId zoneIdConvertToZone = convertToZone(availableZoneIds, str, dateTimeParseContext.isCaseSensitive());
            if (zoneIdConvertToZone == null) {
                zoneIdConvertToZone = convertToZone(availableZoneIds, str2, dateTimeParseContext.isCaseSensitive());
                if (zoneIdConvertToZone == null) {
                    if (!dateTimeParseContext.charEquals(cCharAt, 'Z')) {
                        return ~i10;
                    }
                    dateTimeParseContext.setParsed(ZoneOffset.UTC);
                    return i10 + 1;
                }
                str = str2;
            }
            dateTimeParseContext.setParsed(zoneIdConvertToZone);
            return str.length() + i10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(this.query);
            if (zoneId == null) {
                return false;
            }
            sb2.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    public static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> LENGTH_COMPARATOR = new Comparator<String>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        };
        private final TextStyle textStyle;

        public ZoneTextPrinterParser(TextStyle textStyle) {
            this.textStyle = (TextStyle) Jdk8Methods.requireNonNull(textStyle, "textStyle");
        }

        private int parseOffset(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10, String str) {
            int length = str.length();
            int i11 = i10 + length;
            if (i11 >= charSequence.length()) {
                dateTimeParseContext.setParsed(ZoneId.of(str));
                return i11;
            }
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt != '+' && cCharAt != '-') {
                dateTimeParseContext.setParsed(ZoneId.of(str));
                return i11;
            }
            DateTimeParseContext dateTimeParseContextCopy = dateTimeParseContext.copy();
            try {
                int i12 = OffsetIdPrinterParser.INSTANCE_ID_ZERO.parse(dateTimeParseContextCopy, charSequence, i11);
                if (i12 < 0) {
                    dateTimeParseContext.setParsed(ZoneId.of(str));
                    return i11;
                }
                ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds((int) dateTimeParseContextCopy.getParsed(ChronoField.OFFSET_SECONDS).longValue());
                dateTimeParseContext.setParsed(length == 0 ? zoneOffsetOfTotalSeconds : ZoneId.ofOffset(str, zoneOffsetOfTotalSeconds));
                return i12;
            } catch (DateTimeException unused) {
                return ~i10;
            }
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10) {
            int length = charSequence.length();
            if (i10 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i10 == length) {
                return ~i10;
            }
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == '+' || cCharAt == '-') {
                return i10 + 6 > length ? ~i10 : parseOffset(dateTimeParseContext, charSequence, i10, "");
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i10, TimeZones.GMT_ID, 0, 3)) {
                return parseOffset(dateTimeParseContext, charSequence, i10, TimeZones.GMT_ID);
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i10, "UTC", 0, 3)) {
                return parseOffset(dateTimeParseContext, charSequence, i10, "UTC");
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i10, "UT", 0, 2)) {
                return parseOffset(dateTimeParseContext, charSequence, i10, "UT");
            }
            TreeMap treeMap = new TreeMap(LENGTH_COMPARATOR);
            for (String str : ZoneId.getAvailableZoneIds()) {
                treeMap.put(str, str);
                TimeZone timeZone = TimeZone.getTimeZone(str);
                int i11 = this.textStyle.asNormal() == TextStyle.FULL ? 1 : 0;
                String displayName = timeZone.getDisplayName(false, i11, dateTimeParseContext.getLocale());
                if (str.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                    treeMap.put(displayName, str);
                }
                String displayName2 = timeZone.getDisplayName(true, i11, dateTimeParseContext.getLocale());
                if (str.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                    treeMap.put(displayName2, str);
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str2 = (String) entry.getKey();
                if (dateTimeParseContext.subSequenceEquals(charSequence, i10, str2, 0, str2.length())) {
                    dateTimeParseContext.setParsed(ZoneId.of((String) entry.getValue()));
                    return str2.length() + i10;
                }
            }
            if (cCharAt != 'Z') {
                return ~i10;
            }
            dateTimeParseContext.setParsed(ZoneOffset.UTC);
            return i10 + 1;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(TemporalQueries.zoneId());
            if (zoneId == null) {
                return false;
            }
            if (zoneId.normalized() instanceof ZoneOffset) {
                sb2.append(zoneId.getId());
                return true;
            }
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            sb2.append(TimeZone.getTimeZone(zoneId.getId()).getDisplayName(temporal.isSupported(chronoField) ? zoneId.getRules().isDaylightSavings(Instant.ofEpochSecond(temporal.getLong(chronoField))) : false, this.textStyle.asNormal() == TextStyle.FULL ? 1 : 0, dateTimePrintContext.getLocale()));
            return true;
        }

        public String toString() {
            return "ZoneText(" + this.textStyle + ")";
        }
    }

    static {
        HashMap map = new HashMap();
        FIELD_MAP = map;
        map.put('G', ChronoField.ERA);
        map.put('y', ChronoField.YEAR_OF_ERA);
        map.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.QUARTER_OF_YEAR;
        map.put('Q', temporalField);
        map.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        map.put('M', chronoField);
        map.put('L', chronoField);
        map.put('D', ChronoField.DAY_OF_YEAR);
        map.put('d', ChronoField.DAY_OF_MONTH);
        map.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        map.put('E', chronoField2);
        map.put('c', chronoField2);
        map.put('e', chronoField2);
        map.put('a', ChronoField.AMPM_OF_DAY);
        map.put('H', ChronoField.HOUR_OF_DAY);
        map.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        map.put('K', ChronoField.HOUR_OF_AMPM);
        map.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        map.put('m', ChronoField.MINUTE_OF_HOUR);
        map.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        map.put('S', chronoField3);
        map.put('A', ChronoField.MILLI_OF_DAY);
        map.put('n', chronoField3);
        map.put('N', ChronoField.NANO_OF_DAY);
        LENGTH_SORT = new Comparator<String>() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.3
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
            }
        };
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        Jdk8Methods.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i10 = dateTimeFormatterBuilder.padNextWidth;
        if (i10 > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, i10, dateTimeFormatterBuilder.padNextChar);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = (char) 0;
        }
        this.active.printerParsers.add(dateTimePrinterParser);
        this.active.valueParserIndex = -1;
        return r4.printerParsers.size() - 1;
    }

    public static String getLocalizedDateTimePattern(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        Jdk8Methods.requireNonNull(chronology, "chrono");
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either dateStyle or timeStyle must be non-null");
        }
        DateFormat dateTimeInstance = formatStyle != null ? formatStyle2 != null ? DateFormat.getDateTimeInstance(formatStyle.ordinal(), formatStyle2.ordinal(), locale) : DateFormat.getDateInstance(formatStyle.ordinal(), locale) : DateFormat.getTimeInstance(formatStyle2.ordinal(), locale);
        if (dateTimeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        }
        throw new IllegalArgumentException("Unable to determine pattern");
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseField(char r8, int r9, org.threeten.bp.temporal.TemporalField r10) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.parseField(char, int, org.threeten.bp.temporal.TemporalField):void");
    }

    private void parsePattern(String str) {
        int i10;
        int i11 = 0;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int i12 = i11 + 1;
                while (i12 < str.length() && str.charAt(i12) == cCharAt) {
                    i12++;
                }
                int i13 = i12 - i11;
                if (cCharAt == 'p') {
                    if (i12 >= str.length() || (((cCharAt = str.charAt(i12)) < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                        i10 = i13;
                        i13 = 0;
                    } else {
                        int i14 = i12 + 1;
                        while (i14 < str.length() && str.charAt(i14) == cCharAt) {
                            i14++;
                        }
                        i10 = i14 - i12;
                        i12 = i14;
                    }
                    if (i13 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: ".concat(str));
                    }
                    padNext(i13);
                    i13 = i10;
                }
                TemporalField temporalField = FIELD_MAP.get(Character.valueOf(cCharAt));
                if (temporalField != null) {
                    parseField(cCharAt, i13, temporalField);
                } else if (cCharAt == 'z') {
                    if (i13 > 4) {
                        throw new IllegalArgumentException(c.e("Too many pattern letters: ", cCharAt));
                    }
                    if (i13 == 4) {
                        appendZoneText(TextStyle.FULL);
                    } else {
                        appendZoneText(TextStyle.SHORT);
                    }
                } else if (cCharAt != 'V') {
                    String str2 = "+0000";
                    if (cCharAt == 'Z') {
                        if (i13 < 4) {
                            appendOffset("+HHMM", "+0000");
                        } else if (i13 == 4) {
                            appendLocalizedOffset(TextStyle.FULL);
                        } else {
                            if (i13 != 5) {
                                throw new IllegalArgumentException(c.e("Too many pattern letters: ", cCharAt));
                            }
                            appendOffset("+HH:MM:ss", "Z");
                        }
                    } else if (cCharAt == 'O') {
                        if (i13 == 1) {
                            appendLocalizedOffset(TextStyle.SHORT);
                        } else {
                            if (i13 != 4) {
                                throw new IllegalArgumentException(c.e("Pattern letter count must be 1 or 4: ", cCharAt));
                            }
                            appendLocalizedOffset(TextStyle.FULL);
                        }
                    } else if (cCharAt == 'X') {
                        if (i13 > 5) {
                            throw new IllegalArgumentException(c.e("Too many pattern letters: ", cCharAt));
                        }
                        appendOffset(OffsetIdPrinterParser.PATTERNS[i13 + (i13 == 1 ? 0 : 1)], "Z");
                    } else if (cCharAt == 'x') {
                        if (i13 > 5) {
                            throw new IllegalArgumentException(c.e("Too many pattern letters: ", cCharAt));
                        }
                        if (i13 == 1) {
                            str2 = "+00";
                        } else if (i13 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        appendOffset(OffsetIdPrinterParser.PATTERNS[i13 + (i13 == 1 ? 0 : 1)], str2);
                    } else if (cCharAt == 'W') {
                        if (i13 > 1) {
                            throw new IllegalArgumentException(c.e("Too many pattern letters: ", cCharAt));
                        }
                        appendInternal(new WeekFieldsPrinterParser('W', i13));
                    } else if (cCharAt == 'w') {
                        if (i13 > 2) {
                            throw new IllegalArgumentException(c.e("Too many pattern letters: ", cCharAt));
                        }
                        appendInternal(new WeekFieldsPrinterParser('w', i13));
                    } else {
                        if (cCharAt != 'Y') {
                            throw new IllegalArgumentException(c.e("Unknown pattern letter: ", cCharAt));
                        }
                        appendInternal(new WeekFieldsPrinterParser('Y', i13));
                    }
                } else {
                    if (i13 != 2) {
                        throw new IllegalArgumentException(c.e("Pattern letter count must be 2: ", cCharAt));
                    }
                    appendZoneId();
                }
                i11 = i12 - 1;
            } else if (cCharAt == '\'') {
                int i15 = i11 + 1;
                int i16 = i15;
                while (i16 < str.length()) {
                    if (str.charAt(i16) == '\'') {
                        int i17 = i16 + 1;
                        if (i17 >= str.length() || str.charAt(i17) != '\'') {
                            break;
                        } else {
                            i16 = i17;
                        }
                    }
                    i16++;
                }
                if (i16 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: ".concat(str));
                }
                String strSubstring = str.substring(i15, i16);
                if (strSubstring.length() == 0) {
                    appendLiteral('\'');
                } else {
                    appendLiteral(strSubstring.replace("''", "'"));
                }
                i11 = i16;
            } else if (cCharAt == '[') {
                optionalStart();
            } else if (cCharAt == ']') {
                if (this.active.parent == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                optionalEnd();
            } else {
                if (cCharAt == '{' || cCharAt == '}' || cCharAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cCharAt + "'");
                }
                appendLiteral(cCharAt);
            }
            i11++;
        }
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyId() {
        appendInternal(new ChronoPrinterParser(null));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyText(TextStyle textStyle) {
        Jdk8Methods.requireNonNull(textStyle, "textStyle");
        appendInternal(new ChronoPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField temporalField, int i10, int i11, boolean z10) {
        appendInternal(new FractionPrinterParser(temporalField, i10, i11, z10));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c10) {
        appendInternal(new CharLiteralPrinterParser(c10));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalized(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        appendInternal(new LocalizedPrinterParser(formatStyle, formatStyle2));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle textStyle) {
        Jdk8Methods.requireNonNull(textStyle, "style");
        if (textStyle != TextStyle.FULL && textStyle != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        appendInternal(new LocalizedOffsetPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        appendInternal(new OffsetIdPrinterParser(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID);
        return this;
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.toPrinterParser(true));
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        Jdk8Methods.requireNonNull(str, "pattern");
        parsePattern(str);
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField) {
        return appendText(temporalField, TextStyle.FULL);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendValue(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int i10, int i11, int i12) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendValue(new ReducedPrinterParser(temporalField, i10, i11, i12, null));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneOrOffsetId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zone(), "ZoneOrOffsetId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
            this.active = this.active.parent;
            appendInternal(compositePrinterParser);
        } else {
            this.active = this.active.parent;
        }
        return this;
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i10) {
        return padNext(i10, TokenParser.SP);
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseDefaulting(TemporalField temporalField, long j10) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendInternal(new DefaultingParser(temporalField, j10));
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatterBuilder parseStrict() {
        appendInternal(SettingsParser.STRICT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    public DateTimeFormatterBuilder appendInstant(int i10) {
        if (i10 < -1 || i10 > 9) {
            throw new IllegalArgumentException(c.f("Invalid fractional digits: ", i10));
        }
        appendInternal(new InstantPrinterParser(i10));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        Jdk8Methods.requireNonNull(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                appendInternal(new CharLiteralPrinterParser(str.charAt(0)));
            } else {
                appendInternal(new StringLiteralPrinterParser(str));
            }
        }
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, TextStyle textStyle) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle, Set<ZoneId> set) {
        Jdk8Methods.requireNonNull(set, "preferredZones");
        appendInternal(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i10, char c10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(c.f("The pad width must be at least one but was ", i10));
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.padNextWidth = i10;
        dateTimeFormatterBuilder.padNextChar = c10;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        return this;
    }

    public DateTimeFormatter toFormatter(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, ResolverStyle.SMART, null, null, null);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i10) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        if (i10 >= 1 && i10 <= 19) {
            appendValue(new NumberPrinterParser(temporalField, i10, i10, SignStyle.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException(c.f("The width must be from 1 to 19 inclusive but was ", i10));
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int i10, int i11, ChronoLocalDate chronoLocalDate) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(chronoLocalDate, "baseDate");
        appendValue(new ReducedPrinterParser(temporalField, i10, i11, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map<Long, String> map) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final SimpleDateTimeTextProvider.LocaleStore localeStore = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() { // from class: org.threeten.bp.format.DateTimeFormatterBuilder.2
            @Override // org.threeten.bp.format.DateTimeTextProvider
            public String getText(TemporalField temporalField2, long j10, TextStyle textStyle2, Locale locale) {
                return localeStore.getText(j10, textStyle2);
            }

            @Override // org.threeten.bp.format.DateTimeTextProvider
            public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField2, TextStyle textStyle2, Locale locale) {
                return localeStore.getTextIterator(textStyle2);
            }
        }));
        return this;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z10) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z10;
    }

    public DateTimeFormatter toFormatter(ResolverStyle resolverStyle) {
        return toFormatter().withResolverStyle(resolverStyle);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i10, int i11, SignStyle signStyle) {
        if (i10 == i11 && signStyle == SignStyle.NOT_NEGATIVE) {
            return appendValue(temporalField, i11);
        }
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(signStyle, "signStyle");
        if (i10 < 1 || i10 > 19) {
            throw new IllegalArgumentException(c.f("The minimum width must be from 1 to 19 inclusive but was ", i10));
        }
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException(c.f("The maximum width must be from 1 to 19 inclusive but was ", i11));
        }
        if (i11 >= i10) {
            appendValue(new NumberPrinterParser(temporalField, i10, i11, signStyle));
            return this;
        }
        throw new IllegalArgumentException(c.g("The maximum width must exceed or equal the minimum width but ", i11, " < ", i10));
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParserWithFixedWidth;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i10 = dateTimeFormatterBuilder.valueParserIndex;
        if (i10 >= 0 && (dateTimeFormatterBuilder.printerParsers.get(i10) instanceof NumberPrinterParser)) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            int i11 = dateTimeFormatterBuilder2.valueParserIndex;
            NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) dateTimeFormatterBuilder2.printerParsers.get(i11);
            int i12 = numberPrinterParser.minWidth;
            int i13 = numberPrinterParser.maxWidth;
            if (i12 == i13 && numberPrinterParser.signStyle == SignStyle.NOT_NEGATIVE) {
                numberPrinterParserWithFixedWidth = numberPrinterParser2.withSubsequentWidth(i13);
                appendInternal(numberPrinterParser.withFixedWidth());
                this.active.valueParserIndex = i11;
            } else {
                numberPrinterParserWithFixedWidth = numberPrinterParser2.withFixedWidth();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(i11, numberPrinterParserWithFixedWidth);
        } else {
            this.active.valueParserIndex = appendInternal(numberPrinterParser);
        }
        return this;
    }
}
