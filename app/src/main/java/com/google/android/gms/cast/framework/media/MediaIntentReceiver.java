package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@Keep
/* loaded from: classes.dex */
public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";
    private static final String TAG = "MediaIntentReceiver";
    private static final Logger log = new Logger(TAG);

    private static RemoteMediaClient getRemoteMediaClient(CastSession castSession) {
        if (castSession == null || !castSession.isConnected()) {
            return null;
        }
        return castSession.getRemoteMediaClient();
    }

    private void seek(CastSession castSession, long j10) {
        RemoteMediaClient remoteMediaClient;
        if (j10 == 0 || (remoteMediaClient = getRemoteMediaClient(castSession)) == null || remoteMediaClient.isLiveStream() || remoteMediaClient.isPlayingAd()) {
            return;
        }
        remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j10);
    }

    private void togglePlayback(CastSession castSession) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient(castSession);
        if (remoteMediaClient == null) {
            return;
        }
        remoteMediaClient.togglePlayback();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r0 = r11.getAction()
            com.google.android.gms.cast.internal.Logger r1 = com.google.android.gms.cast.framework.media.MediaIntentReceiver.log
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r0
            java.lang.String r5 = "onReceive action: %s"
            r1.d(r5, r3)
            if (r0 != 0) goto L15
            goto Lae
        L15:
            com.google.android.gms.cast.framework.CastContext r1 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r10)
            com.google.android.gms.cast.framework.SessionManager r1 = r1.getSessionManager()
            com.google.android.gms.cast.framework.Session r3 = r1.getCurrentSession()
            if (r3 == 0) goto Lae
            int r5 = r0.hashCode()
            switch(r5) {
                case -1699820260: goto L71;
                case -945151566: goto L67;
                case -945080078: goto L5d;
                case -668151673: goto L53;
                case -124479363: goto L49;
                case 235550565: goto L3f;
                case 1362116196: goto L35;
                case 1997055314: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L7b
        L2b:
            java.lang.String r5 = "android.intent.action.MEDIA_BUTTON"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 7
            goto L7c
        L35:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.FORWARD"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 3
            goto L7c
        L3f:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 0
            goto L7c
        L49:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 6
            goto L7c
        L53:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 5
            goto L7c
        L5d:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 2
            goto L7c
        L67:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 1
            goto L7c
        L71:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.REWIND"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7b
            r5 = 4
            goto L7c
        L7b:
            r5 = -1
        L7c:
            r6 = 0
            java.lang.String r8 = "googlecast-extra_skip_step_ms"
            switch(r5) {
                case 0: goto Lab;
                case 1: goto La7;
                case 2: goto La3;
                case 3: goto L9b;
                case 4: goto L93;
                case 5: goto L8f;
                case 6: goto L8b;
                case 7: goto L87;
                default: goto L83;
            }
        L83:
            r9.onReceiveOtherAction(r10, r0, r11)
            return
        L87:
            r9.onReceiveActionMediaButton(r3, r11)
            return
        L8b:
            r1.endCurrentSession(r4)
            return
        L8f:
            r1.endCurrentSession(r2)
            return
        L93:
            long r10 = r11.getLongExtra(r8, r6)
            r9.onReceiveActionRewind(r3, r10)
            return
        L9b:
            long r10 = r11.getLongExtra(r8, r6)
            r9.onReceiveActionForward(r3, r10)
            return
        La3:
            r9.onReceiveActionSkipPrev(r3)
            return
        La7:
            r9.onReceiveActionSkipNext(r3)
            return
        Lab:
            r9.onReceiveActionTogglePlayback(r3)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.MediaIntentReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    public void onReceiveActionForward(Session session, long j10) {
        if (session instanceof CastSession) {
            seek((CastSession) session, j10);
        }
    }

    public void onReceiveActionMediaButton(Session session, Intent intent) {
        KeyEvent keyEvent;
        if ((session instanceof CastSession) && intent.hasExtra("android.intent.extra.KEY_EVENT") && (keyEvent = (KeyEvent) ((Bundle) Preconditions.checkNotNull(intent.getExtras())).get("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
            togglePlayback((CastSession) session);
        }
    }

    public void onReceiveActionRewind(Session session, long j10) {
        if (session instanceof CastSession) {
            seek((CastSession) session, -j10);
        }
    }

    public void onReceiveActionSkipNext(Session session) {
        RemoteMediaClient remoteMediaClient;
        if (!(session instanceof CastSession) || (remoteMediaClient = getRemoteMediaClient((CastSession) session)) == null || remoteMediaClient.isPlayingAd()) {
            return;
        }
        remoteMediaClient.queueNext(null);
    }

    public void onReceiveActionSkipPrev(Session session) {
        RemoteMediaClient remoteMediaClient;
        if (!(session instanceof CastSession) || (remoteMediaClient = getRemoteMediaClient((CastSession) session)) == null || remoteMediaClient.isPlayingAd()) {
            return;
        }
        remoteMediaClient.queuePrev(null);
    }

    public void onReceiveActionTogglePlayback(Session session) {
        if (session instanceof CastSession) {
            togglePlayback((CastSession) session);
        }
    }

    public void onReceiveOtherAction(Context context, String str, Intent intent) {
    }

    @Deprecated
    public void onReceiveOtherAction(String str, Intent intent) {
        onReceiveOtherAction(null, str, intent);
    }
}
