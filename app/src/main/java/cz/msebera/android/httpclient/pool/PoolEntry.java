package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;
    private long expiry;

    /* renamed from: id, reason: collision with root package name */
    private final String f10722id;
    private final T route;
    private volatile Object state;
    private long updated;
    private final long validityDeadline;

    public PoolEntry(String str, T t10, C c10, long j10, TimeUnit timeUnit) {
        Args.notNull(t10, "Route");
        Args.notNull(c10, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.f10722id = str;
        this.route = t10;
        this.conn = c10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.created = jCurrentTimeMillis;
        this.updated = jCurrentTimeMillis;
        if (j10 > 0) {
            long millis = timeUnit.toMillis(j10) + jCurrentTimeMillis;
            this.validityDeadline = millis > 0 ? millis : Long.MAX_VALUE;
        } else {
            this.validityDeadline = Long.MAX_VALUE;
        }
        this.expiry = this.validityDeadline;
    }

    public abstract void close();

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public String getId() {
        return this.f10722id;
    }

    public T getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long j10) {
        return j10 >= this.expiry;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public String toString() {
        return "[id:" + this.f10722id + "][route:" + this.route + "][state:" + this.state + "]";
    }

    public synchronized void updateExpiry(long j10, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.updated = jCurrentTimeMillis;
        this.expiry = Math.min(j10 > 0 ? jCurrentTimeMillis + timeUnit.toMillis(j10) : Long.MAX_VALUE, this.validityDeadline);
    }

    public PoolEntry(String str, T t10, C c10) {
        this(str, t10, c10, 0L, TimeUnit.MILLISECONDS);
    }
}
