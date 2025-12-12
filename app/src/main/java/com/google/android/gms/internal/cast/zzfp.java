package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzfp extends zzfq {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfq zzc;

    public zzfp(zzfq zzfqVar, int i10, int i11) {
        this.zzc = zzfqVar;
        this.zza = i10;
        this.zzb = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zzez.zza(i10, this.zzb, "index");
        return this.zzc.get(i10 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.cast.zzfq, java.util.List
    /* renamed from: zzh */
    public final zzfq subList(int i10, int i11) {
        zzez.zzd(i10, i11, this.zzb);
        int i12 = this.zza;
        return this.zzc.subList(i10 + i12, i11 + i12);
    }
}
