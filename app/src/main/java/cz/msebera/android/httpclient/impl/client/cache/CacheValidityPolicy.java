package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import java.util.Date;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
class CacheValidityPolicy {
    public static final long MAX_AGE = 2147483648L;

    public boolean contentLengthHeaderMatchesActualLength(HttpCacheEntry httpCacheEntry) {
        return !hasContentLengthHeader(httpCacheEntry) || (httpCacheEntry.getResource() != null && getContentLengthValue(httpCacheEntry) == httpCacheEntry.getResource().length());
    }

    public long getAgeValue(HttpCacheEntry httpCacheEntry) throws NumberFormatException {
        long j10 = 0;
        for (Header header : httpCacheEntry.getHeaders("Age")) {
            long j11 = MAX_AGE;
            try {
                long j12 = Long.parseLong(header.getValue());
                if (j12 >= 0) {
                    j11 = j12;
                }
            } catch (NumberFormatException unused) {
            }
            if (j11 > j10) {
                j10 = j11;
            }
        }
        return j10;
    }

    public long getApparentAgeSecs(HttpCacheEntry httpCacheEntry) {
        Date date = httpCacheEntry.getDate();
        if (date == null) {
            return MAX_AGE;
        }
        long time = httpCacheEntry.getResponseDate().getTime() - date.getTime();
        if (time < 0) {
            return 0L;
        }
        return time / 1000;
    }

    public long getContentLengthValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Content-Length");
        if (firstHeader == null) {
            return -1L;
        }
        try {
            return Long.parseLong(firstHeader.getValue());
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public long getCorrectedInitialAgeSecs(HttpCacheEntry httpCacheEntry) {
        return getCorrectedReceivedAgeSecs(httpCacheEntry) + getResponseDelaySecs(httpCacheEntry);
    }

    public long getCorrectedReceivedAgeSecs(HttpCacheEntry httpCacheEntry) throws NumberFormatException {
        long apparentAgeSecs = getApparentAgeSecs(httpCacheEntry);
        long ageValue = getAgeValue(httpCacheEntry);
        return apparentAgeSecs > ageValue ? apparentAgeSecs : ageValue;
    }

    public long getCurrentAgeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return getCorrectedInitialAgeSecs(httpCacheEntry) + getResidentTimeSecs(httpCacheEntry, date);
    }

    @Deprecated
    public Date getDateValue(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getDate();
    }

    public Date getExpirationDate(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Expires");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    public long getFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry) throws ParseException, NumberFormatException {
        Date expirationDate;
        long maxAge = getMaxAge(httpCacheEntry);
        if (maxAge > -1) {
            return maxAge;
        }
        Date date = httpCacheEntry.getDate();
        if (date == null || (expirationDate = getExpirationDate(httpCacheEntry)) == null) {
            return 0L;
        }
        return (expirationDate.getTime() - date.getTime()) / 1000;
    }

    public long getHeuristicFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry, float f10, long j10) {
        Date date = httpCacheEntry.getDate();
        Date lastModifiedValue = getLastModifiedValue(httpCacheEntry);
        if (date == null || lastModifiedValue == null) {
            return j10;
        }
        if (date.getTime() - lastModifiedValue.getTime() < 0) {
            return 0L;
        }
        return (long) (f10 * (r5 / 1000));
    }

    public Date getLastModifiedValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    public long getMaxAge(HttpCacheEntry httpCacheEntry) throws ParseException, NumberFormatException {
        long j10 = -1;
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if ("max-age".equals(headerElement.getName()) || "s-maxage".equals(headerElement.getName())) {
                    try {
                        long j11 = Long.parseLong(headerElement.getValue());
                        if (j10 == -1 || j11 < j10) {
                            j10 = j11;
                        }
                    } catch (NumberFormatException unused) {
                        j10 = 0;
                    }
                }
            }
        }
        return j10;
    }

    public long getResidentTimeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return (date.getTime() - httpCacheEntry.getResponseDate().getTime()) / 1000;
    }

    public long getResponseDelaySecs(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getResponseDate().getTime() - httpCacheEntry.getRequestDate().getTime()) / 1000;
    }

    public long getStalenessSecs(HttpCacheEntry httpCacheEntry, Date date) throws ParseException, NumberFormatException {
        long currentAgeSecs = getCurrentAgeSecs(httpCacheEntry, date);
        long freshnessLifetimeSecs = getFreshnessLifetimeSecs(httpCacheEntry);
        if (currentAgeSecs <= freshnessLifetimeSecs) {
            return 0L;
        }
        return currentAgeSecs - freshnessLifetimeSecs;
    }

    public boolean hasCacheControlDirective(HttpCacheEntry httpCacheEntry, String str) throws ParseException {
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (str.equalsIgnoreCase(headerElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasContentLengthHeader(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getFirstHeader("Content-Length") != null;
    }

    public boolean isResponseFresh(HttpCacheEntry httpCacheEntry, Date date) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getFreshnessLifetimeSecs(httpCacheEntry);
    }

    public boolean isResponseHeuristicallyFresh(HttpCacheEntry httpCacheEntry, Date date, float f10, long j10) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getHeuristicFreshnessLifetimeSecs(httpCacheEntry, f10, j10);
    }

    public boolean isRevalidatable(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getFirstHeader("ETag") == null && httpCacheEntry.getFirstHeader("Last-Modified") == null) ? false : true;
    }

    public boolean mayReturnStaleIfError(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) throws ParseException, NumberFormatException {
        long stalenessSecs = getStalenessSecs(httpCacheEntry, date);
        return mayReturnStaleIfError(httpRequest.getHeaders("Cache-Control"), stalenessSecs) || mayReturnStaleIfError(httpCacheEntry.getHeaders("Cache-Control"), stalenessSecs);
    }

    public boolean mayReturnStaleWhileRevalidating(HttpCacheEntry httpCacheEntry, Date date) throws ParseException, NumberFormatException {
        for (Header header : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : header.getElements()) {
                if (HeaderConstants.STALE_WHILE_REVALIDATE.equalsIgnoreCase(headerElement.getName())) {
                    try {
                        if (getStalenessSecs(httpCacheEntry, date) <= Integer.parseInt(r7.getValue())) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean mustRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE);
    }

    public boolean proxyRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE);
    }

    private boolean mayReturnStaleIfError(Header[] headerArr, long j10) throws ParseException {
        boolean z10 = false;
        for (Header header : headerArr) {
            HeaderElement[] elements = header.getElements();
            int length = elements.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    if (HeaderConstants.STALE_IF_ERROR.equals(elements[i10].getName())) {
                        try {
                            if (j10 <= Integer.parseInt(r7.getValue())) {
                                z10 = true;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            continue;
                        }
                    }
                    i10++;
                }
            }
        }
        return z10;
    }
}
