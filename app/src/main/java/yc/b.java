package yc;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import p1.c;

/* compiled from: TopViewHideShowAnimation.java */
/* loaded from: classes2.dex */
public final class b extends AnimationSet {

    /* renamed from: b, reason: collision with root package name */
    public final View f22055b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f22056m;

    public b(View view, boolean z10, long j10) {
        super(false);
        this.f22056m = z10;
        this.f22055b = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
        alphaAnimation.setDuration(j10);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, z10 ? -view.getHeight() : 0, z10 ? 0 : -view.getHeight());
        translateAnimation.setInterpolator(z10 ? new c() : new p1.a());
        translateAnimation.setDuration(j10);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new a());
    }

    /* compiled from: TopViewHideShowAnimation.java */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b bVar = b.this;
            bVar.f22055b.setVisibility(bVar.f22056m ? 0 : 8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.f22055b.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
