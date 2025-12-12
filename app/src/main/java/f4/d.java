package f4;

import f4.k;

/* compiled from: ShadowRippleGenerator.java */
/* loaded from: classes.dex */
public final class d implements k.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f11467a;

    public d(f fVar) {
        this.f11467a = fVar;
    }

    @Override // f4.k.a
    public void onTimeUpdate(float f10) {
        f fVar = this.f11467a;
        fVar.getClass();
        f.a(fVar, 1.0f - f10);
        float f11 = fVar.f11485p;
        float f12 = fVar.f11486q;
        float f13 = f11 < f12 ? f12 - f11 : 0.0f;
        fVar.f11485p = (f12 - f13) + (((fVar.f11489t - f12) - f13) * f10);
        int i10 = (int) ((1.0f - f10) * 100.0f);
        fVar.f11475f = i10;
        fVar.f11474e = a.getNewColorAlpha(fVar.f11476g, i10);
        fVar.f11492w.setColor(fVar.f11474e);
        fVar.f11470a.invalidate();
    }
}
