package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzs implements com.google.android.gms.cast.framework.zzs {
    final /* synthetic */ zzv zza;

    public /* synthetic */ zzs(zzv zzvVar, zzr zzrVar) {
        this.zza = zzvVar;
    }

    @Override // com.google.android.gms.cast.framework.zzs
    public final void zza() {
        zzv.zzf(this.zza, new zzz(new zzy(3)));
    }

    @Override // com.google.android.gms.cast.framework.zzs
    public final void zzb(String str, long j10, int i10, long j11, long j12) {
        zzx zzxVarZzg = this.zza.zzg();
        zzp zzpVar = new zzp(str);
        zzpVar.zzf(j10);
        zzpVar.zzh(i10);
        zzpVar.zzg(j11);
        zzpVar.zze(j12);
        zzxVarZzg.zzb(new zzq(zzpVar));
    }
}
