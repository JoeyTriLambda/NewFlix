package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbl implements RemoteMediaClient.MediaChannelResult {

    /* renamed from: b, reason: collision with root package name */
    public final Status f6748b;

    public zzbl(Status status) {
        this.f6748b = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f6748b;
    }
}
