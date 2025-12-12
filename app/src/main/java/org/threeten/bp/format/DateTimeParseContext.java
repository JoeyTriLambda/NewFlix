package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import o1.a;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes2.dex */
final class DateTimeParseContext {
    private boolean caseSensitive;
    private Locale locale;
    private Chronology overrideChronology;
    private ZoneId overrideZone;
    private final ArrayList<Parsed> parsed;
    private boolean strict;
    private DecimalStyle symbols;

    public final class Parsed extends DefaultInterfaceTemporalAccessor {
        List<Object[]> callbacks;
        Chronology chrono;
        Period excessDays;
        final Map<TemporalField, Long> fieldValues;
        boolean leapSecond;
        ZoneId zone;

        public Parsed copy() {
            Parsed parsed = DateTimeParseContext.this.new Parsed();
            parsed.chrono = this.chrono;
            parsed.zone = this.zone;
            parsed.fieldValues.putAll(this.fieldValues);
            parsed.leapSecond = this.leapSecond;
            return parsed;
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public int get(TemporalField temporalField) {
            if (this.fieldValues.containsKey(temporalField)) {
                return Jdk8Methods.safeToInt(this.fieldValues.get(temporalField).longValue());
            }
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField temporalField) {
            if (this.fieldValues.containsKey(temporalField)) {
                return this.fieldValues.get(temporalField).longValue();
            }
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField temporalField) {
            return this.fieldValues.containsKey(temporalField);
        }

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public <R> R query(TemporalQuery<R> temporalQuery) {
            return temporalQuery == TemporalQueries.chronology() ? (R) this.chrono : (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone()) ? (R) this.zone : (R) super.query(temporalQuery);
        }

        public DateTimeBuilder toBuilder() {
            DateTimeBuilder dateTimeBuilder = new DateTimeBuilder();
            dateTimeBuilder.fieldValues.putAll(this.fieldValues);
            dateTimeBuilder.chrono = DateTimeParseContext.this.getEffectiveChronology();
            ZoneId zoneId = this.zone;
            if (zoneId != null) {
                dateTimeBuilder.zone = zoneId;
            } else {
                dateTimeBuilder.zone = DateTimeParseContext.this.overrideZone;
            }
            dateTimeBuilder.leapSecond = this.leapSecond;
            dateTimeBuilder.excessDays = this.excessDays;
            return dateTimeBuilder;
        }

        public String toString() {
            return this.fieldValues.toString() + "," + this.chrono + "," + this.zone;
        }

        private Parsed() {
            this.chrono = null;
            this.zone = null;
            this.fieldValues = new HashMap();
            this.excessDays = Period.ZERO;
        }
    }

    public DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = dateTimeFormatter.getLocale();
        this.symbols = dateTimeFormatter.getDecimalStyle();
        this.overrideChronology = dateTimeFormatter.getChronology();
        this.overrideZone = dateTimeFormatter.getZone();
        arrayList.add(new Parsed());
    }

    public static boolean charEqualsIgnoreCase(char c10, char c11) {
        return c10 == c11 || Character.toUpperCase(c10) == Character.toUpperCase(c11) || Character.toLowerCase(c10) == Character.toLowerCase(c11);
    }

    private Parsed currentParsed() {
        return this.parsed.get(r0.size() - 1);
    }

    public void addChronologyChangedParser(DateTimeFormatterBuilder.ReducedPrinterParser reducedPrinterParser, long j10, int i10, int i11) {
        Parsed parsedCurrentParsed = currentParsed();
        if (parsedCurrentParsed.callbacks == null) {
            parsedCurrentParsed.callbacks = new ArrayList(2);
        }
        parsedCurrentParsed.callbacks.add(new Object[]{reducedPrinterParser, Long.valueOf(j10), Integer.valueOf(i10), Integer.valueOf(i11)});
    }

    public boolean charEquals(char c10, char c11) {
        return isCaseSensitive() ? c10 == c11 : charEqualsIgnoreCase(c10, c11);
    }

    public DateTimeParseContext copy() {
        return new DateTimeParseContext(this);
    }

    public void endOptional(boolean z10) {
        if (z10) {
            this.parsed.remove(r2.size() - 2);
        } else {
            this.parsed.remove(r2.size() - 1);
        }
    }

    public Chronology getEffectiveChronology() {
        Chronology chronology = currentParsed().chrono;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.overrideChronology;
        return chronology2 == null ? IsoChronology.INSTANCE : chronology2;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Long getParsed(TemporalField temporalField) {
        return currentParsed().fieldValues.get(temporalField);
    }

    public DecimalStyle getSymbols() {
        return this.symbols;
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public boolean isStrict() {
        return this.strict;
    }

    public void setCaseSensitive(boolean z10) {
        this.caseSensitive = z10;
    }

    public void setLocale(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        this.locale = locale;
    }

    public void setParsed(Chronology chronology) {
        Jdk8Methods.requireNonNull(chronology, "chrono");
        Parsed parsedCurrentParsed = currentParsed();
        parsedCurrentParsed.chrono = chronology;
        if (parsedCurrentParsed.callbacks != null) {
            ArrayList arrayList = new ArrayList(parsedCurrentParsed.callbacks);
            parsedCurrentParsed.callbacks.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object[] objArr = (Object[]) it.next();
                ((DateTimeFormatterBuilder.ReducedPrinterParser) objArr[0]).setValue(this, ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        }
    }

    public int setParsedField(TemporalField temporalField, long j10, int i10, int i11) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long lPut = currentParsed().fieldValues.put(temporalField, Long.valueOf(j10));
        return (lPut == null || lPut.longValue() == j10) ? i11 : ~i10;
    }

    public void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    public void setStrict(boolean z10) {
        this.strict = z10;
    }

    public void startOptional() {
        this.parsed.add(currentParsed().copy());
    }

    public boolean subSequenceEquals(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12) {
        if (i10 + i12 > charSequence.length() || i11 + i12 > charSequence2.length()) {
            return false;
        }
        if (isCaseSensitive()) {
            for (int i13 = 0; i13 < i12; i13++) {
                if (charSequence.charAt(i10 + i13) != charSequence2.charAt(i11 + i13)) {
                    return false;
                }
            }
            return true;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            char cCharAt = charSequence.charAt(i10 + i14);
            char cCharAt2 = charSequence2.charAt(i11 + i14);
            if (cCharAt != cCharAt2 && Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                return false;
            }
        }
        return true;
    }

    public Parsed toParsed() {
        return currentParsed();
    }

    public String toString() {
        return currentParsed().toString();
    }

    public DateTimeParseContext(Locale locale, DecimalStyle decimalStyle, Chronology chronology) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = locale;
        this.symbols = decimalStyle;
        this.overrideChronology = chronology;
        this.overrideZone = null;
        arrayList.add(new Parsed());
    }

    public void setParsed(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        currentParsed().zone = zoneId;
    }

    public DateTimeParseContext(DateTimeParseContext dateTimeParseContext) {
        this.caseSensitive = true;
        this.strict = true;
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.parsed = arrayList;
        this.locale = dateTimeParseContext.locale;
        this.symbols = dateTimeParseContext.symbols;
        this.overrideChronology = dateTimeParseContext.overrideChronology;
        this.overrideZone = dateTimeParseContext.overrideZone;
        this.caseSensitive = dateTimeParseContext.caseSensitive;
        this.strict = dateTimeParseContext.strict;
        arrayList.add(new Parsed());
    }
}
