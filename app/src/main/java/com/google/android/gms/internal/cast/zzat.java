package com.google.android.gms.internal.cast;

import a2.n;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzat extends n.a {
    private static final Logger zza = new Logger("MediaRouterCallback");
    private final zzao zzb;

    public zzat(zzao zzaoVar) {
        this.zzb = (zzao) Preconditions.checkNotNull(zzaoVar);
    }

    @Override // a2.n.a
    public final void onRouteAdded(n nVar, n.g gVar) {
        try {
            this.zzb.zzf(gVar.getId(), gVar.getExtras());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteAdded", "zzao");
        }
    }

    @Override // a2.n.a
    public final void onRouteChanged(n nVar, n.g gVar) {
        try {
            this.zzb.zzg(gVar.getId(), gVar.getExtras());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteChanged", "zzao");
        }
    }

    @Override // a2.n.a
    public final void onRouteRemoved(n nVar, n.g gVar) {
        try {
            this.zzb.zzh(gVar.getId(), gVar.getExtras());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteRemoved", "zzao");
        }
    }

    @Override // a2.n.a
    public final void onRouteSelected(n nVar, n.g gVar, int i10) {
        CastDevice fromBundle;
        CastDevice fromBundle2;
        zza.i("onRouteSelected with reason = %d, routeId = %s", Integer.valueOf(i10), gVar.getId());
        if (gVar.getPlaybackType() != 1) {
            return;
        }
        try {
            String id2 = gVar.getId();
            String id3 = gVar.getId();
            if (id3 != null && id3.endsWith("-groupRoute") && (fromBundle = CastDevice.getFromBundle(gVar.getExtras())) != null) {
                String deviceId = fromBundle.getDeviceId();
                Iterator<n.g> it = nVar.getRoutes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n.g next = it.next();
                    String id4 = next.getId();
                    if (id4 != null && !id4.endsWith("-groupRoute") && (fromBundle2 = CastDevice.getFromBundle(next.getExtras())) != null && TextUtils.equals(fromBundle2.getDeviceId(), deviceId)) {
                        zza.d("routeId is changed from %s to %s", id3, next.getId());
                        id3 = next.getId();
                        break;
                    }
                }
            }
            if (this.zzb.zze() >= 220400000) {
                this.zzb.zzj(id3, id2, gVar.getExtras());
            } else {
                this.zzb.zzi(id3, gVar.getExtras());
            }
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteSelected", "zzao");
        }
    }

    @Override // a2.n.a
    public final void onRouteUnselected(n nVar, n.g gVar, int i10) {
        Logger logger = zza;
        logger.i("onRouteUnselected with reason = %d, routeId = %s", Integer.valueOf(i10), gVar.getId());
        if (gVar.getPlaybackType() != 1) {
            logger.d("skip route unselection for non-cast route", new Object[0]);
            return;
        }
        try {
            this.zzb.zzk(gVar.getId(), gVar.getExtras(), i10);
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteUnselected", "zzao");
        }
    }
}
