package org.threeten.bp.chrono;

import ac.c;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
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
public final class JapaneseChronology extends Chronology implements Serializable {
    private static final Map<String, String[]> ERA_FULL_NAMES;
    private static final Map<String, String[]> ERA_NARROW_NAMES;
    private static final Map<String, String[]> ERA_SHORT_NAMES;
    private static final String FALLBACK_LANGUAGE = "en";
    private static final long serialVersionUID = 459996390165777884L;
    private static final String TARGET_LANGUAGE = "ja";
    static final Locale LOCALE = new Locale(TARGET_LANGUAGE, "JP", "JP");
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();

    /* renamed from: org.threeten.bp.chrono.JapaneseChronology$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_DAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_AMPM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_HOUR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_DAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_MINUTE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_DAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_SECOND.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    static {
        HashMap map = new HashMap();
        ERA_NARROW_NAMES = map;
        HashMap map2 = new HashMap();
        ERA_SHORT_NAMES = map2;
        HashMap map3 = new HashMap();
        ERA_FULL_NAMES = map3;
        map.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        map.put(TARGET_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        map2.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        map2.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        map3.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        map3.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private JapaneseDate resolveEYD(Map<TemporalField, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i10) {
        if (resolverStyle != ResolverStyle.LENIENT) {
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            return dateYearDay((Era) japaneseEra, i10, range(chronoField).checkValidIntValue(map.remove(chronoField).longValue(), chronoField));
        }
        int year = (japaneseEra.startDate().getYear() + i10) - 1;
        return dateYearDay(year, 1).plus(Jdk8Methods.safeSubtract(map.remove(ChronoField.DAY_OF_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
    }

    private JapaneseDate resolveEYMD(Map<TemporalField, Long> map, ResolverStyle resolverStyle, JapaneseEra japaneseEra, int i10) {
        if (resolverStyle == ResolverStyle.LENIENT) {
            int year = (japaneseEra.startDate().getYear() + i10) - 1;
            return date(year, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        int iCheckValidIntValue = range(chronoField).checkValidIntValue(map.remove(chronoField).longValue(), chronoField);
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        int iCheckValidIntValue2 = range(chronoField2).checkValidIntValue(map.remove(chronoField2).longValue(), chronoField2);
        if (resolverStyle != ResolverStyle.SMART) {
            return date((Era) japaneseEra, i10, iCheckValidIntValue, iCheckValidIntValue2);
        }
        if (i10 < 1) {
            throw new DateTimeException(c.f("Invalid YearOfEra: ", i10));
        }
        int year2 = (japaneseEra.startDate().getYear() + i10) - 1;
        if (iCheckValidIntValue2 > 28) {
            iCheckValidIntValue2 = Math.min(iCheckValidIntValue2, date(year2, iCheckValidIntValue, 1).lengthOfMonth());
        }
        JapaneseDate japaneseDateDate = date(year2, iCheckValidIntValue, iCheckValidIntValue2);
        if (japaneseDateDate.getEra() != japaneseEra) {
            if (Math.abs(japaneseDateDate.getEra().getValue() - japaneseEra.getValue()) > 1) {
                throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + StringUtils.SPACE + i10);
            }
            if (japaneseDateDate.get(ChronoField.YEAR_OF_ERA) != 1 && i10 != 1) {
                throw new DateTimeException("Invalid Era/YearOfEra: " + japaneseEra + StringUtils.SPACE + i10);
            }
        }
        return japaneseDateDate;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long j10) {
        return IsoChronology.INSTANCE.isLeapYear(j10);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<JapaneseDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era era, int i10) {
        if (!(era instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int year = (((JapaneseEra) era).startDate().getYear() + i10) - 1;
        ValueRange.of(1L, (r6.endDate().getYear() - r6.startDate().getYear()) + 1).checkValidValue(i10, ChronoField.YEAR_OF_ERA);
        return year;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        int[] iArr = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField;
        switch (iArr[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return chronoField.range();
            default:
                Calendar calendar = Calendar.getInstance(LOCALE);
                int i10 = 0;
                switch (iArr[chronoField.ordinal()]) {
                    case 19:
                        JapaneseEra[] japaneseEraArrValues = JapaneseEra.values();
                        return ValueRange.of(japaneseEraArrValues[0].getValue(), japaneseEraArrValues[japaneseEraArrValues.length - 1].getValue());
                    case 20:
                        JapaneseEra[] japaneseEraArrValues2 = JapaneseEra.values();
                        return ValueRange.of(JapaneseDate.MIN_DATE.getYear(), japaneseEraArrValues2[japaneseEraArrValues2.length - 1].endDate().getYear());
                    case 21:
                        JapaneseEra[] japaneseEraArrValues3 = JapaneseEra.values();
                        int year = (japaneseEraArrValues3[japaneseEraArrValues3.length - 1].endDate().getYear() - japaneseEraArrValues3[japaneseEraArrValues3.length - 1].startDate().getYear()) + 1;
                        int iMin = Integer.MAX_VALUE;
                        while (i10 < japaneseEraArrValues3.length) {
                            iMin = Math.min(iMin, (japaneseEraArrValues3[i10].endDate().getYear() - japaneseEraArrValues3[i10].startDate().getYear()) + 1);
                            i10++;
                        }
                        return ValueRange.of(1L, 6L, iMin, year);
                    case 22:
                        return ValueRange.of(calendar.getMinimum(2) + 1, calendar.getGreatestMinimum(2) + 1, calendar.getLeastMaximum(2) + 1, calendar.getMaximum(2) + 1);
                    case 23:
                        JapaneseEra[] japaneseEraArrValues4 = JapaneseEra.values();
                        int iMin2 = 366;
                        while (i10 < japaneseEraArrValues4.length) {
                            iMin2 = Math.min(iMin2, (japaneseEraArrValues4[i10].startDate().lengthOfYear() - japaneseEraArrValues4[i10].startDate().getDayOfYear()) + 1);
                            i10++;
                        }
                        return ValueRange.of(1L, iMin2, 366L);
                    default:
                        throw new UnsupportedOperationException("Unimplementable field: " + chronoField);
                }
        }
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateEpochDay(long j10) {
        return new JapaneseDate(LocalDate.ofEpochDay(j10));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseEra eraOf(int i10) {
        return JapaneseEra.of(i10);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
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
        ChronoField chronoField3 = ChronoField.ERA;
        Long l10 = map.get(chronoField3);
        JapaneseEra japaneseEraEraOf = l10 != null ? eraOf(range(chronoField3).checkValidIntValue(l10.longValue(), chronoField3)) : null;
        ChronoField chronoField4 = ChronoField.YEAR_OF_ERA;
        Long l11 = map.get(chronoField4);
        if (l11 != null) {
            int iCheckValidIntValue = range(chronoField4).checkValidIntValue(l11.longValue(), chronoField4);
            if (japaneseEraEraOf == null && resolverStyle != ResolverStyle.STRICT && !map.containsKey(ChronoField.YEAR)) {
                List<Era> listEras = eras();
                japaneseEraEraOf = (JapaneseEra) listEras.get(listEras.size() - 1);
            }
            if (japaneseEraEraOf != null && map.containsKey(ChronoField.MONTH_OF_YEAR) && map.containsKey(ChronoField.DAY_OF_MONTH)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return resolveEYMD(map, resolverStyle, japaneseEraEraOf, iCheckValidIntValue);
            }
            if (japaneseEraEraOf != null && map.containsKey(ChronoField.DAY_OF_YEAR)) {
                map.remove(chronoField3);
                map.remove(chronoField4);
                return resolveEYD(map, resolverStyle, japaneseEraEraOf, iCheckValidIntValue);
            }
        }
        ChronoField chronoField5 = ChronoField.YEAR;
        if (map.containsKey(chronoField5)) {
            ChronoField chronoField6 = ChronoField.MONTH_OF_YEAR;
            if (map.containsKey(chronoField6)) {
                ChronoField chronoField7 = ChronoField.DAY_OF_MONTH;
                if (map.containsKey(chronoField7)) {
                    int iCheckValidIntValue2 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(iCheckValidIntValue2, 1, 1).plusMonths(Jdk8Methods.safeSubtract(map.remove(chronoField6).longValue(), 1L)).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField7).longValue(), 1L));
                    }
                    int iCheckValidIntValue3 = range(chronoField6).checkValidIntValue(map.remove(chronoField6).longValue(), chronoField6);
                    int iCheckValidIntValue4 = range(chronoField7).checkValidIntValue(map.remove(chronoField7).longValue(), chronoField7);
                    if (resolverStyle == ResolverStyle.SMART && iCheckValidIntValue4 > 28) {
                        iCheckValidIntValue4 = Math.min(iCheckValidIntValue4, date(iCheckValidIntValue2, iCheckValidIntValue3, 1).lengthOfMonth());
                    }
                    return date(iCheckValidIntValue2, iCheckValidIntValue3, iCheckValidIntValue4);
                }
                ChronoField chronoField8 = ChronoField.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(chronoField8)) {
                    ChronoField chronoField9 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(chronoField9)) {
                        int iCheckValidIntValue5 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return date(iCheckValidIntValue5, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField6).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField8).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField9).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int iCheckValidIntValue6 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        JapaneseDate japaneseDatePlus = date(iCheckValidIntValue5, iCheckValidIntValue6, 1).plus((chronoField9.checkValidIntValue(map.remove(chronoField9).longValue()) - 1) + ((chronoField8.checkValidIntValue(map.remove(chronoField8).longValue()) - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                        if (resolverStyle != ResolverStyle.STRICT || japaneseDatePlus.get(chronoField6) == iCheckValidIntValue6) {
                            return japaneseDatePlus;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                    ChronoField chronoField10 = ChronoField.DAY_OF_WEEK;
                    if (map.containsKey(chronoField10)) {
                        int iCheckValidIntValue7 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return date(iCheckValidIntValue7, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField6).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField8).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField10).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int iCheckValidIntValue8 = chronoField6.checkValidIntValue(map.remove(chronoField6).longValue());
                        JapaneseDate japaneseDateWith = date(iCheckValidIntValue7, iCheckValidIntValue8, 1).plus(chronoField8.checkValidIntValue(map.remove(chronoField8).longValue()) - 1, (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField10.checkValidIntValue(map.remove(chronoField10).longValue()))));
                        if (resolverStyle != ResolverStyle.STRICT || japaneseDateWith.get(chronoField6) == iCheckValidIntValue8) {
                            return japaneseDateWith;
                        }
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                }
            }
            ChronoField chronoField11 = ChronoField.DAY_OF_YEAR;
            if (map.containsKey(chronoField11)) {
                int iCheckValidIntValue9 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return dateYearDay(iCheckValidIntValue9, 1).plusDays(Jdk8Methods.safeSubtract(map.remove(chronoField11).longValue(), 1L));
                }
                return dateYearDay(iCheckValidIntValue9, chronoField11.checkValidIntValue(map.remove(chronoField11).longValue()));
            }
            ChronoField chronoField12 = ChronoField.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(chronoField12)) {
                ChronoField chronoField13 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(chronoField13)) {
                    int iCheckValidIntValue10 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(iCheckValidIntValue10, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField13).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    JapaneseDate japaneseDatePlusDays = date(iCheckValidIntValue10, 1, 1).plusDays((chronoField13.checkValidIntValue(map.remove(chronoField13).longValue()) - 1) + ((chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()) - 1) * 7));
                    if (resolverStyle != ResolverStyle.STRICT || japaneseDatePlusDays.get(chronoField5) == iCheckValidIntValue10) {
                        return japaneseDatePlusDays;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                ChronoField chronoField14 = ChronoField.DAY_OF_WEEK;
                if (map.containsKey(chronoField14)) {
                    int iCheckValidIntValue11 = chronoField5.checkValidIntValue(map.remove(chronoField5).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return date(iCheckValidIntValue11, 1, 1).plus(Jdk8Methods.safeSubtract(map.remove(chronoField12).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(map.remove(chronoField14).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    JapaneseDate japaneseDateWith2 = date(iCheckValidIntValue11, 1, 1).plus(chronoField12.checkValidIntValue(map.remove(chronoField12).longValue()) - 1, (TemporalUnit) ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(chronoField14.checkValidIntValue(map.remove(chronoField14).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || japaneseDateWith2.get(chronoField5) == iCheckValidIntValue11) {
                        return japaneseDateWith2;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        return null;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateYearDay(Era era, int i10, int i11) {
        if (era instanceof JapaneseEra) {
            return JapaneseDate.ofYearDay((JapaneseEra) era, i10, i11);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate date(Era era, int i10, int i11, int i12) {
        if (era instanceof JapaneseEra) {
            return JapaneseDate.of((JapaneseEra) era, i10, i11, i12);
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateNow() {
        return (JapaneseDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateNow(ZoneId zoneId) {
        return (JapaneseDate) super.dateNow(zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateNow(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        return (JapaneseDate) super.dateNow(clock);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateYearDay(int i10, int i11) {
        LocalDate localDateOfYearDay = LocalDate.ofYearDay(i10, i11);
        return date(i10, localDateOfYearDay.getMonthValue(), localDateOfYearDay.getDayOfMonth());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate date(int i10, int i11, int i12) {
        return new JapaneseDate(LocalDate.of(i10, i11, i12));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof JapaneseDate) {
            return (JapaneseDate) temporalAccessor;
        }
        return new JapaneseDate(LocalDate.from(temporalAccessor));
    }
}
