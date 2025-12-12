package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes2.dex */
class CPoolEntry extends PoolEntry<HttpRoute, ManagedHttpClientConnection> {
    private final HttpClientAndroidLog log;
    private volatile boolean routeComplete;

    public CPoolEntry(HttpClientAndroidLog httpClientAndroidLog, String str, HttpRoute httpRoute, ManagedHttpClientConnection managedHttpClientConnection, long j10, TimeUnit timeUnit) {
        super(str, httpRoute, managedHttpClientConnection, j10, timeUnit);
        this.log = httpClientAndroidLog;
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public void close() {
        try {
            closeConnection();
        } catch (IOException e10) {
            this.log.debug("I/O error closing connection", e10);
        }
    }

    public void closeConnection() throws IOException {
        getConnection().close();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isExpired(long j10) {
        boolean zIsExpired = super.isExpired(j10);
        if (zIsExpired && this.log.isDebugEnabled()) {
            this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
        }
        return zIsExpired;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public void shutdownConnection() throws IOException {
        getConnection().shutdown();
    }
}
