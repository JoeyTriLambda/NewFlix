package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes2.dex */
public class IdleConnectionHandler {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final Map<HttpConnection, TimeValues> connectionToTimes = new HashMap();

    public static class TimeValues {
        private final long timeAdded;
        private final long timeExpires;

        public TimeValues(long j10, long j11, TimeUnit timeUnit) {
            this.timeAdded = j10;
            if (j11 > 0) {
                this.timeExpires = timeUnit.toMillis(j11) + j10;
            } else {
                this.timeExpires = Long.MAX_VALUE;
            }
        }
    }

    public void add(HttpConnection httpConnection, long j10, TimeUnit timeUnit) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Adding connection at: " + jCurrentTimeMillis);
        }
        this.connectionToTimes.put(httpConnection, new TimeValues(jCurrentTimeMillis, j10, timeUnit));
    }

    public void closeExpiredConnections() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for expired connections, now: " + jCurrentTimeMillis);
        }
        for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
            HttpConnection key = entry.getKey();
            TimeValues value = entry.getValue();
            if (value.timeExpires <= jCurrentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing connection, expired @: " + value.timeExpires);
                }
                try {
                    key.close();
                } catch (IOException e10) {
                    this.log.debug("I/O error closing connection", e10);
                }
            }
        }
    }

    public void closeIdleConnections(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for connections, idle timeout: " + jCurrentTimeMillis);
        }
        for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
            HttpConnection key = entry.getKey();
            long j11 = entry.getValue().timeAdded;
            if (j11 <= jCurrentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing idle connection, connection time: " + j11);
                }
                try {
                    key.close();
                } catch (IOException e10) {
                    this.log.debug("I/O error closing connection", e10);
                }
            }
        }
    }

    public boolean remove(HttpConnection httpConnection) {
        TimeValues timeValuesRemove = this.connectionToTimes.remove(httpConnection);
        if (timeValuesRemove != null) {
            return System.currentTimeMillis() <= timeValuesRemove.timeExpires;
        }
        this.log.warn("Removing a connection that never existed!");
        return true;
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }
}
