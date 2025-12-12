package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* loaded from: classes.dex */
final class zzl implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService.zza f8383b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f8384m;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.zza zzaVar) {
        this.f8383b = zzaVar;
        this.f8384m = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8384m.f7610a.zzp().zza(this.f8383b);
    }
}
