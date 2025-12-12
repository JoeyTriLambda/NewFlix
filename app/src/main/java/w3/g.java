package w3;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20917a;

    /* renamed from: b, reason: collision with root package name */
    public PointF f20918b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20919c;

    public g(PointF pointF, boolean z10, List<u3.a> list) {
        this.f20918b = pointF;
        this.f20919c = z10;
        this.f20917a = new ArrayList(list);
    }

    public List<u3.a> getCurves() {
        return this.f20917a;
    }

    public PointF getInitialPoint() {
        return this.f20918b;
    }

    public void interpolateBetween(g gVar, g gVar2, float f10) {
        if (this.f20918b == null) {
            this.f20918b = new PointF();
        }
        this.f20919c = gVar.isClosed() || gVar2.isClosed();
        if (gVar.getCurves().size() != gVar2.getCurves().size()) {
            a4.d.warning("Curves must have the same number of control points. Shape 1: " + gVar.getCurves().size() + "\tShape 2: " + gVar2.getCurves().size());
        }
        int iMin = Math.min(gVar.getCurves().size(), gVar2.getCurves().size());
        ArrayList arrayList = this.f20917a;
        if (arrayList.size() < iMin) {
            for (int size = arrayList.size(); size < iMin; size++) {
                arrayList.add(new u3.a());
            }
        } else if (arrayList.size() > iMin) {
            for (int size2 = arrayList.size() - 1; size2 >= iMin; size2--) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
        PointF initialPoint = gVar.getInitialPoint();
        PointF initialPoint2 = gVar2.getInitialPoint();
        float fLerp = a4.g.lerp(initialPoint.x, initialPoint2.x, f10);
        float fLerp2 = a4.g.lerp(initialPoint.y, initialPoint2.y, f10);
        if (this.f20918b == null) {
            this.f20918b = new PointF();
        }
        this.f20918b.set(fLerp, fLerp2);
        for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
            u3.a aVar = gVar.getCurves().get(size3);
            u3.a aVar2 = gVar2.getCurves().get(size3);
            PointF controlPoint1 = aVar.getControlPoint1();
            PointF controlPoint2 = aVar.getControlPoint2();
            PointF vertex = aVar.getVertex();
            PointF controlPoint12 = aVar2.getControlPoint1();
            PointF controlPoint22 = aVar2.getControlPoint2();
            PointF vertex2 = aVar2.getVertex();
            ((u3.a) arrayList.get(size3)).setControlPoint1(a4.g.lerp(controlPoint1.x, controlPoint12.x, f10), a4.g.lerp(controlPoint1.y, controlPoint12.y, f10));
            ((u3.a) arrayList.get(size3)).setControlPoint2(a4.g.lerp(controlPoint2.x, controlPoint22.x, f10), a4.g.lerp(controlPoint2.y, controlPoint22.y, f10));
            ((u3.a) arrayList.get(size3)).setVertex(a4.g.lerp(vertex.x, vertex2.x, f10), a4.g.lerp(vertex.y, vertex2.y, f10));
        }
    }

    public boolean isClosed() {
        return this.f20919c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f20917a.size() + "closed=" + this.f20919c + '}';
    }

    public g() {
        this.f20917a = new ArrayList();
    }
}
