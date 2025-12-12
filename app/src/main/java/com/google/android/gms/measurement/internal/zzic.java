package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzic implements Callable<List<zzac>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8163b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8164m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8165n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzhs f8166o;

    public zzic(zzhs zzhsVar, String str, String str2, String str3) {
        this.f8163b = str;
        this.f8164m = str2;
        this.f8165n = str3;
        this.f8166o = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzac> call() throws Exception {
        zzhs zzhsVar = this.f8166o;
        zzhsVar.f8127a.J();
        return zzhsVar.f8127a.zzf().zza(this.f8163b, this.f8164m, this.f8165n);
    }
}
