package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzbp implements zzbm {
    private final zzh zza;
    private final String zzb;

    public zzbp(zzh zzhVar, String str) {
        this.zza = zzhVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final zzh zza(zzaq zzaqVar) {
        this.zza.zza(this.zzb, zzaqVar);
        return this.zza;
    }
}
