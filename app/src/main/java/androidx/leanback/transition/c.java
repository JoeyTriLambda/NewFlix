package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;

/* compiled from: TranslationAnimationCreator.java */
/* loaded from: classes.dex */
public final class c {
    public static ObjectAnimator a(View view, TransitionValues transitionValues, int i10, int i11, float f10, float f11, float f12, float f13, DecelerateInterpolator decelerateInterpolator, Transition transition) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(R.id.transitionPosition)) != null) {
            f10 = (r2[0] - i10) + translationX;
            f11 = (r2[1] - i11) + translationY;
        }
        int iRound = Math.round(f10 - translationX) + i10;
        int iRound2 = Math.round(f11 - translationY) + i11;
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        if (f10 == f12 && f11 == f13) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f10, f11);
        path.lineTo(f12, f13);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, (Property<View, Float>) View.TRANSLATION_Y, path);
        a aVar = new a(view, transitionValues.view, iRound, iRound2, translationX, translationY);
        transition.addListener(aVar);
        objectAnimatorOfFloat.addListener(aVar);
        objectAnimatorOfFloat.addPauseListener(aVar);
        objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        return objectAnimatorOfFloat;
    }

    /* compiled from: TranslationAnimationCreator.java */
    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: b, reason: collision with root package name */
        public final View f3037b;

        /* renamed from: m, reason: collision with root package name */
        public final View f3038m;

        /* renamed from: n, reason: collision with root package name */
        public final int f3039n;

        /* renamed from: o, reason: collision with root package name */
        public final int f3040o;

        /* renamed from: p, reason: collision with root package name */
        public int[] f3041p;

        /* renamed from: q, reason: collision with root package name */
        public float f3042q;

        /* renamed from: r, reason: collision with root package name */
        public float f3043r;

        /* renamed from: s, reason: collision with root package name */
        public final float f3044s;

        /* renamed from: t, reason: collision with root package name */
        public final float f3045t;

        public a(View view, View view2, int i10, int i11, float f10, float f11) {
            this.f3038m = view;
            this.f3037b = view2;
            this.f3039n = i10 - Math.round(view.getTranslationX());
            this.f3040o = i11 - Math.round(view.getTranslationY());
            this.f3044s = f10;
            this.f3045t = f11;
            int i12 = R.id.transitionPosition;
            int[] iArr = (int[]) view2.getTag(i12);
            this.f3041p = iArr;
            if (iArr != null) {
                view2.setTag(i12, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3041p == null) {
                this.f3041p = new int[2];
            }
            int[] iArr = this.f3041p;
            float f10 = this.f3039n;
            View view = this.f3038m;
            iArr[0] = Math.round(view.getTranslationX() + f10);
            this.f3041p[1] = Math.round(view.getTranslationY() + this.f3040o);
            this.f3037b.setTag(R.id.transitionPosition, this.f3041p);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            View view = this.f3038m;
            this.f3042q = view.getTranslationX();
            this.f3043r = view.getTranslationY();
            view.setTranslationX(this.f3044s);
            view.setTranslationY(this.f3045t);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            float f10 = this.f3042q;
            View view = this.f3038m;
            view.setTranslationX(f10);
            view.setTranslationY(this.f3043r);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            float f10 = this.f3044s;
            View view = this.f3038m;
            view.setTranslationX(f10);
            view.setTranslationY(this.f3045t);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }
}
