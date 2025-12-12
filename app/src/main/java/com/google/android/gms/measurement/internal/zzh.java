package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* loaded from: classes.dex */
final class zzh implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8059b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f8060m;

    public zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8059b = zzdiVar;
        this.f8060m = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8060m.f7610a.zzr().zza(this.f8059b);
    }
}
