package com.google.gson.internal;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {

    /* renamed from: b, reason: collision with root package name */
    public final String f10084b;

    public LazilyParsedNumber(String str) {
        this.f10084b = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f10084b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        Object obj2 = ((LazilyParsedNumber) obj).f10084b;
        String str = this.f10084b;
        return str == obj2 || str.equals(obj2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f10084b);
    }

    public int hashCode() {
        return this.f10084b.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        String str = this.f10084b;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return new BigDecimal(str).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(str);
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        String str = this.f10084b;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public String toString() {
        return this.f10084b;
    }
}
