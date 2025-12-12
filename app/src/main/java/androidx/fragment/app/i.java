package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2839b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2840m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f2841n;

    public i(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z10, b0.b bVar) {
        this.f2839b = operation;
        this.f2840m = operation2;
        this.f2841n = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment = this.f2839b.getFragment();
        Fragment fragment2 = this.f2840m.getFragment();
        i0 i0Var = h0.f2837a;
        if (this.f2841n) {
            fragment2.getClass();
        } else {
            fragment.getClass();
        }
    }
}
