package androidx.leanback.widget;

import java.util.ArrayList;

/* compiled from: ArrayObjectAdapter.java */
/* loaded from: classes.dex */
public final class a extends y {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3189c;

    public a(f0 f0Var) {
        super(f0Var);
        this.f3189c = new ArrayList();
        new ArrayList();
    }

    public void add(Object obj) {
        add(this.f3189c.size(), obj);
    }

    @Override // androidx.leanback.widget.y
    public Object get(int i10) {
        return this.f3189c.get(i10);
    }

    public void notifyArrayItemRangeChanged(int i10, int i11) {
        notifyItemRangeChanged(i10, i11);
    }

    public boolean remove(Object obj) {
        ArrayList arrayList = this.f3189c;
        int iIndexOf = arrayList.indexOf(obj);
        if (iIndexOf >= 0) {
            arrayList.remove(iIndexOf);
            notifyItemRangeRemoved(iIndexOf, 1);
        }
        return iIndexOf >= 0;
    }

    @Override // androidx.leanback.widget.y
    public int size() {
        return this.f3189c.size();
    }

    public void add(int i10, Object obj) {
        this.f3189c.add(i10, obj);
        notifyItemRangeInserted(i10, 1);
    }
}
