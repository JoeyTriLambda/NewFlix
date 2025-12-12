package m4;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* compiled from: ThreeBounce.java */
/* loaded from: classes.dex */
public final class m extends l4.g {

    /* compiled from: ThreeBounce.java */
    public class a extends l4.b {
        public a() {
            setScale(0.0f);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.4f, 0.8f, 1.0f};
            j4.d dVar = new j4.d(this);
            Float fValueOf = Float.valueOf(0.0f);
            return dVar.scale(fArr, fValueOf, Float.valueOf(1.0f), fValueOf, fValueOf).duration(1400L).easeInOut(fArr).build();
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iWidth = rectClipSquare.width() / 8;
        int iCenterY = rectClipSquare.centerY() - iWidth;
        int iCenterY2 = rectClipSquare.centerY() + iWidth;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int iWidth2 = ((rectClipSquare.width() * i10) / 3) + rectClipSquare.left;
            getChildAt(i10).setDrawBounds(iWidth2, iCenterY, (iWidth * 2) + iWidth2, iCenterY2);
        }
    }

    @Override // l4.g
    public void onChildCreated(l4.f... fVarArr) {
        super.onChildCreated(fVarArr);
        fVarArr[1].setAnimationDelay(160);
        fVarArr[2].setAnimationDelay(320);
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        return new l4.f[]{new a(), new a(), new a()};
    }
}
