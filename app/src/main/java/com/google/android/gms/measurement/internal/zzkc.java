package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkc implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8314b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8315m;

    public zzkc(zziy zziyVar, AtomicReference atomicReference) {
        this.f8314b = atomicReference;
        this.f8315m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8314b) {
            try {
                this.f8314b.set(Long.valueOf(this.f8315m.zze().zzc(this.f8315m.zzg().a(), zzbh.N)));
            } finally {
                this.f8314b.notify();
            }
        }
    }
}
