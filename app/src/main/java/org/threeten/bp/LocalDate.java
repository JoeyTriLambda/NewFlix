package org.threeten.bp;

import com.loopj.android.http.AsyncHttpClient;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import o1.a;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
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
import org.threeten.bp.zone.ZoneOffsetTransition;

/* loaded from: classes2.dex */
public final class LocalDate extends ChronoLocalDate implements Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = of(Year.MIN_VALUE, 1, 1);
    public static final LocalDate MAX = of(Year.MAX_VALUE, 12, 31);
    public static final TemporalQuery<LocalDate> FROM = new TemporalQuery<LocalDate>() { // from class: org.threeten.bp.LocalDate.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDate.from(temporalAccessor);
        }
    };

    /* renamed from: org.threeten.bp.LocalDate$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private LocalDate(int i10, int i11, int i12) {
        this.year = i10;
        this.month = (short) i11;
        this.day = (short) i12;
    }

    private static LocalDate create(int i10, Month month, int i11) {
        if (i11 <= 28 || i11 <= month.length(IsoChronology.INSTANCE.isLeapYear(i10))) {
            return new LocalDate(i10, month.getValue(), i11);
        }
        if (i11 == 29) {
            throw new DateTimeException(a.d("Invalid date 'February 29' as '", i10, "' is not a leap year"));
        }
        throw new DateTimeException("Invalid date '" + month.name() + StringUtils.SPACE + i11 + "'");
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i10 = this.year;
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException(a.e("Field too large for an int: ", temporalField));
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new DateTimeException(a.e("Field too large for an int: ", temporalField));
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
    }

    private long getProlepticMonth() {
        return (this.year * 12) + (this.month - 1);
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + localDate.getDayOfMonth()) - ((getProlepticMonth() * 32) + getDayOfMonth())) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate of(int i10, Month month, int i11) {
        ChronoField.YEAR.checkValidValue(i10);
        Jdk8Methods.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i11);
        return create(i10, month, i11);
    }

    public static LocalDate ofEpochDay(long j10) {
        long j11;
        ChronoField.EPOCH_DAY.checkValidValue(j10);
        long j12 = (j10 + DAYS_0000_TO_1970) - 60;
        if (j12 < 0) {
            long j13 = ((j12 + 1) / 146097) - 1;
            j11 = j13 * 400;
            j12 += (-j13) * 146097;
        } else {
            j11 = 0;
        }
        long j14 = ((j12 * 400) + 591) / 146097;
        long j15 = j12 - ((j14 / 400) + (((j14 / 4) + (j14 * 365)) - (j14 / 100)));
        if (j15 < 0) {
            j14--;
            j15 = j12 - ((j14 / 400) + (((j14 / 4) + (365 * j14)) - (j14 / 100)));
        }
        int i10 = (int) j15;
        int i11 = ((i10 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j14 + j11 + (i11 / 10)), ((i11 + 2) % 12) + 1, (i10 - (((i11 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i10, int i11) {
        long j10 = i10;
        ChronoField.YEAR.checkValidValue(j10);
        ChronoField.DAY_OF_YEAR.checkValidValue(i11);
        boolean zIsLeapYear = IsoChronology.INSTANCE.isLeapYear(j10);
        if (i11 == 366 && !zIsLeapYear) {
            throw new DateTimeException(a.d("Invalid date 'DayOfYear 366' as '", i10, "' is not a leap year"));
        }
        Month monthOf = Month.of(((i11 - 1) / 31) + 1);
        if (i11 > (monthOf.length(zIsLeapYear) + monthOf.firstDayOfYear(zIsLeapYear)) - 1) {
            monthOf = monthOf.plus(1L);
        }
        return create(i10, monthOf, (i11 - monthOf.firstDayOfYear(zIsLeapYear)) + 1);
    }

    public static LocalDate parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int i10, int i11, int i12) {
        if (i11 == 2) {
            i12 = Math.min(i12, IsoChronology.INSTANCE.isLeapYear((long) i10) ? 29 : 28);
        } else if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
            i12 = Math.min(i12, 30);
        }
        return of(i10, i11, i12);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    public int compareTo0(LocalDate localDate) {
        int i10 = this.year - localDate.year;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.month - localDate.month;
        return i11 == 0 ? this.day - localDate.day : i11;
    }

    public long daysUntil(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(Jdk8Methods.floorMod(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return super.getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.EPOCH_DAY ? toEpochDay() : temporalField == ChronoField.PROLEPTIC_MONTH ? getProlepticMonth() : get0(temporalField) : temporalField.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int i10 = this.year;
        return (((i10 << 11) + (this.month << 6)) + this.day) ^ (i10 & (-2048));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) > 0 : super.isAfter(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) < 0 : super.isBefore(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) == 0 : super.isEqual(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        short s10 = this.month;
        return s10 != 2 ? (s10 == 4 || s10 == 6 || s10 == 9 || s10 == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public LocalDate minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public LocalDate minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public LocalDate minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public LocalDate minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public LocalDate plusDays(long j10) {
        return j10 == 0 ? this : ofEpochDay(Jdk8Methods.safeAdd(toEpochDay(), j10));
    }

    public LocalDate plusMonths(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (this.year * 12) + (this.month - 1) + j10;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j11, 12L)), Jdk8Methods.floorMod(j11, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j10) {
        return plusDays(Jdk8Methods.safeMultiply(j10, 7));
    }

    public LocalDate plusYears(long j10) {
        return j10 == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(this.year + j10), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? this : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (!chronoField.isDateBased()) {
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
        if (i10 == 1) {
            return ValueRange.of(1L, lengthOfMonth());
        }
        if (i10 == 2) {
            return ValueRange.of(1L, lengthOfYear());
        }
        if (i10 == 3) {
            return ValueRange.of(1L, (getMonth() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
        }
        if (i10 != 4) {
            return temporalField.range();
        }
        return ValueRange.of(1L, getYear() <= 0 ? 1000000000L : 999999999L);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j10;
        long j11 = this.year;
        long j12 = this.month;
        long j13 = (365 * j11) + 0;
        if (j11 >= 0) {
            j10 = ((j11 + 399) / 400) + (((3 + j11) / 4) - ((99 + j11) / 100)) + j13;
        } else {
            j10 = j13 - ((j11 / (-400)) + ((j11 / (-4)) - (j11 / (-100))));
        }
        long j14 = (((367 * j12) - 362) / 12) + j10 + (this.day - 1);
        if (j12 > 2) {
            j14--;
            if (!isLeapYear()) {
                j14--;
            }
        }
        return j14 - DAYS_0000_TO_1970;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String toString() {
        int i10 = this.year;
        short s10 = this.month;
        short s11 = this.day;
        int iAbs = Math.abs(i10);
        StringBuilder sb2 = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i10 > 9999) {
                sb2.append('+');
            }
            sb2.append(i10);
        } else if (i10 < 0) {
            sb2.append(i10 - 10000);
            sb2.deleteCharAt(1);
        } else {
            sb2.append(i10 + AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
            sb2.deleteCharAt(0);
        }
        sb2.append(s10 < 10 ? "-0" : "-");
        sb2.append((int) s10);
        sb2.append(s11 >= 10 ? "-" : "-0");
        sb2.append((int) s11);
        return sb2.toString();
    }

    public LocalDate withDayOfMonth(int i10) {
        return this.day == i10 ? this : of(this.year, this.month, i10);
    }

    public LocalDate withDayOfYear(int i10) {
        return getDayOfYear() == i10 ? this : ofYearDay(this.year, i10);
    }

    public LocalDate withMonth(int i10) {
        if (this.month == i10) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue(i10);
        return resolvePreviousValid(this.year, i10, this.day);
    }

    public LocalDate withYear(int i10) {
        if (this.year == i10) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(i10);
        return resolvePreviousValid(i10, this.month, this.day);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public static LocalDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, FROM);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        ZoneOffsetTransition transition;
        Jdk8Methods.requireNonNull(zoneId, "zone");
        LocalDateTime localDateTimeAtTime = atTime(LocalTime.MIDNIGHT);
        if (!(zoneId instanceof ZoneOffset) && (transition = zoneId.getRules().getTransition(localDateTimeAtTime)) != null && transition.isGap()) {
            localDateTimeAtTime = transition.getDateTimeAfter();
        }
        return ZonedDateTime.of(localDateTimeAtTime, zoneId);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, java.lang.Comparable
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) : super.compareTo(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate localDateFrom = from((TemporalAccessor) temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, localDateFrom);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return daysUntil(localDateFrom);
            case 2:
                return daysUntil(localDateFrom) / 7;
            case 3:
                return monthsUntil(localDateFrom);
            case 4:
                return monthsUntil(localDateFrom) / 12;
            case 5:
                return monthsUntil(localDateFrom) / 120;
            case 6:
                return monthsUntil(localDateFrom) / 1200;
            case 7:
                return monthsUntil(localDateFrom) / 12000;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return localDateFrom.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public static LocalDate now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return ofEpochDay(Jdk8Methods.floorDiv(clock.instant().getEpochSecond() + clock.getZone().getRules().getOffset(r0).getTotalSeconds(), 86400L));
    }

    public LocalDateTime atTime(int i10, int i11) {
        return atTime(LocalTime.of(i10, i11));
    }

    public LocalDateTime atTime(int i10, int i11, int i12) {
        return atTime(LocalTime.of(i10, i11, i12));
    }

    public static LocalDate of(int i10, int i11, int i12) {
        ChronoField.YEAR.checkValidValue(i10);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i11);
        ChronoField.DAY_OF_MONTH.checkValidValue(i12);
        return create(i10, Month.of(i11), i12);
    }

    public LocalDateTime atTime(int i10, int i11, int i12, int i13) {
        return atTime(LocalTime.of(i10, i11, i12, i13));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDate minus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDate plus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.adjustInto(this);
    }

    public OffsetDateTime atTime(OffsetTime offsetTime) {
        return OffsetDateTime.of(LocalDateTime.of(this, offsetTime.toLocalTime()), offsetTime.getOffset());
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDate minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public LocalDate plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j10);
                case 2:
                    return plusWeeks(j10);
                case 3:
                    return plusMonths(j10);
                case 4:
                    return plusYears(j10);
                case 5:
                    return plusYears(Jdk8Methods.safeMultiply(j10, 10));
                case 6:
                    return plusYears(Jdk8Methods.safeMultiply(j10, 100));
                case 7:
                    return plusYears(Jdk8Methods.safeMultiply(j10, 1000));
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j10));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (LocalDate) temporalUnit.addTo(this, j10);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j10);
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return withDayOfMonth((int) j10);
                case 2:
                    return withDayOfYear((int) j10);
                case 3:
                    return plusWeeks(j10 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.year < 1) {
                        j10 = 1 - j10;
                    }
                    return withYear((int) j10);
                case 5:
                    return plusDays(j10 - getDayOfWeek().getValue());
                case 6:
                    return plusDays(j10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(j10 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return ofEpochDay(j10);
                case 9:
                    return plusWeeks(j10 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    return withMonth((int) j10);
                case 11:
                    return plusMonths(j10 - getLong(ChronoField.PROLEPTIC_MONTH));
                case 12:
                    return withYear((int) j10);
                case 13:
                    return getLong(ChronoField.ERA) == j10 ? this : withYear(1 - this.year);
                default:
                    throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
            }
        }
        return (LocalDate) temporalField.adjustInto(this, j10);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Period until(ChronoLocalDate chronoLocalDate) {
        LocalDate localDateFrom = from((TemporalAccessor) chronoLocalDate);
        long prolepticMonth = localDateFrom.getProlepticMonth() - getProlepticMonth();
        int iLengthOfMonth = localDateFrom.day - this.day;
        if (prolepticMonth > 0 && iLengthOfMonth < 0) {
            prolepticMonth--;
            iLengthOfMonth = (int) (localDateFrom.toEpochDay() - plusMonths(prolepticMonth).toEpochDay());
        } else if (prolepticMonth < 0 && iLengthOfMonth > 0) {
            prolepticMonth++;
            iLengthOfMonth -= localDateFrom.lengthOfMonth();
        }
        return Period.of(Jdk8Methods.safeToInt(prolepticMonth / 12), (int) (prolepticMonth % 12), iLengthOfMonth);
    }
}
