package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
public final class HijrahChronology extends Chronology implements Serializable {
    private static final HashMap<String, String[]> ERA_FULL_NAMES;
    private static final HashMap<String, String[]> ERA_NARROW_NAMES;
    private static final HashMap<String, String[]> ERA_SHORT_NAMES;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final HijrahChronology INSTANCE = new HijrahChronology();
    private static final long serialVersionUID = 3127340209035924785L;

    static {
        HashMap<String, String[]> map = new HashMap<>();
        ERA_NARROW_NAMES = map;
        HashMap<String, String[]> map2 = new HashMap<>();
        ERA_SHORT_NAMES = map2;
        HashMap<String, String[]> map3 = new HashMap<>();
        ERA_FULL_NAMES = map3;
        map.put(FALLBACK_LANGUAGE, new String[]{"BH", "HE"});
        map2.put(FALLBACK_LANGUAGE, new String[]{"B.H.", "H.E."});
        map3.put(FALLBACK_LANGUAGE, new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private HijrahChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(HijrahEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "islamic-umalqura";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Hijrah-umalqura";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long j10) {
        return HijrahDate.isLeapYear(j10);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<HijrahDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era era, int i10) {
        if (era instanceof HijrahEra) {
            return era == HijrahEra.AH ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be HijrahEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        return chronoField.range();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate dateEpochDay(long j10) {
        return HijrahDate.of(LocalDate.ofEpochDay(j10));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahEra eraOf(int i10) {
        if (i10 == 0) {
            return HijrahEra.BEFORE_AH;
        }
        if (i10 == 1) {
            return HijrahEra.AH;
        }
        throw new DateTimeException("invalid Hijrah era");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return dateEpochDay(map.remove(chronoField).longValue());
        }
        ChronoField chronoField2 = ChronoField.PROLEPTIC_MONTH;
        Long lRemove = map.remove(chronoField2);
        if (lRemove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField2.checkValidValue(lRemove.longValue());
            }
            updateResolveMap(map, ChronoField.MONTH_OF_YEAR, Jdk8Methods.floorMod(lRemove.longValue(), 12) + 1);
            updateResolveMap(map, ChronoField.YEAR, Jdk8Methods.floorDiv(lRemove.longValue(), 12L));
        }
        ChronoField chronoField3 = ChronoField.YEAR_OF_ERA;
        Long lRemove2 = map.remove(chronoField3);
        if (lRemove2 != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField3.checkValidValue(lRemove2.longValue());
            }
            Long lRemove3 = map.remove(ChronoField.ERA);
            if (lRemove3 == null) {
                ChronoField chronoField4 = ChronoField.YEAR;
                Long l10 = map.get(chronoField4);
                if (resolverStyle != ResolverStyle.STRICT) {
                    updateResolveMap(map, chronoField4, (l10 == null || l10.longValue() > 0) ? lRemove2.longValue() : Jdk8Methods.safeSubtract(1L, lRemove2.longValue()));
                } else if (l10 != null) {
                    updateResolveMap(map, chronoField4, l10.longValue() > 0 ? lRemove2.longValue() : Jdk8Methods.safeSubtract(1L, lRemove2.longValue()));
                } else {
                    map.put(chronoField3, lRemove2);
                }
            } else if (lRemove3.longValue() == 1) {
                updateResolveMap(map, ChronoField.YEAR, lRemove2.longValue());
            } else {
                if (lRemove3.longValue() != 0) {
                    throw new DateTimeException("Invalid value for era: " + lRemove3);
                }
                updateResolveMap(map, ChronoField.YEAR, Jdk8Methods.safeSubtract(1L, lRemove2.longValue()));
            }
        } else {
            ChronoField chronoField5 = ChronoField.ERA;
            if (map.containsKey(chronoField5)) {
                chronoField5.checkValidValue(map.get(chronoField5).longValue());
            }
        }
        ChronoField chronoField6 = ChronoField.YEAR;
        if (!map.containsKey(chronoField6)) {
            return null;
        }
        ChronoField chronoField7 = ChronoField.MONTH_OF_YEAR;
        if (map.containsKey(chronoField7)) {
            ChronoField chronoField8 = ChronoField.DAY_OF_MONTH;
            if (map.containsKey(chronoField8)) {
                int iCheckValidIntValue = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return date(iCheckValidIntValue, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1L)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField8).longValue(), 1L));
                }
                int iCheckValidIntValue2 = range(chronoField7).checkValidIntValue(map.remove(chronoField7).longValue(), chronoField7);
                int iCheckValidIntValue3 = range(chronoField8).checkValidIntValue(map.remove(chronoField8).longValue(), chronoField8);
                if (resolverStyle == ResolverStyle.SMART && iCheckValidIntValue3 > 28) {
                    iCheckValidIntValue3 = Math.min(iCheckValidIntValue3, date(iCheckValidIntValue, iCheckValidIntValue2, 1).lengthOfMonth());
                }
                return date(iCheckValidIntValue, iCheckValidIntValue2, iCheckValidIntValue3);
            }
            ChronoField chronoField9 = ChronoField.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(chronoField9)) {
                ChronoField chronoField10 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(chronoField10)) {
                    int iCheckValidIntValue4 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(iCheckValidIntValue4, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField10).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int iCheckValidIntValue5 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    HijrahDate hijrahDatePlus = date(iCheckValidIntValue4, iCheckValidIntValue5, 1).plus((chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1) + ((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                    if (resolverStyle != ResolverStyle.STRICT || hijrahDatePlus.get(chronoField7) == iCheckValidIntValue5) {
                        return hijrahDatePlus;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
                ChronoField chronoField11 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField11)) {
                    int iCheckValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(iCheckValidIntValue6, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField11).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int iCheckValidIntValue7 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    HijrahDate hijrahDateWith = date(iCheckValidIntValue6, iCheckValidIntValue7, 1).plus(chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1, (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || hijrahDateWith.get(chronoField7) == iCheckValidIntValue7) {
                        return hijrahDateWith;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        ChronoField chronoField12 = ChronoField.DAY_OF_YEAR;
        if (map.containsKey(chronoField12)) {
            int iCheckValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return dateYearDay(iCheckValidIntValue8, 1).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1L));
            }
            return dateYearDay(iCheckValidIntValue8, chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()));
        }
        ChronoField chronoField13 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(chronoField13)) {
            return null;
        }
        ChronoField chronoField14 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(chronoField14)) {
            int iCheckValidIntValue9 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return date(iCheckValidIntValue9, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField14).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
            }
            HijrahDate hijrahDatePlusDays = date(iCheckValidIntValue9, 1, 1).plusDays((chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1) + ((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7));
            if (resolverStyle != ResolverStyle.STRICT || hijrahDatePlusDays.get(chronoField6) == iCheckValidIntValue9) {
                return hijrahDatePlusDays;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField15 = ChronoField.DAY_OF_WEEK;
        if (!map.containsKey(chronoField15)) {
            return null;
        }
        int iCheckValidIntValue10 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return date(iCheckValidIntValue10, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField15).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        HijrahDate hijrahDateWith2 = date(iCheckValidIntValue10, 1, 1).plus(chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1, (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || hijrahDateWith2.get(chronoField6) == iCheckValidIntValue10) {
            return hijrahDateWith2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate dateYearDay(Era era, int i10, int i11) {
        return (HijrahDate) super.dateYearDay(era, i10, i11);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate date(Era era, int i10, int i11, int i12) {
        return (HijrahDate) super.date(era, i10, i11, i12);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate dateNow() {
        return (HijrahDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate dateYearDay(int i10, int i11) {
        return HijrahDate.of(i10, 1, 1).plusDays(i11 - 1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate date(int i10, int i11, int i12) {
        return HijrahDate.of(i10, i11, i12);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate dateNow(ZoneId zoneId) {
        return (HijrahDate) super.dateNow(zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof HijrahDate) {
            return (HijrahDate) temporalAccessor;
        }
        return HijrahDate.ofEpochDay(temporalAccessor.getLong(ChronoField.EPOCH_DAY));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public HijrahDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return (HijrahDate) super.dateNow(clock);
    }
}
