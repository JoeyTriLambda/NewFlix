package d3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: NetworkStateTracker.kt */
/* loaded from: classes.dex */
public final class i extends g<b3.b> {

    /* renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f10802f;

    /* renamed from: g, reason: collision with root package name */
    public final a f10803g;

    /* compiled from: NetworkStateTracker.kt */
    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            zf.i.checkNotNullParameter(network, "network");
            zf.i.checkNotNullParameter(networkCapabilities, "capabilities");
            w2.g.get().debug(j.f10805a, "Network capabilities changed: " + networkCapabilities);
            i iVar = i.this;
            iVar.setState(j.getActiveNetworkState(iVar.f10802f));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            zf.i.checkNotNullParameter(network, "network");
            w2.g.get().debug(j.f10805a, "Network connection lost");
            i iVar = i.this;
            iVar.setState(j.getActiveNetworkState(iVar.f10802f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, i3.c cVar) {
        super(context, cVar);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        zf.i.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f10802f = (ConnectivityManager) systemService;
        this.f10803g = new a();
    }

    @Override // d3.g
    public void startTracking() {
        try {
            w2.g.get().debug(j.f10805a, "Registering network callback");
            g3.l.registerDefaultNetworkCallbackCompat(this.f10802f, this.f10803g);
        } catch (IllegalArgumentException e10) {
            w2.g.get().error(j.f10805a, "Received exception while registering network callback", e10);
        } catch (SecurityException e11) {
            w2.g.get().error(j.f10805a, "Received exception while registering network callback", e11);
        }
    }

    @Override // d3.g
    public void stopTracking() {
        try {
            w2.g.get().debug(j.f10805a, "Unregistering network callback");
            g3.i.unregisterNetworkCallbackCompat(this.f10802f, this.f10803g);
        } catch (IllegalArgumentException e10) {
            w2.g.get().error(j.f10805a, "Received exception while unregistering network callback", e10);
        } catch (SecurityException e11) {
            w2.g.get().error(j.f10805a, "Received exception while unregistering network callback", e11);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d3.g
    public b3.b getInitialState() {
        return j.getActiveNetworkState(this.f10802f);
    }
}
