package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzcu extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzb;

    public zzcu(TextView textView, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = textView;
        this.zzb = zzaVar;
        textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
    public final void onProgressUpdated(long j10, long j11) {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, 1000L);
        }
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            TextView textView = this.zza;
            textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
        } else {
            if (remoteMediaClient.isLiveStream() && this.zzb.zzi() == null) {
                this.zza.setVisibility(8);
                return;
            }
            this.zza.setVisibility(0);
            TextView textView2 = this.zza;
            com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar = this.zzb;
            textView2.setText(zzaVar.zzl(zzaVar.zze() + zzaVar.zzb()));
        }
    }
}
