package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzf extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f6427b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzh f6428m;

    public zzf(zzh zzhVar, Runnable runnable) {
        this.f6428m = zzhVar;
        this.f6427b = runnable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        zzh zzhVar = this.f6428m;
        zzhVar.setVisibility(8);
        zzhVar.f6436r = null;
        this.f6427b.run();
    }
}
