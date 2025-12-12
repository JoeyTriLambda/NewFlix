package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import o1.a;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
public final class OffsetDateTime extends DefaultInterfaceTemporal implements TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    public static final OffsetDateTime MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
    public static final OffsetDateTime MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
    public static final TemporalQuery<OffsetDateTime> FROM = new TemporalQuery<OffsetDateTime>() { // from class: org.threeten.bp.OffsetDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public OffsetDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return OffsetDateTime.from(temporalAccessor);
        }
    };
    private static final Comparator<OffsetDateTime> INSTANT_COMPARATOR = new Comparator<OffsetDateTime>() { // from class: org.threeten.bp.OffsetDateTime.2
        @Override // java.util.Comparator
        public int compare(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
            int iCompareLongs = Jdk8Methods.compareLongs(offsetDateTime.toEpochSecond(), offsetDateTime2.toEpochSecond());
            return iCompareLongs == 0 ? Jdk8Methods.compareLongs(offsetDateTime.getNano(), offsetDateTime2.getNano()) : iCompareLongs;
        }
    };

    /* renamed from: org.threeten.bp.OffsetDateTime$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.dateTime = (LocalDateTime) Jdk8Methods.requireNonNull(localDateTime, "dateTime");
        this.offset = (ZoneOffset) Jdk8Methods.requireNonNull(zoneOffset, "offset");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.threeten.bp.OffsetDateTime] */
    public static OffsetDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof OffsetDateTime) {
            return (OffsetDateTime) temporalAccessor;
        }
        try {
            ZoneOffset zoneOffsetFrom = ZoneOffset.from(temporalAccessor);
            try {
                temporalAccessor = of(LocalDateTime.from(temporalAccessor), zoneOffsetFrom);
                return temporalAccessor;
            } catch (DateTimeException unused) {
                return ofInstant(Instant.from(temporalAccessor), zoneOffsetFrom);
            }
        } catch (DateTimeException unused2) {
            throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static OffsetDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetDateTime of(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.of(localDate, localTime), zoneOffset);
    }

    public static OffsetDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "instant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset), offset);
    }

    public static OffsetDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static OffsetDateTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public ZonedDateTime atZoneSameInstant(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, zoneId);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId zoneId) {
        return ZonedDateTime.ofLocal(this.dateTime, zoneId, this.offset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.dateTime.equals(offsetDateTime.dateTime) && this.offset.equals(offsetDateTime.offset);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int i10 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? this.dateTime.get(temporalField) : getOffset().getTotalSeconds();
        }
        throw new DateTimeException(a.e("Field too large for an int: ", temporalField));
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i10 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        return i10 != 1 ? i10 != 2 ? this.dateTime.getLong(temporalField) : getOffset().getTotalSeconds() : toEpochSecond();
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public int hashCode() {
        return this.dateTime.hashCode() ^ this.offset.hashCode();
    }

    public boolean isAfter(OffsetDateTime offsetDateTime) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = offsetDateTime.toEpochSecond();
        return epochSecond > epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() > offsetDateTime.toLocalTime().getNano());
    }

    public boolean isBefore(OffsetDateTime offsetDateTime) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = offsetDateTime.toEpochSecond();
        return epochSecond < epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() < offsetDateTime.toLocalTime().getNano());
    }

    public boolean isEqual(OffsetDateTime offsetDateTime) {
        return toEpochSecond() == offsetDateTime.toEpochSecond() && toLocalTime().getNano() == offsetDateTime.toLocalTime().getNano();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    public OffsetDateTime minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public OffsetDateTime minusHours(long j10) {
        return j10 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j10);
    }

    public OffsetDateTime minusMinutes(long j10) {
        return j10 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-j10);
    }

    public OffsetDateTime minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public OffsetDateTime minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public OffsetDateTime minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public OffsetDateTime minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public OffsetDateTime minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public OffsetDateTime plusDays(long j10) {
        return with(this.dateTime.plusDays(j10), this.offset);
    }

    public OffsetDateTime plusHours(long j10) {
        return with(this.dateTime.plusHours(j10), this.offset);
    }

    public OffsetDateTime plusMinutes(long j10) {
        return with(this.dateTime.plusMinutes(j10), this.offset);
    }

    public OffsetDateTime plusMonths(long j10) {
        return with(this.dateTime.plusMonths(j10), this.offset);
    }

    public OffsetDateTime plusNanos(long j10) {
        return with(this.dateTime.plusNanos(j10), this.offset);
    }

    public OffsetDateTime plusSeconds(long j10) {
        return with(this.dateTime.plusSeconds(j10), this.offset);
    }

    public OffsetDateTime plusWeeks(long j10) {
        return with(this.dateTime.plusWeeks(j10), this.offset);
    }

    public OffsetDateTime plusYears(long j10) {
        return with(this.dateTime.plusYears(j10), this.offset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return (R) getOffset();
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return (R) toLocalDate();
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) toLocalTime();
        }
        if (temporalQuery == TemporalQueries.zoneId()) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : this.dateTime.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    public Instant toInstant() {
        return this.dateTime.toInstant(this.offset);
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetTime toOffsetTime() {
        return OffsetTime.of(this.dateTime.toLocalTime(), this.offset);
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.toString();
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.of(this.dateTime, this.offset);
    }

    public OffsetDateTime truncatedTo(TemporalUnit temporalUnit) {
        return with(this.dateTime.truncatedTo(temporalUnit), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetDateTime offsetDateTimeFrom = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, offsetDateTimeFrom);
        }
        return this.dateTime.until(offsetDateTimeFrom.withOffsetSameInstant(this.offset).dateTime, temporalUnit);
    }

    public OffsetDateTime withDayOfMonth(int i10) {
        return with(this.dateTime.withDayOfMonth(i10), this.offset);
    }

    public OffsetDateTime withDayOfYear(int i10) {
        return with(this.dateTime.withDayOfYear(i10), this.offset);
    }

    public OffsetDateTime withHour(int i10) {
        return with(this.dateTime.withHour(i10), this.offset);
    }

    public OffsetDateTime withMinute(int i10) {
        return with(this.dateTime.withMinute(i10), this.offset);
    }

    public OffsetDateTime withMonth(int i10) {
        return with(this.dateTime.withMonth(i10), this.offset);
    }

    public OffsetDateTime withNano(int i10) {
        return with(this.dateTime.withNano(i10), this.offset);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.offset)) {
            return this;
        }
        return new OffsetDateTime(this.dateTime.plusSeconds(zoneOffset.getTotalSeconds() - this.offset.getTotalSeconds()), zoneOffset);
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset zoneOffset) {
        return with(this.dateTime, zoneOffset);
    }

    public OffsetDateTime withSecond(int i10) {
        return with(this.dateTime.withSecond(i10), this.offset);
    }

    public OffsetDateTime withYear(int i10) {
        return with(this.dateTime.withYear(i10), this.offset);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
    }

    public static OffsetDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static OffsetDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(OffsetDateTime offsetDateTime) {
        if (getOffset().equals(offsetDateTime.getOffset())) {
            return toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime.toLocalDateTime());
        }
        int iCompareLongs = Jdk8Methods.compareLongs(toEpochSecond(), offsetDateTime.toEpochSecond());
        if (iCompareLongs != 0) {
            return iCompareLongs;
        }
        int nano = toLocalTime().getNano() - offsetDateTime.toLocalTime().getNano();
        return nano == 0 ? toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime.toLocalDateTime()) : nano;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.isDateBased() || temporalUnit.isTimeBased() : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    public static OffsetDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofInstant(instant, clock.getZone().getRules().getOffset(instant));
    }

    public static OffsetDateTime of(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    private OffsetDateTime with(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.dateTime == localDateTime && this.offset.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(TemporalAmount temporalAmount) {
        return (OffsetDateTime) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(TemporalAmount temporalAmount) {
        return (OffsetDateTime) temporalAmount.addTo(this);
    }

    public static OffsetDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.of(i10, i11, i12, i13, i14, i15, i16), zoneOffset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with(this.dateTime.plus(j10, temporalUnit), this.offset);
        }
        return (OffsetDateTime) temporalUnit.addTo(this, j10);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalAdjuster temporalAdjuster) {
        if (!(temporalAdjuster instanceof LocalDate) && !(temporalAdjuster instanceof LocalTime) && !(temporalAdjuster instanceof LocalDateTime)) {
            if (temporalAdjuster instanceof Instant) {
                return ofInstant((Instant) temporalAdjuster, this.offset);
            }
            if (temporalAdjuster instanceof ZoneOffset) {
                return with(this.dateTime, (ZoneOffset) temporalAdjuster);
            }
            if (temporalAdjuster instanceof OffsetDateTime) {
                return (OffsetDateTime) temporalAdjuster;
            }
            return (OffsetDateTime) temporalAdjuster.adjustInto(this);
        }
        return with(this.dateTime.with(temporalAdjuster), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i10 = AnonymousClass3.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i10 == 1) {
                return ofInstant(Instant.ofEpochSecond(j10, getNano()), this.offset);
            }
            if (i10 != 2) {
                return with(this.dateTime.with(temporalField, j10), this.offset);
            }
            return with(this.dateTime, ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j10)));
        }
        return (OffsetDateTime) temporalField.adjustInto(this, j10);
    }
}
