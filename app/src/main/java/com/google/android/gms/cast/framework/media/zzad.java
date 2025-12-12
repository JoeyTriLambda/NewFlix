package com.google.android.gms.cast.framework.media;

import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzad extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long[] f6720d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6721e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(RemoteMediaClient remoteMediaClient, long[] jArr) {
        super(remoteMediaClient, false);
        this.f6721e = remoteMediaClient;
        this.f6720d = jArr;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, com.google.android.gms.cast.internal.zzao {
        this.f6721e.f6530c.zzD(a(), this.f6720d);
    }
}
