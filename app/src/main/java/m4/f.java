package m4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import cz.msebera.android.httpclient.HttpStatus;

/* compiled from: FoldingCube.java */
/* loaded from: classes.dex */
public final class f extends l4.g {

    /* compiled from: FoldingCube.java */
    public class a extends l4.c {
        public a() {
            setAlpha(0);
            setRotateX(-180);
        }

        @Override // l4.f
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            return new j4.d(this).alpha(fArr, 0, 0, 255, 255, 0, 0).rotateX(fArr, -180, -180, 0, 0, 0, 0).rotateY(fArr, 0, 0, 0, 0, 180, 180).duration(2400L).interpolator(new LinearInterpolator()).build();
        }
    }

    @Override // l4.g
    public void drawChild(Canvas canvas) {
        Rect rectClipSquare = clipSquare(getBounds());
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int iSave = canvas.save();
            canvas.rotate((i10 * 90) + 45, rectClipSquare.centerX(), rectClipSquare.centerY());
            getChildAt(i10).draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iMin = Math.min(rectClipSquare.width(), rectClipSquare.height()) / 2;
        int i10 = rectClipSquare.left + iMin + 1;
        int i11 = rectClipSquare.top + iMin + 1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            l4.f childAt = getChildAt(i12);
            childAt.setDrawBounds(rectClipSquare.left, rectClipSquare.top, i10, i11);
            childAt.setPivotX(childAt.getDrawBounds().right);
            childAt.setPivotY(childAt.getDrawBounds().bottom);
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        a[] aVarArr = new a[4];
        for (int i10 = 0; i10 < 4; i10++) {
            a aVar = new a();
            aVarArr[i10] = aVar;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.setAnimationDelay(i10 * HttpStatus.SC_MULTIPLE_CHOICES);
            } else {
                aVar.setAnimationDelay((i10 * HttpStatus.SC_MULTIPLE_CHOICES) - 1200);
            }
        }
        return aVarArr;
    }
}
