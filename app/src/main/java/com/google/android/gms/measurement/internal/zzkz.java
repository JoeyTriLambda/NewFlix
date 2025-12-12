package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkz implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8381b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzkv f8382m;

    public zzkz(zzkv zzkvVar, long j10) {
        this.f8381b = j10;
        this.f8382m = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkv zzkvVar = this.f8382m;
        zzkvVar.zzc().zza(this.f8381b);
        zzkvVar.f8364e = null;
    }
}
