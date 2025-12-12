package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;
import x0.j0;
import x0.s;
import x0.t;
import x0.u;
import x0.v;
import x0.y0;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements s, t {
    public static final String F;
    public static final Class<?>[] G;
    public static final ThreadLocal<Map<String, Constructor<c>>> H;
    public static final i I;
    public static final w0.g J;
    public boolean A;
    public Drawable B;
    public ViewGroup.OnHierarchyChangeListener C;
    public a D;
    public final u E;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2082b;

    /* renamed from: m, reason: collision with root package name */
    public final k0.a<View> f2083m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f2084n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f2085o;

    /* renamed from: p, reason: collision with root package name */
    public Paint f2086p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f2087q;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f2088r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2089s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2090t;

    /* renamed from: u, reason: collision with root package name */
    public final int[] f2091u;

    /* renamed from: v, reason: collision with root package name */
    public View f2092v;

    /* renamed from: w, reason: collision with root package name */
    public View f2093w;

    /* renamed from: x, reason: collision with root package name */
    public g f2094x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2095y;

    /* renamed from: z, reason: collision with root package name */
    public y0 f2096z;

    public class a implements v {
        public a() {
        }

        @Override // x0.v
        public y0 onApplyWindowInsets(View view, y0 y0Var) {
            c behavior;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!w0.c.equals(coordinatorLayout.f2096z, y0Var)) {
                coordinatorLayout.f2096z = y0Var;
                boolean z10 = y0Var != null && y0Var.getSystemWindowInsetTop() > 0;
                coordinatorLayout.A = z10;
                coordinatorLayout.setWillNotDraw(!z10 && coordinatorLayout.getBackground() == null);
                if (!y0Var.isConsumed()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = coordinatorLayout.getChildAt(i10);
                        if (j0.getFitsSystemWindows(childAt) && (behavior = ((f) childAt.getLayoutParams()).getBehavior()) != null) {
                            y0Var = behavior.onApplyWindowInsets(coordinatorLayout, childAt, y0Var);
                            if (y0Var.isConsumed()) {
                                break;
                            }
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return y0Var;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v10) {
            return getScrimOpacity(coordinatorLayout, v10) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v10, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v10) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v10) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v10, Rect rect, boolean z10) {
            return false;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                onNestedPreScroll(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                return onStartNestedScroll(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
            if (i10 == 0) {
                onStopNestedScroll(coordinatorLayout, v10, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }

        public void onDetachedFromLayoutParams() {
        }

        public void onAttachedToLayoutParams(f fVar) {
        }

        public y0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v10, y0 y0Var) {
            return y0Var;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.C;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.g(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.C;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.g(0);
            return true;
        }
    }

    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            float z10 = j0.getZ(view);
            float z11 = j0.getZ(view2);
            if (z10 > z11) {
                return -1;
            }
            return z10 < z11 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        F = r02 != null ? r02.getName() : null;
        I = new i();
        G = new Class[]{Context.class, AttributeSet.class};
        H = new ThreadLocal<>();
        J = new w0.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect a() {
        Rect rect = (Rect) J.acquire();
        return rect == null ? new Rect() : rect;
    }

    public static void d(int i10, Rect rect, Rect rect2, f fVar, int i11, int i12) {
        int i13 = fVar.f2101c;
        if (i13 == 0) {
            i13 = 17;
        }
        int absoluteGravity = x0.h.getAbsoluteGravity(i13, i10);
        int i14 = fVar.f2102d;
        if ((i14 & 7) == 0) {
            i14 |= 8388611;
        }
        if ((i14 & 112) == 0) {
            i14 |= 48;
        }
        int absoluteGravity2 = x0.h.getAbsoluteGravity(i14, i10);
        int i15 = absoluteGravity & 7;
        int i16 = absoluteGravity & 112;
        int i17 = absoluteGravity2 & 7;
        int i18 = absoluteGravity2 & 112;
        int iWidth = i17 != 1 ? i17 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i18 != 16 ? i18 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i15 == 1) {
            iWidth -= i11 / 2;
        } else if (i15 != 5) {
            iWidth -= i11;
        }
        if (i16 == 16) {
            iHeight -= i12 / 2;
        } else if (i16 != 80) {
            iHeight -= i12;
        }
        rect2.set(iWidth, iHeight, i11 + iWidth, i12 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f f(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f2100b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.setBehavior(behavior);
                fVar.f2100b = true;
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.setBehavior(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e10) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
                fVar.f2100b = true;
            }
        }
        return fVar;
    }

    public static void k(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f2107i;
        if (i11 != i10) {
            j0.offsetLeftAndRight(view, i10 - i11);
            fVar.f2107i = i10;
        }
    }

    public static void l(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f2108j;
        if (i11 != i10) {
            j0.offsetTopAndBottom(view, i10 - i11);
            fVar.f2108j = i10;
        }
    }

    public final void b(f fVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i10 + iMax, i11 + iMax2);
    }

    public final void c(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            k0.b.getDescendantRect(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void dispatchDependentViewsChanged(View view) {
        List incomingEdges = this.f2083m.getIncomingEdges(view);
        if (incomingEdges == null || incomingEdges.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < incomingEdges.size(); i10++) {
            View view2 = (View) incomingEdges.get(i10);
            c behavior = ((f) view2.getLayoutParams()).getBehavior();
            if (behavior != null) {
                behavior.onDependentViewChanged(this, view2, view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f2099a;
        if (cVar != null) {
            float scrimOpacity = cVar.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.f2086p == null) {
                    this.f2086p = new Paint();
                }
                this.f2086p.setColor(fVar.f2099a.getScrimColor(this, view));
                Paint paint = this.f2086p;
                int iRound = Math.round(scrimOpacity * 255.0f);
                if (iRound < 0) {
                    iRound = 0;
                } else if (iRound > 255) {
                    iRound = 255;
                }
                paint.setAlpha(iRound);
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f2086p);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.B;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final int e(int i10) {
        int[] iArr = this.f2091u;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i10 + " out of range for " + this);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r26) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.g(int):void");
    }

    public List<View> getDependencies(View view) {
        List<View> outgoingEdges = this.f2083m.getOutgoingEdges(view);
        ArrayList arrayList = this.f2085o;
        arrayList.clear();
        if (outgoingEdges != null) {
            arrayList.addAll(outgoingEdges);
        }
        return arrayList;
    }

    public final List<View> getDependencySortedChildren() {
        i();
        return Collections.unmodifiableList(this.f2082b);
    }

    public List<View> getDependents(View view) {
        List incomingEdges = this.f2083m.getIncomingEdges(view);
        ArrayList arrayList = this.f2085o;
        arrayList.clear();
        if (incomingEdges != null) {
            arrayList.addAll(incomingEdges);
        }
        return arrayList;
    }

    public final y0 getLastWindowInsets() {
        return this.f2096z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.E.getNestedScrollAxes();
    }

    public Drawable getStatusBarBackground() {
        return this.B;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final boolean h(MotionEvent motionEvent, int i10) {
        boolean zBlocksInteractionBelow;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f2084n;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i11) : i11));
        }
        i iVar = I;
        if (iVar != null) {
            Collections.sort(arrayList, iVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zOnInterceptTouchEvent = false;
        boolean z10 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) arrayList.get(i12);
            f fVar = (f) view.getLayoutParams();
            c behavior = fVar.getBehavior();
            if (!(zOnInterceptTouchEvent || z10) || actionMasked == 0) {
                if (!zOnInterceptTouchEvent && behavior != null) {
                    if (i10 == 0) {
                        zOnInterceptTouchEvent = behavior.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i10 == 1) {
                        zOnInterceptTouchEvent = behavior.onTouchEvent(this, view, motionEvent);
                    }
                    if (zOnInterceptTouchEvent) {
                        this.f2092v = view;
                    }
                }
                c cVar = fVar.f2099a;
                if (cVar == null) {
                    fVar.f2111m = false;
                }
                boolean z11 = fVar.f2111m;
                if (z11) {
                    zBlocksInteractionBelow = true;
                } else {
                    zBlocksInteractionBelow = (cVar != null ? cVar.blocksInteractionBelow(this, view) : false) | z11;
                    fVar.f2111m = zBlocksInteractionBelow;
                }
                boolean z12 = zBlocksInteractionBelow && !z11;
                if (zBlocksInteractionBelow && !z12) {
                    break;
                }
                z10 = z12;
            } else if (behavior != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i10 == 0) {
                    behavior.onInterceptTouchEvent(this, view, motionEventObtain);
                } else if (i10 == 1) {
                    behavior.onTouchEvent(this, view, motionEventObtain);
                }
            }
        }
        arrayList.clear();
        return zOnInterceptTouchEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.i():void");
    }

    public boolean isPointInChildBounds(View view, int i10, int i11) {
        w0.g gVar = J;
        Rect rectA = a();
        k0.b.getDescendantRect(this, view, rectA);
        try {
            return rectA.contains(i10, i11);
        } finally {
            rectA.setEmpty();
            gVar.release(rectA);
        }
    }

    public final void j(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c behavior = ((f) childAt.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    behavior.onInterceptTouchEvent(this, childAt, motionEventObtain);
                } else {
                    behavior.onTouchEvent(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f) getChildAt(i11).getLayoutParams()).f2111m = false;
        }
        this.f2092v = null;
        this.f2089s = false;
    }

    public final void m() {
        if (!j0.getFitsSystemWindows(this)) {
            j0.setOnApplyWindowInsetsListener(this, null);
            return;
        }
        if (this.D == null) {
            this.D = new a();
        }
        j0.setOnApplyWindowInsetsListener(this, this.D);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j(false);
        if (this.f2095y) {
            if (this.f2094x == null) {
                this.f2094x = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2094x);
        }
        if (this.f2096z == null && j0.getFitsSystemWindows(this)) {
            j0.requestApplyInsets(this);
        }
        this.f2090t = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j(false);
        if (this.f2095y && this.f2094x != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2094x);
        }
        View view = this.f2093w;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2090t = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.A || this.B == null) {
            return;
        }
        y0 y0Var = this.f2096z;
        int systemWindowInsetTop = y0Var != null ? y0Var.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.B.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            j(true);
        }
        boolean zH = h(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            j(true);
        }
        return zH;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c behavior;
        int layoutDirection = j0.getLayoutDirection(this);
        ArrayList arrayList = this.f2082b;
        int size = arrayList.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = (View) arrayList.get(i14);
            if (view.getVisibility() != 8 && ((behavior = ((f) view.getLayoutParams()).getBehavior()) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public void onLayoutChild(View view, int i10) {
        Rect rectA;
        Rect rectA2;
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.f2109k;
        int i11 = 0;
        if (view2 == null && fVar.f2104f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        w0.g gVar = J;
        if (view2 != null) {
            rectA = a();
            rectA2 = a();
            try {
                k0.b.getDescendantRect(this, view2, rectA);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                d(i10, rectA, rectA2, fVar2, measuredWidth, measuredHeight);
                b(fVar2, rectA2, measuredWidth, measuredHeight);
                view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
                return;
            } finally {
                rectA.setEmpty();
                gVar.release(rectA);
                rectA2.setEmpty();
                gVar.release(rectA2);
            }
        }
        int i12 = fVar.f2103e;
        if (i12 < 0) {
            f fVar3 = (f) view.getLayoutParams();
            rectA = a();
            rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
            if (this.f2096z != null && j0.getFitsSystemWindows(this) && !j0.getFitsSystemWindows(view)) {
                rectA.left = this.f2096z.getSystemWindowInsetLeft() + rectA.left;
                rectA.top = this.f2096z.getSystemWindowInsetTop() + rectA.top;
                rectA.right -= this.f2096z.getSystemWindowInsetRight();
                rectA.bottom -= this.f2096z.getSystemWindowInsetBottom();
            }
            rectA2 = a();
            int i13 = fVar3.f2101c;
            if ((i13 & 7) == 0) {
                i13 |= 8388611;
            }
            if ((i13 & 112) == 0) {
                i13 |= 48;
            }
            x0.h.apply(i13, view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i10);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
            return;
        }
        f fVar4 = (f) view.getLayoutParams();
        int i14 = fVar4.f2101c;
        if (i14 == 0) {
            i14 = 8388661;
        }
        int absoluteGravity = x0.h.getAbsoluteGravity(i14, i10);
        int i15 = absoluteGravity & 7;
        int i16 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i10 == 1) {
            i12 = width - i12;
        }
        int iE = e(i12) - measuredWidth2;
        if (i15 == 1) {
            iE += measuredWidth2 / 2;
        } else if (i15 == 5) {
            iE += measuredWidth2;
        }
        if (i16 == 16) {
            i11 = 0 + (measuredHeight2 / 2);
        } else if (i16 == 80) {
            i11 = measuredHeight2 + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, Math.min(iE, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, Math.min(i11, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0173  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r33, int r34) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        c behavior;
        int childCount = getChildCount();
        boolean zOnNestedFling = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (behavior = fVar.getBehavior()) != null) {
                    zOnNestedFling |= behavior.onNestedFling(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (zOnNestedFling) {
            g(1);
        }
        return zOnNestedFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        c behavior;
        int childCount = getChildCount();
        boolean zOnNestedPreFling = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (behavior = fVar.getBehavior()) != null) {
                    zOnNestedPreFling |= behavior.onNestedPreFling(this, childAt, view, f10, f11);
                }
            }
        }
        return zOnNestedPreFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        SparseArray<Parcelable> sparseArray = hVar.f2117n;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c behavior = f(childAt).getBehavior();
            if (id2 != -1 && behavior != null && (parcelable2 = sparseArray.get(id2)) != null) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c behavior = ((f) childAt.getLayoutParams()).getBehavior();
            if (id2 != -1 && behavior != null && (parcelableOnSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id2, parcelableOnSaveInstanceState);
            }
        }
        hVar.f2117n = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[PHI: r3
  0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2092v
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.h(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.f2092v
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.getBehavior()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.f2092v
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.f2092v
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.j(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        c behavior = ((f) view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f2089s) {
            return;
        }
        j(false);
        this.f2089s = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        m();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.C = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.B;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.B = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.B.setState(getDrawableState());
                }
                p0.a.setLayoutDirection(this.B, j0.getLayoutDirection(this));
                this.B.setVisible(getVisibility() == 0, false);
                this.B.setCallback(this);
            }
            j0.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarBackground(i10 != 0 ? m0.a.getDrawable(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.B;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.B.setVisible(z10, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.B;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f2082b = new ArrayList();
        this.f2083m = new k0.a<>();
        this.f2084n = new ArrayList();
        this.f2085o = new ArrayList();
        this.f2087q = new int[2];
        this.f2088r = new int[2];
        this.E = new u(this);
        TypedArray typedArrayObtainStyledAttributes = i10 == 0 ? context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i10, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i10 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f2091u = intArray;
            float f10 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f2091u[i11] = (int) (r12[i11] * f10);
            }
        }
        this.B = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        m();
        super.setOnHierarchyChangeListener(new e());
        if (j0.getImportantForAccessibility(this) == 0) {
            j0.setImportantForAccessibility(this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // x0.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        c behavior;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i12) && (behavior = fVar.getBehavior()) != null) {
                    int[] iArr2 = this.f2087q;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f2087q;
                    iMax = i10 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i11 > 0 ? Math.max(iMax2, iArr3[1]) : Math.min(iMax2, iArr3[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z10) {
            g(1);
        }
    }

    @Override // x0.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f2088r);
    }

    @Override // x0.s
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        c behavior;
        this.E.onNestedScrollAccepted(view, view2, i10, i11);
        this.f2093w = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i11) && (behavior = fVar.getBehavior()) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i10, i11);
            }
        }
    }

    @Override // x0.s
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c behavior = fVar.getBehavior();
                if (behavior != null) {
                    boolean zOnStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i10, i11);
                    z10 |= zOnStartNestedScroll;
                    if (i11 == 0) {
                        fVar.f2112n = zOnStartNestedScroll;
                    } else if (i11 == 1) {
                        fVar.f2113o = zOnStartNestedScroll;
                    }
                } else if (i11 == 0) {
                    fVar.f2112n = false;
                } else if (i11 == 1) {
                    fVar.f2113o = false;
                }
            }
        }
        return z10;
    }

    @Override // x0.s
    public void onStopNestedScroll(View view, int i10) {
        this.E.onStopNestedScroll(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i10)) {
                c behavior = fVar.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i10);
                }
                if (i10 == 0) {
                    fVar.f2112n = false;
                } else if (i10 == 1) {
                    fVar.f2113o = false;
                }
                fVar.f2114p = false;
            }
        }
        this.f2093w = null;
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // x0.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        c behavior;
        int iMin;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i14) && (behavior = fVar.getBehavior()) != null) {
                    int[] iArr2 = this.f2087q;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f2087q;
                    iMax = i12 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i13 > 0) {
                        iMin = Math.max(i15, iArr3[1]);
                    } else {
                        iMin = Math.min(i15, iArr3[1]);
                    }
                    i15 = iMin;
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i15;
        if (z10) {
            g(1);
        }
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    public static class h extends f1.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public SparseArray<Parcelable> f2117n;

        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public h[] newArray(int i10) {
                return new h[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i10 = parcel.readInt();
            int[] iArr = new int[i10];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f2117n = new SparseArray<>(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f2117n.append(iArr[i11], parcelableArray[i11]);
            }
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.f2117n;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = this.f2117n.keyAt(i11);
                parcelableArr[i11] = this.f2117n.valueAt(i11);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c f2099a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2100b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2101c;

        /* renamed from: d, reason: collision with root package name */
        public int f2102d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2103e;

        /* renamed from: f, reason: collision with root package name */
        public final int f2104f;

        /* renamed from: g, reason: collision with root package name */
        public int f2105g;

        /* renamed from: h, reason: collision with root package name */
        public int f2106h;

        /* renamed from: i, reason: collision with root package name */
        public int f2107i;

        /* renamed from: j, reason: collision with root package name */
        public int f2108j;

        /* renamed from: k, reason: collision with root package name */
        public View f2109k;

        /* renamed from: l, reason: collision with root package name */
        public View f2110l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f2111m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f2112n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f2113o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f2114p;

        /* renamed from: q, reason: collision with root package name */
        public final Rect f2115q;

        public f(int i10, int i11) {
            super(i10, i11);
            this.f2100b = false;
            this.f2101c = 0;
            this.f2102d = 0;
            this.f2103e = -1;
            this.f2104f = -1;
            this.f2105g = 0;
            this.f2106h = 0;
            this.f2115q = new Rect();
        }

        public final boolean a(int i10) {
            if (i10 == 0) {
                return this.f2112n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f2113o;
        }

        public int getAnchorId() {
            return this.f2104f;
        }

        public c getBehavior() {
            return this.f2099a;
        }

        public void setBehavior(c cVar) {
            c cVar2 = this.f2099a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.onDetachedFromLayoutParams();
                }
                this.f2099a = cVar;
                this.f2100b = true;
                if (cVar != null) {
                    cVar.onAttachedToLayoutParams(this);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            c cVarNewInstance;
            super(context, attributeSet);
            this.f2100b = false;
            this.f2101c = 0;
            this.f2102d = 0;
            this.f2103e = -1;
            this.f2104f = -1;
            this.f2105g = 0;
            this.f2106h = 0;
            this.f2115q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2101c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2104f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2102d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2103e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2105g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2106h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
            this.f2100b = zHasValue;
            if (zHasValue) {
                String string = typedArrayObtainStyledAttributes.getString(i10);
                String str = CoordinatorLayout.F;
                if (TextUtils.isEmpty(string)) {
                    cVarNewInstance = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.F;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + ClassUtils.PACKAGE_SEPARATOR_CHAR + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.H;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.G);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVarNewInstance = constructor.newInstance(context, attributeSet);
                    } catch (Exception e10) {
                        throw new RuntimeException(ac.c.j("Could not inflate Behavior subclass ", string), e10);
                    }
                }
                this.f2099a = cVarNewInstance;
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f2099a;
            if (cVar != null) {
                cVar.onAttachedToLayoutParams(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f2100b = false;
            this.f2101c = 0;
            this.f2102d = 0;
            this.f2103e = -1;
            this.f2104f = -1;
            this.f2105g = 0;
            this.f2106h = 0;
            this.f2115q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2100b = false;
            this.f2101c = 0;
            this.f2102d = 0;
            this.f2103e = -1;
            this.f2104f = -1;
            this.f2105g = 0;
            this.f2106h = 0;
            this.f2115q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2100b = false;
            this.f2101c = 0;
            this.f2102d = 0;
            this.f2103e = -1;
            this.f2104f = -1;
            this.f2105g = 0;
            this.f2106h = 0;
            this.f2115q = new Rect();
        }
    }
}
