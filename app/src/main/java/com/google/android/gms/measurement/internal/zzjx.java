package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjx implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f8295b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8296m;

    public zzjx(zziy zziyVar, long j10) {
        this.f8295b = j10;
        this.f8296m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        long j10 = this.f8295b;
        zziy zziyVar = this.f8296m;
        zziyVar.a(j10, true);
        zziyVar.zzo().zza(new AtomicReference<>());
    }
}
