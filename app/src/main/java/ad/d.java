package ad;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: ResourceUtil.java */
/* loaded from: classes2.dex */
public final class d {
    public static ColorStateList getColorStateList(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? context.getResources().getColorStateList(i10, context.getTheme()) : context.getResources().getColorStateList(i10);
    }

    public static Drawable getDrawable(Context context, int i10) {
        return context.getResources().getDrawable(i10, context.getTheme());
    }

    public static Drawable tintList(Context context, int i10, int i11) {
        return tintList(context, getDrawable(context, i10).mutate(), i11);
    }

    public static Drawable tintList(Context context, Drawable drawable, int i10) {
        Drawable drawableWrap = p0.a.wrap(drawable);
        p0.a.setTintList(drawableWrap, getColorStateList(context, i10));
        return drawableWrap;
    }
}
