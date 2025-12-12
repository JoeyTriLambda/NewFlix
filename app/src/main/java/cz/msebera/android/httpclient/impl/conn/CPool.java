package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntryCallback;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes2.dex */
class CPool extends AbstractConnPool<HttpRoute, ManagedHttpClientConnection, CPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();
    public HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit timeUnit;

    public CPool(ConnFactory<HttpRoute, ManagedHttpClientConnection> connFactory, int i10, int i11, long j10, TimeUnit timeUnit) {
        super(connFactory, i10, i11);
        this.log = new HttpClientAndroidLog(CPool.class);
        this.timeToLive = j10;
        this.timeUnit = timeUnit;
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> poolEntryCallback) {
        super.enumAvailable(poolEntryCallback);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> poolEntryCallback) {
        super.enumLeased(poolEntryCallback);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public CPoolEntry createEntry(HttpRoute httpRoute, ManagedHttpClientConnection managedHttpClientConnection) {
        return new CPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, managedHttpClientConnection, this.timeToLive, this.timeUnit);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public boolean validate(CPoolEntry cPoolEntry) {
        return !cPoolEntry.getConnection().isStale();
    }
}
