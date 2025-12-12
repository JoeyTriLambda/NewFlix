package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class HttpRequestExecutor {
    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor(int i10) {
        this.waitForContinue = Args.positive(i10, "Wait for continue time");
    }

    private static void closeConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.close();
        } catch (IOException unused) {
        }
    }

    public boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return ("HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod()) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    public HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        HttpResponse httpResponseReceiveResponseHeader = null;
        int statusCode = 0;
        while (true) {
            if (httpResponseReceiveResponseHeader != null && statusCode >= 200) {
                return httpResponseReceiveResponseHeader;
            }
            httpResponseReceiveResponseHeader = httpClientConnection.receiveResponseHeader();
            statusCode = httpResponseReceiveResponseHeader.getStatusLine().getStatusCode();
            if (statusCode < 100) {
                throw new ProtocolException("Invalid response: " + httpResponseReceiveResponseHeader.getStatusLine());
            }
            if (canResponseHaveBody(httpRequest, httpResponseReceiveResponseHeader)) {
                httpClientConnection.receiveResponseEntity(httpResponseReceiveResponseHeader);
            }
        }
    }

    public HttpResponse doSendRequest(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.connection", httpClientConnection);
        httpContext.setAttribute("http.request_sent", Boolean.FALSE);
        httpClientConnection.sendRequestHeader(httpRequest);
        HttpResponse httpResponse = null;
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            boolean z10 = true;
            if (httpEntityEnclosingRequest.expectContinue() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                httpClientConnection.flush();
                if (httpClientConnection.isResponseAvailable(this.waitForContinue)) {
                    HttpResponse httpResponseReceiveResponseHeader = httpClientConnection.receiveResponseHeader();
                    if (canResponseHaveBody(httpRequest, httpResponseReceiveResponseHeader)) {
                        httpClientConnection.receiveResponseEntity(httpResponseReceiveResponseHeader);
                    }
                    int statusCode = httpResponseReceiveResponseHeader.getStatusLine().getStatusCode();
                    if (statusCode >= 200) {
                        z10 = false;
                        httpResponse = httpResponseReceiveResponseHeader;
                    } else if (statusCode != 100) {
                        throw new ProtocolException("Unexpected response: " + httpResponseReceiveResponseHeader.getStatusLine());
                    }
                }
            }
            if (z10) {
                httpClientConnection.sendRequestEntity(httpEntityEnclosingRequest);
            }
        }
        httpClientConnection.flush();
        httpContext.setAttribute("http.request_sent", Boolean.TRUE);
        return httpResponse;
    }

    public HttpResponse execute(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        try {
            HttpResponse httpResponseDoSendRequest = doSendRequest(httpRequest, httpClientConnection, httpContext);
            return httpResponseDoSendRequest == null ? doReceiveResponse(httpRequest, httpClientConnection, httpContext) : httpResponseDoSendRequest;
        } catch (HttpException e10) {
            closeConnection(httpClientConnection);
            throw e10;
        } catch (IOException e11) {
            closeConnection(httpClientConnection);
            throw e11;
        } catch (RuntimeException e12) {
            closeConnection(httpClientConnection);
            throw e12;
        }
    }

    public void postProcess(HttpResponse httpResponse, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.response", httpResponse);
        httpProcessor.process(httpResponse, httpContext);
    }

    public void preProcess(HttpRequest httpRequest, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.request", httpRequest);
        httpProcessor.process(httpRequest, httpContext);
    }

    public HttpRequestExecutor() {
        this(DEFAULT_WAIT_FOR_CONTINUE);
    }
}
