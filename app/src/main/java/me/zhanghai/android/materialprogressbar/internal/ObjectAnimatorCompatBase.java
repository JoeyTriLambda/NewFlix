package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Property;

/* loaded from: classes2.dex */
class ObjectAnimatorCompatBase {
    private static final int NUM_POINTS = 500;

    private ObjectAnimatorCompatBase() {
    }

    private static void calculateXYValues(Path path, float[] fArr, float[] fArr2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float[] fArr3 = new float[2];
        for (int i10 = 0; i10 < 500; i10++) {
            pathMeasure.getPosTan((i10 * length) / 499.0f, fArr3, null);
            fArr[i10] = fArr3[0];
            fArr2[i10] = fArr3[1];
        }
    }

    public static ObjectAnimator ofArgb(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(obj, str, iArr);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        return objectAnimatorOfInt;
    }

    public static ObjectAnimator ofFloat(Object obj, String str, String str2, Path path) {
        float[] fArr = new float[500];
        float[] fArr2 = new float[500];
        calculateXYValues(path, fArr, fArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, PropertyValuesHolder.ofFloat(str, fArr), PropertyValuesHolder.ofFloat(str2, fArr2));
    }

    public static ObjectAnimator ofInt(Object obj, String str, String str2, Path path) {
        int[] iArr = new int[500];
        int[] iArr2 = new int[500];
        calculateXYValues(path, iArr, iArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, PropertyValuesHolder.ofInt(str, iArr), PropertyValuesHolder.ofInt(str2, iArr2));
    }

    public static <T> ObjectAnimator ofArgb(T t10, Property<T, Integer> property, int... iArr) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(t10, property, iArr);
        objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        return objectAnimatorOfInt;
    }

    public static <T> ObjectAnimator ofFloat(T t10, Property<T, Float> property, Property<T, Float> property2, Path path) {
        float[] fArr = new float[500];
        float[] fArr2 = new float[500];
        calculateXYValues(path, fArr, fArr2);
        return ObjectAnimator.ofPropertyValuesHolder(t10, PropertyValuesHolder.ofFloat((Property<?, Float>) property, fArr), PropertyValuesHolder.ofFloat((Property<?, Float>) property2, fArr2));
    }

    public static <T> ObjectAnimator ofInt(T t10, Property<T, Integer> property, Property<T, Integer> property2, Path path) {
        int[] iArr = new int[500];
        int[] iArr2 = new int[500];
        calculateXYValues(path, iArr, iArr2);
        return ObjectAnimator.ofPropertyValuesHolder(t10, PropertyValuesHolder.ofInt((Property<?, Integer>) property, iArr), PropertyValuesHolder.ofInt((Property<?, Integer>) property2, iArr2));
    }

    private static void calculateXYValues(Path path, int[] iArr, int[] iArr2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float[] fArr = new float[2];
        for (int i10 = 0; i10 < 500; i10++) {
            pathMeasure.getPosTan((i10 * length) / 499.0f, fArr, null);
            iArr[i10] = Math.round(fArr[0]);
            iArr2[i10] = Math.round(fArr[1]);
        }
    }
}
