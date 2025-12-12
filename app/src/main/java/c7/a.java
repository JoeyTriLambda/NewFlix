package c7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import n7.b;

/* compiled from: MaterialColors.java */
/* loaded from: classes.dex */
public final class a {
    public static int compositeARGBWithAlpha(int i10, int i11) {
        return o0.a.setAlphaComponent(i10, (Color.alpha(i10) * i11) / 255);
    }

    public static int getColor(View view, int i10) {
        Context context = view.getContext();
        TypedValue typedValueResolveTypedValueOrThrow = b.resolveTypedValueOrThrow(view, i10);
        int i11 = typedValueResolveTypedValueOrThrow.resourceId;
        return i11 != 0 ? m0.a.getColor(context, i11) : typedValueResolveTypedValueOrThrow.data;
    }

    public static Integer getColorOrNull(Context context, int i10) {
        TypedValue typedValueResolve = b.resolve(context, i10);
        if (typedValueResolve == null) {
            return null;
        }
        int i11 = typedValueResolve.resourceId;
        return Integer.valueOf(i11 != 0 ? m0.a.getColor(context, i11) : typedValueResolve.data);
    }

    public static ColorStateList getColorStateList(Context context, int i10, ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue typedValueResolve = b.resolve(context, i10);
        if (typedValueResolve != null) {
            int i11 = typedValueResolve.resourceId;
            colorStateList2 = i11 != 0 ? m0.a.getColorStateList(context, i11) : ColorStateList.valueOf(typedValueResolve.data);
        } else {
            colorStateList2 = null;
        }
        return colorStateList2 == null ? colorStateList : colorStateList2;
    }

    public static ColorStateList getColorStateListOrNull(Context context, int i10) {
        TypedValue typedValueResolve = b.resolve(context, i10);
        if (typedValueResolve == null) {
            return null;
        }
        int i11 = typedValueResolve.resourceId;
        if (i11 != 0) {
            return m0.a.getColorStateList(context, i11);
        }
        int i12 = typedValueResolve.data;
        if (i12 != 0) {
            return ColorStateList.valueOf(i12);
        }
        return null;
    }

    public static boolean isColorLight(int i10) {
        return i10 != 0 && o0.a.calculateLuminance(i10) > 0.5d;
    }

    public static int layer(View view, int i10, int i11, float f10) {
        return layer(getColor(view, i10), getColor(view, i11), f10);
    }

    public static int layer(int i10, int i11, float f10) {
        return layer(i10, o0.a.setAlphaComponent(i11, Math.round(Color.alpha(i11) * f10)));
    }

    public static int getColor(Context context, int i10, String str) {
        TypedValue typedValueResolveTypedValueOrThrow = b.resolveTypedValueOrThrow(context, i10, str);
        int i11 = typedValueResolveTypedValueOrThrow.resourceId;
        if (i11 != 0) {
            return m0.a.getColor(context, i11);
        }
        return typedValueResolveTypedValueOrThrow.data;
    }

    public static int layer(int i10, int i11) {
        return o0.a.compositeColors(i11, i10);
    }

    public static int getColor(View view, int i10, int i11) {
        return getColor(view.getContext(), i10, i11);
    }

    public static int getColor(Context context, int i10, int i11) {
        Integer colorOrNull = getColorOrNull(context, i10);
        return colorOrNull != null ? colorOrNull.intValue() : i11;
    }
}
