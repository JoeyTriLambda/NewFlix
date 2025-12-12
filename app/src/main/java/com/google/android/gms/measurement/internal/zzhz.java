package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhz implements Callable<List<zzac>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8148b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8149m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8150n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzhs f8151o;

    public zzhz(zzhs zzhsVar, String str, String str2, String str3) {
        this.f8148b = str;
        this.f8149m = str2;
        this.f8150n = str3;
        this.f8151o = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzac> call() throws Exception {
        zzhs zzhsVar = this.f8151o;
        zzhsVar.f8127a.J();
        return zzhsVar.f8127a.zzf().zza(this.f8148b, this.f8149m, this.f8150n);
    }
}
