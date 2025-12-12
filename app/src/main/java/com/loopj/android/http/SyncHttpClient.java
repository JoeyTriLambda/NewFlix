package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* loaded from: classes.dex */
public class SyncHttpClient extends AsyncHttpClient {
    public SyncHttpClient() {
        super(false, 80, 443);
    }

    @Override // com.loopj.android.http.AsyncHttpClient
    public RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        responseHandlerInterface.setUseSynchronousMode(true);
        newAsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, str, responseHandlerInterface, context).run();
        return new RequestHandle(null);
    }

    public SyncHttpClient(int i10) {
        super(false, i10, 443);
    }

    public SyncHttpClient(int i10, int i11) {
        super(false, i10, i11);
    }

    public SyncHttpClient(boolean z10, int i10, int i11) {
        super(z10, i10, i11);
    }

    public SyncHttpClient(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }
}
