package com.google.android.material.snackbar;

import android.animation.ValueAnimator;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f9327b;

    public a(BaseTransientBottomBar baseTransientBottomBar) {
        this.f9327b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9327b.f9292i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
