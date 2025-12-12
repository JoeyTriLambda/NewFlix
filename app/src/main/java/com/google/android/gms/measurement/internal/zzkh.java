package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkh implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Boolean f8323b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8324m;

    public zzkh(zziy zziyVar, Boolean bool) {
        this.f8323b = bool;
        this.f8324m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8324m.g(this.f8323b, true);
    }
}
