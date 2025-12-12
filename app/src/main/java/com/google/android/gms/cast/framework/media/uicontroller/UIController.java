package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class UIController {
    private RemoteMediaClient zza;

    public RemoteMediaClient getRemoteMediaClient() {
        return this.zza;
    }

    public void onSessionConnected(CastSession castSession) {
        this.zza = castSession != null ? castSession.getRemoteMediaClient() : null;
    }

    public void onSessionEnded() {
        this.zza = null;
    }

    public void onMediaStatusUpdated() {
    }

    public void onSendingRemoteMediaRequest() {
    }
}
