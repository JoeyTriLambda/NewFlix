package com.google.android.gms.cast.framework.media.internal;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzu extends RemoteMediaClient.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzv f6591a;

    public /* synthetic */ zzu(zzv zzvVar) {
        this.f6591a = zzvVar;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onAdBreakStatusUpdated() throws IllegalArgumentException {
        this.f6591a.zzl(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onMetadataUpdated() throws IllegalArgumentException {
        this.f6591a.zzl(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onPreloadStatusUpdated() throws IllegalArgumentException {
        this.f6591a.zzl(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onQueueStatusUpdated() throws IllegalArgumentException {
        this.f6591a.zzl(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onStatusUpdated() throws IllegalArgumentException {
        this.f6591a.zzl(false);
    }
}
