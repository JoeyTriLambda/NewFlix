package cz.msebera.android.httpclient.conn;

import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes2.dex */
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j10, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
