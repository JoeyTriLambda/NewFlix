package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzt implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f6875b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zza f6876m;

    public zzt(zzw zzwVar, zza zzaVar) {
        this.f6875b = zzwVar;
        this.f6876m = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        Logger logger = zzw.f6882x;
        String strZza = this.f6876m.zza();
        zzw zzwVar = this.f6875b;
        if (CastUtils.zze(strZza, zzwVar.f6892h)) {
            z10 = false;
        } else {
            zzwVar.f6892h = strZza;
            z10 = true;
        }
        zzw.f6882x.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzwVar.f6894j));
        Cast.Listener listener = zzwVar.f6887c;
        if (listener != null && (z10 || zzwVar.f6894j)) {
            listener.onApplicationStatusChanged();
        }
        zzwVar.f6894j = false;
    }
}
