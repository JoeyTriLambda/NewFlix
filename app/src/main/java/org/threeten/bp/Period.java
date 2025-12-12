package org.threeten.bp;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes2.dex */
public final class Period extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);

    private Period(int i10, int i11, int i12) {
        this.years = i10;
        this.months = i11;
        this.days = i12;
    }

    public static Period between(LocalDate localDate, LocalDate localDate2) {
        return localDate.until((ChronoLocalDate) localDate2);
    }

    private static Period create(int i10, int i11, int i12) {
        return ((i10 | i11) | i12) == 0 ? ZERO : new Period(i10, i11, i12);
    }

    public static Period from(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return (Period) temporalAmount;
        }
        if ((temporalAmount instanceof ChronoPeriod) && !IsoChronology.INSTANCE.equals(((ChronoPeriod) temporalAmount).getChronology())) {
            throw new DateTimeException("Period requires ISO chronology: " + temporalAmount);
        }
        Jdk8Methods.requireNonNull(temporalAmount, "amount");
        int iSafeToInt = 0;
        int iSafeToInt2 = 0;
        int iSafeToInt3 = 0;
        for (TemporalUnit temporalUnit : temporalAmount.getUnits()) {
            long j10 = temporalAmount.get(temporalUnit);
            if (temporalUnit == ChronoUnit.YEARS) {
                iSafeToInt = Jdk8Methods.safeToInt(j10);
            } else if (temporalUnit == ChronoUnit.MONTHS) {
                iSafeToInt2 = Jdk8Methods.safeToInt(j10);
            } else {
                if (temporalUnit != ChronoUnit.DAYS) {
                    throw new DateTimeException("Unit must be Years, Months or Days, but was " + temporalUnit);
                }
                iSafeToInt3 = Jdk8Methods.safeToInt(j10);
            }
        }
        return create(iSafeToInt, iSafeToInt2, iSafeToInt3);
    }

    public static Period of(int i10, int i11, int i12) {
        return create(i10, i11, i12);
    }

    public static Period ofDays(int i10) {
        return create(0, 0, i10);
    }

    public static Period ofMonths(int i10) {
        return create(0, i10, 0);
    }

    public static Period ofWeeks(int i10) {
        return create(0, 0, Jdk8Methods.safeMultiply(i10, 7));
    }

    public static Period ofYears(int i10) {
        return create(i10, 0, 0);
    }

    public static Period parse(CharSequence charSequence) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            int i10 = "-".equals(matcher.group(1)) ? -1 : 1;
            String strGroup = matcher.group(2);
            String strGroup2 = matcher.group(3);
            String strGroup3 = matcher.group(4);
            String strGroup4 = matcher.group(5);
            if (strGroup != null || strGroup2 != null || strGroup3 != null || strGroup4 != null) {
                try {
                    return create(parseNumber(charSequence, strGroup, i10), parseNumber(charSequence, strGroup2, i10), Jdk8Methods.safeAdd(parseNumber(charSequence, strGroup4, i10), Jdk8Methods.safeMultiply(parseNumber(charSequence, strGroup3, i10), 7)));
                } catch (NumberFormatException e10) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e10));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static int parseNumber(CharSequence charSequence, String str, int i10) {
        if (str == null) {
            return 0;
        }
        try {
            return Jdk8Methods.safeMultiply(Integer.parseInt(str), i10);
        } catch (ArithmeticException e10) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e10));
        }
    }

    private Object readResolve() {
        return ((this.years | this.months) | this.days) == 0 ? ZERO : this;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i10 = this.years;
        if (i10 != 0) {
            temporal = this.months != 0 ? temporal.plus(toTotalMonths(), ChronoUnit.MONTHS) : temporal.plus(i10, ChronoUnit.YEARS);
        } else {
            int i11 = this.months;
            if (i11 != 0) {
                temporal = temporal.plus(i11, ChronoUnit.MONTHS);
            }
        }
        int i12 = this.days;
        return i12 != 0 ? temporal.plus(i12, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit temporalUnit) {
        int i10;
        if (temporalUnit == ChronoUnit.YEARS) {
            i10 = this.years;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i10 = this.months;
        } else {
            if (temporalUnit != ChronoUnit.DAYS) {
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
            i10 = this.days;
        }
        return i10;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Chronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    public int getYears() {
        return this.years;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public int hashCode() {
        return Integer.rotateLeft(this.days, 16) + Integer.rotateLeft(this.months, 8) + this.years;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean isZero() {
        return this == ZERO;
    }

    public Period minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public Period minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public Period minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public Period plusDays(long j10) {
        return j10 == 0 ? this : create(this.years, this.months, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd(this.days, j10)));
    }

    public Period plusMonths(long j10) {
        return j10 == 0 ? this : create(this.years, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd(this.months, j10)), this.days);
    }

    public Period plusYears(long j10) {
        return j10 == 0 ? this : create(Jdk8Methods.safeToInt(Jdk8Methods.safeAdd(this.years, j10)), this.months, this.days);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i10 = this.years;
        if (i10 != 0) {
            temporal = this.months != 0 ? temporal.minus(toTotalMonths(), ChronoUnit.MONTHS) : temporal.minus(i10, ChronoUnit.YEARS);
        } else {
            int i11 = this.months;
            if (i11 != 0) {
                temporal = temporal.minus(i11, ChronoUnit.MONTHS);
            }
        }
        int i12 = this.days;
        return i12 != 0 ? temporal.minus(i12, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb2 = new StringBuilder("P");
        int i10 = this.years;
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('Y');
        }
        int i11 = this.months;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('M');
        }
        int i12 = this.days;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('D');
        }
        return sb2.toString();
    }

    public long toTotalMonths() {
        return (this.years * 12) + this.months;
    }

    public Period withDays(int i10) {
        return i10 == this.days ? this : create(this.years, this.months, i10);
    }

    public Period withMonths(int i10) {
        return i10 == this.months ? this : create(this.years, i10, this.days);
    }

    public Period withYears(int i10) {
        return i10 == this.years ? this : create(i10, this.months, this.days);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period minus(TemporalAmount temporalAmount) {
        Period periodFrom = from(temporalAmount);
        return create(Jdk8Methods.safeSubtract(this.years, periodFrom.years), Jdk8Methods.safeSubtract(this.months, periodFrom.months), Jdk8Methods.safeSubtract(this.days, periodFrom.days));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period multipliedBy(int i10) {
        return (this == ZERO || i10 == 1) ? this : create(Jdk8Methods.safeMultiply(this.years, i10), Jdk8Methods.safeMultiply(this.months, i10), Jdk8Methods.safeMultiply(this.days, i10));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period negated() {
        return multipliedBy(-1);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period normalized() {
        long totalMonths = toTotalMonths();
        long j10 = totalMonths / 12;
        int i10 = (int) (totalMonths % 12);
        return (j10 == ((long) this.years) && i10 == this.months) ? this : create(Jdk8Methods.safeToInt(j10), i10, this.days);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public Period plus(TemporalAmount temporalAmount) {
        Period periodFrom = from(temporalAmount);
        return create(Jdk8Methods.safeAdd(this.years, periodFrom.years), Jdk8Methods.safeAdd(this.months, periodFrom.months), Jdk8Methods.safeAdd(this.days, periodFrom.days));
    }
}
