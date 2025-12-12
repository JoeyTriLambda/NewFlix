package com.loopj.android.http;

import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.impl.client.AbstractHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.client = (AbstractHttpClient) Utils.notNull(abstractHttpClient, "client");
        this.context = (HttpContext) Utils.notNull(httpContext, "context");
        this.request = (HttpUriRequest) Utils.notNull(httpUriRequest, "request");
        this.responseHandler = (ResponseHandlerInterface) Utils.notNull(responseHandlerInterface, "responseHandler");
    }

    private void makeRequest() throws IOException {
        if (isCancelled()) {
            return;
        }
        if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
        ResponseHandlerInterface responseHandlerInterface = this.responseHandler;
        if (responseHandlerInterface instanceof RangeFileAsyncHttpResponseHandler) {
            ((RangeFileAsyncHttpResponseHandler) responseHandlerInterface).updateRequestHeaders(this.request);
        }
        CloseableHttpResponse closeableHttpResponseExecute = this.client.execute(this.request, this.context);
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface2 = this.responseHandler;
        responseHandlerInterface2.onPreProcessResponse(responseHandlerInterface2, closeableHttpResponseExecute);
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendResponseMessage(closeableHttpResponseExecute);
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface3 = this.responseHandler;
        responseHandlerInterface3.onPostProcessResponse(responseHandlerInterface3, closeableHttpResponseExecute);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [cz.msebera.android.httpclient.client.HttpRequestRetryHandler] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.loopj.android.http.ResponseHandlerInterface] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void makeRequestWithRetries() throws java.io.IOException {
        /*
            r8 = this;
            cz.msebera.android.httpclient.impl.client.AbstractHttpClient r0 = r8.client
            cz.msebera.android.httpclient.client.HttpRequestRetryHandler r0 = r0.getHttpRequestRetryHandler()
            r1 = 1
            r2 = 0
            r3 = 1
        L9:
            if (r3 == 0) goto Lb2
            r8.makeRequest()     // Catch: java.lang.Exception -> Lf java.io.IOException -> L12 java.lang.NullPointerException -> L2c java.net.UnknownHostException -> L53
            return
        Lf:
            r0 = move-exception
            goto L91
        L12:
            r3 = move-exception
            boolean r2 = r8.isCancelled()     // Catch: java.lang.Exception -> Lf
            if (r2 == 0) goto L1a
            return
        L1a:
            int r2 = r8.executionCount     // Catch: java.lang.Exception -> L29
            int r2 = r2 + r1
            r8.executionCount = r2     // Catch: java.lang.Exception -> L29
            cz.msebera.android.httpclient.protocol.HttpContext r4 = r8.context     // Catch: java.lang.Exception -> L29
            boolean r2 = r0.retryRequest(r3, r2, r4)     // Catch: java.lang.Exception -> L29
            r7 = r3
            r3 = r2
            r2 = r7
            goto L84
        L29:
            r0 = move-exception
            r2 = r3
            goto L91
        L2c:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Exception -> Lf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lf
            r5.<init>()     // Catch: java.lang.Exception -> Lf
            java.lang.String r6 = "NPE in HttpClient: "
            r5.append(r6)     // Catch: java.lang.Exception -> Lf
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Exception -> Lf
            r5.append(r3)     // Catch: java.lang.Exception -> Lf
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Exception -> Lf
            r4.<init>(r3)     // Catch: java.lang.Exception -> Lf
            int r2 = r8.executionCount     // Catch: java.lang.Exception -> L8f
            int r2 = r2 + r1
            r8.executionCount = r2     // Catch: java.lang.Exception -> L8f
            cz.msebera.android.httpclient.protocol.HttpContext r3 = r8.context     // Catch: java.lang.Exception -> L8f
            boolean r2 = r0.retryRequest(r4, r2, r3)     // Catch: java.lang.Exception -> L8f
            goto L82
        L53:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Exception -> Lf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lf
            r5.<init>()     // Catch: java.lang.Exception -> Lf
            java.lang.String r6 = "UnknownHostException exception: "
            r5.append(r6)     // Catch: java.lang.Exception -> Lf
            java.lang.String r6 = r3.getMessage()     // Catch: java.lang.Exception -> Lf
            r5.append(r6)     // Catch: java.lang.Exception -> Lf
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Lf
            r4.<init>(r5, r3)     // Catch: java.lang.Exception -> Lf
            int r2 = r8.executionCount     // Catch: java.lang.Exception -> L8f
            if (r2 <= 0) goto L81
            int r2 = r8.executionCount     // Catch: java.lang.Exception -> L8f
            int r2 = r2 + r1
            r8.executionCount = r2     // Catch: java.lang.Exception -> L8f
            cz.msebera.android.httpclient.protocol.HttpContext r5 = r8.context     // Catch: java.lang.Exception -> L8f
            boolean r2 = r0.retryRequest(r3, r2, r5)     // Catch: java.lang.Exception -> L8f
            if (r2 == 0) goto L81
            r2 = 1
            goto L82
        L81:
            r2 = 0
        L82:
            r3 = r2
            r2 = r4
        L84:
            if (r3 == 0) goto L9
            com.loopj.android.http.ResponseHandlerInterface r4 = r8.responseHandler     // Catch: java.lang.Exception -> Lf
            int r5 = r8.executionCount     // Catch: java.lang.Exception -> Lf
            r4.sendRetryMessage(r5)     // Catch: java.lang.Exception -> Lf
            goto L9
        L8f:
            r0 = move-exception
            r2 = r4
        L91:
            com.loopj.android.http.LogInterface r1 = com.loopj.android.http.AsyncHttpClient.log
            java.lang.String r3 = "AsyncHttpRequest"
            java.lang.String r4 = "Unhandled exception origin cause"
            r1.e(r3, r4, r0)
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unhandled exception: "
            r3.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0, r2)
            r2 = r1
        Lb2:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.AsyncHttpRequest.makeRequestWithRetries():void");
    }

    private synchronized void sendCancelNotification() {
        if (!this.isFinished && this.isCancelled.get() && !this.cancelIsNotified) {
            this.cancelIsNotified = true;
            this.responseHandler.sendCancelMessage();
        }
    }

    public boolean cancel(boolean z10) throws UnsupportedOperationException {
        this.isCancelled.set(true);
        this.request.abort();
        return isCancelled();
    }

    public Object getTag() {
        return this.responseHandler.getTag();
    }

    public boolean isCancelled() {
        boolean z10 = this.isCancelled.get();
        if (z10) {
            sendCancelNotification();
        }
        return z10;
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isCancelled()) {
            return;
        }
        if (!this.isRequestPreProcessed) {
            this.isRequestPreProcessed = true;
            onPreProcessRequest(this);
        }
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendStartMessage();
        if (isCancelled()) {
            return;
        }
        try {
            makeRequestWithRetries();
        } catch (IOException e10) {
            if (isCancelled()) {
                AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", e10);
            } else {
                this.responseHandler.sendFailureMessage(0, null, null, e10);
            }
        }
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendFinishMessage();
        if (isCancelled()) {
            return;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
    }

    public AsyncHttpRequest setRequestTag(Object obj) {
        this.responseHandler.setTag(obj);
        return this;
    }

    public void onPostProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    public void onPreProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }
}
