package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zze implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7852b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zza f7853m;

    public zze(zza zzaVar, long j10) {
        this.f7852b = j10;
        this.f7853m = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7853m.c(this.f7852b);
    }
}
