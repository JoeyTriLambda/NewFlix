package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzmb implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzlx f8472b;

    public zzmb(zzlx zzlxVar) {
        this.f8472b = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzlx zzlxVar = this.f8472b;
        zzla.b(zzlxVar.f8464c, new ComponentName(zzlxVar.f8464c.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
