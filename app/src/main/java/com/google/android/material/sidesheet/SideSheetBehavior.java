package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import g1.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k7.f;
import q7.g;
import q7.l;
import x0.h;
import x0.j0;
import y0.d;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements k7.b {
    public static final int I = R.string.side_sheet_accessibility_pane_title;
    public static final int J = R.style.Widget_Material3_SideSheet;
    public WeakReference<V> A;
    public WeakReference<View> B;
    public int C;
    public VelocityTracker D;
    public f E;
    public int F;
    public final LinkedHashSet G;
    public final a H;

    /* renamed from: b, reason: collision with root package name */
    public r7.d f9257b;

    /* renamed from: m, reason: collision with root package name */
    public g f9258m;

    /* renamed from: n, reason: collision with root package name */
    public final ColorStateList f9259n;

    /* renamed from: o, reason: collision with root package name */
    public final l f9260o;

    /* renamed from: p, reason: collision with root package name */
    public final SideSheetBehavior<V>.d f9261p;

    /* renamed from: q, reason: collision with root package name */
    public final float f9262q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9263r;

    /* renamed from: s, reason: collision with root package name */
    public int f9264s;

    /* renamed from: t, reason: collision with root package name */
    public g1.c f9265t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9266u;

    /* renamed from: v, reason: collision with root package name */
    public final float f9267v;

    /* renamed from: w, reason: collision with root package name */
    public int f9268w;

    /* renamed from: x, reason: collision with root package name */
    public int f9269x;

    /* renamed from: y, reason: collision with root package name */
    public int f9270y;

    /* renamed from: z, reason: collision with root package name */
    public int f9271z;

    public class a extends c.AbstractC0148c {
        public a() {
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return r0.a.clamp(i10, sideSheetBehavior.f9257b.g(), sideSheetBehavior.f9257b.f());
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // g1.c.AbstractC0148c
        public int getViewHorizontalDragRange(View view) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return sideSheetBehavior.f9268w + sideSheetBehavior.f9271z;
        }

        @Override // g1.c.AbstractC0148c
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                if (sideSheetBehavior.f9263r) {
                    sideSheetBehavior.c(1);
                }
            }
        }

        @Override // g1.c.AbstractC0148c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            View coplanarSiblingView = sideSheetBehavior.getCoplanarSiblingView();
            if (coplanarSiblingView != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) != null) {
                sideSheetBehavior.f9257b.o(marginLayoutParams, view.getLeft(), view.getRight());
                coplanarSiblingView.setLayoutParams(marginLayoutParams);
            }
            LinkedHashSet linkedHashSet = sideSheetBehavior.G;
            if (linkedHashSet.isEmpty()) {
                return;
            }
            float fB = sideSheetBehavior.f9257b.b(i10);
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((r7.c) it.next()).onSlide(view, fB);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
        @Override // g1.c.AbstractC0148c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onViewReleased(android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                com.google.android.material.sidesheet.SideSheetBehavior r0 = com.google.android.material.sidesheet.SideSheetBehavior.this
                r7.d r1 = r0.f9257b
                boolean r1 = r1.j(r4)
                if (r1 == 0) goto Lb
                goto L55
            Lb:
                r7.d r1 = r0.f9257b
                boolean r1 = r1.m(r3, r4)
                if (r1 == 0) goto L24
                r7.d r1 = r0.f9257b
                boolean r4 = r1.l(r4, r5)
                if (r4 != 0) goto L57
                r7.d r4 = r0.f9257b
                boolean r4 = r4.k(r3)
                if (r4 == 0) goto L55
                goto L57
            L24:
                r1 = 0
                int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r1 == 0) goto L3a
                float r4 = java.lang.Math.abs(r4)
                float r5 = java.lang.Math.abs(r5)
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 <= 0) goto L37
                r4 = 1
                goto L38
            L37:
                r4 = 0
            L38:
                if (r4 != 0) goto L57
            L3a:
                int r4 = r3.getLeft()
                int r5 = r0.getExpandedOffset()
                int r5 = r4 - r5
                int r5 = java.lang.Math.abs(r5)
                r7.d r1 = r0.f9257b
                int r1 = r1.e()
                int r4 = r4 - r1
                int r4 = java.lang.Math.abs(r4)
                if (r5 >= r4) goto L57
            L55:
                r4 = 3
                goto L58
            L57:
                r4 = 5
            L58:
                boolean r5 = r0.shouldSkipSmoothAnimation()
                r0.d(r3, r5, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.a.onViewReleased(android.view.View, float, float):void");
        }

        @Override // g1.c.AbstractC0148c
        public boolean tryCaptureView(View view, int i10) {
            WeakReference<V> weakReference;
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return (sideSheetBehavior.f9264s == 1 || (weakReference = sideSheetBehavior.A) == null || weakReference.get() != view) ? false : true;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.c(5);
            WeakReference<V> weakReference = sideSheetBehavior.A;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            sideSheetBehavior.A.get().requestLayout();
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        public int f9275a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9276b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.activity.d f9277c = new androidx.activity.d(this, 15);

        public d() {
        }

        public final void a(int i10) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            WeakReference<V> weakReference = sideSheetBehavior.A;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f9275a = i10;
            if (this.f9276b) {
                return;
            }
            j0.postOnAnimation(sideSheetBehavior.A.get(), this.f9277c);
            this.f9276b = true;
        }
    }

    public SideSheetBehavior() {
        this.f9261p = new d();
        this.f9263r = true;
        this.f9264s = 5;
        this.f9267v = 0.1f;
        this.C = -1;
        this.G = new LinkedHashSet();
        this.H = new a();
    }

    public final int a(int i10, int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i13);
    }

    public final CoordinatorLayout.f b() {
        V v10;
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || (v10 = weakReference.get()) == null || !(v10.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) v10.getLayoutParams();
    }

    public final void c(int i10) {
        V v10;
        if (this.f9264s == i10) {
            return;
        }
        this.f9264s = i10;
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        int i11 = this.f9264s == 5 ? 4 : 0;
        if (v10.getVisibility() != i11) {
            v10.setVisibility(i11);
        }
        Iterator it = this.G.iterator();
        while (it.hasNext()) {
            ((r7.c) it.next()).onStateChanged(v10, i10);
        }
        e();
    }

    @Override // k7.b
    public void cancelBackProgress() {
        f fVar = this.E;
        if (fVar == null) {
            return;
        }
        fVar.cancelBackProgress();
    }

    public final void d(View view, boolean z10, int i10) {
        int expandedOffset;
        if (i10 == 3) {
            expandedOffset = getExpandedOffset();
        } else {
            if (i10 != 5) {
                throw new IllegalArgumentException(ac.c.f("Invalid state to get outer edge offset: ", i10));
            }
            expandedOffset = this.f9257b.e();
        }
        g1.c cVar = this.f9265t;
        if (!(cVar != null && (!z10 ? !cVar.smoothSlideViewTo(view, expandedOffset, view.getTop()) : !cVar.settleCapturedViewAt(expandedOffset, view.getTop())))) {
            c(i10);
        } else {
            c(2);
            this.f9261p.a(i10);
        }
    }

    public final void e() {
        V v10;
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        j0.removeAccessibilityAction(v10, 262144);
        j0.removeAccessibilityAction(v10, 1048576);
        if (this.f9264s != 5) {
            j0.replaceAccessibilityAction(v10, d.a.f21827l, null, new r7.f(this, 5));
        }
        if (this.f9264s != 3) {
            j0.replaceAccessibilityAction(v10, d.a.f21825j, null, new r7.f(this, 3));
        }
    }

    public View getCoplanarSiblingView() {
        WeakReference<View> weakReference = this.B;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getExpandedOffset() {
        return this.f9257b.d();
    }

    public float getHideFriction() {
        return this.f9267v;
    }

    @Override // k7.b
    public void handleBackInvoked() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        f fVar = this.E;
        if (fVar == null) {
            return;
        }
        androidx.activity.b bVarOnHandleBackInvoked = fVar.onHandleBackInvoked();
        int i10 = 5;
        if (bVarOnHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            setState(5);
            return;
        }
        f fVar2 = this.E;
        r7.d dVar = this.f9257b;
        if (dVar != null && dVar.i() != 0) {
            i10 = 3;
        }
        b bVar = new b();
        final View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            animatorUpdateListener = null;
        } else {
            final int iC = this.f9257b.c(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: r7.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f18650b.f9257b.n(marginLayoutParams, p6.a.lerp(iC, 0, valueAnimator.getAnimatedFraction()));
                    coplanarSiblingView.requestLayout();
                }
            };
        }
        fVar2.finishBackProgress(bVarOnHandleBackInvoked, i10, bVar, animatorUpdateListener);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.A = null;
        this.f9265t = null;
        this.E = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.A = null;
        this.f9265t = null;
        this.E = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        g1.c cVar;
        VelocityTracker velocityTracker;
        if (!((v10.isShown() || j0.getAccessibilityPaneTitle(v10) != null) && this.f9263r)) {
            this.f9266u = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.D) != null) {
            velocityTracker.recycle();
            this.D = null;
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.F = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f9266u) {
            this.f9266u = false;
            return false;
        }
        return (this.f9266u || (cVar = this.f9265t) == null || !cVar.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        int i11;
        View viewFindViewById;
        if (j0.getFitsSystemWindows(coordinatorLayout) && !j0.getFitsSystemWindows(v10)) {
            v10.setFitsSystemWindows(true);
        }
        int iH = 0;
        if (this.A == null) {
            this.A = new WeakReference<>(v10);
            this.E = new f(v10);
            g gVar = this.f9258m;
            if (gVar != null) {
                j0.setBackground(v10, gVar);
                g gVar2 = this.f9258m;
                float elevation = this.f9262q;
                if (elevation == -1.0f) {
                    elevation = j0.getElevation(v10);
                }
                gVar2.setElevation(elevation);
            } else {
                ColorStateList colorStateList = this.f9259n;
                if (colorStateList != null) {
                    j0.setBackgroundTintList(v10, colorStateList);
                }
            }
            int i12 = this.f9264s == 5 ? 4 : 0;
            if (v10.getVisibility() != i12) {
                v10.setVisibility(i12);
            }
            e();
            if (j0.getImportantForAccessibility(v10) == 0) {
                j0.setImportantForAccessibility(v10, 1);
            }
            if (j0.getAccessibilityPaneTitle(v10) == null) {
                j0.setAccessibilityPaneTitle(v10, v10.getResources().getString(I));
            }
        }
        int i13 = h.getAbsoluteGravity(((CoordinatorLayout.f) v10.getLayoutParams()).f2101c, i10) == 3 ? 1 : 0;
        r7.d dVar = this.f9257b;
        if (dVar == null || dVar.i() != i13) {
            l lVar = this.f9260o;
            if (i13 == 0) {
                this.f9257b = new r7.b(this);
                if (lVar != null) {
                    CoordinatorLayout.f fVarB = b();
                    if (!(fVarB != null && ((ViewGroup.MarginLayoutParams) fVarB).rightMargin > 0)) {
                        l.a builder = lVar.toBuilder();
                        builder.setTopRightCornerSize(0.0f).setBottomRightCornerSize(0.0f);
                        l lVarBuild = builder.build();
                        g gVar3 = this.f9258m;
                        if (gVar3 != null) {
                            gVar3.setShapeAppearanceModel(lVarBuild);
                        }
                    }
                }
            } else {
                if (i13 != 1) {
                    throw new IllegalArgumentException(o1.a.d("Invalid sheet edge position value: ", i13, ". Must be 0 or 1."));
                }
                this.f9257b = new r7.a(this);
                if (lVar != null) {
                    CoordinatorLayout.f fVarB2 = b();
                    if (!(fVarB2 != null && ((ViewGroup.MarginLayoutParams) fVarB2).leftMargin > 0)) {
                        l.a builder2 = lVar.toBuilder();
                        builder2.setTopLeftCornerSize(0.0f).setBottomLeftCornerSize(0.0f);
                        l lVarBuild2 = builder2.build();
                        g gVar4 = this.f9258m;
                        if (gVar4 != null) {
                            gVar4.setShapeAppearanceModel(lVarBuild2);
                        }
                    }
                }
            }
        }
        if (this.f9265t == null) {
            this.f9265t = g1.c.create(coordinatorLayout, this.H);
        }
        int iH2 = this.f9257b.h(v10);
        coordinatorLayout.onLayoutChild(v10, i10);
        this.f9269x = coordinatorLayout.getWidth();
        this.f9270y = this.f9257b.getParentInnerEdge(coordinatorLayout);
        this.f9268w = v10.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        this.f9271z = marginLayoutParams != null ? this.f9257b.a(marginLayoutParams) : 0;
        int i14 = this.f9264s;
        if (i14 == 1 || i14 == 2) {
            iH = iH2 - this.f9257b.h(v10);
        } else if (i14 != 3) {
            if (i14 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f9264s);
            }
            iH = this.f9257b.e();
        }
        j0.offsetLeftAndRight(v10, iH);
        if (this.B == null && (i11 = this.C) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i11)) != null) {
            this.B = new WeakReference<>(viewFindViewById);
        }
        for (r7.c cVar : this.G) {
            if (cVar instanceof r7.g) {
                ((r7.g) cVar).getClass();
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(a(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, -1, marginLayoutParams.width), a(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        c cVar = (c) parcelable;
        if (cVar.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v10, cVar.getSuperState());
        }
        int i10 = cVar.f9274n;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f9264s = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new c(super.onSaveInstanceState(coordinatorLayout, v10), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        boolean z10 = false;
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.f9264s;
        if (i10 == 1 && actionMasked == 0) {
            return true;
        }
        g1.c cVar = this.f9265t;
        if (cVar != null && (this.f9263r || i10 == 1)) {
            cVar.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.D) != null) {
            velocityTracker.recycle();
            this.D = null;
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        g1.c cVar2 = this.f9265t;
        if ((cVar2 != null && (this.f9263r || this.f9264s == 1)) && actionMasked == 2 && !this.f9266u) {
            if ((cVar2 != null && (this.f9263r || this.f9264s == 1)) && Math.abs(this.F - motionEvent.getX()) > this.f9265t.getTouchSlop()) {
                z10 = true;
            }
            if (z10) {
                this.f9265t.captureChildView(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f9266u;
    }

    public void setCoplanarSiblingViewId(int i10) {
        this.C = i10;
        WeakReference<View> weakReference = this.B;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.B = null;
        WeakReference<V> weakReference2 = this.A;
        if (weakReference2 != null) {
            V v10 = weakReference2.get();
            if (i10 == -1 || !j0.isLaidOut(v10)) {
                return;
            }
            v10.requestLayout();
        }
    }

    public void setDraggable(boolean z10) {
        this.f9263r = z10;
    }

    public void setState(int i10) {
        if (i10 == 1 || i10 == 2) {
            throw new IllegalArgumentException(ac.c.o(new StringBuilder("STATE_"), i10 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || weakReference.get() == null) {
            c(i10);
            return;
        }
        V v10 = this.A.get();
        n0.h hVar = new n0.h(i10, 1, this);
        ViewParent parent = v10.getParent();
        if (parent != null && parent.isLayoutRequested() && j0.isAttachedToWindow(v10)) {
            v10.post(hVar);
        } else {
            hVar.run();
        }
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // k7.b
    public void startBackProgress(androidx.activity.b bVar) {
        f fVar = this.E;
        if (fVar == null) {
            return;
        }
        fVar.startBackProgress(bVar);
    }

    @Override // k7.b
    public void updateBackProgress(androidx.activity.b bVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        f fVar = this.E;
        if (fVar == null) {
            return;
        }
        r7.d dVar = this.f9257b;
        fVar.updateBackProgress(bVar, (dVar == null || dVar.i() == 0) ? 5 : 3);
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        V v10 = this.A.get();
        View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            return;
        }
        this.f9257b.n(marginLayoutParams, (int) ((v10.getScaleX() * this.f9268w) + this.f9271z));
        coplanarSiblingView.requestLayout();
    }

    public static class c extends f1.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public final int f9274n;

        public class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i10) {
                return new c[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9274n = parcel.readInt();
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f9274n);
        }

        public c(Parcelable parcelable, SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.f9274n = sideSheetBehavior.f9264s;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9261p = new d();
        this.f9263r = true;
        this.f9264s = 5;
        this.f9267v = 0.1f;
        this.C = -1;
        this.G = new LinkedHashSet();
        this.H = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SideSheetBehavior_Layout);
        int i10 = R.styleable.SideSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.f9259n = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, i10);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f9260o = l.builder(context, attributeSet, 0, J).build();
        }
        int i11 = R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            setCoplanarSiblingViewId(typedArrayObtainStyledAttributes.getResourceId(i11, -1));
        }
        l lVar = this.f9260o;
        if (lVar != null) {
            g gVar = new g(lVar);
            this.f9258m = gVar;
            gVar.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.f9259n;
            if (colorStateList != null) {
                this.f9258m.setFillColor(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f9258m.setTint(typedValue.data);
            }
        }
        this.f9262q = typedArrayObtainStyledAttributes.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
