package k7;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import cz.msebera.android.httpclient.cookie.ClientCookie;

/* compiled from: MotionUtils.java */
/* loaded from: classes.dex */
public final class g {
    public static float a(String[] strArr, int i10) throws NumberFormatException {
        float f10 = Float.parseFloat(strArr[i10]);
        if (f10 >= 0.0f && f10 <= 1.0f) {
            return f10;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f10);
    }

    public static boolean b(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static int resolveThemeDuration(Context context, int i10, int i11) {
        return n7.b.resolveInteger(context, i10, i11);
    }

    public static TimeInterpolator resolveThemeInterpolator(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!(b(strValueOf, "cubic-bezier") || b(strValueOf, ClientCookie.PATH_ATTR))) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!b(strValueOf, "cubic-bezier")) {
            if (b(strValueOf, ClientCookie.PATH_ATTR)) {
                return z0.a.create(o0.d.createPathFromPathData(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return z0.a.create(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }
}
