package v3;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public final class i implements m<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final b f20446a;

    /* renamed from: b, reason: collision with root package name */
    public final b f20447b;

    public i(b bVar, b bVar2) {
        this.f20446a = bVar;
        this.f20447b = bVar2;
    }

    @Override // v3.m
    public s3.a<PointF, PointF> createAnimation() {
        return new s3.m(this.f20446a.createAnimation(), this.f20447b.createAnimation());
    }

    @Override // v3.m
    public List<b4.a<PointF>> getKeyframes() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // v3.m
    public boolean isStatic() {
        return this.f20446a.isStatic() && this.f20447b.isStatic();
    }
}
