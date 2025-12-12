package l7;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.c1;
import androidx.drawerlayout.widget.DrawerLayout;
import i7.h;
import i7.i;
import i7.m;
import i7.r;
import java.util.Objects;
import k7.f;
import q7.l;
import q7.q;
import w.g;
import x0.j0;
import x0.y0;

/* compiled from: NavigationView.java */
/* loaded from: classes.dex */
public class c extends m implements k7.b {
    public static final int[] I = {R.attr.state_checked};
    public static final int[] J = {-16842910};
    public static final int K = com.google.android.material.R.style.Widget_Design_NavigationView;
    public boolean A;
    public int B;
    public final boolean C;
    public final int D;
    public final q E;
    public final f F;
    public final k7.c G;
    public final a H;

    /* renamed from: s, reason: collision with root package name */
    public final h f15921s;

    /* renamed from: t, reason: collision with root package name */
    public final i f15922t;

    /* renamed from: u, reason: collision with root package name */
    public InterfaceC0189c f15923u;

    /* renamed from: v, reason: collision with root package name */
    public final int f15924v;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f15925w;

    /* renamed from: x, reason: collision with root package name */
    public g f15926x;

    /* renamed from: y, reason: collision with root package name */
    public l7.d f15927y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f15928z;

    /* compiled from: NavigationView.java */
    public class a extends DrawerLayout.h {
        public a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void onDrawerClosed(View view) {
            c cVar = c.this;
            if (view == cVar) {
                cVar.G.stopListeningForBackCallbacks();
                if (!cVar.C || cVar.B == 0) {
                    return;
                }
                cVar.B = 0;
                cVar.d(cVar.getWidth(), cVar.getHeight());
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void onDrawerOpened(View view) {
            c cVar = c.this;
            if (view == cVar) {
                k7.c cVar2 = cVar.G;
                Objects.requireNonNull(cVar2);
                view.post(new androidx.activity.d(cVar2, 13));
            }
        }
    }

    /* compiled from: NavigationView.java */
    /* renamed from: l7.c$c, reason: collision with other inner class name */
    public interface InterfaceC0189c {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    private MenuInflater getMenuInflater() {
        if (this.f15926x == null) {
            this.f15926x = new g(getContext());
        }
        return this.f15926x;
    }

    public final ColorStateList b(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = s.a.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = J;
        return new ColorStateList(new int[][]{iArr, I, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    public final InsetDrawable c(c1 c1Var, ColorStateList colorStateList) {
        q7.g gVar = new q7.g(l.builder(getContext(), c1Var.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), c1Var.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        gVar.setFillColor(colorStateList);
        return new InsetDrawable((Drawable) gVar, c1Var.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), c1Var.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), c1Var.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), c1Var.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    @Override // k7.b
    public void cancelBackProgress() {
        e();
        this.F.cancelBackProgress();
        if (!this.C || this.B == 0) {
            return;
        }
        this.B = 0;
        d(getWidth(), getHeight());
    }

    public final void d(int i10, int i11) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.f)) {
            if ((this.B > 0 || this.C) && (getBackground() instanceof q7.g)) {
                boolean z10 = x0.h.getAbsoluteGravity(((DrawerLayout.f) getLayoutParams()).f2574a, j0.getLayoutDirection(this)) == 3;
                q7.g gVar = (q7.g) getBackground();
                l.a allCornerSizes = gVar.getShapeAppearanceModel().toBuilder().setAllCornerSizes(this.B);
                if (z10) {
                    allCornerSizes.setTopLeftCornerSize(0.0f);
                    allCornerSizes.setBottomLeftCornerSize(0.0f);
                } else {
                    allCornerSizes.setTopRightCornerSize(0.0f);
                    allCornerSizes.setBottomRightCornerSize(0.0f);
                }
                l lVarBuild = allCornerSizes.build();
                gVar.setShapeAppearanceModel(lVarBuild);
                q qVar = this.E;
                qVar.onShapeAppearanceChanged(this, lVarBuild);
                qVar.onMaskChanged(this, new RectF(0.0f, 0.0f, i10, i11));
                qVar.setOffsetZeroCornerEdgeBoundsEnabled(this, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.E.maybeClip(canvas, new c1.c(this, 9));
    }

    public final Pair<DrawerLayout, DrawerLayout.f> e() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.f)) {
            return new Pair<>((DrawerLayout) parent, (DrawerLayout.f) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public f getBackHelper() {
        return this.F;
    }

    public MenuItem getCheckedItem() {
        return this.f15922t.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.f15922t.getDividerInsetEnd();
    }

    public int getDividerInsetStart() {
        return this.f15922t.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.f15922t.getHeaderCount();
    }

    public Drawable getItemBackground() {
        return this.f15922t.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.f15922t.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.f15922t.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.f15922t.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.f15922t.getItemMaxLines();
    }

    public ColorStateList getItemTextColor() {
        return this.f15922t.getItemTextColor();
    }

    public int getItemVerticalPadding() {
        return this.f15922t.getItemVerticalPadding();
    }

    public Menu getMenu() {
        return this.f15921s;
    }

    public int getSubheaderInsetEnd() {
        return this.f15922t.getSubheaderInsetEnd();
    }

    public int getSubheaderInsetStart() {
        return this.f15922t.getSubheaderInsetStart();
    }

    @Override // k7.b
    public void handleBackInvoked() {
        Pair<DrawerLayout, DrawerLayout.f> pairE = e();
        DrawerLayout drawerLayout = (DrawerLayout) pairE.first;
        f fVar = this.F;
        androidx.activity.b bVarOnHandleBackInvoked = fVar.onHandleBackInvoked();
        if (bVarOnHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.closeDrawer(this);
        } else {
            fVar.finishBackProgress(bVarOnHandleBackInvoked, ((DrawerLayout.f) pairE.second).f2574a, l7.b.getScrimCloseAnimatorListener(drawerLayout, this), l7.b.getScrimCloseAnimatorUpdateListener(drawerLayout));
        }
    }

    public View inflateHeaderView(int i10) {
        return this.f15922t.inflateHeaderView(i10);
    }

    public void inflateMenu(int i10) {
        i iVar = this.f15922t;
        iVar.setUpdateSuspended(true);
        getMenuInflater().inflate(i10, this.f15921s);
        iVar.setUpdateSuspended(false);
        iVar.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.A;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.f15928z;
    }

    @Override // i7.m, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q7.i.setParentAbsoluteElevation(this);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            k7.c cVar = this.G;
            if (cVar.shouldListenForBackCallbacks()) {
                DrawerLayout drawerLayout = (DrawerLayout) parent;
                a aVar = this.H;
                drawerLayout.removeDrawerListener(aVar);
                drawerLayout.addDrawerListener(aVar);
                if (drawerLayout.isDrawerOpen(this)) {
                    cVar.startListeningForBackCallbacksWithPriorityOverlay();
                }
            }
        }
    }

    @Override // i7.m, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f15927y);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).removeDrawerListener(this.H);
        }
    }

    @Override // i7.m
    public void onInsetsChanged(y0 y0Var) {
        this.f15922t.dispatchApplyWindowInsets(y0Var);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int i12 = this.f15924v;
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), i12), 1073741824);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.f15921s.restorePresenterStates(dVar.f15931n);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        dVar.f15931n = bundle;
        this.f15921s.savePresenterStates(bundle);
        return dVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        d(i10, i11);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.A = z10;
    }

    public void setCheckedItem(int i10) {
        MenuItem menuItemFindItem = this.f15921s.findItem(i10);
        if (menuItemFindItem != null) {
            this.f15922t.setCheckedItem((androidx.appcompat.view.menu.g) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i10) {
        this.f15922t.setDividerInsetEnd(i10);
    }

    public void setDividerInsetStart(int i10) {
        this.f15922t.setDividerInsetStart(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        q7.i.setElevation(this, f10);
    }

    public void setForceCompatClippingEnabled(boolean z10) {
        this.E.setForceCompatClippingEnabled(this, z10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f15922t.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        setItemBackground(m0.a.getDrawable(getContext(), i10));
    }

    public void setItemHorizontalPadding(int i10) {
        this.f15922t.setItemHorizontalPadding(i10);
    }

    public void setItemHorizontalPaddingResource(int i10) throws Resources.NotFoundException {
        this.f15922t.setItemHorizontalPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(int i10) {
        this.f15922t.setItemIconPadding(i10);
    }

    public void setItemIconPaddingResource(int i10) throws Resources.NotFoundException {
        this.f15922t.setItemIconPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(int i10) {
        this.f15922t.setItemIconSize(i10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f15922t.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.f15922t.setItemMaxLines(i10);
    }

    public void setItemTextAppearance(int i10) {
        this.f15922t.setItemTextAppearance(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f15922t.setItemTextAppearanceActiveBoldEnabled(z10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f15922t.setItemTextColor(colorStateList);
    }

    public void setItemVerticalPadding(int i10) {
        this.f15922t.setItemVerticalPadding(i10);
    }

    public void setItemVerticalPaddingResource(int i10) throws Resources.NotFoundException {
        this.f15922t.setItemVerticalPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setNavigationItemSelectedListener(InterfaceC0189c interfaceC0189c) {
        this.f15923u = interfaceC0189c;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        i iVar = this.f15922t;
        if (iVar != null) {
            iVar.setOverScrollMode(i10);
        }
    }

    public void setSubheaderInsetEnd(int i10) {
        this.f15922t.setSubheaderInsetEnd(i10);
    }

    public void setSubheaderInsetStart(int i10) {
        this.f15922t.setSubheaderInsetStart(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f15928z = z10;
    }

    @Override // k7.b
    public void startBackProgress(androidx.activity.b bVar) {
        e();
        this.F.startBackProgress(bVar);
    }

    @Override // k7.b
    public void updateBackProgress(androidx.activity.b bVar) {
        int i10 = ((DrawerLayout.f) e().second).f2574a;
        f fVar = this.F;
        fVar.updateBackProgress(bVar, i10);
        if (this.C) {
            this.B = p6.a.lerp(0, this.D, fVar.interpolateProgress(bVar.getProgress()));
            d(getWidth(), getHeight());
        }
    }

    /* compiled from: NavigationView.java */
    public static class d extends f1.a {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public Bundle f15931n;

        /* compiled from: NavigationView.java */
        public class a implements Parcelable.ClassLoaderCreator<d> {
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i10) {
                return new d[i10];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f15931n = parcel.readBundle(classLoader);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f15931n);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        int i12;
        int i13 = K;
        super(x7.a.wrap(context, attributeSet, i10, i13), attributeSet, i10);
        i iVar = new i();
        this.f15922t = iVar;
        this.f15925w = new int[2];
        this.f15928z = true;
        this.A = true;
        this.B = 0;
        this.E = q.create(this);
        this.F = new f(this);
        this.G = new k7.c(this);
        this.H = new a();
        Context context2 = getContext();
        h hVar = new h(context2);
        this.f15921s = hVar;
        c1 c1VarObtainTintedStyledAttributes = r.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i10, i13, new int[0]);
        int i14 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (c1VarObtainTintedStyledAttributes.hasValue(i14)) {
            j0.setBackground(this, c1VarObtainTintedStyledAttributes.getDrawable(i14));
        }
        int dimensionPixelSize = c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.B = dimensionPixelSize;
        this.C = dimensionPixelSize == 0;
        this.D = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListOrNull = e7.a.getColorStateListOrNull(background);
        if (background == null || colorStateListOrNull != null) {
            q7.g gVar = new q7.g(l.builder(context2, attributeSet, i10, i13).build());
            if (colorStateListOrNull != null) {
                gVar.setFillColor(colorStateListOrNull);
            }
            gVar.initializeElevationOverlay(context2);
            j0.setBackground(this, gVar);
        }
        if (c1VarObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(r2, 0));
        }
        setFitsSystemWindows(c1VarObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f15924v = c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int i15 = com.google.android.material.R.styleable.NavigationView_subheaderColor;
        ColorStateList colorStateList = c1VarObtainTintedStyledAttributes.hasValue(i15) ? c1VarObtainTintedStyledAttributes.getColorStateList(i15) : null;
        int i16 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance;
        int resourceId = c1VarObtainTintedStyledAttributes.hasValue(i16) ? c1VarObtainTintedStyledAttributes.getResourceId(i16, 0) : 0;
        if (resourceId == 0 && colorStateList == null) {
            colorStateList = b(R.attr.textColorSecondary);
        }
        int i17 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        ColorStateList colorStateList2 = c1VarObtainTintedStyledAttributes.hasValue(i17) ? c1VarObtainTintedStyledAttributes.getColorStateList(i17) : b(R.attr.textColorSecondary);
        int i18 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        int resourceId2 = c1VarObtainTintedStyledAttributes.hasValue(i18) ? c1VarObtainTintedStyledAttributes.getResourceId(i18, 0) : 0;
        boolean z10 = c1VarObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        int i19 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (c1VarObtainTintedStyledAttributes.hasValue(i19)) {
            setItemIconSize(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(i19, 0));
        }
        int i20 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        ColorStateList colorStateList3 = c1VarObtainTintedStyledAttributes.hasValue(i20) ? c1VarObtainTintedStyledAttributes.getColorStateList(i20) : null;
        if (resourceId2 == 0 && colorStateList3 == null) {
            colorStateList3 = b(R.attr.textColorPrimary);
        }
        Drawable drawable = c1VarObtainTintedStyledAttributes.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (drawable == null) {
            if (c1VarObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || c1VarObtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay)) {
                drawable = c(c1VarObtainTintedStyledAttributes, n7.c.getColorStateList(getContext(), c1VarObtainTintedStyledAttributes, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
                ColorStateList colorStateList4 = n7.c.getColorStateList(context2, c1VarObtainTintedStyledAttributes, com.google.android.material.R.styleable.NavigationView_itemRippleColor);
                if (colorStateList4 != null) {
                    iVar.setItemForeground(new RippleDrawable(o7.b.sanitizeRippleDrawableColor(colorStateList4), null, c(c1VarObtainTintedStyledAttributes, null)));
                }
            }
        }
        int i21 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (c1VarObtainTintedStyledAttributes.hasValue(i21)) {
            i11 = 0;
            setItemHorizontalPadding(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(i21, 0));
        } else {
            i11 = 0;
        }
        int i22 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding;
        if (c1VarObtainTintedStyledAttributes.hasValue(i22)) {
            setItemVerticalPadding(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(i22, i11));
        }
        setDividerInsetStart(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, i11));
        setDividerInsetEnd(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, i11));
        setSubheaderInsetStart(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, i11));
        setSubheaderInsetEnd(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, i11));
        setTopInsetScrimEnabled(c1VarObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.f15928z));
        setBottomInsetScrimEnabled(c1VarObtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.A));
        int dimensionPixelSize2 = c1VarObtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, i11);
        setItemMaxLines(c1VarObtainTintedStyledAttributes.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        hVar.setCallback(new b());
        iVar.setId(1);
        iVar.initForMenu(context2, hVar);
        if (resourceId != 0) {
            iVar.setSubheaderTextAppearance(resourceId);
        }
        iVar.setSubheaderColor(colorStateList);
        iVar.setItemIconTintList(colorStateList2);
        iVar.setOverScrollMode(getOverScrollMode());
        if (resourceId2 != 0) {
            iVar.setItemTextAppearance(resourceId2);
        }
        iVar.setItemTextAppearanceActiveBoldEnabled(z10);
        iVar.setItemTextColor(colorStateList3);
        iVar.setItemBackground(drawable);
        iVar.setItemIconPadding(dimensionPixelSize2);
        hVar.addMenuPresenter(iVar);
        addView((View) iVar.getMenuView(this));
        int i23 = com.google.android.material.R.styleable.NavigationView_menu;
        if (c1VarObtainTintedStyledAttributes.hasValue(i23)) {
            i12 = 0;
            inflateMenu(c1VarObtainTintedStyledAttributes.getResourceId(i23, 0));
        } else {
            i12 = 0;
        }
        int i24 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (c1VarObtainTintedStyledAttributes.hasValue(i24)) {
            inflateHeaderView(c1VarObtainTintedStyledAttributes.getResourceId(i24, i12));
        }
        c1VarObtainTintedStyledAttributes.recycle();
        this.f15927y = new l7.d(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f15927y);
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f15921s.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f15922t.setCheckedItem((androidx.appcompat.view.menu.g) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    /* compiled from: NavigationView.java */
    public class b implements e.a {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean onMenuItemSelected(e eVar, MenuItem menuItem) {
            InterfaceC0189c interfaceC0189c = c.this.f15923u;
            return interfaceC0189c != null && interfaceC0189c.onNavigationItemSelected(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void onMenuModeChange(e eVar) {
        }
    }
}
