package org.threeten.bp.format;

import ac.c;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.time.TimeZones;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseContext;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

/* loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter BASIC_ISO_DATE;
    public static final DateTimeFormatter ISO_DATE;
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_INSTANT;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME;
    public static final DateTimeFormatter ISO_LOCAL_TIME;
    public static final DateTimeFormatter ISO_OFFSET_DATE;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME;
    public static final DateTimeFormatter ISO_OFFSET_TIME;
    public static final DateTimeFormatter ISO_ORDINAL_DATE;
    public static final DateTimeFormatter ISO_TIME;
    public static final DateTimeFormatter ISO_WEEK_DATE;
    public static final DateTimeFormatter ISO_ZONED_DATE_TIME;
    private static final TemporalQuery<Period> PARSED_EXCESS_DAYS;
    private static final TemporalQuery<Boolean> PARSED_LEAP_SECOND;
    public static final DateTimeFormatter RFC_1123_DATE_TIME;
    private final Chronology chrono;
    private final DecimalStyle decimalStyle;
    private final Locale locale;
    private final DateTimeFormatterBuilder.CompositePrinterParser printerParser;
    private final Set<TemporalField> resolverFields;
    private final ResolverStyle resolverStyle;
    private final ZoneId zone;

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral = dateTimeFormatterBuilder.appendValue(chronoField, 4, 10, signStyle).appendLiteral('-');
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral2 = dateTimeFormatterBuilderAppendLiteral.appendValue(chronoField2, 2).appendLiteral('-');
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendValue = dateTimeFormatterBuilderAppendLiteral2.appendValue(chronoField3, 2);
        ResolverStyle resolverStyle = ResolverStyle.STRICT;
        DateTimeFormatter formatter = dateTimeFormatterBuilderAppendValue.toFormatter(resolverStyle);
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        DateTimeFormatter dateTimeFormatterWithChronology = formatter.withChronology(isoChronology);
        ISO_LOCAL_DATE = dateTimeFormatterWithChronology;
        ISO_OFFSET_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(dateTimeFormatterWithChronology).appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(dateTimeFormatterWithChronology).optionalStart().appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral3 = dateTimeFormatterBuilder2.appendValue(chronoField4, 2).appendLiteral(':');
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral4 = dateTimeFormatterBuilderAppendLiteral3.appendValue(chronoField5, 2).optionalStart().appendLiteral(':');
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        DateTimeFormatter formatter2 = dateTimeFormatterBuilderAppendLiteral4.appendValue(chronoField6, 2).optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).toFormatter(resolverStyle);
        ISO_LOCAL_TIME = formatter2;
        ISO_OFFSET_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(formatter2).appendOffsetId().toFormatter(resolverStyle);
        ISO_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(formatter2).optionalStart().appendOffsetId().toFormatter(resolverStyle);
        DateTimeFormatter dateTimeFormatterWithChronology2 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(dateTimeFormatterWithChronology).appendLiteral('T').append(formatter2).toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_LOCAL_DATE_TIME = dateTimeFormatterWithChronology2;
        DateTimeFormatter dateTimeFormatterWithChronology3 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(dateTimeFormatterWithChronology2).appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_OFFSET_DATE_TIME = dateTimeFormatterWithChronology3;
        ISO_ZONED_DATE_TIME = new DateTimeFormatterBuilder().append(dateTimeFormatterWithChronology3).optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_DATE_TIME = new DateTimeFormatterBuilder().append(dateTimeFormatterWithChronology2).optionalStart().appendOffsetId().optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral(']').toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_ORDINAL_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(chronoField, 4, 10, signStyle).appendLiteral('-').appendValue(ChronoField.DAY_OF_YEAR, 3).optionalStart().appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral5 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, signStyle).appendLiteral("-W").appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2).appendLiteral('-');
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        ISO_WEEK_DATE = dateTimeFormatterBuilderAppendLiteral5.appendValue(chronoField7, 1).optionalStart().appendOffsetId().toFormatter(resolverStyle).withChronology(isoChronology);
        ISO_INSTANT = new DateTimeFormatterBuilder().parseCaseInsensitive().appendInstant().toFormatter(resolverStyle);
        BASIC_ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(chronoField, 4).appendValue(chronoField2, 2).appendValue(chronoField3, 2).optionalStart().appendOffset("+HHMMss", "Z").toFormatter(resolverStyle).withChronology(isoChronology);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        RFC_1123_DATE_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText(chronoField7, map).appendLiteral(", ").optionalEnd().appendValue(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE).appendLiteral(TokenParser.SP).appendText(chronoField2, map2).appendLiteral(TokenParser.SP).appendValue(chronoField, 4).appendLiteral(TokenParser.SP).appendValue(chronoField4, 2).appendLiteral(':').appendValue(chronoField5, 2).optionalStart().appendLiteral(':').appendValue(chronoField6, 2).optionalEnd().appendLiteral(TokenParser.SP).appendOffset("+HHMM", TimeZones.GMT_ID).toFormatter(ResolverStyle.SMART).withChronology(isoChronology);
        PARSED_EXCESS_DAYS = new TemporalQuery<Period>() { // from class: org.threeten.bp.format.DateTimeFormatter.1
            @Override // org.threeten.bp.temporal.TemporalQuery
            public Period queryFrom(TemporalAccessor temporalAccessor) {
                return temporalAccessor instanceof DateTimeBuilder ? ((DateTimeBuilder) temporalAccessor).excessDays : Period.ZERO;
            }
        };
        PARSED_LEAP_SECOND = new TemporalQuery<Boolean>() { // from class: org.threeten.bp.format.DateTimeFormatter.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.threeten.bp.temporal.TemporalQuery
            public Boolean queryFrom(TemporalAccessor temporalAccessor) {
                return temporalAccessor instanceof DateTimeBuilder ? Boolean.valueOf(((DateTimeBuilder) temporalAccessor).leapSecond) : Boolean.FALSE;
            }
        };
    }

    public DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale, DecimalStyle decimalStyle, ResolverStyle resolverStyle, Set<TemporalField> set, Chronology chronology, ZoneId zoneId) {
        this.printerParser = (DateTimeFormatterBuilder.CompositePrinterParser) Jdk8Methods.requireNonNull(compositePrinterParser, "printerParser");
        this.locale = (Locale) Jdk8Methods.requireNonNull(locale, "locale");
        this.decimalStyle = (DecimalStyle) Jdk8Methods.requireNonNull(decimalStyle, "decimalStyle");
        this.resolverStyle = (ResolverStyle) Jdk8Methods.requireNonNull(resolverStyle, "resolverStyle");
        this.resolverFields = set;
        this.chrono = chronology;
        this.zone = zoneId;
    }

    private DateTimeParseException createError(CharSequence charSequence, RuntimeException runtimeException) {
        String string;
        if (charSequence.length() > 64) {
            string = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            string = charSequence.toString();
        }
        StringBuilder sbV = c.v("Text '", string, "' could not be parsed: ");
        sbV.append(runtimeException.getMessage());
        return new DateTimeParseException(sbV.toString(), charSequence, 0, runtimeException);
    }

    public static DateTimeFormatter ofLocalizedDate(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "dateStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, null).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "dateTimeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, formatStyle).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedTime(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "timeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(null, formatStyle).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofPattern(String str) {
        return new DateTimeFormatterBuilder().appendPattern(str).toFormatter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateTimeBuilder parseToBuilder(CharSequence charSequence, ParsePosition parsePosition) {
        String string;
        ParsePosition parsePosition2 = parsePosition != null ? parsePosition : new ParsePosition(0);
        DateTimeParseContext.Parsed unresolved0 = parseUnresolved0(charSequence, parsePosition2);
        if (unresolved0 != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return unresolved0.toBuilder();
        }
        if (charSequence.length() > 64) {
            string = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            string = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            StringBuilder sbV = c.v("Text '", string, "' could not be parsed at index ");
            sbV.append(parsePosition2.getErrorIndex());
            throw new DateTimeParseException(sbV.toString(), charSequence, parsePosition2.getErrorIndex());
        }
        StringBuilder sbV2 = c.v("Text '", string, "' could not be parsed, unparsed text found at index ");
        sbV2.append(parsePosition2.getIndex());
        throw new DateTimeParseException(sbV2.toString(), charSequence, parsePosition2.getIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateTimeParseContext.Parsed parseUnresolved0(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(parsePosition, "position");
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this);
        int i10 = this.printerParser.parse(dateTimeParseContext, charSequence, parsePosition.getIndex());
        if (i10 < 0) {
            parsePosition.setErrorIndex(~i10);
            return null;
        }
        parsePosition.setIndex(i10);
        return dateTimeParseContext.toParsed();
    }

    public static final TemporalQuery<Period> parsedExcessDays() {
        return PARSED_EXCESS_DAYS;
    }

    public static final TemporalQuery<Boolean> parsedLeapSecond() {
        return PARSED_LEAP_SECOND;
    }

    public String format(TemporalAccessor temporalAccessor) throws IOException {
        StringBuilder sb2 = new StringBuilder(32);
        formatTo(temporalAccessor, sb2);
        return sb2.toString();
    }

    public void formatTo(TemporalAccessor temporalAccessor, Appendable appendable) throws IOException {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        Jdk8Methods.requireNonNull(appendable, "appendable");
        try {
            DateTimePrintContext dateTimePrintContext = new DateTimePrintContext(temporalAccessor, this);
            if (appendable instanceof StringBuilder) {
                this.printerParser.print(dateTimePrintContext, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb2 = new StringBuilder(32);
            this.printerParser.print(dateTimePrintContext, sb2);
            appendable.append(sb2);
        } catch (IOException e10) {
            throw new DateTimeException(e10.getMessage(), e10);
        }
    }

    public Chronology getChronology() {
        return this.chrono;
    }

    public DecimalStyle getDecimalStyle() {
        return this.decimalStyle;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Set<TemporalField> getResolverFields() {
        return this.resolverFields;
    }

    public ResolverStyle getResolverStyle() {
        return this.resolverStyle;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public TemporalAccessor parse(CharSequence charSequence) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        try {
            return parseToBuilder(charSequence, null).resolve(this.resolverStyle, this.resolverFields);
        } catch (DateTimeParseException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw createError(charSequence, e11);
        }
    }

    public TemporalAccessor parseBest(CharSequence charSequence, TemporalQuery<?>... temporalQueryArr) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(temporalQueryArr, "types");
        if (temporalQueryArr.length < 2) {
            throw new IllegalArgumentException("At least two types must be specified");
        }
        try {
            DateTimeBuilder dateTimeBuilderResolve = parseToBuilder(charSequence, null).resolve(this.resolverStyle, this.resolverFields);
            for (TemporalQuery<?> temporalQuery : temporalQueryArr) {
                try {
                    return (TemporalAccessor) dateTimeBuilderResolve.build(temporalQuery);
                } catch (RuntimeException unused) {
                }
            }
            throw new DateTimeException("Unable to convert parsed text to any specified type: " + Arrays.toString(temporalQueryArr));
        } catch (DateTimeParseException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw createError(charSequence, e11);
        }
    }

    public TemporalAccessor parseUnresolved(CharSequence charSequence, ParsePosition parsePosition) {
        return parseUnresolved0(charSequence, parsePosition);
    }

    public Format toFormat() {
        return new ClassicFormat(this, null);
    }

    public DateTimeFormatterBuilder.CompositePrinterParser toPrinterParser(boolean z10) {
        return this.printerParser.withOptional(z10);
    }

    public String toString() {
        String string = this.printerParser.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }

    public DateTimeFormatter withChronology(Chronology chronology) {
        return Jdk8Methods.equals(this.chrono, chronology) ? this : new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, chronology, this.zone);
    }

    public DateTimeFormatter withDecimalStyle(DecimalStyle decimalStyle) {
        return this.decimalStyle.equals(decimalStyle) ? this : new DateTimeFormatter(this.printerParser, this.locale, decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withLocale(Locale locale) {
        return this.locale.equals(locale) ? this : new DateTimeFormatter(this.printerParser, locale, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withResolverFields(TemporalField... temporalFieldArr) {
        if (temporalFieldArr == null) {
            return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, null, this.chrono, this.zone);
        }
        HashSet hashSet = new HashSet(Arrays.asList(temporalFieldArr));
        if (Jdk8Methods.equals(this.resolverFields, hashSet)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, Collections.unmodifiableSet(hashSet), this.chrono, this.zone);
    }

    public DateTimeFormatter withResolverStyle(ResolverStyle resolverStyle) {
        Jdk8Methods.requireNonNull(resolverStyle, "resolverStyle");
        return Jdk8Methods.equals(this.resolverStyle, resolverStyle) ? this : new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withZone(ZoneId zoneId) {
        return Jdk8Methods.equals(this.zone, zoneId) ? this : new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, zoneId);
    }

    public static DateTimeFormatter ofPattern(String str, Locale locale) {
        return new DateTimeFormatterBuilder().appendPattern(str).toFormatter(locale);
    }

    public Format toFormat(TemporalQuery<?> temporalQuery) {
        Jdk8Methods.requireNonNull(temporalQuery, "query");
        return new ClassicFormat(this, temporalQuery);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle formatStyle, FormatStyle formatStyle2) {
        Jdk8Methods.requireNonNull(formatStyle, "dateStyle");
        Jdk8Methods.requireNonNull(formatStyle2, "timeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, formatStyle2).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public TemporalAccessor parse(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(parsePosition, "position");
        try {
            return parseToBuilder(charSequence, parsePosition).resolve(this.resolverStyle, this.resolverFields);
        } catch (IndexOutOfBoundsException e10) {
            throw e10;
        } catch (DateTimeParseException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            throw createError(charSequence, e12);
        }
    }

    public DateTimeFormatter withResolverFields(Set<TemporalField> set) {
        if (set == null) {
            return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, null, this.chrono, this.zone);
        }
        if (Jdk8Methods.equals(this.resolverFields, set)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, Collections.unmodifiableSet(new HashSet(set)), this.chrono, this.zone);
    }

    public static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final TemporalQuery<?> query;

        public ClassicFormat(DateTimeFormatter dateTimeFormatter, TemporalQuery<?> temporalQuery) {
            this.formatter = dateTimeFormatter;
            this.query = temporalQuery;
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) throws IOException {
            Jdk8Methods.requireNonNull(obj, "obj");
            Jdk8Methods.requireNonNull(stringBuffer, "toAppendTo");
            Jdk8Methods.requireNonNull(fieldPosition, "pos");
            if (!(obj instanceof TemporalAccessor)) {
                throw new IllegalArgumentException("Format target must implement TemporalAccessor");
            }
            fieldPosition.setBeginIndex(0);
            fieldPosition.setEndIndex(0);
            try {
                this.formatter.formatTo((TemporalAccessor) obj, stringBuffer);
                return stringBuffer;
            } catch (RuntimeException e10) {
                throw new IllegalArgumentException(e10.getMessage(), e10);
            }
        }

        @Override // java.text.Format
        public Object parseObject(String str) throws ParseException {
            Jdk8Methods.requireNonNull(str, "text");
            try {
                TemporalQuery<?> temporalQuery = this.query;
                return temporalQuery == null ? this.formatter.parseToBuilder(str, null).resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields()) : this.formatter.parse(str, temporalQuery);
            } catch (DateTimeParseException e10) {
                throw new ParseException(e10.getMessage(), e10.getErrorIndex());
            } catch (RuntimeException e11) {
                throw ((ParseException) new ParseException(e11.getMessage(), 0).initCause(e11));
            }
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            Jdk8Methods.requireNonNull(str, "text");
            try {
                DateTimeParseContext.Parsed unresolved0 = this.formatter.parseUnresolved0(str, parsePosition);
                if (unresolved0 == null) {
                    if (parsePosition.getErrorIndex() < 0) {
                        parsePosition.setErrorIndex(0);
                    }
                    return null;
                }
                try {
                    DateTimeBuilder dateTimeBuilderResolve = unresolved0.toBuilder().resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());
                    TemporalQuery<?> temporalQuery = this.query;
                    return temporalQuery == null ? dateTimeBuilderResolve : dateTimeBuilderResolve.build(temporalQuery);
                } catch (RuntimeException unused) {
                    parsePosition.setErrorIndex(0);
                    return null;
                }
            } catch (IndexOutOfBoundsException unused2) {
                if (parsePosition.getErrorIndex() < 0) {
                    parsePosition.setErrorIndex(0);
                }
                return null;
            }
        }
    }

    public <T> T parse(CharSequence charSequence, TemporalQuery<T> temporalQuery) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(temporalQuery, "type");
        try {
            return (T) parseToBuilder(charSequence, null).resolve(this.resolverStyle, this.resolverFields).build(temporalQuery);
        } catch (DateTimeParseException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            throw createError(charSequence, e11);
        }
    }
}
