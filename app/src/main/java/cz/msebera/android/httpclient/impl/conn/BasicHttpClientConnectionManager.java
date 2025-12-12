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
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public class BasicHttpClientConnectionManager implements HttpClientConnectionManager, Closeable {
    private ManagedHttpClientConnection conn;
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final HttpClientConnectionOperator connectionOperator;
    private long expiry;
    private final AtomicBoolean isShutdown;
    private boolean leased;
    public HttpClientAndroidLog log;
    private HttpRoute route;
    private SocketConfig socketConfig;
    private Object state;
    private long updated;

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this(new DefaultHttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver), httpConnectionFactory);
    }

    private void checkExpiry() {
        if (this.conn == null || System.currentTimeMillis() < this.expiry) {
            return;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection expired @ " + new Date(this.expiry));
        }
        closeConnection();
    }

    private synchronized void closeConnection() {
        if (this.conn != null) {
            this.log.debug("Closing connection");
            try {
                this.conn.close();
            } catch (IOException e10) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("I/O exception closing connection", e10);
                }
            }
            this.conn = null;
        }
    }

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isShutdown.compareAndSet(false, true)) {
            closeConnection();
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public synchronized void closeExpiredConnections() {
        if (this.isShutdown.get()) {
            return;
        }
        if (!this.leased) {
            checkExpiry();
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public synchronized void closeIdleConnections(long j10, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        if (this.isShutdown.get()) {
            return;
        }
        if (!this.leased) {
            long millis = timeUnit.toMillis(j10);
            if (millis < 0) {
                millis = 0;
            }
            if (this.updated <= System.currentTimeMillis() - millis) {
                closeConnection();
            }
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i10, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        HttpHost proxyHost = httpRoute.getProxyHost() != null ? httpRoute.getProxyHost() : httpRoute.getTargetHost();
        this.connectionOperator.connect(this.conn, proxyHost, httpRoute.getLocalSocketAddress(), i10, this.socketConfig, httpContext);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public synchronized HttpClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        Asserts.check(!this.isShutdown.get(), "Connection manager has been shut down");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Get connection for route " + httpRoute);
        }
        Asserts.check(this.leased ? false : true, "Connection is still allocated");
        if (!LangUtils.equals(this.route, httpRoute) || !LangUtils.equals(this.state, obj)) {
            closeConnection();
        }
        this.route = httpRoute;
        this.state = obj;
        checkExpiry();
        if (this.conn == null) {
            this.conn = (ManagedHttpClientConnection) this.connFactory.create(httpRoute, this.connConfig);
        }
        this.conn.setSocketTimeout(this.socketConfig.getSoTimeout());
        this.leased = true;
        return this.conn;
    }

    public synchronized ConnectionConfig getConnectionConfig() {
        return this.connConfig;
    }

    public HttpRoute getRoute() {
        return this.route;
    }

    public synchronized SocketConfig getSocketConfig() {
        return this.socketConfig;
    }

    public Object getState() {
        return this.state;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public synchronized void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j10, TimeUnit timeUnit) {
        String str;
        Args.notNull(httpClientConnection, "Connection");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Releasing connection " + httpClientConnection);
        }
        if (this.isShutdown.get()) {
            return;
        }
        try {
            this.updated = System.currentTimeMillis();
            if (this.conn.isOpen()) {
                this.state = obj;
                this.conn.setSocketTimeout(0);
                if (this.log.isDebugEnabled()) {
                    if (j10 > 0) {
                        str = "for " + j10 + StringUtils.SPACE + timeUnit;
                    } else {
                        str = "indefinitely";
                    }
                    this.log.debug("Connection can be kept alive " + str);
                }
                if (j10 > 0) {
                    this.expiry = this.updated + timeUnit.toMillis(j10);
                } else {
                    this.expiry = Long.MAX_VALUE;
                }
            } else {
                this.route = null;
                this.conn = null;
                this.expiry = Long.MAX_VALUE;
            }
        } finally {
            this.leased = false;
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public final ConnectionRequest requestConnection(final HttpRoute httpRoute, final Object obj) {
        Args.notNull(httpRoute, "Route");
        return new ConnectionRequest() { // from class: cz.msebera.android.httpclient.impl.conn.BasicHttpClientConnectionManager.1
            @Override // cz.msebera.android.httpclient.concurrent.Cancellable
            public boolean cancel() {
                return false;
            }

            @Override // cz.msebera.android.httpclient.conn.ConnectionRequest
            public HttpClientConnection get(long j10, TimeUnit timeUnit) {
                return BasicHttpClientConnectionManager.this.getConnection(httpRoute, obj);
            }
        };
    }

    public synchronized void setConnectionConfig(ConnectionConfig connectionConfig) {
        if (connectionConfig != null) {
            this.connConfig = connectionConfig;
        } else {
            connectionConfig = ConnectionConfig.DEFAULT;
            this.connConfig = connectionConfig;
        }
    }

    public synchronized void setSocketConfig(SocketConfig socketConfig) {
        if (socketConfig != null) {
            this.socketConfig = socketConfig;
        } else {
            socketConfig = SocketConfig.DEFAULT;
            this.socketConfig = socketConfig;
        }
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void shutdown() {
        close();
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.upgrade(this.conn, httpRoute.getTargetHost(), httpContext);
    }

    public BasicHttpClientConnectionManager(HttpClientConnectionOperator httpClientConnectionOperator, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this.log = new HttpClientAndroidLog(getClass());
        this.connectionOperator = (HttpClientConnectionOperator) Args.notNull(httpClientConnectionOperator, "Connection operator");
        this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        this.expiry = Long.MAX_VALUE;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
        this.isShutdown = new AtomicBoolean(false);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(lookup, httpConnectionFactory, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup) {
        this(lookup, null, null, null);
    }

    public BasicHttpClientConnectionManager() {
        this(getDefaultRegistry(), null, null, null);
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
    }
}
