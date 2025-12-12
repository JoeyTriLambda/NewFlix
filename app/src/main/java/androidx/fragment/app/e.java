package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.m;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2787b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f2788m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f2789n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2790o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ m.a f2791p;

    public e(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, m.a aVar) {
        this.f2787b = viewGroup;
        this.f2788m = view;
        this.f2789n = z10;
        this.f2790o = operation;
        this.f2791p = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f2787b;
        View view = this.f2788m;
        viewGroup.endViewTransition(view);
        boolean z10 = this.f2789n;
        SpecialEffectsController.Operation operation = this.f2790o;
        if (z10) {
            operation.getFinalState().a(view);
        }
        this.f2791p.a();
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animator from operation " + operation + " has ended.");
        }
    }
}
