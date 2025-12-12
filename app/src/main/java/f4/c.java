package f4;

import f4.k;

/* compiled from: ShadowRippleGenerator.java */
/* loaded from: classes.dex */
public final class c implements k.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f11466a;

    public c(f fVar) {
        this.f11466a = fVar;
    }

    @Override // f4.k.a
    public void onTimeUpdate(float f10) {
        f fVar = this.f11466a;
        fVar.getClass();
        f.a(fVar, f10);
        fVar.f11485p = fVar.f11486q * f10;
        fVar.f11470a.invalidate();
    }
}
