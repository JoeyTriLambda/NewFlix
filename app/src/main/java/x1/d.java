package x1;

import android.media.session.MediaSessionManager;

/* compiled from: MediaSessionManagerImplApi28.java */
/* loaded from: classes.dex */
public final class d extends e {
    public d(String str, int i10, int i11) {
        super(str, i10, i11);
        new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    public d(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
    }
}
