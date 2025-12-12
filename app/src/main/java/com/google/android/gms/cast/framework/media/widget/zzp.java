package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzp implements RemoteMediaClient.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpandedControllerActivity f6715a;

    public /* synthetic */ zzp(ExpandedControllerActivity expandedControllerActivity) {
        this.f6715a = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onAdBreakStatusUpdated() {
        int i10 = ExpandedControllerActivity.f6650z0;
        this.f6715a.i();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onMetadataUpdated() {
        int i10 = ExpandedControllerActivity.f6650z0;
        this.f6715a.h();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onSendingRemoteMediaRequest() {
        ExpandedControllerActivity expandedControllerActivity = this.f6715a;
        expandedControllerActivity.f6655e0.setText(expandedControllerActivity.getResources().getString(R.string.cast_expanded_controller_loading));
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onStatusUpdated() {
        int i10 = ExpandedControllerActivity.f6650z0;
        ExpandedControllerActivity expandedControllerActivity = this.f6715a;
        RemoteMediaClient remoteMediaClientD = expandedControllerActivity.d();
        if (remoteMediaClientD == null || !remoteMediaClientD.hasMediaSession()) {
            if (expandedControllerActivity.f6672v0) {
                return;
            }
            expandedControllerActivity.finish();
        } else {
            expandedControllerActivity.f6672v0 = false;
            expandedControllerActivity.g();
            expandedControllerActivity.i();
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onPreloadStatusUpdated() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onQueueStatusUpdated() {
    }
}
