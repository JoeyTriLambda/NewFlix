package s3;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class i extends f<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f19038i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f19039j;

    /* renamed from: k, reason: collision with root package name */
    public h f19040k;

    /* renamed from: l, reason: collision with root package name */
    public final PathMeasure f19041l;

    public i(List<? extends b4.a<PointF>> list) {
        super(list);
        this.f19038i = new PointF();
        this.f19039j = new float[2];
        this.f19041l = new PathMeasure();
    }

    @Override // s3.a
    public /* bridge */ /* synthetic */ Object getValue(b4.a aVar, float f10) {
        return getValue((b4.a<PointF>) aVar, f10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s3.a
    public PointF getValue(b4.a<PointF> aVar, float f10) {
        PointF pointF;
        h hVar = (h) aVar;
        Path path = hVar.f19036o;
        if (path == null) {
            return aVar.f4756b;
        }
        b4.c<A> cVar = this.f19022e;
        if (cVar != 0 && (pointF = (PointF) cVar.getValueInternal(hVar.f4759e, hVar.f4760f.floatValue(), hVar.f4756b, hVar.f4757c, b(), f10, getProgress())) != null) {
            return pointF;
        }
        h hVar2 = this.f19040k;
        PathMeasure pathMeasure = this.f19041l;
        if (hVar2 != hVar) {
            pathMeasure.setPath(path, false);
            this.f19040k = hVar;
        }
        float length = pathMeasure.getLength() * f10;
        float[] fArr = this.f19039j;
        pathMeasure.getPosTan(length, fArr, null);
        PointF pointF2 = this.f19038i;
        pointF2.set(fArr[0], fArr[1]);
        return pointF2;
    }
}
