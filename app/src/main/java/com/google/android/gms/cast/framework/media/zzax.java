package com.google.android.gms.cast.framework.media;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzax extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f6731d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6732e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(RemoteMediaClient remoteMediaClient, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.f6732e = remoteMediaClient;
        this.f6731d = jSONObject;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, com.google.android.gms.cast.internal.zzao {
        this.f6732e.f6530c.zzq(a(), this.f6731d);
    }
}
