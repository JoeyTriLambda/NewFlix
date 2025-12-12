package org.apache.commons.lang3;

import java.util.Random;

/* loaded from: classes2.dex */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int i10) {
        Validate.isTrue(i10 >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i10];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d10, double d11) {
        Validate.isTrue(d11 >= d10, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d10 >= 0.0d, "Both range values must be non-negative.", new Object[0]);
        if (d10 == d11) {
            return d10;
        }
        return (RANDOM.nextDouble() * (d11 - d10)) + d10;
    }

    public static float nextFloat(float f10, float f11) {
        Validate.isTrue(f11 >= f10, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f10 >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        if (f10 == f11) {
            return f10;
        }
        return (RANDOM.nextFloat() * (f11 - f10)) + f10;
    }

    public static int nextInt(int i10, int i11) {
        Validate.isTrue(i11 >= i10, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(i10 >= 0, "Both range values must be non-negative.", new Object[0]);
        return i10 == i11 ? i10 : RANDOM.nextInt(i11 - i10) + i10;
    }

    public static long nextLong(long j10, long j11) {
        Validate.isTrue(j11 >= j10, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(j10 >= 0, "Both range values must be non-negative.", new Object[0]);
        return j10 == j11 ? j10 : (long) nextDouble(j10, j11);
    }

    public static double nextDouble() {
        return nextDouble(0.0d, Double.MAX_VALUE);
    }

    public static float nextFloat() {
        return nextFloat(0.0f, Float.MAX_VALUE);
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    public static long nextLong() {
        return nextLong(0L, Long.MAX_VALUE);
    }
}
