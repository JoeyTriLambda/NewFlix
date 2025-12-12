package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzly implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfq f8465b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzlx f8466m;

    public zzly(zzlx zzlxVar, zzfq zzfqVar) {
        this.f8465b = zzfqVar;
        this.f8466m = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8466m) {
            this.f8466m.f8462a = false;
            if (!this.f8466m.f8464c.zzah()) {
                this.f8466m.f8464c.zzj().zzc().zza("Connected to remote service");
                this.f8466m.f8464c.zza(this.f8465b);
            }
        }
    }
}
