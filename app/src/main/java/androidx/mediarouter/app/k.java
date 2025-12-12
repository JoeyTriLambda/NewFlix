package androidx.mediarouter.app;

import android.view.animation.Animation;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class k implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3688b;

    public k(h hVar) {
        this.f3688b = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar = this.f3688b;
        hVar.R.startAnimationAll();
        hVar.R.postDelayed(hVar.B0, hVar.f3652u0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
