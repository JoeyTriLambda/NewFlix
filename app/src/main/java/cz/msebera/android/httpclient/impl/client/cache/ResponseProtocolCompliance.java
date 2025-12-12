package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
class ResponseProtocolCompliance {
    private static final String UNEXPECTED_100_CONTINUE = "The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.";
    private static final String UNEXPECTED_PARTIAL_CONTENT = "partial content was returned for a request that did not ask for it";

    private boolean backendResponseMustNotHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        return "HEAD".equals(httpRequest.getRequestLine().getMethod()) || httpResponse.getStatusLine().getStatusCode() == 204 || httpResponse.getStatusLine().getStatusCode() == 205 || httpResponse.getStatusLine().getStatusCode() == 304;
    }

    private void consumeBody(HttpResponse httpResponse) throws IOException {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            IOUtils.consume(entity);
        }
    }

    private void ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("OPTIONS") && httpResponse.getStatusLine().getStatusCode() == 200 && httpResponse.getFirstHeader("Content-Length") == null) {
            httpResponse.addHeader("Content-Length", "0");
        }
    }

    private void ensure206ContainsDateHeader(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Date") == null) {
            httpResponse.addHeader("Date", DateUtils.formatDate(new Date()));
        }
    }

    private void ensure304DoesNotContainExtraEntityHeaders(HttpResponse httpResponse) {
        String[] strArr = {"Allow", "Content-Encoding", HttpHeaders.CONTENT_LANGUAGE, "Content-Length", HttpHeaders.CONTENT_MD5, "Content-Range", "Content-Type", "Last-Modified"};
        if (httpResponse.getStatusLine().getStatusCode() == 304) {
            for (int i10 = 0; i10 < 8; i10++) {
                httpResponse.removeHeaders(strArr[i10]);
            }
        }
    }

    private void ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        if (httpRequest.getFirstHeader("Range") == null && httpResponse.getStatusLine().getStatusCode() == 206) {
            consumeBody(httpResponse);
            throw new ClientProtocolException(UNEXPECTED_PARTIAL_CONTENT);
        }
    }

    private void identityIsNotUsedInContentEncoding(HttpResponse httpResponse) throws ParseException {
        Header[] headers = httpResponse.getHeaders("Content-Encoding");
        if (headers == null || headers.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (Header header : headers) {
            StringBuilder sb2 = new StringBuilder();
            boolean z11 = true;
            for (HeaderElement headerElement : header.getElements()) {
                if (HTTP.IDENTITY_CODING.equalsIgnoreCase(headerElement.getName())) {
                    z10 = true;
                } else {
                    if (!z11) {
                        sb2.append(",");
                    }
                    sb2.append(headerElement.toString());
                    z11 = false;
                }
            }
            String string = sb2.toString();
            if (!"".equals(string)) {
                arrayList.add(new BasicHeader("Content-Encoding", string));
            }
        }
        if (z10) {
            httpResponse.removeHeaders("Content-Encoding");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                httpResponse.addHeader((Header) it.next());
            }
        }
    }

    private void removeResponseTransferEncoding(HttpResponse httpResponse) {
        httpResponse.removeHeaders(HttpHeaders.TE);
        httpResponse.removeHeaders("Transfer-Encoding");
    }

    private void requestDidNotExpect100ContinueButResponseIsOne(HttpRequestWrapper httpRequestWrapper, HttpResponse httpResponse) throws IOException {
        if (httpResponse.getStatusLine().getStatusCode() != 100) {
            return;
        }
        HttpRequest original = httpRequestWrapper.getOriginal();
        if ((original instanceof HttpEntityEnclosingRequest) && ((HttpEntityEnclosingRequest) original).expectContinue()) {
            return;
        }
        consumeBody(httpResponse);
        throw new ClientProtocolException(UNEXPECTED_100_CONTINUE);
    }

    private void transferEncodingIsNotReturnedTo1_0Client(HttpRequestWrapper httpRequestWrapper, HttpResponse httpResponse) {
        if (httpRequestWrapper.getOriginal().getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) >= 0) {
            return;
        }
        removeResponseTransferEncoding(httpResponse);
    }

    private void warningsWithNonMatchingWarnDatesAreRemoved(HttpResponse httpResponse) {
        Header[] headers;
        Date date = DateUtils.parseDate(httpResponse.getFirstHeader("Date").getValue());
        if (date == null || (headers = httpResponse.getHeaders("Warning")) == null || headers.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (Header header : headers) {
            for (WarningValue warningValue : WarningValue.getWarningValues(header)) {
                Date warnDate = warningValue.getWarnDate();
                if (warnDate == null || warnDate.equals(date)) {
                    arrayList.add(new BasicHeader("Warning", warningValue.toString()));
                } else {
                    z10 = true;
                }
            }
        }
        if (z10) {
            httpResponse.removeHeaders("Warning");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                httpResponse.addHeader((Header) it.next());
            }
        }
    }

    public void ensureProtocolCompliance(HttpRequestWrapper httpRequestWrapper, HttpResponse httpResponse) throws IOException {
        if (backendResponseMustNotHaveBody(httpRequestWrapper, httpResponse)) {
            consumeBody(httpResponse);
            httpResponse.setEntity(null);
        }
        requestDidNotExpect100ContinueButResponseIsOne(httpRequestWrapper, httpResponse);
        transferEncodingIsNotReturnedTo1_0Client(httpRequestWrapper, httpResponse);
        ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(httpRequestWrapper, httpResponse);
        ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(httpRequestWrapper, httpResponse);
        ensure206ContainsDateHeader(httpResponse);
        ensure304DoesNotContainExtraEntityHeaders(httpResponse);
        identityIsNotUsedInContentEncoding(httpResponse);
        warningsWithNonMatchingWarnDatesAreRemoved(httpResponse);
    }
}
