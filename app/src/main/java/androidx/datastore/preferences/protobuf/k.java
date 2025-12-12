package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: DoubleArrayList.java */
/* loaded from: classes.dex */
public final class k extends c<Double> implements w.b, RandomAccess, t0 {

    /* renamed from: m, reason: collision with root package name */
    public double[] f2495m;

    /* renamed from: n, reason: collision with root package name */
    public int f2496n;

    static {
        new k(new double[0], 0).makeImmutable();
    }

    public k() {
        this(new double[10], 0);
    }

    public final void a(int i10) {
        if (i10 < 0 || i10 >= this.f2496n) {
            StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
            sbS.append(this.f2496n);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Charset charset = w.f2545a;
        collection.getClass();
        if (!(collection instanceof k)) {
            return super.addAll(collection);
        }
        k kVar = (k) collection;
        int i10 = kVar.f2496n;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2496n;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.f2495m;
        if (i12 > dArr.length) {
            this.f2495m = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy(kVar.f2495m, 0, this.f2495m, this.f2496n, kVar.f2496n);
        this.f2496n = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addDouble(double d10) {
        ensureIsMutable();
        int i10 = this.f2496n;
        double[] dArr = this.f2495m;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[ac.c.a(i10, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f2495m = dArr2;
        }
        double[] dArr3 = this.f2495m;
        int i11 = this.f2496n;
        this.f2496n = i11 + 1;
        dArr3[i11] = d10;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return super.equals(obj);
        }
        k kVar = (k) obj;
        if (this.f2496n != kVar.f2496n) {
            return false;
        }
        double[] dArr = kVar.f2495m;
        for (int i10 = 0; i10 < this.f2496n; i10++) {
            if (Double.doubleToLongBits(this.f2495m[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public double getDouble(int i10) {
        a(i10);
        return this.f2495m[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i10 = 0; i10 < this.f2496n; i10++) {
            iHashLong = (iHashLong * 31) + w.hashLong(Double.doubleToLongBits(this.f2495m[i10]));
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        ensureIsMutable();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f2495m;
        System.arraycopy(dArr, i11, dArr, i10, this.f2496n - i11);
        this.f2496n -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public double setDouble(int i10, double d10) {
        ensureIsMutable();
        a(i10);
        double[] dArr = this.f2495m;
        double d11 = dArr[i10];
        dArr[i10] = d10;
        return d11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2496n;
    }

    public k(double[] dArr, int i10) {
        this.f2495m = dArr;
        this.f2496n = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i10) {
        return Double.valueOf(getDouble(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.w.h
    /* renamed from: mutableCopyWithCapacity */
    public w.h<Double> mutableCopyWithCapacity2(int i10) {
        if (i10 >= this.f2496n) {
            return new k(Arrays.copyOf(this.f2495m, i10), this.f2496n);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i10 = 0; i10 < this.f2496n; i10++) {
            if (obj.equals(Double.valueOf(this.f2495m[i10]))) {
                double[] dArr = this.f2495m;
                System.arraycopy(dArr, i10 + 1, dArr, i10, (this.f2496n - i10) - 1);
                this.f2496n--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double set(int i10, Double d10) {
        return Double.valueOf(setDouble(i10, d10.doubleValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Double d10) {
        addDouble(d10.doubleValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Double d10) {
        int i11;
        double dDoubleValue = d10.doubleValue();
        ensureIsMutable();
        if (i10 >= 0 && i10 <= (i11 = this.f2496n)) {
            double[] dArr = this.f2495m;
            if (i11 < dArr.length) {
                System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
            } else {
                double[] dArr2 = new double[ac.c.a(i11, 3, 2, 1)];
                System.arraycopy(dArr, 0, dArr2, 0, i10);
                System.arraycopy(this.f2495m, i10, dArr2, i10 + 1, this.f2496n - i10);
                this.f2495m = dArr2;
            }
            this.f2495m[i10] = dDoubleValue;
            this.f2496n++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
        sbS.append(this.f2496n);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public Double remove(int i10) {
        ensureIsMutable();
        a(i10);
        double[] dArr = this.f2495m;
        double d10 = dArr[i10];
        if (i10 < this.f2496n - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.f2496n--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }
}
