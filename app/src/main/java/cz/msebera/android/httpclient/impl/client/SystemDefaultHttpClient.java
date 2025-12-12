package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.conn.PoolingClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.ProxySelectorRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.ProxySelector;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes2.dex */
public class SystemDefaultHttpClient extends DefaultHttpClient {
    public SystemDefaultHttpClient(HttpParams httpParams) {
        super(null, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public ClientConnectionManager createClientConnectionManager() throws NumberFormatException {
        PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
            int i10 = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
            poolingClientConnectionManager.setDefaultMaxPerRoute(i10);
            poolingClientConnectionManager.setMaxTotal(i10 * 2);
        }
        return poolingClientConnectionManager;
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        return "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")) ? new DefaultConnectionReuseStrategy() : new NoConnectionReuseStrategy();
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }

    public SystemDefaultHttpClient() {
        super(null, null);
    }
}
