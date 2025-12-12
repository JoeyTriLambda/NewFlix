package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhv implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzac f8134b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzn f8135m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzhs f8136n;

    public zzhv(zzhs zzhsVar, zzac zzacVar, zzn zznVar) {
        this.f8134b = zzacVar;
        this.f8135m = zznVar;
        this.f8136n = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhs zzhsVar = this.f8136n;
        zzhsVar.f8127a.J();
        zzac zzacVar = this.f8134b;
        Object objZza = zzacVar.f7629n.zza();
        zzn zznVar = this.f8135m;
        if (objZza == null) {
            zzhsVar.f8127a.j(zzacVar, zznVar);
        } else {
            zzhsVar.f8127a.z(zzacVar, zznVar);
        }
    }
}
