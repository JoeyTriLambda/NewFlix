package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p6.h;
import p6.i;
import p6.j;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: n, reason: collision with root package name */
    public final Rect f9517n;

    /* renamed from: o, reason: collision with root package name */
    public final RectF f9518o;

    /* renamed from: p, reason: collision with root package name */
    public final RectF f9519p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f9520q;

    /* renamed from: r, reason: collision with root package name */
    public float f9521r;

    /* renamed from: s, reason: collision with root package name */
    public float f9522s;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9523b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f9524m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ View f9525n;

        public a(boolean z10, View view, View view2) {
            this.f9523b = z10;
            this.f9524m = view;
            this.f9525n = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f9523b) {
                return;
            }
            this.f9524m.setVisibility(4);
            View view = this.f9525n;
            view.setAlpha(1.0f);
            view.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f9523b) {
                this.f9524m.setVisibility(0);
                View view = this.f9525n;
                view.setAlpha(0.0f);
                view.setVisibility(4);
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public h f9526a;

        /* renamed from: b, reason: collision with root package name */
        public j f9527b;
    }

    public FabTransformationBehavior() {
        this.f9517n = new Rect();
        this.f9518o = new RectF();
        this.f9519p = new RectF();
        this.f9520q = new int[2];
    }

    public static Pair a(float f10, float f11, boolean z10, b bVar) {
        i timing;
        i timing2;
        if (f10 == 0.0f || f11 == 0.0f) {
            timing = bVar.f9526a.getTiming("translationXLinear");
            timing2 = bVar.f9526a.getTiming("translationYLinear");
        } else if ((!z10 || f11 >= 0.0f) && (z10 || f11 <= 0.0f)) {
            timing = bVar.f9526a.getTiming("translationXCurveDownwards");
            timing2 = bVar.f9526a.getTiming("translationYCurveDownwards");
        } else {
            timing = bVar.f9526a.getTiming("translationXCurveUpwards");
            timing2 = bVar.f9526a.getTiming("translationYCurveUpwards");
        }
        return new Pair(timing, timing2);
    }

    public static float d(b bVar, i iVar, float f10) {
        long delay = iVar.getDelay();
        long duration = iVar.getDuration();
        i timing = bVar.f9526a.getTiming("expansion");
        return p6.a.lerp(f10, 0.0f, iVar.getInterpolator().getInterpolation((((timing.getDuration() + timing.getDelay()) + 17) - delay) / duration));
    }

    public final float b(View view, View view2, j jVar) {
        float fCenterX;
        float fCenterX2;
        float f10;
        RectF rectF = this.f9518o;
        RectF rectF2 = this.f9519p;
        e(view, rectF);
        rectF.offset(this.f9521r, this.f9522s);
        e(view2, rectF2);
        int i10 = jVar.f17623a & 7;
        if (i10 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i10 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i10 != 5) {
                f10 = 0.0f;
                return f10 + jVar.f17624b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f10 = fCenterX - fCenterX2;
        return f10 + jVar.f17624b;
    }

    public final float c(View view, View view2, j jVar) {
        float fCenterY;
        float fCenterY2;
        float f10;
        RectF rectF = this.f9518o;
        RectF rectF2 = this.f9519p;
        e(view, rectF);
        rectF.offset(this.f9521r, this.f9522s);
        e(view2, rectF2);
        int i10 = jVar.f17623a & 112;
        if (i10 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i10 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i10 != 80) {
                f10 = 0.0f;
                return f10 + jVar.f17625c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f10 = fCenterY - fCenterY2;
        return f10 + jVar.f17625c;
    }

    public final void e(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f9520q);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        if (fVar.f2106h == 0) {
            fVar.f2106h = 80;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x031c  */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.AnimatorSet onCreateExpandedStateChangeAnimation(android.view.View r26, android.view.View r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 892
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.onCreateExpandedStateChangeAnimation(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    public abstract b onCreateMotionSpec(Context context, boolean z10);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9517n = new Rect();
        this.f9518o = new RectF();
        this.f9519p = new RectF();
        this.f9520q = new int[2];
    }
}
