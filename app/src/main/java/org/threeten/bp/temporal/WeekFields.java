package org.threeten.bp.temporal;

import ac.c;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes2.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    private static final long serialVersionUID = -1177360819670808121L;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
    private final transient TemporalField weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
    private final transient TemporalField weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
    private final transient TemporalField weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);

    public static class ComputedDayOfField implements TemporalField {
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);
        private static final ValueRange WEEK_BASED_YEAR_RANGE = ChronoField.YEAR.range();

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.name = str;
            this.weekDef = weekFields;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = valueRange;
        }

        private int computeWeek(int i10, int i11) {
            return ((i11 - 1) + (i10 + 7)) / 7;
        }

        private int localizedDayOfWeek(TemporalAccessor temporalAccessor, int i10) {
            return Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - i10, 7) + 1;
        }

        private int localizedWBY(TemporalAccessor temporalAccessor) {
            int iFloorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            int i10 = temporalAccessor.get(ChronoField.YEAR);
            long jLocalizedWeekOfYear = localizedWeekOfYear(temporalAccessor, iFloorMod);
            if (jLocalizedWeekOfYear == 0) {
                return i10 - 1;
            }
            if (jLocalizedWeekOfYear < 53) {
                return i10;
            }
            return jLocalizedWeekOfYear >= ((long) computeWeek(startOfWeekOffset(temporalAccessor.get(ChronoField.DAY_OF_YEAR), iFloorMod), this.weekDef.getMinimalDaysInFirstWeek() + (Year.isLeap((long) i10) ? 366 : 365))) ? i10 + 1 : i10;
        }

        private int localizedWOWBY(TemporalAccessor temporalAccessor) {
            int iFloorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long jLocalizedWeekOfYear = localizedWeekOfYear(temporalAccessor, iFloorMod);
            if (jLocalizedWeekOfYear == 0) {
                return ((int) localizedWeekOfYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(1L, (TemporalUnit) ChronoUnit.WEEKS), iFloorMod)) + 1;
            }
            if (jLocalizedWeekOfYear >= 53) {
                if (jLocalizedWeekOfYear >= computeWeek(startOfWeekOffset(temporalAccessor.get(ChronoField.DAY_OF_YEAR), iFloorMod), this.weekDef.getMinimalDaysInFirstWeek() + (Year.isLeap((long) temporalAccessor.get(ChronoField.YEAR)) ? 366 : 365))) {
                    return (int) (jLocalizedWeekOfYear - (r7 - 1));
                }
            }
            return (int) jLocalizedWeekOfYear;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporalAccessor, int i10) {
            int i11 = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            return computeWeek(startOfWeekOffset(i11, i10), i11);
        }

        private long localizedWeekOfYear(TemporalAccessor temporalAccessor, int i10) {
            int i11 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            return computeWeek(startOfWeekOffset(i11, i10), i11);
        }

        public static ComputedDayOfField ofDayOfWeekField(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        public static ComputedDayOfField ofWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, WEEK_BASED_YEAR_RANGE);
        }

        public static ComputedDayOfField ofWeekOfMonthField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        public static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        public static ComputedDayOfField ofWeekOfYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        private ValueRange rangeWOWBY(TemporalAccessor temporalAccessor) {
            int iFloorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long jLocalizedWeekOfYear = localizedWeekOfYear(temporalAccessor, iFloorMod);
            if (jLocalizedWeekOfYear == 0) {
                return rangeWOWBY(Chronology.from(temporalAccessor).date(temporalAccessor).minus(2L, (TemporalUnit) ChronoUnit.WEEKS));
            }
            return jLocalizedWeekOfYear >= ((long) computeWeek(startOfWeekOffset(temporalAccessor.get(ChronoField.DAY_OF_YEAR), iFloorMod), this.weekDef.getMinimalDaysInFirstWeek() + (Year.isLeap((long) temporalAccessor.get(ChronoField.YEAR)) ? 366 : 365))) ? rangeWOWBY(Chronology.from(temporalAccessor).date(temporalAccessor).plus(2L, (TemporalUnit) ChronoUnit.WEEKS)) : ValueRange.of(1L, r0 - 1);
        }

        private int startOfWeekOffset(int i10, int i11) {
            int iFloorMod = Jdk8Methods.floorMod(i10 - i11, 7);
            return iFloorMod + 1 > this.weekDef.getMinimalDaysInFirstWeek() ? 7 - iFloorMod : -iFloorMod;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r10, long j10) {
            int iCheckValidIntValue = this.range.checkValidIntValue(j10, this);
            if (iCheckValidIntValue == r10.get(this)) {
                return r10;
            }
            if (this.rangeUnit != ChronoUnit.FOREVER) {
                return (R) r10.plus(iCheckValidIntValue - r1, this.baseUnit);
            }
            int i10 = r10.get(this.weekDef.weekOfWeekBasedYear);
            long j11 = (long) ((j10 - r1) * 52.1775d);
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            Temporal temporalPlus = r10.plus(j11, chronoUnit);
            if (temporalPlus.get(this) > iCheckValidIntValue) {
                return (R) temporalPlus.minus(temporalPlus.get(this.weekDef.weekOfWeekBasedYear), chronoUnit);
            }
            if (temporalPlus.get(this) < iCheckValidIntValue) {
                temporalPlus = temporalPlus.plus(2L, chronoUnit);
            }
            R r11 = (R) temporalPlus.plus(i10 - temporalPlus.get(this.weekDef.weekOfWeekBasedYear), chronoUnit);
            return r11.get(this) > iCheckValidIntValue ? (R) r11.minus(1L, chronoUnit) : r11;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale locale) {
            Jdk8Methods.requireNonNull(locale, "locale");
            return this.rangeUnit == ChronoUnit.YEARS ? "Week" : toString();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long getFrom(TemporalAccessor temporalAccessor) {
            int iLocalizedWBY;
            int iFloorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return iFloorMod;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                int i10 = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
                iLocalizedWBY = computeWeek(startOfWeekOffset(i10, iFloorMod), i10);
            } else if (temporalUnit == ChronoUnit.YEARS) {
                int i11 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
                iLocalizedWBY = computeWeek(startOfWeekOffset(i11, iFloorMod), i11);
            } else if (temporalUnit == IsoFields.WEEK_BASED_YEARS) {
                iLocalizedWBY = localizedWOWBY(temporalAccessor);
            } else {
                if (temporalUnit != ChronoUnit.FOREVER) {
                    throw new IllegalStateException("unreachable");
                }
                iLocalizedWBY = localizedWBY(temporalAccessor);
            }
            return iLocalizedWBY;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == IsoFields.WEEK_BASED_YEARS) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY);
            }
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else {
                if (temporalUnit != ChronoUnit.YEARS) {
                    if (temporalUnit == IsoFields.WEEK_BASED_YEARS) {
                        return rangeWOWBY(temporalAccessor);
                    }
                    if (temporalUnit == ChronoUnit.FOREVER) {
                        return temporalAccessor.range(ChronoField.YEAR);
                    }
                    throw new IllegalStateException("unreachable");
                }
                chronoField = ChronoField.DAY_OF_YEAR;
            }
            int iStartOfWeekOffset = startOfWeekOffset(temporalAccessor.get(chronoField), Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1);
            ValueRange valueRangeRange = temporalAccessor.range(chronoField);
            return ValueRange.of(computeWeek(iStartOfWeekOffset, (int) valueRangeRange.getMinimum()), computeWeek(iStartOfWeekOffset, (int) valueRangeRange.getMaximum()));
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            long j10;
            int iLocalizedDayOfWeek;
            long jCheckValidIntValue;
            ChronoLocalDate chronoLocalDateDate;
            long jCheckValidIntValue2;
            ChronoLocalDate chronoLocalDateDate2;
            long jCheckValidIntValue3;
            int iLocalizedDayOfWeek2;
            long jLocalizedWeekOfYear;
            int value = this.weekDef.getFirstDayOfWeek().getValue();
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                map.put(ChronoField.DAY_OF_WEEK, Long.valueOf(Jdk8Methods.floorMod((this.range.checkValidIntValue(map.remove(this).longValue(), this) - 1) + (value - 1), 7) + 1));
                return null;
            }
            ChronoField chronoField = ChronoField.DAY_OF_WEEK;
            if (!map.containsKey(chronoField)) {
                return null;
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                if (!map.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                    return null;
                }
                Chronology chronologyFrom = Chronology.from(temporalAccessor);
                int iFloorMod = Jdk8Methods.floorMod(chronoField.checkValidIntValue(map.get(chronoField).longValue()) - value, 7) + 1;
                int iCheckValidIntValue = range().checkValidIntValue(map.get(this).longValue(), this);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    chronoLocalDateDate2 = chronologyFrom.date(iCheckValidIntValue, 1, this.weekDef.getMinimalDaysInFirstWeek());
                    jCheckValidIntValue3 = map.get(this.weekDef.weekOfWeekBasedYear).longValue();
                    iLocalizedDayOfWeek2 = localizedDayOfWeek(chronoLocalDateDate2, value);
                    jLocalizedWeekOfYear = localizedWeekOfYear(chronoLocalDateDate2, iLocalizedDayOfWeek2);
                } else {
                    chronoLocalDateDate2 = chronologyFrom.date(iCheckValidIntValue, 1, this.weekDef.getMinimalDaysInFirstWeek());
                    jCheckValidIntValue3 = this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(map.get(this.weekDef.weekOfWeekBasedYear).longValue(), this.weekDef.weekOfWeekBasedYear);
                    iLocalizedDayOfWeek2 = localizedDayOfWeek(chronoLocalDateDate2, value);
                    jLocalizedWeekOfYear = localizedWeekOfYear(chronoLocalDateDate2, iLocalizedDayOfWeek2);
                }
                ChronoLocalDate chronoLocalDatePlus = chronoLocalDateDate2.plus(((jCheckValidIntValue3 - jLocalizedWeekOfYear) * 7) + (iFloorMod - iLocalizedDayOfWeek2), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && chronoLocalDatePlus.getLong(this) != map.get(this).longValue()) {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                map.remove(this);
                map.remove(this.weekDef.weekOfWeekBasedYear);
                map.remove(chronoField);
                return chronoLocalDatePlus;
            }
            ChronoField chronoField2 = ChronoField.YEAR;
            if (!map.containsKey(chronoField2)) {
                return null;
            }
            int iFloorMod2 = Jdk8Methods.floorMod(chronoField.checkValidIntValue(map.get(chronoField).longValue()) - value, 7) + 1;
            int iCheckValidIntValue2 = chronoField2.checkValidIntValue(map.get(chronoField2).longValue());
            Chronology chronologyFrom2 = Chronology.from(temporalAccessor);
            TemporalUnit temporalUnit = this.rangeUnit;
            ChronoUnit chronoUnit = ChronoUnit.MONTHS;
            if (temporalUnit != chronoUnit) {
                if (temporalUnit != ChronoUnit.YEARS) {
                    throw new IllegalStateException("unreachable");
                }
                long jLongValue = map.remove(this).longValue();
                ChronoLocalDate chronoLocalDateDate3 = chronologyFrom2.date(iCheckValidIntValue2, 1, 1);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    iLocalizedDayOfWeek = localizedDayOfWeek(chronoLocalDateDate3, value);
                    jCheckValidIntValue = jLongValue - localizedWeekOfYear(chronoLocalDateDate3, iLocalizedDayOfWeek);
                    j10 = 7;
                } else {
                    j10 = 7;
                    iLocalizedDayOfWeek = localizedDayOfWeek(chronoLocalDateDate3, value);
                    jCheckValidIntValue = this.range.checkValidIntValue(jLongValue, this) - localizedWeekOfYear(chronoLocalDateDate3, iLocalizedDayOfWeek);
                }
                ChronoLocalDate chronoLocalDatePlus2 = chronoLocalDateDate3.plus((jCheckValidIntValue * j10) + (iFloorMod2 - iLocalizedDayOfWeek), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && chronoLocalDatePlus2.getLong(chronoField2) != map.get(chronoField2).longValue()) {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                map.remove(this);
                map.remove(chronoField2);
                map.remove(chronoField);
                return chronoLocalDatePlus2;
            }
            ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
            if (!map.containsKey(chronoField3)) {
                return null;
            }
            long jLongValue2 = map.remove(this).longValue();
            if (resolverStyle == ResolverStyle.LENIENT) {
                chronoLocalDateDate = chronologyFrom2.date(iCheckValidIntValue2, 1, 1).plus(map.get(chronoField3).longValue() - 1, (TemporalUnit) chronoUnit);
                jCheckValidIntValue2 = ((jLongValue2 - localizedWeekOfMonth(chronoLocalDateDate, localizedDayOfWeek(chronoLocalDateDate, value))) * 7) + (iFloorMod2 - r3);
            } else {
                chronoLocalDateDate = chronologyFrom2.date(iCheckValidIntValue2, chronoField3.checkValidIntValue(map.get(chronoField3).longValue()), 8);
                jCheckValidIntValue2 = (iFloorMod2 - r3) + ((this.range.checkValidIntValue(jLongValue2, this) - localizedWeekOfMonth(chronoLocalDateDate, localizedDayOfWeek(chronoLocalDateDate, value))) * 7);
            }
            ChronoLocalDate chronoLocalDatePlus3 = chronoLocalDateDate.plus(jCheckValidIntValue2, (TemporalUnit) ChronoUnit.DAYS);
            if (resolverStyle == ResolverStyle.STRICT && chronoLocalDatePlus3.getLong(chronoField3) != map.get(chronoField3).longValue()) {
                throw new DateTimeException("Strict mode rejected date parsed to a different month");
            }
            map.remove(this);
            map.remove(chronoField2);
            map.remove(chronoField3);
            map.remove(chronoField);
            return chronoLocalDatePlus3;
        }

        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }

    private WeekFields(DayOfWeek dayOfWeek, int i10) {
        Jdk8Methods.requireNonNull(dayOfWeek, "firstDayOfWeek");
        if (i10 < 1 || i10 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek;
        this.minimalDays = i10;
    }

    public static WeekFields of(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        return of(DayOfWeek.SUNDAY.plus(r4.getFirstDayOfWeek() - 1), new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException e10) {
            throw new InvalidObjectException("Invalid WeekFields" + e10.getMessage());
        }
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WeekFields[");
        sb2.append(this.firstDayOfWeek);
        sb2.append(',');
        return c.l(sb2, this.minimalDays, ']');
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }

    public static WeekFields of(DayOfWeek dayOfWeek, int i10) {
        String str = dayOfWeek.toString() + i10;
        ConcurrentMap<String, WeekFields> concurrentMap = CACHE;
        WeekFields weekFields = concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, i10));
        return concurrentMap.get(str);
    }
}
