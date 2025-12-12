package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkb implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8309b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8310m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8311n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f8312o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zziy f8313p;

    public zzkb(zziy zziyVar, AtomicReference atomicReference, String str, String str2, boolean z10) {
        this.f8309b = atomicReference;
        this.f8310m = str;
        this.f8311n = str2;
        this.f8312o = z10;
        this.f8313p = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8313p.f8189a.zzr().zza(this.f8309b, null, this.f8310m, this.f8311n, this.f8312o);
    }
}
