package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzod implements zzoa {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Long> zzd;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.client.consent_state_v1", true);
        zzb = zzhoVarZza.zza("measurement.client.3p_consent_state_v1", true);
        zzc = zzhoVarZza.zza("measurement.service.consent_state_v1_W36", true);
        zzd = zzhoVarZza.zza("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final long zza() {
        return zzd.zza().longValue();
    }
}
