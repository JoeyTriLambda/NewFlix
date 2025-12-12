package o3;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

/* compiled from: DialogUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: DialogUtils.java */
    /* renamed from: o3.a$a, reason: collision with other inner class name */
    public static class RunnableC0209a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16992b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog.c f16993m;

        public RunnableC0209a(MaterialDialog materialDialog, MaterialDialog.c cVar) {
            this.f16992b = materialDialog;
            this.f16993m = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialDialog materialDialog = this.f16992b;
            materialDialog.getInputEditText().requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.f16993m.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(materialDialog.getInputEditText(), 2);
            }
        }
    }

    public static int adjustAlpha(int i10, float f10) {
        return Color.argb(Math.round(Color.alpha(i10) * f10), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public static ColorStateList getActionTextStateList(Context context, int i10) {
        int iResolveColor = resolveColor(context, R.attr.textColorPrimary);
        if (i10 == 0) {
            i10 = iResolveColor;
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{adjustAlpha(i10, 0.4f), i10});
    }

    public static int getColor(Context context, int i10) {
        return Build.VERSION.SDK_INT <= 22 ? context.getResources().getColor(i10) : context.getColor(i10);
    }

    public static void hideKeyboard(DialogInterface dialogInterface, MaterialDialog.c cVar) {
        InputMethodManager inputMethodManager;
        MaterialDialog materialDialog = (MaterialDialog) dialogInterface;
        if (materialDialog.getInputEditText() == null || (inputMethodManager = (InputMethodManager) cVar.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(materialDialog.getCurrentFocus().getWindowToken(), 0);
    }

    public static boolean isColorDark(int i10) {
        return 1.0d - (((((double) Color.blue(i10)) * 0.114d) + ((((double) Color.green(i10)) * 0.587d) + (((double) Color.red(i10)) * 0.299d))) / 255.0d) >= 0.5d;
    }

    public static ColorStateList resolveActionTextColorStateList(Context context, int i10, ColorStateList colorStateList) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(0);
            if (typedValuePeekValue == null) {
                return colorStateList;
            }
            int i11 = typedValuePeekValue.type;
            if (i11 >= 28 && i11 <= 31) {
                return getActionTextStateList(context, typedValuePeekValue.data);
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(0);
            return colorStateList2 != null ? colorStateList2 : colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static boolean resolveBoolean(Context context, int i10, boolean z10) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getBoolean(0, z10);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int resolveColor(Context context, int i10) {
        return resolveColor(context, i10, 0);
    }

    public static int resolveDimension(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static Drawable resolveDrawable(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getDrawable(0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static GravityEnum resolveGravityEnum(Context context, int i10, GravityEnum gravityEnum) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            int iOrdinal = gravityEnum.ordinal();
            int i11 = typedArrayObtainStyledAttributes.getInt(0, iOrdinal != 1 ? iOrdinal != 2 ? 0 : 2 : 1);
            return i11 != 1 ? i11 != 2 ? GravityEnum.START : GravityEnum.END : GravityEnum.CENTER;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static String resolveString(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return (String) typedValue.string;
    }

    public static void setBackgroundCompat(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void showKeyboard(DialogInterface dialogInterface, MaterialDialog.c cVar) {
        MaterialDialog materialDialog = (MaterialDialog) dialogInterface;
        if (materialDialog.getInputEditText() == null) {
            return;
        }
        materialDialog.getInputEditText().post(new RunnableC0209a(materialDialog, cVar));
    }

    public static int resolveColor(Context context, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getColor(0, i11);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static boolean resolveBoolean(Context context, int i10) {
        return resolveBoolean(context, i10, false);
    }
}
