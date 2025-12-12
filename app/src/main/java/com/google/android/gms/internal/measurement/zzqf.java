package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqf implements zzqc {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Boolean> zzd;
    private static final zzhg<Boolean> zze;
    private static final zzhg<Boolean> zzf;
    private static final zzhg<Boolean> zzg;
    private static final zzhg<Boolean> zzh;
    private static final zzhg<Boolean> zzi;
    private static final zzhg<Boolean> zzj;
    private static final zzhg<Boolean> zzk;
    private static final zzhg<Boolean> zzl;
    private static final zzhg<Boolean> zzm;
    private static final zzhg<Boolean> zzn;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.redaction.app_instance_id", true);
        zzb = zzhoVarZza.zza("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzc = zzhoVarZza.zza("measurement.redaction.config_redacted_fields", true);
        zzd = zzhoVarZza.zza("measurement.redaction.device_info", true);
        zze = zzhoVarZza.zza("measurement.redaction.e_tag", true);
        zzf = zzhoVarZza.zza("measurement.redaction.enhanced_uid", true);
        zzg = zzhoVarZza.zza("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzh = zzhoVarZza.zza("measurement.redaction.google_signals", true);
        zzi = zzhoVarZza.zza("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zzhoVarZza.zza("measurement.redaction.retain_major_os_version", true);
        zzk = zzhoVarZza.zza("measurement.redaction.scion_payload_generator", true);
        zzl = zzhoVarZza.zza("measurement.redaction.upload_redacted_fields", true);
        zzm = zzhoVarZza.zza("measurement.redaction.upload_subdomain_override", true);
        zzn = zzhoVarZza.zza("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zza() {
        return zzj.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqc
    public final boolean zzb() {
        return zzk.zza().booleanValue();
    }
}
