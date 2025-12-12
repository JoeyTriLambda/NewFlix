package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjy implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8297b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8298m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8299n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zziy f8300o;

    public zzjy(zziy zziyVar, AtomicReference atomicReference, String str, String str2) {
        this.f8297b = atomicReference;
        this.f8298m = str;
        this.f8299n = str2;
        this.f8300o = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8300o.f8189a.zzr().zza(this.f8297b, (String) null, this.f8298m, this.f8299n);
    }
}
