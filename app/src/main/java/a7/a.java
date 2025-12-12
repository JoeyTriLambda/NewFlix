package a7;

import a7.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

/* compiled from: CircularRevealCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: CircularRevealCompat.java */
    /* renamed from: a7.a$a, reason: collision with other inner class name */
    public class C0006a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f368b;

        public C0006a(c cVar) {
            this.f368b = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f368b.destroyCircularRevealCache();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f368b.buildCircularRevealCache();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator createCircularReveal(c cVar, float f10, float f11, float f12) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(cVar, c.b.f371a, c.a.f369b, new c.d(f10, f11, f12));
        c.d revealInfo = cVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f10, (int) f11, revealInfo.f375c, f12);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    public static Animator.AnimatorListener createCircularRevealListener(c cVar) {
        return new C0006a(cVar);
    }
}
