package g3;

import android.net.ConnectivityManager;

/* compiled from: NetworkApi24.kt */
/* loaded from: classes.dex */
public final class l {
    public static final void registerDefaultNetworkCallbackCompat(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        zf.i.checkNotNullParameter(connectivityManager, "<this>");
        zf.i.checkNotNullParameter(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
