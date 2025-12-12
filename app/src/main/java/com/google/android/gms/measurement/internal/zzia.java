package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzia implements Callable<List<zznq>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8157b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8158m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8159n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzhs f8160o;

    public zzia(zzhs zzhsVar, String str, String str2, String str3) {
        this.f8157b = str;
        this.f8158m = str2;
        this.f8159n = str3;
        this.f8160o = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznq> call() throws Exception {
        zzhs zzhsVar = this.f8160o;
        zzhsVar.f8127a.J();
        return zzhsVar.f8127a.zzf().zzb(this.f8157b, this.f8158m, this.f8159n);
    }
}
