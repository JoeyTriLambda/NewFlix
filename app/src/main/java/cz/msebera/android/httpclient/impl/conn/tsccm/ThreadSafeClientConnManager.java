package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnectionOperator;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes2.dex */
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    protected final AbstractConnPool connectionPool;
    private final HttpClientAndroidLog log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long j10, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j10 + StringUtils.SPACE + timeUnit);
        }
        this.pool.closeIdleConnections(j10, timeUnit);
    }

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    @Deprecated
    public AbstractConnPool createConnectionPool(HttpParams httpParams) {
        return new ConnPoolByRoute(this.connOperator, httpParams);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        return this.pool.getConnectionsInPool(httpRoute);
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return this.connPerRoute.getMaxForRoute(httpRoute);
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection managedClientConnection, long j10, TimeUnit timeUnit) {
        boolean zIsMarkedReusable;
        ConnPoolByRoute connPoolByRoute;
        Args.check(managedClientConnection instanceof BasicPooledConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        BasicPooledConnAdapter basicPooledConnAdapter = (BasicPooledConnAdapter) managedClientConnection;
        if (basicPooledConnAdapter.getPoolEntry() != null) {
            Asserts.check(basicPooledConnAdapter.getManager() == this, "Connection not obtained from this manager");
        }
        synchronized (basicPooledConnAdapter) {
            BasicPoolEntry basicPoolEntry = (BasicPoolEntry) basicPooledConnAdapter.getPoolEntry();
            try {
                if (basicPoolEntry == null) {
                    return;
                }
                try {
                    if (basicPooledConnAdapter.isOpen() && !basicPooledConnAdapter.isMarkedReusable()) {
                        basicPooledConnAdapter.shutdown();
                    }
                    zIsMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                    if (this.log.isDebugEnabled()) {
                        if (zIsMarkedReusable) {
                            this.log.debug("Released connection is reusable.");
                        } else {
                            this.log.debug("Released connection is not reusable.");
                        }
                    }
                    basicPooledConnAdapter.detach();
                    connPoolByRoute = this.pool;
                } catch (IOException e10) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Exception shutting down released connection.", e10);
                    }
                    zIsMarkedReusable = basicPooledConnAdapter.isMarkedReusable();
                    if (this.log.isDebugEnabled()) {
                        if (zIsMarkedReusable) {
                            this.log.debug("Released connection is reusable.");
                        } else {
                            this.log.debug("Released connection is not reusable.");
                        }
                    }
                    basicPooledConnAdapter.detach();
                    connPoolByRoute = this.pool;
                }
                connPoolByRoute.freeEntry(basicPoolEntry, zIsMarkedReusable, j10, timeUnit);
            } catch (Throwable th2) {
                boolean zIsMarkedReusable2 = basicPooledConnAdapter.isMarkedReusable();
                if (this.log.isDebugEnabled()) {
                    if (zIsMarkedReusable2) {
                        this.log.debug("Released connection is reusable.");
                    } else {
                        this.log.debug("Released connection is not reusable.");
                    }
                }
                basicPooledConnAdapter.detach();
                this.pool.freeEntry(basicPoolEntry, zIsMarkedReusable2, j10, timeUnit);
                throw th2;
            }
        }
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(final HttpRoute httpRoute, Object obj) {
        final PoolEntryRequest poolEntryRequestRequestPoolEntry = this.pool.requestPoolEntry(httpRoute, obj);
        return new ClientConnectionRequest() { // from class: cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager.1
            @Override // cz.msebera.android.httpclient.conn.ClientConnectionRequest
            public void abortRequest() {
                poolEntryRequestRequestPoolEntry.abortRequest();
            }

            @Override // cz.msebera.android.httpclient.conn.ClientConnectionRequest
            public ManagedClientConnection getConnection(long j10, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                Args.notNull(httpRoute, "Route");
                if (ThreadSafeClientConnManager.this.log.isDebugEnabled()) {
                    ThreadSafeClientConnManager.this.log.debug("Get connection: " + httpRoute + ", timeout = " + j10);
                }
                return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, poolEntryRequestRequestPoolEntry.getPoolEntry(j10, timeUnit));
            }
        };
    }

    public void setDefaultMaxPerRoute(int i10) {
        this.connPerRoute.setDefaultMaxPerRoute(i10);
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i10) {
        this.connPerRoute.setMaxForRoute(httpRoute, i10);
    }

    public void setMaxTotal(int i10) {
        this.pool.setMaxTotalConnections(i10);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public ConnPoolByRoute createConnectionPool(long j10, TimeUnit timeUnit) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, j10, timeUnit);
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j10, TimeUnit timeUnit) {
        this(schemeRegistry, j10, timeUnit, new ConnPerRouteBean());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry, long j10, TimeUnit timeUnit, ConnPerRouteBean connPerRouteBean) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.log = new HttpClientAndroidLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = connPerRouteBean;
        this.connOperator = createConnectionOperator(schemeRegistry);
        ConnPoolByRoute connPoolByRouteCreateConnectionPool = createConnectionPool(j10, timeUnit);
        this.pool = connPoolByRouteCreateConnectionPool;
        this.connectionPool = connPoolByRouteCreateConnectionPool;
    }

    @Deprecated
    public ThreadSafeClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.log = new HttpClientAndroidLog(getClass());
        this.schemeRegistry = schemeRegistry;
        this.connPerRoute = new ConnPerRouteBean();
        this.connOperator = createConnectionOperator(schemeRegistry);
        ConnPoolByRoute connPoolByRoute = (ConnPoolByRoute) createConnectionPool(httpParams);
        this.pool = connPoolByRoute;
        this.connectionPool = connPoolByRoute;
    }
}
