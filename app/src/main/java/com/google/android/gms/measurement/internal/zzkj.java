package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkj implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziq f8330b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f8331m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f8332n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f8333o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zziq f8334p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ zziy f8335q;

    public zzkj(zziy zziyVar, zziq zziqVar, long j10, long j11, boolean z10, zziq zziqVar2) {
        this.f8330b = zziqVar;
        this.f8331m = j10;
        this.f8332n = j11;
        this.f8333o = z10;
        this.f8334p = zziqVar2;
        this.f8335q = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziy zziyVar = this.f8335q;
        zziq zziqVar = this.f8330b;
        zziyVar.d(zziqVar);
        zziyVar.a(this.f8331m, false);
        zziy.e(this.f8335q, this.f8330b, this.f8332n, true, this.f8333o);
        if (zzqk.zza() && zziyVar.zze().zza(zzbh.f7762r0)) {
            zziy.f(zziyVar, zziqVar, this.f8334p);
        }
    }
}
