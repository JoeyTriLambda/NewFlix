package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import x0.y0;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements g0, x0.s, x0.t {
    public static final int[] M = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public final Rect A;
    public x0.y0 B;
    public x0.y0 C;
    public x0.y0 D;
    public x0.y0 E;
    public d F;
    public OverScroller G;
    public ViewPropertyAnimator H;
    public final a I;
    public final b J;
    public final c K;
    public final x0.u L;

    /* renamed from: b, reason: collision with root package name */
    public int f1087b;

    /* renamed from: m, reason: collision with root package name */
    public int f1088m;

    /* renamed from: n, reason: collision with root package name */
    public ContentFrameLayout f1089n;

    /* renamed from: o, reason: collision with root package name */
    public ActionBarContainer f1090o;

    /* renamed from: p, reason: collision with root package name */
    public h0 f1091p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f1092q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1093r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1094s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1095t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1096u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1097v;

    /* renamed from: w, reason: collision with root package name */
    public int f1098w;

    /* renamed from: x, reason: collision with root package name */
    public int f1099x;

    /* renamed from: y, reason: collision with root package name */
    public final Rect f1100y;

    /* renamed from: z, reason: collision with root package name */
    public final Rect f1101z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.H = null;
            actionBarOverlayLayout.f1097v = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.H = null;
            actionBarOverlayLayout.f1097v = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.b();
            actionBarOverlayLayout.H = actionBarOverlayLayout.f1090o.animate().translationY(0.0f).setListener(actionBarOverlayLayout.I);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.b();
            actionBarOverlayLayout.H = actionBarOverlayLayout.f1090o.animate().translationY(-actionBarOverlayLayout.f1090o.getHeight()).setListener(actionBarOverlayLayout.I);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1088m = 0;
        this.f1100y = new Rect();
        this.f1101z = new Rect();
        this.A = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        x0.y0 y0Var = x0.y0.f21340b;
        this.B = y0Var;
        this.C = y0Var;
        this.D = y0Var;
        this.E = y0Var;
        this.I = new a();
        this.J = new b();
        this.K = new c();
        c(context);
        this.L = new x0.u(this);
    }

    public static boolean a(FrameLayout frameLayout, Rect rect, boolean z10) {
        boolean z11;
        e eVar = (e) frameLayout.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i11 = rect.left;
        if (i10 != i11) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i11;
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i13 = rect.top;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i13;
            z11 = true;
        }
        int i14 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i15 = rect.right;
        if (i14 != i15) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i15;
            z11 = true;
        }
        if (z10) {
            int i16 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i17 = rect.bottom;
            if (i16 != i17) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i17;
                return true;
            }
        }
        return z11;
    }

    public final void b() {
        removeCallbacks(this.J);
        removeCallbacks(this.K);
        ViewPropertyAnimator viewPropertyAnimator = this.H;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(M);
        this.f1087b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1092q = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1093r = context.getApplicationInfo().targetSdkVersion < 19;
        this.G = new OverScroller(context);
    }

    @Override // androidx.appcompat.widget.g0
    public boolean canShowOverflowMenu() {
        d();
        return this.f1091p.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public final void d() {
        h0 wrapper;
        if (this.f1089n == null) {
            this.f1089n = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1090o = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof h0) {
                wrapper = (h0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f1091p = wrapper;
        }
    }

    @Override // androidx.appcompat.widget.g0
    public void dismissPopups() {
        d();
        this.f1091p.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f1092q == null || this.f1093r) {
            return;
        }
        if (this.f1090o.getVisibility() == 0) {
            translationY = (int) (this.f1090o.getTranslationY() + this.f1090o.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.f1092q.setBounds(0, translationY, getWidth(), this.f1092q.getIntrinsicHeight() + translationY);
        this.f1092q.draw(canvas);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1090o;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.L.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        d();
        return this.f1091p.getTitle();
    }

    @Override // androidx.appcompat.widget.g0
    public boolean hideOverflowMenu() {
        d();
        return this.f1091p.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.g0
    public void initFeature(int i10) {
        d();
        if (i10 == 2) {
            this.f1091p.initProgress();
        } else if (i10 == 5) {
            this.f1091p.initIndeterminateProgress();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public boolean isInOverlayMode() {
        return this.f1094s;
    }

    @Override // androidx.appcompat.widget.g0
    public boolean isOverflowMenuShowPending() {
        d();
        return this.f1091p.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.g0
    public boolean isOverflowMenuShowing() {
        d();
        return this.f1091p.isOverflowMenuShowing();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        d();
        x0.y0 windowInsetsCompat = x0.y0.toWindowInsetsCompat(windowInsets, this);
        boolean zA = a(this.f1090o, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), false);
        Rect rect = this.f1100y;
        x0.j0.computeSystemWindowInsets(this, windowInsetsCompat, rect);
        x0.y0 y0VarInset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.B = y0VarInset;
        boolean z10 = true;
        if (!this.C.equals(y0VarInset)) {
            this.C = this.B;
            zA = true;
        }
        Rect rect2 = this.f1101z;
        if (rect2.equals(rect)) {
            z10 = zA;
        } else {
            rect2.set(rect);
        }
        if (z10) {
            requestLayout();
        }
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c(getContext());
        x0.j0.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        d();
        measureChildWithMargins(this.f1090o, i10, 0, i11, 0);
        e eVar = (e) this.f1090o.getLayoutParams();
        int iMax = Math.max(0, this.f1090o.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f1090o.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1090o.getMeasuredState());
        boolean z10 = (x0.j0.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f1087b;
            if (this.f1095t && this.f1090o.getTabContainer() != null) {
                measuredHeight += this.f1087b;
            }
        } else {
            measuredHeight = this.f1090o.getVisibility() != 8 ? this.f1090o.getMeasuredHeight() : 0;
        }
        Rect rect = this.f1100y;
        Rect rect2 = this.A;
        rect2.set(rect);
        x0.y0 y0Var = this.B;
        this.D = y0Var;
        if (this.f1094s || z10) {
            this.D = new y0.b(this.D).setSystemWindowInsets(o0.b.of(y0Var.getSystemWindowInsetLeft(), this.D.getSystemWindowInsetTop() + measuredHeight, this.D.getSystemWindowInsetRight(), this.D.getSystemWindowInsetBottom() + 0)).build();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom += 0;
            this.D = y0Var.inset(0, measuredHeight, 0, 0);
        }
        a(this.f1089n, rect2, true);
        if (!this.E.equals(this.D)) {
            x0.y0 y0Var2 = this.D;
            this.E = y0Var2;
            x0.j0.dispatchApplyWindowInsets(this.f1089n, y0Var2);
        }
        measureChildWithMargins(this.f1089n, i10, 0, i11, 0);
        e eVar2 = (e) this.f1089n.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1089n.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1089n.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1089n.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i10, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f1096u || !z10) {
            return false;
        }
        this.G.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.G.getFinalY() > this.f1090o.getHeight()) {
            b();
            this.K.run();
        } else {
            b();
            this.J.run();
        }
        this.f1097v = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // x0.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScroll(view, i10, i11, i12, i13, i14);
    }

    @Override // x0.s
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // x0.s
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // x0.s
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        d();
        int i11 = this.f1099x ^ i10;
        this.f1099x = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        d dVar = this.F;
        if (dVar != null) {
            ((r.e0) dVar).enableContentAnimations(!z11);
            if (z10 || !z11) {
                ((r.e0) this.F).showForSystem();
            } else {
                ((r.e0) this.F).hideForSystem();
            }
        }
        if ((i11 & 256) == 0 || this.F == null) {
            return;
        }
        x0.j0.requestApplyInsets(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1088m = i10;
        d dVar = this.F;
        if (dVar != null) {
            ((r.e0) dVar).onWindowVisibilityChanged(i10);
        }
    }

    public void setActionBarHideOffset(int i10) {
        b();
        this.f1090o.setTranslationY(-Math.max(0, Math.min(i10, this.f1090o.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.F = dVar;
        if (getWindowToken() != null) {
            ((r.e0) this.F).onWindowVisibilityChanged(this.f1088m);
            int i10 = this.f1099x;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                x0.j0.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1095t = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1096u) {
            this.f1096u = z10;
            if (z10) {
                return;
            }
            b();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        d();
        this.f1091p.setIcon(i10);
    }

    public void setLogo(int i10) {
        d();
        this.f1091p.setLogo(i10);
    }

    @Override // androidx.appcompat.widget.g0
    public void setMenu(Menu menu, i.a aVar) {
        d();
        this.f1091p.setMenu(menu, aVar);
    }

    @Override // androidx.appcompat.widget.g0
    public void setMenuPrepared() {
        d();
        this.f1091p.setMenuPrepared();
    }

    public void setOverlayMode(boolean z10) {
        this.f1094s = z10;
        this.f1093r = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    @Override // androidx.appcompat.widget.g0
    public void setWindowCallback(Window.Callback callback) {
        d();
        this.f1091p.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.g0
    public void setWindowTitle(CharSequence charSequence) {
        d();
        this.f1091p.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.g0
    public boolean showOverflowMenu() {
        d();
        return this.f1091p.showOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // x0.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // x0.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.L.onNestedScrollAccepted(view, view2, i10);
        this.f1098w = getActionBarHideOffset();
        b();
        d dVar = this.F;
        if (dVar != null) {
            ((r.e0) dVar).onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f1090o.getVisibility() != 0) {
            return false;
        }
        return this.f1096u;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1096u && !this.f1097v) {
            if (this.f1098w <= this.f1090o.getHeight()) {
                b();
                postDelayed(this.J, 600L);
            } else {
                b();
                postDelayed(this.K, 600L);
            }
        }
        d dVar = this.F;
        if (dVar != null) {
            ((r.e0) dVar).onContentScrollStopped();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f1098w + i11;
        this.f1098w = i14;
        setActionBarHideOffset(i14);
    }

    public void setIcon(Drawable drawable) {
        d();
        this.f1091p.setIcon(drawable);
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }
}
