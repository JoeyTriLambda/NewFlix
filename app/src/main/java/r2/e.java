package r2;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: AnimationUtilsCompat.java */
/* loaded from: classes.dex */
public final class e {
    public static Interpolator loadInterpolator(Context context, int i10) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i10);
    }
}
