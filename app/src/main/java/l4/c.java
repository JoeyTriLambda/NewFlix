package l4;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: RectSprite.java */
/* loaded from: classes.dex */
public class c extends e {
    @Override // l4.e
    public void drawShape(Canvas canvas, Paint paint) {
        if (getDrawBounds() != null) {
            canvas.drawRect(getDrawBounds(), paint);
        }
    }
}
