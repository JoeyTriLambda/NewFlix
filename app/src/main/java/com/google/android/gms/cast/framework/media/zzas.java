package com.google.android.gms.cast.framework.media;

import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzas extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6726d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzas(RemoteMediaClient remoteMediaClient) {
        super(remoteMediaClient, true);
        this.f6726d = remoteMediaClient;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, com.google.android.gms.cast.internal.zzao {
        this.f6726d.f6530c.zzu(a());
    }
}
