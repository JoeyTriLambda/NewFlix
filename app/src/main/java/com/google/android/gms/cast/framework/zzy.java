package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzy extends Cast.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastSession f6799a;

    public /* synthetic */ zzy(CastSession castSession) {
        this.f6799a = castSession;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onActiveInputStateChanged(int i10) {
        Iterator it = new HashSet(this.f6799a.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onActiveInputStateChanged(i10);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onApplicationDisconnected(int i10) throws IllegalArgumentException {
        CastSession castSession = this.f6799a;
        castSession.f6383h.zzi(i10);
        com.google.android.gms.cast.zzr zzrVar = castSession.f6384i;
        if (zzrVar != null) {
            zzrVar.zzf();
            castSession.f6384i = null;
        }
        castSession.f6386k = null;
        RemoteMediaClient remoteMediaClient = castSession.f6385j;
        if (remoteMediaClient != null) {
            remoteMediaClient.zzs(null);
            castSession.f6385j = null;
        }
        castSession.notifySessionEnded(i10);
        Iterator it = new HashSet(castSession.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onApplicationDisconnected(i10);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        Iterator it = new HashSet(this.f6799a.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onApplicationMetadataChanged(applicationMetadata);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onApplicationStatusChanged() {
        Iterator it = new HashSet(this.f6799a.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onApplicationStatusChanged();
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onStandbyStateChanged(int i10) {
        Iterator it = new HashSet(this.f6799a.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onStandbyStateChanged(i10);
        }
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onVolumeChanged() {
        Iterator it = new HashSet(this.f6799a.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onVolumeChanged();
        }
    }
}
