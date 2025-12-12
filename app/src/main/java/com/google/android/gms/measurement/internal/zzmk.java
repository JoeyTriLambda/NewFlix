package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzmk implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8497b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzmi f8498m;

    public zzmk(zzmi zzmiVar, long j10) {
        this.f8497b = j10;
        this.f8498m = zzmiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        long j10 = this.f8497b;
        zzmi zzmiVar = this.f8498m;
        zzmiVar.zzt();
        zzmiVar.a();
        zzmiVar.zzj().zzp().zza("Activity paused, time", Long.valueOf(j10));
        zzmn zzmnVar = zzmiVar.f8496g;
        zzmi zzmiVar2 = zzmnVar.f8505b;
        zzmm zzmmVar = new zzmm(zzmnVar, zzmiVar2.zzb().currentTimeMillis(), j10);
        zzmnVar.f8504a = zzmmVar;
        zzmiVar2.f8492c.postDelayed(zzmmVar, 2000L);
        if (zzmiVar.zze().zzv()) {
            zzmiVar.f8495f.f8508c.a();
        }
    }
}
