package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes2.dex */
public class RetryExec implements ClientExecChain {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientExecChain, HttpRequestRetryHandler httpRequestRetryHandler) {
        Args.notNull(clientExecChain, "HTTP request executor");
        Args.notNull(httpRequestRetryHandler, "HTTP request retry handler");
        this.requestExecutor = clientExecChain;
        this.retryHandler = httpRequestRetryHandler;
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        Header[] allHeaders = httpRequestWrapper.getAllHeaders();
        int i10 = 1;
        while (true) {
            try {
                return this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            } catch (IOException e10) {
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    this.log.debug("Request has been aborted");
                    throw e10;
                }
                if (!this.retryHandler.retryRequest(e10, i10, httpClientContext)) {
                    if (!(e10 instanceof NoHttpResponseException)) {
                        throw e10;
                    }
                    NoHttpResponseException noHttpResponseException = new NoHttpResponseException(httpRoute.getTargetHost().toHostString() + " failed to respond");
                    noHttpResponseException.setStackTrace(e10.getStackTrace());
                    throw noHttpResponseException;
                }
                if (this.log.isInfoEnabled()) {
                    this.log.info("I/O exception (" + e10.getClass().getName() + ") caught when processing request to " + httpRoute + ": " + e10.getMessage());
                }
                if (this.log.isDebugEnabled()) {
                    this.log.debug(e10.getMessage(), e10);
                }
                if (!RequestEntityProxy.isRepeatable(httpRequestWrapper)) {
                    this.log.debug("Cannot retry non-repeatable request");
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", e10);
                }
                httpRequestWrapper.setHeaders(allHeaders);
                if (this.log.isInfoEnabled()) {
                    this.log.info("Retrying request to " + httpRoute);
                }
                i10++;
            }
        }
    }
}
