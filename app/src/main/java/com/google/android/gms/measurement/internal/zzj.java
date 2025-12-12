package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* loaded from: classes.dex */
final class zzj implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8246b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzbf f8247m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8248n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f8249o;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdi zzdiVar, zzbf zzbfVar, String str) {
        this.f8246b = zzdiVar;
        this.f8247m = zzbfVar;
        this.f8248n = str;
        this.f8249o = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8249o.f7610a.zzr().zza(this.f8246b, this.f8247m, this.f8248n);
    }
}
