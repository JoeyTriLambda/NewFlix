package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import o1.a;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;
    public static final TemporalQuery<Year> FROM = new TemporalQuery<Year>() { // from class: org.threeten.bp.Year.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Year queryFrom(TemporalAccessor temporalAccessor) {
            return Year.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();

    /* renamed from: org.threeten.bp.Year$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.YEAR_OF_ERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private Year(int i10) {
        this.year = i10;
    }

    public static Year from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Year) {
            return (Year) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static boolean isLeap(long j10) {
        return (3 & j10) == 0 && (j10 % 100 != 0 || j10 % 400 == 0);
    }

    public static Year now() {
        return now(Clock.systemDefaultZone());
    }

    public static Year of(int i10) {
        ChronoField.YEAR.checkValidValue(i10);
        return new Year(i10);
    }

    public static Year parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    public static Year readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.YEAR, this.year);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i10) {
        return LocalDate.ofYearDay(this.year, i10);
    }

    public YearMonth atMonth(Month month) {
        return YearMonth.of(this.year, month);
    }

    public LocalDate atMonthDay(MonthDay monthDay) {
        return monthDay.atYear(this.year);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.year == ((Year) obj).year;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i10 == 1) {
            int i11 = this.year;
            if (i11 < 1) {
                i11 = 1 - i11;
            }
            return i11;
        }
        if (i10 == 2) {
            return this.year;
        }
        if (i10 == 3) {
            return this.year < 1 ? 0 : 1;
        }
        throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
    }

    public int getValue() {
        return this.year;
    }

    public int hashCode() {
        return this.year;
    }

    public boolean isAfter(Year year) {
        return this.year > year.year;
    }

    public boolean isBefore(Year year) {
        return this.year < year.year;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    public boolean isValidMonthDay(MonthDay monthDay) {
        return monthDay != null && monthDay.isValidYear(this.year);
    }

    public int length() {
        return isLeap() ? 366 : 365;
    }

    public Year minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public Year plusYears(long j10) {
        return j10 == 0 ? this : of(ChronoField.YEAR.checkValidIntValue(this.year + j10));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.YEARS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, this.year <= 0 ? 1000000000L : 999999999L);
        }
        return super.range(temporalField);
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Year yearFrom = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, yearFrom);
        }
        long j10 = yearFrom.year - this.year;
        int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
        if (i10 == 1) {
            return j10;
        }
        if (i10 == 2) {
            return j10 / 10;
        }
        if (i10 == 3) {
            return j10 / 100;
        }
        if (i10 == 4) {
            return j10 / 1000;
        }
        if (i10 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return yearFrom.getLong(chronoField) - getLong(chronoField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
    }

    public static Year now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static Year parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (Year) dateTimeFormatter.parse(charSequence, FROM);
    }

    public YearMonth atMonth(int i10) {
        return YearMonth.of(this.year, i10);
    }

    @Override // java.lang.Comparable
    public int compareTo(Year year) {
        return this.year - year.year;
    }

    public boolean isLeap() {
        return isLeap(this.year);
    }

    public static Year now(Clock clock) {
        return of(LocalDate.now(clock).getYear());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(TemporalAmount temporalAmount) {
        return (Year) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(TemporalAmount temporalAmount) {
        return (Year) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalAdjuster temporalAdjuster) {
        return (Year) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit == ChronoUnit.YEARS || temporalUnit == ChronoUnit.DECADES || temporalUnit == ChronoUnit.CENTURIES || temporalUnit == ChronoUnit.MILLENNIA || temporalUnit == ChronoUnit.ERAS : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
            if (i10 == 1) {
                return plusYears(j10);
            }
            if (i10 == 2) {
                return plusYears(Jdk8Methods.safeMultiply(j10, 10));
            }
            if (i10 == 3) {
                return plusYears(Jdk8Methods.safeMultiply(j10, 100));
            }
            if (i10 == 4) {
                return plusYears(Jdk8Methods.safeMultiply(j10, 1000));
            }
            if (i10 == 5) {
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j10));
            }
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (Year) temporalUnit.addTo(this, j10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j10);
            int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i10 == 1) {
                if (this.year < 1) {
                    j10 = 1 - j10;
                }
                return of((int) j10);
            }
            if (i10 == 2) {
                return of((int) j10);
            }
            if (i10 == 3) {
                return getLong(ChronoField.ERA) == j10 ? this : of(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        return (Year) temporalField.adjustInto(this, j10);
    }
}
