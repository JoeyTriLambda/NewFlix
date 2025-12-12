package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzky implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzks f8378b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f8379m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzkv f8380n;

    public zzky(zzkv zzkvVar, zzks zzksVar, long j10) {
        this.f8378b = zzksVar;
        this.f8379m = j10;
        this.f8380n = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkv zzkvVar = this.f8380n;
        zzkvVar.d(this.f8378b, false, this.f8379m);
        zzkvVar.f8364e = null;
        zzkvVar.zzo().zza((zzks) null);
    }
}
