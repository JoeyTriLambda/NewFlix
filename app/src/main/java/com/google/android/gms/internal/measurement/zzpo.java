package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpo implements zzpp {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Long> zzc;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.item_scoped_custom_parameters.client", true);
        zzb = zzhoVarZza.zza("measurement.item_scoped_custom_parameters.service", false);
        zzc = zzhoVarZza.zza("measurement.id.item_scoped_custom_parameters.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
