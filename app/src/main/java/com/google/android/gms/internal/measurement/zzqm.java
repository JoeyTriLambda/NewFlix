package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqm implements zzqn {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Boolean> zzd;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzb = zzhoVarZza.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zzc = zzhoVarZza.zza("measurement.session_stitching_token_enabled", false);
        zzd = zzhoVarZza.zza("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqn
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqn
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqn
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqn
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
