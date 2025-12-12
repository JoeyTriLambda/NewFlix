package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology INSTANCE = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    private IsoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "ISO";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long j10) {
        return (3 & j10) == 0 && (j10 % 100 != 0 || j10 % 400 == 0);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era era, int i10) {
        if (era instanceof IsoEra) {
            return era == IsoEra.CE ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be IsoEra");
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
    public LocalDate dateEpochDay(long j10) {
        return LocalDate.ofEpochDay(j10);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public IsoEra eraOf(int i10) {
        return IsoEra.of(i10);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return LocalDate.ofEpochDay(map.remove(chronoField).longValue());
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
                int iSafeToInt = Jdk8Methods.safeToInt(map.remove(chronoField7).longValue());
                int iSafeToInt2 = Jdk8Methods.safeToInt(map.remove(chronoField8).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return LocalDate.of(iCheckValidIntValue, 1, 1).plusMonths(Jdk8Methods.safeSubtract(iSafeToInt, 1)).plusDays(Jdk8Methods.safeSubtract(iSafeToInt2, 1));
                }
                if (resolverStyle != ResolverStyle.SMART) {
                    return LocalDate.of(iCheckValidIntValue, iSafeToInt, iSafeToInt2);
                }
                chronoField8.checkValidValue(iSafeToInt2);
                if (iSafeToInt == 4 || iSafeToInt == 6 || iSafeToInt == 9 || iSafeToInt == 11) {
                    iSafeToInt2 = Math.min(iSafeToInt2, 30);
                } else if (iSafeToInt == 2) {
                    iSafeToInt2 = Math.min(iSafeToInt2, Month.FEBRUARY.length(Year.isLeap(iCheckValidIntValue)));
                }
                return LocalDate.of(iCheckValidIntValue, iSafeToInt, iSafeToInt2);
            }
            ChronoField chronoField9 = ChronoField.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(chronoField9)) {
                ChronoField chronoField10 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(chronoField10)) {
                    int iCheckValidIntValue2 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return LocalDate.of(iCheckValidIntValue2, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1L)).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1L)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField10).longValue(), 1L));
                    }
                    int iCheckValidIntValue3 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    LocalDate localDatePlusDays = LocalDate.of(iCheckValidIntValue2, iCheckValidIntValue3, 1).plusDays((chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()) - 1) + ((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) * 7));
                    if (resolverStyle != ResolverStyle.STRICT || localDatePlusDays.get(chronoField7) == iCheckValidIntValue3) {
                        return localDatePlusDays;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
                ChronoField chronoField11 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField11)) {
                    int iCheckValidIntValue4 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return LocalDate.of(iCheckValidIntValue4, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1L)).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1L)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField11).longValue(), 1L));
                    }
                    int iCheckValidIntValue5 = chronoField7.checkValidIntValue(map.remove(chronoField7).longValue());
                    LocalDate localDateWith = LocalDate.of(iCheckValidIntValue4, iCheckValidIntValue5, 1).plusWeeks(chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || localDateWith.get(chronoField7) == iCheckValidIntValue5) {
                        return localDateWith;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        ChronoField chronoField12 = ChronoField.DAY_OF_YEAR;
        if (map.containsKey(chronoField12)) {
            int iCheckValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.ofYearDay(iCheckValidIntValue6, 1).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1L));
            }
            return LocalDate.ofYearDay(iCheckValidIntValue6, chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()));
        }
        ChronoField chronoField13 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(chronoField13)) {
            return null;
        }
        ChronoField chronoField14 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(chronoField14)) {
            int iCheckValidIntValue7 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.of(iCheckValidIntValue7, 1, 1).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1L)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField14).longValue(), 1L));
            }
            LocalDate localDatePlusDays2 = LocalDate.of(iCheckValidIntValue7, 1, 1).plusDays((chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()) - 1) + ((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) * 7));
            if (resolverStyle != ResolverStyle.STRICT || localDatePlusDays2.get(chronoField6) == iCheckValidIntValue7) {
                return localDatePlusDays2;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField15 = ChronoField.DAY_OF_WEEK;
        if (!map.containsKey(chronoField15)) {
            return null;
        }
        int iCheckValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return LocalDate.of(iCheckValidIntValue8, 1, 1).plusWeeks(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1L)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField15).longValue(), 1L));
        }
        LocalDate localDateWith2 = LocalDate.of(iCheckValidIntValue8, 1, 1).plusWeeks(chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField15.checkValidIntValue(map.remove(chronoField15).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || localDateWith2.get(chronoField6) == iCheckValidIntValue8) {
            return localDateWith2;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateYearDay(Era era, int i10, int i11) {
        return dateYearDay(prolepticYear(era, i10), i11);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        return ZonedDateTime.from(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(Era era, int i10, int i11, int i12) {
        return date(prolepticYear(era, i10), i11, i12);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateYearDay(int i10, int i11) {
        return LocalDate.ofYearDay(i10, i11);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(int i10, int i11, int i12) {
        return LocalDate.of(i10, i11, i12);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate date(TemporalAccessor temporalAccessor) {
        return LocalDate.from(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public LocalDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return date((TemporalAccessor) LocalDate.now(clock));
    }
}
