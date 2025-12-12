package y1;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public final class b {
    @SuppressLint({"MissingPermission"})
    public static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, CharSequence charSequence, int i10, PendingIntent pendingIntent, Boolean bool) {
        if (bool.booleanValue()) {
            mediaStyle.setRemotePlaybackInfo(charSequence, i10, pendingIntent);
        }
        return mediaStyle;
    }
}
