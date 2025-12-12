package s3;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class d extends f<w3.c> {

    /* renamed from: i, reason: collision with root package name */
    public final w3.c f19032i;

    public d(List<b4.a<w3.c>> list) {
        super(list);
        w3.c cVar = list.get(0).f4756b;
        int size = cVar != null ? cVar.getSize() : 0;
        this.f19032i = new w3.c(new float[size], new int[size]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s3.a
    public final Object getValue(b4.a aVar, float f10) {
        w3.c cVar = (w3.c) aVar.f4756b;
        w3.c cVar2 = (w3.c) aVar.f4757c;
        w3.c cVar3 = this.f19032i;
        cVar3.lerp(cVar, cVar2, f10);
        return cVar3;
    }
}
