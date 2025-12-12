package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import i7.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q7.i;
import x0.j0;
import x0.p0;
import x0.q;
import x0.v;
import x0.y0;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int K = R.style.Widget_Design_AppBarLayout;
    public ValueAnimator A;
    public ValueAnimator.AnimatorUpdateListener B;
    public final ArrayList C;
    public final long D;
    public final TimeInterpolator E;
    public int[] F;
    public Drawable G;
    public Integer H;
    public final float I;
    public Behavior J;

    /* renamed from: b, reason: collision with root package name */
    public int f8716b;

    /* renamed from: m, reason: collision with root package name */
    public int f8717m;

    /* renamed from: n, reason: collision with root package name */
    public int f8718n;

    /* renamed from: o, reason: collision with root package name */
    public int f8719o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8720p;

    /* renamed from: q, reason: collision with root package name */
    public int f8721q;

    /* renamed from: r, reason: collision with root package name */
    public y0 f8722r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f8723s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8724t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8725u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8726v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8727w;

    /* renamed from: x, reason: collision with root package name */
    public int f8728x;

    /* renamed from: y, reason: collision with root package name */
    public WeakReference<View> f8729y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f8730z;

    public static class BaseBehavior<T extends AppBarLayout> extends q6.c<T> {

        /* renamed from: u, reason: collision with root package name */
        public int f8731u;

        /* renamed from: v, reason: collision with root package name */
        public int f8732v;

        /* renamed from: w, reason: collision with root package name */
        public ValueAnimator f8733w;

        /* renamed from: x, reason: collision with root package name */
        public a f8734x;

        /* renamed from: y, reason: collision with root package name */
        public WeakReference<View> f8735y;

        public BaseBehavior() {
        }

        public static View h(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            baseBehavior.getClass();
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View j(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof q) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void m(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                int r0 = java.lang.Math.abs(r8)
                int r1 = r7.getChildCount()
                r2 = 0
                r3 = 0
            La:
                if (r3 >= r1) goto L20
                android.view.View r4 = r7.getChildAt(r3)
                int r5 = r4.getTop()
                if (r0 < r5) goto L1d
                int r5 = r4.getBottom()
                if (r0 > r5) goto L1d
                goto L21
            L1d:
                int r3 = r3 + 1
                goto La
            L20:
                r4 = 0
            L21:
                r0 = 1
                if (r4 == 0) goto L5d
                android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$e r1 = (com.google.android.material.appbar.AppBarLayout.e) r1
                int r1 = r1.getScrollFlags()
                r3 = r1 & 1
                if (r3 == 0) goto L5d
                int r3 = x0.j0.getMinimumHeight(r4)
                if (r9 <= 0) goto L4a
                r9 = r1 & 12
                if (r9 == 0) goto L4a
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r3
                int r1 = r7.getTopInset()
                int r9 = r9 - r1
                if (r8 < r9) goto L5d
                goto L5b
            L4a:
                r9 = r1 & 2
                if (r9 == 0) goto L5d
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r3
                int r1 = r7.getTopInset()
                int r9 = r9 - r1
                if (r8 < r9) goto L5d
            L5b:
                r8 = 1
                goto L5e
            L5d:
                r8 = 0
            L5e:
                boolean r9 = r7.isLiftOnScroll()
                if (r9 == 0) goto L6c
                android.view.View r8 = j(r6)
                boolean r8 = r7.d(r8)
            L6c:
                boolean r8 = r7.c(r8)
                if (r10 != 0) goto La2
                if (r8 == 0) goto Lcf
                java.util.List r6 = r6.getDependents(r7)
                int r8 = r6.size()
                r9 = 0
            L7d:
                if (r9 >= r8) goto La0
                java.lang.Object r10 = r6.get(r9)
                android.view.View r10 = (android.view.View) r10
                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$f r10 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r10
                androidx.coordinatorlayout.widget.CoordinatorLayout$c r10 = r10.getBehavior()
                boolean r1 = r10 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r1 == 0) goto L9d
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r10 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r10
                int r6 = r10.getOverlayTop()
                if (r6 == 0) goto La0
                r2 = 1
                goto La0
            L9d:
                int r9 = r9 + 1
                goto L7d
            La0:
                if (r2 == 0) goto Lcf
            La2:
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                if (r6 == 0) goto Laf
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                r6.jumpToCurrentState()
            Laf:
                int r6 = android.os.Build.VERSION.SDK_INT
                r8 = 23
                if (r6 < r8) goto Lc2
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                if (r6 == 0) goto Lc2
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                r6.jumpToCurrentState()
            Lc2:
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                if (r6 == 0) goto Lcf
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                r6.jumpToCurrentState()
            Lcf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.m(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // q6.c
        public final boolean a(View view) {
            View view2;
            WeakReference<View> weakReference = this.f8735y;
            return weakReference == null || !((view2 = weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1));
        }

        @Override // q6.c
        public final int b(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            return appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange());
        }

        @Override // q6.c
        public final int c(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // q6.c
        public final int d() {
            return getTopAndBottomOffset() + this.f8731u;
        }

        @Override // q6.c
        public final void e(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            l(coordinatorLayout, appBarLayout);
            if (appBarLayout.isLiftOnScroll()) {
                appBarLayout.c(appBarLayout.d(j(coordinatorLayout)));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
        @Override // q6.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int f(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                int r0 = r7.d()
                r1 = 0
                if (r11 == 0) goto Ldd
                if (r0 < r11) goto Ldd
                if (r0 > r12) goto Ldd
                int r10 = r0.a.clamp(r10, r11, r12)
                if (r0 == r10) goto Ldf
                boolean r11 = r9.f8720p
                if (r11 == 0) goto L8a
                int r11 = java.lang.Math.abs(r10)
                int r12 = r9.getChildCount()
                r2 = 0
            L20:
                if (r2 >= r12) goto L8a
                android.view.View r3 = r9.getChildAt(r2)
                android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$e r4 = (com.google.android.material.appbar.AppBarLayout.e) r4
                android.view.animation.Interpolator r5 = r4.getScrollInterpolator()
                int r6 = r3.getTop()
                if (r11 < r6) goto L87
                int r6 = r3.getBottom()
                if (r11 > r6) goto L87
                if (r5 == 0) goto L8a
                int r12 = r4.getScrollFlags()
                r2 = r12 & 1
                if (r2 == 0) goto L5b
                int r2 = r3.getHeight()
                int r6 = r4.topMargin
                int r2 = r2 + r6
                int r4 = r4.bottomMargin
                int r2 = r2 + r4
                int r2 = r2 + r1
                r12 = r12 & 2
                if (r12 == 0) goto L5c
                int r12 = x0.j0.getMinimumHeight(r3)
                int r2 = r2 - r12
                goto L5c
            L5b:
                r2 = 0
            L5c:
                boolean r12 = x0.j0.getFitsSystemWindows(r3)
                if (r12 == 0) goto L67
                int r12 = r9.getTopInset()
                int r2 = r2 - r12
            L67:
                if (r2 <= 0) goto L8a
                int r12 = r3.getTop()
                int r11 = r11 - r12
                float r12 = (float) r2
                float r11 = (float) r11
                float r11 = r11 / r12
                float r11 = r5.getInterpolation(r11)
                float r11 = r11 * r12
                int r11 = java.lang.Math.round(r11)
                int r12 = java.lang.Integer.signum(r10)
                int r2 = r3.getTop()
                int r2 = r2 + r11
                int r2 = r2 * r12
                goto L8b
            L87:
                int r2 = r2 + 1
                goto L20
            L8a:
                r2 = r10
            L8b:
                boolean r11 = r7.setTopAndBottomOffset(r2)
                int r12 = r0 - r10
                int r2 = r10 - r2
                r7.f8731u = r2
                r2 = 1
                if (r11 == 0) goto Lc5
                r3 = 0
            L99:
                int r4 = r9.getChildCount()
                if (r3 >= r4) goto Lc5
                android.view.View r4 = r9.getChildAt(r3)
                android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$e r4 = (com.google.android.material.appbar.AppBarLayout.e) r4
                com.google.android.material.appbar.AppBarLayout$c r5 = r4.getScrollEffect()
                if (r5 == 0) goto Lc2
                int r4 = r4.getScrollFlags()
                r4 = r4 & r2
                if (r4 == 0) goto Lc2
                android.view.View r4 = r9.getChildAt(r3)
                int r6 = r7.getTopAndBottomOffset()
                float r6 = (float) r6
                r5.onOffsetChanged(r9, r4, r6)
            Lc2:
                int r3 = r3 + 1
                goto L99
            Lc5:
                if (r11 != 0) goto Lce
                boolean r11 = r9.f8720p
                if (r11 == 0) goto Lce
                r8.dispatchDependentViewsChanged(r9)
            Lce:
                int r11 = r7.getTopAndBottomOffset()
                r9.b(r11)
                if (r10 >= r0) goto Ld8
                r2 = -1
            Ld8:
                m(r8, r9, r10, r2, r1)
                r1 = r12
                goto Ldf
            Ldd:
                r7.f8731u = r1
            Ldf:
                boolean r10 = x0.j0.hasAccessibilityDelegate(r8)
                if (r10 != 0) goto Led
                com.google.android.material.appbar.b r10 = new com.google.android.material.appbar.b
                r10.<init>(r8, r7, r9)
                x0.j0.setAccessibilityDelegate(r8, r10)
            Led:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.f(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void i(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            int iAbs = Math.abs(d() - i10);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iD = d();
            if (iD == i10) {
                ValueAnimator valueAnimator = this.f8733w;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f8733w.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f8733w;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f8733w = valueAnimator3;
                valueAnimator3.setInterpolator(p6.a.f17608e);
                this.f8733w.addUpdateListener(new com.google.android.material.appbar.a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f8733w.setDuration(Math.min(iRound, 600));
            this.f8733w.setIntValues(iD, i10);
            this.f8733w.start();
        }

        public final a k(Parcelable parcelable, T t10) {
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t10.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = f1.a.f11376m;
                    }
                    a aVar = new a(parcelable);
                    boolean z10 = topAndBottomOffset == 0;
                    aVar.f8737o = z10;
                    aVar.f8736n = !z10 && (-topAndBottomOffset) >= t10.getTotalScrollRange();
                    aVar.f8738p = i10;
                    aVar.f8740r = bottom == t10.getTopInset() + j0.getMinimumHeight(childAt);
                    aVar.f8739q = bottom / childAt.getHeight();
                    return aVar;
                }
            }
            return null;
        }

        public final void l(CoordinatorLayout coordinatorLayout, T t10) {
            int paddingTop = t10.getPaddingTop() + t10.getTopInset();
            int iD = d() - paddingTop;
            int childCount = t10.getChildCount();
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    i10 = -1;
                    break;
                }
                View childAt = t10.getChildAt(i10);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if ((eVar.getScrollFlags() & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i11 = -iD;
                if (top <= i11 && bottom >= i11) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                View childAt2 = t10.getChildAt(i10);
                e eVar2 = (e) childAt2.getLayoutParams();
                int scrollFlags = eVar2.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i10 == 0 && j0.getFitsSystemWindows(t10) && j0.getFitsSystemWindows(childAt2)) {
                        topInset -= t10.getTopInset();
                    }
                    if ((scrollFlags & 2) == 2) {
                        minimumHeight += j0.getMinimumHeight(childAt2);
                    } else {
                        if ((scrollFlags & 5) == 5) {
                            int minimumHeight2 = j0.getMinimumHeight(childAt2) + minimumHeight;
                            if (iD < minimumHeight2) {
                                topInset = minimumHeight2;
                            } else {
                                minimumHeight = minimumHeight2;
                            }
                        }
                    }
                    if ((scrollFlags & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) eVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) eVar2).bottomMargin;
                    }
                    if (iD < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    i(coordinatorLayout, t10, r0.a.clamp(topInset + paddingTop, -t10.getTotalScrollRange(), 0));
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // q6.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t10, int i10) {
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) t10, i10);
            int pendingAction = t10.getPendingAction();
            a aVar = this.f8734x;
            if (aVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i11 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            i(coordinatorLayout, t10, i11);
                        } else {
                            g(coordinatorLayout, t10, i11);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            i(coordinatorLayout, t10, 0);
                        } else {
                            g(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (aVar.f8736n) {
                g(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else if (aVar.f8737o) {
                g(coordinatorLayout, t10, 0);
            } else {
                View childAt = t10.getChildAt(aVar.f8738p);
                int i12 = -childAt.getBottom();
                g(coordinatorLayout, t10, this.f8734x.f8740r ? t10.getTopInset() + j0.getMinimumHeight(childAt) + i12 : Math.round(childAt.getHeight() * this.f8734x.f8739q) + i12);
            }
            t10.f8721q = 0;
            this.f8734x = null;
            setTopAndBottomOffset(r0.a.clamp(getTopAndBottomOffset(), -t10.getTotalScrollRange(), 0));
            m(coordinatorLayout, t10, getTopAndBottomOffset(), 0, true);
            t10.b(getTopAndBottomOffset());
            if (!j0.hasAccessibilityDelegate(coordinatorLayout)) {
                j0.setAccessibilityDelegate(coordinatorLayout, new com.google.android.material.appbar.b(coordinatorLayout, this, t10));
            }
            return zOnLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t10.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) t10, i10, i11, i12, i13);
            }
            coordinatorLayout.onMeasureChild(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int downNestedPreScrollRange;
            if (i11 != 0) {
                if (i11 < 0) {
                    int i14 = -t10.getTotalScrollRange();
                    i13 = i14;
                    downNestedPreScrollRange = t10.getDownNestedPreScrollRange() + i14;
                } else {
                    i13 = -t10.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i13 != downNestedPreScrollRange) {
                    iArr[1] = f(coordinatorLayout, t10, d() - i11, i13, downNestedPreScrollRange);
                }
            }
            if (t10.isLiftOnScroll()) {
                t10.c(t10.d(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = f(coordinatorLayout, t10, d() - i13, -t10.getDownNestedScrollRange(), 0);
            }
            if (i13 != 0 || j0.hasAccessibilityDelegate(coordinatorLayout)) {
                return;
            }
            j0.setAccessibilityDelegate(coordinatorLayout, new com.google.android.material.appbar.b(coordinatorLayout, this, t10));
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t10, Parcelable parcelable) {
            if (!(parcelable instanceof a)) {
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t10, parcelable);
                this.f8734x = null;
            } else {
                a aVar = (a) parcelable;
                a aVar2 = this.f8734x;
                this.f8734x = aVar;
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t10, aVar.getSuperState());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t10) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) t10);
            a aVarK = k(parcelableOnSaveInstanceState, t10);
            return aVarK == null ? parcelableOnSaveInstanceState : aVarK;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, T r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r1 = this;
                r5 = r6 & 2
                r6 = 0
                if (r5 == 0) goto L2c
                boolean r5 = r3.isLiftOnScroll()
                r0 = 1
                if (r5 != 0) goto L2b
                int r5 = r3.getTotalScrollRange()
                if (r5 == 0) goto L14
                r5 = 1
                goto L15
            L14:
                r5 = 0
            L15:
                if (r5 == 0) goto L28
                int r2 = r2.getHeight()
                int r4 = r4.getHeight()
                int r2 = r2 - r4
                int r3 = r3.getHeight()
                if (r2 > r3) goto L28
                r2 = 1
                goto L29
            L28:
                r2 = 0
            L29:
                if (r2 == 0) goto L2c
            L2b:
                r6 = 1
            L2c:
                if (r6 == 0) goto L35
                android.animation.ValueAnimator r2 = r1.f8733w
                if (r2 == 0) goto L35
                r2.cancel()
            L35:
                r2 = 0
                r1.f8735y = r2
                r1.f8732v = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, android.view.View, int, int):boolean");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t10, View view, int i10) {
            if (this.f8732v == 0 || i10 == 1) {
                l(coordinatorLayout, t10);
                if (t10.isLiftOnScroll()) {
                    t10.c(t10.d(view));
                }
            }
            this.f8735y = new WeakReference<>(view);
        }

        public static class a extends f1.a {
            public static final Parcelable.Creator<a> CREATOR = new C0082a();

            /* renamed from: n, reason: collision with root package name */
            public boolean f8736n;

            /* renamed from: o, reason: collision with root package name */
            public boolean f8737o;

            /* renamed from: p, reason: collision with root package name */
            public int f8738p;

            /* renamed from: q, reason: collision with root package name */
            public float f8739q;

            /* renamed from: r, reason: collision with root package name */
            public boolean f8740r;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a, reason: collision with other inner class name */
            public class C0082a implements Parcelable.ClassLoaderCreator<a> {
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i10) {
                    return new a[i10];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel, null);
                }
            }

            public a(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f8736n = parcel.readByte() != 0;
                this.f8737o = parcel.readByte() != 0;
                this.f8738p = parcel.readInt();
                this.f8739q = parcel.readFloat();
                this.f8740r = parcel.readByte() != 0;
            }

            @Override // f1.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f8736n ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f8737o ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f8738p);
                parcel.writeFloat(this.f8739q);
                parcel.writeByte(this.f8740r ? (byte) 1 : (byte) 0);
            }

            public a(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // q6.e
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // q6.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i10, i11, i12, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i10, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i10);
        }

        @Override // q6.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // q6.e
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i10) {
            return super.setTopAndBottomOffset(i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends q6.d {
        public ScrollingViewBehavior() {
        }

        @Override // q6.d
        public final AppBarLayout a(List list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // q6.d
        public final float b(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.c behavior = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).getBehavior();
                int iD = behavior instanceof BaseBehavior ? ((BaseBehavior) behavior).d() : 0;
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iD > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iD / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // q6.d
        public final int c(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int iClamp;
            CoordinatorLayout.c behavior = ((CoordinatorLayout.f) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f8731u + this.f17914p;
                if (this.f17915q == 0) {
                    iClamp = 0;
                } else {
                    float fB = b(view2);
                    int i10 = this.f17915q;
                    iClamp = r0.a.clamp((int) (fB * i10), 0, i10);
                }
                j0.offsetTopAndBottom(view, bottom - iClamp);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.c(appBarLayout.d(view));
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                j0.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // q6.e, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            return super.onLayoutChild(coordinatorLayout, view, i10);
        }

        @Override // q6.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, view, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout appBarLayout;
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = dependencies.get(i10);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i10++;
            }
            if (appBarLayout != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f17912n;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayout.setExpanded(false, !z10);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a implements v {
        public a() {
        }

        @Override // x0.v
        public y0 onApplyWindowInsets(View view, y0 y0Var) {
            AppBarLayout appBarLayout = AppBarLayout.this;
            appBarLayout.getClass();
            y0 y0Var2 = j0.getFitsSystemWindows(appBarLayout) ? y0Var : null;
            if (!w0.c.equals(appBarLayout.f8722r, y0Var2)) {
                appBarLayout.f8722r = y0Var2;
                appBarLayout.setWillNotDraw(!(appBarLayout.G != null && appBarLayout.getTopInset() > 0));
                appBarLayout.requestLayout();
            }
            return y0Var;
        }
    }

    public interface b<T extends AppBarLayout> {
        void onOffsetChanged(T t10, int i10);
    }

    public static abstract class c {
        public abstract void onOffsetChanged(AppBarLayout appBarLayout, View view, float f10);
    }

    public static class d extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f8742a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        public final Rect f8743b = new Rect();

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, View view, float f10) {
            Rect rect = this.f8742a;
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
            float fAbs = rect.top - Math.abs(f10);
            if (fAbs > 0.0f) {
                j0.setClipBounds(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fClamp = 1.0f - r0.a.clamp(Math.abs(fAbs / rect.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((rect.height() * 0.3f) * (1.0f - (fClamp * fClamp)));
            view.setTranslationY(fHeight);
            Rect rect2 = this.f8743b;
            view.getDrawingRect(rect2);
            rect2.offset(0, (int) (-fHeight));
            if (fHeight >= rect2.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            j0.setClipBounds(view, rect2);
        }
    }

    public interface f {
        void onUpdate(float f10, int i10);
    }

    public interface g extends b<AppBarLayout> {
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public final void a() {
        Behavior behavior = this.J;
        BaseBehavior.a aVarK = (behavior == null || this.f8717m == -1 || this.f8721q != 0) ? null : behavior.k(f1.a.f11376m, this);
        this.f8717m = -1;
        this.f8718n = -1;
        this.f8719o = -1;
        if (aVarK != null) {
            Behavior behavior2 = this.J;
            if (behavior2.f8734x != null) {
                return;
            }
            behavior2.f8734x = aVarK;
        }
    }

    public void addOnOffsetChangedListener(b bVar) {
        if (this.f8723s == null) {
            this.f8723s = new ArrayList();
        }
        if (bVar == null || this.f8723s.contains(bVar)) {
            return;
        }
        this.f8723s.add(bVar);
    }

    public final void b(int i10) {
        this.f8716b = i10;
        if (!willNotDraw()) {
            j0.postInvalidateOnAnimation(this);
        }
        ArrayList arrayList = this.f8723s;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = (b) this.f8723s.get(i11);
                if (bVar != null) {
                    bVar.onOffsetChanged(this, i10);
                }
            }
        }
    }

    public final boolean c(boolean z10) {
        if (!(!this.f8724t) || this.f8726v == z10) {
            return false;
        }
        this.f8726v = z10;
        refreshDrawableState();
        if (!(getBackground() instanceof q7.g)) {
            return true;
        }
        if (this.f8730z) {
            e(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f8727w) {
            return true;
        }
        float f10 = this.I;
        e(z10 ? 0.0f : f10, z10 ? f10 : 0.0f);
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public final boolean d(View view) {
        int i10;
        if (this.f8729y == null && (i10 = this.f8728x) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i10) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f8728x);
            }
            if (viewFindViewById != null) {
                this.f8729y = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f8729y;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.G != null && getTopInset() > 0) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f8716b);
            this.G.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.G;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final void e(float f10, float f11) {
        ValueAnimator valueAnimator = this.A;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        this.A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.D);
        this.A.setInterpolator(this.E);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.B;
        if (animatorUpdateListener != null) {
            this.A.addUpdateListener(animatorUpdateListener);
        }
        this.A.start();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.J = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i10 = this.f8718n;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = eVar.f8744a;
                if ((i12 & 5) != 5) {
                    if (i11 > 0) {
                        break;
                    }
                } else {
                    int i13 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i12 & 8) != 0) {
                        minimumHeight = j0.getMinimumHeight(childAt);
                    } else if ((i12 & 2) != 0) {
                        minimumHeight = measuredHeight - j0.getMinimumHeight(childAt);
                    } else {
                        iMin = i13 + measuredHeight;
                        if (childCount == 0 && j0.getFitsSystemWindows(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i11 += iMin;
                    }
                    iMin = minimumHeight + i13;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i11 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i11);
        this.f8718n = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i10 = this.f8719o;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin + childAt.getMeasuredHeight();
                int i12 = eVar.f8744a;
                if ((i12 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i12 & 2) != 0) {
                    minimumHeight -= j0.getMinimumHeight(childAt);
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f8719o = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f8728x;
    }

    public q7.g getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof q7.g) {
            return (q7.g) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = j0.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? j0.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f8721q;
    }

    public Drawable getStatusBarForeground() {
        return this.G;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        y0 y0Var = this.f8722r;
        if (y0Var != null) {
            return y0Var.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f8717m;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = eVar.f8744a;
                if ((i12 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin + minimumHeight;
                if (i11 == 0 && j0.getFitsSystemWindows(childAt)) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i12 & 2) != 0) {
                    minimumHeight -= j0.getMinimumHeight(childAt);
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f8717m = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean isLiftOnScroll() {
        return this.f8727w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.F == null) {
            this.F = new int[4];
        }
        int[] iArr = this.F;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f8725u;
        int i11 = R.attr.state_liftable;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (z10 && this.f8726v) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i12 = R.attr.state_collapsible;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (z10 && this.f8726v) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.f8729y;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f8729y = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        /*
            r1 = this;
            super.onLayout(r2, r3, r4, r5, r6)
            boolean r2 = x0.j0.getFitsSystemWindows(r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            int r2 = r1.getChildCount()
            if (r2 <= 0) goto L25
            android.view.View r2 = r1.getChildAt(r3)
            int r5 = r2.getVisibility()
            r6 = 8
            if (r5 == r6) goto L25
            boolean r2 = x0.j0.getFitsSystemWindows(r2)
            if (r2 != 0) goto L25
            r2 = 1
            goto L26
        L25:
            r2 = 0
        L26:
            if (r2 == 0) goto L3d
            int r2 = r1.getTopInset()
            int r5 = r1.getChildCount()
            int r5 = r5 - r4
        L31:
            if (r5 < 0) goto L3d
            android.view.View r6 = r1.getChildAt(r5)
            x0.j0.offsetTopAndBottom(r6, r2)
            int r5 = r5 + (-1)
            goto L31
        L3d:
            r1.a()
            r1.f8720p = r3
            int r2 = r1.getChildCount()
            r5 = 0
        L47:
            if (r5 >= r2) goto L5f
            android.view.View r6 = r1.getChildAt(r5)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$e r6 = (com.google.android.material.appbar.AppBarLayout.e) r6
            android.view.animation.Interpolator r6 = r6.getScrollInterpolator()
            if (r6 == 0) goto L5c
            r1.f8720p = r4
            goto L5f
        L5c:
            int r5 = r5 + 1
            goto L47
        L5f:
            android.graphics.drawable.Drawable r2 = r1.G
            if (r2 == 0) goto L6e
            int r5 = r1.getWidth()
            int r6 = r1.getTopInset()
            r2.setBounds(r3, r3, r5, r6)
        L6e:
            boolean r2 = r1.f8724t
            if (r2 != 0) goto La8
            boolean r2 = r1.f8727w
            if (r2 != 0) goto L9e
            int r2 = r1.getChildCount()
            r5 = 0
        L7b:
            if (r5 >= r2) goto L9b
            android.view.View r6 = r1.getChildAt(r5)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$e r6 = (com.google.android.material.appbar.AppBarLayout.e) r6
            int r6 = r6.f8744a
            r0 = r6 & 1
            if (r0 != r4) goto L93
            r6 = r6 & 10
            if (r6 == 0) goto L93
            r6 = 1
            goto L94
        L93:
            r6 = 0
        L94:
            if (r6 == 0) goto L98
            r2 = 1
            goto L9c
        L98:
            int r5 = r5 + 1
            goto L7b
        L9b:
            r2 = 0
        L9c:
            if (r2 == 0) goto L9f
        L9e:
            r3 = 1
        L9f:
            boolean r2 = r1.f8725u
            if (r2 == r3) goto La8
            r1.f8725u = r3
            r1.refreshDrawableState()
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            super.onMeasure(r5, r6)
            int r5 = android.view.View.MeasureSpec.getMode(r6)
            r0 = 1073741824(0x40000000, float:2.0)
            if (r5 == r0) goto L58
            boolean r0 = x0.j0.getFitsSystemWindows(r4)
            if (r0 == 0) goto L58
            int r0 = r4.getChildCount()
            r1 = 0
            if (r0 <= 0) goto L2c
            android.view.View r0 = r4.getChildAt(r1)
            int r2 = r0.getVisibility()
            r3 = 8
            if (r2 == r3) goto L2c
            boolean r0 = x0.j0.getFitsSystemWindows(r0)
            if (r0 != 0) goto L2c
            r0 = 1
            goto L2d
        L2c:
            r0 = 0
        L2d:
            if (r0 == 0) goto L58
            int r0 = r4.getMeasuredHeight()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r2) goto L40
            if (r5 == 0) goto L3a
            goto L51
        L3a:
            int r5 = r4.getTopInset()
            int r0 = r0 + r5
            goto L51
        L40:
            int r5 = r4.getMeasuredHeight()
            int r0 = r4.getTopInset()
            int r0 = r0 + r5
            int r5 = android.view.View.MeasureSpec.getSize(r6)
            int r0 = r0.a.clamp(r0, r1, r5)
        L51:
            int r5 = r4.getMeasuredWidth()
            r4.setMeasuredDimension(r5, r0)
        L58:
            r4.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.onMeasure(int, int):void");
    }

    public void removeOnOffsetChangedListener(b bVar) {
        ArrayList arrayList = this.f8723s;
        if (arrayList == null || bVar == null) {
            return;
        }
        arrayList.remove(bVar);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        i.setElevation(this, f10);
    }

    public void setExpanded(boolean z10) {
        setExpanded(z10, j0.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f8727w = z10;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f8728x = -1;
        if (view != null) {
            this.f8729y = new WeakReference<>(view);
            return;
        }
        WeakReference<View> weakReference = this.f8729y;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f8729y = null;
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f8728x = i10;
        WeakReference<View> weakReference = this.f8729y;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f8729y = null;
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f8724t = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    public void setStatusBarForeground(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.G;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.G = drawableMutate;
            if (drawableMutate instanceof q7.g) {
                numValueOf = Integer.valueOf(((q7.g) drawableMutate).getResolvedTintColor());
            } else {
                ColorStateList colorStateListOrNull = e7.a.getColorStateListOrNull(drawableMutate);
                if (colorStateListOrNull != null) {
                    numValueOf = Integer.valueOf(colorStateListOrNull.getDefaultColor());
                }
            }
            this.H = numValueOf;
            Drawable drawable3 = this.G;
            boolean z10 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.G.setState(getDrawableState());
                }
                p0.a.setLayoutDirection(this.G, j0.getLayoutDirection(this));
                this.G.setVisible(getVisibility() == 0, false);
                this.G.setCallback(this);
            }
            if (this.G != null && getTopInset() > 0) {
                z10 = true;
            }
            setWillNotDraw(!z10);
            j0.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarForeground(s.a.getDrawable(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) throws Resources.NotFoundException {
        q6.g.a(this, f10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.G;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.G;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i11 = K;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8717m = -1;
        this.f8718n = -1;
        this.f8719o = -1;
        this.f8721q = 0;
        this.C = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i12 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context3, attributeSet, q6.g.f17923a, i10, i11, new int[0]);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayObtainStyledAttributes.getResourceId(0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = r.obtainStyledAttributes(context2, attributeSet, R.styleable.AppBarLayout, i10, i11, new int[0]);
            j0.setBackground(this, typedArrayObtainStyledAttributes2.getDrawable(R.styleable.AppBarLayout_android_background));
            final ColorStateList colorStateList = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes2, R.styleable.AppBarLayout_liftOnScrollColor);
            this.f8730z = colorStateList != null;
            final ColorStateList colorStateListOrNull = e7.a.getColorStateListOrNull(getBackground());
            if (colorStateListOrNull != null) {
                final q7.g gVar = new q7.g();
                gVar.setFillColor(colorStateListOrNull);
                if (colorStateList != null) {
                    final Integer colorOrNull = c7.a.getColorOrNull(getContext(), R.attr.colorSurface);
                    this.B = new ValueAnimator.AnimatorUpdateListener() { // from class: q6.a
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Integer num;
                            int i13 = AppBarLayout.K;
                            AppBarLayout appBarLayout = this.f17896b;
                            appBarLayout.getClass();
                            int iLayer = c7.a.layer(colorStateListOrNull.getDefaultColor(), colorStateList.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
                            ColorStateList colorStateListValueOf = ColorStateList.valueOf(iLayer);
                            q7.g gVar2 = gVar;
                            gVar2.setFillColor(colorStateListValueOf);
                            if (appBarLayout.G != null && (num = appBarLayout.H) != null && num.equals(colorOrNull)) {
                                p0.a.setTint(appBarLayout.G, iLayer);
                            }
                            ArrayList arrayList = appBarLayout.C;
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBarLayout.f fVar = (AppBarLayout.f) it.next();
                                if (gVar2.getFillColor() != null) {
                                    fVar.onUpdate(0.0f, iLayer);
                                }
                            }
                        }
                    };
                    j0.setBackground(this, gVar);
                } else {
                    gVar.initializeElevationOverlay(context2);
                    this.B = new p0(1, this, gVar);
                    j0.setBackground(this, gVar);
                }
            }
            this.D = k7.g.resolveThemeDuration(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.E = k7.g.resolveThemeInterpolator(context2, R.attr.motionEasingStandardInterpolator, p6.a.f17604a);
            int i13 = R.styleable.AppBarLayout_expanded;
            if (typedArrayObtainStyledAttributes2.hasValue(i13)) {
                this.f8721q = (typedArrayObtainStyledAttributes2.getBoolean(i13, false) ? 1 : 2) | 0 | 0;
                requestLayout();
            }
            if (typedArrayObtainStyledAttributes2.hasValue(R.styleable.AppBarLayout_elevation)) {
                q6.g.a(this, typedArrayObtainStyledAttributes2.getDimensionPixelSize(r15, 0));
            }
            if (i12 >= 26) {
                int i14 = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
                if (typedArrayObtainStyledAttributes2.hasValue(i14)) {
                    setKeyboardNavigationCluster(typedArrayObtainStyledAttributes2.getBoolean(i14, false));
                }
                int i15 = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
                if (typedArrayObtainStyledAttributes2.hasValue(i15)) {
                    setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes2.getBoolean(i15, false));
                }
            }
            this.I = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.f8727w = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
            this.f8728x = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(typedArrayObtainStyledAttributes2.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
            typedArrayObtainStyledAttributes2.recycle();
            j0.setOnApplyWindowInsetsListener(this, new a());
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void setExpanded(boolean z10, boolean z11) {
        this.f8721q = (z10 ? 1 : 2) | (z11 ? 4 : 0) | 8;
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    public void removeOnOffsetChangedListener(g gVar) {
        removeOnOffsetChangedListener((b) gVar);
    }

    public void addOnOffsetChangedListener(g gVar) {
        addOnOffsetChangedListener((b) gVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new e((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    public static class e extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f8744a;

        /* renamed from: b, reason: collision with root package name */
        public d f8745b;

        /* renamed from: c, reason: collision with root package name */
        public final Interpolator f8746c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8744a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f8744a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i10 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f8746c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i10, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public c getScrollEffect() {
            return this.f8745b;
        }

        public int getScrollFlags() {
            return this.f8744a;
        }

        public Interpolator getScrollInterpolator() {
            return this.f8746c;
        }

        public void setScrollEffect(int i10) {
            this.f8745b = i10 != 1 ? null : new d();
        }

        public void setScrollFlags(int i10) {
            this.f8744a = i10;
        }

        public e(int i10, int i11) {
            super(i10, i11);
            this.f8744a = 1;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8744a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8744a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8744a = 1;
        }
    }
}
