package com.google.android.material.snackbar;

import android.animation.ValueAnimator;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f9330b;

    public d(BaseTransientBottomBar baseTransientBottomBar) {
        this.f9330b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        p1.b bVar = BaseTransientBottomBar.f9279v;
        this.f9330b.f9292i.setTranslationY(iIntValue);
    }
}
