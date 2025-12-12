package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkf implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8319b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8320m;

    public zzkf(zziy zziyVar, AtomicReference atomicReference) {
        this.f8319b = atomicReference;
        this.f8320m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8319b) {
            try {
                this.f8319b.set(Integer.valueOf(this.f8320m.zze().zzb(this.f8320m.zzg().a(), zzbh.O)));
            } finally {
                this.f8319b.notify();
            }
        }
    }
}
