package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f1545a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1546b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f1547c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1548d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f1549e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f1550f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f1551g = new int[1];

    public static void checkAppCompatTheme(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int getDisabledThemeAttrColor(Context context, int i10) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i10);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f1546b, themeAttrColorStateList.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = f1545a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f10 = typedValue.getFloat();
        return o0.a.setAlphaComponent(getThemeAttrColor(context, i10), Math.round(Color.alpha(r4) * f10));
    }

    public static int getThemeAttrColor(Context context, int i10) {
        int[] iArr = f1551g;
        iArr[0] = i10;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return c1VarObtainStyledAttributes.getColor(0, 0);
        } finally {
            c1VarObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i10) {
        int[] iArr = f1551g;
        iArr[0] = i10;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return c1VarObtainStyledAttributes.getColorStateList(0);
        } finally {
            c1VarObtainStyledAttributes.recycle();
        }
    }
}
