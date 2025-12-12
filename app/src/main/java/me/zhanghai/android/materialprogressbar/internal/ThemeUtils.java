package me.zhanghai.android.materialprogressbar.internal;

import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: classes2.dex */
public class ThemeUtils {
    private ThemeUtils() {
    }

    public static int getColorFromAttrRes(int i10, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static float getFloatFromAttrRes(int i10, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
