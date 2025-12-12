package androidx.leanback.widget;

import androidx.leanback.widget.i;
import androidx.leanback.widget.j;

/* compiled from: StaggeredGrid.java */
/* loaded from: classes.dex */
public abstract class v0 extends i {

    /* renamed from: j, reason: collision with root package name */
    public final b0.e<a> f3400j = new b0.e<>(64);

    /* renamed from: k, reason: collision with root package name */
    public int f3401k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Object f3402l;

    /* renamed from: m, reason: collision with root package name */
    public int f3403m;

    /* compiled from: StaggeredGrid.java */
    public static class a extends i.a {

        /* renamed from: b, reason: collision with root package name */
        public int f3404b;

        /* renamed from: c, reason: collision with root package name */
        public int f3405c;

        public a(int i10, int i11, int i12) {
            super(i10);
            this.f3404b = i11;
            this.f3405c = i12;
        }
    }

    public final boolean appendVisbleItemsWithCache(int i10, boolean z10) {
        int i11;
        int edge;
        int i12;
        b0.e<a> eVar = this.f3400j;
        if (eVar.size() == 0) {
            return false;
        }
        int count = ((j.b) this.f3230b).getCount();
        int i13 = this.f3235g;
        if (i13 >= 0) {
            i11 = i13 + 1;
            edge = ((j.b) this.f3230b).getEdge(i13);
        } else {
            int i14 = this.f3237i;
            i11 = i14 != -1 ? i14 : 0;
            if (i11 > getLastIndex() + 1 || i11 < getFirstIndex()) {
                eVar.clear();
                return false;
            }
            if (i11 > getLastIndex()) {
                return false;
            }
            edge = Integer.MAX_VALUE;
        }
        int lastIndex = getLastIndex();
        int i15 = i11;
        while (i15 < count && i15 <= lastIndex) {
            a location = getLocation(i15);
            if (edge != Integer.MAX_VALUE) {
                edge += location.f3404b;
            }
            int i16 = location.f3238a;
            j.b bVar = (j.b) this.f3230b;
            Object[] objArr = this.f3229a;
            int iCreateItem = bVar.createItem(i15, true, objArr, false);
            if (iCreateItem != location.f3405c) {
                location.f3405c = iCreateItem;
                eVar.removeFromEnd(lastIndex - i15);
                i12 = i15;
            } else {
                i12 = lastIndex;
            }
            this.f3235g = i15;
            if (this.f3234f < 0) {
                this.f3234f = i15;
            }
            ((j.b) this.f3230b).addItem(objArr[0], i15, iCreateItem, i16, edge);
            if (!z10 && checkAppendOverLimit(i10)) {
                return true;
            }
            if (edge == Integer.MAX_VALUE) {
                edge = ((j.b) this.f3230b).getEdge(i15);
            }
            if (i16 == this.f3233e - 1 && z10) {
                return true;
            }
            i15++;
            lastIndex = i12;
        }
        return false;
    }

    public final int appendVisibleItemToRow(int i10, int i11, int i12) {
        int edge;
        boolean z10;
        int i13 = this.f3235g;
        if (i13 >= 0 && (i13 != getLastIndex() || this.f3235g != i10 - 1)) {
            throw new IllegalStateException();
        }
        int i14 = this.f3235g;
        b0.e<a> eVar = this.f3400j;
        if (i14 >= 0) {
            edge = i12 - ((j.b) this.f3230b).getEdge(i14);
        } else if (eVar.size() <= 0 || i10 != getLastIndex() + 1) {
            edge = 0;
        } else {
            int lastIndex = getLastIndex();
            while (true) {
                if (lastIndex < this.f3401k) {
                    z10 = false;
                    break;
                }
                if (getLocation(lastIndex).f3238a == i11) {
                    z10 = true;
                    break;
                }
                lastIndex--;
            }
            if (!z10) {
                lastIndex = getLastIndex();
            }
            edge = isReversedFlow() ? (-getLocation(lastIndex).f3405c) - this.f3232d : getLocation(lastIndex).f3405c + this.f3232d;
            for (int i15 = lastIndex + 1; i15 <= getLastIndex(); i15++) {
                edge -= getLocation(i15).f3404b;
            }
        }
        a aVar = new a(i11, edge, 0);
        eVar.addLast(aVar);
        Object obj = this.f3402l;
        if (obj != null) {
            aVar.f3405c = this.f3403m;
            this.f3402l = null;
        } else {
            j.b bVar = (j.b) this.f3230b;
            Object[] objArr = this.f3229a;
            aVar.f3405c = bVar.createItem(i10, true, objArr, false);
            obj = objArr[0];
        }
        Object obj2 = obj;
        if (eVar.size() == 1) {
            this.f3235g = i10;
            this.f3234f = i10;
            this.f3401k = i10;
        } else {
            int i16 = this.f3235g;
            if (i16 < 0) {
                this.f3235g = i10;
                this.f3234f = i10;
            } else {
                this.f3235g = i16 + 1;
            }
        }
        ((j.b) this.f3230b).addItem(obj2, i10, aVar.f3405c, i11, i12);
        return aVar.f3405c;
    }

    @Override // androidx.leanback.widget.i
    public final boolean appendVisibleItems(int i10, boolean z10) {
        Object[] objArr = this.f3229a;
        if (((j.b) this.f3230b).getCount() == 0) {
            return false;
        }
        if (!z10 && checkAppendOverLimit(i10)) {
            return false;
        }
        try {
            if (!appendVisbleItemsWithCache(i10, z10)) {
                return appendVisibleItemsWithoutCache(i10, z10);
            }
            objArr[0] = null;
            this.f3402l = null;
            return true;
        } finally {
            objArr[0] = null;
            this.f3402l = null;
        }
    }

    public abstract boolean appendVisibleItemsWithoutCache(int i10, boolean z10);

    public final int getFirstIndex() {
        return this.f3401k;
    }

    @Override // androidx.leanback.widget.i
    public final b0.f[] getItemPositionsInRows(int i10, int i11) {
        for (int i12 = 0; i12 < this.f3233e; i12++) {
            this.f3236h[i12].clear();
        }
        if (i10 >= 0) {
            while (i10 <= i11) {
                b0.f fVar = this.f3236h[getLocation(i10).f3238a];
                if (fVar.size() <= 0 || fVar.getLast() != i10 - 1) {
                    fVar.addLast(i10);
                    fVar.addLast(i10);
                } else {
                    fVar.popLast();
                    fVar.addLast(i10);
                }
                i10++;
            }
        }
        return this.f3236h;
    }

    public final int getLastIndex() {
        return (this.f3400j.size() + this.f3401k) - 1;
    }

    @Override // androidx.leanback.widget.i
    public void invalidateItemsAfter(int i10) {
        super.invalidateItemsAfter(i10);
        int lastIndex = (getLastIndex() - i10) + 1;
        b0.e<a> eVar = this.f3400j;
        eVar.removeFromEnd(lastIndex);
        if (eVar.size() == 0) {
            this.f3401k = -1;
        }
    }

    public final boolean prependVisbleItemsWithCache(int i10, boolean z10) {
        int i11;
        int edge;
        int i12;
        b0.e<a> eVar = this.f3400j;
        if (eVar.size() == 0) {
            return false;
        }
        int i13 = this.f3234f;
        if (i13 >= 0) {
            edge = ((j.b) this.f3230b).getEdge(i13);
            i12 = getLocation(this.f3234f).f3404b;
            i11 = this.f3234f - 1;
        } else {
            int i14 = this.f3237i;
            i11 = i14 != -1 ? i14 : 0;
            if (i11 > getLastIndex() || i11 < getFirstIndex() - 1) {
                eVar.clear();
                return false;
            }
            if (i11 < getFirstIndex()) {
                return false;
            }
            edge = Integer.MAX_VALUE;
            i12 = 0;
        }
        int iMax = Math.max(((j.b) this.f3230b).getMinIndex(), this.f3401k);
        while (i11 >= iMax) {
            a location = getLocation(i11);
            int i15 = location.f3238a;
            j.b bVar = (j.b) this.f3230b;
            Object[] objArr = this.f3229a;
            int iCreateItem = bVar.createItem(i11, false, objArr, false);
            if (iCreateItem != location.f3405c) {
                eVar.removeFromStart((i11 + 1) - this.f3401k);
                this.f3401k = this.f3234f;
                this.f3402l = objArr[0];
                this.f3403m = iCreateItem;
                return false;
            }
            this.f3234f = i11;
            if (this.f3235g < 0) {
                this.f3235g = i11;
            }
            ((j.b) this.f3230b).addItem(objArr[0], i11, iCreateItem, i15, edge - i12);
            if (!z10 && checkPrependOverLimit(i10)) {
                return true;
            }
            edge = ((j.b) this.f3230b).getEdge(i11);
            i12 = location.f3404b;
            if (i15 == 0 && z10) {
                return true;
            }
            i11--;
        }
        return false;
    }

    public final int prependVisibleItemToRow(int i10, int i11, int i12) {
        int i13 = this.f3234f;
        if (i13 >= 0 && (i13 != getFirstIndex() || this.f3234f != i10 + 1)) {
            throw new IllegalStateException();
        }
        int i14 = this.f3401k;
        a location = i14 >= 0 ? getLocation(i14) : null;
        int edge = ((j.b) this.f3230b).getEdge(this.f3401k);
        a aVar = new a(i11, 0, 0);
        this.f3400j.addFirst(aVar);
        Object obj = this.f3402l;
        if (obj != null) {
            aVar.f3405c = this.f3403m;
            this.f3402l = null;
        } else {
            j.b bVar = (j.b) this.f3230b;
            Object[] objArr = this.f3229a;
            aVar.f3405c = bVar.createItem(i10, false, objArr, false);
            obj = objArr[0];
        }
        Object obj2 = obj;
        this.f3234f = i10;
        this.f3401k = i10;
        if (this.f3235g < 0) {
            this.f3235g = i10;
        }
        int i15 = !this.f3231c ? i12 - aVar.f3405c : i12 + aVar.f3405c;
        if (location != null) {
            location.f3404b = edge - i15;
        }
        ((j.b) this.f3230b).addItem(obj2, i10, aVar.f3405c, i11, i15);
        return aVar.f3405c;
    }

    @Override // androidx.leanback.widget.i
    public final boolean prependVisibleItems(int i10, boolean z10) {
        Object[] objArr = this.f3229a;
        if (((j.b) this.f3230b).getCount() == 0) {
            return false;
        }
        if (!z10 && checkPrependOverLimit(i10)) {
            return false;
        }
        try {
            if (!prependVisbleItemsWithCache(i10, z10)) {
                return prependVisibleItemsWithoutCache(i10, z10);
            }
            objArr[0] = null;
            this.f3402l = null;
            return true;
        } finally {
            objArr[0] = null;
            this.f3402l = null;
        }
    }

    public abstract boolean prependVisibleItemsWithoutCache(int i10, boolean z10);

    @Override // androidx.leanback.widget.i
    public final a getLocation(int i10) {
        int i11 = i10 - this.f3401k;
        if (i11 < 0) {
            return null;
        }
        b0.e<a> eVar = this.f3400j;
        if (i11 >= eVar.size()) {
            return null;
        }
        return eVar.get(i11);
    }
}
