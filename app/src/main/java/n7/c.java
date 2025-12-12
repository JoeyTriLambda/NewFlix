package n7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.c1;

/* compiled from: MaterialResources.java */
/* loaded from: classes.dex */
public final class c {
    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateList = s.a.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i10) : colorStateList;
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i10, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i11);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable drawable;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (drawable = s.a.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i10) : drawable;
    }

    public static float getFontScale(Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    public static d getTextAppearance(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean isFontScaleAtLeast2_0(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static ColorStateList getColorStateList(Context context, c1 c1Var, int i10) {
        int resourceId;
        ColorStateList colorStateList;
        return (!c1Var.hasValue(i10) || (resourceId = c1Var.getResourceId(i10, 0)) == 0 || (colorStateList = s.a.getColorStateList(context, resourceId)) == null) ? c1Var.getColorStateList(i10) : colorStateList;
    }
}
