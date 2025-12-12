package m4;

import android.animation.ValueAnimator;

/* compiled from: PulseRing.java */
/* loaded from: classes.dex */
public final class j extends l4.d {
    public j() {
        setScale(0.0f);
    }

    @Override // l4.f
    public ValueAnimator onCreateAnimation() {
        float[] fArr = {0.0f, 0.7f, 1.0f};
        j4.d dVar = new j4.d(this);
        Float fValueOf = Float.valueOf(1.0f);
        return dVar.scale(fArr, Float.valueOf(0.0f), fValueOf, fValueOf).alpha(fArr, 255, 178, 0).duration(1000L).interpolator(k4.b.pathInterpolator(0.21f, 0.53f, 0.56f, 0.8f, fArr)).build();
    }
}
