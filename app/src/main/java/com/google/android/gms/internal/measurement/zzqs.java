package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqs implements zzqt {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.sfmc.client", true);
        zzb = zzhoVarZza.zza("measurement.sfmc.service", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqt
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqt
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqt
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
