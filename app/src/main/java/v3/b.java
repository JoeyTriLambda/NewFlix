package v3;

import java.util.Collections;
import java.util.List;

/* compiled from: AnimatableFloatValue.java */
/* loaded from: classes.dex */
public final class b extends n<Float, Float> {
    public b() {
        super(Collections.singletonList(new b4.a(Float.valueOf(0.0f))));
    }

    @Override // v3.m
    public s3.a<Float, Float> createAnimation() {
        return new s3.c(this.f20461a);
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

    public b(List<b4.a<Float>> list) {
        super(list);
    }
}
