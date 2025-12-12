package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import com.google.android.gms.internal.cast.zzeg;
import com.google.android.gms.internal.cast.zzep;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzd extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzh f6424b;

    public zzd(zzh zzhVar) {
        this.f6424b = zzhVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i10 = zzh.f6429y;
        AnimatorSet animatorSet = new AnimatorSet();
        zzh zzhVar = this.f6424b;
        InnerZoneDrawable innerZoneDrawable = zzhVar.f6434p;
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.0f, 1.1f).setDuration(500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.1f, 1.0f).setDuration(500L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, PropertyValuesHolder.ofFloat("pulseScale", 1.1f, 2.0f), PropertyValuesHolder.ofFloat("pulseAlpha", 1.0f, 0.0f)).setDuration(500L);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzep.zzb());
        animatorSet.setStartDelay(500L);
        zzeg.zzd(animatorSet, -1, null);
        zzhVar.f6436r = animatorSet;
        animatorSet.start();
    }
}
