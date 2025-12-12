package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b0.k;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class zzee extends AnimatorListenerAdapter {
    private final k zza = new k();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.zza.put(animator, Boolean.TRUE);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.zza.put(animator, Boolean.FALSE);
    }

    public final boolean zza(Animator animator) {
        return this.zza.containsKey(animator) && ((Boolean) this.zza.get(animator)).booleanValue();
    }
}
