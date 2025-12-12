package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes2.dex */
public interface ClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long j10, TimeUnit timeUnit);

    SchemeRegistry getSchemeRegistry();

    void releaseConnection(ManagedClientConnection managedClientConnection, long j10, TimeUnit timeUnit);

    ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj);

    void shutdown();
}
