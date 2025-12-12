package x3;

import s3.a;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public final class a implements a.InterfaceC0246a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.airbnb.lottie.model.layer.a f21498a;

    public a(com.airbnb.lottie.model.layer.a aVar) {
        this.f21498a = aVar;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        com.airbnb.lottie.model.layer.a aVar = this.f21498a;
        boolean z10 = aVar.f5515q.getFloatValue() == 1.0f;
        if (z10 != aVar.f5521w) {
            aVar.f5521w = z10;
            aVar.f5512n.invalidateSelf();
        }
    }
}
