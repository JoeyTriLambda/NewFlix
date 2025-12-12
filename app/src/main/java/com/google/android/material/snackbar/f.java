package com.google.android.material.snackbar;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f9332b;

    public f(BaseTransientBottomBar baseTransientBottomBar) {
        this.f9332b = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar baseTransientBottomBar = this.f9332b;
        BaseTransientBottomBar.g gVar = baseTransientBottomBar.f9292i;
        if (gVar == null) {
            return;
        }
        ViewParent parent = gVar.getParent();
        BaseTransientBottomBar.g gVar2 = baseTransientBottomBar.f9292i;
        if (parent != null) {
            gVar2.setVisibility(0);
        }
        if (gVar2.getAnimationMode() == 1) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(baseTransientBottomBar.f9287d);
            valueAnimatorOfFloat.addUpdateListener(new a(baseTransientBottomBar));
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
            valueAnimatorOfFloat2.setInterpolator(baseTransientBottomBar.f9289f);
            valueAnimatorOfFloat2.addUpdateListener(new b(baseTransientBottomBar));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
            animatorSet.setDuration(baseTransientBottomBar.f9284a);
            animatorSet.addListener(new s7.e(baseTransientBottomBar));
            animatorSet.start();
            return;
        }
        int height = gVar2.getHeight();
        ViewGroup.LayoutParams layoutParams = gVar2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            height += ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        gVar2.setTranslationY(height);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(height, 0);
        valueAnimator.setInterpolator(baseTransientBottomBar.f9288e);
        valueAnimator.setDuration(baseTransientBottomBar.f9286c);
        valueAnimator.addListener(new s7.b(baseTransientBottomBar));
        valueAnimator.addUpdateListener(new c(baseTransientBottomBar, height));
        valueAnimator.start();
    }
}
