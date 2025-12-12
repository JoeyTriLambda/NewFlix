package org.apache.commons.lang3.math;

import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class IEEE754rUtils {
    public static double max(double... dArr) {
        Validate.isTrue(dArr != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
        double dMax = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            dMax = max(dArr[i10], dMax);
        }
        return dMax;
    }

    public static double min(double... dArr) {
        Validate.isTrue(dArr != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
        double dMin = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            dMin = min(dArr[i10], dMin);
        }
        return dMin;
    }

    public static float max(float... fArr) {
        Validate.isTrue(fArr != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
        float fMax = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            fMax = max(fArr[i10], fMax);
        }
        return fMax;
    }

    public static float min(float... fArr) {
        Validate.isTrue(fArr != null, "The Array must not be null", new Object[0]);
        Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
        float fMin = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            fMin = min(fArr[i10], fMin);
        }
        return fMin;
    }

    public static double max(double d10, double d11, double d12) {
        return max(max(d10, d11), d12);
    }

    public static double min(double d10, double d11, double d12) {
        return min(min(d10, d11), d12);
    }

    public static double max(double d10, double d11) {
        return Double.isNaN(d10) ? d11 : Double.isNaN(d11) ? d10 : Math.max(d10, d11);
    }

    public static double min(double d10, double d11) {
        return Double.isNaN(d10) ? d11 : Double.isNaN(d11) ? d10 : Math.min(d10, d11);
    }

    public static float max(float f10, float f11, float f12) {
        return max(max(f10, f11), f12);
    }

    public static float min(float f10, float f11, float f12) {
        return min(min(f10, f11), f12);
    }

    public static float max(float f10, float f11) {
        return Float.isNaN(f10) ? f11 : Float.isNaN(f11) ? f10 : Math.max(f10, f11);
    }

    public static float min(float f10, float f11) {
        return Float.isNaN(f10) ? f11 : Float.isNaN(f11) ? f10 : Math.min(f10, f11);
    }
}
