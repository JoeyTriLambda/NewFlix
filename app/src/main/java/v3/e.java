package v3;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public final class e implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final List<b4.a<PointF>> f20445a;

    public e(List<b4.a<PointF>> list) {
        this.f20445a = list;
    }

    @Override // v3.m
    public s3.a<PointF, PointF> createAnimation() {
        List<b4.a<PointF>> list = this.f20445a;
        return list.get(0).isStatic() ? new s3.j(list) : new s3.i(list);
    }

    @Override // v3.m
    public List<b4.a<PointF>> getKeyframes() {
        return this.f20445a;
    }

    @Override // v3.m
    public boolean isStatic() {
        List<b4.a<PointF>> list = this.f20445a;
        return list.size() == 1 && list.get(0).isStatic();
    }
}
