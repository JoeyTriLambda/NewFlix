package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzfz extends zzfu {
    private final transient zzft zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzfz(zzft zzftVar, Object[] objArr, int i10, int i11) {
        this.zza = zzftVar;
        this.zzb = objArr;
        this.zzc = i11;
    }

    @Override // com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzfu, com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zza(Object[] objArr, int i10) {
        return zzd().zza(objArr, 0);
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

    @Override // com.google.android.gms.internal.cast.zzfu
    public final zzfq zzi() {
        return new zzfy(this);
    }
}
