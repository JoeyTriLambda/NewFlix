package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import x0.b;

/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
public final class c extends androidx.appcompat.view.menu.a implements b.a {
    public int A;
    public int B;
    public boolean C;
    public final SparseBooleanArray D;
    public e E;
    public a F;
    public RunnableC0016c G;
    public b H;
    public final f I;
    public int J;

    /* renamed from: u, reason: collision with root package name */
    public d f1272u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f1273v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1274w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1275x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1276y;

    /* renamed from: z, reason: collision with root package name */
    public int f1277z;

    /* compiled from: ActionMenuPresenter.java */
    public class a extends androidx.appcompat.view.menu.h {
        public a(Context context, androidx.appcompat.view.menu.l lVar, View view) {
            super(context, lVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) lVar.getItem()).isActionButton()) {
                View view2 = c.this.f1272u;
                setAnchorView(view2 == null ? (View) c.this.f942s : view2);
            }
            setPresenterCallback(c.this.I);
        }

        @Override // androidx.appcompat.view.menu.h
        public void onDismiss() {
            c cVar = c.this;
            cVar.F = null;
            cVar.J = 0;
            super.onDismiss();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public x.f getPopup() {
            a aVar = c.this.F;
            if (aVar != null) {
                return aVar.getPopup();
            }
            return null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    public class RunnableC0016c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final e f1280b;

        public RunnableC0016c(e eVar) {
            this.f1280b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            androidx.appcompat.view.menu.e eVar = cVar.f937n;
            if (eVar != null) {
                eVar.changeMenuMode();
            }
            View view = (View) cVar.f942s;
            if (view != null && view.getWindowToken() != null) {
                e eVar2 = this.f1280b;
                if (eVar2.tryShow()) {
                    cVar.E = eVar2;
                }
            }
            cVar.G = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    public class d extends q implements ActionMenuView.a {

        /* compiled from: ActionMenuPresenter.java */
        public class a extends l0 {
            public a(View view) {
                super(view);
            }

            @Override // androidx.appcompat.widget.l0
            public x.f getPopup() {
                e eVar = c.this.E;
                if (eVar == null) {
                    return null;
                }
                return eVar.getPopup();
            }

            @Override // androidx.appcompat.widget.l0
            public boolean onForwardingStarted() {
                c.this.showOverflowMenu();
                return true;
            }

            @Override // androidx.appcompat.widget.l0
            public boolean onForwardingStopped() {
                c cVar = c.this;
                if (cVar.G != null) {
                    return false;
                }
                cVar.hideOverflowMenu();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            f1.setTooltipText(this, getContentDescription());
            setOnTouchListener(new a(this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                p0.a.setHotspotBounds(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    public class e extends androidx.appcompat.view.menu.h {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z10) {
            super(context, eVar, view, z10, R.attr.actionOverflowMenuStyle);
            setGravity(8388613);
            setPresenterCallback(c.this.I);
        }

        @Override // androidx.appcompat.view.menu.h
        public void onDismiss() {
            c cVar = c.this;
            androidx.appcompat.view.menu.e eVar = cVar.f937n;
            if (eVar != null) {
                eVar.close();
            }
            cVar.E = null;
            super.onDismiss();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    public class f implements i.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (eVar instanceof androidx.appcompat.view.menu.l) {
                eVar.getRootMenu().close(false);
            }
            i.a callback = c.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(eVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean onOpenSubMenu(androidx.appcompat.view.menu.e eVar) {
            c cVar = c.this;
            if (eVar == cVar.f937n) {
                return false;
            }
            cVar.J = ((androidx.appcompat.view.menu.l) eVar).getItem().getItemId();
            i.a callback = cVar.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(eVar);
            }
            return false;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    @SuppressLint({"BanParcelableUsage"})
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f1286b;

        /* compiled from: ActionMenuPresenter.java */
        public class a implements Parcelable.Creator<g> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public g[] newArray(int i10) {
                return new g[i10];
            }
        }

        public g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1286b);
        }

        public g(Parcel parcel) {
            this.f1286b = parcel.readInt();
        }
    }

    public c(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.D = new SparseBooleanArray();
        this.I = new f();
    }

    @Override // androidx.appcompat.view.menu.a
    public void bindItemView(androidx.appcompat.view.menu.g gVar, j.a aVar) {
        aVar.initialize(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f942s);
        if (this.H == null) {
            this.H = new b();
        }
        actionMenuItemView.setPopupCallback(this.H);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean filterLeftoverView(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f1272u) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean flagActionItems() {
        ArrayList<androidx.appcompat.view.menu.g> visibleItems;
        int size;
        boolean z10;
        androidx.appcompat.view.menu.e eVar = this.f937n;
        View view = null;
        if (eVar != null) {
            visibleItems = eVar.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i10 = this.B;
        int i11 = this.A;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f942s;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            z10 = true;
            if (i12 >= size) {
                break;
            }
            androidx.appcompat.view.menu.g gVar = visibleItems.get(i12);
            if (gVar.requiresActionButton()) {
                i13++;
            } else if (gVar.requestsActionButton()) {
                i14++;
            } else {
                z11 = true;
            }
            if (this.C && gVar.isActionViewExpanded()) {
                i10 = 0;
            }
            i12++;
        }
        if (this.f1275x && (z11 || i14 + i13 > i10)) {
            i10--;
        }
        int i15 = i10 - i13;
        SparseBooleanArray sparseBooleanArray = this.D;
        sparseBooleanArray.clear();
        int i16 = 0;
        int i17 = 0;
        while (i16 < size) {
            androidx.appcompat.view.menu.g gVar2 = visibleItems.get(i16);
            if (gVar2.requiresActionButton()) {
                View itemView = getItemView(gVar2, view, viewGroup);
                itemView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = itemView.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, z10);
                }
                gVar2.setIsActionButton(z10);
            } else if (gVar2.requestsActionButton()) {
                int groupId2 = gVar2.getGroupId();
                boolean z12 = sparseBooleanArray.get(groupId2);
                boolean z13 = (i15 > 0 || z12) && i11 > 0;
                if (z13) {
                    View itemView2 = getItemView(gVar2, view, viewGroup);
                    itemView2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z13 &= i11 + i17 > 0;
                }
                boolean z14 = z13;
                if (z14 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, z10);
                } else if (z12) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i18 = 0; i18 < i16; i18++) {
                        androidx.appcompat.view.menu.g gVar3 = visibleItems.get(i18);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.isActionButton()) {
                                i15++;
                            }
                            gVar3.setIsActionButton(false);
                        }
                    }
                }
                if (z14) {
                    i15--;
                }
                gVar2.setIsActionButton(z14);
            } else {
                gVar2.setIsActionButton(false);
                i16++;
                view = null;
                z10 = true;
            }
            i16++;
            view = null;
            z10 = true;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public View getItemView(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.hasCollapsibleActionView()) {
            actionView = super.getItemView(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.j getMenuView(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.j jVar = this.f942s;
        androidx.appcompat.view.menu.j menuView = super.getMenuView(viewGroup);
        if (jVar != menuView) {
            ((ActionMenuView) menuView).setPresenter(this);
        }
        return menuView;
    }

    public Drawable getOverflowIcon() {
        d dVar = this.f1272u;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1274w) {
            return this.f1273v;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        Object obj;
        RunnableC0016c runnableC0016c = this.G;
        if (runnableC0016c != null && (obj = this.f942s) != null) {
            ((View) obj).removeCallbacks(runnableC0016c);
            this.G = null;
            return true;
        }
        e eVar = this.E;
        if (eVar == null) {
            return false;
        }
        eVar.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        a aVar = this.F;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void initForMenu(Context context, androidx.appcompat.view.menu.e eVar) {
        super.initForMenu(context, eVar);
        Resources resources = context.getResources();
        w.a aVar = w.a.get(context);
        if (!this.f1276y) {
            this.f1275x = aVar.showsOverflowMenuButton();
        }
        this.f1277z = aVar.getEmbeddedMenuWidthLimit();
        this.B = aVar.getMaxActionButtons();
        int measuredWidth = this.f1277z;
        if (this.f1275x) {
            if (this.f1272u == null) {
                d dVar = new d(this.f935b);
                this.f1272u = dVar;
                if (this.f1274w) {
                    dVar.setImageDrawable(this.f1273v);
                    this.f1273v = null;
                    this.f1274w = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1272u.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1272u.getMeasuredWidth();
        } else {
            this.f1272u = null;
        }
        this.A = measuredWidth;
        float f10 = resources.getDisplayMetrics().density;
    }

    public boolean isOverflowMenuShowPending() {
        return this.G != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        e eVar = this.E;
        return eVar != null && eVar.isShowing();
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
        dismissPopupMenus();
        super.onCloseMenu(eVar, z10);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.B = w.a.get(this.f936m).getMaxActionButtons();
        androidx.appcompat.view.menu.e eVar = this.f937n;
        if (eVar != null) {
            eVar.onItemsChanged(true);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof g) && (i10 = ((g) parcelable).f1286b) > 0 && (menuItemFindItem = this.f937n.findItem(i10)) != null) {
            onSubMenuSelected((androidx.appcompat.view.menu.l) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable onSaveInstanceState() {
        g gVar = new g();
        gVar.f1286b = this.J;
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.l lVar) {
        boolean z10 = false;
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.l lVar2 = lVar;
        while (lVar2.getParentMenu() != this.f937n) {
            lVar2 = (androidx.appcompat.view.menu.l) lVar2.getParentMenu();
        }
        MenuItem item = lVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.f942s;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i10);
                if ((childAt instanceof j.a) && ((j.a) childAt).getItemData() == item) {
                    view = childAt;
                    break;
                }
                i10++;
            }
        }
        if (view == null) {
            return false;
        }
        this.J = lVar.getItem().getItemId();
        int size = lVar.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            MenuItem item2 = lVar.getItem(i11);
            if (item2.isVisible() && item2.getIcon() != null) {
                z10 = true;
                break;
            }
            i11++;
        }
        a aVar = new a(this.f936m, lVar, view);
        this.F = aVar;
        aVar.setForceShowIcon(z10);
        this.F.show();
        super.onSubMenuSelected(lVar);
        return true;
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.C = z10;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.f942s = actionMenuView;
        actionMenuView.initialize(this.f937n);
    }

    public void setOverflowIcon(Drawable drawable) {
        d dVar = this.f1272u;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f1274w = true;
            this.f1273v = drawable;
        }
    }

    public void setReserveOverflow(boolean z10) {
        this.f1275x = z10;
        this.f1276y = true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean shouldIncludeItem(int i10, androidx.appcompat.view.menu.g gVar) {
        return gVar.isActionButton();
    }

    public boolean showOverflowMenu() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f1275x || isOverflowMenuShowing() || (eVar = this.f937n) == null || this.f942s == null || this.G != null || eVar.getNonActionItems().isEmpty()) {
            return false;
        }
        RunnableC0016c runnableC0016c = new RunnableC0016c(new e(this.f936m, this.f937n, this.f1272u, true));
        this.G = runnableC0016c;
        ((View) this.f942s).post(runnableC0016c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void updateMenuView(boolean z10) {
        super.updateMenuView(z10);
        ((View) this.f942s).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f937n;
        boolean z11 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.g> actionItems = eVar.getActionItems();
            int size = actionItems.size();
            for (int i10 = 0; i10 < size; i10++) {
                x0.b supportActionProvider = actionItems.get(i10).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f937n;
        ArrayList<androidx.appcompat.view.menu.g> nonActionItems = eVar2 != null ? eVar2.getNonActionItems() : null;
        if (this.f1275x && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z11 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f1272u == null) {
                this.f1272u = new d(this.f935b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1272u.getParent();
            if (viewGroup != this.f942s) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1272u);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f942s;
                actionMenuView.addView(this.f1272u, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            d dVar = this.f1272u;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f942s;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1272u);
                }
            }
        }
        ((ActionMenuView) this.f942s).setOverflowReserved(this.f1275x);
    }
}
