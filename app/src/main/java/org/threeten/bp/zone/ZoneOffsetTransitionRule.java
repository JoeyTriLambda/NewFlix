package org.threeten.bp.zone;

import ac.c;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjusters;

/* loaded from: classes2.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    private static final int SECS_PER_DAY = 86400;
    private static final long serialVersionUID = 6889046316657758795L;
    private final int adjustDays;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;

    /* renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition;

        static {
            int[] iArr = new int[TimeDefinition.values().length];
            $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition = iArr;
            try {
                iArr[TimeDefinition.UTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[TimeDefinition.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime createDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            int i10 = AnonymousClass1.$SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[ordinal()];
            return i10 != 1 ? i10 != 2 ? localDateTime : localDateTime.plusSeconds(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()) : localDateTime.plusSeconds(zoneOffset2.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }

    public ZoneOffsetTransitionRule(Month month, int i10, DayOfWeek dayOfWeek, LocalTime localTime, int i11, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month;
        this.dom = (byte) i10;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.adjustDays = i11;
        this.timeDefinition = timeDefinition;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    private void appendZeroPad(StringBuilder sb2, long j10) {
        if (j10 < 10) {
            sb2.append(0);
        }
        sb2.append(j10);
    }

    public static ZoneOffsetTransitionRule of(Month month, int i10, DayOfWeek dayOfWeek, LocalTime localTime, boolean z10, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        Jdk8Methods.requireNonNull(month, "month");
        Jdk8Methods.requireNonNull(localTime, "time");
        Jdk8Methods.requireNonNull(timeDefinition, "timeDefnition");
        Jdk8Methods.requireNonNull(zoneOffset, "standardOffset");
        Jdk8Methods.requireNonNull(zoneOffset2, "offsetBefore");
        Jdk8Methods.requireNonNull(zoneOffset3, "offsetAfter");
        if (i10 < -28 || i10 > 31 || i10 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (!z10 || localTime.equals(LocalTime.MIDNIGHT)) {
            return new ZoneOffsetTransitionRule(month, i10, dayOfWeek, localTime, z10 ? 1 : 0, timeDefinition, zoneOffset, zoneOffset2, zoneOffset3);
        }
        throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
    }

    public static ZoneOffsetTransitionRule readExternal(DataInput dataInput) throws IOException {
        int i10 = dataInput.readInt();
        Month monthOf = Month.of(i10 >>> 28);
        int i11 = ((264241152 & i10) >>> 22) - 32;
        int i12 = (3670016 & i10) >>> 19;
        DayOfWeek dayOfWeekOf = i12 == 0 ? null : DayOfWeek.of(i12);
        int i13 = (507904 & i10) >>> 14;
        TimeDefinition timeDefinition = TimeDefinition.values()[(i10 & 12288) >>> 12];
        int i14 = (i10 & 4080) >>> 4;
        int i15 = (i10 & 12) >>> 2;
        int i16 = i10 & 3;
        int i17 = i13 == 31 ? dataInput.readInt() : i13 * 3600;
        ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(i14 == 255 ? dataInput.readInt() : (i14 - 128) * 900);
        ZoneOffset zoneOffsetOfTotalSeconds2 = i15 == 3 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds((i15 * 1800) + zoneOffsetOfTotalSeconds.getTotalSeconds());
        ZoneOffset zoneOffsetOfTotalSeconds3 = i16 == 3 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds((i16 * 1800) + zoneOffsetOfTotalSeconds.getTotalSeconds());
        if (i11 < -28 || i11 > 31 || i11 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        return new ZoneOffsetTransitionRule(monthOf, i11, dayOfWeekOf, LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(i17, SECS_PER_DAY)), Jdk8Methods.floorDiv(i17, SECS_PER_DAY), timeDefinition, zoneOffsetOfTotalSeconds, zoneOffsetOfTotalSeconds2, zoneOffsetOfTotalSeconds3);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public ZoneOffsetTransition createTransition(int i10) {
        LocalDate localDateOf;
        byte b10 = this.dom;
        if (b10 < 0) {
            Month month = this.month;
            localDateOf = LocalDate.of(i10, month, month.length(IsoChronology.INSTANCE.isLeapYear(i10)) + 1 + this.dom);
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                localDateOf = localDateOf.with(TemporalAdjusters.previousOrSame(dayOfWeek));
            }
        } else {
            localDateOf = LocalDate.of(i10, this.month, b10);
            DayOfWeek dayOfWeek2 = this.dow;
            if (dayOfWeek2 != null) {
                localDateOf = localDateOf.with(TemporalAdjusters.nextOrSame(dayOfWeek2));
            }
        }
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(localDateOf.plusDays(this.adjustDays), this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        return this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.adjustDays == zoneOffsetTransitionRule.adjustDays && this.time.equals(zoneOffsetTransitionRule.time) && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter);
    }

    public int getDayOfMonthIndicator() {
        return this.dom;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dow;
    }

    public LocalTime getLocalTime() {
        return this.time;
    }

    public Month getMonth() {
        return this.month;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public int hashCode() {
        int secondOfDay = ((this.time.toSecondOfDay() + this.adjustDays) << 15) + (this.month.ordinal() << 11) + ((this.dom + 32) << 5);
        DayOfWeek dayOfWeek = this.dow;
        return ((this.standardOffset.hashCode() ^ (this.timeDefinition.ordinal() + (secondOfDay + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    public boolean isMidnightEndOfDay() {
        return this.adjustDays == 1 && this.time.equals(LocalTime.MIDNIGHT);
    }

    public String toString() {
        StringBuilder sbR = c.r("TransitionRule[");
        sbR.append(this.offsetBefore.compareTo(this.offsetAfter) > 0 ? "Gap " : "Overlap ");
        sbR.append(this.offsetBefore);
        sbR.append(" to ");
        sbR.append(this.offsetAfter);
        sbR.append(", ");
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek != null) {
            byte b10 = this.dom;
            if (b10 == -1) {
                sbR.append(dayOfWeek.name());
                sbR.append(" on or before last day of ");
                sbR.append(this.month.name());
            } else if (b10 < 0) {
                sbR.append(dayOfWeek.name());
                sbR.append(" on or before last day minus ");
                sbR.append((-this.dom) - 1);
                sbR.append(" of ");
                sbR.append(this.month.name());
            } else {
                sbR.append(dayOfWeek.name());
                sbR.append(" on or after ");
                sbR.append(this.month.name());
                sbR.append(TokenParser.SP);
                sbR.append((int) this.dom);
            }
        } else {
            sbR.append(this.month.name());
            sbR.append(TokenParser.SP);
            sbR.append((int) this.dom);
        }
        sbR.append(" at ");
        if (this.adjustDays == 0) {
            sbR.append(this.time);
        } else {
            appendZeroPad(sbR, Jdk8Methods.floorDiv((this.adjustDays * 24 * 60) + (this.time.toSecondOfDay() / 60), 60L));
            sbR.append(':');
            appendZeroPad(sbR, Jdk8Methods.floorMod(r3, 60));
        }
        sbR.append(StringUtils.SPACE);
        sbR.append(this.timeDefinition);
        sbR.append(", standard offset ");
        sbR.append(this.standardOffset);
        sbR.append(']');
        return sbR.toString();
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        int secondOfDay = (this.adjustDays * SECS_PER_DAY) + this.time.toSecondOfDay();
        int totalSeconds = this.standardOffset.getTotalSeconds();
        int totalSeconds2 = this.offsetBefore.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.offsetAfter.getTotalSeconds() - totalSeconds;
        int hour = (secondOfDay % 3600 != 0 || secondOfDay > SECS_PER_DAY) ? 31 : secondOfDay == SECS_PER_DAY ? 24 : this.time.getHour();
        int i10 = totalSeconds % 900 == 0 ? (totalSeconds / 900) + 128 : 255;
        int i11 = (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) ? totalSeconds2 / 1800 : 3;
        int i12 = (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) ? totalSeconds3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.dow;
        dataOutput.writeInt((this.month.getValue() << 28) + ((this.dom + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (hour << 14) + (this.timeDefinition.ordinal() << 12) + (i10 << 4) + (i11 << 2) + i12);
        if (hour == 31) {
            dataOutput.writeInt(secondOfDay);
        }
        if (i10 == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (i11 == 3) {
            dataOutput.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (i12 == 3) {
            dataOutput.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }
}
