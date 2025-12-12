package com.google.android.gms.cast;

import a2.m;
import a2.n;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzai implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = ((zzao) iBinder).f6928a;
        Logger logger = CastRemoteDisplayLocalService.f6164w;
        castRemoteDisplayLocalService.a("startRemoteDisplaySession");
        Preconditions.checkMainThread("Starting the Cast Remote Display must be done on the main thread");
        synchronized (CastRemoteDisplayLocalService.f6165x) {
            if (CastRemoteDisplayLocalService.f6167z != null) {
                Logger logger2 = CastRemoteDisplayLocalService.f6164w;
                logger2.w("An existing service had not been stopped before starting one", new Object[0]);
                logger2.e("Connected but unable to get the service instance", new Object[0]);
                new Status(2200);
                throw null;
            }
            CastRemoteDisplayLocalService.f6167z = castRemoteDisplayLocalService;
            castRemoteDisplayLocalService.f6169m = new WeakReference(null);
            castRemoteDisplayLocalService.f6168b = null;
            castRemoteDisplayLocalService.f6170n = null;
            castRemoteDisplayLocalService.f6171o = null;
            castRemoteDisplayLocalService.f6172p = this;
            if (castRemoteDisplayLocalService.f6174r == null) {
                castRemoteDisplayLocalService.f6174r = n.getInstance(castRemoteDisplayLocalService.getApplicationContext());
            }
            Preconditions.checkNotNull(castRemoteDisplayLocalService.f6168b, "applicationId is required.");
            m mVarBuild = new m.a().addControlCategory(CastMediaControlIntent.categoryForCast(castRemoteDisplayLocalService.f6168b)).build();
            castRemoteDisplayLocalService.a("addMediaRouterCallback");
            castRemoteDisplayLocalService.f6174r.addCallback(mVarBuild, castRemoteDisplayLocalService.f6177u, 4);
            throw null;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        CastRemoteDisplayLocalService.f6164w.d("onServiceDisconnected", new Object[0]);
        new Status(2201, "Service Disconnected");
        throw null;
    }
}
