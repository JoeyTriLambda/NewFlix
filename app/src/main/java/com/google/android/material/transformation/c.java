package com.google.android.material.transformation;

import a7.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a7.c f9536b;

    public c(a7.c cVar) {
        this.f9536b = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        a7.c cVar = this.f9536b;
        c.d revealInfo = cVar.getRevealInfo();
        revealInfo.f375c = Float.MAX_VALUE;
        cVar.setRevealInfo(revealInfo);
    }
}
