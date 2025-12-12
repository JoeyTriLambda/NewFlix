package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9533b;

    public a(View view) {
        this.f9533b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9533b.invalidate();
    }
}
