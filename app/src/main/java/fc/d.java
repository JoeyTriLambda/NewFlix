package fc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import flix.com.vision.bvp.BetterVideoPlayer2;

/* compiled from: BetterVideoPlayer2.java */
/* loaded from: classes2.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11535b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BetterVideoPlayer2 f11536m;

    public d(BetterVideoPlayer2 betterVideoPlayer2, TextView textView) {
        this.f11536m = betterVideoPlayer2;
        this.f11535b = textView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11535b.setVisibility(this.f11536m.P);
    }
}
