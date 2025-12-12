package com.google.android.gms.cast.framework.media;

import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzat extends zzbk {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int[] f6727d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6728e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzat(RemoteMediaClient remoteMediaClient, int[] iArr) {
        super(remoteMediaClient, true);
        this.f6728e = remoteMediaClient;
        this.f6727d = iArr;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbk
    public final void zza() throws IllegalStateException, JSONException, IllegalArgumentException, com.google.android.gms.cast.internal.zzao {
        this.f6728e.f6530c.zzv(a(), this.f6727d);
    }
}
