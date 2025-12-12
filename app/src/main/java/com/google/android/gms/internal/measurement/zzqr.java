package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqr implements zzqo {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Boolean> zzd;
    private static final zzhg<Boolean> zze;
    private static final zzhg<Long> zzf;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zzhoVarZza.zza("measurement.client.sessions.enable_fix_background_engagement", false);
        zzc = zzhoVarZza.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzd = zzhoVarZza.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zze = zzhoVarZza.zza("measurement.client.sessions.session_id_enabled", true);
        zzf = zzhoVarZza.zza("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final boolean zza() {
        return zzb.zza().booleanValue();
    }
}
