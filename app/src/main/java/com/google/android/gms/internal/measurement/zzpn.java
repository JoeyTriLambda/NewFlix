package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpn implements zzpk {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Long> zzb;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.increase_param_lengths", false);
        zzb = zzhoVarZza.zza("measurement.id.increase_param_lengths", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpk
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpk
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
