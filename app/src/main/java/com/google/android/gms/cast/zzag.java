package com.google.android.gms.cast;

import a2.n;
import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzag extends n.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastRemoteDisplayLocalService f6923a;

    public zzag(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.f6923a = castRemoteDisplayLocalService;
    }

    @Override // a2.n.a
    public final void onRouteUnselected(n nVar, n.g gVar) {
        Logger logger = CastRemoteDisplayLocalService.f6164w;
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.f6923a;
        castRemoteDisplayLocalService.a("onRouteUnselected");
        if (castRemoteDisplayLocalService.f6170n == null) {
            castRemoteDisplayLocalService.a("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(gVar.getExtras());
        if (fromBundle == null || !fromBundle.getDeviceId().equals(castRemoteDisplayLocalService.f6170n.getDeviceId())) {
            castRemoteDisplayLocalService.a("onRouteUnselected, device does not match");
        } else {
            CastRemoteDisplayLocalService.stopService();
        }
    }
}
