package androidx.leanback.widget;

import androidx.leanback.widget.i;
import androidx.leanback.widget.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;

/* compiled from: SingleRow.java */
/* loaded from: classes.dex */
public final class t0 extends i {

    /* renamed from: j, reason: collision with root package name */
    public final i.a f3372j = new i.a(0);

    public t0() {
        a(1);
    }

    @Override // androidx.leanback.widget.i
    public final boolean appendVisibleItems(int i10, boolean z10) {
        int size;
        if (((j.b) this.f3230b).getCount() == 0) {
            return false;
        }
        if (!z10 && checkAppendOverLimit(i10)) {
            return false;
        }
        int iB = b();
        boolean z11 = false;
        while (iB < ((j.b) this.f3230b).getCount()) {
            j.b bVar = (j.b) this.f3230b;
            Object[] objArr = this.f3229a;
            int iCreateItem = bVar.createItem(iB, true, objArr, false);
            if (this.f3234f < 0 || this.f3235g < 0) {
                size = this.f3231c ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                this.f3234f = iB;
                this.f3235g = iB;
            } else {
                if (this.f3231c) {
                    int i11 = iB - 1;
                    size = (((j.b) this.f3230b).getEdge(i11) - ((j.b) this.f3230b).getSize(i11)) - this.f3232d;
                } else {
                    int i12 = iB - 1;
                    size = this.f3232d + ((j.b) this.f3230b).getSize(i12) + ((j.b) this.f3230b).getEdge(i12);
                }
                this.f3235g = iB;
            }
            ((j.b) this.f3230b).addItem(objArr[0], iB, iCreateItem, 0, size);
            if (z10 || checkAppendOverLimit(i10)) {
                return true;
            }
            iB++;
            z11 = true;
        }
        return z11;
    }

    public final int b() {
        int i10 = this.f3235g;
        if (i10 >= 0) {
            return i10 + 1;
        }
        int i11 = this.f3237i;
        if (i11 != -1) {
            return Math.min(i11, ((j.b) this.f3230b).getCount() - 1);
        }
        return 0;
    }

    public final int c() {
        int i10 = this.f3234f;
        if (i10 >= 0) {
            return i10 - 1;
        }
        int i11 = this.f3237i;
        return i11 != -1 ? Math.min(i11, ((j.b) this.f3230b).getCount() - 1) : ((j.b) this.f3230b).getCount() - 1;
    }

    @Override // androidx.leanback.widget.i
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.l.c cVar) {
        int iC;
        int edge;
        if (!this.f3231c ? i11 < 0 : i11 > 0) {
            if (getLastVisibleIndex() == ((j.b) this.f3230b).getCount() - 1) {
                return;
            }
            iC = b();
            int size = ((j.b) this.f3230b).getSize(this.f3235g) + this.f3232d;
            int edge2 = ((j.b) this.f3230b).getEdge(this.f3235g);
            if (this.f3231c) {
                size = -size;
            }
            edge = size + edge2;
        } else {
            if (getFirstVisibleIndex() == 0) {
                return;
            }
            iC = c();
            edge = ((j.b) this.f3230b).getEdge(this.f3234f) + (this.f3231c ? this.f3232d : -this.f3232d);
        }
        ((k.b) cVar).addPosition(iC, Math.abs(edge - i10));
    }

    @Override // androidx.leanback.widget.i
    public final int findRowMax(boolean z10, int i10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        return this.f3231c ? ((j.b) this.f3230b).getEdge(i10) : ((j.b) this.f3230b).getEdge(i10) + ((j.b) this.f3230b).getSize(i10);
    }

    @Override // androidx.leanback.widget.i
    public final int findRowMin(boolean z10, int i10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        return this.f3231c ? ((j.b) this.f3230b).getEdge(i10) - ((j.b) this.f3230b).getSize(i10) : ((j.b) this.f3230b).getEdge(i10);
    }

    @Override // androidx.leanback.widget.i
    public final b0.f[] getItemPositionsInRows(int i10, int i11) {
        this.f3236h[0].clear();
        this.f3236h[0].addLast(i10);
        this.f3236h[0].addLast(i11);
        return this.f3236h;
    }

    @Override // androidx.leanback.widget.i
    public final i.a getLocation(int i10) {
        return this.f3372j;
    }

    @Override // androidx.leanback.widget.i
    public final boolean prependVisibleItems(int i10, boolean z10) {
        int edge;
        if (((j.b) this.f3230b).getCount() == 0) {
            return false;
        }
        if (!z10 && checkPrependOverLimit(i10)) {
            return false;
        }
        int minIndex = ((j.b) this.f3230b).getMinIndex();
        boolean z11 = false;
        for (int iC = c(); iC >= minIndex; iC--) {
            j.b bVar = (j.b) this.f3230b;
            Object[] objArr = this.f3229a;
            int iCreateItem = bVar.createItem(iC, false, objArr, false);
            if (this.f3234f < 0 || this.f3235g < 0) {
                edge = this.f3231c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                this.f3234f = iC;
                this.f3235g = iC;
            } else {
                edge = this.f3231c ? ((j.b) this.f3230b).getEdge(iC + 1) + this.f3232d + iCreateItem : (((j.b) this.f3230b).getEdge(iC + 1) - this.f3232d) - iCreateItem;
                this.f3234f = iC;
            }
            ((j.b) this.f3230b).addItem(objArr[0], iC, iCreateItem, 0, edge);
            z11 = true;
            if (z10 || checkPrependOverLimit(i10)) {
                break;
            }
        }
        return z11;
    }
}
