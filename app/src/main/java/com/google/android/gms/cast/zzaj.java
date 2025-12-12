package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzaj implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6925b = false;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ CastRemoteDisplayLocalService f6926m;

    public zzaj(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.f6926m = castRemoteDisplayLocalService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger = CastRemoteDisplayLocalService.f6164w;
        this.f6926m.c(this.f6925b);
    }
}
