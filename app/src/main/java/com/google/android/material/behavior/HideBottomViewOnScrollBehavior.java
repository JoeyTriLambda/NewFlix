package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k7.g;
import p1.c;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: u, reason: collision with root package name */
    public static final int f8779u = R.attr.motionDurationLong2;

    /* renamed from: v, reason: collision with root package name */
    public static final int f8780v = R.attr.motionDurationMedium4;

    /* renamed from: w, reason: collision with root package name */
    public static final int f8781w = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<b> f8782b;

    /* renamed from: m, reason: collision with root package name */
    public int f8783m;

    /* renamed from: n, reason: collision with root package name */
    public int f8784n;

    /* renamed from: o, reason: collision with root package name */
    public TimeInterpolator f8785o;

    /* renamed from: p, reason: collision with root package name */
    public TimeInterpolator f8786p;

    /* renamed from: q, reason: collision with root package name */
    public int f8787q;

    /* renamed from: r, reason: collision with root package name */
    public int f8788r;

    /* renamed from: s, reason: collision with root package name */
    public int f8789s;

    /* renamed from: t, reason: collision with root package name */
    public ViewPropertyAnimator f8790t;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f8790t = null;
        }
    }

    public interface b {
        void onStateChanged(View view, int i10);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f8782b = new LinkedHashSet<>();
        this.f8787q = 0;
        this.f8788r = 2;
        this.f8789s = 0;
    }

    public final void a(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f8790t = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    public boolean isScrolledDown() {
        return this.f8788r == 1;
    }

    public boolean isScrolledUp() {
        return this.f8788r == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        this.f8787q = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        this.f8783m = g.resolveThemeDuration(v10.getContext(), f8779u, 225);
        this.f8784n = g.resolveThemeDuration(v10.getContext(), f8780v, 175);
        Context context = v10.getContext();
        c cVar = p6.a.f17607d;
        int i11 = f8781w;
        this.f8785o = g.resolveThemeInterpolator(context, i11, cVar);
        this.f8786p = g.resolveThemeInterpolator(v10.getContext(), i11, p6.a.f17606c);
        return super.onLayoutChild(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            slideDown(v10);
        } else if (i11 < 0) {
            slideUp(v10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public void slideDown(V v10) {
        slideDown(v10, true);
    }

    public void slideUp(V v10) {
        slideUp(v10, true);
    }

    public void slideDown(V v10, boolean z10) {
        if (isScrolledDown()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f8790t;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        this.f8788r = 1;
        Iterator<b> it = this.f8782b.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v10, this.f8788r);
        }
        int i10 = this.f8787q + this.f8789s;
        if (z10) {
            a(v10, i10, this.f8784n, this.f8786p);
        } else {
            v10.setTranslationY(i10);
        }
    }

    public void slideUp(V v10, boolean z10) {
        if (isScrolledUp()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f8790t;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        this.f8788r = 2;
        Iterator<b> it = this.f8782b.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v10, this.f8788r);
        }
        if (z10) {
            a(v10, 0, this.f8783m, this.f8785o);
        } else {
            v10.setTranslationY(0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8782b = new LinkedHashSet<>();
        this.f8787q = 0;
        this.f8788r = 2;
        this.f8789s = 0;
    }
}
