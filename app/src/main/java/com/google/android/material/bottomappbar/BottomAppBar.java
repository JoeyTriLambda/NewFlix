package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cz.msebera.android.httpclient.HttpStatus;
import i7.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import k7.g;
import q7.i;
import s6.d;
import s6.e;
import x0.j0;

/* loaded from: classes.dex */
public final class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: u0, reason: collision with root package name */
    public static final int f8808u0 = R.attr.motionDurationLong2;

    /* renamed from: v0, reason: collision with root package name */
    public static final int f8809v0 = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: i0, reason: collision with root package name */
    public Integer f8810i0;

    /* renamed from: j0, reason: collision with root package name */
    public Animator f8811j0;

    /* renamed from: k0, reason: collision with root package name */
    public Animator f8812k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f8813l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f8814m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f8815n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f8816o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f8817p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f8818q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f8819r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f8820s0;

    /* renamed from: t0, reason: collision with root package name */
    public Behavior f8821t0;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final a A;

        /* renamed from: x, reason: collision with root package name */
        public final Rect f8822x;

        /* renamed from: y, reason: collision with root package name */
        public WeakReference<BottomAppBar> f8823y;

        /* renamed from: z, reason: collision with root package name */
        public int f8824z;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                Behavior behavior = Behavior.this;
                BottomAppBar bottomAppBar = behavior.f8823y.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    Rect rect = behavior.f8822x;
                    floatingActionButton.getMeasuredContentRect(rect);
                    int iHeight = rect.height();
                    bottomAppBar.x(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new RectF(rect)));
                    height = iHeight;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (behavior.f8824z == 0) {
                    if (bottomAppBar.f8815n0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (t.isLayoutRtl(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += 0;
                    }
                }
                int i18 = BottomAppBar.f8808u0;
                bottomAppBar.w();
                throw null;
            }
        }

        public Behavior() {
            this.A = new a();
            this.f8822x = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            this.f8823y = new WeakReference<>(bottomAppBar);
            int i11 = BottomAppBar.f8808u0;
            View viewT = bottomAppBar.t();
            if (viewT == null || j0.isLaidOut(viewT)) {
                coordinatorLayout.onLayoutChild(bottomAppBar, i10);
                return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i10);
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewT.getLayoutParams();
            fVar.f2102d = 17;
            int i12 = bottomAppBar.f8815n0;
            if (i12 == 1) {
                fVar.f2102d = 49;
            }
            if (i12 == 0) {
                fVar.f2102d |= 80;
            }
            this.f8824z = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewT.getLayoutParams())).bottomMargin;
            if (viewT instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) viewT;
                if (floatingActionButton.getShowMotionSpec() == null) {
                    floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                }
                if (floatingActionButton.getHideMotionSpec() == null) {
                    floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                }
                floatingActionButton.addOnHideAnimationListener(null);
                floatingActionButton.addOnShowAnimationListener(new d(bottomAppBar));
                floatingActionButton.addTransformationCallback(null);
            }
            viewT.addOnLayoutChangeListener(this.A);
            bottomAppBar.w();
            throw null;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.A = new a();
            this.f8822x = new Rect();
        }
    }

    public class a extends FloatingActionButton.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8826a;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$a$a, reason: collision with other inner class name */
        public class C0083a extends FloatingActionButton.a {
            public C0083a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
            public void onShown(FloatingActionButton floatingActionButton) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                int i10 = BottomAppBar.f8808u0;
                bottomAppBar.getClass();
            }
        }

        public a(int i10) {
            this.f8826a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public void onHidden(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.u(this.f8826a));
            floatingActionButton.show(new C0083a());
        }
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f8829b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f8830m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f8831n;

        public b(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f8829b = actionMenuView;
            this.f8830m = i10;
            this.f8831n = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f8830m;
            boolean z10 = this.f8831n;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            this.f8829b.setTranslationX(bottomAppBar.getActionMenuViewTranslationX(r3, i10, z10));
        }
    }

    public static class c extends f1.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public int f8833n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f8834o;

        public class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i10) {
                return new c[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8833n);
            parcel.writeInt(this.f8834o ? 1 : 0);
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8833n = parcel.readInt();
            this.f8834o = parcel.readInt() != 0;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return 0;
    }

    private int getFabAlignmentAnimationDuration() {
        return g.resolveThemeDuration(getContext(), f8808u0, HttpStatus.SC_MULTIPLE_CHOICES);
    }

    private float getFabTranslationX() {
        return u(this.f8813l0);
    }

    private float getFabTranslationY() {
        if (this.f8815n0 == 1) {
            return -getTopEdgeTreatment().f19113n;
        }
        return t() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return 0;
    }

    private e getTopEdgeTreatment() {
        throw null;
    }

    public void createFabDefaultXAnimation(int i10, List<Animator> list) {
        View viewT = t();
        FloatingActionButton floatingActionButton = viewT instanceof FloatingActionButton ? (FloatingActionButton) viewT : null;
        if (floatingActionButton == null || floatingActionButton.isOrWillBeHidden()) {
            return;
        }
        floatingActionButton.hide(new a(i10));
    }

    public int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i10, boolean z10) throws Resources.NotFoundException {
        int dimensionPixelOffset;
        if (this.f8817p0 != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean zIsLayoutRtl = t.isLayoutRtl(this);
        int measuredWidth = zIsLayoutRtl ? getMeasuredWidth() : 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f18154a & 8388615) == 8388611) {
                measuredWidth = zIsLayoutRtl ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zIsLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft();
        if (getNavigationIcon() == null) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            if (!zIsLayoutRtl) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
        } else {
            dimensionPixelOffset = 0;
        }
        return measuredWidth - ((right + 0) + dimensionPixelOffset);
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f19113n;
    }

    public int getFabAlignmentMode() {
        return this.f8813l0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f8816o0;
    }

    public int getFabAnchorMode() {
        return this.f8815n0;
    }

    public int getFabAnimationMode() {
        return this.f8814m0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f19112m;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f19111b;
    }

    public boolean getHideOnScroll() {
        return this.f8818q0;
    }

    public int getMenuAlignmentMode() {
        return this.f8817p0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.setParentAbsoluteElevation(this, null);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            Animator animator = this.f8812k0;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.f8811j0;
            if (animator2 != null) {
                animator2.cancel();
            }
            w();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f8812k0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (v()) {
            y(actionMenuView, this.f8813l0, this.f8820s0, false);
        } else {
            y(actionMenuView, 0, false, false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f8813l0 = cVar.f8833n;
        this.f8820s0 = cVar.f8834o;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f8833n = this.f8813l0;
        cVar.f8834o = this.f8820s0;
        return cVar;
    }

    public void replaceMenu(int i10) {
        if (i10 != 0) {
            this.f8819r0 = 0;
            getMenu().clear();
            inflateMenu(i10);
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        p0.a.setTintList(null, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            e topEdgeTreatment = getTopEdgeTreatment();
            if (f10 >= 0.0f) {
                topEdgeTreatment.f19113n = f10;
                throw null;
            }
            topEdgeTreatment.getClass();
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        throw null;
    }

    public void setFabAlignmentMode(int i10) {
        setFabAlignmentModeAndReplaceMenu(i10, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i10, int i11) {
        int i12;
        this.f8819r0 = i11;
        boolean z10 = this.f8820s0;
        if (j0.isLaidOut(this)) {
            Animator animator = this.f8812k0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (v()) {
                i12 = i10;
            } else {
                z10 = false;
                i12 = 0;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                objectAnimatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
                if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i12, z10)) > 1.0f) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    objectAnimatorOfFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                    objectAnimatorOfFloat2.addListener(new s6.c(this, actionMenuView, i12, z10));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(objectAnimatorOfFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.f8812k0 = animatorSet2;
            animatorSet2.addListener(new s6.b(this));
            this.f8812k0.start();
        } else {
            replaceMenu(this.f8819r0);
        }
        if (this.f8813l0 != i10 && j0.isLaidOut(this)) {
            Animator animator2 = this.f8811j0;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.f8814m0 == 1) {
                View viewT = t();
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewT instanceof FloatingActionButton ? (FloatingActionButton) viewT : null, "translationX", u(i10));
                objectAnimatorOfFloat3.setDuration(getFabAlignmentAnimationDuration());
                arrayList2.add(objectAnimatorOfFloat3);
            } else {
                createFabDefaultXAnimation(i10, arrayList2);
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            animatorSet3.setInterpolator(g.resolveThemeInterpolator(getContext(), f8809v0, p6.a.f17604a));
            this.f8811j0 = animatorSet3;
            animatorSet3.addListener(new s6.a(this));
            this.f8811j0.start();
        }
        this.f8813l0 = i10;
    }

    public void setFabAlignmentModeEndMargin(int i10) {
        if (this.f8816o0 == i10) {
            return;
        }
        this.f8816o0 = i10;
        w();
        throw null;
    }

    public void setFabAnchorMode(int i10) {
        this.f8815n0 = i10;
        w();
        throw null;
    }

    public void setFabAnimationMode(int i10) {
        this.f8814m0 = i10;
    }

    public void setFabCornerSize(float f10) {
        if (f10 == getTopEdgeTreatment().a()) {
            return;
        }
        getTopEdgeTreatment().c(f10);
        throw null;
    }

    public void setFabCradleMargin(float f10) {
        if (f10 == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().f19112m = f10;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().f19111b = f10;
        throw null;
    }

    public void setHideOnScroll(boolean z10) {
        this.f8818q0 = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f8817p0 != i10) {
            this.f8817p0 = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                y(actionMenuView, this.f8813l0, v(), false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f8810i0 != null) {
            drawable = p0.a.wrap(drawable.mutate());
            p0.a.setTint(drawable, this.f8810i0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i10) {
        this.f8810i0 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public final View t() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public final float u(int i10) {
        boolean zIsLayoutRtl = t.isLayoutRtl(this);
        if (i10 != 1) {
            return 0.0f;
        }
        View viewT = t();
        int measuredWidth = 0;
        if (this.f8816o0 != -1 && viewT != null) {
            measuredWidth = 0 + (viewT.getMeasuredWidth() / 2) + this.f8816o0;
        }
        return ((getMeasuredWidth() / 2) - measuredWidth) * (zIsLayoutRtl ? -1 : 1);
    }

    public final boolean v() {
        View viewT = t();
        FloatingActionButton floatingActionButton = viewT instanceof FloatingActionButton ? (FloatingActionButton) viewT : null;
        return floatingActionButton != null && floatingActionButton.isOrWillBeShown();
    }

    public final void w() {
        e topEdgeTreatment = getTopEdgeTreatment();
        getFabTranslationX();
        topEdgeTreatment.getClass();
        if (this.f8820s0) {
            v();
        }
        throw null;
    }

    public final void x(int i10) {
        float f10 = i10;
        if (f10 == getTopEdgeTreatment().b()) {
            return;
        }
        getTopEdgeTreatment().d(f10);
        throw null;
    }

    public final void y(ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        b bVar = new b(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(bVar);
        } else {
            bVar.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f8821t0 == null) {
            this.f8821t0 = new Behavior();
        }
        return this.f8821t0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
