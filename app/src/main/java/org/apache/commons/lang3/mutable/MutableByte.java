package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public MutableByte() {
    }

    public void add(byte b10) {
        this.value = (byte) (this.value + b10);
    }

    public byte addAndGet(byte b10) {
        byte b11 = (byte) (this.value + b10);
        this.value = b11;
        return b11;
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public byte decrementAndGet() {
        byte b10 = (byte) (this.value - 1);
        this.value = b10;
        return b10;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public byte getAndAdd(byte b10) {
        byte b11 = this.value;
        this.value = (byte) (b10 + b11);
        return b11;
    }

    public byte getAndDecrement() {
        byte b10 = this.value;
        this.value = (byte) (b10 - 1);
        return b10;
    }

    public byte getAndIncrement() {
        byte b10 = this.value;
        this.value = (byte) (b10 + 1);
        return b10;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    public byte incrementAndGet() {
        byte b10 = (byte) (this.value + 1);
        this.value = b10;
        return b10;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void subtract(byte b10) {
        this.value = (byte) (this.value - b10);
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }

    public MutableByte(byte b10) {
        this.value = b10;
    }

    public void add(Number number) {
        this.value = (byte) (number.byteValue() + this.value);
    }

    public byte addAndGet(Number number) {
        byte bByteValue = (byte) (number.byteValue() + this.value);
        this.value = bByteValue;
        return bByteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableByte mutableByte) {
        return NumberUtils.compare(this.value, mutableByte.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Byte.valueOf(this.value);
    }

    public void setValue(byte b10) {
        this.value = b10;
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public byte getAndAdd(Number number) {
        byte b10 = this.value;
        this.value = (byte) (number.byteValue() + b10);
        return b10;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String str) {
        this.value = Byte.parseByte(str);
    }
}
