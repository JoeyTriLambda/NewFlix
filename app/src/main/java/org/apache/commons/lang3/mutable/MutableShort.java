package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public MutableShort() {
    }

    public void add(short s10) {
        this.value = (short) (this.value + s10);
    }

    public short addAndGet(short s10) {
        short s11 = (short) (this.value + s10);
        this.value = s11;
        return s11;
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public short decrementAndGet() {
        short s10 = (short) (this.value - 1);
        this.value = s10;
        return s10;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableShort) && this.value == ((MutableShort) obj).shortValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public short getAndAdd(short s10) {
        short s11 = this.value;
        this.value = (short) (s10 + s11);
        return s11;
    }

    public short getAndDecrement() {
        short s10 = this.value;
        this.value = (short) (s10 - 1);
        return s10;
    }

    public short getAndIncrement() {
        short s10 = this.value;
        this.value = (short) (s10 + 1);
        return s10;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public short incrementAndGet() {
        short s10 = (short) (this.value + 1);
        this.value = s10;
        return s10;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
    }

    public void subtract(short s10) {
        this.value = (short) (this.value - s10);
    }

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }

    public MutableShort(short s10) {
        this.value = s10;
    }

    public void add(Number number) {
        this.value = (short) (number.shortValue() + this.value);
    }

    public short addAndGet(Number number) {
        short sShortValue = (short) (number.shortValue() + this.value);
        this.value = sShortValue;
        return sShortValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableShort mutableShort) {
        return NumberUtils.compare(this.value, mutableShort.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public Number getValue2() {
        return Short.valueOf(this.value);
    }

    public void setValue(short s10) {
        this.value = s10;
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    public short getAndAdd(Number number) {
        short s10 = this.value;
        this.value = (short) (number.shortValue() + s10);
        return s10;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String str) {
        this.value = Short.parseShort(str);
    }
}
