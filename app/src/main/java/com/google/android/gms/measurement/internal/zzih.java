package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzih implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzno f8177b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzn f8178m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzhs f8179n;

    public zzih(zzhs zzhsVar, zzno zznoVar, zzn zznVar) {
        this.f8177b = zznoVar;
        this.f8178m = zznVar;
        this.f8179n = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzhs zzhsVar = this.f8179n;
        zzhsVar.f8127a.J();
        zzno zznoVar = this.f8177b;
        Object objZza = zznoVar.zza();
        zzn zznVar = this.f8178m;
        if (objZza == null) {
            zzhsVar.f8127a.q(zznoVar.f8589m, zznVar);
        } else {
            zzhsVar.f8127a.n(zznoVar, zznVar);
        }
    }
}
