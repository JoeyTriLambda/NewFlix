package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.ConnPoolControl;
import cz.msebera.android.httpclient.pool.PoolStats;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.StringUtils;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes2.dex */
public class PoolingClientConnectionManager implements ClientConnectionManager, ConnPoolControl<HttpRoute> {
    private final DnsResolver dnsResolver;
    public HttpClientAndroidLog log;
    private final ClientConnectionOperator operator;
    private final HttpConnPool pool;
    private final SchemeRegistry schemeRegistry;

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
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

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long j10, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j10 + StringUtils.SPACE + timeUnit);
        }
        this.pool.closeIdle(j10, timeUnit);
    }

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry, this.dnsResolver);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    public ManagedClientConnection leaseConnection(Future<HttpPoolEntry> future, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, ConnectionPoolTimeoutException, TimeoutException {
        try {
            HttpPoolEntry httpPoolEntry = future.get(j10, timeUnit);
            if (httpPoolEntry == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(httpPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + format(httpPoolEntry) + formatStats(httpPoolEntry.getRoute()));
            }
            return new ManagedClientConnectionImpl(this, this.operator, httpPoolEntry);
        } catch (ExecutionException e10) {
            e = e10;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            this.log.error("Unexpected exception leasing connection from pool", e);
            throw new InterruptedException();
        } catch (TimeoutException unused) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[Catch: all -> 0x00d7, TryCatch #1 {, blocks: (B:8:0x001e, B:10:0x0024, B:34:0x0097, B:36:0x00a8, B:37:0x00ca, B:40:0x00cd, B:41:0x00d6, B:12:0x0026, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003f, B:22:0x0046, B:27:0x0052, B:31:0x0063, B:33:0x007a, B:26:0x0050), top: B:47:0x001e, inners: #2 }] */
    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void releaseConnection(cz.msebera.android.httpclient.conn.ManagedClientConnection r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            java.lang.String r0 = "Connection "
            java.lang.String r1 = "Connection released: "
            java.lang.String r2 = "for "
            boolean r3 = r8 instanceof cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl
            java.lang.String r4 = "Connection class mismatch, connection not obtained from this manager"
            cz.msebera.android.httpclient.util.Args.check(r3, r4)
            cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl r8 = (cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl) r8
            cz.msebera.android.httpclient.conn.ClientConnectionManager r3 = r8.getManager()
            if (r3 != r7) goto L17
            r3 = 1
            goto L18
        L17:
            r3 = 0
        L18:
            java.lang.String r4 = "Connection not obtained from this manager"
            cz.msebera.android.httpclient.util.Asserts.check(r3, r4)
            monitor-enter(r8)
            cz.msebera.android.httpclient.impl.conn.HttpPoolEntry r3 = r8.detach()     // Catch: java.lang.Throwable -> Ld7
            if (r3 != 0) goto L26
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Ld7
            return
        L26:
            boolean r4 = r8.isOpen()     // Catch: java.lang.Throwable -> Lcc
            if (r4 == 0) goto L46
            boolean r4 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Lcc
            if (r4 != 0) goto L46
            r8.shutdown()     // Catch: java.io.IOException -> L36 java.lang.Throwable -> Lcc
            goto L46
        L36:
            r4 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r5 = r7.log     // Catch: java.lang.Throwable -> Lcc
            boolean r5 = r5.isDebugEnabled()     // Catch: java.lang.Throwable -> Lcc
            if (r5 == 0) goto L46
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r5 = r7.log     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r6 = "I/O exception shutting down released connection"
            r5.debug(r6, r4)     // Catch: java.lang.Throwable -> Lcc
        L46:
            boolean r4 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Lcc
            if (r4 == 0) goto L97
            if (r11 == 0) goto L50
            r4 = r11
            goto L52
        L50:
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> Lcc
        L52:
            r3.updateExpiry(r9, r4)     // Catch: java.lang.Throwable -> Lcc
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r4 = r7.log     // Catch: java.lang.Throwable -> Lcc
            boolean r4 = r4.isDebugEnabled()     // Catch: java.lang.Throwable -> Lcc
            if (r4 == 0) goto L97
            r4 = 0
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 <= 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc
            r4.<init>(r2)     // Catch: java.lang.Throwable -> Lcc
            r4.append(r9)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r9 = " "
            r4.append(r9)     // Catch: java.lang.Throwable -> Lcc
            r4.append(r11)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Throwable -> Lcc
            goto L7a
        L78:
            java.lang.String r9 = "indefinitely"
        L7a:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r10 = r7.log     // Catch: java.lang.Throwable -> Lcc
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc
            r11.<init>(r0)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = r7.format(r3)     // Catch: java.lang.Throwable -> Lcc
            r11.append(r0)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = " can be kept alive "
            r11.append(r0)     // Catch: java.lang.Throwable -> Lcc
            r11.append(r9)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r9 = r11.toString()     // Catch: java.lang.Throwable -> Lcc
            r10.debug(r9)     // Catch: java.lang.Throwable -> Lcc
        L97:
            cz.msebera.android.httpclient.impl.conn.HttpConnPool r9 = r7.pool     // Catch: java.lang.Throwable -> Ld7
            boolean r10 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Ld7
            r9.release(r3, r10)     // Catch: java.lang.Throwable -> Ld7
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Ld7
            boolean r9 = r9.isDebugEnabled()     // Catch: java.lang.Throwable -> Ld7
            if (r9 == 0) goto Lca
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r9 = r7.log     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r10.<init>(r1)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r11 = r7.format(r3)     // Catch: java.lang.Throwable -> Ld7
            r10.append(r11)     // Catch: java.lang.Throwable -> Ld7
            java.lang.Object r11 = r3.getRoute()     // Catch: java.lang.Throwable -> Ld7
            cz.msebera.android.httpclient.conn.routing.HttpRoute r11 = (cz.msebera.android.httpclient.conn.routing.HttpRoute) r11     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r11 = r7.formatStats(r11)     // Catch: java.lang.Throwable -> Ld7
            r10.append(r11)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Ld7
            r9.debug(r10)     // Catch: java.lang.Throwable -> Ld7
        Lca:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Ld7
            return
        Lcc:
            r9 = move-exception
            cz.msebera.android.httpclient.impl.conn.HttpConnPool r10 = r7.pool     // Catch: java.lang.Throwable -> Ld7
            boolean r11 = r8.isMarkedReusable()     // Catch: java.lang.Throwable -> Ld7
            r10.release(r3, r11)     // Catch: java.lang.Throwable -> Ld7
            throw r9     // Catch: java.lang.Throwable -> Ld7
        Ld7:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Ld7
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.conn.PoolingClientConnectionManager.releaseConnection(cz.msebera.android.httpclient.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        final Future<HttpPoolEntry> futureLease = this.pool.lease(httpRoute, obj);
        return new ClientConnectionRequest() { // from class: cz.msebera.android.httpclient.impl.conn.PoolingClientConnectionManager.1
            @Override // cz.msebera.android.httpclient.conn.ClientConnectionRequest
            public void abortRequest() {
                futureLease.cancel(true);
            }

            @Override // cz.msebera.android.httpclient.conn.ClientConnectionRequest
            public ManagedClientConnection getConnection(long j10, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                return PoolingClientConnectionManager.this.leaseConnection(futureLease, j10, timeUnit);
            }
        };
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i10) {
        this.pool.setDefaultMaxPerRoute(i10);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxTotal(int i10) {
        this.pool.setMaxTotal(i10);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        this.log.debug("Connection manager is shutting down");
        try {
            this.pool.shutdown();
        } catch (IOException e10) {
            this.log.debug("I/O exception shutting down connection manager", e10);
        }
        this.log.debug("Connection manager shut down");
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS, dnsResolver);
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

    public PoolingClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j10, TimeUnit timeUnit) {
        this(schemeRegistry, j10, timeUnit, new SystemDefaultDnsResolver());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j10, TimeUnit timeUnit, DnsResolver dnsResolver) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
        ClientConnectionOperator clientConnectionOperatorCreateConnectionOperator = createConnectionOperator(schemeRegistry);
        this.operator = clientConnectionOperatorCreateConnectionOperator;
        this.pool = new HttpConnPool(this.log, clientConnectionOperatorCreateConnectionOperator, 2, 20, j10, timeUnit);
    }

    private String format(HttpPoolEntry httpPoolEntry) {
        StringBuilder sb2 = new StringBuilder("[id: ");
        sb2.append(httpPoolEntry.getId());
        sb2.append("][route: ");
        sb2.append(httpPoolEntry.getRoute());
        sb2.append("]");
        Object state = httpPoolEntry.getState();
        if (state != null) {
            sb2.append("[state: ");
            sb2.append(state);
            sb2.append("]");
        }
        return sb2.toString();
    }
}
