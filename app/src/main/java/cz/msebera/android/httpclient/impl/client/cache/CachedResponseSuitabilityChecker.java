package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.util.Date;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes2.dex */
class CachedResponseSuitabilityChecker {
    private final float heuristicCoefficient;
    private final long heuristicDefaultLifetime;
    public HttpClientAndroidLog log;
    private final boolean sharedCache;
    private final boolean useHeuristicCaching;
    private final CacheValidityPolicy validityStrategy;

    public CachedResponseSuitabilityChecker(CacheValidityPolicy cacheValidityPolicy, CacheConfig cacheConfig) {
        this.log = new HttpClientAndroidLog(getClass());
        this.validityStrategy = cacheValidityPolicy;
        this.sharedCache = cacheConfig.isSharedCache();
        this.useHeuristicCaching = cacheConfig.isHeuristicCachingEnabled();
        this.heuristicCoefficient = cacheConfig.getHeuristicCoefficient();
        this.heuristicDefaultLifetime = cacheConfig.getHeuristicDefaultLifetime();
    }

    private boolean cacheEntryDoesNotContainMethodAndEntity(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getRequestMethod() == null && httpCacheEntry.getResource() == null;
    }

    private boolean entryIsNotA204Response(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getStatusCode() != 204;
    }

    private boolean etagValidatorMatches(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) throws ParseException {
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        String value = firstHeader != null ? firstHeader.getValue() : null;
        Header[] headers = httpRequest.getHeaders("If-None-Match");
        if (headers != null) {
            for (Header header : headers) {
                for (HeaderElement headerElement : header.getElements()) {
                    String string = headerElement.toString();
                    if (("*".equals(string) && value != null) || string.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private long getMaxStale(HttpRequest httpRequest) throws ParseException, NumberFormatException {
        long j10 = -1;
        for (Header header : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                    if ((headerElement.getValue() == null || "".equals(headerElement.getValue().trim())) && j10 == -1) {
                        j10 = Long.MAX_VALUE;
                    } else {
                        try {
                            long j11 = Long.parseLong(headerElement.getValue());
                            j = j11 >= 0 ? j11 : 0L;
                        } catch (NumberFormatException unused) {
                        }
                        if (j10 == -1 || j < j10) {
                            j10 = j;
                        }
                    }
                }
            }
        }
        return j10;
    }

    private boolean hasSupportedEtagValidator(HttpRequest httpRequest) {
        return httpRequest.containsHeader("If-None-Match");
    }

    private boolean hasSupportedLastModifiedValidator(HttpRequest httpRequest) {
        return hasValidDateField(httpRequest, "If-Modified-Since");
    }

    private boolean hasUnsupportedCacheEntryForGet(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        return isGet(httpRequest) && cacheEntryDoesNotContainMethodAndEntity(httpCacheEntry) && entryIsNotA204Response(httpCacheEntry);
    }

    private boolean hasUnsupportedConditionalHeaders(HttpRequest httpRequest) {
        return (httpRequest.getFirstHeader("If-Range") == null && httpRequest.getFirstHeader("If-Match") == null && !hasValidDateField(httpRequest, "If-Unmodified-Since")) ? false : true;
    }

    private boolean hasValidDateField(HttpRequest httpRequest, String str) {
        Header[] headers = httpRequest.getHeaders(str);
        return headers.length > 0 && DateUtils.parseDate(headers[0].getValue()) != null;
    }

    private boolean isFreshEnough(HttpCacheEntry httpCacheEntry, HttpRequest httpRequest, Date date) throws ParseException, NumberFormatException {
        if (this.validityStrategy.isResponseFresh(httpCacheEntry, date)) {
            return true;
        }
        if (this.useHeuristicCaching && this.validityStrategy.isResponseHeuristicallyFresh(httpCacheEntry, date, this.heuristicCoefficient, this.heuristicDefaultLifetime)) {
            return true;
        }
        if (originInsistsOnFreshness(httpCacheEntry)) {
            return false;
        }
        long maxStale = getMaxStale(httpRequest);
        return maxStale != -1 && maxStale > this.validityStrategy.getStalenessSecs(httpCacheEntry, date);
    }

    private boolean isGet(HttpRequest httpRequest) {
        return httpRequest.getRequestLine().getMethod().equals("GET");
    }

    private boolean lastModifiedValidatorMatches(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        Date date2 = firstHeader != null ? DateUtils.parseDate(firstHeader.getValue()) : null;
        if (date2 == null) {
            return false;
        }
        for (Header header : httpRequest.getHeaders("If-Modified-Since")) {
            Date date3 = DateUtils.parseDate(header.getValue());
            if (date3 != null && (date3.after(date) || date2.after(date3))) {
                return false;
            }
        }
        return true;
    }

    private boolean originInsistsOnFreshness(HttpCacheEntry httpCacheEntry) {
        if (this.validityStrategy.mustRevalidate(httpCacheEntry)) {
            return true;
        }
        if (this.sharedCache) {
            return this.validityStrategy.proxyRevalidate(httpCacheEntry) || this.validityStrategy.hasCacheControlDirective(httpCacheEntry, "s-maxage");
        }
        return false;
    }

    public boolean allConditionalsMatch(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        boolean zHasSupportedEtagValidator = hasSupportedEtagValidator(httpRequest);
        boolean zHasSupportedLastModifiedValidator = hasSupportedLastModifiedValidator(httpRequest);
        boolean z10 = zHasSupportedEtagValidator && etagValidatorMatches(httpRequest, httpCacheEntry);
        boolean z11 = zHasSupportedLastModifiedValidator && lastModifiedValidatorMatches(httpRequest, httpCacheEntry, date);
        if (zHasSupportedEtagValidator && zHasSupportedLastModifiedValidator && (!z10 || !z11)) {
            return false;
        }
        if (!zHasSupportedEtagValidator || z10) {
            return !zHasSupportedLastModifiedValidator || z11;
        }
        return false;
    }

    public boolean canCachedResponseBeUsed(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) throws ParseException, NumberFormatException {
        int i10;
        boolean z10 = false;
        if (!isFreshEnough(httpCacheEntry, httpRequest, date)) {
            this.log.trace("Cache entry was not fresh enough");
            return false;
        }
        if (isGet(httpRequest) && !this.validityStrategy.contentLengthHeaderMatchesActualLength(httpCacheEntry)) {
            this.log.debug("Cache entry Content-Length and header information do not match");
            return false;
        }
        if (hasUnsupportedConditionalHeaders(httpRequest)) {
            this.log.debug("Request contained conditional headers we don't handle");
            return false;
        }
        if (!isConditional(httpRequest) && httpCacheEntry.getStatusCode() == 304) {
            return false;
        }
        if (isConditional(httpRequest) && !allConditionalsMatch(httpRequest, httpCacheEntry, date)) {
            return false;
        }
        if (hasUnsupportedCacheEntryForGet(httpRequest, httpCacheEntry)) {
            this.log.debug("HEAD response caching enabled but the cache entry does not contain a request method, entity or a 204 response");
            return false;
        }
        Header[] headers = httpRequest.getHeaders("Cache-Control");
        int length = headers.length;
        int i11 = 0;
        while (i11 < length) {
            HeaderElement[] elements = headers[i11].getElements();
            int length2 = elements.length;
            int i12 = 0;
            while (i12 < length2) {
                HeaderElement headerElement = elements[i12];
                if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                    this.log.trace("Response contained NO CACHE directive, cache was not suitable");
                    return z10;
                }
                if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(headerElement.getName())) {
                    this.log.trace("Response contained NO STORE directive, cache was not suitable");
                    return z10;
                }
                if ("max-age".equals(headerElement.getName())) {
                    try {
                        if (this.validityStrategy.getCurrentAgeSecs(httpCacheEntry, date) > Integer.parseInt(headerElement.getValue())) {
                            this.log.trace("Response from cache was NOT suitable due to max age");
                            return z10;
                        }
                    } catch (NumberFormatException e10) {
                        this.log.debug("Response from cache was malformed" + e10.getMessage());
                        return z10;
                    }
                }
                if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                    try {
                        i10 = i11;
                        if (this.validityStrategy.getFreshnessLifetimeSecs(httpCacheEntry) > Integer.parseInt(headerElement.getValue())) {
                            this.log.trace("Response from cache was not suitable due to Max stale freshness");
                            return false;
                        }
                    } catch (NumberFormatException e11) {
                        this.log.debug("Response from cache was malformed: " + e11.getMessage());
                        return false;
                    }
                } else {
                    i10 = i11;
                }
                if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(headerElement.getName())) {
                    try {
                        long j10 = Long.parseLong(headerElement.getValue());
                        if (j10 < 0) {
                            return false;
                        }
                        if (this.validityStrategy.getFreshnessLifetimeSecs(httpCacheEntry) - this.validityStrategy.getCurrentAgeSecs(httpCacheEntry, date) < j10) {
                            this.log.trace("Response from cache was not suitable due to min fresh freshness requirement");
                            return false;
                        }
                    } catch (NumberFormatException e12) {
                        this.log.debug("Response from cache was malformed: " + e12.getMessage());
                        return false;
                    }
                }
                z10 = false;
                i12++;
                i11 = i10;
            }
            i11++;
        }
        this.log.trace("Response from cache was suitable");
        return true;
    }

    public boolean isConditional(HttpRequest httpRequest) {
        return hasSupportedEtagValidator(httpRequest) || hasSupportedLastModifiedValidator(httpRequest);
    }

    public CachedResponseSuitabilityChecker(CacheConfig cacheConfig) {
        this(new CacheValidityPolicy(), cacheConfig);
    }
}
