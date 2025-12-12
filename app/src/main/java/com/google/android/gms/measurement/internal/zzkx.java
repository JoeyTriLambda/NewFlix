package com.google.android.gms.measurement.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkx implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzks f8373b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzks f8374m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f8375n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f8376o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zzkv f8377p;

    public zzkx(zzkv zzkvVar, zzks zzksVar, zzks zzksVar2, long j10, boolean z10) {
        this.f8373b = zzksVar;
        this.f8374m = zzksVar2;
        this.f8375n = j10;
        this.f8376o = z10;
        this.f8377p = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f8377p.c(this.f8373b, this.f8374m, this.f8375n, this.f8376o, null);
    }
}
