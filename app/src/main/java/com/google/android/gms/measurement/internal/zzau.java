package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzau implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzio f7680b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzav f7681m;

    public zzau(zzav zzavVar, zzio zzioVar) {
        this.f7680b = zzioVar;
        this.f7681m = zzavVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f7680b.zzd();
        if (zzad.zza()) {
            this.f7680b.zzl().zzb(this);
            return;
        }
        boolean zZzc = this.f7681m.zzc();
        this.f7681m.f7685c = 0L;
        if (zZzc) {
            this.f7681m.zzb();
        }
    }
}
