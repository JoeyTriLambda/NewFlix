package l4;

import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: CircleLayoutContainer.java */
/* loaded from: classes.dex */
public abstract class a extends g {
    @Override // l4.g
    public void drawChild(Canvas canvas) {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f childAt = getChildAt(i10);
            int iSave = canvas.save();
            canvas.rotate((i10 * 360) / getChildCount(), getBounds().centerX(), getBounds().centerY());
            childAt.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // l4.g, l4.f, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iWidth = (int) (((rectClipSquare.width() * 3.141592653589793d) / 3.5999999046325684d) / getChildCount());
        int iCenterX = rectClipSquare.centerX() - iWidth;
        int iCenterX2 = rectClipSquare.centerX() + iWidth;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f childAt = getChildAt(i10);
            int i11 = rectClipSquare.top;
            childAt.setDrawBounds(iCenterX, i11, iCenterX2, (iWidth * 2) + i11);
        }
    }
}
