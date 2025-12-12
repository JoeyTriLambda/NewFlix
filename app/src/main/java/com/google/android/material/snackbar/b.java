package com.google.android.material.snackbar;

import android.animation.ValueAnimator;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f9328b;

    public b(BaseTransientBottomBar baseTransientBottomBar) {
        this.f9328b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        BaseTransientBottomBar baseTransientBottomBar = this.f9328b;
        baseTransientBottomBar.f9292i.setScaleX(fFloatValue);
        baseTransientBottomBar.f9292i.setScaleY(fFloatValue);
    }
}
