package com.unity3d.services.core.misc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class ViewUtilities {
    public static float dpFromPx(Context context, float f10) {
        return f10 / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(Context context, float f10) {
        return f10 * context.getResources().getDisplayMetrics().density;
    }

    public static void removeViewFromParent(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            ((ViewGroup) view.getParent()).removeView(view);
        } catch (Exception e10) {
            DeviceLog.exception("Error while removing view from it's parent", e10);
        }
    }

    public static void setBackground(View view, Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            View.class.getMethod("setBackground", Drawable.class).invoke(view, drawable);
        } catch (Exception e10) {
            DeviceLog.exception("Couldn't run".concat("setBackground"), e10);
        }
    }
}
