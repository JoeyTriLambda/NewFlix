package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import cz.msebera.android.httpclient.HttpStatus;
import g1.c;
import java.util.ArrayList;
import java.util.List;
import x0.j0;
import x0.y0;
import y0.d;
import y0.g;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] O = {R.attr.colorPrimaryDark};
    public static final int[] P = {R.attr.layout_gravity};
    public static final boolean Q;
    public static final boolean R;
    public static final boolean S;
    public int A;
    public int B;
    public boolean C;
    public e D;
    public ArrayList E;
    public float F;
    public float G;
    public Drawable H;
    public Object I;
    public boolean J;
    public final ArrayList<View> K;
    public Rect L;
    public Matrix M;
    public final a N;

    /* renamed from: b, reason: collision with root package name */
    public final d f2556b;

    /* renamed from: m, reason: collision with root package name */
    public float f2557m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2558n;

    /* renamed from: o, reason: collision with root package name */
    public int f2559o;

    /* renamed from: p, reason: collision with root package name */
    public float f2560p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f2561q;

    /* renamed from: r, reason: collision with root package name */
    public final g1.c f2562r;

    /* renamed from: s, reason: collision with root package name */
    public final g1.c f2563s;

    /* renamed from: t, reason: collision with root package name */
    public final i f2564t;

    /* renamed from: u, reason: collision with root package name */
    public final i f2565u;

    /* renamed from: v, reason: collision with root package name */
    public int f2566v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2567w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2568x;

    /* renamed from: y, reason: collision with root package name */
    public int f2569y;

    /* renamed from: z, reason: collision with root package name */
    public int f2570z;

    public class a implements y0.g {
        public a() {
        }

        @Override // y0.g
        public boolean perform(View view, g.a aVar) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (!drawerLayout.isDrawerOpen(view) || drawerLayout.getDrawerLockMode(view) == 2) {
                return false;
            }
            drawerLayout.closeDrawer(view);
            return true;
        }
    }

    public class b implements View.OnApplyWindowInsetsListener {
        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public class c extends x0.a {

        /* renamed from: d, reason: collision with root package name */
        public final Rect f2572d = new Rect();

        public c() {
        }

        @Override // x0.a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewE = drawerLayout.e();
            if (viewE == null || (drawerTitle = drawerLayout.getDrawerTitle(drawerLayout.f(viewE))) == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        @Override // x0.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            if (DrawerLayout.Q) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
            } else {
                y0.d dVarObtain = y0.d.obtain(dVar);
                super.onInitializeAccessibilityNodeInfo(view, dVarObtain);
                dVar.setSource(view);
                Object parentForAccessibility = j0.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    dVar.setParent((View) parentForAccessibility);
                }
                Rect rect = this.f2572d;
                dVarObtain.getBoundsInScreen(rect);
                dVar.setBoundsInScreen(rect);
                dVar.setVisibleToUser(dVarObtain.isVisibleToUser());
                dVar.setPackageName(dVarObtain.getPackageName());
                dVar.setClassName(dVarObtain.getClassName());
                dVar.setContentDescription(dVarObtain.getContentDescription());
                dVar.setEnabled(dVarObtain.isEnabled());
                dVar.setFocused(dVarObtain.isFocused());
                dVar.setAccessibilityFocused(dVarObtain.isAccessibilityFocused());
                dVar.setSelected(dVarObtain.isSelected());
                dVar.addAction(dVarObtain.getActions());
                dVarObtain.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (DrawerLayout.h(childAt)) {
                        dVar.addChild(childAt);
                    }
                }
            }
            dVar.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            dVar.setFocusable(false);
            dVar.setFocused(false);
            dVar.removeAction(d.a.f21820e);
            dVar.removeAction(d.a.f21821f);
        }

        @Override // x0.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.Q || DrawerLayout.h(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public static final class d extends x0.a {
        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (DrawerLayout.h(view)) {
                return;
            }
            dVar.setParent(null);
        }
    }

    public interface e {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f10);

        void onDrawerStateChanged(int i10);
    }

    public class i extends c.AbstractC0148c {

        /* renamed from: a, reason: collision with root package name */
        public final int f2583a;

        /* renamed from: b, reason: collision with root package name */
        public g1.c f2584b;

        /* renamed from: c, reason: collision with root package name */
        public final a f2585c = new a();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View viewC;
                int width;
                i iVar = i.this;
                int edgeSize = iVar.f2584b.getEdgeSize();
                int i10 = iVar.f2583a;
                boolean z10 = i10 == 3;
                DrawerLayout drawerLayout = DrawerLayout.this;
                if (z10) {
                    viewC = drawerLayout.c(3);
                    width = (viewC != null ? -viewC.getWidth() : 0) + edgeSize;
                } else {
                    viewC = drawerLayout.c(5);
                    width = drawerLayout.getWidth() - edgeSize;
                }
                if (viewC != null) {
                    if (((!z10 || viewC.getLeft() >= width) && (z10 || viewC.getLeft() <= width)) || drawerLayout.getDrawerLockMode(viewC) != 0) {
                        return;
                    }
                    f fVar = (f) viewC.getLayoutParams();
                    iVar.f2584b.smoothSlideViewTo(viewC, width, viewC.getTop());
                    fVar.f2576c = true;
                    drawerLayout.invalidate();
                    View viewC2 = drawerLayout.c(i10 == 3 ? 5 : 3);
                    if (viewC2 != null) {
                        drawerLayout.closeDrawer(viewC2);
                    }
                    if (drawerLayout.C) {
                        return;
                    }
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        drawerLayout.getChildAt(i11).dispatchTouchEvent(motionEventObtain);
                    }
                    motionEventObtain.recycle();
                    drawerLayout.C = true;
                }
            }
        }

        public i(int i10) {
            this.f2583a = i10;
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (drawerLayout.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i10, 0));
            }
            int width = drawerLayout.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i10, width));
        }

        @Override // g1.c.AbstractC0148c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // g1.c.AbstractC0148c
        public int getViewHorizontalDragRange(View view) {
            DrawerLayout.this.getClass();
            if (DrawerLayout.j(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // g1.c.AbstractC0148c
        public void onEdgeDragStarted(int i10, int i11) {
            int i12 = i10 & 1;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewC = i12 == 1 ? drawerLayout.c(3) : drawerLayout.c(5);
            if (viewC == null || drawerLayout.getDrawerLockMode(viewC) != 0) {
                return;
            }
            this.f2584b.captureChildView(viewC, i11);
        }

        @Override // g1.c.AbstractC0148c
        public boolean onEdgeLock(int i10) {
            return false;
        }

        @Override // g1.c.AbstractC0148c
        public void onEdgeTouched(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f2585c, 160L);
        }

        @Override // g1.c.AbstractC0148c
        public void onViewCaptured(View view, int i10) {
            ((f) view.getLayoutParams()).f2576c = false;
            int i11 = this.f2583a == 3 ? 5 : 3;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewC = drawerLayout.c(i11);
            if (viewC != null) {
                drawerLayout.closeDrawer(viewC);
            }
        }

        @Override // g1.c.AbstractC0148c
        public void onViewDragStateChanged(int i10) {
            DrawerLayout.this.o(this.f2584b.getCapturedView(), i10);
        }

        @Override // g1.c.AbstractC0148c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            int width = view.getWidth();
            DrawerLayout drawerLayout = DrawerLayout.this;
            float width2 = (drawerLayout.a(view, 3) ? i10 + width : drawerLayout.getWidth() - i10) / width;
            drawerLayout.l(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            drawerLayout.invalidate();
        }

        @Override // g1.c.AbstractC0148c
        public void onViewReleased(View view, float f10, float f11) {
            int i10;
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            float f12 = ((f) view.getLayoutParams()).f2575b;
            int width = view.getWidth();
            if (drawerLayout.a(view, 3)) {
                i10 = (f10 > 0.0f || (f10 == 0.0f && f12 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = drawerLayout.getWidth();
                if (f10 < 0.0f || (f10 == 0.0f && f12 > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f2584b.settleCapturedViewAt(i10, view.getTop());
            drawerLayout.invalidate();
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.f2585c);
        }

        public void setDragger(g1.c cVar) {
            this.f2584b = cVar;
        }

        @Override // g1.c.AbstractC0148c
        public boolean tryCaptureView(View view, int i10) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            return DrawerLayout.j(view) && drawerLayout.a(view, this.f2583a) && drawerLayout.getDrawerLockMode(view) == 0;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        Q = true;
        R = true;
        S = i10 >= 29;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public static String g(int i10) {
        return (i10 & 3) == 3 ? "LEFT" : (i10 & 5) == 5 ? "RIGHT" : Integer.toHexString(i10);
    }

    public static boolean h(View view) {
        return (j0.getImportantForAccessibility(view) == 4 || j0.getImportantForAccessibility(view) == 2) ? false : true;
    }

    public static boolean i(View view) {
        return ((f) view.getLayoutParams()).f2574a == 0;
    }

    public static boolean j(View view) {
        int absoluteGravity = x0.h.getAbsoluteGravity(((f) view.getLayoutParams()).f2574a, j0.getLayoutDirection(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public final boolean a(View view, int i10) {
        return (f(view) & i10) == i10;
    }

    public void addDrawerListener(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        ArrayList<View> arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            arrayList2 = this.K;
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (!j(childAt)) {
                arrayList2.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i10, i11);
                z10 = true;
            }
            i12++;
        }
        if (!z10) {
            int size = arrayList2.size();
            for (int i13 = 0; i13 < size; i13++) {
                View view = arrayList2.get(i13);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i10, i11);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (d() != null || j(view)) {
            j0.setImportantForAccessibility(view, 4);
        } else {
            j0.setImportantForAccessibility(view, 1);
        }
        if (Q) {
            return;
        }
        j0.setAccessibilityDelegate(view, this.f2556b);
    }

    public final void b(boolean z10) {
        boolean zSmoothSlideViewTo;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVar = (f) childAt.getLayoutParams();
            if (j(childAt) && (!z10 || fVar.f2576c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    int top = childAt.getTop();
                    zSmoothSlideViewTo = this.f2562r.smoothSlideViewTo(childAt, -width, top);
                } else {
                    zSmoothSlideViewTo = this.f2563s.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                z11 |= zSmoothSlideViewTo;
                fVar.f2576c = false;
            }
        }
        this.f2564t.removeCallbacks();
        this.f2565u.removeCallbacks();
        if (z11) {
            invalidate();
        }
    }

    public final View c(int i10) {
        int absoluteGravity = x0.h.getAbsoluteGravity(i10, j0.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((f(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        b(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            fMax = Math.max(fMax, ((f) getChildAt(i10).getLayoutParams()).f2575b);
        }
        this.f2560p = fMax;
        boolean zContinueSettling = this.f2562r.continueSettling(true);
        boolean zContinueSettling2 = this.f2563s.continueSettling(true);
        if (zContinueSettling || zContinueSettling2) {
            j0.postInvalidateOnAnimation(this);
        }
    }

    public final View d() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((f) childAt.getLayoutParams()).f2577d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2560p <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (this.L == null) {
                this.L = new Rect();
            }
            childAt.getHitRect(this.L);
            if (this.L.contains((int) x10, (int) y10) && !i(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.M == null) {
                            this.M = new Matrix();
                        }
                        matrix.invert(this.M);
                        motionEventObtain.transform(this.M);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        int height = getHeight();
        boolean zI = i(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i10 = 0;
        if (zI) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if ((background != null && background.getOpacity() == -1) && j(childAt) && childAt.getHeight() >= height) {
                        if (a(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i11) {
                                i11 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i11, 0, width, getHeight());
            i10 = i11;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(iSave);
        float f10 = this.f2560p;
        if (f10 > 0.0f && zI) {
            int i13 = this.f2559o;
            Paint paint = this.f2561q;
            paint.setColor((((int) ((((-16777216) & i13) >>> 24) * f10)) << 24) | (i13 & 16777215));
            canvas.drawRect(i10, 0.0f, width, getHeight(), paint);
        }
        return zDrawChild;
    }

    public final View e() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (j(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public final int f(View view) {
        return x0.h.getAbsoluteGravity(((f) view.getLayoutParams()).f2574a, j0.getLayoutDirection(this));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (R) {
            return this.f2557m;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i10) {
        int layoutDirection = j0.getLayoutDirection(this);
        if (i10 == 3) {
            int i11 = this.f2569y;
            if (i11 != 3) {
                return i11;
            }
            int i12 = layoutDirection == 0 ? this.A : this.B;
            if (i12 != 3) {
                return i12;
            }
            return 0;
        }
        if (i10 == 5) {
            int i13 = this.f2570z;
            if (i13 != 3) {
                return i13;
            }
            int i14 = layoutDirection == 0 ? this.B : this.A;
            if (i14 != 3) {
                return i14;
            }
            return 0;
        }
        if (i10 == 8388611) {
            int i15 = this.A;
            if (i15 != 3) {
                return i15;
            }
            int i16 = layoutDirection == 0 ? this.f2569y : this.f2570z;
            if (i16 != 3) {
                return i16;
            }
            return 0;
        }
        if (i10 != 8388613) {
            return 0;
        }
        int i17 = this.B;
        if (i17 != 3) {
            return i17;
        }
        int i18 = layoutDirection == 0 ? this.f2570z : this.f2569y;
        if (i18 != 3) {
            return i18;
        }
        return 0;
    }

    public CharSequence getDrawerTitle(int i10) {
        x0.h.getAbsoluteGravity(i10, j0.getLayoutDirection(this));
        return null;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.H;
    }

    public boolean isDrawerOpen(View view) {
        if (j(view)) {
            return (((f) view.getLayoutParams()).f2577d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(View view) {
        if (j(view)) {
            return ((f) view.getLayoutParams()).f2575b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final void k(View view, float f10) {
        float f11 = ((f) view.getLayoutParams()).f2575b;
        float width = view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (f11 * width));
        if (!a(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        l(view, f10);
    }

    public final void l(View view, float f10) {
        f fVar = (f) view.getLayoutParams();
        if (f10 == fVar.f2575b) {
            return;
        }
        fVar.f2575b = f10;
        ArrayList arrayList = this.E;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((e) this.E.get(size)).onDrawerSlide(view, f10);
            }
        }
    }

    public final void m(View view) {
        d.a aVar = d.a.f21827l;
        j0.removeAccessibilityAction(view, aVar.getId());
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        j0.replaceAccessibilityAction(view, aVar, null, this.N);
    }

    public final void n(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((z10 || j(childAt)) && !(z10 && childAt == view)) {
                j0.setImportantForAccessibility(childAt, 4);
            } else {
                j0.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    public final void o(View view, int i10) {
        int i11;
        View rootView;
        int viewDragState = this.f2562r.getViewDragState();
        int viewDragState2 = this.f2563s.getViewDragState();
        if (viewDragState == 1 || viewDragState2 == 1) {
            i11 = 1;
        } else {
            i11 = 2;
            if (viewDragState != 2 && viewDragState2 != 2) {
                i11 = 0;
            }
        }
        if (view != null && i10 == 0) {
            float f10 = ((f) view.getLayoutParams()).f2575b;
            if (f10 == 0.0f) {
                f fVar = (f) view.getLayoutParams();
                if ((fVar.f2577d & 1) == 1) {
                    fVar.f2577d = 0;
                    ArrayList arrayList = this.E;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((e) this.E.get(size)).onDrawerClosed(view);
                        }
                    }
                    n(view, false);
                    m(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f10 == 1.0f) {
                f fVar2 = (f) view.getLayoutParams();
                if ((fVar2.f2577d & 1) == 0) {
                    fVar2.f2577d = 1;
                    ArrayList arrayList2 = this.E;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((e) this.E.get(size2)).onDrawerOpened(view);
                        }
                    }
                    n(view, true);
                    m(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i11 != this.f2566v) {
            this.f2566v = i11;
            ArrayList arrayList3 = this.E;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((e) this.E.get(size3)).onDrawerStateChanged(i11);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2568x = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2568x = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.J || this.H == null) {
            return;
        }
        Object obj = this.I;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.H.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.H.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            g1.c r1 = r7.f2562r
            boolean r2 = r1.shouldInterceptTouchEvent(r8)
            g1.c r3 = r7.f2563s
            boolean r3 = r3.shouldInterceptTouchEvent(r8)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L36
            if (r0 == r3) goto L2f
            r8 = 2
            r5 = 3
            if (r0 == r8) goto L1e
            if (r0 == r5) goto L2f
            goto L34
        L1e:
            boolean r8 = r1.checkTouchSlop(r5)
            if (r8 == 0) goto L34
            androidx.drawerlayout.widget.DrawerLayout$i r8 = r7.f2564t
            r8.removeCallbacks()
            androidx.drawerlayout.widget.DrawerLayout$i r8 = r7.f2565u
            r8.removeCallbacks()
            goto L34
        L2f:
            r7.b(r3)
            r7.C = r4
        L34:
            r8 = 0
            goto L5c
        L36:
            float r0 = r8.getX()
            float r8 = r8.getY()
            r7.F = r0
            r7.G = r8
            float r5 = r7.f2560p
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L59
            int r0 = (int) r0
            int r8 = (int) r8
            android.view.View r8 = r1.findTopChildUnder(r0, r8)
            if (r8 == 0) goto L59
            boolean r8 = i(r8)
            if (r8 == 0) goto L59
            r8 = 1
            goto L5a
        L59:
            r8 = 0
        L5a:
            r7.C = r4
        L5c:
            if (r2 != 0) goto L83
            if (r8 != 0) goto L83
            int r8 = r7.getChildCount()
            r0 = 0
        L65:
            if (r0 >= r8) goto L7a
            android.view.View r1 = r7.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$f r1 = (androidx.drawerlayout.widget.DrawerLayout.f) r1
            boolean r1 = r1.f2576c
            if (r1 == 0) goto L77
            r8 = 1
            goto L7b
        L77:
            int r0 = r0 + 1
            goto L65
        L7a:
            r8 = 0
        L7b:
            if (r8 != 0) goto L83
            boolean r8 = r7.C
            if (r8 == 0) goto L82
            goto L83
        L82:
            r3 = 0
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            if (e() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        View viewE = e();
        if (viewE != null && getDrawerLockMode(viewE) == 0) {
            closeDrawers();
        }
        return viewE != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        WindowInsets rootWindowInsets;
        float f10;
        int i14;
        this.f2567w = true;
        int i15 = i12 - i10;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (i(childAt)) {
                    int i17 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i17, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i17, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f11 = measuredWidth;
                        i14 = (-measuredWidth) + ((int) (fVar.f2575b * f11));
                        f10 = (measuredWidth + i14) / f11;
                    } else {
                        float f12 = measuredWidth;
                        f10 = (i15 - r11) / f12;
                        i14 = i15 - ((int) (fVar.f2575b * f12));
                    }
                    boolean z11 = f10 != fVar.f2575b;
                    int i18 = fVar.f2574a & 112;
                    if (i18 == 16) {
                        int i19 = i13 - i11;
                        int i20 = (i19 - measuredHeight) / 2;
                        int i21 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i20 < i21) {
                            i20 = i21;
                        } else {
                            int i22 = i20 + measuredHeight;
                            int i23 = i19 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i22 > i23) {
                                i20 = i23 - measuredHeight;
                            }
                        }
                        childAt.layout(i14, i20, measuredWidth + i14, measuredHeight + i20);
                    } else if (i18 != 80) {
                        int i24 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i14, i24, measuredWidth + i14, measuredHeight + i24);
                    } else {
                        int i25 = i13 - i11;
                        childAt.layout(i14, (i25 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i14, i25 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z11) {
                        l(childAt, f10);
                    }
                    int i26 = fVar.f2575b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i26) {
                        childAt.setVisibility(i26);
                    }
                }
            }
        }
        if (S && (rootWindowInsets = getRootWindowInsets()) != null) {
            o0.b systemGestureInsets = y0.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            g1.c cVar = this.f2562r;
            cVar.setEdgeSize(Math.max(cVar.getDefaultEdgeSize(), systemGestureInsets.f16884a));
            g1.c cVar2 = this.f2563s;
            cVar2.setEdgeSize(Math.max(cVar2.getDefaultEdgeSize(), systemGestureInsets.f16886c));
        }
        this.f2567w = false;
        this.f2568x = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = HttpStatus.SC_MULTIPLE_CHOICES;
            }
            if (mode2 == 0) {
                size2 = HttpStatus.SC_MULTIPLE_CHOICES;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z10 = this.I != null && j0.getFitsSystemWindows(this);
        int layoutDirection = j0.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z11 = false;
        boolean z12 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z10) {
                    int absoluteGravity = x0.h.getAbsoluteGravity(fVar.f2574a, layoutDirection);
                    if (j0.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.I;
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.I;
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (i(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else {
                    if (!j(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i12 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (R) {
                        float elevation = j0.getElevation(childAt);
                        float f10 = this.f2557m;
                        if (elevation != f10) {
                            j0.setElevation(childAt, f10);
                        }
                    }
                    int iF = f(childAt) & 7;
                    boolean z13 = iF == 3;
                    if ((z13 && z11) || (!z13 && z12)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + g(iF) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z13) {
                        z11 = true;
                    } else {
                        z12 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f2558n + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewC;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        int i10 = gVar.f2578n;
        if (i10 != 0 && (viewC = c(i10)) != null) {
            openDrawer(viewC);
        }
        int i11 = gVar.f2579o;
        if (i11 != 3) {
            setDrawerLockMode(i11, 3);
        }
        int i12 = gVar.f2580p;
        if (i12 != 3) {
            setDrawerLockMode(i12, 5);
        }
        int i13 = gVar.f2581q;
        if (i13 != 3) {
            setDrawerLockMode(i13, 8388611);
        }
        int i14 = gVar.f2582r;
        if (i14 != 3) {
            setDrawerLockMode(i14, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        if (R) {
            return;
        }
        j0.getLayoutDirection(this);
        j0.getLayoutDirection(this);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            f fVar = (f) getChildAt(i10).getLayoutParams();
            int i11 = fVar.f2577d;
            boolean z10 = i11 == 1;
            boolean z11 = i11 == 2;
            if (z10 || z11) {
                gVar.f2578n = fVar.f2574a;
                break;
            }
        }
        gVar.f2579o = this.f2569y;
        gVar.f2580p = this.f2570z;
        gVar.f2581q = this.A;
        gVar.f2582r = this.B;
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            g1.c r0 = r6.f2562r
            r0.processTouchEvent(r7)
            g1.c r1 = r6.f2563s
            r1.processTouchEvent(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L5e
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            goto L6c
        L1a:
            r6.b(r3)
            r6.C = r2
            goto L6c
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.findTopChildUnder(r4, r5)
            if (r4 == 0) goto L59
            boolean r4 = i(r4)
            if (r4 == 0) goto L59
            float r4 = r6.F
            float r1 = r1 - r4
            float r4 = r6.G
            float r7 = r7 - r4
            int r0 = r0.getTouchSlop()
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L59
            android.view.View r7 = r6.d()
            if (r7 == 0) goto L59
            int r7 = r6.getDrawerLockMode(r7)
            r0 = 2
            if (r7 != r0) goto L5a
        L59:
            r2 = 1
        L5a:
            r6.b(r2)
            goto L6c
        L5e:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.F = r0
            r6.G = r7
            r6.C = r2
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void openDrawer(View view) {
        openDrawer(view, true);
    }

    public void removeDrawerListener(e eVar) {
        ArrayList arrayList;
        if (eVar == null || (arrayList = this.E) == null) {
            return;
        }
        arrayList.remove(eVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            b(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2567w) {
            return;
        }
        super.requestLayout();
    }

    public void setChildInsets(Object obj, boolean z10) {
        this.I = obj;
        this.J = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f10) {
        this.f2557m = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (j(childAt)) {
                j0.setElevation(childAt, this.f2557m);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.D;
        if (eVar2 != null) {
            removeDrawerListener(eVar2);
        }
        if (eVar != null) {
            addDrawerListener(eVar);
        }
        this.D = eVar;
    }

    public void setDrawerLockMode(int i10) {
        setDrawerLockMode(i10, 3);
        setDrawerLockMode(i10, 5);
    }

    public void setScrimColor(int i10) {
        this.f2559o = i10;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.H = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i10) {
        this.H = new ColorDrawable(i10);
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2556b = new d();
        this.f2559o = -1728053248;
        this.f2561q = new Paint();
        this.f2568x = true;
        this.f2569y = 3;
        this.f2570z = 3;
        this.A = 3;
        this.B = 3;
        this.N = new a();
        setDescendantFocusability(262144);
        float f10 = getResources().getDisplayMetrics().density;
        this.f2558n = (int) ((64.0f * f10) + 0.5f);
        float f11 = f10 * 400.0f;
        i iVar = new i(3);
        this.f2564t = iVar;
        i iVar2 = new i(5);
        this.f2565u = iVar2;
        g1.c cVarCreate = g1.c.create(this, 1.0f, iVar);
        this.f2562r = cVarCreate;
        cVarCreate.setEdgeTrackingEnabled(1);
        cVarCreate.setMinVelocity(f11);
        iVar.setDragger(cVarCreate);
        g1.c cVarCreate2 = g1.c.create(this, 1.0f, iVar2);
        this.f2563s = cVarCreate2;
        cVarCreate2.setEdgeTrackingEnabled(2);
        cVarCreate2.setMinVelocity(f11);
        iVar2.setDragger(cVarCreate2);
        setFocusableInTouchMode(true);
        j0.setImportantForAccessibility(this, 1);
        j0.setAccessibilityDelegate(this, new c());
        setMotionEventSplittingEnabled(false);
        if (j0.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(O);
            try {
                this.H = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i10, 0);
        try {
            int i11 = androidx.drawerlayout.R.styleable.DrawerLayout_elevation;
            if (typedArrayObtainStyledAttributes2.hasValue(i11)) {
                this.f2557m = typedArrayObtainStyledAttributes2.getDimension(i11, 0.0f);
            } else {
                this.f2557m = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.K = new ArrayList<>();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void closeDrawer(View view, boolean z10) {
        if (!j(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f2568x) {
            fVar.f2575b = 0.0f;
            fVar.f2577d = 0;
        } else if (z10) {
            fVar.f2577d |= 4;
            if (a(view, 3)) {
                this.f2562r.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
            } else {
                this.f2563s.smoothSlideViewTo(view, getWidth(), view.getTop());
            }
        } else {
            k(view, 0.0f);
            o(view, 0);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void openDrawer(View view, boolean z10) {
        if (!j(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f2568x) {
            fVar.f2575b = 1.0f;
            fVar.f2577d = 1;
            n(view, true);
            m(view);
        } else if (z10) {
            fVar.f2577d |= 2;
            if (a(view, 3)) {
                this.f2562r.smoothSlideViewTo(view, 0, view.getTop());
            } else {
                this.f2563s.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            k(view, 1.0f);
            o(view, 0);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void setDrawerLockMode(int i10, int i11) {
        View viewC;
        int absoluteGravity = x0.h.getAbsoluteGravity(i11, j0.getLayoutDirection(this));
        if (i11 == 3) {
            this.f2569y = i10;
        } else if (i11 == 5) {
            this.f2570z = i10;
        } else if (i11 == 8388611) {
            this.A = i10;
        } else if (i11 == 8388613) {
            this.B = i10;
        }
        if (i10 != 0) {
            (absoluteGravity == 3 ? this.f2562r : this.f2563s).cancel();
        }
        if (i10 != 1) {
            if (i10 == 2 && (viewC = c(absoluteGravity)) != null) {
                openDrawer(viewC);
                return;
            }
            return;
        }
        View viewC2 = c(absoluteGravity);
        if (viewC2 != null) {
            closeDrawer(viewC2);
        }
    }

    public void setStatusBarBackground(int i10) {
        this.H = i10 != 0 ? m0.a.getDrawable(getContext(), i10) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i10) {
        View viewC = c(i10);
        if (viewC != null) {
            return isDrawerVisible(viewC);
        }
        return false;
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public final int f2574a;

        /* renamed from: b, reason: collision with root package name */
        public float f2575b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2576c;

        /* renamed from: d, reason: collision with root package name */
        public int f2577d;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2574a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.P);
            this.f2574a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f2574a = 0;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f2574a = 0;
            this.f2574a = fVar.f2574a;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2574a = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2574a = 0;
        }
    }

    public boolean isDrawerOpen(int i10) {
        View viewC = c(i10);
        if (viewC != null) {
            return isDrawerOpen(viewC);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public static class g extends f1.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public int f2578n;

        /* renamed from: o, reason: collision with root package name */
        public int f2579o;

        /* renamed from: p, reason: collision with root package name */
        public int f2580p;

        /* renamed from: q, reason: collision with root package name */
        public int f2581q;

        /* renamed from: r, reason: collision with root package name */
        public int f2582r;

        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public g[] newArray(int i10) {
                return new g[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2578n = 0;
            this.f2578n = parcel.readInt();
            this.f2579o = parcel.readInt();
            this.f2580p = parcel.readInt();
            this.f2581q = parcel.readInt();
            this.f2582r = parcel.readInt();
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2578n);
            parcel.writeInt(this.f2579o);
            parcel.writeInt(this.f2580p);
            parcel.writeInt(this.f2581q);
            parcel.writeInt(this.f2582r);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
            this.f2578n = 0;
        }
    }

    public int getDrawerLockMode(View view) {
        if (j(view)) {
            return getDrawerLockMode(((f) view.getLayoutParams()).f2574a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void closeDrawer(int i10) {
        closeDrawer(i10, true);
    }

    public void closeDrawer(int i10, boolean z10) {
        View viewC = c(i10);
        if (viewC != null) {
            closeDrawer(viewC, z10);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + g(i10));
        }
    }

    public void openDrawer(int i10) {
        openDrawer(i10, true);
    }

    public void openDrawer(int i10, boolean z10) {
        View viewC = c(i10);
        if (viewC != null) {
            openDrawer(viewC, z10);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + g(i10));
        }
    }

    public static abstract class h implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void onDrawerStateChanged(int i10) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void onDrawerSlide(View view, float f10) {
        }
    }
}
