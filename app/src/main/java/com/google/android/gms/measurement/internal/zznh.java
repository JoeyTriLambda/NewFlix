package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zznh implements Callable<String> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8580b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zznd f8581m;

    public zznh(zznd zzndVar, zzn zznVar) {
        this.f8580b = zznVar;
        this.f8581m = zzndVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzn zznVar = this.f8580b;
        String str = (String) Preconditions.checkNotNull(zznVar.f8526b);
        zznd zzndVar = this.f8581m;
        if (zzndVar.y(str).zzj() && zziq.zzb(zznVar.G).zzj()) {
            return zzndVar.d(zznVar).zzab();
        }
        zzndVar.zzj().zzp().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
