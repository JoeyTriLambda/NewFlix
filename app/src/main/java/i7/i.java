package i7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuView;
import java.util.ArrayList;
import x0.j0;
import x0.y0;
import y0.d;

/* compiled from: NavigationMenuPresenter.java */
/* loaded from: classes.dex */
public final class i implements androidx.appcompat.view.menu.i {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public int J;
    public int K;
    public int L;

    /* renamed from: b, reason: collision with root package name */
    public NavigationMenuView f13275b;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f13276m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f13277n;

    /* renamed from: o, reason: collision with root package name */
    public int f13278o;

    /* renamed from: p, reason: collision with root package name */
    public c f13279p;

    /* renamed from: q, reason: collision with root package name */
    public LayoutInflater f13280q;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f13282s;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f13285v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f13286w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f13287x;

    /* renamed from: y, reason: collision with root package name */
    public RippleDrawable f13288y;

    /* renamed from: z, reason: collision with root package name */
    public int f13289z;

    /* renamed from: r, reason: collision with root package name */
    public int f13281r = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f13283t = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13284u = true;
    public boolean I = true;
    public int M = -1;
    public final a N = new a();

    /* compiled from: NavigationMenuPresenter.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            boolean z10 = true;
            iVar.setUpdateSuspended(true);
            androidx.appcompat.view.menu.g itemData = ((NavigationMenuItemView) view).getItemData();
            boolean zPerformItemAction = iVar.f13277n.performItemAction(itemData, iVar, 0);
            if (itemData != null && itemData.isCheckable() && zPerformItemAction) {
                iVar.f13279p.setCheckedItem(itemData);
            } else {
                z10 = false;
            }
            iVar.setUpdateSuspended(false);
            if (z10) {
                iVar.updateMenuView(false);
            }
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public class c extends RecyclerView.Adapter<l> {

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<e> f13291d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f13292e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f13293f;

        public c() {
            a();
        }

        public final void a() {
            if (this.f13293f) {
                return;
            }
            this.f13293f = true;
            ArrayList<e> arrayList = this.f13291d;
            arrayList.clear();
            arrayList.add(new d());
            i iVar = i.this;
            int size = iVar.f13277n.getVisibleItems().size();
            boolean z10 = false;
            int i10 = -1;
            int i11 = 0;
            boolean z11 = false;
            int size2 = 0;
            while (i11 < size) {
                androidx.appcompat.view.menu.g gVar = iVar.f13277n.getVisibleItems().get(i11);
                if (gVar.isChecked()) {
                    setCheckedItem(gVar);
                }
                if (gVar.isCheckable()) {
                    gVar.setExclusiveCheckable(z10);
                }
                if (gVar.hasSubMenu()) {
                    SubMenu subMenu = gVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i11 != 0) {
                            arrayList.add(new f(iVar.L, z10 ? 1 : 0));
                        }
                        arrayList.add(new g(gVar));
                        int size3 = subMenu.size();
                        int i12 = 0;
                        boolean z12 = false;
                        while (i12 < size3) {
                            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) subMenu.getItem(i12);
                            if (gVar2.isVisible()) {
                                if (!z12 && gVar2.getIcon() != null) {
                                    z12 = true;
                                }
                                if (gVar2.isCheckable()) {
                                    gVar2.setExclusiveCheckable(z10);
                                }
                                if (gVar.isChecked()) {
                                    setCheckedItem(gVar);
                                }
                                arrayList.add(new g(gVar2));
                            }
                            i12++;
                            z10 = false;
                        }
                        if (z12) {
                            int size4 = arrayList.size();
                            for (int size5 = arrayList.size(); size5 < size4; size5++) {
                                ((g) arrayList.get(size5)).f13298b = true;
                            }
                        }
                    }
                } else {
                    int groupId = gVar.getGroupId();
                    if (groupId != i10) {
                        size2 = arrayList.size();
                        z11 = gVar.getIcon() != null;
                        if (i11 != 0) {
                            size2++;
                            int i13 = iVar.L;
                            arrayList.add(new f(i13, i13));
                        }
                    } else {
                        if (!z11 && gVar.getIcon() != null) {
                            int size6 = arrayList.size();
                            for (int i14 = size2; i14 < size6; i14++) {
                                ((g) arrayList.get(i14)).f13298b = true;
                            }
                            z11 = true;
                        }
                        g gVar3 = new g(gVar);
                        gVar3.f13298b = z11;
                        arrayList.add(gVar3);
                        i10 = groupId;
                    }
                    g gVar32 = new g(gVar);
                    gVar32.f13298b = z11;
                    arrayList.add(gVar32);
                    i10 = groupId;
                }
                i11++;
                z10 = false;
            }
            this.f13293f = false;
        }

        public Bundle createInstanceState() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.g gVar = this.f13292e;
            if (gVar != null) {
                bundle.putInt("android:menu:checked", gVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            ArrayList<e> arrayList = this.f13291d;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.g menuItem = ((g) eVar).getMenuItem();
                    View actionView = menuItem != null ? menuItem.getActionView() : null;
                    if (actionView != null) {
                        i7.l lVar = new i7.l();
                        actionView.saveHierarchyState(lVar);
                        sparseArray.put(menuItem.getItemId(), lVar);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.g getCheckedItem() {
            return this.f13292e;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f13291d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            e eVar = this.f13291d.get(i10);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).getMenuItem().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void restoreInstanceState(Bundle bundle) {
            androidx.appcompat.view.menu.g menuItem;
            View actionView;
            i7.l lVar;
            androidx.appcompat.view.menu.g menuItem2;
            int i10 = bundle.getInt("android:menu:checked", 0);
            ArrayList<e> arrayList = this.f13291d;
            if (i10 != 0) {
                this.f13293f = true;
                int size = arrayList.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    e eVar = arrayList.get(i11);
                    if ((eVar instanceof g) && (menuItem2 = ((g) eVar).getMenuItem()) != null && menuItem2.getItemId() == i10) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i11++;
                }
                this.f13293f = false;
                a();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = arrayList.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e eVar2 = arrayList.get(i12);
                    if ((eVar2 instanceof g) && (menuItem = ((g) eVar2).getMenuItem()) != null && (actionView = menuItem.getActionView()) != null && (lVar = (i7.l) sparseParcelableArray.get(menuItem.getItemId())) != null) {
                        actionView.restoreHierarchyState(lVar);
                    }
                }
            }
        }

        public void setCheckedItem(androidx.appcompat.view.menu.g gVar) {
            if (this.f13292e == gVar || !gVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.g gVar2 = this.f13292e;
            if (gVar2 != null) {
                gVar2.setChecked(false);
            }
            this.f13292e = gVar;
            gVar.setChecked(true);
        }

        public void setUpdateSuspended(boolean z10) {
            this.f13293f = z10;
        }

        public void update() {
            a();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(l lVar, int i10) throws Resources.NotFoundException {
            int itemViewType = getItemViewType(i10);
            ArrayList<e> arrayList = this.f13291d;
            i iVar = i.this;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) arrayList.get(i10);
                    lVar.f4041a.setPadding(iVar.D, fVar.getPaddingTop(), iVar.E, fVar.getPaddingBottom());
                    return;
                }
                TextView textView = (TextView) lVar.f4041a;
                textView.setText(((g) arrayList.get(i10)).getMenuItem().getTitle());
                d1.i.setTextAppearance(textView, iVar.f13281r);
                textView.setPadding(iVar.F, textView.getPaddingTop(), iVar.G, textView.getPaddingBottom());
                ColorStateList colorStateList = iVar.f13282s;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                j0.setAccessibilityDelegate(textView, new i7.j(this, i10, true));
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.f4041a;
            navigationMenuItemView.setIconTintList(iVar.f13286w);
            navigationMenuItemView.setTextAppearance(iVar.f13283t);
            ColorStateList colorStateList2 = iVar.f13285v;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = iVar.f13287x;
            j0.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = iVar.f13288y;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) arrayList.get(i10);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f13298b);
            int i11 = iVar.f13289z;
            int i12 = iVar.A;
            navigationMenuItemView.setPadding(i11, i12, i11, i12);
            navigationMenuItemView.setIconPadding(iVar.B);
            if (iVar.H) {
                navigationMenuItemView.setIconSize(iVar.C);
            }
            navigationMenuItemView.setMaxLines(iVar.J);
            navigationMenuItemView.initialize(gVar.getMenuItem(), iVar.f13284u);
            j0.setAccessibilityDelegate(navigationMenuItemView, new i7.j(this, i10, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public l onCreateViewHolder(ViewGroup viewGroup, int i10) {
            i iVar = i.this;
            if (i10 == 0) {
                return new C0165i(iVar.f13280q, viewGroup, iVar.N);
            }
            if (i10 == 1) {
                return new k(iVar.f13280q, viewGroup);
            }
            if (i10 == 2) {
                return new j(iVar.f13280q, viewGroup);
            }
            if (i10 != 3) {
                return null;
            }
            return new b(iVar.f13276m);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(l lVar) {
            if (lVar instanceof C0165i) {
                ((NavigationMenuItemView) lVar.f4041a).recycle();
            }
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class d implements e {
    }

    /* compiled from: NavigationMenuPresenter.java */
    public interface e {
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class f implements e {

        /* renamed from: a, reason: collision with root package name */
        public final int f13295a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13296b;

        public f(int i10, int i11) {
            this.f13295a = i10;
            this.f13296b = i11;
        }

        public int getPaddingBottom() {
            return this.f13296b;
        }

        public int getPaddingTop() {
            return this.f13295a;
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.g f13297a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13298b;

        public g(androidx.appcompat.view.menu.g gVar) {
            this.f13297a = gVar;
        }

        public androidx.appcompat.view.menu.g getMenuItem() {
            return this.f13297a;
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public class h extends androidx.recyclerview.widget.s {
        public h(NavigationMenuView navigationMenuView) {
            super(navigationMenuView);
        }

        @Override // androidx.recyclerview.widget.s, x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            c cVar = i.this.f13279p;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                i iVar = i.this;
                if (i10 >= iVar.f13279p.getItemCount()) {
                    dVar.setCollectionInfo(d.e.obtain(i11, 1, false));
                    return;
                }
                int itemViewType = iVar.f13279p.getItemViewType(i10);
                if (itemViewType == 0 || itemViewType == 1) {
                    i11++;
                }
                i10++;
            }
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    /* renamed from: i7.i$i, reason: collision with other inner class name */
    public static class C0165i extends l {
        public C0165i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.f4041a.setOnClickListener(onClickListener);
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    public static abstract class l extends RecyclerView.z {
        public l(View view) {
            super(view);
        }
    }

    public final void a() {
        int i10 = ((getHeaderCount() > 0) || !this.I) ? 0 : this.K;
        NavigationMenuView navigationMenuView = this.f13275b;
        navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(View view) {
        this.f13276m.addView(view);
        NavigationMenuView navigationMenuView = this.f13275b;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean collapseItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    public void dispatchApplyWindowInsets(y0 y0Var) {
        int systemWindowInsetTop = y0Var.getSystemWindowInsetTop();
        if (this.K != systemWindowInsetTop) {
            this.K = systemWindowInsetTop;
            a();
        }
        NavigationMenuView navigationMenuView = this.f13275b;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, y0Var.getSystemWindowInsetBottom());
        j0.dispatchApplyWindowInsets(this.f13276m, y0Var);
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean expandItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean flagActionItems() {
        return false;
    }

    public androidx.appcompat.view.menu.g getCheckedItem() {
        return this.f13279p.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.E;
    }

    public int getDividerInsetStart() {
        return this.D;
    }

    public int getHeaderCount() {
        return this.f13276m.getChildCount();
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return this.f13278o;
    }

    public Drawable getItemBackground() {
        return this.f13287x;
    }

    public int getItemHorizontalPadding() {
        return this.f13289z;
    }

    public int getItemIconPadding() {
        return this.B;
    }

    public int getItemMaxLines() {
        return this.J;
    }

    public ColorStateList getItemTextColor() {
        return this.f13285v;
    }

    public ColorStateList getItemTintList() {
        return this.f13286w;
    }

    public int getItemVerticalPadding() {
        return this.A;
    }

    public androidx.appcompat.view.menu.j getMenuView(ViewGroup viewGroup) {
        if (this.f13275b == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f13280q.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f13275b = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f13275b));
            if (this.f13279p == null) {
                c cVar = new c();
                this.f13279p = cVar;
                cVar.setHasStableIds(true);
            }
            int i10 = this.M;
            if (i10 != -1) {
                this.f13275b.setOverScrollMode(i10);
            }
            LinearLayout linearLayout = (LinearLayout) this.f13280q.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f13275b, false);
            this.f13276m = linearLayout;
            j0.setImportantForAccessibility(linearLayout, 2);
            this.f13275b.setAdapter(this.f13279p);
        }
        return this.f13275b;
    }

    public int getSubheaderInsetEnd() {
        return this.G;
    }

    public int getSubheaderInsetStart() {
        return this.F;
    }

    public View inflateHeaderView(int i10) {
        View viewInflate = this.f13280q.inflate(i10, (ViewGroup) this.f13276m, false);
        addHeaderView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.appcompat.view.menu.i
    public void initForMenu(Context context, androidx.appcompat.view.menu.e eVar) {
        this.f13280q = LayoutInflater.from(context);
        this.f13277n = eVar;
        this.L = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f13275b.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f13279p.restoreInstanceState(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f13276m.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f13275b != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f13275b.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f13279p;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.createInstanceState());
        }
        if (this.f13276m != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f13276m.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.l lVar) {
        return false;
    }

    public void setBehindStatusBar(boolean z10) {
        if (this.I != z10) {
            this.I = z10;
            a();
        }
    }

    public void setCheckedItem(androidx.appcompat.view.menu.g gVar) {
        this.f13279p.setCheckedItem(gVar);
    }

    public void setDividerInsetEnd(int i10) {
        this.E = i10;
        updateMenuView(false);
    }

    public void setDividerInsetStart(int i10) {
        this.D = i10;
        updateMenuView(false);
    }

    public void setId(int i10) {
        this.f13278o = i10;
    }

    public void setItemBackground(Drawable drawable) {
        this.f13287x = drawable;
        updateMenuView(false);
    }

    public void setItemForeground(RippleDrawable rippleDrawable) {
        this.f13288y = rippleDrawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i10) {
        this.f13289z = i10;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i10) {
        this.B = i10;
        updateMenuView(false);
    }

    public void setItemIconSize(int i10) {
        if (this.C != i10) {
            this.C = i10;
            this.H = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f13286w = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i10) {
        this.J = i10;
        updateMenuView(false);
    }

    public void setItemTextAppearance(int i10) {
        this.f13283t = i10;
        updateMenuView(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f13284u = z10;
        updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13285v = colorStateList;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(int i10) {
        this.A = i10;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i10) {
        this.M = i10;
        NavigationMenuView navigationMenuView = this.f13275b;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i10);
        }
    }

    public void setSubheaderColor(ColorStateList colorStateList) {
        this.f13282s = colorStateList;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(int i10) {
        this.G = i10;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(int i10) {
        this.F = i10;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(int i10) {
        this.f13281r = i10;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z10) {
        c cVar = this.f13279p;
        if (cVar != null) {
            cVar.setUpdateSuspended(z10);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void updateMenuView(boolean z10) {
        c cVar = this.f13279p;
        if (cVar != null) {
            cVar.update();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
    }
}
