package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.d;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public boolean f9134b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f9135m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d.f f9136n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d f9137o;

    public b(d dVar, boolean z10, a aVar) {
        this.f9137o = dVar;
        this.f9135m = z10;
        this.f9136n = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f9134b = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d dVar = this.f9137o;
        dVar.f9156m = 0;
        dVar.f9150g = null;
        if (this.f9134b) {
            return;
        }
        FloatingActionButton floatingActionButton = dVar.f9160q;
        boolean z10 = this.f9135m;
        floatingActionButton.internalSetVisibility(z10 ? 8 : 4, z10);
        d.f fVar = this.f9136n;
        if (fVar != null) {
            ((a) fVar).onHidden();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        d dVar = this.f9137o;
        dVar.f9160q.internalSetVisibility(0, this.f9135m);
        dVar.f9156m = 1;
        dVar.f9150g = animator;
        this.f9134b = false;
    }
}
