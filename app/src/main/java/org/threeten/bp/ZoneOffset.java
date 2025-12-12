package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import o1.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes2.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset> {
    private static final int MINUTES_PER_HOUR = 60;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: id, reason: collision with root package name */
    private final transient String f17400id;
    private final int totalSeconds;
    public static final TemporalQuery<ZoneOffset> FROM = new TemporalQuery<ZoneOffset>() { // from class: org.threeten.bp.ZoneOffset.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            return ZoneOffset.from(temporalAccessor);
        }
    };
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MAX = ofTotalSeconds(MAX_SECONDS);

    private ZoneOffset(int i10) {
        this.totalSeconds = i10;
        this.f17400id = buildId(i10);
    }

    private static String buildId(int i10) {
        if (i10 == 0) {
            return "Z";
        }
        int iAbs = Math.abs(i10);
        StringBuilder sb2 = new StringBuilder();
        int i11 = iAbs / SECONDS_PER_HOUR;
        int i12 = (iAbs / 60) % 60;
        sb2.append(i10 < 0 ? "-" : "+");
        sb2.append(i11 < 10 ? "0" : "");
        sb2.append(i11);
        sb2.append(i12 < 10 ? ":0" : ":");
        sb2.append(i12);
        int i13 = iAbs % 60;
        if (i13 != 0) {
            sb2.append(i13 >= 10 ? ":" : ":0");
            sb2.append(i13);
        }
        return sb2.toString();
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.threeten.bp.ZoneOffset of(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            org.threeten.bp.jdk8.Jdk8Methods.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, org.threeten.bp.ZoneOffset> r0 = org.threeten.bp.ZoneOffset.ID_CACHE
            java.lang.Object r0 = r0.get(r7)
            org.threeten.bp.ZoneOffset r0 = (org.threeten.bp.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L62
            r1 = 3
            if (r0 == r1) goto L7e
            r4 = 5
            if (r0 == r4) goto L59
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L50
            r5 = 7
            if (r0 == r5) goto L43
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            int r2 = parseNumber(r7, r5, r2)
            goto L84
        L37:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L43:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            int r2 = parseNumber(r7, r4, r3)
            goto L84
        L50:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            goto L83
        L59:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            goto L83
        L62:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L7e:
            int r0 = parseNumber(r7, r2, r3)
            r1 = 0
        L83:
            r2 = 0
        L84:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L9d
            if (r3 != r5) goto L91
            goto L9d
        L91:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L9d:
            if (r3 != r5) goto La7
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            org.threeten.bp.ZoneOffset r7 = ofHoursMinutesSeconds(r7, r0, r1)
            return r7
        La7:
            org.threeten.bp.ZoneOffset r7 = ofHoursMinutesSeconds(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.of(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    public static ZoneOffset ofHours(int i10) {
        return ofHoursMinutesSeconds(i10, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int i10, int i11) {
        return ofHoursMinutesSeconds(i10, i11, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i10, int i11, int i12) {
        validate(i10, i11, i12);
        return ofTotalSeconds(totalSeconds(i10, i11, i12));
    }

    public static ZoneOffset ofTotalSeconds(int i10) {
        if (Math.abs(i10) > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i10 % 900 != 0) {
            return new ZoneOffset(i10);
        }
        Integer numValueOf = Integer.valueOf(i10);
        ConcurrentMap<Integer, ZoneOffset> concurrentMap = SECONDS_CACHE;
        ZoneOffset zoneOffset = concurrentMap.get(numValueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentMap.putIfAbsent(numValueOf, new ZoneOffset(i10));
        ZoneOffset zoneOffset2 = concurrentMap.get(numValueOf);
        ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
        return zoneOffset2;
    }

    private static int parseNumber(CharSequence charSequence, int i10, boolean z10) {
        if (z10 && charSequence.charAt(i10 - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char cCharAt = charSequence.charAt(i10);
        char cCharAt2 = charSequence.charAt(i10 + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    public static ZoneOffset readExternal(DataInput dataInput) throws IOException {
        byte b10 = dataInput.readByte();
        return b10 == 127 ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(b10 * 900);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static int totalSeconds(int i10, int i11, int i12) {
        return (i11 * 60) + (i10 * SECONDS_PER_HOUR) + i12;
    }

    private static void validate(int i10, int i11, int i12) {
        if (i10 < -18 || i10 > 18) {
            throw new DateTimeException(a.d("Zone offset hours not in valid range: value ", i10, " is not in the range -18 to 18"));
        }
        if (i10 > 0) {
            if (i11 < 0 || i12 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i10 < 0) {
            if (i11 > 0 || i12 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i11 > 0 && i12 < 0) || (i11 < 0 && i12 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i11) > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(i11) + " is not in the range 0 to 59");
        }
        if (Math.abs(i12) > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(i12) + " is not in the range 0 to 59");
        }
        if (Math.abs(i10) == 18) {
            if (Math.abs(i11) > 0 || Math.abs(i12) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f17400id;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            throw new DateTimeException(a.e("Unsupported field: ", temporalField));
        }
        return temporalField.getFrom(this);
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.precision() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.f17400id;
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        int i10 = this.totalSeconds;
        int i11 = i10 % 900 == 0 ? i10 / 900 : 127;
        dataOutput.writeByte(i11);
        if (i11 == 127) {
            dataOutput.writeInt(i10);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }
}
