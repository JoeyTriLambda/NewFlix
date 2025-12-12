package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqa implements zzqb {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Boolean> zzd;
    private static final zzhg<Boolean> zze;
    private static final zzhg<Boolean> zzf;
    private static final zzhg<Boolean> zzg;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.rb.attribution.client2", true);
        zzb = zzhoVarZza.zza("measurement.rb.attribution.dma_fix", true);
        zzc = zzhoVarZza.zza("measurement.rb.attribution.followup1.service", false);
        zzd = zzhoVarZza.zza("measurement.rb.attribution.index_out_of_bounds_fix", false);
        zze = zzhoVarZza.zza("measurement.rb.attribution.service", true);
        zzf = zzhoVarZza.zza("measurement.rb.attribution.enable_trigger_redaction", true);
        zzg = zzhoVarZza.zza("measurement.rb.attribution.uuid_generation", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zze() {
        return zzd.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zzf() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zzg() {
        return zzf.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqb
    public final boolean zzh() {
        return zzg.zza().booleanValue();
    }
}
