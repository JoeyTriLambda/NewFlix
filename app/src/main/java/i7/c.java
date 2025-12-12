package i7;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import x0.w0;

/* compiled from: EdgeToEdgeUtils.java */
/* loaded from: classes.dex */
public final class c {
    public static void applyEdgeToEdge(Window window, boolean z10, Integer num, Integer num2) {
        int i10 = Build.VERSION.SDK_INT;
        boolean z11 = true;
        boolean z12 = num == null || num.intValue() == 0;
        boolean z13 = num2 == null || num2.intValue() == 0;
        if (z12 || z13) {
            int color = c7.a.getColor(window.getContext(), R.attr.colorBackground, -16777216);
            if (z12) {
                num = Integer.valueOf(color);
            }
            if (z13) {
                num2 = Integer.valueOf(color);
            }
        }
        w0.setDecorFitsSystemWindows(window, !z10);
        Context context = window.getContext();
        int color2 = (!z10 || i10 >= 23) ? z10 ? 0 : c7.a.getColor(context, R.attr.statusBarColor, -16777216) : o0.a.setAlphaComponent(c7.a.getColor(context, R.attr.statusBarColor, -16777216), 128);
        Context context2 = window.getContext();
        int color3 = (!z10 || i10 >= 27) ? z10 ? 0 : c7.a.getColor(context2, R.attr.navigationBarColor, -16777216) : o0.a.setAlphaComponent(c7.a.getColor(context2, R.attr.navigationBarColor, -16777216), 128);
        window.setStatusBarColor(color2);
        window.setNavigationBarColor(color3);
        setLightStatusBar(window, c7.a.isColorLight(color2) || (color2 == 0 && c7.a.isColorLight(num.intValue())));
        boolean zIsColorLight = c7.a.isColorLight(num2.intValue());
        if (!c7.a.isColorLight(color3) && (color3 != 0 || !zIsColorLight)) {
            z11 = false;
        }
        setLightNavigationBar(window, z11);
    }

    public static void setLightNavigationBar(Window window, boolean z10) {
        w0.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z10);
    }

    public static void setLightStatusBar(Window window, boolean z10) {
        w0.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z10);
    }
}
