package f4;

import android.view.animation.Animation;

/* compiled from: ShadowSelectorGenerator.java */
/* loaded from: classes.dex */
public final class j implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f11515b;

    public j(g gVar) {
        this.f11515b = gVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f11515b.f11496a.performClick();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
