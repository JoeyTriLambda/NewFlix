package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import java.util.concurrent.atomic.AtomicLong;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> connFactory) {
        super(connFactory, 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams) {
        super(new BasicConnFactory(httpParams), 2, 20);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public BasicPoolEntry createEntry(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httpHost, httpClientConnection);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    public boolean validate(BasicPoolEntry basicPoolEntry) {
        return !basicPoolEntry.getConnection().isStale();
    }

    public BasicConnPool(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        super(new BasicConnFactory(socketConfig, connectionConfig), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }
}
