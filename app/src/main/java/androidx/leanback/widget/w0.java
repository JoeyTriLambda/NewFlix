package androidx.leanback.widget;

import androidx.leanback.widget.j;
import androidx.leanback.widget.v0;

/* compiled from: StaggeredGridDefault.java */
/* loaded from: classes.dex */
public final class w0 extends v0 {
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0137, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0138, code lost:
    
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x014f, code lost:
    
        return r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108 A[LOOP:2: B:87:0x0108->B:103:0x012c, LOOP_START, PHI: r6 r9 r10
  0x0108: PHI (r6v13 int) = (r6v6 int), (r6v18 int) binds: [B:86:0x0106, B:103:0x012c] A[DONT_GENERATE, DONT_INLINE]
  0x0108: PHI (r9v20 int) = (r9v18 int), (r9v21 int) binds: [B:86:0x0106, B:103:0x012c] A[DONT_GENERATE, DONT_INLINE]
  0x0108: PHI (r10v6 int) = (r10v5 int), (r10v8 int) binds: [B:86:0x0106, B:103:0x012c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.leanback.widget.v0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean appendVisibleItemsWithoutCache(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.w0.appendVisibleItemsWithoutCache(int, boolean):boolean");
    }

    public final int b(boolean z10) {
        boolean z11 = false;
        if (z10) {
            for (int i10 = this.f3235g; i10 >= this.f3234f; i10--) {
                int i11 = getLocation(i10).f3238a;
                if (i11 == 0) {
                    z11 = true;
                } else if (z11 && i11 == this.f3233e - 1) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i12 = this.f3234f; i12 <= this.f3235g; i12++) {
            int i13 = getLocation(i12).f3238a;
            if (i13 == this.f3233e - 1) {
                z11 = true;
            } else if (z11 && i13 == 0) {
                return i12;
            }
        }
        return -1;
    }

    public final int c(int i10) {
        int i11;
        v0.a location;
        int i12 = this.f3234f;
        if (i12 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.f3231c) {
            int edge = ((j.b) this.f3230b).getEdge(i12);
            if (getLocation(this.f3234f).f3238a == i10) {
                return edge;
            }
            int i13 = this.f3234f;
            do {
                i13++;
                if (i13 <= getLastIndex()) {
                    location = getLocation(i13);
                    edge += location.f3404b;
                }
            } while (location.f3238a != i10);
            return edge;
        }
        int edge2 = ((j.b) this.f3230b).getEdge(this.f3235g);
        v0.a location2 = getLocation(this.f3235g);
        if (location2.f3238a == i10) {
            i11 = location2.f3405c;
        } else {
            int i14 = this.f3235g;
            do {
                i14--;
                if (i14 >= getFirstIndex()) {
                    edge2 -= location2.f3404b;
                    location2 = getLocation(i14);
                }
            } while (location2.f3238a != i10);
            i11 = location2.f3405c;
        }
        return edge2 + i11;
        return Integer.MIN_VALUE;
    }

    public final int d(int i10) {
        v0.a location;
        int i11;
        int i12 = this.f3234f;
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.f3231c) {
            int edge = ((j.b) this.f3230b).getEdge(i12);
            if (getLocation(this.f3234f).f3238a == i10) {
                return edge;
            }
            int i13 = this.f3234f;
            do {
                i13++;
                if (i13 <= getLastIndex()) {
                    location = getLocation(i13);
                    edge += location.f3404b;
                }
            } while (location.f3238a != i10);
            return edge;
        }
        int edge2 = ((j.b) this.f3230b).getEdge(this.f3235g);
        v0.a location2 = getLocation(this.f3235g);
        if (location2.f3238a == i10) {
            i11 = location2.f3405c;
        } else {
            int i14 = this.f3235g;
            do {
                i14--;
                if (i14 >= getFirstIndex()) {
                    edge2 -= location2.f3404b;
                    location2 = getLocation(i14);
                }
            } while (location2.f3238a != i10);
            i11 = location2.f3405c;
        }
        return edge2 - i11;
        return Integer.MAX_VALUE;
    }

    @Override // androidx.leanback.widget.i
    public int findRowMax(boolean z10, int i10, int[] iArr) {
        int i11;
        int edge = ((j.b) this.f3230b).getEdge(i10);
        v0.a location = getLocation(i10);
        int i12 = location.f3238a;
        if (this.f3231c) {
            i11 = i12;
            int i13 = i11;
            int i14 = 1;
            int i15 = edge;
            for (int i16 = i10 + 1; i14 < this.f3233e && i16 <= this.f3235g; i16++) {
                v0.a location2 = getLocation(i16);
                i15 += location2.f3404b;
                int i17 = location2.f3238a;
                if (i17 != i13) {
                    i14++;
                    if (!z10 ? i15 >= edge : i15 <= edge) {
                        i13 = i17;
                    } else {
                        edge = i15;
                        i10 = i16;
                        i11 = i17;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i18 = 1;
            int i19 = i12;
            v0.a location3 = location;
            int i20 = edge;
            edge = ((j.b) this.f3230b).getSize(i10) + edge;
            i11 = i19;
            for (int i21 = i10 - 1; i18 < this.f3233e && i21 >= this.f3234f; i21--) {
                i20 -= location3.f3404b;
                location3 = getLocation(i21);
                int i22 = location3.f3238a;
                if (i22 != i19) {
                    i18++;
                    int size = ((j.b) this.f3230b).getSize(i21) + i20;
                    if (!z10 ? size >= edge : size <= edge) {
                        i19 = i22;
                    } else {
                        edge = size;
                        i10 = i21;
                        i11 = i22;
                        i19 = i11;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return edge;
    }

    @Override // androidx.leanback.widget.i
    public int findRowMin(boolean z10, int i10, int[] iArr) {
        int size;
        int edge = ((j.b) this.f3230b).getEdge(i10);
        v0.a location = getLocation(i10);
        int i11 = location.f3238a;
        if (this.f3231c) {
            int i12 = 1;
            size = edge - ((j.b) this.f3230b).getSize(i10);
            int i13 = i11;
            for (int i14 = i10 - 1; i12 < this.f3233e && i14 >= this.f3234f; i14--) {
                edge -= location.f3404b;
                location = getLocation(i14);
                int i15 = location.f3238a;
                if (i15 != i13) {
                    i12++;
                    int size2 = edge - ((j.b) this.f3230b).getSize(i14);
                    if (!z10 ? size2 >= size : size2 <= size) {
                        i13 = i15;
                    } else {
                        size = size2;
                        i10 = i14;
                        i11 = i15;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i16 = i11;
            int i17 = i16;
            int i18 = 1;
            int i19 = edge;
            for (int i20 = i10 + 1; i18 < this.f3233e && i20 <= this.f3235g; i20++) {
                v0.a location2 = getLocation(i20);
                i19 += location2.f3404b;
                int i21 = location2.f3238a;
                if (i21 != i17) {
                    i18++;
                    if (!z10 ? i19 >= edge : i19 <= edge) {
                        i17 = i21;
                    } else {
                        edge = i19;
                        i10 = i20;
                        i16 = i21;
                        i17 = i16;
                    }
                }
            }
            size = edge;
            i11 = i16;
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0130, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0131, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0148, code lost:
    
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0101 A[LOOP:2: B:86:0x0101->B:102:0x0125, LOOP_START, PHI: r5 r8 r9
  0x0101: PHI (r5v13 int) = (r5v6 int), (r5v19 int) binds: [B:85:0x00ff, B:102:0x0125] A[DONT_GENERATE, DONT_INLINE]
  0x0101: PHI (r8v19 int) = (r8v17 int), (r8v20 int) binds: [B:85:0x00ff, B:102:0x0125] A[DONT_GENERATE, DONT_INLINE]
  0x0101: PHI (r9v7 int) = (r9v6 int), (r9v9 int) binds: [B:85:0x00ff, B:102:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.leanback.widget.v0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean prependVisibleItemsWithoutCache(int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.w0.prependVisibleItemsWithoutCache(int, boolean):boolean");
    }
}
