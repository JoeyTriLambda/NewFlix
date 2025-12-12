package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: BooleanArrayList.java */
/* loaded from: classes.dex */
public final class f extends c<Boolean> implements w.a, RandomAccess, t0 {

    /* renamed from: m, reason: collision with root package name */
    public boolean[] f2448m;

    /* renamed from: n, reason: collision with root package name */
    public int f2449n;

    static {
        new f(new boolean[0], 0).makeImmutable();
    }

    public f() {
        this(new boolean[10], 0);
    }

    public final void a(int i10) {
        if (i10 < 0 || i10 >= this.f2449n) {
            StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
            sbS.append(this.f2449n);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Charset charset = w.f2545a;
        collection.getClass();
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i10 = fVar.f2449n;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2449n;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.f2448m;
        if (i12 > zArr.length) {
            this.f2448m = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(fVar.f2448m, 0, this.f2448m, this.f2449n, fVar.f2449n);
        this.f2449n = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addBoolean(boolean z10) {
        ensureIsMutable();
        int i10 = this.f2449n;
        boolean[] zArr = this.f2448m;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[ac.c.a(i10, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f2448m = zArr2;
        }
        boolean[] zArr3 = this.f2448m;
        int i11 = this.f2449n;
        this.f2449n = i11 + 1;
        zArr3[i11] = z10;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.f2449n != fVar.f2449n) {
            return false;
        }
        boolean[] zArr = fVar.f2448m;
        for (int i10 = 0; i10 < this.f2449n; i10++) {
            if (this.f2448m[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(int i10) {
        a(i10);
        return this.f2448m[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashBoolean = 1;
        for (int i10 = 0; i10 < this.f2449n; i10++) {
            iHashBoolean = (iHashBoolean * 31) + w.hashBoolean(this.f2448m[i10]);
        }
        return iHashBoolean;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        ensureIsMutable();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f2448m;
        System.arraycopy(zArr, i11, zArr, i10, this.f2449n - i11);
        this.f2449n -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public boolean setBoolean(int i10, boolean z10) {
        ensureIsMutable();
        a(i10);
        boolean[] zArr = this.f2448m;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2449n;
    }

    public f(boolean[] zArr, int i10) {
        this.f2448m = zArr;
        this.f2449n = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i10) {
        return Boolean.valueOf(getBoolean(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.w.h
    /* renamed from: mutableCopyWithCapacity */
    public w.h<Boolean> mutableCopyWithCapacity2(int i10) {
        if (i10 >= this.f2449n) {
            return new f(Arrays.copyOf(this.f2448m, i10), this.f2449n);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i10 = 0; i10 < this.f2449n; i10++) {
            if (obj.equals(Boolean.valueOf(this.f2448m[i10]))) {
                boolean[] zArr = this.f2448m;
                System.arraycopy(zArr, i10 + 1, zArr, i10, (this.f2449n - i10) - 1);
                this.f2449n--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(setBoolean(i10, bool.booleanValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Boolean bool) {
        int i11;
        boolean zBooleanValue = bool.booleanValue();
        ensureIsMutable();
        if (i10 >= 0 && i10 <= (i11 = this.f2449n)) {
            boolean[] zArr = this.f2448m;
            if (i11 < zArr.length) {
                System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
            } else {
                boolean[] zArr2 = new boolean[ac.c.a(i11, 3, 2, 1)];
                System.arraycopy(zArr, 0, zArr2, 0, i10);
                System.arraycopy(this.f2448m, i10, zArr2, i10 + 1, this.f2449n - i10);
                this.f2448m = zArr2;
            }
            this.f2448m[i10] = zBooleanValue;
            this.f2449n++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
        sbS.append(this.f2449n);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean remove(int i10) {
        ensureIsMutable();
        a(i10);
        boolean[] zArr = this.f2448m;
        boolean z10 = zArr[i10];
        if (i10 < this.f2449n - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.f2449n--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }
}
