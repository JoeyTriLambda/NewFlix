package org.apache.commons.lang3;

/* loaded from: classes2.dex */
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i10) {
        this._mask = i10;
        this._shift_count = i10 == 0 ? 0 : Integer.numberOfTrailingZeros(i10);
    }

    public int clear(int i10) {
        return i10 & (~this._mask);
    }

    public byte clearByte(byte b10) {
        return (byte) clear(b10);
    }

    public short clearShort(short s10) {
        return (short) clear(s10);
    }

    public int getRawValue(int i10) {
        return i10 & this._mask;
    }

    public short getShortRawValue(short s10) {
        return (short) getRawValue(s10);
    }

    public short getShortValue(short s10) {
        return (short) getValue(s10);
    }

    public int getValue(int i10) {
        return getRawValue(i10) >> this._shift_count;
    }

    public boolean isAllSet(int i10) {
        int i11 = this._mask;
        return (i10 & i11) == i11;
    }

    public boolean isSet(int i10) {
        return (i10 & this._mask) != 0;
    }

    public int set(int i10) {
        return i10 | this._mask;
    }

    public int setBoolean(int i10, boolean z10) {
        return z10 ? set(i10) : clear(i10);
    }

    public byte setByte(byte b10) {
        return (byte) set(b10);
    }

    public byte setByteBoolean(byte b10, boolean z10) {
        return z10 ? setByte(b10) : clearByte(b10);
    }

    public short setShort(short s10) {
        return (short) set(s10);
    }

    public short setShortBoolean(short s10, boolean z10) {
        return z10 ? setShort(s10) : clearShort(s10);
    }

    public short setShortValue(short s10, short s11) {
        return (short) setValue(s10, s11);
    }

    public int setValue(int i10, int i11) {
        int i12 = this._mask;
        return (i10 & (~i12)) | ((i11 << this._shift_count) & i12);
    }
}
