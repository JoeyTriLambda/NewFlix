package l4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* compiled from: ShapeSprite.java */
/* loaded from: classes.dex */
public abstract class e extends f {
    public final Paint M;
    public int N;
    public int O;

    public e() {
        setColor(-1);
        Paint paint = new Paint();
        this.M = paint;
        paint.setAntiAlias(true);
        paint.setColor(this.N);
    }

    @Override // l4.f
    public final void drawSelf(Canvas canvas) {
        Paint paint = this.M;
        paint.setColor(this.N);
        drawShape(canvas, paint);
    }

    public abstract void drawShape(Canvas canvas, Paint paint);

    @Override // l4.f
    public int getColor() {
        return this.O;
    }

    @Override // l4.f, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        super.setAlpha(i10);
        int alpha = getAlpha();
        int i11 = this.O;
        this.N = ((((i11 >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((i11 << 8) >>> 8);
    }

    @Override // l4.f
    public void setColor(int i10) {
        this.O = i10;
        int alpha = getAlpha();
        int i11 = this.O;
        this.N = ((((i11 >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((i11 << 8) >>> 8);
    }

    @Override // l4.f, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.M.setColorFilter(colorFilter);
    }
}
