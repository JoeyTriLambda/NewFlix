package t2;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: ViewPager.java */
/* loaded from: classes.dex */
public final class b extends ViewGroup {
    public static final int[] F = {R.attr.layout_gravity};
    public boolean A;
    public ArrayList B;
    public f C;
    public ArrayList D;
    public int E;

    /* renamed from: b, reason: collision with root package name */
    public Parcelable f19371b;

    /* renamed from: m, reason: collision with root package name */
    public int f19372m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f19373n;

    /* renamed from: o, reason: collision with root package name */
    public int f19374o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f19375p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19376q;

    /* renamed from: r, reason: collision with root package name */
    public int f19377r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f19378s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f19379t;

    /* renamed from: u, reason: collision with root package name */
    public int f19380u;

    /* renamed from: v, reason: collision with root package name */
    public float f19381v;

    /* renamed from: w, reason: collision with root package name */
    public float f19382w;

    /* renamed from: x, reason: collision with root package name */
    public float f19383x;

    /* renamed from: y, reason: collision with root package name */
    public int f19384y;

    /* renamed from: z, reason: collision with root package name */
    public VelocityTracker f19385z;

    /* compiled from: ViewPager.java */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            cVar.getClass();
            cVar2.getClass();
            return 0;
        }
    }

    /* compiled from: ViewPager.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: t2.b$b, reason: collision with other inner class name */
    public @interface InterfaceC0256b {
    }

    /* compiled from: ViewPager.java */
    public static class c {
    }

    /* compiled from: ViewPager.java */
    public static class d extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19386a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19387b;

        public d() {
            super(-1, -1);
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.F);
            this.f19387b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ViewPager.java */
    public interface e {
        void onAdapterChanged(b bVar, t2.a aVar, t2.a aVar2);
    }

    /* compiled from: ViewPager.java */
    public interface f {
        void onPageScrollStateChanged(int i10);
    }

    /* compiled from: ViewPager.java */
    public static class g extends f1.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public int f19388n;

        /* renamed from: o, reason: collision with root package name */
        public Parcelable f19389o;

        /* compiled from: ViewPager.java */
        public static class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public g[] newArray(int i10) {
                return new g[i10];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("FragmentPager.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" position=");
            return ac.c.m(sb2, this.f19388n, "}");
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19388n);
            parcel.writeParcelable(this.f19389o, i10);
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? g.class.getClassLoader() : classLoader;
            this.f19388n = parcel.readInt();
            this.f19389o = parcel.readParcelable(classLoader);
        }
    }

    static {
        new a();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.f19376q != z10) {
            this.f19376q = z10;
        }
    }

    public final Rect a(View view) {
        Rect rect = new Rect();
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                if (getChildAt(i12).getVisibility() == 0) {
                    throw null;
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(e eVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(eVar);
    }

    public void addOnPageChangeListener(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.add(fVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (getChildAt(i10).getVisibility() == 0) {
                throw null;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        d dVar = (d) layoutParams;
        boolean z10 = dVar.f19386a | (view.getClass().getAnnotation(InterfaceC0256b.class) != null);
        dVar.f19386a = z10;
        if (!this.f19375p) {
            super.addView(view, i10, layoutParams);
        } else {
            if (z10) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            addViewInLayout(view, i10, layoutParams);
        }
    }

    public boolean arrowScroll(int i10) {
        boolean zRequestFocus;
        boolean z10;
        View viewFindFocus = findFocus();
        boolean z11 = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z10 = false;
                    break;
                }
                if (parent == this) {
                    z10 = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb2.append(" => ");
                    sb2.append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb2.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i10 == 17) {
                int i11 = a(viewFindNextFocus).left;
                int i12 = a(viewFindFocus).left;
                if (viewFindFocus == null || i11 < i12) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                    z11 = zRequestFocus;
                }
            } else if (i10 == 66) {
                int i13 = a(viewFindNextFocus).left;
                int i14 = a(viewFindFocus).left;
                if (viewFindFocus == null || i13 > i14) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                    z11 = zRequestFocus;
                }
            }
        }
        if (z11) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
        }
        return z11;
    }

    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && canScroll(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getChildAt(i10).getVisibility() == 0) {
                throw null;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getOverScrollMode() == 0) {
            throw null;
        }
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f19373n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return false;
            }
            return arrowScroll(17);
        }
        if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return false;
            }
            return arrowScroll(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return arrowScroll(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return arrowScroll(1);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public t2.a getAdapter() {
        return null;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        throw null;
    }

    public int getCurrentItem() {
        return 0;
    }

    public int getOffscreenPageLimit() {
        return this.f19377r;
    }

    public int getPageMargin() {
        return this.f19372m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19372m > 0 && this.f19373n != null) {
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f19384y = -1;
            this.f19378s = false;
            this.f19379t = false;
            VelocityTracker velocityTracker = this.f19385z;
            if (velocityTracker == null) {
                throw null;
            }
            velocityTracker.recycle();
            this.f19385z = null;
            throw null;
        }
        if (action != 0) {
            if (this.f19378s) {
                return true;
            }
            if (this.f19379t) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.f19382w = x10;
            this.f19381v = x10;
            this.f19383x = motionEvent.getY();
            this.f19384y = motionEvent.getPointerId(0);
            this.f19379t = false;
            throw null;
        }
        if (action == 2) {
            int i10 = this.f19384y;
            if (i10 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float f10 = x11 - this.f19381v;
                float fAbs = Math.abs(f10);
                float y10 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y10 - this.f19383x);
                if (f10 != 0.0f) {
                    float f11 = this.f19381v;
                    if (!((f11 < ((float) this.f19380u) && f10 > 0.0f) || (f11 > ((float) (getWidth() - this.f19380u)) && f10 < 0.0f)) && canScroll(this, false, (int) f10, (int) x11, (int) y10)) {
                        this.f19381v = x11;
                        this.f19379t = true;
                        return false;
                    }
                }
                float f12 = 0;
                if (fAbs > f12 && fAbs * 0.5f > fAbs2) {
                    this.f19378s = true;
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f13 = this.f19382w;
                    this.f19381v = f10 > 0.0f ? f13 + f12 : f13 - f12;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f12) {
                    this.f19379t = true;
                }
                if (this.f19378s) {
                    this.f19381v = x11;
                    getScrollX();
                    getClientWidth();
                    throw null;
                }
            }
        } else if (action == 6) {
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == this.f19384y) {
                int i11 = actionIndex == 0 ? 1 : 0;
                this.f19381v = motionEvent.getX(i11);
                this.f19384y = motionEvent.getPointerId(i11);
                VelocityTracker velocityTracker2 = this.f19385z;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
        }
        if (this.f19385z == null) {
            this.f19385z = VelocityTracker.obtain();
        }
        this.f19385z.addMovement(motionEvent);
        return this.f19378s;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
            r10 = this;
            int r11 = r10.getChildCount()
            int r14 = r14 - r12
            int r15 = r15 - r13
            int r12 = r10.getPaddingLeft()
            int r13 = r10.getPaddingTop()
            int r0 = r10.getPaddingRight()
            int r1 = r10.getPaddingBottom()
            int r2 = r10.getScrollX()
            r3 = 0
        L1b:
            r4 = 8
            if (r3 >= r11) goto Laa
            android.view.View r5 = r10.getChildAt(r3)
            int r6 = r5.getVisibility()
            if (r6 == r4) goto La6
            android.view.ViewGroup$LayoutParams r4 = r5.getLayoutParams()
            t2.b$d r4 = (t2.b.d) r4
            boolean r6 = r4.f19386a
            if (r6 == 0) goto La6
            int r4 = r4.f19387b
            r6 = r4 & 7
            r4 = r4 & 112(0x70, float:1.57E-43)
            r7 = 1
            if (r6 == r7) goto L57
            r7 = 3
            if (r6 == r7) goto L51
            r7 = 5
            if (r6 == r7) goto L44
            r6 = r12
            goto L66
        L44:
            int r6 = r14 - r0
            int r7 = r5.getMeasuredWidth()
            int r6 = r6 - r7
            int r7 = r5.getMeasuredWidth()
            int r0 = r0 + r7
            goto L63
        L51:
            int r6 = r5.getMeasuredWidth()
            int r6 = r6 + r12
            goto L66
        L57:
            int r6 = r5.getMeasuredWidth()
            int r6 = r14 - r6
            int r6 = r6 / 2
            int r6 = java.lang.Math.max(r6, r12)
        L63:
            r9 = r6
            r6 = r12
            r12 = r9
        L66:
            r7 = 16
            if (r4 == r7) goto L87
            r7 = 48
            if (r4 == r7) goto L81
            r7 = 80
            if (r4 == r7) goto L74
            r4 = r13
            goto L96
        L74:
            int r4 = r15 - r1
            int r7 = r5.getMeasuredHeight()
            int r4 = r4 - r7
            int r7 = r5.getMeasuredHeight()
            int r1 = r1 + r7
            goto L93
        L81:
            int r4 = r5.getMeasuredHeight()
            int r4 = r4 + r13
            goto L96
        L87:
            int r4 = r5.getMeasuredHeight()
            int r4 = r15 - r4
            int r4 = r4 / 2
            int r4 = java.lang.Math.max(r4, r13)
        L93:
            r9 = r4
            r4 = r13
            r13 = r9
        L96:
            int r12 = r12 + r2
            int r7 = r5.getMeasuredWidth()
            int r7 = r7 + r12
            int r8 = r5.getMeasuredHeight()
            int r8 = r8 + r13
            r5.layout(r12, r13, r7, r8)
            r13 = r4
            r12 = r6
        La6:
            int r3 = r3 + 1
            goto L1b
        Laa:
            r12 = 0
        Lab:
            r13 = 0
            if (r12 >= r11) goto Lc7
            android.view.View r14 = r10.getChildAt(r12)
            int r15 = r14.getVisibility()
            if (r15 == r4) goto Lc4
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            t2.b$d r14 = (t2.b.d) r14
            boolean r14 = r14.f19386a
            if (r14 == 0) goto Lc3
            goto Lc4
        Lc3:
            throw r13
        Lc4:
            int r12 = r12 + 1
            goto Lab
        Lc7:
            boolean r11 = r10.A
            if (r11 != 0) goto Lcf
            r11 = 0
            r10.A = r11
            return
        Lcf:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.b.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        d dVar;
        d dVar2;
        int i12;
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.f19380u = Math.min(measuredWidth / 10, 0);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            int i14 = 1073741824;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8 && (dVar2 = (d) childAt.getLayoutParams()) != null && dVar2.f19386a) {
                int i15 = dVar2.f19387b;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                boolean z10 = true;
                boolean z11 = i17 == 48 || i17 == 80;
                if (i16 != 3 && i16 != 5) {
                    z10 = false;
                }
                if (z11) {
                    i12 = 1073741824;
                } else {
                    i = z10 ? 1073741824 : Integer.MIN_VALUE;
                    i12 = Integer.MIN_VALUE;
                }
                int i18 = ((ViewGroup.LayoutParams) dVar2).width;
                if (i18 != -2) {
                    if (i18 == -1) {
                        i18 = paddingLeft;
                    }
                    i12 = 1073741824;
                } else {
                    i18 = paddingLeft;
                }
                int i19 = ((ViewGroup.LayoutParams) dVar2).height;
                if (i19 == -2) {
                    i19 = measuredHeight;
                    i14 = i;
                } else if (i19 == -1) {
                    i19 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i18, i12), View.MeasureSpec.makeMeasureSpec(i19, i14));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f19374o = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f19375p = false;
        int childCount2 = getChildCount();
        for (int i20 = 0; i20 < childCount2; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8 && ((dVar = (d) childAt2.getLayoutParams()) == null || !dVar.f19386a)) {
                dVar.getClass();
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * 0.0f), 1073741824), this.f19374o);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = 1;
            i13 = childCount;
            i11 = 0;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i13) {
            if (getChildAt(i11).getVisibility() == 0) {
                throw null;
            }
            i11 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        this.f19371b = gVar.f19389o;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        gVar.f19388n = 0;
        return gVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            if (i12 <= 0) {
                throw null;
            }
            throw null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getEdgeFlags();
        }
        return false;
    }

    public void removeOnAdapterChangeListener(e eVar) {
        ArrayList arrayList = this.D;
        if (arrayList != null) {
            arrayList.remove(eVar);
        }
    }

    public void removeOnPageChangeListener(f fVar) {
        ArrayList arrayList = this.B;
        if (arrayList != null) {
            arrayList.remove(fVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f19375p) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(t2.a aVar) {
        ArrayList arrayList = this.D;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.D.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) this.D.get(i10)).onAdapterChanged(this, null, aVar);
        }
    }

    public void setCurrentItem(int i10) {
        setScrollingCacheEnabled(false);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i10 + " too small; defaulting to 1");
            i10 = 1;
        }
        if (i10 != this.f19377r) {
            this.f19377r = i10;
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.C = fVar;
    }

    public void setPageMargin(int i10) {
        this.f19372m = i10;
        if (getWidth() <= 0) {
            throw null;
        }
        throw null;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f19373n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i10) {
        if (this.E == i10) {
            return;
        }
        this.E = i10;
        f fVar = this.C;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i10);
        }
        ArrayList arrayList = this.B;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                f fVar2 = (f) this.B.get(i11);
                if (fVar2 != null) {
                    fVar2.onPageScrollStateChanged(i10);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f19373n;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(m0.a.getDrawable(getContext(), i10));
    }
}
