package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzkj extends zzid<String> implements zzkm, RandomAccess {
    private static final zzkj zza;

    @Deprecated
    private static final zzkm zzb;
    private final List<Object> zzc;

    static {
        zzkj zzkjVar = new zzkj(false);
        zza = zzkjVar;
        zzb = zzkjVar;
    }

    public zzkj() {
        this(10);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzij) {
            zzij zzijVar = (zzij) obj;
            String strZzc = zzijVar.zzc();
            if (zzijVar.zzd()) {
                this.zzc.set(i10, strZzc);
            }
            return strZzc;
        }
        byte[] bArr = (byte[]) obj;
        String strZzb = zzjw.zzb(bArr);
        if (zzjw.zzc(bArr)) {
            this.zzc.set(i10, strZzb);
        }
        return strZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        zza();
        Object objRemove = this.zzc.remove(i10);
        ((AbstractList) this).modCount++;
        return zza(objRemove);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        zza();
        return zza(this.zzc.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final /* synthetic */ zzkc zza(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.zzc);
        return new zzkj((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final Object zzb(int i10) {
        return this.zzc.get(i10);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, com.google.android.gms.internal.measurement.zzkc
    public final /* bridge */ /* synthetic */ boolean zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final zzkm zzd() {
        return zzc() ? new zzmy(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final List<?> zze() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzkj(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzkm) {
            collection = ((zzkm) collection).zze();
        }
        boolean zAddAll = this.zzc.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    private zzkj(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private zzkj(boolean z10) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzid, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzij) {
            return ((zzij) obj).zzc();
        }
        return zzjw.zzb((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final void zza(zzij zzijVar) {
        zza();
        this.zzc.add(zzijVar);
        ((AbstractList) this).modCount++;
    }
}
