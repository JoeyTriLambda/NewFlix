package zb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: SimpleVideoPlayer.java */
/* loaded from: classes2.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22671b;

    public k(SimpleVideoPlayer simpleVideoPlayer) {
        this.f22671b = simpleVideoPlayer;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f22671b.O.setVisibility(8);
    }
}
