package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;

/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a7.c f9534b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Drawable f9535m;

    public b(a7.c cVar, Drawable drawable) {
        this.f9534b = cVar;
        this.f9535m = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f9534b.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f9534b.setCircularRevealOverlayDrawable(this.f9535m);
    }
}
