package zb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: SimpleVideoPlayer.java */
/* loaded from: classes2.dex */
public final class j extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22670b;

    public j(SimpleVideoPlayer simpleVideoPlayer) {
        this.f22670b = simpleVideoPlayer;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SimpleVideoPlayer simpleVideoPlayer = this.f22670b;
        simpleVideoPlayer.f11998p0.setVisibility(8);
        simpleVideoPlayer.f11985e0.hideControls();
        simpleVideoPlayer.f11985e0.hideToolbar();
    }
}
