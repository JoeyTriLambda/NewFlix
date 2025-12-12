package d3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

/* compiled from: NetworkStateTracker.kt */
/* loaded from: classes.dex */
public final class k extends e<b3.b> {

    /* renamed from: g, reason: collision with root package name */
    public final ConnectivityManager f10806g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, i3.c cVar) {
        super(context, cVar);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        zf.i.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f10806g = (ConnectivityManager) systemService;
    }

    @Override // d3.e
    public IntentFilter getIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // d3.e
    public void onBroadcastReceive(Intent intent) {
        zf.i.checkNotNullParameter(intent, "intent");
        if (zf.i.areEqual(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            w2.g.get().debug(j.f10805a, "Network broadcast received");
            setState(j.getActiveNetworkState(this.f10806g));
        }
    }

    @Override // d3.g
    public b3.b getInitialState() {
        return j.getActiveNetworkState(this.f10806g);
    }
}
