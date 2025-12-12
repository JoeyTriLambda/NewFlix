package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
