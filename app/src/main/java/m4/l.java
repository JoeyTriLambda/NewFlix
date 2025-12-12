package m4;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* compiled from: RotatingPlane.java */
/* loaded from: classes.dex */
public final class l extends l4.c {
    @Override // l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        setDrawBounds(clipSquare(rect));
    }

    @Override // l4.f
    public ValueAnimator onCreateAnimation() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        return new j4.d(this).rotateX(fArr, 0, -180, -180).rotateY(fArr, 0, 0, -180).duration(1200L).easeInOut(fArr).build();
    }
}
