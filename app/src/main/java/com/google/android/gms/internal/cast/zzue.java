package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzue extends zzsi implements RandomAccess, zzuf {

    @Deprecated
    public static final zzuf zza;
    private static final zzue zzb;
    private final List zzc;

    static {
        zzue zzueVar = new zzue(false);
        zzb = zzueVar;
        zza = zzueVar;
    }

    public zzue() {
        this(10);
    }

    private static String zzi(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzsu ? ((zzsu) obj).zzl(zzty.zzb) : zzty.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.cast.zzsi, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.zzsi, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        zza();
        if (collection instanceof zzuf) {
            collection = ((zzuf) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.cast.zzsi, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.zzsi, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zza();
        Object objRemove = this.zzc.remove(i10);
        ((AbstractList) this).modCount++;
        return zzi(objRemove);
    }

    @Override // com.google.android.gms.internal.cast.zzsi, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        zza();
        return zzi(this.zzc.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.cast.zzuf
    public final zzuf zzd() {
        return zzc() ? new zzwe(this) : this;
    }

    @Override // com.google.android.gms.internal.cast.zzuf
    public final Object zze(int i10) {
        return this.zzc.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final String get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzsu) {
            zzsu zzsuVar = (zzsu) obj;
            String strZzl = zzsuVar.zzl(zzty.zzb);
            if (zzsuVar.zzi()) {
                this.zzc.set(i10, strZzl);
            }
            return strZzl;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzty.zzd(bArr);
        if (zzwn.zzd(bArr)) {
            this.zzc.set(i10, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.android.gms.internal.cast.zztx
    public final /* bridge */ /* synthetic */ zztx zzg(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.zzc);
        return new zzue(arrayList);
    }

    @Override // com.google.android.gms.internal.cast.zzuf
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzue(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        super(true);
        this.zzc = arrayList;
    }

    private zzue(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzue(boolean z10) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.cast.zzsi, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
