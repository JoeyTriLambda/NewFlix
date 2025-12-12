package v7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f20543b;

    public j(k kVar) {
        this.f20543b = kVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        k kVar = this.f20543b;
        kVar.l();
        kVar.f20557r.start();
    }
}
