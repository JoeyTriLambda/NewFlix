package org.threeten.bp.chrono;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.adblockplus.libadblockplus.HttpClient;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Serializable {
    private static final int HOURS_PER_DAY = 24;
    private static final long MICROS_PER_DAY = 86400000000L;
    private static final long MILLIS_PER_DAY = 86400000;
    private static final int MINUTES_PER_DAY = 1440;
    private static final int MINUTES_PER_HOUR = 60;
    private static final long NANOS_PER_DAY = 86400000000000L;
    private static final long NANOS_PER_HOUR = 3600000000000L;
    private static final long NANOS_PER_MINUTE = 60000000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final D date;
    private final LocalTime time;

    /* renamed from: org.threeten.bp.chrono.ChronoLocalDateTimeImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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

    private ChronoLocalDateTimeImpl(D d10, LocalTime localTime) {
        Jdk8Methods.requireNonNull(d10, HttpClient.HEADER_DATE);
        Jdk8Methods.requireNonNull(localTime, "time");
        this.date = d10;
        this.time = localTime;
    }

    public static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> of(R r10, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl<>(r10, localTime);
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long j10) {
        return with(this.date.plus(j10, ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long j10) {
        return plusWithOverflow(this.date, j10, 0L, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long j10) {
        return plusWithOverflow(this.date, 0L, j10, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j10);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D d10, long j10, long j11, long j12, long j13) {
        if ((j10 | j11 | j12 | j13) == 0) {
            return with(d10, this.time);
        }
        long j14 = j10 / 24;
        long j15 = j14 + (j11 / 1440) + (j12 / 86400) + (j13 / NANOS_PER_DAY);
        long j16 = ((j10 % 24) * NANOS_PER_HOUR) + ((j11 % 1440) * NANOS_PER_MINUTE) + ((j12 % 86400) * NANOS_PER_SECOND) + (j13 % NANOS_PER_DAY);
        long nanoOfDay = this.time.toNanoOfDay();
        long j17 = j16 + nanoOfDay;
        long jFloorDiv = Jdk8Methods.floorDiv(j17, NANOS_PER_DAY) + j15;
        long jFloorMod = Jdk8Methods.floorMod(j17, NANOS_PER_DAY);
        return with(d10.plus(jFloorDiv, ChronoUnit.DAYS), jFloorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(jFloorMod));
    }

    public static ChronoLocalDateTime<?> readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((ChronoLocalDate) objectInput.readObject()).atTime((LocalTime) objectInput.readObject());
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoZonedDateTime<D> atZone(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofBest(this, zoneId, null);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public ChronoLocalDateTimeImpl<D> plusSeconds(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, j10, 0L);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public D toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDateTime<?> chronoLocalDateTimeLocalDateTime = toLocalDate().getChronology().localDateTime(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, chronoLocalDateTimeLocalDateTime);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (!chronoUnit.isTimeBased()) {
            ChronoLocalDate localDate = chronoLocalDateTimeLocalDateTime.toLocalDate();
            if (chronoLocalDateTimeLocalDateTime.toLocalTime().isBefore(this.time)) {
                localDate = localDate.minus(1L, (TemporalUnit) ChronoUnit.DAYS);
            }
            return this.date.until(localDate, temporalUnit);
        }
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        long jSafeMultiply = chronoLocalDateTimeLocalDateTime.getLong(chronoField) - this.date.getLong(chronoField);
        switch (AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[chronoUnit.ordinal()]) {
            case 1:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, NANOS_PER_DAY);
                break;
            case 2:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, MICROS_PER_DAY);
                break;
            case 3:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, 86400000L);
                break;
            case 4:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, SECONDS_PER_DAY);
                break;
            case 5:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, MINUTES_PER_DAY);
                break;
            case 6:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, 24);
                break;
            case 7:
                jSafeMultiply = Jdk8Methods.safeMultiply(jSafeMultiply, 2);
                break;
        }
        return Jdk8Methods.safeAdd(jSafeMultiply, this.time.until(chronoLocalDateTimeLocalDateTime.toLocalTime(), temporalUnit));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.date);
        objectOutput.writeObject(this.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plusDays(j10 / MICROS_PER_DAY).plusNanos((j10 % MICROS_PER_DAY) * 1000);
                case 3:
                    return plusDays(j10 / 86400000).plusNanos((j10 % 86400000) * 1000000);
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
        return this.date.getChronology().ensureChronoLocalDateTime(temporalUnit.addTo(this, j10));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.isDateBased() || temporalUnit.isTimeBased() : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    private ChronoLocalDateTimeImpl<D> with(Temporal temporal, LocalTime localTime) {
        D d10 = this.date;
        return (d10 == temporal && this.time == localTime) ? this : new ChronoLocalDateTimeImpl<>(d10.getChronology().ensureChronoLocalDate(temporal), localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof ChronoLocalDate) {
            return with((ChronoLocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof ChronoLocalDateTimeImpl) {
            return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) temporalAdjuster);
        }
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) temporalAdjuster.adjustInto(this));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            if (temporalField.isTimeBased()) {
                return with(this.date, this.time.with(temporalField, j10));
            }
            return with(this.date.with(temporalField, j10), this.time);
        }
        return this.date.getChronology().ensureChronoLocalDateTime(temporalField.adjustInto(this, j10));
    }
}
