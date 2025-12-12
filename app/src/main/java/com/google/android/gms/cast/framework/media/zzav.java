package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaLoadRequestData;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzav extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaLoadRequestData f6729d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6730e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzav(RemoteMediaClient remoteMediaClient, MediaLoadRequestData mediaLoadRequestData) {
        super(remoteMediaClient, false);
        this.f6730e = remoteMediaClient;
        this.f6729d = mediaLoadRequestData;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, IllegalArgumentException, com.google.android.gms.cast.internal.zzao {
        this.f6730e.f6530c.zzp(a(), this.f6729d);
    }
}
