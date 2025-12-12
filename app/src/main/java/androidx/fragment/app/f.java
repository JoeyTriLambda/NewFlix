package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import androidx.fragment.app.SpecialEffectsController;
import t0.d;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class f implements d.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animator f2798b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2799m;

    public f(Animator animator, SpecialEffectsController.Operation operation) {
        this.f2798b = animator;
        this.f2799m = operation;
    }

    @Override // t0.d.a
    public void onCancel() {
        this.f2798b.end();
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animator from operation " + this.f2799m + " has been canceled.");
        }
    }
}
