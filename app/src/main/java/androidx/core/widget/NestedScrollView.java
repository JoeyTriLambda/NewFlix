package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import x0.j0;
import x0.p;
import x0.q;
import x0.r;
import x0.t;
import x0.u;
import y0.d;
import y0.f;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements t, q {
    public static final float N = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final a O = new a();
    public static final int[] P = {R.attr.fillViewport};
    public int A;
    public int B;
    public int C;
    public final int[] D;
    public final int[] E;
    public int F;
    public int G;
    public e H;
    public final u I;
    public final r J;
    public float K;
    public d L;
    public final x0.d M;

    /* renamed from: b, reason: collision with root package name */
    public final float f2145b;

    /* renamed from: m, reason: collision with root package name */
    public long f2146m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f2147n;

    /* renamed from: o, reason: collision with root package name */
    public OverScroller f2148o;

    /* renamed from: p, reason: collision with root package name */
    public final EdgeEffect f2149p;

    /* renamed from: q, reason: collision with root package name */
    public final EdgeEffect f2150q;

    /* renamed from: r, reason: collision with root package name */
    public int f2151r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2152s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2153t;

    /* renamed from: u, reason: collision with root package name */
    public View f2154u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2155v;

    /* renamed from: w, reason: collision with root package name */
    public VelocityTracker f2156w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2157x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2158y;

    /* renamed from: z, reason: collision with root package name */
    public int f2159z;

    public static class a extends x0.a {
        @Override // x0.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            f.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            f.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.addAction(d.a.f21824i);
                dVar.addAction(d.a.f21828m);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.addAction(d.a.f21823h);
                dVar.addAction(d.a.f21830o);
            }
        }

        @Override // x0.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.i(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                    return true;
                }
                if (i10 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.i(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
            return true;
        }
    }

    public static class b {
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public class c implements x0.e {
        public c() {
        }

        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        public boolean startDifferentialMotionFling(float f10) {
            if (f10 == 0.0f) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f10);
            return true;
        }

        public void stopDifferentialMotionFling() {
            NestedScrollView.this.f2148o.abortAnimation();
        }
    }

    public interface d {
    }

    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f2161b;

        public class a implements Parcelable.Creator<e> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("HorizontalScrollView.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" scrollPosition=");
            return ac.c.m(sb2, this.f2161b, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2161b);
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f2161b = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.R.attr.nestedScrollViewStyle);
    }

    public static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean arrowScroll(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !b(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f2147n;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            g(computeScrollDeltaToGetChildRectOnScreen(rect), 0, 1, true);
            viewFindNextFocus.requestFocus(i10);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && (!b(viewFindFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final boolean b(View view, int i10, int i11) {
        Rect rect = this.f2147n;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i10 >= getScrollY() && rect.top - i10 <= getScrollY() + i11;
    }

    public final void c(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.J.dispatchNestedScroll(0, scrollY2, 0, i10 - scrollY2, null, i11, iArr);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void computeScroll() {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i11) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        }
        if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    public final void d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.C) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f2151r = (int) motionEvent.getY(i10);
            this.C = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f2156w;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.J.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.J.dispatchNestedPreFling(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.J.dispatchNestedPreScroll(i10, i11, iArr, iArr2, i12);
    }

    public void dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        this.J.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f2149p;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft() + 0;
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.f2150q;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = 0 + getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    public final boolean e(int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i14 = i11 + 0;
        int i15 = i12 + i10;
        int i16 = i13 + 0;
        if (i14 <= 0 && i14 >= 0) {
            z10 = false;
        } else {
            z10 = true;
            i14 = 0;
        }
        if (i15 > i16) {
            i15 = i16;
        } else {
            if (i15 >= 0) {
                z11 = false;
                if (z11 && !hasNestedScrollingParent(1)) {
                    this.f2148o.springBack(i14, i15, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i14, i15, z10, z11);
                return z10 || z11;
            }
            i15 = 0;
        }
        z11 = true;
        if (z11) {
            this.f2148o.springBack(i14, i15, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i14, i15, z10, z11);
        if (z10) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean executeKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            android.graphics.Rect r0 = r5.f2147n
            r0.setEmpty()
            int r0 = r5.getChildCount()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L33
            android.view.View r0 = r5.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r0 = r0.getHeight()
            int r4 = r3.topMargin
            int r0 = r0 + r4
            int r3 = r3.bottomMargin
            int r0 = r0 + r3
            int r3 = r5.getHeight()
            int r4 = r5.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r5.getPaddingBottom()
            int r3 = r3 - r4
            if (r0 <= r3) goto L33
            r0 = 1
            goto L34
        L33:
            r0 = 0
        L34:
            r3 = 130(0x82, float:1.82E-43)
            if (r0 != 0) goto L62
            boolean r0 = r5.isFocused()
            if (r0 == 0) goto L61
            int r6 = r6.getKeyCode()
            r0 = 4
            if (r6 == r0) goto L61
            android.view.View r6 = r5.findFocus()
            if (r6 != r5) goto L4c
            r6 = 0
        L4c:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r6 = r0.findNextFocus(r5, r6, r3)
            if (r6 == 0) goto L5f
            if (r6 == r5) goto L5f
            boolean r6 = r6.requestFocus(r3)
            if (r6 == 0) goto L5f
            goto L60
        L5f:
            r1 = 0
        L60:
            return r1
        L61:
            return r2
        L62:
            int r0 = r6.getAction()
            if (r0 != 0) goto Lc8
            int r0 = r6.getKeyCode()
            r1 = 19
            r4 = 33
            if (r0 == r1) goto Lb9
            r1 = 20
            if (r0 == r1) goto La9
            r1 = 62
            if (r0 == r1) goto L9d
            r6 = 92
            if (r0 == r6) goto L98
            r6 = 93
            if (r0 == r6) goto L93
            r6 = 122(0x7a, float:1.71E-43)
            if (r0 == r6) goto L8f
            r6 = 123(0x7b, float:1.72E-43)
            if (r0 == r6) goto L8b
            goto Lc8
        L8b:
            r5.pageScroll(r3)
            goto Lc8
        L8f:
            r5.pageScroll(r4)
            goto Lc8
        L93:
            boolean r2 = r5.fullScroll(r3)
            goto Lc8
        L98:
            boolean r2 = r5.fullScroll(r4)
            goto Lc8
        L9d:
            boolean r6 = r6.isShiftPressed()
            if (r6 == 0) goto La5
            r3 = 33
        La5:
            r5.pageScroll(r3)
            goto Lc8
        La9:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto Lb4
            boolean r2 = r5.fullScroll(r3)
            goto Lc8
        Lb4:
            boolean r2 = r5.arrowScroll(r3)
            goto Lc8
        Lb9:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto Lc4
            boolean r2 = r5.fullScroll(r4)
            goto Lc8
        Lc4:
            boolean r2 = r5.arrowScroll(r4)
        Lc8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.executeKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(int r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            int r4 = r17.getHeight()
            int r5 = r17.getScrollY()
            int r4 = r4 + r5
            r6 = 33
            if (r1 != r6) goto L17
            r6 = 1
            goto L18
        L17:
            r6 = 0
        L18:
            r9 = 2
            java.util.ArrayList r9 = r0.getFocusables(r9)
            int r10 = r9.size()
            r11 = 0
            r12 = 0
            r13 = 0
        L24:
            if (r12 >= r10) goto L6c
            java.lang.Object r14 = r9.get(r12)
            android.view.View r14 = (android.view.View) r14
            int r15 = r14.getTop()
            int r7 = r14.getBottom()
            if (r2 >= r7) goto L69
            if (r15 >= r3) goto L69
            if (r2 >= r15) goto L3f
            if (r7 >= r3) goto L3f
            r16 = 1
            goto L41
        L3f:
            r16 = 0
        L41:
            if (r11 != 0) goto L47
            r11 = r14
            r13 = r16
            goto L69
        L47:
            if (r6 == 0) goto L4f
            int r8 = r11.getTop()
            if (r15 < r8) goto L57
        L4f:
            if (r6 != 0) goto L59
            int r8 = r11.getBottom()
            if (r7 <= r8) goto L59
        L57:
            r7 = 1
            goto L5a
        L59:
            r7 = 0
        L5a:
            if (r13 == 0) goto L61
            if (r16 == 0) goto L69
            if (r7 == 0) goto L69
            goto L68
        L61:
            if (r16 == 0) goto L66
            r11 = r14
            r13 = 1
            goto L69
        L66:
            if (r7 == 0) goto L69
        L68:
            r11 = r14
        L69:
            int r12 = r12 + 1
            goto L24
        L6c:
            if (r11 != 0) goto L6f
            r11 = r0
        L6f:
            if (r2 < r5) goto L75
            if (r3 > r4) goto L75
            r7 = 0
            goto L81
        L75:
            if (r6 == 0) goto L79
            int r2 = r2 - r5
            goto L7b
        L79:
            int r2 = r3 - r4
        L7b:
            r3 = 0
            r4 = 1
            r0.g(r2, r3, r4, r4)
            r7 = 1
        L81:
            android.view.View r2 = r17.findFocus()
            if (r11 == r2) goto L8a
            r11.requestFocus(r1)
        L8a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.f(int, int, int):boolean");
    }

    public void fling(int i10) {
        if (getChildCount() > 0) {
            this.f2148o.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            startNestedScroll(2, 1);
            this.G = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public boolean fullScroll(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f2147n;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            rect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.top = rect.bottom - height;
        }
        return f(i10, rect.top, rect.bottom);
    }

    public final int g(int i10, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        boolean z11;
        VelocityTracker velocityTracker;
        if (i12 == 1) {
            startNestedScroll(2, i12);
        }
        boolean zDispatchNestedPreScroll = dispatchNestedPreScroll(0, i10, this.E, this.D, i12);
        int[] iArr = this.E;
        int[] iArr2 = this.D;
        if (zDispatchNestedPreScroll) {
            i13 = i10 - iArr[1];
            i14 = iArr2[1] + 0;
        } else {
            i13 = i10;
            i14 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z12 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z10;
        boolean z13 = e(i13, 0, scrollY, scrollRange) && !hasNestedScrollingParent(i12);
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, i13 - scrollY2, this.D, i12, iArr);
        int i15 = i14 + iArr2[1];
        int i16 = i13 - iArr[1];
        int i17 = scrollY + i16;
        EdgeEffect edgeEffect = this.f2150q;
        EdgeEffect edgeEffect2 = this.f2149p;
        if (i17 < 0) {
            if (z12) {
                d1.d.onPullDistance(edgeEffect2, (-i16) / getHeight(), i11 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i17 > scrollRange && z12) {
            d1.d.onPullDistance(edgeEffect, i16 / getHeight(), 1.0f - (i11 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (edgeEffect2.isFinished() && edgeEffect.isFinished()) {
            z11 = z13;
        } else {
            postInvalidateOnAnimation();
            z11 = false;
        }
        if (z11 && i12 == 0 && (velocityTracker = this.f2156w) != null) {
            velocityTracker.clear();
        }
        if (i12 == 1) {
            stopNestedScroll(i12);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i15;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.I.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.K == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.K = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.K;
    }

    public final boolean h(EdgeEffect edgeEffect, int i10) {
        if (i10 > 0) {
            return true;
        }
        float distance = d1.d.getDistance(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i10) * 0.35f;
        float f10 = this.f2145b * 0.015f;
        double dLog = Math.log(fAbs / f10);
        double d10 = N;
        return ((float) (Math.exp((d10 / (d10 - 1.0d)) * dLog) * ((double) f10))) < distance;
    }

    public boolean hasNestedScrollingParent(int i10) {
        return this.J.hasNestedScrollingParent(i10);
    }

    public final void i(int i10, int i11, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2146m > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f2148o.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z10) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.G = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f2148o.isFinished()) {
                this.f2148o.abortAnimation();
                stopNestedScroll(1);
            }
            scrollBy(i10, i11);
        }
        this.f2146m = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.J.isNestedScrollingEnabled();
    }

    public final boolean j(MotionEvent motionEvent) {
        boolean z10;
        EdgeEffect edgeEffect = this.f2149p;
        if (d1.d.getDistance(edgeEffect) != 0.0f) {
            d1.d.onPullDistance(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z10 = true;
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.f2150q;
        if (d1.d.getDistance(edgeEffect2) == 0.0f) {
            return z10;
        }
        d1.d.onPullDistance(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2153t = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i10;
        float axisValue;
        int width;
        if (motionEvent.getAction() == 8 && !this.f2155v) {
            if (p.isFromSource(motionEvent, 2)) {
                i10 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (p.isFromSource(motionEvent, 4194304)) {
                axisValue = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i10 = 26;
            } else {
                i10 = 0;
                axisValue = 0.0f;
                width = 0;
            }
            if (axisValue != 0.0f) {
                g(-((int) (getVerticalScrollFactorCompat() * axisValue)), width, 1, p.isFromSource(motionEvent, 8194));
                if (i10 != 0) {
                    this.M.onMotionEvent(motionEvent, i10);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e3  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredHeight;
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = 0;
        this.f2152s = false;
        View view = this.f2154u;
        if (view != null && a(view, this)) {
            View view2 = this.f2154u;
            Rect rect = this.f2147n;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        this.f2154u = null;
        if (!this.f2153t) {
            if (this.H != null) {
                scrollTo(getScrollX(), this.H.f2161b);
                this.H = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i14 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i14 != scrollY) {
                scrollTo(getScrollX(), i14);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2153t = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2157x && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        fling((int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // x0.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        dispatchNestedPreScroll(i10, i11, iArr, null, i12);
    }

    @Override // x0.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        c(i13, i14, iArr);
    }

    @Override // x0.s
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        this.I.onNestedScrollAccepted(view, view2, i10, i11);
        startNestedScroll(2, i11);
    }

    @Override // android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i10) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        if (viewFindNextFocus == null || (true ^ b(viewFindNextFocus, 0, getHeight()))) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.H = eVar;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f2161b = getScrollY();
        return eVar;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        d dVar = this.L;
        if (dVar != null) {
            ((r.d) dVar).onScrollChange(this, i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !b(viewFindFocus, 0, i13)) {
            return;
        }
        Rect rect = this.f2147n;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
            if (this.f2158y) {
                smoothScrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            } else {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
    }

    @Override // x0.s
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // x0.s
    public void onStopNestedScroll(View view, int i10) {
        this.I.onStopNestedScroll(view, i10);
        stopNestedScroll(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r20) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean pageScroll(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f2147n;
        if (z10) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            rect.top = getScrollY() - height;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        int i11 = rect.top;
        int i12 = height + i11;
        rect.bottom = i12;
        return f(i10, i11, i12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f2152s) {
            this.f2154u = view2;
        } else {
            Rect rect = this.f2147n;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z11 = iComputeScrollDeltaToGetChildRectOnScreen != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        VelocityTracker velocityTracker;
        if (z10 && (velocityTracker = this.f2156w) != null) {
            velocityTracker.recycle();
            this.f2156w = null;
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2152s = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i10 < 0) {
                i10 = 0;
            } else if (width + i10 > width2) {
                i10 = width2 - width;
            }
            if (height >= height2 || i11 < 0) {
                i11 = 0;
            } else if (height + i11 > height2) {
                i11 = height2 - height;
            }
            if (i10 == getScrollX() && i11 == getScrollY()) {
                return;
            }
            super.scrollTo(i10, i11);
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f2157x) {
            this.f2157x = z10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.J.setNestedScrollingEnabled(z10);
    }

    public void setOnScrollChangeListener(d dVar) {
        this.L = dVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f2158y = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i10, int i11) {
        i(i10, i11, false);
    }

    public boolean startNestedScroll(int i10, int i11) {
        return this.J.startNestedScroll(i10, i11);
    }

    public void stopNestedScroll(int i10) {
        this.J.stopNestedScroll(i10);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2147n = new Rect();
        this.f2152s = true;
        this.f2153t = false;
        this.f2154u = null;
        this.f2155v = false;
        this.f2158y = true;
        this.C = -1;
        this.D = new int[2];
        this.E = new int[2];
        this.M = new x0.d(getContext(), new c());
        this.f2149p = d1.d.create(context, attributeSet);
        this.f2150q = d1.d.create(context, attributeSet);
        this.f2145b = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f2148o = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2159z = viewConfiguration.getScaledTouchSlop();
        this.A = viewConfiguration.getScaledMinimumFlingVelocity();
        this.B = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P, i10, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.I = new u(this);
        this.J = new r(this);
        setNestedScrollingEnabled(true);
        j0.setAccessibilityDelegate(this, O);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.J.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // x0.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        c(i13, i14, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return startNestedScroll(i10, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        c(i13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
