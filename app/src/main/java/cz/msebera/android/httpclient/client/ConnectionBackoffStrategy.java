package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;

/* loaded from: classes2.dex */
public interface ConnectionBackoffStrategy {
    boolean shouldBackoff(HttpResponse httpResponse);

    boolean shouldBackoff(Throwable th2);
}
