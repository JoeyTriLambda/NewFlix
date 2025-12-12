package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import p6.h;
import x0.j0;

/* loaded from: classes.dex */
public final class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: b, reason: collision with root package name */
        public Rect f9116b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f9117m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f9118n;

        public ExtendedFloatingActionButtonBehavior() {
            this.f9117m = false;
            this.f9118n = true;
        }

        public final boolean a(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f9117m || this.f9118n) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f9116b == null) {
                this.f9116b = new Rect();
            }
            Rect rect = this.f9116b;
            i7.b.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        public final boolean c(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        public void extendOrShow(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f9118n ? 3 : 0);
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.f2106h == 0) {
                fVar.f2106h = 80;
            }
        }

        public void shrinkOrHide(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton.e(extendedFloatingActionButton, this.f9118n ? 2 : 1);
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                b(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).getBehavior() instanceof BottomSheetBehavior : false) {
                    c(view, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = dependencies.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).getBehavior() instanceof BottomSheetBehavior : false) && c(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (b(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i10);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f9117m = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f9118n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a extends Property<View, Float> {
        public a() {
            super(Float.class, "width");
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public void set(View view, Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    public class b extends Property<View, Float> {
        public b() {
            super(Float.class, "height");
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public void set(View view, Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    public class c extends Property<View, Float> {
        public c() {
            super(Float.class, "paddingStart");
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(j0.getPaddingStart(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f10) {
            j0.setPaddingRelative(view, f10.intValue(), view.getPaddingTop(), j0.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    public class d extends Property<View, Float> {
        public d() {
            super(Float.class, "paddingEnd");
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(j0.getPaddingEnd(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f10) {
            j0.setPaddingRelative(view, j0.getPaddingStart(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    static {
        new a();
        new b();
        new c();
        new d();
    }

    public static void e(ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
        extendedFloatingActionButton.getClass();
        if (i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
            throw new IllegalStateException(ac.c.f("Unknown strategy type: ", i10));
        }
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return 0;
    }

    public h getExtendMotionSpec() {
        throw null;
    }

    public h getHideMotionSpec() {
        throw null;
    }

    public h getShowMotionSpec() {
        throw null;
    }

    public h getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setExtendMotionSpec(h hVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i10) {
        setExtendMotionSpec(h.createFromResource(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        if (z10) {
            throw null;
        }
    }

    public void setHideMotionSpec(h hVar) {
        throw null;
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.createFromResource(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
    }

    public void setShowMotionSpec(h hVar) {
        throw null;
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.createFromResource(getContext(), i10));
    }

    public void setShrinkMotionSpec(h hVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i10) {
        setShrinkMotionSpec(h.createFromResource(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        getTextColors();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getTextColors();
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
    }
}
