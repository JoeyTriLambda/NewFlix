package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzgd extends zzfu {
    static final zzgd zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzgd(objArr, 0, objArr, 0, 0);
    }

    public zzgd(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.zzb = objArr;
        this.zze = i10;
        this.zzc = objArr2;
        this.zzf = i11;
        this.zzg = i12;
    }

    @Override // com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzfj.zza(obj.hashCode());
                while (true) {
                    int i10 = iZza & this.zzf;
                    Object obj2 = objArr[i10];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i10 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzfu, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.cast.zzfu, com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzfu, com.google.android.gms.internal.cast.zzfm
    /* renamed from: zze */
    public final zzgg iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final boolean zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final Object[] zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzfu
    public final zzfq zzi() {
        return zzfq.zzi(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.cast.zzfu
    public final boolean zzl() {
        return true;
    }
}
