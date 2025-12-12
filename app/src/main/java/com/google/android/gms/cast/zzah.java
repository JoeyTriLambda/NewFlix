package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzah implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CastRemoteDisplayLocalService f6924b;

    public zzah(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.f6924b = castRemoteDisplayLocalService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.f6924b;
        castRemoteDisplayLocalService.a("onCreate after delay. The local service been started: " + castRemoteDisplayLocalService.f6175s);
        if (castRemoteDisplayLocalService.f6175s) {
            return;
        }
        CastRemoteDisplayLocalService.f6164w.e("[Instance: %s] %s", castRemoteDisplayLocalService, "The local service has not been been started, stopping it");
        castRemoteDisplayLocalService.stopSelf();
    }
}
