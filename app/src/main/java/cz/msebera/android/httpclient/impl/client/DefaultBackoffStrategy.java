package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/* loaded from: classes2.dex */
public class DefaultBackoffStrategy implements ConnectionBackoffStrategy {
    @Override // cz.msebera.android.httpclient.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(Throwable th2) {
        return (th2 instanceof SocketTimeoutException) || (th2 instanceof ConnectException);
    }

    @Override // cz.msebera.android.httpclient.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() == 503;
    }
}
