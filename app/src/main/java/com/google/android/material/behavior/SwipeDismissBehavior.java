package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.e;
import g1.c;
import x0.j0;
import y0.d;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: b, reason: collision with root package name */
    public g1.c f8792b;

    /* renamed from: m, reason: collision with root package name */
    public b f8793m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8794n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8795o;

    /* renamed from: p, reason: collision with root package name */
    public int f8796p = 2;

    /* renamed from: q, reason: collision with root package name */
    public final float f8797q = 0.5f;

    /* renamed from: r, reason: collision with root package name */
    public float f8798r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    public float f8799s = 0.5f;

    /* renamed from: t, reason: collision with root package name */
    public final a f8800t = new a();

    public class a extends c.AbstractC0148c {

        /* renamed from: a, reason: collision with root package name */
        public int f8801a;

        /* renamed from: b, reason: collision with root package name */
        public int f8802b = -1;

        public a() {
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            int width;
            int width2;
            int width3;
            boolean z10 = j0.getLayoutDirection(view) == 1;
            int i12 = SwipeDismissBehavior.this.f8796p;
            if (i12 == 0) {
                if (z10) {
                    width = this.f8801a - view.getWidth();
                    width2 = this.f8801a;
                } else {
                    width = this.f8801a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 != 1) {
                width = this.f8801a - view.getWidth();
                width2 = view.getWidth() + this.f8801a;
            } else if (z10) {
                width = this.f8801a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f8801a - view.getWidth();
                width2 = this.f8801a;
            }
            return Math.min(Math.max(width, i10), width2);
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // g1.c.AbstractC0148c
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // g1.c.AbstractC0148c
        public void onViewCaptured(View view, int i10) {
            this.f8802b = i10;
            this.f8801a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                swipeDismissBehavior.f8795o = true;
                parent.requestDisallowInterceptTouchEvent(true);
                swipeDismissBehavior.f8795o = false;
            }
        }

        @Override // g1.c.AbstractC0148c
        public void onViewDragStateChanged(int i10) {
            b bVar = SwipeDismissBehavior.this.f8793m;
            if (bVar != null) {
                ((e) bVar).onDragStateChanged(i10);
            }
        }

        @Override // g1.c.AbstractC0148c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f10 = width * swipeDismissBehavior.f8798r;
            float width2 = view.getWidth() * swipeDismissBehavior.f8799s;
            float fAbs = Math.abs(i10 - this.f8801a);
            if (fAbs <= f10) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f10) / (width2 - f10))), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
        @Override // g1.c.AbstractC0148c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onViewReleased(android.view.View r9, float r10, float r11) {
            /*
                r8 = this;
                r11 = -1
                r8.f8802b = r11
                int r11 = r9.getWidth()
                r0 = 0
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r2 = 1
                r3 = 0
                int r4 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r4 == 0) goto L3a
                int r5 = x0.j0.getLayoutDirection(r9)
                if (r5 != r2) goto L18
                r5 = 1
                goto L19
            L18:
                r5 = 0
            L19:
                int r6 = r1.f8796p
                r7 = 2
                if (r6 != r7) goto L1f
                goto L2a
            L1f:
                if (r6 != 0) goto L2e
                if (r5 == 0) goto L28
                int r4 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r4 >= 0) goto L2c
                goto L2a
            L28:
                if (r4 <= 0) goto L2c
            L2a:
                r4 = 1
                goto L55
            L2c:
                r4 = 0
                goto L55
            L2e:
                if (r6 != r2) goto L2c
                if (r5 == 0) goto L35
                if (r4 <= 0) goto L2c
                goto L39
            L35:
                int r4 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r4 >= 0) goto L2c
            L39:
                goto L2a
            L3a:
                int r4 = r9.getLeft()
                int r5 = r8.f8801a
                int r4 = r4 - r5
                int r5 = r9.getWidth()
                float r5 = (float) r5
                float r6 = r1.f8797q
                float r5 = r5 * r6
                int r5 = java.lang.Math.round(r5)
                int r4 = java.lang.Math.abs(r4)
                if (r4 < r5) goto L2c
                goto L2a
            L55:
                if (r4 == 0) goto L6b
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L66
                int r10 = r9.getLeft()
                int r0 = r8.f8801a
                if (r10 >= r0) goto L64
                goto L66
            L64:
                int r0 = r0 + r11
                goto L6e
            L66:
                int r10 = r8.f8801a
                int r0 = r10 - r11
                goto L6e
            L6b:
                int r0 = r8.f8801a
                r2 = 0
            L6e:
                g1.c r10 = r1.f8792b
                int r11 = r9.getTop()
                boolean r10 = r10.settleCapturedViewAt(r0, r11)
                if (r10 == 0) goto L83
                com.google.android.material.behavior.SwipeDismissBehavior$c r10 = new com.google.android.material.behavior.SwipeDismissBehavior$c
                r10.<init>(r9, r2)
                x0.j0.postOnAnimation(r9, r10)
                goto L8e
            L83:
                if (r2 == 0) goto L8e
                com.google.android.material.behavior.SwipeDismissBehavior$b r10 = r1.f8793m
                if (r10 == 0) goto L8e
                com.google.android.material.snackbar.e r10 = (com.google.android.material.snackbar.e) r10
                r10.onDismiss(r9)
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.onViewReleased(android.view.View, float, float):void");
        }

        @Override // g1.c.AbstractC0148c
        public boolean tryCaptureView(View view, int i10) {
            int i11 = this.f8802b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    }

    public interface b {
    }

    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final View f8804b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f8805m;

        public c(View view, boolean z10) {
            this.f8804b = view;
            this.f8805m = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            g1.c cVar = swipeDismissBehavior.f8792b;
            View view = this.f8804b;
            if (cVar != null && cVar.continueSettling(true)) {
                j0.postOnAnimation(view, this);
            } else {
                if (!this.f8805m || (bVar = swipeDismissBehavior.f8793m) == null) {
                    return;
                }
                ((e) bVar).onDismiss(view);
            }
        }
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.f8794n;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f8794n = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f8794n = false;
        }
        if (!zIsPointInChildBounds) {
            return false;
        }
        if (this.f8792b == null) {
            this.f8792b = g1.c.create(coordinatorLayout, this.f8800t);
        }
        return !this.f8795o && this.f8792b.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v10, i10);
        if (j0.getImportantForAccessibility(v10) == 0) {
            j0.setImportantForAccessibility(v10, 1);
            j0.removeAccessibilityAction(v10, 1048576);
            if (canSwipeDismissView(v10)) {
                j0.replaceAccessibilityAction(v10, d.a.f21827l, null, new com.google.android.material.behavior.a(this));
            }
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (this.f8792b == null) {
            return false;
        }
        if (this.f8795o && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f8792b.processTouchEvent(motionEvent);
        return true;
    }

    public void setEndAlphaSwipeDistance(float f10) {
        this.f8799s = Math.min(Math.max(0.0f, f10), 1.0f);
    }

    public void setListener(b bVar) {
        this.f8793m = bVar;
    }

    public void setStartAlphaSwipeDistance(float f10) {
        this.f8798r = Math.min(Math.max(0.0f, f10), 1.0f);
    }

    public void setSwipeDirection(int i10) {
        this.f8796p = i10;
    }
}
