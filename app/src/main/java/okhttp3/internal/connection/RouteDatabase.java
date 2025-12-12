package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;
import zf.i;

/* compiled from: RouteDatabase.kt */
/* loaded from: classes2.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        i.checkNotNullParameter(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        i.checkNotNullParameter(route, "failedRoute");
        this.failedRoutes.add(route);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        i.checkNotNullParameter(route, "route");
        return this.failedRoutes.contains(route);
    }
}
