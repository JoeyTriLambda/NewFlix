package com.google.android.gms.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzar extends BroadcastReceiver {
    private zzar() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT".equals(intent.getAction())) {
            CastRemoteDisplayLocalService.stopService();
        } else if ("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED".equals(intent.getAction())) {
            CastRemoteDisplayLocalService.b();
        }
    }
}
