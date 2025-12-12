package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoq implements zzor {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.collection.event_safelist", true);
        zzb = zzhoVarZza.zza("measurement.service.store_null_safelist", true);
        zzc = zzhoVarZza.zza("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }
}
