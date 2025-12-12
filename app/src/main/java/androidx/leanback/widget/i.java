package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.leanback.widget.j;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* compiled from: Grid.java */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    public b f3230b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3231c;

    /* renamed from: d, reason: collision with root package name */
    public int f3232d;

    /* renamed from: e, reason: collision with root package name */
    public int f3233e;

    /* renamed from: h, reason: collision with root package name */
    public b0.f[] f3236h;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f3229a = new Object[1];

    /* renamed from: f, reason: collision with root package name */
    public int f3234f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f3235g = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f3237i = -1;

    /* compiled from: Grid.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3238a;

        public a(int i10) {
            this.f3238a = i10;
        }
    }

    /* compiled from: Grid.java */
    public interface b {
    }

    public static i createGrid(int i10) {
        if (i10 == 1) {
            return new t0();
        }
        w0 w0Var = new w0();
        w0Var.a(i10);
        return w0Var;
    }

    public final void a(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.f3233e == i10) {
            return;
        }
        this.f3233e = i10;
        this.f3236h = new b0.f[i10];
        for (int i11 = 0; i11 < this.f3233e; i11++) {
            this.f3236h[i11] = new b0.f();
        }
    }

    public boolean appendOneColumnVisibleItems() {
        return appendVisibleItems(this.f3231c ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public final void appendVisibleItems(int i10) {
        appendVisibleItems(i10, false);
    }

    public abstract boolean appendVisibleItems(int i10, boolean z10);

    public final boolean checkAppendOverLimit(int i10) {
        if (this.f3235g < 0) {
            return false;
        }
        if (this.f3231c) {
            if (findRowMin(true, null) > i10 + this.f3232d) {
                return false;
            }
        } else if (findRowMax(false, null) < i10 - this.f3232d) {
            return false;
        }
        return true;
    }

    public final boolean checkPrependOverLimit(int i10) {
        if (this.f3235g < 0) {
            return false;
        }
        if (this.f3231c) {
            if (findRowMax(false, null) < i10 - this.f3232d) {
                return false;
            }
        } else if (findRowMin(true, null) > i10 + this.f3232d) {
            return false;
        }
        return true;
    }

    public void fillDisappearingItems(int[] iArr, int i10, SparseIntArray sparseIntArray) {
        int lastVisibleIndex = getLastVisibleIndex();
        int iBinarySearch = lastVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i10, lastVisibleIndex) : 0;
        Object[] objArr = this.f3229a;
        if (iBinarySearch < 0) {
            int edge = this.f3231c ? (((j.b) this.f3230b).getEdge(lastVisibleIndex) - ((j.b) this.f3230b).getSize(lastVisibleIndex)) - this.f3232d : this.f3232d + ((j.b) this.f3230b).getSize(lastVisibleIndex) + ((j.b) this.f3230b).getEdge(lastVisibleIndex);
            for (int i11 = (-iBinarySearch) - 1; i11 < i10; i11++) {
                int i12 = iArr[i11];
                int i13 = sparseIntArray.get(i12);
                int i14 = i13 < 0 ? 0 : i13;
                int iCreateItem = ((j.b) this.f3230b).createItem(i12, true, objArr, true);
                ((j.b) this.f3230b).addItem(objArr[0], i12, iCreateItem, i14, edge);
                edge = this.f3231c ? (edge - iCreateItem) - this.f3232d : edge + iCreateItem + this.f3232d;
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        int iBinarySearch2 = firstVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i10, firstVisibleIndex) : 0;
        if (iBinarySearch2 < 0) {
            int edge2 = this.f3231c ? ((j.b) this.f3230b).getEdge(firstVisibleIndex) : ((j.b) this.f3230b).getEdge(firstVisibleIndex);
            for (int i15 = (-iBinarySearch2) - 2; i15 >= 0; i15--) {
                int i16 = iArr[i15];
                int i17 = sparseIntArray.get(i16);
                int i18 = i17 < 0 ? 0 : i17;
                int iCreateItem2 = ((j.b) this.f3230b).createItem(i16, false, objArr, true);
                edge2 = this.f3231c ? edge2 + this.f3232d + iCreateItem2 : (edge2 - this.f3232d) - iCreateItem2;
                ((j.b) this.f3230b).addItem(objArr[0], i16, iCreateItem2, i18, edge2);
            }
        }
    }

    public abstract int findRowMax(boolean z10, int i10, int[] iArr);

    public final int findRowMax(boolean z10, int[] iArr) {
        return findRowMax(z10, this.f3231c ? this.f3234f : this.f3235g, iArr);
    }

    public abstract int findRowMin(boolean z10, int i10, int[] iArr);

    public final int findRowMin(boolean z10, int[] iArr) {
        return findRowMin(z10, this.f3231c ? this.f3235g : this.f3234f, iArr);
    }

    public final int getFirstVisibleIndex() {
        return this.f3234f;
    }

    public final b0.f[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public abstract b0.f[] getItemPositionsInRows(int i10, int i11);

    public final int getLastVisibleIndex() {
        return this.f3235g;
    }

    public abstract a getLocation(int i10);

    public int getNumRows() {
        return this.f3233e;
    }

    public final int getRowIndex(int i10) {
        a location = getLocation(i10);
        if (location == null) {
            return -1;
        }
        return location.f3238a;
    }

    public void invalidateItemsAfter(int i10) {
        int i11;
        if (i10 >= 0 && (i11 = this.f3235g) >= 0) {
            if (i11 >= i10) {
                this.f3235g = i10 - 1;
            }
            if (this.f3235g < this.f3234f) {
                resetVisibleIndex();
            }
            if (getFirstVisibleIndex() < 0) {
                setStart(i10);
            }
        }
    }

    public boolean isReversedFlow() {
        return this.f3231c;
    }

    public final boolean prependOneColumnVisibleItems() {
        return prependVisibleItems(this.f3231c ? Integer.MIN_VALUE : Integer.MAX_VALUE, true);
    }

    public final void prependVisibleItems(int i10) {
        prependVisibleItems(i10, false);
    }

    public abstract boolean prependVisibleItems(int i10, boolean z10);

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void removeInvisibleItemsAtEnd(int r4, int r5) {
        /*
            r3 = this;
        L0:
            int r0 = r3.f3235g
            int r1 = r3.f3234f
            if (r0 < r1) goto L36
            if (r0 <= r4) goto L36
            boolean r1 = r3.f3231c
            r2 = 1
            if (r1 != 0) goto L18
            androidx.leanback.widget.i$b r1 = r3.f3230b
            androidx.leanback.widget.j$b r1 = (androidx.leanback.widget.j.b) r1
            int r0 = r1.getEdge(r0)
            if (r0 < r5) goto L24
            goto L22
        L18:
            androidx.leanback.widget.i$b r1 = r3.f3230b
            androidx.leanback.widget.j$b r1 = (androidx.leanback.widget.j.b) r1
            int r0 = r1.getEdge(r0)
            if (r0 > r5) goto L24
        L22:
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L36
            androidx.leanback.widget.i$b r0 = r3.f3230b
            int r1 = r3.f3235g
            androidx.leanback.widget.j$b r0 = (androidx.leanback.widget.j.b) r0
            r0.removeItem(r1)
            int r0 = r3.f3235g
            int r0 = r0 - r2
            r3.f3235g = r0
            goto L0
        L36:
            int r4 = r3.f3235g
            int r5 = r3.f3234f
            if (r4 >= r5) goto L3f
            r3.resetVisibleIndex()
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.i.removeInvisibleItemsAtEnd(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void removeInvisibleItemsAtFront(int r5, int r6) {
        /*
            r4 = this;
        L0:
            int r0 = r4.f3235g
            int r1 = r4.f3234f
            if (r0 < r1) goto L44
            if (r1 >= r5) goto L44
            androidx.leanback.widget.i$b r0 = r4.f3230b
            androidx.leanback.widget.j$b r0 = (androidx.leanback.widget.j.b) r0
            int r0 = r0.getSize(r1)
            boolean r1 = r4.f3231c
            r2 = 1
            if (r1 != 0) goto L23
            androidx.leanback.widget.i$b r1 = r4.f3230b
            int r3 = r4.f3234f
            androidx.leanback.widget.j$b r1 = (androidx.leanback.widget.j.b) r1
            int r1 = r1.getEdge(r3)
            int r1 = r1 + r0
            if (r1 > r6) goto L32
            goto L30
        L23:
            androidx.leanback.widget.i$b r1 = r4.f3230b
            int r3 = r4.f3234f
            androidx.leanback.widget.j$b r1 = (androidx.leanback.widget.j.b) r1
            int r1 = r1.getEdge(r3)
            int r1 = r1 - r0
            if (r1 < r6) goto L32
        L30:
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            if (r0 == 0) goto L44
            androidx.leanback.widget.i$b r0 = r4.f3230b
            int r1 = r4.f3234f
            androidx.leanback.widget.j$b r0 = (androidx.leanback.widget.j.b) r0
            r0.removeItem(r1)
            int r0 = r4.f3234f
            int r0 = r0 + r2
            r4.f3234f = r0
            goto L0
        L44:
            int r5 = r4.f3235g
            int r6 = r4.f3234f
            if (r5 >= r6) goto L4d
            r4.resetVisibleIndex()
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.i.removeInvisibleItemsAtFront(int, int):void");
    }

    public void resetVisibleIndex() {
        this.f3235g = -1;
        this.f3234f = -1;
    }

    public void setProvider(b bVar) {
        this.f3230b = bVar;
    }

    public final void setReversedFlow(boolean z10) {
        this.f3231c = z10;
    }

    public final void setSpacing(int i10) {
        this.f3232d = i10;
    }

    public void setStart(int i10) {
        this.f3237i = i10;
    }

    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.l.c cVar) {
    }
}
