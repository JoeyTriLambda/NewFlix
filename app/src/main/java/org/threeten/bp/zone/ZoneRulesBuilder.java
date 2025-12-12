package org.threeten.bp.zone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.zone.ZoneOffsetTransitionRule;

/* loaded from: classes2.dex */
class ZoneRulesBuilder {
    private Map<Object, Object> deduplicateMap;
    private List<TZWindow> windowList = new ArrayList();

    public class TZRule implements Comparable<TZRule> {
        private int adjustDays;
        private int dayOfMonthIndicator;
        private DayOfWeek dayOfWeek;
        private Month month;
        private int savingAmountSecs;
        private LocalTime time;
        private ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private int year;

        public TZRule(int i10, Month month, int i11, DayOfWeek dayOfWeek, LocalTime localTime, int i12, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i13) {
            this.year = i10;
            this.month = month;
            this.dayOfMonthIndicator = i11;
            this.dayOfWeek = dayOfWeek;
            this.time = localTime;
            this.adjustDays = i12;
            this.timeDefinition = timeDefinition;
            this.savingAmountSecs = i13;
        }

        private LocalDate toLocalDate() {
            int i10 = this.dayOfMonthIndicator;
            if (i10 < 0) {
                LocalDate localDateOf = LocalDate.of(this.year, this.month, this.month.length(IsoChronology.INSTANCE.isLeapYear(this.year)) + 1 + this.dayOfMonthIndicator);
                DayOfWeek dayOfWeek = this.dayOfWeek;
                return dayOfWeek != null ? localDateOf.with(TemporalAdjusters.previousOrSame(dayOfWeek)) : localDateOf;
            }
            LocalDate localDateOf2 = LocalDate.of(this.year, this.month, i10);
            DayOfWeek dayOfWeek2 = this.dayOfWeek;
            return dayOfWeek2 != null ? localDateOf2.with(TemporalAdjusters.nextOrSame(dayOfWeek2)) : localDateOf2;
        }

        public ZoneOffsetTransition toTransition(ZoneOffset zoneOffset, int i10) {
            LocalDateTime localDateTime = (LocalDateTime) ZoneRulesBuilder.this.deduplicate(LocalDateTime.of(((LocalDate) ZoneRulesBuilder.this.deduplicate(toLocalDate())).plusDays(this.adjustDays), this.time));
            ZoneOffset zoneOffset2 = (ZoneOffset) ZoneRulesBuilder.this.deduplicate(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + i10));
            return new ZoneOffsetTransition((LocalDateTime) ZoneRulesBuilder.this.deduplicate(this.timeDefinition.createDateTime(localDateTime, zoneOffset, zoneOffset2)), zoneOffset2, (ZoneOffset) ZoneRulesBuilder.this.deduplicate(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + this.savingAmountSecs)));
        }

        public ZoneOffsetTransitionRule toTransitionRule(ZoneOffset zoneOffset, int i10) {
            Month month;
            if (this.dayOfMonthIndicator < 0 && (month = this.month) != Month.FEBRUARY) {
                this.dayOfMonthIndicator = month.maxLength() - 6;
            }
            ZoneOffsetTransition transition = toTransition(zoneOffset, i10);
            return new ZoneOffsetTransitionRule(this.month, this.dayOfMonthIndicator, this.dayOfWeek, this.time, this.adjustDays, this.timeDefinition, zoneOffset, transition.getOffsetBefore(), transition.getOffsetAfter());
        }

        @Override // java.lang.Comparable
        public int compareTo(TZRule tZRule) {
            int iCompareTo = this.year - tZRule.year;
            if (iCompareTo == 0) {
                iCompareTo = this.month.compareTo(tZRule.month);
            }
            if (iCompareTo == 0) {
                iCompareTo = toLocalDate().compareTo((ChronoLocalDate) tZRule.toLocalDate());
            }
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            long secondOfDay = (this.adjustDays * 86400) + this.time.toSecondOfDay();
            long secondOfDay2 = (tZRule.adjustDays * 86400) + tZRule.time.toSecondOfDay();
            if (secondOfDay < secondOfDay2) {
                return -1;
            }
            return secondOfDay > secondOfDay2 ? 1 : 0;
        }
    }

    public class TZWindow {
        private Integer fixedSavingAmountSecs;
        private final ZoneOffset standardOffset;
        private final ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private final LocalDateTime windowEnd;
        private List<TZRule> ruleList = new ArrayList();
        private int maxLastRuleStartYear = Year.MIN_VALUE;
        private List<TZRule> lastRuleList = new ArrayList();

        public TZWindow(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
            this.windowEnd = localDateTime;
            this.timeDefinition = timeDefinition;
            this.standardOffset = zoneOffset;
        }

        public void addRule(int i10, int i11, Month month, int i12, DayOfWeek dayOfWeek, LocalTime localTime, int i13, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i14) {
            boolean z10;
            if (this.fixedSavingAmountSecs != null) {
                throw new IllegalStateException("Window has a fixed DST saving, so cannot have DST rules");
            }
            if (this.ruleList.size() >= 2000) {
                throw new IllegalStateException("Window has reached the maximum number of allowed rules");
            }
            int i15 = i11;
            if (i15 == 999999999) {
                z10 = true;
                i15 = i10;
            } else {
                z10 = false;
            }
            for (int i16 = i10; i16 <= i15; i16++) {
                TZRule tZRule = ZoneRulesBuilder.this.new TZRule(i16, month, i12, dayOfWeek, localTime, i13, timeDefinition, i14);
                if (z10) {
                    this.lastRuleList.add(tZRule);
                    this.maxLastRuleStartYear = Math.max(i10, this.maxLastRuleStartYear);
                } else {
                    this.ruleList.add(tZRule);
                }
            }
        }

        public long createDateTimeEpochSecond(int i10) {
            ZoneOffset zoneOffsetCreateWallOffset = createWallOffset(i10);
            return this.timeDefinition.createDateTime(this.windowEnd, this.standardOffset, zoneOffsetCreateWallOffset).toEpochSecond(zoneOffsetCreateWallOffset);
        }

        public ZoneOffset createWallOffset(int i10) {
            return ZoneOffset.ofTotalSeconds(this.standardOffset.getTotalSeconds() + i10);
        }

        public boolean isSingleWindowStandardOffset() {
            return this.windowEnd.equals(LocalDateTime.MAX) && this.timeDefinition == ZoneOffsetTransitionRule.TimeDefinition.WALL && this.fixedSavingAmountSecs == null && this.lastRuleList.isEmpty() && this.ruleList.isEmpty();
        }

        public void setFixedSavings(int i10) {
            if (this.ruleList.size() > 0 || this.lastRuleList.size() > 0) {
                throw new IllegalStateException("Window has DST rules, so cannot have fixed savings");
            }
            this.fixedSavingAmountSecs = Integer.valueOf(i10);
        }

        public void tidy(int i10) {
            if (this.lastRuleList.size() == 1) {
                throw new IllegalStateException("Cannot have only one rule defined as being forever");
            }
            if (this.windowEnd.equals(LocalDateTime.MAX)) {
                this.maxLastRuleStartYear = Math.max(this.maxLastRuleStartYear, i10) + 1;
                for (TZRule tZRule : this.lastRuleList) {
                    addRule(tZRule.year, this.maxLastRuleStartYear, tZRule.month, tZRule.dayOfMonthIndicator, tZRule.dayOfWeek, tZRule.time, tZRule.adjustDays, tZRule.timeDefinition, tZRule.savingAmountSecs);
                    tZRule.year = this.maxLastRuleStartYear + 1;
                }
                int i11 = this.maxLastRuleStartYear;
                if (i11 == 999999999) {
                    this.lastRuleList.clear();
                } else {
                    this.maxLastRuleStartYear = i11 + 1;
                }
            } else {
                int year = this.windowEnd.getYear();
                for (TZRule tZRule2 : this.lastRuleList) {
                    addRule(tZRule2.year, year + 1, tZRule2.month, tZRule2.dayOfMonthIndicator, tZRule2.dayOfWeek, tZRule2.time, tZRule2.adjustDays, tZRule2.timeDefinition, tZRule2.savingAmountSecs);
                }
                this.lastRuleList.clear();
                this.maxLastRuleStartYear = Year.MAX_VALUE;
            }
            Collections.sort(this.ruleList);
            Collections.sort(this.lastRuleList);
            if (this.ruleList.size() == 0 && this.fixedSavingAmountSecs == null) {
                this.fixedSavingAmountSecs = 0;
            }
        }

        public void validateWindowOrder(TZWindow tZWindow) {
            if (this.windowEnd.isBefore(tZWindow.windowEnd)) {
                throw new IllegalStateException("Windows must be added in date-time order: " + this.windowEnd + " < " + tZWindow.windowEnd);
            }
        }
    }

    public ZoneRulesBuilder addRuleToWindow(LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i10) {
        Jdk8Methods.requireNonNull(localDateTime, "transitionDateTime");
        return addRuleToWindow(localDateTime.getYear(), localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), (DayOfWeek) null, localDateTime.toLocalTime(), false, timeDefinition, i10);
    }

    public ZoneRulesBuilder addWindow(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
        Jdk8Methods.requireNonNull(zoneOffset, "standardOffset");
        Jdk8Methods.requireNonNull(localDateTime, "until");
        Jdk8Methods.requireNonNull(timeDefinition, "untilDefinition");
        TZWindow tZWindow = new TZWindow(zoneOffset, localDateTime, timeDefinition);
        if (this.windowList.size() > 0) {
            tZWindow.validateWindowOrder(this.windowList.get(r2.size() - 1));
        }
        this.windowList.add(tZWindow);
        return this;
    }

    public ZoneRulesBuilder addWindowForever(ZoneOffset zoneOffset) {
        return addWindow(zoneOffset, LocalDateTime.MAX, ZoneOffsetTransitionRule.TimeDefinition.WALL);
    }

    public <T> T deduplicate(T t10) {
        if (!this.deduplicateMap.containsKey(t10)) {
            this.deduplicateMap.put(t10, t10);
        }
        return (T) this.deduplicateMap.get(t10);
    }

    public ZoneRulesBuilder setFixedSavingsToWindow(int i10) {
        if (this.windowList.isEmpty()) {
            throw new IllegalStateException("Must add a window before setting the fixed savings");
        }
        this.windowList.get(r0.size() - 1).setFixedSavings(i10);
        return this;
    }

    public ZoneRules toRules(String str) {
        return toRules(str, new HashMap());
    }

    public ZoneRules toRules(String str, Map<Object, Object> map) {
        Iterator<TZWindow> it;
        Jdk8Methods.requireNonNull(str, "zoneId");
        this.deduplicateMap = map;
        if (this.windowList.isEmpty()) {
            throw new IllegalStateException("No windows have been added to the builder");
        }
        ArrayList arrayList = new ArrayList(4);
        ArrayList arrayList2 = new ArrayList(256);
        ArrayList arrayList3 = new ArrayList(2);
        int i10 = 0;
        TZWindow tZWindow = this.windowList.get(0);
        ZoneOffset zoneOffset = tZWindow.standardOffset;
        int iIntValue = tZWindow.fixedSavingAmountSecs != null ? tZWindow.fixedSavingAmountSecs.intValue() : 0;
        ZoneOffset zoneOffset2 = (ZoneOffset) deduplicate(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + iIntValue));
        LocalDateTime localDateTime = (LocalDateTime) deduplicate(LocalDateTime.of(Year.MIN_VALUE, 1, 1, 0, 0));
        Iterator<TZWindow> it2 = this.windowList.iterator();
        ZoneOffset zoneOffset3 = zoneOffset2;
        while (it2.hasNext()) {
            TZWindow next = it2.next();
            next.tidy(localDateTime.getYear());
            Integer numValueOf = next.fixedSavingAmountSecs;
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(i10);
                for (TZRule tZRule : next.ruleList) {
                    if (tZRule.toTransition(zoneOffset, iIntValue).toEpochSecond() > localDateTime.toEpochSecond(zoneOffset3)) {
                        break;
                    }
                    numValueOf = Integer.valueOf(tZRule.savingAmountSecs);
                }
            }
            if (zoneOffset.equals(next.standardOffset)) {
                it = it2;
            } else {
                it = it2;
                arrayList.add(deduplicate(new ZoneOffsetTransition(LocalDateTime.ofEpochSecond(localDateTime.toEpochSecond(zoneOffset3), i10, zoneOffset), zoneOffset, next.standardOffset)));
                zoneOffset = (ZoneOffset) deduplicate(next.standardOffset);
            }
            ZoneOffset zoneOffset4 = (ZoneOffset) deduplicate(ZoneOffset.ofTotalSeconds(numValueOf.intValue() + zoneOffset.getTotalSeconds()));
            if (!zoneOffset3.equals(zoneOffset4)) {
                arrayList2.add((ZoneOffsetTransition) deduplicate(new ZoneOffsetTransition(localDateTime, zoneOffset3, zoneOffset4)));
            }
            iIntValue = numValueOf.intValue();
            for (TZRule tZRule2 : next.ruleList) {
                ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) deduplicate(tZRule2.toTransition(zoneOffset, iIntValue));
                if (!(zoneOffsetTransition.toEpochSecond() < localDateTime.toEpochSecond(zoneOffset3)) && zoneOffsetTransition.toEpochSecond() < next.createDateTimeEpochSecond(iIntValue) && !zoneOffsetTransition.getOffsetBefore().equals(zoneOffsetTransition.getOffsetAfter())) {
                    arrayList2.add(zoneOffsetTransition);
                    iIntValue = tZRule2.savingAmountSecs;
                }
            }
            for (TZRule tZRule3 : next.lastRuleList) {
                arrayList3.add((ZoneOffsetTransitionRule) deduplicate(tZRule3.toTransitionRule(zoneOffset, iIntValue)));
                iIntValue = tZRule3.savingAmountSecs;
            }
            zoneOffset3 = (ZoneOffset) deduplicate(next.createWallOffset(iIntValue));
            i10 = 0;
            localDateTime = (LocalDateTime) deduplicate(LocalDateTime.ofEpochSecond(next.createDateTimeEpochSecond(iIntValue), 0, zoneOffset3));
            it2 = it;
        }
        return new StandardZoneRules(tZWindow.standardOffset, zoneOffset2, arrayList, arrayList2, arrayList3);
    }

    public ZoneRulesBuilder addRuleToWindow(int i10, Month month, int i11, LocalTime localTime, boolean z10, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i12) {
        return addRuleToWindow(i10, i10, month, i11, (DayOfWeek) null, localTime, z10, timeDefinition, i12);
    }

    public ZoneRulesBuilder addRuleToWindow(int i10, int i11, Month month, int i12, DayOfWeek dayOfWeek, LocalTime localTime, boolean z10, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i13) {
        Jdk8Methods.requireNonNull(month, "month");
        Jdk8Methods.requireNonNull(localTime, "time");
        Jdk8Methods.requireNonNull(timeDefinition, "timeDefinition");
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.checkValidValue(i10);
        chronoField.checkValidValue(i11);
        if (i12 >= -28 && i12 <= 31 && i12 != 0) {
            if (z10 && !localTime.equals(LocalTime.MIDNIGHT)) {
                throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
            }
            if (!this.windowList.isEmpty()) {
                this.windowList.get(r1.size() - 1).addRule(i10, i11, month, i12, dayOfWeek, localTime, z10 ? 1 : 0, timeDefinition, i13);
                return this;
            }
            throw new IllegalStateException("Must add a window before adding a rule");
        }
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    public ZoneRulesBuilder addRuleToWindow(int i10, int i11, Month month, int i12, DayOfWeek dayOfWeek, LocalTime localTime, int i13, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i14) {
        Jdk8Methods.requireNonNull(month, "month");
        Jdk8Methods.requireNonNull(timeDefinition, "timeDefinition");
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.checkValidValue(i10);
        chronoField.checkValidValue(i11);
        if (i12 >= -28 && i12 <= 31 && i12 != 0) {
            if (!this.windowList.isEmpty()) {
                this.windowList.get(r1.size() - 1).addRule(i10, i11, month, i12, dayOfWeek, localTime, i13, timeDefinition, i14);
                return this;
            }
            throw new IllegalStateException("Must add a window before adding a rule");
        }
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }
}
