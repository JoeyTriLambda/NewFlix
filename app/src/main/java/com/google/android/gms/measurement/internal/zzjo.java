package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjo implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8272b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8273m;

    public zzjo(zziy zziyVar, long j10) {
        this.f8272b = j10;
        this.f8273m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziy zziyVar = this.f8273m;
        zzgr zzgrVar = zziyVar.zzk().f8001l;
        long j10 = this.f8272b;
        zzgrVar.zza(j10);
        zziyVar.zzj().zzc().zza("Session timeout duration set", Long.valueOf(j10));
    }
}
