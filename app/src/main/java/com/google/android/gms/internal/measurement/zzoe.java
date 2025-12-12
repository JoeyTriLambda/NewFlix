package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoe implements zzof {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.consent.stop_reset_on_ads_storage_denied.client.dev", false);
        zzb = zzhoVarZza.zza("measurement.consent.stop_reset_on_ads_storage_denied.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }
}
