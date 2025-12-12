package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IntArrayList.java */
/* loaded from: classes.dex */
public final class v extends c<Integer> implements w.f, RandomAccess, t0 {

    /* renamed from: m, reason: collision with root package name */
    public int[] f2540m;

    /* renamed from: n, reason: collision with root package name */
    public int f2541n;

    static {
        new v(new int[0], 0).makeImmutable();
    }

    public v() {
        this(new int[10], 0);
    }

    public final void a(int i10) {
        if (i10 < 0 || i10 >= this.f2541n) {
            StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
            sbS.append(this.f2541n);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Charset charset = w.f2545a;
        collection.getClass();
        if (!(collection instanceof v)) {
            return super.addAll(collection);
        }
        v vVar = (v) collection;
        int i10 = vVar.f2541n;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2541n;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f2540m;
        if (i12 > iArr.length) {
            this.f2540m = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(vVar.f2540m, 0, this.f2540m, this.f2541n, vVar.f2541n);
        this.f2541n = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addInt(int i10) {
        ensureIsMutable();
        int i11 = this.f2541n;
        int[] iArr = this.f2540m;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[ac.c.a(i11, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f2540m = iArr2;
        }
        int[] iArr3 = this.f2540m;
        int i12 = this.f2541n;
        this.f2541n = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return super.equals(obj);
        }
        v vVar = (v) obj;
        if (this.f2541n != vVar.f2541n) {
            return false;
        }
        int[] iArr = vVar.f2540m;
        for (int i10 = 0; i10 < this.f2541n; i10++) {
            if (this.f2540m[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public int getInt(int i10) {
        a(i10);
        return this.f2540m[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f2541n; i11++) {
            i10 = (i10 * 31) + this.f2540m[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        ensureIsMutable();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f2540m;
        System.arraycopy(iArr, i11, iArr, i10, this.f2541n - i11);
        this.f2541n -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public int setInt(int i10, int i11) {
        ensureIsMutable();
        a(i10);
        int[] iArr = this.f2540m;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2541n;
    }

    public v(int[] iArr, int i10) {
        this.f2540m = iArr;
        this.f2541n = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.w.h
    /* renamed from: mutableCopyWithCapacity */
    public w.h<Integer> mutableCopyWithCapacity2(int i10) {
        if (i10 >= this.f2541n) {
            return new v(Arrays.copyOf(this.f2540m, i10), this.f2541n);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i10 = 0; i10 < this.f2541n; i10++) {
            if (obj.equals(Integer.valueOf(this.f2540m[i10]))) {
                int[] iArr = this.f2540m;
                System.arraycopy(iArr, i10 + 1, iArr, i10, (this.f2541n - i10) - 1);
                this.f2541n--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer set(int i10, Integer num) {
        return Integer.valueOf(setInt(i10, num.intValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Integer num) {
        int i11;
        int iIntValue = num.intValue();
        ensureIsMutable();
        if (i10 >= 0 && i10 <= (i11 = this.f2541n)) {
            int[] iArr = this.f2540m;
            if (i11 < iArr.length) {
                System.arraycopy(iArr, i10, iArr, i10 + 1, i11 - i10);
            } else {
                int[] iArr2 = new int[ac.c.a(i11, 3, 2, 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                System.arraycopy(this.f2540m, i10, iArr2, i10 + 1, this.f2541n - i10);
                this.f2540m = iArr2;
            }
            this.f2540m[i10] = iIntValue;
            this.f2541n++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
        sbS.append(this.f2541n);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer remove(int i10) {
        ensureIsMutable();
        a(i10);
        int[] iArr = this.f2540m;
        int i11 = iArr[i10];
        if (i10 < this.f2541n - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f2541n--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }
}
