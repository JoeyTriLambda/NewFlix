package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzid implements Callable<zzal> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8167b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8168m;

    public zzid(zzhs zzhsVar, zzn zznVar) {
        this.f8167b = zznVar;
        this.f8168m = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzal call() throws Exception {
        zzhs zzhsVar = this.f8168m;
        zzhsVar.f8127a.J();
        return new zzal(zzhsVar.f8127a.b(this.f8167b.f8526b));
    }
}
