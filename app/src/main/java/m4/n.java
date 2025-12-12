package m4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;

/* compiled from: WanderingCubes.java */
/* loaded from: classes.dex */
public final class n extends l4.g {

    /* compiled from: WanderingCubes.java */
    public class a extends l4.c {
        public final int P;

        public a(n nVar, int i10) {
            this.P = i10;
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            j4.d dVarRotate = new j4.d(this).rotate(fArr, 0, -90, -179, -180, -270, -360);
            Float fValueOf = Float.valueOf(0.0f);
            Float fValueOf2 = Float.valueOf(0.75f);
            j4.d dVarTranslateYPercentage = dVarRotate.translateXPercentage(fArr, fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf, fValueOf).translateYPercentage(fArr, fValueOf, fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf);
            Float fValueOf3 = Float.valueOf(1.0f);
            Float fValueOf4 = Float.valueOf(0.5f);
            j4.d dVarEaseInOut = dVarTranslateYPercentage.scale(fArr, fValueOf3, fValueOf4, fValueOf3, fValueOf3, fValueOf4, fValueOf3).duration(1800L).easeInOut(fArr);
            if (Build.VERSION.SDK_INT >= 24) {
                dVarEaseInOut.startFrame(this.P);
            }
            return dVarEaseInOut.build();
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Rect rectClipSquare = clipSquare(rect);
        super.onBoundsChange(rectClipSquare);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            l4.f childAt = getChildAt(i10);
            int i11 = rectClipSquare.left;
            childAt.setDrawBounds(i11, rectClipSquare.top, (rectClipSquare.width() / 4) + i11, (rectClipSquare.height() / 4) + rectClipSquare.top);
        }
    }

    @Override // l4.g
    public void onChildCreated(l4.f... fVarArr) {
        super.onChildCreated(fVarArr);
        if (Build.VERSION.SDK_INT < 24) {
            fVarArr[1].setAnimationDelay(-900);
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        return new l4.f[]{new a(this, 0), new a(this, 3)};
    }
}
