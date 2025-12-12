package a2;

import a2.a;

/* compiled from: GlobalMediaRouter.java */
/* loaded from: classes.dex */
public final class c extends x1.f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a.d f89g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a.d dVar, int i10, int i11, int i12, String str) {
        super(i10, i11, i12, str);
        this.f89g = dVar;
    }

    @Override // x1.f
    public void onAdjustVolume(int i10) {
        a.this.f57m.post(new b(this, i10, 0));
    }

    @Override // x1.f
    public void onSetVolumeTo(int i10) {
        a.this.f57m.post(new b(this, i10, 1));
    }
}
