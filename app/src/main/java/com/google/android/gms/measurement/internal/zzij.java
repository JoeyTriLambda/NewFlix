package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzij implements Callable<List<zznq>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8183b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8184m;

    public zzij(zzhs zzhsVar, String str) {
        this.f8183b = str;
        this.f8184m = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznq> call() throws Exception {
        zzhs zzhsVar = this.f8184m;
        zzhsVar.f8127a.J();
        return zzhsVar.f8127a.zzf().zzj(this.f8183b);
    }
}
