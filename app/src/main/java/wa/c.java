package wa;

import android.graphics.Paint;

/* compiled from: GraphicObject.java */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f21049a;

    public c() {
        Paint paint = new Paint();
        this.f21049a = paint;
        paint.setAntiAlias(true);
    }

    public void setAlpha(int i10) {
        this.f21049a.setAlpha(i10);
    }

    public void setColor(int i10) {
        this.f21049a.setColor(i10);
    }

    public void setStyle(Paint.Style style) {
        this.f21049a.setStyle(style);
    }

    public void setWidth(float f10) {
        this.f21049a.setStrokeWidth(f10);
    }
}
