package k4;

import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: PathInterpolatorCompatApi21.java */
/* loaded from: classes.dex */
public final class d {
    @TargetApi(21)
    public static Interpolator create(float f10, float f11, float f12, float f13) {
        return new PathInterpolator(f10, f11, f12, f13);
    }
}
