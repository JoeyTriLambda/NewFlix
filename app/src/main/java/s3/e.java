package s3;

import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class e extends f<Integer> {
    public e(List<b4.a<Integer>> list) {
        super(list);
    }

    public final int getIntValue(b4.a<Integer> aVar, float f10) {
        Integer num;
        if (aVar.f4756b == null || aVar.f4757c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b4.c<A> cVar = this.f19022e;
        return (cVar == 0 || (num = (Integer) cVar.getValueInternal(aVar.f4759e, aVar.f4760f.floatValue(), aVar.f4756b, aVar.f4757c, f10, b(), getProgress())) == null) ? a4.g.lerp(aVar.getStartValueInt(), aVar.getEndValueInt(), f10) : num.intValue();
    }

    @Override // s3.a
    public final Object getValue(b4.a aVar, float f10) {
        return Integer.valueOf(getIntValue(aVar, f10));
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
