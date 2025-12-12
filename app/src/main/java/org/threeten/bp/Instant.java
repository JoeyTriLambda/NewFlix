package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import o1.a;
import org.threeten.bp.format.DateTimeFormatter;
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
public final class Instant extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    private static final long MILLIS_PER_SEC = 1000;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;
    public static final Instant EPOCH = new Instant(0, 0);
    private static final long MIN_SECOND = -31557014167219200L;
    public static final Instant MIN = ofEpochSecond(MIN_SECOND, 0);
    private static final long MAX_SECOND = 31556889864403199L;
    public static final Instant MAX = ofEpochSecond(MAX_SECOND, 999999999);
    public static final TemporalQuery<Instant> FROM = new TemporalQuery<Instant>() { // from class: org.threeten.bp.Instant.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public Instant queryFrom(TemporalAccessor temporalAccessor) {
            return Instant.from(temporalAccessor);
        }
    };

    /* renamed from: org.threeten.bp.Instant$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;
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
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.INSTANT_SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Instant(long j10, int i10) {
        this.seconds = j10;
        this.nanos = i10;
    }

    private static Instant create(long j10, int i10) {
        if ((i10 | j10) == 0) {
            return EPOCH;
        }
        if (j10 < MIN_SECOND || j10 > MAX_SECOND) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j10, i10);
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        try {
            return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), temporalAccessor.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e10);
        }
    }

    private long nanosUntil(Instant instant) {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(instant.seconds, this.seconds), 1000000000), instant.nanos - this.nanos);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long j10) {
        return create(Jdk8Methods.floorDiv(j10, 1000L), Jdk8Methods.floorMod(j10, 1000) * NANOS_PER_MILLI);
    }

    public static Instant ofEpochSecond(long j10) {
        return create(j10, 0);
    }

    public static Instant parse(CharSequence charSequence) {
        return (Instant) DateTimeFormatter.ISO_INSTANT.parse(charSequence, FROM);
    }

    public static Instant readExternal(DataInput dataInput) throws IOException {
        return ofEpochSecond(dataInput.readLong(), dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant instant) {
        long jSafeSubtract = Jdk8Methods.safeSubtract(instant.seconds, this.seconds);
        long j10 = instant.nanos - this.nanos;
        return (jSafeSubtract <= 0 || j10 >= 0) ? (jSafeSubtract >= 0 || j10 <= 0) ? jSafeSubtract : jSafeSubtract + 1 : jSafeSubtract - 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.ofInstant(this, zoneOffset);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this, zoneId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.seconds == instant.seconds && this.nanos == instant.nanos;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
        }
        int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i10 == 1) {
            return this.nanos;
        }
        if (i10 == 2) {
            return this.nanos / 1000;
        }
        if (i10 == 3) {
            return this.nanos / NANOS_PER_MILLI;
        }
        throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i10;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i11 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i11 == 1) {
            i10 = this.nanos;
        } else if (i11 == 2) {
            i10 = this.nanos / 1000;
        } else {
            if (i11 != 3) {
                if (i11 == 4) {
                    return this.seconds;
                }
                throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
            }
            i10 = this.nanos / NANOS_PER_MILLI;
        }
        return i10;
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long j10 = this.seconds;
        return (this.nanos * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    public boolean isBefore(Instant instant) {
        return compareTo(instant) < 0;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.isSupportedBy(this);
    }

    public Instant minusMillis(long j10) {
        return j10 == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1L) : plusMillis(-j10);
    }

    public Instant minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public Instant minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public Instant plusMillis(long j10) {
        return plus(j10 / 1000, (j10 % 1000) * 1000000);
    }

    public Instant plusNanos(long j10) {
        return plus(0L, j10);
    }

    public Instant plusSeconds(long j10) {
        return plus(j10, 0L);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toEpochMilli() {
        long j10 = this.seconds;
        return j10 >= 0 ? Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(j10, 1000L), this.nanos / NANOS_PER_MILLI) : Jdk8Methods.safeSubtract(Jdk8Methods.safeMultiply(j10 + 1, 1000L), 1000 - (this.nanos / NANOS_PER_MILLI));
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    public Instant truncatedTo(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.NANOS) {
            return this;
        }
        Duration duration = temporalUnit.getDuration();
        if (duration.getSeconds() > 86400) {
            throw new DateTimeException("Unit is too large to be used for truncation");
        }
        long nanos = duration.toNanos();
        if (86400000000000L % nanos != 0) {
            throw new DateTimeException("Unit must divide into a standard day without remainder");
        }
        long j10 = ((this.seconds % 86400) * 1000000000) + this.nanos;
        return plusNanos((Jdk8Methods.floorDiv(j10, nanos) * nanos) - j10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Instant instantFrom = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, instantFrom);
        }
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanosUntil(instantFrom);
            case 2:
                return nanosUntil(instantFrom) / 1000;
            case 3:
                return Jdk8Methods.safeSubtract(instantFrom.toEpochMilli(), toEpochMilli());
            case 4:
                return secondsUntil(instantFrom);
            case 5:
                return secondsUntil(instantFrom) / 60;
            case 6:
                return secondsUntil(instantFrom) / 3600;
            case 7:
                return secondsUntil(instantFrom) / 43200;
            case 8:
                return secondsUntil(instantFrom) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Instant now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return clock.instant();
    }

    public static Instant ofEpochSecond(long j10, long j11) {
        return create(Jdk8Methods.safeAdd(j10, Jdk8Methods.floorDiv(j11, 1000000000L)), Jdk8Methods.floorMod(j11, 1000000000));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        int iCompareLongs = Jdk8Methods.compareLongs(this.seconds, instant.seconds);
        return iCompareLongs != 0 ? iCompareLongs : this.nanos - instant.nanos;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant minus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalAdjuster temporalAdjuster) {
        return (Instant) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.isTimeBased() || temporalUnit == ChronoUnit.DAYS : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plus(j10 / 1000000, (j10 % 1000000) * 1000);
                case 3:
                    return plusMillis(j10);
                case 4:
                    return plusSeconds(j10);
                case 5:
                    return plusSeconds(Jdk8Methods.safeMultiply(j10, 60));
                case 6:
                    return plusSeconds(Jdk8Methods.safeMultiply(j10, 3600));
                case 7:
                    return plusSeconds(Jdk8Methods.safeMultiply(j10, 43200));
                case 8:
                    return plusSeconds(Jdk8Methods.safeMultiply(j10, 86400));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (Instant) temporalUnit.addTo(this, j10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j10);
            int i10 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()];
            if (i10 == 1) {
                return j10 != ((long) this.nanos) ? create(this.seconds, (int) j10) : this;
            }
            if (i10 == 2) {
                int i11 = ((int) j10) * 1000;
                return i11 != this.nanos ? create(this.seconds, i11) : this;
            }
            if (i10 == 3) {
                int i12 = ((int) j10) * NANOS_PER_MILLI;
                return i12 != this.nanos ? create(this.seconds, i12) : this;
            }
            if (i10 == 4) {
                return j10 != this.seconds ? create(j10, this.nanos) : this;
            }
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        return (Instant) temporalField.adjustInto(this, j10);
    }

    private Instant plus(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return ofEpochSecond(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j10), j11 / 1000000000), this.nanos + (j11 % 1000000000));
    }
}
