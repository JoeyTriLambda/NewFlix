package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.f1;
import androidx.appcompat.widget.m0;
import d1.i;
import i7.e;
import x0.j0;
import y0.d;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends e implements j.a {
    public static final int[] R = {R.attr.state_checked};
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public final CheckedTextView K;
    public FrameLayout L;
    public g M;
    public ColorStateList N;
    public boolean O;
    public Drawable P;
    public final a Q;

    public class a extends x0.a {
        public a() {
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.setCheckable(NavigationMenuItemView.this.I);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.L == null) {
                this.L = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.L.removeAllViews();
            this.L.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.M;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void initialize(g gVar, int i10) throws Resources.NotFoundException {
        StateListDrawable stateListDrawable;
        this.M = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(R, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            j0.setBackground(this, stateListDrawable);
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        f1.setTooltipText(this, gVar.getTooltipText());
        boolean z10 = this.M.getTitle() == null && this.M.getIcon() == null && this.M.getActionView() != null;
        CheckedTextView checkedTextView = this.K;
        if (z10) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.L;
            if (frameLayout != null) {
                m0.a aVar = (m0.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.L.setLayoutParams(aVar);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.L;
        if (frameLayout2 != null) {
            m0.a aVar2 = (m0.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.L.setLayoutParams(aVar2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        g gVar = this.M;
        if (gVar != null && gVar.isCheckable() && this.M.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, R);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.K.setCompoundDrawables(null, null, null, null);
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.I != z10) {
            this.I = z10;
            this.Q.sendAccessibilityEvent(this.K, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.K;
        checkedTextView.setChecked(z10);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z10 && this.J) ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        if (drawable != null) {
            if (this.O) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = p0.a.wrap(drawable).mutate();
                p0.a.setTintList(drawable, this.N);
            }
            int i10 = this.G;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.H) {
            if (this.P == null) {
                Drawable drawable2 = n0.g.getDrawable(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.P = drawable2;
                if (drawable2 != null) {
                    int i11 = this.G;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.P;
        }
        i.setCompoundDrawablesRelative(this.K, drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.K.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.G = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) throws Resources.NotFoundException {
        this.N = colorStateList;
        this.O = colorStateList != null;
        g gVar = this.M;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.K.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.H = z10;
    }

    public void setTextAppearance(int i10) {
        i.setTextAppearance(this.K, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.K.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.K.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.J = true;
        a aVar = new a();
        this.Q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.K = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        j0.setAccessibilityDelegate(checkedTextView, aVar);
    }

    public void initialize(g gVar, boolean z10) throws Resources.NotFoundException {
        this.J = z10;
        initialize(gVar, 0);
    }
}
