package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f1;
import com.google.android.material.R;
import cz.msebera.android.httpclient.HttpStatus;
import i7.r;
import i7.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import t2.b;
import x0.j0;
import x0.k;
import x0.z;
import y0.d;

@b.InterfaceC0256b
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: i0, reason: collision with root package name */
    public static final int f9345i0 = R.style.Widget_Design_TabLayout;

    /* renamed from: j0, reason: collision with root package name */
    public static final w0.g f9346j0 = new w0.g(16);
    public int A;
    public final PorterDuff.Mode B;
    public final float C;
    public final float D;
    public final int E;
    public int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public int K;
    public final int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public boolean S;
    public com.google.android.material.tabs.a T;
    public final TimeInterpolator U;
    public c V;
    public final ArrayList<c> W;

    /* renamed from: a0, reason: collision with root package name */
    public i f9347a0;

    /* renamed from: b, reason: collision with root package name */
    public int f9348b;

    /* renamed from: b0, reason: collision with root package name */
    public ValueAnimator f9349b0;

    /* renamed from: c0, reason: collision with root package name */
    public t2.b f9350c0;

    /* renamed from: d0, reason: collision with root package name */
    public g f9351d0;

    /* renamed from: e0, reason: collision with root package name */
    public b f9352e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f9353f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f9354g0;

    /* renamed from: h0, reason: collision with root package name */
    public final w0.f f9355h0;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<f> f9356m;

    /* renamed from: n, reason: collision with root package name */
    public f f9357n;

    /* renamed from: o, reason: collision with root package name */
    public final e f9358o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9359p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9360q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9361r;

    /* renamed from: s, reason: collision with root package name */
    public final int f9362s;

    /* renamed from: t, reason: collision with root package name */
    public final int f9363t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9364u;

    /* renamed from: v, reason: collision with root package name */
    public final int f9365v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f9366w;

    /* renamed from: x, reason: collision with root package name */
    public ColorStateList f9367x;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f9368y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f9369z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements b.e {
        public b() {
        }

        @Override // t2.b.e
        public void onAdapterChanged(t2.b bVar, t2.a aVar, t2.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f9350c0 == bVar) {
                tabLayout.removeAllTabs();
            }
        }
    }

    @Deprecated
    public interface c<T extends f> {
        void onTabReselected(T t10);

        void onTabSelected(T t10);

        void onTabUnselected(T t10);
    }

    public interface d extends c<f> {
    }

    public class e extends LinearLayout {

        /* renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ int f9372o = 0;

        /* renamed from: b, reason: collision with root package name */
        public ValueAnimator f9373b;

        /* renamed from: m, reason: collision with root package name */
        public int f9374m;

        public e(Context context) {
            super(context);
            this.f9374m = -1;
            setWillNotDraw(false);
        }

        public final void a(int i10) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f9354g0 == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i10);
                com.google.android.material.tabs.a aVar = tabLayout.T;
                Drawable drawable = tabLayout.f9369z;
                aVar.getClass();
                RectF rectFA = com.google.android.material.tabs.a.a(tabLayout, childAt);
                drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
                tabLayout.f9348b = i10;
            }
        }

        public final void b(int i10) {
            TabLayout tabLayout = TabLayout.this;
            Rect bounds = tabLayout.f9369z.getBounds();
            tabLayout.f9369z.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        public final void c(View view, View view2, float f10) {
            if (view != null && view.getWidth() > 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.T.b(tabLayout, view, view2, f10, tabLayout.f9369z);
            } else {
                TabLayout tabLayout2 = TabLayout.this;
                Drawable drawable = tabLayout2.f9369z;
                drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout2.f9369z.getBounds().bottom);
            }
            j0.postInvalidateOnAnimation(this);
        }

        public final void d(int i10, int i11, boolean z10) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f9348b == i10) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                a(tabLayout.getSelectedTabPosition());
                return;
            }
            tabLayout.f9348b = i10;
            com.google.android.material.tabs.b bVar = new com.google.android.material.tabs.b(this, childAt, childAt2);
            if (!z10) {
                this.f9373b.removeAllUpdateListeners();
                this.f9373b.addUpdateListener(bVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f9373b = valueAnimator;
            valueAnimator.setInterpolator(tabLayout.U);
            valueAnimator.setDuration(i11);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(bVar);
            valueAnimator.start();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            TabLayout tabLayout = TabLayout.this;
            int iHeight = tabLayout.f9369z.getBounds().height();
            if (iHeight < 0) {
                iHeight = tabLayout.f9369z.getIntrinsicHeight();
            }
            int i10 = tabLayout.M;
            if (i10 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i10 != 1) {
                height = 0;
                if (i10 != 2) {
                    iHeight = i10 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (tabLayout.f9369z.getBounds().width() > 0) {
                Rect bounds = tabLayout.f9369z.getBounds();
                tabLayout.f9369z.setBounds(bounds.left, height, bounds.right, iHeight);
                tabLayout.f9369z.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f9373b;
            TabLayout tabLayout = TabLayout.this;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                d(tabLayout.getSelectedTabPosition(), -1, false);
                return;
            }
            if (tabLayout.f9348b == -1) {
                tabLayout.f9348b = tabLayout.getSelectedTabPosition();
            }
            a(tabLayout.f9348b);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z10 = true;
            if (tabLayout.K == 1 || tabLayout.N == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) t.dpToPx(getContext(), 16)) * 2)) {
                    boolean z11 = false;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z11 = true;
                        }
                    }
                    z10 = z11;
                } else {
                    tabLayout.K = 0;
                    tabLayout.h(false);
                }
                if (z10) {
                    super.onMeasure(i10, i11);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
            if (Build.VERSION.SDK_INT >= 23 || this.f9374m == i10) {
                return;
            }
            requestLayout();
            this.f9374m = i10;
        }
    }

    public static class g implements b.f {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f9385a;

        /* renamed from: b, reason: collision with root package name */
        public int f9386b;

        public g(TabLayout tabLayout) {
            this.f9385a = new WeakReference<>(tabLayout);
        }

        @Override // t2.b.f
        public void onPageScrollStateChanged(int i10) {
            this.f9386b = i10;
            TabLayout tabLayout = this.f9385a.get();
            if (tabLayout != null) {
                tabLayout.f9354g0 = this.f9386b;
            }
        }
    }

    public final class h extends LinearLayout {

        /* renamed from: w, reason: collision with root package name */
        public static final /* synthetic */ int f9387w = 0;

        /* renamed from: b, reason: collision with root package name */
        public f f9388b;

        /* renamed from: m, reason: collision with root package name */
        public TextView f9389m;

        /* renamed from: n, reason: collision with root package name */
        public ImageView f9390n;

        /* renamed from: o, reason: collision with root package name */
        public View f9391o;

        /* renamed from: p, reason: collision with root package name */
        public r6.a f9392p;

        /* renamed from: q, reason: collision with root package name */
        public View f9393q;

        /* renamed from: r, reason: collision with root package name */
        public TextView f9394r;

        /* renamed from: s, reason: collision with root package name */
        public ImageView f9395s;

        /* renamed from: t, reason: collision with root package name */
        public Drawable f9396t;

        /* renamed from: u, reason: collision with root package name */
        public int f9397u;

        public h(Context context) {
            super(context);
            this.f9397u = 2;
            d(context);
            j0.setPaddingRelative(this, TabLayout.this.f9359p, TabLayout.this.f9360q, TabLayout.this.f9361r, TabLayout.this.f9362s);
            setGravity(17);
            setOrientation(!TabLayout.this.O ? 1 : 0);
            setClickable(true);
            j0.setPointerIcon(this, z.getSystemIcon(getContext(), 1002));
        }

        private r6.a getBadge() {
            return this.f9392p;
        }

        private r6.a getOrCreateBadge() {
            if (this.f9392p == null) {
                this.f9392p = r6.a.create(getContext());
            }
            b();
            r6.a aVar = this.f9392p;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void a() {
            if (this.f9392p != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f9391o;
                if (view != null) {
                    r6.c.detachBadgeDrawable(this.f9392p, view);
                    this.f9391o = null;
                }
            }
        }

        public final void b() {
            f fVar;
            f fVar2;
            if (this.f9392p != null) {
                if (this.f9393q != null) {
                    a();
                    return;
                }
                if (this.f9390n != null && (fVar2 = this.f9388b) != null && fVar2.getIcon() != null) {
                    View view = this.f9391o;
                    ImageView imageView = this.f9390n;
                    if (view == imageView) {
                        c(imageView);
                        return;
                    }
                    a();
                    ImageView imageView2 = this.f9390n;
                    if ((this.f9392p != null) && imageView2 != null) {
                        setClipChildren(false);
                        setClipToPadding(false);
                        ViewGroup viewGroup = (ViewGroup) getParent();
                        if (viewGroup != null) {
                            viewGroup.setClipChildren(false);
                            viewGroup.setClipToPadding(false);
                        }
                        r6.c.attachBadgeDrawable(this.f9392p, imageView2, null);
                        this.f9391o = imageView2;
                        return;
                    }
                    return;
                }
                if (this.f9389m == null || (fVar = this.f9388b) == null || fVar.getTabLabelVisibility() != 1) {
                    a();
                    return;
                }
                View view2 = this.f9391o;
                TextView textView = this.f9389m;
                if (view2 == textView) {
                    c(textView);
                    return;
                }
                a();
                TextView textView2 = this.f9389m;
                if ((this.f9392p != null) && textView2 != null) {
                    setClipChildren(false);
                    setClipToPadding(false);
                    ViewGroup viewGroup2 = (ViewGroup) getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.setClipChildren(false);
                        viewGroup2.setClipToPadding(false);
                    }
                    r6.c.attachBadgeDrawable(this.f9392p, textView2, null);
                    this.f9391o = textView2;
                }
            }
        }

        public final void c(View view) {
            r6.a aVar = this.f9392p;
            if ((aVar != null) && view == this.f9391o) {
                r6.c.setBadgeDrawableBounds(aVar, view, null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.drawable.RippleDrawable] */
        public final void d(Context context) {
            TabLayout tabLayout = TabLayout.this;
            int i10 = tabLayout.E;
            if (i10 != 0) {
                Drawable drawable = s.a.getDrawable(context, i10);
                this.f9396t = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f9396t.setState(getDrawableState());
                }
            } else {
                this.f9396t = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (tabLayout.f9368y != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListConvertToRippleDrawableColor = o7.b.convertToRippleDrawableColor(tabLayout.f9368y);
                boolean z10 = tabLayout.S;
                if (z10) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(colorStateListConvertToRippleDrawableColor, gradientDrawable, z10 ? null : gradientDrawable2);
            }
            j0.setBackground(this, gradientDrawable);
            tabLayout.invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f9396t;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.f9396t.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e() {
            int i10;
            ViewParent parent;
            f fVar = this.f9388b;
            View customView = fVar != null ? fVar.getCustomView() : null;
            if (customView != null) {
                ViewParent parent2 = customView.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(customView);
                    }
                    View view = this.f9393q;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f9393q);
                    }
                    addView(customView);
                }
                this.f9393q = customView;
                TextView textView = this.f9389m;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f9390n;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f9390n.setImageDrawable(null);
                }
                TextView textView2 = (TextView) customView.findViewById(android.R.id.text1);
                this.f9394r = textView2;
                if (textView2 != null) {
                    this.f9397u = d1.i.getMaxLines(textView2);
                }
                this.f9395s = (ImageView) customView.findViewById(android.R.id.icon);
            } else {
                View view2 = this.f9393q;
                if (view2 != null) {
                    removeView(view2);
                    this.f9393q = null;
                }
                this.f9394r = null;
                this.f9395s = null;
            }
            if (this.f9393q == null) {
                if (this.f9390n == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f9390n = imageView2;
                    addView(imageView2, 0);
                }
                if (this.f9389m == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.f9389m = textView3;
                    addView(textView3);
                    this.f9397u = d1.i.getMaxLines(this.f9389m);
                }
                TextView textView4 = this.f9389m;
                TabLayout tabLayout = TabLayout.this;
                d1.i.setTextAppearance(textView4, tabLayout.f9363t);
                if (!isSelected() || (i10 = tabLayout.f9365v) == -1) {
                    d1.i.setTextAppearance(this.f9389m, tabLayout.f9364u);
                } else {
                    d1.i.setTextAppearance(this.f9389m, i10);
                }
                ColorStateList colorStateList = tabLayout.f9366w;
                if (colorStateList != null) {
                    this.f9389m.setTextColor(colorStateList);
                }
                f(this.f9389m, this.f9390n, true);
                b();
                ImageView imageView3 = this.f9390n;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new com.google.android.material.tabs.c(this, imageView3));
                }
                TextView textView5 = this.f9389m;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new com.google.android.material.tabs.c(this, textView5));
                }
            } else {
                TextView textView6 = this.f9394r;
                if (textView6 != null || this.f9395s != null) {
                    f(textView6, this.f9395s, false);
                }
            }
            if (fVar == null || TextUtils.isEmpty(fVar.f9378c)) {
                return;
            }
            setContentDescription(fVar.f9378c);
        }

        public final void f(TextView textView, ImageView imageView, boolean z10) {
            boolean z11;
            f fVar = this.f9388b;
            Drawable drawableMutate = (fVar == null || fVar.getIcon() == null) ? null : p0.a.wrap(this.f9388b.getIcon()).mutate();
            TabLayout tabLayout = TabLayout.this;
            if (drawableMutate != null) {
                p0.a.setTintList(drawableMutate, tabLayout.f9367x);
                PorterDuff.Mode mode = tabLayout.B;
                if (mode != null) {
                    p0.a.setTintMode(drawableMutate, mode);
                }
            }
            f fVar2 = this.f9388b;
            CharSequence text = fVar2 != null ? fVar2.getText() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z12 = !TextUtils.isEmpty(text);
            if (textView != null) {
                z11 = z12 && this.f9388b.f9381f == 1;
                textView.setText(z12 ? text : null);
                textView.setVisibility(z11 ? 0 : 8);
                if (z12) {
                    setVisibility(0);
                }
            } else {
                z11 = false;
            }
            if (z10 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iDpToPx = (z11 && imageView.getVisibility() == 0) ? (int) t.dpToPx(getContext(), 8) : 0;
                if (tabLayout.O) {
                    if (iDpToPx != k.getMarginEnd(marginLayoutParams)) {
                        k.setMarginEnd(marginLayoutParams, iDpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iDpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iDpToPx;
                    k.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.f9388b;
            CharSequence charSequence = fVar3 != null ? fVar3.f9378c : null;
            if (Build.VERSION.SDK_INT > 23) {
                if (!z12) {
                    text = charSequence;
                }
                f1.setTooltipText(this, text);
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.f9389m, this.f9390n, this.f9393q};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z10 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f9389m, this.f9390n, this.f9393q};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z10 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public f getTab() {
            return this.f9388b;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            y0.d dVarWrap = y0.d.wrap(accessibilityNodeInfo);
            r6.a aVar = this.f9392p;
            if (aVar != null && aVar.isVisible()) {
                dVarWrap.setContentDescription(this.f9392p.getContentDescription());
            }
            dVarWrap.setCollectionItemInfo(d.f.obtain(0, 1, this.f9388b.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                dVarWrap.setClickable(false);
                dVarWrap.removeAction(d.a.f21822g);
            }
            dVarWrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                int r0 = android.view.View.MeasureSpec.getSize(r8)
                int r1 = android.view.View.MeasureSpec.getMode(r8)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r3 = r2.getTabMaxWidth()
                if (r3 <= 0) goto L1c
                if (r1 == 0) goto L14
                if (r0 <= r3) goto L1c
            L14:
                int r8 = r2.F
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            L1c:
                super.onMeasure(r8, r9)
                android.widget.TextView r0 = r7.f9389m
                if (r0 == 0) goto L9e
                float r0 = r2.C
                int r1 = r7.f9397u
                android.widget.ImageView r3 = r7.f9390n
                r4 = 1
                if (r3 == 0) goto L34
                int r3 = r3.getVisibility()
                if (r3 != 0) goto L34
                r1 = 1
                goto L40
            L34:
                android.widget.TextView r3 = r7.f9389m
                if (r3 == 0) goto L40
                int r3 = r3.getLineCount()
                if (r3 <= r4) goto L40
                float r0 = r2.D
            L40:
                android.widget.TextView r3 = r7.f9389m
                float r3 = r3.getTextSize()
                android.widget.TextView r5 = r7.f9389m
                int r5 = r5.getLineCount()
                android.widget.TextView r6 = r7.f9389m
                int r6 = d1.i.getMaxLines(r6)
                int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r3 != 0) goto L5a
                if (r6 < 0) goto L9e
                if (r1 == r6) goto L9e
            L5a:
                int r2 = r2.N
                r6 = 0
                if (r2 != r4) goto L8f
                if (r3 <= 0) goto L8f
                if (r5 != r4) goto L8f
                android.widget.TextView r2 = r7.f9389m
                android.text.Layout r2 = r2.getLayout()
                if (r2 == 0) goto L8e
                float r3 = r2.getLineWidth(r6)
                android.text.TextPaint r2 = r2.getPaint()
                float r2 = r2.getTextSize()
                float r2 = r0 / r2
                float r2 = r2 * r3
                int r3 = r7.getMeasuredWidth()
                int r5 = r7.getPaddingLeft()
                int r3 = r3 - r5
                int r5 = r7.getPaddingRight()
                int r3 = r3 - r5
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L8f
            L8e:
                r4 = 0
            L8f:
                if (r4 == 0) goto L9e
                android.widget.TextView r2 = r7.f9389m
                r2.setTextSize(r6, r0)
                android.widget.TextView r0 = r7.f9389m
                r0.setMaxLines(r1)
                super.onMeasure(r8, r9)
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.h.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f9388b == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f9388b.select();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            if (isSelected() != z10) {
            }
            super.setSelected(z10);
            TextView textView = this.f9389m;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f9390n;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f9393q;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        public void setTab(f fVar) {
            if (fVar != this.f9388b) {
                this.f9388b = fVar;
                e();
                f fVar2 = this.f9388b;
                setSelected(fVar2 != null && fVar2.isSelected());
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    private int getDefaultHeight() {
        ArrayList<f> arrayList = this.f9356m;
        int size = arrayList.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                f fVar = arrayList.get(i10);
                if (fVar != null && fVar.getIcon() != null && !TextUtils.isEmpty(fVar.getText())) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        return (!z10 || this.O) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i10 = this.G;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.N;
        if (i11 == 0 || i11 == 2) {
            return this.I;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f9358o.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i10) {
        e eVar = this.f9358o;
        int childCount = eVar.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = eVar.getChildAt(i11);
                if ((i11 != i10 || childAt.isSelected()) && (i11 == i10 || !childAt.isSelected())) {
                    childAt.setSelected(i11 == i10);
                    childAt.setActivated(i11 == i10);
                } else {
                    childAt.setSelected(i11 == i10);
                    childAt.setActivated(i11 == i10);
                    if (childAt instanceof h) {
                        ((h) childAt).e();
                    }
                }
                i11++;
            }
        }
    }

    public final void a(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        f fVarNewTab = newTab();
        CharSequence charSequence = tabItem.f9342b;
        if (charSequence != null) {
            fVarNewTab.setText(charSequence);
        }
        Drawable drawable = tabItem.f9343m;
        if (drawable != null) {
            fVarNewTab.setIcon(drawable);
        }
        int i10 = tabItem.f9344n;
        if (i10 != 0) {
            fVarNewTab.setCustomView(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            fVarNewTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(fVarNewTab);
    }

    @Deprecated
    public void addOnTabSelectedListener(c cVar) {
        ArrayList<c> arrayList = this.W;
        if (arrayList.contains(cVar)) {
            return;
        }
        arrayList.add(cVar);
    }

    public void addTab(f fVar) {
        addTab(fVar, this.f9356m.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public final void b(int i10) {
        boolean z10;
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() != null && j0.isLaidOut(this)) {
            e eVar = this.f9358o;
            int childCount = eVar.getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    z10 = false;
                    break;
                } else {
                    if (eVar.getChildAt(i11).getWidth() <= 0) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
            if (!z10) {
                int scrollX = getScrollX();
                int iD = d(0.0f, i10);
                if (scrollX != iD) {
                    e();
                    this.f9349b0.setIntValues(scrollX, iD);
                    this.f9349b0.start();
                }
                ValueAnimator valueAnimator = eVar.f9373b;
                if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f9348b != i10) {
                    eVar.f9373b.cancel();
                }
                eVar.d(i10, this.L, true);
                return;
            }
        }
        setScrollPosition(i10, 0.0f, true);
    }

    public final void c() {
        int i10 = this.N;
        int iMax = (i10 == 0 || i10 == 2) ? Math.max(0, this.J - this.f9359p) : 0;
        e eVar = this.f9358o;
        j0.setPaddingRelative(eVar, iMax, 0, 0, 0);
        int i11 = this.N;
        if (i11 == 0) {
            int i12 = this.K;
            if (i12 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i12 == 1) {
                eVar.setGravity(1);
            } else if (i12 == 2) {
            }
            eVar.setGravity(8388611);
        } else if (i11 == 1 || i11 == 2) {
            if (this.K == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            eVar.setGravity(1);
        }
        h(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f createTabFromPool() {
        f fVar = (f) f9346j0.acquire();
        return fVar == null ? new f() : fVar;
    }

    public final int d(float f10, int i10) {
        e eVar;
        View childAt;
        int i11 = this.N;
        if ((i11 != 0 && i11 != 2) || (childAt = (eVar = this.f9358o).getChildAt(i10)) == null) {
            return 0;
        }
        int i12 = i10 + 1;
        View childAt2 = i12 < eVar.getChildCount() ? eVar.getChildAt(i12) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i13 = (int) ((width + width2) * 0.5f * f10);
        return j0.getLayoutDirection(this) == 0 ? left + i13 : left - i13;
    }

    public final void e() {
        if (this.f9349b0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f9349b0 = valueAnimator;
            valueAnimator.setInterpolator(this.U);
            this.f9349b0.setDuration(this.L);
            this.f9349b0.addUpdateListener(new a());
        }
    }

    public final void f(int i10, float f10, boolean z10, boolean z11, boolean z12) {
        float f11 = i10 + f10;
        int iRound = Math.round(f11);
        if (iRound >= 0) {
            e eVar = this.f9358o;
            if (iRound >= eVar.getChildCount()) {
                return;
            }
            if (z11) {
                eVar.getClass();
                TabLayout.this.f9348b = Math.round(f11);
                ValueAnimator valueAnimator = eVar.f9373b;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    eVar.f9373b.cancel();
                }
                eVar.c(eVar.getChildAt(i10), eVar.getChildAt(i10 + 1), f10);
            }
            ValueAnimator valueAnimator2 = this.f9349b0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f9349b0.cancel();
            }
            int iD = d(f10, i10);
            int scrollX = getScrollX();
            boolean z13 = (i10 < getSelectedTabPosition() && iD >= scrollX) || (i10 > getSelectedTabPosition() && iD <= scrollX) || i10 == getSelectedTabPosition();
            if (j0.getLayoutDirection(this) == 1) {
                z13 = (i10 < getSelectedTabPosition() && iD <= scrollX) || (i10 > getSelectedTabPosition() && iD >= scrollX) || i10 == getSelectedTabPosition();
            }
            if (z13 || this.f9354g0 == 1 || z12) {
                if (i10 < 0) {
                    iD = 0;
                }
                scrollTo(iD, 0);
            }
            if (z10) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void g(t2.b bVar, boolean z10, boolean z11) {
        t2.b bVar2 = this.f9350c0;
        if (bVar2 != null) {
            g gVar = this.f9351d0;
            if (gVar != null) {
                bVar2.removeOnPageChangeListener(gVar);
            }
            b bVar3 = this.f9352e0;
            if (bVar3 != null) {
                this.f9350c0.removeOnAdapterChangeListener(bVar3);
            }
        }
        c cVar = this.f9347a0;
        if (cVar != null) {
            removeOnTabSelectedListener(cVar);
            this.f9347a0 = null;
        }
        if (bVar != null) {
            this.f9350c0 = bVar;
            if (this.f9351d0 == null) {
                this.f9351d0 = new g(this);
            }
            g gVar2 = this.f9351d0;
            gVar2.f9386b = 0;
            gVar2.getClass();
            bVar.addOnPageChangeListener(gVar2);
            i iVar = new i(bVar);
            this.f9347a0 = iVar;
            addOnTabSelectedListener(iVar);
            bVar.getAdapter();
            if (this.f9352e0 == null) {
                this.f9352e0 = new b();
            }
            b.e eVar = this.f9352e0;
            eVar.getClass();
            bVar.addOnAdapterChangeListener(eVar);
            setScrollPosition(bVar.getCurrentItem(), 0.0f, true);
        } else {
            this.f9350c0 = null;
            removeAllTabs();
        }
        this.f9353f0 = z11;
    }

    public int getSelectedTabPosition() {
        f fVar = this.f9357n;
        if (fVar != null) {
            return fVar.getPosition();
        }
        return -1;
    }

    public f getTabAt(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f9356m.get(i10);
    }

    public int getTabCount() {
        return this.f9356m.size();
    }

    public int getTabGravity() {
        return this.K;
    }

    public ColorStateList getTabIconTint() {
        return this.f9367x;
    }

    public int getTabIndicatorAnimationMode() {
        return this.R;
    }

    public int getTabIndicatorGravity() {
        return this.M;
    }

    public int getTabMaxWidth() {
        return this.F;
    }

    public int getTabMode() {
        return this.N;
    }

    public ColorStateList getTabRippleColor() {
        return this.f9368y;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f9369z;
    }

    public ColorStateList getTabTextColors() {
        return this.f9366w;
    }

    public final void h(boolean z10) {
        int i10 = 0;
        while (true) {
            e eVar = this.f9358o;
            if (i10 >= eVar.getChildCount()) {
                return;
            }
            View childAt = eVar.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.N == 1 && this.K == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z10) {
                childAt.requestLayout();
            }
            i10++;
        }
    }

    public boolean isTabIndicatorFullWidth() {
        return this.P;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f newTab() {
        f fVarCreateTabFromPool = createTabFromPool();
        fVarCreateTabFromPool.f9382g = this;
        w0.f fVar = this.f9355h0;
        h hVar = fVar != null ? (h) fVar.acquire() : null;
        if (hVar == null) {
            hVar = new h(getContext());
        }
        hVar.setTab(fVarCreateTabFromPool);
        hVar.setFocusable(true);
        hVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVarCreateTabFromPool.f9378c)) {
            hVar.setContentDescription(fVarCreateTabFromPool.f9377b);
        } else {
            hVar.setContentDescription(fVarCreateTabFromPool.f9378c);
        }
        fVarCreateTabFromPool.f9383h = hVar;
        int i10 = fVarCreateTabFromPool.f9384i;
        if (i10 != -1) {
            hVar.setId(i10);
        }
        return fVarCreateTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q7.i.setParentAbsoluteElevation(this);
        if (this.f9350c0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof t2.b) {
                g((t2.b) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f9353f0) {
            setupWithViewPager(null);
            this.f9353f0 = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        h hVar;
        Drawable drawable;
        int i10 = 0;
        while (true) {
            e eVar = this.f9358o;
            if (i10 >= eVar.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = eVar.getChildAt(i10);
            if ((childAt instanceof h) && (drawable = (hVar = (h) childAt).f9396t) != null) {
                drawable.setBounds(hVar.getLeft(), hVar.getTop(), hVar.getRight(), hVar.getBottom());
                hVar.f9396t.draw(canvas);
            }
            i10++;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        y0.d.wrap(accessibilityNodeInfo).setCollectionInfo(d.e.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = i7.t.dpToPx(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.H
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = i7.t.dpToPx(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.F = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.N
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8) {
            if (!(getTabMode() == 0 || getTabMode() == 2)) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean releaseFromTabPool(f fVar) {
        return f9346j0.release(fVar);
    }

    public void removeAllTabs() {
        e eVar = this.f9358o;
        for (int childCount = eVar.getChildCount() - 1; childCount >= 0; childCount--) {
            h hVar = (h) eVar.getChildAt(childCount);
            eVar.removeViewAt(childCount);
            if (hVar != null) {
                hVar.setTab(null);
                hVar.setSelected(false);
                this.f9355h0.release(hVar);
            }
            requestLayout();
        }
        Iterator<f> it = this.f9356m.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.f9382g = null;
            next.f9383h = null;
            next.f9376a = null;
            next.f9384i = -1;
            next.f9377b = null;
            next.f9378c = null;
            next.f9379d = -1;
            next.f9380e = null;
            releaseFromTabPool(next);
        }
        this.f9357n = null;
    }

    @Deprecated
    public void removeOnTabSelectedListener(c cVar) {
        this.W.remove(cVar);
    }

    public void selectTab(f fVar) {
        selectTab(fVar, true);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        q7.i.setElevation(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.O == z10) {
            return;
        }
        this.O = z10;
        int i10 = 0;
        while (true) {
            e eVar = this.f9358o;
            if (i10 >= eVar.getChildCount()) {
                c();
                return;
            }
            View childAt = eVar.getChildAt(i10);
            if (childAt instanceof h) {
                h hVar = (h) childAt;
                hVar.setOrientation(!TabLayout.this.O ? 1 : 0);
                TextView textView = hVar.f9394r;
                if (textView == null && hVar.f9395s == null) {
                    hVar.f(hVar.f9389m, hVar.f9390n, true);
                } else {
                    hVar.f(textView, hVar.f9395s, false);
                }
            }
            i10++;
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        e();
        this.f9349b0.addListener(animatorListener);
    }

    public void setScrollPosition(int i10, float f10, boolean z10) {
        setScrollPosition(i10, f10, z10, true);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = p0.a.wrap(drawable).mutate();
        this.f9369z = drawableMutate;
        e7.a.setTint(drawableMutate, this.A);
        int intrinsicHeight = this.Q;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.f9369z.getIntrinsicHeight();
        }
        this.f9358o.b(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.A = i10;
        e7.a.setTint(this.f9369z, i10);
        h(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.M != i10) {
            this.M = i10;
            j0.postInvalidateOnAnimation(this.f9358o);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.Q = i10;
        this.f9358o.b(i10);
    }

    public void setTabGravity(int i10) {
        if (this.K != i10) {
            this.K = i10;
            c();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f9367x != colorStateList) {
            this.f9367x = colorStateList;
            ArrayList<f> arrayList = this.f9356m;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                h hVar = arrayList.get(i10).f9383h;
                if (hVar != null) {
                    hVar.e();
                    f fVar = hVar.f9388b;
                    hVar.setSelected(fVar != null && fVar.isSelected());
                }
            }
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(s.a.getColorStateList(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.R = i10;
        if (i10 == 0) {
            this.T = new com.google.android.material.tabs.a();
            return;
        }
        int i11 = 1;
        if (i10 == 1) {
            this.T = new u7.a(0);
        } else {
            if (i10 == 2) {
                this.T = new u7.a(i11);
                return;
            }
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.P = z10;
        int i10 = e.f9372o;
        e eVar = this.f9358o;
        eVar.a(TabLayout.this.getSelectedTabPosition());
        j0.postInvalidateOnAnimation(eVar);
    }

    public void setTabMode(int i10) {
        if (i10 != this.N) {
            this.N = i10;
            c();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f9368y == colorStateList) {
            return;
        }
        this.f9368y = colorStateList;
        int i10 = 0;
        while (true) {
            e eVar = this.f9358o;
            if (i10 >= eVar.getChildCount()) {
                return;
            }
            View childAt = eVar.getChildAt(i10);
            if (childAt instanceof h) {
                Context context = getContext();
                int i11 = h.f9387w;
                ((h) childAt).d(context);
            }
            i10++;
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(s.a.getColorStateList(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f9366w != colorStateList) {
            this.f9366w = colorStateList;
            ArrayList<f> arrayList = this.f9356m;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                h hVar = arrayList.get(i10).f9383h;
                if (hVar != null) {
                    hVar.e();
                    f fVar = hVar.f9388b;
                    hVar.setSelected(fVar != null && fVar.isSelected());
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(t2.a aVar) {
        removeAllTabs();
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.S == z10) {
            return;
        }
        this.S = z10;
        int i10 = 0;
        while (true) {
            e eVar = this.f9358o;
            if (i10 >= eVar.getChildCount()) {
                return;
            }
            View childAt = eVar.getChildAt(i10);
            if (childAt instanceof h) {
                Context context = getContext();
                int i11 = h.f9387w;
                ((h) childAt).d(context);
            }
            i10++;
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(t2.b bVar) {
        setupWithViewPager(bVar, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f9345i0;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f9348b = -1;
        this.f9356m = new ArrayList<>();
        this.f9365v = -1;
        this.A = 0;
        this.F = Integer.MAX_VALUE;
        this.Q = -1;
        this.W = new ArrayList<>();
        this.f9355h0 = new w0.f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context2);
        this.f9358o = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R.styleable.TabLayout;
        int i12 = R.styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context2, attributeSet, iArr, i10, i11, i12);
        ColorStateList colorStateListOrNull = e7.a.getColorStateListOrNull(getBackground());
        if (colorStateListOrNull != null) {
            q7.g gVar = new q7.g();
            gVar.setFillColor(colorStateListOrNull);
            gVar.initializeElevationOverlay(context2);
            gVar.setElevation(j0.getElevation(this));
            j0.setBackground(this, gVar);
        }
        setSelectedTabIndicator(n7.c.getDrawable(context2, typedArrayObtainStyledAttributes, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        eVar.b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayObtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f9362s = dimensionPixelSize;
        this.f9361r = dimensionPixelSize;
        this.f9360q = dimensionPixelSize;
        this.f9359p = dimensionPixelSize;
        this.f9359p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f9360q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, dimensionPixelSize);
        this.f9361r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, dimensionPixelSize);
        this.f9362s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, dimensionPixelSize);
        if (r.isMaterial3Theme(context2)) {
            this.f9363t = R.attr.textAppearanceTitleSmall;
        } else {
            this.f9363t = R.attr.textAppearanceButton;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(i12, R.style.TextAppearance_Design_Tab);
        this.f9364u = resourceId;
        int[] iArr2 = androidx.appcompat.R.styleable.TextAppearance;
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, iArr2);
        try {
            int i13 = androidx.appcompat.R.styleable.TextAppearance_android_textSize;
            float dimensionPixelSize2 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(i13, 0);
            this.C = dimensionPixelSize2;
            int i14 = androidx.appcompat.R.styleable.TextAppearance_android_textColor;
            this.f9366w = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes2, i14);
            typedArrayObtainStyledAttributes2.recycle();
            int i15 = R.styleable.TabLayout_tabSelectedTextAppearance;
            if (typedArrayObtainStyledAttributes.hasValue(i15)) {
                this.f9365v = typedArrayObtainStyledAttributes.getResourceId(i15, resourceId);
            }
            int i16 = this.f9365v;
            if (i16 != -1) {
                typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(i16, iArr2);
                try {
                    typedArrayObtainStyledAttributes2.getDimensionPixelSize(i13, (int) dimensionPixelSize2);
                    ColorStateList colorStateList = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes2, i14);
                    if (colorStateList != null) {
                        this.f9366w = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(new int[]{android.R.attr.state_selected}, colorStateList.getDefaultColor()), this.f9366w.getDefaultColor()});
                    }
                } finally {
                }
            }
            int i17 = R.styleable.TabLayout_tabTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i17)) {
                this.f9366w = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, i17);
            }
            int i18 = R.styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayObtainStyledAttributes.hasValue(i18)) {
                this.f9366w = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{typedArrayObtainStyledAttributes.getColor(i18, 0), this.f9366w.getDefaultColor()});
            }
            this.f9367x = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, R.styleable.TabLayout_tabIconTint);
            this.B = t.parseTintMode(typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.f9368y = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, R.styleable.TabLayout_tabRippleColor);
            this.L = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, HttpStatus.SC_MULTIPLE_CHOICES);
            this.U = k7.g.resolveThemeInterpolator(context2, R.attr.motionEasingEmphasizedInterpolator, p6.a.f17605b);
            this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.E = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.N = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            this.K = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.O = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.S = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayObtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.D = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.I = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            c();
        } finally {
        }
    }

    public void addTab(f fVar, boolean z10) {
        addTab(fVar, this.f9356m.size(), z10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        a(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void selectTab(f fVar, boolean z10) {
        f fVar2 = this.f9357n;
        ArrayList<c> arrayList = this.W;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    arrayList.get(size).onTabReselected(fVar);
                }
                b(fVar.getPosition());
                return;
            }
            return;
        }
        int position = fVar != null ? fVar.getPosition() : -1;
        if (z10) {
            if ((fVar2 == null || fVar2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                b(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.f9357n = fVar;
        if (fVar2 != null && fVar2.f9382g != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                arrayList.get(size2).onTabUnselected(fVar2);
            }
        }
        if (fVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                arrayList.get(size3).onTabSelected(fVar);
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.V;
        if (cVar2 != null) {
            removeOnTabSelectedListener(cVar2);
        }
        this.V = cVar;
        if (cVar != null) {
            addOnTabSelectedListener(cVar);
        }
    }

    public void setScrollPosition(int i10, float f10, boolean z10, boolean z11) {
        f(i10, f10, z10, z11, true);
    }

    public void setupWithViewPager(t2.b bVar, boolean z10) {
        g(bVar, z10, false);
    }

    public void addTab(f fVar, int i10, boolean z10) {
        if (fVar.f9382g == this) {
            fVar.f9379d = i10;
            ArrayList<f> arrayList = this.f9356m;
            arrayList.add(i10, fVar);
            int size = arrayList.size();
            int i11 = -1;
            for (int i12 = i10 + 1; i12 < size; i12++) {
                if (arrayList.get(i12).getPosition() == this.f9348b) {
                    i11 = i12;
                }
                arrayList.get(i12).f9379d = i12;
            }
            this.f9348b = i11;
            h hVar = fVar.f9383h;
            hVar.setSelected(false);
            hVar.setActivated(false);
            int position = fVar.getPosition();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (this.N == 1 && this.K == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            this.f9358o.addView(hVar, position, layoutParams);
            if (z10) {
                fVar.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f9376a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f9377b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f9378c;

        /* renamed from: e, reason: collision with root package name */
        public View f9380e;

        /* renamed from: g, reason: collision with root package name */
        public TabLayout f9382g;

        /* renamed from: h, reason: collision with root package name */
        public h f9383h;

        /* renamed from: d, reason: collision with root package name */
        public int f9379d = -1;

        /* renamed from: f, reason: collision with root package name */
        public final int f9381f = 1;

        /* renamed from: i, reason: collision with root package name */
        public int f9384i = -1;

        public View getCustomView() {
            return this.f9380e;
        }

        public Drawable getIcon() {
            return this.f9376a;
        }

        public int getPosition() {
            return this.f9379d;
        }

        public int getTabLabelVisibility() {
            return this.f9381f;
        }

        public CharSequence getText() {
            return this.f9377b;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.f9382g;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.f9379d;
        }

        public void select() {
            TabLayout tabLayout = this.f9382g;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.selectTab(this);
        }

        public f setContentDescription(CharSequence charSequence) {
            this.f9378c = charSequence;
            h hVar = this.f9383h;
            if (hVar != null) {
                hVar.e();
                f fVar = hVar.f9388b;
                hVar.setSelected(fVar != null && fVar.isSelected());
            }
            return this;
        }

        public f setCustomView(View view) {
            this.f9380e = view;
            h hVar = this.f9383h;
            if (hVar != null) {
                hVar.e();
                f fVar = hVar.f9388b;
                hVar.setSelected(fVar != null && fVar.isSelected());
            }
            return this;
        }

        public f setIcon(Drawable drawable) {
            this.f9376a = drawable;
            TabLayout tabLayout = this.f9382g;
            if (tabLayout.K == 1 || tabLayout.N == 2) {
                tabLayout.h(true);
            }
            h hVar = this.f9383h;
            if (hVar != null) {
                hVar.e();
                f fVar = hVar.f9388b;
                hVar.setSelected(fVar != null && fVar.isSelected());
            }
            return this;
        }

        public f setText(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f9378c) && !TextUtils.isEmpty(charSequence)) {
                this.f9383h.setContentDescription(charSequence);
            }
            this.f9377b = charSequence;
            h hVar = this.f9383h;
            if (hVar != null) {
                hVar.e();
                f fVar = hVar.f9388b;
                hVar.setSelected(fVar != null && fVar.isSelected());
            }
            return this;
        }

        public f setCustomView(int i10) {
            return setCustomView(LayoutInflater.from(this.f9383h.getContext()).inflate(i10, (ViewGroup) this.f9383h, false));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(s.a.getDrawable(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public static class i implements d {

        /* renamed from: a, reason: collision with root package name */
        public final t2.b f9399a;

        public i(t2.b bVar) {
            this.f9399a = bVar;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(f fVar) {
            this.f9399a.setCurrentItem(fVar.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(f fVar) {
        }
    }
}
