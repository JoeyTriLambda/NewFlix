package com.google.android.material.carousel;

/* compiled from: CarouselStrategyHelper.java */
/* loaded from: classes.dex */
public final class a {
    public static float a(float f10, float f11, int i10) {
        return (Math.max(0, i10 - 1) * f11) + f10;
    }

    public static float b(float f10, float f11, int i10) {
        return i10 > 0 ? (f11 / 2.0f) + f10 : f10;
    }

    public static float c(float f10, float f11, float f12, int i10) {
        return i10 > 0 ? (f12 / 2.0f) + f11 : f10;
    }
}
