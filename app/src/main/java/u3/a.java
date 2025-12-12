package u3;

import android.graphics.PointF;

/* compiled from: CubicCurveData.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final PointF f19978a;

    /* renamed from: b, reason: collision with root package name */
    public final PointF f19979b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF f19980c;

    public a() {
        this.f19978a = new PointF();
        this.f19979b = new PointF();
        this.f19980c = new PointF();
    }

    public PointF getControlPoint1() {
        return this.f19978a;
    }

    public PointF getControlPoint2() {
        return this.f19979b;
    }

    public PointF getVertex() {
        return this.f19980c;
    }

    public void setControlPoint1(float f10, float f11) {
        this.f19978a.set(f10, f11);
    }

    public void setControlPoint2(float f10, float f11) {
        this.f19979b.set(f10, f11);
    }

    public void setVertex(float f10, float f11) {
        this.f19980c.set(f10, f11);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f19978a = pointF;
        this.f19979b = pointF2;
        this.f19980c = pointF3;
    }
}
