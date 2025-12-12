package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* loaded from: classes.dex */
final class zzi implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8152b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8153m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8154n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f8155o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f8156p;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2, boolean z10) {
        this.f8152b = zzdiVar;
        this.f8153m = str;
        this.f8154n = str2;
        this.f8155o = z10;
        this.f8156p = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8156p.f7610a.zzr().zza(this.f8152b, this.f8153m, this.f8154n, this.f8155o);
    }
}
