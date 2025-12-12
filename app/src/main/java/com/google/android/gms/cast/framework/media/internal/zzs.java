package com.google.android.gms.cast.framework.media.internal;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzs extends MediaSessionCompat.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzv f6590a;

    public zzs(zzv zzvVar) {
        this.f6590a = zzvVar;
    }

    public final void a(long j10) {
        zzv zzvVar = this.f6590a;
        RemoteMediaClient remoteMediaClient = zzvVar.f6606n;
        if (remoteMediaClient == null) {
            return;
        }
        long jMin = Math.min(remoteMediaClient.getStreamDuration(), Math.max(0L, remoteMediaClient.getApproximateStreamPosition() + j10));
        RemoteMediaClient remoteMediaClient2 = zzvVar.f6606n;
        if (remoteMediaClient2 == null) {
            return;
        }
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(jMin);
        remoteMediaClient2.seek(builder.build());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCustomAction(java.lang.String r6, android.os.Bundle r7) {
        /*
            r5 = this;
            com.google.android.gms.cast.internal.Logger r7 = com.google.android.gms.cast.framework.media.internal.zzv.f6592v
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r6
            java.lang.String r3 = "onCustomAction with action = %s"
            r7.d(r3, r1)
            int r7 = r6.hashCode()
            r1 = 3
            r3 = 2
            switch(r7) {
                case -1699820260: goto L35;
                case -668151673: goto L2b;
                case -124479363: goto L21;
                case 1362116196: goto L17;
                default: goto L16;
            }
        L16:
            goto L3f
        L17:
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.FORWARD"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L3f
            r7 = 0
            goto L40
        L21:
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L3f
            r7 = 3
            goto L40
        L2b:
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L3f
            r7 = 2
            goto L40
        L35:
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.REWIND"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L3f
            r7 = 1
            goto L40
        L3f:
            r7 = -1
        L40:
            com.google.android.gms.cast.framework.media.internal.zzv r4 = r5.f6590a
            if (r7 == 0) goto L75
            if (r7 == r0) goto L6a
            if (r7 == r3) goto L62
            if (r7 == r1) goto L5a
            android.content.Intent r7 = new android.content.Intent
            r7.<init>(r6)
            android.content.ComponentName r6 = r4.f6599g
            r7.setComponent(r6)
            android.content.Context r6 = r4.f6593a
            r6.sendBroadcast(r7)
            return
        L5a:
            com.google.android.gms.cast.framework.SessionManager r6 = r4.f6596d
            if (r6 == 0) goto L69
            r6.endCurrentSession(r2)
            return
        L62:
            com.google.android.gms.cast.framework.SessionManager r6 = r4.f6596d
            if (r6 == 0) goto L69
            r6.endCurrentSession(r0)
        L69:
            return
        L6a:
            com.google.android.gms.cast.framework.media.NotificationOptions r6 = r4.f6597e
            long r6 = r6.getSkipStepMs()
            long r6 = -r6
            r5.a(r6)
            return
        L75:
            com.google.android.gms.cast.framework.media.NotificationOptions r6 = r4.f6597e
            long r6 = r6.getSkipStepMs()
            r5.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzs.onCustomAction(java.lang.String, android.os.Bundle):void");
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        RemoteMediaClient remoteMediaClient;
        zzv.f6592v.d("onMediaButtonEvent", new Object[0]);
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return true;
        }
        if ((keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126) || (remoteMediaClient = this.f6590a.f6606n) == null) {
            return true;
        }
        remoteMediaClient.togglePlayback();
        return true;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onPause() {
        zzv.f6592v.d("onPause", new Object[0]);
        RemoteMediaClient remoteMediaClient = this.f6590a.f6606n;
        if (remoteMediaClient != null) {
            remoteMediaClient.togglePlayback();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onPlay() {
        zzv.f6592v.d("onPlay", new Object[0]);
        RemoteMediaClient remoteMediaClient = this.f6590a.f6606n;
        if (remoteMediaClient != null) {
            remoteMediaClient.togglePlayback();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onSeekTo(long j10) {
        zzv.f6592v.d("onSeekTo %d", Long.valueOf(j10));
        RemoteMediaClient remoteMediaClient = this.f6590a.f6606n;
        if (remoteMediaClient == null) {
            return;
        }
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j10);
        remoteMediaClient.seek(builder.build());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onSkipToNext() {
        zzv.f6592v.d("onSkipToNext", new Object[0]);
        RemoteMediaClient remoteMediaClient = this.f6590a.f6606n;
        if (remoteMediaClient != null) {
            remoteMediaClient.queueNext(null);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onSkipToPrevious() {
        zzv.f6592v.d("onSkipToPrevious", new Object[0]);
        RemoteMediaClient remoteMediaClient = this.f6590a.f6606n;
        if (remoteMediaClient != null) {
            remoteMediaClient.queuePrev(null);
        }
    }
}
