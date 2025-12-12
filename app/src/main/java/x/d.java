package x;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.i;

/* compiled from: MenuPopup.java */
/* loaded from: classes.dex */
public abstract class d implements f, i, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public Rect f21213b;

    public static int measureIndividualMenuWidth(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i10) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i13, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    public static boolean shouldPreserveIconSpacing(androidx.appcompat.view.menu.e eVar) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static androidx.appcompat.view.menu.d toMenuAdapter(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) listAdapter;
    }

    public abstract void addMenu(androidx.appcompat.view.menu.e eVar);

    public boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean collapseItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean expandItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    public Rect getEpicenterBounds() {
        return this.f21213b;
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        toMenuAdapter(listAdapter).f978b.performItemAction((MenuItem) listAdapter.getItem(i10), this, closeMenuOnSubMenuOpened() ? 0 : 4);
    }

    public abstract void setAnchorView(View view);

    public void setEpicenterBounds(Rect rect) {
        this.f21213b = rect;
    }

    public abstract void setForceShowIcon(boolean z10);

    public abstract void setGravity(int i10);

    public abstract void setHorizontalOffset(int i10);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z10);

    public abstract void setVerticalOffset(int i10);

    @Override // androidx.appcompat.view.menu.i
    public void initForMenu(Context context, androidx.appcompat.view.menu.e eVar) {
    }
}
