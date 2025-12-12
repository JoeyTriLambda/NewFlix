package org.threeten.bp.format;

import ac.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o1.a;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* loaded from: classes2.dex */
final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements Cloneable {
    Chronology chrono;
    ChronoLocalDate date;
    Period excessDays;
    final Map<TemporalField, Long> fieldValues = new HashMap();
    boolean leapSecond;
    LocalTime time;
    ZoneId zone;

    public DateTimeBuilder() {
    }

    private void checkDate(LocalDate localDate) {
        if (localDate != null) {
            addObject(localDate);
            for (TemporalField temporalField : this.fieldValues.keySet()) {
                if ((temporalField instanceof ChronoField) && temporalField.isDateBased()) {
                    try {
                        long j10 = localDate.getLong(temporalField);
                        Long l10 = this.fieldValues.get(temporalField);
                        if (j10 != l10.longValue()) {
                            throw new DateTimeException("Conflict found: Field " + temporalField + StringUtils.SPACE + j10 + " differs from " + temporalField + StringUtils.SPACE + l10 + " derived from " + localDate);
                        }
                    } catch (DateTimeException unused) {
                    }
                }
            }
        }
    }

    private void crossCheck() {
        LocalTime localTime;
        if (this.fieldValues.size() > 0) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null && (localTime = this.time) != null) {
                crossCheck(chronoLocalDate.atTime(localTime));
                return;
            }
            if (chronoLocalDate != null) {
                crossCheck(chronoLocalDate);
                return;
            }
            TemporalAccessor temporalAccessor = this.time;
            if (temporalAccessor != null) {
                crossCheck(temporalAccessor);
            }
        }
    }

    private Long getFieldValue0(TemporalField temporalField) {
        return this.fieldValues.get(temporalField);
    }

    private void mergeDate(ResolverStyle resolverStyle) {
        if (this.chrono instanceof IsoChronology) {
            checkDate(IsoChronology.INSTANCE.resolveDate(this.fieldValues, resolverStyle));
            return;
        }
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            checkDate(LocalDate.ofEpochDay(this.fieldValues.remove(chronoField).longValue()));
        }
    }

    private void mergeInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.zone;
            if (zoneId != null) {
                mergeInstantFields0(zoneId);
                return;
            }
            Long l10 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
            if (l10 != null) {
                mergeInstantFields0(ZoneOffset.ofTotalSeconds(l10.intValue()));
            }
        }
    }

    private void mergeInstantFields0(ZoneId zoneId) {
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        ChronoZonedDateTime<?> chronoZonedDateTimeZonedDateTime = this.chrono.zonedDateTime(Instant.ofEpochSecond(map.remove(chronoField).longValue()), zoneId);
        if (this.date == null) {
            addObject(chronoZonedDateTimeZonedDateTime.toLocalDate());
        } else {
            resolveMakeChanges(chronoField, chronoZonedDateTimeZonedDateTime.toLocalDate());
        }
        addFieldValue(ChronoField.SECOND_OF_DAY, chronoZonedDateTimeZonedDateTime.toLocalTime().toSecondOfDay());
    }

    private void mergeTime(ResolverStyle resolverStyle) {
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.CLOCK_HOUR_OF_DAY;
        if (map.containsKey(chronoField)) {
            long jLongValue = this.fieldValues.remove(chronoField).longValue();
            if (resolverStyle != ResolverStyle.LENIENT && (resolverStyle != ResolverStyle.SMART || jLongValue != 0)) {
                chronoField.checkValidValue(jLongValue);
            }
            ChronoField chronoField2 = ChronoField.HOUR_OF_DAY;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            addFieldValue(chronoField2, jLongValue);
        }
        Map<TemporalField, Long> map2 = this.fieldValues;
        ChronoField chronoField3 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(chronoField3)) {
            long jLongValue2 = this.fieldValues.remove(chronoField3).longValue();
            if (resolverStyle != ResolverStyle.LENIENT && (resolverStyle != ResolverStyle.SMART || jLongValue2 != 0)) {
                chronoField3.checkValidValue(jLongValue2);
            }
            addFieldValue(ChronoField.HOUR_OF_AMPM, jLongValue2 != 12 ? jLongValue2 : 0L);
        }
        ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map3 = this.fieldValues;
            ChronoField chronoField4 = ChronoField.AMPM_OF_DAY;
            if (map3.containsKey(chronoField4)) {
                chronoField4.checkValidValue(this.fieldValues.get(chronoField4).longValue());
            }
            Map<TemporalField, Long> map4 = this.fieldValues;
            ChronoField chronoField5 = ChronoField.HOUR_OF_AMPM;
            if (map4.containsKey(chronoField5)) {
                chronoField5.checkValidValue(this.fieldValues.get(chronoField5).longValue());
            }
        }
        Map<TemporalField, Long> map5 = this.fieldValues;
        ChronoField chronoField6 = ChronoField.AMPM_OF_DAY;
        if (map5.containsKey(chronoField6)) {
            Map<TemporalField, Long> map6 = this.fieldValues;
            ChronoField chronoField7 = ChronoField.HOUR_OF_AMPM;
            if (map6.containsKey(chronoField7)) {
                addFieldValue(ChronoField.HOUR_OF_DAY, (this.fieldValues.remove(chronoField6).longValue() * 12) + this.fieldValues.remove(chronoField7).longValue());
            }
        }
        Map<TemporalField, Long> map7 = this.fieldValues;
        ChronoField chronoField8 = ChronoField.NANO_OF_DAY;
        if (map7.containsKey(chronoField8)) {
            long jLongValue3 = this.fieldValues.remove(chronoField8).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField8.checkValidValue(jLongValue3);
            }
            addFieldValue(ChronoField.SECOND_OF_DAY, jLongValue3 / 1000000000);
            addFieldValue(ChronoField.NANO_OF_SECOND, jLongValue3 % 1000000000);
        }
        Map<TemporalField, Long> map8 = this.fieldValues;
        ChronoField chronoField9 = ChronoField.MICRO_OF_DAY;
        if (map8.containsKey(chronoField9)) {
            long jLongValue4 = this.fieldValues.remove(chronoField9).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField9.checkValidValue(jLongValue4);
            }
            addFieldValue(ChronoField.SECOND_OF_DAY, jLongValue4 / 1000000);
            addFieldValue(ChronoField.MICRO_OF_SECOND, jLongValue4 % 1000000);
        }
        Map<TemporalField, Long> map9 = this.fieldValues;
        ChronoField chronoField10 = ChronoField.MILLI_OF_DAY;
        if (map9.containsKey(chronoField10)) {
            long jLongValue5 = this.fieldValues.remove(chronoField10).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField10.checkValidValue(jLongValue5);
            }
            addFieldValue(ChronoField.SECOND_OF_DAY, jLongValue5 / 1000);
            addFieldValue(ChronoField.MILLI_OF_SECOND, jLongValue5 % 1000);
        }
        Map<TemporalField, Long> map10 = this.fieldValues;
        ChronoField chronoField11 = ChronoField.SECOND_OF_DAY;
        if (map10.containsKey(chronoField11)) {
            long jLongValue6 = this.fieldValues.remove(chronoField11).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField11.checkValidValue(jLongValue6);
            }
            addFieldValue(ChronoField.HOUR_OF_DAY, jLongValue6 / 3600);
            addFieldValue(ChronoField.MINUTE_OF_HOUR, (jLongValue6 / 60) % 60);
            addFieldValue(ChronoField.SECOND_OF_MINUTE, jLongValue6 % 60);
        }
        Map<TemporalField, Long> map11 = this.fieldValues;
        ChronoField chronoField12 = ChronoField.MINUTE_OF_DAY;
        if (map11.containsKey(chronoField12)) {
            long jLongValue7 = this.fieldValues.remove(chronoField12).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField12.checkValidValue(jLongValue7);
            }
            addFieldValue(ChronoField.HOUR_OF_DAY, jLongValue7 / 60);
            addFieldValue(ChronoField.MINUTE_OF_HOUR, jLongValue7 % 60);
        }
        if (resolverStyle != resolverStyle2) {
            Map<TemporalField, Long> map12 = this.fieldValues;
            ChronoField chronoField13 = ChronoField.MILLI_OF_SECOND;
            if (map12.containsKey(chronoField13)) {
                chronoField13.checkValidValue(this.fieldValues.get(chronoField13).longValue());
            }
            Map<TemporalField, Long> map13 = this.fieldValues;
            ChronoField chronoField14 = ChronoField.MICRO_OF_SECOND;
            if (map13.containsKey(chronoField14)) {
                chronoField14.checkValidValue(this.fieldValues.get(chronoField14).longValue());
            }
        }
        Map<TemporalField, Long> map14 = this.fieldValues;
        ChronoField chronoField15 = ChronoField.MILLI_OF_SECOND;
        if (map14.containsKey(chronoField15)) {
            Map<TemporalField, Long> map15 = this.fieldValues;
            ChronoField chronoField16 = ChronoField.MICRO_OF_SECOND;
            if (map15.containsKey(chronoField16)) {
                addFieldValue(chronoField16, (this.fieldValues.get(chronoField16).longValue() % 1000) + (this.fieldValues.remove(chronoField15).longValue() * 1000));
            }
        }
        Map<TemporalField, Long> map16 = this.fieldValues;
        ChronoField chronoField17 = ChronoField.MICRO_OF_SECOND;
        if (map16.containsKey(chronoField17)) {
            Map<TemporalField, Long> map17 = this.fieldValues;
            ChronoField chronoField18 = ChronoField.NANO_OF_SECOND;
            if (map17.containsKey(chronoField18)) {
                addFieldValue(chronoField17, this.fieldValues.get(chronoField18).longValue() / 1000);
                this.fieldValues.remove(chronoField17);
            }
        }
        if (this.fieldValues.containsKey(chronoField15)) {
            Map<TemporalField, Long> map18 = this.fieldValues;
            ChronoField chronoField19 = ChronoField.NANO_OF_SECOND;
            if (map18.containsKey(chronoField19)) {
                addFieldValue(chronoField15, this.fieldValues.get(chronoField19).longValue() / 1000000);
                this.fieldValues.remove(chronoField15);
            }
        }
        if (this.fieldValues.containsKey(chronoField17)) {
            addFieldValue(ChronoField.NANO_OF_SECOND, this.fieldValues.remove(chronoField17).longValue() * 1000);
        } else if (this.fieldValues.containsKey(chronoField15)) {
            addFieldValue(ChronoField.NANO_OF_SECOND, this.fieldValues.remove(chronoField15).longValue() * 1000000);
        }
    }

    private DateTimeBuilder putFieldValue0(TemporalField temporalField, long j10) {
        this.fieldValues.put(temporalField, Long.valueOf(j10));
        return this;
    }

    private boolean resolveFields(ResolverStyle resolverStyle) {
        int i10 = 0;
        loop0: while (i10 < 100) {
            Iterator<Map.Entry<TemporalField, Long>> it = this.fieldValues.entrySet().iterator();
            while (it.hasNext()) {
                TemporalField key = it.next().getKey();
                TemporalAccessor temporalAccessorResolve = key.resolve(this.fieldValues, this, resolverStyle);
                if (temporalAccessorResolve != null) {
                    if (temporalAccessorResolve instanceof ChronoZonedDateTime) {
                        ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) temporalAccessorResolve;
                        ZoneId zoneId = this.zone;
                        if (zoneId == null) {
                            this.zone = chronoZonedDateTime.getZone();
                        } else if (!zoneId.equals(chronoZonedDateTime.getZone())) {
                            throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.zone);
                        }
                        temporalAccessorResolve = chronoZonedDateTime.toLocalDateTime();
                    }
                    if (temporalAccessorResolve instanceof ChronoLocalDate) {
                        resolveMakeChanges(key, (ChronoLocalDate) temporalAccessorResolve);
                    } else if (temporalAccessorResolve instanceof LocalTime) {
                        resolveMakeChanges(key, (LocalTime) temporalAccessorResolve);
                    } else {
                        if (!(temporalAccessorResolve instanceof ChronoLocalDateTime)) {
                            throw new DateTimeException("Unknown type: ".concat(temporalAccessorResolve.getClass().getName()));
                        }
                        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) temporalAccessorResolve;
                        resolveMakeChanges(key, chronoLocalDateTime.toLocalDate());
                        resolveMakeChanges(key, chronoLocalDateTime.toLocalTime());
                    }
                } else if (!this.fieldValues.containsKey(key)) {
                    break;
                }
                i10++;
            }
        }
        if (i10 != 100) {
            return i10 > 0;
        }
        throw new DateTimeException("Badly written field");
    }

    private void resolveFractional() {
        if (this.time == null) {
            if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) || this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) || this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE)) {
                Map<TemporalField, Long> map = this.fieldValues;
                ChronoField chronoField = ChronoField.NANO_OF_SECOND;
                if (map.containsKey(chronoField)) {
                    long jLongValue = this.fieldValues.get(chronoField).longValue();
                    this.fieldValues.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(jLongValue / 1000));
                    this.fieldValues.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(jLongValue / 1000000));
                } else {
                    this.fieldValues.put(chronoField, 0L);
                    this.fieldValues.put(ChronoField.MICRO_OF_SECOND, 0L);
                    this.fieldValues.put(ChronoField.MILLI_OF_SECOND, 0L);
                }
            }
        }
    }

    private void resolveInstant() {
        if (this.date == null || this.time == null) {
            return;
        }
        Long l10 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
        if (l10 != null) {
            Temporal temporalAtZone = this.date.atTime(this.time).atZone(ZoneOffset.ofTotalSeconds(l10.intValue()));
            TemporalField temporalField = ChronoField.INSTANT_SECONDS;
            this.fieldValues.put(temporalField, Long.valueOf(temporalAtZone.getLong(temporalField)));
            return;
        }
        if (this.zone != null) {
            Temporal temporalAtZone2 = this.date.atTime(this.time).atZone(this.zone);
            TemporalField temporalField2 = ChronoField.INSTANT_SECONDS;
            this.fieldValues.put(temporalField2, Long.valueOf(temporalAtZone2.getLong(temporalField2)));
        }
    }

    private void resolveMakeChanges(TemporalField temporalField, ChronoLocalDate chronoLocalDate) {
        if (!this.chrono.equals(chronoLocalDate.getChronology())) {
            throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.chrono);
        }
        long epochDay = chronoLocalDate.toEpochDay();
        Long lPut = this.fieldValues.put(ChronoField.EPOCH_DAY, Long.valueOf(epochDay));
        if (lPut == null || lPut.longValue() == epochDay) {
            return;
        }
        throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(lPut.longValue()) + " differs from " + LocalDate.ofEpochDay(epochDay) + " while resolving  " + temporalField);
    }

    private void resolveTimeInferZeroes(ResolverStyle resolverStyle) {
        Map<TemporalField, Long> map = this.fieldValues;
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        Long l10 = map.get(chronoField);
        Map<TemporalField, Long> map2 = this.fieldValues;
        ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
        Long l11 = map2.get(chronoField2);
        Map<TemporalField, Long> map3 = this.fieldValues;
        ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
        Long l12 = map3.get(chronoField3);
        Map<TemporalField, Long> map4 = this.fieldValues;
        ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
        Long l13 = map4.get(chronoField4);
        if (l10 == null) {
            return;
        }
        if (l11 != null || (l12 == null && l13 == null)) {
            if (l11 == null || l12 != null || l13 == null) {
                if (resolverStyle != ResolverStyle.LENIENT) {
                    if (resolverStyle == ResolverStyle.SMART && l10.longValue() == 24 && ((l11 == null || l11.longValue() == 0) && ((l12 == null || l12.longValue() == 0) && (l13 == null || l13.longValue() == 0)))) {
                        l10 = 0L;
                        this.excessDays = Period.ofDays(1);
                    }
                    int iCheckValidIntValue = chronoField.checkValidIntValue(l10.longValue());
                    if (l11 != null) {
                        int iCheckValidIntValue2 = chronoField2.checkValidIntValue(l11.longValue());
                        if (l12 != null) {
                            int iCheckValidIntValue3 = chronoField3.checkValidIntValue(l12.longValue());
                            if (l13 != null) {
                                addObject(LocalTime.of(iCheckValidIntValue, iCheckValidIntValue2, iCheckValidIntValue3, chronoField4.checkValidIntValue(l13.longValue())));
                            } else {
                                addObject(LocalTime.of(iCheckValidIntValue, iCheckValidIntValue2, iCheckValidIntValue3));
                            }
                        } else if (l13 == null) {
                            addObject(LocalTime.of(iCheckValidIntValue, iCheckValidIntValue2));
                        }
                    } else if (l12 == null && l13 == null) {
                        addObject(LocalTime.of(iCheckValidIntValue, 0));
                    }
                } else {
                    long jLongValue = l10.longValue();
                    if (l11 == null) {
                        int iSafeToInt = Jdk8Methods.safeToInt(Jdk8Methods.floorDiv(jLongValue, 24L));
                        addObject(LocalTime.of(Jdk8Methods.floorMod(jLongValue, 24), 0));
                        this.excessDays = Period.ofDays(iSafeToInt);
                    } else if (l12 != null) {
                        if (l13 == null) {
                            l13 = 0L;
                        }
                        long jSafeAdd = Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jLongValue, 3600000000000L), Jdk8Methods.safeMultiply(l11.longValue(), 60000000000L)), Jdk8Methods.safeMultiply(l12.longValue(), 1000000000L)), l13.longValue());
                        int iFloorDiv = (int) Jdk8Methods.floorDiv(jSafeAdd, 86400000000000L);
                        addObject(LocalTime.ofNanoOfDay(Jdk8Methods.floorMod(jSafeAdd, 86400000000000L)));
                        this.excessDays = Period.ofDays(iFloorDiv);
                    } else {
                        long jSafeAdd2 = Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(jLongValue, 3600L), Jdk8Methods.safeMultiply(l11.longValue(), 60L));
                        int iFloorDiv2 = (int) Jdk8Methods.floorDiv(jSafeAdd2, 86400L);
                        addObject(LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(jSafeAdd2, 86400L)));
                        this.excessDays = Period.ofDays(iFloorDiv2);
                    }
                }
                this.fieldValues.remove(chronoField);
                this.fieldValues.remove(chronoField2);
                this.fieldValues.remove(chronoField3);
                this.fieldValues.remove(chronoField4);
            }
        }
    }

    public DateTimeBuilder addFieldValue(TemporalField temporalField, long j10) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long fieldValue0 = getFieldValue0(temporalField);
        if (fieldValue0 == null || fieldValue0.longValue() == j10) {
            return putFieldValue0(temporalField, j10);
        }
        throw new DateTimeException("Conflict found: " + temporalField + StringUtils.SPACE + fieldValue0 + " differs from " + temporalField + StringUtils.SPACE + j10 + ": " + this);
    }

    public void addObject(ChronoLocalDate chronoLocalDate) {
        this.date = chronoLocalDate;
    }

    public <R> R build(TemporalQuery<R> temporalQuery) {
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Long fieldValue0 = getFieldValue0(temporalField);
        if (fieldValue0 != null) {
            return fieldValue0.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return this.date.getLong(temporalField);
        }
        LocalTime localTime = this.time;
        if (localTime == null || !localTime.isSupported(temporalField)) {
            throw new DateTimeException(a.e("Field not found: ", temporalField));
        }
        return this.time.getLong(temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        ChronoLocalDate chronoLocalDate;
        LocalTime localTime;
        if (temporalField == null) {
            return false;
        }
        return this.fieldValues.containsKey(temporalField) || ((chronoLocalDate = this.date) != null && chronoLocalDate.isSupported(temporalField)) || ((localTime = this.time) != null && localTime.isSupported(temporalField));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId()) {
            return (R) this.zone;
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) this.chrono;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                return (R) LocalDate.from((TemporalAccessor) chronoLocalDate);
            }
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) this.time;
        }
        if (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return temporalQuery.queryFrom(this);
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public DateTimeBuilder resolve(ResolverStyle resolverStyle, Set<TemporalField> set) {
        ChronoLocalDate chronoLocalDate;
        if (set != null) {
            this.fieldValues.keySet().retainAll(set);
        }
        mergeInstantFields();
        mergeDate(resolverStyle);
        mergeTime(resolverStyle);
        if (resolveFields(resolverStyle)) {
            mergeInstantFields();
            mergeDate(resolverStyle);
            mergeTime(resolverStyle);
        }
        resolveTimeInferZeroes(resolverStyle);
        crossCheck();
        Period period = this.excessDays;
        if (period != null && !period.isZero() && (chronoLocalDate = this.date) != null && this.time != null) {
            this.date = chronoLocalDate.plus((TemporalAmount) this.excessDays);
            this.excessDays = Period.ZERO;
        }
        resolveFractional();
        resolveInstant();
        return this;
    }

    public String toString() {
        StringBuilder sbQ = c.q(128, "DateTimeBuilder[");
        if (this.fieldValues.size() > 0) {
            sbQ.append("fields=");
            sbQ.append(this.fieldValues);
        }
        sbQ.append(", ");
        sbQ.append(this.chrono);
        sbQ.append(", ");
        sbQ.append(this.zone);
        sbQ.append(", ");
        sbQ.append(this.date);
        sbQ.append(", ");
        sbQ.append(this.time);
        sbQ.append(']');
        return sbQ.toString();
    }

    public void addObject(LocalTime localTime) {
        this.time = localTime;
    }

    public DateTimeBuilder(TemporalField temporalField, long j10) {
        addFieldValue(temporalField, j10);
    }

    private void crossCheck(TemporalAccessor temporalAccessor) {
        Iterator<Map.Entry<TemporalField, Long>> it = this.fieldValues.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<TemporalField, Long> next = it.next();
            TemporalField key = next.getKey();
            long jLongValue = next.getValue().longValue();
            if (temporalAccessor.isSupported(key)) {
                try {
                    long j10 = temporalAccessor.getLong(key);
                    if (j10 == jLongValue) {
                        it.remove();
                    } else {
                        throw new DateTimeException("Cross check failed: " + key + StringUtils.SPACE + j10 + " vs " + key + StringUtils.SPACE + jLongValue);
                    }
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    private void resolveMakeChanges(TemporalField temporalField, LocalTime localTime) {
        long nanoOfDay = localTime.toNanoOfDay();
        Long lPut = this.fieldValues.put(ChronoField.NANO_OF_DAY, Long.valueOf(nanoOfDay));
        if (lPut == null || lPut.longValue() == nanoOfDay) {
            return;
        }
        throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(lPut.longValue()) + " differs from " + localTime + " while resolving  " + temporalField);
    }
}
