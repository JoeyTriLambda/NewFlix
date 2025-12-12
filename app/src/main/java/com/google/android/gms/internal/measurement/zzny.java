package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzny implements zznz {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.consent_regional_defaults.client", false);
        zzb = zzhoVarZza.zza("measurement.consent_regional_defaults.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
