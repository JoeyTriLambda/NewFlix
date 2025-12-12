package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqy implements zzqz {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.tcf.client", false);
        zzb = zzhoVarZza.zza("measurement.tcf.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqz
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqz
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
