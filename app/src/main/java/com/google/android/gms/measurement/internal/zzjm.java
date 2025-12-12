package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjm implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8268b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8269m;

    public zzjm(zziy zziyVar, boolean z10) {
        this.f8268b = z10;
        this.f8269m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziy zziyVar = this.f8269m;
        boolean zZzac = zziyVar.f8189a.zzac();
        boolean zZzab = zziyVar.f8189a.zzab();
        zzho zzhoVar = zziyVar.f8189a;
        boolean z10 = this.f8268b;
        zzhoVar.A = Boolean.valueOf(z10);
        if (zZzab == z10) {
            zziyVar.f8189a.zzj().zzp().zza("Default data collection state already set to", Boolean.valueOf(z10));
        }
        if (zziyVar.f8189a.zzac() == zZzac || zziyVar.f8189a.zzac() != zziyVar.f8189a.zzab()) {
            zziyVar.f8189a.zzj().zzv().zza("Default data collection is different than actual status", Boolean.valueOf(z10), Boolean.valueOf(zZzac));
        }
        zziyVar.m();
    }
}
