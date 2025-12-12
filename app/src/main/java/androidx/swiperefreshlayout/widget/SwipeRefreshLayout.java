package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import x0.j0;
import x0.q;
import x0.r;
import x0.s;
import x0.t;
import x0.u;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements t, s, q {
    public static final int[] V = {R.attr.enabled};
    public float A;
    public boolean B;
    public int C;
    public final DecelerateInterpolator D;
    public o2.a E;
    public int F;
    public int G;
    public final int H;
    public final int I;
    public int J;
    public o2.d K;
    public o2.e L;
    public o2.f M;
    public o2.g N;
    public o2.g O;
    public boolean P;
    public int Q;
    public boolean R;
    public final a S;
    public final c T;
    public final d U;

    /* renamed from: b, reason: collision with root package name */
    public View f4355b;

    /* renamed from: m, reason: collision with root package name */
    public f f4356m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4357n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4358o;

    /* renamed from: p, reason: collision with root package name */
    public float f4359p;

    /* renamed from: q, reason: collision with root package name */
    public float f4360q;

    /* renamed from: r, reason: collision with root package name */
    public final u f4361r;

    /* renamed from: s, reason: collision with root package name */
    public final r f4362s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f4363t;

    /* renamed from: u, reason: collision with root package name */
    public final int[] f4364u;

    /* renamed from: v, reason: collision with root package name */
    public final int[] f4365v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4366w;

    /* renamed from: x, reason: collision with root package name */
    public final int f4367x;

    /* renamed from: y, reason: collision with root package name */
    public int f4368y;

    /* renamed from: z, reason: collision with root package name */
    public float f4369z;

    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            swipeRefreshLayout.getClass();
            int iAbs = swipeRefreshLayout.I - Math.abs(swipeRefreshLayout.H);
            swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.G + ((int) ((iAbs - r1) * f10))) - swipeRefreshLayout.E.getTop());
            swipeRefreshLayout.K.setArrowScale(1.0f - f10);
        }
    }

    public class d extends Animation {
        public d() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.d(f10);
        }
    }

    public interface e {
    }

    public interface f {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4357n = false;
        this.f4359p = -1.0f;
        this.f4363t = new int[2];
        this.f4364u = new int[2];
        this.f4365v = new int[2];
        this.C = -1;
        this.F = -1;
        this.S = new a();
        this.T = new c();
        this.U = new d();
        this.f4358o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4367x = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.Q = (int) (displayMetrics.density * 40.0f);
        this.E = new o2.a(getContext());
        o2.d dVar = new o2.d(getContext());
        this.K = dVar;
        dVar.setStyle(1);
        this.E.setImageDrawable(this.K);
        this.E.setVisibility(8);
        addView(this.E);
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.I = i10;
        this.f4359p = i10;
        this.f4361r = new u(this);
        this.f4362s = new r(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.Q;
        this.f4368y = i11;
        this.H = i11;
        d(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i10) {
        this.E.getBackground().setAlpha(i10);
        this.K.setAlpha(i10);
    }

    public final void a() {
        if (this.f4355b == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.E)) {
                    this.f4355b = childAt;
                    return;
                }
            }
        }
    }

    public final void b(float f10) {
        if (f10 > this.f4359p) {
            f(true, true);
            return;
        }
        this.f4357n = false;
        this.K.setStartEndTrim(0.0f, 0.0f);
        b bVar = new b();
        this.G = this.f4368y;
        d dVar = this.U;
        dVar.reset();
        dVar.setDuration(200L);
        dVar.setInterpolator(this.D);
        this.E.setAnimationListener(bVar);
        this.E.clearAnimation();
        this.E.startAnimation(dVar);
        this.K.setArrowEnabled(false);
    }

    public final void c(float f10) {
        this.K.setArrowEnabled(true);
        float fMin = Math.min(1.0f, Math.abs(f10 / this.f4359p));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f10) - this.f4359p;
        int i10 = this.J;
        if (i10 <= 0) {
            i10 = this.I;
        }
        float f11 = i10;
        double dMax = Math.max(0.0f, Math.min(fAbs, f11 * 2.0f) / f11) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i11 = this.H + ((int) ((f11 * fMin) + (f11 * fPow * 2.0f)));
        if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
        this.E.setScaleX(1.0f);
        this.E.setScaleY(1.0f);
        if (f10 < this.f4359p) {
            if (this.K.getAlpha() > 76) {
                o2.g gVar = this.N;
                if (!((gVar == null || !gVar.hasStarted() || gVar.hasEnded()) ? false : true)) {
                    o2.g gVar2 = new o2.g(this, this.K.getAlpha(), 76);
                    gVar2.setDuration(300L);
                    this.E.setAnimationListener(null);
                    this.E.clearAnimation();
                    this.E.startAnimation(gVar2);
                    this.N = gVar2;
                }
            }
        } else if (this.K.getAlpha() < 255) {
            o2.g gVar3 = this.O;
            if (!((gVar3 == null || !gVar3.hasStarted() || gVar3.hasEnded()) ? false : true)) {
                o2.g gVar4 = new o2.g(this, this.K.getAlpha(), 255);
                gVar4.setDuration(300L);
                this.E.setAnimationListener(null);
                this.E.clearAnimation();
                this.E.startAnimation(gVar4);
                this.O = gVar4;
            }
        }
        this.K.setStartEndTrim(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.K.setArrowScale(Math.min(1.0f, fMax));
        this.K.setProgressRotation(((fPow * 2.0f) + ((fMax * 0.4f) - 0.25f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f4368y);
    }

    public boolean canChildScrollUp() {
        View view = this.f4355b;
        return view instanceof ListView ? d1.g.canScrollList((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public final void d(float f10) {
        setTargetOffsetTopAndBottom((this.G + ((int) ((this.H - r0) * f10))) - this.E.getTop());
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f4362s.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f4362s.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f4362s.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    public void dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        if (i14 == 0) {
            this.f4362s.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14, iArr2);
        }
    }

    public final void e() {
        this.E.clearAnimation();
        this.K.stop();
        this.E.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.H - this.f4368y);
        this.f4368y = this.E.getTop();
    }

    public final void f(boolean z10, boolean z11) {
        if (this.f4357n != z10) {
            this.P = z11;
            a();
            this.f4357n = z10;
            a aVar = this.S;
            if (!z10) {
                h(aVar);
                return;
            }
            this.G = this.f4368y;
            c cVar = this.T;
            cVar.reset();
            cVar.setDuration(200L);
            cVar.setInterpolator(this.D);
            if (aVar != null) {
                this.E.setAnimationListener(aVar);
            }
            this.E.clearAnimation();
            this.E.startAnimation(cVar);
        }
    }

    public final void g(float f10) {
        float f11 = this.A;
        float f12 = f10 - f11;
        int i10 = this.f4358o;
        if (f12 <= i10 || this.B) {
            return;
        }
        this.f4369z = f11 + i10;
        this.B = true;
        this.K.setAlpha(76);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.F;
        return i12 < 0 ? i11 : i11 == i10 + (-1) ? i12 : i11 >= i12 ? i11 + 1 : i11;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4361r.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.Q;
    }

    public int getProgressViewEndOffset() {
        return this.I;
    }

    public int getProgressViewStartOffset() {
        return this.H;
    }

    public final void h(a aVar) {
        o2.f fVar = new o2.f(this);
        this.M = fVar;
        fVar.setDuration(150L);
        this.E.setAnimationListener(aVar);
        this.E.clearAnimation();
        this.E.startAnimation(this.M);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f4362s.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f4362s.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r5.a()
            int r0 = r6.getActionMasked()
            boolean r1 = r5.isEnabled()
            r2 = 0
            if (r1 == 0) goto L87
            boolean r1 = r5.canChildScrollUp()
            if (r1 != 0) goto L87
            boolean r1 = r5.f4357n
            if (r1 != 0) goto L87
            boolean r1 = r5.f4366w
            if (r1 == 0) goto L1d
            goto L87
        L1d:
            if (r0 == 0) goto L63
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L5e
            r4 = 2
            if (r0 == r4) goto L43
            r4 = 3
            if (r0 == r4) goto L5e
            r3 = 6
            if (r0 == r3) goto L2d
            goto L84
        L2d:
            int r0 = r6.getActionIndex()
            int r3 = r6.getPointerId(r0)
            int r4 = r5.C
            if (r3 != r4) goto L84
            if (r0 != 0) goto L3c
            r2 = 1
        L3c:
            int r6 = r6.getPointerId(r2)
            r5.C = r6
            goto L84
        L43:
            int r0 = r5.C
            if (r0 != r3) goto L4f
            java.lang.String r6 = "SwipeRefreshLayout"
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r6, r0)
            return r2
        L4f:
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L56
            return r2
        L56:
            float r6 = r6.getY(r0)
            r5.g(r6)
            goto L84
        L5e:
            r5.B = r2
            r5.C = r3
            goto L84
        L63:
            o2.a r0 = r5.E
            int r0 = r0.getTop()
            int r1 = r5.H
            int r1 = r1 - r0
            r5.setTargetOffsetTopAndBottom(r1)
            int r0 = r6.getPointerId(r2)
            r5.C = r0
            r5.B = r2
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L7e
            return r2
        L7e:
            float r6 = r6.getY(r0)
            r5.A = r6
        L84:
            boolean r6 = r5.B
            return r6
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f4355b == null) {
            a();
        }
        View view = this.f4355b;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.E.getMeasuredWidth();
        int measuredHeight2 = this.E.getMeasuredHeight();
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f4368y;
        this.E.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f4355b == null) {
            a();
        }
        View view = this.f4355b;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.E.measure(View.MeasureSpec.makeMeasureSpec(this.Q, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Q, 1073741824));
        this.F = -1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == this.E) {
                this.F = i12;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // x0.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // x0.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i14 != 0) {
            return;
        }
        int i15 = iArr[1];
        dispatchNestedScroll(i10, i11, i12, i13, this.f4364u, i14, iArr);
        int i16 = i13 - (iArr[1] - i15);
        if ((i16 == 0 ? i13 + this.f4364u[1] : i16) >= 0 || canChildScrollUp()) {
            return;
        }
        float fAbs = this.f4360q + Math.abs(r1);
        this.f4360q = fAbs;
        c(fAbs);
        iArr[1] = iArr[1] + i16;
    }

    @Override // x0.s
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        setRefreshing(gVar.f4374b);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new g(super.onSaveInstanceState(), this.f4357n);
    }

    @Override // x0.s
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            return onStartNestedScroll(view, view2, i10);
        }
        return false;
    }

    @Override // x0.s
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || canChildScrollUp() || this.f4357n || this.f4366w) {
            return false;
        }
        if (actionMasked == 0) {
            this.C = motionEvent.getPointerId(0);
            this.B = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.C);
                if (iFindPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.B) {
                    float y10 = (motionEvent.getY(iFindPointerIndex) - this.f4369z) * 0.5f;
                    this.B = false;
                    b(y10);
                }
                this.C = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.C);
                if (iFindPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y11 = motionEvent.getY(iFindPointerIndex2);
                g(y11);
                if (this.B) {
                    float f10 = (y11 - this.f4369z) * 0.5f;
                    if (f10 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    c(f10);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.C = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    int actionIndex2 = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex2) == this.C) {
                        this.C = motionEvent.getPointerId(actionIndex2 == 0 ? 1 : 0);
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent;
        View view = this.f4355b;
        if (view == null || j0.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z10);
        } else {
            if (this.R || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public void setAnimationProgress(float f10) {
        this.E.setScaleX(f10);
        this.E.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        a();
        this.K.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = m0.a.getColor(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f4359p = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        e();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.R = z10;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.f4362s.setNestedScrollingEnabled(z10);
    }

    public void setOnRefreshListener(f fVar) {
        this.f4356m = fVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.E.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(m0.a.getColor(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        if (!z10 || this.f4357n == z10) {
            f(z10, false);
            return;
        }
        this.f4357n = z10;
        setTargetOffsetTopAndBottom((this.I + this.H) - this.f4368y);
        this.P = false;
        this.E.setVisibility(0);
        this.K.setAlpha(255);
        o2.e eVar = new o2.e(this);
        this.L = eVar;
        eVar.setDuration(this.f4367x);
        a aVar = this.S;
        if (aVar != null) {
            this.E.setAnimationListener(aVar);
        }
        this.E.clearAnimation();
        this.E.startAnimation(this.L);
    }

    public void setSize(int i10) {
        if (i10 == 0 || i10 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i10 == 0) {
                this.Q = (int) (displayMetrics.density * 56.0f);
            } else {
                this.Q = (int) (displayMetrics.density * 40.0f);
            }
            this.E.setImageDrawable(null);
            this.K.setStyle(i10);
            this.E.setImageDrawable(this.K);
        }
    }

    public void setSlingshotDistance(int i10) {
        this.J = i10;
    }

    public void setTargetOffsetTopAndBottom(int i10) {
        this.E.bringToFront();
        j0.offsetTopAndBottom(this.E, i10);
        this.f4368y = this.E.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return this.f4362s.startNestedScroll(i10);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f4362s.stopNestedScroll();
    }

    public static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public final boolean f4374b;

        public class a implements Parcelable.Creator<g> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public g[] newArray(int i10) {
                return new g[i10];
            }
        }

        public g(Parcelable parcelable, boolean z10) {
            super(parcelable);
            this.f4374b = z10;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f4374b ? (byte) 1 : (byte) 0);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f4374b = parcel.readByte() != 0;
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f4362s.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f4360q;
            if (f10 > 0.0f) {
                float f11 = i11;
                if (f11 > f10) {
                    iArr[1] = (int) f10;
                    this.f4360q = 0.0f;
                } else {
                    this.f4360q = f10 - f11;
                    iArr[1] = i11;
                }
                c(this.f4360q);
            }
        }
        int i12 = i10 - iArr[0];
        int i13 = i11 - iArr[1];
        int[] iArr2 = this.f4363t;
        if (dispatchNestedPreScroll(i12, i13, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f4361r.onNestedScrollAccepted(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f4360q = 0.0f;
        this.f4366w = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (!isEnabled() || this.f4357n || (i10 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f4361r.onStopNestedScroll(view);
        this.f4366w = false;
        float f10 = this.f4360q;
        if (f10 > 0.0f) {
            b(f10);
            this.f4360q = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // x0.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, i14, this.f4365v);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f4365v);
    }

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f fVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f4357n) {
                swipeRefreshLayout.e();
                return;
            }
            swipeRefreshLayout.K.setAlpha(255);
            swipeRefreshLayout.K.start();
            if (swipeRefreshLayout.P && (fVar = swipeRefreshLayout.f4356m) != null) {
                fVar.onRefresh();
            }
            swipeRefreshLayout.f4368y = swipeRefreshLayout.E.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            swipeRefreshLayout.getClass();
            swipeRefreshLayout.h(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void setOnChildScrollUpCallback(e eVar) {
    }
}
