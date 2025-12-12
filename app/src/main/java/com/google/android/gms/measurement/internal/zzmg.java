package com.google.android.gms.measurement.internal;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzmg implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznd f8486b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Runnable f8487m;

    public zzmg(zznd zzndVar, Runnable runnable) {
        this.f8486b = zzndVar;
        this.f8487m = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznd zzndVar = this.f8486b;
        zzndVar.J();
        zzndVar.zzl().zzt();
        if (zzndVar.f8559p == null) {
            zzndVar.f8559p = new ArrayList();
        }
        zzndVar.f8559p.add(this.f8487m);
        zzndVar.L();
    }
}
