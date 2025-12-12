package yc;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import p1.c;

/* compiled from: BottomViewHideShowAnimation.java */
/* loaded from: classes2.dex */
public final class a extends AnimationSet {

    /* renamed from: b, reason: collision with root package name */
    public final View f22052b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f22053m;

    public a(View view, boolean z10, long j10) {
        super(false);
        this.f22053m = z10;
        this.f22052b = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
        alphaAnimation.setDuration(j10);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, z10 ? a(view) : 0, z10 ? 0 : a(view));
        translateAnimation.setInterpolator(z10 ? new c() : new p1.a());
        translateAnimation.setDuration(j10);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new AnimationAnimationListenerC0322a());
    }

    public static int a(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - view.getTop();
    }

    /* compiled from: BottomViewHideShowAnimation.java */
    /* renamed from: yc.a$a, reason: collision with other inner class name */
    public class AnimationAnimationListenerC0322a implements Animation.AnimationListener {
        public AnimationAnimationListenerC0322a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a aVar = a.this;
            aVar.f22052b.setVisibility(aVar.f22053m ? 0 : 8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            a.this.f22052b.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
