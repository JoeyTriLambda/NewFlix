package m4;

import android.animation.ValueAnimator;

/* compiled from: Pulse.java */
/* loaded from: classes.dex */
public final class i extends l4.b {
    public i() {
        setScale(0.0f);
    }

    @Override // l4.f
    public ValueAnimator onCreateAnimation() {
        float[] fArr = {0.0f, 1.0f};
        return new j4.d(this).scale(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f)).alpha(fArr, 255, 0).duration(1000L).easeInOut(fArr).build();
    }
}
