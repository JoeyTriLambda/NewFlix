package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalUnit;

/* loaded from: classes2.dex */
abstract class ChronoDateImpl<D extends ChronoLocalDate> extends ChronoLocalDate implements Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    /* renamed from: org.threeten.bp.chrono.ChronoDateImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDateTime<?> atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    public ChronoDateImpl<D> minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public ChronoDateImpl<D> minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public ChronoDateImpl<D> minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public ChronoDateImpl<D> minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public abstract ChronoDateImpl<D> plusDays(long j10);

    public abstract ChronoDateImpl<D> plusMonths(long j10);

    public ChronoDateImpl<D> plusWeeks(long j10) {
        return plusDays(Jdk8Methods.safeMultiply(j10, 7));
    }

    public abstract ChronoDateImpl<D> plusYears(long j10);

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDate chronoLocalDateDate = getChronology().date(temporal);
        return temporalUnit instanceof ChronoUnit ? LocalDate.from((TemporalAccessor) this).until(chronoLocalDateDate, temporalUnit) : temporalUnit.between(this, chronoLocalDateDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public ChronoDateImpl<D> plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j10);
                case 2:
                    return plusDays(Jdk8Methods.safeMultiply(j10, 7));
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
                default:
                    throw new DateTimeException(temporalUnit + " not valid for chronology " + getChronology().getId());
            }
        }
        return (ChronoDateImpl) getChronology().ensureChronoLocalDate(temporalUnit.addTo(this, j10));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        throw new UnsupportedOperationException("Not supported in ThreeTen backport");
    }
}
