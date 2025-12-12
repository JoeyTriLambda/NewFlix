package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import o1.a;
import org.threeten.bp.chrono.ChronoZonedDateTime;
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
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes2.dex */
public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Serializable {
    public static final TemporalQuery<ZonedDateTime> FROM = new TemporalQuery<ZonedDateTime>() { // from class: org.threeten.bp.ZonedDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZonedDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return ZonedDateTime.from(temporalAccessor);
        }
    };
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* renamed from: org.threeten.bp.ZonedDateTime$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    private static ZonedDateTime create(long j10, int i10, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(Instant.ofEpochSecond(j10, i10));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(j10, i10, offset), offset, zoneId);
    }

    public static ZonedDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ZonedDateTime) {
            return (ZonedDateTime) temporalAccessor;
        }
        try {
            ZoneId zoneIdFrom = ZoneId.from(temporalAccessor);
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            if (temporalAccessor.isSupported(chronoField)) {
                try {
                    return create(temporalAccessor.getLong(chronoField), temporalAccessor.get(ChronoField.NANO_OF_SECOND), zoneIdFrom);
                } catch (DateTimeException unused) {
                }
            }
            return of(LocalDateTime.from(temporalAccessor), zoneIdFrom);
        } catch (DateTimeException unused2) {
            throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static ZonedDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static ZonedDateTime of(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {
        return of(LocalDateTime.of(localDate, localTime), zoneId);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "instant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return create(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    private static ZonedDateTime ofLenient(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || zoneOffset.equals(zoneId)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    public static ZonedDateTime ofLocal(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        List<ZoneOffset> validOffsets = rules.getValidOffsets(localDateTime);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(localDateTime);
            localDateTime = localDateTime.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Jdk8Methods.requireNonNull(validOffsets.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public static ZonedDateTime ofStrict(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        ZoneRules rules = zoneId.getRules();
        if (rules.isValidOffset(localDateTime, zoneOffset)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        ZoneOffsetTransition transition = rules.getTransition(localDateTime);
        if (transition != null && transition.isGap()) {
            throw new DateTimeException("LocalDateTime '" + localDateTime + "' does not exist in zone '" + zoneId + "' due to a gap in the local time-line, typically caused by daylight savings");
        }
        throw new DateTimeException("ZoneOffset '" + zoneOffset + "' is not valid for LocalDateTime '" + localDateTime + "' in zone '" + zoneId + "'");
    }

    public static ZonedDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public static ZonedDateTime readExternal(DataInput dataInput) throws IOException {
        return ofLenient(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput), (ZoneId) Ser.read(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ZonedDateTime resolveInstant(LocalDateTime localDateTime) {
        return ofInstant(localDateTime, this.offset, this.zone);
    }

    private ZonedDateTime resolveLocal(LocalDateTime localDateTime) {
        return ofLocal(localDateTime, this.zone, this.offset);
    }

    private ZonedDateTime resolveOffset(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.offset) || !this.zone.getRules().isValidOffset(this.dateTime, zoneOffset)) ? this : new ZonedDateTime(this.dateTime, zoneOffset, this.zone);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.dateTime.equals(zonedDateTime.dateTime) && this.offset.equals(zonedDateTime.offset) && this.zone.equals(zonedDateTime.zone);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.hashCode()) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    public ZonedDateTime minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public ZonedDateTime minusHours(long j10) {
        return j10 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j10);
    }

    public ZonedDateTime minusMinutes(long j10) {
        return j10 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-j10);
    }

    public ZonedDateTime minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public ZonedDateTime minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public ZonedDateTime minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public ZonedDateTime minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public ZonedDateTime minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public ZonedDateTime plusDays(long j10) {
        return resolveLocal(this.dateTime.plusDays(j10));
    }

    public ZonedDateTime plusHours(long j10) {
        return resolveInstant(this.dateTime.plusHours(j10));
    }

    public ZonedDateTime plusMinutes(long j10) {
        return resolveInstant(this.dateTime.plusMinutes(j10));
    }

    public ZonedDateTime plusMonths(long j10) {
        return resolveLocal(this.dateTime.plusMonths(j10));
    }

    public ZonedDateTime plusNanos(long j10) {
        return resolveInstant(this.dateTime.plusNanos(j10));
    }

    public ZonedDateTime plusSeconds(long j10) {
        return resolveInstant(this.dateTime.plusSeconds(j10));
    }

    public ZonedDateTime plusWeeks(long j10) {
        return resolveLocal(this.dateTime.plusWeeks(j10));
    }

    public ZonedDateTime plusYears(long j10) {
        return resolveLocal(this.dateTime.plusYears(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? (R) toLocalDate() : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : this.dateTime.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.of(this.dateTime, this.offset);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String str = this.dateTime.toString() + this.offset.toString();
        if (this.offset == this.zone) {
            return str;
        }
        return str + '[' + this.zone.toString() + ']';
    }

    public ZonedDateTime truncatedTo(TemporalUnit temporalUnit) {
        return resolveLocal(this.dateTime.truncatedTo(temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime zonedDateTimeFrom = from((TemporalAccessor) temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, zonedDateTimeFrom);
        }
        ZonedDateTime zonedDateTimeWithZoneSameInstant = zonedDateTimeFrom.withZoneSameInstant(this.zone);
        return temporalUnit.isDateBased() ? this.dateTime.until(zonedDateTimeWithZoneSameInstant.dateTime, temporalUnit) : toOffsetDateTime().until(zonedDateTimeWithZoneSameInstant.toOffsetDateTime(), temporalUnit);
    }

    public ZonedDateTime withDayOfMonth(int i10) {
        return resolveLocal(this.dateTime.withDayOfMonth(i10));
    }

    public ZonedDateTime withDayOfYear(int i10) {
        return resolveLocal(this.dateTime.withDayOfYear(i10));
    }

    public ZonedDateTime withFixedOffsetZone() {
        if (this.zone.equals(this.offset)) {
            return this;
        }
        LocalDateTime localDateTime = this.dateTime;
        ZoneOffset zoneOffset = this.offset;
        return new ZonedDateTime(localDateTime, zoneOffset, zoneOffset);
    }

    public ZonedDateTime withHour(int i10) {
        return resolveLocal(this.dateTime.withHour(i10));
    }

    public ZonedDateTime withMinute(int i10) {
        return resolveLocal(this.dateTime.withMinute(i10));
    }

    public ZonedDateTime withMonth(int i10) {
        return resolveLocal(this.dateTime.withMonth(i10));
    }

    public ZonedDateTime withNano(int i10) {
        return resolveLocal(this.dateTime.withNano(i10));
    }

    public ZonedDateTime withSecond(int i10) {
        return resolveLocal(this.dateTime.withSecond(i10));
    }

    public ZonedDateTime withYear(int i10) {
        return resolveLocal(this.dateTime.withYear(i10));
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
        this.zone.write(dataOutput);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return ofLocal(localDateTime, zoneId, null);
    }

    public static ZonedDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (ZonedDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.isDateBased() || temporalUnit.isTimeBased() : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(this.dateTime);
        if (transition != null && transition.isOverlap()) {
            ZoneOffset offsetBefore = transition.getOffsetBefore();
            if (!offsetBefore.equals(this.offset)) {
                return new ZonedDateTime(this.dateTime, offsetBefore, this.zone);
            }
        }
        return this;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withLaterOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(toLocalDateTime());
        if (transition != null) {
            ZoneOffset offsetAfter = transition.getOffsetAfter();
            if (!offsetAfter.equals(this.offset)) {
                return new ZonedDateTime(this.dateTime, offsetAfter, this.zone);
            }
        }
        return this;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withZoneSameInstant(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : create(this.dateTime.toEpochSecond(this.offset), this.dateTime.getNano(), zoneId);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withZoneSameLocal(ZoneId zoneId) {
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : ofLocal(this.dateTime, zoneId, this.offset);
    }

    public static ZonedDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return ofInstant(clock.instant(), clock.getZone());
    }

    public static ZonedDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneId zoneId) {
        return ofLocal(LocalDateTime.of(i10, i11, i12, i13, i14, i15, i16), zoneId, null);
    }

    public static ZonedDateTime ofInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(localDateTime, "localDateTime");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return create(localDateTime.toEpochSecond(zoneOffset), localDateTime.getNano(), zoneId);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime minus(TemporalAmount temporalAmount) {
        return (ZonedDateTime) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime plus(TemporalAmount temporalAmount) {
        return (ZonedDateTime) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return resolveLocal(LocalDateTime.of((LocalDate) temporalAdjuster, this.dateTime.toLocalTime()));
        }
        if (temporalAdjuster instanceof LocalTime) {
            return resolveLocal(LocalDateTime.of(this.dateTime.toLocalDate(), (LocalTime) temporalAdjuster));
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return resolveLocal((LocalDateTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof Instant) {
            Instant instant = (Instant) temporalAdjuster;
            return create(instant.getEpochSecond(), instant.getNano(), this.zone);
        }
        if (temporalAdjuster instanceof ZoneOffset) {
            return resolveOffset((ZoneOffset) temporalAdjuster);
        }
        return (ZonedDateTime) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ZonedDateTime plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isDateBased()) {
                return resolveLocal(this.dateTime.plus(j10, temporalUnit));
            }
            return resolveInstant(this.dateTime.plus(j10, temporalUnit));
        }
        return (ZonedDateTime) temporalUnit.addTo(this, j10);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ZonedDateTime with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i10 == 1) {
                return create(j10, getNano(), this.zone);
            }
            if (i10 != 2) {
                return resolveLocal(this.dateTime.with(temporalField, j10));
            }
            return resolveOffset(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j10)));
        }
        return (ZonedDateTime) temporalField.adjustInto(this, j10);
    }
}
