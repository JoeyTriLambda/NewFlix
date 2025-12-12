package l7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* compiled from: DrawerLayoutUtils.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f15918a = Color.alpha(-1728053248);

    /* compiled from: DrawerLayoutUtils.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrawerLayout f15919b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f15920m;

        public a(DrawerLayout drawerLayout, View view) {
            this.f15919b = drawerLayout;
            this.f15920m = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f15920m;
            DrawerLayout drawerLayout = this.f15919b;
            drawerLayout.closeDrawer(view, false);
            drawerLayout.setScrimColor(-1728053248);
        }
    }

    public static Animator.AnimatorListener getScrimCloseAnimatorListener(DrawerLayout drawerLayout, View view) {
        return new a(drawerLayout, view);
    }

    public static ValueAnimator.AnimatorUpdateListener getScrimCloseAnimatorUpdateListener(DrawerLayout drawerLayout) {
        return new l7.a(drawerLayout, 0);
    }
}
