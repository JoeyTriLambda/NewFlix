package cz.msebera.android.httpclient.impl.client;

import ac.c;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.methods.RequestBuilder;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.URI;
import java.net.URISyntaxException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class DefaultRedirectStrategy implements RedirectStrategy {

    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
    private static final String[] REDIRECT_METHODS = {"GET", "HEAD"};

    public URI createLocationURI(String str) throws ProtocolException {
        try {
            return new URI(str);
        } catch (URISyntaxException e10) {
            throw new ProtocolException(c.j("Invalid redirect URI: ", str), e10);
        }
    }

    public URI getLocationURI(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext httpClientContextAdapt = HttpClientContext.adapt(httpContext);
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String value = firstHeader.getValue();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Redirect requested to location '" + value + "'");
        }
        RequestConfig requestConfig = httpClientContextAdapt.getRequestConfig();
        URI uriCreateLocationURI = createLocationURI(value);
        try {
            if (requestConfig.isNormalizeUri()) {
                uriCreateLocationURI = URIUtils.normalizeSyntax(uriCreateLocationURI);
            }
            if (!uriCreateLocationURI.isAbsolute()) {
                if (!requestConfig.isRelativeRedirectsAllowed()) {
                    throw new ProtocolException("Relative redirect location '" + uriCreateLocationURI + "' not allowed");
                }
                HttpHost targetHost = httpClientContextAdapt.getTargetHost();
                Asserts.notNull(targetHost, "Target host");
                uriCreateLocationURI = URIUtils.resolve(URIUtils.rewriteURI(new URI(httpRequest.getRequestLine().getUri()), targetHost, requestConfig.isNormalizeUri() ? URIUtils.NORMALIZE : URIUtils.NO_FLAGS), uriCreateLocationURI);
            }
            RedirectLocations redirectLocations = (RedirectLocations) httpClientContextAdapt.getAttribute("http.protocol.redirect-locations");
            if (redirectLocations == null) {
                redirectLocations = new RedirectLocations();
                httpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
            }
            if (requestConfig.isCircularRedirectsAllowed() || !redirectLocations.contains(uriCreateLocationURI)) {
                redirectLocations.add(uriCreateLocationURI);
                return uriCreateLocationURI;
            }
            throw new CircularRedirectException("Circular redirect to '" + uriCreateLocationURI + "'");
        } catch (URISyntaxException e10) {
            throw new ProtocolException(e10.getMessage(), e10);
        }
    }

    @Override // cz.msebera.android.httpclient.client.RedirectStrategy
    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI locationURI = getLocationURI(httpRequest, httpResponse, httpContext);
        String method = httpRequest.getRequestLine().getMethod();
        return method.equalsIgnoreCase("HEAD") ? new HttpHead(locationURI) : method.equalsIgnoreCase("GET") ? new HttpGet(locationURI) : httpResponse.getStatusLine().getStatusCode() == 307 ? RequestBuilder.copy(httpRequest).setUri(locationURI).build() : new HttpGet(locationURI);
    }

    public boolean isRedirectable(String str) {
        for (String str2 : REDIRECT_METHODS) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // cz.msebera.android.httpclient.client.RedirectStrategy
    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String method = httpRequest.getRequestLine().getMethod();
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (statusCode != 307) {
            switch (statusCode) {
                case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
                    break;
                case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
                    return isRedirectable(method) && firstHeader != null;
                case HttpStatus.SC_SEE_OTHER /* 303 */:
                    return true;
                default:
                    return false;
            }
        }
        return isRedirectable(method);
    }
}
