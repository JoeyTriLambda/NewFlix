package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: FloatArrayList.java */
/* loaded from: classes.dex */
public final class t extends c<Float> implements w.e, RandomAccess, t0 {

    /* renamed from: m, reason: collision with root package name */
    public float[] f2534m;

    /* renamed from: n, reason: collision with root package name */
    public int f2535n;

    static {
        new t(0, new float[0]).makeImmutable();
    }

    public t() {
        this(0, new float[10]);
    }

    public final void a(int i10) {
        if (i10 < 0 || i10 >= this.f2535n) {
            StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
            sbS.append(this.f2535n);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Charset charset = w.f2545a;
        collection.getClass();
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i10 = tVar.f2535n;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2535n;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.f2534m;
        if (i12 > fArr.length) {
            this.f2534m = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(tVar.f2534m, 0, this.f2534m, this.f2535n, tVar.f2535n);
        this.f2535n = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addFloat(float f10) {
        ensureIsMutable();
        int i10 = this.f2535n;
        float[] fArr = this.f2534m;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[ac.c.a(i10, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f2534m = fArr2;
        }
        float[] fArr3 = this.f2534m;
        int i11 = this.f2535n;
        this.f2535n = i11 + 1;
        fArr3[i11] = f10;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.f2535n != tVar.f2535n) {
            return false;
        }
        float[] fArr = tVar.f2534m;
        for (int i10 = 0; i10 < this.f2535n; i10++) {
            if (Float.floatToIntBits(this.f2534m[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public float getFloat(int i10) {
        a(i10);
        return this.f2534m[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.f2535n; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f2534m[i10]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        ensureIsMutable();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f2534m;
        System.arraycopy(fArr, i11, fArr, i10, this.f2535n - i11);
        this.f2535n -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public float setFloat(int i10, float f10) {
        ensureIsMutable();
        a(i10);
        float[] fArr = this.f2534m;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2535n;
    }

    public t(int i10, float[] fArr) {
        this.f2534m = fArr;
        this.f2535n = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i10) {
        return Float.valueOf(getFloat(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.w.h
    /* renamed from: mutableCopyWithCapacity */
    public w.h<Float> mutableCopyWithCapacity2(int i10) {
        if (i10 < this.f2535n) {
            throw new IllegalArgumentException();
        }
        return new t(this.f2535n, Arrays.copyOf(this.f2534m, i10));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int i10 = 0; i10 < this.f2535n; i10++) {
            if (obj.equals(Float.valueOf(this.f2534m[i10]))) {
                float[] fArr = this.f2534m;
                System.arraycopy(fArr, i10 + 1, fArr, i10, (this.f2535n - i10) - 1);
                this.f2535n--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float set(int i10, Float f10) {
        return Float.valueOf(setFloat(i10, f10.floatValue()));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Float f10) {
        addFloat(f10.floatValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Float f10) {
        int i11;
        float fFloatValue = f10.floatValue();
        ensureIsMutable();
        if (i10 >= 0 && i10 <= (i11 = this.f2535n)) {
            float[] fArr = this.f2534m;
            if (i11 < fArr.length) {
                System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
            } else {
                float[] fArr2 = new float[ac.c.a(i11, 3, 2, 1)];
                System.arraycopy(fArr, 0, fArr2, 0, i10);
                System.arraycopy(this.f2534m, i10, fArr2, i10 + 1, this.f2535n - i10);
                this.f2534m = fArr2;
            }
            this.f2534m[i10] = fFloatValue;
            this.f2535n++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = ac.c.s("Index:", i10, ", Size:");
        sbS.append(this.f2535n);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public Float remove(int i10) {
        ensureIsMutable();
        a(i10);
        float[] fArr = this.f2534m;
        float f10 = fArr[i10];
        if (i10 < this.f2535n - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.f2535n--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }
}
