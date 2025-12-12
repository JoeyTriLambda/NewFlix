package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhu implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8132b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8133m;

    public zzhu(zzhs zzhsVar, zzn zznVar) {
        this.f8132b = zznVar;
        this.f8133m = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhs zzhsVar = this.f8133m;
        zzhsVar.f8127a.J();
        zznd zzndVar = zzhsVar.f8127a;
        zzndVar.zzl().zzt();
        zzndVar.K();
        zzn zznVar = this.f8132b;
        Preconditions.checkNotEmpty(zznVar.f8526b);
        zzndVar.d(zznVar);
    }
}
