package fc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import flix.com.vision.bvp.BetterVideoPlayer2;

/* compiled from: BetterVideoPlayer2.java */
/* loaded from: classes2.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BetterVideoPlayer2 f11537b;

    public e(BetterVideoPlayer2 betterVideoPlayer2) {
        this.f11537b = betterVideoPlayer2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view = this.f11537b.A;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
