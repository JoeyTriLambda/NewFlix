package m4;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import cz.msebera.android.httpclient.HttpStatus;

/* compiled from: CubeGrid.java */
/* loaded from: classes.dex */
public final class c extends l4.g {

    /* compiled from: CubeGrid.java */
    public class a extends l4.c {
        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.35f, 0.7f, 1.0f};
            j4.d dVar = new j4.d(this);
            Float fValueOf = Float.valueOf(1.0f);
            return dVar.scale(fArr, fValueOf, Float.valueOf(0.0f), fValueOf, fValueOf).duration(1300L).easeInOut(fArr).build();
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iWidth = (int) (rectClipSquare.width() * 0.33f);
        int iHeight = (int) (rectClipSquare.height() * 0.33f);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int i11 = ((i10 % 3) * iWidth) + rectClipSquare.left;
            int i12 = ((i10 / 3) * iHeight) + rectClipSquare.top;
            getChildAt(i10).setDrawBounds(i11, i12, i11 + iWidth, i12 + iHeight);
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        int[] iArr = {200, HttpStatus.SC_MULTIPLE_CHOICES, HttpStatus.SC_BAD_REQUEST, 100, 200, HttpStatus.SC_MULTIPLE_CHOICES, 0, 100, 200};
        a[] aVarArr = new a[9];
        for (int i10 = 0; i10 < 9; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            aVar.setAnimationDelay(iArr[i10]);
        }
        return aVarArr;
    }
}
