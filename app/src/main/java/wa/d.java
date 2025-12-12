package wa;

import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: Line.java */
/* loaded from: classes2.dex */
public final class d extends c {

    /* renamed from: b, reason: collision with root package name */
    public PointF f21050b;

    /* renamed from: c, reason: collision with root package name */
    public PointF f21051c;

    public void draw(Canvas canvas) {
        PointF pointF = this.f21050b;
        float f10 = pointF.x;
        float f11 = pointF.y;
        PointF pointF2 = this.f21051c;
        canvas.drawLine(f10, f11, pointF2.x, pointF2.y, this.f21049a);
    }

    public PointF getPoint1() {
        return this.f21050b;
    }

    public void setPoint1(PointF pointF) {
        this.f21050b = pointF;
    }

    public void setPoint2(PointF pointF) {
        this.f21051c = pointF;
    }
}
