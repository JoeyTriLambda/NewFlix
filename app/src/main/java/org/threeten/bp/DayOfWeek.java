package org.threeten.bp;

import ac.c;
import java.util.Locale;
import o1.a;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static final TemporalQuery<DayOfWeek> FROM = new TemporalQuery<DayOfWeek>() { // from class: org.threeten.bp.DayOfWeek.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public DayOfWeek queryFrom(TemporalAccessor temporalAccessor) {
            return DayOfWeek.from(temporalAccessor);
        }
    };
    private static final DayOfWeek[] ENUMS = values();

    public static DayOfWeek from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return of(temporalAccessor.get(ChronoField.DAY_OF_WEEK));
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e10);
        }
    }

    public static DayOfWeek of(int i10) {
        if (i10 < 1 || i10 > 7) {
            throw new DateTimeException(c.f("Invalid value for DayOfWeek: ", i10));
        }
        return ENUMS[i10 - 1];
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField == ChronoField.DAY_OF_WEEK ? getValue() : range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_WEEK, textStyle).toFormatter(locale).format(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        return temporalField.getFrom(this);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.DAY_OF_WEEK : temporalField != null && temporalField.isSupportedBy(this);
    }

    public DayOfWeek minus(long j10) {
        return plus(-(j10 % 7));
    }

    public DayOfWeek plus(long j10) {
        return ENUMS[((((int) (j10 % 7)) + 7) + ordinal()) % 7];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return temporalField.range();
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        return temporalField.rangeRefinedBy(this);
    }
}
