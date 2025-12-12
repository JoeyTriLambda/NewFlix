package s7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.g;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f19115b;

    public b(BaseTransientBottomBar baseTransientBottomBar) {
        this.f19115b = baseTransientBottomBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BaseTransientBottomBar baseTransientBottomBar = this.f19115b;
        baseTransientBottomBar.getClass();
        g.b().onShown(baseTransientBottomBar.f9304u);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        BaseTransientBottomBar baseTransientBottomBar = this.f19115b;
        f fVar = baseTransientBottomBar.f9293j;
        int i10 = baseTransientBottomBar.f9286c;
        int i11 = baseTransientBottomBar.f9284a;
        fVar.animateContentIn(i10 - i11, i11);
    }
}
