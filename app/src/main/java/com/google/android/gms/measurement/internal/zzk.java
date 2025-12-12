package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* loaded from: classes.dex */
final class zzk implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8303b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8304m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8305n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f8306o;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2) {
        this.f8303b = zzdiVar;
        this.f8304m = str;
        this.f8305n = str2;
        this.f8306o = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8306o.f7610a.zzr().zza(this.f8303b, this.f8304m, this.f8305n);
    }
}
