package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public void close() {
        try {
            getConnection().close();
        } catch (IOException unused) {
        }
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }
}
