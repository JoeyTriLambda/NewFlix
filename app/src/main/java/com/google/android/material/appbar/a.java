package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: AppBarLayout.java */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f8773b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f8774m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f8775n;

    public a(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f8775n = baseBehavior;
        this.f8773b = coordinatorLayout;
        this.f8774m = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f8775n.g(this.f8773b, this.f8774m, iIntValue);
    }
}
