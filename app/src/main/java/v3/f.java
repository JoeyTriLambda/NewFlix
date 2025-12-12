package v3;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatablePointValue.java */
/* loaded from: classes.dex */
public final class f extends n<PointF, PointF> {
    public f(List<b4.a<PointF>> list) {
        super(list);
    }

    @Override // v3.m
    public s3.a<PointF, PointF> createAnimation() {
        return new s3.j(this.f20461a);
    }

    @Override // v3.n, v3.m
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    @Override // v3.n, v3.m
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // v3.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
