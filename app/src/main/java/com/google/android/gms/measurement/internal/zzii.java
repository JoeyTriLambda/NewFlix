package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzii implements Callable<byte[]> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbf f8180b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8181m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzhs f8182n;

    public zzii(zzhs zzhsVar, zzbf zzbfVar, String str) {
        this.f8180b = zzbfVar;
        this.f8181m = str;
        this.f8182n = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzhs zzhsVar = this.f8182n;
        zzhsVar.f8127a.J();
        return zzhsVar.f8127a.zzm().zza(this.f8180b, this.f8181m);
    }
}
