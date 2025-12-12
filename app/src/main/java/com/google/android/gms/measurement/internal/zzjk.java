package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjk implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziy f8265b;

    public zzjk(zziy zziyVar) {
        this.f8265b = zziyVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) throws IllegalStateException {
        this.f8265b.zzl().zzb(runnable);
    }
}
