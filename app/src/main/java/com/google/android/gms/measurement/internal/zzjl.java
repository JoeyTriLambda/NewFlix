package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjl implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8266b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8267m;

    public zzjl(zziy zziyVar, AtomicReference atomicReference) {
        this.f8266b = atomicReference;
        this.f8267m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8266b) {
            try {
                AtomicReference atomicReference = this.f8266b;
                zzae zzaeVarZze = this.f8267m.zze();
                String strA = this.f8267m.zzg().a();
                zzaeVarZze.getClass();
                atomicReference.set(Boolean.valueOf(zzaeVarZze.zzf(strA, zzbh.L)));
            } finally {
                this.f8266b.notify();
            }
        }
    }
}
