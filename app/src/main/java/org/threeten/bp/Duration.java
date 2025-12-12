package org.threeten.bp;

import ac.c;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ClassUtils;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes2.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    /* renamed from: org.threeten.bp.Duration$1, reason: invalid class name */
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
        }
    }

    private Duration(long j10, int i10) {
        this.seconds = j10;
        this.nanos = i10;
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long jUntil = temporal.until(temporal2, chronoUnit);
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        long j10 = 0;
        if (temporal.isSupported(chronoField) && temporal2.isSupported(chronoField)) {
            try {
                long j11 = temporal.getLong(chronoField);
                long j12 = temporal2.getLong(chronoField) - j11;
                if (jUntil > 0 && j12 < 0) {
                    j12 += 1000000000;
                } else if (jUntil < 0 && j12 > 0) {
                    j12 -= 1000000000;
                } else if (jUntil == 0 && j12 != 0) {
                    try {
                        jUntil = temporal.until(temporal2.with(chronoField, j11), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j10 = j12;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return ofSeconds(jUntil, j10);
    }

    private static Duration create(boolean z10, long j10, long j11, long j12, long j13, int i10) {
        long jSafeAdd = Jdk8Methods.safeAdd(j10, Jdk8Methods.safeAdd(j11, Jdk8Methods.safeAdd(j12, j13)));
        return z10 ? ofSeconds(jSafeAdd, i10).negated() : ofSeconds(jSafeAdd, i10);
    }

    public static Duration from(TemporalAmount temporalAmount) {
        Jdk8Methods.requireNonNull(temporalAmount, "amount");
        Duration durationPlus = ZERO;
        for (TemporalUnit temporalUnit : temporalAmount.getUnits()) {
            durationPlus = durationPlus.plus(temporalAmount.get(temporalUnit), temporalUnit);
        }
        return durationPlus;
    }

    public static Duration of(long j10, TemporalUnit temporalUnit) {
        return ZERO.plus(j10, temporalUnit);
    }

    public static Duration ofDays(long j10) {
        return create(Jdk8Methods.safeMultiply(j10, 86400), 0);
    }

    public static Duration ofHours(long j10) {
        return create(Jdk8Methods.safeMultiply(j10, 3600), 0);
    }

    public static Duration ofMillis(long j10) {
        long j11 = j10 / 1000;
        int i10 = (int) (j10 % 1000);
        if (i10 < 0) {
            i10 += 1000;
            j11--;
        }
        return create(j11, i10 * NANOS_PER_MILLI);
    }

    public static Duration ofMinutes(long j10) {
        return create(Jdk8Methods.safeMultiply(j10, 60), 0);
    }

    public static Duration ofNanos(long j10) {
        long j11 = j10 / 1000000000;
        int i10 = (int) (j10 % 1000000000);
        if (i10 < 0) {
            i10 += 1000000000;
            j11--;
        }
        return create(j11, i10);
    }

    public static Duration ofSeconds(long j10) {
        return create(j10, 0);
    }

    public static Duration parse(CharSequence charSequence) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches() && !"T".equals(matcher.group(3))) {
            boolean zEquals = "-".equals(matcher.group(1));
            String strGroup = matcher.group(2);
            String strGroup2 = matcher.group(4);
            String strGroup3 = matcher.group(5);
            String strGroup4 = matcher.group(6);
            String strGroup5 = matcher.group(7);
            if (strGroup != null || strGroup2 != null || strGroup3 != null || strGroup4 != null) {
                try {
                    return create(zEquals, parseNumber(charSequence, strGroup, 86400, "days"), parseNumber(charSequence, strGroup2, 3600, "hours"), parseNumber(charSequence, strGroup3, 60, "minutes"), parseNumber(charSequence, strGroup4, 1, "seconds"), parseFraction(charSequence, strGroup5, strGroup4 != null && strGroup4.charAt(0) == '-' ? -1 : 1));
                } catch (ArithmeticException e10) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", charSequence, 0).initCause(e10));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", charSequence, 0);
    }

    private static int parseFraction(CharSequence charSequence, String str, int i10) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str.concat("000000000").substring(0, 9)) * i10;
        } catch (ArithmeticException e10) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e10));
        } catch (NumberFormatException e11) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e11));
        }
    }

    private static long parseNumber(CharSequence charSequence, String str, int i10, String str2) {
        if (str == null) {
            return 0L;
        }
        try {
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            return Jdk8Methods.safeMultiply(Long.parseLong(str), i10);
        } catch (ArithmeticException e10) {
            throw ((DateTimeParseException) new DateTimeParseException(c.j("Text cannot be parsed to a Duration: ", str2), charSequence, 0).initCause(e10));
        } catch (NumberFormatException e11) {
            throw ((DateTimeParseException) new DateTimeParseException(c.j("Text cannot be parsed to a Duration: ", str2), charSequence, 0).initCause(e11));
        }
    }

    public static Duration readExternal(DataInput dataInput) throws IOException {
        return ofSeconds(dataInput.readLong(), dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long j10 = this.seconds;
        if (j10 != 0) {
            temporal = temporal.plus(j10, ChronoUnit.SECONDS);
        }
        int i10 = this.nanos;
        return i10 != 0 ? temporal.plus(i10, ChronoUnit.NANOS) : temporal;
    }

    public Duration dividedBy(long j10) {
        if (j10 != 0) {
            return j10 == 1 ? this : create(toSeconds().divide(BigDecimal.valueOf(j10), RoundingMode.DOWN));
        }
        throw new ArithmeticException("Cannot divide by zero");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.seconds == duration.seconds && this.nanos == duration.nanos;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.SECONDS) {
            return this.seconds;
        }
        if (temporalUnit == ChronoUnit.NANOS) {
            return this.nanos;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.SECONDS, ChronoUnit.NANOS));
    }

    public int hashCode() {
        long j10 = this.seconds;
        return (this.nanos * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public Duration minus(Duration duration) {
        long seconds = duration.getSeconds();
        int nano = duration.getNano();
        return seconds == Long.MIN_VALUE ? plus(Long.MAX_VALUE, -nano).plus(1L, 0L) : plus(-seconds, -nano);
    }

    public Duration minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public Duration minusHours(long j10) {
        return j10 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j10);
    }

    public Duration minusMillis(long j10) {
        return j10 == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1L) : plusMillis(-j10);
    }

    public Duration minusMinutes(long j10) {
        return j10 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-j10);
    }

    public Duration minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public Duration minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public Duration multipliedBy(long j10) {
        return j10 == 0 ? ZERO : j10 == 1 ? this : create(toSeconds().multiply(BigDecimal.valueOf(j10)));
    }

    public Duration negated() {
        return multipliedBy(-1L);
    }

    public Duration plus(Duration duration) {
        return plus(duration.getSeconds(), duration.getNano());
    }

    public Duration plusDays(long j10) {
        return plus(Jdk8Methods.safeMultiply(j10, 86400), 0L);
    }

    public Duration plusHours(long j10) {
        return plus(Jdk8Methods.safeMultiply(j10, 3600), 0L);
    }

    public Duration plusMillis(long j10) {
        return plus(j10 / 1000, (j10 % 1000) * 1000000);
    }

    public Duration plusMinutes(long j10) {
        return plus(Jdk8Methods.safeMultiply(j10, 60), 0L);
    }

    public Duration plusNanos(long j10) {
        return plus(0L, j10);
    }

    public Duration plusSeconds(long j10) {
        return plus(j10, 0L);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        long j10 = this.seconds;
        if (j10 != 0) {
            temporal = temporal.minus(j10, ChronoUnit.SECONDS);
        }
        int i10 = this.nanos;
        return i10 != 0 ? temporal.minus(i10, ChronoUnit.NANOS) : temporal;
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public long toMillis() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000), this.nanos / NANOS_PER_MILLI);
    }

    public int toMillisPart() {
        return this.nanos / NANOS_PER_MILLI;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public long toNanos() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000000000), this.nanos);
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j10 = this.seconds;
        long j11 = j10 / 3600;
        int i10 = (int) ((j10 % 3600) / 60);
        int i11 = (int) (j10 % 60);
        StringBuilder sbQ = c.q(24, "PT");
        if (j11 != 0) {
            sbQ.append(j11);
            sbQ.append('H');
        }
        if (i10 != 0) {
            sbQ.append(i10);
            sbQ.append('M');
        }
        if (i11 == 0 && this.nanos == 0 && sbQ.length() > 2) {
            return sbQ.toString();
        }
        if (i11 >= 0 || this.nanos <= 0) {
            sbQ.append(i11);
        } else if (i11 == -1) {
            sbQ.append("-0");
        } else {
            sbQ.append(i11 + 1);
        }
        if (this.nanos > 0) {
            int length = sbQ.length();
            if (i11 < 0) {
                sbQ.append(2000000000 - this.nanos);
            } else {
                sbQ.append(this.nanos + 1000000000);
            }
            while (sbQ.charAt(sbQ.length() - 1) == '0') {
                sbQ.setLength(sbQ.length() - 1);
            }
            sbQ.setCharAt(length, ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        sbQ.append('S');
        return sbQ.toString();
    }

    public Duration withNanos(int i10) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(i10);
        return create(this.seconds, i10);
    }

    public Duration withSeconds(long j10) {
        return create(j10, this.nanos);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Duration ofSeconds(long j10, long j11) {
        return create(Jdk8Methods.safeAdd(j10, Jdk8Methods.floorDiv(j11, 1000000000L)), Jdk8Methods.floorMod(j11, 1000000000));
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int iCompareLongs = Jdk8Methods.compareLongs(this.seconds, duration.seconds);
        return iCompareLongs != 0 ? iCompareLongs : this.nanos - duration.nanos;
    }

    public Duration plus(long j10, TemporalUnit temporalUnit) {
        Jdk8Methods.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return plus(Jdk8Methods.safeMultiply(j10, 86400), 0L);
        }
        if (temporalUnit.isDurationEstimated()) {
            throw new DateTimeException("Unit must not have an estimated duration");
        }
        if (j10 == 0) {
            return this;
        }
        if (temporalUnit instanceof ChronoUnit) {
            int i10 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? plusSeconds(Jdk8Methods.safeMultiply(temporalUnit.getDuration().seconds, j10)) : plusSeconds(j10) : plusMillis(j10) : plusSeconds((j10 / 1000000000) * 1000).plusNanos((j10 % 1000000000) * 1000) : plusNanos(j10);
        }
        return plusSeconds(temporalUnit.getDuration().multipliedBy(j10).getSeconds()).plusNanos(r7.getNano());
    }

    private static Duration create(long j10, int i10) {
        if ((i10 | j10) == 0) {
            return ZERO;
        }
        return new Duration(j10, i10);
    }

    public Duration minus(long j10, TemporalUnit temporalUnit) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j10, temporalUnit);
    }

    private static Duration create(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerExact.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (bigIntegerArrDivideAndRemainder[0].bitLength() <= 63) {
            return ofSeconds(bigIntegerArrDivideAndRemainder[0].longValue(), bigIntegerArrDivideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    private Duration plus(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return ofSeconds(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j10), j11 / 1000000000), this.nanos + (j11 % 1000000000));
    }
}
