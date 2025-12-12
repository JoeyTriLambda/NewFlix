package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public final class c implements i, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public Context f968b;

    /* renamed from: m, reason: collision with root package name */
    public LayoutInflater f969m;

    /* renamed from: n, reason: collision with root package name */
    public e f970n;

    /* renamed from: o, reason: collision with root package name */
    public ExpandedMenuView f971o;

    /* renamed from: p, reason: collision with root package name */
    public final int f972p;

    /* renamed from: q, reason: collision with root package name */
    public final int f973q;

    /* renamed from: r, reason: collision with root package name */
    public i.a f974r;

    /* renamed from: s, reason: collision with root package name */
    public a f975s;

    /* compiled from: ListMenuPresenter.java */
    public class a extends BaseAdapter {

        /* renamed from: b, reason: collision with root package name */
        public int f976b = -1;

        public a() {
            a();
        }

        public final void a() {
            c cVar = c.this;
            g expandedItem = cVar.f970n.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<g> nonActionItems = cVar.f970n.getNonActionItems();
                int size = nonActionItems.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (nonActionItems.get(i10) == expandedItem) {
                        this.f976b = i10;
                        return;
                    }
                }
            }
            this.f976b = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            c cVar = c.this;
            int size = cVar.f970n.getNonActionItems().size();
            cVar.getClass();
            int i10 = size + 0;
            return this.f976b < 0 ? i10 : i10 - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f969m.inflate(cVar.f973q, viewGroup, false);
            }
            ((j.a) view).initialize(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public g getItem(int i10) {
            c cVar = c.this;
            ArrayList<g> nonActionItems = cVar.f970n.getNonActionItems();
            cVar.getClass();
            int i11 = i10 + 0;
            int i12 = this.f976b;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return nonActionItems.get(i11);
        }
    }

    public c(Context context, int i10) {
        this(i10, 0);
        this.f968b = context;
        this.f969m = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean collapseItemActionView(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean expandItemActionView(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.f975s == null) {
            this.f975s = new a();
        }
        return this.f975s;
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return 0;
    }

    public j getMenuView(ViewGroup viewGroup) {
        if (this.f971o == null) {
            this.f971o = (ExpandedMenuView) this.f969m.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f975s == null) {
                this.f975s = new a();
            }
            this.f971o.setAdapter((ListAdapter) this.f975s);
            this.f971o.setOnItemClickListener(this);
        }
        return this.f971o;
    }

    @Override // androidx.appcompat.view.menu.i
    public void initForMenu(Context context, e eVar) {
        int i10 = this.f972p;
        if (i10 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
            this.f968b = contextThemeWrapper;
            this.f969m = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f968b != null) {
            this.f968b = context;
            if (this.f969m == null) {
                this.f969m = LayoutInflater.from(context);
            }
        }
        this.f970n = eVar;
        a aVar = this.f975s;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void onCloseMenu(e eVar, boolean z10) {
        i.a aVar = this.f974r;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, z10);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f970n.performItemAction(this.f975s.getItem(i10), this, 0);
    }

    @Override // androidx.appcompat.view.menu.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable onSaveInstanceState() {
        if (this.f971o == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean onSubMenuSelected(l lVar) {
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        new f(lVar).show(null);
        i.a aVar = this.f974r;
        if (aVar == null) {
            return true;
        }
        aVar.onOpenSubMenu(lVar);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f971o.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f971o;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // androidx.appcompat.view.menu.i
    public void setCallback(i.a aVar) {
        this.f974r = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void updateMenuView(boolean z10) {
        a aVar = this.f975s;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public c(int i10, int i11) {
        this.f973q = i10;
        this.f972p = i11;
    }
}
