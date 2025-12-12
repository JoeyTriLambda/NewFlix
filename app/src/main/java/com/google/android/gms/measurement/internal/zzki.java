package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzki implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziq f8325b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f8326m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f8327n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zziq f8328o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zziy f8329p;

    public zzki(zziy zziyVar, zziq zziqVar, long j10, boolean z10, zziq zziqVar2) {
        this.f8325b = zziqVar;
        this.f8326m = j10;
        this.f8327n = z10;
        this.f8328o = zziqVar2;
        this.f8329p = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziy zziyVar = this.f8329p;
        zziq zziqVar = this.f8325b;
        zziyVar.d(zziqVar);
        zziy.e(this.f8329p, this.f8325b, this.f8326m, false, this.f8327n);
        if (zzqk.zza() && zziyVar.zze().zza(zzbh.f7762r0)) {
            zziy.f(zziyVar, zziqVar, this.f8328o);
        }
    }
}
