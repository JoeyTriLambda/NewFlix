package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzef extends zzek {
    final /* synthetic */ zzeg zza;

    public zzef(zzeg zzegVar) {
        this.zza = zzegVar;
    }

    @Override // com.google.android.gms.internal.cast.zzek
    public final void zza(long j10) {
        this.zza.zzc++;
        zzeg zzegVar = this.zza;
        if (zzegVar.zza(zzegVar.zza) || this.zza.zza.isStarted()) {
            return;
        }
        zzeg zzegVar2 = this.zza;
        if (zzeg.zze(zzegVar2)) {
            return;
        }
        zzegVar2.zza.start();
    }
}
