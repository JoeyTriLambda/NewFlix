package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.Registry;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.HttpClientConnectionOperator;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.PlainConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.ConnPoolControl;
import cz.msebera.android.httpclient.pool.PoolEntryCallback;
import cz.msebera.android.httpclient.pool.PoolStats;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public class PoolingHttpClientConnectionManager implements HttpClientConnectionManager, ConnPoolControl<HttpRoute>, Closeable {
    private final ConfigData configData;
    private final HttpClientConnectionOperator connectionOperator;
    private final AtomicBoolean isShutDown;
    public HttpClientAndroidLog log;
    private final CPool pool;

    public static class ConfigData {
        private volatile ConnectionConfig defaultConnectionConfig;
        private volatile SocketConfig defaultSocketConfig;
        private final Map<HttpHost, SocketConfig> socketConfigMap = new ConcurrentHashMap();
        private final Map<HttpHost, ConnectionConfig> connectionConfigMap = new ConcurrentHashMap();

        public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
            return this.connectionConfigMap.get(httpHost);
        }

        public ConnectionConfig getDefaultConnectionConfig() {
            return this.defaultConnectionConfig;
        }

        public SocketConfig getDefaultSocketConfig() {
            return this.defaultSocketConfig;
        }

        public SocketConfig getSocketConfig(HttpHost httpHost) {
            return this.socketConfigMap.get(httpHost);
        }

        public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
            this.connectionConfigMap.put(httpHost, connectionConfig);
        }

        public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
            this.defaultConnectionConfig = connectionConfig;
        }

        public void setDefaultSocketConfig(SocketConfig socketConfig) {
            this.defaultSocketConfig = socketConfig;
        }

        public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
            this.socketConfigMap.put(httpHost, socketConfig);
        }
    }

    public static class InternalConnectionFactory implements ConnFactory<HttpRoute, ManagedHttpClientConnection> {
        private final ConfigData configData;
        private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;

        public InternalConnectionFactory(ConfigData configData, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
            this.configData = configData == null ? new ConfigData() : configData;
            this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        }

        @Override // cz.msebera.android.httpclient.pool.ConnFactory
        public ManagedHttpClientConnection create(HttpRoute httpRoute) throws IOException {
            ConnectionConfig connectionConfig = httpRoute.getProxyHost() != null ? this.configData.getConnectionConfig(httpRoute.getProxyHost()) : null;
            if (connectionConfig == null) {
                connectionConfig = this.configData.getConnectionConfig(httpRoute.getTargetHost());
            }
            if (connectionConfig == null) {
                connectionConfig = this.configData.getDefaultConnectionConfig();
            }
            if (connectionConfig == null) {
                connectionConfig = ConnectionConfig.DEFAULT;
            }
            return (ManagedHttpClientConnection) this.connFactory.create(httpRoute, connectionConfig);
        }
    }

    public PoolingHttpClientConnectionManager() {
        this(getDefaultRegistry());
    }

    private String format(HttpRoute httpRoute, Object obj) {
        StringBuilder sb2 = new StringBuilder("[route: ");
        sb2.append(httpRoute);
        sb2.append("]");
        if (obj != null) {
            sb2.append("[state: ");
            sb2.append(obj);
            sb2.append("]");
        }
        return sb2.toString();
    }

    private String formatStats(HttpRoute httpRoute) {
        StringBuilder sb2 = new StringBuilder("[total kept alive: ");
        PoolStats totalStats = this.pool.getTotalStats();
        PoolStats stats = this.pool.getStats(httpRoute);
        sb2.append(totalStats.getAvailable());
        sb2.append("; route allocated: ");
        sb2.append(stats.getAvailable() + stats.getLeased());
        sb2.append(" of ");
        sb2.append(stats.getMax());
        sb2.append("; total allocated: ");
        sb2.append(totalStats.getAvailable() + totalStats.getLeased());
        sb2.append(" of ");
        sb2.append(totalStats.getMax());
        sb2.append("]");
        return sb2.toString();
    }

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SocketConfig resolveSocketConfig(HttpHost httpHost) {
        SocketConfig socketConfig = this.configData.getSocketConfig(httpHost);
        if (socketConfig == null) {
            socketConfig = this.configData.getDefaultSocketConfig();
        }
        return socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown();
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void closeIdleConnections(long j10, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j10 + StringUtils.SPACE + timeUnit);
        }
        this.pool.closeIdle(j10, timeUnit);
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i10, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection connection;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            connection = CPoolProxy.getPoolEntry(httpClientConnection).getConnection();
        }
        HttpHost proxyHost = httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost();
        this.connectionOperator.connect(connection, proxyHost, httpRoute.getLocalSocketAddress(), i10, resolveSocketConfig(proxyHost), httpContext);
    }

    public void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> poolEntryCallback) {
        this.pool.enumAvailable(poolEntryCallback);
    }

    public void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> poolEntryCallback) {
        this.pool.enumLeased(poolEntryCallback);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
        return this.configData.getConnectionConfig(httpHost);
    }

    public ConnectionConfig getDefaultConnectionConfig() {
        return this.configData.getDefaultConnectionConfig();
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    public SocketConfig getDefaultSocketConfig() {
        return this.configData.getDefaultSocketConfig();
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    public Set<HttpRoute> getRoutes() {
        return this.pool.getRoutes();
    }

    public SocketConfig getSocketConfig(HttpHost httpHost) {
        return this.configData.getSocketConfig(httpHost);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    public int getValidateAfterInactivity() {
        return this.pool.getValidateAfterInactivity();
    }

    public HttpClientConnection leaseConnection(Future<CPoolEntry> future, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, ConnectionPoolTimeoutException, TimeoutException {
        try {
            CPoolEntry cPoolEntry = future.get(j10, timeUnit);
            if (cPoolEntry == null || future.isCancelled()) {
                throw new ExecutionException(new CancellationException("Operation cancelled"));
            }
            Asserts.check(cPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + format(cPoolEntry) + formatStats(cPoolEntry.getRoute()));
            }
            return CPoolProxy.newProxy(cPoolEntry);
        } catch (TimeoutException unused) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j10, TimeUnit timeUnit) {
        String str;
        Args.notNull(httpClientConnection, "Managed connection");
        synchronized (httpClientConnection) {
            CPoolEntry cPoolEntryDetach = CPoolProxy.detach(httpClientConnection);
            if (cPoolEntryDetach == null) {
                return;
            }
            ManagedHttpClientConnection connection = cPoolEntryDetach.getConnection();
            boolean z10 = true;
            try {
                if (connection.isOpen()) {
                    if (timeUnit == null) {
                        timeUnit = TimeUnit.MILLISECONDS;
                    }
                    cPoolEntryDetach.setState(obj);
                    cPoolEntryDetach.updateExpiry(j10, timeUnit);
                    if (this.log.isDebugEnabled()) {
                        if (j10 > 0) {
                            str = "for " + (timeUnit.toMillis(j10) / 1000.0d) + " seconds";
                        } else {
                            str = "indefinitely";
                        }
                        this.log.debug("Connection " + format(cPoolEntryDetach) + " can be kept alive " + str);
                    }
                    connection.setSocketTimeout(0);
                }
                CPool cPool = this.pool;
                if (!connection.isOpen() || !cPoolEntryDetach.isRouteComplete()) {
                    z10 = false;
                }
                cPool.release((CPool) cPoolEntryDetach, z10);
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Connection released: " + format(cPoolEntryDetach) + formatStats(cPoolEntryDetach.getRoute()));
                }
            } catch (Throwable th2) {
                CPool cPool2 = this.pool;
                if (!connection.isOpen() || !cPoolEntryDetach.isRouteComplete()) {
                    z10 = false;
                }
                cPool2.release((CPool) cPoolEntryDetach, z10);
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Connection released: " + format(cPoolEntryDetach) + formatStats(cPoolEntryDetach.getRoute()));
                }
                throw th2;
            }
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public ConnectionRequest requestConnection(final HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        final Future<CPoolEntry> futureLease = this.pool.lease(httpRoute, obj, null);
        return new ConnectionRequest() { // from class: cz.msebera.android.httpclient.impl.conn.PoolingHttpClientConnectionManager.1
            @Override // cz.msebera.android.httpclient.concurrent.Cancellable
            public boolean cancel() {
                return futureLease.cancel(true);
            }

            @Override // cz.msebera.android.httpclient.conn.ConnectionRequest
            public HttpClientConnection get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, ConnectionPoolTimeoutException, TimeoutException {
                HttpClientConnection httpClientConnectionLeaseConnection = PoolingHttpClientConnectionManager.this.leaseConnection(futureLease, j10, timeUnit);
                if (httpClientConnectionLeaseConnection.isOpen()) {
                    httpClientConnectionLeaseConnection.setSocketTimeout(PoolingHttpClientConnectionManager.this.resolveSocketConfig(httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost()).getSoTimeout());
                }
                return httpClientConnectionLeaseConnection;
            }
        };
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            CPoolProxy.getPoolEntry(httpClientConnection).markRouteComplete();
        }
    }

    public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
        this.configData.setConnectionConfig(httpHost, connectionConfig);
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.configData.setDefaultConnectionConfig(connectionConfig);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i10) {
        this.pool.setDefaultMaxPerRoute(i10);
    }

    public void setDefaultSocketConfig(SocketConfig socketConfig) {
        this.configData.setDefaultSocketConfig(socketConfig);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxTotal(int i10) {
        this.pool.setMaxTotal(i10);
    }

    public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
        this.configData.setSocketConfig(httpHost, socketConfig);
    }

    public void setValidateAfterInactivity(int i10) {
        this.pool.setValidateAfterInactivity(i10);
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void shutdown() {
        if (this.isShutDown.compareAndSet(false, true)) {
            this.log.debug("Connection manager is shutting down");
            try {
                this.pool.shutdown();
            } catch (IOException e10) {
                this.log.debug("I/O exception shutting down connection manager", e10);
            }
            this.log.debug("Connection manager shut down");
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection connection;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            connection = CPoolProxy.getPoolEntry(httpClientConnection).getConnection();
        }
        this.connectionOperator.upgrade(connection, httpRoute.getTargetHost(), httpContext);
    }

    public PoolingHttpClientConnectionManager(long j10, TimeUnit timeUnit) {
        this(getDefaultRegistry(), null, null, null, j10, timeUnit);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxPerRoute(HttpRoute httpRoute) {
        return this.pool.getMaxPerRoute(httpRoute);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getStats(HttpRoute httpRoute) {
        return this.pool.getStats(httpRoute);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxPerRoute(HttpRoute httpRoute, int i10) {
        this.pool.setMaxPerRoute(httpRoute, i10);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry) {
        this(registry, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, DnsResolver dnsResolver) {
        this(registry, null, dnsResolver);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(registry, httpConnectionFactory, null);
    }

    private String format(CPoolEntry cPoolEntry) {
        StringBuilder sb2 = new StringBuilder("[id: ");
        sb2.append(cPoolEntry.getId());
        sb2.append("][route: ");
        sb2.append(cPoolEntry.getRoute());
        sb2.append("]");
        Object state = cPoolEntry.getState();
        if (state != null) {
            sb2.append("[state: ");
            sb2.append(state);
            sb2.append("]");
        }
        return sb2.toString();
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(getDefaultRegistry(), httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, DnsResolver dnsResolver) {
        this(registry, httpConnectionFactory, null, dnsResolver, -1L, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver, long j10, TimeUnit timeUnit) {
        this(new DefaultHttpClientConnectionOperator(registry, schemePortResolver, dnsResolver), httpConnectionFactory, j10, timeUnit);
    }

    public PoolingHttpClientConnectionManager(HttpClientConnectionOperator httpClientConnectionOperator, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, long j10, TimeUnit timeUnit) {
        this.log = new HttpClientAndroidLog(getClass());
        ConfigData configData = new ConfigData();
        this.configData = configData;
        CPool cPool = new CPool(new InternalConnectionFactory(configData, httpConnectionFactory), 2, 20, j10, timeUnit);
        this.pool = cPool;
        cPool.setValidateAfterInactivity(2000);
        this.connectionOperator = (HttpClientConnectionOperator) Args.notNull(httpClientConnectionOperator, "HttpClientConnectionOperator");
        this.isShutDown = new AtomicBoolean(false);
    }

    public PoolingHttpClientConnectionManager(CPool cPool, Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.log = new HttpClientAndroidLog(getClass());
        this.configData = new ConfigData();
        this.pool = cPool;
        this.connectionOperator = new DefaultHttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
        this.isShutDown = new AtomicBoolean(false);
    }
}
