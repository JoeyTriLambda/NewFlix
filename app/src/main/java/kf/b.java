package kf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import ng.g;
import ng.l;
import zf.i;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f15089a;

    /* renamed from: b, reason: collision with root package name */
    public g f15090b;

    /* renamed from: c, reason: collision with root package name */
    public final a f15091c;

    public b(Context context) {
        i.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        this.f15089a = (ConnectivityManager) systemService;
        this.f15090b = l.MutableStateFlow(Boolean.FALSE);
        this.f15091c = new a(this);
    }

    public final boolean a() {
        int i10 = Build.VERSION.SDK_INT;
        ConnectivityManager connectivityManager = this.f15089a;
        if (i10 >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasTransport(1);
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            Integer numValueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        this.f15090b = l.MutableStateFlow(Boolean.valueOf(a()));
        this.f15089a.registerNetworkCallback(new NetworkRequest.Builder().build(), this.f15091c);
    }

    public final void c() {
        this.f15089a.unregisterNetworkCallback(this.f15091c);
    }
}
