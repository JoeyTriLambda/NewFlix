package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9400b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f9401m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ TabLayout.e f9402n;

    public b(TabLayout.e eVar, View view, View view2) {
        this.f9402n = eVar;
        this.f9400b = view;
        this.f9401m = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9402n.c(this.f9400b, this.f9401m, valueAnimator.getAnimatedFraction());
    }
}
