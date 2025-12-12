package com.google.android.gms.internal.measurement;

import ac.c;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzjp extends zzid<Float> implements zzls, RandomAccess {
    private static final zzjp zza = new zzjp(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    public zzjp() {
        this(new float[10], 0, true);
    }

    private final String zzb(int i10) {
        return c.g("Index:", i10, ", Size:", this.zzc);
    }

    private final void zzc(int i10) {
        if (i10 < 0 || i10 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzb(i10));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i10 < 0 || i10 > (i11 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i10));
        }
        float[] fArr = this.zzb;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[c.a(i11, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.zzb, i10, fArr2, i10 + 1, this.zzc - i10);
            this.zzb = fArr2;
        }
        this.zzb[i10] = fFloatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zza();
        zzjw.zza(collection);
        if (!(collection instanceof zzjp)) {
            return super.addAll(collection);
        }
        zzjp zzjpVar = (zzjp) collection;
        int i10 = zzjpVar.zzc;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.zzc;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.zzb;
        if (i12 > fArr.length) {
            this.zzb = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(zzjpVar.zzb, 0, this.zzb, this.zzc, zzjpVar.zzc);
        this.zzc = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjp)) {
            return super.equals(obj);
        }
        zzjp zzjpVar = (zzjp) obj;
        if (this.zzc != zzjpVar.zzc) {
            return false;
        }
        float[] fArr = zzjpVar.zzb;
        for (int i10 = 0; i10 < this.zzc; i10++) {
            if (Float.floatToIntBits(this.zzb[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        zzc(i10);
        return Float.valueOf(this.zzb[i10]);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.zzc; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzb[i10]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.zzb[i10] == fFloatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zza();
        zzc(i10);
        float[] fArr = this.zzb;
        float f10 = fArr[i10];
        if (i10 < this.zzc - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        zza();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i11, fArr, i10, this.zzc - i11);
        this.zzc -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        zzc(i10);
        float[] fArr = this.zzb;
        float f10 = fArr[i10];
        fArr[i10] = fFloatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final /* synthetic */ zzkc zza(int i10) {
        if (i10 >= this.zzc) {
            return new zzjp(Arrays.copyOf(this.zzb, i10), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzjp(float[] fArr, int i10, boolean z10) {
        super(z10);
        this.zzb = fArr;
        this.zzc = i10;
    }

    public final void zza(float f10) {
        zza();
        int i10 = this.zzc;
        float[] fArr = this.zzb;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[c.a(i10, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i11 = this.zzc;
        this.zzc = i11 + 1;
        fArr3[i11] = f10;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Float) obj).floatValue());
        return true;
    }
}
