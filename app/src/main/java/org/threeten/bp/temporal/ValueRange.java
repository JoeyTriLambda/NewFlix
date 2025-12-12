package org.threeten.bp.temporal;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* loaded from: classes2.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long j10, long j11, long j12, long j13) {
        this.minSmallest = j10;
        this.minLargest = j11;
        this.maxSmallest = j12;
        this.maxLargest = j13;
    }

    public static ValueRange of(long j10, long j11) {
        if (j10 <= j11) {
            return new ValueRange(j10, j10, j11, j11);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long j10, TemporalField temporalField) {
        if (isValidIntValue(j10)) {
            return (int) j10;
        }
        throw new DateTimeException("Invalid int value for " + temporalField + ": " + j10);
    }

    public long checkValidValue(long j10, TemporalField temporalField) {
        if (isValidValue(j10)) {
            return j10;
        }
        if (temporalField == null) {
            throw new DateTimeException("Invalid value (valid values " + this + "): " + j10);
        }
        throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + this + "): " + j10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        return this.minSmallest == valueRange.minSmallest && this.minLargest == valueRange.minLargest && this.maxSmallest == valueRange.maxSmallest && this.maxLargest == valueRange.maxLargest;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public int hashCode() {
        long j10 = this.minSmallest;
        long j11 = this.minLargest;
        long j12 = (j10 + j11) << ((int) (j11 + 16));
        long j13 = this.maxSmallest;
        long j14 = (j12 >> ((int) (j13 + 48))) << ((int) (j13 + 32));
        long j15 = this.maxLargest;
        long j16 = ((j14 >> ((int) (32 + j15))) << ((int) (j15 + 48))) >> 16;
        return (int) (j16 ^ (j16 >>> 32));
    }

    public boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public boolean isIntValue() {
        return getMinimum() >= -2147483648L && getMaximum() <= 2147483647L;
    }

    public boolean isValidIntValue(long j10) {
        return isIntValue() && isValidValue(j10);
    }

    public boolean isValidValue(long j10) {
        return j10 >= getMinimum() && j10 <= getMaximum();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            sb2.append(JsonPointer.SEPARATOR);
            sb2.append(this.minLargest);
        }
        sb2.append(" - ");
        sb2.append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            sb2.append(JsonPointer.SEPARATOR);
            sb2.append(this.maxLargest);
        }
        return sb2.toString();
    }

    public static ValueRange of(long j10, long j11, long j12) {
        return of(j10, j10, j11, j12);
    }

    public static ValueRange of(long j10, long j11, long j12, long j13) {
        if (j10 > j11) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (j12 > j13) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (j11 <= j13) {
            return new ValueRange(j10, j11, j12, j13);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }
}
