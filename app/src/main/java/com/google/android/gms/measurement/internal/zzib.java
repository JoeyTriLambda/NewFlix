package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzib implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8161b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8162m;

    public zzib(zzhs zzhsVar, zzn zznVar) {
        this.f8161b = zznVar;
        this.f8162m = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzhs zzhsVar = this.f8162m;
        zzhsVar.f8127a.J();
        zzhsVar.f8127a.G(this.f8161b);
    }
}
