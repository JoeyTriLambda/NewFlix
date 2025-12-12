package f4;

import f4.k;

/* compiled from: ShadowSelectorGenerator.java */
/* loaded from: classes.dex */
public final class h implements k.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f11513a;

    public h(g gVar) {
        this.f11513a = gVar;
    }

    @Override // f4.k.a
    public void onTimeUpdate(float f10) {
        g gVar = this.f11513a;
        gVar.getClass();
        gVar.a(f10);
        gVar.f11502g = ((Integer) gVar.f11503h.evaluate(f10, Integer.valueOf(gVar.f11500e), Integer.valueOf(gVar.f11501f))).intValue();
        gVar.f11496a.invalidate();
    }
}
