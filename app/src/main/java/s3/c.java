package s3;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class c extends f<Float> {
    public c(List<b4.a<Float>> list) {
        super(list);
    }

    public final float c(b4.a<Float> aVar, float f10) {
        Float f11;
        if (aVar.f4756b == null || aVar.f4757c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b4.c<A> cVar = this.f19022e;
        return (cVar == 0 || (f11 = (Float) cVar.getValueInternal(aVar.f4759e, aVar.f4760f.floatValue(), aVar.f4756b, aVar.f4757c, f10, b(), getProgress())) == null) ? a4.g.lerp(aVar.getStartValueFloat(), aVar.getEndValueFloat(), f10) : f11.floatValue();
    }

    public float getFloatValue() {
        return c(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }

    @Override // s3.a
    public final Object getValue(b4.a aVar, float f10) {
        return Float.valueOf(c(aVar, f10));
    }
}
