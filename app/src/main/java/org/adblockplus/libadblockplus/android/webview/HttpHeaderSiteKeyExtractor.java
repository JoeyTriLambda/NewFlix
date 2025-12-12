package org.adblockplus.libadblockplus.android.webview;

import ac.c;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import bi.a;
import com.unity3d.services.core.device.MimeTypes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.adblockplus.libadblockplus.AdblockPlusException;
import org.adblockplus.libadblockplus.HeaderEntry;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.HttpRequest;
import org.adblockplus.libadblockplus.ServerResponse;
import org.adblockplus.libadblockplus.android.Utils;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;

/* loaded from: classes2.dex */
public class HttpHeaderSiteKeyExtractor extends BaseSiteKeyExtractor {
    private final AtomicBoolean acceptThirdPartyCookies;

    public static class ResourceInfo {
        private static final String[] BINARY_MIMES = {"image", "application/octet-stream", MimeTypes.BASE_TYPE_VIDEO, "font", MimeTypes.BASE_TYPE_AUDIO};
        private static final String CHARSET = "charset=";
        private static final int CHARSET_LENGTH = 8;
        private String encoding;
        private boolean isBinary = false;
        private String mimeType;

        public static ResourceInfo parse(String str) {
            ResourceInfo resourceInfo = new ResourceInfo();
            if (str != null) {
                int iIndexOf = str.indexOf(";");
                int i10 = 0;
                if (iIndexOf > 0) {
                    resourceInfo.mimeType = str.substring(0, iIndexOf);
                    int iIndexOf2 = str.indexOf(CHARSET);
                    if (iIndexOf2 >= 0) {
                        int length = str.length();
                        int i11 = CHARSET_LENGTH;
                        if (iIndexOf2 < length - i11) {
                            resourceInfo.encoding = str.substring(iIndexOf2 + i11);
                        }
                    }
                } else if (str.indexOf("/") > 0) {
                    resourceInfo.mimeType = str;
                }
                if (resourceInfo.mimeType != null) {
                    String[] strArr = BINARY_MIMES;
                    int length2 = strArr.length;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        }
                        if (resourceInfo.mimeType.startsWith(strArr[i10])) {
                            resourceInfo.isBinary = true;
                            break;
                        }
                        i10++;
                    }
                }
            }
            return resourceInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void trim() {
            String str = this.mimeType;
            if (str != null) {
                this.mimeType = str.trim();
            }
            String str2 = this.encoding;
            if (str2 != null) {
                this.encoding = str2.trim();
            }
        }

        public String getEncoding() {
            return this.encoding;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public boolean isBinary() {
            return this.isBinary;
        }

        public void setEncoding(String str) {
            this.encoding = str;
        }

        public void setMimeType(String str) {
            this.mimeType = str;
        }
    }

    public static class ResponseHolder {
        ServerResponse response;

        private ResponseHolder() {
        }
    }

    public static class ServerResponseProcessor {
        private static final String BODY_CLOSE_TAG = "</body>";
        private static final String CSP_UNSAFE_INLINE = "'unsafe-inline'";
        private static final String CSP_SCRIPT_SRC_PARAM = "script-src";
        private static final String NONCE = "nonce-";
        private static final Pattern NONCE_PATTERN = Pattern.compile(String.format("%s[^;]*'(%s[^']+)'.*;", CSP_SCRIPT_SRC_PARAM, NONCE), 2);

        private boolean containsValidUnsafeInline(String str) {
            int iIndexOf;
            int iIndexOf2 = str.indexOf(CSP_SCRIPT_SRC_PARAM);
            if (iIndexOf2 < 0 || (iIndexOf = str.indexOf(CSP_UNSAFE_INLINE, iIndexOf2)) < 0) {
                return false;
            }
            String strSubstring = str.substring(iIndexOf2 + 10, iIndexOf);
            return (strSubstring.contains("-src ") || strSubstring.contains("-src-elem ") || strSubstring.contains("-src-attr ") || strSubstring.contains("navigate-to ") || strSubstring.contains("form-action ") || strSubstring.contains("base-uri ")) ? false : true;
        }

        public boolean injectJavascript(AdblockWebView adblockWebView, String str, ServerResponse serverResponse, Map<String, String> map) {
            String string;
            a.d("injectJavascript() reads content of `%s`", str);
            if (serverResponse.getInputStream() == null) {
                return true;
            }
            try {
                byte[] byteArray = Utils.toByteArray(serverResponse.getInputStream());
                String str2 = new String(byteArray);
                if (str2.toLowerCase().contains(BODY_CLOSE_TAG) && adblockWebView.generateStylesheetForUrl(Utils.getUrlWithoutFragment(str), false)) {
                    String strUpdateCspHeader = updateCspHeader(map);
                    if (strUpdateCspHeader == null) {
                        string = "<script>" + adblockWebView.getInjectJs() + "</script></body>";
                    } else {
                        StringBuilder sbV = c.v("<script nonce=\"", strUpdateCspHeader, "\">");
                        sbV.append(adblockWebView.getInjectJs());
                        sbV.append("</script></body>");
                        string = sbV.toString();
                    }
                    a.d("injectJavascript() adds injectJs for `%s`", str);
                    int iLastIndexOf = str2.lastIndexOf(BODY_CLOSE_TAG);
                    if (iLastIndexOf > 0) {
                        str2 = str2.substring(0, iLastIndexOf) + string + str2.substring(iLastIndexOf + 7);
                    }
                    try {
                        serverResponse.setInputStream(new ByteArrayInputStream(str2.getBytes("UTF-8")));
                    } catch (UnsupportedEncodingException e10) {
                        a.e(e10, "injectJavascript() failed", new Object[0]);
                        return false;
                    }
                } else {
                    a.d("injectJavascript() skips injectJs for `%s`", str);
                    serverResponse.setInputStream(new ByteArrayInputStream(byteArray));
                }
                return true;
            } catch (IOException e11) {
                a.e(e11, "injectJavascript() failed reading input stream to byte array", new Object[0]);
                return false;
            }
        }

        public WebResourceResponse process(AdblockWebView adblockWebView, String str, ServerResponse serverResponse, Map<String, String> map) {
            ResourceInfo resourceInfo = ResourceInfo.parse(map.get(HttpClient.HEADER_CONTENT_TYPE));
            Integer numValueOf = null;
            if (resourceInfo.getMimeType() != null) {
                a.d("Removing %s to avoid Content-Type duplication", HttpClient.HEADER_CONTENT_TYPE);
                map.remove(HttpClient.HEADER_CONTENT_TYPE);
                if (resourceInfo.getEncoding() != null && resourceInfo.isBinary()) {
                    a.d("Setting responseEncoding to null for contentType == %s", resourceInfo.getMimeType());
                    resourceInfo.setEncoding(null);
                }
            } else if (map.get(HttpClient.HEADER_CONTENT_LENGTH) != null) {
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt(map.get(HttpClient.HEADER_CONTENT_LENGTH).trim()));
                } catch (NullPointerException | NumberFormatException e10) {
                    a.e(e10, "Integer.parseInt(responseHeadersMap.get(HEADER_CONTENT_LENGTH)) failed", new Object[0]);
                }
                if (numValueOf == null) {
                    a.d("Setting responseMimeType to %s", "text/plain");
                    resourceInfo.setMimeType("text/plain");
                }
            }
            resourceInfo.trim();
            Object[] objArr = new Object[3];
            objArr[0] = resourceInfo.getMimeType() != null ? resourceInfo.getMimeType() : "null";
            objArr[1] = resourceInfo.getEncoding();
            objArr[2] = str;
            a.d("Using responseMimeType and responseEncoding: %s => %s (url == %s)", objArr);
            if (!adblockWebView.getJsInIframesEnabled() || (!(resourceInfo.getMimeType() == null || resourceInfo.getMimeType().toLowerCase().contains(HttpClient.MIME_TYPE_TEXT_HTML)) || injectJavascript(adblockWebView, str, serverResponse, map))) {
                return new WebResourceResponse(resourceInfo.getMimeType(), resourceInfo.getEncoding(), serverResponse.getResponseStatus(), HttpHeaderSiteKeyExtractor.getReasonPhrase(serverResponse.getStatus()), map, serverResponse.getInputStream());
            }
            a.w("Processing ServerResponse failed, request for `%s` will be repeated!", str);
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        }

        public String readFileToString(InputStream inputStream) {
            Scanner scannerUseDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
        }

        public String updateCspHeader(Map<String, String> map) {
            String str;
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if (next.getKey().toLowerCase().equals(HttpClient.HEADER_CSP) && !next.getValue().isEmpty()) {
                    a.d("Found `%s` CSP header", next.getValue());
                    if (next.getValue().toLowerCase().contains(CSP_SCRIPT_SRC_PARAM)) {
                        Matcher matcher = NONCE_PATTERN.matcher(next.getValue());
                        if (matcher.find() && matcher.groupCount() == 1) {
                            String strGroup = matcher.group(1);
                            a.d("Found nonce in CSP header with value `%s`", strGroup);
                            str = strGroup;
                        } else {
                            if (containsValidUnsafeInline(next.getValue().toLowerCase())) {
                                a.d("Found `%s` in CSP header, no need for update", CSP_UNSAFE_INLINE);
                                return null;
                            }
                            str = NONCE + UUID.randomUUID().toString();
                            String[] strArrSplit = next.getValue().split(CSP_SCRIPT_SRC_PARAM, 2);
                            String str2 = strArrSplit[0].trim() + " script-src '" + str + "' " + strArrSplit[1].trim();
                            map.put(next.getKey(), str2);
                            a.d("Added nonce to CSP header, new value `%s`", str2);
                        }
                    }
                }
            }
            return str != null ? str.substring(6) : str;
        }
    }

    public HttpHeaderSiteKeyExtractor(AdblockWebView adblockWebView) {
        super(adblockWebView);
        this.acceptThirdPartyCookies = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getReasonPhrase(ServerResponse.NsStatus nsStatus) {
        return nsStatus.name().replace("_", "");
    }

    private ServerResponse sendRequest(WebResourceRequest webResourceRequest) throws InterruptedException {
        String string = webResourceRequest.getUrl().toString();
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        final ResponseHolder responseHolder = new ResponseHolder();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        HttpClient.Callback callback = new HttpClient.Callback() { // from class: org.adblockplus.libadblockplus.android.webview.HttpHeaderSiteKeyExtractor.1
            @Override // org.adblockplus.libadblockplus.HttpClient.Callback
            public void onFinished(ServerResponse serverResponse) {
                responseHolder.response = serverResponse;
                countDownLatch.countDown();
            }
        };
        List<HeaderEntry> listConvertMapToHeadersList = Utils.convertMapToHeadersList(requestHeaders);
        AdblockWebView adblockWebView = this.webViewWeakReference.get();
        if (adblockWebView != null) {
            SharedCookieManager.injectPropertyHeaders(this.acceptThirdPartyCookies.get(), adblockWebView.getNavigationUrl(), listConvertMapToHeadersList);
        }
        getSiteKeysConfiguration().getHttpClient().request(new HttpRequest(string, webResourceRequest.getMethod(), listConvertMapToHeadersList, true, true), callback);
        countDownLatch.await();
        return responseHolder.response;
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public WebResourceResponse extract(WebResourceRequest webResourceRequest) {
        if (!isEnabled()) {
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        }
        if (getSiteKeysConfiguration() == null || !webResourceRequest.getMethod().equalsIgnoreCase("GET")) {
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        }
        a.d("extract() called from Thread %s", Long.valueOf(Thread.currentThread().getId()));
        try {
            ServerResponse serverResponseSendRequest = sendRequest(webResourceRequest);
            if (!HttpClient.isValidCode(serverResponseSendRequest.getResponseStatus()) || HttpClient.isRedirectCode(serverResponseSendRequest.getResponseStatus())) {
                return AdblockWebView.WebResponseResult.ALLOW_LOAD;
            }
            String string = webResourceRequest.getUrl().toString();
            if (serverResponseSendRequest.getFinalUrl() != null) {
                a.d("Updating url to %s, was (%s)", serverResponseSendRequest.getFinalUrl(), string);
                string = serverResponseSendRequest.getFinalUrl();
            }
            if (serverResponseSendRequest.getInputStream() == null) {
                a.w("extract() passes control to WebView", new Object[0]);
                return AdblockWebView.WebResponseResult.ALLOW_LOAD;
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            Map<String, String> mapConvertHeaderEntriesToMap = Utils.convertHeaderEntriesToMap(serverResponseSendRequest.getResponseHeaders());
            getSiteKeysConfiguration().getSiteKeyVerifier().verifyInHeaders(string, requestHeaders, mapConvertHeaderEntriesToMap);
            AdblockWebView adblockWebView = this.webViewWeakReference.get();
            if (adblockWebView != null) {
                return new ServerResponseProcessor().process(adblockWebView, string, serverResponseSendRequest, mapConvertHeaderEntriesToMap);
            }
            a.w("extract() couldn't get a handle to AdblockWebView, returning ALLOW_LOAD", new Object[0]);
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        } catch (InterruptedException unused) {
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        } catch (AdblockPlusException e10) {
            a.e(e10, "WebRequest failed", new Object[0]);
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        }
    }

    @Override // org.adblockplus.libadblockplus.android.webview.BaseSiteKeyExtractor, org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        SharedCookieManager.unloadCookieManager();
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void startNewPage() {
        if (isEnabled()) {
            AdblockWebView adblockWebView = this.webViewWeakReference.get();
            if (adblockWebView != null) {
                this.acceptThirdPartyCookies.set(CookieManager.getInstance().acceptThirdPartyCookies(adblockWebView));
            }
            SharedCookieManager.enforceCookieManager();
        }
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public boolean waitForSitekeyCheck(String str, boolean z10) {
        return false;
    }
}
