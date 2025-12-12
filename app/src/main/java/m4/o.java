package m4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;

/* compiled from: Wave.java */
/* loaded from: classes.dex */
public final class o extends l4.g {

    /* compiled from: Wave.java */
    public class a extends l4.c {
        public a() {
            setScaleY(0.4f);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.2f, 0.4f, 1.0f};
            j4.d dVar = new j4.d(this);
            Float fValueOf = Float.valueOf(0.4f);
            return dVar.scaleY(fArr, fValueOf, Float.valueOf(1.0f), fValueOf, fValueOf).duration(1200L).easeInOut(fArr).build();
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iWidth = rectClipSquare.width() / getChildCount();
        int iWidth2 = ((rectClipSquare.width() / 5) * 3) / 5;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            l4.f childAt = getChildAt(i10);
            int i11 = (iWidth / 5) + (i10 * iWidth) + rectClipSquare.left;
            childAt.setDrawBounds(i11, rectClipSquare.top, i11 + iWidth2, rectClipSquare.bottom);
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        a[] aVarArr = new a[5];
        for (int i10 = 0; i10 < 5; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.setAnimationDelay((i10 * 100) + 600);
            } else {
                aVar.setAnimationDelay((i10 * 100) - 1200);
            }
        }
        return aVarArr;
    }
}
