package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzmv extends zzmt<zzmw, zzmw> {
    @Override // com.google.android.gms.internal.measurement.zzmt
    public final boolean zza(zzlv zzlvVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ int zzb(zzmw zzmwVar) {
        return zzmwVar.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ zzmw zzc(Object obj) {
        zzmw zzmwVar = ((zzjt) obj).zzb;
        if (zzmwVar != zzmw.zzc()) {
            return zzmwVar;
        }
        zzmw zzmwVarZzd = zzmw.zzd();
        zza(obj, zzmwVarZzd);
        return zzmwVarZzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ zzmw zzd(Object obj) {
        return ((zzjt) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ zzmw zze(zzmw zzmwVar) {
        zzmw zzmwVar2 = zzmwVar;
        zzmwVar2.zze();
        return zzmwVar2;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzf(Object obj) {
        ((zzjt) obj).zzb.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ int zza(zzmw zzmwVar) {
        return zzmwVar.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zzb(zzmw zzmwVar, int i10, long j10) {
        zzmwVar.zza(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ zzmw zza(zzmw zzmwVar, zzmw zzmwVar2) {
        zzmw zzmwVar3 = zzmwVar;
        zzmw zzmwVar4 = zzmwVar2;
        if (zzmw.zzc().equals(zzmwVar4)) {
            return zzmwVar3;
        }
        if (zzmw.zzc().equals(zzmwVar3)) {
            return zzmw.zza(zzmwVar3, zzmwVar4);
        }
        return zzmwVar3.zza(zzmwVar4);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zzb(Object obj, zzmw zzmwVar) {
        zza(obj, zzmwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zzc(Object obj, zzmw zzmwVar) {
        zza(obj, zzmwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zzb(zzmw zzmwVar, zznt zzntVar) throws IOException {
        zzmwVar.zzb(zzntVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ zzmw zza() {
        return zzmw.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zza(zzmw zzmwVar, int i10, int i11) {
        zzmwVar.zza((i10 << 3) | 5, Integer.valueOf(i11));
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zza(zzmw zzmwVar, int i10, long j10) {
        zzmwVar.zza((i10 << 3) | 1, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zza(zzmw zzmwVar, int i10, zzmw zzmwVar2) {
        zzmwVar.zza((i10 << 3) | 3, zzmwVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zza(zzmw zzmwVar, int i10, zzij zzijVar) {
        zzmwVar.zza((i10 << 3) | 2, zzijVar);
    }

    private static void zza(Object obj, zzmw zzmwVar) {
        ((zzjt) obj).zzb = zzmwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final /* synthetic */ void zza(zzmw zzmwVar, zznt zzntVar) throws IOException {
        zzmwVar.zza(zzntVar);
    }
}
