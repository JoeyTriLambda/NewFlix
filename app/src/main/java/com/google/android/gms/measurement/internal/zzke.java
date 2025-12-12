package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzke implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8317b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8318m;

    public zzke(zziy zziyVar, AtomicReference atomicReference) {
        this.f8317b = atomicReference;
        this.f8318m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8317b) {
            try {
                this.f8317b.set(Double.valueOf(this.f8318m.zze().zza(this.f8318m.zzg().a(), zzbh.P)));
            } finally {
                this.f8317b.notify();
            }
        }
    }
}
