package wa;

import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: Circle.java */
/* loaded from: classes2.dex */
public final class b extends c {

    /* renamed from: b, reason: collision with root package name */
    public final PointF f21047b = new PointF();

    /* renamed from: c, reason: collision with root package name */
    public float f21048c;

    public void draw(Canvas canvas) {
        PointF pointF = this.f21047b;
        canvas.drawCircle(pointF.x, pointF.y, this.f21048c, this.f21049a);
    }

    public void setCenter(float f10, float f11) {
        this.f21047b.set(f10, f11);
    }

    public void setRadius(float f10) {
        this.f21048c = f10;
    }
}
