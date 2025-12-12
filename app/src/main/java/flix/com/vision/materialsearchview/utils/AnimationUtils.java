package flix.com.vision.materialsearchview.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewAnimationUtils;
import x0.s0;

/* loaded from: classes2.dex */
public class AnimationUtils {
    @TargetApi(21)
    public static void circleHideView(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        circleHideView(view, 250, animatorListenerAdapter);
    }

    @TargetApi(21)
    public static void circleRevealView(View view, int i10) {
        int width = view.getWidth();
        int height = view.getHeight() / 2;
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, width, height, 0.0f, (float) Math.hypot(width, height));
        if (i10 > 0) {
            animatorCreateCircularReveal.setDuration(i10);
        } else {
            animatorCreateCircularReveal.setDuration(250L);
        }
        view.setVisibility(0);
        animatorCreateCircularReveal.start();
    }

    @TargetApi(21)
    public static void circleHideView(View view, int i10, AnimatorListenerAdapter animatorListenerAdapter) {
        int width = view.getWidth();
        int height = view.getHeight() / 2;
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, width, height, (float) Math.hypot(width, height), 0.0f);
        animatorCreateCircularReveal.addListener(animatorListenerAdapter);
        if (i10 > 0) {
            animatorCreateCircularReveal.setDuration(i10);
        } else {
            animatorCreateCircularReveal.setDuration(250L);
        }
        animatorCreateCircularReveal.start();
    }

    @TargetApi(21)
    public static void circleRevealView(View view) {
        circleRevealView(view, 250);
    }

    /* renamed from: flix.com.vision.materialsearchview.utils.AnimationUtils$1, reason: invalid class name */
    class AnonymousClass1 implements s0 {
        @Override // x0.s0
        public void onAnimationEnd(View view) {
            view.setVisibility(8);
            view.setAlpha(1.0f);
            view.setDrawingCacheEnabled(false);
        }

        @Override // x0.s0
        public void onAnimationStart(View view) {
            view.setDrawingCacheEnabled(true);
        }

        @Override // x0.s0
        public void onAnimationCancel(View view) {
        }
    }
}
