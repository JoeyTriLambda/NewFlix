package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzif implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbf f8171b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8172m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzhs f8173n;

    public zzif(zzhs zzhsVar, zzbf zzbfVar, String str) {
        this.f8171b = zzbfVar;
        this.f8172m = str;
        this.f8173n = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzhs zzhsVar = this.f8173n;
        zzhsVar.f8127a.J();
        zzhsVar.f8127a.l(this.f8171b, this.f8172m);
    }
}
