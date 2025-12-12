package s7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f19116b;

    public c(BaseTransientBottomBar baseTransientBottomBar, int i10) {
        this.f19116b = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f19116b.a();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        BaseTransientBottomBar baseTransientBottomBar = this.f19116b;
        baseTransientBottomBar.f9293j.animateContentOut(0, baseTransientBottomBar.f9285b);
    }
}
