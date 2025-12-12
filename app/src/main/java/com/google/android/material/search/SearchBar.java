package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import i7.s;
import q7.i;
import x0.j0;

/* loaded from: classes.dex */
public final class SearchBar extends Toolbar {

    /* renamed from: i0, reason: collision with root package name */
    public Drawable f9243i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f9244j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f9245k0;

    public static class a extends f1.a {
        public static final Parcelable.Creator<a> CREATOR = new C0089a();

        /* renamed from: n, reason: collision with root package name */
        public String f9247n;

        /* renamed from: com.google.android.material.search.SearchBar$a$a, reason: collision with other inner class name */
        public class C0089a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i10) {
                return new a[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        }

        public a(Parcel parcel) {
            this(parcel, null);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f9247n);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9247n = parcel.readString();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void setNavigationIconDecorative(boolean z10) {
        ImageButton navigationIconButton = s.getNavigationIconButton(this);
        if (navigationIconButton == null) {
            return;
        }
        navigationIconButton.setClickable(!z10);
        navigationIconButton.setFocusable(!z10);
        Drawable background = navigationIconButton.getBackground();
        if (background != null) {
            this.f9243i0 = background;
        }
        navigationIconButton.setBackgroundDrawable(z10 ? null : this.f9243i0);
        q();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
    }

    public View getCenterView() {
        return null;
    }

    public float getCompatElevation() {
        return j0.getElevation(this);
    }

    public float getCornerSize() {
        throw null;
    }

    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    public CharSequence getHint() {
        throw null;
    }

    public int getMenuResId() {
        return this.f9244j0;
    }

    public int getStrokeColor() {
        throw null;
    }

    public float getStrokeWidth() {
        throw null;
    }

    public CharSequence getText() {
        throw null;
    }

    public TextView getTextView() {
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i10) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof e;
        if (z10) {
            ((e) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i10);
        this.f9244j0 = i10;
        if (z10) {
            ((e) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.setParentAbsoluteElevation(this, null);
        r();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        int i10 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        if (i10 >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (zIsEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        q();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setText(aVar.f9247n);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        CharSequence text = getText();
        aVar.f9247n = text == null ? null : text.toString();
        return aVar;
    }

    public final void q() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z10 = getLayoutDirection() == 1;
        ImageButton navigationIconButton = s.getNavigationIconButton(this);
        int width = (navigationIconButton == null || !navigationIconButton.isClickable()) ? 0 : z10 ? getWidth() - navigationIconButton.getLeft() : navigationIconButton.getRight();
        ActionMenuView actionMenuView = s.getActionMenuView(this);
        int right = actionMenuView != null ? z10 ? actionMenuView.getRight() : getWidth() - actionMenuView.getLeft() : 0;
        float f10 = -(z10 ? right : width);
        if (!z10) {
            width = right;
        }
        setHandwritingBoundsOffsets(f10, 0.0f, -width, 0.0f);
    }

    public final void r() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.f9245k0) {
                if (eVar.getScrollFlags() == 0) {
                    eVar.setScrollFlags(53);
                }
            } else if (eVar.getScrollFlags() == 53) {
                eVar.setScrollFlags(0);
            }
        }
    }

    public void setCenterView(View view) {
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f9245k0 = z10;
        r();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
    }

    public void setHint(CharSequence charSequence) {
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        throw null;
    }

    public void setStrokeColor(int i10) {
        if (getStrokeColor() == i10) {
            return;
        }
        ColorStateList.valueOf(i10);
        throw null;
    }

    public void setStrokeWidth(float f10) {
        if (getStrokeWidth() != f10) {
            throw null;
        }
    }

    public void setText(CharSequence charSequence) {
        throw null;
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: r, reason: collision with root package name */
        public boolean f9246r;

        public ScrollingViewBehavior() {
            this.f9246r = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) throws Resources.NotFoundException {
            boolean zOnDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.f9246r && (view2 instanceof AppBarLayout)) {
                this.f9246r = true;
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                appBarLayout.setBackgroundColor(0);
                if (Build.VERSION.SDK_INT == 21) {
                    appBarLayout.setOutlineProvider(null);
                } else {
                    appBarLayout.setTargetElevation(0.0f);
                }
            }
            return zOnDependentViewChanged;
        }

        @Override // q6.d
        public boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9246r = false;
        }
    }

    public void setHint(int i10) {
        throw null;
    }

    public void setText(int i10) {
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
