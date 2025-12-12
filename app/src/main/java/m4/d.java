package m4;

import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: DoubleBounce.java */
/* loaded from: classes.dex */
public final class d extends l4.g {

    /* compiled from: DoubleBounce.java */
    public class a extends l4.b {
        public a() {
            setAlpha(153);
            setScale(0.0f);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            j4.d dVar = new j4.d(this);
            Float fValueOf = Float.valueOf(0.0f);
            return dVar.scale(fArr, fValueOf, Float.valueOf(1.0f), fValueOf).duration(2000L).easeInOut(fArr).build();
        }
    }

    @Override // l4.g
    public void onChildCreated(l4.f... fVarArr) {
        super.onChildCreated(fVarArr);
        if (Build.VERSION.SDK_INT >= 24) {
            fVarArr[1].setAnimationDelay(1000);
        } else {
            fVarArr[1].setAnimationDelay(-1000);
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        return new l4.f[]{new a(), new a()};
    }
}
