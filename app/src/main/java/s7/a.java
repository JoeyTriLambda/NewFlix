package s7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f19114b;

    public a(BaseTransientBottomBar baseTransientBottomBar, int i10) {
        this.f19114b = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f19114b.a();
    }
}
