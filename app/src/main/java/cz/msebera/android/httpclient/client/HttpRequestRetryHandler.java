package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException iOException, int i10, HttpContext httpContext);
}
