package o3;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;

/* compiled from: RippleHelper.java */
@TargetApi(21)
/* loaded from: classes.dex */
public final class b {
    public static void applyColor(Drawable drawable, int i10) {
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ColorStateList.valueOf(i10));
        }
    }
}
