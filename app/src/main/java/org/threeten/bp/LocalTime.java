package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import o1.a;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.lang3.ClassUtils;
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
public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    public static final TemporalQuery<LocalTime> FROM = new TemporalQuery<LocalTime>() { // from class: org.threeten.bp.LocalTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            return LocalTime.from(temporalAccessor);
        }
    };
    private static final LocalTime[] HOURS = new LocalTime[24];
    static final int HOURS_PER_DAY = 24;
    public static final LocalTime MAX;
    static final long MICROS_PER_DAY = 86400000000L;
    public static final LocalTime MIDNIGHT;
    static final long MILLIS_PER_DAY = 86400000;
    public static final LocalTime MIN;
    static final int MINUTES_PER_DAY = 1440;
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final long NANOS_PER_HOUR = 3600000000000L;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    public static final LocalTime NOON;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* renamed from: org.threeten.bp.LocalTime$2, reason: invalid class name */
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
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.AMPM_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        int i10 = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i10 >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                MIDNIGHT = localTime;
                NOON = localTimeArr[12];
                MIN = localTime;
                MAX = new LocalTime(23, 59, 59, Year.MAX_VALUE);
                return;
            }
            localTimeArr[i10] = new LocalTime(i10, 0, 0, 0);
            i10++;
        }
    }

    private LocalTime(int i10, int i11, int i12, int i13) {
        this.hour = (byte) i10;
        this.minute = (byte) i11;
        this.second = (byte) i12;
        this.nano = i13;
    }

    private static LocalTime create(int i10, int i11, int i12, int i13) {
        return ((i11 | i12) | i13) == 0 ? HOURS[i10] : new LocalTime(i10, i11, i12, i13);
    }

    public static LocalTime from(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.localTime());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new DateTimeException(a.e("Field too large for an int: ", temporalField));
            case 3:
                return this.nano / 1000;
            case 4:
                throw new DateTimeException(a.e("Field too large for an int: ", temporalField));
            case 5:
                return this.nano / 1000000;
            case 6:
                return (int) (toNanoOfDay() / 1000000);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % 12;
            case 12:
                int i10 = this.hour % 12;
                if (i10 % 12 == 0) {
                    return 12;
                }
                return i10;
            case 13:
                return this.hour;
            case 14:
                byte b10 = this.hour;
                if (b10 == 0) {
                    return 24;
                }
                return b10;
            case 15:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalTime of(int i10, int i11) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        if (i11 == 0) {
            return HOURS[i10];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i11);
        return new LocalTime(i10, i11, 0, 0);
    }

    public static LocalTime ofNanoOfDay(long j10) {
        ChronoField.NANO_OF_DAY.checkValidValue(j10);
        int i10 = (int) (j10 / NANOS_PER_HOUR);
        long j11 = j10 - (i10 * NANOS_PER_HOUR);
        int i11 = (int) (j11 / NANOS_PER_MINUTE);
        long j12 = j11 - (i11 * NANOS_PER_MINUTE);
        int i12 = (int) (j12 / NANOS_PER_SECOND);
        return create(i10, i11, i12, (int) (j12 - (i12 * NANOS_PER_SECOND)));
    }

    public static LocalTime ofSecondOfDay(long j10) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j10);
        int i10 = (int) (j10 / 3600);
        long j11 = j10 - (i10 * SECONDS_PER_HOUR);
        return create(i10, (int) (j11 / 60), (int) (j11 - (r0 * 60)), 0);
    }

    public static LocalTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_TIME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    public static LocalTime readExternal(DataInput dataInput) throws IOException {
        int i10;
        int i11;
        int i12 = dataInput.readByte();
        byte b10 = 0;
        if (i12 >= 0) {
            byte b11 = dataInput.readByte();
            if (b11 < 0) {
                ?? r52 = ~b11;
                i11 = 0;
                b10 = r52;
                i10 = 0;
            } else {
                byte b12 = dataInput.readByte();
                if (b12 < 0) {
                    i10 = ~b12;
                    b10 = b11;
                } else {
                    int i13 = dataInput.readInt();
                    i10 = b12;
                    i11 = i13;
                    b10 = b11;
                }
            }
            return of(i12, b10, i10, i11);
        }
        i12 = ~i12;
        i10 = 0;
        i11 = 0;
        return of(i12, b10, i10, i11);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate localDate) {
        return LocalDateTime.of(localDate, this);
    }

    public OffsetTime atOffset(ZoneOffset zoneOffset) {
        return OffsetTime.of(this, zoneOffset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : super.get(temporalField);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.NANO_OF_DAY ? toNanoOfDay() : temporalField == ChronoField.MICRO_OF_DAY ? toNanoOfDay() / 1000 : get0(temporalField) : temporalField.getFrom(this);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    public boolean isAfter(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean isBefore(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalTime minusHours(long j10) {
        return plusHours(-(j10 % 24));
    }

    public LocalTime minusMinutes(long j10) {
        return plusMinutes(-(j10 % 1440));
    }

    public LocalTime minusNanos(long j10) {
        return plusNanos(-(j10 % NANOS_PER_DAY));
    }

    public LocalTime minusSeconds(long j10) {
        return plusSeconds(-(j10 % 86400));
    }

    public LocalTime plusHours(long j10) {
        return j10 == 0 ? this : create(((((int) (j10 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.hour * 60) + this.minute;
        int i11 = ((((int) (j10 % 1440)) + i10) + MINUTES_PER_DAY) % MINUTES_PER_DAY;
        return i10 == i11 ? this : create(i11 / 60, i11 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j10) {
        if (j10 == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j11 = (((j10 % NANOS_PER_DAY) + nanoOfDay) + NANOS_PER_DAY) % NANOS_PER_DAY;
        return nanoOfDay == j11 ? this : create((int) (j11 / NANOS_PER_HOUR), (int) ((j11 / NANOS_PER_MINUTE) % 60), (int) ((j11 / NANOS_PER_SECOND) % 60), (int) (j11 % NANOS_PER_SECOND));
    }

    public LocalTime plusSeconds(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.minute * 60) + (this.hour * 3600) + this.second;
        int i11 = ((((int) (j10 % 86400)) + i10) + SECONDS_PER_DAY) % SECONDS_PER_DAY;
        return i10 == i11 ? this : create(i11 / SECONDS_PER_HOUR, (i11 / 60) % 60, i11 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localDate()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toNanoOfDay() {
        return (this.second * NANOS_PER_SECOND) + (this.minute * NANOS_PER_MINUTE) + (this.hour * NANOS_PER_HOUR) + this.nano;
    }

    public int toSecondOfDay() {
        return (this.minute * 60) + (this.hour * 3600) + this.second;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(18);
        byte b10 = this.hour;
        byte b11 = this.minute;
        byte b12 = this.second;
        int i10 = this.nano;
        sb2.append(b10 < 10 ? "0" : "");
        sb2.append((int) b10);
        sb2.append(b11 < 10 ? ":0" : ":");
        sb2.append((int) b11);
        if (b12 > 0 || i10 > 0) {
            sb2.append(b12 >= 10 ? ":" : ":0");
            sb2.append((int) b12);
            if (i10 > 0) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                if (i10 % 1000000 == 0) {
                    sb2.append(Integer.toString((i10 / 1000000) + 1000).substring(1));
                } else if (i10 % 1000 == 0) {
                    sb2.append(Integer.toString((i10 / 1000) + 1000000).substring(1));
                } else {
                    sb2.append(Integer.toString(i10 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
                }
            }
        }
        return sb2.toString();
    }

    public LocalTime truncatedTo(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.NANOS) {
            return this;
        }
        Duration duration = temporalUnit.getDuration();
        if (duration.getSeconds() > 86400) {
            throw new DateTimeException("Unit is too large to be used for truncation");
        }
        long nanos = duration.toNanos();
        if (NANOS_PER_DAY % nanos == 0) {
            return ofNanoOfDay((toNanoOfDay() / nanos) * nanos);
        }
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalTime localTimeFrom = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, localTimeFrom);
        }
        long nanoOfDay = localTimeFrom.toNanoOfDay() - toNanoOfDay();
        switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanoOfDay;
            case 2:
                return nanoOfDay / 1000;
            case 3:
                return nanoOfDay / 1000000;
            case 4:
                return nanoOfDay / NANOS_PER_SECOND;
            case 5:
                return nanoOfDay / NANOS_PER_MINUTE;
            case 6:
                return nanoOfDay / NANOS_PER_HOUR;
            case 7:
                return nanoOfDay / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime withHour(int i10) {
        if (this.hour == i10) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        return create(i10, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int i10) {
        if (this.minute == i10) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i10);
        return create(this.hour, i10, this.second, this.nano);
    }

    public LocalTime withNano(int i10) {
        if (this.nano == i10) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue(i10);
        return create(this.hour, this.minute, this.second, i10);
    }

    public LocalTime withSecond(int i10) {
        if (this.second == i10) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i10);
        return create(this.hour, this.minute, i10, this.nano);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
            return;
        }
        if (this.second != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(~this.second);
        } else if (this.minute == 0) {
            dataOutput.writeByte(~this.hour);
        } else {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(~this.minute);
        }
    }

    public static LocalTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime localTime) {
        int iCompareInts = Jdk8Methods.compareInts(this.hour, localTime.hour);
        if (iCompareInts != 0) {
            return iCompareInts;
        }
        int iCompareInts2 = Jdk8Methods.compareInts(this.minute, localTime.minute);
        if (iCompareInts2 != 0) {
            return iCompareInts2;
        }
        int iCompareInts3 = Jdk8Methods.compareInts(this.second, localTime.second);
        return iCompareInts3 == 0 ? Jdk8Methods.compareInts(this.nano, localTime.nano) : iCompareInts3;
    }

    public static LocalTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        long epochSecond = ((instant.getEpochSecond() % 86400) + clock.getZone().getRules().getOffset(instant).getTotalSeconds()) % 86400;
        if (epochSecond < 0) {
            epochSecond += 86400;
        }
        return ofSecondOfDay(epochSecond, instant.getNano());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime minus(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return (LocalTime) temporalAdjuster;
        }
        return (LocalTime) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.isTimeBased();
        }
        return temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plusNanos((j10 % MICROS_PER_DAY) * 1000);
                case 3:
                    return plusNanos((j10 % 86400000) * 1000000);
                case 4:
                    return plusSeconds(j10);
                case 5:
                    return plusMinutes(j10);
                case 6:
                    return plusHours(j10);
                case 7:
                    return plusHours((j10 % 2) * 12);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (LocalTime) temporalUnit.addTo(this, j10);
    }

    public static LocalTime of(int i10, int i11, int i12) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        if ((i11 | i12) == 0) {
            return HOURS[i10];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i11);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i12);
        return new LocalTime(i10, i11, i12, 0);
    }

    public static LocalTime ofSecondOfDay(long j10, int i10) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j10);
        ChronoField.NANO_OF_SECOND.checkValidValue(i10);
        int i11 = (int) (j10 / 3600);
        long j11 = j10 - (i11 * SECONDS_PER_HOUR);
        return create(i11, (int) (j11 / 60), (int) (j11 - (r0 * 60)), i10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalField temporalField, long j10) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j10);
            switch (AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return withNano((int) j10);
                case 2:
                    return ofNanoOfDay(j10);
                case 3:
                    return withNano(((int) j10) * 1000);
                case 4:
                    return ofNanoOfDay(j10 * 1000);
                case 5:
                    return withNano(((int) j10) * 1000000);
                case 6:
                    return ofNanoOfDay(j10 * 1000000);
                case 7:
                    return withSecond((int) j10);
                case 8:
                    return plusSeconds(j10 - toSecondOfDay());
                case 9:
                    return withMinute((int) j10);
                case 10:
                    return plusMinutes(j10 - ((this.hour * 60) + this.minute));
                case 11:
                    return plusHours(j10 - (this.hour % 12));
                case 12:
                    if (j10 == 12) {
                        j10 = 0;
                    }
                    return plusHours(j10 - (this.hour % 12));
                case 13:
                    return withHour((int) j10);
                case 14:
                    if (j10 == 24) {
                        j10 = 0;
                    }
                    return withHour((int) j10);
                case 15:
                    return plusHours((j10 - (this.hour / 12)) * 12);
                default:
                    throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
            }
        }
        return (LocalTime) temporalField.adjustInto(this, j10);
    }

    public static LocalTime of(int i10, int i11, int i12, int i13) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i11);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i12);
        ChronoField.NANO_OF_SECOND.checkValidValue(i13);
        return create(i10, i11, i12, i13);
    }
}
