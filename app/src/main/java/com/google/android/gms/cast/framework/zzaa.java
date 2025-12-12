package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzaa extends com.google.android.gms.cast.zzq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastSession f6783a;

    public /* synthetic */ zzaa(CastSession castSession) {
        this.f6783a = castSession;
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zza() {
        CastSession castSession = this.f6783a;
        if (castSession.f6380e == null) {
            return;
        }
        try {
            RemoteMediaClient remoteMediaClient = castSession.f6385j;
            if (remoteMediaClient != null) {
                remoteMediaClient.zzq();
            }
            castSession.f6380e.zzh(null);
        } catch (RemoteException e10) {
            CastSession.f6377n.d(e10, "Unable to call %s on %s.", "onConnected", "zzam");
        }
        zzs zzsVar = castSession.f6388m;
        if (zzsVar != null) {
            zzsVar.zza();
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zzb(int i10) {
        zzam zzamVar = this.f6783a.f6380e;
        if (zzamVar == null) {
            return;
        }
        try {
            zzamVar.zzi(new ConnectionResult(i10));
        } catch (RemoteException e10) {
            CastSession.f6377n.d(e10, "Unable to call %s on %s.", "onConnectionFailed", "zzam");
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zzc(int i10) {
        zzam zzamVar = this.f6783a.f6380e;
        if (zzamVar == null) {
            return;
        }
        try {
            zzamVar.zzj(i10);
        } catch (RemoteException e10) {
            CastSession.f6377n.d(e10, "Unable to call %s on %s.", "onConnectionSuspended", "zzam");
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zzd(int i10) {
        zzam zzamVar = this.f6783a.f6380e;
        if (zzamVar == null) {
            return;
        }
        try {
            zzamVar.zzi(new ConnectionResult(i10));
        } catch (RemoteException e10) {
            CastSession.f6377n.d(e10, "Unable to call %s on %s.", "onDisconnected", "zzam");
        }
    }
}
