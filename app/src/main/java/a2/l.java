package a2;

import android.os.Messenger;

/* compiled from: MediaRouteProviderProtocol.java */
/* loaded from: classes.dex */
public abstract class l {
    public static boolean isValidRemoteMessenger(Messenger messenger) {
        if (messenger == null) {
            return false;
        }
        try {
            return messenger.getBinder() != null;
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
