package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzs implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f6873b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzab f6874m;

    public zzs(zzw zzwVar, zzab zzabVar) {
        this.f6873b = zzwVar;
        this.f6874m = zzabVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        boolean z11;
        boolean z12;
        Logger logger = zzw.f6882x;
        zzab zzabVar = this.f6874m;
        ApplicationMetadata applicationMetadataZze = zzabVar.zze();
        zzw zzwVar = this.f6873b;
        boolean zZze = CastUtils.zze(applicationMetadataZze, zzwVar.f6885a);
        Cast.Listener listener = zzwVar.f6887c;
        if (!zZze) {
            zzwVar.f6885a = applicationMetadataZze;
            listener.onApplicationMetadataChanged(applicationMetadataZze);
        }
        double dZzb = zzabVar.zzb();
        if (Double.isNaN(dZzb) || Math.abs(dZzb - zzwVar.f6897m) <= 1.0E-7d) {
            z10 = false;
        } else {
            zzwVar.f6897m = dZzb;
            z10 = true;
        }
        boolean zZzg = zzabVar.zzg();
        if (zZzg != zzwVar.f6893i) {
            zzwVar.f6893i = zZzg;
            z10 = true;
        }
        Double.isNaN(zzabVar.zza());
        Logger logger2 = zzw.f6882x;
        logger2.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzwVar.f6895k));
        if (listener != null && (z10 || zzwVar.f6895k)) {
            listener.onVolumeChanged();
        }
        int iZzc = zzabVar.zzc();
        if (iZzc != zzwVar.f6899o) {
            zzwVar.f6899o = iZzc;
            z11 = true;
        } else {
            z11 = false;
        }
        logger2.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(zzwVar.f6895k));
        if (listener != null && (z11 || zzwVar.f6895k)) {
            listener.onActiveInputStateChanged(zzwVar.f6899o);
        }
        int iZzd = zzabVar.zzd();
        if (iZzd != zzwVar.f6900p) {
            zzwVar.f6900p = iZzd;
            z12 = true;
        } else {
            z12 = false;
        }
        logger2.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(zzwVar.f6895k));
        if (listener != null && (z12 || zzwVar.f6895k)) {
            listener.onStandbyStateChanged(zzwVar.f6900p);
        }
        if (!CastUtils.zze(zzwVar.f6898n, zzabVar.zzf())) {
            zzwVar.f6898n = zzabVar.zzf();
        }
        zzwVar.f6895k = false;
    }
}
