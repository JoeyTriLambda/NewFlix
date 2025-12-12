package com.google.android.material.bottomsheet;

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
import android.util.SparseIntArray;
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
import i7.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import q7.g;
import q7.l;
import x0.j0;
import y0.d;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements k7.b {

    /* renamed from: q0, reason: collision with root package name */
    public static final int f8835q0 = R.style.Widget_Design_BottomSheet_Modal;
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public int G;
    public int H;
    public final boolean I;
    public final l J;
    public boolean K;
    public final BottomSheetBehavior<V>.f L;
    public ValueAnimator M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public int R;
    public final float S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;
    public g1.c X;
    public boolean Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f8836a0;

    /* renamed from: b, reason: collision with root package name */
    public int f8837b;

    /* renamed from: b0, reason: collision with root package name */
    public final float f8838b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f8839c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f8840d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f8841e0;

    /* renamed from: f0, reason: collision with root package name */
    public WeakReference<V> f8842f0;

    /* renamed from: g0, reason: collision with root package name */
    public WeakReference<View> f8843g0;

    /* renamed from: h0, reason: collision with root package name */
    public final ArrayList<d> f8844h0;

    /* renamed from: i0, reason: collision with root package name */
    public VelocityTracker f8845i0;

    /* renamed from: j0, reason: collision with root package name */
    public k7.d f8846j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f8847k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f8848l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8849m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f8850m0;

    /* renamed from: n, reason: collision with root package name */
    public final float f8851n;

    /* renamed from: n0, reason: collision with root package name */
    public HashMap f8852n0;

    /* renamed from: o, reason: collision with root package name */
    public int f8853o;

    /* renamed from: o0, reason: collision with root package name */
    public final SparseIntArray f8854o0;

    /* renamed from: p, reason: collision with root package name */
    public int f8855p;

    /* renamed from: p0, reason: collision with root package name */
    public final c f8856p0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8857q;

    /* renamed from: r, reason: collision with root package name */
    public int f8858r;

    /* renamed from: s, reason: collision with root package name */
    public final int f8859s;

    /* renamed from: t, reason: collision with root package name */
    public g f8860t;

    /* renamed from: u, reason: collision with root package name */
    public final ColorStateList f8861u;

    /* renamed from: v, reason: collision with root package name */
    public int f8862v;

    /* renamed from: w, reason: collision with root package name */
    public int f8863w;

    /* renamed from: x, reason: collision with root package name */
    public int f8864x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8865y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f8866z;

    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f8867b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f8868m;

        public a(View view, int i10) {
            this.f8867b = view;
            this.f8868m = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = BottomSheetBehavior.f8835q0;
            BottomSheetBehavior.this.k(this.f8867b, false, this.f8868m);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            bottomSheetBehavior.i(5);
            WeakReference<V> weakReference = bottomSheetBehavior.f8842f0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            bottomSheetBehavior.f8842f0.get().requestLayout();
        }
    }

    public class c extends c.AbstractC0148c {

        /* renamed from: a, reason: collision with root package name */
        public long f8871a;

        public c() {
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return r0.a.clamp(i10, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
        }

        @Override // g1.c.AbstractC0148c
        public int getViewVerticalDragRange(View view) {
            int i10 = BottomSheetBehavior.f8835q0;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.isHideable() && bottomSheetBehavior.isHideableWhenDragging() ? bottomSheetBehavior.f8841e0 : bottomSheetBehavior.R;
        }

        @Override // g1.c.AbstractC0148c
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.V) {
                    bottomSheetBehavior.i(1);
                }
            }
        }

        @Override // g1.c.AbstractC0148c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.d(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
        @Override // g1.c.AbstractC0148c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onViewReleased(android.view.View r9, float r10, float r11) {
            /*
                Method dump skipped, instructions count: 271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.onViewReleased(android.view.View, float, float):void");
        }

        @Override // g1.c.AbstractC0148c
        public boolean tryCaptureView(View view, int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.W;
            if (i11 == 1 || bottomSheetBehavior.f8850m0) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.f8847k0 == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.f8843g0;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f8871a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = bottomSheetBehavior.f8842f0;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public static abstract class d {
        public abstract void onSlide(View view, float f10);

        public abstract void onStateChanged(View view, int i10);
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public int f8878a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8879b;

        /* renamed from: c, reason: collision with root package name */
        public final a f8880c = new a();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.f8879b = false;
                g1.c cVar = BottomSheetBehavior.this.X;
                if (cVar != null && cVar.continueSettling(true)) {
                    fVar.a(fVar.f8878a);
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.W == 2) {
                    bottomSheetBehavior.i(fVar.f8878a);
                }
            }
        }

        public f() {
        }

        public final void a(int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            WeakReference<V> weakReference = bottomSheetBehavior.f8842f0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f8878a = i10;
            if (this.f8879b) {
                return;
            }
            j0.postOnAnimation(bottomSheetBehavior.f8842f0.get(), this.f8880c);
            this.f8879b = true;
        }
    }

    public BottomSheetBehavior() {
        this.f8837b = 0;
        this.f8849m = true;
        this.f8862v = -1;
        this.f8863w = -1;
        this.L = new f();
        this.Q = 0.5f;
        this.S = -1.0f;
        this.V = true;
        this.W = 4;
        this.f8838b0 = 0.1f;
        this.f8844h0 = new ArrayList<>();
        this.f8848l0 = -1;
        this.f8854o0 = new SparseIntArray();
        this.f8856p0 = new c();
    }

    public static View e(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (j0.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View viewE = e(viewGroup.getChildAt(i10));
                if (viewE != null) {
                    return viewE;
                }
            }
        }
        return null;
    }

    public final void a() {
        int iC = c();
        if (this.f8849m) {
            this.R = Math.max(this.f8841e0 - iC, this.O);
        } else {
            this.R = this.f8841e0 - iC;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float b() {
        /*
            r5 = this;
            q7.g r0 = r5.f8860t
            r1 = 0
            if (r0 == 0) goto L65
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r5.f8842f0
            if (r0 == 0) goto L65
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L65
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L65
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r5.f8842f0
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.h()
            if (r2 == 0) goto L65
            android.view.WindowInsets r0 = p0.b.h(r0)
            if (r0 == 0) goto L65
            q7.g r2 = r5.f8860t
            float r2 = r2.getTopLeftCornerResolvedSize()
            android.view.RoundedCorner r3 = a3.b.l(r0)
            if (r3 == 0) goto L44
            int r3 = a3.b.e(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = 0
        L45:
            q7.g r2 = r5.f8860t
            float r2 = r2.getTopRightCornerResolvedSize()
            android.view.RoundedCorner r0 = a3.b.v(r0)
            if (r0 == 0) goto L60
            int r0 = a3.b.e(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L60
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L60
            float r1 = r0 / r2
        L60:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L65:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.b():float");
    }

    public final int c() {
        int i10;
        return this.f8857q ? Math.min(Math.max(this.f8858r, this.f8841e0 - ((this.f8840d0 * 9) / 16)), this.f8839c0) + this.G : (this.f8865y || this.f8866z || (i10 = this.f8864x) <= 0) ? this.f8855p + this.G : Math.max(this.f8855p, i10 + this.f8859s);
    }

    @Override // k7.b
    public void cancelBackProgress() {
        k7.d dVar = this.f8846j0;
        if (dVar == null) {
            return;
        }
        dVar.cancelBackProgress();
    }

    public final void d(int i10) {
        float f10;
        float expandedOffset;
        V v10 = this.f8842f0.get();
        if (v10 != null) {
            ArrayList<d> arrayList = this.f8844h0;
            if (arrayList.isEmpty()) {
                return;
            }
            int i11 = this.R;
            if (i10 > i11 || i11 == getExpandedOffset()) {
                int i12 = this.R;
                f10 = i12 - i10;
                expandedOffset = this.f8841e0 - i12;
            } else {
                int i13 = this.R;
                f10 = i13 - i10;
                expandedOffset = i13 - getExpandedOffset();
            }
            float f11 = f10 / expandedOffset;
            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                arrayList.get(i14).onSlide(v10, f11);
            }
        }
    }

    public final int f(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    public final int g(int i10) {
        if (i10 == 3) {
            return getExpandedOffset();
        }
        if (i10 == 4) {
            return this.R;
        }
        if (i10 == 5) {
            return this.f8841e0;
        }
        if (i10 == 6) {
            return this.P;
        }
        throw new IllegalArgumentException(ac.c.f("Invalid state to get top offset: ", i10));
    }

    public int getExpandedOffset() {
        if (this.f8849m) {
            return this.O;
        }
        return Math.max(this.N, this.C ? 0 : this.H);
    }

    public final boolean h() {
        WeakReference<V> weakReference = this.f8842f0;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.f8842f0.get().getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    @Override // k7.b
    public void handleBackInvoked() {
        k7.d dVar = this.f8846j0;
        if (dVar == null) {
            return;
        }
        androidx.activity.b bVarOnHandleBackInvoked = dVar.onHandleBackInvoked();
        if (bVarOnHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            setState(this.T ? 5 : 4);
        } else if (this.T) {
            this.f8846j0.finishBackProgressNotPersistent(bVarOnHandleBackInvoked, new b());
        } else {
            this.f8846j0.finishBackProgressPersistent(bVarOnHandleBackInvoked, null);
            setState(4);
        }
    }

    public final void i(int i10) {
        V v10;
        if (this.W == i10) {
            return;
        }
        this.W = i10;
        WeakReference<V> weakReference = this.f8842f0;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        int i11 = 0;
        if (i10 == 3) {
            n(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            n(false);
        }
        m(i10, true);
        while (true) {
            ArrayList<d> arrayList = this.f8844h0;
            if (i11 >= arrayList.size()) {
                l();
                return;
            } else {
                arrayList.get(i11).onStateChanged(v10, i10);
                i11++;
            }
        }
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.f8865y;
    }

    public boolean isHideable() {
        return this.T;
    }

    public boolean isHideableWhenDragging() {
        return true;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public final boolean j(View view, float f10) {
        if (this.U) {
            return true;
        }
        if (!isHideableWhenDragging() || view.getTop() < this.R) {
            return false;
        }
        return Math.abs(((f10 * this.f8838b0) + ((float) view.getTop())) - ((float) this.R)) / ((float) c()) > 0.5f;
    }

    public final void k(View view, boolean z10, int i10) {
        int iG = g(i10);
        g1.c cVar = this.X;
        if (!(cVar != null && (!z10 ? !cVar.smoothSlideViewTo(view, view.getLeft(), iG) : !cVar.settleCapturedViewAt(view.getLeft(), iG)))) {
            i(i10);
            return;
        }
        i(2);
        m(i10, true);
        this.L.a(i10);
    }

    public final void l() {
        V v10;
        WeakReference<V> weakReference = this.f8842f0;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        j0.removeAccessibilityAction(v10, 524288);
        j0.removeAccessibilityAction(v10, 262144);
        j0.removeAccessibilityAction(v10, 1048576);
        SparseIntArray sparseIntArray = this.f8854o0;
        int i10 = sparseIntArray.get(0, -1);
        if (i10 != -1) {
            j0.removeAccessibilityAction(v10, i10);
            sparseIntArray.delete(0);
        }
        if (!this.f8849m && this.W != 6) {
            sparseIntArray.put(0, j0.addAccessibilityAction(v10, v10.getResources().getString(R.string.bottomsheet_action_expand_halfway), new t6.c(this, 6)));
        }
        if (this.T && isHideableWhenDragging() && this.W != 5) {
            j0.replaceAccessibilityAction(v10, d.a.f21827l, null, new t6.c(this, 5));
        }
        int i11 = this.W;
        if (i11 == 3) {
            j0.replaceAccessibilityAction(v10, d.a.f21826k, null, new t6.c(this, this.f8849m ? 4 : 6));
            return;
        }
        if (i11 == 4) {
            j0.replaceAccessibilityAction(v10, d.a.f21825j, null, new t6.c(this, this.f8849m ? 3 : 6));
        } else {
            if (i11 != 6) {
                return;
            }
            j0.replaceAccessibilityAction(v10, d.a.f21826k, null, new t6.c(this, 4));
            j0.replaceAccessibilityAction(v10, d.a.f21825j, null, new t6.c(this, 3));
        }
    }

    public final void m(int i10, boolean z10) {
        ValueAnimator valueAnimator;
        if (i10 == 2) {
            return;
        }
        boolean z11 = this.W == 3 && (this.I || h());
        if (this.K == z11 || this.f8860t == null) {
            return;
        }
        this.K = z11;
        if (!z10 || (valueAnimator = this.M) == null) {
            ValueAnimator valueAnimator2 = this.M;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.M.cancel();
            }
            this.f8860t.setInterpolation(this.K ? b() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.M.reverse();
        } else {
            this.M.setFloatValues(this.f8860t.getInterpolation(), z11 ? b() : 1.0f);
            this.M.start();
        }
    }

    public final void n(boolean z10) {
        WeakReference<V> weakReference = this.f8842f0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f8852n0 != null) {
                    return;
                } else {
                    this.f8852n0 = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.f8842f0.get() && z10) {
                    this.f8852n0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z10) {
                return;
            }
            this.f8852n0 = null;
        }
    }

    public final void o(boolean z10) {
        V v10;
        if (this.f8842f0 != null) {
            a();
            if (this.W != 4 || (v10 = this.f8842f0.get()) == null) {
                return;
            }
            if (z10) {
                setState(4);
            } else {
                v10.requestLayout();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.f8842f0 = null;
        this.X = null;
        this.f8846j0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f8842f0 = null;
        this.X = null;
        this.f8846j0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int i10;
        g1.c cVar;
        if (!v10.isShown() || !this.V) {
            this.Y = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8847k0 = -1;
            this.f8848l0 = -1;
            VelocityTracker velocityTracker = this.f8845i0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f8845i0 = null;
            }
        }
        if (this.f8845i0 == null) {
            this.f8845i0 = VelocityTracker.obtain();
        }
        this.f8845i0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f8848l0 = (int) motionEvent.getY();
            if (this.W != 2) {
                WeakReference<View> weakReference = this.f8843g0;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x10, this.f8848l0)) {
                    this.f8847k0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f8850m0 = true;
                }
            }
            this.Y = this.f8847k0 == -1 && !coordinatorLayout.isPointInChildBounds(v10, x10, this.f8848l0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f8850m0 = false;
            this.f8847k0 = -1;
            if (this.Y) {
                this.Y = false;
                return false;
            }
        }
        if (!this.Y && (cVar = this.X) != null && cVar.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f8843g0;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.Y || this.W == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.X == null || (i10 = this.f8848l0) == -1 || Math.abs(((float) i10) - motionEvent.getY()) <= ((float) this.X.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        if (j0.getFitsSystemWindows(coordinatorLayout) && !j0.getFitsSystemWindows(v10)) {
            v10.setFitsSystemWindows(true);
        }
        int i11 = 0;
        if (this.f8842f0 == null) {
            this.f8858r = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z10 = (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.f8857q) ? false : true;
            if (this.f8866z || this.A || this.B || this.D || this.E || this.F || z10) {
                t.doOnApplyWindowInsets(v10, new t6.b(this, z10));
            }
            j0.setWindowInsetsAnimationCallback(v10, new t6.d(v10));
            this.f8842f0 = new WeakReference<>(v10);
            this.f8846j0 = new k7.d(v10);
            g gVar = this.f8860t;
            if (gVar != null) {
                j0.setBackground(v10, gVar);
                g gVar2 = this.f8860t;
                float elevation = this.S;
                if (elevation == -1.0f) {
                    elevation = j0.getElevation(v10);
                }
                gVar2.setElevation(elevation);
            } else {
                ColorStateList colorStateList = this.f8861u;
                if (colorStateList != null) {
                    j0.setBackgroundTintList(v10, colorStateList);
                }
            }
            l();
            if (j0.getImportantForAccessibility(v10) == 0) {
                j0.setImportantForAccessibility(v10, 1);
            }
        }
        if (this.X == null) {
            this.X = g1.c.create(coordinatorLayout, this.f8856p0);
        }
        int top = v10.getTop();
        coordinatorLayout.onLayoutChild(v10, i10);
        this.f8840d0 = coordinatorLayout.getWidth();
        this.f8841e0 = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.f8839c0 = height;
        int iMin = this.f8841e0;
        int i12 = iMin - height;
        int i13 = this.H;
        if (i12 < i13) {
            if (this.C) {
                int i14 = this.f8863w;
                if (i14 != -1) {
                    iMin = Math.min(iMin, i14);
                }
                this.f8839c0 = iMin;
            } else {
                int iMin2 = iMin - i13;
                int i15 = this.f8863w;
                if (i15 != -1) {
                    iMin2 = Math.min(iMin2, i15);
                }
                this.f8839c0 = iMin2;
            }
        }
        this.O = Math.max(0, this.f8841e0 - this.f8839c0);
        this.P = (int) ((1.0f - this.Q) * this.f8841e0);
        a();
        int i16 = this.W;
        if (i16 == 3) {
            j0.offsetTopAndBottom(v10, getExpandedOffset());
        } else if (i16 == 6) {
            j0.offsetTopAndBottom(v10, this.P);
        } else if (this.T && i16 == 5) {
            j0.offsetTopAndBottom(v10, this.f8841e0);
        } else if (i16 == 4) {
            j0.offsetTopAndBottom(v10, this.R);
        } else if (i16 == 1 || i16 == 2) {
            j0.offsetTopAndBottom(v10, top - v10.getTop());
        }
        m(this.W, false);
        this.f8843g0 = new WeakReference<>(e(v10));
        while (true) {
            ArrayList<d> arrayList = this.f8844h0;
            if (i11 >= arrayList.size()) {
                return true;
            }
            arrayList.get(i11).getClass();
            i11++;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(f(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f8862v, marginLayoutParams.width), f(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f8863w, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (isNestedScrollingCheckEnabled() && (weakReference = this.f8843g0) != null && view == weakReference.get()) {
            return this.W != 3 || super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, V r3, android.view.View r4, int r5, int r6, int[] r7, int r8) {
        /*
            r1 = this;
            r2 = 1
            if (r8 != r2) goto L4
            return
        L4:
            java.lang.ref.WeakReference<android.view.View> r5 = r1.f8843g0
            if (r5 == 0) goto Lf
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            goto L10
        Lf:
            r5 = 0
        L10:
            boolean r8 = r1.isNestedScrollingCheckEnabled()
            if (r8 == 0) goto L19
            if (r4 == r5) goto L19
            return
        L19:
            int r5 = r3.getTop()
            int r8 = r5 - r6
            if (r6 <= 0) goto L46
            int r4 = r1.getExpandedOffset()
            if (r8 >= r4) goto L37
            int r4 = r1.getExpandedOffset()
            int r5 = r5 - r4
            r7[r2] = r5
            int r4 = -r5
            x0.j0.offsetTopAndBottom(r3, r4)
            r4 = 3
            r1.i(r4)
            goto L81
        L37:
            boolean r4 = r1.V
            if (r4 != 0) goto L3c
            return
        L3c:
            r7[r2] = r6
            int r4 = -r6
            x0.j0.offsetTopAndBottom(r3, r4)
            r1.i(r2)
            goto L81
        L46:
            if (r6 >= 0) goto L81
            r0 = -1
            boolean r4 = r4.canScrollVertically(r0)
            if (r4 != 0) goto L81
            int r4 = r1.R
            if (r8 <= r4) goto L73
            boolean r4 = r1.isHideable()
            if (r4 == 0) goto L61
            boolean r4 = r1.isHideableWhenDragging()
            if (r4 == 0) goto L61
            r4 = 1
            goto L62
        L61:
            r4 = 0
        L62:
            if (r4 == 0) goto L65
            goto L73
        L65:
            int r4 = r1.R
            int r5 = r5 - r4
            r7[r2] = r5
            int r4 = -r5
            x0.j0.offsetTopAndBottom(r3, r4)
            r4 = 4
            r1.i(r4)
            goto L81
        L73:
            boolean r4 = r1.V
            if (r4 != 0) goto L78
            return
        L78:
            r7[r2] = r6
            int r4 = -r6
            x0.j0.offsetTopAndBottom(r3, r4)
            r1.i(r2)
        L81:
            int r3 = r3.getTop()
            r1.d(r3)
            r1.Z = r6
            r1.f8836a0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int, int, int[], int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, eVar.getSuperState());
        int i10 = this.f8837b;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.f8855p = eVar.f8874o;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.f8849m = eVar.f8875p;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.T = eVar.f8876q;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.U = eVar.f8877r;
            }
        }
        int i11 = eVar.f8873n;
        if (i11 == 1 || i11 == 2) {
            this.W = 4;
        } else {
            this.W = i11;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new e(super.onSaveInstanceState(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.Z = 0;
        this.f8836a0 = false;
        return (i10 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ba  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.getExpandedOffset()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.i(r0)
            return
        Lf:
            boolean r3 = r2.isNestedScrollingCheckEnabled()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f8843g0
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.f8836a0
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.Z
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f8849m
            if (r3 == 0) goto L2f
            goto Lbb
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.P
            if (r3 <= r6) goto Lbb
            goto Lba
        L39:
            boolean r3 = r2.T
            if (r3 == 0) goto L5a
            android.view.VelocityTracker r3 = r2.f8845i0
            if (r3 != 0) goto L43
            r3 = 0
            goto L52
        L43:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f8851n
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f8845i0
            int r6 = r2.f8847k0
            float r3 = r3.getYVelocity(r6)
        L52:
            boolean r3 = r2.j(r4, r3)
            if (r3 == 0) goto L5a
            r0 = 5
            goto Lbb
        L5a:
            int r3 = r2.Z
            r6 = 4
            if (r3 != 0) goto L9f
            int r3 = r4.getTop()
            boolean r1 = r2.f8849m
            if (r1 == 0) goto L79
            int r5 = r2.O
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.R
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto La3
            goto Lbb
        L79:
            int r1 = r2.P
            if (r3 >= r1) goto L8f
            int r1 = r2.R
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L88
            goto Lbb
        L88:
            boolean r3 = r2.shouldSkipHalfExpandedStateWhenDragging()
            if (r3 == 0) goto Lba
            goto La3
        L8f:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.R
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto La3
            goto Lba
        L9f:
            boolean r3 = r2.f8849m
            if (r3 == 0) goto La5
        La3:
            r0 = 4
            goto Lbb
        La5:
            int r3 = r4.getTop()
            int r0 = r2.P
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.R
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto La3
        Lba:
            r0 = 6
        Lbb:
            r3 = 0
            r2.k(r4, r3, r0)
            r2.f8836a0 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10 = false;
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.W;
        if (i10 == 1 && actionMasked == 0) {
            return true;
        }
        g1.c cVar = this.X;
        if (cVar != null && (this.V || i10 == 1)) {
            cVar.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.f8847k0 = -1;
            this.f8848l0 = -1;
            VelocityTracker velocityTracker = this.f8845i0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f8845i0 = null;
            }
        }
        if (this.f8845i0 == null) {
            this.f8845i0 = VelocityTracker.obtain();
        }
        this.f8845i0.addMovement(motionEvent);
        if (this.X != null && (this.V || this.W == 1)) {
            z10 = true;
        }
        if (z10 && actionMasked == 2 && !this.Y && Math.abs(this.f8848l0 - motionEvent.getY()) > this.X.getTouchSlop()) {
            this.X.captureChildView(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.Y;
    }

    public void setDraggable(boolean z10) {
        this.V = z10;
    }

    public void setExpandedOffset(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.N = i10;
        m(this.W, true);
    }

    public void setFitToContents(boolean z10) {
        if (this.f8849m == z10) {
            return;
        }
        this.f8849m = z10;
        if (this.f8842f0 != null) {
            a();
        }
        i((this.f8849m && this.W == 6) ? 3 : this.W);
        m(this.W, true);
        l();
    }

    public void setGestureInsetBottomIgnored(boolean z10) {
        this.f8865y = z10;
    }

    public void setHalfExpandedRatio(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.Q = f10;
        if (this.f8842f0 != null) {
            this.P = (int) ((1.0f - f10) * this.f8841e0);
        }
    }

    public void setHideable(boolean z10) {
        if (this.T != z10) {
            this.T = z10;
            if (!z10 && this.W == 5) {
                setState(4);
            }
            l();
        }
    }

    public void setMaxHeight(int i10) {
        this.f8863w = i10;
    }

    public void setMaxWidth(int i10) {
        this.f8862v = i10;
    }

    public void setPeekHeight(int i10) {
        setPeekHeight(i10, false);
    }

    public void setSaveFlags(int i10) {
        this.f8837b = i10;
    }

    public void setSignificantVelocityThreshold(int i10) {
        this.f8853o = i10;
    }

    public void setSkipCollapsed(boolean z10) {
        this.U = z10;
    }

    public void setState(int i10) {
        if (i10 == 1 || i10 == 2) {
            throw new IllegalArgumentException(ac.c.o(new StringBuilder("STATE_"), i10 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.T && i10 == 5) {
            o1.a.o("Cannot set state: ", i10, "BottomSheetBehavior");
            return;
        }
        int i11 = (i10 == 6 && this.f8849m && g(i10) <= this.O) ? 3 : i10;
        WeakReference<V> weakReference = this.f8842f0;
        if (weakReference == null || weakReference.get() == null) {
            i(i10);
            return;
        }
        V v10 = this.f8842f0.get();
        a aVar = new a(v10, i11);
        ViewParent parent = v10.getParent();
        if (parent != null && parent.isLayoutRequested() && j0.isAttachedToWindow(v10)) {
            v10.post(aVar);
        } else {
            aVar.run();
        }
    }

    public boolean shouldExpandOnUpwardDrag(long j10, float f10) {
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // k7.b
    public void startBackProgress(androidx.activity.b bVar) {
        k7.d dVar = this.f8846j0;
        if (dVar == null) {
            return;
        }
        dVar.startBackProgress(bVar);
    }

    @Override // k7.b
    public void updateBackProgress(androidx.activity.b bVar) {
        k7.d dVar = this.f8846j0;
        if (dVar == null) {
            return;
        }
        dVar.updateBackProgress(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r4 != r0) goto Lc
            boolean r4 = r3.f8857q
            if (r4 != 0) goto L15
            r3.f8857q = r1
            goto L1f
        Lc:
            boolean r0 = r3.f8857q
            if (r0 != 0) goto L17
            int r0 = r3.f8855p
            if (r0 == r4) goto L15
            goto L17
        L15:
            r1 = 0
            goto L1f
        L17:
            r3.f8857q = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.f8855p = r4
        L1f:
            if (r1 == 0) goto L24
            r3.o(r5)
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public static class e extends f1.a {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public final int f8873n;

        /* renamed from: o, reason: collision with root package name */
        public final int f8874o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f8875p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f8876q;

        /* renamed from: r, reason: collision with root package name */
        public final boolean f8877r;

        public class a implements Parcelable.ClassLoaderCreator<e> {
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i10) {
                return new e[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, (ClassLoader) null);
            }
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8873n = parcel.readInt();
            this.f8874o = parcel.readInt();
            this.f8875p = parcel.readInt() == 1;
            this.f8876q = parcel.readInt() == 1;
            this.f8877r = parcel.readInt() == 1;
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8873n);
            parcel.writeInt(this.f8874o);
            parcel.writeInt(this.f8875p ? 1 : 0);
            parcel.writeInt(this.f8876q ? 1 : 0);
            parcel.writeInt(this.f8877r ? 1 : 0);
        }

        public e(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f8873n = bottomSheetBehavior.W;
            this.f8874o = bottomSheetBehavior.f8855p;
            this.f8875p = bottomSheetBehavior.f8849m;
            this.f8876q = bottomSheetBehavior.T;
            this.f8877r = bottomSheetBehavior.U;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i10;
        super(context, attributeSet);
        this.f8837b = 0;
        this.f8849m = true;
        this.f8862v = -1;
        this.f8863w = -1;
        this.L = new f();
        this.Q = 0.5f;
        this.S = -1.0f;
        this.V = true;
        this.W = 4;
        this.f8838b0 = 0.1f;
        this.f8844h0 = new ArrayList<>();
        this.f8848l0 = -1;
        this.f8854o0 = new SparseIntArray();
        this.f8856p0 = new c();
        this.f8859s = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        int i11 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f8861u = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, i11);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.J = l.builder(context, attributeSet, R.attr.bottomSheetStyle, f8835q0).build();
        }
        l lVar = this.J;
        if (lVar != null) {
            g gVar = new g(lVar);
            this.f8860t = gVar;
            gVar.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.f8861u;
            if (colorStateList != null) {
                this.f8860t.setFillColor(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f8860t.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(b(), 1.0f);
        this.M = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.M.addUpdateListener(new t6.a(this));
        this.S = typedArrayObtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i12 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i14);
        if (typedValuePeekValue != null && (i10 = typedValuePeekValue.data) == -1) {
            setPeekHeight(i10);
        } else {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(typedArrayObtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i15);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            setExpandedOffset(typedValuePeekValue2.data);
        } else {
            setExpandedOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        setSignificantVelocityThreshold(typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.f8866z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.A = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.B = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.C = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.E = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.F = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.I = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f8851n = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }
}
