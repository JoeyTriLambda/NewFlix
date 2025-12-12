package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzbn implements zzbm {
    private final zzh zza;
    private final String zzb;

    public zzbn(zzh zzhVar, String str) {
        this.zza = zzhVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final zzh zza(zzaq zzaqVar) {
        zzh zzhVarZza = this.zza.zza();
        zzhVarZza.zza(this.zzb, zzaqVar);
        return zzhVarZza;
    }
}
