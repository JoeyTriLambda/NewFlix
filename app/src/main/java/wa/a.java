package wa;

import android.graphics.Canvas;
import android.graphics.RectF;

/* compiled from: Arc.java */
/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public RectF f21044b;

    /* renamed from: c, reason: collision with root package name */
    public float f21045c;

    /* renamed from: d, reason: collision with root package name */
    public float f21046d;

    public void draw(Canvas canvas) {
        canvas.drawArc(this.f21044b, this.f21045c, this.f21046d, false, this.f21049a);
    }

    public float getStartAngle() {
        return this.f21045c;
    }

    public void setOval(RectF rectF) {
        this.f21044b = rectF;
    }

    public void setStartAngle(float f10) {
        this.f21045c = f10;
    }

    public void setSweepAngle(float f10) {
        this.f21046d = f10;
    }
}
