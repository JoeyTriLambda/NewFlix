package kf;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import zf.i;

/* loaded from: classes2.dex */
public final class a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f15088a;

    public a(b bVar) {
        this.f15088a = bVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        i.checkNotNullParameter(network, "network");
        b bVar = this.f15088a;
        bVar.f15090b.setValue(Boolean.valueOf(bVar.a()));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        i.checkNotNullParameter(network, "network");
        i.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        b bVar = this.f15088a;
        bVar.f15090b.setValue(Boolean.valueOf(bVar.a()));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        i.checkNotNullParameter(network, "network");
        b bVar = this.f15088a;
        bVar.f15090b.setValue(Boolean.valueOf(bVar.a()));
    }
}
