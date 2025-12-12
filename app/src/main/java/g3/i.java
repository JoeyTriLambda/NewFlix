package g3;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: NetworkApi21.kt */
/* loaded from: classes.dex */
public final class i {
    public static final NetworkCapabilities getNetworkCapabilitiesCompat(ConnectivityManager connectivityManager, Network network) {
        zf.i.checkNotNullParameter(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean hasCapabilityCompat(NetworkCapabilities networkCapabilities, int i10) {
        zf.i.checkNotNullParameter(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i10);
    }

    public static final void unregisterNetworkCallbackCompat(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        zf.i.checkNotNullParameter(connectivityManager, "<this>");
        zf.i.checkNotNullParameter(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
