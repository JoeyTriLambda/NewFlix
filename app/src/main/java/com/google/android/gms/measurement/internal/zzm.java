package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* loaded from: classes.dex */
final class zzm implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8469b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f8470m;

    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8469b = zzdiVar;
        this.f8470m = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.f8470m;
        appMeasurementDynamiteService.f7610a.zzt().zza(this.f8469b, appMeasurementDynamiteService.f7610a.zzab());
    }
}
