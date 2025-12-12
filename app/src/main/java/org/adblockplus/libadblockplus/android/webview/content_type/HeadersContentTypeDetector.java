package org.adblockplus.libadblockplus.android.webview.content_type;

import android.webkit.WebResourceRequest;
import bi.a;
import java.util.Map;
import org.adblockplus.libadblockplus.FilterEngine;
import org.adblockplus.libadblockplus.HttpClient;

/* loaded from: classes2.dex */
public class HeadersContentTypeDetector implements ContentTypeDetector {
    @Override // org.adblockplus.libadblockplus.android.webview.content_type.ContentTypeDetector
    public FilterEngine.ContentType detect(WebResourceRequest webResourceRequest) {
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey(HttpClient.HEADER_REQUESTED_WITH) && HttpClient.HEADER_REQUESTED_WITH_XMLHTTPREQUEST.equals(requestHeaders.get(HttpClient.HEADER_REQUESTED_WITH))) {
            a.w("using xmlhttprequest content type", new Object[0]);
            return FilterEngine.ContentType.XMLHTTPREQUEST;
        }
        String str = requestHeaders.get("Accept");
        if (str == null || !str.contains(HttpClient.MIME_TYPE_TEXT_HTML)) {
            return null;
        }
        a.w("using subdocument content type", new Object[0]);
        return FilterEngine.ContentType.SUBDOCUMENT;
    }
}
