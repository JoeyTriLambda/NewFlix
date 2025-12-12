package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes2.dex */
public class BasicPoolEntry extends AbstractPoolEntry {
    private final long created;
    private long expiry;
    private long updated;
    private final long validUntil;

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, ReferenceQueue<Object> referenceQueue) {
        super(clientConnectionOperator, httpRoute);
        Args.notNull(httpRoute, "HTTP route");
        this.created = System.currentTimeMillis();
        this.validUntil = Long.MAX_VALUE;
        this.expiry = Long.MAX_VALUE;
    }

    public final OperatedClientConnection getConnection() {
        return this.connection;
    }

    public long getCreated() {
        return this.created;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public final HttpRoute getPlannedRoute() {
        return this.route;
    }

    public long getUpdated() {
        return this.updated;
    }

    public long getValidUntil() {
        return this.validUntil;
    }

    public final BasicPoolEntryRef getWeakRef() {
        return null;
    }

    public boolean isExpired(long j10) {
        return j10 >= this.expiry;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry
    public void shutdownEntry() {
        super.shutdownEntry();
    }

    public void updateExpiry(long j10, TimeUnit timeUnit) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.updated = jCurrentTimeMillis;
        this.expiry = Math.min(this.validUntil, j10 > 0 ? timeUnit.toMillis(j10) + jCurrentTimeMillis : Long.MAX_VALUE);
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute) {
        this(clientConnectionOperator, httpRoute, -1L, TimeUnit.MILLISECONDS);
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, long j10, TimeUnit timeUnit) {
        super(clientConnectionOperator, httpRoute);
        Args.notNull(httpRoute, "HTTP route");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.created = jCurrentTimeMillis;
        if (j10 > 0) {
            this.validUntil = timeUnit.toMillis(j10) + jCurrentTimeMillis;
        } else {
            this.validUntil = Long.MAX_VALUE;
        }
        this.expiry = this.validUntil;
    }
}
