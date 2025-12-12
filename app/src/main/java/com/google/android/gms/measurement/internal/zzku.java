package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzku implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8357b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzks f8358m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzks f8359n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f8360o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zzkv f8361p;

    public zzku(zzkv zzkvVar, Bundle bundle, zzks zzksVar, zzks zzksVar2, long j10) {
        this.f8357b = bundle;
        this.f8358m = zzksVar;
        this.f8359n = zzksVar2;
        this.f8360o = j10;
        this.f8361p = zzkvVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzks zzksVar = this.f8358m;
        zzks zzksVar2 = this.f8359n;
        long j10 = this.f8360o;
        Bundle bundle = this.f8357b;
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        zzkv zzkvVar = this.f8361p;
        zzkvVar.c(zzksVar, zzksVar2, j10, true, zzkvVar.zzq().f("screen_view", bundle, null, false));
    }
}
