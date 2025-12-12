package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhx implements Callable<List<zznq>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8142b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8143m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8144n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzhs f8145o;

    public zzhx(zzhs zzhsVar, String str, String str2, String str3) {
        this.f8142b = str;
        this.f8143m = str2;
        this.f8144n = str3;
        this.f8145o = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznq> call() throws Exception {
        zzhs zzhsVar = this.f8145o;
        zzhsVar.f8127a.J();
        return zzhsVar.f8127a.zzf().zzb(this.f8142b, this.f8143m, this.f8144n);
    }
}
