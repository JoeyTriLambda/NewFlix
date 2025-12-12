package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbn implements com.google.android.gms.cast.internal.zzan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6749a;

    public /* synthetic */ zzbn(RemoteMediaClient remoteMediaClient) {
        this.f6749a = remoteMediaClient;
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zza() {
        RemoteMediaClient remoteMediaClient = this.f6749a;
        Iterator it = remoteMediaClient.f6535h.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onAdBreakStatusUpdated();
        }
        Iterator it2 = remoteMediaClient.f6536i.iterator();
        while (it2.hasNext()) {
            ((RemoteMediaClient.Callback) it2.next()).onAdBreakStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzb(MediaError mediaError) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).onMediaError(mediaError);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzc() {
        Logger logger = RemoteMediaClient.f6527l;
        RemoteMediaClient remoteMediaClient = this.f6749a;
        remoteMediaClient.getClass();
        Iterator it = remoteMediaClient.f6535h.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onMetadataUpdated();
        }
        Iterator it2 = remoteMediaClient.f6536i.iterator();
        while (it2.hasNext()) {
            ((RemoteMediaClient.Callback) it2.next()).onMetadataUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzd() {
        RemoteMediaClient remoteMediaClient = this.f6749a;
        Iterator it = remoteMediaClient.f6535h.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onPreloadStatusUpdated();
        }
        Iterator it2 = remoteMediaClient.f6536i.iterator();
        while (it2.hasNext()) {
            ((RemoteMediaClient.Callback) it2.next()).onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zze(int[] iArr) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zzb(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzf(int[] iArr, int i10) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zzc(iArr, i10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzg(MediaQueueItem[] mediaQueueItemArr) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zzd(mediaQueueItemArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzh(int[] iArr) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zze(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzi(List list, List list2, int i10) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zzf(list, list2, i10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzj(int[] iArr) {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zzg(iArr);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzk() {
        RemoteMediaClient remoteMediaClient = this.f6749a;
        Iterator it = remoteMediaClient.f6535h.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onQueueStatusUpdated();
        }
        Iterator it2 = remoteMediaClient.f6536i.iterator();
        while (it2.hasNext()) {
            ((RemoteMediaClient.Callback) it2.next()).onQueueStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzl() {
        Iterator it = this.f6749a.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zzh();
        }
    }

    @Override // com.google.android.gms.cast.internal.zzan
    public final void zzm() {
        Logger logger = RemoteMediaClient.f6527l;
        RemoteMediaClient remoteMediaClient = this.f6749a;
        remoteMediaClient.getClass();
        for (zzbp zzbpVar : remoteMediaClient.f6538k.values()) {
            if (remoteMediaClient.hasMediaSession() && !zzbpVar.zzi()) {
                zzbpVar.zzf();
            } else if (!remoteMediaClient.hasMediaSession() && zzbpVar.zzi()) {
                zzbpVar.zzg();
            }
            if (zzbpVar.zzi() && (remoteMediaClient.isBuffering() || remoteMediaClient.a() || remoteMediaClient.isPaused() || remoteMediaClient.isLoadingNextItem())) {
                remoteMediaClient.b(zzbpVar.f6751a);
            }
        }
        Iterator it = remoteMediaClient.f6535h.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Listener) it.next()).onStatusUpdated();
        }
        Iterator it2 = remoteMediaClient.f6536i.iterator();
        while (it2.hasNext()) {
            ((RemoteMediaClient.Callback) it2.next()).onStatusUpdated();
        }
    }
}
