package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes2.dex */
public final class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;

    /* renamed from: org.threeten.bp.temporal.IsoFields$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum Field implements TemporalField {
        DAY_OF_QUARTER { // from class: org.threeten.bp.temporal.IsoFields.Field.1
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return (R) r10.with(chronoField, (j10 - from) + r10.getLong(chronoField));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return ChronoUnit.DAYS;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.isSupported(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j10 = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                if (j10 == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                return j10 == 2 ? ValueRange.of(1L, 91L) : (j10 == 3 || j10 == 4) ? ValueRange.of(1L, 92L) : range();
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDatePlusDays;
                ChronoField chronoField = ChronoField.YEAR;
                Long l10 = map.get(chronoField);
                TemporalField temporalField = Field.QUARTER_OF_YEAR;
                Long l11 = map.get(temporalField);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int iCheckValidIntValue = chronoField.checkValidIntValue(l10.longValue());
                long jLongValue = map.get(Field.DAY_OF_QUARTER).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    localDatePlusDays = LocalDate.of(iCheckValidIntValue, 1, 1).plusMonths(Jdk8Methods.safeMultiply(Jdk8Methods.safeSubtract(l11.longValue(), 1L), 3)).plusDays(Jdk8Methods.safeSubtract(jLongValue, 1L));
                } else {
                    int iCheckValidIntValue2 = temporalField.range().checkValidIntValue(l11.longValue(), temporalField);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i10 = 91;
                        if (iCheckValidIntValue2 == 1) {
                            if (!IsoChronology.INSTANCE.isLeapYear(iCheckValidIntValue)) {
                                i10 = 90;
                            }
                        } else if (iCheckValidIntValue2 != 2) {
                            i10 = 92;
                        }
                        ValueRange.of(1L, i10).checkValidValue(jLongValue, this);
                    } else {
                        range().checkValidValue(jLongValue, this);
                    }
                    localDatePlusDays = LocalDate.of(iCheckValidIntValue, ((iCheckValidIntValue2 - 1) * 3) + 1, 1).plusDays(jLongValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(temporalField);
                return localDatePlusDays;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.2
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return (R) r10.with(chronoField, ((j10 - from) * 3) + r10.getLong(chronoField));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return ChronoUnit.YEARS;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.3
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                range().checkValidValue(j10, this);
                return (R) r10.plus(Jdk8Methods.safeSubtract(j10, getFrom(r10)), ChronoUnit.WEEKS);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return ChronoUnit.WEEKS;
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public String getDisplayName(Locale locale) {
                Jdk8Methods.requireNonNull(locale, "locale");
                return "Week";
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeek(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeekRange(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                TemporalField temporalField;
                LocalDate localDateWith;
                long j10;
                TemporalField temporalField2 = Field.WEEK_BASED_YEAR;
                Long l10 = map.get(temporalField2);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l11 = map.get(chronoField);
                if (l10 == null || l11 == null) {
                    return null;
                }
                int iCheckValidIntValue = temporalField2.range().checkValidIntValue(l10.longValue(), temporalField2);
                long jLongValue = map.get(Field.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long jLongValue2 = l11.longValue();
                    if (jLongValue2 > 7) {
                        long j11 = jLongValue2 - 1;
                        j10 = j11 / 7;
                        jLongValue2 = (j11 % 7) + 1;
                    } else if (jLongValue2 < 1) {
                        j10 = (jLongValue2 / 7) - 1;
                        jLongValue2 = (jLongValue2 % 7) + 7;
                    } else {
                        j10 = 0;
                    }
                    temporalField = temporalField2;
                    localDateWith = LocalDate.of(iCheckValidIntValue, 1, 4).plusWeeks(jLongValue - 1).plusWeeks(j10).with((TemporalField) chronoField, jLongValue2);
                } else {
                    temporalField = temporalField2;
                    int iCheckValidIntValue2 = chronoField.checkValidIntValue(l11.longValue());
                    if (resolverStyle == ResolverStyle.STRICT) {
                        Field.getWeekRange(LocalDate.of(iCheckValidIntValue, 1, 4)).checkValidValue(jLongValue, this);
                    } else {
                        range().checkValidValue(jLongValue, this);
                    }
                    localDateWith = LocalDate.of(iCheckValidIntValue, 1, 4).plusWeeks(jLongValue - 1).with((TemporalField) chronoField, iCheckValidIntValue2);
                }
                map.remove(this);
                map.remove(temporalField);
                map.remove(chronoField);
                return localDateWith;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.4
            @Override // org.threeten.bp.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                if (!isSupportedBy(r10)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int iCheckValidIntValue = range().checkValidIntValue(j10, Field.WEEK_BASED_YEAR);
                LocalDate localDateFrom = LocalDate.from((TemporalAccessor) r10);
                int i10 = localDateFrom.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(localDateFrom);
                if (week == 53 && Field.getWeekRange(iCheckValidIntValue) == 52) {
                    week = 52;
                }
                return (R) r10.with(LocalDate.of(iCheckValidIntValue, 1, 4).plusDays(((week - 1) * 7) + (i10 - r6.get(r0))));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.isSupported(this)) {
                    return Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return ChronoUnit.FOREVER;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                return ChronoField.YEAR.range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        };

        private static final int[] QUARTER_DAYS = {0, 90, 181, 273, 0, 91, 182, 274};

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeek(LocalDate localDate) {
            int iOrdinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i10 = (3 - iOrdinal) + dayOfYear;
            int i11 = (i10 - ((i10 / 7) * 7)) - 3;
            if (i11 < -3) {
                i11 += 7;
            }
            if (dayOfYear < i11) {
                return (int) getWeekRange(localDate.withDayOfYear(180).minusYears(1L)).getMaximum();
            }
            int i12 = ((dayOfYear - i11) / 7) + 1;
            if (i12 == 53) {
                if (!(i11 == -3 || (i11 == -2 && localDate.isLeapYear()))) {
                    return 1;
                }
            }
            return i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            }
            return year;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isIso(TemporalAccessor temporalAccessor) {
            return Chronology.from(temporalAccessor).equals(IsoChronology.INSTANCE);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale locale) {
            Jdk8Methods.requireNonNull(locale, "locale");
            return toString();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return null;
        }

        /* synthetic */ Field(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int i10) {
            LocalDate localDateOf = LocalDate.of(i10, 1, 1);
            if (localDateOf.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (localDateOf.getDayOfWeek() == DayOfWeek.WEDNESDAY && localDateOf.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }
    }

    public enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        Unit(String str, Duration duration) {
            this.name = str;
            this.duration = duration;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r10, long j10) {
            int i10 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (i10 == 1) {
                return (R) r10.with(IsoFields.WEEK_BASED_YEAR, Jdk8Methods.safeAdd(r10.get(r0), j10));
            }
            if (i10 == 2) {
                return (R) r10.plus(j10 / 256, ChronoUnit.YEARS).plus((j10 % 256) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public long between(Temporal temporal, Temporal temporal2) {
            int i10 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (i10 == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return Jdk8Methods.safeSubtract(temporal2.getLong(temporalField), temporal.getLong(temporalField));
            }
            if (i10 == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public Duration getDuration() {
            return this.duration;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isSupportedBy(Temporal temporal) {
            return temporal.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        @Override // java.lang.Enum, org.threeten.bp.temporal.TemporalUnit
        public String toString() {
            return this.name;
        }
    }

    private IsoFields() {
        throw new AssertionError("Not instantiable");
    }
}
