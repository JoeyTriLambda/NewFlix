package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.g;
import i7.r;
import i7.t;
import i7.v;
import java.util.List;
import q7.l;
import x0.j0;
import x0.y0;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    public final int f9284a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9285b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9286c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f9287d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f9288e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f9289f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f9290g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f9291h;

    /* renamed from: i, reason: collision with root package name */
    public final g f9292i;

    /* renamed from: j, reason: collision with root package name */
    public final s7.f f9293j;

    /* renamed from: k, reason: collision with root package name */
    public int f9294k;

    /* renamed from: m, reason: collision with root package name */
    public int f9296m;

    /* renamed from: n, reason: collision with root package name */
    public int f9297n;

    /* renamed from: o, reason: collision with root package name */
    public int f9298o;

    /* renamed from: p, reason: collision with root package name */
    public int f9299p;

    /* renamed from: q, reason: collision with root package name */
    public int f9300q;

    /* renamed from: r, reason: collision with root package name */
    public int f9301r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9302s;

    /* renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f9303t;

    /* renamed from: v, reason: collision with root package name */
    public static final p1.b f9279v = p6.a.f17605b;

    /* renamed from: w, reason: collision with root package name */
    public static final LinearInterpolator f9280w = p6.a.f17604a;

    /* renamed from: x, reason: collision with root package name */
    public static final p1.c f9281x = p6.a.f17607d;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f9283z = {R.attr.snackbarStyle};
    public static final String A = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: y, reason: collision with root package name */
    public static final Handler f9282y = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: l, reason: collision with root package name */
    public final b f9295l = new b();

    /* renamed from: u, reason: collision with root package name */
    public final e f9304u = new e();

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: u, reason: collision with root package name */
        public final f f9305u = new f(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return this.f9305u.canSwipeDismissView(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f9305u.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    public class a implements Handler.Callback {
        /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean handleMessage(android.os.Message r8) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.BaseTransientBottomBar.a.handleMessage(android.os.Message):boolean");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f9292i == null || (context = baseTransientBottomBar.f9291h) == null) {
                return;
            }
            int iHeight = v.getCurrentWindowBounds(context).height();
            int[] iArr = new int[2];
            g gVar = baseTransientBottomBar.f9292i;
            gVar.getLocationInWindow(iArr);
            int height = (iHeight - (gVar.getHeight() + iArr[1])) + ((int) baseTransientBottomBar.f9292i.getTranslationY());
            int i10 = baseTransientBottomBar.f9300q;
            if (height >= i10) {
                baseTransientBottomBar.f9301r = i10;
                return;
            }
            ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.f9292i.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.A, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            int i11 = baseTransientBottomBar.f9300q;
            baseTransientBottomBar.f9301r = i11;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = (i11 - height) + marginLayoutParams.bottomMargin;
            baseTransientBottomBar.f9292i.requestLayout();
        }
    }

    public class c implements x0.v {
        public c() {
        }

        @Override // x0.v
        public y0 onApplyWindowInsets(View view, y0 y0Var) {
            int systemWindowInsetBottom = y0Var.getSystemWindowInsetBottom();
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            baseTransientBottomBar.f9296m = systemWindowInsetBottom;
            baseTransientBottomBar.f9297n = y0Var.getSystemWindowInsetLeft();
            baseTransientBottomBar.f9298o = y0Var.getSystemWindowInsetRight();
            baseTransientBottomBar.c();
            return y0Var;
        }
    }

    public class d extends x0.a {
        public d() {
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.addAction(1048576);
            dVar.setDismissable(true);
        }

        @Override // x0.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 1048576) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            BaseTransientBottomBar.this.dismiss();
            return true;
        }
    }

    public class e implements g.b {
        public e() {
        }

        @Override // com.google.android.material.snackbar.g.b
        public void dismiss(int i10) {
            Handler handler = BaseTransientBottomBar.f9282y;
            handler.sendMessage(handler.obtainMessage(1, i10, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.g.b
        public void show() {
            Handler handler = BaseTransientBottomBar.f9282y;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public e f9310a;

        public f(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View view) {
            return view instanceof g;
        }

        public void onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.g.b().pauseTimeout(this.f9310a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.g.b().restoreTimeoutIfPaused(this.f9310a);
            }
        }

        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f9310a = baseTransientBottomBar.f9304u;
        }
    }

    public static class g extends FrameLayout {

        /* renamed from: w, reason: collision with root package name */
        public static final a f9311w = new a();

        /* renamed from: b, reason: collision with root package name */
        public BaseTransientBottomBar<?> f9312b;

        /* renamed from: m, reason: collision with root package name */
        public final l f9313m;

        /* renamed from: n, reason: collision with root package name */
        public int f9314n;

        /* renamed from: o, reason: collision with root package name */
        public final float f9315o;

        /* renamed from: p, reason: collision with root package name */
        public final float f9316p;

        /* renamed from: q, reason: collision with root package name */
        public final int f9317q;

        /* renamed from: r, reason: collision with root package name */
        public final int f9318r;

        /* renamed from: s, reason: collision with root package name */
        public ColorStateList f9319s;

        /* renamed from: t, reason: collision with root package name */
        public PorterDuff.Mode f9320t;

        /* renamed from: u, reason: collision with root package name */
        public Rect f9321u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f9322v;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public g(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            GradientDrawable gradientDrawable;
            Drawable drawableWrap;
            super(x7.a.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                j0.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f9314n = typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f9313m = l.builder(context2, attributeSet, 0, 0).build();
            }
            this.f9315o = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(t.parseTintMode(typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f9316p = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f9317q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.f9318r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f9311w);
            setFocusable(true);
            if (getBackground() == null) {
                int iLayer = c7.a.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
                l lVar = this.f9313m;
                if (lVar != null) {
                    p1.b bVar = BaseTransientBottomBar.f9279v;
                    q7.g gVar = new q7.g(lVar);
                    gVar.setFillColor(ColorStateList.valueOf(iLayer));
                    gradientDrawable = gVar;
                } else {
                    Resources resources = getResources();
                    p1.b bVar2 = BaseTransientBottomBar.f9279v;
                    float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(0);
                    gradientDrawable2.setCornerRadius(dimension);
                    gradientDrawable2.setColor(iLayer);
                    gradientDrawable = gradientDrawable2;
                }
                if (this.f9319s != null) {
                    drawableWrap = p0.a.wrap(gradientDrawable);
                    p0.a.setTintList(drawableWrap, this.f9319s);
                } else {
                    drawableWrap = p0.a.wrap(gradientDrawable);
                }
                j0.setBackground(this, drawableWrap);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f9312b = baseTransientBottomBar;
        }

        public float getActionTextColorAlpha() {
            return this.f9316p;
        }

        public int getAnimationMode() {
            return this.f9314n;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f9315o;
        }

        public int getMaxInlineActionWidth() {
            return this.f9318r;
        }

        public int getMaxWidth() {
            return this.f9317q;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9312b;
            if (baseTransientBottomBar != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    WindowInsets rootWindowInsets = baseTransientBottomBar.f9292i.getRootWindowInsets();
                    if (rootWindowInsets != null) {
                        baseTransientBottomBar.f9300q = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                        baseTransientBottomBar.c();
                    }
                } else {
                    baseTransientBottomBar.getClass();
                }
            }
            j0.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9312b;
            if (baseTransientBottomBar == null || !baseTransientBottomBar.isShownOrQueued()) {
                return;
            }
            BaseTransientBottomBar.f9282y.post(new s7.d(baseTransientBottomBar));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9312b;
            if (baseTransientBottomBar == null || !baseTransientBottomBar.f9302s) {
                return;
            }
            baseTransientBottomBar.b();
            baseTransientBottomBar.f9302s = false;
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int i12 = this.f9317q;
            if (i12 <= 0 || getMeasuredWidth() <= i12) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }

        public void setAnimationMode(int i10) {
            this.f9314n = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f9319s != null) {
                drawable = p0.a.wrap(drawable.mutate());
                p0.a.setTintList(drawable, this.f9319s);
                p0.a.setTintMode(drawable, this.f9320t);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f9319s = colorStateList;
            if (getBackground() != null) {
                Drawable drawableWrap = p0.a.wrap(getBackground().mutate());
                p0.a.setTintList(drawableWrap, colorStateList);
                p0.a.setTintMode(drawableWrap, this.f9320t);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f9320t = mode;
            if (getBackground() != null) {
                Drawable drawableWrap = p0.a.wrap(getBackground().mutate());
                p0.a.setTintMode(drawableWrap, mode);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f9322v || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.f9321u = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f9312b;
            if (baseTransientBottomBar != null) {
                p1.b bVar = BaseTransientBottomBar.f9279v;
                baseTransientBottomBar.c();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f9311w);
            super.setOnClickListener(onClickListener);
        }
    }

    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, s7.f fVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (fVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f9290g = viewGroup;
        this.f9293j = fVar;
        this.f9291h = context;
        r.checkAppCompatTheme(context);
        g gVar = (g) LayoutInflater.from(context).inflate(getSnackbarBaseLayoutResId(), viewGroup, false);
        this.f9292i = gVar;
        gVar.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            float actionTextColorAlpha = gVar.getActionTextColorAlpha();
            if (actionTextColorAlpha != 1.0f) {
                snackbarContentLayout.f9324m.setTextColor(c7.a.layer(c7.a.getColor(snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.f9324m.getCurrentTextColor(), actionTextColorAlpha));
            }
            snackbarContentLayout.setMaxInlineActionWidth(gVar.getMaxInlineActionWidth());
        }
        gVar.addView(view);
        j0.setAccessibilityLiveRegion(gVar, 1);
        j0.setImportantForAccessibility(gVar, 1);
        j0.setFitsSystemWindows(gVar, true);
        j0.setOnApplyWindowInsetsListener(gVar, new c());
        j0.setAccessibilityDelegate(gVar, new d());
        this.f9303t = (AccessibilityManager) context.getSystemService("accessibility");
        int i10 = R.attr.motionDurationLong2;
        this.f9286c = k7.g.resolveThemeDuration(context, i10, 250);
        this.f9284a = k7.g.resolveThemeDuration(context, i10, 150);
        this.f9285b = k7.g.resolveThemeDuration(context, R.attr.motionDurationMedium1, 75);
        int i11 = R.attr.motionEasingEmphasizedInterpolator;
        this.f9287d = k7.g.resolveThemeInterpolator(context, i11, f9280w);
        this.f9289f = k7.g.resolveThemeInterpolator(context, i11, f9281x);
        this.f9288e = k7.g.resolveThemeInterpolator(context, i11, f9279v);
    }

    public final void a() {
        com.google.android.material.snackbar.g.b().onDismissed(this.f9304u);
        g gVar = this.f9292i;
        ViewParent parent = gVar.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(gVar);
        }
    }

    public final void b() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z10 = true;
        AccessibilityManager accessibilityManager = this.f9303t;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z10 = false;
        }
        g gVar = this.f9292i;
        if (z10) {
            gVar.post(new com.google.android.material.snackbar.f(this));
            return;
        }
        if (gVar.getParent() != null) {
            gVar.setVisibility(0);
        }
        com.google.android.material.snackbar.g.b().onShown(this.f9304u);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            r9 = this;
            com.google.android.material.snackbar.BaseTransientBottomBar$g r0 = r9.f9292i
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            boolean r2 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            java.lang.String r3 = com.google.android.material.snackbar.BaseTransientBottomBar.A
            if (r2 != 0) goto L12
            java.lang.String r0 = "Unable to update margins because layout params are not MarginLayoutParams"
            android.util.Log.w(r3, r0)
            return
        L12:
            android.graphics.Rect r2 = r0.f9321u
            if (r2 != 0) goto L1c
            java.lang.String r0 = "Unable to update margins because original view margins are not set"
            android.util.Log.w(r3, r0)
            return
        L1c:
            android.view.ViewParent r2 = r0.getParent()
            if (r2 != 0) goto L23
            return
        L23:
            android.view.View r2 = r9.getAnchorView()
            if (r2 == 0) goto L2c
            int r2 = r9.f9299p
            goto L2e
        L2c:
            int r2 = r9.f9296m
        L2e:
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            android.graphics.Rect r3 = r0.f9321u
            int r4 = r3.bottom
            int r4 = r4 + r2
            int r2 = r3.left
            int r5 = r9.f9297n
            int r2 = r2 + r5
            int r5 = r3.right
            int r6 = r9.f9298o
            int r5 = r5 + r6
            int r3 = r3.top
            int r6 = r1.bottomMargin
            r7 = 1
            r8 = 0
            if (r6 != r4) goto L56
            int r6 = r1.leftMargin
            if (r6 != r2) goto L56
            int r6 = r1.rightMargin
            if (r6 != r5) goto L56
            int r6 = r1.topMargin
            if (r6 == r3) goto L54
            goto L56
        L54:
            r6 = 0
            goto L57
        L56:
            r6 = 1
        L57:
            if (r6 == 0) goto L64
            r1.bottomMargin = r4
            r1.leftMargin = r2
            r1.rightMargin = r5
            r1.topMargin = r3
            r0.requestLayout()
        L64:
            if (r6 != 0) goto L6c
            int r1 = r9.f9301r
            int r2 = r9.f9300q
            if (r1 == r2) goto L99
        L6c:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 < r2) goto L99
            int r1 = r9.f9300q
            if (r1 <= 0) goto L8e
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            boolean r2 = r1 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.f
            if (r2 == 0) goto L8a
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r1
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r1 = r1.getBehavior()
            boolean r1 = r1 instanceof com.google.android.material.behavior.SwipeDismissBehavior
            if (r1 == 0) goto L8a
            r1 = 1
            goto L8b
        L8a:
            r1 = 0
        L8b:
            if (r1 == 0) goto L8e
            goto L8f
        L8e:
            r7 = 0
        L8f:
            if (r7 == 0) goto L99
            com.google.android.material.snackbar.BaseTransientBottomBar$b r1 = r9.f9295l
            r0.removeCallbacks(r1)
            r0.post(r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.BaseTransientBottomBar.c():void");
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int i10) {
        com.google.android.material.snackbar.g.b().dismiss(this.f9304u, i10);
    }

    public View getAnchorView() {
        return null;
    }

    public int getDuration() {
        return this.f9294k;
    }

    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    public int getSnackbarBaseLayoutResId() {
        return hasSnackbarStyleAttr() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray typedArrayObtainStyledAttributes = this.f9291h.obtainStyledAttributes(f9283z);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public boolean isShownOrQueued() {
        return com.google.android.material.snackbar.g.b().isCurrentOrNext(this.f9304u);
    }

    public B setDuration(int i10) {
        this.f9294k = i10;
        return this;
    }

    public void show() {
        com.google.android.material.snackbar.g.b().show(getDuration(), this.f9304u);
    }
}
