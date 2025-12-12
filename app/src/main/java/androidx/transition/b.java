package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.e;
import q2.k;
import q2.m;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public final class b extends i {

    /* compiled from: Fade.java */
    public static class a extends AnimatorListenerAdapter implements e.InterfaceC0045e {

        /* renamed from: b, reason: collision with root package name */
        public final View f4384b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f4385m = false;

        public a(View view) {
            this.f4384b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            k.f17789a.setTransitionAlpha(this.f4384b, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f4384b;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.f4385m = true;
                view.setLayerType(2, null);
            }
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionPause(e eVar) {
            View view = this.f4384b;
            view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? k.f17789a.getTransitionAlpha(view) : 0.0f));
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionResume(e eVar) {
            this.f4384b.setTag(R.id.transition_pause_alpha, null);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(e eVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            boolean z11 = this.f4385m;
            View view = this.f4384b;
            if (z11) {
                view.setLayerType(0, null);
            }
            if (z10) {
                return;
            }
            m mVar = k.f17789a;
            mVar.setTransitionAlpha(view, 1.0f);
            mVar.clearNonTransitionAlpha(view);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionEnd(e eVar, boolean z10) {
            q2.f.a(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(e eVar, boolean z10) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionCancel(e eVar) {
        }
    }

    public b(int i10) {
        setMode(i10);
    }

    public static float p(q2.i iVar, float f10) {
        Float f11;
        return (iVar == null || (f11 = (Float) iVar.f17785a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // androidx.transition.i, androidx.transition.e
    public void captureStartValues(q2.i iVar) {
        super.captureStartValues(iVar);
        Float fValueOf = (Float) iVar.f17786b.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            View view = iVar.f17786b;
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(k.f17789a.getTransitionAlpha(view)) : Float.valueOf(0.0f);
        }
        iVar.f17785a.put("android:fade:transitionAlpha", fValueOf);
    }

    public final ObjectAnimator o(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        k.f17789a.setTransitionAlpha(view, f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, k.f17790b, f11);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        getRootTransition().addListener(aVar);
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.i
    public Animator onAppear(ViewGroup viewGroup, View view, q2.i iVar, q2.i iVar2) {
        k.f17789a.saveNonTransitionAlpha(view);
        return o(view, p(iVar, 0.0f), 1.0f);
    }

    @Override // androidx.transition.i
    public Animator onDisappear(ViewGroup viewGroup, View view, q2.i iVar, q2.i iVar2) {
        m mVar = k.f17789a;
        mVar.saveNonTransitionAlpha(view);
        ObjectAnimator objectAnimatorO = o(view, p(iVar, 1.0f), 0.0f);
        if (objectAnimatorO == null) {
            mVar.setTransitionAlpha(view, p(iVar2, 1.0f));
        }
        return objectAnimatorO;
    }

    public b() {
    }
}
