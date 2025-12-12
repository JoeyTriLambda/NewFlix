package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public final class d extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final e f978b;

    /* renamed from: m, reason: collision with root package name */
    public int f979m = -1;

    /* renamed from: n, reason: collision with root package name */
    public boolean f980n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f981o;

    /* renamed from: p, reason: collision with root package name */
    public final LayoutInflater f982p;

    /* renamed from: q, reason: collision with root package name */
    public final int f983q;

    public d(e eVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f981o = z10;
        this.f982p = layoutInflater;
        this.f978b = eVar;
        this.f983q = i10;
        a();
    }

    public final void a() {
        e eVar = this.f978b;
        g expandedItem = eVar.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<g> nonActionItems = eVar.getNonActionItems();
            int size = nonActionItems.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (nonActionItems.get(i10) == expandedItem) {
                    this.f979m = i10;
                    return;
                }
            }
        }
        this.f979m = -1;
    }

    public e getAdapterMenu() {
        return this.f978b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        boolean z10 = this.f981o;
        e eVar = this.f978b;
        return this.f979m < 0 ? (z10 ? eVar.getNonActionItems() : eVar.getVisibleItems()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f982p.inflate(this.f983q, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f978b.isGroupDividerEnabled() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        j.a aVar = (j.a) view;
        if (this.f980n) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z10) {
        this.f980n = z10;
    }

    @Override // android.widget.Adapter
    public g getItem(int i10) {
        boolean z10 = this.f981o;
        e eVar = this.f978b;
        ArrayList<g> nonActionItems = z10 ? eVar.getNonActionItems() : eVar.getVisibleItems();
        int i11 = this.f979m;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return nonActionItems.get(i10);
    }
}
