package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.IdleConnectionHandler;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractConnPool {
    protected volatile boolean isShutDown;
    protected Set<BasicPoolEntryRef> issuedConnections;
    protected int numConnections;
    protected ReferenceQueue<Object> refQueue;
    private final HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    protected Set<BasicPoolEntry> leasedConnections = new HashSet();
    protected IdleConnectionHandler idleConnHandler = new IdleConnectionHandler();
    protected final Lock poolLock = new ReentrantLock();

    public void closeConnection(OperatedClientConnection operatedClientConnection) {
        if (operatedClientConnection != null) {
            try {
                operatedClientConnection.close();
            } catch (IOException e10) {
                this.log.debug("I/O error closing connection", e10);
            }
        }
    }

    public void closeExpiredConnections() {
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeExpiredConnections();
        } finally {
            this.poolLock.unlock();
        }
    }

    public void closeIdleConnections(long j10, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeIdleConnections(timeUnit.toMillis(j10));
        } finally {
            this.poolLock.unlock();
        }
    }

    public abstract void deleteClosedConnections();

    public abstract void freeEntry(BasicPoolEntry basicPoolEntry, boolean z10, long j10, TimeUnit timeUnit);

    public final BasicPoolEntry getEntry(HttpRoute httpRoute, Object obj, long j10, TimeUnit timeUnit) throws ConnectionPoolTimeoutException, InterruptedException {
        return requestPoolEntry(httpRoute, obj).getPoolEntry(j10, timeUnit);
    }

    public abstract void handleLostEntry(HttpRoute httpRoute);

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj);

    public void shutdown() {
        this.poolLock.lock();
        try {
            if (this.isShutDown) {
                return;
            }
            Iterator<BasicPoolEntry> it = this.leasedConnections.iterator();
            while (it.hasNext()) {
                BasicPoolEntry next = it.next();
                it.remove();
                closeConnection(next.getConnection());
            }
            this.idleConnHandler.removeAll();
            this.isShutDown = true;
        } finally {
            this.poolLock.unlock();
        }
    }

    public void enableConnectionGC() throws IllegalStateException {
    }

    public void handleReference(Reference<?> reference) {
    }
}
