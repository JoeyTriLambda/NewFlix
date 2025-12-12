package androidx.leanback.transition;

import android.animation.ValueAnimator;
import androidx.leanback.widget.c0;

/* compiled from: ParallaxTransition.java */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f3036b;

    public a(c0 c0Var) {
        this.f3036b = c0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3036b.updateValues();
    }
}
