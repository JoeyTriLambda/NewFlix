package o7;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* compiled from: RippleUtils.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f17032a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f17033b = {R.attr.state_focused};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f17034c = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f17035d = {R.attr.state_selected};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f17036e = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    public static final String f17037f = b.class.getSimpleName();

    /* compiled from: RippleUtils.java */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable b(Context context, int i10) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(c7.a.getColorStateList(context, com.google.android.material.R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i10, i10, i10, i10));
        }
    }

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return o0.a.setAlphaComponent(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList colorStateList) {
        int[] iArr = f17033b;
        return new ColorStateList(new int[][]{f17035d, iArr, StateSet.NOTHING}, new int[]{a(colorStateList, f17034c), a(colorStateList, iArr), a(colorStateList, f17032a)});
    }

    public static Drawable createOvalRippleLollipop(Context context, int i10) {
        return a.b(context, i10);
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 22 && i10 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f17036e, 0)) != 0) {
            Log.w(f17037f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean shouldDrawRippleCompat(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
