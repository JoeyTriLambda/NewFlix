package fc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import flix.com.vision.bvp.BetterVideoPlayer;

/* compiled from: BetterVideoPlayer.java */
/* loaded from: classes2.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11533b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BetterVideoPlayer f11534m;

    public c(BetterVideoPlayer betterVideoPlayer, TextView textView) {
        this.f11534m = betterVideoPlayer;
        this.f11533b = textView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11533b.setVisibility(this.f11534m.N);
    }
}
