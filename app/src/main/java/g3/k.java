package g3;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: NetworkApi23.kt */
/* loaded from: classes.dex */
public final class k {
    public static final Network getActiveNetworkCompat(ConnectivityManager connectivityManager) {
        zf.i.checkNotNullParameter(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
