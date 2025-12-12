package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzht implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8130b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8131m;

    public zzht(zzhs zzhsVar, zzn zznVar) {
        this.f8130b = zznVar;
        this.f8131m = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzhs zzhsVar = this.f8131m;
        zzhsVar.f8127a.J();
        zzhsVar.f8127a.E(this.f8130b);
    }
}
