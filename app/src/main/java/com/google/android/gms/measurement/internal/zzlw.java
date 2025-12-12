package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlw implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfq f8460b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzlx f8461m;

    public zzlw(zzlx zzlxVar, zzfq zzfqVar) {
        this.f8460b = zzfqVar;
        this.f8461m = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8461m) {
            this.f8461m.f8462a = false;
            if (!this.f8461m.f8464c.zzah()) {
                this.f8461m.f8464c.zzj().zzp().zza("Connected to service");
                this.f8461m.f8464c.zza(this.f8460b);
            }
        }
    }
}
