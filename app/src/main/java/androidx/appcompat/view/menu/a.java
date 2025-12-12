package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class a implements i {

    /* renamed from: b, reason: collision with root package name */
    public final Context f935b;

    /* renamed from: m, reason: collision with root package name */
    public Context f936m;

    /* renamed from: n, reason: collision with root package name */
    public e f937n;

    /* renamed from: o, reason: collision with root package name */
    public final LayoutInflater f938o;

    /* renamed from: p, reason: collision with root package name */
    public i.a f939p;

    /* renamed from: q, reason: collision with root package name */
    public final int f940q;

    /* renamed from: r, reason: collision with root package name */
    public final int f941r;

    /* renamed from: s, reason: collision with root package name */
    public j f942s;

    /* renamed from: t, reason: collision with root package name */
    public int f943t;

    public a(Context context, int i10, int i11) {
        this.f935b = context;
        this.f938o = LayoutInflater.from(context);
        this.f940q = i10;
        this.f941r = i11;
    }

    public void addItemView(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f942s).addView(view, i10);
    }

    public abstract void bindItemView(g gVar, j.a aVar);

    @Override // androidx.appcompat.view.menu.i
    public boolean collapseItemActionView(e eVar, g gVar) {
        return false;
    }

    public j.a createItemView(ViewGroup viewGroup) {
        return (j.a) this.f938o.inflate(this.f941r, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean expandItemActionView(e eVar, g gVar) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public i.a getCallback() {
        return this.f939p;
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return this.f943t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getItemView(g gVar, View view, ViewGroup viewGroup) {
        j.a aVarCreateItemView = view instanceof j.a ? (j.a) view : createItemView(viewGroup);
        bindItemView(gVar, aVarCreateItemView);
        return (View) aVarCreateItemView;
    }

    public j getMenuView(ViewGroup viewGroup) {
        if (this.f942s == null) {
            j jVar = (j) this.f938o.inflate(this.f940q, viewGroup, false);
            this.f942s = jVar;
            jVar.initialize(this.f937n);
            updateMenuView(true);
        }
        return this.f942s;
    }

    @Override // androidx.appcompat.view.menu.i
    public void initForMenu(Context context, e eVar) {
        this.f936m = context;
        LayoutInflater.from(context);
        this.f937n = eVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void onCloseMenu(e eVar, boolean z10) {
        i.a aVar = this.f939p;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.i
    public boolean onSubMenuSelected(l lVar) {
        i.a aVar = this.f939p;
        l lVar2 = lVar;
        if (aVar == null) {
            return false;
        }
        if (lVar == null) {
            lVar2 = this.f937n;
        }
        return aVar.onOpenSubMenu(lVar2);
    }

    @Override // androidx.appcompat.view.menu.i
    public void setCallback(i.a aVar) {
        this.f939p = aVar;
    }

    public void setId(int i10) {
        this.f943t = i10;
    }

    public abstract boolean shouldIncludeItem(int i10, g gVar);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.i
    public void updateMenuView(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f942s;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f937n;
        int i10 = 0;
        if (eVar != null) {
            eVar.flagActionItems();
            ArrayList<g> visibleItems = this.f937n.getVisibleItems();
            int size = visibleItems.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                g gVar = visibleItems.get(i12);
                if (shouldIncludeItem(i11, gVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    g itemData = childAt instanceof j.a ? ((j.a) childAt).getItemData() : null;
                    View itemView = getItemView(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        itemView.setPressed(false);
                        itemView.jumpDrawablesToCurrentState();
                    }
                    if (itemView != childAt) {
                        addItemView(itemView, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!filterLeftoverView(viewGroup, i10)) {
                i10++;
            }
        }
    }
}
