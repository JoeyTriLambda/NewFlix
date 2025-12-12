package io.netas.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import he.a;

/* loaded from: classes2.dex */
public class NetworkStateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public a f13508a = null;

    public static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        return intentFilter;
    }

    public boolean b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        je.a.c("NetworkStateReceiver", "NetworkStateReceiver onReceive...", new Object[0]);
        String action = intent.getAction();
        if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE") && a(context)) {
            je.a.a("NetworkStateReceiver", "reconnect to network", new Object[0]);
            a aVar = this.f13508a;
            if (aVar != null) {
                aVar.b(b(context));
            }
        }
    }

    public void a(a aVar) {
        this.f13508a = aVar;
    }

    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    je.a.a("NetworkStateReceiver", "Network is available : %s ", networkCapabilities.toString());
                    if (networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) {
                        return true;
                    }
                }
            } else {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        if (activeNetworkInfo.isConnected()) {
                            return true;
                        }
                    }
                } catch (Exception e10) {
                    je.a.c("NetworkStateReceiver", "" + e10.getMessage(), new Object[0]);
                }
            }
        }
        je.a.a("NetworkStateReceiver", "Network is available : FALSE ", new Object[0]);
        return false;
    }
}
