package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zznj implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8583b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8584m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Bundle f8585n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzng f8586o;

    public zznj(zzng zzngVar, String str, String str2, Bundle bundle) {
        this.f8583b = str;
        this.f8584m = str2;
        this.f8585n = bundle;
        this.f8586o = zzngVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzng zzngVar = this.f8586o;
        zznt zzntVarZzq = zzngVar.f8579a.zzq();
        String str = this.f8584m;
        Bundle bundle = this.f8585n;
        zznd zzndVar = zzngVar.f8579a;
        zzndVar.l((zzbf) Preconditions.checkNotNull(zzntVarZzq.g(str, bundle, "auto", zzndVar.zzb().currentTimeMillis(), false)), this.f8583b);
    }
}
