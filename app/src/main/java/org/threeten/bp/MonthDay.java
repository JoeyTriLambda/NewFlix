package org.threeten.bp;

import ac.c;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import o1.a;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAdjuster, Comparable<MonthDay>, Serializable {
    public static final TemporalQuery<MonthDay> FROM = new TemporalQuery<MonthDay>() { // from class: org.threeten.bp.MonthDay.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public MonthDay queryFrom(TemporalAccessor temporalAccessor) {
            return MonthDay.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    /* renamed from: org.threeten.bp.MonthDay$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MonthDay(int i10, int i11) {
        this.month = i10;
        this.day = i11;
    }

    public static MonthDay from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MonthDay) {
            return (MonthDay) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.MONTH_OF_YEAR), temporalAccessor.get(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay of(Month month, int i10) {
        Jdk8Methods.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i10);
        if (i10 <= month.maxLength()) {
            return new MonthDay(month.getValue(), i10);
        }
        StringBuilder sbS = c.s("Illegal value for DayOfMonth field, value ", i10, " is not valid for month ");
        sbS.append(month.name());
        throw new DateTimeException(sbS.toString());
    }

    public static MonthDay parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    public static MonthDay readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (!Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        Temporal temporalWith = temporal.with(ChronoField.MONTH_OF_YEAR, this.month);
        ChronoField chronoField = ChronoField.DAY_OF_MONTH;
        return temporalWith.with(chronoField, Math.min(temporalWith.range(chronoField).getMaximum(), this.day));
    }

    public LocalDate atYear(int i10) {
        return LocalDate.of(i10, this.month, isValidYear(i10) ? this.day : 28);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        return this.month == monthDay.month && this.day == monthDay.day;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i10;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i11 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i11 == 1) {
            i10 = this.day;
        } else {
            if (i11 != 2) {
                throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
            }
            i10 = this.month;
        }
        return i10;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public boolean isAfter(MonthDay monthDay) {
        return compareTo(monthDay) > 0;
    }

    public boolean isBefore(MonthDay monthDay) {
        return compareTo(monthDay) < 0;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH : temporalField != null && temporalField.isSupportedBy(this);
    }

    public boolean isValidYear(int i10) {
        return !(this.day == 29 && this.month == 2 && !Year.isLeap((long) i10));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.chronology() ? (R) IsoChronology.INSTANCE : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? temporalField.range() : temporalField == ChronoField.DAY_OF_MONTH ? ValueRange.of(1L, getMonth().minLength(), getMonth().maxLength()) : super.range(temporalField);
    }

    public String toString() {
        StringBuilder sbQ = c.q(10, "--");
        sbQ.append(this.month < 10 ? "0" : "");
        sbQ.append(this.month);
        sbQ.append(this.day < 10 ? "-0" : "-");
        sbQ.append(this.day);
        return sbQ.toString();
    }

    public MonthDay with(Month month) {
        Jdk8Methods.requireNonNull(month, "month");
        if (month.getValue() == this.month) {
            return this;
        }
        return new MonthDay(month.getValue(), Math.min(this.day, month.maxLength()));
    }

    public MonthDay withDayOfMonth(int i10) {
        return i10 == this.day ? this : of(this.month, i10);
    }

    public MonthDay withMonth(int i10) {
        return with(Month.of(i10));
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public static MonthDay now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static MonthDay parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (MonthDay) dateTimeFormatter.parse(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(MonthDay monthDay) {
        int i10 = this.month - monthDay.month;
        return i10 == 0 ? this.day - monthDay.day : i10;
    }

    public static MonthDay now(Clock clock) {
        LocalDate localDateNow = LocalDate.now(clock);
        return of(localDateNow.getMonth(), localDateNow.getDayOfMonth());
    }

    public static MonthDay of(int i10, int i11) {
        return of(Month.of(i10), i11);
    }
}
