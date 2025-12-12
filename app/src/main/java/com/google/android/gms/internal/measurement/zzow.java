package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzow implements zzox {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;
    private static final zzhg<Boolean> zzd;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzhoVarZza.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzhoVarZza.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzhoVarZza.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzd() {
        return zzd.zza().booleanValue();
    }
}
