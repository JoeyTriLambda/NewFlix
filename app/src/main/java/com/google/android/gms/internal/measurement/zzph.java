package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzph implements zzpe {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Long> zzc;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.gbraid_campaign.gbraid.client.dev", false);
        zzb = zzhoVarZza.zza("measurement.gbraid_campaign.gbraid.service", false);
        zzc = zzhoVarZza.zza("measurement.id.gbraid_campaign.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
