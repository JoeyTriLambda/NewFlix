package s7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.g;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f19118b;

    public e(BaseTransientBottomBar baseTransientBottomBar) {
        this.f19118b = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BaseTransientBottomBar baseTransientBottomBar = this.f19118b;
        baseTransientBottomBar.getClass();
        g.b().onShown(baseTransientBottomBar.f9304u);
    }
}
