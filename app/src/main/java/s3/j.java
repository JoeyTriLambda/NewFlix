package s3;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class j extends f<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f19042i;

    public j(List<b4.a<PointF>> list) {
        super(list);
        this.f19042i = new PointF();
    }

    @Override // s3.a
    public /* bridge */ /* synthetic */ Object getValue(b4.a aVar, float f10) {
        return getValue((b4.a<PointF>) aVar, f10);
    }

    @Override // s3.a
    public PointF getValue(b4.a<PointF> aVar, float f10) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f4756b;
        if (pointF3 == null || (pointF = aVar.f4757c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        b4.c<A> cVar = this.f19022e;
        if (cVar != 0 && (pointF2 = (PointF) cVar.getValueInternal(aVar.f4759e, aVar.f4760f.floatValue(), pointF4, pointF5, f10, b(), getProgress())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f19042i;
        float f11 = pointF4.x;
        float fA = o1.a.a(pointF5.x, f11, f10, f11);
        float f12 = pointF4.y;
        pointF6.set(fA, ((pointF5.y - f12) * f10) + f12);
        return pointF6;
    }
}
