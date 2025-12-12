package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
class ResponseCachingPolicy {
    private static final String[] AUTH_CACHEABLE_PARAMS = {"s-maxage", HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, HeaderConstants.PUBLIC};
    private static final Set<Integer> cacheableStatuses = new HashSet(Arrays.asList(200, Integer.valueOf(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION), Integer.valueOf(HttpStatus.SC_MULTIPLE_CHOICES), Integer.valueOf(HttpStatus.SC_MOVED_PERMANENTLY), Integer.valueOf(HttpStatus.SC_GONE)));
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final long maxObjectSizeBytes;
    private final boolean neverCache1_0ResponsesWithQueryString;
    private final boolean sharedCache;
    private final Set<Integer> uncacheableStatuses;

    public ResponseCachingPolicy(long j10, boolean z10, boolean z11, boolean z12) {
        this.maxObjectSizeBytes = j10;
        this.sharedCache = z10;
        this.neverCache1_0ResponsesWithQueryString = z11;
        Integer numValueOf = Integer.valueOf(HttpStatus.SC_PARTIAL_CONTENT);
        if (z12) {
            this.uncacheableStatuses = new HashSet(Arrays.asList(numValueOf));
        } else {
            this.uncacheableStatuses = new HashSet(Arrays.asList(numValueOf, Integer.valueOf(HttpStatus.SC_SEE_OTHER)));
        }
    }

    private boolean expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Cache-Control") != null) {
            return false;
        }
        Header firstHeader = httpResponse.getFirstHeader("Expires");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (firstHeader == null || firstHeader2 == null) {
            return false;
        }
        Date date = DateUtils.parseDate(firstHeader.getValue());
        Date date2 = DateUtils.parseDate(firstHeader2.getValue());
        if (date == null || date2 == null) {
            return false;
        }
        return date.equals(date2) || date.before(date2);
    }

    private boolean from1_0Origin(HttpResponse httpResponse) throws ParseException {
        Header firstHeader = httpResponse.getFirstHeader("Via");
        if (firstHeader != null) {
            HeaderElement[] elements = firstHeader.getElements();
            if (elements.length > 0) {
                String str = elements[0].toString().split("\\s")[0];
                return str.contains("/") ? str.equals("HTTP/1.0") : str.equals("1.0");
            }
        }
        return HttpVersion.HTTP_1_0.equals(httpResponse.getProtocolVersion());
    }

    private boolean requestProtocolGreaterThanAccepted(HttpRequest httpRequest) {
        return httpRequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) > 0;
    }

    private boolean unknownStatusCode(int i10) {
        if (i10 >= 100 && i10 <= 101) {
            return false;
        }
        if (i10 >= 200 && i10 <= 206) {
            return false;
        }
        if (i10 >= 300 && i10 <= 307) {
            return false;
        }
        if (i10 < 400 || i10 > 417) {
            return i10 < 500 || i10 > 505;
        }
        return false;
    }

    public boolean hasCacheControlParameterFrom(HttpMessage httpMessage, String[] strArr) throws ParseException {
        for (Header header : httpMessage.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                for (String str : strArr) {
                    if (str.equalsIgnoreCase(headerElement.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isExplicitlyCacheable(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Expires") != null) {
            return true;
        }
        return hasCacheControlParameterFrom(httpResponse, new String[]{"max-age", "s-maxage", HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE, HeaderConstants.PUBLIC});
    }

    public boolean isExplicitlyNonCacheable(HttpResponse httpResponse) throws ParseException {
        for (Header header : httpResponse.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(headerElement.getName()) || HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                    return true;
                }
                if (this.sharedCache && HeaderConstants.PRIVATE.equals(headerElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isResponseCacheable(String str, HttpResponse httpResponse) throws ParseException {
        boolean z10;
        if (!"GET".equals(str) && !"HEAD".equals(str)) {
            this.log.debug("Response was not cacheable.");
            return false;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (cacheableStatuses.contains(Integer.valueOf(statusCode))) {
            z10 = true;
        } else {
            if (this.uncacheableStatuses.contains(Integer.valueOf(statusCode)) || unknownStatusCode(statusCode)) {
                return false;
            }
            z10 = false;
        }
        Header firstHeader = httpResponse.getFirstHeader("Content-Length");
        if ((firstHeader != null && Long.parseLong(firstHeader.getValue()) > this.maxObjectSizeBytes) || httpResponse.getHeaders("Age").length > 1 || httpResponse.getHeaders("Expires").length > 1) {
            return false;
        }
        Header[] headers = httpResponse.getHeaders("Date");
        if (headers.length != 1 || DateUtils.parseDate(headers[0].getValue()) == null) {
            return false;
        }
        for (Header header : httpResponse.getHeaders("Vary")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("*".equals(headerElement.getName())) {
                    return false;
                }
            }
        }
        if (isExplicitlyNonCacheable(httpResponse)) {
            return false;
        }
        return z10 || isExplicitlyCacheable(httpResponse);
    }

    public boolean isResponseCacheable(HttpRequest httpRequest, HttpResponse httpResponse) {
        Header[] headers;
        if (requestProtocolGreaterThanAccepted(httpRequest)) {
            this.log.debug("Response was not cacheable.");
            return false;
        }
        if (hasCacheControlParameterFrom(httpRequest, new String[]{HeaderConstants.CACHE_CONTROL_NO_STORE})) {
            return false;
        }
        if (httpRequest.getRequestLine().getUri().contains("?")) {
            if (this.neverCache1_0ResponsesWithQueryString && from1_0Origin(httpResponse)) {
                this.log.debug("Response was not cacheable as it had a query string.");
                return false;
            }
            if (!isExplicitlyCacheable(httpResponse)) {
                this.log.debug("Response was not cacheable as it is missing explicit caching headers.");
                return false;
            }
        }
        if (expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(httpResponse)) {
            return false;
        }
        if (!this.sharedCache || (headers = httpRequest.getHeaders("Authorization")) == null || headers.length <= 0 || hasCacheControlParameterFrom(httpResponse, AUTH_CACHEABLE_PARAMS)) {
            return isResponseCacheable(httpRequest.getRequestLine().getMethod(), httpResponse);
        }
        return false;
    }
}
