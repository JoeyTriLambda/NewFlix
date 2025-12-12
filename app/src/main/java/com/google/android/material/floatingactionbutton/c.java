package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.d;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f9138b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d.f f9139m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f9140n;

    public c(d dVar, boolean z10, a aVar) {
        this.f9140n = dVar;
        this.f9138b = z10;
        this.f9139m = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d dVar = this.f9140n;
        dVar.f9156m = 0;
        dVar.f9150g = null;
        d.f fVar = this.f9139m;
        if (fVar != null) {
            ((a) fVar).onShown();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        d dVar = this.f9140n;
        dVar.f9160q.internalSetVisibility(0, this.f9138b);
        dVar.f9156m = 2;
        dVar.f9150g = animator;
    }
}
