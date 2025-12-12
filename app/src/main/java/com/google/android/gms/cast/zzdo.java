package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzdo implements RemoteMediaPlayer.MediaChannelResult {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Status f7003b;

    public zzdo(Status status) {
        this.f7003b = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f7003b;
    }
}
