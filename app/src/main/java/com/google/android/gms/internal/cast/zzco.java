package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzco extends UIController {
    private final TextView zza;

    public zzco(TextView textView) {
        this.zza = textView;
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        String strZze;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || (mediaInfo = remoteMediaClient.getMediaInfo()) == null || (metadata = mediaInfo.getMetadata()) == null || (strZze = com.google.android.gms.cast.framework.media.internal.zzw.zze(metadata)) == null) {
            return;
        }
        this.zza.setText(strZze);
    }
}
