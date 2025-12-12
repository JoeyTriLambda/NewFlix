package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqg implements zzqh {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Long> zzb;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.remove_app_background.client", false);
        zzb = zzhoVarZza.zza("measurement.id.remove_app_background.client", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzqh
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqh
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
