package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class s extends o {

    /* renamed from: b, reason: collision with root package name */
    public final Object f10241b;

    public s(Boolean bool) {
        this.f10241b = v9.a.checkNotNull(bool);
    }

    public static boolean a(s sVar) {
        Object obj = sVar.f10241b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        Object obj2 = this.f10241b;
        Object obj3 = sVar.f10241b;
        if (obj2 == null) {
            return obj3 == null;
        }
        if (a(this) && a(sVar)) {
            return getAsNumber().longValue() == sVar.getAsNumber().longValue();
        }
        if (!(obj2 instanceof Number) || !(obj3 instanceof Number)) {
            return obj2.equals(obj3);
        }
        double dDoubleValue = getAsNumber().doubleValue();
        double dDoubleValue2 = sVar.getAsNumber().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.o
    public boolean getAsBoolean() {
        return isBoolean() ? ((Boolean) this.f10241b).booleanValue() : Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.o
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.o
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.o
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public Number getAsNumber() {
        Object obj = this.f10241b;
        return obj instanceof String ? new LazilyParsedNumber((String) obj) : (Number) obj;
    }

    @Override // com.google.gson.o
    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        boolean zIsBoolean = isBoolean();
        Object obj = this.f10241b;
        return zIsBoolean ? ((Boolean) obj).toString() : (String) obj;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        Object obj = this.f10241b;
        if (obj == null) {
            return 31;
        }
        if (a(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public boolean isBoolean() {
        return this.f10241b instanceof Boolean;
    }

    public boolean isNumber() {
        return this.f10241b instanceof Number;
    }

    public boolean isString() {
        return this.f10241b instanceof String;
    }

    public s(Number number) {
        this.f10241b = v9.a.checkNotNull(number);
    }

    public s(String str) {
        this.f10241b = v9.a.checkNotNull(str);
    }
}
