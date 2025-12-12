package s3;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class b extends f<Integer> {
    public b(List<b4.a<Integer>> list) {
        super(list);
    }

    public int getIntValue(b4.a<Integer> aVar, float f10) {
        Integer num;
        Integer num2 = aVar.f4756b;
        if (num2 == null || aVar.f4757c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = aVar.f4757c.intValue();
        b4.c<A> cVar = this.f19022e;
        return (cVar == 0 || (num = (Integer) cVar.getValueInternal(aVar.f4759e, aVar.f4760f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f10, b(), getProgress())) == null) ? a4.b.evaluate(a4.g.clamp(f10, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    @Override // s3.a
    public final Object getValue(b4.a aVar, float f10) {
        return Integer.valueOf(getIntValue(aVar, f10));
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
