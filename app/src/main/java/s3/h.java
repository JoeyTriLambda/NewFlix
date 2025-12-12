package s3;

import android.graphics.Path;
import android.graphics.PointF;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public final class h extends b4.a<PointF> {

    /* renamed from: o, reason: collision with root package name */
    public Path f19036o;

    /* renamed from: p, reason: collision with root package name */
    public final b4.a<PointF> f19037p;

    public h(p3.d dVar, b4.a<PointF> aVar) {
        super(dVar, aVar.f4756b, aVar.f4757c, aVar.f4758d, aVar.f4759e, aVar.f4760f);
        this.f19037p = aVar;
        createPath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createPath() {
        T t10 = this.f4757c;
        T t11 = this.f4756b;
        boolean z10 = (t10 == 0 || t11 == 0 || !((PointF) t11).equals(((PointF) t10).x, ((PointF) t10).y)) ? false : true;
        T t12 = this.f4757c;
        if (t12 == 0 || z10) {
            return;
        }
        b4.a<PointF> aVar = this.f19037p;
        this.f19036o = a4.h.createPath((PointF) t11, (PointF) t12, aVar.f4767m, aVar.f4768n);
    }
}
