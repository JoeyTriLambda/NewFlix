package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzov implements zzos {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Boolean> zzd;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.client.ad_id_consent_fix", true);
        zzb = zzhoVarZza.zza("measurement.service.consent.aiid_reset_fix", true);
        zzc = zzhoVarZza.zza("measurement.service.consent.app_start_fix", true);
        zzd = zzhoVarZza.zza("measurement.service.consent.pfo_on_fx", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final boolean zza() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final boolean zzb() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzos
    public final boolean zzc() {
        return zzd.zza().booleanValue();
    }
}
