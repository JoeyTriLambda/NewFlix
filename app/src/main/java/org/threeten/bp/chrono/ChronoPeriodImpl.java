package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes2.dex */
final class ChronoPeriodImpl extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final Chronology chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(Chronology chronology, int i10, int i11, int i12) {
        this.chronology = chronology;
        this.years = i10;
        this.months = i11;
        this.days = i12;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        Chronology chronology = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chronology != null && !this.chronology.equals(chronology)) {
            throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + chronology.getId());
        }
        int i10 = this.years;
        if (i10 != 0) {
            temporal = temporal.plus(i10, ChronoUnit.YEARS);
        }
        int i11 = this.months;
        if (i11 != 0) {
            temporal = temporal.plus(i11, ChronoUnit.MONTHS);
        }
        int i12 = this.days;
        return i12 != 0 ? temporal.plus(i12, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoPeriodImpl)) {
            return false;
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
        return this.years == chronoPeriodImpl.years && this.months == chronoPeriodImpl.months && this.days == chronoPeriodImpl.days && this.chronology.equals(chronoPeriodImpl.chronology);
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
        return this.chronology;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public int hashCode() {
        return Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.years, 16) + this.chronology.hashCode() + this.days;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod minus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeSubtract(this.years, chronoPeriodImpl.years), Jdk8Methods.safeSubtract(this.months, chronoPeriodImpl.months), Jdk8Methods.safeSubtract(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to subtract amount: " + temporalAmount);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod multipliedBy(int i10) {
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeMultiply(this.years, i10), Jdk8Methods.safeMultiply(this.months, i10), Jdk8Methods.safeMultiply(this.days, i10));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod normalized() {
        Chronology chronology = this.chronology;
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        if (!chronology.range(chronoField).isFixed()) {
            return this;
        }
        long maximum = (this.chronology.range(chronoField).getMaximum() - this.chronology.range(chronoField).getMinimum()) + 1;
        long j10 = (this.years * maximum) + this.months;
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeToInt(j10 / maximum), Jdk8Methods.safeToInt(j10 % maximum), this.days);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public ChronoPeriod plus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeAdd(this.years, chronoPeriodImpl.years), Jdk8Methods.safeAdd(this.months, chronoPeriodImpl.months), Jdk8Methods.safeAdd(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to add amount: " + temporalAmount);
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod, org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        Chronology chronology = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chronology != null && !this.chronology.equals(chronology)) {
            throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + chronology.getId());
        }
        int i10 = this.years;
        if (i10 != 0) {
            temporal = temporal.minus(i10, ChronoUnit.YEARS);
        }
        int i11 = this.months;
        if (i11 != 0) {
            temporal = temporal.minus(i11, ChronoUnit.MONTHS);
        }
        int i12 = this.days;
        return i12 != 0 ? temporal.minus(i12, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public String toString() {
        if (isZero()) {
            return this.chronology + " P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.chronology);
        sb2.append(" P");
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
}
