package f4;

import android.view.animation.Animation;

/* compiled from: ShadowRippleGenerator.java */
/* loaded from: classes.dex */
public final class e implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11468b;

    public e(f fVar) {
        this.f11468b = fVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f11468b.f11470a.performClick();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
