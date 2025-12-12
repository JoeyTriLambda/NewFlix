package q2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0.b f17782b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ androidx.transition.e f17783m;

    public e(androidx.transition.e eVar, b0.b bVar) {
        this.f17783m = eVar;
        this.f17782b = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f17782b.remove(animator);
        this.f17783m.f4409y.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f17783m.f4409y.add(animator);
    }
}
