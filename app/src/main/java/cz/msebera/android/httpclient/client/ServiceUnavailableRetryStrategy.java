package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface ServiceUnavailableRetryStrategy {
    long getRetryInterval();

    boolean retryRequest(HttpResponse httpResponse, int i10, HttpContext httpContext);
}
