package l4;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: CircleSprite.java */
/* loaded from: classes.dex */
public class b extends e {
    @Override // l4.e
    public void drawShape(Canvas canvas, Paint paint) {
        if (getDrawBounds() != null) {
            canvas.drawCircle(getDrawBounds().centerX(), getDrawBounds().centerY(), Math.min(getDrawBounds().width(), getDrawBounds().height()) / 2, paint);
        }
    }
}
