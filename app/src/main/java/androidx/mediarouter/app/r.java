package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.mediarouter.R;

/* compiled from: MediaRouterThemeHelper.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3784a = R.color.mr_dynamic_dialog_icon_light;

    public static ContextThemeWrapper a(Context context, int i10, boolean z10) {
        if (i10 == 0) {
            i10 = h(context, !z10 ? androidx.appcompat.R.attr.dialogTheme : androidx.appcompat.R.attr.alertDialogTheme);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        return h(contextThemeWrapper, R.attr.mediaRouteTheme) != 0 ? new ContextThemeWrapper(contextThemeWrapper, f(contextThemeWrapper)) : contextThemeWrapper;
    }

    public static int b(ContextThemeWrapper contextThemeWrapper) {
        int iH = h(contextThemeWrapper, R.attr.mediaRouteTheme);
        return iH == 0 ? f(contextThemeWrapper) : iH;
    }

    public static int c(Context context, int i10) {
        return o0.a.calculateContrast(-1, g(context, i10, androidx.appcompat.R.attr.colorPrimary)) >= 3.0d ? -1 : -570425344;
    }

    public static float d(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.disabledAlpha, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    public static Drawable e(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i10});
        Drawable drawableWrap = p0.a.wrap(s.a.getDrawable(context, typedArrayObtainStyledAttributes.getResourceId(0, 0)));
        if (i(context)) {
            p0.a.setTint(drawableWrap, m0.a.getColor(context, f3784a));
        }
        typedArrayObtainStyledAttributes.recycle();
        return drawableWrap;
    }

    public static int f(Context context) {
        return i(context) ? c(context, 0) == -570425344 ? R.style.Theme_MediaRouter_Light : R.style.Theme_MediaRouter_Light_DarkControlPanel : c(context, 0) == -570425344 ? R.style.Theme_MediaRouter_LightControlPanel : R.style.Theme_MediaRouter;
    }

    public static int g(Context context, int i10, int i11) throws Resources.NotFoundException {
        if (i10 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, new int[]{i11});
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            if (color != 0) {
                return color;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId != 0 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
    }

    public static int h(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    public static boolean i(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.appcompat.R.attr.isLightTheme, typedValue, true) && typedValue.data != 0;
    }

    public static void j(Context context, ProgressBar progressBar) {
        if (progressBar.isIndeterminate()) {
            progressBar.getIndeterminateDrawable().setColorFilter(m0.a.getColor(context, i(context) ? R.color.mr_cast_progressbar_progress_and_thumb_light : R.color.mr_cast_progressbar_progress_and_thumb_dark), PorterDuff.Mode.SRC_IN);
        }
    }

    public static void k(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider, ViewGroup viewGroup) {
        int iC = c(context, 0);
        if (Color.alpha(iC) != 255) {
            iC = o0.a.compositeColors(iC, ((Integer) viewGroup.getTag()).intValue());
        }
        mediaRouteVolumeSlider.setColor(iC);
    }
}
