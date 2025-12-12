package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzml implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8499b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzmi f8500m;

    public zzml(zzmi zzmiVar, long j10) {
        this.f8499b = j10;
        this.f8500m = zzmiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzmi zzmiVar = this.f8500m;
        zzmiVar.zzt();
        zzmiVar.a();
        zzgd zzgdVarZzp = zzmiVar.zzj().zzp();
        long j10 = this.f8499b;
        zzgdVarZzp.zza("Activity resumed, time", Long.valueOf(j10));
        boolean zZza = zzmiVar.zze().zza(zzbh.K0);
        zzmo zzmoVar = zzmiVar.f8495f;
        if (zZza) {
            if (zzmiVar.zze().zzv() || zzmiVar.f8493d) {
                zzmoVar.f8509d.zzt();
                zzmoVar.f8508c.a();
                zzmoVar.f8506a = j10;
                zzmoVar.f8507b = j10;
            }
        } else if (zzmiVar.zze().zzv() || zzmiVar.zzk().f8009t.zza()) {
            zzmoVar.f8509d.zzt();
            zzmoVar.f8508c.a();
            zzmoVar.f8506a = j10;
            zzmoVar.f8507b = j10;
        }
        zzmn zzmnVar = zzmiVar.f8496g;
        zzmi zzmiVar2 = zzmnVar.f8505b;
        zzmiVar2.zzt();
        zzmm zzmmVar = zzmnVar.f8504a;
        if (zzmmVar != null) {
            zzmiVar2.f8492c.removeCallbacks(zzmmVar);
        }
        zzmiVar2.zzk().f8009t.zza(false);
        zzmiVar2.zzt();
        zzmiVar2.f8493d = false;
        zzmq zzmqVar = zzmiVar.f8494e;
        zzmqVar.f8511a.zzt();
        zzmi zzmiVar3 = zzmqVar.f8511a;
        if (zzmiVar3.f8189a.zzac()) {
            zzmqVar.b(zzmiVar3.zzb().currentTimeMillis(), false);
        }
    }
}
