package com.google.android.gms.cast.framework.media;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzan extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f6724d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6725e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzan(RemoteMediaClient remoteMediaClient, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.f6725e = remoteMediaClient;
        this.f6724d = jSONObject;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, IllegalArgumentException, com.google.android.gms.cast.internal.zzao {
        this.f6725e.f6530c.zzA(a(), 0, -1L, null, 1, null, null, this.f6724d);
    }
}
