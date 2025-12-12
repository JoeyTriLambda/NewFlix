package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private final String method;
    private final HttpRequest original;
    private RequestLine requestLine;
    private final HttpHost target;
    private URI uri;
    private ProtocolVersion version;

    public static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest, HttpHost httpHost) {
            super(httpEntityEnclosingRequest, httpHost);
            this.entity = httpEntityEnclosingRequest.getEntity();
        }

        @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
        public boolean expectContinue() {
            Header firstHeader = getFirstHeader("Expect");
            return firstHeader != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(firstHeader.getValue());
        }

        @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
        public HttpEntity getEntity() {
            return this.entity;
        }

        @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
        public void setEntity(HttpEntity httpEntity) {
            this.entity = httpEntity;
        }
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest) {
        return wrap(httpRequest, null);
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return this.method;
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = this.original.getParams().copy();
        }
        return this.params;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : this.original.getProtocolVersion();
    }

    @Override // cz.msebera.android.httpclient.HttpRequest
    public RequestLine getRequestLine() {
        if (this.requestLine == null) {
            URI uri = this.uri;
            String aSCIIString = uri != null ? uri.toASCIIString() : this.original.getRequestLine().getUri();
            if (aSCIIString == null || aSCIIString.isEmpty()) {
                aSCIIString = "/";
            }
            this.requestLine = new BasicRequestLine(this.method, aSCIIString, getProtocolVersion());
        }
        return this.requestLine;
    }

    public HttpHost getTarget() {
        return this.target;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public boolean isAborted() {
        return false;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
        this.requestLine = null;
    }

    public void setURI(URI uri) {
        this.uri = uri;
        this.requestLine = null;
    }

    public String toString() {
        return getRequestLine() + StringUtils.SPACE + this.headergroup;
    }

    private HttpRequestWrapper(HttpRequest httpRequest, HttpHost httpHost) {
        HttpRequest httpRequest2 = (HttpRequest) Args.notNull(httpRequest, "HTTP request");
        this.original = httpRequest2;
        this.target = httpHost;
        this.version = httpRequest2.getRequestLine().getProtocolVersion();
        this.method = httpRequest2.getRequestLine().getMethod();
        if (httpRequest instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            this.uri = null;
        }
        setHeaders(httpRequest.getAllHeaders());
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest, HttpHost httpHost) {
        Args.notNull(httpRequest, "HTTP request");
        return httpRequest instanceof HttpEntityEnclosingRequest ? new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest, httpHost) : new HttpRequestWrapper(httpRequest, httpHost);
    }
}
