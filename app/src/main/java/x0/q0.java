package x0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class q0 extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f21297b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f21298m;

    public q0(s0 s0Var, View view) {
        this.f21297b = s0Var;
        this.f21298m = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f21297b.onAnimationCancel(this.f21298m);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f21297b.onAnimationEnd(this.f21298m);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f21297b.onAnimationStart(this.f21298m);
    }
}
