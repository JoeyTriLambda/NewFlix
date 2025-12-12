package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.m0;

/* loaded from: classes.dex */
public class ActionMenuView extends m0 implements e.b, androidx.appcompat.view.menu.j {
    public androidx.appcompat.view.menu.e A;
    public Context B;
    public int C;
    public boolean D;
    public androidx.appcompat.widget.c E;
    public i.a F;
    public e.a G;
    public boolean H;
    public int I;
    public final int J;
    public final int K;
    public e L;

    public interface a {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class c extends m0.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1105a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1106b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1107c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1108d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1109e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1110f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f1105a = cVar.f1105a;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f1105a = false;
        }
    }

    public class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.L;
            return eVar2 != null && ((Toolbar.a) eVar2).onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.G;
            if (aVar != null) {
                aVar.onMenuModeChange(eVar);
            }
        }
    }

    public interface e {
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.m0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public void dismissPopupMenus() {
        androidx.appcompat.widget.c cVar = this.E;
        if (cVar != null) {
            cVar.dismissPopupMenus();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public c generateOverflowButtonLayoutParams() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f1105a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.A == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.A = eVar;
            eVar.setCallback(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.E = cVar;
            cVar.setReserveOverflow(true);
            androidx.appcompat.widget.c cVar2 = this.E;
            i.a bVar = this.F;
            if (bVar == null) {
                bVar = new b();
            }
            cVar2.setCallback(bVar);
            this.A.addMenuPresenter(this.E, this.B);
            this.E.setMenuView(this);
        }
        return this.A;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.E.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.C;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hasSupportDividerBeforeChildAt(int i10) {
        boolean zNeedsDividerAfter = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            zNeedsDividerAfter = false | ((a) childAt).needsDividerAfter();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? zNeedsDividerAfter : zNeedsDividerAfter | ((a) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        androidx.appcompat.widget.c cVar = this.E;
        return cVar != null && cVar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.view.menu.j
    public void initialize(androidx.appcompat.view.menu.e eVar) {
        this.A = eVar;
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean invokeItem(androidx.appcompat.view.menu.g gVar) {
        return this.A.performItemAction(gVar, 0);
    }

    public boolean isOverflowMenuShowPending() {
        androidx.appcompat.widget.c cVar = this.E;
        return cVar != null && cVar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        androidx.appcompat.widget.c cVar = this.E;
        return cVar != null && cVar.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.D;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.E;
        if (cVar != null) {
            cVar.updateMenuView(false);
            if (this.E.isOverflowMenuShowing()) {
                this.E.hideOverflowMenu();
                this.E.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.m0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        if (!this.H) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i12 - i10;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean zIsLayoutRtl = k1.isLayoutRtl(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1105a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zIsLayoutRtl) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    hasSupportDividerBeforeChildAt(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int iMax = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (zIsLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1105a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1105a) {
                int i27 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax + i27;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v31 */
    @Override // androidx.appcompat.widget.m0, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        boolean z11;
        int i14;
        int i15;
        int i16;
        ?? r42;
        int i17;
        int i18;
        int i19;
        androidx.appcompat.view.menu.e eVar;
        boolean z12 = this.H;
        boolean z13 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.H = z13;
        if (z12 != z13) {
            this.I = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.H && (eVar = this.A) != null && size != this.I) {
            this.I = size;
            eVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.H || childCount <= 0) {
            for (int i20 = 0; i20 < childCount; i20++) {
                c cVar = (c) getChildAt(i20).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i10);
        int size3 = View.MeasureSpec.getSize(i11);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingBottom, -2);
        int i21 = size2 - paddingRight;
        int i22 = this.J;
        int i23 = i21 / i22;
        int i24 = i21 % i22;
        if (i23 == 0) {
            setMeasuredDimension(i21, 0);
            return;
        }
        int i25 = (i24 / i23) + i22;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i26 = 0;
        int iMax2 = 0;
        int i27 = 0;
        boolean z14 = false;
        long j10 = 0;
        int i28 = 0;
        while (true) {
            i12 = this.K;
            if (i27 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i27);
            int i29 = size3;
            int i30 = i21;
            if (childAt.getVisibility() == 8) {
                i17 = mode;
                i18 = paddingBottom;
            } else {
                boolean z15 = childAt instanceof ActionMenuItemView;
                int i31 = i26 + 1;
                if (z15) {
                    childAt.setPadding(i12, 0, i12, 0);
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f1110f = false;
                cVar2.f1107c = 0;
                cVar2.f1106b = 0;
                cVar2.f1108d = false;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = 0;
                cVar2.f1109e = z15 && ((ActionMenuItemView) childAt).hasText();
                int i32 = cVar2.f1105a ? 1 : i23;
                c cVar3 = (c) childAt.getLayoutParams();
                i17 = mode;
                i18 = paddingBottom;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z15 ? (ActionMenuItemView) childAt : null;
                boolean z16 = actionMenuItemView != null && actionMenuItemView.hasText();
                if (i32 <= 0 || (z16 && i32 < 2)) {
                    i19 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i32 * i25, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i19 = measuredWidth / i25;
                    if (measuredWidth % i25 != 0) {
                        i19++;
                    }
                    if (z16 && i19 < 2) {
                        i19 = 2;
                    }
                }
                cVar3.f1108d = !cVar3.f1105a && z16;
                cVar3.f1106b = i19;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i25 * i19, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i19);
                if (cVar2.f1108d) {
                    i28++;
                }
                if (cVar2.f1105a) {
                    z14 = true;
                }
                i23 -= i19;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i19 == 1) {
                    j10 |= 1 << i27;
                }
                i26 = i31;
            }
            i27++;
            size3 = i29;
            i21 = i30;
            paddingBottom = i18;
            mode = i17;
        }
        int i33 = mode;
        int i34 = i21;
        int i35 = size3;
        boolean z17 = z14 && i26 == 2;
        boolean z18 = false;
        while (i28 > 0 && i23 > 0) {
            int i36 = Integer.MAX_VALUE;
            int i37 = 0;
            int i38 = 0;
            long j11 = 0;
            while (i38 < childCount2) {
                c cVar4 = (c) getChildAt(i38).getLayoutParams();
                boolean z19 = z18;
                if (cVar4.f1108d) {
                    int i39 = cVar4.f1106b;
                    if (i39 < i36) {
                        j11 = 1 << i38;
                        i36 = i39;
                        i37 = 1;
                    } else if (i39 == i36) {
                        j11 |= 1 << i38;
                        i37++;
                    }
                }
                i38++;
                z18 = z19;
            }
            z10 = z18;
            j10 |= j11;
            if (i37 > i23) {
                break;
            }
            int i40 = i36 + 1;
            int i41 = 0;
            while (i41 < childCount2) {
                View childAt2 = getChildAt(i41);
                c cVar5 = (c) childAt2.getLayoutParams();
                int i42 = iMax;
                int i43 = childMeasureSpec;
                int i44 = childCount2;
                long j12 = 1 << i41;
                if ((j11 & j12) != 0) {
                    if (z17 && cVar5.f1109e) {
                        r42 = 1;
                        r42 = 1;
                        if (i23 == 1) {
                            childAt2.setPadding(i12 + i25, 0, i12, 0);
                        }
                    } else {
                        r42 = 1;
                    }
                    cVar5.f1106b += r42;
                    cVar5.f1110f = r42;
                    i23--;
                } else if (cVar5.f1106b == i40) {
                    j10 |= j12;
                }
                i41++;
                childMeasureSpec = i43;
                iMax = i42;
                childCount2 = i44;
            }
            z18 = true;
        }
        z10 = z18;
        int i45 = iMax;
        int i46 = childMeasureSpec;
        int i47 = childCount2;
        boolean z20 = !z14 && i26 == 1;
        if (i23 <= 0 || j10 == 0 || (i23 >= i26 - 1 && !z20 && iMax2 <= 1)) {
            i13 = i47;
            z11 = z10;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (!z20) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1109e) {
                    fBitCount -= 0.5f;
                }
                int i48 = i47 - 1;
                if ((j10 & (1 << i48)) != 0 && !((c) getChildAt(i48).getLayoutParams()).f1109e) {
                    fBitCount -= 0.5f;
                }
            }
            int i49 = fBitCount > 0.0f ? (int) ((i23 * i25) / fBitCount) : 0;
            boolean z21 = z10;
            i13 = i47;
            for (int i50 = 0; i50 < i13; i50++) {
                if ((j10 & (1 << i50)) != 0) {
                    View childAt3 = getChildAt(i50);
                    c cVar6 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar6.f1107c = i49;
                        cVar6.f1110f = true;
                        if (i50 == 0 && !cVar6.f1109e) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = (-i49) / 2;
                        }
                    } else if (cVar6.f1105a) {
                        cVar6.f1107c = i49;
                        cVar6.f1110f = true;
                        ((LinearLayout.LayoutParams) cVar6).rightMargin = (-i49) / 2;
                    } else {
                        if (i50 != 0) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = i49 / 2;
                        }
                        if (i50 != i13 - 1) {
                            ((LinearLayout.LayoutParams) cVar6).rightMargin = i49 / 2;
                        }
                    }
                    z21 = true;
                }
            }
            z11 = z21;
        }
        if (z11) {
            int i51 = 0;
            while (i51 < i13) {
                View childAt4 = getChildAt(i51);
                c cVar7 = (c) childAt4.getLayoutParams();
                if (cVar7.f1110f) {
                    i16 = i46;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar7.f1106b * i25) + cVar7.f1107c, 1073741824), i16);
                } else {
                    i16 = i46;
                }
                i51++;
                i46 = i16;
            }
        }
        if (i33 != 1073741824) {
            i15 = i34;
            i14 = i45;
        } else {
            i14 = i35;
            i15 = i34;
        }
        setMeasuredDimension(i15, i14);
    }

    public androidx.appcompat.view.menu.e peekMenu() {
        return this.A;
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.E.setExpandedActionViewsExclusive(z10);
    }

    public void setMenuCallbacks(i.a aVar, e.a aVar2) {
        this.F = aVar;
        this.G = aVar2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.L = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.E.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.D = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.C != i10) {
            this.C = i10;
            if (i10 == 0) {
                this.B = getContext();
            } else {
                this.B = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.E = cVar;
        cVar.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        androidx.appcompat.widget.c cVar = this.E;
        return cVar != null && cVar.showOverflowMenu();
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.J = (int) (56.0f * f10);
        this.K = (int) (f10 * 4.0f);
        this.B = context;
        this.C = 0;
    }

    @Override // androidx.appcompat.widget.m0, android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.m0, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.m0, android.view.ViewGroup
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams != null) {
            if (layoutParams instanceof c) {
                cVar = new c((c) layoutParams);
            } else {
                cVar = new c(layoutParams);
            }
            if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    public static class b implements i.a {
        @Override // androidx.appcompat.view.menu.i.a
        public boolean onOpenSubMenu(androidx.appcompat.view.menu.e eVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }
    }
}
