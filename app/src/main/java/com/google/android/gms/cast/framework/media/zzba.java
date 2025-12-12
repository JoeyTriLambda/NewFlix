package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaSeekOptions;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzba extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaSeekOptions f6735d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6736e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzba(RemoteMediaClient remoteMediaClient, MediaSeekOptions mediaSeekOptions) {
        super(remoteMediaClient, false);
        this.f6736e = remoteMediaClient;
        this.f6735d = mediaSeekOptions;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, com.google.android.gms.cast.internal.zzao {
        this.f6736e.f6530c.zzC(a(), this.f6735d);
    }
}
