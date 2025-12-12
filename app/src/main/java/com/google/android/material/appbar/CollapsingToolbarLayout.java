package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import i7.o;
import i7.r;
import java.lang.reflect.InvocationTargetException;
import k7.g;
import q6.f;
import x0.j0;
import x0.v;
import x0.y0;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int Q = R.style.Widget_Design_CollapsingToolbar;
    public Drawable A;
    public int B;
    public boolean C;
    public ValueAnimator D;
    public long E;
    public final TimeInterpolator F;
    public final TimeInterpolator G;
    public int H;
    public c I;
    public int J;
    public int K;
    public y0 L;
    public int M;
    public boolean N;
    public int O;
    public boolean P;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8747b;

    /* renamed from: m, reason: collision with root package name */
    public final int f8748m;

    /* renamed from: n, reason: collision with root package name */
    public ViewGroup f8749n;

    /* renamed from: o, reason: collision with root package name */
    public View f8750o;

    /* renamed from: p, reason: collision with root package name */
    public View f8751p;

    /* renamed from: q, reason: collision with root package name */
    public int f8752q;

    /* renamed from: r, reason: collision with root package name */
    public int f8753r;

    /* renamed from: s, reason: collision with root package name */
    public int f8754s;

    /* renamed from: t, reason: collision with root package name */
    public int f8755t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f8756u;

    /* renamed from: v, reason: collision with root package name */
    public final com.google.android.material.internal.a f8757v;

    /* renamed from: w, reason: collision with root package name */
    public final f7.a f8758w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8759x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8760y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f8761z;

    public class a implements v {
        public a() {
        }

        @Override // x0.v
        public y0 onApplyWindowInsets(View view, y0 y0Var) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.getClass();
            y0 y0Var2 = j0.getFitsSystemWindows(collapsingToolbarLayout) ? y0Var : null;
            if (!w0.c.equals(collapsingToolbarLayout.L, y0Var2)) {
                collapsingToolbarLayout.L = y0Var2;
                collapsingToolbarLayout.requestLayout();
            }
            return y0Var.consumeSystemWindowInsets();
        }
    }

    public class c implements AppBarLayout.g {
        public c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) throws NoSuchMethodException, SecurityException {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.J = i10;
            y0 y0Var = collapsingToolbarLayout.L;
            int systemWindowInsetTop = y0Var != null ? y0Var.getSystemWindowInsetTop() : 0;
            int childCount = collapsingToolbarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = collapsingToolbarLayout.getChildAt(i11);
                b bVar = (b) childAt.getLayoutParams();
                f fVarB = CollapsingToolbarLayout.b(childAt);
                int i12 = bVar.f8763a;
                if (i12 == 1) {
                    fVarB.setTopAndBottomOffset(r0.a.clamp(-i10, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.b(childAt).getLayoutTop()) - childAt.getHeight()) - ((FrameLayout.LayoutParams) ((b) childAt.getLayoutParams())).bottomMargin));
                } else if (i12 == 2) {
                    fVarB.setTopAndBottomOffset(Math.round((-i10) * bVar.f8764b));
                }
            }
            collapsingToolbarLayout.d();
            if (collapsingToolbarLayout.A != null && systemWindowInsetTop > 0) {
                j0.postInvalidateOnAnimation(collapsingToolbarLayout);
            }
            int height = collapsingToolbarLayout.getHeight();
            int minimumHeight = (height - j0.getMinimumHeight(collapsingToolbarLayout)) - systemWindowInsetTop;
            float scrimVisibleHeightTrigger = height - collapsingToolbarLayout.getScrimVisibleHeightTrigger();
            float f10 = minimumHeight;
            float fMin = Math.min(1.0f, scrimVisibleHeightTrigger / f10);
            com.google.android.material.internal.a aVar = collapsingToolbarLayout.f8757v;
            aVar.setFadeModeStartFraction(fMin);
            aVar.setCurrentOffsetY(collapsingToolbarLayout.J + minimumHeight);
            aVar.setExpansionFraction(Math.abs(i10) / f10);
        }
    }

    public interface d extends o {
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public static f b(View view) {
        int i10 = R.id.view_offset_helper;
        f fVar = (f) view.getTag(i10);
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(view);
        view.setTag(i10, fVar2);
        return fVar2;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() throws Resources.NotFoundException {
        ColorStateList colorStateListOrNull = c7.a.getColorStateListOrNull(getContext(), R.attr.colorSurfaceContainer);
        if (colorStateListOrNull != null) {
            return colorStateListOrNull.getDefaultColor();
        }
        return this.f8758w.compositeOverlayWithThemeSurfaceColorIfNeeded(getResources().getDimension(R.dimen.design_appbar_elevation));
    }

    public final void a() {
        if (this.f8747b) {
            ViewGroup viewGroup = null;
            this.f8749n = null;
            this.f8750o = null;
            int i10 = this.f8748m;
            if (i10 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i10);
                this.f8749n = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    View view = viewGroup2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.f8750o = view;
                }
            }
            if (this.f8749n == null) {
                int childCount = getChildCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i11);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i11++;
                }
                this.f8749n = viewGroup;
            }
            c();
            this.f8747b = false;
        }
    }

    public final void c() {
        View view;
        if (!this.f8759x && (view = this.f8751p) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8751p);
            }
        }
        if (!this.f8759x || this.f8749n == null) {
            return;
        }
        if (this.f8751p == null) {
            this.f8751p = new View(getContext());
        }
        if (this.f8751p.getParent() == null) {
            this.f8749n.addView(this.f8751p, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public final void d() {
        if (this.f8761z == null && this.A == null) {
            return;
        }
        setScrimsShown(getHeight() + this.J < getScrimVisibleHeightTrigger());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            super.draw(r7)
            r6.a()
            android.view.ViewGroup r0 = r6.f8749n
            if (r0 != 0) goto L20
            android.graphics.drawable.Drawable r0 = r6.f8761z
            if (r0 == 0) goto L20
            int r1 = r6.B
            if (r1 <= 0) goto L20
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r1 = r6.B
            r0.setAlpha(r1)
            android.graphics.drawable.Drawable r0 = r6.f8761z
            r0.draw(r7)
        L20:
            boolean r0 = r6.f8759x
            r1 = 0
            if (r0 == 0) goto L65
            boolean r0 = r6.f8760y
            if (r0 == 0) goto L65
            android.view.ViewGroup r0 = r6.f8749n
            com.google.android.material.internal.a r2 = r6.f8757v
            if (r0 == 0) goto L62
            android.graphics.drawable.Drawable r0 = r6.f8761z
            if (r0 == 0) goto L62
            int r0 = r6.B
            if (r0 <= 0) goto L62
            int r0 = r6.K
            r3 = 1
            if (r0 != r3) goto L3d
            goto L3e
        L3d:
            r3 = 0
        L3e:
            if (r3 == 0) goto L62
            float r0 = r2.getExpansionFraction()
            float r3 = r2.getFadeModeThresholdFraction()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L62
            int r0 = r7.save()
            android.graphics.drawable.Drawable r3 = r6.f8761z
            android.graphics.Rect r3 = r3.getBounds()
            android.graphics.Region$Op r4 = android.graphics.Region.Op.DIFFERENCE
            r7.clipRect(r3, r4)
            r2.draw(r7)
            r7.restoreToCount(r0)
            goto L65
        L62:
            r2.draw(r7)
        L65:
            android.graphics.drawable.Drawable r0 = r6.A
            if (r0 == 0) goto L98
            int r0 = r6.B
            if (r0 <= 0) goto L98
            x0.y0 r0 = r6.L
            if (r0 == 0) goto L76
            int r0 = r0.getSystemWindowInsetTop()
            goto L77
        L76:
            r0 = 0
        L77:
            if (r0 <= 0) goto L98
            android.graphics.drawable.Drawable r2 = r6.A
            int r3 = r6.J
            int r3 = -r3
            int r4 = r6.getWidth()
            int r5 = r6.J
            int r0 = r0 - r5
            r2.setBounds(r1, r3, r4, r0)
            android.graphics.drawable.Drawable r0 = r6.A
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r1 = r6.B
            r0.setAlpha(r1)
            android.graphics.drawable.Drawable r0 = r6.A
            r0.draw(r7)
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.draw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean drawChild(android.graphics.Canvas r7, android.view.View r8, long r9) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.f8761z
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L4d
            int r3 = r6.B
            if (r3 <= 0) goto L4d
            android.view.View r3 = r6.f8750o
            if (r3 == 0) goto L14
            if (r3 != r6) goto L11
            goto L14
        L11:
            if (r8 != r3) goto L1a
            goto L18
        L14:
            android.view.ViewGroup r3 = r6.f8749n
            if (r8 != r3) goto L1a
        L18:
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 == 0) goto L4d
            int r3 = r6.getWidth()
            int r4 = r6.getHeight()
            int r5 = r6.K
            if (r5 != r2) goto L2b
            r5 = 1
            goto L2c
        L2b:
            r5 = 0
        L2c:
            if (r5 == 0) goto L38
            if (r8 == 0) goto L38
            boolean r5 = r6.f8759x
            if (r5 == 0) goto L38
            int r4 = r8.getBottom()
        L38:
            r0.setBounds(r1, r1, r3, r4)
            android.graphics.drawable.Drawable r0 = r6.f8761z
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r6.B
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r6.f8761z
            r0.draw(r7)
            r0 = 1
            goto L4e
        L4d:
            r0 = 0
        L4e:
            boolean r7 = super.drawChild(r7, r8, r9)
            if (r7 != 0) goto L56
            if (r0 == 0) goto L57
        L56:
            r1 = 1
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.A;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f8761z;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.f8757v;
        if (aVar != null) {
            state |= aVar.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(int i10, int i11, int i12, int i13, boolean z10) throws NoSuchMethodException, SecurityException {
        View view;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        if (!this.f8759x || (view = this.f8751p) == null) {
            return;
        }
        int titleMarginStart = 0;
        boolean z11 = j0.isAttachedToWindow(view) && this.f8751p.getVisibility() == 0;
        this.f8760y = z11;
        if (z11 || z10) {
            boolean z12 = j0.getLayoutDirection(this) == 1;
            View view2 = this.f8750o;
            if (view2 == null) {
                view2 = this.f8749n;
            }
            int height = ((getHeight() - b(view2).getLayoutTop()) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((b) view2.getLayoutParams())).bottomMargin;
            View view3 = this.f8751p;
            Rect rect = this.f8756u;
            i7.b.getDescendantRect(this, view3, rect);
            ViewGroup viewGroup = this.f8749n;
            if (viewGroup instanceof Toolbar) {
                Toolbar toolbar = (Toolbar) viewGroup;
                titleMarginStart = toolbar.getTitleMarginStart();
                titleMarginEnd = toolbar.getTitleMarginEnd();
                titleMarginTop = toolbar.getTitleMarginTop();
                titleMarginBottom = toolbar.getTitleMarginBottom();
            } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                titleMarginBottom = 0;
                titleMarginEnd = 0;
                titleMarginTop = 0;
            } else {
                android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                titleMarginStart = toolbar2.getTitleMarginStart();
                titleMarginEnd = toolbar2.getTitleMarginEnd();
                titleMarginTop = toolbar2.getTitleMarginTop();
                titleMarginBottom = toolbar2.getTitleMarginBottom();
            }
            int i14 = rect.left + (z12 ? titleMarginEnd : titleMarginStart);
            int i15 = rect.top + height + titleMarginTop;
            int i16 = rect.right;
            if (!z12) {
                titleMarginStart = titleMarginEnd;
            }
            int i17 = i16 - titleMarginStart;
            int i18 = (rect.bottom + height) - titleMarginBottom;
            com.google.android.material.internal.a aVar = this.f8757v;
            aVar.setCollapsedBounds(i14, i15, i17, i18);
            aVar.setExpandedBounds(z12 ? this.f8754s : this.f8752q, rect.top + this.f8753r, (i12 - i10) - (z12 ? this.f8752q : this.f8754s), (i13 - i11) - this.f8755t);
            aVar.recalculate(z10);
        }
    }

    public final void f() throws NoSuchMethodException, SecurityException {
        if (this.f8749n != null && this.f8759x && TextUtils.isEmpty(this.f8757v.getText())) {
            ViewGroup viewGroup = this.f8749n;
            setTitle(viewGroup instanceof Toolbar ? ((Toolbar) viewGroup).getTitle() : viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null);
        }
    }

    public int getCollapsedTitleGravity() {
        return this.f8757v.getCollapsedTextGravity();
    }

    public float getCollapsedTitleTextSize() {
        return this.f8757v.getCollapsedTextSize();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f8757v.getCollapsedTypeface();
    }

    public Drawable getContentScrim() {
        return this.f8761z;
    }

    public int getExpandedTitleGravity() {
        return this.f8757v.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f8755t;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f8754s;
    }

    public int getExpandedTitleMarginStart() {
        return this.f8752q;
    }

    public int getExpandedTitleMarginTop() {
        return this.f8753r;
    }

    public float getExpandedTitleTextSize() {
        return this.f8757v.getExpandedTextSize();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f8757v.getExpandedTypeface();
    }

    public int getHyphenationFrequency() {
        return this.f8757v.getHyphenationFrequency();
    }

    public int getLineCount() {
        return this.f8757v.getLineCount();
    }

    public float getLineSpacingAdd() {
        return this.f8757v.getLineSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.f8757v.getLineSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.f8757v.getMaxLines();
    }

    public int getScrimAlpha() {
        return this.B;
    }

    public long getScrimAnimationDuration() {
        return this.E;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10 = this.H;
        if (i10 >= 0) {
            return i10 + this.M + this.O;
        }
        y0 y0Var = this.L;
        int systemWindowInsetTop = y0Var != null ? y0Var.getSystemWindowInsetTop() : 0;
        int minimumHeight = j0.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.A;
    }

    public CharSequence getTitle() {
        if (this.f8759x) {
            return this.f8757v.getText();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.K;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f8757v.getPositionInterpolator();
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f8757v.getTitleTextEllipsize();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.K == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
            j0.setFitsSystemWindows(this, j0.getFitsSystemWindows(appBarLayout));
            if (this.I == null) {
                this.I = new c();
            }
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.g) this.I);
            j0.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws NoSuchMethodException, SecurityException {
        super.onConfigurationChanged(configuration);
        this.f8757v.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        c cVar = this.I;
        if (cVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener((AppBarLayout.g) cVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws NoSuchMethodException, SecurityException {
        super.onLayout(z10, i10, i11, i12, i13);
        y0 y0Var = this.L;
        if (y0Var != null) {
            int systemWindowInsetTop = y0Var.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (!j0.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    j0.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            f fVarB = b(getChildAt(i15));
            View view = fVarB.f17918a;
            fVarB.f17919b = view.getTop();
            fVarB.f17920c = view.getLeft();
        }
        e(i10, i11, i12, i13, false);
        f();
        d();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            b(getChildAt(i16)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) throws NoSuchMethodException, SecurityException {
        int measuredHeight;
        int measuredHeight2;
        a();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        y0 y0Var = this.L;
        int systemWindowInsetTop = y0Var != null ? y0Var.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.N) && systemWindowInsetTop > 0) {
            this.M = systemWindowInsetTop;
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.P) {
            com.google.android.material.internal.a aVar = this.f8757v;
            if (aVar.getMaxLines() > 1) {
                f();
                e(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
                int expandedLineCount = aVar.getExpandedLineCount();
                if (expandedLineCount > 1) {
                    this.O = (expandedLineCount - 1) * Math.round(aVar.getExpandedTextFullHeight());
                    super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.O, 1073741824));
                }
            }
        }
        ViewGroup viewGroup = this.f8749n;
        if (viewGroup != null) {
            View view = this.f8750o;
            if (view == null || view == this) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    measuredHeight = viewGroup.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    measuredHeight = viewGroup.getMeasuredHeight();
                }
                setMinimumHeight(measuredHeight);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                measuredHeight2 = view.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
            } else {
                measuredHeight2 = view.getMeasuredHeight();
            }
            setMinimumHeight(measuredHeight2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f8761z;
        if (drawable != null) {
            ViewGroup viewGroup = this.f8749n;
            if ((this.K == 1) && viewGroup != null && this.f8759x) {
                i11 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i10, i11);
        }
    }

    public void setCollapsedTitleGravity(int i10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setCollapsedTextGravity(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setCollapsedTextAppearance(i10);
    }

    public void setCollapsedTitleTextColor(int i10) throws NoSuchMethodException, SecurityException {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTextSize(float f10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setCollapsedTextSize(f10);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) throws NoSuchMethodException, SecurityException {
        this.f8757v.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f8761z;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f8761z = drawableMutate;
            if (drawableMutate != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.f8749n;
                if ((this.K == 1) && viewGroup != null && this.f8759x) {
                    height = viewGroup.getBottom();
                }
                drawableMutate.setBounds(0, 0, width, height);
                this.f8761z.setCallback(this);
                this.f8761z.setAlpha(this.B);
            }
            j0.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(m0.a.getDrawable(getContext(), i10));
    }

    public void setExpandedTitleColor(int i10) throws NoSuchMethodException, SecurityException {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setExpandedTextGravity(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f8755t = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f8754s = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f8752q = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f8753r = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setExpandedTextAppearance(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        this.f8757v.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTextSize(float f10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setExpandedTextSize(f10);
    }

    public void setExpandedTitleTypeface(Typeface typeface) throws NoSuchMethodException, SecurityException {
        this.f8757v.setExpandedTypeface(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.P = z10;
    }

    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.N = z10;
    }

    public void setHyphenationFrequency(int i10) {
        this.f8757v.setHyphenationFrequency(i10);
    }

    public void setLineSpacingAdd(float f10) {
        this.f8757v.setLineSpacingAdd(f10);
    }

    public void setLineSpacingMultiplier(float f10) {
        this.f8757v.setLineSpacingMultiplier(f10);
    }

    public void setMaxLines(int i10) throws NoSuchMethodException, SecurityException {
        this.f8757v.setMaxLines(i10);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f8757v.setRtlTextDirectionHeuristicsEnabled(z10);
    }

    public void setScrimAlpha(int i10) {
        ViewGroup viewGroup;
        if (i10 != this.B) {
            if (this.f8761z != null && (viewGroup = this.f8749n) != null) {
                j0.postInvalidateOnAnimation(viewGroup);
            }
            this.B = i10;
            j0.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.E = j10;
    }

    public void setScrimVisibleHeightTrigger(int i10) {
        if (this.H != i10) {
            this.H = i10;
            d();
        }
    }

    public void setScrimsShown(boolean z10) {
        setScrimsShown(z10, j0.isLaidOut(this) && !isInEditMode());
    }

    public void setStaticLayoutBuilderConfigurer(d dVar) throws NoSuchMethodException, SecurityException {
        this.f8757v.setStaticLayoutBuilderConfigurer(dVar);
    }

    public void setStatusBarScrim(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.A;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.A = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.A.setState(getDrawableState());
                }
                p0.a.setLayoutDirection(this.A, j0.getLayoutDirection(this));
                this.A.setVisible(getVisibility() == 0, false);
                this.A.setCallback(this);
                this.A.setAlpha(this.B);
            }
            j0.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarScrim(m0.a.getDrawable(getContext(), i10));
    }

    public void setTitle(CharSequence charSequence) throws NoSuchMethodException, SecurityException {
        this.f8757v.setText(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i10) {
        this.K = i10;
        boolean z10 = i10 == 1;
        this.f8757v.setFadeModeEnabled(z10);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.K == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z10 && this.f8761z == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) throws NoSuchMethodException, SecurityException {
        this.f8757v.setTitleTextEllipsize(truncateAt);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f8759x) {
            this.f8759x = z10;
            setContentDescription(getTitle());
            c();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) throws NoSuchMethodException, SecurityException {
        this.f8757v.setPositionInterpolator(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.A;
        if (drawable != null && drawable.isVisible() != z10) {
            this.A.setVisible(z10, false);
        }
        Drawable drawable2 = this.f8761z;
        if (drawable2 == null || drawable2.isVisible() == z10) {
            return;
        }
        this.f8761z.setVisible(z10, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8761z || drawable == this.A;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i11 = Q;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8747b = true;
        this.f8756u = new Rect();
        this.H = -1;
        this.M = 0;
        this.O = 0;
        Context context2 = getContext();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f8757v = aVar;
        aVar.setTextSizeInterpolator(p6.a.f17608e);
        aVar.setRtlTextDirectionHeuristicsEnabled(false);
        this.f8758w = new f7.a(context2);
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i10, i11, new int[0]);
        aVar.setExpandedTextGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        aVar.setCollapsedTextGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f8755t = dimensionPixelSize;
        this.f8754s = dimensionPixelSize;
        this.f8753r = dimensionPixelSize;
        this.f8752q = dimensionPixelSize;
        int i12 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.f8752q = typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, 0);
        }
        int i13 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.f8754s = typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, 0);
        }
        int i14 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f8753r = typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, 0);
        }
        int i15 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            this.f8755t = typedArrayObtainStyledAttributes.getDimensionPixelSize(i15, 0);
        }
        this.f8759x = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        aVar.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        aVar.setCollapsedTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i16 = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            aVar.setExpandedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(i16, 0));
        }
        int i17 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            aVar.setCollapsedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(i17, 0));
        }
        int i18 = R.styleable.CollapsingToolbarLayout_titleTextEllipsize;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            int i19 = typedArrayObtainStyledAttributes.getInt(i18, -1);
            setTitleEllipsize(i19 != 0 ? i19 != 1 ? i19 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START);
        }
        int i20 = R.styleable.CollapsingToolbarLayout_expandedTitleTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i20)) {
            aVar.setExpandedTextColor(n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, i20));
        }
        int i21 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i21)) {
            aVar.setCollapsedTextColor(n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, i21));
        }
        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int i22 = R.styleable.CollapsingToolbarLayout_maxLines;
        if (typedArrayObtainStyledAttributes.hasValue(i22)) {
            aVar.setMaxLines(typedArrayObtainStyledAttributes.getInt(i22, 1));
        }
        int i23 = R.styleable.CollapsingToolbarLayout_titlePositionInterpolator;
        if (typedArrayObtainStyledAttributes.hasValue(i23)) {
            aVar.setPositionInterpolator(AnimationUtils.loadInterpolator(context2, typedArrayObtainStyledAttributes.getResourceId(i23, 0)));
        }
        this.E = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        int i24 = R.attr.motionEasingStandardInterpolator;
        this.F = g.resolveThemeInterpolator(context2, i24, p6.a.f17606c);
        this.G = g.resolveThemeInterpolator(context2, i24, p6.a.f17607d);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f8748m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.N = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        j0.setOnApplyWindowInsetsListener(this, new a());
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        this.f8757v.setCollapsedTextColor(colorStateList);
    }

    public void setScrimsShown(boolean z10, boolean z11) {
        if (this.C != z10) {
            if (z11) {
                int i10 = z10 ? 255 : 0;
                a();
                ValueAnimator valueAnimator = this.D;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.D = valueAnimator2;
                    valueAnimator2.setInterpolator(i10 > this.B ? this.F : this.G);
                    this.D.addUpdateListener(new q6.b(this));
                } else if (valueAnimator.isRunning()) {
                    this.D.cancel();
                }
                this.D.setDuration(this.E);
                this.D.setIntValues(this.B, i10);
                this.D.start();
            } else {
                setScrimAlpha(z10 ? 255 : 0);
            }
            this.C = z10;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public static class b extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public final int f8763a;

        /* renamed from: b, reason: collision with root package name */
        public float f8764b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8763a = 0;
            this.f8764b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f8763a = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(typedArrayObtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void setParallaxMultiplier(float f10) {
            this.f8764b = f10;
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f8763a = 0;
            this.f8764b = 0.5f;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8763a = 0;
            this.f8764b = 0.5f;
        }
    }
}
