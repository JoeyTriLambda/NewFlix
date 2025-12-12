package x1;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: MediaSessionManager.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final e f21374a;

    public b(String str, int i10, int i11) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f21374a = new d(str, i10, i11);
        } else {
            this.f21374a = new e(str, i10, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f21374a.equals(((b) obj).f21374a);
    }

    public int hashCode() {
        return this.f21374a.hashCode();
    }

    public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String packageName = remoteUserInfo.getPackageName();
        if (packageName != null) {
            if (!TextUtils.isEmpty(packageName)) {
                this.f21374a = new d(remoteUserInfo);
                return;
            }
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        throw new NullPointerException("package shouldn't be null");
    }
}
