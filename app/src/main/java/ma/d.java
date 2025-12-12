package ma;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.lang.ref.WeakReference;
import la.a;

/* compiled from: ViewPropertyAnimatorICS.java */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<ViewPropertyAnimator> f16241b;

    /* compiled from: ViewPropertyAnimatorICS.java */
    public class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0190a f16242b;

        public a(a.InterfaceC0190a interfaceC0190a) {
            this.f16242b = interfaceC0190a;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f16242b.onAnimationCancel(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f16242b.onAnimationEnd(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.f16242b.onAnimationRepeat(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f16242b.onAnimationStart(null);
        }
    }

    public d(View view) {
        this.f16241b = new WeakReference<>(view.animate());
    }

    @Override // ma.b
    public b alpha(float f10) {
        ViewPropertyAnimator viewPropertyAnimator = this.f16241b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f10);
        }
        return this;
    }

    @Override // ma.b
    public b setDuration(long j10) {
        ViewPropertyAnimator viewPropertyAnimator = this.f16241b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j10);
        }
        return this;
    }

    @Override // ma.b
    public b setListener(a.InterfaceC0190a interfaceC0190a) {
        ViewPropertyAnimator viewPropertyAnimator = this.f16241b.get();
        if (viewPropertyAnimator != null) {
            if (interfaceC0190a == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new a(interfaceC0190a));
            }
        }
        return this;
    }

    @Override // ma.b
    public b translationX(float f10) {
        ViewPropertyAnimator viewPropertyAnimator = this.f16241b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f10);
        }
        return this;
    }
}
