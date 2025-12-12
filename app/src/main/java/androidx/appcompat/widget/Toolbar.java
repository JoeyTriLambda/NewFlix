package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import r.a;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements x0.l {
    public int A;
    public int B;
    public int C;
    public int D;
    public u0 E;
    public int F;
    public int G;
    public final int H;
    public CharSequence I;
    public CharSequence J;
    public ColorStateList K;
    public ColorStateList L;
    public boolean M;
    public boolean N;
    public final ArrayList<View> O;
    public final ArrayList<View> P;
    public final int[] Q;
    public final x0.m R;
    public ArrayList<MenuItem> S;
    public h T;
    public final a U;
    public e1 V;
    public androidx.appcompat.widget.c W;

    /* renamed from: a0, reason: collision with root package name */
    public f f1199a0;

    /* renamed from: b, reason: collision with root package name */
    public ActionMenuView f1200b;

    /* renamed from: b0, reason: collision with root package name */
    public i.a f1201b0;

    /* renamed from: c0, reason: collision with root package name */
    public e.a f1202c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f1203d0;

    /* renamed from: e0, reason: collision with root package name */
    public OnBackInvokedCallback f1204e0;

    /* renamed from: f0, reason: collision with root package name */
    public OnBackInvokedDispatcher f1205f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f1206g0;

    /* renamed from: h0, reason: collision with root package name */
    public final b f1207h0;

    /* renamed from: m, reason: collision with root package name */
    public AppCompatTextView f1208m;

    /* renamed from: n, reason: collision with root package name */
    public AppCompatTextView f1209n;

    /* renamed from: o, reason: collision with root package name */
    public o f1210o;

    /* renamed from: p, reason: collision with root package name */
    public q f1211p;

    /* renamed from: q, reason: collision with root package name */
    public final Drawable f1212q;

    /* renamed from: r, reason: collision with root package name */
    public final CharSequence f1213r;

    /* renamed from: s, reason: collision with root package name */
    public o f1214s;

    /* renamed from: t, reason: collision with root package name */
    public View f1215t;

    /* renamed from: u, reason: collision with root package name */
    public Context f1216u;

    /* renamed from: v, reason: collision with root package name */
    public int f1217v;

    /* renamed from: w, reason: collision with root package name */
    public int f1218w;

    /* renamed from: x, reason: collision with root package name */
    public int f1219x;

    /* renamed from: y, reason: collision with root package name */
    public final int f1220y;

    /* renamed from: z, reason: collision with root package name */
    public final int f1221z;

    public class a implements ActionMenuView.e {
        public a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Toolbar toolbar = Toolbar.this;
            if (toolbar.R.onMenuItemSelected(menuItem)) {
                return true;
            }
            h hVar = toolbar.T;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    public class c implements e.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.f1202c0;
            return aVar != null && aVar.onMenuItemSelected(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            Toolbar toolbar = Toolbar.this;
            if (!toolbar.f1200b.isOverflowMenuShowing()) {
                toolbar.R.onPrepareMenu(eVar);
            }
            e.a aVar = toolbar.f1202c0;
            if (aVar != null) {
                aVar.onMenuModeChange(eVar);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new androidx.activity.l(runnable, 1);
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new w.g(getContext());
    }

    public static int h(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return x0.k.getMarginEnd(marginLayoutParams) + x0.k.getMarginStart(marginLayoutParams);
    }

    public static int i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i10, ArrayList arrayList) {
        boolean z10 = x0.j0.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = x0.h.getAbsoluteGravity(i10, x0.j0.getLayoutDirection(this));
        arrayList.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f1229b == 0 && o(childAt)) {
                    int i12 = gVar.f18154a;
                    int layoutDirection = x0.j0.getLayoutDirection(this);
                    int absoluteGravity2 = x0.h.getAbsoluteGravity(i12, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i13 = childCount - 1; i13 >= 0; i13--) {
            View childAt2 = getChildAt(i13);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f1229b == 0 && o(childAt2)) {
                int i14 = gVar2.f18154a;
                int layoutDirection2 = x0.j0.getLayoutDirection(this);
                int absoluteGravity3 = x0.h.getAbsoluteGravity(i14, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // x0.l
    public void addMenuProvider(x0.o oVar) {
        this.R.addMenuProvider(oVar);
    }

    public final void b(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f1229b = 1;
        if (!z10 || this.f1215t == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.P.add(view);
        }
    }

    public final void c() {
        if (this.f1214s == null) {
            o oVar = new o(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f1214s = oVar;
            oVar.setImageDrawable(this.f1212q);
            this.f1214s.setContentDescription(this.f1213r);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f18154a = (this.f1220y & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f1229b = 2;
            this.f1214s.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f1214s.setOnClickListener(new d());
        }
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1200b) != null && actionMenuView.isOverflowReserved();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public void collapseActionView() {
        f fVar = this.f1199a0;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.f1227m;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public final void d() {
        e();
        if (this.f1200b.peekMenu() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f1200b.getMenu();
            if (this.f1199a0 == null) {
                this.f1199a0 = new f();
            }
            this.f1200b.setExpandedActionViewsExclusive(true);
            eVar.addMenuPresenter(this.f1199a0, this.f1216u);
            p();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.f1200b;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    public final void e() {
        if (this.f1200b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1200b = actionMenuView;
            actionMenuView.setPopupTheme(this.f1217v);
            this.f1200b.setOnMenuItemClickListener(this.U);
            this.f1200b.setMenuCallbacks(this.f1201b0, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f18154a = (this.f1220y & 112) | 8388613;
            this.f1200b.setLayoutParams(gVarGenerateDefaultLayoutParams);
            b(this.f1200b, false);
        }
    }

    public final void f() {
        if (this.f1210o == null) {
            this.f1210o = new o(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f18154a = (this.f1220y & 112) | 8388611;
            this.f1210o.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    public final int g(View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int i12 = gVar.f18154a & 112;
        if (i12 != 16 && i12 != 48 && i12 != 80) {
            i12 = this.H & 112;
        }
        if (i12 == 48) {
            return getPaddingTop() - i11;
        }
        if (i12 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i13) {
            iMax = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i14 < i15) {
                iMax = Math.max(0, iMax - (i15 - i14));
            }
        }
        return paddingTop + iMax;
    }

    public CharSequence getCollapseContentDescription() {
        o oVar = this.f1214s;
        if (oVar != null) {
            return oVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        o oVar = this.f1214s;
        if (oVar != null) {
            return oVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        u0 u0Var = this.E;
        if (u0Var != null) {
            return u0Var.getEnd();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.G;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        u0 u0Var = this.E;
        if (u0Var != null) {
            return u0Var.getLeft();
        }
        return 0;
    }

    public int getContentInsetRight() {
        u0 u0Var = this.E;
        if (u0Var != null) {
            return u0Var.getRight();
        }
        return 0;
    }

    public int getContentInsetStart() {
        u0 u0Var = this.E;
        if (u0Var != null) {
            return u0Var.getStart();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.F;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarPeekMenu;
        ActionMenuView actionMenuView = this.f1200b;
        return actionMenuView != null && (eVarPeekMenu = actionMenuView.peekMenu()) != null && eVarPeekMenu.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.G, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return x0.j0.getLayoutDirection(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return x0.j0.getLayoutDirection(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.F, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        q qVar = this.f1211p;
        if (qVar != null) {
            return qVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        q qVar = this.f1211p;
        if (qVar != null) {
            return qVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        d();
        return this.f1200b.getMenu();
    }

    public View getNavButtonView() {
        return this.f1210o;
    }

    public CharSequence getNavigationContentDescription() {
        o oVar = this.f1210o;
        if (oVar != null) {
            return oVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        o oVar = this.f1210o;
        if (oVar != null) {
            return oVar.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.W;
    }

    public Drawable getOverflowIcon() {
        d();
        return this.f1200b.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1216u;
    }

    public int getPopupTheme() {
        return this.f1217v;
    }

    public CharSequence getSubtitle() {
        return this.J;
    }

    public final TextView getSubtitleTextView() {
        return this.f1209n;
    }

    public CharSequence getTitle() {
        return this.I;
    }

    public int getTitleMarginBottom() {
        return this.D;
    }

    public int getTitleMarginEnd() {
        return this.B;
    }

    public int getTitleMarginStart() {
        return this.A;
    }

    public int getTitleMarginTop() {
        return this.C;
    }

    public final TextView getTitleTextView() {
        return this.f1208m;
    }

    public h0 getWrapper() {
        if (this.V == null) {
            this.V = new e1(this, true);
        }
        return this.V;
    }

    public boolean hasExpandedActionView() {
        f fVar = this.f1199a0;
        return (fVar == null || fVar.f1227m == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.f1200b;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    public void inflateMenu(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public void invalidateMenu() {
        Iterator<MenuItem> it = this.S.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.R.onCreateMenu(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.S = currentMenuItems2;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.f1200b;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.f1200b;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    public final boolean j(View view) {
        return view.getParent() == this || this.P.contains(view);
    }

    public final int k(View view, int i10, int i11, int[] iArr) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = Math.max(0, i12) + i10;
        iArr[0] = Math.max(0, -i12);
        int iG = g(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iG, iMax + measuredWidth, view.getMeasuredHeight() + iG);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin + iMax;
    }

    public final int l(View view, int i10, int i11, int[] iArr) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iG = g(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iG, iMax, view.getMeasuredHeight() + iG);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    public final int m(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i15) + Math.max(0, i14);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + iMax + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void n(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i13 >= 0) {
            if (mode != 0) {
                i13 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i13);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean o(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1207h0);
        p();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.N = false;
        }
        if (!this.N) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.N = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.N = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0290 A[LOOP:0: B:102:0x028e->B:103:0x0290, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ac A[LOOP:1: B:105:0x02aa->B:106:0x02ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02cc A[LOOP:2: B:108:0x02ca->B:109:0x02cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031a A[LOOP:3: B:117:0x0318->B:118:0x031a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int iH;
        int iMax;
        int iCombineMeasuredStates;
        int iH2;
        int iCombineMeasuredStates2;
        int iMax2;
        int i12;
        boolean z10;
        boolean zIsLayoutRtl = k1.isLayoutRtl(this);
        int i13 = !zIsLayoutRtl ? 1 : 0;
        if (o(this.f1210o)) {
            n(this.f1210o, i10, 0, i11, this.f1221z);
            iH = h(this.f1210o) + this.f1210o.getMeasuredWidth();
            iMax = Math.max(0, i(this.f1210o) + this.f1210o.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1210o.getMeasuredState());
        } else {
            iH = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (o(this.f1214s)) {
            n(this.f1214s, i10, 0, i11, this.f1221z);
            iH = h(this.f1214s) + this.f1214s.getMeasuredWidth();
            iMax = Math.max(iMax, i(this.f1214s) + this.f1214s.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1214s.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iH) + 0;
        int iMax4 = Math.max(0, currentContentInsetStart - iH);
        int[] iArr = this.Q;
        iArr[zIsLayoutRtl ? 1 : 0] = iMax4;
        if (o(this.f1200b)) {
            n(this.f1200b, i10, iMax3, i11, this.f1221z);
            iH2 = h(this.f1200b) + this.f1200b.getMeasuredWidth();
            iMax = Math.max(iMax, i(this.f1200b) + this.f1200b.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1200b.getMeasuredState());
        } else {
            iH2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iH2);
        iArr[i13] = Math.max(0, currentContentInsetEnd - iH2);
        if (o(this.f1215t)) {
            iMax5 += m(this.f1215t, i10, iMax5, i11, 0, iArr);
            iMax = Math.max(iMax, i(this.f1215t) + this.f1215t.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1215t.getMeasuredState());
        }
        if (o(this.f1211p)) {
            iMax5 += m(this.f1211p, i10, iMax5, i11, 0, iArr);
            iMax = Math.max(iMax, i(this.f1211p) + this.f1211p.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1211p.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (((g) childAt.getLayoutParams()).f1229b == 0 && o(childAt)) {
                iMax5 += m(childAt, i10, iMax5, i11, 0, iArr);
                iMax = Math.max(iMax, i(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i15 = this.C + this.D;
        int i16 = this.A + this.B;
        if (o(this.f1208m)) {
            m(this.f1208m, i10, iMax5 + i16, i11, i15, iArr);
            int iH3 = h(this.f1208m) + this.f1208m.getMeasuredWidth();
            i12 = i(this.f1208m) + this.f1208m.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1208m.getMeasuredState());
            iMax2 = iH3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            i12 = 0;
        }
        if (o(this.f1209n)) {
            iMax2 = Math.max(iMax2, m(this.f1209n, i10, iMax5 + i16, i11, i12 + i15, iArr));
            i12 += i(this.f1209n) + this.f1209n.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1209n.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, i12);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i10, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16);
        if (!this.f1203d0) {
            z10 = false;
            break;
        }
        int childCount2 = getChildCount();
        for (int i17 = 0; i17 < childCount2; i17++) {
            View childAt2 = getChildAt(i17);
            if (o(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                z10 = false;
                break;
            }
        }
        z10 = true;
        setMeasuredDimension(iResolveSizeAndState, z10 ? 0 : iResolveSizeAndState2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        ActionMenuView actionMenuView = this.f1200b;
        androidx.appcompat.view.menu.e eVarPeekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        int i10 = iVar.f1230n;
        if (i10 != 0 && this.f1199a0 != null && eVarPeekMenu != null && (menuItemFindItem = eVarPeekMenu.findItem(i10)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f1231o) {
            b bVar = this.f1207h0;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.E == null) {
            this.E = new u0();
        }
        this.E.setDirection(i10 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.f1199a0;
        if (fVar != null && (gVar = fVar.f1227m) != null) {
            iVar.f1230n = gVar.getItemId();
        }
        iVar.f1231o = isOverflowMenuShowing();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.M = false;
        }
        if (!this.M) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.M = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.M = false;
        }
        return true;
    }

    final void p() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z10 = hasExpandedActionView() && onBackInvokedDispatcherA != null && x0.j0.isAttachedToWindow(this) && this.f1206g0;
            if (z10 && this.f1205f0 == null) {
                if (this.f1204e0 == null) {
                    this.f1204e0 = e.b(new d1(this, 1));
                }
                e.c(onBackInvokedDispatcherA, this.f1204e0);
                this.f1205f0 = onBackInvokedDispatcherA;
                return;
            }
            if (z10 || (onBackInvokedDispatcher = this.f1205f0) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.f1204e0);
            this.f1205f0 = null;
        }
    }

    @Override // x0.l
    public void removeMenuProvider(x0.o oVar) {
        this.R.removeMenuProvider(oVar);
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f1206g0 != z10) {
            this.f1206g0 = z10;
            p();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(s.a.getDrawable(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.f1203d0 = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.G) {
            this.G = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.F) {
            this.F = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsRelative(int i10, int i11) {
        if (this.E == null) {
            this.E = new u0();
        }
        this.E.setRelative(i10, i11);
    }

    public void setLogo(int i10) {
        setLogo(s.a.getDrawable(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setMenu(androidx.appcompat.view.menu.e eVar, androidx.appcompat.widget.c cVar) {
        if (eVar == null && this.f1200b == null) {
            return;
        }
        e();
        androidx.appcompat.view.menu.e eVarPeekMenu = this.f1200b.peekMenu();
        if (eVarPeekMenu == eVar) {
            return;
        }
        if (eVarPeekMenu != null) {
            eVarPeekMenu.removeMenuPresenter(this.W);
            eVarPeekMenu.removeMenuPresenter(this.f1199a0);
        }
        if (this.f1199a0 == null) {
            this.f1199a0 = new f();
        }
        cVar.setExpandedActionViewsExclusive(true);
        if (eVar != null) {
            eVar.addMenuPresenter(cVar, this.f1216u);
            eVar.addMenuPresenter(this.f1199a0, this.f1216u);
        } else {
            cVar.initForMenu(this.f1216u, null);
            this.f1199a0.initForMenu(this.f1216u, null);
            cVar.updateMenuView(true);
            this.f1199a0.updateMenuView(true);
        }
        this.f1200b.setPopupTheme(this.f1217v);
        this.f1200b.setPresenter(cVar);
        this.W = cVar;
        p();
    }

    public void setMenuCallbacks(i.a aVar, e.a aVar2) {
        this.f1201b0 = aVar;
        this.f1202c0 = aVar2;
        ActionMenuView actionMenuView = this.f1200b;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(s.a.getDrawable(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f1210o.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.T = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        d();
        this.f1200b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f1217v != i10) {
            this.f1217v = i10;
            if (i10 == 0) {
                this.f1216u = getContext();
            } else {
                this.f1216u = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextAppearance(Context context, int i10) {
        this.f1219x = i10;
        AppCompatTextView appCompatTextView = this.f1209n;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i10);
        }
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.D = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.B = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.A = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.C = i10;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i10) {
        this.f1218w = i10;
        AppCompatTextView appCompatTextView = this.f1208m;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(context, i10);
        }
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.f1200b;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    public static class g extends a.C0232a {

        /* renamed from: b, reason: collision with root package name */
        public int f1229b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1229b = 0;
        }

        public g(int i10, int i11) {
            super(i10, i11);
            this.f1229b = 0;
            this.f18154a = 8388627;
        }

        public g(g gVar) {
            super((a.C0232a) gVar);
            this.f1229b = 0;
            this.f1229b = gVar.f1229b;
        }

        public g(a.C0232a c0232a) {
            super(c0232a);
            this.f1229b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1229b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1229b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.H = 8388627;
        this.O = new ArrayList<>();
        this.P = new ArrayList<>();
        this.Q = new int[2];
        this.R = new x0.m(new d1(this, 0));
        this.S = new ArrayList<>();
        this.U = new a();
        this.f1207h0 = new b();
        Context context2 = getContext();
        int[] iArr = R.styleable.Toolbar;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context2, attributeSet, iArr, i10, 0);
        x0.j0.saveAttributeDataForStyleable(this, context, iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        this.f1218w = c1VarObtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f1219x = c1VarObtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.H = c1VarObtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, 8388627);
        this.f1220y = c1VarObtainStyledAttributes.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        int i11 = R.styleable.Toolbar_titleMargins;
        dimensionPixelOffset = c1VarObtainStyledAttributes.hasValue(i11) ? c1VarObtainStyledAttributes.getDimensionPixelOffset(i11, dimensionPixelOffset) : dimensionPixelOffset;
        this.D = dimensionPixelOffset;
        this.C = dimensionPixelOffset;
        this.B = dimensionPixelOffset;
        this.A = dimensionPixelOffset;
        int dimensionPixelOffset2 = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.A = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.B = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.C = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.D = dimensionPixelOffset5;
        }
        this.f1221z = c1VarObtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = c1VarObtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = c1VarObtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        if (this.E == null) {
            this.E = new u0();
        }
        this.E.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            this.E.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.F = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.G = c1VarObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1212q = c1VarObtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.f1213r = c1VarObtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = c1VarObtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = c1VarObtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f1216u = getContext();
        setPopupTheme(c1VarObtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = c1VarObtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = c1VarObtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = c1VarObtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = c1VarObtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        int i12 = R.styleable.Toolbar_titleTextColor;
        if (c1VarObtainStyledAttributes.hasValue(i12)) {
            setTitleTextColor(c1VarObtainStyledAttributes.getColorStateList(i12));
        }
        int i13 = R.styleable.Toolbar_subtitleTextColor;
        if (c1VarObtainStyledAttributes.hasValue(i13)) {
            setSubtitleTextColor(c1VarObtainStyledAttributes.getColorStateList(i13));
        }
        int i14 = R.styleable.Toolbar_menu;
        if (c1VarObtainStyledAttributes.hasValue(i14)) {
            inflateMenu(c1VarObtainStyledAttributes.getResourceId(i14, 0));
        }
        c1VarObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        o oVar = this.f1214s;
        if (oVar != null) {
            oVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f1214s.setImageDrawable(drawable);
        } else {
            o oVar = this.f1214s;
            if (oVar != null) {
                oVar.setImageDrawable(this.f1212q);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f1211p == null) {
                this.f1211p = new q(getContext());
            }
            if (!j(this.f1211p)) {
                b(this.f1211p, true);
            }
        } else {
            q qVar = this.f1211p;
            if (qVar != null && j(qVar)) {
                removeView(this.f1211p);
                this.P.remove(this.f1211p);
            }
        }
        q qVar2 = this.f1211p;
        if (qVar2 != null) {
            qVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f1211p == null) {
            this.f1211p = new q(getContext());
        }
        q qVar = this.f1211p;
        if (qVar != null) {
            qVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        o oVar = this.f1210o;
        if (oVar != null) {
            oVar.setContentDescription(charSequence);
            f1.setTooltipText(this.f1210o, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!j(this.f1210o)) {
                b(this.f1210o, true);
            }
        } else {
            o oVar = this.f1210o;
            if (oVar != null && j(oVar)) {
                removeView(this.f1210o);
                this.P.remove(this.f1210o);
            }
        }
        o oVar2 = this.f1210o;
        if (oVar2 != null) {
            oVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f1209n;
            if (appCompatTextView != null && j(appCompatTextView)) {
                removeView(this.f1209n);
                this.P.remove(this.f1209n);
            }
        } else {
            if (this.f1209n == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f1209n = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f1209n.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1219x;
                if (i10 != 0) {
                    this.f1209n.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.L;
                if (colorStateList != null) {
                    this.f1209n.setTextColor(colorStateList);
                }
            }
            if (!j(this.f1209n)) {
                b(this.f1209n, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f1209n;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.J = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.L = colorStateList;
        AppCompatTextView appCompatTextView = this.f1209n;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f1208m;
            if (appCompatTextView != null && j(appCompatTextView)) {
                removeView(this.f1208m);
                this.P.remove(this.f1208m);
            }
        } else {
            if (this.f1208m == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f1208m = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f1208m.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1218w;
                if (i10 != 0) {
                    this.f1208m.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.K;
                if (colorStateList != null) {
                    this.f1208m.setTextColor(colorStateList);
                }
            }
            if (!j(this.f1208m)) {
                b(this.f1208m, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f1208m;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.I = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.K = colorStateList;
        AppCompatTextView appCompatTextView = this.f1208m;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public static class i extends f1.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public int f1230n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f1231o;

        public class a implements Parcelable.ClassLoaderCreator<i> {
            @Override // android.os.Parcelable.Creator
            public i[] newArray(int i10) {
                return new i[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1230n = parcel.readInt();
            this.f1231o = parcel.readInt() != 0;
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1230n);
            parcel.writeInt(this.f1231o ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof g) {
            return new g((g) layoutParams);
        }
        if (layoutParams instanceof a.C0232a) {
            return new g((a.C0232a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new g((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new g(layoutParams);
    }

    public class f implements androidx.appcompat.view.menu.i {

        /* renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f1226b;

        /* renamed from: m, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f1227m;

        public f() {
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean collapseItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar toolbar = Toolbar.this;
            KeyEvent.Callback callback = toolbar.f1215t;
            if (callback instanceof w.c) {
                ((w.c) callback).onActionViewCollapsed();
            }
            toolbar.removeView(toolbar.f1215t);
            toolbar.removeView(toolbar.f1214s);
            toolbar.f1215t = null;
            ArrayList<View> arrayList = toolbar.P;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    arrayList.clear();
                    this.f1227m = null;
                    toolbar.requestLayout();
                    gVar.setActionViewExpanded(false);
                    toolbar.p();
                    return true;
                }
                toolbar.addView(arrayList.get(size));
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean expandItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar toolbar = Toolbar.this;
            toolbar.c();
            ViewParent parent = toolbar.f1214s.getParent();
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1214s);
                }
                toolbar.addView(toolbar.f1214s);
            }
            View actionView = gVar.getActionView();
            toolbar.f1215t = actionView;
            this.f1227m = gVar;
            ViewParent parent2 = actionView.getParent();
            if (parent2 != toolbar) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar.f1215t);
                }
                g gVarGenerateDefaultLayoutParams = toolbar.generateDefaultLayoutParams();
                gVarGenerateDefaultLayoutParams.f18154a = (toolbar.f1220y & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f1229b = 2;
                toolbar.f1215t.setLayoutParams(gVarGenerateDefaultLayoutParams);
                toolbar.addView(toolbar.f1215t);
            }
            int childCount = toolbar.getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    break;
                }
                View childAt = toolbar.getChildAt(childCount);
                if (((g) childAt.getLayoutParams()).f1229b != 2 && childAt != toolbar.f1200b) {
                    toolbar.removeViewAt(childCount);
                    toolbar.P.add(childAt);
                }
            }
            toolbar.requestLayout();
            gVar.setActionViewExpanded(true);
            KeyEvent.Callback callback = toolbar.f1215t;
            if (callback instanceof w.c) {
                ((w.c) callback).onActionViewExpanded();
            }
            toolbar.p();
            return true;
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.i
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.i
        public void initForMenu(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1226b;
            if (eVar2 != null && (gVar = this.f1227m) != null) {
                eVar2.collapseItemActionView(gVar);
            }
            this.f1226b = eVar;
        }

        @Override // androidx.appcompat.view.menu.i
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean onSubMenuSelected(androidx.appcompat.view.menu.l lVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.i
        public void updateMenuView(boolean z10) {
            if (this.f1227m != null) {
                androidx.appcompat.view.menu.e eVar = this.f1226b;
                boolean z11 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        if (this.f1226b.getItem(i10) == this.f1227m) {
                            z11 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (z11) {
                    return;
                }
                collapseItemActionView(this.f1226b, this.f1227m);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.i
        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }
    }
}
