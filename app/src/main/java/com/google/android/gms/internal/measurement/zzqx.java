package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqx implements zzqu {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.sgtm.client.dev", false);
        zzb = zzhoVarZza.zza("measurement.sgtm.preview_mode_enabled.dev", false);
        zzc = zzhoVarZza.zza("measurement.sgtm.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqu
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
