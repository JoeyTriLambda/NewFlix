package f4;

import f4.k;

/* compiled from: ShadowSelectorGenerator.java */
/* loaded from: classes.dex */
public final class i implements k.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f11514a;

    public i(g gVar) {
        this.f11514a = gVar;
    }

    @Override // f4.k.a
    public void onTimeUpdate(float f10) {
        g gVar = this.f11514a;
        gVar.getClass();
        gVar.a(1.0f - f10);
        gVar.f11502g = ((Integer) gVar.f11503h.evaluate(f10, Integer.valueOf(gVar.f11501f), Integer.valueOf(gVar.f11500e))).intValue();
        gVar.f11496a.invalidate();
    }
}
