package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzju implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8290b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8291m;

    public zzju(zziy zziyVar, AtomicReference atomicReference) {
        this.f8290b = atomicReference;
        this.f8291m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8290b) {
            try {
                AtomicReference atomicReference = this.f8290b;
                zzae zzaeVarZze = this.f8291m.zze();
                String strA = this.f8291m.zzg().a();
                zzaeVarZze.getClass();
                atomicReference.set(zzaeVarZze.zzd(strA, zzbh.M));
            } finally {
                this.f8290b.notify();
            }
        }
    }
}
