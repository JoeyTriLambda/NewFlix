package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzr extends RemoteMediaClient.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastSession f6795a;

    public zzr(CastSession castSession) {
        this.f6795a = castSession;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zza(String str, long j10, int i10, long j11, long j12) {
        zzs zzsVar = this.f6795a.f6388m;
        if (zzsVar != null) {
            zzsVar.zzb(str, j10, i10, j11, j12);
        }
    }
}
