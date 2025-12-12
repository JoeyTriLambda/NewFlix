package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpu implements zzpv {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Double> zzb;
    private static final zzhg<Long> zzc;
    private static final zzhg<Long> zzd;
    private static final zzhg<String> zze;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.test.boolean_flag", false);
        zzb = zzhoVarZza.zza("measurement.test.double_flag", -3.0d);
        zzc = zzhoVarZza.zza("measurement.test.int_flag", -2L);
        zzd = zzhoVarZza.zza("measurement.test.long_flag", -1L);
        zze = zzhoVarZza.zza("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzpv
    public final double zza() {
        return zzb.zza().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpv
    public final long zzb() {
        return zzc.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpv
    public final long zzc() {
        return zzd.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpv
    public final String zzd() {
        return zze.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzpv
    public final boolean zze() {
        return zza.zza().booleanValue();
    }
}
