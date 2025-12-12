package org.adblockplus.libadblockplus.android;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import bi.a;
import org.adblockplus.libadblockplus.IsAllowedConnectionCallback;

/* loaded from: classes2.dex */
public class IsAllowedConnectionCallbackImpl implements IsAllowedConnectionCallback {
    private ConnectivityManager manager;

    public IsAllowedConnectionCallbackImpl(ConnectivityManager connectivityManager) {
        this.manager = connectivityManager;
    }

    @Override // org.adblockplus.libadblockplus.IsAllowedConnectionCallback
    public boolean isConnectionAllowed(String str) {
        a.d("Checking connection: %s", str);
        if (str == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = this.manager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        ConnectionType connectionTypeFindByValue = ConnectionType.findByValue(str);
        if (connectionTypeFindByValue == null) {
            a.e("Unknown connection type: %s", str);
            return false;
        }
        if (connectionTypeFindByValue.isRequiredConnection(this.manager)) {
            return true;
        }
        a.w("Current connection type is not allowed for web requests", new Object[0]);
        return false;
    }
}
