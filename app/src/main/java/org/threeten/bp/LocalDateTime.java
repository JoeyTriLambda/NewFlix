package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.adblockplus.libadblockplus.HttpClient;
import org.apache.commons.lang3.time.DateUtils;
import org.threeten.bp.chrono.ChronoLocalDateTime;
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

/* loaded from: classes2.dex */
public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Serializable {
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);
    public static final TemporalQuery<LocalDateTime> FROM = new TemporalQuery<LocalDateTime>() { // from class: org.threeten.bp.LocalDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDateTime.from(temporalAccessor);
        }
    };

    /* renamed from: org.threeten.bp.LocalDateTime$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int iCompareTo0 = this.date.compareTo0(localDateTime.toLocalDate());
        return iCompareTo0 == 0 ? this.time.compareTo(localDateTime.toLocalTime()) : iCompareTo0;
    }

    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static LocalDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTime of(int i10, Month month, int i11, int i12, int i13) {
        return new LocalDateTime(LocalDate.of(i10, month, i11), LocalTime.of(i12, i13));
    }

    public static LocalDateTime ofEpochSecond(long j10, int i10, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        return new LocalDateTime(LocalDate.ofEpochDay(Jdk8Methods.floorDiv(j10 + zoneOffset.getTotalSeconds(), 86400L)), LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(r2, 86400), i10));
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "instant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), zoneId.getRules().getOffset(instant));
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j10, long j11, long j12, long j13, int i10) {
        if ((j10 | j11 | j12 | j13) == 0) {
            return with(localDate, this.time);
        }
        long j14 = i10;
        long nanoOfDay = this.time.toNanoOfDay();
        long j15 = ((((j10 % 24) * 3600000000000L) + ((j11 % 1440) * 60000000000L) + ((j12 % 86400) * 1000000000) + (j13 % 86400000000000L)) * j14) + nanoOfDay;
        long jFloorDiv = Jdk8Methods.floorDiv(j15, 86400000000000L) + (((j10 / 24) + (j11 / 1440) + (j12 / 86400) + (j13 / 86400000000000L)) * j14);
        long jFloorMod = Jdk8Methods.floorMod(j15, 86400000000000L);
        return with(localDate.plusDays(jFloorDiv), jFloorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(jFloorMod));
    }

    public static LocalDateTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalDate.readExternal(dataInput), LocalTime.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.of(this, zoneOffset);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isAfter(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) > 0 : super.isAfter(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isBefore(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) < 0 : super.isBefore(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isEqual(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) == 0 : super.isEqual(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalDateTime minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public LocalDateTime minusHours(long j10) {
        return plusWithOverflow(this.date, j10, 0L, 0L, 0L, -1);
    }

    public LocalDateTime minusMinutes(long j10) {
        return plusWithOverflow(this.date, 0L, j10, 0L, 0L, -1);
    }

    public LocalDateTime minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public LocalDateTime minusNanos(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j10, -1);
    }

    public LocalDateTime minusSeconds(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, j10, 0L, -1);
    }

    public LocalDateTime minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public LocalDateTime minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public LocalDateTime plusDays(long j10) {
        return with(this.date.plusDays(j10), this.time);
    }

    public LocalDateTime plusHours(long j10) {
        return plusWithOverflow(this.date, j10, 0L, 0L, 0L, 1);
    }

    public LocalDateTime plusMinutes(long j10) {
        return plusWithOverflow(this.date, 0L, j10, 0L, 0L, 1);
    }

    public LocalDateTime plusMonths(long j10) {
        return with(this.date.plusMonths(j10), this.time);
    }

    public LocalDateTime plusNanos(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j10, 1);
    }

    public LocalDateTime plusSeconds(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, j10, 0L, 1);
    }

    public LocalDateTime plusWeeks(long j10) {
        return with(this.date.plusWeeks(j10), this.time);
    }

    public LocalDateTime plusYears(long j10) {
        return with(this.date.plusYears(j10), this.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? (R) toLocalDate() : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public LocalDateTime truncatedTo(TemporalUnit temporalUnit) {
        return with(this.date, this.time.truncatedTo(temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDateTime localDateTimeFrom = from((TemporalAccessor) temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, localDateTimeFrom);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (!chronoUnit.isTimeBased()) {
            LocalDate localDatePlusDays = localDateTimeFrom.date;
            if (localDatePlusDays.isAfter(this.date) && localDateTimeFrom.time.isBefore(this.time)) {
                localDatePlusDays = localDatePlusDays.minusDays(1L);
            } else if (localDatePlusDays.isBefore(this.date) && localDateTimeFrom.time.isAfter(this.time)) {
                localDatePlusDays = localDatePlusDays.plusDays(1L);
            }
            return this.date.until(localDatePlusDays, temporalUnit);
        }
        long jDaysUntil = this.date.daysUntil(localDateTimeFrom.date);
        long nanoOfDay = localDateTimeFrom.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (jDaysUntil > 0 && nanoOfDay < 0) {
            jDaysUntil--;
            nanoOfDay += 86400000000000L;
        } else if (jDaysUntil < 0 && nanoOfDay > 0) {
            jDaysUntil++;
            nanoOfDay -= 86400000000000L;
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[chronoUnit.ordinal()]) {
            case 1:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, 86400000000000L), nanoOfDay);
            case 2:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, 86400000000L), nanoOfDay / 1000);
            case 3:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, DateUtils.MILLIS_PER_DAY), nanoOfDay / 1000000);
            case 4:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, 86400), nanoOfDay / 1000000000);
            case 5:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, 1440), nanoOfDay / 60000000000L);
            case 6:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, 24), nanoOfDay / 3600000000000L);
            case 7:
                return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jDaysUntil, 2), nanoOfDay / 43200000000000L);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalDateTime withDayOfMonth(int i10) {
        return with(this.date.withDayOfMonth(i10), this.time);
    }

    public LocalDateTime withDayOfYear(int i10) {
        return with(this.date.withDayOfYear(i10), this.time);
    }

    public LocalDateTime withHour(int i10) {
        return with(this.date, this.time.withHour(i10));
    }

    public LocalDateTime withMinute(int i10) {
        return with(this.date, this.time.withMinute(i10));
    }

    public LocalDateTime withMonth(int i10) {
        return with(this.date.withMonth(i10), this.time);
    }

    public LocalDateTime withNano(int i10) {
        return with(this.date, this.time.withNano(i10));
    }

    public LocalDateTime withSecond(int i10) {
        return with(this.date, this.time.withSecond(i10));
    }

    public LocalDateTime withYear(int i10) {
        return with(this.date.withYear(i10), this.time);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.date.writeExternal(dataOutput);
        this.time.writeExternal(dataOutput);
    }

    public static LocalDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, java.lang.Comparable
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) : super.compareTo(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.date;
    }

    public static LocalDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), clock.getZone().getRules().getOffset(instant));
    }

    public static LocalDateTime of(int i10, Month month, int i11, int i12, int i13, int i14) {
        return new LocalDateTime(LocalDate.of(i10, month, i11), LocalTime.of(i12, i13, i14));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.isDateBased() || temporalUnit.isTimeBased() : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plusDays(j10 / 86400000000L).plusNanos((j10 % 86400000000L) * 1000);
                case 3:
                    return plusDays(j10 / DateUtils.MILLIS_PER_DAY).plusNanos((j10 % DateUtils.MILLIS_PER_DAY) * 1000000);
                case 4:
                    return plusSeconds(j10);
                case 5:
                    return plusMinutes(j10);
                case 6:
                    return plusHours(j10);
                case 7:
                    return plusDays(j10 / 256).plusHours((j10 % 256) * 12);
                default:
                    return with(this.date.plus(j10, temporalUnit), this.time);
            }
        }
        return (LocalDateTime) temporalUnit.addTo(this, j10);
    }

    public static LocalDateTime of(int i10, Month month, int i11, int i12, int i13, int i14, int i15) {
        return new LocalDateTime(LocalDate.of(i10, month, i11), LocalTime.of(i12, i13, i14, i15));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return with((LocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return (LocalDateTime) temporalAdjuster;
        }
        return (LocalDateTime) temporalAdjuster.adjustInto(this);
    }

    public static LocalDateTime of(int i10, int i11, int i12, int i13, int i14) {
        return new LocalDateTime(LocalDate.of(i10, i11, i12), LocalTime.of(i13, i14));
    }

    public static LocalDateTime of(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new LocalDateTime(LocalDate.of(i10, i11, i12), LocalTime.of(i13, i14, i15));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            if (temporalField.isTimeBased()) {
                return with(this.date, this.time.with(temporalField, j10));
            }
            return with(this.date.with(temporalField, j10), this.time);
        }
        return (LocalDateTime) temporalField.adjustInto(this, j10);
    }

    public static LocalDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        return new LocalDateTime(LocalDate.of(i10, i11, i12), LocalTime.of(i13, i14, i15, i16));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Jdk8Methods.requireNonNull(localDate, HttpClient.HEADER_DATE);
        Jdk8Methods.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }
}
