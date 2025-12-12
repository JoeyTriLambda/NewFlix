package s3;

import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class k extends f<b4.d> {

    /* renamed from: i, reason: collision with root package name */
    public final b4.d f19043i;

    public k(List<b4.a<b4.d>> list) {
        super(list);
        this.f19043i = new b4.d();
    }

    @Override // s3.a
    public /* bridge */ /* synthetic */ Object getValue(b4.a aVar, float f10) {
        return getValue((b4.a<b4.d>) aVar, f10);
    }

    @Override // s3.a
    public b4.d getValue(b4.a<b4.d> aVar, float f10) {
        b4.d dVar;
        b4.d dVar2;
        b4.d dVar3 = aVar.f4756b;
        if (dVar3 == null || (dVar = aVar.f4757c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b4.d dVar4 = dVar3;
        b4.d dVar5 = dVar;
        b4.c<A> cVar = this.f19022e;
        if (cVar != 0 && (dVar2 = (b4.d) cVar.getValueInternal(aVar.f4759e, aVar.f4760f.floatValue(), dVar4, dVar5, f10, b(), getProgress())) != null) {
            return dVar2;
        }
        float fLerp = a4.g.lerp(dVar4.getScaleX(), dVar5.getScaleX(), f10);
        float fLerp2 = a4.g.lerp(dVar4.getScaleY(), dVar5.getScaleY(), f10);
        b4.d dVar6 = this.f19043i;
        dVar6.set(fLerp, fLerp2);
        return dVar6;
    }
}
