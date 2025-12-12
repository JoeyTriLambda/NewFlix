package d3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* compiled from: NetworkStateTracker.kt */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10805a;

    static {
        String strTagWithPrefix = w2.g.tagWithPrefix("NetworkStateTracker");
        zf.i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"NetworkStateTracker\")");
        f10805a = strTagWithPrefix;
    }

    public static final g<b3.b> NetworkStateTracker(Context context, i3.c cVar) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
        return Build.VERSION.SDK_INT >= 24 ? new i(context, cVar) : new k(context, cVar);
    }

    public static final b3.b getActiveNetworkState(ConnectivityManager connectivityManager) {
        zf.i.checkNotNullParameter(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return new b3.b(activeNetworkInfo != null && activeNetworkInfo.isConnected(), isActiveNetworkValidated(connectivityManager), s0.a.isActiveNetworkMetered(connectivityManager), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }

    public static final boolean isActiveNetworkValidated(ConnectivityManager connectivityManager) {
        zf.i.checkNotNullParameter(connectivityManager, "<this>");
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilitiesCompat = g3.i.getNetworkCapabilitiesCompat(connectivityManager, g3.k.getActiveNetworkCompat(connectivityManager));
            if (networkCapabilitiesCompat != null) {
                return g3.i.hasCapabilityCompat(networkCapabilitiesCompat, 16);
            }
            return false;
        } catch (SecurityException e10) {
            w2.g.get().error(f10805a, "Unable to validate active network", e10);
            return false;
        }
    }
}
