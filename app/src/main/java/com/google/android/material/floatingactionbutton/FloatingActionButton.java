package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import i7.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p6.h;
import p6.k;
import q7.l;
import q7.p;
import x0.j0;

/* loaded from: classes.dex */
public final class FloatingActionButton extends u implements g7.a, p, CoordinatorLayout.b {

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f9119m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f9120n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f9121o;

    /* renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f9122p;

    /* renamed from: q, reason: collision with root package name */
    public ColorStateList f9123q;

    /* renamed from: r, reason: collision with root package name */
    public int f9124r;

    /* renamed from: s, reason: collision with root package name */
    public int f9125s;

    /* renamed from: t, reason: collision with root package name */
    public int f9126t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9127u;

    /* renamed from: v, reason: collision with root package name */
    public h7.d f9128v;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: b, reason: collision with root package name */
        public Rect f9129b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f9130m;

        public BaseBehavior() {
            this.f9130m = true;
        }

        public final boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.f9130m && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f9129b == null) {
                this.f9129b = new Rect();
            }
            Rect rect = this.f9129b;
            i7.b.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.c(null, false);
                return true;
            }
            floatingActionButton.e(null, false);
            return true;
        }

        public final boolean c(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.c(null, false);
                return true;
            }
            floatingActionButton.e(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.f2106h == 0) {
                fVar.f2106h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            floatingActionButton.getClass();
            floatingActionButton.getLeft();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                b(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).getBehavior() instanceof BottomSheetBehavior : false) {
                    c(view, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = dependencies.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).getBehavior() instanceof BottomSheetBehavior : false) && c(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (b(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i10);
            floatingActionButton.getClass();
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f9130m = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            super.onAttachedToLayoutParams(fVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class b implements p7.b {
        public b() {
        }

        public boolean isCompatPaddingEnabled() {
            return FloatingActionButton.this.f9127u;
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        public void setShadowPadding(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.getClass();
            throw null;
        }
    }

    public class c<T extends FloatingActionButton> implements d.e {
        public c(FloatingActionButton floatingActionButton) {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            ((c) obj).getClass();
            throw null;
        }

        public int hashCode() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.d.e
        public void onScaleChanged() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.d.e
        public void onTranslationChanged() {
            throw null;
        }
    }

    private d getImpl() {
        if (this.f9128v == null) {
            this.f9128v = new h7.d(this, new b());
        }
        return this.f9128v;
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().addOnHideAnimationListener(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.f9157n == null) {
            impl.f9157n = new ArrayList<>();
        }
        impl.f9157n.add(animatorListener);
    }

    public void addTransformationCallback(k<? extends FloatingActionButton> kVar) {
        d impl = getImpl();
        c cVar = new c(this);
        if (impl.f9159p == null) {
            impl.f9159p = new ArrayList<>();
        }
        impl.f9159p.add(cVar);
    }

    public final int b(int i10) {
        int i11 = this.f9125s;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        return i10 != -1 ? i10 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? b(1) : b(0);
    }

    public final void c(a aVar, boolean z10) {
        d impl = getImpl();
        com.google.android.material.floatingactionbutton.a aVar2 = aVar == null ? null : new com.google.android.material.floatingactionbutton.a(this, aVar);
        boolean z11 = false;
        if (impl.f9160q.getVisibility() != 0 ? impl.f9156m != 2 : impl.f9156m == 1) {
            return;
        }
        Animator animator = impl.f9150g;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton = impl.f9160q;
        if (j0.isLaidOut(floatingActionButton) && !floatingActionButton.isInEditMode()) {
            z11 = true;
        }
        if (!z11) {
            floatingActionButton.internalSetVisibility(z10 ? 8 : 4, z10);
            if (aVar2 != null) {
                aVar2.onHidden();
                return;
            }
            return;
        }
        h hVar = impl.f9152i;
        AnimatorSet animatorSetB = hVar != null ? impl.b(hVar, 0.0f, 0.0f, 0.0f) : impl.c(d.A, 0.0f, 0.4f, d.B, 0.4f);
        animatorSetB.addListener(new com.google.android.material.floatingactionbutton.b(impl, z10, aVar2));
        ArrayList<Animator.AnimatorListener> arrayList = impl.f9158o;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetB.addListener(it.next());
            }
        }
        animatorSetB.start();
    }

    public final void d() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f9121o;
        if (colorStateList == null) {
            p0.a.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f9122p;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.k.getPorterDuffColorFilter(colorForState, mode));
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().h(getDrawableState());
    }

    public final void e(a aVar, boolean z10) {
        d impl = getImpl();
        com.google.android.material.floatingactionbutton.a aVar2 = aVar == null ? null : new com.google.android.material.floatingactionbutton.a(this, aVar);
        if (impl.f9160q.getVisibility() == 0 ? impl.f9156m != 1 : impl.f9156m == 2) {
            return;
        }
        Animator animator = impl.f9150g;
        if (animator != null) {
            animator.cancel();
        }
        boolean z11 = impl.f9151h == null;
        FloatingActionButton floatingActionButton = impl.f9160q;
        boolean z12 = j0.isLaidOut(floatingActionButton) && !floatingActionButton.isInEditMode();
        Matrix matrix = impl.f9165v;
        if (!z12) {
            floatingActionButton.internalSetVisibility(0, z10);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.f9154k = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            if (aVar2 != null) {
                aVar2.onShown();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z11 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z11 ? 0.4f : 0.0f);
            float f10 = z11 ? 0.4f : 0.0f;
            impl.f9154k = f10;
            impl.a(f10, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
        h hVar = impl.f9151h;
        AnimatorSet animatorSetB = hVar != null ? impl.b(hVar, 1.0f, 1.0f, 1.0f) : impl.c(d.f9142y, 1.0f, 1.0f, d.f9143z, 1.0f);
        animatorSetB.addListener(new com.google.android.material.floatingactionbutton.c(impl, z10, aVar2));
        ArrayList<Animator.AnimatorListener> arrayList = impl.f9157n;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetB.addListener(it.next());
            }
        }
        animatorSetB.start();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f9119m;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f9120n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f9148e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f9149f;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    @Deprecated
    public boolean getContentRect(Rect rect) {
        if (!j0.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    public int getCustomSize() {
        return this.f9125s;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public h getHideMotionSpec() {
        return getImpl().f9152i;
    }

    public void getMeasuredContentRect(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        throw null;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f9123q;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f9123q;
    }

    public l getShapeAppearanceModel() {
        return (l) w0.h.checkNotNull(getImpl().f9144a);
    }

    public h getShowMotionSpec() {
        return getImpl().f9151h;
    }

    public int getSize() {
        return this.f9124r;
    }

    public int getSizeDimension() {
        return b(this.f9124r);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f9121o;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f9122p;
    }

    public boolean getUseCompatPadding() {
        return this.f9127u;
    }

    public void hide() {
        hide(null);
    }

    @Override // g7.a
    public boolean isExpanded() {
        throw null;
    }

    public boolean isOrWillBeHidden() {
        d impl = getImpl();
        if (impl.f9160q.getVisibility() == 0) {
            if (impl.f9156m == 1) {
                return true;
            }
        } else if (impl.f9156m != 2) {
            return true;
        }
        return false;
    }

    public boolean isOrWillBeShown() {
        d impl = getImpl();
        if (impl.f9160q.getVisibility() != 0) {
            if (impl.f9156m == 2) {
                return true;
            }
        } else if (impl.f9156m != 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().f();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        impl.getClass();
        if (!(impl instanceof h7.d)) {
            ViewTreeObserver viewTreeObserver = impl.f9160q.getViewTreeObserver();
            if (impl.f9166w == null) {
                impl.f9166w = new h7.c(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.f9166w);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f9160q.getViewTreeObserver();
        h7.c cVar = impl.f9166w;
        if (cVar != null) {
            viewTreeObserver.removeOnPreDrawListener(cVar);
            impl.f9166w = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        int i12 = (sizeDimension - this.f9126t) / 2;
        getImpl().n();
        Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        throw null;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof t7.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        t7.a aVar = (t7.a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        throw null;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new t7.a(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        getMeasuredContentRect(null);
        h7.d dVar = this.f9128v;
        if (!dVar.f9145b) {
            throw null;
        }
        Math.max((0 - dVar.f9160q.getSizeDimension()) / 2, 0);
        throw null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f9119m != colorStateList) {
            this.f9119m = colorStateList;
            getImpl().getClass();
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f9120n != mode) {
            this.f9120n = mode;
            getImpl().getClass();
        }
    }

    public void setCompatElevation(float f10) {
        d impl = getImpl();
        if (impl.f9147d != f10) {
            impl.f9147d = f10;
            impl.i(f10, impl.f9148e, impl.f9149f);
        }
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        d impl = getImpl();
        if (impl.f9148e != f10) {
            impl.f9148e = f10;
            impl.i(impl.f9147d, f10, impl.f9149f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        d impl = getImpl();
        if (impl.f9149f != f10) {
            impl.f9149f = f10;
            impl.i(impl.f9147d, impl.f9148e, f10);
        }
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i10 != this.f9125s) {
            this.f9125s = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().f9145b) {
            getImpl().f9145b = z10;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        throw null;
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().f9152i = hVar;
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.createFromResource(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            d impl = getImpl();
            float f10 = impl.f9154k;
            impl.f9154k = f10;
            Matrix matrix = impl.f9165v;
            impl.a(f10, matrix);
            impl.f9160q.setImageMatrix(matrix);
            if (this.f9121o != null) {
                d();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        throw null;
    }

    public void setMaxImageSize(int i10) {
        this.f9126t = i10;
        d impl = getImpl();
        if (impl.f9155l != i10) {
            impl.f9155l = i10;
            float f10 = impl.f9154k;
            impl.f9154k = f10;
            Matrix matrix = impl.f9165v;
            impl.a(f10, matrix);
            impl.f9160q.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        ArrayList<d.e> arrayList = getImpl().f9159p;
        if (arrayList != null) {
            Iterator<d.e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        ArrayList<d.e> arrayList = getImpl().f9159p;
        if (arrayList != null) {
            Iterator<d.e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    public void setShadowPaddingEnabled(boolean z10) {
        d impl = getImpl();
        impl.f9146c = z10;
        impl.n();
    }

    @Override // q7.p
    public void setShapeAppearanceModel(l lVar) {
        getImpl().f9144a = lVar;
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().f9151h = hVar;
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.createFromResource(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f9125s = 0;
        if (i10 != this.f9124r) {
            this.f9124r = i10;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f9121o != colorStateList) {
            this.f9121o = colorStateList;
            d();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f9122p != mode) {
            this.f9122p = mode;
            d();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().j();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().j();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().j();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f9127u != z10) {
            this.f9127u = z10;
            getImpl().g();
        }
    }

    @Override // i7.u, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void show() {
        show(null);
    }

    public void hide(a aVar) {
        c(aVar, true);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f9123q != colorStateList) {
            this.f9123q = colorStateList;
            getImpl().k();
        }
    }

    public void show(a aVar) {
        e(aVar, true);
    }

    public static abstract class a {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown(FloatingActionButton floatingActionButton) {
        }
    }
}
