package androidx.mediarouter.app;

import android.view.animation.Animation;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class g implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3627b;

    public g(h hVar) {
        this.f3627b = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f3627b.g(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
