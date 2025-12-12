package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlz implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentName f8467b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzlx f8468m;

    public zzlz(zzlx zzlxVar, ComponentName componentName) {
        this.f8467b = componentName;
        this.f8468m = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzla.b(this.f8468m.f8464c, this.f8467b);
    }
}
