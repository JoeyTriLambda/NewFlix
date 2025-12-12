package l4;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: RingSprite.java */
/* loaded from: classes.dex */
public class d extends e {
    @Override // l4.e
    public void drawShape(Canvas canvas, Paint paint) {
        if (getDrawBounds() != null) {
            paint.setStyle(Paint.Style.STROKE);
            int iMin = Math.min(getDrawBounds().width(), getDrawBounds().height()) / 2;
            paint.setStrokeWidth(iMin / 12);
            canvas.drawCircle(getDrawBounds().centerX(), getDrawBounds().centerY(), iMin, paint);
        }
    }
}
