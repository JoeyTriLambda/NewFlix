package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpt implements zzpq {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Long> zzd;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzhoVarZza.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzhoVarZza.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzhoVarZza.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpq
    public final boolean zza() {
        return zzc.zza().booleanValue();
    }
}
