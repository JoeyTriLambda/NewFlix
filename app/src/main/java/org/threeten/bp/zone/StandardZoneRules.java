package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes2.dex */
final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    public StandardZoneRules(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        this.standardTransitions = new long[list.size()];
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[list.size() + 1];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        int i10 = 0;
        while (i10 < list.size()) {
            this.standardTransitions[i10] = list.get(i10).toEpochSecond();
            int i11 = i10 + 1;
            this.standardOffsets[i11] = list.get(i10).getOffsetAfter();
            i10 = i11;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zoneOffset2);
        for (ZoneOffsetTransition zoneOffsetTransition : list2) {
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
            }
            arrayList2.add(zoneOffsetTransition.getOffsetAfter());
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        this.wallOffsets = (ZoneOffset[]) arrayList2.toArray(new ZoneOffset[arrayList2.size()]);
        this.savingsInstantTransitions = new long[list2.size()];
        for (int i12 = 0; i12 < list2.size(); i12++) {
            this.savingsInstantTransitions[i12] = list2.get(i12).getInstant().getEpochSecond();
        }
        if (list3.size() > 15) {
            throw new IllegalArgumentException("Too many transition rules");
        }
        this.lastRules = (ZoneOffsetTransitionRule[]) list3.toArray(new ZoneOffsetTransitionRule[list3.size()]);
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        return zoneOffsetTransition.isGap() ? localDateTime.isBefore(dateTimeBefore) ? zoneOffsetTransition.getOffsetBefore() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition : zoneOffsetTransition.getOffsetAfter() : !localDateTime.isBefore(dateTimeBefore) ? zoneOffsetTransition.getOffsetAfter() : localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition.getOffsetBefore() : zoneOffsetTransition;
    }

    private ZoneOffsetTransition[] findTransitionArray(int i10) {
        Integer numValueOf = Integer.valueOf(i10);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.lastRulesCache.get(numValueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
        ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i11 = 0; i11 < zoneOffsetTransitionRuleArr.length; i11++) {
            zoneOffsetTransitionArr2[i11] = zoneOffsetTransitionRuleArr[i11].createTransition(i10);
        }
        if (i10 < LAST_CACHED_YEAR) {
            this.lastRulesCache.putIfAbsent(numValueOf, zoneOffsetTransitionArr2);
        }
        return zoneOffsetTransitionArr2;
    }

    private int findYear(long j10, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(Jdk8Methods.floorDiv(j10 + zoneOffset.getTotalSeconds(), 86400L)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        int i10 = 0;
        if (this.lastRules.length > 0) {
            LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
            if (localDateTimeArr.length == 0 || localDateTime.isAfter(localDateTimeArr[localDateTimeArr.length - 1])) {
                ZoneOffsetTransition[] zoneOffsetTransitionArrFindTransitionArray = findTransitionArray(localDateTime.getYear());
                int length = zoneOffsetTransitionArrFindTransitionArray.length;
                Object obj = null;
                while (i10 < length) {
                    ZoneOffsetTransition zoneOffsetTransition = zoneOffsetTransitionArrFindTransitionArray[i10];
                    Object objFindOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                    if ((objFindOffsetInfo instanceof ZoneOffsetTransition) || objFindOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                        return objFindOffsetInfo;
                    }
                    i10++;
                    obj = objFindOffsetInfo;
                }
                return obj;
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (iBinarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        } else {
            Object[] objArr = this.savingsLocalTransitions;
            if (iBinarySearch < objArr.length - 1) {
                int i11 = iBinarySearch + 1;
                if (objArr[iBinarySearch].equals(objArr[i11])) {
                    iBinarySearch = i11;
                }
            }
        }
        if ((iBinarySearch & 1) != 0) {
            return this.wallOffsets[(iBinarySearch / 2) + 1];
        }
        LocalDateTime[] localDateTimeArr2 = this.savingsLocalTransitions;
        LocalDateTime localDateTime2 = localDateTimeArr2[iBinarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr2[iBinarySearch + 1];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        int i12 = iBinarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr[i12];
        ZoneOffset zoneOffset2 = zoneOffsetArr[i12 + 1];
        return zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds() ? new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2) : new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
    }

    public static StandardZoneRules readExternal(DataInput dataInput) throws IOException, ClassNotFoundException {
        int i10 = dataInput.readInt();
        long[] jArr = new long[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i11] = Ser.readEpochSec(dataInput);
        }
        int i12 = i10 + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            zoneOffsetArr[i13] = Ser.readOffset(dataInput);
        }
        int i14 = dataInput.readInt();
        long[] jArr2 = new long[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            jArr2[i15] = Ser.readEpochSec(dataInput);
        }
        int i16 = i14 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            zoneOffsetArr2[i17] = Ser.readOffset(dataInput);
        }
        int i18 = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[i18];
        for (int i19 = 0; i19 < i18; i19++) {
            zoneOffsetTransitionRuleArr[i19] = ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return Arrays.equals(this.standardTransitions, standardZoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, standardZoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, standardZoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, standardZoneRules.wallOffsets) && Arrays.equals(this.lastRules, standardZoneRules.lastRules);
        }
        if ((obj instanceof ZoneRules.Fixed) && isFixedOffset()) {
            Instant instant = Instant.EPOCH;
            if (getOffset(instant).equals(((ZoneRules.Fixed) obj).getOffset(instant))) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public Duration getDaylightSavings(Instant instant) {
        return Duration.ofSeconds(getOffset(instant).getTotalSeconds() - getStandardOffset(instant).getTotalSeconds());
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(Instant instant) {
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            long[] jArr = this.savingsInstantTransitions;
            if (jArr.length == 0 || epochSecond > jArr[jArr.length - 1]) {
                ZoneOffsetTransition[] zoneOffsetTransitionArrFindTransitionArray = findTransitionArray(findYear(epochSecond, this.wallOffsets[r8.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i10 = 0; i10 < zoneOffsetTransitionArrFindTransitionArray.length; i10++) {
                    zoneOffsetTransition = zoneOffsetTransitionArrFindTransitionArray[i10];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.wallOffsets[iBinarySearch + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getStandardOffset(Instant instant) {
        int iBinarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.standardOffsets[iBinarySearch + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.unmodifiableList(Arrays.asList(this.lastRules));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            long[] jArr = this.savingsInstantTransitions;
            if (i10 >= jArr.length) {
                return Collections.unmodifiableList(arrayList);
            }
            long j10 = jArr[i10];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[i10];
            i10++;
            arrayList.add(new ZoneOffsetTransition(j10, zoneOffset, zoneOffsetArr[i10]));
        }
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        return offsetInfo instanceof ZoneOffsetTransition ? ((ZoneOffsetTransition) offsetInfo).getValidOffsets() : Collections.singletonList((ZoneOffset) offsetInfo);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public int hashCode() {
        return (((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isFixedOffset() {
        return this.savingsInstantTransitions.length == 0 && this.lastRules.length == 0 && this.wallOffsets[0].equals(this.standardOffsets[0]);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition nextTransition(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond = instant.getEpochSecond();
        long[] jArr = this.savingsInstantTransitions;
        if (epochSecond < jArr[jArr.length - 1]) {
            int iBinarySearch = Arrays.binarySearch(jArr, epochSecond);
            int i10 = iBinarySearch < 0 ? (-iBinarySearch) - 1 : iBinarySearch + 1;
            long j10 = this.savingsInstantTransitions[i10];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            return new ZoneOffsetTransition(j10, zoneOffsetArr[i10], zoneOffsetArr[i10 + 1]);
        }
        if (this.lastRules.length == 0) {
            return null;
        }
        int iFindYear = findYear(epochSecond, this.wallOffsets[r12.length - 1]);
        for (ZoneOffsetTransition zoneOffsetTransition : findTransitionArray(iFindYear)) {
            if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                return zoneOffsetTransition;
            }
        }
        if (iFindYear < 999999999) {
            return findTransitionArray(iFindYear + 1)[0];
        }
        return null;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSecond < Long.MAX_VALUE) {
            epochSecond++;
        }
        long j10 = this.savingsInstantTransitions[r12.length - 1];
        if (this.lastRules.length > 0 && epochSecond > j10) {
            ZoneOffset zoneOffset = this.wallOffsets[r12.length - 1];
            int iFindYear = findYear(epochSecond, zoneOffset);
            ZoneOffsetTransition[] zoneOffsetTransitionArrFindTransitionArray = findTransitionArray(iFindYear);
            for (int length = zoneOffsetTransitionArrFindTransitionArray.length - 1; length >= 0; length--) {
                if (epochSecond > zoneOffsetTransitionArrFindTransitionArray[length].toEpochSecond()) {
                    return zoneOffsetTransitionArrFindTransitionArray[length];
                }
            }
            int i10 = iFindYear - 1;
            if (i10 > findYear(j10, zoneOffset)) {
                return findTransitionArray(i10)[r12.length - 1];
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        if (iBinarySearch <= 0) {
            return null;
        }
        int i11 = iBinarySearch - 1;
        long j11 = this.savingsInstantTransitions[i11];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        return new ZoneOffsetTransition(j11, zoneOffsetArr[i11], zoneOffsetArr[iBinarySearch]);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StandardZoneRules[currentStandardOffset=");
        sb2.append(this.standardOffsets[r1.length - 1]);
        sb2.append("]");
        return sb2.toString();
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.standardTransitions.length);
        for (long j10 : this.standardTransitions) {
            Ser.writeEpochSec(j10, dataOutput);
        }
        for (ZoneOffset zoneOffset : this.standardOffsets) {
            Ser.writeOffset(zoneOffset, dataOutput);
        }
        dataOutput.writeInt(this.savingsInstantTransitions.length);
        for (long j11 : this.savingsInstantTransitions) {
            Ser.writeEpochSec(j11, dataOutput);
        }
        for (ZoneOffset zoneOffset2 : this.wallOffsets) {
            Ser.writeOffset(zoneOffset2, dataOutput);
        }
        dataOutput.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule zoneOffsetTransitionRule : this.lastRules) {
            zoneOffsetTransitionRule.writeExternal(dataOutput);
        }
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).getOffsetBefore();
        }
        return (ZoneOffset) offsetInfo;
    }

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < jArr2.length) {
            int i11 = i10 + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i10], zoneOffsetArr2[i10], zoneOffsetArr2[i11]);
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
            }
            i10 = i11;
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
    }
}
